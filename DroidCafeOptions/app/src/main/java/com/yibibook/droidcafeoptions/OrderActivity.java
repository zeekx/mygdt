package com.yibibook.droidcafeoptions;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;


public class OrderActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    public static final String TAG = OrderActivity.class.getSimpleName();
    private static final String DEFAULT_SELECTED_RADIO_BUTTON_KEY = "default selected radio button";
    private RadioGroup radioGroup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        String msg = "You order: " + getIntent().getStringExtra(MainActivity.EXTRA_MESSAGE);
        TextView textView = findViewById(R.id.order_msg_textview);
        textView.setText(msg);
        radioGroup = findViewById(R.id.delivery_radio_group);
        int idOfRadioButton = R.id.sameday;
        if (savedInstanceState != null) {
            idOfRadioButton = savedInstanceState.getInt(DEFAULT_SELECTED_RADIO_BUTTON_KEY);
        }
        RadioButton rb = findViewById(idOfRadioButton);
        rb.setChecked(true);

        Spinner spinner = findViewById(R.id.label_spinner);
        spinner.setOnItemSelectedListener(this);

        ArrayAdapter<CharSequence> arrayAdapter = ArrayAdapter.createFromResource(this,
                R.array.labels_array, android.R.layout.simple_spinner_item);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(arrayAdapter);
    }


    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(DEFAULT_SELECTED_RADIO_BUTTON_KEY, radioGroup.getCheckedRadioButtonId());
    }

    public void onRadioButtonClicked(View view) {
        String msg = null;
        boolean isChecked = ((RadioButton) view).isChecked();
        switch (view.getId()) {
            case R.id.sameday:
                msg = getString(R.string.same_day_messenger_service);
                break;

            case R.id.nextday:
                msg = getString(R.string.next_day_ground_delivery);
                break;

            case R.id.pickup:
                if (isChecked) {
                    msg = getString(R.string.pick_up);
                }
                break;

            default:
                break;
        }
        if (!TextUtils.isEmpty(msg)) {
            displayToast(msg);
        }
    }

    private void displayToast(String msg) {
        Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        displayToast(parent.getItemAtPosition(position).toString());
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    public void onPickDate(View view) {
        DatePickerFragment fragment = new DatePickerFragment();
        fragment.show(getSupportFragmentManager(), "DatePicker");
    }

}
