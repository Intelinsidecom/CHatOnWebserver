package com.coolots.chaton.calllog.util;

import com.coolots.chaton.buddy.BuddyManagerInterface;
import com.coolots.chaton.calllog.model.CallLogData;
import com.coolots.chaton.common.controller.ChatOnResourceInterface;
import com.coolots.chaton.common.controller.VAppPhoneManager;
import com.coolots.sso.util.ChatONVAPII;
import com.sds.coolots.MainApplication;
import com.sds.coolots.common.util.Log;
import com.sec.spp.push.Config;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* loaded from: classes.dex */
public final class CallLogStringUtil {
    private static final String CLASSNAME = "[CallLogStringUtil]";
    private static CallLogStringUtil instance = new CallLogStringUtil();
    private final BuddyManagerInterface mBuddyManager = ((VAppPhoneManager) MainApplication.mPhoneManager).getChatOnContactManager();

    private static void logI(String message) {
        Log.m2963i(CLASSNAME + message);
    }

    private CallLogStringUtil() {
        Log.m2963i("[CallLogStringUtil] new Instance");
    }

    public static CallLogStringUtil getInstance() {
        return instance;
    }

    public String getCallDateString(String input, String fmt) {
        if (fmt == null || "".equals(fmt)) {
            return "";
        }
        try {
            Date date = stringToDate(input, "yyyyMMddHHmmss");
            return dateToString(date, fmt);
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public long getDaysBetweenCallDateAndToday(String calldate) {
        try {
            Date callDate = stringToDate(calldate, "yyyyMMddHHmmss");
            Date todayDate = new Date();
            return daysBetween(callDate, todayDate);
        } catch (Exception e) {
            e.printStackTrace();
            return -1L;
        }
    }

    public Date stringToDate(String dateString, String fmt) throws Exception {
        return new SimpleDateFormat(fmt, MainApplication.mContext.getResources().getConfiguration().locale).parse(dateString);
    }

    public String dateToString(Date date, String fmt) throws Exception {
        return new SimpleDateFormat(fmt, MainApplication.mContext.getResources().getConfiguration().locale).format(date);
    }

    private long daysBetween(Date firstDate, Date secondDate) {
        long difference;
        long firstSeconds = truncateToDate(firstDate).getTime() / 1000;
        long secondSeconds = truncateToDate(secondDate).getTime() / 1000;
        long difference2 = secondSeconds - firstSeconds;
        if (difference2 >= 0) {
            difference = difference2 + 43200;
        } else {
            difference = difference2 - 43200;
        }
        return difference / 86400;
    }

    private Date truncateToDate(Date date) {
        if (!(date instanceof java.sql.Date)) {
            Date date2 = (Date) date.clone();
            date2.setHours(0);
            date2.setMinutes(0);
            date2.setSeconds(0);
            date2.setTime((date2.getTime() / 1000) * 1000);
            return date2;
        }
        return date;
    }

    public String getCallInfoMsgForDisplay(int callType) {
        switch (callType) {
            case 1:
                int msgNo = ((ChatOnResourceInterface) MainApplication.mResources).getCallTypeCancelled();
                String msg = MainApplication.mContext.getString(msgNo);
                return msg;
            case 2:
                int msgNo2 = ((ChatOnResourceInterface) MainApplication.mResources).getCallTypeMissed();
                String msg2 = MainApplication.mContext.getString(msgNo2);
                return msg2;
            case 3:
            case 4:
                int msgNo3 = ((ChatOnResourceInterface) MainApplication.mResources).getCallTypeRejected();
                String msg3 = MainApplication.mContext.getString(msgNo3);
                return msg3;
            default:
                return "";
        }
    }

    public String getDurationForDisplay(int duration) {
        String minute;
        String hour = "00";
        int min = duration / 60;
        if (min >= 60) {
            hour = Integer.toString(min / 60);
            minute = Integer.toString(min % 60);
        } else {
            minute = Integer.toString(min);
        }
        String second = Integer.toString(duration % 60);
        String strduration = String.valueOf(checkLength(hour)) + ChatONVAPII.USERID_DELEMETER + checkLength(minute) + ChatONVAPII.USERID_DELEMETER + checkLength(second);
        return strduration;
    }

    private String checkLength(String num) {
        if (num.length() == 1) {
            return "0" + num;
        }
        return num;
    }

    public boolean isSameDate(String callDate1, String callDate2) {
        try {
            Date _callDate1 = stringToDate(callDate1, "yyyyMMddHHmmss");
            Date _callDate2 = stringToDate(callDate2, "yyyyMMddHHmmss");
            if (_callDate1.getYear() == _callDate2.getYear() && _callDate1.getMonth() == _callDate2.getMonth()) {
                if (_callDate1.getDate() == _callDate2.getDate()) {
                    return true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean isToday(String callDate1) {
        Date _callDate2 = new Date();
        try {
            Date _callDate1 = stringToDate(callDate1, "yyyyMMddHHmmss");
            if (_callDate1.getYear() == _callDate2.getYear() && _callDate1.getMonth() == _callDate2.getMonth()) {
                if (_callDate1.getDate() == _callDate2.getDate()) {
                    return true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public String getAllUserDisplayName(CallLogData callLog) {
        String name = null;
        String userIDs = "";
        for (CallLogData.UserInfo userInfo : callLog.userInfo) {
            if (!userIDs.contains(userInfo.userID)) {
                userIDs = String.valueOf(userIDs) + userInfo.userID + Config.KEYVALUE_SPLIT;
                int buddyKind = ((VAppPhoneManager) MainApplication.mPhoneManager).getChatOnContactManager().getKindOfBuddy(userInfo.userID);
                if (buddyKind == 2) {
                    name = (name == null || name.isEmpty()) ? ((VAppPhoneManager) MainApplication.mPhoneManager).getChatOnContactManager().getBuddyNameByUserID(userInfo.userID) : String.valueOf(name) + ", " + ((VAppPhoneManager) MainApplication.mPhoneManager).getChatOnContactManager().getBuddyNameByUserID(userInfo.userID);
                } else if (userInfo.userDisplayName == null || userInfo.userDisplayName.isEmpty()) {
                    name = (name == null || name.isEmpty()) ? userInfo.userDefaultName : String.valueOf(name) + ", " + userInfo.userDefaultName;
                } else {
                    name = (name == null || name.isEmpty()) ? userInfo.userDisplayName : String.valueOf(name) + ", " + userInfo.userDisplayName;
                }
            }
        }
        return name;
    }

    public ArrayList<String> getAllUserDisplayNames(CallLogData callLog) {
        ArrayList<String> names = new ArrayList<>();
        names.clear();
        String userIDs = "";
        for (CallLogData.UserInfo userInfo : callLog.userInfo) {
            if (!userIDs.contains(userInfo.userID)) {
                userIDs = String.valueOf(userIDs) + userInfo.userID + Config.KEYVALUE_SPLIT;
                if (userInfo.userDisplayName == null || userInfo.userDisplayName.isEmpty()) {
                    names.add(userInfo.userDefaultName);
                } else {
                    names.add(userInfo.userDisplayName);
                }
            }
        }
        return names;
    }

    public String getSingleCallUserMessage(String userID, String defaultMsg) {
        String name;
        if (!MainApplication.mPhoneManager.IsLinkagewithChatON()) {
            long userNo = this.mBuddyManager.getUserNoByUserID(userID);
            if (userNo <= 0) {
                return defaultMsg;
            }
        }
        if (this.mBuddyManager.isFriend(userID)) {
            name = this.mBuddyManager.getUserMessageByUserID(userID);
            if (name == null || name.isEmpty()) {
                name = "";
            }
        } else {
            name = defaultMsg;
        }
        return name;
    }

    public String getGroupNameByPriority(CallLogData callLog, HashMap<Set<Long>, String> groupInfo, List<CallLogData.UserInfo> userInfo) {
        if (callLog.groupid == 0) {
            Set<Long> userNos = new HashSet<>();
            for (CallLogData.UserInfo user : userInfo) {
                userNos.add(Long.valueOf(this.mBuddyManager.getUserNoByUserID(user.userID)));
            }
            if (!groupInfo.containsKey(userNos)) {
                return null;
            }
            String groupName = groupInfo.get(userNos);
            return groupName;
        }
        String groupName2 = this.mBuddyManager.getGroupNameByGroupID(callLog.groupid);
        return groupName2;
    }
}
