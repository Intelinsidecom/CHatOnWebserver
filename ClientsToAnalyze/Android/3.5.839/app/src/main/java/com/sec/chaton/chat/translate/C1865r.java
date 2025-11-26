package com.sec.chaton.chat.translate;

import android.content.pm.PackageManager;
import android.os.Build;
import android.text.TextUtils;
import com.sec.chaton.global.C2349a;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.util.C4808a;
import com.sec.chaton.util.C4904y;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;

/* compiled from: TranslationUtil.java */
/* renamed from: com.sec.chaton.chat.translate.r */
/* loaded from: classes.dex */
public class C1865r {

    /* renamed from: a */
    private static final String f7083a = C1865r.class.getSimpleName();

    /* renamed from: a */
    public static boolean m9069a(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            C4904y.m18641c("Source Language error!! - " + str, f7083a);
            return false;
        }
        if (TextUtils.isEmpty(str2)) {
            C4904y.m18641c("Target Language error!! - " + str2, f7083a);
            return false;
        }
        return true;
    }

    /* renamed from: b */
    public static byte[] m9071b(String str, String str2) throws Exception {
        try {
            if (!TextUtils.isEmpty(str)) {
                return new C4808a(C4808a.m18100b(str), C4808a.m18101c(str)).m18102b(str2.getBytes());
            }
            C4904y.m18634a("Fail in getting a key", f7083a);
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception(e.getMessage());
        }
    }

    /* renamed from: a */
    public static InputStream m9067a(String str, InputStream inputStream) throws Exception {
        try {
            if (!TextUtils.isEmpty(str)) {
                C4808a c4808a = new C4808a(C4808a.m18100b(str), C4808a.m18101c(str));
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                byte[] bArr = new byte[4096];
                while (true) {
                    int i = inputStream.read(bArr, 0, bArr.length);
                    if (i == -1) {
                        break;
                    }
                    byteArrayOutputStream.write(bArr, 0, i);
                }
                byteArrayOutputStream.flush();
                byte[] bArrM18103c = c4808a.m18103c(byteArrayOutputStream.toByteArray());
                if (bArrM18103c == null) {
                    return null;
                }
                return new ByteArrayInputStream(bArrM18103c);
            }
            C4904y.m18634a("Fail in getting a key", f7083a);
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception(e.getMessage());
        }
    }

    /* renamed from: a */
    public static String m9068a() {
        String str = "";
        try {
            str = GlobalApplication.m18732r().getPackageManager().getPackageInfo(GlobalApplication.m18732r().getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        StringBuilder sb = new StringBuilder();
        sb.append(Build.MODEL).append("; ");
        sb.append(Build.DISPLAY).append("; ");
        if (C2349a.m10301a("tablet_enable_feature")) {
            sb.append("ChatON android tablet=").append(str);
        } else {
            sb.append("ChatON android phone=").append(str);
        }
        return sb.toString();
    }

    /* renamed from: b */
    public static boolean m9070b() {
        return Build.VERSION.SDK_INT >= 14;
    }

    /* renamed from: c */
    public static boolean m9072c() {
        boolean zM10301a = C2349a.m10301a("translate_language_arabic");
        if (C4904y.f17872b) {
            C4904y.m18639b("supportArabic : " + zM10301a, f7083a);
        }
        return zM10301a;
    }

    /* renamed from: d */
    public static boolean m9073d() {
        boolean zM10301a = C2349a.m10301a("translate_language_hindi");
        if (C4904y.f17872b) {
            C4904y.m18639b("supportHindi : " + zM10301a, f7083a);
        }
        return zM10301a;
    }

    /* renamed from: e */
    public static boolean m9074e() {
        boolean zM10301a = C2349a.m10301a("translate_language_turkish");
        if (C4904y.f17872b) {
            C4904y.m18639b("supportTurkish : " + zM10301a, f7083a);
        }
        return zM10301a;
    }

    /* renamed from: f */
    public static boolean m9075f() {
        boolean zM10301a = C2349a.m10301a("translate_language_farsi");
        if (C4904y.f17872b) {
            C4904y.m18639b("supportFarsi : " + zM10301a, f7083a);
        }
        return zM10301a;
    }
}
