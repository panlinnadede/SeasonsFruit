package com.lin.seasonsfruit.MVP.Adapter;

import com.lin.seasonsfruit.MVP.Entity.CommondityListDto;
import com.xiaochao.lcrapiddeveloplibrary.BaseQuickAdapter;
import com.xiaochao.lcrapiddeveloplibrary.BaseViewHolder;

import java.util.List;

/**
 * Created by lin on 16-12-20.
 */

public class CommondityListAdapter extends BaseQuickAdapter<CommondityListDto> {
    public CommondityListAdapter(int layoutResId, List<CommondityListDto> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, CommondityListDto item) {

    }
}
