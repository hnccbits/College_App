package bitsindri.hncc.collegeapp.Drawer;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import bitsindri.hncc.collegeapp.R;

public class SimpleItem extends  DrawerItem<SimpleItem.ViewHolder> {

    //variable to distinguish bet sselected and unselected items
    private  int selectedItemIconTint;
    private int selectedItemTextTint;

    private  int normalItemIconTint;
    private  int normalItemTextTint;

    private Drawable icon;
    private String title;

    public  SimpleItem(Drawable icon,String title){
        this.icon = icon;
        this .title = title;

    }

    @Override
    public ViewHolder createViewHolder(ViewGroup parent) {

        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.item_option,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void bindViewHolder(ViewHolder holder) {
      holder.title.setText(title);
      holder.icon.setImageDrawable(icon);

      holder.icon.setColorFilter(isChecked ? selectedItemIconTint : normalItemIconTint);
      holder.title.setTextColor(isChecked ? selectedItemTextTint : normalItemTextTint);
    }

    //methods for icon and text color for selected and non selected items
    public SimpleItem withSelectedIconTint(int selectedItemIconTint){
        this.selectedItemIconTint = selectedItemIconTint;
        return  this;
    }

    public SimpleItem withSelectedTextTint(int selectedItemTextTint){
        this.selectedItemTextTint = selectedItemTextTint;
        return this;
    }

    public  SimpleItem withIcontint(int  normalItemIconTint){
        this.normalItemIconTint = normalItemIconTint;
        return this;
    }

    public SimpleItem withTextTint(int normalItemTextTint){
        this.normalItemTextTint = normalItemTextTint;
        return  this;
    }

    static  class ViewHolder extends DrawerAdapter.ViewHolder {

        private ImageView icon;
        private TextView title;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            icon = itemView.findViewById(R.id.icon);
            title = itemView.findViewById(R.id.title);
        }
    }

}
