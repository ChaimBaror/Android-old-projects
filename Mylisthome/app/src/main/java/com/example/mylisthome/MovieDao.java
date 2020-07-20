package com.example.mylisthome;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.Collection;
import java.util.List;

@Dao
public interface MovieDao {

    @Query("SELECT * FROM MoviesModel ORDER BY popularity DESC")
    List<MoviesModel> getAll();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(Collection<MoviesModel> movies);

    @Query("DELETE FROM MoviesModel")
    void deleteAll();
}
