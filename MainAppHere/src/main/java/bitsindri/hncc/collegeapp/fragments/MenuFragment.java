package bitsindri.hncc.collegeapp.fragments;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import bitsindri.hncc.collegeapp.Adapters.MenuAdapter;
import bitsindri.hncc.collegeapp.Custom_Classes.menuClass;
import bitsindri.hncc.collegeapp.R;
import bitsindri.hncc.collegeapp.activities.AchievementsActivity;
import bitsindri.hncc.collegeapp.activities.ContactUsActivity;
import bitsindri.hncc.collegeapp.activities.BuisnessActivity;
import bitsindri.hncc.collegeapp.activities.ContestsAndHackathonsActivity;
import bitsindri.hncc.collegeapp.activities.FeeCollectionActivity;
import bitsindri.hncc.collegeapp.activities.FrontActivity;
import bitsindri.hncc.collegeapp.activities.InternshipsAndJobsActivity;
import bitsindri.hncc.collegeapp.activities.InterviewsActivity;
import bitsindri.hncc.collegeapp.activities.MessActivity;
import bitsindri.hncc.collegeapp.activities.NavigationActivity;
import bitsindri.hncc.collegeapp.activities.OngoingIssuesActivity;
import bitsindri.hncc.collegeapp.activities.StartupAndProjectIdeas;
import bitsindri.hncc.collegeapp.activities.WorkshopsAndWebinarsActivity;


public class MenuFragment extends Fragment implements MenuAdapter.calluser {

    ArrayList<menuClass> menuListLeft;
    //ArrayList<menuClass> menuListRight;
    MenuAdapter menuAdapterLeft;
    //MenuAdapter menuAdapterRight;

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
        //menuListRight = new ArrayList<>();
        setData();
        setRecycler();
    }

    private void setData() {

        menuListLeft.clear();
        menuListLeft.add(new menuClass("Study Resources", R.drawable.vector_study_resources));
        menuListLeft.add(new menuClass("Lost and Found", R.drawable.vector_lost_and_found));

        menuListLeft.add(new menuClass("Internships and Jobs", R.drawable.vector_internships_and_jobs));
        menuListLeft.add(new menuClass("Interviews", R.drawable.vector_interviews));

        menuListLeft.add(new menuClass("StartUp/Project ideas", R.drawable.vector_startup_projects));
        menuListLeft.add(new menuClass("Help BITians", R.drawable.vector_help_bitians));

        menuListLeft.add(new menuClass("Ongoing Issues", R.drawable.vector_ongoing_issues));
        menuListLeft.add(new menuClass("Contact Us", R.drawable.vector_contact_us));

        menuListLeft.add(new menuClass("Workshops and Webinars", R.drawable.vector_workshops_and_webinars));
        menuListLeft.add(new menuClass("Canteen Orders", R.drawable.vector_canteen_orders));

        menuListLeft.add(new menuClass("Contests and Hackathons", R.drawable.vector_contests_and_hackathons));
        menuListLeft.add(new menuClass("Hostel Report", R.drawable.vector_mess_report));

        menuListLeft.add(new menuClass("Our Achievements", R.drawable.vector_achievements));
        menuListLeft.add(new menuClass("Clubs and Societies", R.drawable.vector_clubs_and_societies));

        menuListLeft.add(new menuClass("BIT Sindri", R.drawable.vector_bit_sindri));
        menuListLeft.add(new menuClass("Fee Collection", R.drawable.vector_fees));
        //menuListLeft.add(new menuClass("Fee Collection",R.drawable.vector_lost_and_found));

    }

    private void setRecycler() {
        RecyclerView recyclerViewLeft = getActivity().findViewById(R.id.menuRecyclerview_1);
        //RecyclerView recyclerViewRight = getActivity().findViewById(R.id.menuRecyclerview_2);
        recyclerViewLeft.setLayoutManager(new GridLayoutManager(getContext(), 2));
        //recyclerViewRight.setLayoutManager(new LinearLayoutManager(getContext()));

//        int orientation = getResources().getConfiguration().orientation;
//        if(orientation == Configuration.ORIENTATION_LANDSCAPE) {
//            recyclerViewLeft.setLayoutManager(new LinearLayoutManager(getContext()));
//        }else if (orientation == Configuration.ORIENTATION_PORTRAIT){
//            recyclerViewLeft.setLayoutManager(new GridLayoutManager(getContext(),2));
//        }
        //marketplaceRecyclerView.setLayoutManager(new GridLayoutManager(getContext(),2));

        menuAdapterLeft = new MenuAdapter(menuListLeft,this);
        //menuAdapterRight = new MenuAdapter(menuListRight,this);
        recyclerViewLeft.setAdapter(menuAdapterLeft);
        //recyclerViewRight.setAdapter(menuAdapterRight);
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

        if(position == 0){
            //startActivity(new Intent(getContext(), InternshipsAndJobsActivity.class));
            FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
            fragmentManager.beginTransaction().setCustomAnimations(android.R.animator.fade_in, android.R.animator.fade_out).replace(R.id.frameLayout, new StudyResources_Fragment()).addToBackStack(null).commit();

        }else if(position == 1){
            startActivity(new Intent(getContext(), FrontActivity.class));
        }else if(position == 2){
            startActivity(new Intent(getContext(), InternshipsAndJobsActivity.class));
        }else if(position == 3){
            startActivity(new Intent(getContext(), InterviewsActivity.class));
        }else if(position == 4){
            startActivity(new Intent(getContext(), StartupAndProjectIdeas.class));
        }else if(position == 5){
            //startActivity(new Intent(getContext(), InternshipsAndJobsActivity.class));
        }else if(position == 6){
            startActivity(new Intent(getContext(), OngoingIssuesActivity.class));
        }else if(position == 7){
            startActivity(new Intent(getContext(), ContactUsActivity.class));
        }else if(position == 8){
            startActivity(new Intent(getContext(), WorkshopsAndWebinarsActivity.class));
        }else if(position == 9){
            startActivity(new Intent(getContext(), NavigationActivity.class));
        }else if(position == 10){
            startActivity(new Intent(getContext(), ContestsAndHackathonsActivity.class));
        }else if(position == 11){
            startActivity(new Intent(getContext(), MessActivity.class));
        }else if(position == 12){
            startActivity(new Intent(getContext(), AchievementsActivity.class));
        }else if(position == 13){
            //startActivity(new Intent(getContext(), InternshipsAndJobsActivity.class));
        }else if(position == 14){
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.bitsindri.ac.in/index.php#")));
        }
        else if(position==15){
            startActivity(new Intent(getContext(), FeeCollectionActivity.class));
        }

    }
}