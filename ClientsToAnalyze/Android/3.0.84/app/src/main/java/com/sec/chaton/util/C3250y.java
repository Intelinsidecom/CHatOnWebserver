package com.sec.chaton.util;

import android.app.Application;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.util.Log;
import com.coolots.sso.p006a.C0045a;
import com.sec.chaton.R;
import com.sec.chaton.global.C1493a;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.plugin.C1954g;
import com.sec.chaton.plugin.EnumC1955h;
import com.sec.chaton.push.util.C2115g;
import com.sec.common.C3330f;
import com.sec.common.CommonApplication;
import com.sec.common.util.C3347i;
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
/* renamed from: com.sec.chaton.util.y */
/* loaded from: classes.dex */
public class C3250y {

    /* renamed from: a */
    public static boolean f11733a = false;

    /* renamed from: b */
    public static boolean f11734b = false;

    /* renamed from: c */
    public static boolean f11735c = false;

    /* renamed from: d */
    public static boolean f11736d = false;

    /* renamed from: e */
    public static boolean f11737e = false;

    /* renamed from: f */
    public static boolean f11738f = true;

    /* renamed from: g */
    public static String f11739g = "pref_log_on_off";

    /* renamed from: a */
    public static boolean m11446a(String str) throws NoSuchAlgorithmException {
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
    public static void m11438a() {
        m11439a(-1);
    }

    /* renamed from: b */
    public static int m11447b() {
        return C3159aa.m10962a().m10978a(f11739g, (Integer) 0).intValue();
    }

    /* renamed from: a */
    public static void m11439a(int i) {
        if (i == -1) {
            C3159aa.m10962a().m10978a(f11739g, (Integer) 0).intValue();
        } else {
            C3159aa.m10964a(f11739g, Integer.valueOf(i));
        }
        String strM10979a = C3159aa.m10962a().m10979a("primary_contact_addrss", "");
        if (C3159aa.m10962a().m10978a(f11739g, (Integer) 0).intValue() > 0) {
            m11445a(true, true, true, true, true);
            C2115g.m8361a(true, true, true, true);
            C3330f.f12033a.m11653a(true, true, true, true);
            m11444a(true);
            return;
        }
        if (C1493a.m6463a("log_by_shipbuild")) {
            try {
                if (C3347i.m11784g()) {
                    m11444a(false);
                    m11445a(false, false, false, false, true);
                    C2115g.m8361a(false, false, false, true);
                    C3330f.f12033a.m11653a(false, false, false, true);
                } else {
                    m11445a(true, true, true, true, true);
                    C2115g.m8361a(true, true, true, true);
                    C3330f.f12033a.m11653a(true, true, true, true);
                    m11444a(true);
                }
                return;
            } catch (Throwable th) {
                m11444a(false);
                m11445a(false, false, false, false, true);
                C2115g.m8361a(false, false, false, true);
                C3330f.f12033a.m11653a(false, false, false, true);
                return;
            }
        }
        if ("stg.contact.samsungchaton.com".equalsIgnoreCase(strM10979a)) {
            m11445a(true, true, true, true, true);
            C2115g.m8361a(true, true, true, true);
            C3330f.f12033a.m11653a(true, true, true, true);
            m11444a(true);
            return;
        }
        if ("dev.contact.samsungchaton.com".equalsIgnoreCase(strM10979a)) {
            m11445a(true, true, true, true, true);
            C2115g.m8361a(true, true, true, true);
            C3330f.f12033a.m11653a(true, true, true, true);
            m11444a(true);
            return;
        }
        if (((Application) CommonApplication.m11493l().getApplicationContext()).getApplicationInfo().icon == R.drawable.icon_black) {
            m11445a(true, true, true, true, true);
            C2115g.m8361a(true, true, true, true);
            C3330f.f12033a.m11653a(true, true, true, true);
            m11444a(true);
            return;
        }
        m11444a(false);
        m11445a(false, false, false, false, true);
        C2115g.m8361a(false, false, false, true);
        C3330f.f12033a.m11653a(false, false, false, true);
    }

    /* renamed from: a */
    private static void m11445a(boolean z, boolean z2, boolean z3, boolean z4, boolean z5) {
        f11733a = z;
        f11734b = z2;
        f11735c = z3;
        f11736d = z4;
        f11737e = z5;
    }

    /* renamed from: a */
    public static String m11436a(Throwable th) throws IOException {
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
    public static void m11443a(Throwable th, String str) {
        if (f11737e) {
            m11440a(6, "ChatON", m11436a(th), str);
        }
    }

    /* renamed from: a */
    public static void m11442a(String str, String str2) {
        if (f11737e) {
            m11440a(6, "ChatON", str, str2);
        }
    }

    /* renamed from: b */
    public static void m11450b(String str, String str2) {
        if (f11734b) {
            m11440a(3, "ChatON", str, str2);
        }
    }

    /* renamed from: c */
    public static void m11453c(String str, String str2) {
        if (f11735c) {
            m11440a(4, "ChatON", str, str2);
        }
    }

    /* renamed from: d */
    public static void m11455d(String str, String str2) {
        if (f11736d) {
            m11440a(5, "ChatON", str, str2);
        }
    }

    /* renamed from: e */
    public static void m11456e(String str, String str2) {
        if (f11733a) {
            m11440a(2, "ChatON", str, str2);
        }
    }

    /* renamed from: f */
    public static void m11457f(String str, String str2) {
        if (f11738f) {
            m11440a(3, "ChatON", str, str2 + "_MESSAGE_FLOW");
        }
    }

    /* renamed from: a */
    public static String m11437a(List<? extends Object> list) {
        String str = "";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            sb.append(str).append("" + list.get(i));
            str = ",";
        }
        return sb.toString();
    }

    /* renamed from: a */
    private static synchronized void m11440a(int i, String str, String str2, String str3) {
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
                if (sb.toString().contains("imei=")) {
                    Log.w(str, sb.toString());
                    break;
                } else {
                    Log.e(str, sb.toString());
                    break;
                }
        }
    }

    /* renamed from: a */
    public static final String m11434a(Context context) {
        return m11435a(context, (String) null);
    }

    /* renamed from: a */
    public static final String m11435a(Context context, String str) throws IOException {
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

    /* renamed from: g */
    public static void m11458g(String str, String str2) {
        if (f11734b) {
            m11440a(3, "ChatON", str, str2);
        }
    }

    private C3250y() {
    }

    @Deprecated
    /* renamed from: b */
    public static void m11449b(String str) {
        if (f11735c) {
            Log.i("ChatON", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()) + "\t[" + Thread.currentThread().getId() + "] " + str);
        }
    }

    @Deprecated
    /* renamed from: h */
    public static void m11459h(String str, String str2) {
        if (f11734b) {
            Log.d("ChatON-" + str, new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()) + "\t[" + Thread.currentThread().getId() + "][" + str + "] " + str2);
        }
    }

    @Deprecated
    /* renamed from: b */
    public static void m11451b(Throwable th) {
        m11452c(m11436a(th));
    }

    @Deprecated
    /* renamed from: c */
    public static void m11452c(String str) {
        if (f11737e) {
            Log.e("ChatON", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()) + "\t[" + Thread.currentThread().getId() + "] " + str);
        }
    }

    /* renamed from: d */
    public static void m11454d(String str) {
        m11450b(str, "System_out");
    }

    /* renamed from: a */
    public static void m11441a(Object obj) {
        m11450b(obj != null ? obj.toString() : "null", "System_out");
    }

    /* renamed from: b */
    public static void m11448b(int i) {
        if (i == 1) {
            C3159aa.m10962a().m10984b(f11739g, (Integer) 1);
            m11445a(true, true, true, true, true);
            C2115g.m8361a(true, true, true, true);
            C3330f.f12033a.m11653a(true, true, true, true);
            m11444a(true);
            return;
        }
        C3159aa.m10962a().m10984b(f11739g, (Integer) 0);
        m11444a(false);
        m11445a(false, false, false, false, false);
        C2115g.m8361a(false, false, false, false);
        C3330f.f12033a.m11653a(false, false, false, false);
    }

    /* renamed from: a */
    private static void m11444a(boolean z) {
        if (C1493a.m6463a("chatonv_feature") && C1954g.m7916a().m7918a(GlobalApplication.m11493l(), EnumC1955h.ChatONV)) {
            if (z) {
                C0045a.m29a(GlobalApplication.m11493l(), true);
                if (f11734b) {
                    m11450b("enableChatONVLog : success to ON", C3250y.class.getSimpleName());
                    return;
                }
                return;
            }
            C0045a.m29a(GlobalApplication.m11493l(), false);
            if (f11734b) {
                m11450b("enableChatONVLog : success to OFF", C3250y.class.getSimpleName());
                return;
            }
            return;
        }
        if (f11734b) {
            m11450b("enableChatONVLog : fail", C3250y.class.getSimpleName());
        }
    }
}
