package com.lin.seasonsfruit.MVP.Entity;

import cn.bmob.v3.datatype.BmobPointer;
import cn.bmob.v3.datatype.BmobRelation;

/**
 * Created by lin on 16-12-20.
 *
 * 商品列表
 */

public class HomeGoodsListDto extends BmobRelation {
    private int id;
    private int goodsId;
    private String goodsName;
    private float goodsPrice;
    private String imageUrl;
    private String goodsTag;
    private int saleAmount;
    private String goodsIntroduction;
    private HomeGoodsClassDto goodsClass;

    public HomeGoodsClassDto getGoodsClass() {
        return goodsClass;
    }

    public void setGoodsClass(HomeGoodsClassDto goodsClass) {
        this.goodsClass = goodsClass;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setGoodsId(int goodsId) {
        this.goodsId = goodsId;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public void setGoodsPrice(float goodsPrice) {
        this.goodsPrice = goodsPrice;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public void setGoodsTag(String goodsTag) {
        this.goodsTag = goodsTag;
    }

    public void setSaleAmount(int saleAmount) {
        this.saleAmount = saleAmount;
    }

    public void setGoodsIntroduction(String goodsIntroduction) {
        this.goodsIntroduction = goodsIntroduction;
    }

    public int getId() {
        return id;
    }

    public int getGoodsId() {
        return goodsId;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public float getGoodsPrice() {
        return goodsPrice;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getGoodsTag() {
        return goodsTag;
    }

    public int getSaleAmount() {
        return saleAmount;
    }

    public String getGoodsIntroduction() {
        return goodsIntroduction;
    }
}
