package com.example.asynctaskactivity;


import android.os.AsyncTask;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.ref.WeakReference;


public class ExampleAsyncTaskFragment extends Fragment implements OnMovieFragmentClickListener {
    ExampleAsyncTask task;
    ProgressBar progressBar;
    LinearLayout linearLayout;
    Button Create, Start, Cancel;
    TextView textView;


    public ExampleAsyncTaskFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        final View view = inflater.inflate(R.layout.fragment_async_task, container, false);
        textView = view.findViewById(R.id.counter);
        linearLayout = view.findViewById(R.id.inearLayout);
        progressBar = view.findViewById(R.id.progress_bar);

        Create = view.findViewById(R.id.button);
        Start = view.findViewById(R.id.button2);
        Cancel = view.findViewById(R.id.button3);
        textView.setText("This is Async Activity");


        Cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                task.cancel(true);
            }
        });


        Create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                task = new ExampleAsyncTask(ExampleAsyncTaskFragment.this);
                textView.setText("This is Async Activity");
                Toast.makeText(getActivity(), " Create:(", Toast.LENGTH_SHORT).show();
            }
        });
        Start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                task = new ExampleAsyncTask(ExampleAsyncTaskFragment.this);
                task.execute(100);
                Toast.makeText(getActivity(), " Start Start Start Start:(", Toast.LENGTH_SHORT).show();

            }
        });
        return view;


    }



    @Override
    public void onPreExecute() {
        if (getActivity() == null || getActivity().isFinishing()) {
            return;
        }
        Cancel.setVisibility(View.VISIBLE);
        Toast.makeText(getActivity(), " Create:(", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onPostExecute(String s) {
        if (getActivity() == null || getActivity().isFinishing()) {
            return;
        }
        textView.setText(s);
    }

    @Override
    public void onProgressUpdate(Integer integer) {
        if (getActivity() == null || getActivity().isFinishing()) {
            return;
        }
        textView.setText(integer.toString() + "%");
        progressBar.setProgress(integer);
    }

    @Override
    public void onCancel() {
        if (getActivity() == null || getActivity().isFinishing()) {
            return;
        }
        Toast.makeText(getActivity(), "An error occurred please try again later :(", Toast.LENGTH_SHORT).show();
    }
//
//    public void Create(View view) {
//        onDestroy();
//
//    }
//
//    public void Cancel(View view) {
//        task.onCancelled();
//    }
//
//    public void startAsyncTask(View view) {
//        progressBar =view. findViewById(R.id.progress_bar);
////        Toast.makeText(this, "startAsyncTask", Toast.LENGTH_LONG).show();
//
//        task = new ExampleAsyncTask(ExampleAsyncTaskFragment.this) {
//        };
//
//        task.execute(10);
//    }
//
//    @Override
//    public void onDestroy() {
//        super.onDestroy();
//        task.cancel(true);
//        Toast.makeText(this, "onDestroy", Toast.LENGTH_LONG).show();
//
//    }
//
//
//    @Override
//    public void onStop() {
//        super.onStop();
//        task.cancel(false);
//        Toast.makeText(this, "onStop", Toast.LENGTH_LONG).show();
//
//    }


    public static class ExampleAsyncTask extends AsyncTask<Integer, Integer, String> {
        WeakReference<OnMovieFragmentClickListener> weakReference;
        OnMovieFragmentClickListener uiEvents;

        public ExampleAsyncTask(OnMovieFragmentClickListener clickListener) {
            this.weakReference = new WeakReference<>(clickListener);
            /*if (weakReference != null) {
                uiEvents = weakReference.get();
            }*/
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            if (weakReference == null) {
                return;
            }
            uiEvents = weakReference.get();
            uiEvents.onPreExecute();
        }

        @Override // PARAMS
        protected String doInBackground(Integer... integers) {
            for (int i = 0; i < integers[0]; i++) {
                if (isCancelled()) {
                    break;
                }
                publishProgress(i * 100 / integers[0]);
                try {
                    Thread.sleep(40);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            return "good for you!";
        }

        @Override // PROGRESS
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            if (weakReference == null) {
                return;
            }
            uiEvents.onProgressUpdate(values[0]);
        }

        @Override // RESULT
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            if (weakReference == null) {
                return;
            }
            uiEvents.onPostExecute(s);
        }

        @Override
        protected void onCancelled() {
            super.onCancelled();
            if (weakReference == null) {
                return;
            }
            uiEvents.onCancel();
        }
    }
}

////////////
//    public static class ExampleAsyncTask extends AsyncTask<Integer, Integer, String> {
//        WeakReference<OnMovieFragmentClickListener> activityWeakReference;
//
//
//        ExampleAsyncTask(OnMovieFragmentClickListener activity) {
//
//            activityWeakReference = new WeakReference<OnMovieFragmentClickListener>(activity);
//
//        }
//
//        @Override
//        public String doInBackground(Integer... integers) {
//            for (int i = 0; i < integers[0]; i++) {
//                if (isCancelled()) {
//                    break;
//                }
//
//
//                publishProgress((i * 100) / integers[0]);
//                try {
//                    Thread.sleep(1000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//
//            return "Finished!";
//        }
//
//
//        @Override
//        protected void onProgressUpdate(Integer... values) {
//            super.onProgressUpdate(values);
//
//            OnMovieFragmentClickListener activity = activityWeakReference.get();
//            if (getActivity()==null || getActivity().isFinishing()){
//                return;
//            activity.textView.setText(String.valueOf(values[0] / 10));
//            activity.progressBar.setProgress(values[0]);
//        }
//
//        @Override
//        protected void onPreExecute() {
//            super.onPreExecute();
//
//            MainActivity activity = activityWeakReference.get();
//            if (activity == null || activity.isFinishing()) {
//                return;
//            }
//
//            activity.progressBar.setVisibility(View.VISIBLE);
//        }
//
//        @Override
//        protected void onCancelled() {
//            super.onCancelled();
//
//            MainActivity activity = activityWeakReference.get();
//            if (activity == null || activity.isFinishing()) {
//                return;
//            }
//            Toast.makeText(activity, "An error occurred, " +
//                    "please try again later :(", Toast.LENGTH_SHORT).show();
//
//        }
//
//
//    }
//}

