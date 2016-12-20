package com.lin.seasonsfruit.MVP.Home.view;


import com.lin.seasonsfruit.MVP.Entity.HomeDto;

/**
 * Created by XY on 2016/9/17.
 */
public interface HomePageFragmentView {
    //显示加载页
    void showProgress();
    //关闭加载页
    void hideProgress();
    //加载新数据
    void newDatas(HomeDto data);
    //显示加载失败
    void showLoadFailMsg();

}
