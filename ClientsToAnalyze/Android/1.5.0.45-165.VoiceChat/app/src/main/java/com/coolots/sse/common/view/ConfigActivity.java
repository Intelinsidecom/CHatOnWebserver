package com.coolots.sse.common.view;

import android.content.Context;
import android.content.SharedPreferences;
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
    private static final String PREF_KEY_AUDIO_SETTING = "pref_audio_setting";
    private static final String PREF_KEY_BUDDY_UPDATE_DATE = "pref_buddy_update_date";
    private static final String PREF_KEY_BUDDY_UPDATE_NEEDED = "pref_buddy_update_needed";
    private static final String PREF_KEY_CHECK_CHAGE_ALERT = "pref_check_charge_alert";
    private static final String PREF_KEY_ENGINEERING_CONFIG = "pref_engineering_config";
    private static final String PREF_KEY_NATIONAL_CODE = "pref_national_code";
    private static final String PREF_KEY_NATIVE_CONTACT_CHANGED = "pref_native_contact_changed";
    private static final String PREF_KEY_PROFILE_IMG_UPDATE_DATE = "pref_profile_img_update_date";
    private static final String PREF_KEY_PROFILE_UPDATE_DATE = "pref_profile_update_date";
    private static final String PREF_KEY_USERNO = "PREF_KEY_USERNO";
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
    public static final String PREF_PROFILE_SAMSUNG_ACCOUNT_CLIENTID = "pref_profile_samsung_account_clientid";
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

    private static void setStringPreference(String key, String arg) {
        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(MainApplication.mContext);
        SharedPreferences.Editor editor = pref.edit();
        editor.putString(key, arg);
        editor.commit();
    }

    private static boolean getBooleanPreference(String key, boolean def) {
        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(MainApplication.mContext);
        return pref.getBoolean(key, def);
    }

    private static void setBooleanPreference(String key, boolean arg) {
        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(MainApplication.mContext);
        SharedPreferences.Editor editor = pref.edit();
        editor.putBoolean(key, arg);
        editor.commit();
    }

    private static int getIntPreference(String key, int def) {
        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(MainApplication.mContext);
        return pref.getInt(key, def);
    }

    private static void setIntPreference(String key, int val) {
        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(MainApplication.mContext);
        SharedPreferences.Editor editor = pref.edit();
        editor.putInt(key, val);
        editor.commit();
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
        editor.commit();
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
        editor.commit();
    }

    public static boolean isCheckChargeAlert() {
        SharedPreferences prefs = MainApplication.mContext.getSharedPreferences(PREFNAME, 0);
        return prefs.getBoolean(PREF_KEY_CHECK_CHAGE_ALERT, false);
    }

    public static void setNativeContactChanged(boolean update) {
        SharedPreferences prefs = MainApplication.mContext.getSharedPreferences(PREFNAME, 0);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putBoolean(PREF_KEY_NATIVE_CONTACT_CHANGED, update);
        editor.commit();
    }

    public static boolean isNativeContactChanged() {
        SharedPreferences prefs = MainApplication.mContext.getSharedPreferences(PREFNAME, 0);
        return prefs.getBoolean(PREF_KEY_NATIVE_CONTACT_CHANGED, false);
    }

    public static void setBuddyUpdateNeeded(boolean update) {
        SharedPreferences prefs = MainApplication.mContext.getSharedPreferences(PREFNAME, 0);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putBoolean(PREF_KEY_BUDDY_UPDATE_NEEDED, update);
        editor.commit();
    }

    public static boolean isBuddyUpdateNeeded() {
        SharedPreferences prefs = MainApplication.mContext.getSharedPreferences(PREFNAME, 0);
        return prefs.getBoolean(PREF_KEY_BUDDY_UPDATE_NEEDED, false);
    }

    public static void setProfileImgUpdateDate(Date profileImgDate) {
        SharedPreferences prefs = MainApplication.mContext.getSharedPreferences(PREFNAME, 0);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putLong(PREF_KEY_PROFILE_IMG_UPDATE_DATE, profileImgDate.getTime());
        editor.commit();
    }

    public static Date getProfileImgUpdateDate() {
        SharedPreferences prefs = MainApplication.mContext.getSharedPreferences(PREFNAME, 0);
        return new Date(prefs.getLong(PREF_KEY_PROFILE_IMG_UPDATE_DATE, 0L));
    }

    public static void setProfileUpdateDate(Date profileDate) {
        SharedPreferences prefs = MainApplication.mContext.getSharedPreferences(PREFNAME, 0);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putLong(PREF_KEY_PROFILE_UPDATE_DATE, profileDate.getTime());
        editor.commit();
    }

    public static Date getProfileUpdateDate() {
        SharedPreferences prefs = MainApplication.mContext.getSharedPreferences(PREFNAME, 0);
        return new Date(prefs.getLong(PREF_KEY_PROFILE_UPDATE_DATE, 0L));
    }

    public static void setUserNo(long nUserNo) {
        SharedPreferences prefs = MainApplication.mContext.getSharedPreferences(PREFNAME, 0);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putLong(PREF_KEY_USERNO, nUserNo);
        editor.commit();
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

    public static void setAuthID(String strValue) {
        setStringPreference("pref_profile_auth_id", strValue);
    }

    public static String getAuthID() {
        return getStringPreference("pref_profile_auth_id", "");
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

    public static void setNationalCode(int version) {
        setIntPreference(PREF_KEY_NATIONAL_CODE, version);
    }

    public static int getNationalCode() {
        return getIntPreference(PREF_KEY_NATIONAL_CODE, 0);
    }

    public static void setAudioSettingCfg(int version) {
        setIntPreference(PREF_KEY_AUDIO_SETTING, version);
    }

    public static int getAudioSettingCfg() {
        return getIntPreference(PREF_KEY_AUDIO_SETTING, 0);
    }

    public static void setEngineeringCfg(int version) {
        setIntPreference(PREF_KEY_ENGINEERING_CONFIG, version);
    }

    public static int getEngineeringCfg() {
        return getIntPreference(PREF_KEY_ENGINEERING_CONFIG, 0);
    }
}
