package com.vlingo.sdk.internal.deviceinfo;

import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import com.coolots.sso.util.ChatONVAPII;
import com.vlingo.sdk.internal.core.ApplicationAdapter;
import com.vlingo.sdk.internal.crypto.CryptoUtils;
import com.vlingo.sdk.internal.location.LocationUtils;
import com.vlingo.sdk.internal.logging.Logger;
import com.vlingo.sdk.internal.util.StringUtils;

/* loaded from: classes.dex */
public class PhoneInfo {
    private static PhoneInfo instance;
    protected static final Logger log = Logger.getLogger(PhoneInfo.class);
    String deviceId = null;

    public static synchronized PhoneInfo getInstance() {
        if (instance == null) {
            instance = new PhoneInfo();
        }
        return instance;
    }

    public static void destroy() {
        instance = null;
    }

    public static String hashForPhoneNumber(String number) {
        int len = number.length();
        StringBuffer sb = new StringBuffer(len);
        for (int i = 0; i < len; i++) {
            char c = number.charAt(i);
            if (Character.isDigit(c)) {
                sb.append(c);
            }
        }
        if (sb.length() > 7) {
            sb.delete(0, sb.length() - 7);
        }
        return CryptoUtils.getHash(sb.toString(), 2);
    }

    Context getCtx() {
        return ApplicationAdapter.getInstance().getApplicationContext();
    }

    TelephonyManager getManager() {
        return (TelephonyManager) getCtx().getSystemService("phone");
    }

    WifiManager getWifiManager() {
        return (WifiManager) getCtx().getSystemService("wifi");
    }

    public String getModel() {
        return myModel();
    }

    private static String myModel() {
        if (Build.MODEL.equals("HTC Paradise")) {
            return "ventura";
        }
        if (Build.MODEL.equals("HTC Liberty")) {
            return "intruder";
        }
        return Build.MODEL;
    }

    public String getCarrierCountry() {
        String s = LocationUtils.getCarrierCountry(getCtx());
        if (s == null || s.length() == 0) {
            s = LocationUtils.getMCC();
            if ("000".equals(s)) {
                s = null;
            }
        }
        if (s == null) {
            s = "";
        }
        return s.toUpperCase();
    }

    public String getCurrentCarrier() {
        String networkOperatorName = getManager().getNetworkOperatorName();
        String carrier = networkOperatorName.replaceAll("[^A-Za-z0-9]", "");
        if (!carrier.equals(networkOperatorName)) {
            log.debug("carrier name cleansed, was '" + networkOperatorName + "', now '" + carrier + "'");
        }
        return carrier;
    }

    public String getCurrentNetworkISO3CountryCode() {
        return CountryUtils.ISO2ToISO3CountryCode(getCarrierCountry());
    }

    public String getDeviceID() {
        WifiInfo info;
        if (this.deviceId == null) {
            this.deviceId = getManager().getDeviceId();
            if (StringUtils.isNullOrWhiteSpace(this.deviceId) && Build.VERSION.SDK_INT >= 9) {
                this.deviceId = Build.SERIAL;
            }
            if (StringUtils.isNullOrWhiteSpace(this.deviceId) && (info = getWifiManager().getConnectionInfo()) != null) {
                this.deviceId = info.getMacAddress();
                if (this.deviceId != null) {
                    this.deviceId = StringUtils.replace(this.deviceId, ChatONVAPII.USERID_DELEMETER, "");
                }
            }
            if (StringUtils.isNullOrWhiteSpace(this.deviceId) && Build.VERSION.SDK_INT >= 8) {
                this.deviceId = Settings.Secure.getString(getCtx().getContentResolver(), "android_id");
            }
        }
        return this.deviceId;
    }

    public String getOSVersion() {
        return Build.VERSION.RELEASE;
    }

    public String getPhoneNumber() {
        return "";
    }

    public String getPhoneNumberHash() {
        return "";
    }

    public String getShortOSVersion() {
        return Build.VERSION.RELEASE;
    }

    public String getVendorCarrier() {
        return Build.BRAND;
    }

    public String getVendorCountry() {
        return null;
    }

    public int getVendorID() {
        return 0;
    }

    public String getVendorName() {
        return Build.MANUFACTURER;
    }

    public boolean isSimulator() {
        return false;
    }

    public boolean isTouchDevice() {
        return true;
    }
}
