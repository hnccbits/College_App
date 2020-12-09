package bitsindri.hncc.collegeapp.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import bitsindri.hncc.collegeapp.Custom_Classes.PhoneNumber;
import bitsindri.hncc.collegeapp.GetterAndSetter.marketplace;
import bitsindri.hncc.collegeapp.R;
import bitsindri.hncc.collegeapp.activities.sellingItemActivity;

public class NewMarketAdapter extends RecyclerView.Adapter<NewMarketAdapter.ExampleViewHolder> {
    private calluser callusers;
    private Context mContext ;
    private ArrayList<marketplace> marketplaceList ;
    boolean click=false;
    int temp=0;


    public NewMarketAdapter(ArrayList<marketplace> marketplaceList,calluser callusers) {
        this.marketplaceList = marketplaceList;
       this.callusers= callusers;

    }

    @NonNull
    @Override
    public ExampleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.each_selling_item,parent,false);
        ExampleViewHolder evh = new ExampleViewHolder(v , callusers);
        return evh;
    }

    @Override
    public void onBindViewHolder(@NonNull ExampleViewHolder holder, int position) {


       holder.itemCategory.setText(marketplaceList.get(position).getItemCategory());
        final String price = "Rs. " + marketplaceList.get(position).getItemPrice();
        holder.itemPrice.setText(price);


    }

    @Override
    public int getItemCount() {
        return marketplaceList.size();
    }
    public  class ExampleViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView itemCategory, itemPrice;
        Button starbtn;
        calluser callusers;


        public ExampleViewHolder(@NonNull View itemView, calluser calluser) {
            super(itemView);
            itemCategory = itemView.findViewById(R.id.item_category);
            itemPrice = itemView.findViewById(R.id.item_price);
            starbtn = itemView.findViewById(R.id.fav_item);
            this.callusers = calluser;

            starbtn.setOnClickListener(v -> {

                int position=getAdapterPosition();
                if(temp==position)
                {
                    //TODO: implement like feature.
                }
                else
                {
                    temp=position;
                    click=false;
                }

                if(!click)
                {
                    starbtn.setBackgroundResource(R.drawable.star_on);
                }
                else
                {
                    starbtn.setBackgroundResource(R.drawable.star_off);
                }
                click=!click;

            });

            itemView.setOnClickListener(this);


        }

        @Override
        public void onClick(View view) {
            //Toast.makeText(mContext,"hello",Toast.LENGTH_SHORT).show();
            callusers.productDetails(getAdapterPosition());

        }
    }

    //Interface containing method......
    public interface calluser{
        void productDetails(int position);
    }
}