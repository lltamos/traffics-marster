package com.traffics_marster.ui.act;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;

import com.traffics_marster.R;
import com.traffics_marster.misc.inter.CommonListener;
import com.traffics_marster.misc.inter.IBase;
import com.traffics_marster.misc.utils.KeyboardUtils;
import com.traffics_marster.misc.utils.SystemBarTintManager;

import org.greenrobot.eventbus.EventBus;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by Litao-pc on 2016/9/7.
 */
public abstract class BaseActivity extends AppCompatActivity implements IBase, CommonListener {
    protected View mRootView;
    protected final String sClassName = getClass().getSimpleName();
    private Unbinder unbinder;
    private Context mContext;


    /**
     * 退出时之前的界面进入动画,可在finish();前通过改变它的值来改变动画效果
     */
    protected int enterAnim = R.anim.fade;
    /**
     * 退出时该界面动画,可在finish();前通过改变它的值来改变动画效果
     */
    protected int exitAnim = R.anim.right_push_out;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        createView(null, null, savedInstanceState);
        mContext = this;
        hintStatusBar();
        bindView(savedInstanceState);

    }

    @Override
    public View createView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        int layoutRes = getLayoutResId();
        if (layoutRes == 0) {
            throw new IllegalArgumentException("implements getLayoutRes not 0");
        } else {
            mRootView = View.inflate(this, layoutRes, null);
        }
        super.setContentView(mRootView);
        unbinder = ButterKnife.bind(this);
        return mRootView;
    }


    //是否开启称沉浸状态栏
    public void hintStatusBar() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            setTranslucentStatus(true);
        }
        SystemBarTintManager tintManager = new SystemBarTintManager(this);
        tintManager.setStatusBarTintEnabled(true);
        tintManager.setNavigationBarTintEnabled(true);
        tintManager.setTintColor(Color.parseColor("#303F9F"));//通知栏所需颜
    }

    @TargetApi(19)
    private void setTranslucentStatus(boolean on) {
        Window win = getWindow();
        WindowManager.LayoutParams winParams = win.getAttributes();
        final int bits = WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS;
        if (on) {
            winParams.flags |= bits;
        } else {
            winParams.flags &= ~bits;
        }
        win.setAttributes(winParams);
    }


    @Override
    protected void onDestroy() {
        unbinder.unbind();
        EventBus.getDefault().unregister(this);
        super.onDestroy();

    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * activity退出时隐藏软键盘需要，需要在调用finish方法前赋值
     */
    protected View toGetWindowTokenView = null;

    @Override
    public void finish() {
        super.finish();//必须写在最前才能显示自定义动画
        this.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                if (toGetWindowTokenView != null) {
                    KeyboardUtils.hideKeyboard(BaseActivity.this, toGetWindowTokenView);
                }
                if (enterAnim > 0 && exitAnim > 0) {
                    try {
                        overridePendingTransition(enterAnim, exitAnim);
                    } catch (Exception e) {
                        Log.e(sClassName, "finish overridePendingTransition(enterAnim, exitAnim);" +
                                " >> catch (Exception e) {  " + e.getMessage());
                    }
                }
            }
        });
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
    public void onClick(View view) {

    }
}
