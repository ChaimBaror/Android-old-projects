package com.example.asynctaskactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.HandlerThread;
import android.os.SystemClock;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class ThreadsActivity extends AppCompatActivity {

    ProgressBar progressBar;
    LinearLayout linearLayout;
    Button Create, Start, Cancel;
    TextView textView,coun;
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_threads);
        linearLayout = findViewById(R.id.linearLayout);
        progressBar = findViewById(R.id.progress_bar);
        editText = findViewById(R.id.editText);
        Create = findViewById(R.id.button);
        Start = findViewById(R.id.button2);
        Cancel = findViewById(R.id.button3);
        coun = findViewById(R.id.textViewcoun);
        textView = findViewById(R.id.TextViewA);
        textView.setText("This is Activity");


        Create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                    Thread thread = new Thread(new CustomThread());
                final CustomThread thread = new CustomThread();
                textView.setText("Go Go Go Run");
//                thread.start();
                Start.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        thread.start();

                    }
                });
                Cancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        thread.cancel();

                    }
                });
            }
        });
    }
    public class CustomThread extends Thread {


        int counter = 100;

        boolean running = false;

        @Override
        public void run() {
            running = true;
            while (running) {
                //doHardWork();
                for (int i = counter; i > 0; i--) {

                    textView.setText(String.valueOf(i));
                    progressBar.setProgress(i);

                    try {
                        SystemClock.sleep(40);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

                textView.setText("Finished!");

//                running = false;
            }
        }

        public void cancel() {
            running = false;
        }
    }
}
