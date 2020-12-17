package bitsindri.hncc.collegeapp.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import bitsindri.hncc.collegeapp.Custom_Classes.Data;
import bitsindri.hncc.collegeapp.Custom_Classes.PDFModel;
import bitsindri.hncc.collegeapp.Interfaces.ItemClickListener;
import bitsindri.hncc.collegeapp.R;

public class PDFAdapter extends RecyclerView.Adapter<PDFAdapter.Holder> {

//    private List<PDFModel> list;
private List<Data> list;
    private Context context;
    ItemClickListener itemClickListener;

//    public PDFAdapter(List<PDFModel> list, Context context, ItemClickListener itemClickListener) {
//        this.list = list;
//        this.context = context;
//        this.itemClickListener = itemClickListener;
//    }
    public PDFAdapter(List<Data> list, Context context, ItemClickListener itemClickListener) {
        this.list = list;
        this.context = context;
        this.itemClickListener = itemClickListener;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.viewholder_study_resources,parent,false);
        Holder holder = new Holder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {

  //      holder.pdfName.setText(list.get(position).getPdfName());
        holder.sem.setText((list.get(position).getSem()));
        holder.branch.setText((list.get(position).getBranch()));
        holder.sub.setText((list.get(position).getSub()));

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class Holder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView pdfName,branch,sem,sub;
        private ImageView imageView;
        private Button read;

        public Holder(View itemView) {
            super(itemView);
            pdfName = itemView.findViewById(R.id.TV_title);
            imageView = itemView.findViewById(R.id.IV);
            sem=itemView.findViewById(R.id.TV_sem);
            branch=itemView.findViewById(R.id.TV_branch);
            sub=itemView.findViewById(R.id.TV_sub);
            read=itemView.findViewById(R.id.download);



//            imageView.setOnClickListener(this);
            read.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            itemClickListener.onClick(v,getAdapterPosition(),false);
        }
    }
}
