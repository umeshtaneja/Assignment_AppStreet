package com.example.top_github.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.top_github.R;
import com.example.top_github.service.model.RepoDetails;
import com.jakewharton.picasso.OkHttp3Downloader;
import com.squareup.picasso.Picasso;

import java.util.List;

public class RepoDetailsAdapter extends RecyclerView.Adapter<RepoDetailsAdapter.CustomViewHolder> {

    private List<RepoDetails> repoDetailsList;
    private Context context;
    private OnItemClickListener onItemClickListener;


    public RepoDetailsAdapter(Context context, List<RepoDetails> repoDetailsList) {
        this.context = context;
        this.repoDetailsList = repoDetailsList;
        this.onItemClickListener = (OnItemClickListener) context;
    }

    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.custom_reop_item, parent, false);
        return new CustomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, final int position) {
        holder.tvRepoName.setText(repoDetailsList.get(position).getRepo().getName());
        holder.tvUserName.setText(repoDetailsList.get(position).getUserName());

        Picasso.Builder builder = new Picasso.Builder(context);
        builder.downloader(new OkHttp3Downloader(context));
        builder.build().load(repoDetailsList.get(position).getThumbnailUrl())
                .placeholder((R.drawable.ic_launcher_background))
                .error(R.drawable.ic_launcher_background)
                .into(holder.userImage);

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClickListener.onItemClick(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return repoDetailsList.size();
    }


    class CustomViewHolder extends RecyclerView.ViewHolder {

        final View mView;

        private CardView cardView;
        TextView tvRepoName, tvUserName;
        private ImageView userImage;

        CustomViewHolder(View itemView) {
            super(itemView);
            mView = itemView;

            cardView = mView.findViewById(R.id.cvRoot);
            tvRepoName = mView.findViewById(R.id.tvRepoName);
            tvUserName = mView.findViewById(R.id.tvUserName);
            userImage = mView.findViewById(R.id.imgUser);
        }
    }
}
