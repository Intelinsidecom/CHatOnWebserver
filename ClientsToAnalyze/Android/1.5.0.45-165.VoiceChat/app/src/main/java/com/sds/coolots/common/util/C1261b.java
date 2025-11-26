package com.sds.coolots.common.util;

import android.content.Context;
import android.os.Environment;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* renamed from: com.sds.coolots.common.util.b */
/* loaded from: classes.dex */
public class C1261b {

    /* renamed from: a */
    static Context f3096a = null;

    /* renamed from: b */
    static String f3097b = null;

    /* renamed from: c */
    static int f3098c = 0;

    /* renamed from: d */
    static final int f3099d = 1;

    /* renamed from: e */
    static final String f3100e = "ChatONVLog.jpg";

    /* renamed from: f */
    static final String f3101f = "ChatONV_LOG";

    /* renamed from: g */
    static final long f3102g = 5242880;

    /* renamed from: a */
    private static String m2991a(boolean z) {
        return (z ? new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS", Locale.KOREA) : new SimpleDateFormat("yyyy-MM-dd")).format(new Date());
    }

    /* renamed from: a */
    public static void m2992a(Context context) {
        f3096a = context;
    }

    /* renamed from: a */
    public static void m2993a(String str) throws IOException {
        if (str == null || (f3098c & 1) == 0) {
            return;
        }
        FileOutputStream fileOutputStreamOpenFileOutput = null;
        try {
            try {
                fileOutputStreamOpenFileOutput = f3096a.openFileOutput(f3097b, 32768);
                if (fileOutputStreamOpenFileOutput != null) {
                    fileOutputStreamOpenFileOutput.write(m2991a(true).getBytes());
                    fileOutputStreamOpenFileOutput.write(str.getBytes());
                    fileOutputStreamOpenFileOutput.write("\n".getBytes());
                }
                if (fileOutputStreamOpenFileOutput != null) {
                    try {
                        fileOutputStreamOpenFileOutput.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            } catch (Throwable th) {
                if (fileOutputStreamOpenFileOutput != null) {
                    try {
                        fileOutputStreamOpenFileOutput.close();
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
                throw th;
            }
        } catch (Exception e3) {
            e3.printStackTrace();
            if (fileOutputStreamOpenFileOutput != null) {
                try {
                    fileOutputStreamOpenFileOutput.close();
                } catch (Exception e4) {
                    e4.printStackTrace();
                }
            }
        }
    }

    /* renamed from: a */
    public static boolean m2994a() {
        File file = new File(String.valueOf(Environment.getExternalStorageDirectory().getAbsolutePath()) + File.separator + f3101f + File.separator);
        return file.exists() || file.mkdirs();
    }

    /* renamed from: b */
    private static void m2995b() throws IOException {
        if (f3096a.fileList().length > 0) {
            for (String str : f3096a.fileList()) {
                m2993a("fileNames in folder?" + str);
                if (str.startsWith("ChatONVLog") && !str.equals(f3097b) && (f3098c & 1) != 0) {
                    f3096a.deleteFile(str);
                    m2993a("DELETE OLD FILE!!!!");
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:43:0x00a4 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void m2996b(java.lang.String r4) throws java.lang.Throwable {
        /*
            if (r4 != 0) goto L3
        L2:
            return
        L3:
            java.io.File r0 = new java.io.File
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.io.File r2 = android.os.Environment.getExternalStorageDirectory()
            java.lang.String r2 = r2.getAbsolutePath()
            java.lang.String r2 = java.lang.String.valueOf(r2)
            r1.<init>(r2)
            java.lang.String r2 = "ChatONV_LOG"
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.String r1 = r1.toString()
            java.lang.String r2 = "ChatONVLog.jpg"
            r0.<init>(r1, r2)
            boolean r1 = r0.exists()
            if (r1 == 0) goto L39
            long r0 = r0.length()
            r2 = 5242880(0x500000, double:2.590327E-317)
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 < 0) goto L39
            m2995b()
        L39:
            r2 = 0
            java.io.FileOutputStream r1 = new java.io.FileOutputStream     // Catch: java.lang.Exception -> L8f java.lang.Throwable -> La1
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L8f java.lang.Throwable -> La1
            java.io.File r3 = android.os.Environment.getExternalStorageDirectory()     // Catch: java.lang.Exception -> L8f java.lang.Throwable -> La1
            java.lang.String r3 = r3.getAbsolutePath()     // Catch: java.lang.Exception -> L8f java.lang.Throwable -> La1
            java.lang.String r3 = java.lang.String.valueOf(r3)     // Catch: java.lang.Exception -> L8f java.lang.Throwable -> La1
            r0.<init>(r3)     // Catch: java.lang.Exception -> L8f java.lang.Throwable -> La1
            java.lang.String r3 = java.io.File.separator     // Catch: java.lang.Exception -> L8f java.lang.Throwable -> La1
            java.lang.StringBuilder r0 = r0.append(r3)     // Catch: java.lang.Exception -> L8f java.lang.Throwable -> La1
            java.lang.String r3 = "ChatONV_LOG"
            java.lang.StringBuilder r0 = r0.append(r3)     // Catch: java.lang.Exception -> L8f java.lang.Throwable -> La1
            java.lang.String r3 = java.io.File.separator     // Catch: java.lang.Exception -> L8f java.lang.Throwable -> La1
            java.lang.StringBuilder r0 = r0.append(r3)     // Catch: java.lang.Exception -> L8f java.lang.Throwable -> La1
            java.lang.String r3 = "ChatONVLog.jpg"
            java.lang.StringBuilder r0 = r0.append(r3)     // Catch: java.lang.Exception -> L8f java.lang.Throwable -> La1
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Exception -> L8f java.lang.Throwable -> La1
            r3 = 1
            r1.<init>(r0, r3)     // Catch: java.lang.Exception -> L8f java.lang.Throwable -> La1
            if (r1 == 0) goto L82
            r0 = 1
            java.lang.String r0 = m2991a(r0)     // Catch: java.lang.Throwable -> Lad java.lang.Exception -> Lb0
            byte[] r0 = r0.getBytes()     // Catch: java.lang.Throwable -> Lad java.lang.Exception -> Lb0
            r1.write(r0)     // Catch: java.lang.Throwable -> Lad java.lang.Exception -> Lb0
            byte[] r0 = r4.getBytes()     // Catch: java.lang.Throwable -> Lad java.lang.Exception -> Lb0
            r1.write(r0)     // Catch: java.lang.Throwable -> Lad java.lang.Exception -> Lb0
        L82:
            if (r1 == 0) goto L2
            r1.close()     // Catch: java.lang.Exception -> L89
            goto L2
        L89:
            r0 = move-exception
            r0.printStackTrace()
            goto L2
        L8f:
            r0 = move-exception
            r1 = r2
        L91:
            r0.printStackTrace()     // Catch: java.lang.Throwable -> Lad
            if (r1 == 0) goto L2
            r1.close()     // Catch: java.lang.Exception -> L9b
            goto L2
        L9b:
            r0 = move-exception
            r0.printStackTrace()
            goto L2
        La1:
            r0 = move-exception
        La2:
            if (r2 == 0) goto La7
            r2.close()     // Catch: java.lang.Exception -> La8
        La7:
            throw r0
        La8:
            r1 = move-exception
            r1.printStackTrace()
            goto La7
        Lad:
            r0 = move-exception
            r2 = r1
            goto La2
        Lb0:
            r0 = move-exception
            goto L91
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sds.coolots.common.util.C1261b.m2996b(java.lang.String):void");
    }
}
