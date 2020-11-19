package bitsindri.hncc.collegeapp.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

import bitsindri.hncc.collegeapp.Adapters.InternshipsAndJobsAdapter;
import bitsindri.hncc.collegeapp.GetterAndSetter.internshipsAndJobs;
import bitsindri.hncc.collegeapp.R;

public class WorkshopsAndWebinarsActivity extends AppCompatActivity {

    ArrayList<internshipsAndJobs> workshopsAndWebinarsArrayList;
    private RecyclerView workshopsAndWebinarsRecyclerView;
    InternshipsAndJobsAdapter workshopsAndWebinarsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workshops_and_webinars);


        workshopsAndWebinarsArrayList = new ArrayList<>();
        workshopsAndWebinarsArrayList.clear();
        workshopsAndWebinarsArrayList.add(new internshipsAndJobs("(Workshop) Machine Learning With Image Classification Project","Topic : Machine Learning & Project Creation from scratch\n" +
                "Level : Beginner To Advance\n" +
                "Fees : $0\n" +
                "Certificate By : Microsoft Learn Student Ambassador\n" +
                "Date & Time : 20th November (Tomorrow) | 5:00 PM" +
                "\n\nLINK"));
        workshopsAndWebinarsArrayList.add(new internshipsAndJobs("6 Days Live Web Development Boot-camp with Certification","Topic : Web Development Bootcamp\n" +
                " Type : Online Live Classes\n" +
                "Price : FREE\n" +
                "Batch size :  50 students\n" +
                "Date : 17th Nov - 22nd Nov (Starting from tomorrow) " +
                "\n\nLINK"));
        workshopsAndWebinarsArrayList.add(new internshipsAndJobs("Build A Mini Project Using Machine Learning","Topic: Mini Project Using Machine Learning From Scratch\n" +
                "Project Name: Cereal Rating Recommendation System\n"  +
                "Fees: $0\n" +
                "Date & Time: 10th Nov | 6:30 PM to 7:30 PM IST\n" +
                "Level : Beginner" +
                "\n\nLINK"));


        workshopsAndWebinarsRecyclerView = findViewById(R.id.workshops_and_webinars_recycler_view);
        workshopsAndWebinarsRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        workshopsAndWebinarsAdapter = new InternshipsAndJobsAdapter( this,workshopsAndWebinarsArrayList);
        workshopsAndWebinarsRecyclerView.setAdapter(workshopsAndWebinarsAdapter);

    }

}