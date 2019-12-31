package com.yibibook.u2inputchallenge2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText phoneEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        phoneEditText = findViewById(R.id.phone_text);
        phoneEditText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_SEND) {
                    dialNumber();
                }
                return false;
            }
        });
    }

    private void dialNumber() {
        String number = "tel: " + phoneEditText.getText().toString();
        Intent implicitIntent = new Intent(Intent.ACTION_DIAL);
        implicitIntent.setData(Uri.parse(number));
        if (implicitIntent.resolveActivity(getPackageManager()) != null) {
            startActivity(implicitIntent);
        } else {

        }
    }
}
