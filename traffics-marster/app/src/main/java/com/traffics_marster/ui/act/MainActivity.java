package com.traffics_marster.ui.act;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.traffics_marster.R;
import com.traffics_marster.misc.utils.ActionBarManager;
import com.traffics_marster.misc.utils.GPSUtils;
import com.traffics_marster.misc.weiget.APSTSViewPager;
import com.traffics_marster.mvp.model.MainModel;
import com.traffics_marster.mvp.presenter.MainPresenter;
import com.traffics_marster.mvp.presenter.MvpPresenter;
import com.traffics_marster.mvp.viewer.MainViewer;
import com.traffics_marster.ui.ada.MainacAdapter;

import java.util.ArrayList;

import butterknife.BindView;
import me.majiajie.pagerbottomtabstrip.Controller;
import me.majiajie.pagerbottomtabstrip.PagerBottomTabLayout;
import me.majiajie.pagerbottomtabstrip.listener.OnTabItemSelectListener;

/**
 * Created by Litao-pc on 2016/9/7.
 */
public class MainActivity extends MvpActivity implements MainViewer, OnTabItemSelectListener {
    @BindView(R.id.bottomTabLayout)
    PagerBottomTabLayout bottomTabLayout;
    @BindView(R.id.vpPager)
    APSTSViewPager vpPager;
    private ArrayList<Fragment> arr;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.title)
    TextView title;

    @Override
    protected MvpPresenter createPresenter() {
        return new MainPresenter(new MainModel());
    }

    @Override
    public void bindView(Bundle savedInstanceState) {
        setSupportActionBar(toolbar);
        ActionBarManager.initTitleCenterActionBar(getSupportActionBar());
        title.setText("公路通");
        Controller controller = bottomTabLayout.builder()
                .addTabItem(android.R.drawable.ic_menu_manage, "工具")
                .addTabItem(android.R.drawable.ic_menu_mapmode, "图层")
                .addTabItem(android.R.drawable.ic_menu_myplaces, "采集")
                .addTabItem(android.R.drawable.ic_menu_compass, "选择")
                .addTabItem(android.R.drawable.ic_menu_directions, "属性")
                .build();
        controller.addTabItemClickListener(this);
        controller.setSelect(1);
        vpPager.setAdapter(new MainacAdapter(getSupportFragmentManager()));
        vpPager.setOffscreenPageLimit(5);
        vpPager.setNoFocus(true);

    }

    @Override
    public int getLayoutResId() {
        return R.layout.activity_main;
    }

    @Override
    public void onSelected(int index, Object tag) {

        if(index==2)return;
        vpPager.setCurrentItem(index, true);

    }

    @Override
    public void onRepeatClick(int index, Object tag) {

    }


    @Override
    protected void onResume() {
        super.onResume();
        if (!GPSUtils.isOpenGPSsetting(this)) GPSUtils.openGPSSettings(this);
    }
}
