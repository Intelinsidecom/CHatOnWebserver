package com.coolots.chaton.common.view;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.preference.EditTextPreference;
import android.preference.ListPreference;
import android.preference.PreferenceActivity;
import android.preference.PreferenceCategory;
import android.preference.PreferenceManager;
import android.telephony.TelephonyManager;
import com.coolots.chaton.common.controller.VAppPhoneManager;
import com.coolots.chaton.common.util.SecurePreferences;
import com.coolots.chaton.setting.data.ChatONHideMeImgData;
import com.coolots.p2pmsg.model.CallMediaSettingRep;
import com.infraware.office.evengine.InterfaceC0507E;
import com.sds.coolots.EngineInterface;
import com.sds.coolots.MainApplication;
import com.sds.coolots.common.controller.PhoneManager;
import com.sds.coolots.common.util.EncodingUtil;
import com.sds.coolots.common.util.Log;
import com.sds.coolots.common.util.ModelInfoUtil;
import com.sds.coolots.common.view.DisposeInterface;
import com.vlingo.sdk.recognition.spotter.VLSpotterContext;
import java.io.IOException;

/* loaded from: classes.dex */
public class EngineeringConfigActivity extends PreferenceActivity implements SharedPreferences.OnSharedPreferenceChangeListener, DisposeInterface {
    private static final String CLASSNAME = "[EngineeringConfigActivity]";
    private static final String DEFAULT_SUB_PORT = ":7080";
    public static final String DEF_BACK_OFFICE = "70.90.211.15";
    public static final String DEF_CENTER_DOMAIN = "70.90.211.20";
    public static final String DEF_CENTER_PATH = "xml3/pb.do";
    public static final String DEF_FALSE = "0";
    public static final String DEF_FRONT_WEB = "70.90.211.15";
    public static final String DEF_IMAGE_SERVER = "70.90.211.15/images";
    public static final String DEF_MOBILE_WEB = "70.90.211.15";
    public static final String DEF_TRUE = "1";
    private static final String DNS_EXTERNAL = "-v.coolots.com";
    private static final String DNS_INTERNAL = "-v-int.coolots.com";
    public static final int LOG_LEVEL_ERROR = 1;
    public static final int LOG_LEVEL_VERBOSE = 5;
    public static final int MEDIA_CODEC_AAC = 6;
    public static final int MEDIA_CODEC_AMR_NB = 4;
    public static final int MEDIA_CODEC_AMR_WB = 5;
    public static final int MEDIA_CODEC_G711_PCMA = 1;
    public static final int MEDIA_CODEC_G711_PCMU = 0;
    public static final int MEDIA_CODEC_G7231 = 3;
    public static final int MEDIA_CODEC_G729 = 2;
    public static final int MEDIA_CODEC_ILBC = 8;
    public static final int MEDIA_CODEC_PCM_WB = 7;
    public static final int MEDIA_CODEC_SILK = 9;
    public static final String PREF_CAHTON_BACKUP_ACCOUNT_PHONENO = "pref_backup_account_phoneno";
    public static final String PREF_CALL_BACK_FRAMESIZE = "pref_call_back_framesize";
    public static final String PREF_CALL_FRAMERATE = "pref_call_framerate";
    public static final String PREF_CALL_FRONT_FRAMESIZE = "pref_call_front_framesize";
    public static final String PREF_CALL_PLACE_CAMERA = "pref_call_place_camera";
    public static final String PREF_CALL_RECEIVE_CAMERA = "pref_call_receive_camera";
    public static final String PREF_CENTER_DOMAIN = "pref_center_domain";
    public static final String PREF_CENTER_DOMAIN_IP = "pref_center_domain_ip";
    public static final String PREF_CENTER_PATH = "pref_center_path";
    public static final String PREF_CHATON_BACKUP_ACCOUNT_COUNTRY = "pref_backup_account_country";
    public static final String PREF_CHATON_BACKUP_ACCOUNT_EMAIL = "pref_backup_account_email";
    public static final String PREF_CHATON_BACKUP_ACCOUNT_ID = "pref_backup_account_id";
    public static final String PREF_CHATON_BACKUP_ACCOUNT_USERNAME = "pref_backup_account_username";
    public static final String PREF_CHATON_JOIN_BACKUP_COUNTRY = "pref_backup_country";
    public static final String PREF_CHATON_JOIN_BACKUP_ID = "pref_backup_id";
    public static final String PREF_CHATON_SERIAL = "pref_serial_number";
    public static final String PREF_CHATON_SERVICE_POLICY_ENABLE_VIDEO = "pref_service_policy_enable_video";
    public static final String PREF_CHATON_SERVICE_POLICY_ENABLE_VOICE = "pref_service_policy_enable_voice";
    public static final String PREF_CONF_LOGIN = "pref_conf_login";
    public static final String PREF_DEMO_VERSION = "pref_demo_version";
    public static final String PREF_DEV = "dev";
    public static final String PREF_ETC = "etc";
    public static final String PREF_ETC_SERVER_SETTING = "pref_etc_server_setting";
    private static final String PREF_KEY_CIPHER_KEY = "PREF_KEY_CIPHER_KEY";
    private static final String PREF_KEY_GCMPUSHREGID = "PREF_KEY_GCMPUSHREGID";
    private static final String PREF_KEY_LOGIN_SUCCESS_EVER = "PREF_KEY_LOGIN_SUCCESS_EVER";
    private static final String PREF_KEY_NONCE = "PREF_KEY_NONCE";
    private static final String PREF_KEY_NONCE_EXPIRED_TIME = "PREF_KEY_NONCE_EXPIRED_TIME";
    private static final String PREF_KEY_SERVER_REGION = "PREF_KEY_SERVER_REGION";
    private static final String PREF_KEY_SESSIONID = "PREF_SESSION_ID";
    private static final String PREF_KEY_SPPPUSHREGID = "PREF_KEY_SPPPUSHREGID";
    public static final String PREF_LOCAL_CENTER_DOMAIN = "pref_local_center_domain";
    public static final String PREF_OPF = "";
    public static final String PREF_SERVER_LEVEL = "pref_server_level";
    public static final String PREF_SERVER_REGION = "pref_server_region";
    public static final String PREF_STG = "stg";
    public static final String PREF_USE_SEC_AUDIO_ENGINE = "pref_use_sec_audio_engine";
    public static final int TYPE_FRAME_SIZE_288_480 = 0;
    public static final int TYPE_FRAME_SIZE_368_480 = 1;
    public static final int TYPE_FRAME_SIZE_384_288 = 9;
    public static final int TYPE_FRAME_SIZE_448_336 = 10;
    public static final int TYPE_FRAME_SIZE_480P = 7;
    public static final int TYPE_FRAME_SIZE_512_384 = 11;
    public static final int TYPE_FRAME_SIZE_576_432 = 12;
    public static final int TYPE_FRAME_SIZE_720P = 8;
    public static final int TYPE_FRAME_SIZE_CIF = 4;
    public static final int TYPE_FRAME_SIZE_QCIF = 2;
    public static final int TYPE_FRAME_SIZE_QVGA = 3;
    public static final int TYPE_FRAME_SIZE_VERTICAL_CIF = 104;
    public static final int TYPE_FRAME_SIZE_VERTICAL_QCIF = 102;
    public static final int TYPE_FRAME_SIZE_VERTICAL_QVGA = 103;
    public static final int TYPE_FRAME_SIZE_VERTICAL_VGA = 105;
    public static final int TYPE_FRAME_SIZE_VERTICAL_WVGA = 106;
    public static final int TYPE_FRAME_SIZE_VGA = 5;
    public static final int TYPE_FRAME_SIZE_WVGA = 6;
    private static final String WEB_URL_PREFIX_RUN = "http://kr-m";
    private static final String WEB_URL_PREFIX_STG = "http://kr-stgm";
    private static EngineeringConfigActivity instance;
    public static boolean value;
    private Handler mConfigHandler = new ConfigHandler(null);
    private static SecurePreferences mLoginPref = new SecurePreferences(MainApplication.mContext);
    public static String defCenterDNS = ".coolots.com";
    public static final String DEF_SERVER_LEVEL = PhoneManager.mServerType;
    private static final String DEF_SERVER_REGION = PhoneManager.mServerRegion;
    public static boolean isUseFrontCameraForOutGoingCallNow = true;
    public static boolean isUseFrontCameraForReceiveCallNow = true;

    private void logE(String message) {
        Log.m2958e(CLASSNAME + message);
    }

    private void logI(String message) {
        Log.m2963i(CLASSNAME + message);
    }

    public static EngineeringConfigActivity getInstance() {
        return instance;
    }

    @Override // android.preference.PreferenceActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        instance = this;
        addPreferencesFromResource(MainApplication.mResources.getXmlEngineeringConfig());
        getPreferenceScreen().getSharedPreferences().registerOnSharedPreferenceChangeListener(this);
        MainApplication.mPhoneManager.getConfigManager().setConfigActivityHandler(this.mConfigHandler);
        updateSummary(getPreferenceManager().getSharedPreferences());
    }

    @Override // android.preference.PreferenceActivity, android.app.ListActivity, android.app.Activity
    protected void onDestroy() {
        logI("onDestroy");
        dispose();
        super.onDestroy();
    }

    @Override // android.content.SharedPreferences.OnSharedPreferenceChangeListener
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {
        if (key.equals("pref_use_sec_audio_engine")) {
            boolean value2 = sharedPreferences.getBoolean(key, true);
            if (value2) {
                EngineInterface.jniSetUseSECAudioEngine(1);
                return;
            } else {
                EngineInterface.jniSetUseSECAudioEngine(0);
                return;
            }
        }
        updateSummary(sharedPreferences);
    }

    private void updateSummary(SharedPreferences sharedPreferences) {
        updateEntrySummary(sharedPreferences, "pref_server_level");
        updateStringSummary(sharedPreferences, "pref_center_domain");
        updateStringSummary(sharedPreferences, "pref_center_path");
        updateEntrySummary(sharedPreferences, "pref_call_receive_camera");
        updateEntrySummary(sharedPreferences, "pref_call_front_framesize");
        updateEntrySummary(sharedPreferences, "pref_call_back_framesize");
        updateEntrySummary(sharedPreferences, "pref_call_framerate");
        updateEntrySummary(sharedPreferences, "pref_conf_login");
        updateStringSummary(sharedPreferences, "pref_backup_id");
        updateStringSummary(sharedPreferences, "pref_backup_country");
        updateStringSummary(sharedPreferences, "pref_serial_number");
        updateStringSummary(sharedPreferences, "pref_backup_account_id");
        updateStringSummary(sharedPreferences, "pref_backup_account_country");
        updateStringSummary(sharedPreferences, "pref_backup_account_phoneno");
        updateStringSummary(sharedPreferences, "pref_backup_account_username");
        updateStringSummary(sharedPreferences, "pref_backup_account_email");
        modeChange();
    }

    private void modeChange() {
        Log.m2963i("modeChange()");
        ListPreference listPref = (ListPreference) getPreferenceScreen().findPreference("pref_server_level");
        PreferenceCategory prefCategory = (PreferenceCategory) getPreferenceScreen().findPreference("pref_etc_server_setting");
        if (listPref != null) {
            VAppPhoneManager mManager = (VAppPhoneManager) MainApplication.mPhoneManager;
            if (getServerLevel().equals(PREF_DEV)) {
                prefCategory.setEnabled(false);
                VAppPhoneManager.setUnlimitedSMS(true);
                Log.setLogLevel(5);
                defCenterDNS = DNS_EXTERNAL;
                mManager.setWebURL(WEB_URL_PREFIX_STG + defCenterDNS + "/");
                return;
            }
            if (getServerLevel().equals("stg")) {
                prefCategory.setEnabled(false);
                VAppPhoneManager.setUnlimitedSMS(false);
                Log.setLogLevel(5);
                defCenterDNS = DNS_EXTERNAL;
                mManager.setWebURL(WEB_URL_PREFIX_STG + defCenterDNS + "/");
                return;
            }
            prefCategory.setEnabled(false);
            VAppPhoneManager.setUnlimitedSMS(false);
            Log.setLogLevel(1);
            defCenterDNS = DNS_EXTERNAL;
            mManager.setWebURL(WEB_URL_PREFIX_RUN + defCenterDNS + DEFAULT_SUB_PORT + "/");
        }
    }

    private void updateEntrySummary(SharedPreferences sharedPreferences, String key) {
        ListPreference listPref = (ListPreference) getPreferenceScreen().findPreference(key);
        if (listPref != null) {
            if (sharedPreferences != null) {
                listPref.setValue(sharedPreferences.getString(key, ""));
            }
            listPref.setSummary(listPref.getEntry());
        }
    }

    private void updateStringSummary(SharedPreferences sharedPreferences, String key) {
        EditTextPreference editPref = (EditTextPreference) getPreferenceScreen().findPreference(key);
        if (editPref != null) {
            if (sharedPreferences != null) {
                editPref.setText(sharedPreferences.getString(key, ""));
            }
            editPref.setSummary(editPref.getText());
        }
    }

    private static String getStringPreference(String key, String def) {
        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(MainApplication.mContext);
        if (pref.getString(key, def) != null) {
            return pref.getString(key, def);
        }
        Log.m2963i("pref == null");
        return def;
    }

    private static String getStringPreference(String key, String def, Context context) {
        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(context);
        if (pref.getString(key, def) != null) {
            return pref.getString(key, def);
        }
        Log.m2963i("pref == null");
        return def;
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

    private static String getLoginPreference(String key, String def) {
        return mLoginPref.getString(key, def);
    }

    private static void setLoginPreference(String key, String value2) {
        SharedPreferences.Editor editor = mLoginPref.edit();
        editor.putString(key, value2);
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

    private static long getLongPreference(String key, long def) {
        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(MainApplication.mContext);
        return pref.getLong(key, def);
    }

    private static void setLongPreference(String key, long arg) {
        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(MainApplication.mContext);
        SharedPreferences.Editor editor = pref.edit();
        editor.putLong(key, arg);
        if (Build.VERSION.SDK_INT < 9) {
            editor.commit();
        } else {
            editor.apply();
        }
    }

    public static boolean isConfLogin() {
        String tmp = getStringPreference("pref_conf_login", "N");
        return !"N".equals(tmp);
    }

    public static String getServerRegion() {
        return getStringPreference(PREF_KEY_SERVER_REGION, DEF_SERVER_REGION);
    }

    public static String getServerLevel() {
        String server = getStringPreference("pref_server_level", DEF_SERVER_LEVEL);
        return server;
    }

    public static void setServerLevel(String strValue) {
        if (strValue != null && !strValue.isEmpty()) {
            setStringPreference("pref_server_level", strValue);
        }
    }

    public static void setLocalCenterDomain(String strValue) {
        if (strValue != null && !strValue.isEmpty()) {
            setStringPreference("pref_local_center_domain", strValue);
        }
    }

    public static String getLocalCenterDomain() {
        return getStringPreference("pref_local_center_domain", null);
    }

    public static String getCenterDomain() {
        if (getServerLevel().equals("etc")) {
            String localDomain = getLocalCenterDomain();
            if (localDomain == null || localDomain.isEmpty()) {
                return String.valueOf(getServerRegion()) + PREF_DEV + "cs" + defCenterDNS;
            }
            return localDomain;
        }
        if (getServerLevel().equals("stg")) {
            String localDomain2 = getLocalCenterDomain();
            if (localDomain2 == null || localDomain2.isEmpty()) {
                return String.valueOf(getServerRegion()) + "stgcs" + defCenterDNS;
            }
            return localDomain2;
        }
        String localDomain3 = getLocalCenterDomain();
        if (localDomain3 == null || localDomain3.isEmpty()) {
            return String.valueOf(getServerRegion()) + getServerLevel() + "cs" + defCenterDNS;
        }
        return localDomain3;
    }

    public static String getMasterCenterDomain() {
        if (getServerLevel().equals("etc")) {
            return "devcs" + defCenterDNS;
        }
        if (getServerLevel().equals("stg")) {
            return "stgcs" + defCenterDNS;
        }
        return String.valueOf(getServerLevel()) + "cs" + defCenterDNS;
    }

    public static void setCenterDomain(String strValue) {
        if (strValue != null && !strValue.isEmpty()) {
            setStringPreference("pref_center_domain", strValue);
        }
    }

    public static String getCenterDomainIP() {
        return getStringPreference("pref_center_domain_ip", DEF_CENTER_DOMAIN);
    }

    public static void setCenterDomainIP(String strValue) {
        if (strValue != null && !strValue.isEmpty()) {
            setStringPreference("pref_center_domain_ip", strValue);
        }
    }

    public static String getCenterPath() {
        return getStringPreference("pref_center_path", "xml3/pb.do");
    }

    public static void setCenterPath(String strValue) {
        if (strValue != null && !strValue.isEmpty()) {
            setStringPreference("pref_center_path", strValue);
        }
    }

    public static int getCallFrameSize(boolean isFrontCamera) throws IOException {
        String tmp;
        Log.m2967v("getCallFrameSize : isFrontCamera = " + isFrontCamera);
        if (MainApplication.mPhoneManager.getVersion() == 4) {
            if (!ModelInfoUtil.IS_MODEL_GALAXY_S2 && ModelInfoUtil.IS_MODEL_GALAXY_S && Build.VERSION.SDK_INT <= 8) {
                return isFrontCamera ? 103 : 103;
            }
            return 3;
        }
        if (MainApplication.mPhoneManager.getVersion() == 1 || MainApplication.mPhoneManager.getVersion() == 0) {
            if (isFrontCamera) {
                tmp = getStringPreference("pref_call_back_framesize", String.valueOf(5));
                if (Integer.parseInt(tmp) >= 7) {
                    return 5;
                }
            } else {
                tmp = getStringPreference("pref_call_back_framesize", String.valueOf(5));
            }
        } else if (isFrontCamera) {
            tmp = getStringPreference("pref_call_front_framesize", String.valueOf(1));
        } else {
            tmp = getStringPreference("pref_call_back_framesize", String.valueOf(5));
        }
        return Integer.parseInt(tmp);
    }

    public static int getCallFrameRate() {
        return Integer.parseInt(getStringPreference("pref_call_framerate", "15"));
    }

    public static int getFrameWidth(int framesize) {
        switch (framesize) {
            case 0:
            case 104:
                return InterfaceC0507E.EV_GUI_EVENT.eEV_GUI_SELECT_ALL_EVENT;
            case 1:
                return 368;
            case 2:
                return 176;
            case 3:
                return VLSpotterContext.DEFAULT_PHRASESPOT_PARAMB;
            case 4:
                return 352;
            case 5:
                return ChatONHideMeImgData.IMAGE_DEFAULT_HEIGHT;
            case 6:
                return 800;
            case 7:
                return 720;
            case 8:
                return 1024;
            case 9:
                return 384;
            case 10:
                return 448;
            case 11:
                return 512;
            case 12:
                return 576;
            case 102:
                return 144;
            case 103:
                return 240;
            case 105:
                return ChatONHideMeImgData.IMAGE_DEFAULT_WIDTH;
            case 106:
                return ChatONHideMeImgData.IMAGE_DEFAULT_WIDTH;
            default:
                return VLSpotterContext.DEFAULT_PHRASESPOT_PARAMB;
        }
    }

    public static int getFrameHeight(int framesize) {
        switch (framesize) {
            case 0:
            case 1:
            case 5:
            case 6:
            case 7:
                return ChatONHideMeImgData.IMAGE_DEFAULT_WIDTH;
            case 2:
                return 144;
            case 3:
                return 240;
            case 4:
                return InterfaceC0507E.EV_GUI_EVENT.eEV_GUI_SELECT_ALL_EVENT;
            case 8:
                return 600;
            case 9:
                return InterfaceC0507E.EV_GUI_EVENT.eEV_GUI_SELECT_ALL_EVENT;
            case 10:
                return 336;
            case 11:
                return 384;
            case 12:
                return 432;
            case 102:
                return 176;
            case 103:
                return VLSpotterContext.DEFAULT_PHRASESPOT_PARAMB;
            case 104:
                return 352;
            case 105:
                return ChatONHideMeImgData.IMAGE_DEFAULT_HEIGHT;
            case 106:
                return 800;
            default:
                return 240;
        }
    }

    public static void setCallMediaSetting(CallMediaSettingRep rep) {
    }

    public static void setBackupJoinUserID(String userID) {
        setStringPreference("pref_backup_id", userID);
    }

    public static String getBackupJoinUserID() {
        return getStringPreference("pref_backup_id", "");
    }

    public static String getBackupJoinUserID(Context context) {
        return getStringPreference("pref_backup_id", "", context);
    }

    public static void setBackupJoinCountryCode(String countryCode) {
        setStringPreference("pref_backup_country", countryCode);
    }

    public static String getBackupJoinCountryCode() {
        return getStringPreference("pref_backup_country", "");
    }

    public static void setBackupLinkUserID(String userID) {
        setStringPreference("pref_backup_account_id", userID);
    }

    public static String getBackupLinkUserID() {
        return getStringPreference("pref_backup_account_id", "");
    }

    public static void setBackupLinkCountry(String country) {
        setStringPreference("pref_backup_account_country", country);
    }

    public static String getBackupLinkCountry() {
        return getStringPreference("pref_backup_account_country", "");
    }

    public static void setBackupLinkPhoneNo(String phoneNo) {
        setStringPreference("pref_backup_account_phoneno", phoneNo);
    }

    public static String getBackupLinkPhoneNo() {
        return getStringPreference("pref_backup_account_phoneno", "");
    }

    public static void setBackupLinkUserName(String userName) {
        setStringPreference("pref_backup_account_username", userName);
    }

    public static String getBackupLinkUserName() {
        return getStringPreference("pref_backup_account_username", "");
    }

    public static void setBackupLinkEmail(String email) {
        setStringPreference("pref_backup_account_email", email);
    }

    public static String getBackupLinkEmail() {
        return getStringPreference("pref_backup_account_email", "");
    }

    public static void setChatonSerialNumber(String serial) {
        TelephonyManager manager = (TelephonyManager) MainApplication.mContext.getSystemService("phone");
        String strDeviceSerialNo = manager.getDeviceId();
        if (strDeviceSerialNo == null || strDeviceSerialNo.isEmpty()) {
            setStringPreference("pref_serial_number", serial);
        } else {
            setStringPreference("pref_serial_number", strDeviceSerialNo);
        }
    }

    public static String getChatonSerialNumber() {
        TelephonyManager telManager = (TelephonyManager) MainApplication.mContext.getSystemService("phone");
        String strIMEI = telManager.getDeviceId();
        String strDeviceSerialNo = Build.SERIAL;
        if (strIMEI == null || strIMEI.isEmpty()) {
            return (strDeviceSerialNo == null || strDeviceSerialNo.isEmpty()) ? "000000000000000" : strDeviceSerialNo;
        }
        return strIMEI;
    }

    public static String getDeviceMACAddress() {
        WifiManager wifiManager = (WifiManager) MainApplication.mContext.getSystemService("wifi");
        WifiInfo wifiInfo = wifiManager.getConnectionInfo();
        String strMACAddress = null;
        if (wifiInfo != null) {
            strMACAddress = wifiInfo.getMacAddress();
        }
        return strMACAddress;
    }

    public static void setServicePolicyInfoEnableVoice(boolean enable) {
        setBooleanPreference("pref_service_policy_enable_voice", enable);
    }

    public static void setServicePolicyInfoEnableVideo(boolean enable) {
        setBooleanPreference("pref_service_policy_enable_video", enable);
    }

    public static boolean getServicePolicyInfoEnableVoice() {
        return getBooleanPreference("pref_service_policy_enable_voice", true);
    }

    public static boolean getServicePolicyInfoEnableVideo() {
        return getBooleanPreference("pref_service_policy_enable_video", true);
    }

    public static boolean isDemoVersion() {
        return getBooleanPreference(PREF_DEMO_VERSION, false);
    }

    public static void setDemoVersion(boolean isDemo) {
        setBooleanPreference(PREF_DEMO_VERSION, isDemo);
    }

    public static void setSessionID(String sessionID) {
        if (sessionID != null) {
            setStringPreference(PREF_KEY_SESSIONID, sessionID);
        }
    }

    public static String getSessionID() {
        return getStringPreference(PREF_KEY_SESSIONID, "");
    }

    public static void setCipherKey(String cipherKey) {
        if (cipherKey != null) {
            setLoginPreference(PREF_KEY_CIPHER_KEY, cipherKey);
        }
    }

    public static String getCipherKey() {
        return getLoginPreference(PREF_KEY_CIPHER_KEY, "");
    }

    public static byte[] getDecodedCipherKey() {
        String mCipherKey = getLoginPreference(PREF_KEY_CIPHER_KEY, "");
        if (mCipherKey == null || mCipherKey.isEmpty()) {
            return null;
        }
        try {
            byte[] mDecodedCipherKey = EncodingUtil.decodeBase64ToBytes(mCipherKey);
            return mDecodedCipherKey;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static boolean getLoginSuccess() {
        return getBooleanPreference(PREF_KEY_LOGIN_SUCCESS_EVER, false);
    }

    public static void setLoginSuccess(boolean success) {
        setBooleanPreference(PREF_KEY_LOGIN_SUCCESS_EVER, success);
    }

    public static void setNonce(String nonce) {
        if (nonce != null) {
            setLoginPreference(PREF_KEY_NONCE, nonce);
        }
    }

    public static String getNonce() {
        return getLoginPreference(PREF_KEY_NONCE, "");
    }

    public static String getSPPPushRegID() {
        return getLoginPreference(PREF_KEY_SPPPUSHREGID, "");
    }

    public static String getGCMPushRegID() {
        return getLoginPreference(PREF_KEY_GCMPUSHREGID, "");
    }

    public static void setSPPPUSHRegID(String regID) {
        if (regID != null) {
            setLoginPreference(PREF_KEY_SPPPUSHREGID, regID);
        }
    }

    public static void setGCMPUSHRegID(String regID) {
        if (regID != null) {
            setLoginPreference(PREF_KEY_GCMPUSHREGID, regID);
        }
    }

    public static long getNonceExpiredTime() {
        return getLongPreference(PREF_KEY_NONCE_EXPIRED_TIME, -1L);
    }

    public static void setNonceExpiredTime(long time) {
        setLongPreference(PREF_KEY_NONCE_EXPIRED_TIME, time);
    }

    private static class ConfigHandler extends Handler {
        private ConfigHandler() {
        }

        /* synthetic */ ConfigHandler(ConfigHandler configHandler) {
            this();
        }

        @Override // android.os.Handler
        public void handleMessage(Message msg) {
            if (msg.what == 1) {
            }
        }
    }

    @Override // com.sds.coolots.common.view.DisposeInterface
    public void dispose() {
        this.mConfigHandler = null;
    }
}
