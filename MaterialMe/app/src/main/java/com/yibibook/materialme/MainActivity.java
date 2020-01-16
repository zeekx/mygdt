package com.yibibook.materialme;

import android.content.res.TypedArray;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.ItemTouchUIUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.PersistableBundle;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private static final String KEY_SPORTS_DATA = "com.yibibook.materialme.soprts.data_key";

    private ArrayList<Sport> mSportData = new ArrayList<>();
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
                initializeData(null);
                mAdapter.notifyDataSetChanged();
            }
        });
        mRecyclerView = findViewById(R.id.recycler_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mAdapter = new SportAdapter(this, mSportData);
        mRecyclerView.setAdapter(mAdapter);

        initializeData(savedInstanceState);


        ItemTouchHelper helper = new ItemTouchHelper(
                new ItemTouchHelper.SimpleCallback(
                        ItemTouchHelper.UP
                        | ItemTouchHelper.DOWN,

                ItemTouchHelper.LEFT
                        | ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView,
                                  @NonNull RecyclerView.ViewHolder viewHolder,
                                  @NonNull RecyclerView.ViewHolder target) {
                int from = viewHolder.getAdapterPosition();
                int to = target.getAdapterPosition();
                Collections.swap(mSportData, from, to);
                mAdapter.notifyItemMoved(from, to);
                return true;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                final int position = viewHolder.getAdapterPosition();
                mSportData.remove(position);
                mAdapter.notifyItemRemoved(position);
            }
        });
        helper.attachToRecyclerView(mRecyclerView);

        mAdapter.notifyDataSetChanged();
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        outState.putParcelableArrayList(KEY_SPORTS_DATA, mSportData);
        super.onSaveInstanceState(outState);
    }


    private void initializeData(Bundle savedInstanceState) {
        mSportData.clear();
        if (savedInstanceState != null && savedInstanceState.containsKey(KEY_SPORTS_DATA)) {
            ArrayList<Sport> sports = savedInstanceState.getParcelableArrayList(KEY_SPORTS_DATA);
            mSportData.addAll(sports);
            Log.d("sis", "inner mSportData.size:" + mSportData.size());
            return;
        }
        String[] sportTitles = getResources().getStringArray(R.array.sports_titles);
        String[] sportInfos = getResources().getStringArray(R.array.sports_info);
        TypedArray sportImageRes = getResources().obtainTypedArray(R.array.sports_images);

        assert sportTitles.length == sportInfos.length && sportInfos.length == sportImageRes.length() : "length";


        for (int i = 0; i < sportTitles.length; i++) {
            mSportData.add( new Sport(sportTitles[i],
                    sportInfos[i],
                    sportImageRes.getResourceId(i, 0)));
        }
        sportImageRes.recycle();
        Log.d("sis", "mSportData.size:" + mSportData.size());
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
