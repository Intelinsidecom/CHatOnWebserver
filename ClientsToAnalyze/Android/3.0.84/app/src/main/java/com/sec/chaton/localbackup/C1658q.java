package com.sec.chaton.localbackup;

import android.os.Environment;
import com.sec.chaton.R;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.localbackup.database.C1642b;
import com.sec.chaton.p027e.C1404av;
import com.sec.chaton.util.C3158a;
import com.sec.chaton.util.C3159aa;
import com.sec.chaton.util.C3223ck;
import com.sec.common.CommonApplication;
import com.sec.widget.C3641ai;
import java.io.File;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* compiled from: EncryptionBackupFile.java */
/* renamed from: com.sec.chaton.localbackup.q */
/* loaded from: classes.dex */
public class C1658q {

    /* renamed from: a */
    public static final String f6136a = Environment.getExternalStorageDirectory().getAbsolutePath() + "/ChatON/LocalBackup/";

    /* renamed from: b */
    private Key f6137b;

    /* renamed from: c */
    private byte[] f6138c;

    /* renamed from: a */
    private void m6932a(File file, String str) throws Throwable {
        m6931a(1, file, str);
    }

    /* renamed from: b */
    private void m6936b(File file, String str) throws Throwable {
        m6931a(2, file, str);
    }

    /* renamed from: a */
    private String m6929a(int i, String str) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, InvalidAlgorithmParameterException {
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(i, this.f6137b, new IvParameterSpec(this.f6138c));
        if (i == 1 && str != null) {
            return C3158a.m10954a(cipher.doFinal(str.getBytes()));
        }
        if (i != 2) {
            return null;
        }
        return new String(cipher.doFinal(m6933a(C3159aa.m10962a().m10979a("backup_enterkey", ""), 16)), "UTF-8");
    }

    /* JADX WARN: Removed duplicated region for block: B:69:0x0068 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0063 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:90:? A[SYNTHETIC] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void m6931a(int r7, java.io.File r8, java.lang.String r9) throws java.lang.Throwable {
        /*
            r6 = this;
            r2 = 0
            java.lang.String r0 = "AES/CBC/PKCS5Padding"
            javax.crypto.Cipher r0 = javax.crypto.Cipher.getInstance(r0)
            javax.crypto.spec.IvParameterSpec r1 = new javax.crypto.spec.IvParameterSpec
            byte[] r3 = r6.f6138c
            r1.<init>(r3)
            java.security.Key r3 = r6.f6137b
            r0.init(r7, r3, r1)
            java.io.BufferedInputStream r3 = new java.io.BufferedInputStream     // Catch: java.lang.Throwable -> L5f java.io.IOException -> L72 java.io.FileNotFoundException -> L91
            java.io.FileInputStream r1 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L5f java.io.IOException -> L72 java.io.FileNotFoundException -> L91
            r1.<init>(r8)     // Catch: java.lang.Throwable -> L5f java.io.IOException -> L72 java.io.FileNotFoundException -> L91
            r3.<init>(r1)     // Catch: java.lang.Throwable -> L5f java.io.IOException -> L72 java.io.FileNotFoundException -> L91
            java.io.BufferedOutputStream r1 = new java.io.BufferedOutputStream     // Catch: java.lang.Throwable -> L83 java.io.IOException -> L8c java.io.FileNotFoundException -> L94
            java.io.FileOutputStream r4 = new java.io.FileOutputStream     // Catch: java.lang.Throwable -> L83 java.io.IOException -> L8c java.io.FileNotFoundException -> L94
            r4.<init>(r9)     // Catch: java.lang.Throwable -> L83 java.io.IOException -> L8c java.io.FileNotFoundException -> L94
            r1.<init>(r4)     // Catch: java.lang.Throwable -> L83 java.io.IOException -> L8c java.io.FileNotFoundException -> L94
            r2 = 1024(0x400, float:1.435E-42)
            byte[] r2 = new byte[r2]     // Catch: java.io.FileNotFoundException -> L3b java.lang.Throwable -> L85 java.io.IOException -> L8e
        L2b:
            int r4 = r3.read(r2)     // Catch: java.io.FileNotFoundException -> L3b java.lang.Throwable -> L85 java.io.IOException -> L8e
            r5 = -1
            if (r4 == r5) goto L4b
            r5 = 0
            byte[] r4 = r0.update(r2, r5, r4)     // Catch: java.io.FileNotFoundException -> L3b java.lang.Throwable -> L85 java.io.IOException -> L8e
            r1.write(r4)     // Catch: java.io.FileNotFoundException -> L3b java.lang.Throwable -> L85 java.io.IOException -> L8e
            goto L2b
        L3b:
            r0 = move-exception
            r2 = r3
        L3d:
            r0.printStackTrace()     // Catch: java.lang.Throwable -> L88
            if (r1 == 0) goto L45
            r1.close()     // Catch: java.io.IOException -> L70
        L45:
            if (r2 == 0) goto L4a
            r2.close()     // Catch: java.io.IOException -> L5d
        L4a:
            return
        L4b:
            byte[] r0 = r0.doFinal()     // Catch: java.io.FileNotFoundException -> L3b java.lang.Throwable -> L85 java.io.IOException -> L8e
            r1.write(r0)     // Catch: java.io.FileNotFoundException -> L3b java.lang.Throwable -> L85 java.io.IOException -> L8e
            if (r1 == 0) goto L57
            r1.close()     // Catch: java.io.IOException -> L81
        L57:
            if (r3 == 0) goto L4a
            r3.close()     // Catch: java.io.IOException -> L5d
            goto L4a
        L5d:
            r0 = move-exception
            goto L4a
        L5f:
            r0 = move-exception
            r3 = r2
        L61:
            if (r2 == 0) goto L66
            r2.close()     // Catch: java.io.IOException -> L6c
        L66:
            if (r3 == 0) goto L6b
            r3.close()     // Catch: java.io.IOException -> L6e
        L6b:
            throw r0
        L6c:
            r1 = move-exception
            goto L66
        L6e:
            r1 = move-exception
            goto L6b
        L70:
            r0 = move-exception
            goto L45
        L72:
            r0 = move-exception
            r3 = r2
        L74:
            if (r2 == 0) goto L79
            r2.close()     // Catch: java.io.IOException -> L7f
        L79:
            if (r3 == 0) goto L4a
            r3.close()     // Catch: java.io.IOException -> L5d
            goto L4a
        L7f:
            r0 = move-exception
            goto L79
        L81:
            r0 = move-exception
            goto L57
        L83:
            r0 = move-exception
            goto L61
        L85:
            r0 = move-exception
            r2 = r1
            goto L61
        L88:
            r0 = move-exception
            r3 = r2
            r2 = r1
            goto L61
        L8c:
            r0 = move-exception
            goto L74
        L8e:
            r0 = move-exception
            r2 = r1
            goto L74
        L91:
            r0 = move-exception
            r1 = r2
            goto L3d
        L94:
            r0 = move-exception
            r1 = r2
            r2 = r3
            goto L3d
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.localbackup.C1658q.m6931a(int, java.io.File, java.lang.String):void");
    }

    /* renamed from: a */
    public void m6942a(EnumC1661t enumC1661t, String str, String str2) {
        this.f6137b = new SecretKeySpec(m6937b(str + "7832512ed294cf75a3529456d273801b"), "AES");
        this.f6138c = m6933a("123abc654def07984cf75a35292512ed", 16);
        if (str2 != null) {
            switch (C1659r.f6139a[enumC1661t.ordinal()]) {
                case 1:
                    m6932a(m6934b(), str2);
                    C3159aa.m10962a().m10986b("backup_last_modified", m6935b(Long.valueOf(new File(str2).lastModified())));
                    break;
                case 2:
                    C1642b.m6919a().close();
                    m6936b(new File(str2), m6930a(m6934b()));
                    C3159aa.m10962a().m10986b("backup_checkkey", Long.toString(new File(str2).lastModified()));
                    break;
            }
        }
    }

    /* renamed from: b */
    private String m6935b(Long l) {
        Date date = new Date();
        date.setTime(l.longValue());
        return new SimpleDateFormat("yyyy-MM-dd hh:mm a").format(date);
    }

    /* renamed from: b */
    private byte[] m6937b(String str) {
        byte[] bytes = str.getBytes();
        int length = bytes.length;
        byte[] bArr = new byte[16];
        if (length >= 16) {
            System.arraycopy(bytes, 0, bArr, 0, 16);
        } else {
            System.arraycopy(bytes, 0, bArr, 0, length);
            for (int i = 0; i < 16 - length; i++) {
                bArr[length + i] = bytes[i % length];
            }
        }
        return bArr;
    }

    /* renamed from: a */
    public String m6938a(EnumC1660s enumC1660s, String str) {
        this.f6137b = new SecretKeySpec(m6933a("5a3529457832512ed294cf76d273801b", 16), "AES");
        this.f6138c = m6933a("123abc654def07984cf75a35292512ed", 16);
        switch (C1659r.f6140b[enumC1660s.ordinal()]) {
            case 1:
                String strM6929a = m6929a(1, str);
                C3159aa.m10962a().m10986b("backup_enterkey", strM6929a);
                return strM6929a;
            case 2:
                return m6929a(2, (String) null);
            default:
                return null;
        }
    }

    /* renamed from: b */
    private File m6934b() {
        return GlobalApplication.m11493l().getDatabasePath(C1404av.m6254a());
    }

    /* renamed from: a */
    public String m6940a(String str) {
        if (C3223ck.m11327a()) {
            File file = new File(f6136a);
            if (!file.exists()) {
                file.mkdirs();
            }
            return f6136a + str;
        }
        C3641ai.m13210a(CommonApplication.m11493l(), R.string.unable_backup_sdcard, 0).show();
        return null;
    }

    /* renamed from: a */
    private String m6930a(File file) {
        return file.getAbsolutePath().substring(0, file.getAbsolutePath().lastIndexOf("/")) + "/chaton_local_backup.db";
    }

    /* renamed from: a */
    private byte[] m6933a(String str, int i) {
        if (str == null || str.length() == 0) {
            return null;
        }
        int length = str.length();
        if (length % 2 == 1) {
            throw new IllegalArgumentException("Illegal input string");
        }
        int i2 = length / 2;
        byte[] bArr = new byte[i2];
        for (int i3 = 0; i3 < i2; i3++) {
            int i4 = i3 * 2;
            bArr[i3] = (byte) Short.parseShort(str.substring(i4, i4 + 2), i);
        }
        return bArr;
    }

    /* renamed from: a */
    public void m6941a() {
        if (C3223ck.m11327a()) {
            File file = new File(m6940a("local-backup.db.crypt"));
            if (file.exists()) {
                file.renameTo(new File(m6940a(m6939a(Long.valueOf(file.lastModified())))));
            }
        }
    }

    /* renamed from: a */
    public String m6939a(Long l) {
        Date date = new Date();
        date.setTime(l.longValue());
        return "local-backup.db.crypt".substring(0, "local-backup.db.crypt".indexOf(".")) + new SimpleDateFormat("yyyyMMddhhmm").format(date) + ".db.crypt";
    }
}
