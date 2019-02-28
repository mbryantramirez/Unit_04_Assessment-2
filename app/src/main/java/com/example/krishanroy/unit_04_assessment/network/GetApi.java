package com.example.krishanroy.unit_04_assessment.network;

import com.example.krishanroy.unit_04_assessment.model.OuterClass;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GetApi {
    String END_POINT = "JDVila/storybook/master/echinoderms.json";
    @GET(END_POINT)
    Call<OuterClass> getOuterClass();

}
