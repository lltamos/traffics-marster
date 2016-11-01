package com.traffics_marster.ui.act;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.traffics_marster.R;
import com.traffics_marster.misc.utils.CommonUtils;
import com.traffics_marster.mvp.model.LoginModel;
import com.traffics_marster.mvp.presenter.LoginPresenter;
import com.traffics_marster.mvp.presenter.MvpPresenter;
import com.traffics_marster.mvp.viewer.LoginViewer;

import butterknife.OnClick;

public class LoginActivity extends MvpActivity implements LoginViewer {

    @OnClick(R.id.btn_submit)
    public void click(View view) {
        finish();
        CommonUtils.toActivity(this, new Intent(this, MainActivity.class));

    }

    @Override
    protected MvpPresenter createPresenter() {
        return new LoginPresenter(new LoginModel());
    }

    @Override
    public void bindView(Bundle savedInstanceState) {

    }

    @Override
    public int getLayoutResId() {
        return R.layout.activity_login;
    }


}
