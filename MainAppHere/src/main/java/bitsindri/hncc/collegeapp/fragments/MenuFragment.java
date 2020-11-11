package bitsindri.hncc.collegeapp.fragments;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.util.ArrayList;

import bitsindri.hncc.collegeapp.Adapters.MenuAdapter;
import bitsindri.hncc.collegeapp.Adapters.NewMarketAdapter;
import bitsindri.hncc.collegeapp.Adapters.marketplaceAdapter;
import bitsindri.hncc.collegeapp.Custom_Classes.menuClass;
import bitsindri.hncc.collegeapp.GetterAndSetter.marketplace;
import bitsindri.hncc.collegeapp.R;
import bitsindri.hncc.collegeapp.activities.MainActivity;
import bitsindri.hncc.collegeapp.activities.sellingItemActivity;

public class MenuFragment extends Fragment implements MenuAdapter.calluser {

    ArrayList<menuClass> menuList;
    private RecyclerView recyclerView;
    MenuAdapter menuAdapter;

    private  int index=0;


    public MenuFragment() {
        //Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_menu, container, false);

    }




    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        menuList = new ArrayList<>();
        setData();
        setRecycler();


    }

    private void setData() {
        menuList.clear();
        menuList.add(new menuClass("News & Events", R.drawable.img_icon));
        menuList.add(new menuClass("Lost & Found", R.drawable.img_icon));
        menuList.add(new menuClass("Marketplace", R.drawable.img_icon));
        menuList.add(new menuClass("Tools & Utility", R.drawable.img_icon));
        menuList.add(new menuClass("Study Materials", R.drawable.img_icon));
        menuList.add(new menuClass("Navigation", R.drawable.img_icon));
        menuList.add(new menuClass("order @Canteen", R.drawable.img_icon));
        menuList.add(new menuClass("Settings", R.drawable.settings));

    }

    private void setRecycler() {
        recyclerView = getActivity().findViewById(R.id.menuRecyclerview);

        int orientation = getResources().getConfiguration().orientation;
        if(orientation == Configuration.ORIENTATION_LANDSCAPE) {
            recyclerView.setLayoutManager(new GridLayoutManager(getContext(),4));
        }else if (orientation == Configuration.ORIENTATION_PORTRAIT){
            recyclerView.setLayoutManager(new GridLayoutManager(getContext(),2));
        }
        //marketplaceRecyclerView.setLayoutManager(new GridLayoutManager(getContext(),2));

        menuAdapter = new MenuAdapter( menuList,this);
        recyclerView.setAdapter(menuAdapter);
    }


    @Override
    public void onConfigurationChanged(@NonNull Configuration newConfig) {
        super.onConfigurationChanged(newConfig);

        if(newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            recyclerView.setLayoutManager(new GridLayoutManager(getContext(),4));
        }else if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT){
            recyclerView.setLayoutManager(new GridLayoutManager(getContext(),2));
        }

    }

    @Override
    public void productDetails(int position) {
        index=position;
        Toast.makeText(getContext(),"position: "+position,Toast.LENGTH_SHORT).show();

        switch (position)
        {
            case 1:
                //TODO: implement differnt menu
                break;
        }

    }
}