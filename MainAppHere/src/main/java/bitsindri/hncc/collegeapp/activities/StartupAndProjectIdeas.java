package bitsindri.hncc.collegeapp.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;

import bitsindri.hncc.collegeapp.Adapters.EmptyAdapter;
import bitsindri.hncc.collegeapp.Custom_Classes.EmptyClass;
import bitsindri.hncc.collegeapp.R;

public class StartupAndProjectIdeas extends AppCompatActivity implements EmptyAdapter.calluser {

    RecyclerView startupProjectRecyclerView;
    ArrayList<EmptyClass> startupProjectRecyclerList;
    EmptyAdapter startupProjectAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_startup_and_project_ideas);

        startupProjectRecyclerList = new ArrayList<>();
        setdata();
        setRecycler();
    }

    private void setdata() {
        startupProjectRecyclerList.clear();
        startupProjectRecyclerList.add(new EmptyClass("Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries."));
        startupProjectRecyclerList.add(new EmptyClass("Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries."));
        startupProjectRecyclerList.add(new EmptyClass("Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries."));
        startupProjectRecyclerList.add(new EmptyClass("Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries."));
        startupProjectRecyclerList.add(new EmptyClass("Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries."));
        startupProjectRecyclerList.add(new EmptyClass("Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries."));
        startupProjectRecyclerList.add(new EmptyClass("Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries."));

    }

    private void setRecycler() {

        startupProjectRecyclerView=findViewById(R.id.startupProjectRecyclerView);
        startupProjectAdapter=new EmptyAdapter(startupProjectRecyclerList, this);
        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(StartupAndProjectIdeas.this);
        startupProjectRecyclerView.setLayoutManager(layoutManager);
        startupProjectRecyclerView.setAdapter(startupProjectAdapter);
    }


    @Override
    public void dialNumber(int position) {

    }
}