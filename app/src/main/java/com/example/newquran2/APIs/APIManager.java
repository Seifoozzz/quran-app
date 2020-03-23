package com.example.newquran2.APIs;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class APIManager {

    private static Retrofit retrofit;

    private static Retrofit getInstance(){
        // Build object Retrofit
        if (retrofit == null)
            retrofit = new Retrofit.Builder()
                    .baseUrl("http://api.mp3quran.net/radios/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        return retrofit;
    }

    public static WebServices getAPIs(){
        return getInstance().create(WebServices.class);
    }
}
