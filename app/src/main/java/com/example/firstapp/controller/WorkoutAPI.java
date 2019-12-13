package com.example.firstapp.controller;

import com.example.firstapp.model.Exercice;

import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface WorkoutAPI {
    @GET("db.json")
    Call<List<Exercice>> loadExercices(@Query("q") String status);
}