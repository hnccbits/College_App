package bitsindri.hncc.collegeapp.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import bitsindri.hncc.collegeapp.R;
import bitsindri.hncc.collegeapp.Custom_Classes.UserList;
import xute.storyview.StoryView;

public class StoryAdapter extends RecyclerView.Adapter<StoryAdapter.ViewHolder> {
    ArrayList<UserList> data ;
    public StoryAdapter(ArrayList<UserList>  data)
    {

        this.data=data;

    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_story_list,parent,false);
        return  new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        if(position==0)
        {
            holder.addStroy.setVisibility(View.VISIBLE);
            holder.textTime.setText(null);
            holder.storyView.setVisibility(View.GONE);
            holder.dp.setVisibility(View.VISIBLE);
        }
        else
        {
            int index=position-1;
            holder.textName.setText(data.get(index).getUserName());
            holder.textTime.setText(data.get(index).getTime());
            holder.storyView.resetStoryVisits();
            holder.storyView.setImageUris(data.get(index).getUser().get(index));
        }
        if(position==data.size())
        {
            holder.textName.setText(data.get(position).getUserName());
            holder.textTime.setText(data.get(position).getTime());
            holder.storyView.resetStoryVisits();
            holder.storyView.setImageUris(data.get(position).getUser().get(position));
        }


    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        //ImageView imageView;
        TextView textName;
        TextView textTime;
        StoryView storyView;
        Button addStroy;
        ImageView dp;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            storyView = itemView.findViewById(R.id.storyView);
            textTime=itemView.findViewById(R.id.text_time);
            textName=itemView.findViewById(R.id.text_name);
            addStroy=itemView.findViewById(R.id.btn_addStory);
            dp=itemView.findViewById(R.id.profilepic);

        }
    }


}
