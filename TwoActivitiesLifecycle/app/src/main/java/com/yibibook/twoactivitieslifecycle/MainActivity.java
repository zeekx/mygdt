package com.yibibook.twoactivitieslifecycle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "MESSAGE";
    public static final int TEXT_REQUEST_CODE = 1;
    private TextView mReplyHeadTextView;
    private TextView mReplyTextView;
    private EditText mMessageEditText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mReplyTextView = findViewById(R.id.text_message_reply);
        mReplyHeadTextView = findViewById(R.id.text_header_reply);
        mMessageEditText = findViewById(R.id.editText_main);
        Log.d(LOG_TAG, "----------");
        Log.d(LOG_TAG, "onCreate");

        if (savedInstanceState != null) {
            if (savedInstanceState.getBoolean("reply_visible")) {
                mReplyHeadTextView.setVisibility(View.VISIBLE);
                mReplyTextView.setVisibility(View.VISIBLE);
                mReplyTextView.setText(savedInstanceState.getString("reply_text"));
                Log.d(LOG_TAG, "outState:" + savedInstanceState.getString("reply_text"));
            }
        }
    }

    public static final String LOG_TAG = MainActivity.class.getSimpleName();
    public void launchSecondActivity(View view) {
        Log.d(LOG_TAG, "Button Clicked!");
        Intent intent = new Intent(this, SecondActivity.class);
        String msg = mMessageEditText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, msg);
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
            mReplyTextView.setVisibility(View.VISIBLE);
            mReplyHeadTextView.setVisibility(View.VISIBLE);
            mReplyTextView.setText(msg);
        }
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        if (mReplyHeadTextView.getVisibility() == View.VISIBLE) {
            outState.putBoolean("reply_visible", true);
            outState.putString("reply_text", mReplyTextView.getText().toString());
            Log.d(LOG_TAG, "outState:" + outState.getString("reply_text"));
        }
        Log.d(LOG_TAG, "onSaveInstanceState");
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
