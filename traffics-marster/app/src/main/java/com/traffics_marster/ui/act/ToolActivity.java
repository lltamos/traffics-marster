package com.traffics_marster.ui.act;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.traffics_marster.R;
import com.traffics_marster.bean.Menu;
import com.traffics_marster.misc.conf.MenuEnum;
import com.traffics_marster.misc.utils.ActionBarManager;
import com.traffics_marster.misc.utils.CommonUtils;
import com.traffics_marster.mvp.model.LoginModel;
import com.traffics_marster.mvp.presenter.LoginPresenter;
import com.traffics_marster.mvp.presenter.MvpPresenter;
import com.traffics_marster.ui.ada.PartAdapter;

import butterknife.BindArray;
import butterknife.BindView;

/**
 * Created by Litao-pc on 2016/9/12.
 */
public class ToolActivity extends MvpActivity {
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.title)
    TextView title;
    @BindView(R.id.listView)
    ListView listView;
    @BindArray(R.array.tool_set)
    String[] SETTING_NAME;
    private Menu[] enums;

    @Override
    protected MvpPresenter createPresenter() {
        return new LoginPresenter(new LoginModel());
    }

    @Override
    public void bindView(Bundle savedInstanceState) {
        setSupportActionBar(toolbar);
        ActionBarManager.initBackTitle(getSupportActionBar());
        title.setText("设置");
        enums = MenuEnum.getName("1");
        listView.setAdapter(new PartAdapter(this, enums));
        listView.setOnItemClickListener(this);

    }


    @Override
    public int getLayoutResId() {
        return R.layout.activity_tool;
    }



    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        CommonUtils.toActivity(this, new Intent(this, enums[i].getClazz()));

    }


}
