package com.sec.chaton.util;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.Signature;
import android.content.res.Resources;
import android.database.Cursor;
import android.net.Uri;
import android.os.HandlerThread;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.coolots.sso.p030a.C0416a;
import com.coolots.sso.p030a.InterfaceC0419d;
import com.google.android.gcm.C0693a;
import com.p137vk.sdk.VKOpenAuthActivity;
import com.sec.chaton.EOSPopupActivity;
import com.sec.chaton.R;
import com.sec.chaton.api.access_token.C1041a;
import com.sec.chaton.global.C2349a;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.msgsend.C2717y;
import com.sec.chaton.p051c.C1427a;
import com.sec.chaton.p055d.C2122ca;
import com.sec.chaton.plugin.C2923b;
import com.sec.chaton.plugin.C2948h;
import com.sec.chaton.plugin.EnumC2949i;
import com.sec.chaton.settings.FragmentWebView;
import com.sec.chaton.smsplugin.p111h.C3892o;
import com.sec.common.CommonApplication;
import com.sec.common.p123a.AbstractC4932a;
import com.sec.common.p123a.InterfaceC4936e;
import com.sec.common.util.C5034k;
import com.sec.spp.push.Config;
import com.sec.widget.C5179v;
import java.util.ArrayList;

/* compiled from: RegistrationUtil.java */
/* renamed from: com.sec.chaton.util.bx */
/* loaded from: classes.dex */
public class C4859bx {

    /* renamed from: b */
    private static String f17686b = C4859bx.class.getSimpleName();

    /* renamed from: a */
    public static C0416a f17685a = null;

    /* renamed from: c */
    private static ArrayList<CharSequence> f17687c = new ArrayList<>();

    static {
        f17687c.add("CN");
        f17687c.add("IR");
        f17687c.add("VN");
        f17687c.add("PK");
        f17687c.add("SY");
        f17687c.add("BD");
    }

    /* renamed from: a */
    public static boolean m18386a(Context context) {
        return C2349a.m10301a("chatonv_feature") && C2948h.m12190a().m12192a(context, EnumC2949i.ChatONV) && C2923b.m12153h(context);
    }

    /* renamed from: a */
    public static int m18369a(Context context, C0416a c0416a) {
        C4904y.m18638b();
        String strM18121a = C4809aa.m18104a().m18121a("samsung_account_user_id", "");
        String strM18121a2 = C4809aa.m18104a().m18121a("chaton_id", "");
        String strM18121a3 = C4809aa.m18104a().m18121a("Push Name", "");
        String strM18121a4 = C4809aa.m18104a().m18121a("uid", "");
        String strM18121a5 = C4809aa.m18104a().m18121a("samsung_account_email", "");
        String strM18121a6 = C4809aa.m18104a().m18121a("account_country_code", "");
        String strM18121a7 = C4809aa.m18104a().m18121a("samsung_account_birthday", "");
        int iM1486a = c0416a.m1486a(context, strM18121a2, strM18121a5, strM18121a6, strM18121a, strM18121a3, C4822an.m18228d(), strM18121a4, strM18121a7);
        if (C4904y.f17872b) {
            C4904y.m18639b("chatonId : " + strM18121a2 + " email : " + strM18121a5 + " ISO : " + strM18121a6 + " userId : " + strM18121a + " nickName : " + strM18121a3 + " IMEI : " + C4822an.m18228d() + " chatonUid : " + strM18121a4 + " birthday : " + strM18121a7, context.getClass().getSimpleName());
            C4904y.m18639b("ChatONV create result : " + iM1486a + "," + C0416a.m1475b(iM1486a), context.getClass().getSimpleName());
        }
        return iM1486a;
    }

    /* renamed from: b */
    public static int m18388b(Context context, C0416a c0416a) {
        int iM1494c = c0416a.m1494c(context);
        C4904y.m18639b("run:mChatonV.removeAccountInDevice(), result : " + C0416a.m1475b(iM1494c) + "," + iM1494c, context.getClass().getSimpleName());
        return iM1494c;
    }

    /* renamed from: a */
    public static String m18377a(Activity activity) {
        AccountManager accountManager = AccountManager.get(activity);
        Account[] accountsByType = accountManager.getAccountsByType("com.google");
        if (accountsByType.length > 0) {
            return accountsByType[0].name;
        }
        accountManager.addAccount("com.google", null, null, null, activity, null, null);
        return null;
    }

    /* renamed from: b */
    public static String m18389b(Context context) {
        Account[] accountsByType = AccountManager.get(context).getAccountsByType("com.osp.app.signin");
        if (accountsByType.length <= 0) {
            return null;
        }
        return accountsByType[0].name;
    }

    /* renamed from: a */
    public static int m18370a(String str) throws PackageManager.NameNotFoundException {
        PackageInfo packageInfo;
        try {
            packageInfo = GlobalApplication.m18732r().getPackageManager().getPackageInfo(str, 0);
        } catch (PackageManager.NameNotFoundException e) {
            C4904y.m18645d(e.toString(), "getVersionCodeForService");
            packageInfo = null;
        }
        if (packageInfo != null) {
            if (C4904y.f17872b) {
                C4904y.m18639b("[" + str + "]version code : " + packageInfo.versionCode, "getVersionCodeForService");
            }
            return packageInfo.versionCode;
        }
        return -1;
    }

    /* renamed from: b */
    public static String m18390b(String str) throws PackageManager.NameNotFoundException {
        PackageInfo packageInfo;
        try {
            packageInfo = GlobalApplication.m18732r().getPackageManager().getPackageInfo(str, 0);
        } catch (PackageManager.NameNotFoundException e) {
            C4904y.m18645d(e.toString(), "getVersionForService");
            packageInfo = null;
        }
        if (packageInfo != null) {
            if (C4904y.f17872b) {
                C4904y.m18639b("[" + str + "]version name : " + packageInfo.versionName, "getVersionForService");
            }
            return packageInfo.versionName;
        }
        return "";
    }

    /* renamed from: c */
    public static int m18394c(Context context) throws PackageManager.NameNotFoundException {
        PackageInfo packageInfo;
        try {
            packageInfo = context.getPackageManager().getPackageInfo("com.osp.app.signin", 0);
        } catch (PackageManager.NameNotFoundException e) {
            C4904y.m18645d(e.toString(), "MainActivity");
            packageInfo = null;
        }
        if (packageInfo != null && packageInfo.versionCode >= 12005) {
            return packageInfo.versionCode;
        }
        return -1;
    }

    /* renamed from: a */
    public static void m18385a(String str, String str2, boolean z) {
        if (C4904y.f17874d) {
            C4904y.m18645d("[addAccount] key : " + str + " mUid : " + str2 + " withMSISDN : " + z, "DeviceInfoUtil");
        }
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            Account account = new Account("ChatON", Config.CHATON_PACKAGE_NAME);
            AccountManager.get(GlobalApplication.m18732r()).addAccountExplicitly(account, str2, null);
            if (z) {
                ContentResolver.setSyncAutomatically(account, "com.android.contacts", true);
            } else {
                ContentResolver.setIsSyncable(account, "com.android.contacts", 0);
            }
        }
    }

    /* renamed from: a */
    public static void m18384a(String str, Context context, boolean z) {
        String string;
        if (TextUtils.isEmpty(str)) {
            C4904y.m18639b("Input ISO3 is null", context.getClass().getSimpleName());
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
        C4904y.m18639b("Input ISO3 : " + str + " Output : " + string, context.getClass().getSimpleName());
        C4809aa.m18108a("temp_account_country_code", string);
    }

    /* renamed from: a */
    public static void m18381a(Context context, String str) {
        String string;
        if (TextUtils.isEmpty(str)) {
            C4904y.m18639b("Input MCC is null", context.getClass().getSimpleName());
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
        C4904y.m18639b("Input MCC : " + str + " Output : " + string, context.getClass().getSimpleName());
        C4809aa.m18108a("temp_account_country_code", string);
    }

    /* renamed from: a */
    public static EnumC4863ca m18374a() {
        EnumC4863ca enumC4863caM18420a = EnumC4863ca.m18420a(C4809aa.m18104a().m18120a("back_regi_status", (Integer) (-1)).intValue());
        if (C4904y.f17872b) {
            C4904y.m18639b("getBackRegiStatus, status : " + enumC4863caM18420a.toString(), f17686b);
        }
        return enumC4863caM18420a;
    }

    /* renamed from: a */
    public static void m18382a(EnumC4863ca enumC4863ca) {
        int iM18419a = EnumC4863ca.m18419a(enumC4863ca);
        C4809aa.m18104a().m18126b("back_regi_status", Integer.valueOf(iM18419a));
        if (C4904y.f17872b) {
            C4904y.m18639b("putBackRegiStatus, value : " + iM18419a, f17686b);
        }
    }

    /* renamed from: a */
    public static void m18379a(Context context, Intent intent) {
        try {
            String stringExtra = intent.getStringExtra("REQUIRED_PROCESS_ACTION");
            intent.setAction(stringExtra);
            intent.setPackage(null);
            context.startActivity(intent);
            intent.setComponent(null);
            intent.setFlags(268435456);
            if (C4904y.f17872b) {
                C4904y.m18639b("[runHandleSSOError]action : " + stringExtra, context.getClass().getSimpleName());
            }
        } catch (Exception e) {
            if (C4904y.f17875e) {
                C4904y.m18634a("[runHandleSSOError] : " + e, context.getClass().getSimpleName());
            }
        }
    }

    /* renamed from: a */
    public static void m18378a(int i) {
        String strM18121a;
        if (C4904y.f17872b) {
            C4904y.m18639b("service : " + i, "gotoSamsungApps");
        }
        if (i == 0) {
            strM18121a = C4809aa.m18104a().m18121a("SamsungappsUrl", "");
            if (TextUtils.isEmpty(strM18121a)) {
                strM18121a = "samsungapps://ProductDetail/" + GlobalApplication.m18732r().getPackageName();
            }
        } else if (i == 1) {
            strM18121a = C4809aa.m18104a().m18121a("chatonv_apps_down_url", "");
            if (TextUtils.isEmpty(strM18121a)) {
                strM18121a = "samsungapps://ProductDetail/" + m18402e();
            }
        } else {
            m18391b(i);
            return;
        }
        Intent intent = new Intent("android.intent.action.VIEW");
        try {
            Uri uri = Uri.parse(strM18121a);
            intent.addFlags(335544352);
            intent.setData(uri);
            GlobalApplication.m18732r().startActivity(intent);
            C4892m.m18587g(true);
            C4904y.m18639b("Go to Samsung apps", f17686b);
        } catch (ActivityNotFoundException e) {
            C5179v.m19811a(CommonApplication.m18732r(), CommonApplication.m18732r().getResources().getString(R.string.chaton_ps_has_been_disabled, CommonApplication.m18732r().getResources().getString(R.string.upgrade_samsung_apps)), 0).show();
            if (C4904y.f17872b) {
                C4904y.m18639b("samsung apps was NOT found", f17686b);
            }
        }
    }

    /* renamed from: b */
    public static void m18391b(int i) {
        Intent intent = new Intent();
        intent.setClassName("com.sec.android.app.samsungapps", "com.sec.android.app.samsungapps.Main");
        intent.putExtra("directcall", true);
        intent.putExtra("CallerType", 1);
        if (i == 2) {
            intent.putExtra("GUID", "com.sec.spp.push");
        }
        try {
            GlobalApplication.m18732r().startActivity(m18373a(intent));
            C4892m.m18587g(true);
        } catch (ActivityNotFoundException e) {
            C5179v.m19811a(CommonApplication.m18732r(), CommonApplication.m18732r().getResources().getString(R.string.chaton_ps_has_been_disabled, CommonApplication.m18732r().getResources().getString(R.string.upgrade_samsung_apps)), 0).show();
            if (C4904y.f17872b) {
                C4904y.m18639b("service was NOT found", f17686b);
            }
        }
    }

    /* renamed from: c */
    public static void m18395c(int i) {
        if (C4904y.f17872b) {
            C4904y.m18639b("service : " + i, "gotoGooglePlay");
        }
        C4892m.m18587g(true);
        if (i == 0) {
            String strM18121a = C4809aa.m18104a().m18121a("UpdateUrl", "");
            if (TextUtils.isEmpty(strM18121a)) {
                strM18121a = "market://details?id=" + GlobalApplication.m18732r().getPackageName();
            }
            Intent intent = new Intent("android.intent.action.VIEW");
            try {
                Uri uri = Uri.parse(strM18121a);
                intent.addFlags(335544352);
                intent.setData(uri);
                GlobalApplication.m18732r().startActivity(intent);
                C4904y.m18639b("Go to Google play", f17686b);
                return;
            } catch (ActivityNotFoundException e) {
                GlobalApplication.m18732r().startActivity(m18373a(new Intent("android.intent.action.VIEW", Uri.parse("http://play.google.com/store/apps/details?id=" + GlobalApplication.m18732r().getPackageName()))));
                if (C4904y.f17872b) {
                    C4904y.m18639b("google play was NOT found", f17686b);
                    return;
                }
                return;
            }
        }
        m18399d(i);
    }

    /* renamed from: d */
    public static void m18399d(int i) {
        try {
            if (i == 1) {
                String strM18121a = C4809aa.m18104a().m18121a("chatonv_google_down_url", "");
                if (TextUtils.isEmpty(strM18121a)) {
                    strM18121a = "market://details?id=" + m18402e();
                }
                GlobalApplication.m18732r().startActivity(m18373a(new Intent("android.intent.action.VIEW", Uri.parse(strM18121a))));
                return;
            }
            if (i == 2) {
                GlobalApplication.m18732r().startActivity(m18373a(new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=com.sec.spp.push"))));
            }
        } catch (ActivityNotFoundException e) {
            if (C4904y.f17872b) {
                C4904y.m18639b("google play was NOT found", f17686b);
            }
            if (i == 1) {
                GlobalApplication.m18732r().startActivity(m18373a(new Intent("android.intent.action.VIEW", Uri.parse("http://play.google.com/store/apps/details?id=" + m18402e()))));
            } else if (i == 2) {
                GlobalApplication.m18732r().startActivity(m18373a(new Intent("android.intent.action.VIEW", Uri.parse("http://play.google.com/store/apps/details?id=com.sec.spp.push"))));
            }
        }
    }

    /* renamed from: a */
    public static Intent m18373a(Intent intent) {
        intent.addFlags(268435456);
        intent.addFlags(67108864);
        intent.addFlags(32);
        return intent;
    }

    /* renamed from: e */
    public static void m18403e(int i) {
        if (C4904y.f17872b) {
            C4904y.m18639b("service : " + i, "gotoChatonUrl");
        }
        if (i == 0) {
            String str = "http://www.chaton.com/androidapk_canada";
            if (!"com.sec.chatonforcanada".equals(GlobalApplication.m18732r().getPackageName())) {
                str = "http://www.chaton.com/androidapk";
            }
            Uri uri = Uri.parse(str);
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.addFlags(335544352);
            intent.setData(uri);
            GlobalApplication.m18732r().startActivity(intent);
            return;
        }
        if (i == 2) {
            Uri uri2 = Uri.parse("http://www.chaton.com/pushclientapk");
            Intent intent2 = new Intent("android.intent.action.VIEW");
            intent2.addFlags(335544352);
            intent2.setData(uri2);
            GlobalApplication.m18732r().startActivity(intent2);
        }
    }

    /* renamed from: c */
    public static boolean m18397c(String str) {
        return C5034k.m19095a(GlobalApplication.m18732r(), str);
    }

    /* renamed from: b */
    public static boolean m18393b() {
        return C5034k.m19095a(GlobalApplication.m18732r(), "com.sec.android.app.samsungapps");
    }

    /* renamed from: c */
    public static boolean m18396c() {
        return C5034k.m19095a(GlobalApplication.m18732r(), "com.android.vending");
    }

    /* renamed from: d */
    public static void m18398d() {
        C4809aa.m18104a().m18123a("provisioning_selfsms_status");
        C4809aa.m18104a().m18123a("provisioning_disclaimer_status");
        C4809aa.m18104a().m18123a("provisioning_account_login");
        C4809aa.m18104a().m18123a("selected_country");
        C4809aa.m18104a().m18123a("provisioning_pushname_status");
        C4809aa.m18104a().m18123a("samsung_account_email");
        C4809aa.m18104a().m18123a("provisioning_sns_login_state");
        C4809aa.m18104a().m18123a("skipRegi");
        C4809aa.m18104a().m18123a("authnum");
        C4809aa.m18104a().m18123a("skip_sms_register_now");
        C4809aa.m18104a().m18123a("sms_provision_state");
        C4809aa.m18104a().m18123a("chaton_sa_is_valid");
    }

    /* renamed from: a */
    public static void m18380a(Context context, InterfaceC0419d interfaceC0419d) {
        if (m18386a(context)) {
            if (f17685a != null) {
                f17685a.m1489a(context);
            }
            f17685a = new C0416a();
            f17685a.m1492a(context, interfaceC0419d);
            f17685a.m1505n(context);
        }
    }

    /* renamed from: d */
    public static void m18400d(Context context) {
        if (f17685a != null) {
            f17685a.m1492a(context, (InterfaceC0419d) null);
            f17685a = null;
        }
    }

    /* renamed from: a */
    public static AbstractC4932a m18375a(AbstractC4932a abstractC4932a, Context context, String str) {
        if (C4904y.f17872b) {
            C4904y.m18639b("error code : " + str, "setContactUsButton");
        }
        if (!TextUtils.isEmpty(str)) {
            abstractC4932a.mo18756d(R.string.contact_us, new DialogInterfaceOnClickListenerC4860by(context, str));
        }
        return abstractC4932a;
    }

    /* renamed from: a */
    public static void m18383a(EnumC4864cb enumC4864cb, Context context) {
        int iM18370a = m18370a("com.sec.spp.push");
        if (iM18370a < 36) {
            if (C4904y.f17872b) {
                C4904y.m18639b("Current SPP version is under SPP marketing support ver. : " + iM18370a, f17686b);
                return;
            }
            return;
        }
        if (context == null) {
            context = GlobalApplication.m18732r();
        }
        String packageName = context.getPackageName();
        if (C4904y.f17872b) {
            C4904y.m18639b("setMarketingDisclaimer : " + enumC4864cb.toString() + " Request Class : " + context.getClass().getSimpleName() + " chaton package : " + packageName + " version : " + C1427a.f5063a, f17686b);
        }
        Intent intent = new Intent();
        intent.setComponent(new ComponentName("com.sec.spp.push", "com.sec.spp.push.notisvc.registration.UserAgreementReceiver"));
        intent.setAction("com.sec.spp.action.USER_AGREEMENT");
        intent.putExtra("pkgName", packageName);
        if (enumC4864cb.equals(EnumC4864cb.agree)) {
            intent.putExtra("agreement", 2);
            C4809aa.m18104a().m18125b("marketing_disclaimer", (Boolean) true);
        } else if (enumC4864cb.equals(EnumC4864cb.disagree)) {
            intent.putExtra("agreement", -2);
            C4809aa.m18104a().m18125b("marketing_disclaimer", (Boolean) false);
        } else if (enumC4864cb.equals(EnumC4864cb.deregister)) {
            intent.putExtra("agreement", -1);
        }
        intent.putExtra(VKOpenAuthActivity.VK_EXTRA_API_VERSION, C1427a.f5063a);
        if (iM18370a < 54) {
            context.sendBroadcast(intent, Config.PERMISSION_PUSH_SERVICE_PROVIDER);
            return;
        }
        try {
            intent.putExtra("accessKey", m18409g(context));
            context.sendBroadcast(intent);
        } catch (Exception e) {
            if (C4904y.f17875e) {
                C4904y.m18634a(e.toString(), f17686b);
            }
        }
    }

    /* renamed from: g */
    private static String m18409g(Context context) {
        String string = null;
        Cursor cursorQuery = context.getContentResolver().query(Uri.parse("content://com.sec.spp.accessKeyProvider/accesskey"), null, null, null, null);
        if (cursorQuery != null) {
            if (cursorQuery.moveToFirst()) {
                string = cursorQuery.getString(cursorQuery.getColumnIndex("accesskey"));
                if (C4904y.f17872b) {
                    C4904y.m18639b("SPP access key : " + string, f17686b);
                }
            }
            cursorQuery.close();
        } else if (C4904y.f17872b) {
            C4904y.m18639b("cursor is null", f17686b);
        }
        return string;
    }

    /* renamed from: e */
    public static String m18402e() {
        if (Config.CHATON_PACKAGE_NAME.equals(GlobalApplication.m18732r().getPackageName())) {
            if (C4904y.f17872b) {
                C4904y.m18639b("ChatON is golbal version", "getChatONVPackage");
            }
            return "com.coolots.chaton";
        }
        if (C4904y.f17872b) {
            C4904y.m18639b("ChatON is canada version", "getChatONVPackage");
        }
        return "com.coolots.chatonforcanada";
    }

    /* renamed from: e */
    public static void m18404e(Context context) {
        if (C4904y.f17872b) {
            C4904y.m18639b("checkValidation", f17686b);
        }
        Intent intent = new Intent("com.msc.action.VALIDATION_CHECK_REQUEST");
        intent.putExtra(VKOpenAuthActivity.VK_EXTRA_CLIENT_ID, "fs24s8z0hh");
        intent.putExtra("client_secret", "8F23805C79D7D4EBAAC5CE705A87371D");
        intent.putExtra("mypackage", context.getPackageName());
        intent.putExtra("OSP_VER", "OSP_02");
        intent.putExtra("MODE", "VALIDATION_CHECK");
        context.sendBroadcast(intent);
    }

    /* renamed from: f */
    public static Intent m18406f() {
        if (C4904y.f17872b) {
            C4904y.m18639b("checkValidation by Activity", f17686b);
        }
        Intent intent = new Intent("com.msc.action.samsungaccount.REQUEST_CHECKLIST_VALIDATION");
        intent.putExtra(VKOpenAuthActivity.VK_EXTRA_CLIENT_ID, "fs24s8z0hh");
        intent.putExtra("client_secret", "8F23805C79D7D4EBAAC5CE705A87371D");
        intent.putExtra("progress_theme", "invisible");
        intent.putExtra("validation_result_only", true);
        return intent;
    }

    /* renamed from: g */
    public static void m18410g() {
        if (AccountManager.get(CommonApplication.m18732r()).getAccountsByType(Config.CHATON_PACKAGE_NAME).length <= 0 && C4809aa.m18104a().m18129b("uid")) {
            String strM18121a = C4809aa.m18104a().m18121a("msisdn", "");
            String strM18121a2 = C4809aa.m18104a().m18121a("samsung_account_email", "");
            String strM18121a3 = C4809aa.m18104a().m18121a("uid", "");
            if (TextUtils.isEmpty(strM18121a)) {
                m18385a(strM18121a2, strM18121a3, false);
            } else {
                m18385a(strM18121a, strM18121a3, true);
            }
        }
    }

    /* renamed from: h */
    public static void m18412h() {
        C1427a.m7521d();
        C4809aa.m18104a().m18125b("first_time_after_regi", (Boolean) true);
        C2717y.m11402e();
        C4809aa.m18104a().m18128b("provisioning_disclaimer_status", "DONE");
        if (C4809aa.m18104a().m18129b("msisdn")) {
            if (C4904y.f17872b) {
                C4904y.m18639b("Success to register with phone, so save this status", f17686b);
            }
            C4809aa.m18105a("register_with_phone", (Boolean) true);
        }
        m18392b(GlobalApplication.m18732r(), "com.sec.chaton.ACTION_REGISTERED");
        C3892o.m15036j();
    }

    /* renamed from: a */
    public static InterfaceC4936e m18376a(InterfaceC4936e interfaceC4936e, Context context) throws Resources.NotFoundException {
        if (context == null) {
            if (!C4904y.f17872b) {
                return null;
            }
            C4904y.m18639b("Context is null", "makeBuddySyncDialog");
            return null;
        }
        View viewInflate = LayoutInflater.from(context).inflate(R.layout.layout_multidevice_sync, (ViewGroup) null, false);
        String string = context.getResources().getString(R.string.multi_deivce_mapping_pop_up_title);
        String string2 = context.getResources().getString(R.string.auto_regi_buddy_sync);
        String str = context.getResources().getString(R.string.multidevice_sync_popup).split("\n\n")[1];
        TextView textView = (TextView) viewInflate.findViewById(R.id.messageText);
        ((TextView) viewInflate.findViewById(R.id.subTitleText)).setText(string2);
        textView.setText(str);
        InterfaceC4936e interfaceC4936eMo18745a = AbstractC4932a.m18733a(context).mo18740a(string).mo18748b(viewInflate).mo18742a(true).mo18745a();
        interfaceC4936eMo18745a.setCancelable(false);
        return interfaceC4936eMo18745a;
    }

    /* renamed from: f */
    public static boolean m18407f(Context context) {
        if (context == null) {
            return false;
        }
        try {
            Signature[] signatureArr = context.getPackageManager().getPackageInfo("com.osp.app.signin", 64).signatures;
            if (C4904y.f17872b) {
                C4904y.m18639b("sigs: " + signatureArr[0].hashCode(), f17686b);
            }
            return signatureArr[0].hashCode() == 384506773;
        } catch (PackageManager.NameNotFoundException e) {
            if (!C4904y.f17874d) {
                return false;
            }
            C4904y.m18645d("Samsung Account was NOT installed", f17686b);
            return false;
        }
    }

    /* renamed from: b */
    public static void m18392b(Context context, String str) {
        if (C4904y.f17872b) {
            C4904y.m18639b("sendBroadCastUsingToken : " + str, f17686b);
        }
        Intent intent = new Intent(str);
        for (ResolveInfo resolveInfo : context.getPackageManager().queryBroadcastReceivers(intent, 0)) {
            String str2 = resolveInfo.activityInfo.packageName;
            if (C4904y.f17872b) {
                C4904y.m18639b("package name : " + str2, f17686b);
            }
            if (str2 != null && C1041a.m6139a(context, str2)) {
                if (C4904y.f17872b) {
                    C4904y.m18639b("sendBroadcast to " + str2, f17686b);
                }
                intent.setPackage(resolveInfo.activityInfo.packageName);
                context.sendBroadcast(intent);
            }
        }
    }

    /* renamed from: d */
    public static boolean m18401d(String str) {
        if (str != null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add("com.sec.chaton.HomeActivity");
            arrayList.add("com.sec.chaton.TabActivity");
            arrayList.add("com.sec.chaton.registration.RegisterSMSActivity");
            arrayList.add("com.sec.chaton.SplashActivity");
            arrayList.add("com.sec.chaton.registration.AuthenticatorActivity");
            z = arrayList.contains(str);
            if (C4904y.f17872b) {
                C4904y.m18639b("currentActivity : " + str + " isRootActivity : " + z, f17686b);
            }
        }
        return z;
    }

    /* renamed from: a */
    public static Intent m18372a(Context context, Class<?> cls) {
        if (C4904y.f17872b) {
            C4904y.m18639b("request : " + context.getClass().getSimpleName() + " destination : " + cls.getSimpleName(), f17686b);
        }
        Intent intent = new Intent(context, cls);
        intent.putExtra("finish", true);
        if (context instanceof Activity) {
            C4904y.m18646e("instanceOf Activity", f17686b);
            intent.setFlags(67108864);
        } else {
            C4904y.m18646e("No instanceOf Activity", f17686b);
            intent.setFlags(335544320);
        }
        return intent;
    }

    /* renamed from: i */
    public static void m18414i() {
        if (C2349a.m10301a("gcm_push_feature")) {
            try {
                C0693a.m2213a(GlobalApplication.m18732r());
                C0693a.m2218b(GlobalApplication.m18732r());
                String strM2222e = C0693a.m2222e(GlobalApplication.m18732r());
                if ("".equals(strM2222e)) {
                    if (C4904y.f17873c) {
                        C4904y.m18641c("GCMRegistrar : request register", f17686b);
                    }
                    C0693a.m2216a(GlobalApplication.m18732r(), "256731395928");
                } else {
                    if (C4904y.f17873c) {
                        C4904y.m18641c("GCMRegistrar : already regist, gcmRegId(" + strM2222e + ")", f17686b);
                    }
                    GlobalApplication.f8356b = strM2222e;
                    m18405e(strM2222e);
                }
            } catch (Exception e) {
                if (C4904y.f17875e) {
                    C4904y.m18635a(e, f17686b);
                }
            }
        }
    }

    /* renamed from: e */
    public static void m18405e(String str) {
        String strM18121a = C4809aa.m18104a().m18121a("get_version_gcm_reg_id", "");
        C4904y.m18639b("Last get version GCM registration id: " + strM18121a, f17686b);
        if (strM18121a.equals(str)) {
            C4904y.m18639b("Last get version GCM regi id == current gcm regi id. don't execute GetVersion.", f17686b);
            return;
        }
        C4904y.m18639b("Last get version GCM registration id isn't equal. execute GetVersion.", f17686b);
        HandlerThread handlerThread = new HandlerThread(f17686b);
        handlerThread.start();
        new C2122ca(new HandlerC4861bz(handlerThread.getLooper())).m9469a();
    }

    /* renamed from: j */
    public static boolean m18415j() throws PackageManager.NameNotFoundException {
        int iM18370a = m18370a("com.sec.spp.push");
        if (iM18370a >= 36) {
            return true;
        }
        if (C4904y.f17872b) {
            C4904y.m18639b("SPP is not support to push marketing : " + iM18370a, f17686b);
        }
        return false;
    }

    /* renamed from: a */
    public static Intent m18371a(Context context, FragmentWebView.mode modeVar, String str) {
        if (C4904y.f17872b) {
            C4904y.m18639b("[ " + context.getClass().getSimpleName() + " ] mode : " + modeVar.toString() + "errorCdoe : " + str, f17686b);
        }
        return new Intent("android.intent.action.VIEW", Uri.parse(FragmentWebView.makeURLForMuse(context, modeVar, str)));
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0067  */
    /* renamed from: f */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean m18408f(java.lang.String r4) {
        /*
            r1 = 1
            r0 = 0
            boolean r2 = android.text.TextUtils.isEmpty(r4)
            if (r2 == 0) goto L69
            com.sec.chaton.util.ab r2 = com.sec.chaton.util.C4809aa.m18104a()
            java.lang.String r3 = "chaton_sns_facebook_feature"
            boolean r2 = r2.m18129b(r3)
            if (r2 == 0) goto L51
            com.sec.chaton.util.ab r0 = com.sec.chaton.util.C4809aa.m18104a()
            java.lang.String r2 = "chaton_sns_facebook_feature"
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r1)
            java.lang.Boolean r0 = r0.m18119a(r2, r1)
            boolean r0 = r0.booleanValue()
        L28:
            boolean r1 = com.sec.chaton.util.C4904y.f17872b
            if (r1 == 0) goto L50
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "supportFaceBook : "
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.StringBuilder r1 = r1.append(r0)
            java.lang.String r2 = " , iso : "
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.StringBuilder r1 = r1.append(r4)
            java.lang.String r1 = r1.toString()
            java.lang.String r2 = com.sec.chaton.util.C4859bx.f17686b
            com.sec.chaton.util.C4904y.m18639b(r1, r2)
        L50:
            return r0
        L51:
            java.lang.String r2 = com.sec.chaton.util.C4822an.m18236g()
            if (r2 == 0) goto L67
            java.util.ArrayList<java.lang.CharSequence> r2 = com.sec.chaton.util.C4859bx.f17687c
            java.lang.String r3 = com.sec.chaton.util.C4822an.m18236g()
            java.lang.String r3 = r3.toUpperCase()
            boolean r2 = r2.contains(r3)
            if (r2 != 0) goto L28
        L67:
            r0 = r1
            goto L28
        L69:
            java.util.ArrayList<java.lang.CharSequence> r2 = com.sec.chaton.util.C4859bx.f17687c
            boolean r2 = r2.contains(r4)
            if (r2 == 0) goto L67
            goto L28
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.util.C4859bx.m18408f(java.lang.String):boolean");
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x005e  */
    /* renamed from: g */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean m18411g(java.lang.String r4) {
        /*
            r1 = 1
            r0 = 0
            boolean r2 = android.text.TextUtils.isEmpty(r4)
            if (r2 == 0) goto L60
            com.sec.chaton.util.ab r2 = com.sec.chaton.util.C4809aa.m18104a()
            java.lang.String r3 = "chaton_sns_vkontakte_feature"
            boolean r2 = r2.m18129b(r3)
            if (r2 == 0) goto L51
            com.sec.chaton.util.ab r0 = com.sec.chaton.util.C4809aa.m18104a()
            java.lang.String r2 = "chaton_sns_vkontakte_feature"
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r1)
            java.lang.Boolean r0 = r0.m18119a(r2, r1)
            boolean r0 = r0.booleanValue()
        L28:
            boolean r1 = com.sec.chaton.util.C4904y.f17872b
            if (r1 == 0) goto L50
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "supportVkontakte : "
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.StringBuilder r1 = r1.append(r0)
            java.lang.String r2 = " , iso : "
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.StringBuilder r1 = r1.append(r4)
            java.lang.String r1 = r1.toString()
            java.lang.String r2 = com.sec.chaton.util.C4859bx.f17686b
            com.sec.chaton.util.C4904y.m18639b(r1, r2)
        L50:
            return r0
        L51:
            java.lang.String r2 = "IT"
            java.lang.String r3 = com.sec.chaton.util.C4822an.m18236g()
            boolean r2 = r2.equalsIgnoreCase(r3)
            if (r2 != 0) goto L28
        L5e:
            r0 = r1
            goto L28
        L60:
            java.lang.String r2 = "IT"
            boolean r2 = r2.equalsIgnoreCase(r4)
            if (r2 == 0) goto L5e
            goto L28
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.util.C4859bx.m18411g(java.lang.String):boolean");
    }

    /* renamed from: h */
    public static boolean m18413h(String str) {
        boolean zBooleanValue = C4809aa.m18104a().m18129b("chaton_sns_odnok_feature") ? C4809aa.m18104a().m18119a("chaton_sns_odnok_feature", (Boolean) true).booleanValue() : true;
        if (C4904y.f17872b) {
            C4904y.m18639b("supportOdnok : " + zBooleanValue + " , iso : " + str, f17686b);
        }
        return zBooleanValue;
    }

    /* renamed from: a */
    public static boolean m18387a(String str, Activity activity) {
        if (System.currentTimeMillis() >= 1427864400000L || (!"US".equals(str) && !"VI".equals(str) && !"PR".equals(str))) {
            Intent intent = new Intent(activity, (Class<?>) EOSPopupActivity.class);
            intent.setFlags(603979776);
            intent.putExtra("force_close", C4809aa.m18104a().m18129b("uid") ? false : true);
            intent.putExtra("country_code", str);
            activity.startActivityForResult(intent, 100);
            z = true;
        }
        if (C4904y.f17872b) {
            C4904y.m18639b("showEOSPopup : " + z + " , iso : " + str, f17686b);
        }
        return z;
    }
}
