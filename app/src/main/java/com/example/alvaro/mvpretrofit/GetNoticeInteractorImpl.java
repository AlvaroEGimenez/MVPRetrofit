package com.example.alvaro.mvpretrofit;

import android.util.Log;

import com.example.alvaro.mvpretrofit.Model.NoticeList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GetNoticeInteractorImpl implements MainContract.GetNoticeInteractor {


    @Override
    public void getNoticeArraylist(final OnfinishedListener onfinishedListener) {

        GetNoticeDataService service = RetrofitInstance.getRetrofitInstance().create(GetNoticeDataService.class);
        Call<NoticeList> call = service.getTopNotice();

        call.enqueue(new Callback<NoticeList>() {
            @Override
            public void onResponse(Call<NoticeList> call, Response<NoticeList> response) {

                onfinishedListener.onFinished(response.body().getArticles());
            }

            @Override
            public void onFailure(Call<NoticeList> call, Throwable t) {
                onfinishedListener.onFailure(t);

            }
        });
    }
}
