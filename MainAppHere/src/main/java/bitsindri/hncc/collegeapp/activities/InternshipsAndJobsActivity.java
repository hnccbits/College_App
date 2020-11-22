package bitsindri.hncc.collegeapp.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

import bitsindri.hncc.collegeapp.Adapters.InternshipsAndJobsAdapter;
import bitsindri.hncc.collegeapp.Adapters.NewMarketAdapter;
import bitsindri.hncc.collegeapp.GetterAndSetter.internshipsAndJobs;
import bitsindri.hncc.collegeapp.R;

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
        internshipsAndJobsArrayList.add(new internshipsAndJobs("ACG is Hiring Data Science PG Intern","Query on Databases for data extraction, Handle Bigdata sets and develop interactive and insightful dashboards using data visualization software\n\nLINK"));
        internshipsAndJobsArrayList.add(new internshipsAndJobs("Amazon is Hiring Software Development Engineer Intern","As an intern, you will be matched to a manager and a mentor. You will have the opportunity to influence the evolution of Amazon technology and lead mission critical projects early in your career.\n\nLINK"));
        internshipsAndJobsArrayList.add(new internshipsAndJobs("Postman is Hiring Technical Support Intern","We are looking for a Technical Support Intern to join our team supporting our 11+ million strong user base. Responsibilities also include adding content to our public facing knowledge base to keep it up to date with our increasing feature set. A background in software development is desired.\n\nLINK"));
        internshipsAndJobsArrayList.add(new internshipsAndJobs("GE Is Hiring Software Engineer","Bachelor’s Degree in Computer Science or STEM” Majors (Science, Technology, Engineering and Math) with basic experience.\n\nLINK"));
        internshipsAndJobsArrayList.add(new internshipsAndJobs("Annotation Analyst Job at Apple","As part of the Annotation Team you’ll play a central role in enhancing the user experience. We work in a fast paced, dynamic, technology focused environment.\n\nLINK"));

        internshipsAndJobsRecyclerView = findViewById(R.id.internship_an_jobs_recycler_view);
        internshipsAndJobsRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        InternshipsAndJobsAdapter = new InternshipsAndJobsAdapter( this,internshipsAndJobsArrayList);
        internshipsAndJobsRecyclerView.setAdapter(InternshipsAndJobsAdapter);
    }
}