package com.example.asynctaskactivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Timer;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import static android.os.SystemClock.sleep;


public class MainActivity extends AppCompatActivity {

    ProgressBar progressBar;

    Button Create, Start, Cancel;
    TextView textView;

    ExampleAsyncTaskFragment task;


    private final Executor diskIO = Executors.newSingleThreadExecutor();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


    }


//
//        Toolbar toolbar = findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
//
//        Create =findViewById(R.id.button);
//        Start = findViewById(R.id.button2);
//        Cancel = findViewById(R.id.button3);
//        textView =findViewById(R.id.text);


//        thread.start();


    public void goo() {
        diskIO.execute(new CustomRunnable());

    }

    public static class CustomRunnable implements Runnable {
        @Override
        public void run() {
            //doHardWork();
        }
    }

    //    public void Start(View view){
//        startAsyncTask();
//    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.action_settings:
                AsyncTaskFragment();
                return true;
            case R.id.action_settings2:
                newGame();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }

    private void AsyncTaskFragment() {

        task = new ExampleAsyncTaskFragment();
        getSupportFragmentManager()
                .beginTransaction()
                .addToBackStack(null)
                .add(R.id.fragment, task)
                .commit();
        Toast.makeText(this, "Got the new AsyncTask coumter", Toast.LENGTH_LONG).show();

    }

    private void newGame() {
        Intent intent = new Intent(this, ThreadsActivity.class);
        startActivity(intent);

        Toast.makeText(this, "Got the  coumter successfully", Toast.LENGTH_LONG).show();
    }
}
