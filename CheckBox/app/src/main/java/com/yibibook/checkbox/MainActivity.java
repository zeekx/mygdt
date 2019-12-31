package com.yibibook.checkbox;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private String message = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onCheckBoxSelected(View view) {
        CheckBox checkBox = (CheckBox )view;
        String item = checkBox.getText().toString() + "/";
        if (checkBox.isChecked()) {
            message += item;
        }
    }

    private void displayToast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    public void onDisplayToast(View view) {
        displayToast(message);
    }
}
