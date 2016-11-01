package com.traffics_marster.ui.ada;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import butterknife.ButterKnife;

/**
 * Created by Litao-pc on 2016/6/15.
 */
public class BaseHolder<T> extends RecyclerView.ViewHolder {

    public View mView;
    protected T mData;
    protected Context mContext;

    public BaseHolder(View itemView) {
        super(itemView);
        this.mView = itemView;
        ButterKnife.bind(this, mView);
        mContext = itemView.getContext();
        init();

    }

    public void init() {
    }

    public void setData(T mData) {
        this.mData = mData;
    }
}
