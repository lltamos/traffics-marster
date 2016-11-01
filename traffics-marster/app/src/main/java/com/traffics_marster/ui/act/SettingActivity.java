package com.traffics_marster.ui.act;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
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
public class SettingActivity extends MvpActivity {
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
        title.setText("采集设置");
    }


    @Override
    public int getLayoutResId() {
        return R.layout.activity_setting;
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.save, menu);
        return true;
    }
}
