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

import bitsindri.hncc.collegeapp.Adapters.NewMarketAdapter;
import bitsindri.hncc.collegeapp.Adapters.marketplaceAdapter;
import bitsindri.hncc.collegeapp.GetterAndSetter.marketplace;
import bitsindri.hncc.collegeapp.R;
import bitsindri.hncc.collegeapp.activities.MainActivity;
import bitsindri.hncc.collegeapp.activities.sellingItemActivity;

public class MarketplaceFragment extends Fragment implements NewMarketAdapter.calluser {

    ArrayList<marketplace> marketplaceArrayList;
    private RecyclerView marketplaceRecyclerView;
    NewMarketAdapter marketplaceRecyclerAdapter;

    private  int index=0;
    //Declaration of Bottom Sheet Variable
    BottomSheetBehavior bottomSheetBehavior;
    BottomSheetDialog bottomSheetDialog;
    View bottom_sheet,view;
    ImageView imgClose;
    TextView txtUserName,uploadDate,description;
    Button btnPingMe;

    public MarketplaceFragment() {
        //Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_marketplace, container, false);

    }




    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        marketplaceArrayList = new ArrayList<>();
        setData();
        setRecycler();
        showBottomSheetDialog();

    }

    private void setData() {
        marketplaceArrayList.clear();
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
    }

    private void setRecycler() {
        marketplaceRecyclerView = getActivity().findViewById(R.id.marketplaceRecyclerView);

        int orientation = getResources().getConfiguration().orientation;
        if(orientation == Configuration.ORIENTATION_LANDSCAPE) {
            marketplaceRecyclerView.setLayoutManager(new GridLayoutManager(getContext(),4));
        }else if (orientation == Configuration.ORIENTATION_PORTRAIT){
            marketplaceRecyclerView.setLayoutManager(new GridLayoutManager(getContext(),2));
        }
        //marketplaceRecyclerView.setLayoutManager(new GridLayoutManager(getContext(),2));

        marketplaceRecyclerAdapter = new NewMarketAdapter( marketplaceArrayList,this);
        marketplaceRecyclerView.setAdapter(marketplaceRecyclerAdapter);
    }
    private void showBottomSheetDialog() {
        bottom_sheet = getActivity().findViewById(R.id.bottom_sheet);
        bottomSheetBehavior = BottomSheetBehavior.from(bottom_sheet);
        view = getLayoutInflater().inflate(R.layout.bottom_sheet,null);
        bottomSheetDialog = new BottomSheetDialog(getContext());

        bottomSheetDialog.setContentView(view);
//        ((View) view.getParent()).setBackgroundColor(getResources().getColor(android.R.color.transparent)); //it is depricated after API 21
        ((View) view.getParent()).setBackgroundColor(ContextCompat.getColor(getContext(), android.R.color.transparent));
        txtUserName = view.findViewById(R.id.txt_name);
        uploadDate=view.findViewById(R.id.txt_date);
        description=view.findViewById(R.id.txt_descript);
        imgClose = view.findViewById(R.id.img_close);
        btnPingMe = view.findViewById(R.id.btn_click);

        imgClose.setOnClickListener(v -> bottomSheetDialog.dismiss());

        btnPingMe.setOnClickListener(v -> {

            Intent i = new Intent(getActivity(), sellingItemActivity.class);
            i.putExtra("category", marketplaceArrayList.get(index).getItemCategory());
            i.putExtra("price", String.valueOf(marketplaceArrayList.get(index).getItemPrice()));
            startActivity(i);
            bottomSheetDialog.dismiss();
        });

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

    @Override
    public void productDetails(int position) {
        index=position;
        //Toast.makeText(getContext(),"position: "+position,Toast.LENGTH_SHORT).show();
        txtUserName.setText(marketplaceArrayList.get(position).getItemCategory());
        uploadDate.setText("Rs: "+String.valueOf(marketplaceArrayList.get(position).getItemPrice())+"/-");
       bottomSheetDialog.show();
    }
}