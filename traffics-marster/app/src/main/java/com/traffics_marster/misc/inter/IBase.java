package com.traffics_marster.misc.inter;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * Created by Litao-pc on 2016/6/6.
 */
public interface IBase {
    View createView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState);

    void bindView(Bundle savedInstanceState);

    View getRootView();

    int getLayoutResId();


}
