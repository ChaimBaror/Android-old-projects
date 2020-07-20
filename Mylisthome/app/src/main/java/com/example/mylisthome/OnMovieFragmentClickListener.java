package com.example.mylisthome;

import java.util.ArrayList;

interface OnMovieFragmentClickListener {

    
    void onMovieClicked(MoviesModel moviesModel, ArrayList<MoviesModel> models, int itemPosition);

}
