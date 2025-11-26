package com.coolots.chaton.setting.data;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Handler;
import android.preference.PreferenceManager;
import com.coolots.chaton.common.controller.ChatOnResourceInterface;
import com.coolots.chaton.common.controller.VAppPhoneManager;
import com.coolots.chaton.common.util.ChatOnConfigInterface;
import com.coolots.chaton.profile.ProfileManagerInterface;
import com.coolots.chaton.profile.adaptor.ProfileAdaptor;
import com.sds.coolots.MainApplication;
import com.sds.coolots.call.model.RingtoneInfo;
import com.sds.coolots.common.util.Log;
import com.sds.coolots.common.util.ModelInfoUtil;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public final class ChatONSettingData implements ChatONSettingDataInterface {
    private static final boolean ALERTS_ON_CALL_DEFAULT = false;
    private static final boolean AUTO_SYNC_POPUP_SHOW_DEFAULT = true;
    private static final boolean CALL_ANSWERING_HOME_KEY_DEFAULT = false;
    private static final boolean CALL_ANSWER_VIBRATION_DEFAULT = false;
    private static final boolean CALL_CONNECT_TONE_DEFAULT = true;
    private static final boolean CALL_END_POWER_KEY_DEFAULT = false;
    private static final boolean CALL_END_TONE_DEFAULT = true;
    private static final boolean CALL_END_VIBRATION_DEFAULT = false;
    private static final String CALL_STATUS_TONES_DEFAULT = "0OV=I=XseparatorX=I=VO2";
    private static final boolean CALL_STATUS_TONES_DEFAULT_1 = true;
    private static final boolean CALL_STATUS_TONES_DEFAULT_2 = false;
    private static final boolean CALL_STATUS_TONES_DEFAULT_3 = true;
    private static List<Boolean> CALL_STATUS_TONES_DEFAULT_LIST = null;
    private static final String CALL_STATUS_VIBRATIONS_DEFAULT = "";
    private static final boolean CALL_STATUS_VIBRATIONS_DEFAULT_1 = false;
    private static final boolean CALL_STATUS_VIBRATIONS_DEFAULT_2 = false;
    private static List<Boolean> CALL_STATUS_VIBRATIONS_DEFAULT_LIST = null;
    private static final String CLASSNAME = "[ChatONSettingData]";
    private static final boolean CONTACT_SYNC_NOW_DEFAULT = false;
    private static final int DEFAULT_DAY = 1;
    private static final int INIT_VALUE = -1;
    private static final boolean MINUTE_MINDER_DEFAULT = false;
    public static final boolean OWN_VIDEO_DEFAULT = true;
    private static final String PREF_CYCLE_DAY = "datausage_cycle_day";
    private static final String RINGTONE_DEFAULT = "2";
    private static final boolean USE_DRIVINGMODE_DEFAULT = true;
    private static final boolean USE_EXCLUDE_ME_DEFAULT = false;
    private static final boolean USE_PRIVACY_DEFAULT = false;
    private static final boolean USE_PROXIMITY_DEFAULT = true;
    private static final boolean USE_SUGGESTION_DEFAULT = false;
    private static final boolean USE_WIFI_ONLY_DEFAULT = false;
    private static final boolean VIBRATE_WHEN_RINGING_DEFAULT = false;
    private static final boolean VIDEO_CALL_QUALITY_DEFAULT = false;
    private static ChatONSettingDataInterface instance = new ChatONSettingData();
    private int mAlertsOnCall;
    private Handler mAlertsOnCallChangeHandler;
    private int mAutoSyncPopupShow;
    private int mCallAnswerHomeKey;
    private Handler mCallAnswerHomeKeyChangeHandler;
    private int mCallAnswerVibration;
    private int mCallConnectTone;
    private int mCallEndPowerKey;
    private Handler mCallEndPowerKeyChangeHandler;
    private int mCallEndTone;
    private int mCallEndVibration;
    private List<Boolean> mCallStatusTones;
    private List<Boolean> mCallStatusVibrations;
    private boolean mChangeDefaultImage;
    private int mContactSyncNow;
    private int mMinuteMinder;
    private int mOwnVideo;
    private String mUpdateVersionName;
    private int mUseDrivingMode;
    private int mUseExcludeMe;
    private int mUseHighQuality;
    private int mUsePrivacy;
    private int mUseProximity;
    private int mUseSuggestion;
    private int mUseWifiOnly;
    private int mVibrateWhenRinging;

    private void logI(String message) {
        Log.m2963i(CLASSNAME + message);
    }

    private ChatONSettingData() {
        this.mUpdateVersionName = "";
        Log.m2963i("[ChatONSetting] new Instance");
        this.mCallStatusVibrations = null;
        CALL_STATUS_VIBRATIONS_DEFAULT_LIST = new ArrayList(2);
        CALL_STATUS_VIBRATIONS_DEFAULT_LIST.add(false);
        CALL_STATUS_VIBRATIONS_DEFAULT_LIST.add(false);
        this.mCallStatusTones = null;
        CALL_STATUS_TONES_DEFAULT_LIST = new ArrayList(3);
        CALL_STATUS_TONES_DEFAULT_LIST.add(true);
        CALL_STATUS_TONES_DEFAULT_LIST.add(false);
        CALL_STATUS_TONES_DEFAULT_LIST.add(true);
        this.mAlertsOnCall = -1;
        this.mOwnVideo = -1;
        this.mUseWifiOnly = -1;
        this.mUseProximity = -1;
        this.mUseSuggestion = -1;
        this.mUseExcludeMe = -1;
        this.mUsePrivacy = -1;
        this.mCallAnswerHomeKey = -1;
        this.mCallEndPowerKey = -1;
        this.mChangeDefaultImage = false;
        this.mContactSyncNow = -1;
        this.mAutoSyncPopupShow = -1;
        this.mUpdateVersionName = "";
        this.mUseHighQuality = -1;
        this.mUseDrivingMode = -1;
        this.mVibrateWhenRinging = -1;
    }

    public static ChatONSettingDataInterface getInstance() {
        return instance;
    }

    @Override // com.coolots.chaton.setting.data.ChatONSettingDataInterface
    public String getLastVersionName() {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(MainApplication.mContext);
        this.mUpdateVersionName = sharedPreferences.getString(ChatONSettingDataInterface.PREF_LATEST_VERSION_KEY, ModelInfoUtil.getAppVersion(MainApplication.mContext));
        return this.mUpdateVersionName;
    }

    @Override // com.coolots.chaton.setting.data.ChatONSettingDataInterface
    public void setLastVersionName(String versionName) {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(MainApplication.mContext);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(ChatONSettingDataInterface.PREF_LATEST_VERSION_KEY, versionName);
        if (Build.VERSION.SDK_INT < 9) {
            editor.commit();
        } else {
            editor.apply();
        }
        this.mUpdateVersionName = versionName;
    }

    @Override // com.coolots.chaton.setting.data.ChatONSettingDataInterface
    public boolean isChecked(String key) {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(MainApplication.mContext);
        return sharedPreferences.getBoolean(key, false);
    }

    @Override // com.coolots.chaton.setting.data.ChatONSettingDataInterface
    public void setChecked(String key, boolean check) {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(MainApplication.mContext);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean(key, check);
        if (Build.VERSION.SDK_INT < 9) {
            editor.commit();
        } else {
            editor.apply();
        }
    }

    @Override // com.coolots.chaton.setting.data.ChatONSettingDataInterface
    public int getValue(String key, int defaultV) {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(MainApplication.mContext);
        return sharedPreferences.getInt(key, defaultV);
    }

    @Override // com.coolots.chaton.setting.data.ChatONSettingDataInterface
    public void setValue(String key, int value) {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(MainApplication.mContext);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(key, value);
        if (Build.VERSION.SDK_INT < 9) {
            editor.commit();
        } else {
            editor.apply();
        }
    }

    @Override // com.coolots.chaton.setting.data.ChatONSettingDataInterface
    public boolean isAlertsOnCall() {
        if (this.mAlertsOnCall == -1) {
            updateAlertsOnCall();
        }
        return this.mAlertsOnCall == 1;
    }

    @Override // com.coolots.chaton.setting.data.ChatONSettingDataInterface
    public void updateAlertsOnCall() {
        logI("updateAlertsOnCall() mAlertsOnCall is " + this.mAlertsOnCall);
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(MainApplication.mContext);
        boolean value = sharedPreferences.getBoolean(ChatONSettingDataInterface.PREF_ALERTS_ON_CALL_KEY, false);
        ((ChatOnConfigInterface) MainApplication.mConfig).setVoIPInCallAlert(value);
        this.mAlertsOnCall = value ? 1 : 0;
        logI("=> change to " + this.mAlertsOnCall);
        if (this.mAlertsOnCallChangeHandler != null) {
            this.mAlertsOnCallChangeHandler.sendEmptyMessage(this.mAlertsOnCall);
        }
    }

    @Override // com.coolots.chaton.setting.data.ChatONSettingDataInterface
    public void registAlertsOnCallHandler(Handler handler) {
        this.mAlertsOnCallChangeHandler = handler;
    }

    @Override // com.coolots.chaton.setting.data.ChatONSettingDataInterface
    public Bitmap getVideoCallImage(boolean isDefaultImg, boolean isLandscape) {
        Bitmap bitmap;
        int defaultImageRID;
        if (isDefaultImg) {
            setChangeVideoCallImage(false);
            if (isLandscape) {
                bitmap = ChatONHideMeImgData.getLandscapeImage();
                defaultImageRID = ((ChatOnResourceInterface) MainApplication.mResources).getHideMeDefaultLandscapeImage();
            } else {
                bitmap = ChatONHideMeImgData.getPortraitImage();
                defaultImageRID = ((ChatOnResourceInterface) MainApplication.mResources).getHideMeDefaultPortraitImage();
            }
        } else if (isLandscape) {
            bitmap = ChatONHideMeImgData.getGalleryLandscapeImage();
            defaultImageRID = ((ChatOnResourceInterface) MainApplication.mResources).getHideMeDefaultLandscapeImage();
        } else {
            bitmap = ChatONHideMeImgData.getGalleryPortraitImage();
            defaultImageRID = ((ChatOnResourceInterface) MainApplication.mResources).getHideMeDefaultPortraitImage();
        }
        if (bitmap == null && defaultImageRID > 0) {
            Bitmap bitmap2 = ChatONHideMeImgData.makeDefaultHideImage(defaultImageRID);
            return bitmap2;
        }
        return bitmap;
    }

    @Override // com.coolots.chaton.setting.data.ChatONSettingDataInterface
    public boolean isChanageVideoCallImage() {
        logI("isChanageVideoCallImage()" + this.mChangeDefaultImage);
        return this.mChangeDefaultImage;
    }

    @Override // com.coolots.chaton.setting.data.ChatONSettingDataInterface
    public void setChangeVideoCallImage(boolean isChanged) {
        logI("setChangeVideoCallImage()" + isChanged);
        this.mChangeDefaultImage = isChanged;
    }

    @Override // com.coolots.chaton.setting.data.ChatONSettingDataInterface
    public boolean isOwnVideo() {
        if (ModelInfoUtil.IS_MODEL_SCAMERA) {
            this.mOwnVideo = getCurrentBooleanData(this.mOwnVideo, ChatONSettingDataInterface.PREF_OWN_VIDEO_KEY, false);
        } else {
            this.mOwnVideo = getCurrentBooleanData(this.mOwnVideo, ChatONSettingDataInterface.PREF_OWN_VIDEO_KEY, true);
        }
        return this.mOwnVideo == 1;
    }

    @Override // com.coolots.chaton.setting.data.ChatONSettingDataInterface
    public void getLatestOwnVideoFromServer(Handler handler) {
        logI("getLatestOwnVideoFromServer ");
        ProfileAdaptor adaptor = new ProfileAdaptor(handler);
        adaptor.start();
    }

    @Override // com.coolots.chaton.setting.data.ChatONSettingDataInterface
    public void updateOwnVideo() {
        this.mOwnVideo = updateCurrentBooleanData(ChatONSettingDataInterface.PREF_OWN_VIDEO_KEY, true);
    }

    @Override // com.coolots.chaton.setting.data.ChatONSettingDataInterface
    public void setOwnVideo(boolean useOwnVideo, Handler handler) {
        logI("setOwnVideo(): useOwnVideo: " + useOwnVideo);
        this.mOwnVideo = setBooleanPreference(ChatONSettingDataInterface.PREF_OWN_VIDEO_KEY, useOwnVideo);
        ProfileManagerInterface manager = ((VAppPhoneManager) MainApplication.mPhoneManager).getProfileManager();
        manager.changeProfileInfo(null, null, null, null, useOwnVideo ? "Y" : "N", null, handler);
    }

    @Override // com.coolots.chaton.setting.data.ChatONSettingDataInterface
    public void setOwnVideo(boolean useOwnVideo) {
        logI("setOwnVideo(): useOwnVideo: " + useOwnVideo);
        this.mOwnVideo = setBooleanPreference(ChatONSettingDataInterface.PREF_OWN_VIDEO_KEY, useOwnVideo);
    }

    private int setBooleanPreference(String key, boolean arg) {
        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(MainApplication.mContext);
        SharedPreferences.Editor editor = pref.edit();
        editor.putBoolean(key, arg);
        if (Build.VERSION.SDK_INT < 9) {
            editor.commit();
        } else {
            editor.apply();
        }
        return arg ? 1 : 0;
    }

    private void setStringPreference(String key, String arg) {
        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(MainApplication.mContext);
        SharedPreferences.Editor editor = pref.edit();
        editor.putString(key, arg);
        if (Build.VERSION.SDK_INT < 9) {
            editor.commit();
        } else {
            editor.apply();
        }
    }

    private void setIntPreference(String key, int arg) {
        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(MainApplication.mContext);
        SharedPreferences.Editor editor = pref.edit();
        editor.putInt(key, arg);
        if (Build.VERSION.SDK_INT < 9) {
            editor.commit();
        } else {
            editor.apply();
        }
    }

    @Override // com.coolots.chaton.setting.data.ChatONSettingDataInterface
    public boolean isUseWifiOnly() {
        if (MainApplication.mPhoneManager.getPhoneStateMachine().isEntitlementWifiOnlyMode()) {
            this.mUseWifiOnly = getCurrentBooleanData(this.mUseWifiOnly, ChatONSettingDataInterface.PREF_WIFI_KEY, true);
        } else {
            this.mUseWifiOnly = getCurrentBooleanData(this.mUseWifiOnly, ChatONSettingDataInterface.PREF_WIFI_KEY, false);
        }
        return this.mUseWifiOnly == 1;
    }

    @Override // com.coolots.chaton.setting.data.ChatONSettingDataInterface
    public void setUseWifiOnly(boolean useWifiOnly) {
        if (MainApplication.mPhoneManager.getPhoneStateMachine().isEntitlementWifiOnlyMode()) {
            this.mUseWifiOnly = setBooleanPreference(ChatONSettingDataInterface.PREF_WIFI_KEY, true);
        } else {
            this.mUseWifiOnly = setBooleanPreference(ChatONSettingDataInterface.PREF_WIFI_KEY, useWifiOnly);
        }
    }

    @Override // com.coolots.chaton.setting.data.ChatONSettingDataInterface
    public void updateUseMobileNetwork() {
        if (MainApplication.mPhoneManager.getPhoneStateMachine().isEntitlementWifiOnlyMode()) {
            this.mUseWifiOnly = updateCurrentBooleanData(ChatONSettingDataInterface.PREF_WIFI_KEY, true);
        } else {
            this.mUseWifiOnly = updateCurrentBooleanData(ChatONSettingDataInterface.PREF_WIFI_KEY, false);
        }
    }

    @Override // com.coolots.chaton.setting.data.ChatONSettingDataInterface
    public boolean isUseProximity() {
        if (ModelInfoUtil.IS_MODEL_SCAMERA) {
            this.mUseProximity = getCurrentBooleanData(this.mUseProximity, ChatONSettingDataInterface.PREF_PROXIMITY_KEY, false);
        } else {
            this.mUseProximity = getCurrentBooleanData(this.mUseProximity, ChatONSettingDataInterface.PREF_PROXIMITY_KEY, true);
        }
        return this.mUseProximity == 1;
    }

    @Override // com.coolots.chaton.setting.data.ChatONSettingDataInterface
    public void setUseProximity(boolean useProximity) {
        this.mUseProximity = setBooleanPreference(ChatONSettingDataInterface.PREF_PROXIMITY_KEY, useProximity);
    }

    @Override // com.coolots.chaton.setting.data.ChatONSettingDataInterface
    public void updateUseProximity() {
        this.mUseProximity = updateCurrentBooleanData(ChatONSettingDataInterface.PREF_PROXIMITY_KEY, true);
    }

    @Override // com.coolots.chaton.setting.data.ChatONSettingDataInterface
    public boolean isUseBuddySuggestion() {
        this.mUseSuggestion = getCurrentBooleanData(this.mUseSuggestion, ChatONSettingDataInterface.PREF_SUGGESTION_KEY, false);
        return this.mUseSuggestion == 1;
    }

    @Override // com.coolots.chaton.setting.data.ChatONSettingDataInterface
    public void setBuddySuggestion(boolean useBuddySuggestion) {
        this.mUseSuggestion = setBooleanPreference(ChatONSettingDataInterface.PREF_SUGGESTION_KEY, useBuddySuggestion);
        Log.m2958e("BUDDY_TRACE setBuddySuggestion : " + useBuddySuggestion);
    }

    @Override // com.coolots.chaton.setting.data.ChatONSettingDataInterface
    public void updateBuddySuggestion() {
        this.mUseSuggestion = updateCurrentBooleanData(ChatONSettingDataInterface.PREF_SUGGESTION_KEY, false);
    }

    @Override // com.coolots.chaton.setting.data.ChatONSettingDataInterface
    public void updateUseDrivingMode() {
        this.mUseDrivingMode = updateCurrentBooleanData(ChatONSettingDataInterface.PREF_DRIVING_MODE_KEY, true);
    }

    @Override // com.coolots.chaton.setting.data.ChatONSettingDataInterface
    public boolean isUseExcludeMe() {
        this.mUseExcludeMe = getCurrentBooleanData(this.mUseExcludeMe, ChatONSettingDataInterface.PREF_EXCLUDE_ME_KEY, false);
        return this.mUseExcludeMe == 1;
    }

    @Override // com.coolots.chaton.setting.data.ChatONSettingDataInterface
    public void setExcludeMe(boolean useExcludeMe) {
        this.mUseExcludeMe = setBooleanPreference(ChatONSettingDataInterface.PREF_EXCLUDE_ME_KEY, useExcludeMe);
        Log.m2958e("BUDDY_TRACE setExcludeMe : " + useExcludeMe);
    }

    @Override // com.coolots.chaton.setting.data.ChatONSettingDataInterface
    public void updateExcludeMe() {
        this.mUseExcludeMe = updateCurrentBooleanData(ChatONSettingDataInterface.PREF_EXCLUDE_ME_KEY, false);
    }

    @Override // com.coolots.chaton.setting.data.ChatONSettingDataInterface
    public boolean isOnPrivacy() {
        this.mUsePrivacy = getCurrentBooleanData(this.mUsePrivacy, ChatONSettingDataInterface.PREF_PHONE_NUM_PRIVACY_KEY, false);
        return this.mUsePrivacy == 1;
    }

    @Override // com.coolots.chaton.setting.data.ChatONSettingDataInterface
    public void setOnPrivacy(boolean usePrivacy) {
        this.mUsePrivacy = setBooleanPreference(ChatONSettingDataInterface.PREF_PHONE_NUM_PRIVACY_KEY, usePrivacy);
    }

    @Override // com.coolots.chaton.setting.data.ChatONSettingDataInterface
    public void updatePrivacy() {
        this.mUsePrivacy = updateCurrentBooleanData(ChatONSettingDataInterface.PREF_PHONE_NUM_PRIVACY_KEY, false);
    }

    @Override // com.coolots.chaton.setting.data.ChatONSettingDataInterface
    public boolean isUseCallAnswerHomeKey() {
        this.mCallAnswerHomeKey = getCurrentBooleanData(this.mCallAnswerHomeKey, ChatONSettingDataInterface.PREF_CALL_ANSWER_HOME_KEY, false);
        return this.mCallAnswerHomeKey == 1;
    }

    @Override // com.coolots.chaton.setting.data.ChatONSettingDataInterface
    public void updateCallAnswerHomeKey() {
        this.mCallAnswerHomeKey = updateCurrentBooleanData(ChatONSettingDataInterface.PREF_CALL_ANSWER_HOME_KEY, false);
        if (this.mCallAnswerHomeKeyChangeHandler != null) {
            this.mCallAnswerHomeKeyChangeHandler.sendEmptyMessage(this.mCallAnswerHomeKey);
        }
    }

    @Override // com.coolots.chaton.setting.data.ChatONSettingDataInterface
    public void registCallAnswerHomeKeyHandler(Handler handler) {
        this.mCallAnswerHomeKeyChangeHandler = handler;
    }

    @Override // com.coolots.chaton.setting.data.ChatONSettingDataInterface
    public void setCallAnswerHomeKey(boolean useHomeKeyOption) {
        this.mCallAnswerHomeKey = setBooleanPreference(ChatONSettingDataInterface.PREF_CALL_ANSWER_HOME_KEY, useHomeKeyOption);
    }

    @Override // com.coolots.chaton.setting.data.ChatONSettingDataInterface
    public boolean isUseCallEndPowerKey() {
        this.mCallEndPowerKey = getCurrentBooleanData(this.mCallEndPowerKey, ChatONSettingDataInterface.PREF_CALL_END_POWER_KEY, false);
        return this.mCallEndPowerKey == 1;
    }

    @Override // com.coolots.chaton.setting.data.ChatONSettingDataInterface
    public void updateCallEndPowerKey() {
        this.mCallEndPowerKey = updateCurrentBooleanData(ChatONSettingDataInterface.PREF_CALL_END_POWER_KEY, false);
        if (this.mCallEndPowerKeyChangeHandler != null) {
            this.mCallEndPowerKeyChangeHandler.sendEmptyMessage(this.mCallEndPowerKey);
        }
    }

    @Override // com.coolots.chaton.setting.data.ChatONSettingDataInterface
    public void registCallEndPowerKeyHandler(Handler handler) {
        this.mCallEndPowerKeyChangeHandler = handler;
    }

    @Override // com.coolots.chaton.setting.data.ChatONSettingDataInterface
    public void setCallEndPowerKey(boolean usePowerKeyOption) {
        this.mCallEndPowerKey = setBooleanPreference(ChatONSettingDataInterface.PREF_CALL_END_POWER_KEY, usePowerKeyOption);
    }

    @Override // com.coolots.chaton.setting.data.ChatONSettingDataInterface
    public boolean isContactSyncNow() {
        this.mContactSyncNow = getCurrentBooleanData(this.mContactSyncNow, ChatONSettingDataInterface.PREF_CONTACT_SYNC_NOW_KEY, false);
        return this.mContactSyncNow == 1;
    }

    @Override // com.coolots.chaton.setting.data.ChatONSettingDataInterface
    public void updateContactSyncNow() {
        this.mContactSyncNow = updateCurrentBooleanData(ChatONSettingDataInterface.PREF_CONTACT_SYNC_NOW_KEY, false);
    }

    @Override // com.coolots.chaton.setting.data.ChatONSettingDataInterface
    public void setContactSyncNow(boolean syncNow) {
        this.mContactSyncNow = setBooleanPreference(ChatONSettingDataInterface.PREF_CONTACT_SYNC_NOW_KEY, syncNow);
    }

    @Override // com.coolots.chaton.setting.data.ChatONSettingDataInterface
    public boolean isAutoSyncPopupShow() {
        this.mAutoSyncPopupShow = getCurrentBooleanData(this.mAutoSyncPopupShow, ChatONSettingDataInterface.PREF_AUTO_SYNC_POPUP_SHOW, true);
        return this.mAutoSyncPopupShow == 1;
    }

    @Override // com.coolots.chaton.setting.data.ChatONSettingDataInterface
    public void updateAutoSyncPopupShow() {
        this.mAutoSyncPopupShow = updateCurrentBooleanData(ChatONSettingDataInterface.PREF_AUTO_SYNC_POPUP_SHOW, true);
    }

    @Override // com.coolots.chaton.setting.data.ChatONSettingDataInterface
    public void setAutoSyncPopupShow(boolean isShow) {
        this.mAutoSyncPopupShow = setBooleanPreference(ChatONSettingDataInterface.PREF_AUTO_SYNC_POPUP_SHOW, isShow);
    }

    @Override // com.coolots.chaton.setting.data.ChatONSettingDataInterface
    public void updateVideoCallQuality() {
        this.mUseHighQuality = updateCurrentBooleanData(ChatONSettingDataInterface.PREF_VIDEO_CALL_QUALITY_KEY, false);
    }

    @Override // com.coolots.chaton.setting.data.ChatONSettingDataInterface
    public boolean isUseHighQuality() {
        this.mUseHighQuality = getCurrentBooleanData(this.mUseHighQuality, ChatONSettingDataInterface.PREF_VIDEO_CALL_QUALITY_KEY, false);
        return this.mUseHighQuality == 1;
    }

    @Override // com.coolots.chaton.setting.data.ChatONSettingDataInterface
    public void setVideoCallQuality(boolean isUseHighQuality) {
        this.mUseHighQuality = setBooleanPreference(ChatONSettingDataInterface.PREF_VIDEO_CALL_QUALITY_KEY, isUseHighQuality);
    }

    @Override // com.coolots.chaton.setting.data.ChatONSettingDataInterface
    public void setRingtoneData(int type, int index, String path) {
        RingtoneInfo info = new RingtoneInfo(type, index, path);
        setStringPreference(ChatONSettingDataInterface.PREF_RINGTONE_KEY, info.getValue("2"));
    }

    @Override // com.coolots.chaton.setting.data.ChatONSettingDataInterface
    public String getRingtoneData() {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(MainApplication.mContext);
        return sharedPreferences.getString(ChatONSettingDataInterface.PREF_RINGTONE_KEY, "2");
    }

    @Override // com.coolots.chaton.setting.data.ChatONSettingDataInterface
    public int getCycleDayPref() {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(MainApplication.mContext);
        if (sharedPreferences == null) {
            return -1;
        }
        int CycleDay = sharedPreferences.getInt(PREF_CYCLE_DAY, 1);
        return CycleDay;
    }

    @Override // com.coolots.chaton.setting.data.ChatONSettingDataInterface
    public void setCycleDayPref(int cycleDay) {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(MainApplication.mContext);
        if (sharedPreferences != null) {
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putInt(PREF_CYCLE_DAY, cycleDay);
            if (Build.VERSION.SDK_INT < 9) {
                editor.commit();
            } else {
                editor.apply();
            }
        }
    }

    private int getCurrentBooleanData(int data, String key, boolean defaultVal) {
        int retV = data;
        if (retV == -1) {
            retV = updateCurrentBooleanData(key, defaultVal);
        }
        logI("getCurrentBooleanData(): " + key + " " + retV);
        return retV;
    }

    private int updateCurrentBooleanData(String key, boolean defaultVal) {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(MainApplication.mContext);
        boolean value = sharedPreferences.getBoolean(key, defaultVal);
        logI("updateCurrentBooleanData() >> " + key + ": " + value);
        return value ? 1 : 0;
    }

    private String getCurrentStringData(String data, String key, String defaultVal) {
        String retV = data;
        if (retV == null) {
            retV = updateCurrentStringData(key, defaultVal);
        }
        logI("getCurrentStringData(): " + key + " " + retV);
        return retV;
    }

    private String updateCurrentStringData(String key, String defaultVal) {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(MainApplication.mContext);
        String value = sharedPreferences.getString(key, defaultVal);
        logI("updateCurrentStringData() >> " + key + ": " + value);
        return value;
    }

    private int getCurrentIntData(int data, String key, int defaultVal) {
        int retV = data;
        if (retV == -1) {
            retV = updateCurrentIntData(key, defaultVal);
        }
        logI("getCurrentIntData(): " + key + " " + retV);
        return retV;
    }

    private int updateCurrentIntData(String key, int defaultVal) {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(MainApplication.mContext);
        int value = sharedPreferences.getInt(key, defaultVal);
        logI("updateCurrentIntData() >> " + key + ": " + value);
        return value;
    }

    @Override // com.coolots.chaton.setting.data.ChatONSettingDataInterface
    public boolean isUseDrivingMode() {
        if (ModelInfoUtil.IS_MODEL_SCAMERA) {
            this.mUseDrivingMode = getCurrentBooleanData(this.mUseDrivingMode, ChatONSettingDataInterface.PREF_DRIVING_MODE_KEY, false);
        } else {
            this.mUseDrivingMode = getCurrentBooleanData(this.mUseDrivingMode, ChatONSettingDataInterface.PREF_DRIVING_MODE_KEY, true);
        }
        return this.mUseDrivingMode == 1;
    }

    @Override // com.coolots.chaton.setting.data.ChatONSettingDataInterface
    public void setUseDrivingMode(boolean useDrivingMode) {
        this.mUseDrivingMode = setBooleanPreference(ChatONSettingDataInterface.PREF_DRIVING_MODE_KEY, useDrivingMode);
    }

    @Override // com.coolots.chaton.setting.data.ChatONSettingDataInterface
    public boolean getVibrateWhenRinging() {
        this.mVibrateWhenRinging = getCurrentBooleanData(this.mVibrateWhenRinging, ChatONSettingDataInterface.PREF_VIBRATE_WHEN_RINGING, false);
        return this.mVibrateWhenRinging == 1;
    }

    @Override // com.coolots.chaton.setting.data.ChatONSettingDataInterface
    public void setVibrateWhenRinging(boolean checked) {
        this.mVibrateWhenRinging = setBooleanPreference(ChatONSettingDataInterface.PREF_VIBRATE_WHEN_RINGING, checked);
    }

    @Override // com.coolots.chaton.setting.data.ChatONSettingDataInterface
    public void updateVibrateWhenRinging() {
        this.mVibrateWhenRinging = updateCurrentBooleanData(ChatONSettingDataInterface.PREF_VIBRATE_WHEN_RINGING, false);
    }

    @Override // com.coolots.chaton.setting.data.ChatONSettingDataInterface, com.sds.coolots.common.coolotsinterface.SettingDataInterface
    public boolean getCallAnswerVibration() {
        this.mCallAnswerVibration = getCurrentBooleanData(this.mCallAnswerVibration, ChatONSettingDataInterface.PREF_ANSWER_VIBRATION, false);
        return this.mCallAnswerVibration == 1;
    }

    @Override // com.coolots.chaton.setting.data.ChatONSettingDataInterface
    public void setCallAnswerVibration(boolean checked) {
        this.mCallAnswerVibration = setBooleanPreference(ChatONSettingDataInterface.PREF_ANSWER_VIBRATION, checked);
    }

    @Override // com.coolots.chaton.setting.data.ChatONSettingDataInterface
    public void updateCallAnswerVibration() {
        this.mCallAnswerVibration = updateCurrentBooleanData(ChatONSettingDataInterface.PREF_ANSWER_VIBRATION, false);
    }

    @Override // com.coolots.chaton.setting.data.ChatONSettingDataInterface, com.sds.coolots.common.coolotsinterface.SettingDataInterface
    public boolean getCallEndVibration() {
        this.mCallEndVibration = getCurrentBooleanData(this.mCallEndVibration, ChatONSettingDataInterface.PREF_CALL_END_VIBRATION, false);
        return this.mCallEndVibration == 1;
    }

    @Override // com.coolots.chaton.setting.data.ChatONSettingDataInterface
    public void setCallEndVibration(boolean checked) {
        this.mCallEndVibration = setBooleanPreference(ChatONSettingDataInterface.PREF_CALL_END_VIBRATION, checked);
    }

    @Override // com.coolots.chaton.setting.data.ChatONSettingDataInterface
    public void updateCallEndVibration() {
        this.mCallEndVibration = updateCurrentBooleanData(ChatONSettingDataInterface.PREF_CALL_END_VIBRATION, false);
    }

    @Override // com.coolots.chaton.setting.data.ChatONSettingDataInterface, com.sds.coolots.common.coolotsinterface.SettingDataInterface
    public boolean getCallConnectTone() {
        this.mCallConnectTone = getCurrentBooleanData(this.mCallConnectTone, ChatONSettingDataInterface.PREF_CALL_CONNECT_TONE, true);
        return this.mCallConnectTone == 1;
    }

    @Override // com.coolots.chaton.setting.data.ChatONSettingDataInterface
    public void setCallConnectTone(boolean checked) {
        this.mCallConnectTone = setBooleanPreference(ChatONSettingDataInterface.PREF_CALL_CONNECT_TONE, checked);
    }

    @Override // com.coolots.chaton.setting.data.ChatONSettingDataInterface
    public void updateCallConnectTone() {
        this.mCallConnectTone = updateCurrentBooleanData(ChatONSettingDataInterface.PREF_CALL_CONNECT_TONE, true);
    }

    @Override // com.coolots.chaton.setting.data.ChatONSettingDataInterface, com.sds.coolots.common.coolotsinterface.SettingDataInterface
    public boolean getMinuteMinder() {
        this.mMinuteMinder = getCurrentBooleanData(this.mMinuteMinder, ChatONSettingDataInterface.PREF_MINUTE_MINDER, false);
        return this.mMinuteMinder == 1;
    }

    @Override // com.coolots.chaton.setting.data.ChatONSettingDataInterface
    public void setMinuteMinder(boolean checked) {
        this.mMinuteMinder = setBooleanPreference(ChatONSettingDataInterface.PREF_MINUTE_MINDER, checked);
    }

    @Override // com.coolots.chaton.setting.data.ChatONSettingDataInterface
    public void updateMinuteMinder() {
        this.mMinuteMinder = updateCurrentBooleanData(ChatONSettingDataInterface.PREF_MINUTE_MINDER, false);
    }

    @Override // com.coolots.chaton.setting.data.ChatONSettingDataInterface, com.sds.coolots.common.coolotsinterface.SettingDataInterface
    public boolean getCallEndTone() {
        this.mCallEndTone = getCurrentBooleanData(this.mCallEndTone, ChatONSettingDataInterface.PREF_CALL_END_TONE, true);
        return this.mCallEndTone == 1;
    }

    @Override // com.coolots.chaton.setting.data.ChatONSettingDataInterface
    public void setCallEndTone(boolean checked) {
        this.mCallEndTone = setBooleanPreference(ChatONSettingDataInterface.PREF_CALL_END_TONE, checked);
    }

    @Override // com.coolots.chaton.setting.data.ChatONSettingDataInterface
    public void updateCallEndTone() {
        this.mCallEndTone = updateCurrentBooleanData(ChatONSettingDataInterface.PREF_CALL_END_TONE, true);
    }

    @Override // com.coolots.chaton.setting.data.ChatONSettingDataInterface, com.sds.coolots.common.coolotsinterface.SettingDataInterface
    public boolean isLogON() {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(MainApplication.mContext);
        boolean value = sharedPreferences.getBoolean(ChatONSettingDataInterface.PREF_LOG_IS_ON_KEY, false);
        logI("isLogON(): " + value);
        return value;
    }

    @Override // com.coolots.chaton.setting.data.ChatONSettingDataInterface
    public void setIsLogON(Context context, boolean value) {
        logI("setIsLogON(" + value + ")");
        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = pref.edit();
        editor.putBoolean(ChatONSettingDataInterface.PREF_LOG_IS_ON_KEY, value);
        if (Build.VERSION.SDK_INT < 9) {
            editor.commit();
        } else {
            editor.apply();
        }
        MainApplication.mPhoneManager.setLogLevelWithServerType();
        MainApplication.mPhoneManager.setEngineLogLevelWithServerType();
    }
}
