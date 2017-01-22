package com.lin.seasonsfruit.MVP.Entity;

import cn.bmob.v3.BmobObject;

/**
 * Created by XY on 2016/9/17.
 */
public class HomeDto extends BmobObject {
    private HomeBannerDto banner;
    private HomeGoodsClassDto classification;
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

    public HomeTipDto getDistribution() {
        return distribution;
    }

    public void setDistribution(HomeTipDto distribution) {
        this.distribution = distribution;
    }
}
