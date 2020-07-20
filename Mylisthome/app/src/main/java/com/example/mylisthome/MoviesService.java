//package com.example.mylisthome;
//
//import retrofit2.Call;
//import retrofit2.http.Body;
//import retrofit2.http.GET;
//import retrofit2.http.Headers;
//import retrofit2.http.POST;
//import retrofit2.http.Path;
//import retrofit2.http.Query;
//
//
//
//interface MoviesService {
//
//
//    @GET("search/movies")
//    Call<VideosListResult> searchMoviesByTitle(@Query("query") String title);
//
//    @GET("discover/movie")
//    Call<VideosListResult> discoverMovies(@Query("year") int year);
//
//
//    // https://api.themoviedb.org/3/movies/{movie_id}/rating
//    @Headers("content-type:application/json;charset=utf-8")
//    @POST("movies/{movie_id}/rating")
//    Call<Void> rateMovie(@Path("movie_id") String movieId,
//                         @Body String rating);
//
//}
