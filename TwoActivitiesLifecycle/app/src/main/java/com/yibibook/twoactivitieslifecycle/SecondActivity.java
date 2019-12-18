package com.yibibook.twoactivitieslifecycle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    public static final String EXTRA_REPLY = "SecondActivity.extra.REPLY";
    private static final String LOG_TAG = SecondActivity.class.getSimpleName();
    private TextView mMessageTextView;
    private EditText mReplyEditText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        mMessageTextView = findViewById(R.id.text_message);
        mReplyEditText = findViewById(R.id.editText_second);

        String msg = getIntent().getStringExtra(MainActivity.EXTRA_MESSAGE);
        mMessageTextView.setText(msg);
        Log.d(LOG_TAG, "++++++");
        Log.d(LOG_TAG, "onCreate");
    }


    public void returnReply(View view) {
        String msg = mReplyEditText.getText().toString();
        Intent replyIntent = new Intent();
        replyIntent.putExtra(EXTRA_REPLY, msg);
        setResult(RESULT_OK, replyIntent);
        finish();
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
