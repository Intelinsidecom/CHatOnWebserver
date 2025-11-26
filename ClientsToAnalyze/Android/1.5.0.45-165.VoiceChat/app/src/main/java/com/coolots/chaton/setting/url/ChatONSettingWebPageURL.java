package com.coolots.chaton.setting.url;

import android.os.Build;
import android.telephony.TelephonyManager;
import com.sds.coolots.MainApplication;
import com.sds.coolots.common.util.Log;
import com.vlingo.sdk.internal.audio.TTSRequestParams;
import com.vlingo.sdk.internal.http.HttpUtil;

/* loaded from: classes.dex */
public class ChatONSettingWebPageURL {
    private static final String CLASSNAME = "[ChatONSettingWebPageURL]";
    private static final String ISO2_NATIONALCODE_DEFAULT = "en";
    private static final String ISO2_NATIONALCODE_KOREA = "ko";
    private static final String SETTING_WEB_URL_CONTACTUS = "voc.html";
    private static final String SETTING_WEB_URL_CONTACT_US = "http://smm.samsung.com/settings/v1/";
    private static final String SETTING_WEB_URL_FAQ = "help.html";
    private static final String SETTING_WEB_URL_NOTICE = "notice.html";
    private static final String SETTING_WEB_URL_OPENLICENCE = "open_source_license.html";
    private static final String SETTING_WEB_URL_SERVICE_GUIDE = "guide.html";
    private static final String SETTING_WEB_URL_TERMS = "terms_global.html";
    private String mSettingWebURL = null;
    private String osType = null;
    private String osVer = null;
    private int mccValue = 0;
    private String langCode = null;
    private String cuSender = null;
    private String cuVersion = null;
    private String cuConnection = null;
    private String cuDisplay = null;
    private String cuBrand = null;
    private String cuServer = null;

    private void logE(String message) {
        Log.m2958e(CLASSNAME + message);
    }

    private void logI(String message) {
        Log.m2963i(CLASSNAME + message);
    }

    public void setSender() {
        TelephonyManager telManager = (TelephonyManager) MainApplication.mContext.getSystemService("phone");
        this.cuSender = telManager.getLine1Number();
    }

    public void setVersion(String version) {
        this.cuVersion = version;
    }

    public void setConnection(String connection) {
        this.cuConnection = connection;
    }

    public void setDisplay(String sender) {
        this.cuDisplay = sender;
    }

    public void setBrand(String brand) {
        this.cuBrand = brand;
    }

    public void setServer(String serverr) {
        this.cuServer = serverr;
    }

    public void setOSType(String type) {
        this.osType = type;
    }

    public void setOSVersion(String version) {
        this.osVer = version;
    }

    public void setMCCValue(int value) {
        this.mccValue = value;
    }

    public void setLangCode(String code) {
        this.langCode = code;
    }

    public String getHttpGetValue() {
        setHttpGetValue();
        String strGetValue = "ostype=" + this.osType + "&osver=" + this.osVer + "&mcc=" + this.mccValue + "&lang=" + this.langCode;
        return strGetValue;
    }

    public String getContactusHttpGetValue() {
        setContactusHttpGetValue();
        String strContactusGetValue = "Sender=" + this.cuSender + "&Version=" + this.cuVersion + "&Connection=" + this.cuConnection + "&Display=" + this.cuDisplay + "&Brand=" + this.cuBrand + "&Server=" + this.cuServer + "&Service=ChatONV&lang=" + this.langCode;
        return strContactusGetValue;
    }

    public void setContactusHttpGetValue() {
        setSender();
        setVersion(Build.VERSION.RELEASE);
        setConnection("WIFI");
        setDisplay(Build.DISPLAY);
        setBrand(Build.BRAND);
        setServer("ChatONV");
        if (this.langCode.equals("")) {
            setLangCode(ISO2_NATIONALCODE_KOREA);
        }
    }

    public void setHttpGetValue() {
        setOSType("android");
        setOSVersion("2.3");
        setMCCValue(450);
        if (this.langCode.equals("")) {
            setLangCode(ISO2_NATIONALCODE_KOREA);
        }
    }

    public void setWebURL(String url) {
        logI("setWebURL??" + url);
        this.mSettingWebURL = url;
    }

    public String getNoticeURL() {
        if (this.mSettingWebURL == null || this.mSettingWebURL.isEmpty()) {
            return "http://www.google.com";
        }
        logI("getNoticeURL() url: " + this.mSettingWebURL + SETTING_WEB_URL_NOTICE + "?" + getHttpGetValue());
        return String.valueOf(this.mSettingWebURL) + SETTING_WEB_URL_NOTICE + "?" + getHttpGetValue();
    }

    public String getFAQURL() {
        if (this.mSettingWebURL == null || this.mSettingWebURL.isEmpty()) {
            return "http://www.google.com";
        }
        logI("getFAQURL() url: " + this.mSettingWebURL + SETTING_WEB_URL_FAQ + "?" + getHttpGetValue());
        return String.valueOf(this.mSettingWebURL) + SETTING_WEB_URL_FAQ + "?" + getHttpGetValue();
    }

    public String getContactUsURL() {
        if (this.mSettingWebURL == null || this.mSettingWebURL.isEmpty()) {
            return "http://www.google.com";
        }
        logI("getContactUsURL() url: http://smm.samsung.com/settings/v1/voc.html?" + getContactusHttpGetValue());
        return "http://smm.samsung.com/settings/v1/voc.html";
    }

    public String getContactUsURLData() {
        setContactusHttpGetValue();
        StringBuffer sb = new StringBuffer();
        sb.append(TTSRequestParams.FROM).append("=").append(this.cuSender).append("&").append(TTSRequestParams.VERSION).append("=").append(this.cuVersion).append("&").append(HttpUtil.HEADER_CONNECTION).append("=").append(this.cuConnection).append("&").append("Display").append("=").append(this.cuDisplay).append("&").append("Brand").append("=").append(this.cuBrand).append("&").append("Server").append("=").append(this.cuServer).append("&").append("Service").append("=").append("chatonv").append("&").append("lang").append("=").append(this.langCode);
        return sb.toString();
    }

    public String getServiceGuideURL() {
        if (this.mSettingWebURL == null || this.mSettingWebURL.isEmpty()) {
            return "http://www.google.com";
        }
        logI("getServiceGuideURL() url: " + this.mSettingWebURL + SETTING_WEB_URL_SERVICE_GUIDE + "?" + getHttpGetValue());
        return String.valueOf(this.mSettingWebURL) + SETTING_WEB_URL_SERVICE_GUIDE;
    }

    public String getOpenLicenceURL() {
        if (this.mSettingWebURL == null || this.mSettingWebURL.isEmpty()) {
            return "http://www.google.com";
        }
        logI("getOpenLicenceURL() url: " + this.mSettingWebURL + SETTING_WEB_URL_OPENLICENCE + "?lang=" + this.langCode);
        return String.valueOf(this.mSettingWebURL) + SETTING_WEB_URL_OPENLICENCE + "?lang=" + this.langCode;
    }

    public String getTermsURL() {
        if (this.mSettingWebURL == null || this.mSettingWebURL.isEmpty()) {
            return "http://www.google.com";
        }
        logI("getTermsURL() url: " + this.mSettingWebURL + SETTING_WEB_URL_TERMS + "?" + getHttpGetValue());
        return String.valueOf(this.mSettingWebURL) + SETTING_WEB_URL_TERMS;
    }
}
