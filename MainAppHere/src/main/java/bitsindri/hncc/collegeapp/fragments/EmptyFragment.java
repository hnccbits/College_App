package bitsindri.hncc.collegeapp.fragments;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import bitsindri.hncc.collegeapp.Adapters.EmptyAdapter;
import bitsindri.hncc.collegeapp.Adapters.StoryAdapter;
import bitsindri.hncc.collegeapp.Adapters.TelephoneAdapter;
import bitsindri.hncc.collegeapp.Adapters.homeFeedAdapter;
import bitsindri.hncc.collegeapp.Custom_Classes.EmptyClass;
import bitsindri.hncc.collegeapp.Custom_Classes.PhoneNumber;
import bitsindri.hncc.collegeapp.Custom_Classes.UserList;
import bitsindri.hncc.collegeapp.GetterAndSetter.feed;
import bitsindri.hncc.collegeapp.R;
import xute.storyview.StoryModel;


public class EmptyFragment extends Fragment implements EmptyAdapter.calluser {


    RecyclerView recyclerView;
    ArrayList<EmptyClass> data;
    EmptyAdapter emptyAdapter;





    public EmptyFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.empty_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        data = new ArrayList<>();
        setdata();
        setRecycler();
    }



    private void setdata() {
        data.clear();
        data.add(new EmptyClass("Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries."));
        data.add(new EmptyClass("Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries."));
        data.add(new EmptyClass("Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries."));
        data.add(new EmptyClass("Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries."));
        data.add(new EmptyClass("Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries."));
        data.add(new EmptyClass("Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries."));
        data.add(new EmptyClass("Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries."));

    }

    private void setRecycler() {

        recyclerView=(RecyclerView)getActivity().findViewById(R.id.emptyRecyclerView);
        emptyAdapter=new EmptyAdapter(data,this);
        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(emptyAdapter);
    }

    @Override
    public void dialNumber(int position) {
        Toast.makeText(getContext(),"position:"+position,Toast.LENGTH_SHORT).show();


    }
}