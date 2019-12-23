package com.yibibook.twoactivitieslifecyclechallenge;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "MESSAGE";
    public static final int TEXT_REQUEST_CODE = 1;

    private List<TextView> mShoppingList;
    private int nextIndex = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final int COUNT = 10;
        mShoppingList = new ArrayList<>(COUNT);
        mShoppingList.add((TextView) findViewById(R.id.text_shopping_list_1));
        mShoppingList.add((TextView) findViewById(R.id.text_shopping_list_2));
        mShoppingList.add((TextView) findViewById(R.id.text_shopping_list_3));
        mShoppingList.add((TextView) findViewById(R.id.text_shopping_list_4));
        mShoppingList.add((TextView) findViewById(R.id.text_shopping_list_5));
        mShoppingList.add((TextView) findViewById(R.id.text_shopping_list_6));
        mShoppingList.add((TextView) findViewById(R.id.text_shopping_list_7));
        mShoppingList.add((TextView) findViewById(R.id.text_shopping_list_8));
        mShoppingList.add((TextView) findViewById(R.id.text_shopping_list_9));
        mShoppingList.add((TextView) findViewById(R.id.text_shopping_list_10));

        Log.d(LOG_TAG, "----------");
        Log.d(LOG_TAG, "onCreate");

        if (savedInstanceState != null) {
            for (int i = 0; i < mShoppingList.size(); i++) {
                String text = savedInstanceState.getString("shopping_list_" + i);
                mShoppingList.get(i).setText(text);
                Log.i(LOG_TAG, "shopping_list_" + i + ":" + text);
            }
        }
    }

    public static final String LOG_TAG = MainActivity.class.getSimpleName();
    public void launchSecondActivity(View view) {
        Log.d(LOG_TAG, "Button Clicked!");
        Intent intent = new Intent(this, SecondActivity.class);
        startActivityForResult(intent, TEXT_REQUEST_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode != RESULT_OK) {
            return;
        }

        if (requestCode == TEXT_REQUEST_CODE) {
            String msg = data.getStringExtra(SecondActivity.EXTRA_REPLY);
           if (nextIndex < mShoppingList.size()) {
               mShoppingList.get(nextIndex).setText(msg);
               nextIndex++;
           }
        }
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        for (int i = 0; i < mShoppingList.size(); i++) {
            outState.putString("shopping_list_" + i, mShoppingList.get(i).getText().toString());
            Log.i(LOG_TAG, "shopping_list_" + i + ":" + mShoppingList.get(i).getText().toString());
        }
        Log.i(LOG_TAG, "onSaveInstanceState");
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


}
