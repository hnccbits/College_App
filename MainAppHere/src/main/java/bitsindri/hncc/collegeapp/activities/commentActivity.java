package bitsindri.hncc.collegeapp.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import bitsindri.hncc.collegeapp.Adapters.commentsAdapter;
import bitsindri.hncc.collegeapp.Adapters.homeFeedAdapter;
import bitsindri.hncc.collegeapp.GetterAndSetter.comment;
import bitsindri.hncc.collegeapp.GetterAndSetter.feed;
import bitsindri.hncc.collegeapp.R;

public class commentActivity extends AppCompatActivity {

    private ImageView postImage;
    private TextView postUserName, postDateAndTime, postMessage, postLike;
    private EditText commentEditText;
    private ImageButton sendCommentButton;
    ArrayList<comment> commentList;
    commentsAdapter commentsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comment);

        postUserName = findViewById(R.id.comment_post_name);
        postDateAndTime = findViewById(R.id.comment_post_date_and_time);
        postImage = findViewById(R.id.comment_post_image);
        postMessage = findViewById(R.id.comment_post_message);
        postLike = findViewById(R.id.comment_feed_likes);
        commentEditText = findViewById(R.id.comment_edit_text);
        sendCommentButton = findViewById(R.id.send_comment_button);

        Intent commentIntent = getIntent();
        String commentUserName = commentIntent.getExtras().get("postUserName").toString();
        postUserName.setText(commentUserName);
        String commentPostDateAndTime = commentIntent.getExtras().get("postDateAndTime").toString();
        postDateAndTime.setText(commentPostDateAndTime);
        String commentPostImage = commentIntent.getExtras().get("postImage").toString();
        if(commentPostImage.equals("no_post_img"))
            postImage.setVisibility(View.GONE);
        else
            postImage.setImageResource(R.drawable.desktop);
        String commentPostMessage = commentIntent.getExtras().get("postMessage").toString();
        postMessage.setText(commentPostMessage);
        String commentPostLike = commentIntent.getExtras().get("postLikes").toString() + " Likes";
        postLike.setText(commentPostLike);

        RecyclerView commentsRecyclerView = findViewById(R.id.commentsRecyclerView);
        commentsRecyclerView.setLayoutManager(new LinearLayoutManager(commentActivity.this));

        commentList = new ArrayList<comment>();

        commentsAdapter = new commentsAdapter(commentList, commentActivity.this);
        commentsRecyclerView.setAdapter(commentsAdapter);



        sendCommentButton.setOnClickListener(v -> {
            String myComment = commentEditText.getText().toString();
            if(!myComment.equals("")){
                comment myCommentObj = new comment("Person A", "11-11-20 09:05 PM", myComment);
                commentList.add(myCommentObj);
                commentEditText.setText("");
                commentsAdapter.notifyDataSetChanged();
            }
        });

        ViewCompat.setNestedScrollingEnabled(commentsRecyclerView, false);

    }

}