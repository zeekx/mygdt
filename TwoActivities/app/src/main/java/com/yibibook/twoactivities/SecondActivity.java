package com.yibibook.twoactivities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    public static final String EXTRA_REPLY = "com.yibibook.twoactivities.SecondActivity.extra.REPLY";
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
    }


    public void returnReply(View view) {
        String msg = mReplyEditText.getText().toString();
        Intent replyIntent = new Intent();
        replyIntent.putExtra(EXTRA_REPLY, msg);
        setResult(RESULT_OK, replyIntent);
        finish();
    }
}
