package com.coolots.sso.util;

import android.content.BroadcastReceiver;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.util.Log;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class ChatONVAPII {
    private static final String ABOUT_CHATONV_ACTION = "com.coolots.chaton.USER_SETTING_SUBPAGE_ABOUNT_CHATON_CALL";
    private static final String ACCESS_PERMISSION = "com.coolots.permission.COOLOTS";
    private static final String ACCOUNT_AVAILABLE_URI_STR = "content://com.coolots.chaton/account";
    private static final String BR_ACCOUNT_RESULT_INFO = "com.coolots.chaton.account.ACCOUNT_RESULTINFO";
    private static final String BR_CALL_STATE_CHANGE_INFO = "com.coolots.chaton.account.CALL_STATE_CHANGE_INFO";
    private static final String BR_CONFERENCE_MEMBER_CHANGED = "com.coolots.chaton.version.CONFERENCE_MEMBER_CHANGED";
    private static final String BR_REMOVE_ACCOUNT_RESULT_INFO = "com.coolots.chaton.account.REMOVE_ACCOUNT_RESULTINFO";
    public static final String BR_UPGRADE_NEW_APK_INFO = "com.coolots.chaton.version.UPGRADE_NEW_APK_INFO";
    private static final String CALLLOG_ACTION = "com.coolots.chaton.CallLog.Update";
    private static final String CALL_DURATION_URI_STR = "content://com.coolots.chaton/callduration";
    private static final String CALL_SETTING_ACTION = "com.coolots.chaton.USER_SETTING_SUBPAGE_CALL_SETTINGS";
    private static final String CALL_STATE_URI_STR = "content://com.coolots.chaton/callstate";
    public static final int CALL_TYPE_NONE = 0;
    public static final int CALL_TYPE_VIDEO = 1;
    public static final int CALL_TYPE_VOICE = 2;
    private static final int CHECK_KEY_INVALID_ACCESS = 1;
    private static final int CHECK_KEY_NOT_SUPPORTED_FUNCTION = 2;
    private static final int CHECK_KEY_NO_ACCOUNT = 3;
    private static final int CHECK_KEY_SUCCESS = 0;
    private static final String CONFERENCECALL_AVAILABLE_URI_STR = "content://com.coolots.chaton/outgoingconferencecall";
    private static final String CONFERENCECALL_MAX_MEMBER_URI_STR = "content://com.coolots.chaton/maxconferencecallnum";
    private static final String CREATE_ACCOUNT_AVAILABLE_URI_STR = "content://com.coolots.chaton/create_account";
    private static final String DATA_USAGE_ACTION = "com.coolots.chaton.USER_SETTING_SUBPAGE_DATA_USGAE";
    public static final String EXTRAS_KEY_ACCOUNT_FAIL_MSG = "account_fail_string";
    public static final String EXTRAS_KEY_CURRENT_VERSION_NAME = "current_version_name";
    private static final String EXTRAS_KEY_RESULT = "result";
    public static final String EXTRAS_KEY_VERSION_INFO = "version_info";
    public static final String EXTRAS_KEY_VERSION_NAME = "version_name";
    private static final String GET_CALL_MEMBER_URI_STR = "content://com.coolots.chaton/get_call_member";
    private static final String GET_CALL_TYPE_URI_STR = "content://com.coolots.chaton/get_call_type";
    private static final String GET_LATEST_VERSION_URI_STR = "content://com.coolots.chaton/get_latest_version";
    private static final String IS_CALLING_URI_STR = "content://com.coolots.chaton/iscalling";
    private static final String KEY_INIT_URI_STR = "content://com.coolots.chaton/key_init";
    private static final String KEY_URI_STR = "content://com.coolots.chaton/key";
    private static final String P2PCALL_AVAILABLE_URI_STR = "content://com.coolots.chaton/outgoingcall";
    private static final String QUICKPANNEL_END_CALL = "1";
    private static final String QUICKPANNEL_SHOW_CALL = "0";
    private static final String REMOTE_CALL_ACTIVITY_URI_STR = "content://com.coolots.chaton/remotecallactivity";
    private static final String REMOVE_ACCOUNT_AVAILABLE_URI_STR = "content://com.coolots.chaton/remove_account";
    public static final int RET_CHATONV_BIRTHDAY_EMPTY = 12;
    public static final int RET_CHATONV_CALLER_NAME_EMPTY = 8;
    public static final int RET_CHATONV_CHATON_NUMBER_EMPTY = 9;
    public static final int RET_CHATONV_CHATON_UID_EMPTY = 10;
    public static final int RET_CHATONV_FAIL = 1;
    public static final int RET_CHATONV_GUID_EMPTY = 7;
    public static final int RET_CHATONV_ID_EMPTY = 3;
    public static final int RET_CHATONV_IMEI_EMPTY = 11;
    public static final int RET_CHATONV_NATIONAL_CODE_EMPTY = 6;
    public static final int RET_CHATONV_NOT_ALLOWED_ACCESS = 5;
    public static final int RET_CHATONV_NOT_INSTALLED = 2;
    public static final int RET_CHATONV_NOT_SUPPORTED_FUNCTION = 13;
    public static final int RET_CHATONV_NO_ACCOUNT = 14;
    public static final int RET_CHATONV_SUCCESS = 0;
    public static final int RET_CHATONV_UNEXPECTED_ERROR = 4;
    private static final String SET_LOG_DISPLAY_URI_STR = "content://com.coolots.chaton/set_log_display";
    public static final int STATE_CALLING = 1;
    public static final int STATE_CHANGE_TO_CONFERENCE_CONNECTED = 100;
    public static final int STATE_CHANGE_TO_CONFERENCE_DISCONNECTED = 102;
    public static final int STATE_CHANGE_TO_P2P_CONNECTED = 101;
    public static final int STATE_CHANGE_TO_P2P_DISCONNECTED = 103;
    public static final int STATE_CONNECTED = 2;
    public static final int STATE_DISCONNECTED = 3;
    public static final int STATE_INIT = 0;
    private static final String TAG = "ChatONVAPII(1.0.0.3)";
    public static final String USERID_DELEMETER = ":";
    private static boolean mIsLogDisplay = false;
    private ChatONVAPIIReceiver mReceiver = null;
    private IChatONVAPII mListener = null;
    private ChatONVAPIICallReceiver mCallReceiver = null;
    private ICallChatONVAPII mCallListener = null;
    private ChatONVAPIIUpdateReceiver mUpdateReceiver = null;
    private IUpdateChatONVAPII mUpdateListener = null;

    /* JADX INFO: Access modifiers changed from: private */
    public static void logI(String msg) {
        if (mIsLogDisplay) {
            Log.i(TAG, msg);
        }
    }

    private static void logE(String msg) {
        if (mIsLogDisplay) {
            Log.e(TAG, msg);
        }
    }

    public ChatONVAPII() {
        logI("ChatONVAPII create() " + toString());
    }

    public static void setDisplayLog(Context context, boolean isDisplay) {
        mIsLogDisplay = isDisplay;
        logI("setDisplayLog: " + isDisplay);
        if (!isInstalled(context)) {
            logE("ChatON V is not installed");
            return;
        }
        int accessCheck = checkKey(context, SET_LOG_DISPLAY_URI_STR);
        if (accessCheck == 1) {
            logE("not allowed access");
        } else {
            if (accessCheck == 2) {
                logE("not supported function");
                return;
            }
            ContentValues cValues = new ContentValues();
            ContentResolver cr = context.getContentResolver();
            cr.update(Uri.parse(SET_LOG_DISPLAY_URI_STR), cValues, isDisplay ? "1" : "0", null);
        }
    }

    public static boolean isDisplayLog() {
        return mIsLogDisplay;
    }

    public void setAccountListener(Context context, IChatONVAPII listener) {
        ChatONVAPIIReceiver chatONVAPIIReceiver = null;
        if (listener == null) {
            logI("setListener: clear " + toString());
            clearAccountListener(context);
            return;
        }
        clearAccountListener(context);
        this.mListener = listener;
        this.mReceiver = new ChatONVAPIIReceiver(this, chatONVAPIIReceiver);
        logI("setListener: set :" + toString());
        logI("setListener: mListener :" + this.mListener.toString());
        logI("setListener: mReceiver :" + this.mReceiver.toString());
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.coolots.chaton.account.ACCOUNT_RESULTINFO");
        intentFilter.addAction("com.coolots.chaton.account.REMOVE_ACCOUNT_RESULTINFO");
        context.registerReceiver(this.mReceiver, intentFilter, "com.coolots.permission.COOLOTS", null);
    }

    private void clearAccountListener(Context context) {
        if (this.mListener != null) {
            logI("clearAccountListener: mListener :" + this.mListener.toString() + " => removed");
            this.mListener = null;
        }
        if (this.mReceiver != null) {
            logI("clearAccountListener: mReceiver :" + this.mReceiver.toString() + " => removed");
            try {
                context.unregisterReceiver(this.mReceiver);
            } catch (IllegalArgumentException e) {
                logE("IllegalArgumentException \n e");
            } finally {
                this.mReceiver = null;
            }
        }
    }

    public void setCallListener(Context context, ICallChatONVAPII listener) {
        ChatONVAPIICallReceiver chatONVAPIICallReceiver = null;
        if (listener == null) {
            logI("setCallListener: clear " + toString());
            clearCallListener(context);
            return;
        }
        clearCallListener(context);
        this.mCallListener = listener;
        this.mCallReceiver = new ChatONVAPIICallReceiver(this, chatONVAPIICallReceiver);
        logI("setCallListener: set " + toString());
        logI("setCallListener: mCallListener " + this.mCallListener.toString());
        logI("setCallListener: mCallReceiver " + this.mCallReceiver.toString());
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.coolots.chaton.version.CONFERENCE_MEMBER_CHANGED");
        intentFilter.addAction("com.coolots.chaton.account.CALL_STATE_CHANGE_INFO");
        context.registerReceiver(this.mCallReceiver, intentFilter, "com.coolots.permission.COOLOTS", null);
    }

    private void clearCallListener(Context context) {
        if (this.mCallListener != null) {
            logI("clearCallListener: mCallListener :" + this.mCallListener.toString() + " => removed");
            this.mCallListener = null;
        }
        if (this.mCallReceiver != null) {
            logI("clearCallListener: mCallReceiver :" + this.mCallReceiver.toString() + " => removed");
            try {
                context.unregisterReceiver(this.mCallReceiver);
            } catch (IllegalArgumentException e) {
                logE("IllegalArgumentException \n e");
            } finally {
                this.mCallReceiver = null;
            }
        }
    }

    public void setUpdateListener(Context context, IUpdateChatONVAPII listener) {
        ChatONVAPIIUpdateReceiver chatONVAPIIUpdateReceiver = null;
        if (listener == null) {
            logI("setUpdateListener: clear " + toString());
            clearUpdateListener(context);
            return;
        }
        clearUpdateListener(context);
        this.mUpdateListener = listener;
        this.mUpdateReceiver = new ChatONVAPIIUpdateReceiver(this, chatONVAPIIUpdateReceiver);
        logI("setUpdateListener: set " + toString());
        logI("setUpdateListener: mUpdateListener " + this.mUpdateListener.toString());
        logI("setUpdateListener: mUpdateReceiver " + this.mUpdateReceiver.toString());
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.coolots.chaton.version.UPGRADE_NEW_APK_INFO");
        context.registerReceiver(this.mUpdateReceiver, intentFilter, "com.coolots.permission.COOLOTS", null);
    }

    private void clearUpdateListener(Context context) {
        if (this.mUpdateListener != null) {
            logI("clearUpdateListener: mUpdateListener :" + this.mUpdateListener.toString() + " => removed");
            this.mUpdateListener = null;
        }
        if (this.mUpdateReceiver != null) {
            logI("clearUpdateListener: mUpdateReceiver :" + this.mUpdateReceiver.toString() + " => removed");
            try {
                context.unregisterReceiver(this.mUpdateReceiver);
            } catch (IllegalArgumentException e) {
                logE("IllegalArgumentException \n e");
            } finally {
                this.mUpdateReceiver = null;
            }
        }
    }

    public void dispose(Context context) {
        logI("dispose()");
        clearAccountListener(context);
        clearCallListener(context);
        clearUpdateListener(context);
    }

    public static boolean isInstalled(Context context) {
        return isInstalled(context, "com.coolots.chaton") || isInstalled(context, "com.coolots.chatonforcanada");
    }

    public static boolean isInstalled(Context context, String packageName) throws PackageManager.NameNotFoundException {
        PackageManager pm = context.getPackageManager();
        try {
            pm.getApplicationInfo(packageName, 128);
            logI(String.valueOf(packageName) + "isInstalled() true");
            return true;
        } catch (PackageManager.NameNotFoundException e) {
            logI(String.valueOf(packageName) + "isInstalled() false");
            return false;
        }
    }

    public int createAccount(Context context, String chatonID, String samsungAccount, String nationalCode, String GUID, String callerName, String IMEI, String chatONUID, String birthday) {
        logI("createAccount() call start");
        if (!isInstalled(context)) {
            logE("ChatON V is not installed");
            return 2;
        }
        int accessCheck = checkKey(context, CREATE_ACCOUNT_AVAILABLE_URI_STR);
        if (accessCheck == 1) {
            logE("not allowed access");
            return 5;
        }
        if (accessCheck == 2) {
            logE("not supported function");
            return 13;
        }
        if (accessCheck == 3) {
            logI("no account");
        }
        if (samsungAccount == null || samsungAccount.isEmpty()) {
            logI("samsungAccount is empty");
            return 3;
        }
        if (nationalCode == null || nationalCode.isEmpty()) {
            logI("nationalCode is empty");
            return 6;
        }
        if (GUID == null || GUID.isEmpty()) {
            logI("GUID is empty");
            return 7;
        }
        if (callerName == null || callerName.isEmpty()) {
            logI("callerName is empty");
            return 8;
        }
        if (chatonID == null || chatonID.isEmpty()) {
            logI("chatonID is empty");
            return 9;
        }
        if (IMEI == null || IMEI.isEmpty()) {
            logI("IMEI is empty");
            return 11;
        }
        if (chatONUID == null || chatONUID.isEmpty()) {
            logI("chatONUID is empty");
            return 10;
        }
        if (birthday == null || birthday.isEmpty()) {
            logI("birthday is empty");
        }
        String[] selectionArgs = {String.valueOf(samsungAccount), String.valueOf(nationalCode), String.valueOf(callerName), String.valueOf(GUID), String.valueOf(chatonID), String.valueOf(IMEI), String.valueOf(chatONUID), String.valueOf(birthday)};
        ContentResolver cr = context.getContentResolver();
        Cursor c = cr.query(Uri.parse(CREATE_ACCOUNT_AVAILABLE_URI_STR), null, null, selectionArgs, null);
        if (c != null) {
            c.close();
        }
        return 0;
    }

    public int removeAccountInDevice(Context context) {
        logI("removeAccountInDevice() call start");
        if (!isInstalled(context)) {
            logE("ChatON V is not installed");
            return 2;
        }
        int accessCheck = checkKey(context, REMOVE_ACCOUNT_AVAILABLE_URI_STR);
        if (accessCheck == 1) {
            logE("not allowed access");
            return 5;
        }
        if (accessCheck == 2) {
            logE("not supported function");
            return 13;
        }
        ContentResolver cr = context.getContentResolver();
        Cursor c = cr.query(Uri.parse(REMOVE_ACCOUNT_AVAILABLE_URI_STR), null, null, null, null);
        if (c != null) {
            c.close();
        }
        return 0;
    }

    public boolean isReadyToCall(Context context) {
        logI("isReadyToCall() call start");
        if (!isInstalled(context)) {
            logE("ChatON V is not installed");
            return false;
        }
        int accessCheck = checkKey(context, ACCOUNT_AVAILABLE_URI_STR);
        if (accessCheck == 1) {
            logE("not allowed access");
            return false;
        }
        if (accessCheck == 2) {
            logE("not supported function");
            return false;
        }
        if (accessCheck != 3) {
            return true;
        }
        logE("no account");
        return false;
    }

    public int getMaxConferenceMemberCnt(Context context, boolean isVideo) {
        logI("getMaxConferenceMemberCnt()");
        if (!isInstalled(context)) {
            logE("ChatON V is not installed");
            return 0;
        }
        int accessCheck = checkKey(context, CONFERENCECALL_MAX_MEMBER_URI_STR);
        if (accessCheck == 1) {
            logE("not allowed access");
            return 0;
        }
        if (accessCheck == 2) {
            logE("not supported function");
            return 0;
        }
        if (accessCheck == 3) {
            logE("no account");
            return 0;
        }
        ContentValues cValues = new ContentValues();
        ContentResolver cr = context.getContentResolver();
        return cr.update(Uri.parse(CONFERENCECALL_MAX_MEMBER_URI_STR), cValues, isVideo ? "1" : "0", null);
    }

    public Intent getIntentSettingActivity(Context context) {
        logI("getIntentSettingActivity()");
        if (isReadyToCall(context)) {
            Intent intent = new Intent();
            intent.setAction(CALL_SETTING_ACTION);
            return intent;
        }
        logI("getIntentSettingActivity() return null");
        return null;
    }

    public Intent getIntentCallLogActivity(Context context) {
        logI("getIntentCallLogActivity()");
        if (isReadyToCall(context)) {
            Intent intent = new Intent();
            intent.setAction(CALLLOG_ACTION);
            return intent;
        }
        logI("getIntentCallLogActivity() return null");
        return null;
    }

    public Intent getIntentAboutChatONVActivity(Context context) {
        logI("getIntentAboutChatONVActivity()");
        if (isReadyToCall(context)) {
            Intent intent = new Intent();
            intent.setAction(ABOUT_CHATONV_ACTION);
            return intent;
        }
        logI("getIntentAboutChatONVActivity() return null");
        return null;
    }

    public Intent getIntentDataUsageActivity(Context context) {
        logI("getIntentDataUsageActivity()");
        if (isReadyToCall(context)) {
            Intent intent = new Intent();
            intent.setAction(DATA_USAGE_ACTION);
            return intent;
        }
        logI("getIntentDataUsageActivity() return null");
        return null;
    }

    public int outgoingCall(Context context, boolean isVideoCall, String chatonID, String callerName, String roomNumber) {
        logI("outgoingCall() call start");
        if (!isInstalled(context)) {
            logE("ChatON V is not installed");
            return 2;
        }
        int accessCheck = checkKey(context, P2PCALL_AVAILABLE_URI_STR);
        if (accessCheck == 1) {
            logE("not allowed access");
            return 5;
        }
        if (accessCheck == 2) {
            logE("not supported function");
            return 13;
        }
        if (accessCheck == 3) {
            logE("no account");
            return 14;
        }
        if (chatonID == null || chatonID.isEmpty()) {
            logI("chatonID is empty");
            return 3;
        }
        String[] selectionArgs = new String[4];
        selectionArgs[0] = String.valueOf(isVideoCall ? "1" : "0");
        selectionArgs[1] = String.valueOf(callerName);
        selectionArgs[2] = String.valueOf(chatonID);
        selectionArgs[3] = String.valueOf(roomNumber);
        ContentResolver cr = context.getContentResolver();
        Cursor c = cr.query(Uri.parse(P2PCALL_AVAILABLE_URI_STR), null, null, selectionArgs, null);
        if (c != null) {
            c.close();
        }
        return 0;
    }

    public int outgoingConferenceCall(Context context, boolean isVideoCall, String[] chatonIDs, String callerName, String roomNumber, String groupName) {
        logI("outgoingConferenceCall() call start");
        if (!isInstalled(context)) {
            logE("ChatON V is not installed");
            return 2;
        }
        int accessCheck = checkKey(context, CONFERENCECALL_AVAILABLE_URI_STR);
        if (accessCheck == 1) {
            logE("not allowed access");
            return 5;
        }
        if (accessCheck == 2) {
            logE("not supported function");
            return 13;
        }
        if (accessCheck == 3) {
            logE("no account");
            return 14;
        }
        if (chatonIDs == null || chatonIDs.length == 0) {
            logI("samsungAccount is empty");
            return 3;
        }
        String[] selectionArgs = new String[chatonIDs.length + 5];
        selectionArgs[0] = String.valueOf(isVideoCall ? "1" : "0");
        selectionArgs[1] = String.valueOf(callerName);
        selectionArgs[2] = String.valueOf(roomNumber);
        selectionArgs[3] = String.valueOf(groupName);
        selectionArgs[4] = String.valueOf(chatonIDs.length);
        System.arraycopy(chatonIDs, 0, selectionArgs, 5, chatonIDs.length);
        ContentResolver cr = context.getContentResolver();
        Cursor c = cr.query(Uri.parse(CONFERENCECALL_AVAILABLE_URI_STR), null, null, selectionArgs, null);
        if (c != null) {
            c.close();
        }
        return 0;
    }

    public boolean showCallActivity(Context context) {
        logI("showCallActivity() call start");
        if (!isInstalled(context)) {
            logE("ChatON V is not installed");
            return false;
        }
        int accessCheck = checkKey(context, REMOTE_CALL_ACTIVITY_URI_STR);
        if (accessCheck == 1) {
            logE("not allowed access");
            return false;
        }
        if (accessCheck == 2) {
            logE("not supported function");
            return false;
        }
        if (accessCheck == 3) {
            logE("no account");
            return false;
        }
        ContentValues cValues = new ContentValues();
        ContentResolver cr = context.getContentResolver();
        int retV = cr.update(Uri.parse(REMOTE_CALL_ACTIVITY_URI_STR), cValues, "0", null);
        return retV == 1;
    }

    public boolean endCallActivity(Context context) {
        logI("endCallActivity() call start");
        if (!isInstalled(context)) {
            logE("ChatON V is not installed");
            return false;
        }
        int accessCheck = checkKey(context, REMOTE_CALL_ACTIVITY_URI_STR);
        if (accessCheck == 1) {
            logE("not allowed access");
            return false;
        }
        if (accessCheck == 2) {
            logE("not supported function");
            return false;
        }
        if (accessCheck == 3) {
            logE("no account");
            return false;
        }
        ContentValues cValues = new ContentValues();
        ContentResolver cr = context.getContentResolver();
        int retV = cr.update(Uri.parse(REMOTE_CALL_ACTIVITY_URI_STR), cValues, "1", null);
        return retV == 1;
    }

    public int getCallDuration(Context context) {
        logI("getCallDuration() call start");
        if (!isInstalled(context)) {
            logE("ChatON V is not installed");
            return -1;
        }
        int accessCheck = checkKey(context, CALL_DURATION_URI_STR);
        if (accessCheck == 1) {
            logE("not allowed access");
            return -1;
        }
        if (accessCheck == 2) {
            logE("not supported function");
            return -1;
        }
        if (accessCheck == 3) {
            logE("no account");
            return -1;
        }
        ContentResolver cr = context.getContentResolver();
        String duration = cr.getType(Uri.parse(CALL_DURATION_URI_STR));
        if (duration != null) {
            return Integer.parseInt(duration);
        }
        return -1;
    }

    public boolean isCalling(Context context) {
        logI("isCalling() call start");
        if (!isInstalled(context)) {
            logE("ChatON V is not installed");
            return false;
        }
        int accessCheck = checkKey(context, IS_CALLING_URI_STR);
        if (accessCheck == 1) {
            logE("not allowed access");
            return false;
        }
        if (accessCheck == 2) {
            logE("not supported function");
            return false;
        }
        if (accessCheck == 3) {
            logE("no account");
            return false;
        }
        ContentResolver cr = context.getContentResolver();
        String retV = cr.getType(Uri.parse(IS_CALLING_URI_STR));
        return retV != null;
    }

    public int getCallStateDuringCall(Context context) {
        logI("getCallStateDuringCall() call start");
        if (!isInstalled(context)) {
            logE("ChatON V is not installed");
            return 0;
        }
        int accessCheck = checkKey(context, CALL_STATE_URI_STR);
        if (accessCheck == 1) {
            logE("not allowed access");
            return 0;
        }
        if (accessCheck == 2) {
            logE("not supported function");
            return 0;
        }
        if (accessCheck == 3) {
            logE("no account");
            return 0;
        }
        ContentResolver cr = context.getContentResolver();
        String retV = cr.getType(Uri.parse(CALL_STATE_URI_STR));
        if (retV == null) {
            return 3;
        }
        return Integer.parseInt(retV);
    }

    public int getCallType(Context context) {
        logI("getCallType() call start");
        if (!isInstalled(context)) {
            logE("ChatON V is not installed");
            return 0;
        }
        int accessCheck = checkKey(context, GET_CALL_TYPE_URI_STR);
        if (accessCheck == 1) {
            logE("not allowed access");
            return 0;
        }
        if (accessCheck == 2) {
            logE("not supported function");
            return 0;
        }
        if (accessCheck == 3) {
            logE("no account");
            return 0;
        }
        ContentValues cValues = new ContentValues();
        ContentResolver cr = context.getContentResolver();
        return cr.update(Uri.parse(GET_CALL_TYPE_URI_STR), cValues, null, null);
    }

    public ArrayList<String> getCallMember(Context context) {
        logI("getCallMember() call start");
        if (!isInstalled(context)) {
            logE("ChatON V is not installed");
            return null;
        }
        int accessCheck = checkKey(context, GET_CALL_MEMBER_URI_STR);
        if (accessCheck == 1) {
            logE("not allowed access");
            return null;
        }
        if (accessCheck == 2) {
            logE("not supported function");
            return null;
        }
        if (accessCheck == 3) {
            logE("no account");
            return null;
        }
        ContentResolver cr = context.getContentResolver();
        ArrayList<String> callMember = new ArrayList<>();
        String bufCallMember = cr.getType(Uri.parse(GET_CALL_MEMBER_URI_STR));
        if (bufCallMember == null || bufCallMember.length() == 0) {
            return null;
        }
        String[] member = bufCallMember.split(USERID_DELEMETER);
        for (String str : member) {
            callMember.add(str);
        }
        logI("call member: " + callMember);
        if (callMember.size() == 0) {
            return null;
        }
        return callMember;
    }

    public int getLatestApkVersion(Context context) {
        logI("getLatestApkVersion() call start");
        if (!isInstalled(context)) {
            logE("ChatON V is not installed");
            return 2;
        }
        int accessCheck = checkKey(context, GET_LATEST_VERSION_URI_STR);
        if (accessCheck == 1) {
            logE("not allowed access");
            return 5;
        }
        if (accessCheck == 2) {
            logE("not supported function");
            return 13;
        }
        if (accessCheck == 3) {
            logE("no account");
            return 14;
        }
        ContentResolver cr = context.getContentResolver();
        cr.getType(Uri.parse(GET_LATEST_VERSION_URI_STR));
        return 0;
    }

    public static String toVersionInfoString(int versionInfo) {
        switch (versionInfo) {
            case 1:
                return "NORMAL_UPDATE";
            case 2:
                return "MINOR_UPDATE";
            case 3:
                return "CRITICAL_UPDATE";
            default:
                return "SAME_VERSION";
        }
    }

    public static String toCallStateString(int state) {
        switch (state) {
            case 0:
                return "STATE_INIT";
            case 1:
                return "STATE_CALLING";
            case 2:
                return "STATE_CONNECTED";
            case 3:
                return "STATE_DISCONNECTED";
            case 100:
                return "STATE_CHANGE_TO_CONFERENCE_CONNECTED";
            case 101:
                return "STATE_CHANGE_TO_P2P_CONNECTED";
            case 102:
                return "STATE_CHANGE_TO_CONFERENCE_DISCONNECTED";
            case 103:
                return "STATE_CHANGE_TO_P2P_DISCONNECTED";
            default:
                return null;
        }
    }

    public static String toString(int returnValue) {
        switch (returnValue) {
            case 0:
                return "RET_CHATONV_SUCCESS";
            case 1:
                return "RET_CHATONV_FAIL";
            case 2:
                return "RET_CHATONV_NOT_INSTALLED";
            case 3:
                return "RET_CHATONV_ID_EMPTY";
            case 4:
                return "RET_CHATONV_UNEXPECTED_ERROR";
            case 5:
                return "RET_CHATONV_NOT_ALLOWED_ACCESS";
            case 6:
                return "RET_CHATONV_NATIONAL_CODE_EMPTY";
            case 7:
                return "RET_CHATONV_GUID_EMPTY";
            case 8:
                return "RET_CHATONV_CALLER_NAME_EMPTY";
            case 9:
                return "RET_CHATONV_CHATON_NUMBER_EMPTY";
            case 10:
                return "RET_CHATONV_CHATON_UID_EMPTY";
            case 11:
                return "RET_CHATONV_IMEI_EMPTY";
            case 12:
                return "RET_CHATONV_BIRTHDAY_EMPTY";
            case 13:
                return "RET_CHATONV_NOT_SUPPORTED_FUNCTION";
            case 14:
                return "RET_CHATONV_NO_ACCOUNT";
            default:
                return "";
        }
    }

    private static int checkKey(Context context, String url) {
        logI("checkKey()");
        ContentValues cv = new ContentValues();
        cv.put("key", context.getPackageName());
        cv.put("function", url);
        ContentResolver cr = context.getContentResolver();
        Uri uriRet = cr.insert(Uri.parse(KEY_URI_STR), cv);
        if (uriRet == null) {
            return 1;
        }
        if (uriRet.toString().equals("content://com.coolots.chaton/not_supported_function")) {
            return 2;
        }
        return uriRet.toString().equals("content://com.coolots.chaton/no_account") ? 3 : 0;
    }

    private class ChatONVAPIIReceiver extends BroadcastReceiver {
        private ChatONVAPIIReceiver() {
        }

        /* synthetic */ ChatONVAPIIReceiver(ChatONVAPII chatONVAPII, ChatONVAPIIReceiver chatONVAPIIReceiver) {
            this();
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if (action != null) {
                ChatONVAPII.logI("ChatONVAPIIReceiver() action: " + action);
                ChatONVAPII.logI("ChatONVAPIIReceiver() this: " + toString());
                ChatONVAPII.logI("ChatONVAPIIReceiver() mListener: " + ChatONVAPII.this.mListener.toString());
                ChatONVAPII.logI("ChatONVAPIIReceiver() mReceiver: " + ChatONVAPII.this.mReceiver.toString());
                if (action.equals("com.coolots.chaton.account.ACCOUNT_RESULTINFO")) {
                    if (intent.hasExtra("result")) {
                        ChatONVAPII.logI("BR_ACCOUNT_RESULT_INFO");
                        if (ChatONVAPII.this.mListener != null) {
                            boolean result = intent.getBooleanExtra("result", false);
                            String resultString = intent.getStringExtra("account_fail_string");
                            ChatONVAPII.logI("result: " + result + ", result string: " + resultString);
                            ChatONVAPII.this.mListener.onReceiveCreateAccount(result, resultString);
                            return;
                        }
                        return;
                    }
                    return;
                }
                if (action.equals("com.coolots.chaton.account.REMOVE_ACCOUNT_RESULTINFO") && intent.hasExtra("result")) {
                    ChatONVAPII.logI("BR_REMOVE_ACCOUNT_RESULT_INFO");
                    if (ChatONVAPII.this.mListener != null) {
                        ChatONVAPII.this.mListener.onReceiveRemoveAccount(intent.getBooleanExtra("result", false));
                    }
                }
            }
        }
    }

    private class ChatONVAPIICallReceiver extends BroadcastReceiver {
        private ChatONVAPIICallReceiver() {
        }

        /* synthetic */ ChatONVAPIICallReceiver(ChatONVAPII chatONVAPII, ChatONVAPIICallReceiver chatONVAPIICallReceiver) {
            this();
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if (action != null) {
                ChatONVAPII.logI("ChatONVAPIICallReceiver() action: " + action);
                ChatONVAPII.logI("ChatONVAPIICallReceiver() this: " + toString());
                ChatONVAPII.logI("ChatONVAPIICallReceiver() mCallListener: " + ChatONVAPII.this.mCallListener.toString());
                ChatONVAPII.logI("ChatONVAPIICallReceiver() mCallReceiver: " + ChatONVAPII.this.mCallReceiver.toString());
                if (action.equals("com.coolots.chaton.account.CALL_STATE_CHANGE_INFO")) {
                    if (intent.hasExtra("result")) {
                        int state = intent.getIntExtra("result", 3);
                        ChatONVAPII.logI("BR_CALL_STATE_CHANGE_INFO state(" + ChatONVAPII.toCallStateString(state) + ")");
                        if (ChatONVAPII.this.mCallListener != null) {
                            ChatONVAPII.this.mCallListener.onReceiveChangeCallState(state);
                            return;
                        }
                        return;
                    }
                    return;
                }
                if (action.equals("com.coolots.chaton.version.CONFERENCE_MEMBER_CHANGED")) {
                    ChatONVAPII.logI("BR_CONFERENCE_MEMBER_CHANGED");
                    if (ChatONVAPII.this.mCallListener != null) {
                        ChatONVAPII.this.mCallListener.onReceiveChangeConferenceMember();
                    }
                }
            }
        }
    }

    private class ChatONVAPIIUpdateReceiver extends BroadcastReceiver {
        private ChatONVAPIIUpdateReceiver() {
        }

        /* synthetic */ ChatONVAPIIUpdateReceiver(ChatONVAPII chatONVAPII, ChatONVAPIIUpdateReceiver chatONVAPIIUpdateReceiver) {
            this();
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if (action != null) {
                ChatONVAPII.logI("ChatONVAPIIUpdateReceiver() action: " + action);
                ChatONVAPII.logI("ChatONVAPIIUpdateReceiver() this: " + toString());
                ChatONVAPII.logI("ChatONVAPIIUpdateReceiver() mUpdateListener: " + ChatONVAPII.this.mUpdateListener.toString());
                ChatONVAPII.logI("ChatONVAPIIUpdateReceiver() mUpdateReceiver: " + ChatONVAPII.this.mUpdateReceiver.toString());
                if (action.equals("com.coolots.chaton.version.UPGRADE_NEW_APK_INFO") && intent.hasExtra("version_name") && intent.hasExtra("version_info")) {
                    String currentVersionName = intent.getStringExtra("current_version_name");
                    String serverVersionName = intent.getStringExtra("version_name");
                    int versionInfo = intent.getIntExtra("version_info", 0);
                    ChatONVAPII.logI("BR_UPGRADE_NEW_APK_INFO " + currentVersionName + ", " + serverVersionName + ", " + versionInfo);
                    if (ChatONVAPII.this.mUpdateListener != null) {
                        ChatONVAPII.this.mUpdateListener.onReceiveUpdateVerion(currentVersionName, serverVersionName, versionInfo);
                    }
                }
            }
        }
    }
}
