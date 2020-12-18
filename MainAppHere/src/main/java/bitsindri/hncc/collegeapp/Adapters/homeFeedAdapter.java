package bitsindri.hncc.collegeapp.Adapters;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import bitsindri.hncc.collegeapp.GetterAndSetter.feed;
import bitsindri.hncc.collegeapp.R;

public class homeFeedAdapter extends RecyclerView.Adapter{

    ArrayList<feed> homeFeedList;
    Context myContext;

    public homeFeedAdapter(ArrayList<feed> homeFeedList, Context myContext) {
        this.homeFeedList = homeFeedList;
        this.myContext = myContext;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.each_feed, parent, false);
        return new homeFeedAdapter.FeedHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        final FeedHolder FeedHolder = (FeedHolder)holder;

        final feed feed = homeFeedList.get(position);

        FeedHolder.feedProfileName.setText(feed.getProfileName());
        FeedHolder.feedDateAndTime.setText(feed.getPostDateAndTime());

        String PostImageUrl = feed.getPostImageUrl();
        if(!PostImageUrl.equals("null")){
            FeedHolder.feedImage.setImageResource(R.drawable.desktop);
            Picasso.get().load(feed.getPostImageUrl()).into(FeedHolder.feedImage);
//            Picasso.with(myContext).load(feed.getPostImageUrl()).into( FeedHolder.feedImage);
        }else {
            FeedHolder.feedImage.setVisibility(View.GONE);

        }

        FeedHolder.feedText.setText(feed.getPostMessage());

        FeedHolder.feedLikes.setText(feed.getPostLikes());

        final boolean[] isLiked = {false};
        final int[] postLikes = {Integer.parseInt(feed.getPostLikes())};
        FeedHolder.feedLikeLayout.setOnClickListener(v -> {
            if(isLiked[0]){
                // user is unliking the post
                isLiked[0] = false;
                --postLikes[0];
                feed.setPostLikes(String.valueOf(postLikes[0]));
                FeedHolder.feedLikes.setText(String.valueOf(postLikes[0]));
                FeedHolder.feedLikeButton.setImageResource(R.drawable.vector_unlike);
            }else{
                // user is liking the post
                isLiked[0] = true;
                ++postLikes[0];
                feed.setPostLikes(String.valueOf(postLikes[0]));
                FeedHolder.feedLikes.setText(String.valueOf(postLikes[0]));
                FeedHolder.feedLikeButton.setImageResource(R.drawable.vector_like);
            }
        });

        FeedHolder.commentFeed.setOnClickListener(v -> {
            Intent commentIntent = new Intent(myContext, bitsindri.hncc.collegeapp.activities.commentActivity.class);
            commentIntent.putExtra("postImage", feed.getPostImageUrl());
            commentIntent.putExtra("postMessage", feed.getPostMessage());
            commentIntent.putExtra("postUserName", feed.getProfileName());
            commentIntent.putExtra("postDateAndTime", feed.getPostDateAndTime());
            commentIntent.putExtra("postLikes", feed.getPostLikes());
            myContext.startActivity(commentIntent);

        });

        FeedHolder.shareFeed.setOnClickListener(v -> {
            Intent shareIntent = new Intent();

            if(PostImageUrl.equals("no_post_img")){
                // when post has no image, only text
                shareIntent.putExtra(Intent.EXTRA_TEXT, feed.getPostMessage());
                shareIntent.setType("text/plain");
            }else {
                // when post has image and text both
                Uri imageUri = Uri.parse("android.resource://" + myContext.getPackageName()
                        + "/drawable/" + "desktop");
                String shareMessage = feed.getPostMessage();
                shareIntent.putExtra(Intent.EXTRA_TEXT, "Hello");
                shareIntent.putExtra(Intent.EXTRA_STREAM, imageUri);
                shareIntent.setType("image/jpeg");
            }
            shareIntent.setAction(Intent.ACTION_SEND);
            shareIntent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
            try {
                myContext.startActivity(Intent.createChooser(shareIntent, "send"));
            } catch (android.content.ActivityNotFoundException ex) {
                Toast.makeText(myContext, "Something went wrong :(", Toast.LENGTH_SHORT).show();
            }

        });

    }





    @Override
    public int getItemCount() {
        return homeFeedList == null? 0: homeFeedList.size();
    }

    public class FeedHolder extends RecyclerView.ViewHolder {

        TextView feedProfileName;
        TextView feedDateAndTime;
        ImageView feedImage;
        ImageView feedLikeButton;
        LinearLayout feedLikeLayout;
        TextView feedText;
        TextView feedLikes;
        LinearLayout shareFeed, commentFeed;

        public FeedHolder(View itemView) {
            super(itemView);
            feedProfileName = itemView.findViewById(R.id.each_post_name_text_view);
            feedDateAndTime= itemView.findViewById(R.id.each_post_date_and_time_text_view);
            feedImage = itemView.findViewById(R.id.feed_image);
            feedText = itemView.findViewById(R.id.feed_text);
            feedLikeButton = itemView.findViewById(R.id.like_button);
            feedLikeLayout = itemView.findViewById(R.id.like_linear_layout);
            feedLikes = itemView.findViewById(R.id.feed_likes);
            shareFeed = itemView.findViewById(R.id.shareLinearLayout);
            commentFeed = itemView.findViewById(R.id.commentLinearLayout);
        }

    }

}
