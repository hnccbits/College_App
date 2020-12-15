package bitsindri.hncc.collegeapp.fragments;

import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import bitsindri.hncc.collegeapp.Adapters.DynamicRVAdapter;
import bitsindri.hncc.collegeapp.Adapters.DynamicRVInterface.LoadMore;
import bitsindri.hncc.collegeapp.Adapters.StaticRVAdapter;
import bitsindri.hncc.collegeapp.R;
import bitsindri.hncc.collegeapp.models.DynamicRVModel;
import bitsindri.hncc.collegeapp.models.StaticRCViewModel;

public class DashboardFragment extends Fragment {

    private RecyclerView recyclerView;
    private StaticRVAdapter staticRVAdapter;

    List<DynamicRVModel> items = new ArrayList<>();
    DynamicRVAdapter dynamicRVAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_dashboard, container, false);


        ArrayList<StaticRCViewModel> item = new ArrayList<>();

        //adding items inside arrayList with the help of StaticRecyclerViewModel
        item.add(new StaticRCViewModel(R.drawable.img2,"Alumni"));
        item.add(new StaticRCViewModel(R.drawable.img3,"Teachers"));
        item.add(new StaticRCViewModel(R.drawable.img1,"Non-Teachers"));
        item.add(new StaticRCViewModel(R.drawable.img2,"Student"));
        item.add(new StaticRCViewModel(R.drawable.img3,"Security"));
        item.add(new StaticRCViewModel(R.drawable.img1,"Mess Service"));
        item.add(new StaticRCViewModel(R.drawable.img2,"First Aid"));


        recyclerView = view.findViewById(R.id.rv_1);
        staticRVAdapter = new StaticRVAdapter((item));
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL,false));
        recyclerView.setAdapter(staticRVAdapter);

        items.add(new DynamicRVModel("Newsfeed",R.drawable.ic_baseline_emoji_food_beverage_24));
        items.add(new DynamicRVModel("Market Place",R.drawable.ic_baseline_school_24));
        items.add(new DynamicRVModel("Admin Block",R.drawable.ic_baseline_emoji_food_beverage_24));
        items.add(new DynamicRVModel("Q&A",R.drawable.ic_baseline_school_24));
        items.add(new DynamicRVModel("Notifications",R.drawable.ic_baseline_emoji_food_beverage_24));
        items.add(new DynamicRVModel("Google Map",R.drawable.ic_baseline_school_24));
        items.add(new DynamicRVModel("All In One",R.drawable.ic_baseline_emoji_food_beverage_24));
        items.add(new DynamicRVModel("GH",R.drawable.ic_baseline_school_24));
        items.add(new DynamicRVModel("OP",R.drawable.ic_baseline_emoji_food_beverage_24));
        items.add(new DynamicRVModel("MG",R.drawable.ic_baseline_school_24));
        items.add(new DynamicRVModel("Lecture Hall",R.drawable.ic_baseline_emoji_food_beverage_24));
        items.add(new DynamicRVModel("Google Map",R.drawable.ic_baseline_school_24));
        items.add(new DynamicRVModel("All In One",R.drawable.ic_baseline_emoji_food_beverage_24));
        items.add(new DynamicRVModel("GH",R.drawable.ic_baseline_school_24));
        items.add(new DynamicRVModel("OP",R.drawable.ic_baseline_emoji_food_beverage_24));
        items.add(new DynamicRVModel("MG",R.drawable.ic_baseline_school_24));

        RecyclerView drv = view.findViewById(R.id.rv_2);
        drv.setLayoutManager(new LinearLayoutManager(getActivity()));
        dynamicRVAdapter = new DynamicRVAdapter(drv,getActivity(),items);
        drv.setAdapter(dynamicRVAdapter);

        dynamicRVAdapter.setLoadMore(() -> {
            if(items.size()<=10){
                items.add(null);
                dynamicRVAdapter.notifyItemInserted(items.size()-1);
                new Handler().postDelayed(() -> {
                    items.remove(items.size()-1);
                    dynamicRVAdapter.notifyItemRemoved(items.size());

                    int index = items.size();
                    int end = index+10;
                    for(int i=index;i<end;i++){
                        String name = UUID.randomUUID().toString();
                        DynamicRVModel item1 = new DynamicRVModel(name,R.drawable.img2);
                        items.add(item1);
                    }
                    dynamicRVAdapter.notifyDataSetChanged();
                    dynamicRVAdapter.setLoaded();
                },4000);
            }
            else{
                Toast.makeText(requireActivity(),"Data Completed",Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }
}