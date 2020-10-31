package bitsindri.hncc.collegeapp.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

import bitsindri.hncc.collegeapp.Adapters.PageAdapter;
import bitsindri.hncc.collegeapp.R;
import bitsindri.hncc.collegeapp.Custom_Classes.UserList;
import xute.storyview.StoryModel;

public class MainActivity extends AppCompatActivity {
    //StoryView storyView;   // get the object for StoryView

    RecyclerView recyclerView;
    ArrayList<UserList> data=new ArrayList<UserList>();
    //ViewPager2 viewpager;
    PageAdapter pageAdapter;
    ArrayList<ArrayList<StoryModel>> user_list=new ArrayList<ArrayList<StoryModel>>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=findViewById(R.id.revyclerview);

        //viewpager=findViewById(R.id.viewpager2);
//
//        storyView = findViewById(R.id.storyView); // find the XML view using findViewById
//        storyView.resetStoryVisits(); // reset the storyview
//
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
        LinearLayoutManager manager = new LinearLayoutManager(this);
        manager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(pageAdapter);


    }
}