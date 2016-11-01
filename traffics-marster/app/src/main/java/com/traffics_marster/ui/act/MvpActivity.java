package com.traffics_marster.ui.act;

import android.os.Bundle;
import android.view.View;

import com.traffics_marster.mvp.presenter.MvpPresenter;
import com.traffics_marster.mvp.viewer.MvpView;

/**
 * Created by Litao-pc on 2016/9/7.
 */
public abstract class MvpActivity<P extends MvpPresenter> extends BaseActivity implements MvpView {
    protected P presenter;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (presenter == null) {
            presenter = createPresenter();
        }
        presenter.attachView(this);
    }

    protected abstract P createPresenter();


    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.detachView(false);
    }



    @Override
    public View getRootView() {
        return mRootView;
    }


}
