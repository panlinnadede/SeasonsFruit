package com.lin.seasonsfruit.MVP.Entity;

import cn.bmob.v3.BmobObject;

/**
 * Created by lin on 17-1-2.
 */

public class HomeGoodsClassDto extends BmobObject {
    private int id;
    private String classTitle;
    private String classIntroduction;

    public void setId(int id) {
        this.id = id;
    }

    public void setClassTitle(String classTitle) {
        this.classTitle = classTitle;
    }

    public void setClassIntroduction(String classIntroduction) {
        this.classIntroduction = classIntroduction;
    }

    public int getId() {
        return id;
    }

    public String getClassTitle() {
        return classTitle;
    }

    public String getClassIntroduction() {
        return classIntroduction;
    }
}
