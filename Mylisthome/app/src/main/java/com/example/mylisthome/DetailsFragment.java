package com.example.mylisthome;


import android.os.Bundle;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;


public class DetailsFragment extends Fragment {

    private static final String MOVIE_BUNDLE_KEY = "unique_movie_key";

    private TextView movieTitle;
    private TextView overViewText;
    private ImageView posterImage;

    private MoviesModel moviesModel;

    public static DetailsFragment newInstance(MoviesModel moviesModel) {
        DetailsFragment fragment = new DetailsFragment();
        Bundle args = new Bundle();
        args.putParcelable(MOVIE_BUNDLE_KEY, moviesModel);
        fragment.setArguments(args);
        return fragment;
    }



    //    public static DetailsFragment newInstance(MoviesModel moviesModel){
//        DetailsFragment fragment = new DetailsFragment();
//        Bundle args = new Bundle();
//        args.putParcelable("chaim",moviesModel);
//        return fragment;
//
//    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            moviesModel = getArguments().getParcelable(MOVIE_BUNDLE_KEY);
        }
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_details, container, false);
        initView(view);
        if (moviesModel != null)
            loadMovie();
        return view;
    }
    private void loadMovie() {
        movieTitle.setText(moviesModel.getName());
        overViewText.setText(moviesModel.getOverview());
        posterImage.setImageResource(moviesModel.getImageResourceId());

    }

    private void initView(View view) {
        movieTitle = view.findViewById(R.id.descTextView);
        overViewText = view.findViewById(R.id.textView3);
        posterImage = view.findViewById(R.id.backgroundImage);
    }
}
