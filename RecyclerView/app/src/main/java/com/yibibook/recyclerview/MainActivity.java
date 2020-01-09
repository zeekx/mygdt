package com.yibibook.recyclerview;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private static int WORD_SIZE = 20000 * 10;
    private List<String> mWordList = new ArrayList<>(WORD_SIZE * 2 + 1);
    private RecyclerView mRecyclerView;
    private WordListAdapter mAdapter;
    private List<String> mOriginalWordList;

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
              int size = mWordList.size();
              mWordList.add("+ word " + size);
              mRecyclerView.getAdapter().notifyItemInserted(size);
//              mRecyclerView.smoothScrollToPosition(size);
                mRecyclerView.scrollToPosition(size);
            }
        });

        for (int i = 0; i < WORD_SIZE; i++) {
            mWordList.add("word" + i);
        }

        mOriginalWordList = new ArrayList<>();
        mOriginalWordList.addAll(mWordList);

        mAdapter = new WordListAdapter(this, mWordList);
        mRecyclerView = findViewById(R.id.recycler_view);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.addOnItemTouchListener(mAdapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
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
        if (id == R.id.action_reset) {
            mWordList.clear();
            mWordList.addAll(mOriginalWordList);
            mRecyclerView.getAdapter().notifyDataSetChanged();
            Log.d("rreset", "original size " + mOriginalWordList.size() + "word list " + mWordList.size());
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
