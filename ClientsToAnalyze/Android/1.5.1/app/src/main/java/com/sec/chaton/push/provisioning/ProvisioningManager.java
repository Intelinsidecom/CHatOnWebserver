package com.sec.chaton.push.provisioning;

import android.content.Context;
import android.content.SharedPreferences;
import android.telephony.TelephonyManager;
import com.sec.chaton.push.util.PushLog;
import java.util.UUID;

/* loaded from: classes.dex */
public class ProvisioningManager {

    /* renamed from: a */
    private static final String f2784a = ProvisioningManager.class.getSimpleName();

    /* renamed from: a */
    public static synchronized void m2998a(Context context, String str, String str2, int i, String str3, int i2, int i3) {
        SharedPreferences.Editor editorEdit = context.getSharedPreferences("com.sec.chaton.push.config", 0).edit();
        editorEdit.putString("deviceToken", str);
        editorEdit.putString("primaryIp", str2);
        editorEdit.putInt("primaryPort", i);
        editorEdit.putString("secondaryIp", str3);
        editorEdit.putInt("secondaryPort", i2);
        editorEdit.putInt("pingInterval", i3);
        editorEdit.commit();
    }

    /* renamed from: a */
    public static boolean m2999a(Context context) {
        return (m3002d(context) == null || m3003e(context) == null || m3004f(context) == 0) ? false : true;
    }

    /* renamed from: b */
    public static synchronized void m3000b(Context context) {
        SharedPreferences.Editor editorEdit = context.getSharedPreferences("com.sec.chaton.push.config", 0).edit();
        editorEdit.remove("deviceToken");
        editorEdit.remove("primaryIp");
        editorEdit.remove("primaryPort");
        editorEdit.remove("secondaryIp");
        editorEdit.remove("secondaryPort");
        editorEdit.remove("pingInterval");
        editorEdit.commit();
    }

    /* renamed from: c */
    public static synchronized String m3001c(Context context) {
        String strM3009k;
        strM3009k = m3009k(context);
        if (strM3009k != null) {
            PushLog.m3025a(f2784a, "Using generated random device id: " + strM3009k);
        } else {
            strM3009k = ((TelephonyManager) context.getSystemService("phone")).getDeviceId();
        }
        return strM3009k;
    }

    /* renamed from: d */
    public static String m3002d(Context context) {
        return context.getSharedPreferences("com.sec.chaton.push.config", 0).getString("deviceToken", null);
    }

    /* renamed from: e */
    public static String m3003e(Context context) {
        return context.getSharedPreferences("com.sec.chaton.push.config", 0).getString("primaryIp", null);
    }

    /* renamed from: f */
    public static int m3004f(Context context) {
        return context.getSharedPreferences("com.sec.chaton.push.config", 0).getInt("primaryPort", 0);
    }

    /* renamed from: g */
    public static String m3005g(Context context) {
        String string = context.getSharedPreferences("com.sec.chaton.push.config", 0).getString("secondaryIp", null);
        return (string == null || string.equals("")) ? m3003e(context) : string;
    }

    /* renamed from: h */
    public static int m3006h(Context context) {
        int i = context.getSharedPreferences("com.sec.chaton.push.config", 0).getInt("secondaryPort", 0);
        return i == 0 ? m3004f(context) : i;
    }

    /* renamed from: i */
    public static int m3007i(Context context) {
        return context.getSharedPreferences("com.sec.chaton.push.config", 0).getInt("pingInterval", 8);
    }

    /* renamed from: j */
    public static void m3008j(Context context) {
        String strM3009k = m3009k(context);
        if (strM3009k != null) {
            PushLog.m3025a(f2784a, "Already generate random device does exist, use it: " + strM3009k);
            return;
        }
        String string = UUID.randomUUID().toString();
        SharedPreferences.Editor editorEdit = context.getSharedPreferences("com.sec.chaton.push.config", 0).edit();
        editorEdit.putString("deviceId", string);
        editorEdit.commit();
        PushLog.m3025a(f2784a, "Generate random device id: " + string);
    }

    /* renamed from: k */
    public static String m3009k(Context context) {
        String string = context.getSharedPreferences("com.sec.chaton.push.config", 0).getString("deviceId", null);
        if (string != null) {
            return string;
        }
        PushLog.m3025a(f2784a, "Generated radom device doesn't exist.");
        return null;
    }
}
