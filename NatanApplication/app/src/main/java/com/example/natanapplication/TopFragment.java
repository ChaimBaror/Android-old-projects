package com.example.natanapplication;


import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class TopFragment extends Fragment {
    int counter = 0;
    keepernumber keep;
    boolean running = true;


    public static TopFragment newFragment() {
        return new TopFragment();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_top, container, false);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof keepernumber)
            keep = (keepernumber) context;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        view.findViewById(R.id.bottom_plus).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                  counter++;
                keep.onUpdatNumber(++counter);
            }
        });
        view.findViewById(R.id.bottom_minos).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counter--;

                keep.onUpdatNumber(counter);
            }
        });
        view.findViewById(R.id.bottom_run).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (running == true) {
                    Thread thread = new Thread(new CustomRunnable());
                    thread.start();
                    if (counter == 100) running = false;

                } else {
                    keep.onUpdatNumber(counter = -100);
                    running = true;

                }
            }
        });
    }

    public class CustomRunnable implements Runnable {

        @Override
        public void run() {
            while (running) {

                while (counter < 100) {
                    counter++;
                    keep.onUpdatNumber(counter);
                    try {
                        SystemClock.sleep(100);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                }
                break;
            }
        }
    }
}
