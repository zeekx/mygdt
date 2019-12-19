package com.yibibook.twoactivitieslifecyclechallenge;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class SecondActivity extends AppCompatActivity {

    public static final String EXTRA_REPLY = "SecondActivity.extra.REPLY";
    private static final String LOG_TAG = SecondActivity.class.getSimpleName();
    private List<Button> mFruits;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        final int COUNT = 3;
        mFruits =  new ArrayList<>(COUNT);
        mFruits.add((Button) findViewById(R.id.button_fruit_1));
        mFruits.add((Button) findViewById(R.id.button_fruit_2));
        mFruits.add((Button) findViewById(R.id.button_fruit_3));

        String msg = getIntent().getStringExtra(MainActivity.EXTRA_MESSAGE);
        Log.d(LOG_TAG, "++++++");
        Log.d(LOG_TAG, "onCreate");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(LOG_TAG, "onStart");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(LOG_TAG, "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(LOG_TAG, "onDestroy");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(LOG_TAG, "onPause");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(LOG_TAG, "onResume");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(LOG_TAG, "onRestart");
    }

    public void selectItem(View view) {
        if (!(view instanceof Button)) {
            return;
        }
        Button button = (Button) view;
        String msg = button.getText().toString();
        Intent replyIntent = new Intent();
        replyIntent.putExtra(EXTRA_REPLY, msg);
        setResult(RESULT_OK, replyIntent);
        finish();
    }
}
