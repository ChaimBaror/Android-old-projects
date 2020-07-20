package com.example.asynctaskactivity;

import android.os.AsyncTask;
import android.view.View;
import android.widget.Toast;

import java.lang.ref.WeakReference;
//
//public class ExampleAsyncTask extends AsyncTask<Integer, Integer, String> {
//    private WeakReference<MainActivity> activityWeakReference;

//
//
//    ExampleAsyncTask(MainActivity activity) {
//
//        activityWeakReference = new WeakReference<MainActivity>(activity);
//    }
//
//    @Override
//    protected String doInBackground(Integer... integers) {
//        for (int i = 0; i < integers[0]; i++) {
//            if (isCancelled()) {
//                break;
//            }
//
//
//            publishProgress((i * 100) / integers[0]);
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
//
//        return "Finished!";
//    }
//
//
//    @Override
//    protected void onProgressUpdate(Integer... values) {
//        super.onProgressUpdate(values);
//
//        MainActivity activity = activityWeakReference.get();
//        if (activity == null || activity.isFinishing()) {
//            return;
//        }
//        activity.textView.setText(String.valueOf(values[0] / 10));
//        activity.progressBar.setProgress(values[0]);
//    }
//
//    @Override
//    protected void onPreExecute() {
//        super.onPreExecute();
//
//        MainActivity activity = activityWeakReference.get();
//        if (activity == null || activity.isFinishing()) {
//            return;
//        }
//
//        activity.progressBar.setVisibility(View.VISIBLE);
//    }
//    @Override
//    protected void onCancelled() {
//        super.onCancelled();
//
//        MainActivity activity = activityWeakReference.get();
//        if (activity == null || activity.isFinishing()) {
//            return;
//        }
//        Toast.makeText(activity, "An error occurred, " +
//                "please try again later :(", Toast.LENGTH_SHORT).show();
//
//    }


//
//    @Override
//    protected void onPostExecute(String s) {
//        super.onPostExecute(s);
//
//        MainActivity activity = activityWeakReference.get();
//        if (activity == null || activity.isFinishing()) {
//            return;
//        }
//
//        Toast.makeText(activity, s, Toast.LENGTH_SHORT).show();
//
//        activity.textView.setText(s);
//        activity.progressBar.setProgress(0);
//
//
//        activity.progressBar.setVisibility(View.INVISIBLE);
//    }
//}
