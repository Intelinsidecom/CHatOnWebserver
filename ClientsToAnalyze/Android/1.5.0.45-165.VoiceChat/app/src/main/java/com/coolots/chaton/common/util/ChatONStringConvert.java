package com.coolots.chaton.common.util;

import com.sds.coolots.MainApplication;
import com.sds.coolots.common.util.Log;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

/* loaded from: classes.dex */
public final class ChatONStringConvert {
    public static final String CHATON_FOOTER = "@chaton";
    private static final String CLASSNAME = "[ChatONStringConvert]";
    public static final int MSISDN_DEFAULT_LENGTH = 10;
    public static final String VAPP_FOOTER = "@v";
    private static ChatONStringConvert instance = new ChatONStringConvert();

    private static void logI(String message) {
        Log.m2963i(CLASSNAME + message);
    }

    private ChatONStringConvert() {
        Log.m2963i("[ChatONStringConvert] new Instance");
    }

    public static ChatONStringConvert getInstance() {
        return instance;
    }

    public String removeFooter(String userID) {
        int index;
        if (userID == null || userID.isEmpty()) {
            return "";
        }
        if (MainApplication.mPhoneManager.IsLinkagewithChatON()) {
            index = userID.indexOf("@chaton");
        } else {
            index = userID.indexOf("@v");
        }
        return index >= 0 ? userID.substring(0, index) : userID;
    }

    public String removeAfterAt(String userID) {
        if (userID == null || userID.isEmpty()) {
            return "";
        }
        int index = userID.indexOf(64);
        return index >= 0 ? userID.substring(0, index) : userID;
    }

    public String toUserID(String samsungAccount) {
        if (samsungAccount == null || samsungAccount.isEmpty()) {
            return "";
        }
        if (!MainApplication.mPhoneManager.IsLinkagewithChatON()) {
            return samsungAccount.indexOf("@v") < 0 ? String.valueOf(samsungAccount) + "@v" : samsungAccount;
        }
        if (samsungAccount.indexOf("@chaton") < 0) {
            return String.valueOf(samsungAccount) + "@chaton";
        }
        return samsungAccount;
    }

    public String deleteFooter(String userID) {
        if (userID == null || userID.isEmpty()) {
            return "";
        }
        if (MainApplication.mPhoneManager.IsLinkagewithChatON()) {
            return userID.replaceAll("@chaton", "");
        }
        return userID.replaceAll("@v", "");
    }

    public long convertCallDateSeconds(String calldate) {
        try {
            Date date = new SimpleDateFormat("yyyyMMddHHmmss", MainApplication.mContext.getResources().getConfiguration().locale).parse(calldate);
            return date.getTime();
        } catch (Exception e) {
            e.printStackTrace();
            return 0L;
        }
    }

    public long convertGMT2LocalTime(long gmtTime) {
        logI("convertGMT2LocalTime()");
        Calendar calendar = Calendar.getInstance(Locale.getDefault());
        long currentTimeSeconds = calendar.getTimeInMillis() / 1000;
        int refrenceOffset = TimeZone.getDefault().getOffset(currentTimeSeconds);
        logI("GMT time: " + gmtTime + " difference: " + refrenceOffset);
        long time = gmtTime + refrenceOffset;
        logI("Local time: " + time);
        return time;
    }

    public long convertGMT2LocalTime(String calldate) {
        logI("convertGMT2LocalTime()");
        long time = convertCallDateSeconds(calldate);
        Calendar calendar = Calendar.getInstance(Locale.getDefault());
        long currentTimeSeconds = calendar.getTimeInMillis() / 1000;
        int refrenceOffset = TimeZone.getDefault().getOffset(currentTimeSeconds);
        logI("GMT time: " + time + " difference: " + refrenceOffset);
        long time2 = time + refrenceOffset;
        logI("Local time: " + time2);
        return time2;
    }

    public long convertLocalTime2GMT(long localTime) {
        logI("convertLocalTime2GMT()");
        Calendar calendar = Calendar.getInstance(Locale.getDefault());
        long currentTimeSeconds = calendar.getTimeInMillis() / 1000;
        int refrenceOffset = TimeZone.getDefault().getOffset(currentTimeSeconds);
        logI("Local time: " + localTime + " difference: " + refrenceOffset);
        long time = localTime - refrenceOffset;
        logI("GMT time: " + time);
        return time;
    }

    public String convertMSISDNfromPhoneNo(String phoneNo) {
        logI("convertMSISDNfromPhoneNo()");
        if (phoneNo == null || phoneNo.length() < 10) {
            return null;
        }
        if (phoneNo.length() == 10 || phoneNo.length() == 11) {
            StringBuilder MSISDN = new StringBuilder();
            if (MainApplication.mConfig.getProfileCountryCode().intValue() == 82) {
                MSISDN.append(82);
                if (phoneNo.charAt(0) == '0') {
                    MSISDN.append(phoneNo.substring(1));
                } else {
                    MSISDN.append(phoneNo);
                }
                return MSISDN.toString();
            }
            return String.valueOf(MainApplication.mConfig.getProfileCountryCode().toString()) + phoneNo;
        }
        return phoneNo;
    }
}
