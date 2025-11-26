package com.coolots.sso.p006a;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.util.Log;
import java.util.ArrayList;

/* renamed from: com.coolots.sso.a.a */
/* loaded from: classes.dex */
public class C0045a {

    /* renamed from: a */
    private static boolean f33a = false;

    /* renamed from: b */
    private C0050f f34b = null;

    /* renamed from: c */
    private InterfaceC0047c f35c = null;

    /* renamed from: d */
    private C0049e f36d = null;

    /* renamed from: e */
    private InterfaceC0046b f37e = null;

    /* renamed from: f */
    private C0051g f38f = null;

    /* renamed from: g */
    private InterfaceC0048d f39g = null;

    public C0045a() {
        m36b("ChatONVAPII create() " + toString());
    }

    /* renamed from: a */
    public static String m28a(int i) {
        switch (i) {
            case 0:
                return "STATE_INIT";
            case 1:
                return "STATE_CALLING";
            case 2:
                return "STATE_CONNECTED";
            case 3:
                return "STATE_DISCONNECTED";
            case 100:
                return "STATE_CHANGE_TO_CONFERENCE_CONNECTED";
            case 101:
                return "STATE_CHANGE_TO_P2P_CONNECTED";
            case 102:
                return "STATE_CHANGE_TO_CONFERENCE_DISCONNECTED";
            case 103:
                return "STATE_CHANGE_TO_P2P_DISCONNECTED";
            default:
                return null;
        }
    }

    /* renamed from: a */
    public static void m29a(Context context, boolean z) {
        f33a = z;
        m36b("setDisplayLog: " + z);
        if (!m37b(context)) {
            m39c("ChatON V is not installed");
            return;
        }
        int iM33b = m33b(context, "content://com.coolots.chaton/set_log_display");
        if (iM33b == 1) {
            m39c("not allowed access");
        } else if (iM33b == 2) {
            m39c("not supported function");
        } else {
            context.getContentResolver().update(Uri.parse("content://com.coolots.chaton/set_log_display"), new ContentValues(), z ? "1" : "0", null);
        }
    }

    /* renamed from: a */
    public static boolean m31a() {
        return f33a;
    }

    /* renamed from: a */
    public static boolean m32a(Context context, String str) throws PackageManager.NameNotFoundException {
        try {
            context.getPackageManager().getApplicationInfo(str, 128);
            m36b(String.valueOf(str) + "isInstalled() true");
            return true;
        } catch (PackageManager.NameNotFoundException e) {
            m36b(String.valueOf(str) + "isInstalled() false");
            return false;
        }
    }

    /* renamed from: b */
    private static int m33b(Context context, String str) {
        m36b("checkKey()");
        ContentValues contentValues = new ContentValues();
        contentValues.put("key", context.getPackageName());
        contentValues.put("function", str);
        Uri uriInsert = context.getContentResolver().insert(Uri.parse("content://com.coolots.chaton/key"), contentValues);
        if (uriInsert == null) {
            return 1;
        }
        if (uriInsert.toString().equals("content://com.coolots.chaton/not_supported_function")) {
            return 2;
        }
        return uriInsert.toString().equals("content://com.coolots.chaton/no_account") ? 3 : 0;
    }

    /* renamed from: b */
    public static String m35b(int i) {
        switch (i) {
            case 0:
                return "RET_CHATONV_SUCCESS";
            case 1:
                return "RET_CHATONV_FAIL";
            case 2:
                return "RET_CHATONV_NOT_INSTALLED";
            case 3:
                return "RET_CHATONV_ID_EMPTY";
            case 4:
                return "RET_CHATONV_UNEXPECTED_ERROR";
            case 5:
                return "RET_CHATONV_NOT_ALLOWED_ACCESS";
            case 6:
                return "RET_CHATONV_NATIONAL_CODE_EMPTY";
            case 7:
                return "RET_CHATONV_GUID_EMPTY";
            case 8:
                return "RET_CHATONV_CALLER_NAME_EMPTY";
            case 9:
                return "RET_CHATONV_CHATON_NUMBER_EMPTY";
            case 10:
                return "RET_CHATONV_CHATON_UID_EMPTY";
            case 11:
                return "RET_CHATONV_IMEI_EMPTY";
            case 12:
                return "RET_CHATONV_BIRTHDAY_EMPTY";
            case 13:
                return "RET_CHATONV_NOT_SUPPORTED_FUNCTION";
            case 14:
                return "RET_CHATONV_NO_ACCOUNT";
            default:
                return "";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public static void m36b(String str) {
        if (f33a) {
            Log.i("ChatONVAPII(1.0.0.3)", str);
        }
    }

    /* renamed from: b */
    public static boolean m37b(Context context) {
        return m32a(context, "com.coolots.chaton") || m32a(context, "com.coolots.chatonforcanada");
    }

    /* renamed from: c */
    private static void m39c(String str) {
        if (f33a) {
            Log.e("ChatONVAPII(1.0.0.3)", str);
        }
    }

    /* renamed from: o */
    private void m43o(Context context) {
        if (this.f35c != null) {
            m36b("clearAccountListener: mListener :" + this.f35c.toString() + " => removed");
            this.f35c = null;
        }
        if (this.f34b != null) {
            m36b("clearAccountListener: mReceiver :" + this.f34b.toString() + " => removed");
            try {
                context.unregisterReceiver(this.f34b);
            } catch (IllegalArgumentException e) {
                m39c("IllegalArgumentException \n e");
            } finally {
                this.f34b = null;
            }
        }
    }

    /* renamed from: p */
    private void m44p(Context context) {
        if (this.f37e != null) {
            m36b("clearCallListener: mCallListener :" + this.f37e.toString() + " => removed");
            this.f37e = null;
        }
        if (this.f36d != null) {
            m36b("clearCallListener: mCallReceiver :" + this.f36d.toString() + " => removed");
            try {
                context.unregisterReceiver(this.f36d);
            } catch (IllegalArgumentException e) {
                m39c("IllegalArgumentException \n e");
            } finally {
                this.f36d = null;
            }
        }
    }

    /* renamed from: q */
    private void m45q(Context context) {
        if (this.f39g != null) {
            m36b("clearUpdateListener: mUpdateListener :" + this.f39g.toString() + " => removed");
            this.f39g = null;
        }
        if (this.f38f != null) {
            m36b("clearUpdateListener: mUpdateReceiver :" + this.f38f.toString() + " => removed");
            try {
                context.unregisterReceiver(this.f38f);
            } catch (IllegalArgumentException e) {
                m39c("IllegalArgumentException \n e");
            } finally {
                this.f38f = null;
            }
        }
    }

    /* renamed from: a */
    public int m46a(Context context, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
        m36b("createAccount() call start");
        if (!m37b(context)) {
            m39c("ChatON V is not installed");
            return 2;
        }
        int iM33b = m33b(context, "content://com.coolots.chaton/create_account");
        if (iM33b == 1) {
            m39c("not allowed access");
            return 5;
        }
        if (iM33b == 2) {
            m39c("not supported function");
            return 13;
        }
        if (iM33b == 3) {
            m36b("no account");
        }
        if (str2 == null || str2.isEmpty()) {
            m36b("samsungAccount is empty");
            return 3;
        }
        if (str3 == null || str3.isEmpty()) {
            m36b("nationalCode is empty");
            return 6;
        }
        if (str4 == null || str4.isEmpty()) {
            m36b("GUID is empty");
            return 7;
        }
        if (str5 == null || str5.isEmpty()) {
            m36b("callerName is empty");
            return 8;
        }
        if (str == null || str.isEmpty()) {
            m36b("chatonID is empty");
            return 9;
        }
        if (str6 == null || str6.isEmpty()) {
            m36b("IMEI is empty");
            return 11;
        }
        if (str7 == null || str7.isEmpty()) {
            m36b("chatONUID is empty");
            return 10;
        }
        if (str8 == null || str8.isEmpty()) {
            m36b("birthday is empty");
        }
        Cursor cursorQuery = context.getContentResolver().query(Uri.parse("content://com.coolots.chaton/create_account"), null, null, new String[]{String.valueOf(str2), String.valueOf(str3), String.valueOf(str5), String.valueOf(str4), String.valueOf(str), String.valueOf(str6), String.valueOf(str7), String.valueOf(str8)}, null);
        if (cursorQuery != null) {
            cursorQuery.close();
        }
        return 0;
    }

    /* renamed from: a */
    public int m47a(Context context, boolean z, String str, String str2, String str3) {
        m36b("outgoingCall() call start");
        if (!m37b(context)) {
            m39c("ChatON V is not installed");
            return 2;
        }
        int iM33b = m33b(context, "content://com.coolots.chaton/outgoingcall");
        if (iM33b == 1) {
            m39c("not allowed access");
            return 5;
        }
        if (iM33b == 2) {
            m39c("not supported function");
            return 13;
        }
        if (iM33b == 3) {
            m39c("no account");
            return 14;
        }
        if (str == null || str.isEmpty()) {
            m36b("chatonID is empty");
            return 3;
        }
        String[] strArr = new String[4];
        strArr[0] = String.valueOf(z ? "1" : "0");
        strArr[1] = String.valueOf(str2);
        strArr[2] = String.valueOf(str);
        strArr[3] = String.valueOf(str3);
        Cursor cursorQuery = context.getContentResolver().query(Uri.parse("content://com.coolots.chaton/outgoingcall"), null, null, strArr, null);
        if (cursorQuery != null) {
            cursorQuery.close();
        }
        return 0;
    }

    /* renamed from: a */
    public int m48a(Context context, boolean z, String[] strArr, String str, String str2, String str3) {
        m36b("outgoingConferenceCall() call start");
        if (!m37b(context)) {
            m39c("ChatON V is not installed");
            return 2;
        }
        int iM33b = m33b(context, "content://com.coolots.chaton/outgoingconferencecall");
        if (iM33b == 1) {
            m39c("not allowed access");
            return 5;
        }
        if (iM33b == 2) {
            m39c("not supported function");
            return 13;
        }
        if (iM33b == 3) {
            m39c("no account");
            return 14;
        }
        if (strArr == null || strArr.length == 0) {
            m36b("samsungAccount is empty");
            return 3;
        }
        String[] strArr2 = new String[strArr.length + 5];
        strArr2[0] = String.valueOf(z ? "1" : "0");
        strArr2[1] = String.valueOf(str);
        strArr2[2] = String.valueOf(str2);
        strArr2[3] = String.valueOf(str3);
        strArr2[4] = String.valueOf(strArr.length);
        System.arraycopy(strArr, 0, strArr2, 5, strArr.length);
        Cursor cursorQuery = context.getContentResolver().query(Uri.parse("content://com.coolots.chaton/outgoingconferencecall"), null, null, strArr2, null);
        if (cursorQuery != null) {
            cursorQuery.close();
        }
        return 0;
    }

    /* renamed from: a */
    public void m49a(Context context) {
        m36b("dispose()");
        m43o(context);
        m44p(context);
        m45q(context);
    }

    /* renamed from: a */
    public void m50a(Context context, InterfaceC0046b interfaceC0046b) {
        C0049e c0049e = null;
        if (interfaceC0046b == null) {
            m36b("setCallListener: clear " + toString());
            m44p(context);
            return;
        }
        m44p(context);
        this.f37e = interfaceC0046b;
        this.f36d = new C0049e(this, c0049e);
        m36b("setCallListener: set " + toString());
        m36b("setCallListener: mCallListener " + this.f37e.toString());
        m36b("setCallListener: mCallReceiver " + this.f36d.toString());
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.coolots.chaton.version.CONFERENCE_MEMBER_CHANGED");
        intentFilter.addAction("com.coolots.chaton.account.CALL_STATE_CHANGE_INFO");
        context.registerReceiver(this.f36d, intentFilter, "com.coolots.permission.COOLOTS", null);
    }

    /* renamed from: a */
    public void m51a(Context context, InterfaceC0047c interfaceC0047c) {
        C0050f c0050f = null;
        if (interfaceC0047c == null) {
            m36b("setListener: clear " + toString());
            m43o(context);
            return;
        }
        m43o(context);
        this.f35c = interfaceC0047c;
        this.f34b = new C0050f(this, c0050f);
        m36b("setListener: set :" + toString());
        m36b("setListener: mListener :" + this.f35c.toString());
        m36b("setListener: mReceiver :" + this.f34b.toString());
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.coolots.chaton.account.ACCOUNT_RESULTINFO");
        intentFilter.addAction("com.coolots.chaton.account.REMOVE_ACCOUNT_RESULTINFO");
        context.registerReceiver(this.f34b, intentFilter, "com.coolots.permission.COOLOTS", null);
    }

    /* renamed from: a */
    public void m52a(Context context, InterfaceC0048d interfaceC0048d) {
        C0051g c0051g = null;
        if (interfaceC0048d == null) {
            m36b("setUpdateListener: clear " + toString());
            m45q(context);
            return;
        }
        m45q(context);
        this.f39g = interfaceC0048d;
        this.f38f = new C0051g(this, c0051g);
        m36b("setUpdateListener: set " + toString());
        m36b("setUpdateListener: mUpdateListener " + this.f39g.toString());
        m36b("setUpdateListener: mUpdateReceiver " + this.f38f.toString());
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.coolots.chaton.version.UPGRADE_NEW_APK_INFO");
        context.registerReceiver(this.f38f, intentFilter, "com.coolots.permission.COOLOTS", null);
    }

    /* renamed from: b */
    public int m53b(Context context, boolean z) {
        m36b("getMaxConferenceMemberCnt()");
        if (!m37b(context)) {
            m39c("ChatON V is not installed");
            return 0;
        }
        int iM33b = m33b(context, "content://com.coolots.chaton/maxconferencecallnum");
        if (iM33b == 1) {
            m39c("not allowed access");
            return 0;
        }
        if (iM33b == 2) {
            m39c("not supported function");
            return 0;
        }
        if (iM33b == 3) {
            m39c("no account");
            return 0;
        }
        return context.getContentResolver().update(Uri.parse("content://com.coolots.chaton/maxconferencecallnum"), new ContentValues(), z ? "1" : "0", null);
    }

    /* renamed from: c */
    public int m54c(Context context) {
        m36b("removeAccountInDevice() call start");
        if (!m37b(context)) {
            m39c("ChatON V is not installed");
            return 2;
        }
        int iM33b = m33b(context, "content://com.coolots.chaton/remove_account");
        if (iM33b == 1) {
            m39c("not allowed access");
            return 5;
        }
        if (iM33b == 2) {
            m39c("not supported function");
            return 13;
        }
        Cursor cursorQuery = context.getContentResolver().query(Uri.parse("content://com.coolots.chaton/remove_account"), null, null, null, null);
        if (cursorQuery != null) {
            cursorQuery.close();
        }
        return 0;
    }

    /* renamed from: d */
    public boolean m55d(Context context) {
        m36b("isReadyToCall() call start");
        if (!m37b(context)) {
            m39c("ChatON V is not installed");
            return false;
        }
        int iM33b = m33b(context, "content://com.coolots.chaton/account");
        if (iM33b == 1) {
            m39c("not allowed access");
            return false;
        }
        if (iM33b == 2) {
            m39c("not supported function");
            return false;
        }
        if (iM33b != 3) {
            return true;
        }
        m39c("no account");
        return false;
    }

    /* renamed from: e */
    public Intent m56e(Context context) {
        m36b("getIntentSettingActivity()");
        if (!m55d(context)) {
            m36b("getIntentSettingActivity() return null");
            return null;
        }
        Intent intent = new Intent();
        intent.setAction("com.coolots.chaton.USER_SETTING_SUBPAGE_CALL_SETTINGS");
        return intent;
    }

    /* renamed from: f */
    public Intent m57f(Context context) {
        m36b("getIntentDataUsageActivity()");
        if (!m55d(context)) {
            m36b("getIntentDataUsageActivity() return null");
            return null;
        }
        Intent intent = new Intent();
        intent.setAction("com.coolots.chaton.USER_SETTING_SUBPAGE_DATA_USGAE");
        return intent;
    }

    /* renamed from: g */
    public boolean m58g(Context context) {
        m36b("showCallActivity() call start");
        if (!m37b(context)) {
            m39c("ChatON V is not installed");
            return false;
        }
        int iM33b = m33b(context, "content://com.coolots.chaton/remotecallactivity");
        if (iM33b == 1) {
            m39c("not allowed access");
            return false;
        }
        if (iM33b == 2) {
            m39c("not supported function");
            return false;
        }
        if (iM33b != 3) {
            return context.getContentResolver().update(Uri.parse("content://com.coolots.chaton/remotecallactivity"), new ContentValues(), "0", null) == 1;
        }
        m39c("no account");
        return false;
    }

    /* renamed from: h */
    public boolean m59h(Context context) {
        m36b("endCallActivity() call start");
        if (!m37b(context)) {
            m39c("ChatON V is not installed");
            return false;
        }
        int iM33b = m33b(context, "content://com.coolots.chaton/remotecallactivity");
        if (iM33b == 1) {
            m39c("not allowed access");
            return false;
        }
        if (iM33b == 2) {
            m39c("not supported function");
            return false;
        }
        if (iM33b != 3) {
            return context.getContentResolver().update(Uri.parse("content://com.coolots.chaton/remotecallactivity"), new ContentValues(), "1", null) == 1;
        }
        m39c("no account");
        return false;
    }

    /* renamed from: i */
    public int m60i(Context context) {
        m36b("getCallDuration() call start");
        if (!m37b(context)) {
            m39c("ChatON V is not installed");
            return -1;
        }
        int iM33b = m33b(context, "content://com.coolots.chaton/callduration");
        if (iM33b == 1) {
            m39c("not allowed access");
            return -1;
        }
        if (iM33b == 2) {
            m39c("not supported function");
            return -1;
        }
        if (iM33b == 3) {
            m39c("no account");
            return -1;
        }
        String type = context.getContentResolver().getType(Uri.parse("content://com.coolots.chaton/callduration"));
        if (type != null) {
            return Integer.parseInt(type);
        }
        return -1;
    }

    /* renamed from: j */
    public boolean m61j(Context context) {
        m36b("isCalling() call start");
        if (!m37b(context)) {
            m39c("ChatON V is not installed");
            return false;
        }
        int iM33b = m33b(context, "content://com.coolots.chaton/iscalling");
        if (iM33b == 1) {
            m39c("not allowed access");
            return false;
        }
        if (iM33b == 2) {
            m39c("not supported function");
            return false;
        }
        if (iM33b != 3) {
            return context.getContentResolver().getType(Uri.parse("content://com.coolots.chaton/iscalling")) != null;
        }
        m39c("no account");
        return false;
    }

    /* renamed from: k */
    public int m62k(Context context) {
        m36b("getCallStateDuringCall() call start");
        if (!m37b(context)) {
            m39c("ChatON V is not installed");
            return 0;
        }
        int iM33b = m33b(context, "content://com.coolots.chaton/callstate");
        if (iM33b == 1) {
            m39c("not allowed access");
            return 0;
        }
        if (iM33b == 2) {
            m39c("not supported function");
            return 0;
        }
        if (iM33b == 3) {
            m39c("no account");
            return 0;
        }
        String type = context.getContentResolver().getType(Uri.parse("content://com.coolots.chaton/callstate"));
        if (type == null) {
            return 3;
        }
        return Integer.parseInt(type);
    }

    /* renamed from: l */
    public int m63l(Context context) {
        m36b("getCallType() call start");
        if (!m37b(context)) {
            m39c("ChatON V is not installed");
            return 0;
        }
        int iM33b = m33b(context, "content://com.coolots.chaton/get_call_type");
        if (iM33b == 1) {
            m39c("not allowed access");
            return 0;
        }
        if (iM33b == 2) {
            m39c("not supported function");
            return 0;
        }
        if (iM33b == 3) {
            m39c("no account");
            return 0;
        }
        return context.getContentResolver().update(Uri.parse("content://com.coolots.chaton/get_call_type"), new ContentValues(), null, null);
    }

    /* renamed from: m */
    public ArrayList m64m(Context context) {
        m36b("getCallMember() call start");
        if (!m37b(context)) {
            m39c("ChatON V is not installed");
            return null;
        }
        int iM33b = m33b(context, "content://com.coolots.chaton/get_call_member");
        if (iM33b == 1) {
            m39c("not allowed access");
            return null;
        }
        if (iM33b == 2) {
            m39c("not supported function");
            return null;
        }
        if (iM33b == 3) {
            m39c("no account");
            return null;
        }
        ContentResolver contentResolver = context.getContentResolver();
        ArrayList arrayList = new ArrayList();
        String type = contentResolver.getType(Uri.parse("content://com.coolots.chaton/get_call_member"));
        if (type == null || type.length() == 0) {
            return null;
        }
        String[] strArrSplit = type.split(":");
        for (String str : strArrSplit) {
            arrayList.add(str);
        }
        m36b("call member: " + arrayList);
        if (arrayList.size() == 0) {
            return null;
        }
        return arrayList;
    }

    /* renamed from: n */
    public int m65n(Context context) {
        m36b("getLatestApkVersion() call start");
        if (!m37b(context)) {
            m39c("ChatON V is not installed");
            return 2;
        }
        int iM33b = m33b(context, "content://com.coolots.chaton/get_latest_version");
        if (iM33b == 1) {
            m39c("not allowed access");
            return 5;
        }
        if (iM33b == 2) {
            m39c("not supported function");
            return 13;
        }
        if (iM33b == 3) {
            m39c("no account");
            return 14;
        }
        context.getContentResolver().getType(Uri.parse("content://com.coolots.chaton/get_latest_version"));
        return 0;
    }
}
