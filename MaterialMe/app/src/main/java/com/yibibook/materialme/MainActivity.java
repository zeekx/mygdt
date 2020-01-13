package com.yibibook.materialme;

import android.content.res.TypedArray;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Sport> mSportData = new ArrayList<>();
    private RecyclerView mRecyclerView;
    private SportAdapter mAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                initializeData();
                mAdapter.notifyDataSetChanged();
            }
        });
        mRecyclerView = findViewById(R.id.recycler_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mAdapter = new SportAdapter(this, mSportData);
        mRecyclerView.setAdapter(mAdapter);

        initializeData();
        mAdapter.notifyDataSetChanged();

    }

    private void initializeData() {
        String[] sportTitles = getResources().getStringArray(R.array.sports_titles);
        String[] sportInfos = getResources().getStringArray(R.array.sports_info);
        TypedArray sportImageRes = getResources().obtainTypedArray(R.array.sports_images);

        assert sportTitles.length == sportInfos.length && sportInfos.length == sportImageRes.length() : "length";

        mSportData.clear();
        for (int i = 0; i < sportTitles.length; i++) {
            mSportData.add( new Sport(sportTitles[i],
                    sportInfos[i],
                    sportImageRes.getResourceId(i, 0)));
        }
        sportImageRes.recycle();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
