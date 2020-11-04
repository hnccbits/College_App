package bitsindri.hncc.collegeapp.Adapters;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import java.util.List;

import bitsindri.hncc.collegeapp.Adapters.DynamicRVInterface.LoadMore;
import bitsindri.hncc.collegeapp.R;
import bitsindri.hncc.collegeapp.models.DynamicRVModel;

class LoadViewHolder extends RecyclerView.ViewHolder{

    public ProgressBar progressBar;

    public LoadViewHolder(@NonNull View itemView) {
        super(itemView);
        progressBar = itemView.findViewById(R.id.progress_bar);
    }

}

class ItemViewHolder extends RecyclerView.ViewHolder{

    public TextView name;
    public ImageView imageView;

    public ItemViewHolder(@NonNull View itemView) {
        super(itemView);

        name = itemView.findViewById(R.id.name);
        imageView = itemView.findViewById(R.id.imageView);
    }
}

public class DynamicRVAdapter extends  RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private  final int VIEW_TYPE_ITEM =0,VIEW_TYPE_LOADING =1;
    LoadMore loadmore;
    boolean isLoading;
    Activity activity;
    List<DynamicRVModel> items;
    int visibleThreshold = 5;
    int lastVisibleItem ,totalItem;

    public DynamicRVAdapter(RecyclerView recyclerView,
                            Activity activity,
                            List<DynamicRVModel> items){
        this.activity = activity;
        this .items = items;

        final LinearLayoutManager linearLayoutManager = (LinearLayoutManager)recyclerView.getLayoutManager();
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx , int dy) {
                super.onScrolled(recyclerView,dx,dy);

                totalItem = linearLayoutManager.getItemCount();
                lastVisibleItem = linearLayoutManager.findLastVisibleItemPosition();
                if(!isLoading && totalItem <=(lastVisibleItem+visibleThreshold)){
                    if(loadmore != null){
                        loadmore.onLoadMore();
                        isLoading = true;
                    }
                }
            }

        });
    }

    @Override
    public int getItemViewType(int position) {
        return  items.get(position) == null ? VIEW_TYPE_LOADING:VIEW_TYPE_ITEM;
    }

    public void  setLoadMore(LoadMore loadMore){
        this.loadmore =  loadMore;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        if(viewType == VIEW_TYPE_ITEM){
            View view = LayoutInflater.from(activity).inflate(R.layout.dyanamic_rv_item,parent,false);
            return new ItemViewHolder(view);
        }else if(viewType == VIEW_TYPE_LOADING){
            View view = LayoutInflater.from(activity).inflate(R.layout.dynamic_rv_progress_bar,parent,false);
            return new LoadViewHolder(view);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        if(holder instanceof  ItemViewHolder){
            DynamicRVModel item = items.get(position);
            ItemViewHolder viewHolder = (ItemViewHolder) holder;
            viewHolder.name.setText(item.getName());
            viewHolder.imageView.setImageResource(item.getImage());
        }
        else if(holder instanceof  LoadViewHolder){
            LoadViewHolder loadViewHolder = (LoadViewHolder) holder;
        }
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public  void setLoaded(){
        isLoading = false;
    }
}
