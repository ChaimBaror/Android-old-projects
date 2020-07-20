package com.example.asynctaskactivity;

interface OnMovieFragmentClickListener {


    void onPreExecute();

    void onProgressUpdate(Integer value);

    void onPostExecute(String s);

    void onCancel();
}
