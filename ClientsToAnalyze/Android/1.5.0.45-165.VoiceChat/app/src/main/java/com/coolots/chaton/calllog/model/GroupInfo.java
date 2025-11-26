package com.coolots.chaton.calllog.model;

import android.database.Cursor;
import com.sds.coolots.MainApplication;
import com.sds.coolots.common.controller.DatabaseHelper;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/* loaded from: classes.dex */
public class GroupInfo {
    public int groupid;
    public Set<Long> groupmember = new HashSet();
    public String groupname;
    public String username;
    public long userno;

    public GroupInfo(Cursor cursorC) {
        if ((cursorC == null || (cursorC.getPosition() < cursorC.getCount() && cursorC.getPosition() >= 0)) && cursorC != null) {
            int nIndex = cursorC.getColumnIndex(DatabaseHelper.KEY_GROUPID);
            if (nIndex >= 0) {
                this.groupid = cursorC.getInt(nIndex);
            }
            int nIndex2 = cursorC.getColumnIndex(DatabaseHelper.KEY_GROUPNAME);
            if (nIndex2 >= 0) {
                this.groupname = cursorC.getString(nIndex2);
            }
            int nIndex3 = cursorC.getColumnIndex(DatabaseHelper.KEY_USERNO);
            if (nIndex3 >= 0) {
                this.userno = cursorC.getLong(nIndex3);
            }
            int nIndex4 = cursorC.getColumnIndex(DatabaseHelper.KEY_USERNAME);
            if (nIndex4 >= 0) {
                this.username = cursorC.getString(nIndex4);
            }
        }
    }

    public static HashMap<Set<Long>, String> getGroupInfoMapByCursor(Cursor cursorC) {
        HashMap<Set<Long>, String> groupInfo = new HashMap<>();
        if (!MainApplication.mPhoneManager.IsLinkagewithChatON()) {
            Set<Long> prevGroupMember = null;
            int prevGroupID = -1;
            if (cursorC != null) {
                cursorC.moveToFirst();
                if (!cursorC.isAfterLast()) {
                    do {
                        GroupInfo data = new GroupInfo(cursorC);
                        if (data != null) {
                            data.groupmember.add(Long.valueOf(data.userno));
                            if (prevGroupID == data.groupid && prevGroupMember != null) {
                                prevGroupMember.add(Long.valueOf(data.userno));
                                groupInfo.put(prevGroupMember, data.groupname);
                            } else {
                                new HashSet<>();
                                String prevGroupName = data.groupname;
                                prevGroupID = data.groupid;
                                prevGroupMember = data.groupmember;
                            }
                        }
                    } while (cursorC.moveToNext());
                }
                cursorC.close();
            }
        }
        return groupInfo;
    }
}
