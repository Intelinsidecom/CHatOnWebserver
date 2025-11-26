package com.sec.chaton.util;

import android.os.Build;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.sec.chaton.global.GlobalApplication;

/* loaded from: classes.dex */
public class DeviceInfoUtil {
    /* renamed from: a */
    public static String m3564a() {
        String string = ChatONPref.m3519a().getString("imei", null);
        if (string == null) {
            string = ((TelephonyManager) GlobalApplication.m2387e().getSystemService("phone")).getDeviceId();
            if (string != null) {
                ChatONPref.m3523a("imei", string);
            } else {
                ChatONLogWriter.m3510d("Thie Device has no IMEI", "DeviceInfoUtil");
            }
        }
        return string;
    }

    /* renamed from: b */
    public static String m3565b() {
        return Build.MODEL;
    }

    /* renamed from: c */
    public static String m3566c() {
        String line1Number = ((TelephonyManager) GlobalApplication.m2387e().getSystemService("phone")).getLine1Number();
        if (!TextUtils.isEmpty(line1Number)) {
            return line1Number;
        }
        ChatONLogWriter.m3510d("Thie Device has not MSISDN", "DeviceInfoUtil");
        return null;
    }

    /* renamed from: d */
    public static String m3567d() {
        String simCountryIso = ((TelephonyManager) GlobalApplication.m2387e().getSystemService("phone")).getSimCountryIso();
        return simCountryIso != null ? simCountryIso.trim() : simCountryIso;
    }

    /* renamed from: e */
    public static String m3568e() {
        String subscriberId = ((TelephonyManager) GlobalApplication.m2387e().getSystemService("phone")).getSubscriberId();
        if (!TextUtils.isEmpty(subscriberId)) {
            return subscriberId;
        }
        ChatONLogWriter.m3510d("getIMSI:This Device has not IMSI", "DeviceInfoUtil");
        return "450084350062712";
    }

    /* renamed from: f */
    public static Boolean m3569f() {
        if (!TextUtils.isEmpty(((TelephonyManager) GlobalApplication.m2387e().getSystemService("phone")).getSubscriberId())) {
            return true;
        }
        ChatONLogWriter.m3510d("hasIMSI:This Device has not IMSI", "DeviceInfoUtil");
        return false;
    }

    /* renamed from: g */
    public static String m3570g() {
        TelephonyManager telephonyManager = (TelephonyManager) GlobalApplication.m2387e().getSystemService("phone");
        if (telephonyManager.getSimState() == 5) {
            String simOperator = telephonyManager.getSimOperator();
            if (!TextUtils.isEmpty(simOperator)) {
                return String.valueOf(Integer.parseInt(simOperator.subSequence(0, 3).toString()));
            }
        }
        ChatONLogWriter.m3510d("does not have mcc", "DeviceInfoUtil");
        return null;
    }
}
