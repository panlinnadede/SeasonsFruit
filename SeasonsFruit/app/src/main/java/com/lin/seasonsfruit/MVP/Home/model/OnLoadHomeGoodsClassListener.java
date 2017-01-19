package com.lin.seasonsfruit.MVP.Home.model;

import com.lin.seasonsfruit.MVP.Entity.HomeGoodsClassDto;

import java.util.List;

/**
 * Created by lin on 17-1-19.
 */

public interface OnLoadHomeGoodsClassListener {
    void onLoadClassSuccess(List<HomeGoodsClassDto> homeGoodsClassDto);
    void onFailure(Throwable e);
}
