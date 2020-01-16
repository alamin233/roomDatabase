package com.example.worddemo;

        import androidx.lifecycle.LiveData;
        import androidx.room.Dao;
        import androidx.room.Insert;
        import androidx.room.OnConflictStrategy;
        import androidx.room.Query;

        import java.util.List;

@Dao
public interface WordDao {

    @Query("Select * from word_table")
    LiveData<List<Word>> getAlphabetizedWords();

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(Word word);

    @Query("Delete from word_table")
    void deleteAll();



}
