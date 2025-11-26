package com.coolots.sso.p030a;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.util.Log;
import com.sec.chaton.privateplugin.data.Spam;
import java.util.ArrayList;

/* renamed from: com.coolots.sso.a.a */
/* loaded from: classes.dex */
public class C0416a {

    /* renamed from: a */
    private static boolean f1002a = false;

    /* renamed from: b */
    private C0421f f1003b = null;

    /* renamed from: c */
    private InterfaceC0418c f1004c = null;

    /* renamed from: d */
    private C0420e f1005d = null;

    /* renamed from: e */
    private InterfaceC0417b f1006e = null;

    /* renamed from: f */
    private C0422g f1007f = null;

    /* renamed from: g */
    private InterfaceC0419d f1008g = null;

    public C0416a() {
        m1476b("ChatONVAPII create() " + this);
    }

    /* renamed from: a */
    public static String m1468a(int i) {
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
    public static void m1469a(Context context, boolean z) {
        f1002a = z;
        m1476b("setDisplayLog: " + z);
        if (!m1477b(context)) {
            m1479c("ChatON V is not installed");
            return;
        }
        int iM1473b = m1473b(context, "content://com.coolots.chaton/set_log_display");
        if (iM1473b == 1) {
            m1479c("not allowed access");
            return;
        }
        if (iM1473b == 2) {
            m1479c("not supported function");
            return;
        }
        try {
            context.getContentResolver().update(Uri.parse("content://com.coolots.chaton/set_log_display"), new ContentValues(), z ? Spam.ACTIVITY_REPORT : Spam.ACTIVITY_CANCEL, null);
        } catch (IllegalArgumentException e) {
            StackTraceElement[] stackTrace = e.getStackTrace();
            for (StackTraceElement stackTraceElement : stackTrace) {
                m1476b(stackTraceElement.toString());
            }
        }
    }

    /* renamed from: a */
    public static boolean m1471a() {
        return f1002a;
    }

    /* renamed from: a */
    public static boolean m1472a(Context context, String str) throws PackageManager.NameNotFoundException {
        try {
            context.getPackageManager().getApplicationInfo(str, 128);
            m1476b(String.valueOf(str) + "isInstalled() true");
            return true;
        } catch (PackageManager.NameNotFoundException e) {
            m1476b(String.valueOf(str) + "isInstalled() false");
            return false;
        }
    }

    /* renamed from: b */
    private static int m1473b(Context context, String str) {
        Uri uriInsert;
        m1476b("checkKey()");
        ContentValues contentValues = new ContentValues();
        contentValues.put("key", context.getPackageName());
        contentValues.put("function", str);
        try {
            uriInsert = context.getContentResolver().insert(Uri.parse("content://com.coolots.chaton/key"), contentValues);
        } catch (IllegalArgumentException e) {
            StackTraceElement[] stackTrace = e.getStackTrace();
            for (StackTraceElement stackTraceElement : stackTrace) {
                m1476b(stackTraceElement.toString());
            }
            uriInsert = null;
        }
        if (uriInsert == null) {
            return 1;
        }
        if (uriInsert.toString().equals("content://com.coolots.chaton/not_supported_function")) {
            return 2;
        }
        return uriInsert.toString().equals("content://com.coolots.chaton/no_account") ? 3 : 0;
    }

    /* renamed from: b */
    public static String m1475b(int i) {
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
    public static void m1476b(String str) {
        if (f1002a) {
            Log.i("ChatONVAPII(1.0.0.6)", str);
        }
    }

    /* renamed from: b */
    public static boolean m1477b(Context context) {
        return m1472a(context, "com.coolots.chaton") || m1472a(context, "com.coolots.chatonforcanada");
    }

    /* renamed from: c */
    private static void m1479c(String str) {
        if (f1002a) {
            Log.e("ChatONVAPII(1.0.0.6)", str);
        }
    }

    /* renamed from: o */
    private void m1483o(Context context) {
        if (this.f1004c != null) {
            m1476b("clearAccountListener: mListener :" + this.f1004c + " => removed");
            this.f1004c = null;
        }
        if (this.f1003b != null) {
            m1476b("clearAccountListener: mReceiver :" + this.f1003b + " => removed");
            try {
                context.unregisterReceiver(this.f1003b);
            } catch (IllegalArgumentException e) {
                m1479c("IllegalArgumentException \n e");
            } finally {
                this.f1003b = null;
            }
        }
    }

    /* renamed from: p */
    private void m1484p(Context context) {
        if (this.f1006e != null) {
            m1476b("clearCallListener: mCallListener :" + this.f1006e + " => removed");
            this.f1006e = null;
        }
        if (this.f1005d != null) {
            m1476b("clearCallListener: mCallReceiver :" + this.f1005d + " => removed");
            try {
                context.unregisterReceiver(this.f1005d);
            } catch (IllegalArgumentException e) {
                m1479c("IllegalArgumentException \n e");
            } finally {
                this.f1005d = null;
            }
        }
    }

    /* renamed from: q */
    private void m1485q(Context context) {
        if (this.f1008g != null) {
            m1476b("clearUpdateListener: mUpdateListener :" + this.f1008g + " => removed");
            this.f1008g = null;
        }
        if (this.f1007f != null) {
            m1476b("clearUpdateListener: mUpdateReceiver :" + this.f1007f + " => removed");
            try {
                context.unregisterReceiver(this.f1007f);
            } catch (IllegalArgumentException e) {
                m1479c("IllegalArgumentException \n e");
            } finally {
                this.f1007f = null;
            }
        }
    }

    /* renamed from: a */
    public int m1486a(Context context, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
        m1476b("createAccount() call start");
        if (!m1477b(context)) {
            m1479c("ChatON V is not installed");
            return 2;
        }
        int iM1473b = m1473b(context, "content://com.coolots.chaton/create_account");
        if (iM1473b == 1) {
            m1479c("not allowed access");
            return 5;
        }
        if (iM1473b == 2) {
            m1479c("not supported function");
            return 13;
        }
        if (iM1473b == 3) {
            m1476b("no account");
        }
        if (str2 == null || str2.isEmpty()) {
            m1476b("samsungAccount is empty");
            return 3;
        }
        if (str3 == null || str3.isEmpty()) {
            m1476b("nationalCode is empty");
            return 6;
        }
        if (str4 == null || str4.isEmpty()) {
            m1476b("GUID is empty");
            return 7;
        }
        if (str5 == null || str5.isEmpty()) {
            m1476b("callerName is empty");
            return 8;
        }
        if (str == null || str.isEmpty()) {
            m1476b("chatonID is empty");
            return 9;
        }
        if (str6 == null || str6.isEmpty()) {
            m1476b("IMEI is empty");
            return 11;
        }
        if (str7 == null || str7.isEmpty()) {
            m1476b("chatONUID is empty");
            return 10;
        }
        if (str8 == null || str8.isEmpty()) {
            m1476b("birthday is empty");
        }
        Cursor cursorQuery = context.getContentResolver().query(Uri.parse("content://com.coolots.chaton/create_account"), null, null, new String[]{String.valueOf(str2), String.valueOf(str3), String.valueOf(str5), String.valueOf(str4), String.valueOf(str), String.valueOf(str6), String.valueOf(str7), String.valueOf(str8)}, null);
        if (cursorQuery != null) {
            cursorQuery.close();
        }
        return 0;
    }

    /* renamed from: a */
    public int m1487a(Context context, boolean z, String str, String str2, String str3) {
        m1476b("outgoingCall() call start");
        if (!m1477b(context)) {
            m1479c("ChatON V is not installed");
            return 2;
        }
        int iM1473b = m1473b(context, "content://com.coolots.chaton/outgoingcall");
        if (iM1473b == 1) {
            m1479c("not allowed access");
            return 5;
        }
        if (iM1473b == 2) {
            m1479c("not supported function");
            return 13;
        }
        if (iM1473b == 3) {
            m1479c("no account");
            return 14;
        }
        if (str == null || str.isEmpty()) {
            m1476b("chatonID is empty");
            return 3;
        }
        String[] strArr = new String[4];
        strArr[0] = String.valueOf(z ? Spam.ACTIVITY_REPORT : Spam.ACTIVITY_CANCEL);
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
    public int m1488a(Context context, boolean z, String[] strArr, String str, String str2, String str3) {
        m1476b("outgoingConferenceCall() call start");
        if (!m1477b(context)) {
            m1479c("ChatON V is not installed");
            return 2;
        }
        int iM1473b = m1473b(context, "content://com.coolots.chaton/outgoingconferencecall");
        if (iM1473b == 1) {
            m1479c("not allowed access");
            return 5;
        }
        if (iM1473b == 2) {
            m1479c("not supported function");
            return 13;
        }
        if (iM1473b == 3) {
            m1479c("no account");
            return 14;
        }
        if (strArr == null || strArr.length == 0) {
            m1476b("samsungAccount is empty");
            return 3;
        }
        String[] strArr2 = new String[strArr.length + 5];
        strArr2[0] = String.valueOf(z ? Spam.ACTIVITY_REPORT : Spam.ACTIVITY_CANCEL);
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
    public void m1489a(Context context) {
        m1476b("dispose()");
        m1483o(context);
        m1484p(context);
        m1485q(context);
    }

    /* renamed from: a */
    public void m1490a(Context context, InterfaceC0417b interfaceC0417b) {
        C0420e c0420e = null;
        if (interfaceC0417b == null) {
            m1476b("setCallListener: clear " + this);
            m1484p(context);
            return;
        }
        m1484p(context);
        this.f1006e = interfaceC0417b;
        this.f1005d = new C0420e(this, c0420e);
        m1476b("setCallListener: set " + this);
        m1476b("setCallListener: mCallListener " + this.f1006e);
        m1476b("setCallListener: mCallReceiver " + this.f1005d);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.coolots.chaton.version.CONFERENCE_MEMBER_CHANGED");
        intentFilter.addAction("com.coolots.chaton.account.CALL_STATE_CHANGE_INFO");
        context.registerReceiver(this.f1005d, intentFilter, "com.coolots.permission.COOLOTS", null);
    }

    /* renamed from: a */
    public void m1491a(Context context, InterfaceC0418c interfaceC0418c) {
        C0421f c0421f = null;
        if (interfaceC0418c == null) {
            m1476b("setListener: clear " + this);
            m1483o(context);
            return;
        }
        m1483o(context);
        this.f1004c = interfaceC0418c;
        this.f1003b = new C0421f(this, c0421f);
        m1476b("setListener: set :" + this);
        m1476b("setListener: mListener :" + this.f1004c);
        m1476b("setListener: mReceiver :" + this.f1003b);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.coolots.chaton.account.ACCOUNT_RESULTINFO");
        intentFilter.addAction("com.coolots.chaton.account.REMOVE_ACCOUNT_RESULTINFO");
        context.registerReceiver(this.f1003b, intentFilter, "com.coolots.permission.COOLOTS", null);
    }

    /* renamed from: a */
    public void m1492a(Context context, InterfaceC0419d interfaceC0419d) {
        C0422g c0422g = null;
        if (interfaceC0419d == null) {
            m1476b("setUpdateListener: clear " + this);
            m1485q(context);
            return;
        }
        m1485q(context);
        this.f1008g = interfaceC0419d;
        this.f1007f = new C0422g(this, c0422g);
        m1476b("setUpdateListener: set " + this);
        m1476b("setUpdateListener: mUpdateListener " + this.f1008g);
        m1476b("setUpdateListener: mUpdateReceiver " + this.f1007f);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.coolots.chaton.version.UPGRADE_NEW_APK_INFO");
        context.registerReceiver(this.f1007f, intentFilter, "com.coolots.permission.COOLOTS", null);
    }

    /* renamed from: b */
    public int m1493b(Context context, boolean z) {
        int iUpdate = 0;
        m1476b("getMaxConferenceMemberCnt()");
        if (!m1477b(context)) {
            m1479c("ChatON V is not installed");
            return 0;
        }
        int iM1473b = m1473b(context, "content://com.coolots.chaton/maxconferencecallnum");
        if (iM1473b == 1) {
            m1479c("not allowed access");
            return 0;
        }
        if (iM1473b == 2) {
            m1479c("not supported function");
            return 0;
        }
        if (iM1473b == 3) {
            m1479c("no account");
            return 0;
        }
        try {
            iUpdate = context.getContentResolver().update(Uri.parse("content://com.coolots.chaton/maxconferencecallnum"), new ContentValues(), z ? Spam.ACTIVITY_REPORT : Spam.ACTIVITY_CANCEL, null);
            return iUpdate;
        } catch (IllegalArgumentException e) {
            StackTraceElement[] stackTrace = e.getStackTrace();
            int length = stackTrace.length;
            for (int i = iUpdate; i < length; i++) {
                m1476b(stackTrace[i].toString());
            }
            return iUpdate;
        }
    }

    /* renamed from: c */
    public int m1494c(Context context) {
        m1476b("removeAccountInDevice() call start");
        if (!m1477b(context)) {
            m1479c("ChatON V is not installed");
            return 2;
        }
        int iM1473b = m1473b(context, "content://com.coolots.chaton/remove_account");
        if (iM1473b == 1) {
            m1479c("not allowed access");
            return 5;
        }
        if (iM1473b == 2) {
            m1479c("not supported function");
            return 13;
        }
        Cursor cursorQuery = context.getContentResolver().query(Uri.parse("content://com.coolots.chaton/remove_account"), null, null, null, null);
        if (cursorQuery != null) {
            cursorQuery.close();
        }
        return 0;
    }

    /* renamed from: d */
    public boolean m1495d(Context context) {
        m1476b("isReadyToCall() call start");
        if (!m1477b(context)) {
            m1479c("ChatON V is not installed");
            return false;
        }
        int iM1473b = m1473b(context, "content://com.coolots.chaton/account");
        if (iM1473b == 1) {
            m1479c("not allowed access");
            return false;
        }
        if (iM1473b == 2) {
            m1479c("not supported function");
            return false;
        }
        if (iM1473b != 3) {
            return true;
        }
        m1479c("no account");
        return false;
    }

    /* renamed from: e */
    public Intent m1496e(Context context) {
        m1476b("getIntentSettingActivity()");
        if (!m1495d(context)) {
            m1476b("getIntentSettingActivity() return null");
            return null;
        }
        Intent intent = new Intent();
        intent.setAction("com.coolots.chaton.USER_SETTING_SUBPAGE_CALL_SETTINGS");
        return intent;
    }

    /* renamed from: f */
    public Intent m1497f(Context context) {
        m1476b("getIntentDataUsageActivity()");
        if (!m1495d(context)) {
            m1476b("getIntentDataUsageActivity() return null");
            return null;
        }
        Intent intent = new Intent();
        intent.setAction("com.coolots.chaton.USER_SETTING_SUBPAGE_DATA_USGAE");
        return intent;
    }

    /* renamed from: g */
    public boolean m1498g(Context context) {
        int iUpdate;
        m1476b("showCallActivity() call start");
        if (!m1477b(context)) {
            m1479c("ChatON V is not installed");
            return false;
        }
        int iM1473b = m1473b(context, "content://com.coolots.chaton/remotecallactivity");
        if (iM1473b == 1) {
            m1479c("not allowed access");
            return false;
        }
        if (iM1473b == 2) {
            m1479c("not supported function");
            return false;
        }
        if (iM1473b == 3) {
            m1479c("no account");
            return false;
        }
        try {
            iUpdate = context.getContentResolver().update(Uri.parse("content://com.coolots.chaton/remotecallactivity"), new ContentValues(), Spam.ACTIVITY_CANCEL, null);
        } catch (IllegalArgumentException e) {
            StackTraceElement[] stackTrace = e.getStackTrace();
            for (StackTraceElement stackTraceElement : stackTrace) {
                m1476b(stackTraceElement.toString());
            }
            iUpdate = 0;
        }
        return iUpdate == 1;
    }

    /* renamed from: h */
    public boolean m1499h(Context context) {
        int iUpdate;
        m1476b("endCallActivity() call start");
        if (!m1477b(context)) {
            m1479c("ChatON V is not installed");
            return false;
        }
        int iM1473b = m1473b(context, "content://com.coolots.chaton/remotecallactivity");
        if (iM1473b == 1) {
            m1479c("not allowed access");
            return false;
        }
        if (iM1473b == 2) {
            m1479c("not supported function");
            return false;
        }
        if (iM1473b == 3) {
            m1479c("no account");
            return false;
        }
        try {
            iUpdate = context.getContentResolver().update(Uri.parse("content://com.coolots.chaton/remotecallactivity"), new ContentValues(), Spam.ACTIVITY_REPORT, null);
        } catch (IllegalArgumentException e) {
            StackTraceElement[] stackTrace = e.getStackTrace();
            for (StackTraceElement stackTraceElement : stackTrace) {
                m1476b(stackTraceElement.toString());
            }
            iUpdate = 0;
        }
        return iUpdate == 1;
    }

    /* renamed from: i */
    public int m1500i(Context context) {
        m1476b("getCallDuration() call start");
        if (!m1477b(context)) {
            m1479c("ChatON V is not installed");
            return -1;
        }
        int iM1473b = m1473b(context, "content://com.coolots.chaton/callduration");
        if (iM1473b == 1) {
            m1479c("not allowed access");
            return -1;
        }
        if (iM1473b == 2) {
            m1479c("not supported function");
            return -1;
        }
        if (iM1473b == 3) {
            m1479c("no account");
            return -1;
        }
        String type = context.getContentResolver().getType(Uri.parse("content://com.coolots.chaton/callduration"));
        if (type != null) {
            return Integer.parseInt(type);
        }
        return -1;
    }

    /* renamed from: j */
    public boolean m1501j(Context context) {
        m1476b("isCalling() call start");
        if (!m1477b(context)) {
            m1479c("ChatON V is not installed");
            return false;
        }
        int iM1473b = m1473b(context, "content://com.coolots.chaton/iscalling");
        if (iM1473b == 1) {
            m1479c("not allowed access");
            return false;
        }
        if (iM1473b == 2) {
            m1479c("not supported function");
            return false;
        }
        if (iM1473b != 3) {
            return context.getContentResolver().getType(Uri.parse("content://com.coolots.chaton/iscalling")) != null;
        }
        m1479c("no account");
        return false;
    }

    /* renamed from: k */
    public int m1502k(Context context) {
        m1476b("getCallStateDuringCall() call start");
        if (!m1477b(context)) {
            m1479c("ChatON V is not installed");
            return 0;
        }
        int iM1473b = m1473b(context, "content://com.coolots.chaton/callstate");
        if (iM1473b == 1) {
            m1479c("not allowed access");
            return 0;
        }
        if (iM1473b == 2) {
            m1479c("not supported function");
            return 0;
        }
        if (iM1473b == 3) {
            m1479c("no account");
            return 0;
        }
        String type = context.getContentResolver().getType(Uri.parse("content://com.coolots.chaton/callstate"));
        if (type == null) {
            return 3;
        }
        return Integer.parseInt(type);
    }

    /* renamed from: l */
    public int m1503l(Context context) {
        m1476b("getCallType() call start");
        if (!m1477b(context)) {
            m1479c("ChatON V is not installed");
            return 0;
        }
        int iM1473b = m1473b(context, "content://com.coolots.chaton/get_call_type");
        if (iM1473b == 1) {
            m1479c("not allowed access");
            return 0;
        }
        if (iM1473b == 2) {
            m1479c("not supported function");
            return 0;
        }
        if (iM1473b == 3) {
            m1479c("no account");
            return 0;
        }
        try {
            return context.getContentResolver().update(Uri.parse("content://com.coolots.chaton/get_call_type"), new ContentValues(), null, null);
        } catch (IllegalArgumentException e) {
            StackTraceElement[] stackTrace = e.getStackTrace();
            for (StackTraceElement stackTraceElement : stackTrace) {
                m1476b(stackTraceElement.toString());
            }
            return 0;
        }
    }

    /* renamed from: m */
    public ArrayList m1504m(Context context) {
        m1476b("getCallMember() call start");
        if (!m1477b(context)) {
            m1479c("ChatON V is not installed");
            return null;
        }
        int iM1473b = m1473b(context, "content://com.coolots.chaton/get_call_member");
        if (iM1473b == 1) {
            m1479c("not allowed access");
            return null;
        }
        if (iM1473b == 2) {
            m1479c("not supported function");
            return null;
        }
        if (iM1473b == 3) {
            m1479c("no account");
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
        m1476b("call member: " + arrayList);
        if (arrayList.size() == 0) {
            return null;
        }
        return arrayList;
    }

    /* renamed from: n */
    public int m1505n(Context context) {
        m1476b("getLatestApkVersion() call start");
        if (!m1477b(context)) {
            m1479c("ChatON V is not installed");
            return 2;
        }
        int iM1473b = m1473b(context, "content://com.coolots.chaton/get_latest_version");
        if (iM1473b == 1) {
            m1479c("not allowed access");
            return 5;
        }
        if (iM1473b == 2) {
            m1479c("not supported function");
            return 13;
        }
        if (iM1473b == 3) {
            m1479c("no account");
            return 14;
        }
        context.getContentResolver().getType(Uri.parse("content://com.coolots.chaton/get_latest_version"));
        return 0;
    }
}
