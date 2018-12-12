package com.example.alvaro.mvpretrofit;

import com.example.alvaro.mvpretrofit.Model.NoticeList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GetNoticeDataService {
    public static final String API_KEY = "ff112350a3354d97867f69c1b33d2428";

    @GET("top-headlines?sources=hacker-news&apiKey=ff112350a3354d97867f69c1b33d2428")
    Call<NoticeList> getTopNotice();

}
