package com.lin.seasonsfruit.MVP.Home.view;


import com.lin.seasonsfruit.MVP.Entity.HomeBannerDto;
import com.lin.seasonsfruit.MVP.Entity.HomeDto;
import com.lin.seasonsfruit.MVP.Entity.HomeGoodsClassDto;
import com.lin.seasonsfruit.MVP.Entity.HomeGoodsListDto;
import com.lin.seasonsfruit.MVP.Entity.HomeTipDto;

import java.util.List;

/**
 * Created by XY on 2016/9/17.
 */
public interface HomePageFragmentView {
    //显示加载页
    void showProgress();

    //关闭加载页
    void hideProgress();

    //加载新数据
    //void newDatas(HomeDto data);

    //加载首页Banner
    void newHomeBanner(List<HomeBannerDto> homeBannerDto);

    //加载首页商品分类
    void newHomeGoodsClass(List<HomeGoodsClassDto> homeGoodsClassDto);

    //加载首页商品列表
    void newHomeGoodsList(List<HomeGoodsListDto> homeGoodsListDto);

    //加载首页提示信息
    void newHomeTip(List<HomeTipDto> homeTipDto);

    //显示加载失败
    void showLoadFailMsg();

}
