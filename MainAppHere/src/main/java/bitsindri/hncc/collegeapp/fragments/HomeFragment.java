package bitsindri.hncc.collegeapp.fragments;

import android.os.Bundle;

import androidx.core.view.ViewCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.Comparator;

import bitsindri.hncc.collegeapp.Adapters.StoryAdapter;
import bitsindri.hncc.collegeapp.Adapters.homeFeedAdapter;
import bitsindri.hncc.collegeapp.Custom_Classes.UserList;
import bitsindri.hncc.collegeapp.GetterAndSetter.feed;
import bitsindri.hncc.collegeapp.R;
import xute.storyview.StoryModel;


public class HomeFragment extends Fragment {

    ArrayList<feed> homeFeedList;
    homeFeedAdapter homeFeedAdapter;

    ArrayList<UserList> data=new ArrayList<UserList>();
    StoryAdapter pageAdapter;
    ArrayList<ArrayList<StoryModel>> user_list=new ArrayList<ArrayList<StoryModel>>();


    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View homeFeedView = inflater.inflate(R.layout.fragment_home, container, false);


        data.clear(); //clearing data each time,before loading to PageAdapter

        //code for STATUS on home fragment
        ArrayList<StoryModel> StoriesList = new ArrayList<>();  // create a Array list of Stories

        StoriesList.add(new StoryModel("https://images.unsplash.com/photo-1503023345310-bd7c1de61c7d?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&w=1000&q=80","Status 1","Yesterday"));
        StoriesList.add(new StoryModel("https://www.bigstockphoto.com/images/homepage/module-6.jpg","Status 2","10:15 PM"));
        StoriesList.add(new StoryModel("https://www.gettyimages.com/gi-resources/images/500px/983794168.jpg","Satus 3","Today,2:31 PM"));
//        storyView.setImageUris(StoriesList);  // finally set the stories to storyview
        user_list.add(StoriesList);

        data.add(new UserList(user_list,"User1","Today,11:00am"));
        StoriesList.clear(); // claering previous data from arraylist.

        StoriesList.add(new StoryModel("https://images.unsplash.com/photo-1503023345310-bd7c1de61c7d?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&w=1000&q=80","Status 1","Yesterday"));
        StoriesList.add(new StoryModel("https://www.bigstockphoto.com/images/homepage/module-6.jpg","Status 2","10:15 PM"));
        StoriesList.add(new StoryModel("https://www.gettyimages.com/gi-resources/images/500px/983794168.jpg","Satus 3","Today,2:31 PM"));
        user_list.add(StoriesList);
        data.add(new UserList(user_list,"User2","Today,12:00am"));
        // StoriesList.clear(); // claering previous data from arraylist.

        user_list.add(StoriesList);
        data.add(new UserList(user_list,"User3","Today,01:00pm"));
        user_list.add(StoriesList);
        data.add(new UserList(user_list,"User4","yestarday"));
        user_list.add(StoriesList);
        data.add(new UserList(user_list,"User5","Today,09:00am"));
        user_list.add(StoriesList);
        data.add(new UserList(user_list,"User6","yestarday"));



        pageAdapter=new StoryAdapter(data);




        //RECYCLER VIEW
        LinearLayoutManager manager = new LinearLayoutManager(getContext());
        manager.setOrientation(LinearLayoutManager.HORIZONTAL);
        RecyclerView recyclerView = homeFeedView.findViewById(R.id.revyclerview);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(pageAdapter);

        ViewCompat.setNestedScrollingEnabled(recyclerView, false);




        //code for FEED on home fragment
        RecyclerView homeRecyclerView = homeFeedView.findViewById(R.id.homeRecyclerView);
        homeRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        homeFeedList = new ArrayList<feed>();

        homeFeedList.add(new feed("Person A", "29-10-2020 05:40 PM", "no_post_img", "This is my first message on this app", "5"));
        homeFeedList.add(new feed("Person B", "25-10-2020 06:35 PM", "has_image", "Labelled as a vegetable for nutritional purposes, tomatoes are a good source of vitamin C and the phytochemical lycopene. ", "10"));
        homeFeedList.add(new feed("Person C", "24-10-2020 10:42 AM", "no_post_img", "This is my another message for every one on this app", "0"));
        homeFeedList.add(new feed("Person D", "24-09-2020 01:17 PM", "has_img", "Additionally, a large percentage of the world’s tomato crop is used for processing; products include canned tomatoes, tomato juice, ketchup, puree, paste, and “sun-dried” tomatoes or dehydrated pulp.", "15"));
        homeFeedList.add(new feed("Person E", "15-08-2020 06:23 AM", "no_post_img", "This is a message for the world", "6"));

        // using comparator for arranging feed as per timing of their post
        Comparator<feed> compareByDateAndTime = new Comparator<feed>() {
            @Override
            public int compare(feed f1, feed f2) {
                return f2.getPostDateAndTime().compareToIgnoreCase(f1.getPostDateAndTime());
            }
        };
        homeFeedList.sort(compareByDateAndTime);

        homeFeedAdapter = new homeFeedAdapter(homeFeedList, getContext());
        homeRecyclerView.setAdapter(homeFeedAdapter);

        ViewCompat.setNestedScrollingEnabled(homeRecyclerView, false);

        return homeFeedView;
    }


}