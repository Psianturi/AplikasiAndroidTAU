package me.posmajanius.advancemobileprogramming_uts.one;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import me.posmajanius.advancemobileprogramming_uts.DetailActivity;
import me.posmajanius.advancemobileprogramming_uts.R;


public class OneAdapter extends RecyclerView.Adapter<OneAdapter.ViewHolder> {

    Context context;
    private ArrayList<OneModel> oneModels;

    public OneAdapter(Context context, ArrayList<OneModel> oneModels) {
        this.context = context;
        this.oneModels = oneModels;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_one, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull OneAdapter.ViewHolder holder, final int position) {
        holder.tvDays.setText(oneModels.get(position).getNameOne());
        holder.tvPlace.setText(oneModels.get(position).getPlaceOne());
        //holder.tvCity.setText(oneModels.get(position).getCityOne());
        Glide.with(context).load(oneModels.get(position).getPhotoOne()).into(holder.ivPhoto);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                OneModel oneModel = new OneModel();
                oneModel.setPhotoOne(oneModels.get(position).getPhotoOne());
                oneModel.setNameOne(oneModels.get(position).getNameOne());
                oneModel.setPlaceOne(oneModels.get(position).getPlaceOne());
                //oneModel.setCityOne(oneModels.get(position).getCityOne());
                oneModel.setDescriptionOne(oneModels.get(position).getDescriptionOne());
                Intent intent = new Intent(context, DetailActivity.class);
                intent.putExtra("object", oneModel);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return oneModels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView ivPhoto;
        private TextView tvDays;
        private TextView tvPlace;
        //private TextView tvCity;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ivPhoto = itemView.findViewById(R.id.iv_photoListMovie);
            tvDays = itemView.findViewById(R.id.tv_nameMovie);
            tvPlace = itemView.findViewById(R.id.tv_dateMovie);
            //tvCity = itemView.findViewById(R.id.tv_rateMovie);
        }
    }
}

