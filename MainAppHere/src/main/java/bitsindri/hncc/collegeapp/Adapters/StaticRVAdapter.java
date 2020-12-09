package bitsindri.hncc.collegeapp.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import bitsindri.hncc.collegeapp.R;
import bitsindri.hncc.collegeapp.models.StaticRCViewModel;


public class StaticRVAdapter extends RecyclerView.Adapter<StaticRVAdapter.StaticRVViewHolder>{

    ArrayList<StaticRCViewModel> items;
    int row_index = -1;

    public StaticRVAdapter(ArrayList<StaticRCViewModel> items){
        this.items = items;
    }

    @NonNull
    @Override
    public StaticRVViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.static_rv_item,parent,false);
        StaticRVViewHolder staticRVViewHolder = new StaticRVViewHolder(view);
        return staticRVViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull StaticRVViewHolder holder, final int position) {


        StaticRCViewModel curretnItem = items.get(position);
        holder.image.setImageResource(curretnItem.getImage());
        holder.text.setText(curretnItem.getText());

        holder.linearLayout.setOnClickListener(v -> {
            row_index = position;
            notifyDataSetChanged();
        });

        if(row_index == position){
            holder.linearLayout.setBackgroundResource(R.drawable.static_rv_selected);
        }else{
            holder.linearLayout.setBackgroundResource(R.drawable.static_recycler_view_background);
        }
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public static class StaticRVViewHolder extends RecyclerView.ViewHolder{

        TextView text;
        ImageView image;
        LinearLayout linearLayout;

        public StaticRVViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.image);
            text = itemView.findViewById(R.id.text);
            linearLayout = itemView.findViewById(R.id.linearLayout);

        }
    }

}
