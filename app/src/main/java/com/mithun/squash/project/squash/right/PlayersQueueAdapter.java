package com.mithun.squash.project.squash.right;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.mithun.squash.project.squash.R;
import com.mithun.squash.project.squash.PlayerInfoModel;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by mithun on 9/20/15.
 */
public class PlayersQueueAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    List<PlayerInfoModel> playerInfoList;

    PlayersQueueAdapter(Context context) {
        this.context = context;
        if (playerInfoList == null) {
            playerInfoList = new ArrayList<PlayerInfoModel>();
        }

        addData();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v;
        RecyclerView.ViewHolder holder = null;
        v = LayoutInflater.from(parent.getContext()).inflate(R.layout.player_info_item, parent, false);
        holder = new PlayerInfoViewHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        PlayerInfoModel item = playerInfoList.get(position);
        loadPlayerInfoCard(item, (PlayerInfoViewHolder) holder);
    }

    void loadPlayerInfoCard(PlayerInfoModel item, PlayerInfoViewHolder holder) {
        File imgFile = new File(item.photo_path);
        if (imgFile.exists()) {
            Bitmap thumbBitmap = BitmapFactory.decodeFile(imgFile.getAbsolutePath());
            holder.photoThumbnail.setImageBitmap(thumbBitmap);
        } else {
            holder.photoThumbnail.setImageResource(R.drawable.photo);
        }
        holder.name.setText(item.name);
    }

    @Override
    public int getItemCount() {
        return playerInfoList.size();
    }

    public void onItemDismiss(int adapterPosition) {
        playerInfoList.remove(adapterPosition);
        notifyItemRemoved(adapterPosition);
    }


    public class PlayerInfoViewHolder extends RecyclerView.ViewHolder {
        ImageView photoThumbnail;
        TextView name;


        PlayerInfoViewHolder(View itemView) {
            super(itemView);

            photoThumbnail = (ImageView) itemView.findViewById(R.id.player_thumbnail);
            name = (TextView) itemView.findViewById(R.id.player_name);
        }


    }


    void addData() {

        for (int i = 1; i < 10; i++) {
            PlayerInfoModel item = new PlayerInfoModel("Name " + i);
            playerInfoList.add(item);
        }

    }
}
