package com.mango.domain;

import java.util.Date;

/**
 * Created by Aaron on 2017-08-01.
 */
public class Commons {
    public Date createTime;
    public Date modifyTime;

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }


}
