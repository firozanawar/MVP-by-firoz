package com.firozanwar.mvpretrofit.basicmvp.presenter;

import com.firozanwar.mvpretrofit.basicmvp.model.User;

public class BasicMVPActivityPresenter {

    private IActions mActions;
    private User user;

    public BasicMVPActivityPresenter(IActions iActions) {
        this.mActions = iActions;
        user = new User();
    }

    public void updateFullName(String fullName) {
        user.setFullName(fullName);
        mActions.updateUserInfoTextView(user.toString());

    }

    public void updateEmail(String email) {
        user.setEmail(email);
        mActions.updateUserInfoTextView(user.toString());
    }

    public interface IActions {

        void updateUserInfoTextView(String info);

        void showProgressBar();

        void hideProgressBar();

    }
}
