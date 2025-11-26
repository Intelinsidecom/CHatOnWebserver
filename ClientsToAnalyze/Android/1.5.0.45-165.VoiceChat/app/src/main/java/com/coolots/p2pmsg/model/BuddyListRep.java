package com.coolots.p2pmsg.model;

import com.coolots.common.util.DateTimeUtil;
import java.sql.Timestamp;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* loaded from: classes.dex */
public class BuddyListRep extends MsgBody {
    private Date UpdateDate;
    private List<BuddyInfo> BuddyList = new ArrayList();
    private List<BuddyGroupInfo> GroupList = new ArrayList();
    private List<BuddyGroupInfo> RemovedGroupList = new ArrayList();
    private List<BuddyGroupMapInfo> MapList = new ArrayList();
    private List<BuddyGroupMapInfo> RemovedMapList = new ArrayList();

    public List<BuddyInfo> getBuddyList() {
        return this.BuddyList;
    }

    public void setBuddyList(List<BuddyInfo> buddyList) {
        this.BuddyList = buddyList;
    }

    public List<BuddyGroupInfo> getGroupList() {
        return this.GroupList;
    }

    public void setGroupList(List<BuddyGroupInfo> groupList) {
        this.GroupList = groupList;
    }

    public List<BuddyGroupInfo> getRemovedGroupList() {
        return this.RemovedGroupList;
    }

    public void setRemovedGroupList(List<BuddyGroupInfo> removedGroupList) {
        this.RemovedGroupList = removedGroupList;
    }

    public List<BuddyGroupMapInfo> getMapList() {
        return this.MapList;
    }

    public void setMapList(List<BuddyGroupMapInfo> mapList) {
        this.MapList = mapList;
    }

    public List<BuddyGroupMapInfo> getRemovedMapList() {
        return this.RemovedMapList;
    }

    public void setRemovedMapList(List<BuddyGroupMapInfo> removedMapList) {
        this.RemovedMapList = removedMapList;
    }

    public Date getUpdateDate() {
        return this.UpdateDate;
    }

    public void setUpdateDate(Date updateDate) {
        if (updateDate instanceof Timestamp) {
            this.UpdateDate = new Date(updateDate.getTime());
        } else {
            this.UpdateDate = updateDate;
        }
    }

    public void setUpdateDate(String updateDate) throws ParseException {
        setUpdateDate(DateTimeUtil.changeFormat(updateDate, "yyyy-MM-dd HH:mm:ss"));
    }
}
