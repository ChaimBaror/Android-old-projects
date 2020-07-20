package com.example.mylisthome;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class MoviesModel  implements   Parcelable   {
    @PrimaryKey

    private int movieId;
    private String name;
    private String imageUri;
    private String backImageUri;
    private String overview;
    private String releaseDate;
    private Double popularity;
    int imageResourceId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImageResourceId() {
        return imageResourceId;
    }

    public void setImageResourceId(int imageResourceId) {
        this.imageResourceId = imageResourceId;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
        dest.writeInt(this.imageResourceId);
        dest.writeString(this.overview);
    }

    public MoviesModel() {
    }

    protected MoviesModel(Parcel in) {
        this.name = in.readString();
        this.imageResourceId = in.readInt();
        this.overview = in.readString();
    }

    public static final Creator<MoviesModel> CREATOR = new Creator<MoviesModel>() {
        @Override
        public MoviesModel createFromParcel(Parcel source) {
            return new MoviesModel(source);
        }

        @Override
        public MoviesModel[] newArray(int size) {
            return new MoviesModel[size];
        }
    };
}
