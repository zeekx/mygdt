package com.yibibook.recyclerview;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class WordListAdapter extends RecyclerView.Adapter<WordListAdapter.WordViewHolder>
    implements RecyclerView.OnItemTouchListener {
    private List<String> mWordList;

    private LayoutInflater mInflater;

    public WordListAdapter(Context context, List<String> wordList) {
        super();
        mInflater = LayoutInflater.from(context);
        mWordList = wordList;
    }

    @NonNull
    @Override
    public WordViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = mInflater.inflate(R.layout.item_word_layout, parent, false);
        return new WordViewHolder(itemView, this);
    }

    @Override
    public void onBindViewHolder(@NonNull WordViewHolder holder, int position) {
        holder.wordItemView.setText(mWordList.get(position));
    }

    @Override
    public int getItemCount() {
        return mWordList.size();
    }

    @Override
    public boolean onInterceptTouchEvent(@NonNull RecyclerView rv, @NonNull MotionEvent e) {
        Log.d("recyclerview", "onInterceptTouchEvent" + e.toString());
        View child = rv.findChildViewUnder(e.getX(), e.getY());
        if (e.getAction() == MotionEvent.ACTION_UP && child != null) {
            int position = rv.getChildLayoutPosition(child);
            String word = mWordList.get(position);
            mWordList.set(position, word + " checked!");
            notifyItemChanged(position);
            Log.d("recyclerview", "onInterceptTouchEvent:" + position + " word:" + word);
            return true;
        } else {
            return false;
        }

    }

    @Override
    public void onTouchEvent(@NonNull RecyclerView rv, @NonNull MotionEvent e) {
        Log.d("recyclerview", "onTouchEvent" + e.toString());
    }

    @Override
    public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {
        Log.d("recyclerview", "onRequestDisallowInterceptTouchEvent");

    }

    public class WordViewHolder extends RecyclerView.ViewHolder {
        public final TextView wordItemView;
        final WordListAdapter mAdapter;
        public WordViewHolder(@NonNull View itemView, WordListAdapter adapter) {
            super(itemView);
            wordItemView = itemView.findViewById(R.id.word);
            mAdapter = adapter;
        }
    }
}
