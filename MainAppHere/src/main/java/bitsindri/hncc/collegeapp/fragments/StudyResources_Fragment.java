package bitsindri.hncc.collegeapp.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import bitsindri.hncc.collegeapp.Adapters.PDFAdapter;
import bitsindri.hncc.collegeapp.Custom_Classes.PDFModel;
import bitsindri.hncc.collegeapp.Interfaces.ItemClickListener;
import bitsindri.hncc.collegeapp.R;
import bitsindri.hncc.collegeapp.activities.WebViewActivity;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link StudyResources_Fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class StudyResources_Fragment extends Fragment {


    RecyclerView recyclerView;
    public static List<PDFModel> list;

    public StudyResources_Fragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_study_resources_, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        recyclerView =getActivity().findViewById(R.id.RV);

        list = new ArrayList<>();
        list.add(new PDFModel("PDF One","https://drive.google.com/file/d/0B4L4P11PTo2Bc3RhcnRlcl9maWxl/view?usp=sharing"));
        list.add(new PDFModel("PDF Two", "https://drive.google.com/file/d/0B4L4P11PTo2Bc3RhcnRlcl9maWxl/view?usp=sharing"));
        list.add(new PDFModel("PDF Three","https://drive.google.com/file/d/0B4L4P11PTo2Bc3RhcnRlcl9maWxl/view?usp=sharing"));
        list.add(new PDFModel("PDF Four","https://drive.google.com/file/d/0B4L4P11PTo2Bc3RhcnRlcl9maWxl/view?usp=sharing"));
        list.add(new PDFModel("PDF Five","https://drive.google.com/file/d/0B4L4P11PTo2Bc3RhcnRlcl9maWxl/view?usp=sharing"));
        list.add(new PDFModel("PDF java","https://drive.google.com/file/d/0B4L4P11PTo2Bc3RhcnRlcl9maWxl/view?usp=sharing"));
        list.add(new PDFModel("PDF java ","https://drive.google.com/file/d/0B4L4P11PTo2Bc3RhcnRlcl9maWxl/view?usp=sharing"));

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        ItemClickListener itemClickListener = new ItemClickListener() {
            @Override
            public void onClick(View view, int position, boolean isLongClick) {

                switch (view.getId())
                {
                    case R.id.IV|R.id.download:
                        Intent intent = new Intent(getContext(), WebViewActivity.class);
                        //intent.putExtra("url",list.get(position).getPdfUrl());
                        intent.putExtra("url",list.get(position).getPdfUrl());
                        startActivity(intent);
                        break;


                }

            }
        };

        PDFAdapter adapter = new PDFAdapter(list,getContext(),itemClickListener);
        recyclerView.setAdapter(adapter);


    }
}