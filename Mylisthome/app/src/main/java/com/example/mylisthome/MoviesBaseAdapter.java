package com.example.mylisthome;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MoviesBaseAdapter extends RecyclerView.Adapter<MoviesBaseAdapter.ViewHolder> {


//    public static class MovieViewHolder {
//        public ImageView image;
//        public TextView title, overview;
//    }

    private OnMovieClickListener movieClickListener;
    private LayoutInflater mInflater;
    private ArrayList<MoviesModel> mDataSource;

    public MoviesBaseAdapter(ArrayList<MoviesModel> items, OnMovieClickListener listener, Context context) {
        mDataSource = items;
        mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        movieClickListener = listener;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View rowItem = mInflater.inflate(R.layout.row, parent, false);
        return new ViewHolder(rowItem);

    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.onBindViewHolder(mDataSource.get(position));
    }


    @Override
    public int getItemCount() {
        return mDataSource.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public final ImageView ivImage;
        public final TextView tvTitle;
        public final TextView tvOverview;

        public ViewHolder(View view) {
            super(view);
            view.setOnClickListener(this);
            ivImage = view.findViewById(R.id.item_movie_iv);
            tvTitle = view.findViewById(R.id.textView);
            tvOverview = view.findViewById(R.id.textView2);
        }

        @Override
        public void onClick(View v) {
            if (movieClickListener == null) return;
            movieClickListener.onMovieClicked(getAdapterPosition());
        }

        public void onBindViewHolder(MoviesModel movieModel) {
            ivImage.setImageResource(movieModel.getImageResourceId());
            tvTitle.setText(movieModel.getName());
            tvOverview.setText(movieModel.getOverview());
        }

    }

}

//    @Override
//    public MoviesModel getItem(int position) {
//        return mDataSource.get(position);
//    }
//
//    @Override
//    public long getItemId(int position) {
//        return position;
//    }

//    @Override
//    public View getView(int position, View convertView, ViewGroup parent) {
//        // Inflate our row and find our views!
//        if (convertView == null) {
//            View rowItem = mInflater.inflate(R.layout.row, parent, false);
//
//        ImageView image = (ImageView) rowItem.findViewById(R.id.item_movie_iv);
//        TextView title = (TextView) rowItem.findViewById(R.id.textView);
//        TextView overview = (TextView) rowItem.findViewById(R.id.textView2);
//
//
//        MoviesModel movie = getItem(position);
//
//        image.setImageResource(movie.getImageResourceId());
//        title.setText(movie.getName());
//        overview.setText(movie.getOverview());
//
//        return rowItem;
//    }

//
//    public View getView(int position, View convertView, ViewGroup parent) {
//
//        // Inflate our row and find our views!
//        MovieViewHolder holder;
//        if (convertView == null) {
//            convertView = mInflater.inflate(R.layout.row, parent, false);
//            holder = new MovieViewHolder();
//            holder.image = convertView.findViewById(R.id.item_movie_iv);
//            holder.title = convertView.findViewById(R.id.textView);
//            holder.overview = convertView.findViewById(R.id.textView2);
//            convertView.setTag(holder);
//        } else {
//            holder = (MovieViewHolder) convertView.getTag();
//
//        }
//
//        MoviesModel movie = getItem(position);
//
//        holder.image.setImageResource(movie.getImageResourceId());
//        holder.title.setText(movie.getName());
//        holder.overview.setText(movie.getOverview());
//
//        return convertView;
//    }
//}

