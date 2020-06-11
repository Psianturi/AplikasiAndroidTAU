package me.posmajanius.advancemobileprogramming_uts;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.SimpleTarget;

import me.posmajanius.advancemobileprogramming_uts.one.OneModel;
import me.posmajanius.advancemobileprogramming_uts.two.TwoModel;

public class DetailActivity extends AppCompatActivity {

    TextView tv_nameDetail;
    TextView tv_dateDetail;
    TextView tv_rateDetail;
    TextView tv_descDetail;
    ImageView iv_photoDetail;

    //@BindView(R.id.txt_title_detail_tv) TextView tv_nameDetail;
    //@BindView(R.id.textview_graduate) TextView tv_dateDetail;
    //@BindView(R.id.txt_scoreAngkaDetail_tv) TextView tv_rateDetail;
    //@BindView(R.id.txt_overviewDetail_tv) TextView tv_descDetail;
    //@BindView(R.id.poster_detail_tv) ImageView iv_photoDetail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        tv_nameDetail = findViewById(R.id.txt_title_detail_tv);
        tv_dateDetail = findViewById(R.id.textview_graduate);
        tv_rateDetail = findViewById(R.id.txt_scoreAngkaDetail_tv);
        tv_descDetail = findViewById(R.id.txt_overviewDetail_tv);
        iv_photoDetail = findViewById(R.id.poster_detail_tv);

        // Progress Bar Declaration
        // Progress Bar Variable Declaration
        ProgressBar progressBar = findViewById(R.id.progressBar_detailMovie_tv);
        progressBar.bringToFront();
        progressBar.setVisibility(View.GONE);

        //ButterKnife.bind(this);

        Bundle extras = getIntent().getExtras();
        if (extras!=null){
            OneModel oneModel = extras.getParcelable("object");
            TwoModel twoModel = extras.getParcelable("object2");
            if (twoModel !=null){
                Glide.with(this).load(twoModel.getPhotoTwo()).into(new SimpleTarget<Drawable>() {
                    @Override
                    public void onResourceReady(@NonNull Drawable resource, @Nullable com.bumptech.glide.request.transition.Transition<? super Drawable> transition) {
                        iv_photoDetail.setBackground(resource);
                    }
                });
                tv_nameDetail.setText(twoModel.getNameTwo());
                //tv_dateDetail.setText(twoModel.getPlaceTwo());
                tv_rateDetail.setText(twoModel.getCityTwo());
                tv_descDetail.setText(twoModel.getDescriptionTwo());
            }
           else if (oneModel !=null){
                Glide.with(this).load(oneModel.getPhotoOne()).into(new SimpleTarget<Drawable>() {
                    @Override
                    public void onResourceReady(@NonNull Drawable resource, @Nullable com.bumptech.glide.request.transition.Transition<? super Drawable> transition) {
                        iv_photoDetail.setBackground(resource);
                    }
                });
                tv_nameDetail.setText(oneModel.getNameOne());
                tv_dateDetail.setText(oneModel.getPlaceOne());
                //tv_rateDetail.setText(oneModel.getCityOne());
                tv_descDetail.setText(oneModel.getDescriptionOne());
            }

            ImageButton btnBack = findViewById(R.id.btn_back_tv);
            btnBack.setOnClickListener(v -> {
                finish();
                overridePendingTransition(R.anim.no_animation, R.anim.slide_down);
            });

    }
}
}
