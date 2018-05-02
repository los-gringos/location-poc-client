package com.kostas.retrofitexampleapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.kostas.retrofitexampleapplication.model.Movie;
import com.kostas.retrofitexampleapplication.model.MovieResponse;
import com.kostas.retrofitexampleapplication.rest.ApiClient;
import com.kostas.retrofitexampleapplication.rest.ApiInterface;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    List<Movie> movies = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);

        Call<MovieResponse> call = apiService.getTopRatedMovies(ApiClient.API_KEY);
        call.enqueue(new Callback<MovieResponse>() {
            @Override
            public void onResponse(Call<MovieResponse> call, Response<MovieResponse> response) {
                movies = response.body().setResults();
            }

            @Override
            public void onFailure(Call<MovieResponse> call, Throwable t) {

            }
        });



    }


}
