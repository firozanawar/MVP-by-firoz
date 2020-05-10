package com.firozanwar.mvpretrofit.mvpwithretrofit.view;

import com.firozanwar.mvpretrofit.mvpwithretrofit.model.Notice;

import java.util.ArrayList;

public class MainContract {

    /**
     * This interface callbacks will be called when the user interact with the view onRefreshButtonClick(),
     * when the view is destroyed onDestroy() and requesting the data from the server requestDataFromServer()
     * for the first time when the activity is created.
     */
    interface presenter {
        void requestDataFromServer();

        void onRefreshButtonClick();

        void onDestroy();
    }

    /**
     * The interface callback will be called when the user need to show/hide the progressbar
     * showPregress()/hidePregress() , set data to the recycler view setDataToRecyclerView(…)
     * and lastly to show the error if the network response is failed onResponseFailure(…).
     */
    interface MainView {
        void showProgress();

        void hideProgress();

        void setDataToRecyclerview(ArrayList<Notice> noticeArrayList);

        void onResponseFailure(Throwable throwable);
    }

    /**
     * Intractors are built for fetching the data from the database, webservices or any other data source.
     * This interface callback has one inner interface named onFinishedListener{..}
     * which will be called when the webservices response in finished or the response is failure onFinished(…)
     * and onFailure(…). And it also has another callback named getNoticeArrayList(onFinishListener …)
     * that has the onFinishListener interface as a constructor.
     */
    interface GetNoticeIntractor {

        interface OnFinishedListener {
            void onFinished(ArrayList<Notice> noticeArrayList);

            void onFailure(Throwable t);
        }

        void getNoticeArrayList(OnFinishedListener onFinishedListener);
    }


}
