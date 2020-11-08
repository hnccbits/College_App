package bitsindri.hncc.collegeapp.fragments;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;

import bitsindri.hncc.collegeapp.Adapters.TelephoneAdapter;
import bitsindri.hncc.collegeapp.Custom_Classes.PhoneNumber;
import bitsindri.hncc.collegeapp.R;


public class Telephone_Directory extends Fragment implements TelephoneAdapter.calluser {

    RecyclerView recyclerView;
    ArrayList<PhoneNumber> data;
    TelephoneAdapter telephoneAdapter;


    public Telephone_Directory() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_telephone__directory, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        recyclerView=(RecyclerView)getActivity().findViewById(R.id.tel_RecyclerView);

        data = new ArrayList<>();
        data.add(new PhoneNumber(R.drawable.profilepic,"user","0866-2410978"));
        data.add(new PhoneNumber(R.drawable.profilepic,"user","0866-2410978"));
        data.add(new PhoneNumber(R.drawable.profilepic,"user","0866-2410978"));
        data.add(new PhoneNumber(R.drawable.profilepic,"user","0866-2410978"));
        data.add(new PhoneNumber(R.drawable.profilepic,"user","0866-2410978"));
        data.add(new PhoneNumber(R.drawable.profilepic,"user","0866-2410978"));
        data.add(new PhoneNumber(R.drawable.profilepic,"user","0866-2410978"));
        data.add(new PhoneNumber(R.drawable.profilepic,"user","0866-2410978"));
        data.add(new PhoneNumber(R.drawable.profilepic,"user","0866-2410978"));
        data.add(new PhoneNumber(R.drawable.profilepic,"user","0866-2410978"));




        telephoneAdapter=new TelephoneAdapter(data,this);
        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(telephoneAdapter);

    }

    @Override
    public void dialNumber(int position) {

        data.get(position);
        PhoneNumber current_user = data.get(position);
        String phoneno =current_user.getPhone_no();
        Toast.makeText(getContext(),phoneno,Toast.LENGTH_LONG).show();
        Uri u = Uri.parse("tel:"+phoneno);
        Intent i = new Intent(Intent.ACTION_DIAL, u);
        startActivity(i);
    }
}