package com.firozanwar.mvpretrofit.mvpwithretrofit.network;

import com.firozanwar.mvpretrofit.mvpwithretrofit.model.NoticeList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GetNoticeDataService {

    @GET("fc817c902b5c02de4967")
    Call<NoticeList> getNoticeData();
}
