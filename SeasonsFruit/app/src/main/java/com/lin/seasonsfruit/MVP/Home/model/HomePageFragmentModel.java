package com.lin.seasonsfruit.MVP.Home.model;

import com.lin.seasonsfruit.Data.HttpData.HttpData;
import com.lin.seasonsfruit.MVP.Entity.HomeDto;

import rx.Observer;

/**
 * Created by lin on 16-12-20.
 */

public class HomePageFragmentModel {
    public void loadData(boolean isload,final OnLoadDataListListener listener){
//        HttpData.getInstance().getHomeInfo(isload,new Observer<HomeDto>() {
//            @Override
//            public void onCompleted() {
//
//            }
//
//            @Override
//            public void onError(Throwable e) {
//                listener.onFailure(e);
//            }
//
//            @Override
//            public void onNext(HomeDto homeDto) {
//                listener.onSuccess(homeDto);
//            }
//        });
    }
}
