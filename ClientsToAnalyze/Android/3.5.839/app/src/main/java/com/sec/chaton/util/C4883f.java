package com.sec.chaton.util;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.sec.chaton.privateplugin.data.Spam;

/* compiled from: BuddyCheckUtil.java */
/* renamed from: com.sec.chaton.util.f */
/* loaded from: classes.dex */
public class C4883f {
    /* renamed from: a */
    public static boolean m18539a(String str) {
        if (str.length() >= 19 && str.startsWith("10")) {
            C4904y.m18639b("chaton id : " + str, "BuddyCheckUtil");
            return false;
        }
        if (str.startsWith(Spam.ACTIVITY_CANCEL)) {
            C4904y.m18639b("pin number : " + str, "BuddyCheckUtil");
            return false;
        }
        C4904y.m18639b("phone number: " + str, "BuddyCheckUtil");
        return true;
    }

    /* renamed from: a */
    public static boolean m18537a(Context context) {
        boolean zM18538a;
        if (((TelephonyManager) context.getSystemService("phone")).getPhoneType() == 0) {
            zM18538a = false;
        } else {
            zM18538a = m18538a(context, new Intent("android.intent.action.CALL", Uri.parse("tel:+000")));
        }
        C4904y.m18639b("is3GCallAvailable : " + zM18538a, "BuddyCheckUtil");
        return zM18538a;
    }

    /* renamed from: a */
    public static boolean m18538a(Context context, Intent intent) {
        return context.getPackageManager().queryIntentActivities(intent, 65536).size() > 0;
    }

    /* renamed from: a */
    public static boolean m18540a(String str, String str2) {
        if (((str.length() >= 19 && str.startsWith("10")) || str.startsWith(Spam.ACTIVITY_CANCEL)) && !TextUtils.isEmpty(str2)) {
            return true;
        }
        return false;
    }
}
