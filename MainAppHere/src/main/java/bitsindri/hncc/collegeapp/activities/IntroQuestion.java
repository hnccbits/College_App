package bitsindri.hncc.collegeapp.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.CompositePageTransformer;
import androidx.viewpager2.widget.MarginPageTransformer;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import bitsindri.hncc.collegeapp.Adapters.IntroQuestionAdapter;
import bitsindri.hncc.collegeapp.R;

public class IntroQuestion extends AppCompatActivity implements IntroQuestionAdapter.OnItemListener {
    TextView skip;
    ViewPager2 viewpager;
    IntroQuestionAdapter pageAdapter;
    RelativeLayout relativeLayout;
    ArrayList<String> data=new ArrayList<>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro_question);



        relativeLayout=findViewById(R.id.relativelayout);
        skip=findViewById(R.id.skipbtn);
        viewpager=findViewById(R.id.viewpager2);
        data.add("Sample Question here?");
        data.add("Sample Question here?");
        data.add("Sample Question here?");
        data.add("Sample Question here?");
        data.add("Sample Question here?");




        pageAdapter=new IntroQuestionAdapter(data,this);

        viewpager.setClipToPadding(false);
        viewpager.setClipChildren(false);
        viewpager.setOffscreenPageLimit(3);
        viewpager.getChildAt(0).setOverScrollMode(viewpager.OVER_SCROLL_IF_CONTENT_SCROLLS);
//        viewpager.getChildAt(0).setOverScrollMode(viewpager.OVER_SCROLL_NEVER);

        viewpager.setAdapter(pageAdapter);

        CompositePageTransformer transformer=new CompositePageTransformer();
        transformer.addTransformer(new MarginPageTransformer(50));
        transformer.addTransformer((page, position) -> {

            float r = 1 - Math.abs(position);
            page.setScaleY(0.8f);

//                page.setScaleY(0.8f + r * 0.2f);

        });
        viewpager.setPageTransformer(transformer);

        skip.setOnClickListener(v -> {

            Toast.makeText(IntroQuestion.this, "skip", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(IntroQuestion.this,MainActivity.class));
            finish();

        });

    }

    @Override
    public void OnListClick(int position) {
        switch(position)
        {
            case 0:

                relativeLayout.setBackgroundColor(Color.parseColor("#012dda"));
                break;
        }
    }
}