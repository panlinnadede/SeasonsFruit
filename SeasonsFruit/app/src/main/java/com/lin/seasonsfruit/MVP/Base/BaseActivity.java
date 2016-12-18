package com.lin.seasonsfruit.MVP.Base;

import android.content.Context;
import android.content.pm.ActivityInfo;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.widget.Toast;

import com.lin.seasonsfruit.Application.CustomApplication;

import butterknife.ButterKnife;

/**
 * Created by lin on 16-12-17.
 */

public abstract class BaseActivity extends AppCompatActivity {
    protected Context mContext;
    private ConnectivityManager mConnectivityManager;
    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        mContext = getActivityContext();
        initView();
        ButterKnife.bind(this);
        initData();
        CustomApplication.getApplication().addActivity(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        CustomApplication.getApplication().finishActivity(this);
    }

    protected abstract Context getActivityContext();

    private void initView() {
        loadViewLayout();
    }

    private void initData() {
        findViewById();
        setListener();
        processLogic();
    }

    /**
     * 加载页面Layout
     */
    protected abstract void loadViewLayout();

    /**
     * 加载页面元素
     */
    protected abstract void findViewById();

    /**
     * 设置各种事件的监听
     */
    protected abstract void setListener();

    /**
     * 业务逻辑处理，主要与后端交互
     */
    protected abstract void processLogic();

    public void showToast(String toastContent) {
        Toast toast = Toast.makeText(this, toastContent, Toast.LENGTH_LONG);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();
    }
}
