package com.lin.seasonsfruit.Data.HttpData;


import com.lin.seasonsfruit.Data.API.HomeCacheProviders;
import com.lin.seasonsfruit.Data.API.HomeService;
import com.lin.seasonsfruit.Data.Retrofit.RetrofitUtils;
import com.lin.seasonsfruit.MVP.Entity.HomeBannerDto;
import com.lin.seasonsfruit.MVP.Entity.HomeGoodsClassDto;
import com.lin.seasonsfruit.MVP.Entity.HomeGoodsListDto;
import com.lin.seasonsfruit.MVP.Entity.HomeTipDto;
import com.lin.seasonsfruit.Util.FileUtil;

import java.io.File;
import java.util.List;
import java.util.Map;

import io.rx_cache.DynamicKey;
import io.rx_cache.EvictDynamicKey;
import io.rx_cache.Reply;
import io.rx_cache.internal.RxCache;
import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/*
 *所有的请求数据的方法集中地
 * 根据MovieService的定义编写合适的方法
 * 其中observable是获取API数据
 * observableCahce获取缓存数据
 * new EvictDynamicKey(false) false使用缓存  true 加载数据不使用缓存
 */
public class HttpData extends RetrofitUtils {

    private static File cacheDirectory = FileUtil.getcacheDirectory();
    private static final HomeCacheProviders providers = new RxCache.Builder()
            .persistence(cacheDirectory)
            .using(HomeCacheProviders.class);
    protected static final HomeService service = getRetrofit().create(HomeService.class);

    //在访问HttpMethods时创建单例
    private static class SingletonHolder {
        private static final HttpData INSTANCE = new HttpData();
    }

    //获取单例
    public static HttpData getInstance() {
        return SingletonHolder.INSTANCE;
    }

//    //获取app书本类别
//    public void getBookTypes(Observer<List<BookTypeDto>> observer){
//        Observable observable=service.getTypeList().map(new HttpResultFunc<List<BookTypeDto>>());
//        Observable observableCahce=providers.getTypeList(observable,new DynamicKey("书本类别"),new EvictDynamicKey(false)).map(new HttpResultFuncCcche<List<BookTypeDto>>());
//        setSubscribe(observableCahce,observer);
//    }
    //获取app首页配置信息  banner  最新 最热
//    public void getHomeInfo(boolean isload,Observer<List<HomeDto>> observer){
////        Observable observable=service.getHomeInfo().map(new HttpResultFunc<HomeDto>());
//        Observable observable=service.getHomeInfo()
//                .flatMap(new Func1<Map<String, List<HomeDto>>, Observable<?>>() {
//                    @Override
//                    public Observable<?> call(Map<String, List<HomeDto>> map) {
//                        return Observable.just(map.get("results"));
//                    }
//                })
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .unsubscribeOn(Schedulers.io());
//        observable.subscribe(observer);
//
////        Observable observableCache=providers.getHomeInfo(observable,new DynamicKey("首页配置"),new EvictDynamicKey(isload)).map(new HttpResultFuncCcche<HomeDto>());
////        setSubscribe(observableCache,observer);
//    }

    public void getHomeBanner(boolean isload,Observer<List<HomeBannerDto>> observer){
        Observable observable=service.getHomeBanner().flatMap(new HttpResultFunc<List<HomeBannerDto>>());
        Observable observableCache = providers.getHomeBanner(observable, new DynamicKey("Banner配置"),new EvictDynamicKey(isload)).map(new HttpResultFuncCache<List<HomeBannerDto>>());
        setSubscribe(observableCache, observer);
    }

//    public void getHomeGoodsClass(boolean isload,Observer<List<HomeGoodsClassDto>> observer){
//        Observable observable=service.getHomeGoodsClass().flatMap(new HttpResultFunc<List<HomeGoodsClassDto>>());
//        Observable observableCache = providers.getHomeGoodsClass(observable, new DynamicKey("商品分类"), new EvictDynamicKey(isload)).map(new HttpResultFuncCache<List<HomeGoodsClassDto>>());
//        setSubscribe(observableCache, observer);
//    }

    public void getHomeGoodsList(boolean isload,Observer<List<HomeGoodsListDto>> observer){
        Observable observable=service.getHomeGoodsList().flatMap(new HttpResultFunc<List<HomeGoodsListDto>>());
        Observable observableCache = providers.getHomeGoodsList(observable, new DynamicKey("商品列表"), new EvictDynamicKey(isload)).map(new HttpResultFuncCache<List<HomeGoodsListDto>>());
        setSubscribe(observableCache, observer);
    }

    public void getHomeTip(boolean isload,Observer<List<HomeTipDto>> observer){
        Observable observable=service.getHomeTip().flatMap(new HttpResultFunc<List<HomeTipDto>>());
        Observable observableCache = providers.getHomeTip(observable, new DynamicKey("首页提示"), new EvictDynamicKey(isload)).map(new HttpResultFuncCache<List<HomeTipDto>>());
        setSubscribe(observableCache, observer);
    }

    /**
     * 插入观察者
     *
     * @param observable
     * @param observer
     * @param <T>
     */
//    public static <T> void setSubscribe(Observable<T> observable, Observer<T> observer) {
//        observable.subscribeOn(Schedulers.io())
//                .subscribeOn(Schedulers.newThread())//子线程访问网络
//                .observeOn(AndroidSchedulers.mainThread())//回调到主线程
//                .subscribe(observer);
//    }

    public static <T> void setSubscribe(Observable<T> observable, Observer<T> observer) {
        observable.subscribeOn(Schedulers.io())
                .subscribeOn(Schedulers.newThread())//子线程访问网络
                .observeOn(AndroidSchedulers.mainThread())//回调到主线程
                .subscribe(observer);
    }

    /**
     * 用来统一处理Http的resultCode,并将HttpResult的Data部分剥离出来返回给subscriber
     *
     * @param <T>   Subscriber真正需要的数据类型，也就是Data部分的数据类型
     */
//    private  class HttpResultFunc<T> implements Func1<HttpResult<T>, T> {
//
//        @Override
//        public T call(HttpResult<T> httpResult) {
//            Log.d("PLPLPL", "HttpResultFunc--call: httpResult.getCode = " + httpResult.getCode() + " httpResult.getData = " + httpResult.getData());
//            if (httpResult.getCode() !=1 ) {
//                throw new ApiException(httpResult);
//            }
//            return httpResult.getData();
//        }
//    }

    private class HttpResultFunc<T> implements Func1<Map<String, T>, Observable<?>> {
        @Override
        public Observable<?> call(Map<String, T> map) {
            return Observable.just(map.get("results"));
        }
    }

    /**
     * 用来统一处理RxCacha的结果
     */
//    private  class HttpResultFuncCcche<T> implements Func1<Reply<T>, T> {
//
//        @Override
//        public T call(Reply<T> httpResult) {
//            return httpResult.getData();
//        }
//    }

    private class HttpResultFuncCache<T> implements Func1<Reply<T>, T> {
        @Override
        public T call(Reply<T> tReply) {
            return tReply.getData();
        }
    }

}
