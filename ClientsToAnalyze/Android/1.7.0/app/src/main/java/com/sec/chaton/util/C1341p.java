package com.sec.chaton.util;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.util.Log;
import com.sec.chaton.p029f.C0684a;
import com.sec.chaton.push.util.C0921g;
import com.sec.p007b.p008a.C0108a;
import com.sec.p007b.p008a.C0111b;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import org.jboss.netty.handler.codec.rtsp.RtspHeaders;

/* compiled from: ChatONLogWriter.java */
/* renamed from: com.sec.chaton.util.p */
/* loaded from: classes.dex */
public class C1341p {

    /* renamed from: a */
    public static boolean f4577a = false;

    /* renamed from: b */
    public static boolean f4578b = false;

    /* renamed from: c */
    public static boolean f4579c = false;

    /* renamed from: d */
    public static boolean f4580d = false;

    /* renamed from: e */
    public static boolean f4581e = false;

    /* renamed from: f */
    public static String f4582f = "pref_log_on_off";

    /* renamed from: a */
    public static boolean m4655a(String str) throws NoSuchAlgorithmException {
        String string = null;
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(str.getBytes());
            string = new BigInteger(1, messageDigest.digest()).toString(16);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return "f0e86378bd078e9e0357a6e13f914c83".equals(string);
    }

    /* renamed from: a */
    public static void m4647a() {
        m4648a(-1);
    }

    /* renamed from: a */
    public static void m4648a(int i) {
        if (i == -1) {
            C1323bs.m4575a().getInt(f4582f, 0);
        } else {
            C1323bs.m4577a(f4582f, Integer.valueOf(i));
        }
        String string = C1323bs.m4575a().getString("primary_contact_addrss", "");
        if (C1323bs.m4575a().getInt(f4582f, 0) > 0) {
            m4654a(true, true, true, true, true);
            C0921g.m3639a(true, true, true, true);
            C0111b.f208a.m584a(true, true, true, true);
            return;
        }
        if (C0108a.m578a()) {
            m4654a(false, false, false, false, true);
            C0921g.m3639a(false, false, false, true);
            C0111b.f208a.m584a(false, false, false, true);
        } else if ("stg.contact.samsungchaton.com".equalsIgnoreCase(string)) {
            m4654a(true, true, true, true, true);
            C0921g.m3639a(true, true, true, true);
            C0111b.f208a.m584a(true, true, true, true);
        } else if (Calendar.getInstance().compareTo(C0684a.m3052d()) < 0) {
            m4654a(true, true, true, true, true);
            C0921g.m3639a(true, true, true, true);
            C0111b.f208a.m584a(true, true, true, true);
        } else {
            m4654a(false, false, false, false, true);
            C0921g.m3639a(false, false, false, true);
            C0111b.f208a.m584a(false, false, false, true);
        }
    }

    /* renamed from: a */
    private static void m4654a(boolean z, boolean z2, boolean z3, boolean z4, boolean z5) {
        f4577a = z;
        f4578b = z2;
        f4579c = z3;
        f4580d = z4;
        f4581e = z5;
    }

    /* renamed from: b */
    private static String m4656b(Throwable th) throws IOException {
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
    public static void m4653a(Throwable th, String str) {
        if (f4581e) {
            m4649a(6, "ChatON", m4656b(th), str);
        }
    }

    /* renamed from: a */
    public static void m4651a(String str, String str2) {
        if (f4581e) {
            m4649a(6, "ChatON", str, str2);
        }
    }

    /* renamed from: b */
    public static void m4658b(String str, String str2) {
        if (f4578b) {
            m4649a(3, "ChatON", str, str2);
        }
    }

    /* renamed from: c */
    public static void m4660c(String str, String str2) {
        if (f4579c) {
            m4649a(4, "ChatON", str, str2);
        }
    }

    /* renamed from: d */
    public static void m4661d(String str, String str2) {
        if (f4580d) {
            m4649a(5, "ChatON", str, str2);
        }
    }

    /* renamed from: e */
    public static void m4662e(String str, String str2) {
        if (f4577a) {
            m4649a(2, "ChatON", str, str2);
        }
    }

    /* renamed from: a */
    public static String m4646a(List list) {
        String str = "";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            sb.append(str).append("" + list.get(i));
            str = ",";
        }
        return sb.toString();
    }

    /* renamed from: a */
    private static synchronized void m4649a(int i, String str, String str2, String str3) {
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
    public static final String m4644a(Context context) {
        return m4645a(context, (String) null);
    }

    /* renamed from: a */
    public static final String m4645a(Context context, String str) throws IOException {
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
    public static void m4663f(String str, String str2) {
        if (f4578b) {
            m4649a(3, "ChatON", str, str2);
        }
    }

    private C1341p() {
    }

    @Deprecated
    /* renamed from: g */
    public static void m4664g(String str, String str2) {
        if (f4578b) {
            Log.d("ChatON-" + str, new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()) + "\t[" + Thread.currentThread().getId() + "][" + str + "] " + str2);
        }
    }

    @Deprecated
    /* renamed from: a */
    public static void m4652a(Throwable th) {
        m4657b(m4656b(th));
    }

    @Deprecated
    /* renamed from: b */
    public static void m4657b(String str) {
        if (f4581e) {
            Log.e("ChatON", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()) + "\t[" + Thread.currentThread().getId() + "] " + str);
        }
    }

    /* renamed from: c */
    public static void m4659c(String str) {
        m4658b(str, "System_out");
    }

    /* renamed from: a */
    public static void m4650a(Object obj) {
        m4658b(obj != null ? obj.toString() : "null", "System_out");
    }
}
