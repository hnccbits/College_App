package bitsindri.hncc.collegeapp.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import bitsindri.hncc.collegeapp.Custom_Classes.Data;
import bitsindri.hncc.collegeapp.GetterAndSetter.marketplace;
import bitsindri.hncc.collegeapp.Interfaces.ItemClickListener;
import bitsindri.hncc.collegeapp.R;

public class MarketAdapter extends RecyclerView.Adapter<MarketAdapter.Holder> {

//    private List<PDFModel> list;
private List<marketplace> list;
    //private ArrayList<marketplace> marketplaceList ;
    boolean click=false;
    int temp=0;
    private Context context;
    ItemClickListener itemClickListener;


    public MarketAdapter(List<marketplace> list, Context context, ItemClickListener itemClickListener) {
        this.list = list;
        this.context = context;
        this.itemClickListener = itemClickListener;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.each_selling_item,parent,false);
        Holder holder = new Holder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {

        holder.itemCategory.setText(list.get(position).getCategory());
        String price = "Rs. " + list.get(position).getPrice();
        holder.itemPrice.setText(price);
        Picasso.get().load(list.get(position).getImg_url()).into(holder.imageView);


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class Holder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView itemCategory, itemPrice;
        ImageView imageView;
        Button starbtn;
        NewMarketAdapter.calluser callusers;

        public Holder(View itemView) {
            super(itemView);
            itemCategory = itemView.findViewById(R.id.item_category);
            itemPrice = itemView.findViewById(R.id.item_price);
            imageView=itemView.findViewById(R.id.product_img);
            starbtn = itemView.findViewById(R.id.fav_item);


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

            imageView.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {
            itemClickListener.onClick(v,getAdapterPosition(),false);
        }
    }
}
