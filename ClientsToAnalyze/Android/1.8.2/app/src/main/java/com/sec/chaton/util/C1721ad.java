package com.sec.chaton.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.res.Configuration;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.RemoteException;
import android.p000os.IVoIPInterface;
import android.p000os.ServiceManager;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.push.C1126j;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.Locale;
import java.util.UUID;

/* compiled from: DeviceInfoUtil.java */
/* renamed from: com.sec.chaton.util.ad */
/* loaded from: classes.dex */
public class C1721ad {
    /* renamed from: a */
    public static String m5873a() {
        String str;
        String string = C1789u.m6075a().getString("imei", null);
        if (string == null) {
            TelephonyManager telephonyManager = (TelephonyManager) GlobalApplication.m3260b().getSystemService("phone");
            String deviceId = telephonyManager.getDeviceId();
            if (deviceId != null) {
                if (telephonyManager.getPhoneType() == 2) {
                    StringBuilder sb = new StringBuilder();
                    for (int length = deviceId.length(); length < 14; length++) {
                        sb.append("0");
                    }
                    str = deviceId + ((Object) sb);
                } else {
                    str = deviceId;
                }
                C1786r.m6065d("device ID is " + str, "DeviceInfoUtil");
                C1789u.m6079a("imei", str);
                return str;
            }
            C1786r.m6065d("Thie Device has no IMEI", "DeviceInfoUtil");
            WifiInfo connectionInfo = ((WifiManager) GlobalApplication.m3260b().getSystemService("wifi")).getConnectionInfo();
            StringBuilder sb2 = new StringBuilder();
            if (connectionInfo == null) {
                return deviceId;
            }
            String macAddress = connectionInfo.getMacAddress();
            if (macAddress != null) {
                String strReplace = macAddress.replace(":", "");
                for (int length2 = strReplace.length(); length2 < 14; length2++) {
                    sb2.append("M");
                }
                String str2 = ((Object) sb2) + strReplace;
                C1789u.m6079a("imei", str2);
                C1786r.m6065d("device ID using mac address is " + str2, "DeviceInfoUtil");
                return str2;
            }
            C1786r.m6065d("Thie Device has no Mac Address", "DeviceInfoUtil");
            return macAddress;
        }
        return string;
    }

    /* renamed from: b */
    public static Boolean m5875b() {
        return ((TelephonyManager) GlobalApplication.m3260b().getSystemService("phone")).getDeviceId() != null;
    }

    /* renamed from: c */
    public static String m5876c() {
        return Build.MODEL;
    }

    /* renamed from: d */
    public static String m5877d() {
        String line1Number = ((TelephonyManager) GlobalApplication.m3260b().getSystemService("phone")).getLine1Number();
        if (TextUtils.isEmpty(line1Number)) {
            C1786r.m6065d("Thie Device has not MSISDN", "DeviceInfoUtil");
            return null;
        }
        return line1Number;
    }

    /* renamed from: e */
    public static String m5878e() {
        TelephonyManager telephonyManager = (TelephonyManager) GlobalApplication.m3260b().getSystemService("phone");
        String simCountryIso = telephonyManager.getSimCountryIso();
        int simState = telephonyManager.getSimState();
        C1786r.m6061b("getSimCountryISO2L simCountryISO2L " + simCountryIso + " simState " + simState, "Chaton");
        if (simCountryIso == null || simState == 1 || simState == 0) {
            return null;
        }
        return simCountryIso.trim();
    }

    /* renamed from: f */
    public static String m5879f() {
        return Locale.getDefault().toString();
    }

    /* renamed from: g */
    public static String m5880g() {
        String subscriberId = ((TelephonyManager) GlobalApplication.m3260b().getSystemService("phone")).getSubscriberId();
        if (TextUtils.isEmpty(subscriberId)) {
            C1786r.m6065d("getIMSI:This Device has not IMSI", "DeviceInfoUtil");
            return "000000000000000";
        }
        return subscriberId;
    }

    /* renamed from: h */
    public static String m5881h() {
        String networkOperator = ((TelephonyManager) GlobalApplication.m3260b().getSystemService("phone")).getNetworkOperator();
        if (!TextUtils.isEmpty(networkOperator)) {
            return String.valueOf(Integer.parseInt(networkOperator.subSequence(0, 3).toString()));
        }
        C1786r.m6065d("Net does not have mcc", "DeviceInfoUtil");
        return null;
    }

    /* renamed from: i */
    public static String m5882i() {
        String networkOperator = ((TelephonyManager) GlobalApplication.m3260b().getSystemService("phone")).getNetworkOperator();
        if (!TextUtils.isEmpty(networkOperator)) {
            return String.valueOf(Integer.parseInt(networkOperator.substring(3).toString()));
        }
        C1786r.m6065d("Net does not have mnc", "DeviceInfoUtil");
        return null;
    }

    /* renamed from: j */
    public static String m5883j() {
        TelephonyManager telephonyManager = (TelephonyManager) GlobalApplication.m3260b().getSystemService("phone");
        if (telephonyManager.getSimState() == 5) {
            String simOperator = telephonyManager.getSimOperator();
            if (!TextUtils.isEmpty(simOperator)) {
                return String.valueOf(Integer.parseInt(simOperator.subSequence(0, 3).toString()));
            }
        }
        C1786r.m6065d("does not have mcc", "DeviceInfoUtil");
        return null;
    }

    /* renamed from: k */
    public static String m5884k() {
        TelephonyManager telephonyManager = (TelephonyManager) GlobalApplication.m3260b().getSystemService("phone");
        if (telephonyManager.getSimState() == 5) {
            String simOperator = telephonyManager.getSimOperator();
            if (!TextUtils.isEmpty(simOperator)) {
                return String.valueOf(Integer.parseInt(simOperator.substring(3).toString()));
            }
        }
        C1786r.m6065d("does not have mnc", "DeviceInfoUtil");
        return null;
    }

    /* renamed from: l */
    public static boolean m5885l() {
        String str = Build.MODEL;
        return (str.contains("P1010") || str.contains("YP-GS1") || str.contains("S5360")) ? false : true;
    }

    /* renamed from: m */
    public static boolean m5886m() {
        String str = Build.MODEL;
        return (str.contains("YP-GS1") || str.contains("S7500")) ? false : true;
    }

    /* renamed from: a */
    public static void m5874a(Context context) {
        String string = UUID.randomUUID().toString();
        SharedPreferences.Editor editorM4240a = C1126j.m4240a();
        C1126j.m4244a(editorM4240a, string);
        editorM4240a.commit();
        C1789u.m6079a("imei", string);
        C1786r.m6061b("Generate random device id : " + C1789u.m6075a().getString("imei", null), "DeviceInfoUtil");
    }

    /* renamed from: n */
    public static boolean m5887n() {
        TelephonyManager telephonyManager = (TelephonyManager) GlobalApplication.m3260b().getSystemService("phone");
        return telephonyManager == null || telephonyManager.getCallState() == 0;
    }

    /* renamed from: o */
    public static boolean m5888o() {
        IVoIPInterface iVoIPInterfaceAsInterface = IVoIPInterface.Stub.asInterface(ServiceManager.getService("voip"));
        if (iVoIPInterfaceAsInterface != null) {
            try {
                return iVoIPInterfaceAsInterface.isVoIPIdle();
            } catch (RemoteException e) {
            }
        }
        return true;
    }

    /* renamed from: p */
    public static boolean m5889p() {
        Iterator<ApplicationInfo> it = GlobalApplication.m3260b().getPackageManager().getInstalledApplications(8192).iterator();
        while (it.hasNext()) {
            if (it.next().packageName.equals("com.sec.android.app.samsungapps")) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: q */
    public static String m5890q() {
        Configuration configuration = GlobalApplication.m3260b().getResources().getConfiguration();
        C1786r.m6061b("screen size : " + (configuration.screenLayout & 15), "DeviceInfoUtil");
        switch (configuration.screenLayout & 15) {
        }
        return "normal";
    }

    /* renamed from: r */
    public static String m5891r() throws IOException {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream("/system/csc/sales_code.dat")));
            String str = null;
            while (true) {
                String line = bufferedReader.readLine();
                if (line != null) {
                    C1786r.m6061b("CSC read " + line, "DeviceInfoUtil");
                    str = line;
                } else {
                    bufferedReader.close();
                    C1786r.m6061b("CSC is " + str, "DeviceInfoUtil");
                    return str;
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return "";
        }
    }

    /* renamed from: s */
    public static String m5892s() {
        String string = C1789u.m6075a().getString("accept_disclaimer_iso", "");
        String string2 = C1789u.m6075a().getString("country_ISO", "");
        String string3 = C1789u.m6075a().getString("country_letter", "");
        C1786r.m6061b(" acceptMCC : " + string + " registISO : " + string2 + " midISO : " + string3, "DeviceInfoUtil");
        if (TextUtils.isEmpty(string)) {
            return !TextUtils.isEmpty(string3) ? string3 : !TextUtils.isEmpty(string2) ? string2 : m5878e().toUpperCase();
        }
        return string;
    }

    /* renamed from: t */
    public static String m5893t() {
        String string = C1789u.m6075a().getString("country_ISO", "");
        String upperCase = null;
        if (m5878e() != null) {
            upperCase = m5878e().toUpperCase();
        }
        String string2 = C1789u.m6075a().getString("country_letter", "");
        C1786r.m6061b(" registISO : " + string + " simISO : " + upperCase + " midISO : " + string2, "DeviceInfoUtil");
        if (!TextUtils.isEmpty(string)) {
            return string;
        }
        if (TextUtils.isEmpty(upperCase)) {
            return !TextUtils.isEmpty(string2) ? string2 : "";
        }
        return upperCase;
    }
}
