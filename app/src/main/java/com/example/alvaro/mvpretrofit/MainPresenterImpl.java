package com.example.alvaro.mvpretrofit;

import com.example.alvaro.mvpretrofit.Model.Notice;

import java.util.ArrayList;

public class MainPresenterImpl implements MainContract.presenter, MainContract.GetNoticeInteractor.OnfinishedListener {

    private MainContract.MainView mainView;
    private MainContract.GetNoticeInteractor getNoticeInteractor;


    public MainPresenterImpl(MainContract.MainView mainView, MainContract.GetNoticeInteractor getNoticeInteractor) {
        this.mainView = mainView;
        this.getNoticeInteractor = getNoticeInteractor;
    }

    @Override
    public void onDestroy() {
        mainView = null;
    }

    @Override
    public void onRefreshButtonClick() {
        if (mainView != null){
            mainView.showProgress();
        }
        getNoticeInteractor.getNoticeArraylist(this);

    }

    @Override
    public void requestDataForServer() {
        getNoticeInteractor.getNoticeArraylist(this);
    }

    @Override
    public void onFinished(ArrayList<Notice> noticeArrayList) {
        if (mainView != null){
            mainView.setDataRecyclerView(noticeArrayList);
            mainView.hideProgress();
        }

    }

    @Override
    public void onFailure(Throwable throwable) {
        if (mainView != null){
            mainView.onResponseFailure(throwable);
            mainView.hideProgress();
        }

    }
}
