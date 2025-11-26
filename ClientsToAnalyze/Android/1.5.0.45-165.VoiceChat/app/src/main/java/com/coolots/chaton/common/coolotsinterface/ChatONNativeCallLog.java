package com.coolots.chaton.common.coolotsinterface;

import android.content.ContentValues;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.coolots.chaton.buddy.BuddyManagerInterface;
import com.coolots.chaton.calllog.model.CallLogDBData;
import com.coolots.chaton.common.controller.VAppPhoneManager;
import com.coolots.chaton.common.util.ChatONStringConvert;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonRecentMediaAdapter;
import com.sds.coolots.MainApplication;
import com.sds.coolots.calllog.NativeCallLogInterface;
import com.sds.coolots.common.controller.DatabaseHelper;
import com.sds.coolots.common.util.Log;
import com.sec.chaton.clientapi.GraphAPI;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class ChatONNativeCallLog implements NativeCallLogInterface {
    public static final String CHATON_CALLLOG_ADDRESS_TYPE = "address";
    public static final int CHATON_CALLLOG_AUTOREJECTED_TYPE = 6;
    public static final int CHATON_CALLLOG_INCOMING_TYPE = 1;
    public static final String CHATON_CALLLOG_LOG_TYPE = "logtype";
    public static final int CHATON_CALLLOG_LOG_TYPE_CALL = 100;
    public static final int CHATON_CALLLOG_LOG_TYPE_VIDEO = 500;
    public static final int CHATON_CALLLOG_LOG_TYPE_VOIP = 800;
    public static final int CHATON_CALLLOG_MISSED_TYPE = 3;
    public static final int CHATON_CALLLOG_OUTGOING_TYPE = 2;
    public static final int CHATON_CALLLOG_REJECTED_TYPE = 5;
    public static final String CHATON_CALLLOG_TYPE = "type";
    private static final String CLASSNAME = "[ChatONNativeCallLog]";
    private static final String KEY_BR_DURATION = "calllog_duration";
    private static final String KEY_BR_GMT_START_CALL_TIME = "calllog_gmt_start_call_time";
    private static final String KEY_BR_METHOD = "calllog_method";
    private static final String KEY_BR_NAME = "calllog_name";
    private static final String KEY_BR_PHONENUMBER = "calllog_phonenumber";
    private static final String KEY_BR_REJECTMSG = "calllog_rejectmsg";
    private static final String KEY_BR_SAMSUNG_ACCOUNT_ID = "calllog_id";
    private static final String KEY_BR_TYPE = "calllog_type";
    private static final String NATIVE_CALLLOG_BR_ACTION = "com.coolots.chaton.action.NATIVE_CALL_LOG";
    private static final boolean SEND_BROADCASTING = true;
    private static final boolean SEND_CONTENTPROVIDER = false;
    private static final Uri CHATON_CALLLOG_VOICE_URI = Uri.parse("content://logs/chaton_call");
    private static final Uri CHATON_CALLLOG_VIDEO_URI = Uri.parse("content://logs/chaton_video");

    private void logE(String message) {
        Log.m2958e(CLASSNAME + message);
    }

    private void logI(String message) {
        Log.m2963i(CLASSNAME + message);
    }

    @Override // com.sds.coolots.calllog.NativeCallLogInterface
    public void saveCallLog(Object object) {
        CallLogDBData data = (CallLogDBData) object;
        Intent intent = new Intent(NATIVE_CALLLOG_BR_ACTION);
        Bundle extras = new Bundle();
        extras.putString(KEY_BR_SAMSUNG_ACCOUNT_ID, data.userid);
        extras.putString(KEY_BR_NAME, data.username);
        BuddyManagerInterface buddyManager = ((VAppPhoneManager) MainApplication.mPhoneManager).getChatOnContactManager();
        ArrayList<String> phoneNums = buddyManager.getPhoneNoArrayListByUserID(data.userid);
        if (phoneNums != null && !phoneNums.isEmpty()) {
            extras.putString(KEY_BR_PHONENUMBER, phoneNums.get(0));
        }
        extras.putString(KEY_BR_GMT_START_CALL_TIME, data.calldate);
        extras.putInt(KEY_BR_DURATION, data.duration);
        switch (data.calllogtype) {
            case 0:
                extras.putString("calllog_type", "incoming");
                break;
            case 1:
                extras.putString("calllog_type", "outgoing");
                break;
            case 2:
                extras.putString("calllog_type", "missed");
                break;
            case 3:
                extras.putString("calllog_type", "rejected");
                break;
            case 4:
                extras.putString("calllog_type", "autorejected");
                break;
        }
        if (data.rejectmsg != null && !data.rejectmsg.isEmpty()) {
            extras.putString(KEY_BR_REJECTMSG, data.rejectmsg);
        }
        switch (data.callmethod) {
            case 6:
            case 8:
            case 10:
                extras.putString(KEY_BR_METHOD, "voice");
                break;
            case 7:
            case 9:
            case 11:
                extras.putString(KEY_BR_METHOD, SlookAirButtonRecentMediaAdapter.VIDEO_TYPE);
                break;
        }
        logI("sendBroadcast()");
        intent.putExtras(extras);
        MainApplication.mContext.sendBroadcast(intent);
    }

    private ContentValues getContentValues(CallLogDBData data) {
        logI("getContentValues()");
        ContentValues values = new ContentValues();
        values.put(CHATON_CALLLOG_ADDRESS_TYPE, data.userid);
        values.put("number", ChatONStringConvert.getInstance().removeAfterAt(data.phoneno));
        long localTime = ChatONStringConvert.getInstance().convertGMT2LocalTime(data.calldate);
        values.put("date", Long.toString(localTime));
        values.put(DatabaseHelper.KEY_DURATION, Integer.valueOf(data.duration));
        if (data.hangupcode == 100) {
            values.put(CHATON_CALLLOG_TYPE, (Integer) 5);
        } else {
            switch (data.calllogtype) {
                case 0:
                    values.put(CHATON_CALLLOG_TYPE, (Integer) 1);
                    break;
                case 1:
                    values.put(CHATON_CALLLOG_TYPE, (Integer) 2);
                    break;
                case 2:
                    values.put(CHATON_CALLLOG_TYPE, (Integer) 3);
                    break;
                case 4:
                    values.put(CHATON_CALLLOG_TYPE, (Integer) 6);
                    break;
            }
        }
        values.put("new", (Integer) 1);
        values.put(GraphAPI.ME_NAME, data.username);
        values.put("numbertype", (Integer) 0);
        values.put("numberlabel", "");
        return values;
    }

    private Uri getContentURI(CallLogDBData data) {
        logI("getContentURI()");
        switch (data.callmethod) {
            case 6:
            case 8:
            case 10:
                return CHATON_CALLLOG_VOICE_URI;
            case 7:
            case 9:
            case 11:
                return CHATON_CALLLOG_VIDEO_URI;
            default:
                return null;
        }
    }
}
