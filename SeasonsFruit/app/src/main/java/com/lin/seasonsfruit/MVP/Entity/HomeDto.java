package com.lin.seasonsfruit.MVP.Entity;

import java.util.List;

/**
 * Created by lin on 16-12-20.
 */

public class HomeDto {
    private List<BannerDto> banner;

    public List<BannerDto> getBanner() {
        return banner;
    }

    public void setBanner(List<BannerDto> banner) {
        this.banner = banner;
    }
}
