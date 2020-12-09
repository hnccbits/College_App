package bitsindri.hncc.collegeapp.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.Comparator;

import bitsindri.hncc.collegeapp.Adapters.homeFeedAdapter;
import bitsindri.hncc.collegeapp.GetterAndSetter.feed;
import bitsindri.hncc.collegeapp.R;

public class AchievementsActivity extends AppCompatActivity {

    ArrayList<feed> achievementsList;
    homeFeedAdapter achievementsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_achievements);

        FloatingActionButton fabAchievement = findViewById(R.id.add_achievement);
        fabAchievement.setOnClickListener(v -> startActivity(new Intent(AchievementsActivity.this, AddAchievementActivity.class)));

        RecyclerView achievementsRecyclerView = findViewById(R.id.achievements_recycler_view);
        achievementsRecyclerView.setLayoutManager(new LinearLayoutManager(AchievementsActivity.this));

        achievementsList = new ArrayList<feed>();

        achievementsList.clear();
        achievementsList.add(new feed("Person A", "29-10-2020 05:40 PM", "no_post_img", "This is my first message on this app", "5"));
        achievementsList.add(new feed("Person B", "25-10-2020 06:35 PM", "has_image", "Labelled as a vegetable for nutritional purposes, tomatoes are a good source of vitamin C and the phytochemical lycopene. ", "10"));
        achievementsList.add(new feed("Person C", "24-10-2020 10:42 AM", "no_post_img", "This is my another message for every one on this app", "0"));
        achievementsList.add(new feed("Person D", "24-09-2020 01:17 PM", "has_img", "Additionally, a large percentage of the world’s tomato crop is used for processing; products include canned tomatoes, tomato juice, ketchup, puree, paste, and “sun-dried” tomatoes or dehydrated pulp.", "15"));
        achievementsList.add(new feed("Person E", "15-08-2020 06:23 AM", "no_post_img", "This is a message for the world", "6"));

        // using comparator for arranging feed as per timing of their post
        Comparator<feed> compareByDateAndTime = (f1, f2) -> f2.getPostDateAndTime().compareToIgnoreCase(f1.getPostDateAndTime());
        achievementsList.sort(compareByDateAndTime);

        achievementsAdapter = new homeFeedAdapter(achievementsList, AchievementsActivity.this);
        achievementsRecyclerView.setAdapter(achievementsAdapter);

    }
}