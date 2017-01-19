package com.lin.seasonsfruit.MVP.Entity;

import cn.bmob.v3.BmobObject;
import cn.bmob.v3.BmobUser;
import cn.bmob.v3.datatype.BmobPointer;

/**
 * Created by lin on 17-1-2.
 */

public class HomeTipDto extends BmobObject {
    private String time;
    private String site;
    private String policy;

    public void setTime(String time) {
        this.time = time;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public void setPolicy(String policy) {
        this.policy = policy;
    }

    public String getTime() {
        return time;
    }

    public String getSite() {
        return site;
    }

    public String getPolicy() {
        return policy;
    }
}
