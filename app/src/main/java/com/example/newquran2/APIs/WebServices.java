package com.example.newquran2.APIs;

import com.example.newquran2.model.RadiosResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface WebServices {

    @GET("radio_arabic.json")
    Call<RadiosResponse>getRediosChannel();
}
