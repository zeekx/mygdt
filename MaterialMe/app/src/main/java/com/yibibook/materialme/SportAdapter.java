package com.yibibook.materialme;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

import static com.yibibook.materialme.DetailActivity.SHARED_TRANSITION_SPORT_IMAGE;
import static com.yibibook.materialme.DetailActivity.SHARED_TRANSITION_SPORT_TITLE;


public class SportAdapter extends RecyclerView.Adapter<SportAdapter.ItemHolder> {
    private List<Sport> mSports;
    private Context mContext;

    SportAdapter(Context context, List<Sport> sports) {
        mSports = sports;
        mContext = context;
    }

    @NonNull
    @Override
    public ItemHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View item = LayoutInflater.from(mContext).inflate(R.layout.item_sport, parent, false);
        return new ItemHolder(item);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemHolder holder, int position) {
        holder.bindWith(mSports.get(position));
    }

    @Override
    public int getItemCount() {
        int count = mSports == null ? 0 : mSports.size();
        Log.d("sis", "getItemCount" + count);
        return count;
    }

    class ItemHolder extends RecyclerView.ViewHolder {

        private TextView tvTitle;
        private TextView tvInfo;
        private ImageView ivDetailImageView;

        public ItemHolder(@NonNull View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.title);
            tvInfo = itemView.findViewById(R.id.subTitle);
            ivDetailImageView = itemView.findViewById(R.id.sportsImage);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Sport sport = mSports.get(getAdapterPosition());
                    Intent intent = new Intent(mContext, DetailActivity.class);
                    intent.putExtra(DetailActivity.EXTRA_TITLE, sport.getTitle());
                    intent.putExtra(DetailActivity.EXTRA_IMAGE_RESOURCE, sport.getImageResource());
                    intent.putExtra(DetailActivity.EXTRA_INFO, sport.getInfo());
                    ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation((Activity) mContext,
                            Pair.create((View)ivDetailImageView, SHARED_TRANSITION_SPORT_IMAGE),
                            Pair.create((View)tvTitle, SHARED_TRANSITION_SPORT_TITLE));
                    mContext.startActivity(intent, options.toBundle());
                }
            });
        }

        public void bindWith(Sport sport) {
            tvTitle.setText(sport.getTitle());
            tvInfo.setText(sport.getInfo());
            Glide.with(mContext).load(sport.getImageResource()).into(ivDetailImageView);
        }
    }
}
