package com.firozanwar.mvpretrofit.mvpwithretrofit.view;

import com.firozanwar.mvpretrofit.mvpwithretrofit.model.Notice;
import com.firozanwar.mvpretrofit.mvpwithretrofit.view.MainContract;

import java.util.ArrayList;

/**
 * This class is responsible to act as the middle man between View and Model.
 * It retrieves data from the Model and returns it formatted to the View and
 * it also decides what happens when you interact with the View.
 * <p>
 * This call implements the MainContract.GetNoticeIntractor.OnFinishedListener,
 * and MainContract.presenter interface which includes their overridden methods as well.
 * And the constructor includes the two params named MainContract.MainAview and
 * MainContract.GetNoticeIntractor.
 * <p>
 * When the onDestroy method is called from the main activity,
 * this class listen the onDestroy() callback and make the mainview to null.
 * And when onRefreshButtonClick() it calls the showProgress() and
 * getNoticeArrayList(...) callback to get data from server.
 * And When the data is fetched/received from the webservices callback in
 * GetNoticeIntractorImpl class onFinish(…) and onFailure(…) callback is called.
 */
public class MainPresenterImpl implements MainContract.presenter, MainContract.GetNoticeIntractor.OnFinishedListener {

    private MainContract.MainView mainView;
    private MainContract.GetNoticeIntractor getNoticeIntractor;

    public MainPresenterImpl(MainContract.MainView mainView, MainContract.GetNoticeIntractor getNoticeIntractor) {
        this.mainView = mainView;
        this.getNoticeIntractor = getNoticeIntractor;
    }

    @Override
    public void requestDataFromServer() {
        getNoticeIntractor.getNoticeArrayList(this);
    }

    @Override
    public void onRefreshButtonClick() {
        if (mainView != null) {
            mainView.showProgress();
        }
        getNoticeIntractor.getNoticeArrayList(this);
    }

    @Override
    public void onDestroy() {
        mainView = null;
    }

    @Override
    public void onFinished(ArrayList<Notice> noticeArrayList) {
        if (mainView != null) {
            mainView.setDataToRecyclerview(noticeArrayList);
            mainView.hideProgress();
        }
    }

    @Override
    public void onFailure(Throwable t) {
        if (mainView != null) {
            mainView.onResponseFailure(t);
            mainView.hideProgress();
        }
    }
}
