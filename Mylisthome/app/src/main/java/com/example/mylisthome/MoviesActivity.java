package com.example.mylisthome;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MoviesActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movies);
        MoviesFragment moviesFragment = new MoviesFragment();
        getSupportFragmentManager().beginTransaction().add(R.id.recyclerView, moviesFragment).commit();
    }
}






