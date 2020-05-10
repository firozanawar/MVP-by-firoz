package com.firozanwar.mvpretrofit.mvpwithretrofit.view;

import android.util.Log;

import com.firozanwar.mvpretrofit.mvpwithretrofit.model.NoticeList;
import com.firozanwar.mvpretrofit.mvpwithretrofit.network.GetNoticeDataService;
import com.firozanwar.mvpretrofit.mvpwithretrofit.network.RetrofitInstance;
import com.firozanwar.mvpretrofit.mvpwithretrofit.view.MainContract;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * This class implements the MainAcontract.GetNoticeIntractor Interface which
 * includes the overridden methoid getNoticeArrayList().
 * <p>
 * This class is responsible to get data using the rest apis using retrofit library and pass data through onFinishedListener callback.
 * <p>
 * Now, we have to create the retrofit instance service and use that service to fetch data by using the interface.
 * Here, we don’t pass your callback as the last parameter. We use the service to get a call object. Once we’ve invoked
 * .enqueue on the created call object the request will be made by Retrofit.
 * And we should be able to make our very first request with Retrofit.
 * If everything went well, Retrofit will return you a List<Notice>and then
 * we will pass data through onFinishedListener.onFinished(…) callback.
 * If failure then we will pass data through onFinishedListener.onFailure(…) callback.
 */
public class GetNoticeIntractorImpl implements MainContract.GetNoticeIntractor {

    @Override
    public void getNoticeArrayList(OnFinishedListener onFinishedListener) {

        /** Create handle for the RetrofitInstance interface*/
        GetNoticeDataService service = RetrofitInstance.getRetrofitInstance().create(GetNoticeDataService.class);

        Call<NoticeList> call = service.getNoticeData();

        /**Log the URL called*/
        Log.wtf("URL Called", call.request().url() + "");

        call.enqueue(new Callback<NoticeList>() {
            @Override
            public void onResponse(Call<NoticeList> call, Response<NoticeList> response) {
                onFinishedListener.onFinished(response.body().getNoticeArrayList());
            }

            @Override
            public void onFailure(Call<NoticeList> call, Throwable t) {
                onFinishedListener.onFailure(t);
            }
        });
    }
}
