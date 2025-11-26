package com.coolots.chaton.buddy;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Message;
import android.provider.ContactsContract;
import android.telephony.TelephonyManager;
import com.coolots.chaton.buddy.adaptor.AddBuddyAdaptor;
import com.coolots.chaton.buddy.adaptor.AddBuddyGroupAdaptor;
import com.coolots.chaton.buddy.adaptor.AddBuddyGroupMapAdaptor;
import com.coolots.chaton.buddy.adaptor.AddBuddySuggestionAdaptor;
import com.coolots.chaton.buddy.adaptor.AutoBuddyAdaptor;
import com.coolots.chaton.buddy.adaptor.BlockBuddyAdaptor;
import com.coolots.chaton.buddy.adaptor.BuddyListAdaptor;
import com.coolots.chaton.buddy.adaptor.BuddySearchAdaptor;
import com.coolots.chaton.buddy.adaptor.BuddySearchInfo;
import com.coolots.chaton.buddy.adaptor.DeleteBuddyGroupAdaptor;
import com.coolots.chaton.buddy.adaptor.DeleteBuddyGroupMapAdaptor;
import com.coolots.chaton.buddy.adaptor.HideBuddyAdaptor;
import com.coolots.chaton.buddy.adaptor.RegionDomainInfoAdaptor;
import com.coolots.chaton.buddy.adaptor.SetFavoriteBuddyAdaptor;
import com.coolots.chaton.buddy.adaptor.UpdateBuddyAdaptor;
import com.coolots.chaton.buddy.adaptor.UpdateBuddyGroupAdaptor;
import com.coolots.chaton.buddy.model.BuddyDBAdaptor;
import com.coolots.chaton.buddy.model.BuddyGroupTable;
import com.coolots.chaton.buddy.model.BuddyListChildItem;
import com.coolots.chaton.buddy.model.BuddyListGroupItem;
import com.coolots.chaton.buddy.model.BuddyPhoneNoInfo;
import com.coolots.chaton.buddy.model.BuddyTable;
import com.coolots.chaton.buddy.model.GroupBuddyMapTable;
import com.coolots.chaton.buddy.model.NativeContactInfo;
import com.coolots.chaton.buddy.model.NativeContactSyncData;
import com.coolots.chaton.buddy.model.NativeNameAndPhoneNumberInfo;
import com.coolots.chaton.buddy.model.NativePhoneBookInfo;
import com.coolots.chaton.buddy.model.PhoneNoInfo;
import com.coolots.chaton.buddy.util.NativeContactProviderUtil;
import com.coolots.chaton.buddy.util.RegionDomainUtil;
import com.coolots.chaton.buddy.util.ValueObjectConverter;
import com.coolots.chaton.common.controller.ChatOnResourceInterface;
import com.coolots.chaton.common.controller.VAppPhoneManager;
import com.coolots.chaton.common.view.ConfigActivity;
import com.coolots.chaton.setting.data.ChatONSettingData;
import com.coolots.p2pmsg.MessageInfo;
import com.coolots.p2pmsg.model.BuddyGroupInfo;
import com.coolots.p2pmsg.model.BuddyGroupMapInfo;
import com.coolots.p2pmsg.model.BuddyInfo;
import com.coolots.p2pmsg.model.ConfLimitPolicyInfo;
import com.coolots.p2pmsg.model.ConferenceInfo;
import com.coolots.p2pmsg.model.MsgBody;
import com.coolots.p2pmsg.model.NotifyUnsubscribeAsk;
import com.coolots.p2pmsg.model.NotifyUnsubscribeMyIDAsk;
import com.coolots.p2pmsg.model.PhoneBookInfo;
import com.coolots.p2pmsg.model.RefreshBuddyAsk;
import com.coolots.p2pmsg.model.RefreshProfileAsk;
import com.coolots.p2pmsg.model.SimpleUserInfo;
import com.coolots.p2pmsg.model.StoreNoteAsk;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.sds.coolots.EngineInterface;
import com.sds.coolots.MainApplication;
import com.sds.coolots.call.BlockCallHandler;
import com.sds.coolots.call.model.Destination;
import com.sds.coolots.call.model.P2PUserInfo;
import com.sds.coolots.common.controller.DatabaseHelper;
import com.sds.coolots.common.controller.EngineContactCallbackInterface;
import com.sds.coolots.common.controller.PhoneManager;
import com.sds.coolots.common.util.Log;
import com.sds.coolots.common.util.PhoneNumberUtil;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.regex.Pattern;

/* loaded from: classes.dex */
public class BuddyManager implements BuddyManagerInterface, EngineContactCallbackInterface {
    private static final String BUDDY_UPDATE_ACTION = "com.coolots.chaton.buddy.view.BuddyMainListActivity.Update";
    private static final String ENGLISHPATTERN = "[a-zA-Z]";
    private static final int FAVORITE_MAX_COUNT = 100;
    private static final int GROUPMEMBER_MAX_COUNT = 100;
    private static final int GROUP_MAX_COUNT = 100;
    private static final char HANGUL_SYLLABLES_BEGIN = 44032;
    private static final char HANGUL_SYLLABLES_END = 55203;
    private static final String KOREANPATTERN = "[\\u3131-\\u318E]";
    private final BuddyAdaptorHandler mBuddyAdaptorHandler;
    private static final char[] HANGUL_CHOSEONG = {12593, 12594, 12596, 12599, 12600, 12601, 12609, 12610, 12611, 12613, 12614, 12615, 12616, 12617, 12618, 12619, 12620, 12621, 12622};
    private static final char[] HANGUL_JUNGSEONG = {12623, 12624, 12625, 12626, 12627, 12628, 12629, 12630, 12631, 12632, 12633, 12634, 12635, 12636, 12637, 12638, 12639, 12640, 12641, 12642, 12643};
    private static final char[] HANGUL_JONGSEONG = {0, 12593, 12594, 12595, 12596, 12597, 12598, 12599, 12601, 12602, 12603, 12604, 12605, 12606, 12607, 12608, 12609, 12610, 12612, 12613, 12614, 12615, 12616, 12618, 12619, 12620, 12621, 12622};
    public static final int HANGUL_CHOSEONG_SIZE = HANGUL_CHOSEONG.length;
    public static final int HANGUL_JUNGSEONG_SIZE = HANGUL_JUNGSEONG.length;
    public static final int HANGUL_JONGSEONG_SIZE = HANGUL_JONGSEONG.length;
    private final String[] alphabetStringIndex = {"A", StoreNoteAsk.TYPE_SEND_SUCCESS, StoreNoteAsk.TYPE_ADD_MEMBER, StoreNoteAsk.TYPE_REMOVE_MEMBER, "E", ConfLimitPolicyInfo.PAID_TYPE_FREE, "G", SimpleUserInfo.TYPE_HOST, "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
    private final String[] koreanStringIndex = {"ㄱ", "ㄲ", "ㄴ", "ㄷ", "ㄸ", "ㄹ", "ㅁ", "ㅂ", "ㅃ", "ㅅ", "ㅆ", "ㅇ", "ㅈ", "ㅉ", "ㅊ", "ㅋ", "ㅌ", "ㅍ", "ㅎ"};
    private final BuddyDBAdaptor buddyDBAdaptor = new BuddyDBAdaptor();
    private final ArrayList<BuddyListGroupItem> adaptorGroupData = new ArrayList<>();
    private final ArrayList<ArrayList<BuddyListChildItem>> adaptorChildData = new ArrayList<>();
    ArrayList<BuddyListChildItem> rawListAdaptorData = new ArrayList<>();
    private final DBHandler mHandler = new DBHandler(this, null);

    /* renamed from: tm */
    public TelephonyManager f1tm = null;

    public BuddyManager() {
        EngineInterface.getInstance().setEngineContactCallback(this);
        this.mBuddyAdaptorHandler = new BuddyAdaptorHandler(this.buddyDBAdaptor);
    }

    private void resetData() {
        if (this.adaptorGroupData != null && !this.adaptorGroupData.isEmpty()) {
            this.adaptorGroupData.clear();
        }
        if (this.adaptorChildData != null && !this.adaptorChildData.isEmpty()) {
            this.adaptorChildData.clear();
        }
    }

    @Override // com.coolots.chaton.buddy.BuddyManagerInterface
    public void fillBuddyListAdaptorData() {
        resetData();
        fillMyProfileListData();
        fillFreshBuddyListData();
        fillFavoriteBuddyListData();
        fillGroupListData();
        fillBuddyListData();
    }

    @Override // com.coolots.chaton.buddy.BuddyManagerInterface
    public void fillBuddyListAdaptorDataCheckList() {
        resetData();
        fillFavoriteBuddyListData();
        fillGroupListData();
        fillBuddyListData();
    }

    @Override // com.coolots.chaton.buddy.BuddyManagerInterface
    public void fillBuddyListAdaptorDataForAddMember(long groupNo) throws Throwable {
        resetData();
        fillFavoriteBuddyListDataForAddmember(groupNo);
        fillGroupListDataForAddMember(groupNo);
        fillBuddyListDataForAddGroupMember(groupNo);
    }

    @Override // com.coolots.chaton.buddy.BuddyManagerInterface
    public void fillOnlyBuddyListData() {
        resetData();
        fillBuddyItemListData();
    }

    public void fillBuddyListSelectedAdapterData() {
        resetData();
        fillFavoriteBuddyListData();
        fillGroupListData();
        fillBuddyListData();
    }

    @Override // com.coolots.chaton.buddy.BuddyManagerInterface
    public ArrayList<BuddyListGroupItem> getBuddyListAdaptorGroupData() {
        return this.adaptorGroupData;
    }

    @Override // com.coolots.chaton.buddy.BuddyManagerInterface
    public ArrayList<ArrayList<BuddyListChildItem>> getBuddyListAdaptorChildData() {
        return this.adaptorChildData;
    }

    @Override // com.coolots.chaton.buddy.BuddyManagerInterface
    public ArrayList<BuddyListChildItem> getBuddyItemListData() {
        return this.rawListAdaptorData;
    }

    private void fillMyProfileListData() {
        ArrayList<BuddyListChildItem> mRawListAdaptorData = new ArrayList<>();
        BuddyListChildItem buddyMe = new BuddyListChildItem(null, ConfigActivity.getProfileUserName(), ConfigActivity.getUserNo(), ConfigActivity.getProfileNickName(), false, false, false);
        mRawListAdaptorData.add(buddyMe);
        BuddyListGroupItem buddyGroupItem = new BuddyListGroupItem(null, null, null, 0);
        int rscNumber = ((ChatOnResourceInterface) MainApplication.mResources).getMeTitle();
        String strName = "";
        if (rscNumber > 0) {
            strName = MainApplication.mContext.getResources().getText(rscNumber).toString();
        }
        buddyGroupItem.setName(strName);
        buddyGroupItem.setMsg(1);
        this.adaptorGroupData.add(buddyGroupItem);
        this.adaptorChildData.add(mRawListAdaptorData);
    }

    private void fillFreshBuddyListData() {
        new ArrayList();
        ArrayList<BuddyListChildItem> mRawListAdaptorData = this.buddyDBAdaptor.getBuddyRawData(1);
        if (mRawListAdaptorData != null && !mRawListAdaptorData.isEmpty()) {
            BuddyListGroupItem buddyGroupItem = new BuddyListGroupItem(null, null, null, 0);
            int rscNumber = ((ChatOnResourceInterface) MainApplication.mResources).getNewTitle();
            String strName = "";
            if (rscNumber > 0) {
                strName = MainApplication.mContext.getResources().getText(rscNumber).toString();
            }
            buddyGroupItem.setName(strName);
            buddyGroupItem.setMsg(mRawListAdaptorData.size());
            this.adaptorGroupData.add(buddyGroupItem);
            this.adaptorChildData.add(mRawListAdaptorData);
        }
    }

    private void fillFavoriteBuddyListDataForAddmember(long groupCode) throws Throwable {
        new ArrayList();
        new ArrayList();
        ArrayList<Long> memberNoList = new ArrayList<>();
        ArrayList<BuddyListChildItem> mRawListAdaptorDataTemp = getGroupMemberListByGroupID(groupCode);
        if (mRawListAdaptorDataTemp != null && !mRawListAdaptorDataTemp.isEmpty()) {
            Iterator<BuddyListChildItem> it = mRawListAdaptorDataTemp.iterator();
            while (it.hasNext()) {
                BuddyListChildItem BLCI = it.next();
                memberNoList.add(Long.valueOf(BLCI.getUserNo()));
            }
        }
        ArrayList<BuddyListChildItem> mRawListAdaptorData = this.buddyDBAdaptor.getBuddyRawDataForAddMemberInFavorite(memberNoList);
        if (mRawListAdaptorData != null && !mRawListAdaptorData.isEmpty()) {
            BuddyListGroupItem buddyGroupItem = new BuddyListGroupItem(null, null, null, 0);
            int rscNumber = ((ChatOnResourceInterface) MainApplication.mResources).getFavoriteTitle();
            String strName = "";
            if (rscNumber > 0) {
                strName = MainApplication.mContext.getResources().getText(rscNumber).toString();
            }
            buddyGroupItem.setName(strName);
            buddyGroupItem.setMsg(mRawListAdaptorData.size());
            this.adaptorGroupData.add(buddyGroupItem);
            this.adaptorChildData.add(mRawListAdaptorData);
        }
    }

    private void fillFavoriteBuddyListDataForAddConferencemember(ArrayList<Long> memberUserNumbers) {
        new ArrayList();
        ArrayList<BuddyListChildItem> mRawListAdaptorData = this.buddyDBAdaptor.getBuddyRawDataForAddMemberInFavorite(memberUserNumbers);
        if (mRawListAdaptorData != null && !mRawListAdaptorData.isEmpty()) {
            BuddyListGroupItem buddyGroupItem = new BuddyListGroupItem(null, null, null, 0);
            int rscNumber = ((ChatOnResourceInterface) MainApplication.mResources).getFavoriteTitle();
            String strName = "";
            if (rscNumber > 0) {
                strName = MainApplication.mContext.getResources().getText(rscNumber).toString();
            }
            buddyGroupItem.setName(strName);
            buddyGroupItem.setMsg(mRawListAdaptorData.size());
            this.adaptorGroupData.add(buddyGroupItem);
            this.adaptorChildData.add(mRawListAdaptorData);
        }
    }

    private void fillFavoriteBuddyListData() {
        new ArrayList();
        ArrayList<BuddyListChildItem> mRawListAdaptorData = this.buddyDBAdaptor.getBuddyRawData(2);
        if (mRawListAdaptorData != null && !mRawListAdaptorData.isEmpty()) {
            BuddyListGroupItem buddyGroupItem = new BuddyListGroupItem(null, null, null, 0);
            int rscNumber = ((ChatOnResourceInterface) MainApplication.mResources).getFavoriteTitle();
            String strName = "";
            if (rscNumber > 0) {
                strName = MainApplication.mContext.getResources().getText(rscNumber).toString();
            }
            buddyGroupItem.setName(strName);
            buddyGroupItem.setMsg(mRawListAdaptorData.size());
            this.adaptorGroupData.add(buddyGroupItem);
            this.adaptorChildData.add(mRawListAdaptorData);
        }
    }

    private void fillGroupListData() {
        Log.m2958e("TIME_TRACE fillGroupListData start" + System.currentTimeMillis());
        HashMap<Long, String> groupTableMap = new HashMap<>();
        Cursor groupCursor = this.buddyDBAdaptor.selectBuddyGroupAll();
        if (groupCursor != null && groupCursor.getCount() > 0 && groupCursor.moveToFirst()) {
            do {
                groupTableMap.put(Long.valueOf(groupCursor.getLong(2)), groupCursor.getString(1));
            } while (groupCursor.moveToNext());
            groupCursor.close();
            Cursor rawCursor = this.buddyDBAdaptor.getGroupListDataVOCursor();
            int groupMemberCount = 0;
            int groupCount = 0;
            long previousGroupID = -1;
            ArrayList<BuddyListChildItem> buddyListChildItemList = new ArrayList<>();
            StringBuilder builder = new StringBuilder();
            if (rawCursor != null && rawCursor.moveToFirst() && rawCursor.getCount() > 0) {
                do {
                    long currentGroupID = rawCursor.getLong(rawCursor.getColumnIndex(DatabaseHelper.KEY_GROUPID));
                    if (previousGroupID == currentGroupID) {
                        builder.append(rawCursor.getString(rawCursor.getColumnIndex(DatabaseHelper.KEY_DISPLAYNAME)));
                        builder.append(", ");
                        groupMemberCount++;
                    } else {
                        if (previousGroupID != -1) {
                            BuddyListChildItem mListChildData = new BuddyListChildItem(null, null, -1L, null, true, false, false);
                            mListChildData.setBuddyName(String.valueOf(groupTableMap.get(Long.valueOf(previousGroupID))) + " (" + Integer.toString(groupMemberCount) + ")");
                            mListChildData.setBuddyNo(previousGroupID);
                            builder.delete(builder.length() - 2, builder.length());
                            mListChildData.setBuddyMsg(builder.toString());
                            builder.delete(0, builder.length());
                            buddyListChildItemList.add(mListChildData);
                        }
                        groupMemberCount = 1;
                        builder.append(rawCursor.getString(rawCursor.getColumnIndex(DatabaseHelper.KEY_DISPLAYNAME)));
                        builder.append(", ");
                        previousGroupID = currentGroupID;
                        groupCount++;
                    }
                } while (rawCursor.moveToNext());
                BuddyListChildItem mListChildData2 = new BuddyListChildItem(null, null, -1L, null, true, false, false);
                mListChildData2.setBuddyName(String.valueOf(groupTableMap.get(Long.valueOf(previousGroupID))) + " (" + Integer.toString(groupMemberCount) + ")");
                mListChildData2.setBuddyNo(previousGroupID);
                builder.delete(builder.length() - 2, builder.length());
                mListChildData2.setBuddyMsg(builder.toString());
                builder.delete(0, builder.length());
                buddyListChildItemList.add(mListChildData2);
                rawCursor.close();
                BuddyListGroupItem buddyGroupItem = new BuddyListGroupItem(null, null, null, 0);
                int rscNumber = ((ChatOnResourceInterface) MainApplication.mResources).getGroupTitle();
                String strName = "";
                if (rscNumber > 0) {
                    strName = MainApplication.mContext.getResources().getText(rscNumber).toString();
                }
                buddyGroupItem.setName(strName);
                buddyGroupItem.setMsg(groupCount);
                this.adaptorGroupData.add(buddyGroupItem);
                this.adaptorChildData.add(buddyListChildItemList);
                Log.m2958e("TIME_TRACE fillGroupListData end" + System.currentTimeMillis());
                return;
            }
            if (rawCursor != null) {
                rawCursor.close();
                return;
            }
            return;
        }
        if (groupCursor != null) {
            groupCursor.close();
        }
        Log.m2958e("TIME_TRACE fillGroupListData No BuddyGroups");
    }

    private void fillGroupListDataForAddMember(long groupNo) {
        new ArrayList();
        ArrayList<BuddyGroupTable> mRawBuddyGroupData = new ArrayList<>();
        ArrayList<BuddyGroupTable> mRawBuddyGroupDataAll = this.buddyDBAdaptor.getBuddyGroupRawDataForAddMember(groupNo);
        if (mRawBuddyGroupDataAll != null && !mRawBuddyGroupDataAll.isEmpty()) {
            Iterator<BuddyGroupTable> it = mRawBuddyGroupDataAll.iterator();
            while (it.hasNext()) {
                BuddyGroupTable BGT = it.next();
                Cursor groupBuddyMapCursor = this.buddyDBAdaptor.selectGroupBuddyMapByGroupID(BGT.getGroupID());
                if (groupBuddyMapCursor != null && groupBuddyMapCursor.moveToFirst()) {
                    groupBuddyMapCursor.close();
                    mRawBuddyGroupData.add(mRawBuddyGroupDataAll.get(mRawBuddyGroupDataAll.indexOf(BGT)));
                } else {
                    Log.m2958e("BUDDY_TRACE Empty Group Delete!");
                    if (groupBuddyMapCursor != null) {
                        groupBuddyMapCursor.close();
                    }
                }
            }
            if (!mRawBuddyGroupData.isEmpty()) {
                BuddyListGroupItem buddyGroupItem = new BuddyListGroupItem(null, null, null, 0);
                int rscNumber = ((ChatOnResourceInterface) MainApplication.mResources).getGroupTitle();
                String strName = "";
                if (rscNumber > 0) {
                    strName = MainApplication.mContext.getResources().getText(rscNumber).toString();
                }
                buddyGroupItem.setName(strName);
                buddyGroupItem.setMsg(mRawBuddyGroupData.size());
                this.adaptorGroupData.add(buddyGroupItem);
                ArrayList<BuddyListChildItem> buddyListChildItemList = new ArrayList<>();
                for (int count = 0; count < mRawBuddyGroupDataAll.size(); count++) {
                    new ArrayList();
                    ArrayList<GroupBuddyMapTable> mRawBuddyGroupMapData = this.buddyDBAdaptor.getGroupBuddyMapRawDataByGroupID(mRawBuddyGroupDataAll.get(count).getGroupID());
                    if (mRawBuddyGroupMapData != null && !mRawBuddyGroupMapData.isEmpty()) {
                        BuddyListChildItem mListChildData = new BuddyListChildItem(null, null, -1L, null, true, false, false);
                        mListChildData.setBuddyName(String.valueOf(mRawBuddyGroupDataAll.get(count).getGroupName()) + " (" + Integer.toString(mRawBuddyGroupMapData.size()) + ")");
                        mListChildData.setBuddyNo(mRawBuddyGroupDataAll.get(count).getGroupID());
                        StringBuilder builder = new StringBuilder();
                        for (int childCount = 0; childCount < mRawBuddyGroupMapData.size(); childCount++) {
                            mListChildData.setUserNoList(mRawBuddyGroupMapData.get(childCount).getUserNo());
                            builder.append(this.buddyDBAdaptor.getDisplayNameByUserNo(mRawBuddyGroupMapData.get(childCount).getUserNo()));
                            builder.append(", ");
                        }
                        builder.delete(builder.length() - 2, builder.length());
                        mListChildData.setBuddyMsg(builder.toString());
                        buddyListChildItemList.add(mListChildData);
                    }
                }
                this.adaptorChildData.add(buddyListChildItemList);
            }
        }
    }

    private void fillBuddyListData() {
        CharSequence ch;
        String choseong;
        new ArrayList();
        ArrayList<BuddyListChildItem> mRawListAdaptorData = this.buddyDBAdaptor.getBuddyRawData(4);
        if (mRawListAdaptorData != null && !mRawListAdaptorData.isEmpty()) {
            ArrayList<BuddyListChildItem> mSeparatedListAdaptorDataSharp = new ArrayList<>();
            BuddyListGroupItem buddyGroupSharpItem = new BuddyListGroupItem(null, null, null, 0);
            ArrayList<BuddyListChildItem> mSeparatedListAdaptorDataETC = new ArrayList<>();
            BuddyListGroupItem buddyGroupETCItem = new BuddyListGroupItem(null, null, null, 0);
            ArrayList<ArrayList<BuddyListChildItem>> mSeparatedListAdaptorDataENGLISH = new ArrayList<>();
            ArrayList<BuddyListGroupItem> buddyGroupEnglishItemList = new ArrayList<>();
            for (int englishCount = 0; englishCount < this.alphabetStringIndex.length; englishCount++) {
                ArrayList<BuddyListChildItem> mSeparatedListAdaptorDataOneChar = new ArrayList<>();
                mSeparatedListAdaptorDataENGLISH.add(mSeparatedListAdaptorDataOneChar);
                BuddyListGroupItem buddyGroupOnCharItem = new BuddyListGroupItem(null, null, null, 0);
                buddyGroupEnglishItemList.add(buddyGroupOnCharItem);
            }
            ArrayList<ArrayList<BuddyListChildItem>> mSeparatedListAdaptorDataKOREAN = new ArrayList<>();
            ArrayList<BuddyListGroupItem> buddyGroupKOREANItemList = new ArrayList<>();
            for (int koreanCount = 0; koreanCount < this.koreanStringIndex.length; koreanCount++) {
                ArrayList<BuddyListChildItem> mSeparatedListAdaptorDataOneChar2 = new ArrayList<>();
                mSeparatedListAdaptorDataKOREAN.add(mSeparatedListAdaptorDataOneChar2);
                BuddyListGroupItem buddyGroupOnCharItem2 = new BuddyListGroupItem(null, null, null, 0);
                buddyGroupKOREANItemList.add(buddyGroupOnCharItem2);
            }
            for (int rawCount = 0; rawCount < mRawListAdaptorData.size(); rawCount++) {
                try {
                    ch = mRawListAdaptorData.get(rawCount).getBuddyName().subSequence(0, 1);
                } catch (Exception e) {
                    ch = "";
                }
                if (Pattern.matches(ENGLISHPATTERN, ch.toString().toUpperCase())) {
                    int englishIndex = getIndexInIndexer(false, ch.toString().toUpperCase());
                    buddyGroupEnglishItemList.get(englishIndex).setName(this.alphabetStringIndex[englishIndex]);
                    buddyGroupEnglishItemList.get(englishIndex).setMsg(buddyGroupEnglishItemList.get(englishIndex).getMembers() + 1);
                    mSeparatedListAdaptorDataENGLISH.get(englishIndex).add(mRawListAdaptorData.get(rawCount));
                } else {
                    int index = getIndexInIndexer(true, ch);
                    try {
                        choseong = getChoseong(ch.charAt(0));
                    } catch (Exception e2) {
                        choseong = null;
                    }
                    if (index != -1 || (choseong != null && getIndexInIndexer(true, choseong.subSequence(0, 1)) != -1)) {
                        if (index == -1) {
                            index = getIndexInIndexer(true, choseong.subSequence(0, 1));
                        }
                        if (index == 1 || index == 4 || index == 8 || index == 10 || index == 13) {
                            buddyGroupKOREANItemList.get(index - 1).setName(this.koreanStringIndex[index - 1]);
                            buddyGroupKOREANItemList.get(index - 1).setMsg(buddyGroupKOREANItemList.get(index - 1).getMembers() + 1);
                            mSeparatedListAdaptorDataKOREAN.get(index - 1).add(mRawListAdaptorData.get(rawCount));
                        } else {
                            buddyGroupKOREANItemList.get(index).setName(this.koreanStringIndex[index]);
                            buddyGroupKOREANItemList.get(index).setMsg(buddyGroupKOREANItemList.get(index).getMembers() + 1);
                            mSeparatedListAdaptorDataKOREAN.get(index).add(mRawListAdaptorData.get(rawCount));
                        }
                    } else if (Pattern.matches(KOREANPATTERN, ch)) {
                        buddyGroupETCItem.setName("?");
                        buddyGroupETCItem.setMsg(buddyGroupETCItem.getMembers() + 1);
                        mSeparatedListAdaptorDataETC.add(mRawListAdaptorData.get(rawCount));
                    } else {
                        buddyGroupSharpItem.setName("#");
                        buddyGroupSharpItem.setMsg(buddyGroupSharpItem.getMembers() + 1);
                        mSeparatedListAdaptorDataSharp.add(mRawListAdaptorData.get(rawCount));
                    }
                }
            }
            if (buddyGroupSharpItem.getMembers() > 0) {
                this.adaptorGroupData.add(buddyGroupSharpItem);
                this.adaptorChildData.add(mSeparatedListAdaptorDataSharp);
            }
            Locale lc = MainApplication.mContext.getResources().getConfiguration().locale;
            if (lc.equals(Locale.KOREAN) || lc.equals(Locale.KOREA)) {
                for (int koreanCount2 = 0; koreanCount2 < this.koreanStringIndex.length; koreanCount2++) {
                    if (buddyGroupKOREANItemList.get(koreanCount2).getMembers() > 0) {
                        this.adaptorGroupData.add(buddyGroupKOREANItemList.get(koreanCount2));
                        this.adaptorChildData.add(mSeparatedListAdaptorDataKOREAN.get(koreanCount2));
                    }
                }
                for (int englishCount2 = 0; englishCount2 < this.alphabetStringIndex.length; englishCount2++) {
                    if (buddyGroupEnglishItemList.get(englishCount2).getMembers() > 0) {
                        this.adaptorGroupData.add(buddyGroupEnglishItemList.get(englishCount2));
                        this.adaptorChildData.add(mSeparatedListAdaptorDataENGLISH.get(englishCount2));
                    }
                }
            } else {
                for (int englishCount3 = 0; englishCount3 < this.alphabetStringIndex.length; englishCount3++) {
                    if (buddyGroupEnglishItemList.get(englishCount3).getMembers() > 0) {
                        this.adaptorGroupData.add(buddyGroupEnglishItemList.get(englishCount3));
                        this.adaptorChildData.add(mSeparatedListAdaptorDataENGLISH.get(englishCount3));
                    }
                }
                for (int koreanCount3 = 0; koreanCount3 < this.koreanStringIndex.length; koreanCount3++) {
                    if (buddyGroupKOREANItemList.get(koreanCount3).getMembers() > 0) {
                        this.adaptorGroupData.add(buddyGroupKOREANItemList.get(koreanCount3));
                        this.adaptorChildData.add(mSeparatedListAdaptorDataKOREAN.get(koreanCount3));
                    }
                }
            }
            if (buddyGroupETCItem.getMembers() > 0) {
                this.adaptorGroupData.add(buddyGroupETCItem);
                this.adaptorChildData.add(mSeparatedListAdaptorDataETC);
            }
        }
    }

    private void fillBuddyListDataForAddGroupMember(long groupNo) {
        CharSequence ch;
        String choseong;
        new ArrayList();
        ArrayList<Long> memberUserNumbers = new ArrayList<>();
        Cursor rawCursor = this.buddyDBAdaptor.selectGroupBuddyMapByGroupID(groupNo);
        if (rawCursor != null && rawCursor.getCount() > 0 && rawCursor.moveToFirst()) {
            do {
                memberUserNumbers.add(Long.valueOf(rawCursor.getLong(2)));
            } while (rawCursor.moveToNext());
        }
        if (rawCursor != null) {
            rawCursor.close();
        }
        ArrayList<BuddyListChildItem> mRawListAdaptorData = this.buddyDBAdaptor.getBuddyRawDataForAddMemberList(memberUserNumbers);
        if (mRawListAdaptorData != null && !mRawListAdaptorData.isEmpty()) {
            ArrayList<BuddyListChildItem> mSeparatedListAdaptorDataSharp = new ArrayList<>();
            BuddyListGroupItem buddyGroupSharpItem = new BuddyListGroupItem(null, null, null, 0);
            ArrayList<BuddyListChildItem> mSeparatedListAdaptorDataETC = new ArrayList<>();
            BuddyListGroupItem buddyGroupETCItem = new BuddyListGroupItem(null, null, null, 0);
            ArrayList<ArrayList<BuddyListChildItem>> mSeparatedListAdaptorDataENGLISH = new ArrayList<>();
            ArrayList<BuddyListGroupItem> buddyGroupEnglishItemList = new ArrayList<>();
            for (int englishCount = 0; englishCount < this.alphabetStringIndex.length; englishCount++) {
                ArrayList<BuddyListChildItem> mSeparatedListAdaptorDataOneChar = new ArrayList<>();
                mSeparatedListAdaptorDataENGLISH.add(mSeparatedListAdaptorDataOneChar);
                BuddyListGroupItem buddyGroupOnCharItem = new BuddyListGroupItem(null, null, null, 0);
                buddyGroupEnglishItemList.add(buddyGroupOnCharItem);
            }
            ArrayList<ArrayList<BuddyListChildItem>> mSeparatedListAdaptorDataKOREAN = new ArrayList<>();
            ArrayList<BuddyListGroupItem> buddyGroupKOREANItemList = new ArrayList<>();
            for (int koreanCount = 0; koreanCount < this.koreanStringIndex.length; koreanCount++) {
                ArrayList<BuddyListChildItem> mSeparatedListAdaptorDataOneChar2 = new ArrayList<>();
                mSeparatedListAdaptorDataKOREAN.add(mSeparatedListAdaptorDataOneChar2);
                BuddyListGroupItem buddyGroupOnCharItem2 = new BuddyListGroupItem(null, null, null, 0);
                buddyGroupKOREANItemList.add(buddyGroupOnCharItem2);
            }
            for (int rawCount = 0; rawCount < mRawListAdaptorData.size(); rawCount++) {
                try {
                    ch = mRawListAdaptorData.get(rawCount).getBuddyName().subSequence(0, 1);
                } catch (Exception e) {
                    ch = "";
                }
                if (Pattern.matches(ENGLISHPATTERN, ch.toString().toUpperCase())) {
                    int englishIndex = getIndexInIndexer(false, ch.toString().toUpperCase());
                    buddyGroupEnglishItemList.get(englishIndex).setName(this.alphabetStringIndex[englishIndex]);
                    buddyGroupEnglishItemList.get(englishIndex).setMsg(buddyGroupEnglishItemList.get(englishIndex).getMembers() + 1);
                    mSeparatedListAdaptorDataENGLISH.get(englishIndex).add(mRawListAdaptorData.get(rawCount));
                } else {
                    int index = getIndexInIndexer(true, ch);
                    try {
                        choseong = getChoseong(ch.charAt(0));
                    } catch (Exception e2) {
                        choseong = null;
                    }
                    if (index != -1 || (choseong != null && getIndexInIndexer(true, choseong.subSequence(0, 1)) != -1)) {
                        if (index == -1) {
                            index = getIndexInIndexer(true, choseong.subSequence(0, 1));
                        }
                        if (index == 1 || index == 4 || index == 8 || index == 10 || index == 13) {
                            buddyGroupKOREANItemList.get(index - 1).setName(this.koreanStringIndex[index - 1]);
                            buddyGroupKOREANItemList.get(index - 1).setMsg(buddyGroupKOREANItemList.get(index - 1).getMembers() + 1);
                            mSeparatedListAdaptorDataKOREAN.get(index - 1).add(mRawListAdaptorData.get(rawCount));
                        } else {
                            buddyGroupKOREANItemList.get(index).setName(this.koreanStringIndex[index]);
                            buddyGroupKOREANItemList.get(index).setMsg(buddyGroupKOREANItemList.get(index).getMembers() + 1);
                            mSeparatedListAdaptorDataKOREAN.get(index).add(mRawListAdaptorData.get(rawCount));
                        }
                    } else if (Pattern.matches(KOREANPATTERN, ch)) {
                        buddyGroupETCItem.setName("?");
                        buddyGroupETCItem.setMsg(buddyGroupETCItem.getMembers() + 1);
                        mSeparatedListAdaptorDataETC.add(mRawListAdaptorData.get(rawCount));
                    } else {
                        buddyGroupSharpItem.setName("#");
                        buddyGroupSharpItem.setMsg(buddyGroupSharpItem.getMembers() + 1);
                        mSeparatedListAdaptorDataSharp.add(mRawListAdaptorData.get(rawCount));
                    }
                }
            }
            if (buddyGroupSharpItem.getMembers() > 0) {
                this.adaptorGroupData.add(buddyGroupSharpItem);
                this.adaptorChildData.add(mSeparatedListAdaptorDataSharp);
            }
            Locale lc = MainApplication.mContext.getResources().getConfiguration().locale;
            if (lc.equals(Locale.KOREAN) || lc.equals(Locale.KOREA)) {
                for (int koreanCount2 = 0; koreanCount2 < this.koreanStringIndex.length; koreanCount2++) {
                    if (buddyGroupKOREANItemList.get(koreanCount2).getMembers() > 0) {
                        this.adaptorGroupData.add(buddyGroupKOREANItemList.get(koreanCount2));
                        this.adaptorChildData.add(mSeparatedListAdaptorDataKOREAN.get(koreanCount2));
                    }
                }
                for (int englishCount2 = 0; englishCount2 < this.alphabetStringIndex.length; englishCount2++) {
                    if (buddyGroupEnglishItemList.get(englishCount2).getMembers() > 0) {
                        this.adaptorGroupData.add(buddyGroupEnglishItemList.get(englishCount2));
                        this.adaptorChildData.add(mSeparatedListAdaptorDataENGLISH.get(englishCount2));
                    }
                }
            } else {
                for (int englishCount3 = 0; englishCount3 < this.alphabetStringIndex.length; englishCount3++) {
                    if (buddyGroupEnglishItemList.get(englishCount3).getMembers() > 0) {
                        this.adaptorGroupData.add(buddyGroupEnglishItemList.get(englishCount3));
                        this.adaptorChildData.add(mSeparatedListAdaptorDataENGLISH.get(englishCount3));
                    }
                }
                for (int koreanCount3 = 0; koreanCount3 < this.koreanStringIndex.length; koreanCount3++) {
                    if (buddyGroupKOREANItemList.get(koreanCount3).getMembers() > 0) {
                        this.adaptorGroupData.add(buddyGroupKOREANItemList.get(koreanCount3));
                        this.adaptorChildData.add(mSeparatedListAdaptorDataKOREAN.get(koreanCount3));
                    }
                }
            }
            if (buddyGroupETCItem.getMembers() > 0) {
                this.adaptorGroupData.add(buddyGroupETCItem);
                this.adaptorChildData.add(mSeparatedListAdaptorDataETC);
            }
        }
    }

    @Override // com.coolots.chaton.buddy.BuddyManagerInterface
    public boolean isExistAddBuddyForConferenceMember(ArrayList<Long> memberUserNumbers) {
        new ArrayList();
        ArrayList<BuddyListChildItem> mRawListAdaptorData = this.buddyDBAdaptor.getBuddyRawDataForAddMemberList(memberUserNumbers);
        return (mRawListAdaptorData == null || mRawListAdaptorData.isEmpty()) ? false : true;
    }

    @Override // com.coolots.chaton.buddy.BuddyManagerInterface
    public void fillBuddyListDataForAddConferenceMember(ArrayList<Long> memberUserNumbers) {
        CharSequence ch;
        String choseong;
        resetData();
        fillFavoriteBuddyListDataForAddConferencemember(memberUserNumbers);
        new ArrayList();
        ArrayList<BuddyListChildItem> mRawListAdaptorData = this.buddyDBAdaptor.getBuddyRawDataForAddMemberList(memberUserNumbers);
        if (mRawListAdaptorData != null && !mRawListAdaptorData.isEmpty()) {
            ArrayList<BuddyListChildItem> mSeparatedListAdaptorDataSharp = new ArrayList<>();
            BuddyListGroupItem buddyGroupSharpItem = new BuddyListGroupItem(null, null, null, 0);
            ArrayList<BuddyListChildItem> mSeparatedListAdaptorDataETC = new ArrayList<>();
            BuddyListGroupItem buddyGroupETCItem = new BuddyListGroupItem(null, null, null, 0);
            ArrayList<ArrayList<BuddyListChildItem>> mSeparatedListAdaptorDataENGLISH = new ArrayList<>();
            ArrayList<BuddyListGroupItem> buddyGroupEnglishItemList = new ArrayList<>();
            for (int englishCount = 0; englishCount < this.alphabetStringIndex.length; englishCount++) {
                ArrayList<BuddyListChildItem> mSeparatedListAdaptorDataOneChar = new ArrayList<>();
                mSeparatedListAdaptorDataENGLISH.add(mSeparatedListAdaptorDataOneChar);
                BuddyListGroupItem buddyGroupOnCharItem = new BuddyListGroupItem(null, null, null, 0);
                buddyGroupEnglishItemList.add(buddyGroupOnCharItem);
            }
            ArrayList<ArrayList<BuddyListChildItem>> mSeparatedListAdaptorDataKOREAN = new ArrayList<>();
            ArrayList<BuddyListGroupItem> buddyGroupKOREANItemList = new ArrayList<>();
            for (int koreanCount = 0; koreanCount < this.koreanStringIndex.length; koreanCount++) {
                ArrayList<BuddyListChildItem> mSeparatedListAdaptorDataOneChar2 = new ArrayList<>();
                mSeparatedListAdaptorDataKOREAN.add(mSeparatedListAdaptorDataOneChar2);
                BuddyListGroupItem buddyGroupOnCharItem2 = new BuddyListGroupItem(null, null, null, 0);
                buddyGroupKOREANItemList.add(buddyGroupOnCharItem2);
            }
            for (int rawCount = 0; rawCount < mRawListAdaptorData.size(); rawCount++) {
                try {
                    ch = mRawListAdaptorData.get(rawCount).getBuddyName().subSequence(0, 1);
                } catch (Exception e) {
                    ch = "";
                }
                if (Pattern.matches(ENGLISHPATTERN, ch.toString().toUpperCase())) {
                    int englishIndex = getIndexInIndexer(false, ch.toString().toUpperCase());
                    buddyGroupEnglishItemList.get(englishIndex).setName(this.alphabetStringIndex[englishIndex]);
                    buddyGroupEnglishItemList.get(englishIndex).setMsg(buddyGroupEnglishItemList.get(englishIndex).getMembers() + 1);
                    mSeparatedListAdaptorDataENGLISH.get(englishIndex).add(mRawListAdaptorData.get(rawCount));
                } else {
                    int index = getIndexInIndexer(true, ch);
                    try {
                        choseong = getChoseong(ch.charAt(0));
                    } catch (Exception e2) {
                        choseong = null;
                    }
                    if (index != -1 || (choseong != null && getIndexInIndexer(true, choseong.subSequence(0, 1)) != -1)) {
                        if (index == -1) {
                            index = getIndexInIndexer(true, choseong.subSequence(0, 1));
                        }
                        if (index == 1 || index == 4 || index == 8 || index == 10 || index == 13) {
                            buddyGroupKOREANItemList.get(index - 1).setName(this.koreanStringIndex[index - 1]);
                            buddyGroupKOREANItemList.get(index - 1).setMsg(buddyGroupKOREANItemList.get(index - 1).getMembers() + 1);
                            mSeparatedListAdaptorDataKOREAN.get(index - 1).add(mRawListAdaptorData.get(rawCount));
                        } else {
                            buddyGroupKOREANItemList.get(index).setName(this.koreanStringIndex[index]);
                            buddyGroupKOREANItemList.get(index).setMsg(buddyGroupKOREANItemList.get(index).getMembers() + 1);
                            mSeparatedListAdaptorDataKOREAN.get(index).add(mRawListAdaptorData.get(rawCount));
                        }
                    } else if (Pattern.matches(KOREANPATTERN, ch)) {
                        buddyGroupETCItem.setName("?");
                        buddyGroupETCItem.setMsg(buddyGroupETCItem.getMembers() + 1);
                        mSeparatedListAdaptorDataETC.add(mRawListAdaptorData.get(rawCount));
                    } else {
                        buddyGroupSharpItem.setName("#");
                        buddyGroupSharpItem.setMsg(buddyGroupSharpItem.getMembers() + 1);
                        mSeparatedListAdaptorDataSharp.add(mRawListAdaptorData.get(rawCount));
                    }
                }
            }
            if (buddyGroupSharpItem.getMembers() > 0) {
                this.adaptorGroupData.add(buddyGroupSharpItem);
                this.adaptorChildData.add(mSeparatedListAdaptorDataSharp);
            }
            Locale lc = MainApplication.mContext.getResources().getConfiguration().locale;
            if (lc.equals(Locale.KOREAN) || lc.equals(Locale.KOREA)) {
                for (int koreanCount2 = 0; koreanCount2 < this.koreanStringIndex.length; koreanCount2++) {
                    if (buddyGroupKOREANItemList.get(koreanCount2).getMembers() > 0) {
                        this.adaptorGroupData.add(buddyGroupKOREANItemList.get(koreanCount2));
                        this.adaptorChildData.add(mSeparatedListAdaptorDataKOREAN.get(koreanCount2));
                    }
                }
                for (int englishCount2 = 0; englishCount2 < this.alphabetStringIndex.length; englishCount2++) {
                    if (buddyGroupEnglishItemList.get(englishCount2).getMembers() > 0) {
                        this.adaptorGroupData.add(buddyGroupEnglishItemList.get(englishCount2));
                        this.adaptorChildData.add(mSeparatedListAdaptorDataENGLISH.get(englishCount2));
                    }
                }
            } else {
                for (int englishCount3 = 0; englishCount3 < this.alphabetStringIndex.length; englishCount3++) {
                    if (buddyGroupEnglishItemList.get(englishCount3).getMembers() > 0) {
                        this.adaptorGroupData.add(buddyGroupEnglishItemList.get(englishCount3));
                        this.adaptorChildData.add(mSeparatedListAdaptorDataENGLISH.get(englishCount3));
                    }
                }
                for (int koreanCount3 = 0; koreanCount3 < this.koreanStringIndex.length; koreanCount3++) {
                    if (buddyGroupKOREANItemList.get(koreanCount3).getMembers() > 0) {
                        this.adaptorGroupData.add(buddyGroupKOREANItemList.get(koreanCount3));
                        this.adaptorChildData.add(mSeparatedListAdaptorDataKOREAN.get(koreanCount3));
                    }
                }
            }
            if (buddyGroupETCItem.getMembers() > 0) {
                this.adaptorGroupData.add(buddyGroupETCItem);
                this.adaptorChildData.add(mSeparatedListAdaptorDataETC);
            }
        }
    }

    private void fillBuddyItemListData() {
        this.rawListAdaptorData = this.buddyDBAdaptor.getBuddyRawData(4);
    }

    @Override // com.coolots.chaton.buddy.BuddyManagerInterface
    public ArrayList<BuddyListChildItem> getBuddyListChildItemByUserNo(long userNo) {
        return this.buddyDBAdaptor.getBuddyListChildItemByUserNo(userNo);
    }

    @Override // com.coolots.chaton.buddy.BuddyManagerInterface
    public boolean isBuddyUpdated() {
        return this.buddyDBAdaptor.isBuddyUpdated();
    }

    @Override // com.coolots.chaton.buddy.BuddyManagerInterface
    public boolean isBuddyUpdatedSuggestion() {
        return this.buddyDBAdaptor.isBuddyUpdatedSuggestion();
    }

    @Override // com.coolots.chaton.buddy.BuddyManagerInterface
    public void addBuddy(ArrayList<String> userIDList, Handler handler) {
        AddBuddyAdaptor adaptor = new AddBuddyAdaptor(userIDList, handler, this.mBuddyAdaptorHandler);
        adaptor.start();
    }

    @Override // com.coolots.chaton.buddy.BuddyManagerInterface
    public void addBuddySuggestion(ArrayList<String> userIDList) {
        AddBuddySuggestionAdaptor adaptor = new AddBuddySuggestionAdaptor(userIDList);
        adaptor.start();
    }

    @Override // com.coolots.chaton.buddy.BuddyManagerInterface
    public void autoBuddy(Handler handler, NativePhoneBookInfo nativePhoneBookInfo) {
        AutoBuddyAdaptor adaptor = new AutoBuddyAdaptor(nativePhoneBookInfo.getPhoneBookInfoList(), nativePhoneBookInfo.getNativeNameInfoList(), handler, this.mBuddyAdaptorHandler);
        adaptor.start();
    }

    @Override // com.coolots.chaton.buddy.BuddyManagerInterface
    public void regionCodeSync(Handler handler) {
        RegionDomainInfoAdaptor adaptor = new RegionDomainInfoAdaptor(handler, this.mBuddyAdaptorHandler);
        adaptor.start();
    }

    @Override // com.coolots.chaton.buddy.BuddyManagerInterface
    public void blockBuddy(List<Long> userNos, boolean isBlock, Handler handler) {
        BlockBuddyAdaptor adaptor = new BlockBuddyAdaptor(userNos, isBlock, handler, this.mBuddyAdaptorHandler);
        adaptor.start();
    }

    @Override // com.coolots.chaton.buddy.BuddyManagerInterface
    public void buddySearchByUserID(String userID, Handler handler) {
        BuddySearchInfo searchInfo = new BuddySearchInfo();
        searchInfo.searchByPhoneNumber = false;
        searchInfo.userID = String.valueOf(userID) + "@v";
        BuddySearchAdaptor adaptor = new BuddySearchAdaptor(searchInfo, handler);
        adaptor.start();
    }

    @Override // com.coolots.chaton.buddy.BuddyManagerInterface
    public void buddySearchByPhoneNo(int countryNo, String phoneNo, Handler handler) {
        BuddySearchInfo searchInfo = new BuddySearchInfo();
        searchInfo.searchByPhoneNumber = true;
        searchInfo.countryCode = countryNo;
        searchInfo.phoneNo = phoneNo;
        BuddySearchAdaptor adaptor = new BuddySearchAdaptor(searchInfo, handler);
        adaptor.start();
    }

    @Override // com.coolots.chaton.buddy.BuddyManagerInterface
    public void updateBuddyListDataBase(Handler handler) {
        if (isBuddyUpdatedSuggestion()) {
            Date zeroDate = new Date(0L);
            BuddyListAdaptor adaptor = new BuddyListAdaptor(zeroDate, handler, this.mBuddyAdaptorHandler);
            adaptor.start();
        } else {
            BuddyListAdaptor adaptor2 = new BuddyListAdaptor(this.buddyDBAdaptor.getBuddyUpdateDate(), handler, this.mBuddyAdaptorHandler);
            adaptor2.start();
        }
    }

    @Override // com.coolots.chaton.buddy.BuddyManagerInterface
    public void updateBuddyInfo(long userNo, String editedUserName, Handler handler) {
        if (editedUserName != null && !editedUserName.isEmpty()) {
            UpdateBuddyAdaptor adaptor = new UpdateBuddyAdaptor(userNo, editedUserName, null, false, handler, this.mBuddyAdaptorHandler);
            adaptor.start();
        }
    }

    @Override // com.coolots.chaton.buddy.BuddyManagerInterface
    public void updateBuddyMainPhoneNo(long userNo, String editedPhoneNo, Handler handler) {
        if (editedPhoneNo != null) {
            boolean deletePhoneNo = false;
            if (editedPhoneNo.isEmpty()) {
                deletePhoneNo = true;
            }
            UpdateBuddyAdaptor adaptor = new UpdateBuddyAdaptor(userNo, null, editedPhoneNo, deletePhoneNo, handler, this.mBuddyAdaptorHandler);
            adaptor.start();
        }
    }

    @Override // com.coolots.chaton.buddy.BuddyManagerInterface
    public void hideBuddy(ArrayList<Long> noList, boolean isHide, Handler handler) {
        HideBuddyAdaptor adaptor = new HideBuddyAdaptor(noList, isHide, handler, this.mBuddyAdaptorHandler);
        adaptor.start();
    }

    @Override // com.coolots.chaton.buddy.BuddyManagerInterface
    public void setFavoriteBuddy(long userNo, boolean isFavorite, Handler handler) {
        SetFavoriteBuddyAdaptor adaptor = new SetFavoriteBuddyAdaptor(userNo, isFavorite, handler, this.mBuddyAdaptorHandler);
        adaptor.start();
    }

    @Override // com.coolots.chaton.buddy.BuddyManagerInterface
    public void addBuddyGroup(BuddyGroupInfo buddyGroupInfo, List<BuddyGroupMapInfo> mapList, Handler handler) {
        AddBuddyGroupAdaptor adaptor = new AddBuddyGroupAdaptor(buddyGroupInfo, mapList, handler, this.mBuddyAdaptorHandler);
        adaptor.start();
    }

    @Override // com.coolots.chaton.buddy.BuddyManagerInterface
    public void changeBuddyGroupName(long groupID, String newGroupName, Handler handler) {
        BuddyGroupInfo groupInfo = new BuddyGroupInfo();
        groupInfo.setGroupCode(groupID);
        groupInfo.setGroupName(newGroupName);
        UpdateBuddyGroupAdaptor adaptor = new UpdateBuddyGroupAdaptor(groupInfo, handler, this.mBuddyAdaptorHandler);
        adaptor.start();
    }

    @Override // com.coolots.chaton.buddy.BuddyManagerInterface
    public void deleteBuddyGroup(long groupID, Handler handler) {
        DeleteBuddyGroupAdaptor adaptor = new DeleteBuddyGroupAdaptor(groupID, handler, this.mBuddyAdaptorHandler);
        adaptor.start();
    }

    @Override // com.coolots.chaton.buddy.BuddyManagerInterface
    public void deleteBuddyGroupMember(long groupID, List<Long> buddys, Handler handler) {
        DeleteBuddyGroupMapAdaptor adaptor = new DeleteBuddyGroupMapAdaptor(groupID, buddys, handler, this.mBuddyAdaptorHandler);
        adaptor.start();
    }

    @Override // com.coolots.chaton.buddy.BuddyManagerInterface
    public void addBuddyGroupMember(long groupID, List<Long> buddys, Handler handler) {
        AddBuddyGroupMapAdaptor adaptor = new AddBuddyGroupMapAdaptor(groupID, buddys, handler, this.mBuddyAdaptorHandler);
        adaptor.start();
    }

    @Override // com.coolots.chaton.buddy.BuddyManagerInterface
    public void updateDatabaseForBuddySync() {
        updateBuddyListDataBase(this.mHandler);
    }

    private class DBHandler extends Handler {
        private DBHandler() {
        }

        /* synthetic */ DBHandler(BuddyManager buddyManager, DBHandler dBHandler) {
            this();
        }

        @Override // android.os.Handler
        public void handleMessage(Message msg) {
            if (msg.what == MessageInfo.BuddyListAsk.getDispatchCode()) {
                if (msg.arg1 == 0) {
                    String authID = MainApplication.mConfig.getAuthID();
                    if (authID == null) {
                        Log.m2958e("<<YHT10>> auth id is null!!!");
                    }
                    if (ConfigActivity.isEnableAutoBuddy()) {
                        if (ConfigActivity.isNativeContactChanged() && ChatONSettingData.getInstance().isContactSyncNow()) {
                            BuddyManager.this.startAutoBuddyTask();
                            Log.m2958e("BUDDY_TRACE AutoBuddyAsk Started!!!!!!  setNativeContactChanged false");
                            ConfigActivity.setNativeContactChanged(false);
                        } else {
                            Log.m2958e("BUDDY_TRACE There is no change in Native Contacts");
                            if (RegionDomainUtil.isNeededToRegionDomainSync()) {
                                BuddyManager.this.regionCodeSync(BuddyManager.this.mHandler);
                            } else {
                                Intent intent = new Intent(BuddyManager.BUDDY_UPDATE_ACTION);
                                MainApplication.mContext.sendBroadcast(intent);
                                BuddyManager.this.buddyDBAdaptor.setBuddyUpdated(false);
                                NativeContactProviderUtil.doContactSync();
                            }
                        }
                    } else {
                        Log.m2958e("BUDDY_TRACE autoBuddy impossible!!!!!!");
                        if (RegionDomainUtil.isNeededToRegionDomainSync()) {
                            BuddyManager.this.regionCodeSync(BuddyManager.this.mHandler);
                        } else {
                            Intent intent2 = new Intent(BuddyManager.BUDDY_UPDATE_ACTION);
                            MainApplication.mContext.sendBroadcast(intent2);
                            BuddyManager.this.buddyDBAdaptor.setBuddyUpdated(false);
                            NativeContactProviderUtil.doContactSync();
                        }
                    }
                    BuddyManager.this.setBuddyUpdatedSuggestion(false);
                } else {
                    Intent intent3 = new Intent(BuddyManager.BUDDY_UPDATE_ACTION);
                    MainApplication.mContext.sendBroadcast(intent3);
                    NativeContactProviderUtil.doContactSync();
                }
            }
            if (msg.what == MessageInfo.AutoBuddyAsk.getDispatchCode()) {
                if (msg.arg1 == 0) {
                    if (RegionDomainUtil.isNeededToRegionDomainSync()) {
                        BuddyManager.this.regionCodeSync(BuddyManager.this.mHandler);
                    } else {
                        Intent intent4 = new Intent(BuddyManager.BUDDY_UPDATE_ACTION);
                        MainApplication.mContext.sendBroadcast(intent4);
                        BuddyManager.this.buddyDBAdaptor.setBuddyUpdated(false);
                        NativeContactProviderUtil.doContactSync();
                    }
                } else {
                    Intent intent5 = new Intent(BuddyManager.BUDDY_UPDATE_ACTION);
                    MainApplication.mContext.sendBroadcast(intent5);
                    NativeContactProviderUtil.doContactSync();
                }
            }
            if (msg.what == MessageInfo.RegionDomainInfoAsk.getDispatchCode()) {
                if (msg.arg1 == 0) {
                    Intent intent6 = new Intent(BuddyManager.BUDDY_UPDATE_ACTION);
                    MainApplication.mContext.sendBroadcast(intent6);
                    BuddyManager.this.buddyDBAdaptor.setBuddyUpdated(false);
                    NativeContactProviderUtil.doContactSync();
                    return;
                }
                Intent intent7 = new Intent(BuddyManager.BUDDY_UPDATE_ACTION);
                MainApplication.mContext.sendBroadcast(intent7);
                NativeContactProviderUtil.doContactSync();
            }
        }
    }

    public void startAutoBuddyTask() {
        new Thread(new Runnable() { // from class: com.coolots.chaton.buddy.BuddyManager.1
            @Override // java.lang.Runnable
            public void run() {
                NativePhoneBookInfo nativePhoneBookInfo = BuddyManager.this.getPBListFromNativeForAutoBuddy();
                if (nativePhoneBookInfo == null) {
                    Log.m2958e("BUDDY_TRACE there is no changes nativePhoneBook!!!!!!");
                    if (RegionDomainUtil.isNeededToRegionDomainSync()) {
                        BuddyManager.this.regionCodeSync(BuddyManager.this.mHandler);
                        return;
                    }
                    Intent intent = new Intent(BuddyManager.BUDDY_UPDATE_ACTION);
                    MainApplication.mContext.sendBroadcast(intent);
                    BuddyManager.this.buddyDBAdaptor.setBuddyUpdated(false);
                    NativeContactProviderUtil.doContactSync();
                    return;
                }
                Log.m2958e("BUDDY_TRACE there is some changes in nativePhoneBook!!!!!!");
                BuddyManager.this.autoBuddy(BuddyManager.this.mHandler, nativePhoneBookInfo);
            }
        }).start();
    }

    @Override // com.coolots.chaton.buddy.BuddyManagerInterface, com.sds.coolots.contact.ContactManagerInterface
    public boolean isFriend(String userID) {
        BuddyInfo buddy = this.buddyDBAdaptor.findBuddyByUserID(userID);
        return buddy != null;
    }

    @Override // com.sds.coolots.contact.ContactManagerInterface
    public String getUserNameByUserID(String userID) {
        BuddyInfo buddy = this.buddyDBAdaptor.findBuddyByUserID(userID);
        return buddy == null ? userID : buddy.getUserName();
    }

    @Override // com.coolots.chaton.buddy.BuddyManagerInterface
    public String getUserNameByUserIDForAddbuddyList(long userNo) {
        return this.buddyDBAdaptor.findBuddyByUserNoForAddBuddyList(userNo);
    }

    @Override // com.coolots.chaton.buddy.BuddyManagerInterface
    public String getUserNameByUserIDForCallLogDetail(String userID) {
        BuddyInfo buddy = this.buddyDBAdaptor.findBuddyByUserIDForCallLogDetail(userID);
        return buddy == null ? userID : buddy.getUserName();
    }

    @Override // com.coolots.chaton.buddy.BuddyManagerInterface
    public ArrayList<String> getPhoneNoArrayListByUserNo(long userNo) {
        return this.buddyDBAdaptor.getPhoneNoArrayListByUserNo(userNo);
    }

    @Override // com.coolots.chaton.buddy.BuddyManagerInterface
    public ArrayList<String> getPhoneNoArrayListByUserID(String userID) {
        return this.buddyDBAdaptor.getPhoneNoArrayListByUserID(userID);
    }

    @Override // com.coolots.chaton.buddy.BuddyManagerInterface
    public long getUserNoByAccountID(String accountID) {
        return this.buddyDBAdaptor.getUserNoByAccountID(accountID);
    }

    @Override // com.coolots.chaton.buddy.BuddyManagerInterface
    public long getUserNoByAccountIDWithNoException(String accountID) {
        return this.buddyDBAdaptor.getUserNoByAccountIDWithNoException(accountID);
    }

    @Override // com.coolots.chaton.buddy.BuddyManagerInterface
    public String getAccountIDByUserNo(long userNo) {
        return this.buddyDBAdaptor.getAccountIDByUserNo(userNo);
    }

    @Override // com.coolots.chaton.buddy.BuddyManagerInterface
    public long getUserNoByUserID(String userID) {
        return this.buddyDBAdaptor.getUserNoByUserID(userID);
    }

    @Override // com.coolots.chaton.buddy.BuddyManagerInterface
    public String getUserMessageByUserID(String userID) {
        return null;
    }

    @Override // com.coolots.chaton.buddy.BuddyManagerInterface
    public String getUserMessageByUserNO(long userNo) {
        return this.buddyDBAdaptor.getUserMessageByUserNO(userNo);
    }

    public long getRegionByUserNo(long userNo) {
        return this.buddyDBAdaptor.getRegionByUserNo(userNo);
    }

    @Override // com.coolots.chaton.buddy.BuddyManagerInterface
    public Cursor selectRegionCode() {
        return this.buddyDBAdaptor.selectRegionCode();
    }

    @Override // com.coolots.chaton.buddy.BuddyManagerInterface
    public String getRegionImageURLByUserNo(long userNo) {
        return this.buddyDBAdaptor.getRegionImageURLByUserNo(userNo);
    }

    @Override // com.coolots.chaton.buddy.BuddyManagerInterface
    public String getRegionImageURLByRegion(long region) {
        return this.buddyDBAdaptor.getRegionImageURLByRegion(region);
    }

    @Override // com.sds.coolots.contact.ContactManagerInterface
    public boolean isBlockUser(String userID, Handler handler) {
        return this.buddyDBAdaptor.isBlockUser(userID);
    }

    @Override // com.coolots.chaton.buddy.BuddyManagerInterface
    public int getKindOfBuddy(String userID) {
        int retValue;
        Cursor rawCursor = this.buddyDBAdaptor.selectBuddyByUserIDWithNoException(userID);
        if (rawCursor == null || rawCursor.getCount() <= 0 || !rawCursor.moveToFirst() || rawCursor.getInt(19) == 1) {
            retValue = 4;
        } else if (rawCursor.getInt(14) == 1) {
            retValue = 2;
        } else if (rawCursor.getInt(15) == 1) {
            retValue = 1;
        } else if (rawCursor.getInt(18) == 1) {
            retValue = 3;
        } else {
            retValue = 0;
        }
        if (rawCursor != null) {
            rawCursor.close();
        }
        return retValue;
    }

    @Override // com.coolots.chaton.buddy.BuddyManagerInterface
    public int getKindOfBuddy(long userNo) {
        int retValue;
        Cursor rawCursor = this.buddyDBAdaptor.selectBuddyByUserNoWithNoException(userNo);
        if (rawCursor == null || rawCursor.getCount() <= 0 || !rawCursor.moveToFirst() || rawCursor.getInt(19) == 1) {
            retValue = 4;
        } else if (rawCursor.getInt(14) == 1) {
            retValue = 2;
        } else if (rawCursor.getInt(15) == 1) {
            retValue = 1;
        } else if (rawCursor.getInt(18) == 1) {
            retValue = 3;
        } else {
            retValue = 0;
        }
        if (rawCursor != null) {
            rawCursor.close();
        }
        return retValue;
    }

    @Override // com.coolots.chaton.buddy.BuddyManagerInterface
    public boolean isNeedDeleteContactSync(String userSA) {
        boolean retValue;
        Cursor rawCursor = this.buddyDBAdaptor.selectBuddyByAccountIDWithNoException(userSA);
        long userNo = -1;
        if (rawCursor == null || rawCursor.getCount() <= 0 || !rawCursor.moveToFirst() || rawCursor.getInt(14) == 1 || rawCursor.getInt(15) == 1 || rawCursor.getInt(18) == 1) {
            retValue = true;
        } else {
            userNo = rawCursor.getLong(1);
            retValue = false;
        }
        if (rawCursor != null) {
            rawCursor.close();
        }
        if (!retValue) {
            ArrayList<String> phoneNumberList = this.buddyDBAdaptor.getPhoneNoArrayListByUserNo(userNo);
            if (phoneNumberList == null || phoneNumberList.isEmpty()) {
                retValue = true;
            }
            String BuddySA = this.buddyDBAdaptor.getAccountIDByUserNo(userNo);
            if (BuddySA == null || BuddySA.isEmpty() || !BuddySA.equals(userSA)) {
                return true;
            }
            return retValue;
        }
        return retValue;
    }

    @Override // com.sds.coolots.contact.ContactManagerInterface
    public boolean isBlockPhoneNo(String phoneNo, Handler handler) {
        return false;
    }

    @Override // com.sds.coolots.contact.ContactManagerInterface
    public boolean isBlockUserForCall(String userID, short deviceID, Destination destination, int callID, boolean UseVideo, boolean isP2P, boolean isSecureCommunication, boolean isLiveShare, String displayName, Date date, BlockCallHandler handler) {
        if (userID == null || userID.isEmpty() || handler == null) {
            return false;
        }
        if (this.buddyDBAdaptor.isBlockUser(userID)) {
            handler.handleBlockedCall(destination, callID, UseVideo, isP2P, isLiveShare, displayName, date);
        } else {
            handler.startIncomingCall(destination, deviceID, callID, UseVideo, isP2P, isSecureCommunication, isLiveShare, displayName, date);
        }
        return true;
    }

    @Override // com.sds.coolots.contact.ContactManagerInterface
    public boolean isBlockUserForConf(String userID, Destination destination, ConferenceInfo confInfo, Date startTime, String p2pKey, BlockCallHandler handler, String inviteUserID) {
        if ((userID == null || userID.isEmpty() || handler == null) && (MainApplication.mConfig.getCallHangupType() == 1 || handler == null)) {
            return false;
        }
        if (this.buddyDBAdaptor.isBlockUser(userID)) {
            handler.handleBlockedConference(destination, confInfo, startTime);
        } else {
            handler.startIncomingConference(destination, confInfo, startTime, p2pKey, inviteUserID);
        }
        return true;
    }

    @Override // com.sds.coolots.common.controller.EngineContactCallbackInterface
    public boolean handleContactMessage(MsgBody msgBody) {
        if (msgBody instanceof RefreshBuddyAsk) {
            setBuddyUpdated(true);
        } else if (msgBody instanceof RefreshProfileAsk) {
            ((VAppPhoneManager) MainApplication.mPhoneManager).getProfileManager().handleRefreshProfileAsk((RefreshProfileAsk) msgBody);
        } else if (msgBody instanceof NotifyUnsubscribeAsk) {
            Log.m2958e("BUDDY_TRACE one of My Buddy Delete Samsung Account From WEB!!!!!!!!!!!!!!!!!!!!!!");
            updateDatabaseForBuddySync();
        } else if (msgBody instanceof NotifyUnsubscribeMyIDAsk) {
            Log.m2958e("BUDDY_TRACE My Samsung Account Delete from WEB!!!!!!!!!!!!!!!!!!!!! BuddyManager");
            if (!PhoneManager.isSamsungAccountDeleted) {
                Intent deleteAccountIntent = MainApplication.mDeleteAccountIntentGenerator.getDeleteAccountIntent();
                deleteAccountIntent.addFlags(268435456);
                deleteAccountIntent.addFlags(536870912);
                deleteAccountIntent.addFlags(8388608);
                MainApplication.mContext.startActivity(deleteAccountIntent);
                PhoneManager.isSamsungAccountDeleted = true;
            }
        }
        return true;
    }

    public void setBuddyUpdated(boolean updated) {
        this.buddyDBAdaptor.setBuddyUpdated(updated);
    }

    @Override // com.coolots.chaton.buddy.BuddyManagerInterface
    public void setBuddyUpdatedSuggestion(boolean updated) {
        this.buddyDBAdaptor.setBuddyUpdatedSuggestion(updated);
    }

    @Override // com.coolots.chaton.buddy.BuddyManagerInterface
    public String getDisplayNameByPriorityPolicy(String editedName, String nativeName, String userName) {
        if (editedName == null) {
            if (nativeName != null) {
                return nativeName;
            }
            if (userName != null) {
                return userName;
            }
            return null;
        }
        return editedName;
    }

    @Override // com.coolots.chaton.buddy.BuddyManagerInterface
    public String getFirstNumberBYUserNo(long userNo) {
        return this.buddyDBAdaptor.getFirstNumberBYUserNo(userNo);
    }

    @Override // com.coolots.chaton.buddy.BuddyManagerInterface
    public Long getGroupIDBYGroupName(String groupName) {
        return Long.valueOf(this.buddyDBAdaptor.getBuddyGroupIDByGroupName(groupName));
    }

    @Override // com.coolots.chaton.buddy.BuddyManagerInterface
    public ArrayList<Long> getGroupNoListBYUserNo(long userNo) {
        return this.buddyDBAdaptor.getGroupNoListBYUserNo(userNo);
    }

    @Override // com.coolots.chaton.buddy.BuddyManagerInterface
    public String getGroupNameByGroupID(long groupId) {
        return this.buddyDBAdaptor.getBuddyGroupNameByGroupID(groupId);
    }

    @Override // com.coolots.chaton.buddy.BuddyManagerInterface
    public ArrayList<NativeContactSyncData> getPBListFromNativeForContactSync() {
        String[] PHONE_PROJECTION = {DatabaseHelper.KEY_ROWID, SlookAirButtonFrequentContactAdapter.DISPLAY_NAME, "data1", "raw_contact_id"};
        Cursor cursor = MainApplication.mContext.getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, PHONE_PROJECTION, null, null, null);
        if (cursor != null && cursor.getCount() > 0 && cursor.moveToFirst()) {
            ArrayList<NativeContactInfo> dbPhoneNoList = new ArrayList<>();
            do {
                String nativePhoneNumber = cursor.getString(cursor.getColumnIndex("data1"));
                PhoneNoInfo phoneNoInfo = getDbPhoneNo(nativePhoneNumber);
                if (phoneNoInfo != null && phoneNoInfo.phoneNo != null && !phoneNoInfo.phoneNo.isEmpty()) {
                    NativeContactInfo info = new NativeContactInfo();
                    info.phoneNo = phoneNoInfo.phoneNo;
                    info.countryCode = phoneNoInfo.countryCode;
                    info.displayName = cursor.getString(cursor.getColumnIndex(SlookAirButtonFrequentContactAdapter.DISPLAY_NAME));
                    info.rawContactID = cursor.getLong(cursor.getColumnIndex("raw_contact_id"));
                    dbPhoneNoList.add(info);
                }
            } while (cursor.moveToNext());
            cursor.close();
            List<BuddyPhoneNoInfo> buddyPhoneNoList = this.buddyDBAdaptor.getBuddyPhoneNo();
            ArrayList<NativeContactSyncData> result = new ArrayList<>();
            if (buddyPhoneNoList == null) {
                return null;
            }
            Iterator<NativeContactInfo> it = dbPhoneNoList.iterator();
            while (it.hasNext()) {
                NativeContactInfo nativeInfo = it.next();
                for (BuddyPhoneNoInfo buddyInfo : buddyPhoneNoList) {
                    if (buddyInfo.phoneNo.equals(nativeInfo.phoneNo)) {
                        NativeContactSyncData tempSyncData = new NativeContactSyncData();
                        tempSyncData.setNativeName(nativeInfo.displayName);
                        tempSyncData.setSamsungAccount(buddyInfo.samsungAccountID);
                        tempSyncData.setUserID(buddyInfo.userID);
                        tempSyncData.setUserNo(buddyInfo.userNo);
                        tempSyncData.setRawContactID(nativeInfo.rawContactID);
                        result.add(tempSyncData);
                    }
                }
            }
            return result;
        }
        if (cursor != null) {
            cursor.close();
        }
        return null;
    }

    public PhoneNoInfo getDbPhoneNo(String phoneNo) {
        String simCountryISOStr;
        String simCountryCodeStr;
        String dbPhoneNumber;
        PhoneNoInfo phoneNoInfo = new PhoneNoInfo();
        if (phoneNo == null) {
            return null;
        }
        String tempString = phoneNo.replace(" ", "");
        String nativePhoneNumber = tempString.replace("-", "");
        if (nativePhoneNumber.startsWith("00")) {
            nativePhoneNumber = nativePhoneNumber.substring(2);
        }
        if (nativePhoneNumber.startsWith("+")) {
            nativePhoneNumber = nativePhoneNumber.substring(1);
        }
        if (nativePhoneNumber != null && nativePhoneNumber.length() > 0) {
            String.valueOf(0);
            PhoneNumberUtil phone = new PhoneNumberUtil(nativePhoneNumber);
            String nationalCode = phone.getCountryCode();
            if (nationalCode == null || nationalCode.length() == 0) {
                if (this.f1tm == null) {
                    this.f1tm = (TelephonyManager) MainApplication.mContext.getSystemService("phone");
                }
                int simState = this.f1tm.getSimState();
                if (simState != 1 && simState != 0 && (simCountryISOStr = this.f1tm.getSimCountryIso()) != null && !simCountryISOStr.isEmpty() && (simCountryCodeStr = MainApplication.mPhoneManager.getConfigManager().getCountryFromIso(simCountryISOStr)) != null && !simCountryCodeStr.isEmpty()) {
                    nationalCode = simCountryCodeStr;
                } else {
                    nationalCode = String.valueOf(ConfigActivity.getProfileCountryCode());
                }
            }
            String transformedPhoneNumber = phone.getPhoneNumber();
            if (transformedPhoneNumber == null || transformedPhoneNumber.length() == 0) {
                transformedPhoneNumber = nativePhoneNumber;
            }
            if (transformedPhoneNumber.startsWith("0")) {
                dbPhoneNumber = String.valueOf(nationalCode) + transformedPhoneNumber.substring(1);
            } else {
                dbPhoneNumber = String.valueOf(nationalCode) + transformedPhoneNumber;
            }
            phoneNoInfo.phoneNo = dbPhoneNumber;
            phoneNoInfo.countryCode = nationalCode;
            return phoneNoInfo;
        }
        return phoneNoInfo;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public NativePhoneBookInfo getPBListFromNativeForAutoBuddy() {
        Log.m2963i("<<YHT2>> getPBListFromNativeForAutoBuddy executed!!");
        List<PhoneBookInfo> pbList = new ArrayList<>();
        List<NativeNameAndPhoneNumberInfo> nameList = new ArrayList<>();
        NativePhoneBookInfo nativephoneBookInfo = new NativePhoneBookInfo();
        String[] PHONE_PROJECTION = {DatabaseHelper.KEY_ROWID, SlookAirButtonFrequentContactAdapter.DISPLAY_NAME, "data1"};
        Cursor cursor = MainApplication.mContext.getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, PHONE_PROJECTION, null, null, null);
        if (cursor != null && cursor.getCount() > 0 && cursor.moveToFirst()) {
            ArrayList<NativeContactInfo> dbPhoneNoList = new ArrayList<>();
            do {
                String nativePhoneNumber = cursor.getString(cursor.getColumnIndex("data1"));
                PhoneNoInfo phoneNoInfo = getDbPhoneNo(nativePhoneNumber);
                if (phoneNoInfo != null && phoneNoInfo.phoneNo != null && !phoneNoInfo.phoneNo.isEmpty()) {
                    NativeContactInfo info = new NativeContactInfo();
                    info.phoneNo = phoneNoInfo.phoneNo;
                    info.countryCode = phoneNoInfo.countryCode;
                    info.displayName = cursor.getString(cursor.getColumnIndex(SlookAirButtonFrequentContactAdapter.DISPLAY_NAME));
                    dbPhoneNoList.add(info);
                }
            } while (cursor.moveToNext());
            cursor.close();
            List<BuddyPhoneNoInfo> buddyPhoneNoList = this.buddyDBAdaptor.getBuddyPhoneNoForAutoBuddy();
            List<BuddyPhoneNoInfo> nameUpdateList = new ArrayList<>();
            Iterator<NativeContactInfo> it = dbPhoneNoList.iterator();
            while (it.hasNext()) {
                NativeContactInfo nativeInfo = it.next();
                boolean bFound = false;
                Iterator<BuddyPhoneNoInfo> it2 = buddyPhoneNoList.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        break;
                    }
                    BuddyPhoneNoInfo buddyInfo = it2.next();
                    if (buddyInfo.phoneNo.equals(nativeInfo.phoneNo)) {
                        bFound = true;
                        BuddyPhoneNoInfo temp = new BuddyPhoneNoInfo();
                        temp.userNo = buddyInfo.userNo;
                        temp.displayName = nativeInfo.displayName;
                        nameUpdateList.add(temp);
                        break;
                    }
                }
                if (!bFound) {
                    try {
                        PhoneBookInfo phoneBook = new PhoneBookInfo();
                        NativeNameAndPhoneNumberInfo nativeNameInfo = new NativeNameAndPhoneNumberInfo();
                        phoneBook.setCountryCode(Integer.parseInt(nativeInfo.countryCode));
                        phoneBook.setPhoneNo(nativeInfo.phoneNo);
                        pbList.add(phoneBook);
                        nativeNameInfo.setNativeName(nativeInfo.displayName);
                        nativeNameInfo.setPhoneNumber(nativeInfo.phoneNo);
                        nameList.add(nativeNameInfo);
                    } catch (OutOfMemoryError e) {
                        e.printStackTrace();
                        return null;
                    }
                }
            }
            deleteNativeNameInBuddyTable();
            for (BuddyPhoneNoInfo updateInfo : nameUpdateList) {
                Cursor tempCursor = this.buddyDBAdaptor.selectBuddyByUserNoForAutoBuddy(updateInfo.userNo);
                if (tempCursor != null && tempCursor.moveToFirst()) {
                    BuddyInfo buddy = ValueObjectConverter.makeBuddyInfoFromBuddyCursor(tempCursor);
                    if (tempCursor != null) {
                        tempCursor.close();
                    }
                    if (buddy != null) {
                        ContentValues query = new ContentValues();
                        query.put(DatabaseHelper.KEY_USERNO, Long.valueOf(updateInfo.userNo));
                        Log.m2958e("BUDDY_TRACE Update Native Name : " + updateInfo.displayName);
                        ContentValues execute = ValueObjectConverter.makeBuddyContentValuesFromBuddyInfo(buddy, updateInfo.displayName, false, false);
                        this.buddyDBAdaptor.updateBuddy(execute, query);
                    }
                } else if (tempCursor != null) {
                    tempCursor.close();
                }
            }
            nativephoneBookInfo.setNativeNameInfoList(nameList);
            nativephoneBookInfo.setPhoneBookInfoList(pbList);
            Log.m2963i("<<YHT2>> getPBListFromNativeForAutoBuddy finished!!");
            return nativephoneBookInfo;
        }
        deleteNativeNameInBuddyTable();
        if (cursor != null) {
            cursor.close();
        }
        return null;
    }

    private void deleteNativeNameInBuddyTable() {
        BuddyInfo buddy;
        Cursor rawCursor = this.buddyDBAdaptor.selectBuddyAll();
        if (rawCursor != null && rawCursor.moveToFirst()) {
            do {
                if (rawCursor.getString(6) != null && (buddy = ValueObjectConverter.makeBuddyInfoFromBuddyCursor(rawCursor)) != null) {
                    ContentValues query = new ContentValues();
                    query.put(DatabaseHelper.KEY_USERNO, Long.valueOf(rawCursor.getLong(1)));
                    ContentValues execute = ValueObjectConverter.makeBuddyContentValuesFromBuddyInfo(buddy, null, false, true);
                    this.buddyDBAdaptor.updateBuddy(execute, query);
                }
            } while (rawCursor.moveToNext());
            rawCursor.close();
            return;
        }
        if (rawCursor != null) {
            rawCursor.close();
        }
    }

    @Override // com.coolots.chaton.buddy.BuddyManagerInterface
    public ArrayList<BuddyListChildItem> getBlockList() {
        Cursor cursor = this.buddyDBAdaptor.selectBuddyForBlockList();
        if (cursor != null && cursor.moveToFirst()) {
            ArrayList<BuddyListChildItem> BLCIList = ValueObjectConverter.makeBuddyListChildItemArrayFromBuddyCursor(cursor);
            cursor.close();
            return (ArrayList) BLCIList.clone();
        }
        if (cursor != null) {
            cursor.close();
        }
        return null;
    }

    @Override // com.coolots.chaton.buddy.BuddyManagerInterface
    public ArrayList<BuddyListChildItem> getHideList() {
        Cursor cursor = this.buddyDBAdaptor.selectBuddyForHideList();
        if (cursor == null || !cursor.moveToFirst()) {
            return null;
        }
        ArrayList<BuddyListChildItem> BLCIList = ValueObjectConverter.makeBuddyListChildItemArrayFromBuddyCursor(cursor);
        cursor.close();
        return (ArrayList) BLCIList.clone();
    }

    @Override // com.coolots.chaton.buddy.BuddyManagerInterface
    public ArrayList<BuddyListChildItem> getSuggestionList() {
        Cursor cursor = this.buddyDBAdaptor.selectBuddyForSuggestionList();
        if (cursor != null && cursor.moveToFirst()) {
            ArrayList<BuddyListChildItem> BLCIList = ValueObjectConverter.makeBuddyListChildItemArrayFromBuddyCursor(cursor);
            cursor.close();
            return (ArrayList) BLCIList.clone();
        }
        if (cursor != null) {
            cursor.close();
        }
        return null;
    }

    @Override // com.coolots.chaton.buddy.BuddyManagerInterface
    public ArrayList<BuddyListChildItem> getGroupMemberListByGroupID(long groupid) throws Throwable {
        ArrayList<BuddyListChildItem> retValue = null;
        Cursor cursor = this.buddyDBAdaptor.selectGroupBuddyMapByGroupID(groupid);
        if (cursor != null) {
            try {
                if (cursor.moveToFirst()) {
                    new ArrayList();
                    try {
                        retValue = ValueObjectConverter.makeBuddyListChildItemArrayFromGroupBuddyMapCursor(cursor);
                    } catch (Throwable th) {
                        th = th;
                        if (cursor != null) {
                            cursor.close();
                        }
                        throw th;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }
        if (cursor != null) {
            cursor.close();
        }
        return retValue;
    }

    @Override // com.coolots.chaton.buddy.BuddyManagerInterface
    public int getSuggestionCount() {
        Cursor rawCursor = this.buddyDBAdaptor.selectBuddyForSuggestionList();
        if (rawCursor != null && rawCursor.moveToFirst()) {
            int retValue = rawCursor.getCount();
            rawCursor.close();
            return retValue;
        }
        if (rawCursor != null) {
            rawCursor.close();
        }
        return 0;
    }

    @Override // com.coolots.chaton.buddy.BuddyManagerInterface
    public void updateFreshBuddyStateInBuddyTable() {
        this.buddyDBAdaptor.updateFreshBuddyStateInBuddyTable();
    }

    @Override // com.coolots.chaton.buddy.BuddyManagerInterface
    public BuddyTable getVAppBuddyInfoTextData(String accountID) throws Throwable {
        Cursor cursor = this.buddyDBAdaptor.selectBuddyByAccountID(accountID);
        BuddyTable buddyTable = null;
        if (cursor != null) {
            try {
                if (cursor.moveToFirst()) {
                    new BuddyTable();
                    try {
                        buddyTable = ValueObjectConverter.makeBuddyTableFromBuddyCursor(cursor);
                    } catch (Throwable th) {
                        th = th;
                        if (cursor != null) {
                            cursor.close();
                        }
                        throw th;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }
        if (cursor != null) {
            cursor.close();
        }
        return buddyTable;
    }

    @Override // com.coolots.chaton.buddy.BuddyManagerInterface
    public List<BuddyTable> getVAppBuddyInfoTextData(List<String> accountID) {
        ArrayList<BuddyTable> buddyTableList = new ArrayList<>();
        for (String singleAccountID : accountID) {
            buddyTableList.add(getVAppBuddyInfoTextData(singleAccountID));
        }
        return buddyTableList;
    }

    @Override // com.coolots.chaton.buddy.BuddyManagerInterface
    public BuddyTable getVAppBuddyInfoTextDataByPhoneNumber(String phoneNumber) {
        Cursor rawCursor = this.buddyDBAdaptor.selectIDNumberByPhoneNo(phoneNumber);
        new BuddyTable();
        if (rawCursor != null && rawCursor.moveToFirst()) {
            Cursor buddyCursor = this.buddyDBAdaptor.selectBuddyByUserNo(rawCursor.getLong(1));
            if (buddyCursor != null && buddyCursor.moveToFirst()) {
                BuddyTable retValue = ValueObjectConverter.makeBuddyTableFromBuddyCursor(buddyCursor);
                buddyCursor.close();
                rawCursor.close();
                return retValue;
            }
            if (buddyCursor == null) {
                return null;
            }
            buddyCursor.close();
            return null;
        }
        if (rawCursor == null) {
            return null;
        }
        rawCursor.close();
        return null;
    }

    @Override // com.coolots.chaton.buddy.BuddyManagerInterface
    public List<BuddyTable> getVAppBuddyInfoTextDataByPhoneNumber(List<String> phoneNumber) {
        ArrayList<BuddyTable> buddyTableList = new ArrayList<>();
        for (String singlePhoneNo : phoneNumber) {
            buddyTableList.add(getVAppBuddyInfoTextDataByPhoneNumber(singlePhoneNo));
        }
        return buddyTableList;
    }

    @Override // com.coolots.chaton.buddy.BuddyManagerInterface
    public BuddyTable getVAppBuddyInfoTextDataByUserNo(long userNo) throws Throwable {
        Cursor cursor = this.buddyDBAdaptor.selectBuddyByUserNo(userNo);
        BuddyTable retValue = null;
        if (cursor != null) {
            try {
                if (cursor.moveToFirst()) {
                    new BuddyTable();
                    try {
                        retValue = ValueObjectConverter.makeBuddyTableFromBuddyCursor(cursor);
                    } catch (Throwable th) {
                        th = th;
                        if (cursor != null) {
                            cursor.close();
                        }
                        throw th;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }
        if (cursor != null) {
            cursor.close();
        }
        return retValue;
    }

    @Override // com.coolots.chaton.buddy.BuddyManagerInterface
    public boolean getVAppBuddyInfoImageData(String userID, Handler handler) {
        return false;
    }

    @Override // com.coolots.chaton.buddy.BuddyManagerInterface
    public boolean getVAppBuddyInfoImageData(List<String> userID, Handler handler) {
        return false;
    }

    @Override // com.coolots.chaton.buddy.BuddyManagerInterface
    public boolean getVAppBuddyInfoImageDataByPhoneNumber(String phoneNumber, Handler handler) {
        return false;
    }

    @Override // com.coolots.chaton.buddy.BuddyManagerInterface
    public boolean getVAppBuddyInfoImageDataByPhoneNumber(List<String> phoneNumber, Handler handler) {
        return false;
    }

    @Override // com.coolots.chaton.buddy.BuddyManagerInterface
    public Bitmap getVAppBuddyInfoImageData(String userID) {
        return null;
    }

    @Override // com.coolots.chaton.buddy.BuddyManagerInterface
    public List<Bitmap> getVAppBuddyInfoImageData(List<String> userID) {
        return null;
    }

    @Override // com.coolots.chaton.buddy.BuddyManagerInterface
    public Bitmap getVAppBuddyInfoImageDataByPhoneNumber(String phoneNumber) {
        return null;
    }

    @Override // com.coolots.chaton.buddy.BuddyManagerInterface
    public List<Bitmap> getVAppBuddyInfoImageDataByPhoneNumber(List<String> phoneNumber) {
        return null;
    }

    @Override // com.coolots.chaton.buddy.BuddyManagerInterface
    public String getVAppBuddyInfoProfileName(String userID) {
        return null;
    }

    @Override // com.coolots.chaton.buddy.BuddyManagerInterface
    public HashMap<String, String> getVAppBuddyInfoProfileName(List<String> userID) {
        return null;
    }

    @Override // com.coolots.chaton.buddy.BuddyManagerInterface
    public ArrayList<SimpleUserInfo> getSimpleUserInfoFromMSISDN(List<String> MSISDNs) {
        return null;
    }

    @Override // com.coolots.chaton.buddy.BuddyManagerInterface
    public ArrayList<SimpleUserInfo> getSimpleUserInfoFromMSISDN(HashMap<String, String> userInfo) {
        return null;
    }

    @Override // com.coolots.chaton.buddy.BuddyManagerInterface
    public ArrayList<P2PUserInfo> getP2PUserInfoFromMSISDN(List<String> MSISDNs) {
        return null;
    }

    @Override // com.coolots.chaton.buddy.BuddyManagerInterface
    public ArrayList<P2PUserInfo> getP2PUserInfoFromMSISDN(HashMap<String, String> userInfo) {
        return null;
    }

    public static String getChoseong(char ch) {
        int hCode = (ch - HANGUL_SYLLABLES_BEGIN) / (HANGUL_JUNGSEONG_SIZE * HANGUL_JONGSEONG_SIZE);
        if (hCode <= -1 || hCode > HANGUL_CHOSEONG_SIZE - 1) {
            return null;
        }
        return String.valueOf(HANGUL_CHOSEONG[hCode]);
    }

    private int getIndexInIndexer(boolean isKorean, CharSequence oneChar) {
        String[] indexer;
        if (isKorean) {
            indexer = (String[]) this.koreanStringIndex.clone();
        } else {
            indexer = (String[]) this.alphabetStringIndex.clone();
        }
        for (int count = 0; count < indexer.length; count++) {
            if (indexer[count].equals(oneChar.toString())) {
                return count;
            }
        }
        return -1;
    }

    @Override // com.coolots.chaton.buddy.BuddyManagerInterface
    public boolean isExistImageUpdateDate(boolean isBuddy, long code) {
        return this.buddyDBAdaptor.isExistImageUpdateDate(isBuddy, code);
    }

    @Override // com.coolots.chaton.buddy.BuddyManagerInterface
    public void setGroupImageUpdateDate(long groupCode, Date updateDate) {
        this.buddyDBAdaptor.setGroupImageUpdateDate(groupCode, updateDate);
    }

    @Override // com.coolots.chaton.buddy.BuddyManagerInterface
    public void resetBuddyUpdatedate() {
        Date resetDate = new Date();
        resetDate.setTime(0L);
        ConfigActivity.setBuddyUpdateDate(resetDate);
    }

    @Override // com.coolots.chaton.buddy.BuddyManagerInterface
    public void deleteAllSuggestionBuddy() {
        Log.m2958e("BUDDY_TRACE deleteAllSuggestionBuddy");
        this.buddyDBAdaptor.deleteAllSuggestionBuddy();
    }

    @Override // com.coolots.chaton.buddy.BuddyManagerInterface
    public long getUserNoByUserIDWithNoException(String userID) {
        return this.buddyDBAdaptor.getUserNoByUserIDWithNoException(userID);
    }

    @Override // com.coolots.chaton.buddy.BuddyManagerInterface
    public long deleteEmptyGroup(Handler handler) {
        Cursor groupCursor = this.buddyDBAdaptor.selectBuddyGroupAll();
        ArrayList<Long> groupList = new ArrayList<>();
        if (groupCursor != null && groupCursor.moveToFirst()) {
            do {
                long groupCode = groupCursor.getLong(2);
                groupList.add(Long.valueOf(groupCode));
            } while (groupCursor.moveToNext());
            groupCursor.close();
        }
        if (groupCursor != null) {
            groupCursor.close();
        }
        if (groupList == null || groupList.isEmpty()) {
            return -1L;
        }
        Iterator<Long> it = groupList.iterator();
        while (it.hasNext()) {
            Long value = it.next();
            Cursor groupBuddyMapCursor = this.buddyDBAdaptor.selectGroupBuddyMapByGroupID(value.longValue());
            if (groupBuddyMapCursor != null && groupBuddyMapCursor.moveToFirst()) {
                groupBuddyMapCursor.close();
                return -1L;
            }
            Log.m2958e("BUDDY_TRACE Empty Group Delete!");
            if (groupBuddyMapCursor != null) {
                groupBuddyMapCursor.close();
            }
            deleteBuddyGroup(value.longValue(), handler);
        }
        return 1L;
    }

    @Override // com.coolots.chaton.buddy.BuddyManagerInterface
    public ArrayList<String> getGroupNameList() throws Throwable {
        Cursor cursor = this.buddyDBAdaptor.selectBuddyGroupAll();
        ArrayList<String> retList = null;
        if (cursor != null) {
            try {
                if (cursor.moveToFirst()) {
                    do {
                        try {
                            retList = new ArrayList<>();
                            retList.add(cursor.getString(1));
                        } catch (Throwable th) {
                            th = th;
                            if (cursor != null) {
                                cursor.close();
                            }
                            throw th;
                        }
                    } while (cursor.moveToNext());
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }
        if (cursor != null) {
            cursor.close();
        }
        return retList;
    }

    @Override // com.coolots.chaton.buddy.BuddyManagerInterface
    public String getNativeNameByUserNo(long userNO) {
        return this.buddyDBAdaptor.getNativeNameByUserNo(userNO);
    }

    @Override // com.coolots.chaton.buddy.BuddyManagerInterface
    public String getBuddyNameByUserNo(long userNO) {
        return this.buddyDBAdaptor.getBuddyNameByUserNo(userNO);
    }

    @Override // com.coolots.chaton.buddy.BuddyManagerInterface
    public String getBuddyNameByUserID(String userID) {
        return this.buddyDBAdaptor.getBuddyNameByUserID(userID);
    }

    @Override // com.coolots.chaton.buddy.BuddyManagerInterface
    public BuddyTable getBuddyInfoForCallLogDetail(String userID) {
        Cursor rawCursor = this.buddyDBAdaptor.selectBuddyByUserIDWithNoException(userID);
        if (rawCursor != null && rawCursor.moveToFirst()) {
            BuddyTable buddyTable = ValueObjectConverter.makeBuddyTableFromBuddyCursor(rawCursor);
            rawCursor.close();
            return buddyTable;
        }
        if (rawCursor != null) {
            rawCursor.close();
        }
        return null;
    }

    @Override // com.coolots.chaton.buddy.BuddyManagerInterface
    public long getGroupIDByUserIDList(ArrayList<String> userIDList) {
        Log.m2963i("getGroupIDByUserIDList()");
        ArrayList<Long> userNoList = new ArrayList<>();
        Iterator<String> it = userIDList.iterator();
        while (it.hasNext()) {
            String userID = it.next();
            long userNo = this.buddyDBAdaptor.getUserNoByUserID(userID);
            if (userNo != -1) {
                userNoList.add(Long.valueOf(userNo));
            }
        }
        int userCount = userNoList.size();
        if (userCount != userIDList.size()) {
            return -1L;
        }
        ArrayList<Long> groupCodeList = this.buddyDBAdaptor.getGroupIDListByMemberCount(userCount);
        ArrayList<Long> remainGroupCodeList = new ArrayList<>();
        if (groupCodeList != null && !groupCodeList.isEmpty()) {
            Iterator<Long> it2 = groupCodeList.iterator();
            while (it2.hasNext()) {
                long groupCode = it2.next().longValue();
                ArrayList<Long> memberNoList = this.buddyDBAdaptor.getMemberNoListByGroupID(groupCode);
                if (memberNoList != null && memberNoList.containsAll(userNoList)) {
                    remainGroupCodeList.add(Long.valueOf(groupCode));
                }
            }
            if (remainGroupCodeList != null && !remainGroupCodeList.isEmpty()) {
                ArrayList<String> groupNameList = new ArrayList<>();
                Iterator<Long> it3 = remainGroupCodeList.iterator();
                while (it3.hasNext()) {
                    groupNameList.add(this.buddyDBAdaptor.getBuddyGroupNameByGroupID(it3.next().longValue()));
                }
                Collections.sort(groupNameList);
                return this.buddyDBAdaptor.getBuddyGroupIDByGroupName(groupNameList.get(0));
            }
            return -1L;
        }
        return -1L;
    }

    @Override // com.coolots.chaton.buddy.BuddyManagerInterface
    public boolean isReachToGroupMaxInLocal() {
        Cursor rawCursor = this.buddyDBAdaptor.selectBuddyGroupAll();
        if (rawCursor != null && rawCursor.moveToFirst()) {
            int groupCount = rawCursor.getCount();
            rawCursor.close();
            return groupCount >= 100;
        }
        if (rawCursor == null) {
            return true;
        }
        rawCursor.close();
        return true;
    }

    @Override // com.coolots.chaton.buddy.BuddyManagerInterface
    public boolean isReachToFavoriteMaxInLocal() {
        Cursor rawcursor = this.buddyDBAdaptor.selectBuddyForFavoriteList();
        if (rawcursor != null && rawcursor.moveToFirst()) {
            int favoriteCount = rawcursor.getCount();
            rawcursor.close();
            return favoriteCount >= 100;
        }
        if (rawcursor == null) {
            return true;
        }
        rawcursor.close();
        return true;
    }

    public boolean isReachToGroupMemberMaxInLocal(long groupCode) {
        Cursor rawcursor = this.buddyDBAdaptor.selectGroupBuddyMapByGroupID(groupCode);
        if (rawcursor != null && rawcursor.moveToFirst()) {
            int groupMemberCount = rawcursor.getCount();
            rawcursor.close();
            return groupMemberCount >= 100;
        }
        if (rawcursor == null) {
            return true;
        }
        rawcursor.close();
        return true;
    }

    @Override // com.coolots.chaton.buddy.BuddyManagerInterface
    public String getDisplayNameByUserID(String userID) {
        return this.buddyDBAdaptor.getDisplayNameByUserID(userID);
    }

    @Override // com.coolots.chaton.buddy.BuddyManagerInterface
    public String getBuddyMessageByUserID(String userID) {
        return this.buddyDBAdaptor.getUserMessageByUserID(userID);
    }

    @Override // com.coolots.chaton.buddy.BuddyManagerInterface
    public boolean getBuddyPresenceByUserID(String userID) {
        return this.buddyDBAdaptor.getBuddyPresenceByUserID(userID);
    }

    public boolean getBuddyPresenceByUserNO(long userNO) {
        return this.buddyDBAdaptor.getBuddyPresenceByUserNO(userNO);
    }
}
