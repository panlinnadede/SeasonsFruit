package com.lin.seasonsfruit.MVP.Home.model;

import com.lin.seasonsfruit.MVP.Entity.HomeTipDto;

import java.util.List;

/**
 * Created by lin on 17-1-19.
 */

public interface OnLoadHomeTipListener {
    void onLoadTipSuccess(List<HomeTipDto> homeTipDto);
    void onFailure(Throwable e);
}
