package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_DATA_COUNTER = "EDC";
    private int mCounter = 0;
    private TextView mCounterTextView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mCounterTextView = findViewById(R.id.textnew);
    }
        public void increaseCount(View view) {
            mCounter++;
            if (mCounter > 10) {
                navigateToSecondActivity();
                return;
            }
            mCounterTextView.setText(String.valueOf(mCounter));


        }

        public void navigateToSecondActivity() {
            Intent openSecondActivity = new Intent(this, secondActivity.class);
            openSecondActivity.putExtra(EXTRA_DATA_COUNTER, mCounter);
            startActivity(openSecondActivity);
    }



    public void newSecondActivity(View view){
        Intent openSecondActivity = new Intent(this, secondActivity.class);
        openSecondActivity.putExtra(EXTRA_DATA_COUNTER, mCounter);
        startActivity(openSecondActivity);
    }
    public void onclickTextView (View view){
        TextView editText = findViewById(R.id.editText);
        mCounterTextView.setText(editText.getText());
    }
}
