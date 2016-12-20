package com.lin.seasonsfruit.MVP.Entity;

/**
 * Created by lin on 16-12-17.
 *
 * 滚动横幅的属性集合类
 */

public class BannerDto {
    /**
     * id : 1
     * imageUrl : http://odog3v89f.bkt.c    louddn.com/banner/banner1.png
     * mBannerTitle : 游离在正邪边缘的人:残袍
     * mCommondityId : 29286
     */

    private int mId;
    private String mImageUrl;
    private String mBannerTitle;
    private int mCommondityId;

    public void setmId(int mId) {
        this.mId = mId;
    }

    public void setmImageUrl(String mImageUrl) {
        this.mImageUrl = mImageUrl;
    }

    public void setmBannerTitle(String mBannerTitle) {
        this.mBannerTitle = mBannerTitle;
    }

    public String getmBannerTitle() {
        return mBannerTitle;
    }

    public String getmImageUrl() {
        return mImageUrl;
    }

    public int getmId() {
        return mId;
    }

    public void setmCommondityId(int mCommondityId) {
        this.mCommondityId = mCommondityId;
    }

    public int getmCommondityId() {
        return mCommondityId;
    }

}
