package com.traffics_marster.ui.frg;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

import com.traffics_marster.mvp.presenter.MvpPresenter;
import com.traffics_marster.mvp.viewer.MvpView;

/**
 * Created by Litao-pc on 2016/9/7.
 */
public abstract class MvpFragment<P extends MvpPresenter> extends BaseFragment implements
        MvpView {

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
    public void onDestroy() {
        super.onDestroy();
        presenter.detachView(false);
    }


    public void hideSoftKeyboard() {
        View view = getActivity().getCurrentFocus();
        if (view != null) {
            InputMethodManager inputManager = (InputMethodManager) getActivity().getSystemService(
                    Context.INPUT_METHOD_SERVICE);
            inputManager.hideSoftInputFromWindow(view.getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
        }
    }
}
