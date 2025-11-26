package com.sec.chaton.util;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.util.Log;
import com.sec.chaton.push.util.C1139g;
import com.sec.common.p056b.C1816b;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.jboss.netty.handler.codec.rtsp.RtspHeaders;

/* compiled from: ChatONLogWriter.java */
/* renamed from: com.sec.chaton.util.r */
/* loaded from: classes.dex */
public class C1786r {

    /* renamed from: a */
    public static boolean f6451a = false;

    /* renamed from: b */
    public static boolean f6452b = false;

    /* renamed from: c */
    public static boolean f6453c = false;

    /* renamed from: d */
    public static boolean f6454d = false;

    /* renamed from: e */
    public static boolean f6455e = false;

    /* renamed from: f */
    public static String f6456f = "pref_log_on_off";

    /* renamed from: a */
    public static boolean m6058a(String str) throws NoSuchAlgorithmException {
        String string = null;
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(str.getBytes());
            string = new BigInteger(1, messageDigest.digest()).toString(16);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return "48889278013a56902cd33955d709136f".equals(string);
    }

    /* renamed from: a */
    public static void m6050a() {
        m6051a(-1);
    }

    /* renamed from: a */
    public static void m6051a(int i) {
        if (i == -1) {
            C1789u.m6075a().getInt(f6456f, 0);
        } else {
            C1789u.m6077a(f6456f, Integer.valueOf(i));
        }
        String string = C1789u.m6075a().getString("primary_contact_addrss", "");
        if (C1789u.m6075a().getInt(f6456f, 0) > 0) {
            m6057a(true, true, true, true, true);
            C1139g.m4310a(true, true, true, true);
        } else if (C1816b.m6163f()) {
            m6057a(false, false, false, false, true);
            C1139g.m4310a(false, false, false, true);
        } else if ("stg.contact.samsungchaton.com".equalsIgnoreCase(string)) {
            m6057a(true, true, true, true, true);
            C1139g.m4310a(true, true, true, true);
        } else {
            m6057a(false, false, false, false, true);
            C1139g.m4310a(false, false, false, true);
        }
    }

    /* renamed from: a */
    private static void m6057a(boolean z, boolean z2, boolean z3, boolean z4, boolean z5) {
        f6451a = z;
        f6452b = z2;
        f6453c = z3;
        f6454d = z4;
        f6455e = z5;
    }

    /* renamed from: b */
    private static String m6059b(Throwable th) throws IOException {
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        th.printStackTrace(printWriter);
        printWriter.close();
        try {
            stringWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stringWriter.toString();
    }

    /* renamed from: a */
    public static void m6056a(Throwable th, String str) {
        if (f6455e) {
            m6052a(6, "ChatON", m6059b(th), str);
        }
    }

    /* renamed from: a */
    public static void m6054a(String str, String str2) {
        if (f6455e) {
            m6052a(6, "ChatON", str, str2);
        }
    }

    /* renamed from: b */
    public static void m6061b(String str, String str2) {
        if (f6452b) {
            m6052a(3, "ChatON", str, str2);
        }
    }

    /* renamed from: c */
    public static void m6063c(String str, String str2) {
        if (f6453c) {
            m6052a(4, "ChatON", str, str2);
        }
    }

    /* renamed from: d */
    public static void m6065d(String str, String str2) {
        if (f6454d) {
            m6052a(5, "ChatON", str, str2);
        }
    }

    /* renamed from: e */
    public static void m6066e(String str, String str2) {
        if (f6451a) {
            m6052a(2, "ChatON", str, str2);
        }
    }

    /* renamed from: a */
    public static String m6049a(List list) {
        String str = "";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            sb.append(str).append("" + list.get(i));
            str = ",";
        }
        return sb.toString();
    }

    /* renamed from: a */
    private static synchronized void m6052a(int i, String str, String str2, String str3) {
        StringBuilder sb = new StringBuilder();
        sb.append("[" + Thread.currentThread().getId() + "]");
        if (!"NoClassName!@#".equals(str3)) {
            sb.append("[" + str3 + "] ");
        }
        sb.append(str2);
        switch (i) {
            case 2:
                Log.v(str, sb.toString());
                break;
            case 3:
                Log.d(str, sb.toString());
                break;
            case 4:
                Log.i(str, sb.toString());
                break;
            case 5:
                Log.w(str, sb.toString());
                break;
            case 6:
                Log.e(str, sb.toString());
                break;
        }
    }

    /* renamed from: a */
    public static final String m6047a(Context context) {
        return m6048a(context, (String) null);
    }

    /* renamed from: a */
    public static final String m6048a(Context context, String str) throws IOException {
        int i;
        String[] strArr;
        String str2 = Build.BRAND;
        String str3 = Build.MANUFACTURER;
        String str4 = Build.MODEL;
        String str5 = Build.VERSION.SDK;
        String str6 = "";
        PackageManager packageManager = context.getPackageManager();
        try {
            str6 = packageManager.getPackageInfo(context.getPackageName(), 64).versionName;
            i = packageManager.getPackageInfo(context.getPackageName(), 64).versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            str6 = str6;
            i = 0;
        }
        String str7 = "Brand: " + str2 + "\nManufacturer: " + str3 + "\nModel: " + str4 + "\nAPI Version: " + str5 + "\nApplication Version Name: " + str6 + "\nApplication Version Code: " + i + "\n";
        if (str == null) {
            strArr = new String[]{"logcat", "-d", "-v", RtspHeaders.Values.TIME};
        } else {
            strArr = new String[]{"logcat", "-d", "-v", RtspHeaders.Values.TIME, str + ":V", "*:S"};
        }
        try {
            Process processExec = Runtime.getRuntime().exec(strArr);
            String property = System.getProperty("line.separator");
            StringBuilder sb = new StringBuilder();
            try {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(processExec.getInputStream()));
                sb.append("---------------------------------------------------------------\n");
                sb.append(str7);
                sb.append("---------------------------------------------------------------\n");
                while (true) {
                    String line = bufferedReader.readLine();
                    if (line == null) {
                        break;
                    }
                    sb.append(line);
                    sb.append(property);
                }
                bufferedReader.close();
            } catch (IOException e2) {
                e2.printStackTrace();
            }
            return sb.toString();
        } catch (IOException e3) {
            e3.printStackTrace();
            return "";
        }
    }

    /* renamed from: f */
    public static void m6067f(String str, String str2) {
        if (f6452b) {
            m6052a(3, str2, str, str2);
        }
    }

    @Deprecated
    /* renamed from: b */
    public static void m6060b(String str) {
        if (f6452b) {
            Log.d("ChatON", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()) + "\t[" + Thread.currentThread().getId() + "] " + str);
        }
    }

    @Deprecated
    /* renamed from: g */
    public static void m6068g(String str, String str2) {
        if (f6452b) {
            Log.d("ChatON-" + str, new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()) + "\t[" + Thread.currentThread().getId() + "][" + str + "] " + str2);
        }
    }

    @Deprecated
    /* renamed from: a */
    public static void m6055a(Throwable th) {
        m6062c(m6059b(th));
    }

    @Deprecated
    /* renamed from: c */
    public static void m6062c(String str) {
        if (f6455e) {
            Log.e("ChatON", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()) + "\t[" + Thread.currentThread().getId() + "] " + str);
        }
    }

    /* renamed from: d */
    public static void m6064d(String str) {
        m6061b(str, "System_out");
    }

    /* renamed from: a */
    public static void m6053a(Object obj) {
        m6061b(obj != null ? obj.toString() : "null", "System_out");
    }
}
