package bitsindri.hncc.collegeapp.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import bitsindri.hncc.collegeapp.GetterAndSetter.comment;
import bitsindri.hncc.collegeapp.GetterAndSetter.feed;
import bitsindri.hncc.collegeapp.R;

public class commentsAdapter extends RecyclerView.Adapter {

    ArrayList<comment> commentList;
    Context myContext;

    public commentsAdapter(ArrayList<comment> commentList, Context myContext) {
        this.commentList = commentList;
        this.myContext = myContext;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.each_comment_for_mess, parent, false);
        return new commentsAdapter.commentHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        final commentsAdapter.commentHolder commentHolder = (commentsAdapter.commentHolder) holder;
        final comment comment = commentList.get(position);

        commentHolder.eating_time_comment.setText(comment.getCommentUserName());
        commentHolder.commentDateAndTime.setText(comment.getCommentDateAndTime());
        commentHolder.commentText.setText(comment.getCommentText());

    }

    @Override
    public int getItemCount() {
        return commentList == null? 0: commentList.size();
    }

    public class commentHolder extends RecyclerView.ViewHolder {

        TextView eating_time_comment;
        TextView commentDateAndTime;
        TextView commentText;

        public commentHolder(View itemView) {
            super(itemView);
            eating_time_comment = itemView.findViewById(R.id.eating_time_comment);
            commentDateAndTime= itemView.findViewById(R.id.comment_date_and_time_text_view);
            commentText = itemView.findViewById(R.id.comment_text);

        }

    }

}
