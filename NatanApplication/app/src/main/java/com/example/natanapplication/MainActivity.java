package com.example.natanapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements keepernumber {
    DisplayFeagment mfeagment = DisplayFeagment.newInstance(9);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.top_fragment,TopFragment.newFragment())
                .commit();


        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.daon_fafment,mfeagment )
                .commit();
    }

    @Override
    public void onUpdatNumber(int i) {
        if(mfeagment != null)
        mfeagment.setText(i);

    }
}
