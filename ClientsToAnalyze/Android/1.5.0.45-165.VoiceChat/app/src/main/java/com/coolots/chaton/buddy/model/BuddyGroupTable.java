package com.coolots.chaton.buddy.model;

import android.content.ContentValues;
import com.sds.coolots.common.controller.DatabaseHelper;

/* loaded from: classes.dex */
public class BuddyGroupTable {
    private final int DEFAULT_VALUE = -1;
    private String groupName = null;
    private long groupID = -1;
    private long updateDate = -1;

    public ContentValues getContentValue() {
        ContentValues value = new ContentValues();
        if (this.groupName != null) {
            value.put(DatabaseHelper.KEY_GROUPNAME, this.groupName);
        }
        if (this.groupID > -1) {
            value.put(DatabaseHelper.KEY_GROUPID, Long.valueOf(this.groupID));
        }
        if (this.updateDate > -1) {
            value.put(DatabaseHelper.KEY_UPDATEDATE, Long.valueOf(this.updateDate));
        }
        return value;
    }

    public void setContentValue(ContentValues cvalue) {
        this.groupName = cvalue.getAsString(DatabaseHelper.KEY_GROUPNAME);
        this.groupID = cvalue.getAsLong(DatabaseHelper.KEY_GROUPID).longValue();
        this.updateDate = cvalue.getAsLong(DatabaseHelper.KEY_UPDATEDATE).longValue();
    }

    public long getGroupID() {
        return this.groupID;
    }

    public void setGroupID(long sourceGroupID) {
        this.groupID = sourceGroupID;
    }

    public String getGroupName() {
        return this.groupName;
    }
}
