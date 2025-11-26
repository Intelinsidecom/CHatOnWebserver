package com.coolots.chaton.common.view;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.preference.PreferenceManager;
import com.coolots.p2pmsg.model.ProfileInfo;
import com.sds.coolots.MainApplication;
import com.sds.coolots.common.util.FileUtil;
import com.sds.coolots.common.util.Log;
import java.util.Date;

/* loaded from: classes.dex */
public class ConfigActivity {
    private static final String CLASSNAME = "[ConfigActivity]";
    public static final String CLIENT_VERSION = "1.1.21";
    private static final String PREFNAME = "coolots_pref";
    private static final String PREF_COOLOTS_CALL_STATE = "pref_profile_coolots_call_state";
    private static final String PREF_KEY_ASSET_VERSION = "pref_asset_version";
    private static final String PREF_KEY_AUTO_BUDDY_OPTION = "pref_auto_buddy_option";
    private static final String PREF_KEY_BUDDY_UPDATE_DATE = "pref_buddy_update_date";
    private static final String PREF_KEY_BUDDY_UPDATE_NEEDED = "pref_buddy_update_needed";
    private static final String PREF_KEY_BUDDY_UPDATE_NEEDED_SUGGESTION = "pref_buddy_update_needed_suggestion";
    private static final String PREF_KEY_CALL_SEND_INTERVAL = "pref_call_send_interval";
    private static final String PREF_KEY_CHATON_NO = "pref_profile_chaton_no";
    private static final String PREF_KEY_CHATON_UID = "pref_profile_chaton_uid";
    private static final String PREF_KEY_CHATON_VIDEO_CONF_MAX_NUM = "pref_chaton_video_conf_max_num";
    private static final String PREF_KEY_CHATON_VOICE_CONF_MAX_NUM = "pref_chaton_voice_conf_max_num";
    private static final String PREF_KEY_CHECK_CHAGE_ALERT = "pref_check_charge_alert";
    private static final String PREF_KEY_CHECK_REMOTE_UPDATE = "pref_check_remote_update";
    private static final String PREF_KEY_NATIVE_CONTACT_CHANGED = "pref_native_contact_changed";
    private static final String PREF_KEY_PROFILE_IMG_UPDATE_DATE = "pref_profile_img_update_date";
    private static final String PREF_KEY_PROFILE_UPDATE_DATE = "pref_profile_update_date";
    private static final String PREF_KEY_SHARE_SCREEN_CHANGE_VOICE = "pref_share_screen_change_voice";
    private static final String PREF_KEY_SHARE_SCREEN_COPYRIGHT = "pref_share_screen_copyright";
    private static final String PREF_KEY_SMS_AUTH_COUNTRY = "pref_sms_auth_country";
    private static final String PREF_KEY_SMS_AUTH_NO = "pref_sms_auth_no";
    private static final String PREF_KEY_USERNO = "PREF_KEY_USERNO";
    private static final String PREF_KEY_VALID_DEVICE = "pref_valid_defice";
    private static final String PREF_KEY_VERSION_UPDATE_DATE = "pref_version_update_date";
    private static final String PREF_KEY_VIDEOCALL_IMG_UPDATE_DATE = "pref_videocall_img_update_date";
    public static final String PREF_NATIONAL_CODE_VERSION = "pref_national_code_version";
    public static final String PREF_PROFILE_AUTH_ID = "pref_profile_auth_id";
    public static final String PREF_PROFILE_COUNTRY_CODE = "pref_profile_country_code";
    public static final String PREF_PROFILE_DEVICE_ID = "pref_profile_device_id";
    public static final String PREF_PROFILE_IMAGE_URL = "pref_profile_image_url";
    public static final String PREF_PROFILE_NATIONAL_CODE = "pref_profile_national_code";
    public static final String PREF_PROFILE_NICK_NAME = "pref_profile_nick_name";
    public static final String PREF_PROFILE_PWD = "pref_profile_passwd";
    public static final String PREF_PROFILE_RAW_PWD = "pref_profile_raw_pwd";
    public static final String PREF_PROFILE_RAW_PWD_CHK = "pref_profile_raw_pwd_check";
    public static final String PREF_PROFILE_SAMSUNG_ACCOUNT_ACCESS_TOKEN = "pref_profile_samsung_account_access_token";
    public static final String PREF_PROFILE_SAMSUNG_ACCOUNT_BIRTHDAY = "pref_profile_samsung_account_birthday";
    public static final String PREF_PROFILE_SAMSUNG_ACCOUNT_CLIENTID = "pref_profile_samsung_account_clientid";
    public static final String PREF_PROFILE_SAMSUNG_ACCOUNT_COUNTRY = "pref_profile_samsung_account_country";
    public static final String PREF_PROFILE_SAMSUNG_ACCOUNT_ID = "pref_profile_samsung_account_id";
    public static final String PREF_PROFILE_SAMSUNG_ACCOUNT_NO = "pref_profile_samsung_account_no";
    public static final String PREF_PROFILE_SAMSUNG_ACCOUNT_SECRETKEY = "pref_profile_samsung_account_secretkey";
    public static final String PREF_PROFILE_SERIAL_NO = "pref_profile_serial_no";
    public static final String PREF_PROFILE_USER_EMAIL = "pref_profile_user_email";
    public static final String PREF_PROFILE_USER_ID = "pref_profile_userid";
    public static final String PREF_PROFILE_USER_NAME = "pref_profile_user_name";
    private static final String PREF_SAMSUNG_ACCOUNT_AUTHCODE = "pref_profile_samsung_account_authcode";
    private static final String PREF_SAMSUNG_ACCOUNT_GUID = "pref_profile_samsung_account_guid";
    private static final String PREF_SAMSUNG_ACCOUNT_NAME = "pref_profile_samsung_account_name";
    private static final String PREF_SIP_ID_SEND_ONLY = "pref_profile_sip_id_send_only";
    private final ProfileInfo profileInfo = new ProfileInfo();
    private static Context mContext = null;
    private static Boolean bSDCardWritable = null;

    private void logE(String message) {
        Log.m2958e(CLASSNAME + message);
    }

    private void logI(String message) {
        Log.m2963i(CLASSNAME + message);
    }

    private static String getStringPreference(String key, String def) {
        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(MainApplication.mContext);
        return (pref.getString(key, def) == null || pref.getString(key, def).length() == 0) ? def : pref.getString(key, def);
    }

    private static String getStringPreference(String key, String def, Context context) {
        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(context);
        return (pref.getString(key, def) == null || pref.getString(key, def).length() == 0) ? def : pref.getString(key, def);
    }

    private static void setStringPreference(String key, String arg) {
        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(MainApplication.mContext);
        SharedPreferences.Editor editor = pref.edit();
        editor.putString(key, arg);
        if (Build.VERSION.SDK_INT < 9) {
            editor.commit();
        } else {
            editor.apply();
        }
    }

    private static boolean getBooleanPreference(String key, boolean def) {
        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(MainApplication.mContext);
        return pref.getBoolean(key, def);
    }

    private static void setBooleanPreference(String key, boolean arg) {
        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(MainApplication.mContext);
        SharedPreferences.Editor editor = pref.edit();
        editor.putBoolean(key, arg);
        if (Build.VERSION.SDK_INT < 9) {
            editor.commit();
        } else {
            editor.apply();
        }
    }

    private static int getIntPreference(String key, int def) {
        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(MainApplication.mContext);
        return pref.getInt(key, def);
    }

    private static void setIntPreference(String key, int val) {
        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(MainApplication.mContext);
        SharedPreferences.Editor editor = pref.edit();
        editor.putInt(key, val);
        if (Build.VERSION.SDK_INT < 9) {
            editor.commit();
        } else {
            editor.apply();
        }
    }

    public static void setProfileCountryCode(Integer strValue) {
        if (strValue != null) {
            setStringPreference("pref_profile_country_code", strValue.toString());
        }
    }

    public static void setProfileNationalCode(String strValue) {
        if (strValue != null) {
            setStringPreference("pref_profile_national_code", strValue);
        }
    }

    public static Integer getProfileCountryCode() {
        return Integer.valueOf(Integer.parseInt(getStringPreference("pref_profile_country_code", "82")));
    }

    public static String getProfileNationalCode() {
        return getStringPreference("pref_profile_national_code", "2");
    }

    public static void setProfileUserName(String strValue) {
        if (strValue != null) {
            if (strValue.length() > 30) {
                Log.m2958e("<<RDJ>> original username=" + strValue + "(" + strValue.length() + ")");
                String tempUserName = strValue.substring(0, 27);
                strValue = String.valueOf(tempUserName) + "...";
                Log.m2958e("<<RDJ>> 30digits username=" + strValue + "(" + strValue.length() + ")");
            }
            setStringPreference("pref_profile_user_name", strValue);
        }
    }

    public static String getProfileImageUrl() {
        return getStringPreference("pref_profile_image_url", "");
    }

    public static void setProfileImageUrl(String strValue) {
    }

    public static void setProfileUserEmail(String strValue) {
        if (strValue != null) {
            setStringPreference("pref_profile_user_email", strValue);
        }
    }

    public static String getProfileUserEmail() {
        return getStringPreference("pref_profile_user_email", "");
    }

    public static String getProfileUserName() {
        return getStringPreference("pref_profile_user_name", "");
    }

    public static String getProfileNickName() {
        return getStringPreference("pref_profile_nick_name", "");
    }

    public static void setProfileNickName(String strValue) {
        setStringPreference("pref_profile_nick_name", strValue);
    }

    public static void setProfileUserID(String strValue) {
        setStringPreference("pref_profile_userid", strValue);
    }

    public static String getProfileUserID() {
        return getStringPreference("pref_profile_userid", "");
    }

    public static String getProfileUserID(Context context) {
        return getStringPreference("pref_profile_userid", "", context);
    }

    public static void setSamsungAccountCountryCode(String strValue) {
        setStringPreference(PREF_PROFILE_SAMSUNG_ACCOUNT_COUNTRY, strValue);
    }

    public static String getSamsungAccountCountryCode() {
        return getStringPreference(PREF_PROFILE_SAMSUNG_ACCOUNT_COUNTRY, "");
    }

    public static void setSamsungAccountBirthDay(String strValue) {
        setStringPreference(PREF_PROFILE_SAMSUNG_ACCOUNT_BIRTHDAY, strValue);
    }

    public static String getSamsungAccountBirthDay() {
        return getStringPreference(PREF_PROFILE_SAMSUNG_ACCOUNT_BIRTHDAY, "");
    }

    public static void setSamsungAccountID(String strValue) {
        setStringPreference("pref_profile_samsung_account_id", strValue);
    }

    public static String getSamsungAccountID() {
        return getStringPreference("pref_profile_samsung_account_id", "");
    }

    public static void setSamsungAccountAuthCode(String strValue) {
        setStringPreference(PREF_SAMSUNG_ACCOUNT_AUTHCODE, strValue);
    }

    public static String getSamsungAccountAuthCode() {
        return getStringPreference(PREF_SAMSUNG_ACCOUNT_AUTHCODE, "");
    }

    public static void setSamsungAccountGUID(String strValue) {
        setStringPreference(PREF_SAMSUNG_ACCOUNT_GUID, strValue);
    }

    public static void setSamsungAccountAccessToken(String strValue) {
        setStringPreference(PREF_PROFILE_SAMSUNG_ACCOUNT_ACCESS_TOKEN, strValue);
    }

    public static String getSamsungAccountAccessToken() {
        return getStringPreference(PREF_PROFILE_SAMSUNG_ACCOUNT_ACCESS_TOKEN, "");
    }

    public static String getSamsungAccountGUID() {
        return getStringPreference(PREF_SAMSUNG_ACCOUNT_GUID, "");
    }

    public static void setSamsungAccountClient_id(String strValue) {
        setStringPreference("pref_profile_samsung_account_clientid", strValue);
    }

    public static String getSamsungAccountClient_id() {
        return getStringPreference("pref_profile_samsung_account_clientid", "");
    }

    public static void setSamsungAccountSecret_key(String strValue) {
        setStringPreference("pref_profile_samsung_account_secretkey", strValue);
    }

    public static String getSamsungAccountSecret_key() {
        return getStringPreference("pref_profile_samsung_account_secretkey", "");
    }

    public static void setProfileSerialNo(String strValue) {
        if (strValue != null) {
            setStringPreference("pref_profile_serial_no", strValue);
        }
    }

    public static String getProfileSerialNo() {
        return getStringPreference("pref_profile_serial_no", "");
    }

    public static void setProfileDeviceID(Short shortValue) {
        if (shortValue.toString().length() != 0) {
            setStringPreference("pref_profile_device_id", shortValue.toString());
        }
    }

    public static void setProfilePasswd(String strValue) {
        setStringPreference("pref_profile_passwd", strValue);
    }

    public static String getProfilePasswd() {
        return getStringPreference("pref_profile_passwd", "");
    }

    public static void setProfileRawPwd(String strValue) {
        if (strValue != null) {
            setStringPreference("pref_profile_raw_pwd", strValue);
        }
    }

    public static String getProfileRawPwd() {
        return getStringPreference("pref_profile_raw_pwd", "");
    }

    public static void setProfileRawPwdCheck(boolean strValue) {
        setBooleanPreference("pref_profile_raw_pwd_check", strValue);
    }

    public static boolean isProfileRawPwdCheck() {
        return getBooleanPreference("pref_profile_raw_pwd_check", false);
    }

    public static Short getProfileDeviceID() {
        if (getStringPreference("pref_profile_device_id", "") == null || getStringPreference("pref_profile_device_id", "").length() == 0) {
            return null;
        }
        return Short.valueOf(Short.parseShort(getStringPreference("pref_profile_device_id", "")));
    }

    public static void setNationalCodeVersion(String strValue) {
        if (strValue != null && !strValue.isEmpty()) {
            setStringPreference("pref_national_code_version", strValue);
        }
    }

    public static String getNationalCodeVersion() {
        return getStringPreference("pref_national_code_version", "0.0");
    }

    public static void setBuddyUpdateDate(Date buddyDate) {
        SharedPreferences prefs = MainApplication.mContext.getSharedPreferences(PREFNAME, 0);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putLong(PREF_KEY_BUDDY_UPDATE_DATE, buddyDate.getTime());
        if (Build.VERSION.SDK_INT < 9) {
            editor.commit();
        } else {
            editor.apply();
        }
    }

    public static Date getBuddyUpdateDate() {
        SharedPreferences prefs = MainApplication.mContext.getSharedPreferences(PREFNAME, 0);
        return new Date(prefs.getLong(PREF_KEY_BUDDY_UPDATE_DATE, 0L));
    }

    public static void setAssetVersion(int version) {
        setIntPreference(PREF_KEY_ASSET_VERSION, version);
    }

    public static int getAssetVersion() {
        return getIntPreference(PREF_KEY_ASSET_VERSION, 0);
    }

    public static void setCheckChargeAlert(boolean checked) {
        SharedPreferences prefs = MainApplication.mContext.getSharedPreferences(PREFNAME, 0);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putBoolean(PREF_KEY_CHECK_CHAGE_ALERT, checked);
        if (Build.VERSION.SDK_INT < 9) {
            editor.commit();
        } else {
            editor.apply();
        }
    }

    public static boolean isCheckChargeAlert() {
        SharedPreferences prefs = MainApplication.mContext.getSharedPreferences(PREFNAME, 0);
        return prefs.getBoolean(PREF_KEY_CHECK_CHAGE_ALERT, false);
    }

    public static void setVersionUpdateDate(Date versionDate) {
        SharedPreferences prefs = MainApplication.mContext.getSharedPreferences(PREFNAME, 0);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putLong(PREF_KEY_VERSION_UPDATE_DATE, versionDate.getTime());
        if (Build.VERSION.SDK_INT < 9) {
            editor.commit();
        } else {
            editor.apply();
        }
    }

    public static Date getVersionUpdateDate() {
        SharedPreferences prefs = MainApplication.mContext.getSharedPreferences(PREFNAME, 0);
        return new Date(prefs.getLong(PREF_KEY_VERSION_UPDATE_DATE, 0L));
    }

    public static void setNativeContactChanged(boolean update) {
        SharedPreferences prefs = MainApplication.mContext.getSharedPreferences(PREFNAME, 0);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putBoolean(PREF_KEY_NATIVE_CONTACT_CHANGED, update);
        if (Build.VERSION.SDK_INT < 9) {
            editor.commit();
        } else {
            editor.apply();
        }
    }

    public static boolean isNativeContactChanged() {
        SharedPreferences prefs = MainApplication.mContext.getSharedPreferences(PREFNAME, 0);
        return prefs.getBoolean(PREF_KEY_NATIVE_CONTACT_CHANGED, false);
    }

    public static void setBuddyUpdateNeeded(boolean update) {
        SharedPreferences prefs = MainApplication.mContext.getSharedPreferences(PREFNAME, 0);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putBoolean(PREF_KEY_BUDDY_UPDATE_NEEDED, update);
        if (Build.VERSION.SDK_INT < 9) {
            editor.commit();
        } else {
            editor.apply();
        }
    }

    public static boolean isBuddyUpdateNeeded() {
        SharedPreferences prefs = MainApplication.mContext.getSharedPreferences(PREFNAME, 0);
        return prefs.getBoolean(PREF_KEY_BUDDY_UPDATE_NEEDED, false);
    }

    public static void setBuddyUpdateNeededSuggestion(boolean update) {
        SharedPreferences prefs = MainApplication.mContext.getSharedPreferences(PREFNAME, 0);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putBoolean(PREF_KEY_BUDDY_UPDATE_NEEDED_SUGGESTION, update);
        if (Build.VERSION.SDK_INT < 9) {
            editor.commit();
        } else {
            editor.apply();
        }
    }

    public static boolean isBuddyUpdateNeededSuggestion() {
        SharedPreferences prefs = MainApplication.mContext.getSharedPreferences(PREFNAME, 0);
        return prefs.getBoolean(PREF_KEY_BUDDY_UPDATE_NEEDED_SUGGESTION, false);
    }

    public static void setVideoCallImgUpdateDate(Date profileImgDate) {
        SharedPreferences prefs = MainApplication.mContext.getSharedPreferences(PREFNAME, 0);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putLong(PREF_KEY_VIDEOCALL_IMG_UPDATE_DATE, profileImgDate.getTime());
        if (Build.VERSION.SDK_INT < 9) {
            editor.commit();
        } else {
            editor.apply();
        }
    }

    public static Date getVideoCallImgUpdateDate() {
        SharedPreferences prefs = MainApplication.mContext.getSharedPreferences(PREFNAME, 0);
        return new Date(prefs.getLong(PREF_KEY_VIDEOCALL_IMG_UPDATE_DATE, 0L));
    }

    public static void setVideoCallUpdateDate(Date profileDate) {
        SharedPreferences prefs = MainApplication.mContext.getSharedPreferences(PREFNAME, 0);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putLong(PREF_KEY_VIDEOCALL_IMG_UPDATE_DATE, profileDate.getTime());
        if (Build.VERSION.SDK_INT < 9) {
            editor.commit();
        } else {
            editor.apply();
        }
    }

    public static void setProfileImgUpdateDate(Date profileImgDate) {
        SharedPreferences prefs = MainApplication.mContext.getSharedPreferences(PREFNAME, 0);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putLong(PREF_KEY_PROFILE_IMG_UPDATE_DATE, profileImgDate.getTime());
        if (Build.VERSION.SDK_INT < 9) {
            editor.commit();
        } else {
            editor.apply();
        }
    }

    public static Date getProfileImgUpdateDate() {
        SharedPreferences prefs = MainApplication.mContext.getSharedPreferences(PREFNAME, 0);
        return new Date(prefs.getLong(PREF_KEY_PROFILE_IMG_UPDATE_DATE, 0L));
    }

    public static void setProfileUpdateDate(Date profileDate) {
        SharedPreferences prefs = MainApplication.mContext.getSharedPreferences(PREFNAME, 0);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putLong(PREF_KEY_PROFILE_UPDATE_DATE, profileDate.getTime());
        if (Build.VERSION.SDK_INT < 9) {
            editor.commit();
        } else {
            editor.apply();
        }
    }

    public static Date getProfileUpdateDate() {
        SharedPreferences prefs = MainApplication.mContext.getSharedPreferences(PREFNAME, 0);
        return new Date(prefs.getLong(PREF_KEY_PROFILE_UPDATE_DATE, 0L));
    }

    public static void setUserNo(long nUserNo) {
        SharedPreferences prefs = MainApplication.mContext.getSharedPreferences(PREFNAME, 0);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putLong(PREF_KEY_USERNO, nUserNo);
        if (Build.VERSION.SDK_INT < 9) {
            editor.commit();
        } else {
            editor.apply();
        }
    }

    public static long getUserNo() {
        SharedPreferences prefs = MainApplication.mContext.getSharedPreferences(PREFNAME, 0);
        return prefs.getLong(PREF_KEY_USERNO, -1L);
    }

    public static void setSipIdSendOnly(String strValue) {
        setStringPreference(PREF_SIP_ID_SEND_ONLY, strValue);
    }

    public static String getSipIdSendOnly() {
        return getStringPreference(PREF_SIP_ID_SEND_ONLY, "");
    }

    public static void setCallState(boolean isCalling) {
        setBooleanPreference(PREF_COOLOTS_CALL_STATE, isCalling);
    }

    public static boolean getCallState() {
        return getBooleanPreference(PREF_COOLOTS_CALL_STATE, false);
    }

    public static void setValidDevice(boolean enable) {
        setBooleanPreference(PREF_KEY_VALID_DEVICE, enable);
    }

    public static boolean isValidDevice() {
        return getBooleanPreference(PREF_KEY_VALID_DEVICE, false);
    }

    public static void setEnableAutoBuddy(boolean enable) {
        Log.m2958e("<YHT> setEnableAutoBuddy!!! enable:" + enable);
        setBooleanPreference(PREF_KEY_AUTO_BUDDY_OPTION, enable);
    }

    public static boolean isEnableAutoBuddy() {
        Log.m2958e("<YHT> isEnableAutoBuddy!!! enable:" + getBooleanPreference(PREF_KEY_AUTO_BUDDY_OPTION, false));
        return getBooleanPreference(PREF_KEY_AUTO_BUDDY_OPTION, false);
    }

    public static void setAuthID(String strValue) {
        setStringPreference("pref_profile_auth_id", strValue);
    }

    public static String getAuthID() {
        return getStringPreference("pref_profile_auth_id", "");
    }

    public static void setSMSAuthNumber(String authNo) {
        setStringPreference(PREF_KEY_SMS_AUTH_NO, authNo);
    }

    public static String getSMSAuthNumber() {
        return getStringPreference(PREF_KEY_SMS_AUTH_NO, "");
    }

    public static void setSMSAuthCountryCode(String authCountry) {
        setStringPreference(PREF_KEY_SMS_AUTH_COUNTRY, authCountry);
    }

    public static String getSMSAuthCountryCode() {
        return getStringPreference(PREF_KEY_SMS_AUTH_COUNTRY, "");
    }

    public static void clearCoolotsPref() {
        SharedPreferences pref = MainApplication.mContext.getSharedPreferences(PREFNAME, 0);
        pref.edit().clear().commit();
    }

    public static void resetPrefValues() {
        SharedPreferences pref = MainApplication.mContext.getSharedPreferences("com.coolots.chaton_preferences", 0);
        pref.edit().clear().commit();
        SharedPreferences loginPref = MainApplication.mContext.getSharedPreferences("com.coolots.login_preferences", 0);
        loginPref.edit().clear().commit();
    }

    public static void cleanSharedPreference(boolean bDeleteLoginInfo) {
        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(MainApplication.mContext);
        String centerDomain = EngineeringConfigActivity.getCenterDomain();
        String centerDomainIP = EngineeringConfigActivity.getCenterDomainIP();
        String centerPath = EngineeringConfigActivity.getCenterPath();
        String serverLevel = EngineeringConfigActivity.getServerLevel();
        String userid = getProfileUserID();
        String rawpwd = getProfileRawPwd();
        String passwd = getProfilePasswd();
        boolean passchk = isProfileRawPwdCheck();
        String serialno = getProfileSerialNo();
        Short deviceid = getProfileDeviceID();
        String nationalCodeVer = getNationalCodeVersion();
        String authid = getAuthID();
        short deviceID = 0;
        if (deviceid != null) {
            deviceID = deviceid.shortValue();
        }
        pref.edit().clear();
        pref.edit().commit();
        EngineeringConfigActivity.setCenterDomain(centerDomain);
        EngineeringConfigActivity.setCenterDomainIP(centerDomainIP);
        Log.m2958e("ip : " + EngineeringConfigActivity.getCenterDomainIP());
        EngineeringConfigActivity.setCenterPath(centerPath);
        EngineeringConfigActivity.setServerLevel(serverLevel);
        if (!bDeleteLoginInfo) {
            setProfileUserID(userid);
            setProfileRawPwd(rawpwd);
            setProfilePasswd(passwd);
            setProfileRawPwdCheck(passchk);
            setProfileSerialNo(serialno);
            setProfileDeviceID(Short.valueOf(deviceID));
            setNationalCodeVersion(nationalCodeVer);
            setAuthID(authid);
        }
    }

    public static synchronized boolean getSDCardWritable(boolean bUpdate) {
        if (bSDCardWritable == null || bUpdate) {
            bSDCardWritable = Boolean.valueOf(FileUtil.checkSDCardStatus(true));
            Log.m2963i("getSDCardWritable() SDCard Writable = " + (bSDCardWritable.booleanValue() ? "true" : "false"));
        }
        return bSDCardWritable.booleanValue();
    }

    private String callChoiceToString(int choice) {
        return "";
    }

    public static void setChatONNo(String strValue) {
        setStringPreference(PREF_KEY_CHATON_NO, strValue);
    }

    public static String getChatONNo() {
        return getStringPreference(PREF_KEY_CHATON_NO, "");
    }

    public static void setChatONUID(String strValue) {
        setStringPreference(PREF_KEY_CHATON_UID, strValue);
    }

    public static String getChatONUID() {
        return getStringPreference(PREF_KEY_CHATON_UID, "");
    }

    public static void setVoiceConferenceCallMaxPeopleNum(int intValue) {
        setIntPreference(PREF_KEY_CHATON_VOICE_CONF_MAX_NUM, intValue);
    }

    public static void setVideoConferenceCallMaxPeopleNum(int intValue) {
        setIntPreference(PREF_KEY_CHATON_VIDEO_CONF_MAX_NUM, intValue);
    }

    public static int getVoiceConferenceCallMaxPeopleNum() {
        return getIntPreference(PREF_KEY_CHATON_VOICE_CONF_MAX_NUM, 0);
    }

    public static int getVideoConferenceCallMaxPeopleNum() {
        return getIntPreference(PREF_KEY_CHATON_VIDEO_CONF_MAX_NUM, 0);
    }

    public static void setShareScreenCopyRight(boolean strValue) {
        SharedPreferences prefs = MainApplication.mContext.getSharedPreferences(PREFNAME, 0);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putBoolean(PREF_KEY_SHARE_SCREEN_COPYRIGHT, strValue);
        if (Build.VERSION.SDK_INT < 9) {
            editor.commit();
        } else {
            editor.apply();
        }
    }

    public static boolean isShareScreenCopyRight() {
        SharedPreferences prefs = MainApplication.mContext.getSharedPreferences(PREFNAME, 0);
        return prefs.getBoolean(PREF_KEY_SHARE_SCREEN_COPYRIGHT, false);
    }

    public static void setCheckShareScreenChangeVoice(boolean strValue) {
        SharedPreferences prefs = MainApplication.mContext.getSharedPreferences(PREFNAME, 0);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putBoolean(PREF_KEY_SHARE_SCREEN_CHANGE_VOICE, strValue);
        if (Build.VERSION.SDK_INT < 9) {
            editor.commit();
        } else {
            editor.apply();
        }
    }

    public static boolean isCheckShareScreenChangeVoice() {
        SharedPreferences prefs = MainApplication.mContext.getSharedPreferences(PREFNAME, 0);
        return prefs.getBoolean(PREF_KEY_SHARE_SCREEN_CHANGE_VOICE, false);
    }

    public static void setCallDataSendInterval(int intValue) {
        setIntPreference(PREF_KEY_CALL_SEND_INTERVAL, intValue);
    }

    public static int getCallDataSendInterval() {
        return getIntPreference(PREF_KEY_CALL_SEND_INTERVAL, 60);
    }
}
