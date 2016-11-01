package com.traffics_marster.ui.act;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.TextView;

import com.traffics_marster.R;
import com.traffics_marster.misc.utils.ActionBarManager;
import com.traffics_marster.mvp.model.LoginModel;
import com.traffics_marster.mvp.presenter.LoginPresenter;
import com.traffics_marster.mvp.presenter.MvpPresenter;

import butterknife.BindView;

/**
 * Created by Litao-pc on 2016/9/12.
 */
public class BGMapActivity extends MvpActivity {
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.title)
    TextView title;

    @Override
    protected MvpPresenter createPresenter() {
        return new LoginPresenter(new LoginModel());
    }

    @Override
    public void bindView(Bundle savedInstanceState) {
        setSupportActionBar(toolbar);
        ActionBarManager.initBackTitle(getSupportActionBar());
        title.setText("背景地图设置");
    }

    @Override
    public int getLayoutResId() {
        return R.layout.activity_bgmap;
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.save, menu);
        return super.onCreateOptionsMenu(menu);
    }
}
