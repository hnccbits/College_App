package bitsindri.hncc.collegeapp.fragments;

import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.ismaeldivita.chipnavigation.ChipNavigationBar;

import java.util.ArrayList;

import bitsindri.hncc.collegeapp.Adapters.GoogleMapAdapter;
import bitsindri.hncc.collegeapp.GetterAndSetter.googlemap;
import bitsindri.hncc.collegeapp.R;

public class GoogleMapFragment extends Fragment {

    EditText et_destination;
    ImageView revert;
    EditText et_source;
    ChipNavigationBar chipNavigationBar;
    Button btnShowTrack;

    RecyclerView recyclerview_map;
    GoogleMapAdapter googleMapAdapter;
    ArrayList<googlemap> items=new ArrayList<>();
    LinearLayoutManager linearLayoutManager;

    public GoogleMapFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_google_map, container, false);


        et_destination = view.findViewById(R.id.et_destination);
        et_source = view.findViewById(R.id.et_source);
        revert = view.findViewById(R.id.revert);
        chipNavigationBar = view.findViewById(R.id.chipNavigationBar);

        recyclerview_map = view.findViewById(R.id.recyclerview_map);
        linearLayoutManager = new LinearLayoutManager(getContext());
        recyclerview_map.setLayoutManager(linearLayoutManager);


        btnShowTrack = view.findViewById(R.id.btnShowTrack);


        items.add(new googlemap("Sindri"));
        items.add(new googlemap("Dhanbad"));
        items.add(new googlemap("MG"));
        items.add(new googlemap("OP"));
        items.add(new googlemap("GH"));
        items.add(new googlemap("Canteen"));
        items.add(new googlemap("ATM"));
        items.add(new googlemap("Shaherpura"));
        items.add(new googlemap("Lecture Hall"));
        items.add(new googlemap("C-51"));



        googleMapAdapter = new GoogleMapAdapter(items,getContext());
        recyclerview_map.setAdapter(googleMapAdapter);



        revert.setOnClickListener(v -> {

            String source = et_source.getText().toString();
            String dest = et_destination.getText().toString();

            if(source.equals("") && dest.equals("")){
                Toast.makeText(getActivity(),"Enter both location",Toast.LENGTH_SHORT).show();
            }
            else{

                   String temp = source;


            }

        });


        btnShowTrack.setOnClickListener(v -> {

            String source = et_source.getText().toString();
            String dest = et_destination.getText().toString();

          if(source.equals("") && dest.equals("")){
              Toast.makeText(getActivity(),"Enter both location",Toast.LENGTH_SHORT).show();
          }
          else{
              displayTrack(source, dest);
          }


        });

        chipNavigationBar.setItemSelected(R.id.car,true);

//        chipNavigationBar.setOnItemSelectedListener(new ChipNavigationBar.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(int i) {
//                switch (i){
//                    case R.id.car:
//                }
//            }
//        });

        return  view;
    }

    private void displayTrack(String source, String destination) {
        //if the device does not have a map installed ,the redirect it to play store

        try{
            Uri uri = Uri.parse("https://www.google.co.in/maps/dir/"+source+"/"+destination);

            //initialize intent with action view
            Intent intent = new Intent(Intent.ACTION_VIEW,uri);

            //set package
            intent.setPackage("com.google.android.apps.maps");

            //set flag
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        }catch (Exception e){
            //when google map is not installed

            //initialize uri
            Uri uri = Uri.parse("https://play.google.com/store/apps/details?id=com.google.android.apps.maps");

            //initialize intent
            Intent intent = new Intent(Intent.ACTION_VIEW,uri);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);

        }
    }
}