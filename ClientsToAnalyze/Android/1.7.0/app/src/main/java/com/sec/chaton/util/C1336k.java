package com.sec.chaton.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.res.Configuration;
import android.net.ConnectivityManager;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.RemoteException;
import android.p000os.IVoIPInterface;
import android.p000os.ServiceManager;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.push.C0904h;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.Locale;
import java.util.UUID;

/* compiled from: DeviceInfoUtil.java */
/* renamed from: com.sec.chaton.util.k */
/* loaded from: classes.dex */
public class C1336k {
    /* renamed from: a */
    public static String m4621a() {
        String string = C1323bs.m4575a().getString("imei", null);
        if (string == null) {
            String deviceId = ((TelephonyManager) GlobalApplication.m3100a().getSystemService("phone")).getDeviceId();
            if (deviceId != null) {
                C1323bs.m4579a("imei", deviceId);
                return deviceId;
            }
            C1341p.m4661d("Thie Device has no IMEI", "DeviceInfoUtil");
            WifiInfo connectionInfo = ((WifiManager) GlobalApplication.m3100a().getSystemService("wifi")).getConnectionInfo();
            StringBuilder sb = new StringBuilder();
            if (connectionInfo == null) {
                return deviceId;
            }
            String macAddress = connectionInfo.getMacAddress();
            if (macAddress != null) {
                String strReplace = macAddress.replace(":", "");
                for (int length = strReplace.length(); length < 14; length++) {
                    sb.append("M");
                }
                String str = ((Object) sb) + strReplace;
                C1323bs.m4579a("imei", str);
                C1341p.m4661d("device ID using mac address is " + str, "DeviceInfoUtil");
                return str;
            }
            C1341p.m4661d("Thie Device has no Mac Address", "DeviceInfoUtil");
            return macAddress;
        }
        return string;
    }

    /* renamed from: b */
    public static boolean m4623b() {
        return ((TelephonyManager) GlobalApplication.m3100a().getSystemService("phone")).getDeviceId() != null;
    }

    /* renamed from: c */
    public static String m4625c() {
        return Build.MODEL;
    }

    /* renamed from: d */
    public static String m4627d() {
        String line1Number = ((TelephonyManager) GlobalApplication.m3100a().getSystemService("phone")).getLine1Number();
        if (TextUtils.isEmpty(line1Number)) {
            C1341p.m4661d("Thie Device has not MSISDN", "DeviceInfoUtil");
            return null;
        }
        return line1Number;
    }

    /* renamed from: e */
    public static String m4628e() {
        String simCountryIso = ((TelephonyManager) GlobalApplication.m3100a().getSystemService("phone")).getSimCountryIso();
        if (simCountryIso != null) {
            return simCountryIso.trim();
        }
        return simCountryIso;
    }

    /* renamed from: f */
    public static String m4629f() {
        String subscriberId = ((TelephonyManager) GlobalApplication.m3100a().getSystemService("phone")).getSubscriberId();
        if (TextUtils.isEmpty(subscriberId)) {
            C1341p.m4661d("getIMSI:This Device has not IMSI", "DeviceInfoUtil");
            return "000000000000000";
        }
        return subscriberId;
    }

    /* renamed from: g */
    public static String m4630g() {
        TelephonyManager telephonyManager = (TelephonyManager) GlobalApplication.m3100a().getSystemService("phone");
        if (telephonyManager.getSimState() == 5) {
            String simOperator = telephonyManager.getSimOperator();
            if (!TextUtils.isEmpty(simOperator)) {
                return String.valueOf(Integer.parseInt(simOperator.subSequence(0, 3).toString()));
            }
        }
        C1341p.m4661d("does not have mcc", "DeviceInfoUtil");
        return null;
    }

    /* renamed from: a */
    public static void m4622a(Context context) {
        String string = UUID.randomUUID().toString();
        SharedPreferences.Editor editorM3538a = C0904h.m3538a();
        C0904h.m3542a(editorM3538a, string);
        editorM3538a.commit();
        C1323bs.m4579a("imei", string);
        C1341p.m4658b("Generate random device id : " + C1323bs.m4575a().getString("imei", null), "DeviceInfoUtil");
    }

    /* renamed from: h */
    public static boolean m4631h() {
        TelephonyManager telephonyManager = (TelephonyManager) GlobalApplication.m3100a().getSystemService("phone");
        return telephonyManager == null || telephonyManager.getCallState() == 0;
    }

    /* renamed from: i */
    public static boolean m4632i() {
        IVoIPInterface iVoIPInterfaceAsInterface = IVoIPInterface.Stub.asInterface(ServiceManager.getService("voip"));
        if (iVoIPInterfaceAsInterface != null) {
            try {
                return iVoIPInterfaceAsInterface.isVoIPIdle();
            } catch (RemoteException e) {
            }
        }
        return true;
    }

    /* renamed from: j */
    public static String m4633j() {
        return Locale.getDefault().toString();
    }

    /* renamed from: k */
    public static boolean m4634k() {
        Iterator<ApplicationInfo> it = GlobalApplication.m3100a().getPackageManager().getInstalledApplications(8192).iterator();
        while (it.hasNext()) {
            if (it.next().packageName.equals("com.sec.android.app.samsungapps")) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: l */
    public static String m4635l() {
        Configuration configuration = GlobalApplication.m3100a().getResources().getConfiguration();
        C1341p.m4658b("screen size : " + (configuration.screenLayout & 15), "DeviceInfoUtil");
        switch (configuration.screenLayout & 15) {
        }
        return "normal";
    }

    /* renamed from: b */
    public static boolean m4624b(Context context) {
        return context.getPackageManager().hasSystemFeature("android.hardware.camera");
    }

    /* renamed from: m */
    public static String m4636m() {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream("/system/csc/sales_code.dat")));
            String str = null;
            while (true) {
                String line = bufferedReader.readLine();
                if (line != null) {
                    C1341p.m4658b("CSC read " + line, "DeviceInfoUtil");
                    str = line;
                } else {
                    bufferedReader.close();
                    C1341p.m4658b("CSC is " + str, "DeviceInfoUtil");
                    return str;
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return "";
        }
    }

    /* renamed from: n */
    public static boolean m4637n() {
        ConnectivityManager connectivityManager = (ConnectivityManager) GlobalApplication.m3100a().getSystemService("connectivity");
        boolean zIsConnected = connectivityManager.getNetworkInfo(1).isConnected();
        boolean zIsConnected2 = connectivityManager.getNetworkInfo(0).isConnected();
        if (zIsConnected || zIsConnected2) {
            C1341p.m4658b("isWifiConnected = " + zIsConnected + ", is3GConnected = " + zIsConnected2, "DeviceInfoUtil");
            return true;
        }
        C1341p.m4658b("isWifiConnected = " + zIsConnected + ", is3GConnected = " + zIsConnected2, "DeviceInfoUtil");
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0013, code lost:
    
        r0 = false;
     */
    /* renamed from: c */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean m4626c(android.content.Context r3) {
        /*
            r1 = 0
            java.lang.String r0 = "phone"
            java.lang.Object r0 = r3.getSystemService(r0)     // Catch: java.lang.Exception -> L1d
            android.telephony.TelephonyManager r0 = (android.telephony.TelephonyManager) r0     // Catch: java.lang.Exception -> L1d
            if (r0 == 0) goto L14
            int r0 = r0.getCallState()     // Catch: java.lang.Exception -> L1d
            r2 = 2
            if (r0 != r2) goto L21
            r0 = 1
        L13:
            return r0
        L14:
            java.lang.String r0 = "Null Pointer Exception set isOnCall as false"
            java.lang.String r2 = "DeviceInfoUtil"
            com.sec.chaton.util.C1341p.m4658b(r0, r2)     // Catch: java.lang.Exception -> L1d
            r0 = r1
            goto L13
        L1d:
            r0 = move-exception
            r0.printStackTrace()
        L21:
            r0 = r1
            goto L13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.util.C1336k.m4626c(android.content.Context):boolean");
    }
}
