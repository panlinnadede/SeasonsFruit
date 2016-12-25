package com.lin.seasonsfruit.MVP.Home.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lin.seasonsfruit.Constant.Constant;
import com.lin.seasonsfruit.MVP.Adapter.BGABannerAdapter;
import com.lin.seasonsfruit.MVP.Base.BaseFragment;
import com.lin.seasonsfruit.MVP.Entity.BannerDto;
import com.lin.seasonsfruit.MVP.Entity.HomeDto;
import com.lin.seasonsfruit.MVP.Home.presenter.HomePageFragmentPresenter;
import com.lin.seasonsfruit.MVP.Home.view.HomePageFragmentView;
import com.lin.seasonsfruit.R;
import com.xiaochao.lcrapiddeveloplibrary.container.DefaultHeader;
import com.xiaochao.lcrapiddeveloplibrary.viewtype.ProgressActivity;
import com.xiaochao.lcrapiddeveloplibrary.widget.SpringView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.bingoogolapple.bgabanner.BGABanner;

/**
 * Created by lin on 16-12-17.
 */

public class HomePageFragment extends BaseFragment implements HomePageFragmentView, SpringView.OnFreshListener {
    @BindView(R.id.home_page_banner)
    BGABanner homePageBanner;
    @BindView(R.id.home_page_progress)
    ProgressActivity  homePageProgress;
    @BindView(R.id.home_page_springview)
    SpringView homePageSpringview;

    private HomePageFragmentPresenter mHomePageFragmentPresenter;
    private List<BannerDto> mBannerList = new ArrayList<>();

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        return inflater.inflate(R.layout.fragment_home_page, container, false);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    protected void initListener() {
        homePageSpringview.setListener(this);
        homePageSpringview.setHeader(new DefaultHeader(getContext()));

        homePageBanner.setOnItemClickListener(new BGABanner.OnItemClickListener() {

            @Override
            public void onBannerItemClick(BGABanner banner, View view, Object model, int position) {

            }
        });
    }

    @Override
    protected void initData() {
        mHomePageFragmentPresenter = new HomePageFragmentPresenter(this);
        mHomePageFragmentPresenter.LoadData(false);
    }

    @Override
    public void showProgress() {
        //homePageProgress.showLoading();
    }

    @Override
    public void hideProgress() {
        homePageProgress.showContent();
    }

    @Override
    public void newDatas(HomeDto data) {
        mBannerList = data.getBanner();
        List<String> bannerTitle = new ArrayList<>();
        List<String> bannerImage = new ArrayList<>();
        for (int temp = 0 ; temp < data.getBanner().size() ; temp++) {
            bannerTitle.add(data.getBanner().get(temp).getmBannerTitle());
            bannerImage.add(data.getBanner().get(temp).getmImageUrl());
        }
        homePageBanner.setAdapter(new BGABannerAdapter(getActivity()));
        homePageBanner.setData(bannerImage, bannerTitle);
    }

    @Override
    public void showLoadFailMsg() {
        toError();
    }

    public void toError() {
        homePageProgress.showError(getResources().getDrawable(R.mipmap.load_error), Constant.ERROR_TITLE, Constant.ERROR_CONTEXT, Constant.ERROR_BUTTON, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                homePageProgress.showLoading();
                //重试
                mHomePageFragmentPresenter.LoadData(true);
            }
        });
    }

    @Override
    public void onRefresh() {
        mHomePageFragmentPresenter.LoadData(true);
    }

    @Override
    public void onLoadmore() {

    }
}
