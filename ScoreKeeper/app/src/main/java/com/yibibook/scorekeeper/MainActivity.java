package com.yibibook.scorekeeper;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private int mScore1;
    private int mScore2;

    private TextView mScoreText1;
    private TextView mScoreText2;

    public static String STATE_SCORE_1 = "Team 1 score";
    public static String STATE_SCORE_2 = "Team 2 score";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mScoreText1 = findViewById(R.id.score_team_1);
        mScoreText2 = findViewById(R.id.score_team_2);


        if (savedInstanceState != null) {
            mScore1 = savedInstanceState.getInt(STATE_SCORE_1);
            mScore2 = savedInstanceState.getInt(STATE_SCORE_2);
        }
        mScoreText1.setText(String.valueOf(mScore1));
        mScoreText2.setText(String.valueOf(mScore2));

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
      //TODO: Get the night mode state of the app.
        int mode = AppCompatDelegate.getDefaultNightMode();
        if (mode == AppCompatDelegate.MODE_NIGHT_YES) {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        } else {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
        }

        recreate();

        return true;
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        outState.putInt(STATE_SCORE_1, mScore1);
        outState.putInt(STATE_SCORE_2, mScore2);
        super.onSaveInstanceState(outState);
    }

    public void decreaseScore(View view) {
        switch (view.getId()) {
            case R.id.decrease_team_1:
                mScoreText1.setText(String.valueOf(--mScore1));
                break;

            case R.id.decrease_team_2:
                mScoreText2.setText(String.valueOf(--mScore2));
                break;

            default:
                break;
        }
    }

    public void increaseScore(View view) {
        switch (view.getId()) {
            case R.id.increase_team_1:
                mScoreText1.setText(String.valueOf(++mScore1));
                break;
            case R.id.increase_team_2:
                mScoreText2.setText(String.valueOf(++mScore2));
                break;

            default:
                break;
        }
    }
}
