package com.yibibook.materialme;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class DetailActivity extends AppCompatActivity {
    public static final String EXTRA_TITLE = "com.yibibook.materialme.detailactivity.title";
    public static final String EXTRA_IMAGE_RESOURCE = "com.yibibook.materialme.detailactivity.imageresource";
    public static final String EXTRA_INFO = "com.yibibook.materialme.detailactivity.info";

    public static final String SHARED_TRANSITION_SPORT_IMAGE = "sportImage";
    public static final String SHARED_TRANSITION_SPORT_TITLE = "sportTitle";

    private String mTitle;
    private String mInfo;
    private int mImageRes;


    private TextView mTitleView;
    private TextView mSubtitleDetailView;
    private ImageView mImageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        mImageView = findViewById(R.id.sportsImageDetail);
        mTitleView = findViewById(R.id.titleDetail);
        mSubtitleDetailView = findViewById(R.id.subTitleDetail);

        Intent intent = getIntent();
        mTitle = intent.getStringExtra(EXTRA_TITLE);
        mInfo = intent.getStringExtra(EXTRA_INFO);
        mImageRes = intent.getIntExtra(EXTRA_IMAGE_RESOURCE, 0);
        Log.d("ttt", "mTitle:" + mTitle + " img res:" + mImageRes);

        Glide.with(this).load(mImageRes).into(mImageView);
        mTitleView.setText(mTitle);
        mSubtitleDetailView.setText(mInfo);
    }

}
