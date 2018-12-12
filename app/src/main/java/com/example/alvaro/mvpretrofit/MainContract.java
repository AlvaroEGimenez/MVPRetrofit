package com.example.alvaro.mvpretrofit;

import com.example.alvaro.mvpretrofit.Model.Notice;

import java.util.ArrayList;

public interface MainContract {

    interface presenter {

        void onDestroy();

        void onRefreshButtonClick();

        void requestDataForServer();

    }

    interface MainView {

        void showProgress();

        void hideProgress();

        void setDataRecyclerView(ArrayList<Notice> noticeArrayList);

        void onResponseFailure(Throwable throwable);


    }

    interface GetNoticeInteractor {

        interface OnfinishedListener {

            void onFinished(ArrayList<Notice> noticeArrayList);
            void onFailure(Throwable throwable);
        }

        void getNoticeArraylist(OnfinishedListener onfinishedListener);
    }


}
