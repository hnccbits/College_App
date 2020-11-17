package bitsindri.hncc.collegeapp.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.Nullable;
//import androidx.appcompat.view.menu.MenuAdapter;
import bitsindri.hncc.collegeapp.Adapters.MenuAdapter;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import bitsindri.hncc.collegeapp.Custom_Classes.menuClass;
import bitsindri.hncc.collegeapp.R;

public class MenuFragment extends Fragment implements MenuAdapter.calluser {

    ArrayList<menuClass> menuListLeft;
    ArrayList<menuClass> menuListRight;
    private RecyclerView recyclerViewLeft;
    private RecyclerView recyclerViewRight;
    MenuAdapter menuAdapterLeft;
    MenuAdapter menuAdapterRight;

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

        menuListLeft = new ArrayList<>();
        menuListRight = new ArrayList<>();
        setData();
        setRecycler();
    }

    private void setData() {
        // work done on menuListLeft by Prayanshu
        menuListLeft.clear();
        menuListLeft.add(new menuClass("Study Resources", R.drawable.vector_study_resources));
        menuListLeft.add(new menuClass("Internships and Jobs", R.drawable.vector_internships_and_jobs));
        menuListLeft.add(new menuClass("StartUp/Project ideas", R.drawable.vector_startup_projects));
        menuListLeft.add(new menuClass("Ongoing issues in BIT", R.drawable.vector_ongoing_issues));
        menuListLeft.add(new menuClass("Workshops and Webinars", R.drawable.vector_workshops_and_webinars));
        menuListLeft.add(new menuClass("Contests and Hackathons", R.drawable.vector_contests_and_hackathons));
        menuListLeft.add(new menuClass("Our Achievements", R.drawable.vector_achievements));


        // work done on menuListRight by Anjali
        menuListRight.clear();
        menuListRight.add(new menuClass("Lost and Found", R.drawable.vector_lost_and_found));
        menuListRight.add(new menuClass("Interviews", R.drawable.vector_interviews));
        menuListRight.add(new menuClass("Help BITians", R.drawable.vector_help_bitians));
        menuListRight.add(new menuClass("Canteen Orders", R.drawable.vector_canteen_orders));
        menuListRight.add(new menuClass("Mess Report", R.drawable.vector_mess_report));
        menuListRight.add(new menuClass("Clubs and Societies", R.drawable.vector_clubs_and_societies));
        menuListRight.add(new menuClass("About BIT Sindri", R.drawable.vector_bit_sindri));
    }

    private void setRecycler() {
        recyclerViewLeft = getActivity().findViewById(R.id.menuRecyclerview_1);
        recyclerViewRight = getActivity().findViewById(R.id.menuRecyclerview_2);
        recyclerViewLeft.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerViewRight.setLayoutManager(new LinearLayoutManager(getContext()));

//        int orientation = getResources().getConfiguration().orientation;
//        if(orientation == Configuration.ORIENTATION_LANDSCAPE) {
//            recyclerViewLeft.setLayoutManager(new LinearLayoutManager(getContext()));
//        }else if (orientation == Configuration.ORIENTATION_PORTRAIT){
//            recyclerViewLeft.setLayoutManager(new GridLayoutManager(getContext(),2));
//        }
        //marketplaceRecyclerView.setLayoutManager(new GridLayoutManager(getContext(),2));

        menuAdapterLeft = new MenuAdapter(menuListLeft,this);
        menuAdapterRight = new MenuAdapter(menuListRight,this);
        recyclerViewLeft.setAdapter(menuAdapterLeft);
        recyclerViewRight.setAdapter(menuAdapterRight);
    }


//    @Override
//    public void onConfigurationChanged(@NonNull Configuration newConfig) {
//        super.onConfigurationChanged(newConfig);
//
//        if(newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
//            recyclerViewLeft.setLayoutManager(new GridLayoutManager(getContext(),4));
//        }else if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT){
//            recyclerViewLeft.setLayoutManager(new GridLayoutManager(getContext(),2));
//        }
//
//    }

    @Override
    public void productDetails(int position) {
        Toast.makeText(getContext(),"position: "+position,Toast.LENGTH_SHORT).show();
        //TO DO ADD TASK
    }
}