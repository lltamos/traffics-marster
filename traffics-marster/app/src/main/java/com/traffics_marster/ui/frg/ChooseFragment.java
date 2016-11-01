package com.traffics_marster.ui.frg;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;

import com.traffics_marster.R;
import com.traffics_marster.mvp.model.LoginModel;
import com.traffics_marster.mvp.presenter.LoginPresenter;
import com.traffics_marster.mvp.presenter.MvpPresenter;

/**
 * Created by Litao-pc on 2016/9/7.
 */
public class ChooseFragment  extends MvpFragment{
    @Override
    protected MvpPresenter createPresenter() {
        return new LoginPresenter(new LoginModel());
    }


    @Override
    public void bindView(Bundle savedInstanceState) {

    }

    @Override
    public int getLayoutResId() {
        return R.layout.fragment_choose;
    }

    @Override
    public void onClick(View view) {

    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
