package bitsindri.hncc.collegeapp.Adapters;

import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.ImageView;
        import android.widget.TextView;

        import androidx.annotation.NonNull;
        import androidx.recyclerview.widget.RecyclerView;

        import java.util.ArrayList;

import bitsindri.hncc.collegeapp.Custom_Classes.PhoneNumber;
import bitsindri.hncc.collegeapp.R;

public class TelephoneAdapter extends RecyclerView.Adapter<TelephoneAdapter.ExampleViewHolder> {
    private ArrayList<PhoneNumber> phoneNumbers;
    private calluser callusers;


    public TelephoneAdapter(ArrayList<PhoneNumber> phoneNumbers, calluser callusers){
        this.phoneNumbers = phoneNumbers;
        this.callusers = callusers;

    }

    @NonNull
    @Override
    public ExampleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_telephone_directory,parent,false);
        ExampleViewHolder evh = new ExampleViewHolder(v , callusers);
        return evh;
    }

    @Override
    public void onBindViewHolder(@NonNull ExampleViewHolder holder, int position) {

        PhoneNumber currentitem = phoneNumbers.get(position);
        holder.mImageView.setImageResource(currentitem.getmImageResource());
        holder.username.setText(currentitem.getUsername());
        holder.phnumber.setText(currentitem.getPhone_no());
        //holder.itemView.setOnClickListener();



    }

    @Override
    public int getItemCount() {
        return phoneNumbers.size();
    }
    public  class ExampleViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public ImageView mImageView;
        public TextView username;
        public TextView phnumber;
        calluser callusers;


        public ExampleViewHolder(@NonNull View itemView, calluser calluser) {
            super(itemView);
            mImageView = itemView.findViewById(R.id.imageview);
            username = itemView.findViewById(R.id.textview1);
            phnumber = itemView.findViewById(R.id.textview2);
            this.callusers = calluser;

            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View view) {
            callusers.dialNumber(getAdapterPosition());

        }
    }

    //Interface containing method......
    public interface calluser{
        void dialNumber(int position);
    }
}