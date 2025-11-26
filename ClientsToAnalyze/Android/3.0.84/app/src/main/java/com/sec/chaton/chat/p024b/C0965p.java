package com.sec.chaton.chat.p024b;

import android.content.pm.PackageManager;
import android.os.Build;
import android.text.TextUtils;
import com.sec.chaton.global.C1493a;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.util.C3250y;
import java.io.InputStream;
import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;

/* compiled from: TranslationUtil.java */
/* renamed from: com.sec.chaton.chat.b.p */
/* loaded from: classes.dex */
public class C0965p {

    /* renamed from: a */
    private static final String f3963a = C0965p.class.getSimpleName();

    /* renamed from: a */
    public static boolean m5183a(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            C3250y.m11453c("Source Language error!! - " + str, f3963a);
            return false;
        }
        if (TextUtils.isEmpty(str2)) {
            C3250y.m11453c("Target Language error!! - " + str2, f3963a);
            return false;
        }
        return true;
    }

    /* renamed from: b */
    public static byte[] m5184b(String str, String str2) throws Exception {
        try {
            SecretKey secretKeyGenerateSecret = SecretKeyFactory.getInstance("DES").generateSecret(new DESKeySpec(str.getBytes("UTF-8")));
            Cipher cipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
            cipher.init(1, secretKeyGenerateSecret);
            return cipher.doFinal(str2.getBytes("UTF-8"));
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception(e.getMessage());
        }
    }

    /* renamed from: a */
    public static InputStream m5181a(String str, InputStream inputStream) throws Exception {
        try {
            SecretKey secretKeyGenerateSecret = SecretKeyFactory.getInstance("DES").generateSecret(new DESKeySpec(C0952c.m5143c().m5153b().getBytes("UTF-8")));
            Cipher cipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
            cipher.init(2, secretKeyGenerateSecret);
            return new CipherInputStream(inputStream, cipher);
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception(e.getMessage());
        }
    }

    /* renamed from: a */
    public static String m5182a() {
        String str = "";
        try {
            str = GlobalApplication.m11493l().getPackageManager().getPackageInfo(GlobalApplication.m11493l().getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        StringBuilder sb = new StringBuilder();
        sb.append(Build.MODEL).append("; ");
        sb.append(Build.DISPLAY).append("; ");
        if (C1493a.m6463a("tablet_enable_feature")) {
            sb.append("ChatON android tablet=").append(str);
        } else {
            sb.append("ChatON android phone=").append(str);
        }
        return sb.toString();
    }
}
