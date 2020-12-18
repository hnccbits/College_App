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
import bitsindri.hncc.collegeapp.GetterAndSetter.internshipsAndJobs;
import bitsindri.hncc.collegeapp.Interfaces.FastAPI;
import bitsindri.hncc.collegeapp.R;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ContestsAndHackathonsActivity extends AppCompatActivity {

    ArrayList<internshipsAndJobs> contestsAndHackathonsArrayList;
    RecyclerView contestsAndHackathonsRecyclerView;
    InternshipsAndJobsAdapter contestsAndHackathonsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contests_and_hackathons);

        contestsAndHackathonsArrayList = new ArrayList<>();
        contestsAndHackathonsArrayList.clear();

        contestsAndHackathonsRecyclerView = findViewById(R.id.contests_and_hackathons_recycler_view);
        contestsAndHackathonsRecyclerView.setLayoutManager(new LinearLayoutManager(ContestsAndHackathonsActivity.this));

        contestsAndHackathonsAdapter = new InternshipsAndJobsAdapter( ContestsAndHackathonsActivity.this,contestsAndHackathonsArrayList);
        contestsAndHackathonsRecyclerView.setAdapter(contestsAndHackathonsAdapter);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://3.7.248.151:8000/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        // as fastApi is an interface
        FastAPI fastApi = retrofit.create(FastAPI.class);

        Call<List<internshipsAndJobs>> call = fastApi.getHackathons();

        // retrofit help us to fetch data on different thread, using enqueue
        call.enqueue(new Callback<List<internshipsAndJobs>>() {
            @Override
            public void onResponse(Call<List<internshipsAndJobs>> call, Response<List<internshipsAndJobs>> response) {

                if(!response.isSuccessful()){
                    //responseTextView.setText("Code: " + response.code());
                    Toast.makeText(ContestsAndHackathonsActivity.this,"Code: " + response.code(), Toast.LENGTH_SHORT).show();
                    return;
                }

                List<internshipsAndJobs> responseList = response.body();

                for(internshipsAndJobs eachResponse : responseList){
                    contestsAndHackathonsArrayList.add(new internshipsAndJobs(eachResponse.getId(), eachResponse.getTitle(), eachResponse.getUrl()));
                }

                contestsAndHackathonsAdapter.notifyDataSetChanged();

            }

            @Override
            public void onFailure(Call<List<internshipsAndJobs>> call, Throwable t) {
                //responseTextView.setText(t.getMessage());
                Log.i("onFailure","" + t.getMessage());
            }
        });


    }
}