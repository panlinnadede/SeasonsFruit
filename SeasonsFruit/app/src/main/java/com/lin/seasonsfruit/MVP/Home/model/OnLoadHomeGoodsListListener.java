package com.lin.seasonsfruit.MVP.Home.model;

import com.lin.seasonsfruit.MVP.Entity.HomeGoodsListDto;

import java.util.List;

/**
 * Created by lin on 17-1-19.
 */

public interface OnLoadHomeGoodsListListener {
    void onLoadListSuccess(List<HomeGoodsListDto> homeGoodsListDto);
    void onFailure(Throwable e);
}
