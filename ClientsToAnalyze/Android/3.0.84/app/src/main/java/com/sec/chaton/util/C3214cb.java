package com.sec.chaton.util;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.content.ActivityNotFoundException;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.net.Uri;
import android.text.TextUtils;
import com.coolots.sso.p006a.C0045a;
import com.coolots.sso.p006a.InterfaceC0048d;
import com.sec.chaton.R;
import com.sec.chaton.global.C1493a;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.plugin.C1948a;
import com.sec.chaton.plugin.C1954g;
import com.sec.chaton.plugin.EnumC1955h;
import com.sec.common.util.C3347i;

/* compiled from: RegistrationUtil.java */
/* renamed from: com.sec.chaton.util.cb */
/* loaded from: classes.dex */
public class C3214cb {

    /* renamed from: b */
    private static String f11598b = C3214cb.class.getSimpleName();

    /* renamed from: a */
    public static C0045a f11597a = null;

    /* renamed from: a */
    public static boolean m11256a(Context context) {
        return C1493a.m6463a("chatonv_feature") && C1954g.m7916a().m7918a(context, EnumC1955h.ChatONV) && C1948a.m7903a(context);
    }

    /* renamed from: a */
    public static int m11245a(Context context, C0045a c0045a) {
        C3250y.m11438a();
        String strM10979a = C3159aa.m10962a().m10979a("samsung_account_user_id", "");
        String strM10979a2 = C3159aa.m10962a().m10979a("chaton_id", "");
        String strM10979a3 = C3159aa.m10962a().m10979a("Push Name", "");
        String strM10979a4 = C3159aa.m10962a().m10979a("uid", "");
        String strM10979a5 = C3159aa.m10962a().m10979a("samsung_account_email", "");
        String strM10979a6 = C3159aa.m10962a().m10979a("account_country_code", "");
        String strM10979a7 = C3159aa.m10962a().m10979a("samsung_account_birthday", "");
        int iM46a = c0045a.m46a(context, strM10979a2, strM10979a5, strM10979a6, strM10979a, strM10979a3, C3171am.m11045a(), strM10979a4, strM10979a7);
        if (C3250y.f11734b) {
            C3250y.m11450b("chatonId : " + strM10979a2 + " email : " + strM10979a5 + " ISO : " + strM10979a6 + " userId : " + strM10979a + " nickName : " + strM10979a3 + " IMEI : " + C3171am.m11045a() + " chatonUid : " + strM10979a4 + " birthday : " + strM10979a7, context.getClass().getSimpleName());
            C3250y.m11450b("ChatONV create result : " + iM46a + "," + C0045a.m35b(iM46a), context.getClass().getSimpleName());
        }
        return iM46a;
    }

    /* renamed from: b */
    public static void m11260b(Context context, C0045a c0045a) {
        int iM54c = c0045a.m54c(context);
        C3250y.m11450b("run:mChatonV.removeAccountInDevice(), result : " + C0045a.m35b(iM54c) + "," + iM54c, context.getClass().getSimpleName());
    }

    /* renamed from: b */
    public static String m11257b(Context context) {
        Account[] accountsByType = AccountManager.get(context).getAccountsByType("com.osp.app.signin");
        if (accountsByType.length <= 0) {
            return null;
        }
        return accountsByType[0].name;
    }

    /* renamed from: a */
    public static int m11246a(String str) throws PackageManager.NameNotFoundException {
        PackageInfo packageInfo;
        try {
            packageInfo = GlobalApplication.m11493l().getPackageManager().getPackageInfo(str, 0);
        } catch (PackageManager.NameNotFoundException e) {
            C3250y.m11455d(e.toString(), "getVersionCodeForService");
            packageInfo = null;
        }
        if (packageInfo != null) {
            if (C3250y.f11734b) {
                C3250y.m11450b("[" + str + "]version code : " + packageInfo.versionCode, "getVersionCodeForService");
            }
            return packageInfo.versionCode;
        }
        return -1;
    }

    /* renamed from: b */
    public static String m11258b(String str) throws PackageManager.NameNotFoundException {
        PackageInfo packageInfo;
        try {
            packageInfo = GlobalApplication.m11493l().getPackageManager().getPackageInfo(str, 0);
        } catch (PackageManager.NameNotFoundException e) {
            C3250y.m11455d(e.toString(), "getVersionForService");
            packageInfo = null;
        }
        if (packageInfo != null) {
            if (C3250y.f11734b) {
                C3250y.m11450b("[" + str + "]version name : " + packageInfo.versionName, "getVersionForService");
            }
            return packageInfo.versionName;
        }
        return "";
    }

    /* renamed from: c */
    public static int m11262c(Context context) throws PackageManager.NameNotFoundException {
        PackageInfo packageInfo;
        try {
            packageInfo = context.getPackageManager().getPackageInfo("com.osp.app.signin", 0);
        } catch (PackageManager.NameNotFoundException e) {
            C3250y.m11455d(e.toString(), "MainActivity");
            packageInfo = null;
        }
        if (packageInfo != null && packageInfo.versionCode >= 12005) {
            return packageInfo.versionCode;
        }
        return -1;
    }

    /* renamed from: a */
    public static boolean m11255a(int i) {
        return i >= 13001;
    }

    /* renamed from: a */
    public static void m11254a(String str, String str2, boolean z) {
        if (C3250y.f11736d) {
            C3250y.m11455d("[addAccount] key : " + str + " mUid : " + str2 + " withMSISDN : " + z, "DeviceInfoUtil");
        }
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            Account account = new Account(str, "com.sec.chaton");
            AccountManager.get(GlobalApplication.m11493l()).addAccountExplicitly(account, str2, null);
            if (z) {
                ContentResolver.setSyncAutomatically(account, "com.android.contacts", true);
            } else {
                ContentResolver.setIsSyncable(account, "com.android.contacts", 0);
            }
        }
    }

    /* renamed from: a */
    public static void m11253a(String str, Context context, boolean z) {
        String string;
        if (TextUtils.isEmpty(str)) {
            C3250y.m11450b("Input ISO3 is null", context.getClass().getSimpleName());
            return;
        }
        CharSequence[] textArray = context.getResources().getTextArray(R.array.Account_ISO_country_code2);
        CharSequence[] textArray2 = context.getResources().getTextArray(R.array.Account_ISO_country_code3);
        int i = 0;
        while (true) {
            if (i >= textArray.length) {
                string = null;
                break;
            } else if (!textArray2[i].equals(str)) {
                i++;
            } else {
                string = textArray[i].toString();
                break;
            }
        }
        C3250y.m11450b("Input ISO3 : " + str + " Output : " + string, context.getClass().getSimpleName());
        C3159aa.m10966a("temp_account_country_code", string);
    }

    /* renamed from: a */
    public static void m11251a(Context context, String str) throws Resources.NotFoundException {
        String string;
        if (TextUtils.isEmpty(str)) {
            C3250y.m11450b("Input MCC is null", context.getClass().getSimpleName());
            return;
        }
        CharSequence[] textArray = context.getResources().getTextArray(R.array.Account_SSO_ISO2);
        CharSequence[] textArray2 = context.getResources().getTextArray(R.array.Account_SSO_MCC);
        int i = 0;
        while (true) {
            if (i >= textArray2.length) {
                string = null;
                break;
            } else if (!textArray2[i].equals(str)) {
                i++;
            } else {
                string = textArray[i].toString();
                break;
            }
        }
        C3250y.m11450b("Input MCC : " + str + " Output : " + string, context.getClass().getSimpleName());
        C3159aa.m10966a("temp_account_country_code", string);
    }

    /* renamed from: a */
    public static EnumC3215cc m11248a() {
        EnumC3215cc enumC3215ccM11273a = EnumC3215cc.m11273a(C3159aa.m10962a().m10978a("back_regi_status", (Integer) (-1)).intValue());
        if (C3250y.f11734b) {
            C3250y.m11450b("getBackRegiStatus, status : " + enumC3215ccM11273a.toString(), f11598b);
        }
        return enumC3215ccM11273a;
    }

    /* renamed from: a */
    public static void m11252a(EnumC3215cc enumC3215cc) {
        int iM11272a = EnumC3215cc.m11272a(enumC3215cc);
        C3159aa.m10962a().m10984b("back_regi_status", Integer.valueOf(iM11272a));
        if (C3250y.f11734b) {
            C3250y.m11450b("putBackRegiStatus, value : " + iM11272a, f11598b);
        }
    }

    /* renamed from: a */
    public static void m11249a(Context context, Intent intent) {
        try {
            String stringExtra = intent.getStringExtra("REQUIRED_PROCESS_ACTION");
            intent.setAction(stringExtra);
            intent.setPackage(null);
            context.startActivity(intent);
            intent.setComponent(null);
            intent.setFlags(268435456);
            if (C3250y.f11734b) {
                C3250y.m11450b("[runHandleSSOError]action : " + stringExtra, context.getClass().getSimpleName());
            }
        } catch (Exception e) {
            if (C3250y.f11737e) {
                C3250y.m11442a("[runHandleSSOError] : " + e, context.getClass().getSimpleName());
            }
        }
    }

    /* renamed from: b */
    public static void m11259b(int i) {
        if (C3250y.f11734b) {
            C3250y.m11450b("service : " + i, "gotoSamsungApps");
        }
        if (i == 0) {
            String strM10979a = C3159aa.m10962a().m10979a("SamsungappsUrl", "");
            if (!TextUtils.isEmpty(strM10979a)) {
                String strReplace = strM10979a.replace("com.sec.chaton", GlobalApplication.m11493l().getPackageName());
                Intent intent = new Intent("android.intent.action.VIEW");
                try {
                    Uri uri = Uri.parse(strReplace);
                    intent.addFlags(335544352);
                    intent.setData(uri);
                    GlobalApplication.m11493l().startActivity(intent);
                    C3250y.m11450b("Go to Samsung apps", f11598b);
                    return;
                } catch (Exception e) {
                    e.printStackTrace();
                    return;
                }
            }
            return;
        }
        m11263c(i);
    }

    /* renamed from: c */
    public static void m11263c(int i) {
        Intent intent = new Intent();
        intent.setClassName("com.sec.android.app.samsungapps", "com.sec.android.app.samsungapps.Main");
        intent.putExtra("directcall", true);
        intent.putExtra("CallerType", 1);
        if (i == 1) {
            intent.putExtra("GUID", "com.coolots.chaton");
        } else if (i == 2) {
            intent.putExtra("GUID", "com.sec.spp.push");
        }
        GlobalApplication.m11493l().startActivity(m11247a(intent));
    }

    /* renamed from: d */
    public static void m11267d(int i) {
        if (C3250y.f11734b) {
            C3250y.m11450b("service : " + i, "gotoGooglePlay");
        }
        if (i == 0) {
            String strM10979a = C3159aa.m10962a().m10979a("UpdateUrl", "");
            if (!TextUtils.isEmpty(strM10979a)) {
                String strReplace = strM10979a.replace("com.sec.chaton", GlobalApplication.m11493l().getPackageName());
                Intent intent = new Intent("android.intent.action.VIEW");
                try {
                    Uri uri = Uri.parse(strReplace);
                    intent.addFlags(335544352);
                    intent.setData(uri);
                    GlobalApplication.m11493l().startActivity(intent);
                    C3250y.m11450b("Go to Google play", f11598b);
                    return;
                } catch (Exception e) {
                    e.printStackTrace();
                    return;
                }
            }
            return;
        }
        m11269e(i);
    }

    /* renamed from: e */
    public static void m11269e(int i) {
        try {
            if (i == 1) {
                GlobalApplication.m11493l().startActivity(m11247a(new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=com.coolots.chaton"))));
            } else if (i == 2) {
                GlobalApplication.m11493l().startActivity(m11247a(new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=com.sec.spp.push"))));
            }
        } catch (ActivityNotFoundException e) {
            if (C3250y.f11734b) {
                C3250y.m11450b("There is no google play in the device", f11598b);
            }
            if (i == 1) {
                GlobalApplication.m11493l().startActivity(m11247a(new Intent("android.intent.action.VIEW", Uri.parse("http://play.google.com/store/apps/details?id=com.coolots.chaton"))));
            } else if (i == 2) {
                GlobalApplication.m11493l().startActivity(m11247a(new Intent("android.intent.action.VIEW", Uri.parse("http://play.google.com/store/apps/details?id=com.sec.spp.push"))));
            }
        }
    }

    /* renamed from: a */
    public static Intent m11247a(Intent intent) {
        intent.addFlags(268435456);
        intent.addFlags(67108864);
        intent.addFlags(32);
        return intent;
    }

    /* renamed from: f */
    public static void m11270f(int i) {
        if (C3250y.f11734b) {
            C3250y.m11450b("service : " + i, "gotoChatonUrl");
        }
        if (i == 0) {
            Uri uri = Uri.parse("com.sec.chaton".equals(GlobalApplication.m11493l().getPackageName()) ? "http://smm.samsung.com/download.html?s=normal&r=global" : "http://smm.samsung.com/download.html?s=normal&r=global".replace("global", "canada"));
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.addFlags(335544352);
            intent.setData(uri);
            GlobalApplication.m11493l().startActivity(intent);
            return;
        }
        if (i == 2) {
            Uri uri2 = Uri.parse("http://www.chaton.com/pushclientapk");
            Intent intent2 = new Intent("android.intent.action.VIEW");
            intent2.addFlags(335544352);
            intent2.setData(uri2);
            GlobalApplication.m11493l().startActivity(intent2);
        }
    }

    /* renamed from: c */
    public static boolean m11265c(String str) {
        return C3347i.m11778a(GlobalApplication.m11493l(), str);
    }

    /* renamed from: b */
    public static boolean m11261b() {
        return C3347i.m11778a(GlobalApplication.m11493l(), "com.sec.android.app.samsungapps");
    }

    /* renamed from: c */
    public static boolean m11264c() {
        return C3347i.m11778a(GlobalApplication.m11493l(), "com.android.vending");
    }

    /* renamed from: d */
    public static void m11266d() {
        C3159aa.m10962a().m10981a("provisioning_selfsms_status");
        C3159aa.m10962a().m10981a("provisioning_disclaimer_status");
        C3159aa.m10962a().m10981a("provisioning_account_login");
        C3159aa.m10962a().m10981a("selected_country");
        C3159aa.m10962a().m10981a("provisioning_pushname_status");
        C3159aa.m10962a().m10981a("samsung_account_email");
        C3159aa.m10962a().m10981a("provisioning_sns_login_state");
    }

    /* renamed from: a */
    public static void m11250a(Context context, InterfaceC0048d interfaceC0048d) {
        if (m11256a(context)) {
            if (f11597a != null) {
                f11597a.m49a(context);
            }
            f11597a = new C0045a();
            f11597a.m52a(context, interfaceC0048d);
            f11597a.m65n(context);
        }
    }

    /* renamed from: d */
    public static void m11268d(Context context) {
        if (f11597a != null) {
            f11597a.m52a(context, (InterfaceC0048d) null);
            f11597a = null;
        }
    }
}
