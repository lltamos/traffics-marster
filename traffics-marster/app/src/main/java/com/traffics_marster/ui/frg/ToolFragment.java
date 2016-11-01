package com.traffics_marster.ui.frg;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.traffics_marster.R;
import com.traffics_marster.bean.Menu;
import com.traffics_marster.misc.conf.MenuEnum;
import com.traffics_marster.misc.utils.CommonUtils;
import com.traffics_marster.misc.utils.LoggerUtils;
import com.traffics_marster.mvp.model.LoginModel;
import com.traffics_marster.mvp.presenter.LoginPresenter;
import com.traffics_marster.mvp.presenter.MvpPresenter;
import com.traffics_marster.ui.ada.PartAdapter;

import butterknife.BindArray;
import butterknife.BindView;

/**
 * Created by Litao-pc on 2016/9/7.
 * 工具
 */
public class ToolFragment extends MvpFragment {
    @BindArray(R.array.fr_tool_fields)
    String[] FIELD_TOOL;
    @BindArray(R.array.fr_tool_fields_icon)
    String[] ICON_TOOL;
    @BindView(R.id.listView)
    ListView listView;
    private Menu[] enums;


    @Override
    protected MvpPresenter createPresenter() {
        return new LoginPresenter(new LoginModel());
    }

    @Override
    public void bindView(Bundle savedInstanceState) {
        enums = MenuEnum.getName("0");
        listView.setAdapter(new PartAdapter(mContext, enums));
        listView.setOnItemClickListener(this);
    }

    @Override
    public int getLayoutResId() {
        return R.layout.fragment_tool;
    }


    @Override
    public void onClick(View view) {
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        LoggerUtils.d("xx",enums[i].getClass().toString());
        CommonUtils.toActivity(mContext, new Intent(mContext, enums[i].getClazz()));
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
