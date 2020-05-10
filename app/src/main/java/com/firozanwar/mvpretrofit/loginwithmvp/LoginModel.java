package com.firozanwar.mvpretrofit.loginwithmvp;

public interface LoginModel {
    interface OnLoginFinishListener {
        void onCancelled();

        void onPasswordError();

        void onSuccess();
    }

    void login(String email, String password, OnLoginFinishListener onLoginFinishListener);
}
