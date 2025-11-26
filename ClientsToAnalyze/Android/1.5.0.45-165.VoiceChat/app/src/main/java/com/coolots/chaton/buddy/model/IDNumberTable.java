package com.coolots.chaton.buddy.model;

import android.content.ContentValues;
import com.sds.coolots.common.controller.DatabaseHelper;

/* loaded from: classes.dex */
public class IDNumberTable {
    private final int DEFAULT_VALUE = -1;
    private long userNo = -1;
    private String userId = null;
    private String phoneno = null;

    public ContentValues getContentValue() {
        ContentValues value = new ContentValues();
        if (this.userNo > -1) {
            value.put(DatabaseHelper.KEY_USERNO, Long.valueOf(this.userNo));
        }
        if (this.userId != null) {
            value.put(DatabaseHelper.KEY_USERID, this.userId);
        }
        if (this.phoneno != null) {
            value.put(DatabaseHelper.KEY_PHONENO, this.phoneno);
        }
        return value;
    }

    public void setContentValue(ContentValues cvalue) {
        this.userNo = cvalue.getAsLong(DatabaseHelper.KEY_USERNO).longValue();
        this.userId = cvalue.getAsString(DatabaseHelper.KEY_USERID);
        this.phoneno = cvalue.getAsString(DatabaseHelper.KEY_PHONENO);
    }

    public String getPhoneNo() {
        return this.phoneno;
    }
}
