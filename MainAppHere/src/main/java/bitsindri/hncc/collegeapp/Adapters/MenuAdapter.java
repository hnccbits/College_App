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

import java.util.ArrayList;

import bitsindri.hncc.collegeapp.Custom_Classes.menuClass;
import bitsindri.hncc.collegeapp.GetterAndSetter.marketplace;
import bitsindri.hncc.collegeapp.R;

public class MenuAdapter extends RecyclerView.Adapter<MenuAdapter.ExampleViewHolder> {
    private calluser callusers;
//    private Context mContext;
    private ArrayList<menuClass> marketplaceList;


    public MenuAdapter(ArrayList<menuClass> marketplaceList, calluser callusers) {
        this.marketplaceList = marketplaceList;
        this.callusers = callusers;

    }

    @NonNull
    @Override
    public ExampleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_menu, parent, false);
        ExampleViewHolder evh = new ExampleViewHolder(v, callusers);
        return evh;
    }

    @Override
    public void onBindViewHolder(@NonNull ExampleViewHolder holder, int position) {


        holder.itemCategory.setText(marketplaceList.get(position).getItemCategory());
        holder.menu_icon.setImageResource(marketplaceList.get(position).getImgResource());
        holder.description.setText(marketplaceList.get(position).getDescription());


    }

    @Override
    public int getItemCount() {
        return marketplaceList.size();
    }

    public class ExampleViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView itemCategory;
        TextView description;
        ImageView menu_icon;
        calluser callusers;


        public ExampleViewHolder(@NonNull View itemView, calluser calluser) {
            super(itemView);
            itemCategory = itemView.findViewById(R.id.item_category);
            menu_icon = itemView.findViewById(R.id.menu_icon);
            description=itemView.findViewById(R.id.item_description);
            this.callusers = calluser;

            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View view) {
            callusers.productDetails(getAdapterPosition());

        }
    }

    //Interface containing method......
    public interface calluser {
        void productDetails(int position);
    }
}