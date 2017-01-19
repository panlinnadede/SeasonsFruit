package com.lin.seasonsfruit.MVP.Home.model;

import com.lin.seasonsfruit.MVP.Entity.HomeBannerDto;

import java.util.List;

/**
 * Created by lin on 17-1-19.
 */

public interface OnLoadHomeBannerListener {
    void onLoadBannerSuccess(List<HomeBannerDto> homeBannerDto);
    void onFailure(Throwable e);
}
