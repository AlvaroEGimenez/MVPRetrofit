package com.example.alvaro.mvpretrofit;

import com.facebook.stetho.okhttp3.StethoInterceptor;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitInstance {

    private static Retrofit retrofit;
    public static final String BASE_URL = "https://newsapi.org/v2/";

    public static OkHttpClient getOKClient() {
        OkHttpClient client;
        OkHttpClient.Builder clientbuilder = new OkHttpClient.Builder();
        clientbuilder.followRedirects(true);

        if (BuildConfig.DEBUG) {
            /// /debug stethto only debug
            clientbuilder.addNetworkInterceptor(new StethoInterceptor());
        }
        client = clientbuilder.build();
        return client;
    }


    public static Retrofit getRetrofitInstance(){
        if (retrofit == null){
            retrofit = new retrofit2.Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .client(getOKClient())
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
