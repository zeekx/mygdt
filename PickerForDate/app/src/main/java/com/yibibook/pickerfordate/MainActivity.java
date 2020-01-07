package com.yibibook.pickerfordate;

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

    public void onClickShowDatePicker(View view) {
        DatePickerFragment fragment = new DatePickerFragment();
        fragment.show(getSupportFragmentManager(), getString(R.string.date_pick_fragment_show_tag));
    }

    public void processDatePickerResult(int y, int m, int d) {
        Toast.makeText(this, "Date:" + y + "/" + m+1 + "/" + d, Toast.LENGTH_SHORT)
                .show();
    }
}
