package com.lin.seasonsfruit.MVP.Home.presenter;


import com.lin.seasonsfruit.MVP.Entity.HomeDto;
import com.lin.seasonsfruit.MVP.Home.model.HomePageFragmentModel;
import com.lin.seasonsfruit.MVP.Home.model.OnLoadDataListListener;
import com.lin.seasonsfruit.MVP.Home.view.HomePageFragmentView;

/**
 * Created by XY on 2016/9/17.
 */
public class HomePageFragmentPresenter implements OnLoadDataListListener<HomeDto> {
    private HomePageFragmentView mView;
    private HomePageFragmentModel mModel;

    public HomePageFragmentPresenter(HomePageFragmentView mView) {
        this.mView = mView;
        this.mModel=new HomePageFragmentModel();
        mView.showProgress();
    }

    public void LoadData(boolean isload){
        mModel.loadData(isload,this);
    }

    @Override
    public void onSuccess(HomeDto data) {
        mView.newDatas(data);
        mView.hideProgress();
    }

    @Override
    public void onFailure(Throwable e) {
        mView.showLoadFailMsg();
    }
}
