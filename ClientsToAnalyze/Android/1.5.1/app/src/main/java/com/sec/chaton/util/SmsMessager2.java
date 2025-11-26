package com.sec.chaton.util;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.os.CountDownTimer;
import java.util.StringTokenizer;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: classes.dex */
public class SmsMessager2 {

    /* renamed from: a */
    static Context f3741a;

    /* renamed from: b */
    static String f3742b;

    /* renamed from: e */
    private static Cipher f3745e;

    /* renamed from: f */
    private static SecretKeySpec f3746f;

    /* renamed from: g */
    private static String f3747g;

    /* renamed from: h */
    private static byte[] f3748h;

    /* renamed from: i */
    private static StringTokenizer f3749i;

    /* renamed from: k */
    private static CountDownTimer f3751k;

    /* renamed from: l */
    private static Activity f3752l;

    /* renamed from: m */
    private static AlertDialog f3753m;

    /* renamed from: d */
    private static String f3744d = "";

    /* renamed from: j */
    private static boolean f3750j = false;

    /* renamed from: c */
    public static BroadcastReceiver f3743c = new C0606d();

    /* renamed from: n */
    private static BroadcastReceiver f3754n = new C0607e();

    /* renamed from: a */
    public static void m3664a(Context context) {
        if (f3754n != null) {
            context.unregisterReceiver(f3754n);
            f3754n = null;
        }
        if (f3743c != null) {
            context.unregisterReceiver(f3743c);
            f3743c = null;
        }
    }

    /* renamed from: a */
    public static byte[] m3666a(String str) {
        if (str == null || str.length() == 0) {
            return null;
        }
        byte[] bArr = new byte[str.length() / 2];
        for (int i = 0; i < bArr.length; i++) {
            bArr[i] = (byte) Integer.parseInt(str.substring(i * 2, (i * 2) + 2), 16);
        }
        return bArr;
    }

    /* renamed from: b */
    public static void m3670b(Context context) {
        if (f3751k != null) {
            ChatONLogWriter.m3506b("Self SMS Timer canceled", null);
            f3751k.cancel();
            f3751k = null;
        }
    }
}
