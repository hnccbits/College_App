package bitsindri.hncc.collegeapp.Adapters;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import bitsindri.hncc.collegeapp.GetterAndSetter.internshipsAndJobs;
import bitsindri.hncc.collegeapp.GetterAndSetter.marketplace;
import bitsindri.hncc.collegeapp.R;

public class InternshipsAndJobsAdapter extends RecyclerView.Adapter {

    private final Context mContext ;
    private final ArrayList<internshipsAndJobs> internshipsAndJobsList ;

    public InternshipsAndJobsAdapter(Context mContext, ArrayList<internshipsAndJobs> internshipsAndJobsList) {
        this.mContext = mContext;
        this.internshipsAndJobsList = internshipsAndJobsList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        LayoutInflater mInflater = LayoutInflater.from(mContext);
        view = mInflater.inflate(R.layout.each_internship_or_job,parent,false);
        return new InternshipsAndJobsHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        InternshipsAndJobsAdapter.InternshipsAndJobsHolder InternshipsAndJobsHolder = (InternshipsAndJobsAdapter.InternshipsAndJobsHolder)holder;
        InternshipsAndJobsHolder.title.setText(internshipsAndJobsList.get(position).getTitle());

        InternshipsAndJobsHolder.description.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mContext.startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(internshipsAndJobsList.get(position).getUrl())));
            }
        });
    }

    @Override
    public int getItemCount() {
        return internshipsAndJobsList == null? 0: internshipsAndJobsList.size();
    }

    public static class InternshipsAndJobsHolder extends RecyclerView.ViewHolder {

        TextView title;
        Button description;

        public InternshipsAndJobsHolder(View itemView) {
            super(itemView);

            title = itemView.findViewById(R.id.internship_an_jobs_title);
            description = itemView.findViewById(R.id.internship_an_jobs_description);

        }
    }

}
