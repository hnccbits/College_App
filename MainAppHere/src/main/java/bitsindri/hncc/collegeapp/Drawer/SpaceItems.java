package bitsindri.hncc.collegeapp.Drawer;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;

public class SpaceItems extends  DrawerItem<SpaceItems.ViewHolder> {

    private  int spaceDp;

    public SpaceItems(int spaceDp){
        this.spaceDp = spaceDp;
    }

    @Override
    public boolean isSelected() {
        return false;
    }

    @Override
    public ViewHolder createViewHolder(ViewGroup parent) {

        Context c = parent.getContext();
        View view = new View(c);
        int height = (int) (c.getResources().getDisplayMetrics().density*spaceDp);
        view.setLayoutParams(new ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                height
        ));
        return new ViewHolder(view);
    }

    @Override
    public void bindViewHolder(ViewHolder holder) {

    }

    public  class ViewHolder extends DrawerAdapter.ViewHolder{

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
