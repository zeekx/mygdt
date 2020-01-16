package com.yibibook.transitionwithanimations;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

public class MainActivity extends AnimatedActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize the views.
        ImageView redBlock = findViewById(R.id.redBlock);
        ImageView blueBlock = findViewById(R.id.blueBlock);
        ImageView yellowBlock = findViewById(R.id.yellowBlock);
        ImageView androidBlock = findViewById(R.id.androidBlock);

        explodeAnimation(this, redBlock);
        slideAnimation(this, blueBlock);
        switchAnimation(androidBlock,
                        blueBlock,
                        new Intent(this,SecondaryActivity.class),
                        this);
        rotateAnimation(yellowBlock);
    }
}
