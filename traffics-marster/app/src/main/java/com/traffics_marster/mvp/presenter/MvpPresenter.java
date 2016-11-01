package com.traffics_marster.mvp.presenter;

import com.traffics_marster.mvp.model.MvpModel;
import com.traffics_marster.mvp.viewer.MvpView;

import java.lang.ref.WeakReference;

/**
 * Created by Litao-pc on 2016/9/7.
 */
public class MvpPresenter<V extends MvpView, T extends MvpModel> implements BasePresenter<V> {
    public T mModel;

    private WeakReference<V> viewRef;

    public MvpPresenter(T mModel) {
        this.mModel = mModel;
    }

    @Override
    public void attachView(V view) {
        viewRef = new WeakReference<V>(view);
    }

    protected V getView() {
        return viewRef.get();
    }

    protected boolean isViewAttached() {
        return viewRef != null && viewRef.get() != null;
    }

    @Override
    public void detachView(boolean retainInstance) {
        if (viewRef != null) {
            viewRef.clear();
            viewRef = null;
        }
    }
}
