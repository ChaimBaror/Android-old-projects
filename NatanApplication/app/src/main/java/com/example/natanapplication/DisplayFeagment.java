package com.example.natanapplication;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;


public class DisplayFeagment extends Fragment {
    protected static final String EXTRA_START = "ES";
    TextView textView;
    ProgressBar progressBar;

    public static DisplayFeagment newInstance(int startNumber) {
        DisplayFeagment displayFeagment = new DisplayFeagment();
        Bundle bundle = new Bundle();
        bundle.putInt(EXTRA_START, startNumber);
        displayFeagment.setArguments(bundle);
        return displayFeagment;

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragmentdisplay, container, false);
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        textView = view.findViewById(R.id.text_couner);
        progressBar = view.findViewById(R.id.progressBar);
    }

    public void setText(Integer count) {
        textView.setText(count.toString());
        progressBar.setProgress(count);
    }
}

