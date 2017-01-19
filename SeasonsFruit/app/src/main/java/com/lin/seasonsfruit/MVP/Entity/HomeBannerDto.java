package com.lin.seasonsfruit.MVP.Entity;

import cn.bmob.v3.BmobObject;

/**
 * Created by XY on 2016/9/17.
 */
public class HomeBannerDto extends BmobObject {

    /**
     * id : 1
     * imageUrl : http://odog3v89f.bkt.clouddn.com/banner/banner1.png
     * bannerTitle : 游离在正邪边缘的人:残袍
     * goodsId : 29286
     */

    private int id;
    private String imageUrl;
    private String bannerTitle;
    private int goodsId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getBannerTitle() {
        return bannerTitle;
    }

    public void setBannerTitle(String bannerTitle) {
        this.bannerTitle = bannerTitle;
    }

    public int getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(int goodsId) {
        this.goodsId = goodsId;
    }
}