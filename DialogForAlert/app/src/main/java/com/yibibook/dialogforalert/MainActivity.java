package com.yibibook.dialogforalert;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickShowAlter(View view) {
        AlertDialog.Builder myDialogBuilder = new AlertDialog.Builder(this);
        myDialogBuilder.setTitle(getString(R.string.alert_title));
        myDialogBuilder.setMessage(getString(R.string.alert_message));
        myDialogBuilder.setPositiveButton(R.string.alert_ok, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, "Press OK", Toast.LENGTH_SHORT).show();
            }
        });

        myDialogBuilder.setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, "Press CANCEL", Toast.LENGTH_SHORT).show();
            }
        });
        myDialogBuilder.show();
    }
}
