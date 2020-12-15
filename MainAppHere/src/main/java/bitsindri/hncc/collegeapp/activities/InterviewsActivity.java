package bitsindri.hncc.collegeapp.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.Comparator;

import bitsindri.hncc.collegeapp.Adapters.homeFeedAdapter;
import bitsindri.hncc.collegeapp.GetterAndSetter.feed;
import bitsindri.hncc.collegeapp.R;

public class InterviewsActivity extends AppCompatActivity {

    ArrayList<feed> interviewsList;
    homeFeedAdapter interviewsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interviews);

        RecyclerView interviewsRecyclerView = findViewById(R.id.interviews_recycler_view);
        interviewsRecyclerView.setLayoutManager(new LinearLayoutManager(InterviewsActivity.this));

        interviewsList = new ArrayList<feed>();

        interviewsList.clear();
        interviewsList.add(new feed("Person A", "29-10-2020 05:40 PM", "no_post_img", "This is my first message on this app", "5"));
        interviewsList.add(new feed("Person B", "25-10-2020 06:35 PM", "has_image", "Labelled as a vegetable for nutritional purposes, tomatoes are a good source of vitamin C and the phytochemical lycopene. ", "10"));
        interviewsList.add(new feed("Person C", "24-10-2020 10:42 AM", "no_post_img", "This is my another message for every one on this app", "0"));
        interviewsList.add(new feed("Person D", "24-09-2020 01:17 PM", "has_img", "Additionally, a large percentage of the world’s tomato crop is used for processing; products include canned tomatoes, tomato juice, ketchup, puree, paste, and “sun-dried” tomatoes or dehydrated pulp.", "15"));
        interviewsList.add(new feed("Person E", "15-08-2020 06:23 AM", "no_post_img", "This is a message for the world", "6"));

        // using comparator for arranging feed as per timing of their post
        Comparator<feed> compareByDateAndTime = new Comparator<feed>() {
            @Override
            public int compare(feed f1, feed f2) {
                return f2.getPostDateAndTime().compareToIgnoreCase(f1.getPostDateAndTime());
            }
        };
        interviewsList.sort(compareByDateAndTime);

        interviewsAdapter = new homeFeedAdapter(interviewsList, InterviewsActivity.this);
        interviewsRecyclerView.setAdapter(interviewsAdapter);

    }
}