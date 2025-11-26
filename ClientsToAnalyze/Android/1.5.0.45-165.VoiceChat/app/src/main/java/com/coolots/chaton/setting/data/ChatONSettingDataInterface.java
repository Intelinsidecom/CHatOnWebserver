package com.coolots.chaton.setting.data;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import com.sds.coolots.common.coolotsinterface.SettingDataInterface;

/* loaded from: classes.dex */
public interface ChatONSettingDataInterface extends SettingDataInterface {
    public static final int ATNT_POPUP_NO = 2;
    public static final int ATNT_POPUP_YES = 1;
    public static final String PREF_ALERTS_ON_CALL_KEY = "pref_call_alerts_alerts_on_calls_key";
    public static final String PREF_ALL_VIDEO_KEY = "pref_data_usage_all_video_key";
    public static final String PREF_ALL_VOICE_KEY = "pref_data_usage_all_voice_key";
    public static final String PREF_ANSWER_VIBRATION = "pref_anwer_vibration_key";
    public static final String PREF_ATNT_POPUP_CHECK = "pref_atnt_popup_check";
    public static final String PREF_ATNT_POPUP_CHOICE = "pref_atnt_popup_choice";
    public static final String PREF_AUTO_SYNC_POPUP_SHOW = "pref_auto_popup_show_key";
    public static final String PREF_CALL_ANSWER_HOME_KEY = "pref_call_answer_home_key";
    public static final String PREF_CALL_CONNECT_TONE = "pref_call_connect_tone_key";
    public static final String PREF_CALL_END_POWER_KEY = "pref_call_end_power_key";
    public static final String PREF_CALL_END_TONE = "pref_call_end_tone_key";
    public static final String PREF_CALL_END_VIBRATION = "pref_call_end_vibration_key";
    public static final String PREF_CALL_STATUS_TONES_KEY = "pref_call_alerts_tones_key";
    public static final String PREF_CALL_STATUS_VIB_KEY = "pref_call_alerts_vibrations_key";
    public static final String PREF_CONTACT_SYNC_NOW_KEY = "pref_contact_sync_now_key";
    public static final String PREF_DATA_USAGE_KEY = "pref_data_usage_key";
    public static final String PREF_DIAL_VIDEO_KEY = "pref_data_usage_dial_video_key";
    public static final String PREF_DIAL_VOICE_KEY = "pref_data_usage_dial_voice_key";
    public static final String PREF_DRIVING_MODE_KEY = "pref_driving_mode_key";
    public static final String PREF_EXCLUDE_ME_KEY = "pref_exclude_me_key";
    public static final String PREF_LAST_VIDEO_KEY = "pref_data_usage_last_video_key";
    public static final String PREF_LAST_VOICE_KEY = "pref_data_usage_last_voice_key";
    public static final String PREF_LATEST_VERSION_KEY = "pref_latest_version_key";
    public static final String PREF_LOG_IS_ON_KEY = "pref_log_is_on_key";
    public static final String PREF_MINUTE_MINDER = "pref_minute_minder_key";
    public static final String PREF_OWN_VIDEO_KEY = "pref_own_video_key";
    public static final String PREF_PHONE_NUM_PRIVACY_KEY = "pref_phone_num_privacy_key";
    public static final String PREF_PROXIMITY_KEY = "pref_proximity_key";
    public static final String PREF_RECEIVE_VIDEO_KEY = "pref_data_usage_receive_video_key";
    public static final String PREF_RECEIVE_VOICE_KEY = "pref_data_usage_receive_voice_key";
    public static final String PREF_RINGTONE_KEY = "pref_ringtone_key";
    public static final String PREF_SUGGESTION_KEY = "pref_buddy_suggestions_key";
    public static final String PREF_VERSION_KEY = "pref_version_key";
    public static final String PREF_VIBRATE_WHEN_RINGING = "pref_vibrate_when_ringing_key";
    public static final String PREF_VIDEO_CALL_QUALITY_KEY = "pref_video_call_quality_key";
    public static final String PREF_WIFI_KEY = "pref_wifi_key";

    @Override // com.sds.coolots.common.coolotsinterface.SettingDataInterface
    boolean getCallAnswerVibration();

    @Override // com.sds.coolots.common.coolotsinterface.SettingDataInterface
    boolean getCallConnectTone();

    @Override // com.sds.coolots.common.coolotsinterface.SettingDataInterface
    boolean getCallEndTone();

    @Override // com.sds.coolots.common.coolotsinterface.SettingDataInterface
    boolean getCallEndVibration();

    int getCycleDayPref();

    String getLastVersionName();

    void getLatestOwnVideoFromServer(Handler handler);

    @Override // com.sds.coolots.common.coolotsinterface.SettingDataInterface
    boolean getMinuteMinder();

    String getRingtoneData();

    int getValue(String str, int i);

    boolean getVibrateWhenRinging();

    Bitmap getVideoCallImage(boolean z, boolean z2);

    boolean isAlertsOnCall();

    boolean isAutoSyncPopupShow();

    boolean isChanageVideoCallImage();

    boolean isChecked(String str);

    boolean isContactSyncNow();

    @Override // com.sds.coolots.common.coolotsinterface.SettingDataInterface
    boolean isLogON();

    boolean isOnPrivacy();

    boolean isOwnVideo();

    boolean isUseBuddySuggestion();

    boolean isUseCallAnswerHomeKey();

    boolean isUseCallEndPowerKey();

    boolean isUseDrivingMode();

    boolean isUseExcludeMe();

    boolean isUseHighQuality();

    boolean isUseProximity();

    boolean isUseWifiOnly();

    void registAlertsOnCallHandler(Handler handler);

    void registCallAnswerHomeKeyHandler(Handler handler);

    void registCallEndPowerKeyHandler(Handler handler);

    void setAutoSyncPopupShow(boolean z);

    void setBuddySuggestion(boolean z);

    void setCallAnswerHomeKey(boolean z);

    void setCallAnswerVibration(boolean z);

    void setCallConnectTone(boolean z);

    void setCallEndPowerKey(boolean z);

    void setCallEndTone(boolean z);

    void setCallEndVibration(boolean z);

    void setChangeVideoCallImage(boolean z);

    void setChecked(String str, boolean z);

    void setContactSyncNow(boolean z);

    void setCycleDayPref(int i);

    void setExcludeMe(boolean z);

    void setIsLogON(Context context, boolean z);

    void setLastVersionName(String str);

    void setMinuteMinder(boolean z);

    void setOnPrivacy(boolean z);

    void setOwnVideo(boolean z);

    void setOwnVideo(boolean z, Handler handler);

    void setRingtoneData(int i, int i2, String str);

    void setUseDrivingMode(boolean z);

    void setUseProximity(boolean z);

    void setUseWifiOnly(boolean z);

    void setValue(String str, int i);

    void setVibrateWhenRinging(boolean z);

    void setVideoCallQuality(boolean z);

    void updateAlertsOnCall();

    void updateAutoSyncPopupShow();

    void updateBuddySuggestion();

    void updateCallAnswerHomeKey();

    void updateCallAnswerVibration();

    void updateCallConnectTone();

    void updateCallEndPowerKey();

    void updateCallEndTone();

    void updateCallEndVibration();

    void updateContactSyncNow();

    void updateExcludeMe();

    void updateMinuteMinder();

    void updateOwnVideo();

    void updatePrivacy();

    void updateUseDrivingMode();

    void updateUseMobileNetwork();

    void updateUseProximity();

    void updateVibrateWhenRinging();

    void updateVideoCallQuality();
}
