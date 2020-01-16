package com.example.worddemo;


import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Word_table")
public class Word {

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "Word")
    private String mWord;

    public Word(@NonNull String word)
    {
        this.mWord = word;
    }

    @NonNull
    public String getWord()
    {
        return this.mWord;
    }

}
