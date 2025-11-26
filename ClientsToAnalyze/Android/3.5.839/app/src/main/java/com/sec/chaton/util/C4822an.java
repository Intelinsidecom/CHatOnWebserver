package com.sec.chaton.util;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.annotation.SuppressLint;
import android.content.ActivityNotFoundException;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.hardware.motion.MotionRecognitionManager;
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
import android.provider.Settings;
import android.support.v4.content.C0096i;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.WindowManager;
import com.sec.chaton.R;
import com.sec.chaton.UpgradeDialog;
import com.sec.chaton.global.C2349a;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p065io.entry.GetVersionNotice;
import com.sec.chaton.privateplugin.data.Spam;
import com.sec.chaton.smsplugin.C3847e;
import com.sec.chaton.smsplugin.p111h.C3892o;
import com.sec.common.CommonApplication;
import com.sec.spp.push.Config;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.UUID;

/* compiled from: DeviceInfoUtil.java */
/* renamed from: com.sec.chaton.util.an */
/* loaded from: classes.dex */
public class C4822an {

    /* renamed from: b */
    private static final String f17607b = C4822an.class.getSimpleName();

    /* renamed from: c */
    private static int f17608c = 0;

    /* renamed from: a */
    public static int f17606a = 0;

    /* renamed from: a */
    public static boolean m18218a() {
        if (!C4809aa.m18104a().m18129b("uid")) {
            return false;
        }
        return true;
    }

    /* renamed from: b */
    public static boolean m18223b() {
        if (C2349a.m10301a("sms_feature")) {
            if (Build.VERSION.SDK_INT >= 19) {
                return C3892o.m15023b();
            }
            return m18226c();
        }
        return false;
    }

    /* renamed from: c */
    public static boolean m18226c() {
        if (C2349a.m10301a("sms_feature")) {
            return C4809aa.m18104a().m18119a("pref_key_using_sms_mms_mode", Boolean.valueOf(C3847e.m14688at())).booleanValue();
        }
        return false;
    }

    /* renamed from: d */
    public static String m18228d() {
        String str;
        String strM18121a = C4809aa.m18104a().m18121a("imei", (String) null);
        if (TextUtils.isEmpty(strM18121a)) {
            TelephonyManager telephonyManager = (TelephonyManager) CommonApplication.m18732r().getSystemService("phone");
            String deviceId = telephonyManager.getDeviceId();
            if (deviceId != null) {
                if (telephonyManager.getPhoneType() == 2) {
                    StringBuilder sb = new StringBuilder();
                    for (int length = deviceId.length(); length < 14; length++) {
                        sb.append(Spam.ACTIVITY_CANCEL);
                    }
                    str = deviceId + ((Object) sb);
                } else {
                    str = deviceId;
                }
                C4904y.m18645d("device ID is " + str, f17607b);
                C4809aa.m18108a("imei", str);
                return str;
            }
            C4904y.m18645d("Thie Device has no IMEI", f17607b);
            WifiInfo connectionInfo = ((WifiManager) CommonApplication.m18732r().getSystemService("wifi")).getConnectionInfo();
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
                C4809aa.m18108a("imei", str2);
                C4904y.m18645d("device ID using mac address is " + str2, f17607b);
                return str2;
            }
            C4904y.m18645d("Thie Device has no Mac Address", f17607b);
            return macAddress;
        }
        return strM18121a;
    }

    /* renamed from: e */
    public static String m18231e() {
        return Build.MODEL;
    }

    /* renamed from: f */
    public static String m18234f() {
        String line1Number = ((TelephonyManager) CommonApplication.m18732r().getSystemService("phone")).getLine1Number();
        if (TextUtils.isEmpty(line1Number)) {
            C4904y.m18645d("Thie Device has not MSISDN", f17607b);
            return null;
        }
        return line1Number;
    }

    /* renamed from: g */
    public static String m18236g() {
        String simCountryIso = ((TelephonyManager) CommonApplication.m18732r().getSystemService("phone")).getSimCountryIso();
        if (simCountryIso != null) {
            return simCountryIso.trim();
        }
        return simCountryIso;
    }

    /* renamed from: h */
    public static String m18238h() {
        String subscriberId = ((TelephonyManager) CommonApplication.m18732r().getSystemService("phone")).getSubscriberId();
        if (TextUtils.isEmpty(subscriberId)) {
            C4904y.m18645d("getIMSI:This Device has not IMSI", f17607b);
            return "000000000000000";
        }
        return subscriberId;
    }

    /* renamed from: i */
    public static String m18241i() {
        String networkOperator = ((TelephonyManager) CommonApplication.m18732r().getSystemService("phone")).getNetworkOperator();
        if (!TextUtils.isEmpty(networkOperator)) {
            try {
                return networkOperator.substring(0, 3);
            } catch (StringIndexOutOfBoundsException e) {
                if (C4904y.f17875e) {
                    C4904y.m18634a("Network MCC is unexcepted length", f17607b);
                }
            }
        }
        C4904y.m18645d("Net does not have mcc", f17607b);
        return null;
    }

    /* renamed from: j */
    public static String m18242j() {
        String networkOperator = ((TelephonyManager) CommonApplication.m18732r().getSystemService("phone")).getNetworkOperator();
        if (!TextUtils.isEmpty(networkOperator)) {
            try {
                return networkOperator.substring(3);
            } catch (StringIndexOutOfBoundsException e) {
                if (C4904y.f17875e) {
                    C4904y.m18634a("Network MNC is unexcepted length", f17607b);
                }
            }
        }
        C4904y.m18645d("Net does not have mnc", f17607b);
        return null;
    }

    /* renamed from: k */
    public static String m18243k() {
        String strM18121a = C4809aa.m18104a().m18121a("admin_mcc", (String) null);
        if (!TextUtils.isEmpty(strM18121a)) {
            if (C4904y.f17872b) {
                C4904y.m18639b("[getMCC] Admin MCC : " + strM18121a, f17607b);
                return strM18121a;
            }
            return strM18121a;
        }
        TelephonyManager telephonyManager = (TelephonyManager) CommonApplication.m18732r().getSystemService("phone");
        if (telephonyManager.getSimState() == 5) {
            String simOperator = telephonyManager.getSimOperator();
            if (!TextUtils.isEmpty(simOperator)) {
                try {
                    return simOperator.substring(0, 3);
                } catch (StringIndexOutOfBoundsException e) {
                    if (C4904y.f17875e) {
                        C4904y.m18634a("MCC is unexcepted length", f17607b);
                    }
                }
            }
        }
        C4904y.m18645d("does not have mcc", f17607b);
        return null;
    }

    /* renamed from: l */
    public static String m18244l() {
        TelephonyManager telephonyManager = (TelephonyManager) CommonApplication.m18732r().getSystemService("phone");
        if (telephonyManager.getSimState() == 5) {
            String simOperator = telephonyManager.getSimOperator();
            if (!TextUtils.isEmpty(simOperator)) {
                try {
                    return simOperator.substring(3);
                } catch (StringIndexOutOfBoundsException e) {
                    if (C4904y.f17875e) {
                        C4904y.m18634a("MNC is unexcepted length", f17607b);
                    }
                }
            }
        }
        C4904y.m18645d("does not have mnc", f17607b);
        return null;
    }

    /* renamed from: a */
    public static void m18211a(Context context) {
        C4809aa.m18108a("imei", UUID.randomUUID().toString().substring(0, 16));
        C4904y.m18639b("Generate random device id : " + C4809aa.m18104a().m18121a("imei", (String) null), f17607b);
    }

    /* renamed from: m */
    public static boolean m18245m() {
        TelephonyManager telephonyManager = (TelephonyManager) CommonApplication.m18732r().getSystemService("phone");
        return telephonyManager == null || telephonyManager.getCallState() == 0;
    }

    /* renamed from: n */
    public static boolean m18246n() {
        IVoIPInterface iVoIPInterfaceAsInterface = IVoIPInterface.Stub.asInterface(ServiceManager.getService("voip"));
        if (iVoIPInterfaceAsInterface != null) {
            try {
                return iVoIPInterfaceAsInterface.isVoIPIdle();
            } catch (RemoteException e) {
            }
        }
        return true;
    }

    /* renamed from: o */
    public static String m18247o() {
        return Locale.getDefault().toString();
    }

    /* renamed from: p */
    public static String m18248p() {
        return Locale.getDefault().getLanguage().toString();
    }

    /* renamed from: q */
    public static boolean m18249q() {
        return C4859bx.m18393b();
    }

    /* renamed from: r */
    public static String m18250r() {
        Configuration configuration = CommonApplication.m18732r().getResources().getConfiguration();
        C4904y.m18639b("screen size : " + (configuration.screenLayout & 15), f17607b);
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

    /* renamed from: s */
    public static boolean m18251s() {
        return CommonApplication.m18732r().getPackageManager().hasSystemFeature("android.hardware.camera");
    }

    /* renamed from: b */
    public static float m18220b(Context context) throws Resources.NotFoundException {
        float dimension = context.getResources().getDimension(R.dimen.font_size_normal);
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(android.R.attr.textAppearanceMedium, typedValue, true);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(typedValue.data, new int[]{android.R.attr.textSize});
        int dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(0, (int) dimension);
        typedArrayObtainStyledAttributes.recycle();
        return dimensionPixelSize;
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x006e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* renamed from: t */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String m18252t() throws java.lang.Throwable {
        /*
            r2 = 0
            java.io.BufferedReader r1 = new java.io.BufferedReader     // Catch: java.io.FileNotFoundException -> L57 java.lang.Throwable -> L6a
            java.io.InputStreamReader r0 = new java.io.InputStreamReader     // Catch: java.io.FileNotFoundException -> L57 java.lang.Throwable -> L6a
            java.io.FileInputStream r3 = new java.io.FileInputStream     // Catch: java.io.FileNotFoundException -> L57 java.lang.Throwable -> L6a
            java.lang.String r4 = "/system/csc/sales_code.dat"
            r3.<init>(r4)     // Catch: java.io.FileNotFoundException -> L57 java.lang.Throwable -> L6a
            r0.<init>(r3)     // Catch: java.io.FileNotFoundException -> L57 java.lang.Throwable -> L6a
            r1.<init>(r0)     // Catch: java.io.FileNotFoundException -> L57 java.lang.Throwable -> L6a
            r0 = r2
        L14:
            java.lang.String r2 = r1.readLine()     // Catch: java.lang.Throwable -> L79 java.io.FileNotFoundException -> L7b
            if (r2 == 0) goto L35
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L79 java.io.FileNotFoundException -> L7b
            r0.<init>()     // Catch: java.lang.Throwable -> L79 java.io.FileNotFoundException -> L7b
            java.lang.String r3 = "CSC read "
            java.lang.StringBuilder r0 = r0.append(r3)     // Catch: java.lang.Throwable -> L79 java.io.FileNotFoundException -> L7b
            java.lang.StringBuilder r0 = r0.append(r2)     // Catch: java.lang.Throwable -> L79 java.io.FileNotFoundException -> L7b
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Throwable -> L79 java.io.FileNotFoundException -> L7b
            java.lang.String r3 = com.sec.chaton.util.C4822an.f17607b     // Catch: java.lang.Throwable -> L79 java.io.FileNotFoundException -> L7b
            com.sec.chaton.util.C4904y.m18639b(r0, r3)     // Catch: java.lang.Throwable -> L79 java.io.FileNotFoundException -> L7b
            r0 = r2
            goto L14
        L35:
            r1.close()     // Catch: java.lang.Throwable -> L79 java.io.FileNotFoundException -> L7b
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L79 java.io.FileNotFoundException -> L7b
            r2.<init>()     // Catch: java.lang.Throwable -> L79 java.io.FileNotFoundException -> L7b
            java.lang.String r3 = "CSC is "
            java.lang.StringBuilder r2 = r2.append(r3)     // Catch: java.lang.Throwable -> L79 java.io.FileNotFoundException -> L7b
            java.lang.StringBuilder r2 = r2.append(r0)     // Catch: java.lang.Throwable -> L79 java.io.FileNotFoundException -> L7b
            java.lang.String r2 = r2.toString()     // Catch: java.lang.Throwable -> L79 java.io.FileNotFoundException -> L7b
            java.lang.String r3 = com.sec.chaton.util.C4822an.f17607b     // Catch: java.lang.Throwable -> L79 java.io.FileNotFoundException -> L7b
            com.sec.chaton.util.C4904y.m18639b(r2, r3)     // Catch: java.lang.Throwable -> L79 java.io.FileNotFoundException -> L7b
            if (r1 == 0) goto L56
            r1.close()     // Catch: java.io.IOException -> L77
        L56:
            return r0
        L57:
            r0 = move-exception
            r1 = r2
        L59:
            r0.printStackTrace()     // Catch: java.lang.Throwable -> L79
            java.lang.String r0 = ""
            if (r1 == 0) goto L56
            r1.close()     // Catch: java.io.IOException -> L65
            goto L56
        L65:
            r1 = move-exception
        L66:
            r1.printStackTrace()
            goto L56
        L6a:
            r0 = move-exception
            r1 = r2
        L6c:
            if (r1 == 0) goto L71
            r1.close()     // Catch: java.io.IOException -> L72
        L71:
            throw r0
        L72:
            r1 = move-exception
            r1.printStackTrace()
            goto L71
        L77:
            r1 = move-exception
            goto L66
        L79:
            r0 = move-exception
            goto L6c
        L7b:
            r0 = move-exception
            goto L59
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.util.C4822an.m18252t():java.lang.String");
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0014, code lost:
    
        r0 = false;
     */
    /* renamed from: c */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean m18227c(android.content.Context r3) {
        /*
            r1 = 0
            java.lang.String r0 = "phone"
            java.lang.Object r0 = r3.getSystemService(r0)     // Catch: java.lang.Exception -> L1f
            android.telephony.TelephonyManager r0 = (android.telephony.TelephonyManager) r0     // Catch: java.lang.Exception -> L1f
            if (r0 == 0) goto L15
            int r0 = r0.getCallState()     // Catch: java.lang.Exception -> L1f
            r2 = 2
            if (r0 != r2) goto L23
            r0 = 1
        L14:
            return r0
        L15:
            java.lang.String r0 = "Null Pointer Exception set isOnCall as false"
            java.lang.String r2 = com.sec.chaton.util.C4822an.f17607b     // Catch: java.lang.Exception -> L1f
            com.sec.chaton.util.C4904y.m18639b(r0, r2)     // Catch: java.lang.Exception -> L1f
            r0 = r1
            goto L14
        L1f:
            r0 = move-exception
            r0.printStackTrace()
        L23:
            r0 = r1
            goto L14
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.util.C4822an.m18227c(android.content.Context):boolean");
    }

    /* renamed from: u */
    public static String m18253u() {
        String strM18121a = C4809aa.m18104a().m18121a("accept_disclaimer_iso", "");
        String strM18121a2 = C4809aa.m18104a().m18121a("country_ISO", "");
        String strM18121a3 = C4809aa.m18104a().m18121a("country_letter", "");
        C4904y.m18639b(" acceptMCC : " + strM18121a + " registISO : " + strM18121a2 + " midISO : " + strM18121a3, f17607b);
        if (TextUtils.isEmpty(strM18121a)) {
            if (!TextUtils.isEmpty(strM18121a3)) {
                return strM18121a3;
            }
            if (!TextUtils.isEmpty(strM18121a2)) {
                return strM18121a2;
            }
            if (m18236g() != null) {
                return m18236g().toUpperCase();
            }
            return null;
        }
        return strM18121a;
    }

    /* renamed from: v */
    public static String m18254v() {
        return C4809aa.m18104a().m18121a("samsung_account_email", "");
    }

    /* renamed from: a */
    public static void m18215a(String str) {
        if (C4904y.f17872b) {
            C4904y.m18639b("putSamsungAcountEmail : " + str, f17607b);
        }
        if (!TextUtils.isEmpty(str) && !str.equals(m18254v())) {
            if (C4904y.f17872b) {
                C4904y.m18639b("SamsungAccountEmail was changed", f17607b);
            }
            C4809aa.m18108a("samsung_account_email", str);
            if (!C4809aa.m18104a().m18119a("register_with_phone", (Boolean) false).booleanValue() && m18255w()) {
                AccountManager accountManager = AccountManager.get(CommonApplication.m18732r());
                Account[] accountsByType = accountManager.getAccountsByType(Config.CHATON_PACKAGE_NAME);
                if (accountsByType.length > 0) {
                    String str2 = accountsByType[0].name;
                    if (C4904y.f17872b) {
                        C4904y.m18639b("accountEmail : " + str2, f17607b);
                    }
                    Account account = new Account(str2, Config.CHATON_PACKAGE_NAME);
                    accountManager.setUserData(account, "skip_deregi", "true");
                    accountManager.setUserData(account, "req_email", str);
                    accountManager.removeAccount(account, null, null);
                }
            }
        }
    }

    /* renamed from: w */
    public static boolean m18255w() {
        return C4809aa.m18104a().m18119a("did_samsung_account_mapping", (Boolean) false).booleanValue();
    }

    /* renamed from: x */
    public static void m18256x() {
        C4809aa.m18104a().m18123a("UpdateIsCritical");
        C4809aa.m18104a().m18123a("UpdateTargetVersion");
        C4809aa.m18104a().m18123a("UpdateUrl");
        C4809aa.m18104a().m18123a("SamsungappsUrl");
        C4809aa.m18104a().m18123a("UpdateIsNormal");
        C4809aa.m18104a().m18123a("UpdateAppsReady");
    }

    /* renamed from: y */
    public static String m18257y() {
        String strM18121a = C4809aa.m18104a().m18121a("account_country_code", "");
        String strM18121a2 = C4809aa.m18104a().m18121a("country_ISO", "");
        String strM18121a3 = C4809aa.m18104a().m18121a("country_letter", "");
        C4904y.m18639b(" accountISO : " + strM18121a + " registISO : " + strM18121a2 + " skipRegiISO : " + strM18121a3, f17607b);
        if (TextUtils.isEmpty(strM18121a)) {
            return !TextUtils.isEmpty(strM18121a2) ? strM18121a2 : !TextUtils.isEmpty(strM18121a3) ? strM18121a3 : "";
        }
        return strM18121a;
    }

    /* renamed from: b */
    public static boolean m18224b(String str) {
        String strM18257y = m18257y();
        C4904y.m18639b("Received ISO2 : " + str + " CurrentISO2 : " + strM18257y, f17607b);
        return str.equals(strM18257y);
    }

    /* renamed from: a */
    public static void m18213a(GetVersionNotice getVersionNotice, Context context, boolean z, String str) {
        m18214a(getVersionNotice, context, z, str, true);
    }

    /* renamed from: a */
    public static void m18214a(GetVersionNotice getVersionNotice, Context context, boolean z, String str, boolean z2) {
        if (C4904y.f17872b) {
            C4904y.m18639b("come in handleUpdate", "handleUpdate");
        }
        boolean zBooleanValue = false;
        if (getVersionNotice.critical != null) {
            zBooleanValue = getVersionNotice.critical.booleanValue();
        }
        C4809aa.m18104a().m18128b("UpdateTargetVersion", getVersionNotice.newversion);
        C4809aa.m18104a().m18125b("UpdateIsCritical", getVersionNotice.critical);
        C4809aa.m18104a().m18125b("UpdateIsNormal", getVersionNotice.uptodate);
        C4809aa.m18104a().m18128b("UpdateUrl", getVersionNotice.downloadurl);
        C4809aa.m18104a().m18128b("SamsungappsUrl", getVersionNotice.samsungappsurl);
        if (z) {
            C0096i.m358a(context.getApplicationContext()).m363a(new Intent("more_tab_badge_update"));
        }
        Intent intent = new Intent(context, (Class<?>) UpgradeDialog.class);
        intent.putExtra("isCritical", zBooleanValue);
        intent.putExtra("isFromHome", z);
        intent.putExtra("isReadyApps", str);
        if (z) {
            intent.setFlags(MotionRecognitionManager.EVENT_OVER_TURN_LOW_POWER);
        }
        context.startActivity(intent);
    }

    /* renamed from: a */
    public static void m18217a(String str, String str2, boolean z) {
        if (C4904y.f17874d) {
            C4904y.m18645d("[addAccount] key : " + str + " mUid : " + str2 + " withMSISDN : " + z, "DeviceInfoUtil");
        }
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            Account account = new Account("ChatON", Config.CHATON_PACKAGE_NAME);
            AccountManager.get(CommonApplication.m18732r()).addAccountExplicitly(account, str2, null);
            if (z) {
                ContentResolver.setSyncAutomatically(account, "com.android.contacts", true);
            } else {
                ContentResolver.setIsSyncable(account, "com.android.contacts", 0);
            }
        }
    }

    @SuppressLint({"NewApi"})
    /* renamed from: a */
    public static void m18216a(String str, Object obj) {
        if (C4904y.f17872b) {
            C4904y.m18639b("writePrefWithoutEncrypt, key : " + str + " value : " + obj, f17607b);
        }
        SharedPreferences.Editor editorEdit = CommonApplication.m18732r().getApplicationContext().getSharedPreferences("com.sec.chaton_preferences", 0).edit();
        if (obj instanceof Boolean) {
            editorEdit.putBoolean(str, ((Boolean) obj).booleanValue());
        }
        if (Build.VERSION.SDK_INT > 8) {
            editorEdit.apply();
        } else {
            editorEdit.commit();
        }
    }

    /* renamed from: d */
    public static String m18229d(Context context) {
        return null;
    }

    /* renamed from: e */
    public static String m18232e(Context context) throws PackageManager.NameNotFoundException {
        try {
            return "SSO ver " + context.getPackageManager().getPackageInfo("com.osp.app.signin", 0).versionName;
        } catch (PackageManager.NameNotFoundException e) {
            return "Not Installed";
        }
    }

    /* renamed from: f */
    public static String m18235f(Context context) throws PackageManager.NameNotFoundException {
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
    public static Intent m18208a(Intent intent) {
        intent.setFlags(268435456);
        intent.addFlags(67108864);
        intent.addFlags(536870912);
        intent.setFlags(65536);
        return intent;
    }

    /* renamed from: c */
    public static void m18225c(String str) {
        try {
            GlobalApplication.m18732r().startActivity(m18221b(new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=" + str))));
        } catch (ActivityNotFoundException e) {
            if (C4904y.f17872b) {
                C4904y.m18639b("There is no google play in the device", "gotoGooglePlayFor3rd");
            }
            GlobalApplication.m18732r().startActivity(m18221b(new Intent("android.intent.action.VIEW", Uri.parse("http://play.google.com/store/apps/details?id=" + str))));
        }
    }

    /* renamed from: b */
    public static Intent m18221b(Intent intent) {
        intent.addFlags(268435456);
        intent.addFlags(67108864);
        intent.addFlags(32);
        return intent;
    }

    /* renamed from: d */
    public static void m18230d(String str) {
        Intent intent = new Intent();
        intent.setClassName("com.sec.android.app.samsungapps", "com.sec.android.app.samsungapps.Main");
        intent.putExtra("directcall", true);
        intent.putExtra("CallerType", 1);
        intent.putExtra("GUID", str);
        GlobalApplication.m18732r().startActivity(m18221b(intent));
    }

    /* renamed from: z */
    public static String m18258z() {
        TelephonyManager telephonyManager = (TelephonyManager) GlobalApplication.m18732r().getSystemService("phone");
        if (telephonyManager.getSimState() == 5) {
            String simOperator = telephonyManager.getSimOperator();
            if (!TextUtils.isEmpty(simOperator)) {
                try {
                    return simOperator.subSequence(0, 3).toString();
                } catch (StringIndexOutOfBoundsException e) {
                    if (C4904y.f17875e) {
                        C4904y.m18634a("MCC2 is unexcepted length", f17607b);
                    }
                }
            }
        }
        C4904y.m18645d("does not have mcc", f17607b);
        return null;
    }

    /* renamed from: A */
    public static String m18191A() {
        TelephonyManager telephonyManager = (TelephonyManager) GlobalApplication.m18732r().getSystemService("phone");
        if (telephonyManager.getSimState() == 5) {
            String simOperator = telephonyManager.getSimOperator();
            if (!TextUtils.isEmpty(simOperator)) {
                try {
                    return simOperator.substring(3).toString();
                } catch (StringIndexOutOfBoundsException e) {
                    if (C4904y.f17875e) {
                        C4904y.m18634a("MNC2 is unexcepted length", f17607b);
                    }
                }
            }
        }
        C4904y.m18645d("does not have mnc", f17607b);
        return null;
    }

    /* renamed from: a */
    public static void m18212a(Context context, String str) {
        PackageManager packageManager = CommonApplication.m18732r().getPackageManager();
        if (str != null) {
            try {
                context.startActivity(packageManager.getLaunchIntentForPackage(str));
            } catch (ActivityNotFoundException e) {
                C4904y.m18635a(e, " - There is no such a activity.");
            }
        }
    }

    /* renamed from: g */
    public static boolean m18237g(Context context) {
        TelephonyManager telephonyManager;
        try {
            telephonyManager = (TelephonyManager) context.getSystemService("phone");
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (telephonyManager != null) {
            if (telephonyManager.getCallState() == 1) {
                if (C4904y.f17873c) {
                    C4904y.m18639b("ringing phone call, return true", f17607b);
                }
                return true;
            }
            return false;
        }
        if (C4904y.f17873c) {
            C4904y.m18641c("Null Pointer Exception set isRinging as false", f17607b);
        }
        return false;
    }

    @SuppressLint({"NewApi"})
    /* renamed from: h */
    public static boolean m18239h(Context context) {
        UserHandle userHandleMyUserHandle = Process.myUserHandle();
        UserManager userManager = (UserManager) GlobalApplication.m18732r().getSystemService("user");
        return userManager != null && userManager.getSerialNumberForUser(userHandleMyUserHandle) == 0;
    }

    /* renamed from: a */
    public static String m18209a(String str, String str2, String str3) {
        if (C4904y.f17872b) {
            C4904y.m18639b("networkMsg : " + str + " errorMsg : " + str2 + " errorCode : " + str3, "getMessageErrorCode");
        }
        if (!TextUtils.isEmpty(str3)) {
            String strM18233e = m18233e(str3);
            if (strM18233e != null) {
                return strM18233e;
            }
            if (!TextUtils.isEmpty(str2)) {
                return str2 + " (" + str3 + ")";
            }
            return str + " (" + str3 + ")";
        }
        return str;
    }

    /* renamed from: e */
    public static String m18233e(String str) {
        String str2 = null;
        Context contextR = GlobalApplication.m18732r();
        if ("CCS-00003".equals(str)) {
            str2 = contextR.getResources().getString(R.string.error_code_CCS_00003) + " (" + str + ")";
        } else if ("CCS-00012".equals(str) || "CCS-00800".equals(str) || "CCS-00900".equals(str) || "CCS-11001".equals(str) || "CCS-11003".equals(str)) {
            str2 = contextR.getResources().getString(R.string.chat_send_recordvodeo_toast_failed) + " (" + str + ")";
        } else if ("CCS-11004".equals(str) || "CCS-11013".equals(str)) {
            str2 = contextR.getResources().getString(R.string.error_code_common) + " " + contextR.getResources().getString(R.string.registration_check_phone_number);
        }
        if (C4904y.f17872b) {
            C4904y.m18639b("checkErrorCode : " + str + ", " + str2, f17607b);
        }
        return str2;
    }

    /* renamed from: B */
    public static String m18192B() {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) GlobalApplication.m18732r().getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        String strValueOf = String.valueOf(displayMetrics.densityDpi);
        C4904y.m18639b("screenDensity : " + strValueOf, f17607b);
        return strValueOf;
    }

    /* renamed from: C */
    public static String m18193C() {
        String networkOperatorName;
        TelephonyManager telephonyManager = (TelephonyManager) CommonApplication.m18732r().getSystemService("phone");
        String simOperatorName = telephonyManager.getSimOperatorName();
        if (TextUtils.isEmpty(simOperatorName)) {
            if (C4904y.f17872b) {
                C4904y.m18639b("sim operator name is empty", f17607b);
            }
            networkOperatorName = telephonyManager.getNetworkOperatorName();
        } else {
            networkOperatorName = simOperatorName;
        }
        if (C4904y.f17872b) {
            C4904y.m18639b("getOperatorName : " + networkOperatorName, f17607b);
        }
        return networkOperatorName;
    }

    /* renamed from: D */
    public static boolean m18194D() {
        String language = Locale.getDefault().getLanguage();
        if (C4904y.f17872b) {
            C4904y.m18639b("language : " + language, "checkIsArabicStyleLang");
        }
        return "ar".equalsIgnoreCase(language) || "ur".equalsIgnoreCase(language) || "fa".equalsIgnoreCase(language);
    }

    /* renamed from: E */
    public static boolean m18195E() {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) GlobalApplication.m18732r().getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics.densityDpi == 213 && m18250r().equals("large");
    }

    /* renamed from: F */
    public static boolean m18196F() {
        String strM18236g = m18236g();
        if (!TextUtils.isEmpty(strM18236g)) {
            strM18236g = strM18236g.toUpperCase();
        }
        if (C4904y.f17872b) {
            C4904y.m18639b("is America region : " + strM18236g, "hasNotSim");
        }
        if ("US".equalsIgnoreCase(strM18236g) || "VI".equals(strM18236g) || "PR".equals(strM18236g)) {
            return true;
        }
        TelephonyManager telephonyManager = (TelephonyManager) CommonApplication.m18732r().getSystemService("phone");
        String subscriberId = telephonyManager.getSubscriberId();
        String line1Number = telephonyManager.getLine1Number();
        int phoneType = telephonyManager.getPhoneType();
        if (C4904y.f17872b) {
            C4904y.m18639b("Phone Type : " + phoneType + " Network Type : " + telephonyManager.getNetworkType() + " Sim State : " + telephonyManager.getSimState(), "hasNotSim");
            C4904y.m18639b("imsi : " + subscriberId + " getLine1Number : " + line1Number, "hasNotSim");
        }
        if (TextUtils.isEmpty(subscriberId)) {
            if (phoneType == 2) {
                if (TextUtils.isEmpty(line1Number) || (line1Number.length() >= 6 && line1Number.substring(0, 6).equals("000000"))) {
                    if (C4904y.f17872b) {
                        C4904y.m18639b("Sim NOT eixst", "hasNotSim");
                    }
                    return true;
                }
            } else {
                if (C4904y.f17872b) {
                    C4904y.m18639b("Sim NOT eixst", "hasNotSim");
                }
                return true;
            }
        }
        if (C4904y.f17872b) {
            C4904y.m18639b("Sim eixst", "hasNotSim");
        }
        return false;
    }

    /* renamed from: G */
    public static boolean m18197G() {
        return !TextUtils.isEmpty(C4809aa.m18104a().m18121a("register_sns_type", (String) null));
    }

    /* renamed from: H */
    public static String m18198H() {
        return C4809aa.m18104a().m18121a("register_sns_type", (String) null);
    }

    /* renamed from: i */
    public static int m18240i(Context context) {
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        Configuration configuration = context.getResources().getConfiguration();
        int rotation = windowManager.getDefaultDisplay().getRotation();
        return (((rotation == 0 || rotation == 2) && configuration.orientation == 2) || ((rotation == 1 || rotation == 3) && configuration.orientation == 1)) ? 2 : 1;
    }

    /* renamed from: I */
    public static int m18199I() {
        return f17608c;
    }

    /* renamed from: a */
    public static void m18210a(int i) {
        f17608c = i;
    }

    /* renamed from: b */
    public static void m18222b(int i) {
        f17606a = i;
    }

    /* renamed from: J */
    public static void m18200J() {
        if (C4904y.f17873c) {
            C4904y.m18641c("[updateBadgeMainIcon] chatbadge:" + f17608c + ", mypageBadge:" + f17606a, "DeviceInfoUtil");
        }
        int i = f17608c + f17606a;
        try {
            Intent intent = new Intent("android.intent.action.BADGE_COUNT_UPDATE");
            intent.putExtra("badge_count", i);
            intent.putExtra("badge_count_package_name", Config.CHATON_PACKAGE_NAME);
            intent.putExtra("badge_count_class_name", "com.sec.chaton.HomeActivity");
            GlobalApplication.m18732r().sendBroadcast(intent);
        } catch (Exception e) {
            C4904y.m18635a(e, "updateBadgeMainIcon");
        }
    }

    /* renamed from: K */
    public static boolean m18201K() {
        boolean zEquals = C4809aa.m18104a().m18121a("provisioning_disclaimer_status", "").equals("DONE");
        if (C4904y.f17872b) {
            C4904y.m18639b("acceptedDisclaimer : " + zEquals, "DeviceInfoUtil");
        }
        return zEquals;
    }

    /* renamed from: L */
    public static String m18202L() {
        String str = new SimpleDateFormat("yyyyMMdd").format(new Date());
        if (C4904y.f17872b) {
            C4904y.m18639b("getDate : " + str, "DeviceInfoUtil");
        }
        return str;
    }

    /* renamed from: M */
    public static boolean m18203M() {
        if (m18218a() && C2349a.m10301a("sms_feature") && m18226c()) {
            if (C4904y.f17872b) {
                C4904y.m18639b("isEnabledMixtureRoom() mixture room was enabled", f17607b);
            }
            return true;
        }
        if (C4904y.f17872b) {
            C4904y.m18639b("isEnabledMixtureRoom() mixture room was disabled", f17607b);
        }
        return false;
    }

    /* renamed from: N */
    public static boolean m18204N() {
        return C4809aa.m18104a().m18119a("weblogin_info_needsync", (Boolean) true).booleanValue();
    }

    /* renamed from: O */
    public static boolean m18205O() {
        String strM18121a = C4809aa.m18104a().m18121a("primary_huge_file_address", "");
        if (C4904y.f17875e) {
            C4904y.m18634a("sHugeFileServerAddress: " + strM18121a, f17607b);
        }
        return !TextUtils.isEmpty(strM18121a) && C4809aa.m18104a().m18119a("large_file_enable", (Boolean) false).booleanValue();
    }

    /* renamed from: a */
    public static boolean m18219a(File file) {
        return file == null || file.length() <= 31457280 || m18205O();
    }

    /* renamed from: P */
    public static boolean m18206P() {
        int i = Settings.System.getInt(CommonApplication.m18732r().getContentResolver(), "ultra_powersaving_mode", 0);
        if (C4904y.f17872b) {
            C4904y.m18639b("ultra_powersaving_mode : " + i, f17607b);
        }
        return i > 0;
    }

    /* renamed from: Q */
    public static boolean m18207Q() {
        int i = Settings.System.getInt(CommonApplication.m18732r().getContentResolver(), "emergency_mode", 0);
        if (C4904y.f17872b) {
            C4904y.m18639b("emergency_mode : " + i, f17607b);
        }
        return i > 0;
    }
}
