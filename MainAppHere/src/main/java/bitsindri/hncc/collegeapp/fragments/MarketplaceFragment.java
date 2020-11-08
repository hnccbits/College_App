package bitsindri.hncc.collegeapp.fragments;

import android.content.res.Configuration;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import bitsindri.hncc.collegeapp.Adapters.marketplaceAdapter;
import bitsindri.hncc.collegeapp.GetterAndSetter.marketplace;
import bitsindri.hncc.collegeapp.R;

public class MarketplaceFragment extends Fragment {

    ArrayList<marketplace> marketplaceArrayList;
    private RecyclerView marketplaceRecyclerView;
    marketplaceAdapter marketplaceRecyclerAdapter;

    public MarketplaceFragment() {
        //Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View marketplaceFragmentView = inflater.inflate(R.layout.fragment_marketplace, container, false);

        marketplaceArrayList = new ArrayList<>();

        marketplaceArrayList.add(new marketplace("Book", 300));
        marketplaceArrayList.add(new marketplace("Bicycle", 3000));
        marketplaceArrayList.add(new marketplace("Laptop", 45000));
        marketplaceArrayList.add(new marketplace("Plywood", 800));
        marketplaceArrayList.add(new marketplace("Electric Iron", 200));
        marketplaceArrayList.add(new marketplace("Bag", 900));
        marketplaceArrayList.add(new marketplace("Phone", 8000));
        marketplaceArrayList.add(new marketplace("Book", 550));
        marketplaceArrayList.add(new marketplace("Bike", 50000));
        marketplaceArrayList.add(new marketplace("Headphone", 800));

        marketplaceRecyclerView = marketplaceFragmentView.findViewById(R.id.marketplaceRecyclerView);

        int orientation = getResources().getConfiguration().orientation;
        if(orientation == Configuration.ORIENTATION_LANDSCAPE) {
            marketplaceRecyclerView.setLayoutManager(new GridLayoutManager(getContext(),4));
        }else if (orientation == Configuration.ORIENTATION_PORTRAIT){
            marketplaceRecyclerView.setLayoutManager(new GridLayoutManager(getContext(),2));
        }
        //marketplaceRecyclerView.setLayoutManager(new GridLayoutManager(getContext(),2));

        marketplaceRecyclerAdapter = new marketplaceAdapter(getContext(), marketplaceArrayList);
        marketplaceRecyclerView.setAdapter(marketplaceRecyclerAdapter);


        return marketplaceFragmentView;
    }

    @Override
    public void onConfigurationChanged(@NonNull Configuration newConfig) {
        super.onConfigurationChanged(newConfig);

        if(newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            marketplaceRecyclerView.setLayoutManager(new GridLayoutManager(getContext(),4));
        }else if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT){
            marketplaceRecyclerView.setLayoutManager(new GridLayoutManager(getContext(),2));
        }

    }

}