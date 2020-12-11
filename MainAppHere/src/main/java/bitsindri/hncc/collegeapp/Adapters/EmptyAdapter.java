package bitsindri.hncc.collegeapp.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.io.Serializable;
import java.util.ArrayList;

import bitsindri.hncc.collegeapp.Custom_Classes.EmptyClass;
import bitsindri.hncc.collegeapp.Custom_Classes.PhoneNumber;
import bitsindri.hncc.collegeapp.R;

public class EmptyAdapter extends RecyclerView.Adapter<EmptyAdapter.ExampleViewHolder> {
    private ArrayList<EmptyClass> data;
    private calluser callusers;


    public EmptyAdapter(ArrayList<EmptyClass> data, calluser callusers){
        this.data = data;
        this.callusers = callusers;

    }

    @NonNull
    @Override
    public ExampleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_empty_fragment,parent,false);
        ExampleViewHolder evh = new ExampleViewHolder(v , callusers);
        return evh;
    }

    @Override
    public void onBindViewHolder(@NonNull ExampleViewHolder holder, int position) {

        EmptyClass currentitem = data.get(position);
       // holder.mImageView.setImageResource(currentitem.getmImageResource());
        holder.textView.setText(currentitem.getUsername());

    }

    @Override
    public int getItemCount() {
        return data.size();
    }
    public  class ExampleViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public ImageView mImageView;
        public TextView textView;

        calluser callusers;


        public ExampleViewHolder(@NonNull View itemView, calluser calluser) {
            super(itemView);
            mImageView = itemView.findViewById(R.id.content_img);
            textView = itemView.findViewById(R.id.content_text);

            this.callusers = calluser;

            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View view) {
            callusers.dialNumber(getAdapterPosition());

        }
    }

    //Interface containing method......
    public interface calluser {
        void dialNumber(int position);
    }
}