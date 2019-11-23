package com.example.top_github.service.Repository;

import com.example.top_github.service.model.RepoDetails;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface GetDataService {

    @GET(".")
    Call<List<RepoDetails>> getAllRepos(
            @Query("language") String param1,
            @Query("since") String param2);
}
