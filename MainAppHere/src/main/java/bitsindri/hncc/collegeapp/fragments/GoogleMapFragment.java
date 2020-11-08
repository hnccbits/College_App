package bitsindri.hncc.collegeapp.fragments;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import bitsindri.hncc.collegeapp.R;

public class GoogleMapFragment extends Fragment {

    EditText et_destination;
    EditText et_source;
    Button btnShowTrack;

    public GoogleMapFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_google_map, container, false);


        et_destination = view.findViewById(R.id.et_destination);
        et_source = view.findViewById(R.id.et_source);
        btnShowTrack = view.findViewById(R.id.btnShowTrack);


        btnShowTrack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

              String source = et_source.getText().toString();
              String dest = et_destination.getText().toString();
              if(source.equals("") && dest.equals("")){
                  Toast.makeText(getActivity(),"Enter both location",Toast.LENGTH_SHORT).show();
              }
              else{
                  displayTrack(source,dest);
              }


            }
        });

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