package com.coolots.chaton.buddy;

import android.database.sqlite.SQLiteException;
import com.coolots.chaton.buddy.model.BuddyDBAdaptor;
import com.coolots.chaton.buddy.model.NativeNameAndPhoneNumberInfo;
import com.coolots.chaton.common.controller.VAppPhoneManager;
import com.coolots.p2pmsg.model.BuddyGroupInfo;
import com.coolots.p2pmsg.model.BuddyGroupMapInfo;
import com.coolots.p2pmsg.model.BuddyInfo;
import com.coolots.p2pmsg.model.RegionDomainInfo;
import com.sds.coolots.MainApplication;
import com.sds.coolots.common.util.Log;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* loaded from: classes.dex */
public class BuddyAdaptorHandler implements BuddyAdaptorHandlerInterface {
    private static final String CLASSNAME = "[BuddyAdaptorHandler]";
    private final BuddyDBAdaptor mBuddyDBAdaptor;

    private void logI(String message) {
        Log.m2963i(CLASSNAME + message);
    }

    public BuddyAdaptorHandler(BuddyDBAdaptor dbAdaptor) {
        this.mBuddyDBAdaptor = dbAdaptor;
    }

    @Override // com.coolots.chaton.buddy.BuddyAdaptorHandlerInterface
    public long insertBuddys(List<BuddyInfo> buddyList, List<NativeNameAndPhoneNumberInfo> NativeNameInfoList) {
        return this.mBuddyDBAdaptor.insertBuddyInfotoDB(buddyList, NativeNameInfoList);
    }

    @Override // com.coolots.chaton.buddy.BuddyAdaptorHandlerInterface
    public long insertBuddys(List<BuddyInfo> buddyList) {
        return this.mBuddyDBAdaptor.insertBuddyInfotoDB(buddyList);
    }

    @Override // com.coolots.chaton.buddy.BuddyAdaptorHandlerInterface
    public long withdrawBuddys(List<BuddyInfo> buddyList) {
        for (BuddyInfo bi : buddyList) {
            this.mBuddyDBAdaptor.deleteBuddyInDB(bi.getUserNo());
        }
        ((VAppPhoneManager) MainApplication.mPhoneManager).getChatOnContactManager().deleteEmptyGroup(null);
        return 1L;
    }

    @Override // com.coolots.chaton.buddy.BuddyAdaptorHandlerInterface
    public long blockBuddy(List<BuddyInfo> buddyList) {
        for (BuddyInfo buddy : buddyList) {
            boolean isBlock = false;
            if (buddy.getBlock().equals("Y")) {
                isBlock = true;
            }
            this.mBuddyDBAdaptor.blockBuddy(Long.valueOf(buddy.getUserNo()), isBlock);
        }
        return 0L;
    }

    @Override // com.coolots.chaton.buddy.BuddyAdaptorHandlerInterface
    public long blockBuddy(List<BuddyInfo> buddyList, List<BuddyGroupMapInfo> groupmapInfoList) {
        for (BuddyInfo buddy : buddyList) {
            boolean isBlock = false;
            if (buddy.getBlock().equals("Y")) {
                isBlock = true;
            }
            this.mBuddyDBAdaptor.blockBuddy(Long.valueOf(buddy.getUserNo()), isBlock);
        }
        if (groupmapInfoList != null && !groupmapInfoList.isEmpty()) {
            deleteGroupBuddyMap(groupmapInfoList);
            return 0L;
        }
        return 0L;
    }

    @Override // com.coolots.chaton.buddy.BuddyAdaptorHandlerInterface
    public long favoriteBuddy(long userNo, boolean isFavorite) {
        return this.mBuddyDBAdaptor.favoriteBuddy(userNo, isFavorite);
    }

    @Override // com.coolots.chaton.buddy.BuddyAdaptorHandlerInterface
    public long hideBuddys(List<BuddyInfo> buddyList) {
        for (BuddyInfo buddy : buddyList) {
            boolean isHidden = false;
            if (buddy.getHide().equals("Y")) {
                isHidden = true;
            }
            this.mBuddyDBAdaptor.hideBuddy(Long.valueOf(buddy.getUserNo()), isHidden);
        }
        return 0L;
    }

    @Override // com.coolots.chaton.buddy.BuddyAdaptorHandlerInterface
    public long hideBuddys(List<BuddyInfo> buddyList, List<BuddyGroupMapInfo> groupmapInfoList) {
        for (BuddyInfo buddy : buddyList) {
            boolean isHidden = false;
            if (buddy.getHide().equals("Y")) {
                isHidden = true;
            }
            this.mBuddyDBAdaptor.hideBuddy(Long.valueOf(buddy.getUserNo()), isHidden);
        }
        if (groupmapInfoList != null && !groupmapInfoList.isEmpty()) {
            deleteGroupBuddyMap(groupmapInfoList);
            return 0L;
        }
        return 0L;
    }

    @Override // com.coolots.chaton.buddy.BuddyAdaptorHandlerInterface
    public long changeBuddyName(long userNo, String editedUserName) {
        return this.mBuddyDBAdaptor.changeBuddyName(userNo, editedUserName);
    }

    @Override // com.coolots.chaton.buddy.BuddyAdaptorHandlerInterface
    public long changeMainPhoneNo(long userNo, String mainPhoneNo) {
        return this.mBuddyDBAdaptor.changeBuddyMainPhoneNo(userNo, mainPhoneNo);
    }

    @Override // com.coolots.chaton.buddy.BuddyAdaptorHandlerInterface
    public long updateBuddys(List<BuddyInfo> buddyList, List<BuddyGroupInfo> groupList, List<BuddyGroupInfo> delGroupList, List<BuddyGroupMapInfo> groupMapList, List<BuddyGroupMapInfo> delGroupMapList) {
        long retValue = -1;
        try {
            retValue = this.mBuddyDBAdaptor.updateBuddyInfos(buddyList, groupList, delGroupList, groupMapList, delGroupMapList);
        } catch (SQLiteException e) {
            StackTraceElement[] elems = e.getStackTrace();
            for (StackTraceElement elem : elems) {
                logI(elem.toString());
            }
        }
        ((VAppPhoneManager) MainApplication.mPhoneManager).getChatOnContactManager().deleteEmptyGroup(null);
        return retValue;
    }

    @Override // com.coolots.chaton.buddy.BuddyAdaptorHandlerInterface
    public void setBuddyUpdateFlag(Date updateDate) {
        this.mBuddyDBAdaptor.setBuddyUpdated(false);
        this.mBuddyDBAdaptor.setBuddyUpdateDate(updateDate);
    }

    @Override // com.coolots.chaton.buddy.BuddyAdaptorHandlerInterface
    public long addBuddyGroup(BuddyGroupInfo group) {
        return this.mBuddyDBAdaptor.insertBuddyGroup(group);
    }

    @Override // com.coolots.chaton.buddy.BuddyAdaptorHandlerInterface
    public long updateBuddyGroup(BuddyGroupInfo group) {
        return this.mBuddyDBAdaptor.updateBuddyGroup(group);
    }

    @Override // com.coolots.chaton.buddy.BuddyAdaptorHandlerInterface
    public long deleteBuddyGroup(long groupCode) {
        return this.mBuddyDBAdaptor.deleteBuddyGroup(groupCode);
    }

    @Override // com.coolots.chaton.buddy.BuddyAdaptorHandlerInterface
    public long addBuddyGroupMap(List<BuddyGroupMapInfo> mapList) {
        return this.mBuddyDBAdaptor.insertGroupBuddyMap(mapList);
    }

    @Override // com.coolots.chaton.buddy.BuddyAdaptorHandlerInterface
    public long deleteGroupBuddyMap(List<BuddyGroupMapInfo> mapList) {
        return this.mBuddyDBAdaptor.deleteGroupBuddyMap(mapList);
    }

    @Override // com.coolots.chaton.buddy.BuddyAdaptorHandlerInterface
    public long makeRegionInfoTable(ArrayList<RegionDomainInfo> regionDomainInfo) {
        return this.mBuddyDBAdaptor.makeRegionInfoTable(regionDomainInfo);
    }
}
