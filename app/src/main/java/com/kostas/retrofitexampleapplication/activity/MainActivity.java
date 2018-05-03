package com.kostas.retrofitexampleapplication.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.kostas.retrofitexampleapplication.R;
import com.kostas.retrofitexampleapplication.adapter.MoviesAdapter;
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

    private List<Movie> movies = new ArrayList<>();
    private ApiInterface apiService;
    private RecyclerView recycler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recycler = findViewById(R.id.mainRecyclerView);
        recycler.setLayoutManager(new LinearLayoutManager(this));

        apiService = ApiClient.getClient().create(ApiInterface.class);

        Call<MovieResponse> call = apiService.getTopRatedMovies(ApiClient.API_KEY);
        call.enqueue(new Callback<MovieResponse>() {
            @Override
            public void onResponse(Call<MovieResponse> call, Response<MovieResponse> response) {
                movies = response.body().getResults();
                recycler.setAdapter(new MoviesAdapter(R.layout.movie_list_item,movies,getBaseContext()));
            }

            @Override
            public void onFailure(Call<MovieResponse> call, Throwable t) {

            }
        });



    }


}
