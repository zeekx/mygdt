package com.yibibook.materialme;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {
    public static String EXTRA_TITLE = "com.yibibook.materialme.detailactivity.title";
    public static String EXTRA_IMAGE_RESOURCE = "com.yibibook.materialme.detailactivity.imageresource";


    private String mTitle;
    private int mImageRes;


    private TextView mTitleView;
    private ImageView mImageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        mTitleView = findViewById(R.id.titleDetail);
        mImageView = findViewById(R.id.sportsImageDetail);

        Intent intent = getIntent();
        mTitle = intent.getStringExtra(EXTRA_TITLE);
        mImageRes = intent.getIntExtra(EXTRA_IMAGE_RESOURCE, 0);

        mTitleView.setText(mTitle);
        mImageView.setImageResource(mImageRes);
    }

}
