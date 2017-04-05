package com.example.nhungnguyen.firstproject.Interface;

import com.example.nhungnguyen.firstproject.Models.SOAnswersResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Copy right asiantech
 * Created by asiantech on 4/5/17.
 */

public interface SOService {
    @GET("/answers?order=desc&sort=activity&site=stackoverflow")
    Call<SOAnswersResponse> getAnswers();
    @GET("/answers?order=desc&sort=activity&site=stackoverflow")
    Call<SOAnswersResponse> getAnswers(@Query("tagged")String tags);
}
