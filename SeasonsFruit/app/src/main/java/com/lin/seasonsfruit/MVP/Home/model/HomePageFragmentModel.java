package com.lin.seasonsfruit.MVP.Home.model;

import com.lin.seasonsfruit.Data.HttpData.HttpData;
import com.lin.seasonsfruit.MVP.Entity.HomeBannerDto;
import com.lin.seasonsfruit.MVP.Entity.HomeGoodsClassDto;
import com.lin.seasonsfruit.MVP.Entity.HomeGoodsListDto;
import com.lin.seasonsfruit.MVP.Entity.HomeTipDto;
import com.lin.seasonsfruit.MVP.Home.presenter.HomePageFragmentPresenter;

import java.util.List;

import rx.Observer;

/**
 * Created by lin on 16-12-20.
 */

public class HomePageFragmentModel {
    public void loadData(boolean isload,final HomePageFragmentPresenter homePageFragmentPresenter){
//        HttpData.getInstance().getHomeInfo(isload,new Observer<List<HomeDto>>() {
//            @Override
//            public void onCompleted() {
//
//            }
//
//            @Override
//            public void onError(Throwable e) {
//                Log.d("PLPLPL", "loadData--onError:", e);
//                listener.onFailure(e);
//            }
//
//            @Override
//            public void onNext(List<HomeDto> homeDto) {
//                Log.d("PLPLPL", "loadData--banner--imageUrl = " + homeDto.get(0).getBanner().getImageUrl());
//                //listener.onSuccess(homeDto.get(0));
//            }
//        });

        HttpData.getInstance().getHomeBanner(isload, new Observer<List<HomeBannerDto>>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                homePageFragmentPresenter.onFailure(e);
            }

            @Override
            public void onNext(List<HomeBannerDto> homeBannerDtos) {
                homePageFragmentPresenter.onLoadBannerSuccess(homeBannerDtos);
            }
        });
        HttpData.getInstance().getHomeGoodsClass(isload, new Observer<List<HomeGoodsClassDto>>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                homePageFragmentPresenter.onFailure(e);
            }

            @Override
            public void onNext(List<HomeGoodsClassDto> homeGoodsClassDtos) {
                homePageFragmentPresenter.onLoadClassSuccess(homeGoodsClassDtos);
            }
        });
        HttpData.getInstance().getHomeGoodsList(isload, new Observer<List<HomeGoodsListDto>>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                homePageFragmentPresenter.onFailure(e);
            }

            @Override
            public void onNext(List<HomeGoodsListDto> homeGoodsListDtos) {
                homePageFragmentPresenter.onLoadListSuccess(homeGoodsListDtos);
            }
        });
        HttpData.getInstance().getHomeTip(isload, new Observer<List<HomeTipDto>>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                homePageFragmentPresenter.onFailure(e);
            }

            @Override
            public void onNext(List<HomeTipDto> homeTipDtos) {
                homePageFragmentPresenter.onLoadTipSuccess(homeTipDtos);
            }
        });
    }
}
