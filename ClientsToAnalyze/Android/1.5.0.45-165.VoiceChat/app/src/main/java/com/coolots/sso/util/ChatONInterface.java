package com.coolots.sso.util;

import android.content.Intent;
import android.os.Bundle;
import com.coolots.chaton.common.util.ChatOnConfigInterface;
import com.coolots.sso.calllog.ChatONCallLogData;
import com.sds.coolots.MainApplication;
import com.sds.coolots.common.coolotsinterface.IChatONInterface;
import com.sds.coolots.common.util.Log;
import com.sds.coolots.common.util.ModelInfoUtil;
import com.vlingo.sdk.internal.Strings;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
public class ChatONInterface implements IChatONInterface {
    public static final String ACCESS_PERMISSION = "com.coolots.permission.COOLOTS";
    public static final String BR_ACCOUNT_RESULT_INFO = "com.coolots.chaton.account.ACCOUNT_RESULTINFO";
    public static final String BR_CALLLOG_DATA = "com.coolots.chaton.CALLLOG_DATA";
    public static final String BR_CALL_STATE_CHANGE_INFO = "com.coolots.chaton.account.CALL_STATE_CHANGE_INFO";
    public static final String BR_CONFERENCE_MEMBER_CHANGED = "com.coolots.chaton.version.CONFERENCE_MEMBER_CHANGED";
    public static final String BR_REMOVE_ACCOUNT_RESULT_INFO = "com.coolots.chaton.account.REMOVE_ACCOUNT_RESULTINFO";
    public static final String BR_SERVICE_POLICY_INFO = "com.coolots.chaton.SERVICE_POLICY_INFO";
    public static final String BR_SHARE_VIEW_INFO = "com.coolots.chaton.SHARE_VIEW_START_END";
    public static final String BR_UPGRADE_NEW_APK_INFO = "com.coolots.chaton.version.UPGRADE_NEW_APK_INFO";
    public static final String CALL_SHORT_CUT_ACTION_NAME = "com.coolots.chaton.CALL_SHORTCUT";
    public static final String EXTRAS_KEY_ACCOUNT_FAIL_MSG = "account_fail_string";
    public static final String EXTRAS_KEY_CALLLOG_DATA = "calllog_data";
    public static final String EXTRAS_KEY_CALLLOG_TYPE = "calllog_type";
    public static final String EXTRAS_KEY_CURRENT_VERSION_NAME = "current_version_name";
    public static final String EXTRAS_KEY_DOWNLOAD_URL = "download_url";
    public static final String EXTRAS_KEY_ENABLE_VIDEO_CALL = "enable_video_call";
    public static final String EXTRAS_KEY_ENABLE_VOICE_CALL = "enable_voice_call";
    public static final String EXTRAS_KEY_GVIDEO_CALL_MAX_COUNT = "group_video_call_max_count";
    public static final String EXTRAS_KEY_GVOICE_CALL_MAX_COUNT = "group_voice_call_max_count";
    public static final String EXTRAS_KEY_RESULT = "result";
    public static final String EXTRAS_KEY_SHARE_VIEW_END = "end_share_view";
    public static final String EXTRAS_KEY_SHARE_VIEW_PAUSE = "pause_share_view";
    public static final String EXTRAS_KEY_SHARE_VIEW_RESTART = "restart_share_view";
    public static final String EXTRAS_KEY_SHARE_VIEW_START = "start_share_view";
    public static final String EXTRAS_KEY_VERSION_INFO = "version_info";
    public static final String EXTRAS_KEY_VERSION_NAME = "version_name";
    public static final String USER_SETTING_ACTION_NAME = "com.coolots.chaton.USER_SETTING";

    private void logE(String message) {
        Log.m2958e("[SSOBroadcasting]" + message);
    }

    private void logI(String message) {
        Log.m2963i("[SSOBroadcasting]" + message);
    }

    @Override // com.sds.coolots.common.coolotsinterface.IChatONInterface
    public void sendBroadcastCreateAccountResult(Boolean result, int msg) {
        String msgString = msg != 0 ? MainApplication.mContext.getString(msg) : "Create account success";
        logI("sendBroadcastAccountResult(): " + result + ", msg: " + msgString);
        Intent intent = new Intent();
        Bundle extras = new Bundle();
        extras.putBoolean(EXTRAS_KEY_RESULT, result.booleanValue());
        extras.putInt(EXTRAS_KEY_GVOICE_CALL_MAX_COUNT, ((ChatOnConfigInterface) MainApplication.mConfig).getConferenceCallMaxPeopleNum(false));
        extras.putInt(EXTRAS_KEY_GVIDEO_CALL_MAX_COUNT, ((ChatOnConfigInterface) MainApplication.mConfig).getConferenceCallMaxPeopleNum(true));
        if (msgString != null) {
            extras.putString("account_fail_string", msgString);
        }
        intent.setAction(BR_ACCOUNT_RESULT_INFO);
        intent.putExtras(extras);
        MainApplication.mContext.sendBroadcast(intent, "com.coolots.permission.COOLOTS");
    }

    @Override // com.sds.coolots.common.coolotsinterface.IChatONInterface
    public void sendBroadcastCreateAccountResult(Boolean result) {
        sendBroadcastCreateAccountResult(result, 0);
    }

    @Override // com.sds.coolots.common.coolotsinterface.IChatONInterface
    public void sendBroadcastRemoveAccountResult(Boolean result) {
        logI("sendBroadcastRemoveAccountResult(): " + result);
        Intent intent = new Intent();
        Bundle extras = new Bundle();
        extras.putBoolean(EXTRAS_KEY_RESULT, result.booleanValue());
        intent.setAction(BR_REMOVE_ACCOUNT_RESULT_INFO);
        intent.putExtras(extras);
        MainApplication.mContext.sendBroadcast(intent, "com.coolots.permission.COOLOTS");
    }

    @Override // com.sds.coolots.common.coolotsinterface.IChatONInterface
    public void sendBroadcastServicePolicyInfo(boolean enableVoice, boolean enableVideo) {
        logI("sendBroadcastServicePolicyInfo( voice: " + enableVoice + ", video: " + enableVideo + ")");
        Intent intent = new Intent();
        Bundle extras = new Bundle();
        extras.putBoolean(EXTRAS_KEY_ENABLE_VOICE_CALL, enableVoice);
        extras.putBoolean(EXTRAS_KEY_ENABLE_VIDEO_CALL, enableVideo);
        intent.setAction(BR_SERVICE_POLICY_INFO);
        intent.putExtras(extras);
        MainApplication.mContext.sendBroadcast(intent, "com.coolots.permission.COOLOTS");
    }

    @Override // com.sds.coolots.common.coolotsinterface.IChatONInterface
    public void sendBroadcastShareViewInfo(int info) {
        logI("sendBroadcastShareViewInfo(): " + info);
        Intent intent = new Intent();
        Bundle extras = new Bundle();
        switch (info) {
            case 1:
                extras.putBoolean(EXTRAS_KEY_SHARE_VIEW_START, true);
                break;
            case 2:
                extras.putBoolean(EXTRAS_KEY_SHARE_VIEW_END, true);
                break;
            case 3:
                extras.putBoolean(EXTRAS_KEY_SHARE_VIEW_PAUSE, true);
                break;
            case 4:
                extras.putBoolean(EXTRAS_KEY_SHARE_VIEW_RESTART, true);
                break;
        }
        intent.setAction(BR_SHARE_VIEW_INFO);
        intent.putExtras(extras);
        MainApplication.mContext.sendBroadcast(intent, "com.coolots.permission.COOLOTS");
    }

    @Override // com.sds.coolots.common.coolotsinterface.IChatONInterface
    public void sendBroadcastCallStateChange(int callState) {
        logI("sendBroadcastCallStateChange(): " + ChatONVAPII.toCallStateString(callState));
        Intent intent = new Intent();
        Bundle extras = new Bundle();
        extras.putInt(EXTRAS_KEY_RESULT, callState);
        intent.setAction(BR_CALL_STATE_CHANGE_INFO);
        intent.putExtras(extras);
        MainApplication.mContext.sendBroadcast(intent, "com.coolots.permission.COOLOTS");
    }

    @Override // com.sds.coolots.common.coolotsinterface.IChatONInterface
    public void sendBroadcastUgradeNewApk(String versionName, int versionInfo, String[] downloadURL) {
        logE("sendBroadcastUgradeNewApk(" + versionName + ", " + versionInfo + ")");
        Intent intent = new Intent();
        Bundle extras = new Bundle();
        extras.putString("current_version_name", ModelInfoUtil.getAppVersion(MainApplication.mContext));
        extras.putString("version_name", versionName);
        extras.putInt("version_info", versionInfo);
        extras.putStringArray(EXTRAS_KEY_DOWNLOAD_URL, downloadURL);
        intent.setAction("com.coolots.chaton.version.UPGRADE_NEW_APK_INFO");
        intent.putExtras(extras);
        MainApplication.mContext.sendBroadcast(intent, "com.coolots.permission.COOLOTS");
    }

    @Override // com.sds.coolots.common.coolotsinterface.IChatONInterface
    public void sendBroadcastCallMemberChange() {
        logI("sendBroadcastCallMemberChange()");
        Intent intent = new Intent();
        intent.setAction(BR_CONFERENCE_MEMBER_CHANGED);
        MainApplication.mContext.sendBroadcast(intent, "com.coolots.permission.COOLOTS");
    }

    public void sendBroadcastCallLogData(ArrayList<ChatONCallLogData> dataList, boolean isConference) {
        logI("<<kyj>> sendBroadcastCallLogData()");
        Iterator<ChatONCallLogData> it = dataList.iterator();
        while (it.hasNext()) {
            ChatONCallLogData user = it.next();
            logE("<<kyj>> CallLog Test isConference: " + isConference + "user id: " + user.getUserid() + " user name: " + user.getUsername() + " duration: " + user.getDuration() + " startTime: " + user.getCalldate() + " type: " + user.getCalllogtype() + Strings.android_core_method + user.getCallmethod());
        }
        Intent intent = new Intent();
        Bundle extras = new Bundle();
        intent.setAction(BR_CALLLOG_DATA);
        extras.putBoolean(EXTRAS_KEY_CALLLOG_TYPE, isConference);
        extras.putParcelableArrayList(EXTRAS_KEY_CALLLOG_DATA, dataList);
        intent.putExtras(extras);
        logE(extras.toString());
        MainApplication.mContext.sendBroadcast(intent, "com.coolots.permission.COOLOTS");
    }
}
