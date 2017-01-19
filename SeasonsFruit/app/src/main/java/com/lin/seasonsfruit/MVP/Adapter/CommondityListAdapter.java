package com.lin.seasonsfruit.MVP.Adapter;

import com.lin.seasonsfruit.MVP.Entity.HomeGoodsListDto;
import com.xiaochao.lcrapiddeveloplibrary.BaseQuickAdapter;
import com.xiaochao.lcrapiddeveloplibrary.BaseViewHolder;

import java.util.List;

/**
 * Created by lin on 16-12-20.
 */

public class CommondityListAdapter extends BaseQuickAdapter<HomeGoodsListDto> {
    public CommondityListAdapter(int layoutResId, List<HomeGoodsListDto> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, HomeGoodsListDto item) {

    }
}
