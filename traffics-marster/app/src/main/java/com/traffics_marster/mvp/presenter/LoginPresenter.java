package com.traffics_marster.mvp.presenter;

import com.traffics_marster.mvp.model.LoginModel;
import com.traffics_marster.mvp.viewer.LoginViewer;

/**
 * Created by Litao-pc on 2016/9/7.
 */
public class LoginPresenter extends MvpPresenter<LoginViewer,LoginModel>  {

    public LoginPresenter(LoginModel mModel) {
        super(mModel);
    }
}
