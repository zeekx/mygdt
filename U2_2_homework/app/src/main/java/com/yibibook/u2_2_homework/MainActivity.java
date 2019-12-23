package com.yibibook.u2_2_homework;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public static final String TAG = MainActivity.class.getSimpleName();
    private TextView mScoreTextView;
    private EditText mScoreEditor;

    static class WidgetState {

        int score;
        public static String getKeyOfScore() {
            return "score";
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mScoreEditor = findViewById(R.id.score_editor);
        mScoreTextView = findViewById(R.id.score_text);
        if (savedInstanceState != null) {
            String scoreString = String.valueOf(savedInstanceState.getInt(WidgetState.getKeyOfScore()));
            mScoreTextView.setText(scoreString);
        }
        Log.d(TAG, "onCreate");
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.d(TAG, "onRestoreInstanceState");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "onRestart");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume");
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(WidgetState.getKeyOfScore(), Integer.parseInt(mScoreTextView.getText().toString()));
        Log.d(TAG, "onSaveInstanceState");
    }

    public void incrementScore(View view) {
        int score = Integer.parseInt(mScoreTextView.getText().toString());
        mScoreTextView.setText(String.valueOf(score + 1));
    }
}
