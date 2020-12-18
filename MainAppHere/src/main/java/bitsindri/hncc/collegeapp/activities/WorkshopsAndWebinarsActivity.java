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

public class WorkshopsAndWebinarsActivity extends AppCompatActivity {

    ArrayList<internshipsAndJobs> workshopsAndWebinarsArrayList;
    RecyclerView workshopsAndWebinarsRecyclerView;
    InternshipsAndJobsAdapter workshopsAndWebinarsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workshops_and_webinars);


        workshopsAndWebinarsArrayList = new ArrayList<>();
        workshopsAndWebinarsArrayList.clear();

        workshopsAndWebinarsRecyclerView = findViewById(R.id.workshops_and_webinars_recycler_view);
        workshopsAndWebinarsRecyclerView.setLayoutManager(new LinearLayoutManager(WorkshopsAndWebinarsActivity.this));

        workshopsAndWebinarsAdapter = new InternshipsAndJobsAdapter( WorkshopsAndWebinarsActivity.this, workshopsAndWebinarsArrayList);
        workshopsAndWebinarsRecyclerView.setAdapter(workshopsAndWebinarsAdapter);


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://3.7.248.151:8000/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        // as fastApi is an interface
        FastAPI fastApi = retrofit.create(FastAPI.class);

        Call<List<internshipsAndJobs>> call = fastApi.getWorkshops();

        // retrofit help us to fetch data on different thread, using enqueue
        call.enqueue(new Callback<List<internshipsAndJobs>>() {
            @Override
            public void onResponse(Call<List<internshipsAndJobs>> call, Response<List<internshipsAndJobs>> response) {

                if(!response.isSuccessful()){
                    //responseTextView.setText("Code: " + response.code());
                    Toast.makeText(WorkshopsAndWebinarsActivity.this,"Code: " + response.code(), Toast.LENGTH_SHORT).show();
                    return;
                }

                List<internshipsAndJobs> responseList = response.body();

                for(internshipsAndJobs eachResponse : responseList){
                    workshopsAndWebinarsArrayList.add(new internshipsAndJobs(eachResponse.getId(), eachResponse.getTitle(), eachResponse.getUrl()));
                }

                workshopsAndWebinarsAdapter.notifyDataSetChanged();

            }

            @Override
            public void onFailure(Call<List<internshipsAndJobs>> call, Throwable t) {
                //responseTextView.setText(t.getMessage());
                Log.i("onFailure","" + t.getMessage());
            }
        });

//        workshopsAndWebinarsArrayList.add(new internshipsAndJobs("(Workshop) Machine Learning With Image Classification Project","Topic : Machine Learning & Project Creation from scratch\n" +
//                "Level : Beginner To Advance\n" +
//                "Fees : $0\n" +
//                "Certificate By : Microsoft Learn Student Ambassador\n" +
//                "Date & Time : 20th November (Tomorrow) | 5:00 PM" +
//                "\n\nLINK"));
//        workshopsAndWebinarsArrayList.add(new internshipsAndJobs("6 Days Live Web Development Boot-camp with Certification","Topic : Web Development Bootcamp\n" +
//                " Type : Online Live Classes\n" +
//                "Price : FREE\n" +
//                "Batch size :  50 students\n" +
//                "Date : 17th Nov - 22nd Nov (Starting from tomorrow) " +
//                "\n\nLINK"));
//        workshopsAndWebinarsArrayList.add(new internshipsAndJobs("Build A Mini Project Using Machine Learning","Topic: Mini Project Using Machine Learning From Scratch\n" +
//                "Project Name: Cereal Rating Recommendation System\n"  +
//                "Fees: $0\n" +
//                "Date & Time: 10th Nov | 6:30 PM to 7:30 PM IST\n" +
//                "Level : Beginner" +
//                "\n\nLINK"));



    }

}