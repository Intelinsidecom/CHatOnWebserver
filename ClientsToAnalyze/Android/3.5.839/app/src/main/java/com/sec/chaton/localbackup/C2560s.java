package com.sec.chaton.localbackup;

import android.os.Environment;
import com.sec.chaton.R;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.localbackup.database.C2544b;
import com.sec.chaton.p057e.C2268bn;
import com.sec.chaton.util.C4808a;
import com.sec.chaton.util.C4809aa;
import com.sec.chaton.util.C4873ck;
import com.sec.chaton.util.C4904y;
import com.sec.common.CommonApplication;
import com.sec.widget.C5179v;
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
/* renamed from: com.sec.chaton.localbackup.s */
/* loaded from: classes.dex */
public class C2560s {

    /* renamed from: c */
    private Key f9182c;

    /* renamed from: d */
    private byte[] f9183d;

    /* renamed from: b */
    private static final String f9181b = C2560s.class.getSimpleName();

    /* renamed from: a */
    public static final String f9180a = Environment.getExternalStorageDirectory().getAbsolutePath() + "/ChatON/LocalBackup/";

    /* renamed from: a */
    private void m10963a(File file, String str) throws Throwable {
        m10962a(1, file, str);
    }

    /* renamed from: b */
    private void m10967b(File file, String str) throws Throwable {
        m10962a(2, file, str);
    }

    /* renamed from: a */
    private String m10960a(int i, String str) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, InvalidAlgorithmParameterException {
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(i, this.f9182c, new IvParameterSpec(this.f9183d));
        if (i == 1 && str != null) {
            return C4808a.m18098a(cipher.doFinal(str.getBytes()));
        }
        if (i != 2) {
            return null;
        }
        return new String(cipher.doFinal(m10964a(C4809aa.m18104a().m18121a("backup_enterkey", ""), 16)), "UTF-8");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0091 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:74:0x008c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:96:? A[SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r0v1, types: [javax.crypto.Cipher] */
    /* JADX WARN: Type inference failed for: r3v1, types: [java.security.Key] */
    /* JADX WARN: Type inference failed for: r3v10, types: [java.io.BufferedInputStream, java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r3v2, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r3v3 */
    /* JADX WARN: Type inference failed for: r3v4 */
    /* JADX WARN: Type inference failed for: r3v5, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r3v6 */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void m10962a(int r7, java.io.File r8, java.lang.String r9) throws java.lang.Throwable {
        /*
            r6 = this;
            r2 = 0
            java.lang.String r0 = "AES/CBC/PKCS5Padding"
            javax.crypto.Cipher r0 = javax.crypto.Cipher.getInstance(r0)
            javax.crypto.spec.IvParameterSpec r1 = new javax.crypto.spec.IvParameterSpec
            byte[] r3 = r6.f9183d
            r1.<init>(r3)
            java.security.Key r3 = r6.f9182c
            r0.init(r7, r3, r1)
            java.io.BufferedInputStream r3 = new java.io.BufferedInputStream     // Catch: java.io.IOException -> L6c java.lang.Throwable -> L88 java.io.FileNotFoundException -> Lad
            java.io.FileInputStream r1 = new java.io.FileInputStream     // Catch: java.io.IOException -> L6c java.lang.Throwable -> L88 java.io.FileNotFoundException -> Lad
            r1.<init>(r8)     // Catch: java.io.IOException -> L6c java.lang.Throwable -> L88 java.io.FileNotFoundException -> Lad
            r3.<init>(r1)     // Catch: java.io.IOException -> L6c java.lang.Throwable -> L88 java.io.FileNotFoundException -> Lad
            java.io.BufferedOutputStream r1 = new java.io.BufferedOutputStream     // Catch: java.lang.Throwable -> L9f java.io.IOException -> La8 java.io.FileNotFoundException -> Lb0
            java.io.FileOutputStream r4 = new java.io.FileOutputStream     // Catch: java.lang.Throwable -> L9f java.io.IOException -> La8 java.io.FileNotFoundException -> Lb0
            r4.<init>(r9)     // Catch: java.lang.Throwable -> L9f java.io.IOException -> La8 java.io.FileNotFoundException -> Lb0
            r1.<init>(r4)     // Catch: java.lang.Throwable -> L9f java.io.IOException -> La8 java.io.FileNotFoundException -> Lb0
            r2 = 1024(0x400, float:1.435E-42)
            byte[] r2 = new byte[r2]     // Catch: java.io.FileNotFoundException -> L3c java.lang.Throwable -> La1 java.io.IOException -> Laa
        L2c:
            int r4 = r3.read(r2)     // Catch: java.io.FileNotFoundException -> L3c java.lang.Throwable -> La1 java.io.IOException -> Laa
            r5 = -1
            if (r4 == r5) goto L58
            r5 = 0
            byte[] r4 = r0.update(r2, r5, r4)     // Catch: java.io.FileNotFoundException -> L3c java.lang.Throwable -> La1 java.io.IOException -> Laa
            r1.write(r4)     // Catch: java.io.FileNotFoundException -> L3c java.lang.Throwable -> La1 java.io.IOException -> Laa
            goto L2c
        L3c:
            r0 = move-exception
            r2 = r3
        L3e:
            boolean r3 = com.sec.chaton.util.C4904y.f17875e     // Catch: java.lang.Throwable -> La4
            if (r3 == 0) goto L4d
            java.lang.Class r3 = r6.getClass()     // Catch: java.lang.Throwable -> La4
            java.lang.String r3 = r3.getSimpleName()     // Catch: java.lang.Throwable -> La4
            com.sec.chaton.util.C4904y.m18635a(r0, r3)     // Catch: java.lang.Throwable -> La4
        L4d:
            if (r1 == 0) goto L52
            r1.close()     // Catch: java.io.IOException -> L99
        L52:
            if (r2 == 0) goto L57
            r2.close()     // Catch: java.io.IOException -> L6a
        L57:
            return
        L58:
            byte[] r0 = r0.doFinal()     // Catch: java.io.FileNotFoundException -> L3c java.lang.Throwable -> La1 java.io.IOException -> Laa
            r1.write(r0)     // Catch: java.io.FileNotFoundException -> L3c java.lang.Throwable -> La1 java.io.IOException -> Laa
            if (r1 == 0) goto L64
            r1.close()     // Catch: java.io.IOException -> L9d
        L64:
            if (r3 == 0) goto L57
            r3.close()     // Catch: java.io.IOException -> L6a
            goto L57
        L6a:
            r0 = move-exception
            goto L57
        L6c:
            r0 = move-exception
            r3 = r2
        L6e:
            boolean r1 = com.sec.chaton.util.C4904y.f17875e     // Catch: java.lang.Throwable -> L9f
            if (r1 == 0) goto L7d
            java.lang.Class r1 = r6.getClass()     // Catch: java.lang.Throwable -> L9f
            java.lang.String r1 = r1.getSimpleName()     // Catch: java.lang.Throwable -> L9f
            com.sec.chaton.util.C4904y.m18635a(r0, r1)     // Catch: java.lang.Throwable -> L9f
        L7d:
            if (r2 == 0) goto L82
            r2.close()     // Catch: java.io.IOException -> L9b
        L82:
            if (r3 == 0) goto L57
            r3.close()     // Catch: java.io.IOException -> L6a
            goto L57
        L88:
            r0 = move-exception
            r3 = r2
        L8a:
            if (r2 == 0) goto L8f
            r2.close()     // Catch: java.io.IOException -> L95
        L8f:
            if (r3 == 0) goto L94
            r3.close()     // Catch: java.io.IOException -> L97
        L94:
            throw r0
        L95:
            r1 = move-exception
            goto L8f
        L97:
            r1 = move-exception
            goto L94
        L99:
            r0 = move-exception
            goto L52
        L9b:
            r0 = move-exception
            goto L82
        L9d:
            r0 = move-exception
            goto L64
        L9f:
            r0 = move-exception
            goto L8a
        La1:
            r0 = move-exception
            r2 = r1
            goto L8a
        La4:
            r0 = move-exception
            r3 = r2
            r2 = r1
            goto L8a
        La8:
            r0 = move-exception
            goto L6e
        Laa:
            r0 = move-exception
            r2 = r1
            goto L6e
        Lad:
            r0 = move-exception
            r1 = r2
            goto L3e
        Lb0:
            r0 = move-exception
            r1 = r2
            r2 = r3
            goto L3e
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.localbackup.C2560s.m10962a(int, java.io.File, java.lang.String):void");
    }

    /* renamed from: a */
    public void m10973a(EnumC2563v enumC2563v, String str, String str2) throws Throwable {
        if (str != null) {
            this.f9182c = new SecretKeySpec(m10968b(str + "7832512ed294cf75a3529456d273801b"), "AES");
            this.f9183d = m10964a("123abc654def07984cf75a35292512ed", 16);
            if (str2 != null) {
                switch (C2561t.f9184a[enumC2563v.ordinal()]) {
                    case 1:
                        m10963a(m10965b(), str2);
                        C4809aa.m18104a().m18128b("backup_last_modified", m10966b(Long.valueOf(new File(str2).lastModified())));
                        break;
                    case 2:
                        C2544b.m10951a().close();
                        m10967b(new File(str2), m10961a(m10965b()));
                        C4809aa.m18104a().m18128b("backup_checkkey", Long.toString(new File(str2).lastModified()));
                        break;
                }
            }
        }
    }

    /* renamed from: b */
    private String m10966b(Long l) {
        Date date = new Date();
        date.setTime(l.longValue());
        return new SimpleDateFormat("yyyy-MM-dd hh:mm a").format(date);
    }

    /* renamed from: b */
    private byte[] m10968b(String str) {
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
    public String m10969a(EnumC2562u enumC2562u, String str) {
        this.f9182c = new SecretKeySpec(m10964a("5a3529457832512ed294cf76d273801b", 16), "AES");
        this.f9183d = m10964a("123abc654def07984cf75a35292512ed", 16);
        switch (C2561t.f9185b[enumC2562u.ordinal()]) {
            case 1:
                String strM10960a = m10960a(1, str);
                C4809aa.m18104a().m18128b("backup_enterkey", strM10960a);
                return strM10960a;
            case 2:
                return m10960a(2, (String) null);
            default:
                return null;
        }
    }

    /* renamed from: b */
    private File m10965b() {
        return GlobalApplication.m18732r().getDatabasePath(C2268bn.m10127a());
    }

    /* renamed from: a */
    public String m10971a(String str) {
        if (C4873ck.m18500a()) {
            File file = new File(f9180a);
            if (!file.exists()) {
                file.mkdirs();
            }
            return f9180a + str;
        }
        C5179v.m19810a(CommonApplication.m18732r(), R.string.unable_backup_sdcard, 0).show();
        return null;
    }

    /* renamed from: a */
    private String m10961a(File file) {
        return file.getAbsolutePath().substring(0, file.getAbsolutePath().lastIndexOf("/")) + "/chaton_local_backup.db";
    }

    /* renamed from: a */
    private byte[] m10964a(String str, int i) {
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
    public void m10972a() {
        String strM10970a;
        String strM10971a;
        if (C4873ck.m18500a()) {
            boolean z = false;
            try {
                String strM10971a2 = m10971a("local-backup.db.crypt");
                if (strM10971a2 != null) {
                    File file = new File(strM10971a2);
                    if (file.exists() && (strM10970a = m10970a(Long.valueOf(file.lastModified()))) != null && (strM10971a = m10971a(strM10970a)) != null) {
                        file.renameTo(new File(strM10971a));
                        z = true;
                    }
                }
            } catch (Exception e) {
                if (C4904y.f17875e) {
                    C4904y.m18634a("Renaming file is failed. errorMsg : " + e, f9181b);
                }
            }
            if (z && C4904y.f17872b) {
                C4904y.m18634a("Renaming is success ", f9181b);
                return;
            }
            return;
        }
        if (C4904y.f17875e) {
            C4904y.m18634a("Renaming file is failed. There is no storage available.", f9181b);
        }
    }

    /* renamed from: a */
    public String m10970a(Long l) {
        Date date = new Date();
        date.setTime(l.longValue());
        return "local-backup.db.crypt".substring(0, "local-backup.db.crypt".indexOf(".")) + new SimpleDateFormat("yyyyMMddhhmm").format(date) + ".db.crypt";
    }
}
