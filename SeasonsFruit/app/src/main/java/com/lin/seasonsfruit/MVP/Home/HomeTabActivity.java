package com.lin.seasonsfruit.MVP.Home;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.lin.seasonsfruit.MVP.Base.BaseActivity;
import com.lin.seasonsfruit.MVP.Home.Fragment.FragmentController;
import com.lin.seasonsfruit.R;

import butterknife.BindView;

public class HomeTabActivity extends BaseActivity
        implements RadioGroup.OnCheckedChangeListener {

    @BindView(R.id.home_radio_group)
    RadioGroup homeRadioGroup;
    @BindView(R.id.hometab_toolbar_textview_title)
    TextView hometabToolbarTextviewTitle;

    private FragmentController mFragmentController;

    private String mHomeRadioTitle;
    private String mSpellRadioTitle;
    private String mShoppingCartTitle;
    private String mPersonalTitle;

    @Override
    protected void onDestroy() {
        mFragmentController.onDestroy();
        super.onDestroy();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected Context getActivityContext() {
        return this;
    }

    @Override
    protected void loadViewLayout() {
        setContentView(R.layout.activity_home_tab);

        mHomeRadioTitle = getResources().getString(R.string.tab_home_title);
        mSpellRadioTitle = getResources().getString(R.string.tab_spell_title);
        mShoppingCartTitle = getResources().getString(R.string.tab_shopping_cart_title);
        mPersonalTitle = getResources().getString(R.string.tab_personal_title);

        mFragmentController = FragmentController.getInstance(this, R.id.hometab_context);
        mFragmentController.showFragment(0);
    }

    @Override
    protected void findViewById() {
        homeRadioGroup = (RadioGroup)findViewById(R.id.home_radio_group);
    }

    @Override
    protected void setListener() {
        homeRadioGroup.setOnCheckedChangeListener(this);
    }

    @Override
    protected void processLogic() {

    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
        switch (checkedId) {
            case R.id.home_radio:
                hometabToolbarTextviewTitle.setText(mHomeRadioTitle);
                mFragmentController.showFragment(0);
                break;
            case R.id.spell_radio:
                hometabToolbarTextviewTitle.setText(mSpellRadioTitle);
                mFragmentController.showFragment(1);
                break;
            case R.id.shopping_cart_radio:
                hometabToolbarTextviewTitle.setText(mShoppingCartTitle);
                mFragmentController.showFragment(2);
                break;
            case R.id.personal_radio:
                hometabToolbarTextviewTitle.setText(mPersonalTitle);
                mFragmentController.showFragment(3);
                break;
        }
    }
}
