package bitsindri.hncc.collegeapp.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import bitsindri.hncc.collegeapp.activities.sellingItemActivity;
import bitsindri.hncc.collegeapp.GetterAndSetter.marketplace;
import bitsindri.hncc.collegeapp.R;

public class marketplaceAdapter extends RecyclerView.Adapter{

    private final Context mContext ;
    private final ArrayList<marketplace> marketplaceList ;

    public marketplaceAdapter(Context mContext, ArrayList<marketplace> marketplaceList) {
        this.mContext = mContext;
        this.marketplaceList = marketplaceList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        LayoutInflater mInflater = LayoutInflater.from(mContext);
        view = mInflater.inflate(R.layout.each_selling_item,parent,false);
        return new marketplaceViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        marketplaceViewHolder marketplaceViewHolder = (marketplaceViewHolder)holder;
        marketplaceViewHolder.itemCategory.setText(marketplaceList.get(position).getItemCategory());
        final String price = "Rs. " + marketplaceList.get(position).getItemPrice();
        marketplaceViewHolder.itemPrice.setText(price);
        marketplaceViewHolder.buyButton.setOnClickListener(v -> {

            Intent intent = new Intent(mContext, sellingItemActivity.class);
            intent.putExtra("category", marketplaceList.get(position).getItemCategory());
            intent.putExtra("price", price);
            mContext.startActivity(intent);

        });
    }

    @Override
    public int getItemCount() {
        return marketplaceList == null? 0: marketplaceList.size();
    }

    public static class marketplaceViewHolder extends RecyclerView.ViewHolder {

        TextView itemCategory, itemPrice;
        Button buyButton;

        public marketplaceViewHolder(View itemView) {
            super(itemView);

            itemCategory = itemView.findViewById(R.id.item_category);
            itemPrice = itemView.findViewById(R.id.item_price);
            buyButton = itemView.findViewById(R.id.fav_item);


        }
    }


}
