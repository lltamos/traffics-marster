package com.traffics_marster.mvp.presenter;

import com.traffics_marster.mvp.model.MainModel;
import com.traffics_marster.mvp.viewer.MainViewer;

/**
 * Created by Litao-pc on 2016/9/7.
 */
public class MainPresenter extends MvpPresenter<MainViewer, MainModel> {
    public MainPresenter(MainModel mModel) {
        super(mModel);
    }
}
