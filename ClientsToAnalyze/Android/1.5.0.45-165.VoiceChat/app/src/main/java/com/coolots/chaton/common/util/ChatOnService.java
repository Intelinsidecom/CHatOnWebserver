package com.coolots.chaton.common.util;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import com.coolots.chaton.buddy.model.BuddyListChildItem;
import com.sds.coolots.MainApplication;
import com.sds.coolots.common.util.Log;
import com.sec.chaton.clientapi.GraphAPI;
import com.sec.chaton.clientapi.MessageAPI;
import com.sec.chaton.clientapi.UtilityAPI;
import com.sec.chaton.clientapi.exception.IllegalArgumentClientAPIException;
import com.sec.chaton.clientapi.exception.NotActivatedClientAPIException;
import com.sec.chaton.clientapi.exception.NotAvailableClientAPIException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/* loaded from: classes.dex */
public class ChatOnService {
    public static final int CHATONSERVICE_CHAT_SERVICE_OK = 5;
    public static final int CHATONSERVICE_INSTALLED = 1;
    public static final int CHATONSERVICE_MEMBER = 4;
    public static final int CHATONSERVICE_NOT_INSTALLED = 2;
    public static final int CHATONSERVICE_NOT_MEMBER = 3;
    public static final int CHATONSERVICE_NULL_ARGUMENT = 6;
    private static ChatOnService chatonservice = null;
    private static Context mContext;
    private String mBuddyNumber = null;
    private String mBuddyName = null;
    private String mBuddyStateMsg = null;
    private HashMap<String, String> mKnownBuddyData = new HashMap<>();

    private void logE(String message) {
        Log.m2958e("[ChatOnService]" + message);
    }

    private void logI(String message) {
        Log.m2963i("[ChatOnService]" + message);
    }

    private ChatOnService() {
    }

    public static ChatOnService createService(Context context) {
        mContext = context;
        if (isAvailableService() != 1) {
            return null;
        }
        if (chatonservice == null) {
            chatonservice = new ChatOnService();
        }
        return chatonservice;
    }

    private static int isAvailableService() {
        return UtilityAPI.isChatONInstalled(mContext) ? 1 : 2;
    }

    private String removeFooter(String userID) {
        return ChatONStringConvert.getInstance().removeFooter(userID);
    }

    public int openChatService(ArrayList<String> selectedBuddyNumberList) {
        if (selectedBuddyNumberList != null && selectedBuddyNumberList.size() > 0) {
            if (selectedBuddyNumberList.size() == 0) {
                return 3;
            }
            MessageAPI.openChatRoom(mContext, (String[]) selectedBuddyNumberList.toArray(new String[0]));
            return 5;
        }
        return 6;
    }

    public int openChatService(String selectedBuddyNumber) {
        if (selectedBuddyNumber == null) {
            return 6;
        }
        ArrayList<String> selected_buddies_number = new ArrayList<>();
        selected_buddies_number.add(selectedBuddyNumber);
        MessageAPI.openChatRoom(mContext, (String[]) selected_buddies_number.toArray(new String[0]));
        return 5;
    }

    public int openChatService(BuddyListChildItem selectBuddy) {
        if (selectBuddy != null) {
            String selected_buddy_number = getChatOnBuddyNumber(selectBuddy);
            if (selected_buddy_number == null) {
                return 3;
            }
            ArrayList<String> selected_buddies_number = new ArrayList<>();
            selected_buddies_number.add(selected_buddy_number);
            MessageAPI.openChatRoom(mContext, (String[]) selected_buddies_number.toArray(new String[0]));
            return 5;
        }
        return 6;
    }

    public int isChatOnBuddy(BuddyListChildItem curBuddy) {
        if (isAvailableService() == 1) {
            String selected_buddy_number = getChatOnBuddyNumber(curBuddy);
            if (selected_buddy_number == null) {
                return 3;
            }
            return 4;
        }
        return 2;
    }

    public int isChatOnBuddy(String accountId) {
        if (isAvailableService() == 1) {
            logI("isChatOnBuddy 1 ");
            if (getBuddyHashMap(removeFooter(accountId)) != null) {
                logI("getBuddyHashMap find pop id = " + removeFooter(accountId));
                return 4;
            }
            String selected_buddy_name = getChatOnBuddyName(accountId);
            putBuddyHashMap(removeFooter(accountId), selected_buddy_name);
            return selected_buddy_name == null ? 3 : 4;
        }
        return 2;
    }

    private void putBuddyHashMap(String accountId, String Name) {
        logI("putBuddyHashMap start ");
        if (Name != null && accountId != null && this.mKnownBuddyData != null && getBuddyHashMap(accountId) == null) {
            logI("putBuddyHashMap push id = " + accountId);
            this.mKnownBuddyData.put(accountId, Name);
        }
        logI("putBuddyHashMap end ");
    }

    private String getBuddyHashMap(String accountId) {
        logI("getBuddyHashMap()");
        if (this.mKnownBuddyData == null || this.mKnownBuddyData.isEmpty() || accountId == null) {
            return null;
        }
        return this.mKnownBuddyData.get(accountId);
    }

    public void clearBuddyData() {
        if (this.mKnownBuddyData != null && !this.mKnownBuddyData.isEmpty()) {
            this.mKnownBuddyData.clear();
        }
    }

    public void setChatOnBuddyInfo(String userID) {
        logI("setChatOnBuddyInfo(" + userID + ")");
        Cursor c = null;
        try {
            try {
                Cursor c2 = GraphAPI.getBuddyList(mContext, "buddy_no=?", new String[]{removeFooter(userID)}, null);
                if (c2 == null || c2.getCount() <= 0) {
                    logI("cursor is null");
                    this.mBuddyNumber = "";
                    this.mBuddyName = "";
                    this.mBuddyStateMsg = "";
                } else {
                    c2.moveToNext();
                    int columnNo = c2.getColumnIndex(GraphAPI.BUDDY_NO);
                    int columnName = c2.getColumnIndex(GraphAPI.BUDDY_NAME);
                    int columnStatusMessage = c2.getColumnIndex(GraphAPI.BUDDY_STATUS_MESSAGE);
                    this.mBuddyNumber = c2.getString(columnNo);
                    this.mBuddyName = c2.getString(columnName);
                    this.mBuddyStateMsg = c2.getString(columnStatusMessage);
                }
                if (c2 != null) {
                    c2.close();
                }
            } catch (NotActivatedClientAPIException e) {
                e.printStackTrace();
                if (0 != 0) {
                    c.close();
                }
            } catch (NotAvailableClientAPIException e2) {
                e2.printStackTrace();
                if (0 != 0) {
                    c.close();
                }
            }
        } catch (Throwable th) {
            if (0 != 0) {
                c.close();
            }
            throw th;
        }
    }

    public void setChatOnBuddyInfo(long userNo) {
        logI("setChatOnBuddyInfo(userNo)");
        String userNumber = String.valueOf(userNo);
        try {
            Cursor c = GraphAPI.getBuddyList(MainApplication.mContext, "buddy_no=? AND buddy_name=?", new String[]{userNumber, "ChatON"}, "buddy_no DESC");
            if (c != null && c.getCount() > 0) {
                c.moveToNext();
                int columnNo = c.getColumnIndex(GraphAPI.BUDDY_NO);
                int columnName = c.getColumnIndex(GraphAPI.BUDDY_NAME);
                int columnStatusMessage = c.getColumnIndex(GraphAPI.BUDDY_STATUS_MESSAGE);
                this.mBuddyNumber = c.getString(columnNo);
                this.mBuddyName = c.getString(columnName);
                this.mBuddyStateMsg = c.getString(columnStatusMessage);
            }
            if (c != null) {
                c.close();
            }
        } catch (NotActivatedClientAPIException e) {
            e.printStackTrace();
        } catch (NotAvailableClientAPIException e2) {
            e2.printStackTrace();
        } catch (SecurityException e3) {
            e3.printStackTrace();
        }
    }

    public int openShareFileService(ArrayList<BuddyListChildItem> selectedMemberList) {
        return -1;
    }

    public String getChatOnBuddyNumber() {
        return this.mBuddyNumber;
    }

    public String getChatOnBuddyName() {
        return this.mBuddyName;
    }

    public String getChatOnBuddyStateMsg() {
        return this.mBuddyStateMsg;
    }

    public String getChatOnBuddyName(String userID) {
        Cursor c = null;
        String BuddyName = null;
        logI("getChatOnBuddyName userID = " + removeFooter(userID));
        try {
            try {
                c = GraphAPI.getBuddyList(mContext, "buddy_no=?", new String[]{removeFooter(userID)}, null);
                if (c == null || c.getCount() <= 0) {
                    logI("getChatOnBuddyName = null");
                    BuddyName = null;
                } else {
                    c.moveToNext();
                    int columnName = c.getColumnIndex(GraphAPI.BUDDY_NAME);
                    logI("getChatOnBuddyName = " + c.getString(columnName));
                    BuddyName = c.getString(columnName);
                }
            } catch (NotActivatedClientAPIException e) {
                e.printStackTrace();
                if (c != null) {
                    c.close();
                }
            } catch (NotAvailableClientAPIException e2) {
                e2.printStackTrace();
                if (c != null) {
                    c.close();
                }
            }
            return BuddyName;
        } finally {
            if (c != null) {
                c.close();
            }
        }
    }

    public ArrayList<String> getChatOnBuddyNumber(ArrayList<BuddyListChildItem> selectedMemberList) {
        ArrayList<String> NumberList = new ArrayList<>();
        Iterator<BuddyListChildItem> it = selectedMemberList.iterator();
        while (it.hasNext()) {
            BuddyListChildItem childitem = it.next();
            String numberstring = getChatOnBuddyNumber(childitem);
            if (numberstring != null) {
                NumberList.add(numberstring);
            }
        }
        return NumberList;
    }

    public ArrayList<String> getChatOnBuddyNumberAsIdList(ArrayList<String> BuddyIdList) {
        ArrayList<String> NumberList = new ArrayList<>();
        Iterator<String> it = BuddyIdList.iterator();
        while (it.hasNext()) {
            String childitem = it.next();
            String numberstring = getChatOnBuddyNumber(childitem);
            if (numberstring != null) {
                NumberList.add(numberstring);
            }
        }
        return NumberList;
    }

    public String getChatOnBuddyNumber(BuddyListChildItem selectedBuddy) {
        String accountID = selectedBuddy.getAccountID();
        String buddyNumber = null;
        logI("getChatOnBuddyNumber(selectedBuddy) accountID = " + accountID);
        Cursor c = null;
        try {
            try {
                c = GraphAPI.getBuddyList(mContext, "buddy_no=?", new String[]{removeFooter(accountID)}, null);
                if (c != null && c.getCount() > 0) {
                    c.moveToNext();
                    int columnNo = c.getColumnIndex(GraphAPI.BUDDY_NO);
                    buddyNumber = c.getString(columnNo);
                }
            } catch (NotActivatedClientAPIException e) {
                e.printStackTrace();
                if (c != null) {
                    c.close();
                }
            } catch (NotAvailableClientAPIException e2) {
                e2.printStackTrace();
                if (c != null) {
                    c.close();
                }
            }
            return buddyNumber;
        } finally {
            if (c != null) {
                c.close();
            }
        }
    }

    public ArrayList<String> getChatOnBuddyNumberListAsAccountID(ArrayList<String> AccountList) {
        ArrayList<String> buddyIDList = new ArrayList<>();
        Iterator<String> it = AccountList.iterator();
        while (it.hasNext()) {
            String AccountId = it.next();
            buddyIDList.add(getChatOnBuddyNumber(AccountId));
        }
        return buddyIDList;
    }

    public String getChatOnBuddyNumber(String accountID) {
        logI("getChatOnBuddyNumber(accountID) accountID = " + accountID);
        String buddyNumber = null;
        Cursor c = null;
        try {
            try {
                c = GraphAPI.getBuddyList(mContext, "buddy_no=?", new String[]{removeFooter(accountID)}, null);
                if (c != null && c.getCount() > 0) {
                    c.moveToNext();
                    int columnNo = c.getColumnIndex(GraphAPI.BUDDY_NO);
                    buddyNumber = c.getString(columnNo);
                }
            } catch (NotActivatedClientAPIException e) {
                e.printStackTrace();
                if (c != null) {
                    c.close();
                }
            } catch (NotAvailableClientAPIException e2) {
                e2.printStackTrace();
                if (c != null) {
                    c.close();
                }
            }
            return buddyNumber;
        } finally {
            if (c != null) {
                c.close();
            }
        }
    }

    public ArrayList<BuddyListChildItem> getChatOnBuddyMember(ArrayList<BuddyListChildItem> selectedMemberList) {
        ArrayList<BuddyListChildItem> MemberList = new ArrayList<>();
        Iterator<BuddyListChildItem> it = selectedMemberList.iterator();
        while (it.hasNext()) {
            BuddyListChildItem childitem = it.next();
            BuddyListChildItem childItem = getChatOnBuddyMember(childitem);
            if (childItem != null) {
                MemberList.add(childitem);
            }
        }
        return MemberList;
    }

    public BuddyListChildItem getChatOnBuddyMember(BuddyListChildItem selectedBuddy) {
        String accountID = selectedBuddy.getAccountID();
        BuddyListChildItem buddyItem = null;
        logI("getChatOnBuddyMember(selectedBuddy) accountID = " + removeFooter(accountID));
        Cursor c = null;
        try {
            try {
                try {
                    c = GraphAPI.getBuddyList(mContext, "buddy_no=?", new String[]{removeFooter(accountID)}, null);
                    if (c != null) {
                        if (c.getCount() > 0) {
                            buddyItem = selectedBuddy;
                        }
                    }
                } catch (NotAvailableClientAPIException e) {
                    e.printStackTrace();
                    if (c != null) {
                        c.close();
                    }
                }
            } catch (NotActivatedClientAPIException e2) {
                e2.printStackTrace();
                if (c != null) {
                    c.close();
                }
            }
            return buddyItem;
        } finally {
            if (c != null) {
                c.close();
            }
        }
    }

    public ArrayList<BuddyListChildItem> getBuddyItemAsBuddyNoList(ArrayList<String> buudyNoList) {
        if (buudyNoList == null || buudyNoList.isEmpty()) {
            return null;
        }
        ArrayList<BuddyListChildItem> buddyListChildItem = new ArrayList<>();
        Iterator<String> it = buudyNoList.iterator();
        while (it.hasNext()) {
            String buddyNo = it.next();
            BuddyListChildItem buddyItem = getBuddyItemAsBuddyNo(buddyNo);
            buddyListChildItem.add(buddyItem);
        }
        if (buddyListChildItem == null || buddyListChildItem.isEmpty()) {
            return null;
        }
        return buddyListChildItem;
    }

    public BuddyListChildItem getBuddyItemAsBuddyNo(String buddyNo) {
        BuddyListChildItem buddylistchildItem;
        logI("ChatOnService getBuddyItemAsBuddyNo -start-");
        Cursor c = null;
        try {
            try {
                c = GraphAPI.getBuddyList(mContext, "buddy_no=?", new String[]{buddyNo}, null);
                if (c == null || c.getCount() <= 0) {
                    buddylistchildItem = null;
                } else {
                    logI("ChatOnService getBuddyItemAsBuddyNo c.getCount() " + c.getCount());
                    c.moveToNext();
                    int columnNo = c.getColumnIndex(GraphAPI.BUDDY_NO);
                    int columnName = c.getColumnIndex(GraphAPI.BUDDY_NAME);
                    int columnMsg = c.getColumnIndex(GraphAPI.BUDDY_STATUS_MESSAGE);
                    logI("ChatOnService getBuddyItemAsBuddyNo No = " + c.getString(columnNo));
                    logI("ChatOnService getBuddyItemAsBuddyNo Name = " + c.getString(columnName));
                    logI("ChatOnService getBuddyItemAsBuddyNo Msg = " + c.getString(columnMsg));
                    buddylistchildItem = new BuddyListChildItem(ChatONStringConvert.getInstance().toUserID(buddyNo), c.getString(columnName), -1L, c.getString(columnMsg), false, false, false);
                }
                if (c == null) {
                    return buddylistchildItem;
                }
                c.close();
                return buddylistchildItem;
            } catch (NotActivatedClientAPIException e) {
                e.printStackTrace();
                if (c != null) {
                    c.close();
                    return null;
                }
                return null;
            } catch (NotAvailableClientAPIException e2) {
                e2.printStackTrace();
                if (c != null) {
                    c.close();
                    return null;
                }
                return null;
            }
        } catch (Throwable th) {
            if (c != null) {
                c.close();
            }
            throw th;
        }
    }

    public void viewBuddyProfile(String BuddyID) {
        try {
            Intent intent = GraphAPI.viewBuddyProfile(mContext, removeFooter(BuddyID));
            if (intent == null) {
                logE("intent is null");
            } else {
                mContext.startActivity(intent);
            }
        } catch (ActivityNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalArgumentClientAPIException e2) {
            e2.printStackTrace();
        } catch (NotActivatedClientAPIException e3) {
            e3.printStackTrace();
        } catch (NotAvailableClientAPIException e4) {
            e4.printStackTrace();
        }
    }

    public int getBackgroundThema() {
        Cursor oCursor = null;
        try {
            oCursor = UtilityAPI.getSettingInfo(mContext);
        } catch (NotActivatedClientAPIException e) {
            e.printStackTrace();
        } catch (NotAvailableClientAPIException e2) {
            e2.printStackTrace();
        }
        if (oCursor == null) {
            return 0;
        }
        oCursor.moveToFirst();
        int thema = oCursor.getInt(oCursor.getColumnIndex(UtilityAPI.URI_SETTING_INFO_COLUMN_THEME));
        oCursor.close();
        return thema;
    }
}
