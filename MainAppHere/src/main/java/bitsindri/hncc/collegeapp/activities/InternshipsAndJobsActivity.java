package bitsindri.hncc.collegeapp.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import bitsindri.hncc.collegeapp.Adapters.InternshipsAndJobsAdapter;
import bitsindri.hncc.collegeapp.Adapters.NewMarketAdapter;
import bitsindri.hncc.collegeapp.GetterAndSetter.internshipsAndJobs;
import bitsindri.hncc.collegeapp.Interfaces.FastAPI;
import bitsindri.hncc.collegeapp.R;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class InternshipsAndJobsActivity extends AppCompatActivity {

    ArrayList<internshipsAndJobs> internshipsAndJobsArrayList;
    RecyclerView internshipsAndJobsRecyclerView;
    InternshipsAndJobsAdapter InternshipsAndJobsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_internships_and_jobs);

        internshipsAndJobsArrayList = new ArrayList<>();
        internshipsAndJobsArrayList.clear();

        internshipsAndJobsRecyclerView = findViewById(R.id.internship_an_jobs_recycler_view);
        internshipsAndJobsRecyclerView.setLayoutManager(new LinearLayoutManager(InternshipsAndJobsActivity.this));

        InternshipsAndJobsAdapter = new InternshipsAndJobsAdapter( InternshipsAndJobsActivity.this, internshipsAndJobsArrayList);
        internshipsAndJobsRecyclerView.setAdapter(InternshipsAndJobsAdapter);



        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://3.7.248.151:8000/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        // as fastApi is an interface
        FastAPI fastApi = retrofit.create(FastAPI.class);

        Call<List<internshipsAndJobs>> call = fastApi.getInternships();

        // retrofit help us to fetch data on different thread, using enqueue
        call.enqueue(new Callback<List<internshipsAndJobs>>() {
            @Override
            public void onResponse(Call<List<internshipsAndJobs>> call, Response<List<internshipsAndJobs>> response) {

                if(!response.isSuccessful()){
                    //responseTextView.setText("Code: " + response.code());
                    Toast.makeText(InternshipsAndJobsActivity.this,"Code: " + response.code(), Toast.LENGTH_SHORT).show();
                    return;
                }

                List<internshipsAndJobs> responseList = response.body();

                for(internshipsAndJobs eachResponse : responseList){
                    internshipsAndJobsArrayList.add(new internshipsAndJobs(eachResponse.getId(), eachResponse.getTitle(), eachResponse.getUrl()));
                }

                InternshipsAndJobsAdapter.notifyDataSetChanged();

            }

            @Override
            public void onFailure(Call<List<internshipsAndJobs>> call, Throwable t) {
                //responseTextView.setText(t.getMessage());
                Log.i("onFailure","" + t.getMessage());
            }
        });





    }
}