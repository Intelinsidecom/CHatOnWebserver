package com.coolots.chaton.buddy.model;

import android.content.ContentValues;
import com.sds.coolots.common.controller.DatabaseHelper;

/* loaded from: classes.dex */
public class GroupBuddyMapTable {
    private final int DEFAULT_VALUE = -1;
    private long groupId = -1;
    private long userNo = -1;
    private long updateDate = -1;

    public ContentValues getContentValue() {
        ContentValues value = new ContentValues();
        if (this.groupId > -1) {
            value.put(DatabaseHelper.KEY_GROUPID, Long.valueOf(this.groupId));
        }
        if (this.userNo > -1) {
            value.put(DatabaseHelper.KEY_USERNO, Long.valueOf(this.userNo));
        }
        if (this.updateDate > -1) {
            value.put(DatabaseHelper.KEY_UPDATEDATE, Long.valueOf(this.updateDate));
        }
        return value;
    }

    public void setContentValue(ContentValues cvalue) {
        this.groupId = cvalue.getAsLong(DatabaseHelper.KEY_GROUPID).longValue();
        this.userNo = cvalue.getAsLong(DatabaseHelper.KEY_USERNO).longValue();
        this.updateDate = cvalue.getAsLong(DatabaseHelper.KEY_UPDATEDATE).longValue();
    }

    public long getUserNo() {
        return this.userNo;
    }
}
