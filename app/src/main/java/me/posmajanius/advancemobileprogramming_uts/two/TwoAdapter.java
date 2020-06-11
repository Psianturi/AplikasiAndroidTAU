package me.posmajanius.advancemobileprogramming_uts.two;

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


public class TwoAdapter extends RecyclerView.Adapter<TwoAdapter.ViewHolder> {
    private ArrayList<TwoModel> twoModels;
    Context context;

    public TwoAdapter(Context context, ArrayList<TwoModel> twoModels){
        this.twoModels = twoModels;
        this.context = context;

}

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_two, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        holder.tvDays2.setText(twoModels.get(position).getNameTwo());
        holder.tvPlace2.setText(twoModels.get(position).getPlaceTwo());
        holder.tvCity2.setText(twoModels.get(position).getCityTwo());
        //Glide.with(context).load(twoModels.get(position).getBackdropTwo()).into(holder.ivBackdrop2);
        Glide.with(context).load(twoModels.get(position).getPhotoTwo()).into(holder.ivPhoto2);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TwoModel twoModel = new TwoModel();
                twoModel.setPhotoTwo(twoModels.get(position).getPhotoTwo());
                twoModel.setNameTwo(twoModels.get(position).getNameTwo());
                twoModel.setPlaceTwo(twoModels.get(position).getPlaceTwo());
                twoModel.setCityTwo(twoModels.get(position).getCityTwo());
                twoModel.setDescriptionTwo(twoModels.get(position).getDescriptionTwo());
                Intent intent = new Intent(context, DetailActivity.class);
                intent.putExtra("object2", twoModel);
                context.startActivity(intent);

            }
        });
    }

    @Override
    public int getItemCount() {
        return twoModels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        //private ImageView ivBackdrop2;
        private ImageView ivPhoto2;
        private TextView tvDays2;
        private TextView tvPlace2;
        private TextView tvCity2;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ivPhoto2 = itemView.findViewById(R.id.iv_photoListTv);
            //ivBackdrop2 = itemView.findViewById(R.id.poster_banner_tv)
            tvDays2 = itemView.findViewById(R.id.tv_nameTv);
            tvPlace2 = itemView.findViewById(R.id.tv_dateTv);
            tvCity2 = itemView.findViewById(R.id.tv_rateTv);
        }
    }
}



