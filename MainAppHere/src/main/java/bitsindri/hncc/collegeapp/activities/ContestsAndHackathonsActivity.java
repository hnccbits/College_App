package bitsindri.hncc.collegeapp.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

import bitsindri.hncc.collegeapp.Adapters.InternshipsAndJobsAdapter;
import bitsindri.hncc.collegeapp.GetterAndSetter.internshipsAndJobs;
import bitsindri.hncc.collegeapp.R;

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
        contestsAndHackathonsArrayList.add(new internshipsAndJobs("Codeforces","Codeforces Round #685 (Div. 2) will take place on the 21st of November at 14:35 UTC. \n"
                +"Please, join by the link https://codeforces.com/contests/1451"));
        contestsAndHackathonsArrayList.add(new internshipsAndJobs("Appathon","Create an Android Application in one day and share it to us. \n"
                +"https://dare2compete.com/o/appathon-nullclass-136949"));
        contestsAndHackathonsArrayList.add(new internshipsAndJobs("Codechef","Codechef November Cook-Off 2020 \n"
                +"https://www.codechef.com/COOK124/?utm_source=hpbanner&utm_medium=website&utm_campaign=COOK124"));
        contestsAndHackathonsArrayList.add(new internshipsAndJobs("LETS HACK","Build your ideas to unveil a plethora of opportunities and compete against some of the best minds. Choose your track to find the right place and be the better you. \n"
                +"https://dare2compete.com/o/lets-hack-zubiio-136619"));
        contestsAndHackathonsArrayList.add(new internshipsAndJobs("Codeforces","Educational Codeforces Round 98 (rated for Div. 2) starts on the 19th of November at 14:35 UTC \n"
                +"https://codeforces.com/contests/1452"));

        contestsAndHackathonsRecyclerView = findViewById(R.id.contests_and_hackathons_recycler_view);
        contestsAndHackathonsRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        contestsAndHackathonsAdapter = new InternshipsAndJobsAdapter( this,contestsAndHackathonsArrayList);
        contestsAndHackathonsRecyclerView.setAdapter(contestsAndHackathonsAdapter);

    }
}