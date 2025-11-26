package com.coolots.sse.buddy;

import android.graphics.Bitmap;
import android.os.Handler;
import com.coolots.chaton.buddy.model.BuddyTable;
import com.coolots.p2pmsg.model.BuddyGroupInfo;
import com.coolots.p2pmsg.model.BuddyGroupMapInfo;
import com.coolots.p2pmsg.model.ConferenceInfo;
import com.coolots.p2pmsg.model.SimpleUserInfo;
import com.sds.coolots.call.BlockCallHandler;
import com.sds.coolots.call.model.Destination;
import com.sds.coolots.call.model.P2PUserInfo;
import com.sds.coolots.contact.ContactManagerInterface;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/* loaded from: classes.dex */
public interface BuddyManagerInterface extends ContactManagerInterface {
    public static final int PREINDEX_BUDDYLIST = 4;
    public static final int PREINDEX_FAVORITE = 2;
    public static final int PREINDEX_NEW = 1;

    void addBuddy(String str, Handler handler);

    void addBuddyGroup(BuddyGroupInfo buddyGroupInfo, List<BuddyGroupMapInfo> list, Handler handler);

    void addBuddyGroupMember(long j, List<Long> list, Handler handler);

    void autoBuddy(Handler handler);

    void blockBuddy(List<Long> list, boolean z, Handler handler);

    void buddySearchByPhoneNo(int i, String str, Handler handler);

    void buddySearchByUserID(String str, Handler handler);

    void changeBuddyGroupName(long j, String str, Handler handler);

    void deleteBuddyGroup(long j, Handler handler);

    void deleteBuddyGroupMember(long j, List<Long> list, Handler handler);

    ArrayList<P2PUserInfo> getP2PUserInfoFromMSISDN(HashMap<String, String> map);

    ArrayList<P2PUserInfo> getP2PUserInfoFromMSISDN(List<String> list);

    ArrayList<SimpleUserInfo> getSimpleUserInfoFromMSISDN(HashMap<String, String> map);

    ArrayList<SimpleUserInfo> getSimpleUserInfoFromMSISDN(List<String> list);

    @Override // com.sds.coolots.contact.ContactManagerInterface
    String getUserNameByUserID(String str);

    Bitmap getVAppBuddyInfoImageData(String str);

    List<Bitmap> getVAppBuddyInfoImageData(List<String> list);

    boolean getVAppBuddyInfoImageData(String str, Handler handler);

    boolean getVAppBuddyInfoImageData(List<String> list, Handler handler);

    Bitmap getVAppBuddyInfoImageDataByPhoneNumber(String str);

    List<Bitmap> getVAppBuddyInfoImageDataByPhoneNumber(List<String> list);

    boolean getVAppBuddyInfoImageDataByPhoneNumber(String str, Handler handler);

    boolean getVAppBuddyInfoImageDataByPhoneNumber(List<String> list, Handler handler);

    String getVAppBuddyInfoProfileName(String str);

    HashMap<String, String> getVAppBuddyInfoProfileName(List<String> list);

    BuddyTable getVAppBuddyInfoTextData(String str);

    List<BuddyTable> getVAppBuddyInfoTextData(List<String> list);

    BuddyTable getVAppBuddyInfoTextDataByPhoneNumber(String str);

    List<BuddyTable> getVAppBuddyInfoTextDataByPhoneNumber(List<String> list);

    BuddyTable getVAppBuddyInfoTextDataByUserNo(long j);

    void hideBuddy(ArrayList<Long> arrayList, boolean z, Handler handler);

    @Override // com.sds.coolots.contact.ContactManagerInterface
    boolean isBlockPhoneNo(String str, Handler handler);

    @Override // com.sds.coolots.contact.ContactManagerInterface
    boolean isBlockUser(String str, Handler handler);

    @Override // com.sds.coolots.contact.ContactManagerInterface
    boolean isBlockUserForCall(String str, short s, Destination destination, int i, boolean z, boolean z2, boolean z3, boolean z4, String str2, Date date, BlockCallHandler blockCallHandler);

    boolean isBlockUserForConf(String str, Destination destination, ConferenceInfo conferenceInfo, Date date, BlockCallHandler blockCallHandler, String str2);

    boolean isBuddySyncNeeded();

    boolean isBuddyUpdated();

    @Override // com.sds.coolots.contact.ContactManagerInterface
    boolean isFriend(String str);

    void setFavoriteBuddy(long j, boolean z, Handler handler);

    void updateBuddyInfo(long j, String str, Handler handler);

    void updateBuddyListDataBase(Handler handler);
}
