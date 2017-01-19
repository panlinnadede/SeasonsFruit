package com.lin.seasonsfruit.MVP.Entity;

import cn.bmob.v3.BmobObject;

/**
 * Created by XY on 2016/9/17.
 */
public class HomeDto extends BmobObject {
    private HomeBannerDto banner;
    private HomeGoodsClassDto classification;
    private HomeGoodsListDto goodsList;
    private HomeTipDto distribution;

    public HomeBannerDto getBanner() {
        return banner;
    }

    public void setBanner(HomeBannerDto banner) {
        this.banner = banner;
    }

    public HomeGoodsClassDto getClassification() {
        return classification;
    }

    public void setClassification(HomeGoodsClassDto classification) {
        this.classification = classification;
    }

    public HomeGoodsListDto getGoodsList() {
        return goodsList;
    }

    public void setGoodsList(HomeGoodsListDto goodsList) {
        this.goodsList = goodsList;
    }

    public HomeTipDto getDistribution() {
        return distribution;
    }

    public void setDistribution(HomeTipDto distribution) {
        this.distribution = distribution;
    }
}
