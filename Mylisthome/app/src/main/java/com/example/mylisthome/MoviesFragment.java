package com.example.mylisthome;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import static com.example.mylisthome.MainActivity.loadMovies;


public class MoviesFragment extends Fragment implements OnMovieClickListener {

    private OnMovieFragmentClickListener mListener ;

    private RecyclerView mRecyclerView;
    private LinearLayoutManager mLayoutManager;
    private MoviesBaseAdapter mAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment, container, false);
        mRecyclerView = view.findViewById(R.id.movies_fragment_rcv);
        initRecyclerView(view);
        return view;

    }


    private void initRecyclerView(View view) {
        if (getContext() != null) {
            mRecyclerView = view.findViewById(R.id.movies_fragment_rcv);
            mLayoutManager = new LinearLayoutManager(getContext());
            mRecyclerView.setLayoutManager(mLayoutManager);
            mAdapter = new MoviesBaseAdapter(loadMovies(), this, getContext());
            mRecyclerView.setAdapter(mAdapter);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        if (context instanceof OnMovieFragmentClickListener) {
            mListener = (OnMovieFragmentClickListener) context;
        } else
            throw new RuntimeException(" must implement OnMovieFragmentClickListener");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

//    @Override
//    public void onMovieClicked(int itemPosition) {
//        mListener.onMovieClicked(loadMovies().get(itemPosition));
//    }
    @Override
    public void onMovieClicked(int itemPosition) {
        if(mListener != null)
            mListener.onMovieClicked(loadMovies().get(itemPosition),loadMovies(),itemPosition);
    }
}