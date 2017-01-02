package com.lin.seasonsfruit.Application;

import android.app.Activity;
import android.app.Application;

import com.lin.seasonsfruit.MVP.WelcomeActivity;
import com.xiaochao.lcrapiddeveloplibrary.Exception.core.Recovery;

import java.util.ArrayList;
import java.util.List;

import cn.bmob.v3.Bmob;
import cn.bmob.v3.BmobConfig;

/**
 * Created by lin on 16-12-18.
 */

public class CustomApplication extends Application {
    private static CustomApplication instance;
    //记录当前栈里的所有Activity
    private List<Activity> activities = new ArrayList<Activity>();

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;

        //异常友好管理初始化
        Recovery.getInstance()
                .debug(true)
                .recoverInBackground(false)
                .recoverStack(true)
                .mainPage(WelcomeActivity.class)
                //.skip(H5PayActivity.class) //集成支付宝支付，需要这句代码
                .init(this);

        Bmob.initialize(this, "5ac6f261133446a4ab5bf85b761086f4");

        //第二：自v3.4.7版本开始,设置BmobConfig,允许设置请求超时时间、文件分片上传时每片的大小、文件的过期时间(单位为秒)，
        BmobConfig config = new BmobConfig.Builder(this)
        //设置appkey
        .setApplicationId("5ac6f261133446a4ab5bf85b761086f4")
        //请求超时时间（单位为秒）：默认15s
        .setConnectTimeout(30)
        //文件分片上传时每片的大小（单位字节），默认512*1024
        .setUploadBlockSize(1024*1024)
        //文件的过期时间(单位为秒)：默认1800s
        .setFileExpiration(2500)
        .build();
        Bmob.initialize(config);
    }

    public static CustomApplication getApplication () {
        return instance;
    }

    /**
     * 新建一个Activity
     * @param activity
     */
    public void addActivity (Activity activity) {
        activities.add(activity);
    }

    public void finishActivity (Activity activity) {
        if (activity != null) {
            activities.remove(activity);
            activity.finish();
            activity = null;
        }
    }

    public void exit () {
        for (Activity activity : activities) {
            if (activity != null) {
                activity.finish();
            }
        }
        System.exit(0);
    }
}
