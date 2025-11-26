package com.sec.chaton.util;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.content.ActivityNotFoundException;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.net.Uri;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Process;
import android.os.RemoteException;
import android.os.UserHandle;
import android.os.UserManager;
import android.p004os.IVoIPInterface;
import android.p004os.ServiceManager;
import android.support.v4.content.LocalBroadcastManager;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.TypedValue;
import com.sec.chaton.R;
import com.sec.chaton.UpgradeDialog;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p035io.entry.GetVersionNotice;
import com.sec.chaton.push.C2099k;
import com.sec.chaton.push.util.C2117i;
import com.sec.common.CommonApplication;
import java.util.Locale;
import java.util.UUID;
import twitter4j.conf.PropertyConfiguration;

/* compiled from: DeviceInfoUtil.java */
/* renamed from: com.sec.chaton.util.am */
/* loaded from: classes.dex */
public class C3171am {
    /* renamed from: a */
    public static String m11045a() {
        String str;
        String strM10979a = C3159aa.m10962a().m10979a("imei", (String) null);
        if (TextUtils.isEmpty(strM10979a)) {
            TelephonyManager telephonyManager = (TelephonyManager) CommonApplication.m11493l().getSystemService("phone");
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
                C3250y.m11455d("device ID is " + str, "DeviceInfoUtil");
                C3159aa.m10966a("imei", str);
                return str;
            }
            C3250y.m11455d("Thie Device has no IMEI", "DeviceInfoUtil");
            WifiInfo connectionInfo = ((WifiManager) CommonApplication.m11493l().getSystemService("wifi")).getConnectionInfo();
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
                C3159aa.m10966a("imei", str2);
                C3250y.m11455d("device ID using mac address is " + str2, "DeviceInfoUtil");
                return str2;
            }
            C3250y.m11455d("Thie Device has no Mac Address", "DeviceInfoUtil");
            return macAddress;
        }
        return strM10979a;
    }

    /* renamed from: b */
    public static String m11055b() {
        return Build.MODEL;
    }

    /* renamed from: c */
    public static String m11057c() {
        String line1Number = ((TelephonyManager) CommonApplication.m11493l().getSystemService("phone")).getLine1Number();
        if (TextUtils.isEmpty(line1Number)) {
            C3250y.m11455d("Thie Device has not MSISDN", "DeviceInfoUtil");
            return null;
        }
        return line1Number;
    }

    /* renamed from: d */
    public static String m11060d() {
        String simCountryIso = ((TelephonyManager) CommonApplication.m11493l().getSystemService("phone")).getSimCountryIso();
        if (simCountryIso != null) {
            return simCountryIso.trim();
        }
        return simCountryIso;
    }

    /* renamed from: e */
    public static String m11062e() {
        String subscriberId = ((TelephonyManager) CommonApplication.m11493l().getSystemService("phone")).getSubscriberId();
        if (TextUtils.isEmpty(subscriberId)) {
            C3250y.m11455d("getIMSI:This Device has not IMSI", "DeviceInfoUtil");
            return "000000000000000";
        }
        return subscriberId;
    }

    /* renamed from: f */
    public static String m11064f() {
        String networkOperator = ((TelephonyManager) CommonApplication.m11493l().getSystemService("phone")).getNetworkOperator();
        if (!TextUtils.isEmpty(networkOperator)) {
            return networkOperator.substring(0, 3);
        }
        C3250y.m11455d("Net does not have mcc", "DeviceInfoUtil");
        return null;
    }

    /* renamed from: g */
    public static String m11066g() {
        String networkOperator = ((TelephonyManager) CommonApplication.m11493l().getSystemService("phone")).getNetworkOperator();
        if (!TextUtils.isEmpty(networkOperator)) {
            return networkOperator.substring(3);
        }
        C3250y.m11455d("Net does not have mnc", "DeviceInfoUtil");
        return null;
    }

    /* renamed from: h */
    public static String m11068h() {
        TelephonyManager telephonyManager = (TelephonyManager) CommonApplication.m11493l().getSystemService("phone");
        if (telephonyManager.getSimState() == 5) {
            String simOperator = telephonyManager.getSimOperator();
            if (!TextUtils.isEmpty(simOperator)) {
                return simOperator.substring(0, 3);
            }
        }
        C3250y.m11455d("does not have mcc", "DeviceInfoUtil");
        return null;
    }

    /* renamed from: i */
    public static String m11070i() {
        TelephonyManager telephonyManager = (TelephonyManager) CommonApplication.m11493l().getSystemService("phone");
        if (telephonyManager.getSimState() == 5) {
            String simOperator = telephonyManager.getSimOperator();
            if (!TextUtils.isEmpty(simOperator)) {
                return simOperator.substring(3);
            }
        }
        C3250y.m11455d("does not have mnc", "DeviceInfoUtil");
        return null;
    }

    /* renamed from: a */
    public static void m11047a(Context context) {
        String string = UUID.randomUUID().toString();
        SharedPreferences.Editor editorM8284a = C2099k.m8284a();
        C2099k.m8289a(editorM8284a, string);
        editorM8284a.commit();
        C3159aa.m10966a("imei", string.substring(0, 16));
        C3250y.m11450b("Generate random device id : " + C3159aa.m10962a().m10979a("imei", (String) null), "DeviceInfoUtil");
    }

    /* renamed from: j */
    public static boolean m11072j() {
        TelephonyManager telephonyManager = (TelephonyManager) CommonApplication.m11493l().getSystemService("phone");
        return telephonyManager == null || telephonyManager.getCallState() == 0;
    }

    /* renamed from: k */
    public static boolean m11073k() {
        IVoIPInterface iVoIPInterfaceAsInterface = IVoIPInterface.Stub.asInterface(ServiceManager.getService("voip"));
        if (iVoIPInterfaceAsInterface != null) {
            try {
                return iVoIPInterfaceAsInterface.isVoIPIdle();
            } catch (RemoteException e) {
            }
        }
        return true;
    }

    /* renamed from: l */
    public static String m11074l() {
        return Locale.getDefault().toString();
    }

    /* renamed from: m */
    public static boolean m11075m() {
        return C3214cb.m11261b();
    }

    /* renamed from: n */
    public static String m11076n() {
        Configuration configuration = CommonApplication.m11493l().getResources().getConfiguration();
        C3250y.m11450b("screen size : " + (configuration.screenLayout & 15), "DeviceInfoUtil");
        switch (configuration.screenLayout & 15) {
            case 1:
                return "small";
            case 2:
                return "normal";
            case 3:
                return "large";
            case 4:
                return "xlarge";
            default:
                return "normal";
        }
    }

    /* renamed from: o */
    public static boolean m11077o() {
        return CommonApplication.m11493l().getPackageManager().hasSystemFeature("android.hardware.camera");
    }

    /* renamed from: b */
    public static float m11053b(Context context) throws Resources.NotFoundException {
        float dimension = context.getResources().getDimension(R.dimen.font_size_normal);
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(android.R.attr.textAppearanceMedium, typedValue, true);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(typedValue.data, new int[]{android.R.attr.textSize});
        int dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(0, (int) dimension);
        typedArrayObtainStyledAttributes.recycle();
        return dimensionPixelSize;
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x006a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* renamed from: p */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String m11078p() throws java.lang.Throwable {
        /*
            r2 = 0
            java.io.BufferedReader r1 = new java.io.BufferedReader     // Catch: java.io.FileNotFoundException -> L54 java.lang.Throwable -> L66
            java.io.InputStreamReader r0 = new java.io.InputStreamReader     // Catch: java.io.FileNotFoundException -> L54 java.lang.Throwable -> L66
            java.io.FileInputStream r3 = new java.io.FileInputStream     // Catch: java.io.FileNotFoundException -> L54 java.lang.Throwable -> L66
            java.lang.String r4 = "/system/csc/sales_code.dat"
            r3.<init>(r4)     // Catch: java.io.FileNotFoundException -> L54 java.lang.Throwable -> L66
            r0.<init>(r3)     // Catch: java.io.FileNotFoundException -> L54 java.lang.Throwable -> L66
            r1.<init>(r0)     // Catch: java.io.FileNotFoundException -> L54 java.lang.Throwable -> L66
            r0 = r2
        L13:
            java.lang.String r2 = r1.readLine()     // Catch: java.lang.Throwable -> L75 java.io.FileNotFoundException -> L77
            if (r2 == 0) goto L33
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L75 java.io.FileNotFoundException -> L77
            r0.<init>()     // Catch: java.lang.Throwable -> L75 java.io.FileNotFoundException -> L77
            java.lang.String r3 = "CSC read "
            java.lang.StringBuilder r0 = r0.append(r3)     // Catch: java.lang.Throwable -> L75 java.io.FileNotFoundException -> L77
            java.lang.StringBuilder r0 = r0.append(r2)     // Catch: java.lang.Throwable -> L75 java.io.FileNotFoundException -> L77
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Throwable -> L75 java.io.FileNotFoundException -> L77
            java.lang.String r3 = "DeviceInfoUtil"
            com.sec.chaton.util.C3250y.m11450b(r0, r3)     // Catch: java.lang.Throwable -> L75 java.io.FileNotFoundException -> L77
            r0 = r2
            goto L13
        L33:
            r1.close()     // Catch: java.lang.Throwable -> L75 java.io.FileNotFoundException -> L77
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L75 java.io.FileNotFoundException -> L77
            r2.<init>()     // Catch: java.lang.Throwable -> L75 java.io.FileNotFoundException -> L77
            java.lang.String r3 = "CSC is "
            java.lang.StringBuilder r2 = r2.append(r3)     // Catch: java.lang.Throwable -> L75 java.io.FileNotFoundException -> L77
            java.lang.StringBuilder r2 = r2.append(r0)     // Catch: java.lang.Throwable -> L75 java.io.FileNotFoundException -> L77
            java.lang.String r2 = r2.toString()     // Catch: java.lang.Throwable -> L75 java.io.FileNotFoundException -> L77
            java.lang.String r3 = "DeviceInfoUtil"
            com.sec.chaton.util.C3250y.m11450b(r2, r3)     // Catch: java.lang.Throwable -> L75 java.io.FileNotFoundException -> L77
            if (r1 == 0) goto L53
            r1.close()     // Catch: java.io.IOException -> L73
        L53:
            return r0
        L54:
            r0 = move-exception
            r1 = r2
        L56:
            r0.printStackTrace()     // Catch: java.lang.Throwable -> L75
            java.lang.String r0 = ""
            if (r1 == 0) goto L53
            r1.close()     // Catch: java.io.IOException -> L61
            goto L53
        L61:
            r1 = move-exception
        L62:
            r1.printStackTrace()
            goto L53
        L66:
            r0 = move-exception
            r1 = r2
        L68:
            if (r1 == 0) goto L6d
            r1.close()     // Catch: java.io.IOException -> L6e
        L6d:
            throw r0
        L6e:
            r1 = move-exception
            r1.printStackTrace()
            goto L6d
        L73:
            r1 = move-exception
            goto L62
        L75:
            r0 = move-exception
            goto L68
        L77:
            r0 = move-exception
            goto L56
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.util.C3171am.m11078p():java.lang.String");
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0013, code lost:
    
        r0 = false;
     */
    /* renamed from: c */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean m11059c(android.content.Context r3) {
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
            com.sec.chaton.util.C3250y.m11450b(r0, r2)     // Catch: java.lang.Exception -> L1d
            r0 = r1
            goto L13
        L1d:
            r0 = move-exception
            r0.printStackTrace()
        L21:
            r0 = r1
            goto L13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.util.C3171am.m11059c(android.content.Context):boolean");
    }

    /* renamed from: q */
    public static String m11079q() {
        return C3159aa.m10962a().m10979a("samsung_account_email", "");
    }

    /* renamed from: r */
    public static boolean m11080r() {
        return C3159aa.m10962a().m10977a("did_samsung_account_mapping", (Boolean) false).booleanValue();
    }

    /* renamed from: s */
    public static void m11081s() {
        C3159aa.m10962a().m10981a("UpdateIsCritical");
        C3159aa.m10962a().m10981a("UpdateTargetVersion");
        C3159aa.m10962a().m10981a("UpdateUrl");
        C3159aa.m10962a().m10981a("SamsungappsUrl");
        C3159aa.m10962a().m10981a("UpdateIsNormal");
    }

    /* renamed from: t */
    public static String m11082t() {
        String strM10979a = C3159aa.m10962a().m10979a("account_country_code", "");
        String strM10979a2 = C3159aa.m10962a().m10979a("country_ISO", "");
        String strM10979a3 = C3159aa.m10962a().m10979a("country_letter", "");
        C3250y.m11450b(" accountISO : " + strM10979a + " registISO : " + strM10979a2 + " skipRegiISO : " + strM10979a3, "DeviceInfoUtil");
        if (TextUtils.isEmpty(strM10979a)) {
            return !TextUtils.isEmpty(strM10979a2) ? strM10979a2 : !TextUtils.isEmpty(strM10979a3) ? strM10979a3 : "";
        }
        return strM10979a;
    }

    /* renamed from: a */
    public static boolean m11052a(String str) {
        String strM11082t = m11082t();
        C3250y.m11450b("Received ISO2 : " + str + " CurrentISO2 : " + strM11082t, "DeviceInfoUtil");
        return str.equals(strM11082t);
    }

    /* renamed from: d */
    public static boolean m11061d(Context context) throws PackageManager.NameNotFoundException {
        PackageInfo packageInfo;
        try {
            packageInfo = context.getPackageManager().getPackageInfo("com.osp.app.signin", 0);
        } catch (PackageManager.NameNotFoundException e) {
            C3250y.m11455d(e.toString(), "DeviceInfoUtil");
            packageInfo = null;
        }
        return packageInfo != null && packageInfo.versionCode >= 12005;
    }

    /* renamed from: a */
    public static void m11049a(GetVersionNotice getVersionNotice, Context context, boolean z, String str) {
        if (C3250y.f11734b) {
            C3250y.m11450b("come in handleUpdate", "handleUpdate");
        }
        boolean zBooleanValue = false;
        if (getVersionNotice.critical != null) {
            zBooleanValue = getVersionNotice.critical.booleanValue();
        }
        C3159aa.m10962a().m10986b("UpdateTargetVersion", getVersionNotice.newversion);
        C3159aa.m10962a().m10983b("UpdateIsCritical", getVersionNotice.critical);
        C3159aa.m10962a().m10983b("UpdateIsNormal", getVersionNotice.uptodate);
        C3159aa.m10962a().m10986b("UpdateUrl", getVersionNotice.downloadurl);
        C3159aa.m10962a().m10986b("SamsungappsUrl", getVersionNotice.samsungappsurl);
        if (z) {
            LocalBroadcastManager.getInstance(context.getApplicationContext()).sendBroadcast(new Intent("more_tab_badge_update"));
        }
        Intent intent = new Intent(context, (Class<?>) UpgradeDialog.class);
        intent.putExtra("isCritical", zBooleanValue);
        intent.putExtra("isFromHome", z);
        intent.putExtra("isReadyApps", str);
        intent.setFlags(131072);
        context.startActivity(intent);
    }

    /* renamed from: a */
    public static void m11051a(String str, String str2, boolean z) {
        if (C3250y.f11736d) {
            C3250y.m11455d("[addAccount] key : " + str + " mUid : " + str2 + " withMSISDN : " + z, "DeviceInfoUtil");
        }
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            Account account = new Account(str, "com.sec.chaton");
            AccountManager.get(CommonApplication.m11493l()).addAccountExplicitly(account, str2, null);
            if (z) {
                ContentResolver.setSyncAutomatically(account, "com.android.contacts", true);
            } else {
                ContentResolver.setIsSyncable(account, "com.android.contacts", 0);
            }
        }
    }

    /* renamed from: a */
    public static void m11050a(String str, Object obj) {
        if (C3250y.f11734b) {
            C3250y.m11450b("writePrefWithoutEncrypt, key : " + str + " value : " + obj, "DeviceInfoUtil");
        }
        SharedPreferences.Editor editorEdit = CommonApplication.m11493l().getApplicationContext().getSharedPreferences("com.sec.chaton_preferences", 0).edit();
        if (obj instanceof Boolean) {
            editorEdit.putBoolean(str, ((Boolean) obj).booleanValue());
        }
        if (Build.VERSION.SDK_INT > 8) {
            editorEdit.apply();
        } else {
            editorEdit.commit();
        }
    }

    /* renamed from: e */
    public static String m11063e(Context context) {
        if (C2117i.m8370a(context)) {
            if (C3159aa.m10962a().m10977a("spp_available", (Boolean) false).booleanValue()) {
                try {
                    return "SPP ver " + context.getPackageManager().getPackageInfo("com.sec.spp.push", 0).versionName;
                } catch (Exception e) {
                    e.toString();
                    return "SPP ver ";
                }
            }
            return "Not Available";
        }
        return "In-App Push";
    }

    /* renamed from: f */
    public static String m11065f(Context context) throws PackageManager.NameNotFoundException {
        try {
            return "SSO ver " + context.getPackageManager().getPackageInfo("com.osp.app.signin", 0).versionName;
        } catch (PackageManager.NameNotFoundException e) {
            return "Not Installed";
        }
    }

    /* renamed from: g */
    public static String m11067g(Context context) throws PackageManager.NameNotFoundException {
        try {
            return "ChatONV ver " + context.getPackageManager().getPackageInfo("com.coolots.chaton", 0).versionName;
        } catch (PackageManager.NameNotFoundException e) {
            try {
                return "ChatONV ver " + context.getPackageManager().getPackageInfo("com.coolots.chatonforcanada", 0).versionName;
            } catch (PackageManager.NameNotFoundException e2) {
                return "Not Installed";
            }
        }
    }

    /* renamed from: a */
    public static Intent m11044a(Intent intent) {
        intent.setFlags(268435456);
        intent.addFlags(67108864);
        intent.addFlags(536870912);
        intent.setFlags(65536);
        return intent;
    }

    /* renamed from: b */
    public static void m11056b(String str) {
        try {
            GlobalApplication.m11493l().startActivity(m11054b(new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=" + str))));
        } catch (ActivityNotFoundException e) {
            if (C3250y.f11734b) {
                C3250y.m11450b("There is no google play in the device", "gotoGooglePlayFor3rd");
            }
            GlobalApplication.m11493l().startActivity(m11054b(new Intent("android.intent.action.VIEW", Uri.parse("http://play.google.com/store/apps/details?id=" + str))));
        }
    }

    /* renamed from: b */
    public static Intent m11054b(Intent intent) {
        intent.addFlags(268435456);
        intent.addFlags(67108864);
        intent.addFlags(32);
        return intent;
    }

    /* renamed from: c */
    public static void m11058c(String str) {
        Intent intent = new Intent();
        intent.setClassName("com.sec.android.app.samsungapps", "com.sec.android.app.samsungapps.Main");
        intent.putExtra("directcall", true);
        intent.putExtra("CallerType", 1);
        intent.putExtra("GUID", str);
        GlobalApplication.m11493l().startActivity(m11054b(intent));
    }

    /* renamed from: u */
    public static String m11083u() {
        TelephonyManager telephonyManager = (TelephonyManager) GlobalApplication.m11493l().getSystemService("phone");
        if (telephonyManager.getSimState() == 5) {
            String simOperator = telephonyManager.getSimOperator();
            if (!TextUtils.isEmpty(simOperator)) {
                return simOperator.subSequence(0, 3).toString();
            }
        }
        C3250y.m11455d("does not have mcc", "DeviceInfoUtil");
        return null;
    }

    /* renamed from: v */
    public static String m11084v() {
        TelephonyManager telephonyManager = (TelephonyManager) GlobalApplication.m11493l().getSystemService("phone");
        if (telephonyManager.getSimState() == 5) {
            String simOperator = telephonyManager.getSimOperator();
            if (!TextUtils.isEmpty(simOperator)) {
                return simOperator.substring(3).toString();
            }
        }
        C3250y.m11455d("does not have mnc", "DeviceInfoUtil");
        return null;
    }

    /* renamed from: a */
    public static void m11048a(Context context, String str) {
        PackageManager packageManager = CommonApplication.m11493l().getPackageManager();
        if (str != null) {
            try {
                context.startActivity(packageManager.getLaunchIntentForPackage(str));
            } catch (ActivityNotFoundException e) {
                C3250y.m11443a(e, " - There is no such a activity.");
            }
        }
    }

    /* renamed from: h */
    public static boolean m11069h(Context context) {
        TelephonyManager telephonyManager;
        try {
            telephonyManager = (TelephonyManager) context.getSystemService("phone");
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (telephonyManager != null) {
            if (telephonyManager.getCallState() == 1) {
                if (C3250y.f11735c) {
                    C3250y.m11450b("ringing phone call, return true", "DeviceInfoUtil");
                }
                return true;
            }
            return false;
        }
        if (C3250y.f11735c) {
            C3250y.m11453c("Null Pointer Exception set isRinging as false", "DeviceInfoUtil");
        }
        return false;
    }

    /* renamed from: i */
    public static boolean m11071i(Context context) {
        UserHandle userHandleMyUserHandle = Process.myUserHandle();
        UserManager userManager = (UserManager) GlobalApplication.m11493l().getSystemService(PropertyConfiguration.USER);
        return userManager != null && userManager.getSerialNumberForUser(userHandleMyUserHandle) == 0;
    }

    /* renamed from: a */
    public static String m11046a(String str, String str2, String str3) {
        if (C3250y.f11734b) {
            C3250y.m11450b("networkMsg : " + str + "errorMsg : " + str2 + "errorCode : " + str3, "getMessageErrorCode");
        }
        if (!TextUtils.isEmpty(str3)) {
            if (!TextUtils.isEmpty(str2)) {
                return str2 + " (" + str3 + ")";
            }
            return str + " (" + str3 + ")";
        }
        return str;
    }
}
