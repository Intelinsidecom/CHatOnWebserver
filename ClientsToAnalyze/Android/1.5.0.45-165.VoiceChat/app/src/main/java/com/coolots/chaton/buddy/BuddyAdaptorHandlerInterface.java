package com.coolots.chaton.buddy;

import com.coolots.chaton.buddy.model.NativeNameAndPhoneNumberInfo;
import com.coolots.p2pmsg.model.BuddyGroupInfo;
import com.coolots.p2pmsg.model.BuddyGroupMapInfo;
import com.coolots.p2pmsg.model.BuddyInfo;
import com.coolots.p2pmsg.model.RegionDomainInfo;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* loaded from: classes.dex */
public interface BuddyAdaptorHandlerInterface {
    long addBuddyGroup(BuddyGroupInfo buddyGroupInfo);

    long addBuddyGroupMap(List<BuddyGroupMapInfo> list);

    long blockBuddy(List<BuddyInfo> list);

    long blockBuddy(List<BuddyInfo> list, List<BuddyGroupMapInfo> list2);

    long changeBuddyName(long j, String str);

    long changeMainPhoneNo(long j, String str);

    long deleteBuddyGroup(long j);

    long deleteGroupBuddyMap(List<BuddyGroupMapInfo> list);

    long favoriteBuddy(long j, boolean z);

    long hideBuddys(List<BuddyInfo> list);

    long hideBuddys(List<BuddyInfo> list, List<BuddyGroupMapInfo> list2);

    long insertBuddys(List<BuddyInfo> list);

    long insertBuddys(List<BuddyInfo> list, List<NativeNameAndPhoneNumberInfo> list2);

    long makeRegionInfoTable(ArrayList<RegionDomainInfo> arrayList);

    void setBuddyUpdateFlag(Date date);

    long updateBuddyGroup(BuddyGroupInfo buddyGroupInfo);

    long updateBuddys(List<BuddyInfo> list, List<BuddyGroupInfo> list2, List<BuddyGroupInfo> list3, List<BuddyGroupMapInfo> list4, List<BuddyGroupMapInfo> list5);

    long withdrawBuddys(List<BuddyInfo> list);
}
