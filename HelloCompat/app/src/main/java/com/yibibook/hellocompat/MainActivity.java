package com.yibibook.hellocompat;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private TextView mHelloTextView;
    // array of color names, these match the color resources in color.xml
    private String[] mColorArray = {"red", "pink", "purple", "deep_purple",
            "indigo", "blue", "light_blue", "cyan", "teal", "green",
            "light_green", "lime", "yellow", "amber", "orange", "deep_orange",
            "brown", "grey", "blue_grey", "black" };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mHelloTextView = findViewById(R.id.hello_text_view);
        if (savedInstanceState != null) {
            int color = savedInstanceState.getInt("color");
            mHelloTextView.setTextColor(color);
        }
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("color", mHelloTextView.getCurrentTextColor());
    }

    private Random random = new Random();

    public void changeColor(View view) {
        int index = random.nextInt(mColorArray.length);
        String colorName = mColorArray[index];
        int colorResName = getResources().getIdentifier(colorName, "color", getApplicationContext().getPackageName());
        mHelloTextView.setTextColor(ContextCompat.getColor(this, colorResName));
    }
}
