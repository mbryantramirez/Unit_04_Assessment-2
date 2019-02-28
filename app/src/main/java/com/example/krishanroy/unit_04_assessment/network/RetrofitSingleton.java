package com.example.krishanroy.unit_04_assessment.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitSingleton {
    private static final String BASE_URL = "https://raw.githubusercontent.com/";
    private static Retrofit ourInstance;

    public static Retrofit newInstance() {
        if (ourInstance != null) {
            return ourInstance;
        }
        ourInstance = new Retrofit
                .Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return ourInstance;
    }

    private RetrofitSingleton() {
    }
}
