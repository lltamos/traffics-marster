package com.traffics_marster.ui.frg;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;

import com.esri.android.map.MapView;
import com.esri.android.map.ags.ArcGISTiledMapServiceLayer;
import com.esri.android.runtime.ArcGISRuntime;
import com.traffics_marster.R;
import com.traffics_marster.mvp.model.LoginModel;
import com.traffics_marster.mvp.presenter.LoginPresenter;
import com.traffics_marster.mvp.presenter.MvpPresenter;

import butterknife.BindString;
import butterknife.BindView;
import cn.pedant.SweetAlert.ProgressHelper;
import cn.pedant.SweetAlert.SweetAlertDialog;

/**
 * Created by Litao-pc on 2016/9/7.
 * 图层
 */
public class LayerFragment extends MvpFragment {
    @BindString(R.string.basemap_url)
    String BASEURL;
    @BindView(R.id.map)
    MapView mMap;
    @BindView(R.id.btn)
    Button btn;


    @Override
    protected MvpPresenter createPresenter() {
        return new LoginPresenter(new LoginModel());
    }

    @Override
    public void bindView(Bundle savedInstanceState) {
        ArcGISRuntime.setClientId("1eFHW78avlnRUPHm");
        ArcGISTiledMapServiceLayer dynamicLayout = new ArcGISTiledMapServiceLayer(BASEURL);
        mMap.addLayer(dynamicLayout);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                SweetAlertDialog ss = new SweetAlertDialog(getContext(), SweetAlertDialog.NORMAL_TYPE)

                        .setTitleText("Are you sure?")
                        .setContentText("Won't be able to recover this file!")
                        .setConfirmText("Yes,delete it!")
                        .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                            @Override
                            public void onClick(SweetAlertDialog sDialog) {
                                sDialog
                                        .setTitleText("Deleted!")
                                        .setContentText("Your imaginary f")
                                        .setConfirmText("OK")
                                        .setConfirmClickListener(null)
                                        .changeAlertType(SweetAlertDialog.SUCCESS_TYPE);

                            }
                        });

                ProgressHelper p= ss.getProgressHelper();
                p.setRimWidth(1000);
                p.setInstantProgress(10f);
                p.setBarWidth(1000);
                p.setBarColor(Color.RED);
                ss.show();
            }
        });

    }

    @Override
    public int getLayoutResId() {
        return R.layout.fragment_layer;
    }


    @Override
    public void onClick(View view) {
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

    }


}
