package bitsindri.hncc.collegeapp.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.makeramen.roundedimageview.RoundedImageView;

import java.util.ArrayList;

import bitsindri.hncc.collegeapp.R;

public class IntroQuestionAdapter extends RecyclerView.Adapter<IntroQuestionAdapter.ViewHolder> {
    ArrayList<String> data ;
    Context context;
    public IntroQuestionAdapter(ArrayList<String>  data, Context context)
    {

        this.data=data;
        this.context=context;

    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.view_holder_intro_question,parent,false);
        return  new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.textView.setText(data.get(position));
        switch(position){
            case 0:

                break;


        }
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        //ImageView imageView;
        TextView textView;
        private RoundedImageView imageView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.imgView);
            textView=itemView.findViewById(R.id.textView);
        }
    }

    public  interface  OnItemListener{
        void OnListClick(int position);
    }
}
