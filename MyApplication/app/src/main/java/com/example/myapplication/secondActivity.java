package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import static com.example.myapplication.MainActivity.EXTRA_DATA_COUNTER;

public class secondActivity extends AppCompatActivity {


    private TextView textView;
    private View view;
    private View view1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        textView = findViewById(R.id.textView);
        int numberget = getIntent().getIntExtra(EXTRA_DATA_COUNTER, -1);
        textView.setText(String.valueOf(numberget));
        view = findViewById(R.id.View1);
        view1 = findViewById(R.id.View2);
    }

}
