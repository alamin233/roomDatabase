package com.example.worddemo;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private WordViewModel mWordViewModel;

    FloatingActionButton fabBtn;

    @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

        fabBtn = findViewById(R.id.fab);

        RecyclerView recyclerView = findViewById(R.id.recyclerview);
        final WordListAdapter adapter = new WordListAdapter(this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));



        mWordViewModel = new ViewModelProvider(this).get(WordViewModel.class);
        Log.e("------------","------------"+mWordViewModel.getAllWords());

        mWordViewModel.getAllWords().observe(this, new Observer<List<Word>>() {
            public void onChanged(@Nullable final List<Word> words) {
                // Update the cached copy of the words in the adapter.
             adapter.setWords(words);
                //Log.e("------------------","---------Words----------"+words.get(0).getWord());
                //Log.e("------------------","---------Words----------"+words.get(1).getWord());
               // Log.e("------------------","---------Words----------"+words.get(2).getWord());
                //Log.e("------------------","---------Words----------"+words.get(3).getWord());

//                Log.e("-----------------","================"+words.size());
//                for(int i = 0;i<words.size();i++)
//                {
//                    Log.e("------------------","---------Words----------"+words.get(i).getWord());
//                }

            }
        });

        fabBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity.this, NewWordActivity.class);
                startActivity(intent);
            }
        });

    }
}
