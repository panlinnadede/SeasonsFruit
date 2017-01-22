package com.lin.seasonsfruit.MVP.Home.presenter;


import android.util.Log;

import com.lin.seasonsfruit.MVP.Entity.HomeBannerDto;
import com.lin.seasonsfruit.MVP.Entity.HomeGoodsClassDto;
import com.lin.seasonsfruit.MVP.Entity.HomeGoodsListDto;
import com.lin.seasonsfruit.MVP.Entity.HomeTipDto;
import com.lin.seasonsfruit.MVP.Home.model.HomePageFragmentModel;
import com.lin.seasonsfruit.MVP.Home.model.OnLoadHomeBannerListener;
import com.lin.seasonsfruit.MVP.Home.model.OnLoadHomeGoodsClassListener;
import com.lin.seasonsfruit.MVP.Home.model.OnLoadHomeGoodsListListener;
import com.lin.seasonsfruit.MVP.Home.model.OnLoadHomeTipListener;
import com.lin.seasonsfruit.MVP.Home.view.HomePageFragmentView;

import java.util.List;

/**
 * Created by XY on 2016/9/17.
 */
public class HomePageFragmentPresenter implements /* OnLoadDataListListener<HomeDto> */ OnLoadHomeBannerListener, /*OnLoadHomeGoodsClassListener,*/ OnLoadHomeGoodsListListener, OnLoadHomeTipListener {
    private HomePageFragmentView mView;
    private HomePageFragmentModel mModel;

    public HomePageFragmentPresenter(HomePageFragmentView mView) {
        this.mView = mView;
        this.mModel=new HomePageFragmentModel();
        mView.showProgress();
    }

    public void LoadData(boolean isload){
        mModel.loadData(isload,this);
    }

    @Override
    public void onLoadBannerSuccess(List<HomeBannerDto> homeBannerDto) {
        mView.newHomeBanner(homeBannerDto);
    }

//    @Override
//    public void onLoadClassSuccess(List<HomeGoodsClassDto> homeGoodsClassDto) {
//        mView.newHomeGoodsClass(homeGoodsClassDto);
//    }

    @Override
    public void onLoadListSuccess(List<HomeGoodsListDto> homeGoodsListDto) {
        mView.newHomeGoodsList(homeGoodsListDto);
    }

    @Override
    public void onLoadTipSuccess(List<HomeTipDto> homeTipDto) {
        mView.newHomeTip(homeTipDto);
    }

    @Override
    public void onFailure(Throwable e) {
        Log.d("PLPLPL", "onFailure: e", e);
        mView.showLoadFailMsg();
    }

//    @Override
//    public void onSuccess(HomeDto data) {
//        //mView.newDatas(data);
//        mView.hideProgress();
//    }
//
//    @Override
//    public void onFailure(Throwable e) {
//        mView.showLoadFailMsg();
//    }
}
