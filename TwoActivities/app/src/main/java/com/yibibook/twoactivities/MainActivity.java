package com.yibibook.twoactivities;

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
    private TextView mMessageTextView;
    private TextView mHeaderReply;
    private EditText mMessageEditText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mHeaderReply = findViewById(R.id.text_header_reply);
        mMessageTextView = findViewById(R.id.textView_msg);
        mMessageEditText = findViewById(R.id.editText_main);
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
            mHeaderReply.setVisibility(View.VISIBLE);
            mMessageTextView.setVisibility(View.VISIBLE);
            mMessageTextView.setText(msg);
        }
    }
}
