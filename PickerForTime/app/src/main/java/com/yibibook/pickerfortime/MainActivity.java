package com.yibibook.pickerfortime;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void processTimePickerResult(int hourOfDay, int minute) {
        Toast.makeText(this,
                "Time " + hourOfDay + ":" + minute,
                Toast.LENGTH_SHORT).show();
    }

    public void onClickPickTime(View view) {
        TimePickerFragment fragment = new TimePickerFragment();
        fragment.show(getSupportFragmentManager(), "TimePicker");
    }
}
