package bitsindri.hncc.collegeapp.Activities;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import bitsindri.hncc.collegeapp.Adapters.PageAdapter;
import bitsindri.hncc.collegeapp.Adapters.homeFeedAdapter;
import bitsindri.hncc.collegeapp.Custom_Classes.UserList;
import bitsindri.hncc.collegeapp.GetterAndSetter.feed;
import bitsindri.hncc.collegeapp.R;
import xute.storyview.StoryModel;


public class HomeFragment extends Fragment {

    private View homeFeedView;
    private RecyclerView homeRecyclerView;
    ArrayList<feed> homeFeedList;
    homeFeedAdapter homeFeedAdapter;

    private RecyclerView recyclerView;
    ArrayList<UserList> data=new ArrayList<UserList>();
    //ViewPager2 viewpager;
    PageAdapter pageAdapter;
    ArrayList<ArrayList<StoryModel>> user_list=new ArrayList<ArrayList<StoryModel>>();


    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        homeFeedView = inflater.inflate(R.layout.fragment_home, container, false);




        //code for status on home fragment
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



        pageAdapter=new PageAdapter(data);

//        viewpager.setClipToPadding(false);
//        viewpager.setClipChildren(false);
//        viewpager.setOffscreenPageLimit(3);
//        viewpager.getChildAt(0).setOverScrollMode(viewpager.OVER_SCROLL_ALWAYS);
////        viewpager.getChildAt(0).setOverScrollMode(viewpager.OVER_SCROLL_NEVER);
//        viewpager.setAdapter(pageAdapter);
//
//        CompositePageTransformer transformer=new CompositePageTransformer();
//        transformer.addTransformer(new MarginPageTransformer(0));
//        transformer.addTransformer(new ViewPager2.PageTransformer() {
//            @Override
//            public void transformPage(@NonNull View page, float position) {
//
//                float r = 1 - Math.abs(position);
//                //page.setScaleY(0.8f);
//
//                page.setScaleY(0.8f + r * 0.05f);
//
//            }
//        });
//        viewpager.setPageTransformer(transformer);


        //RECYCLER VIEW
        LinearLayoutManager manager = new LinearLayoutManager(getContext());
        manager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView = homeFeedView.findViewById(R.id.revyclerview);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(pageAdapter);




        //code for feed on home fragment
        homeRecyclerView = homeFeedView.findViewById(R.id.homeRecyclerView);
        homeRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        homeFeedList = new ArrayList<feed>();

        homeFeedList.add(new feed("Person A", "29-10-2020 05:40 PM", "no_post_img", "This is my first message on this app", "5"));
        homeFeedList.add(new feed("Person B", "25-10-2020 06:35 PM", "has_image", "Labelled as a vegetable for nutritional purposes, tomatoes are a good source of vitamin C and the phytochemical lycopene. ", "10"));
        homeFeedList.add(new feed("Person C", "24-10-2020 10:42 AM", "no_post_img", "This is my another message for every one on this app", "0"));
        homeFeedList.add(new feed("Person D", "24-09-2020 01:17 PM", "has_img", "Additionally, a large percentage of the world’s tomato crop is used for processing; products include canned tomatoes, tomato juice, ketchup, puree, paste, and “sun-dried” tomatoes or dehydrated pulp.", "15"));
        homeFeedList.add(new feed("Person E", "15-08-2020 06:23 AM", "no_post_img", "This is a message for the world", "6"));

        Comparator<feed> compareByDateAndTime = new Comparator<feed>() {
            @Override
            public int compare(feed f1, feed f2) {
                return f2.getPostDateAndTime().compareToIgnoreCase(f1.getPostDateAndTime());
            }
        };
        homeFeedList.sort(compareByDateAndTime);

        homeFeedAdapter = new homeFeedAdapter(homeFeedList, getContext());
        homeRecyclerView.setAdapter(homeFeedAdapter);

        return homeFeedView;
    }
}