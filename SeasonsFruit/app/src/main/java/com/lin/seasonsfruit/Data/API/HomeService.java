package com.lin.seasonsfruit.Data.API;

import com.lin.seasonsfruit.Constant.Constant;
import com.lin.seasonsfruit.MVP.Entity.HomeBannerDto;
import com.lin.seasonsfruit.MVP.Entity.HomeGoodsClassDto;
import com.lin.seasonsfruit.MVP.Entity.HomeGoodsListDto;
import com.lin.seasonsfruit.MVP.Entity.HomeTipDto;

import java.util.List;
import java.util.Map;

import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import rx.Observable;

/**
 * API接口
 * 因为使用RxCache作为缓存策略 所以这里不需要写缓存信息
 */
public interface HomeService {

    @Headers({"X-Bmob-Application-Id:"+ Constant.APPLICATION_ID,
            "X-Bmob-REST-API-Key:"+Constant.REST_APP_KEY})
    @GET("1/classes/HomeBannerDto")
    Observable<Map<String,List<HomeBannerDto>>> getHomeBanner();

//    @Headers({"X-Bmob-Application-Id:"+ Constant.APPLICATION_ID,
//            "X-Bmob-REST-API-Key:"+Constant.REST_APP_KEY})
//    @GET("1/classes/HomeGoodsClassDto")
//    Observable<Map<String,List<HomeGoodsClassDto>>> getHomeGoodsClass();

    @Headers({"X-Bmob-Application-Id:"+ Constant.APPLICATION_ID,
            "X-Bmob-REST-API-Key:"+Constant.REST_APP_KEY})
    @GET("1/classes/HomeGoodsListDto?include=goodsClass")
    Observable<Map<String,List<HomeGoodsListDto>>> getHomeGoodsList();

    @Headers({"X-Bmob-Application-Id:"+ Constant.APPLICATION_ID,
            "X-Bmob-REST-API-Key:"+Constant.REST_APP_KEY})
    @GET("1/classes/HomeTipDto")
    Observable<Map<String,List<HomeTipDto>>> getHomeTip();
}
