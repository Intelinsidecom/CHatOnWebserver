package com.sec.chaton.util;

import android.media.MediaScannerConnection;
import android.os.Environment;
import android.text.TextUtils;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p012c.C0452a;
import com.sec.chaton.p017e.EnumC0695j;
import com.sec.chaton.p017e.p018a.C0665i;
import com.sec.chaton.p022h.C0764a;
import com.sec.chaton.p022h.C0800j;
import com.sec.chaton.p022h.EnumC0801k;
import java.io.File;

/* compiled from: ChatONFileUtil.java */
/* renamed from: com.sec.chaton.util.o */
/* loaded from: classes.dex */
public class C1783o {

    /* renamed from: b */
    private static MediaScannerConnection f6447b;

    /* renamed from: c */
    private static String f6448c;

    /* renamed from: a */
    private static String f6446a = "ChatONFileUtil";

    /* renamed from: d */
    private static MediaScannerConnection.MediaScannerConnectionClient f6449d = new C1784p();

    /* renamed from: a */
    public static void m6034a() {
        File file = new File(Environment.getExternalStorageDirectory().getAbsolutePath(), "ChatON");
        if (file.exists()) {
            m6035a(file);
            if (!file.delete()) {
                file.delete();
            }
        }
    }

    /* renamed from: b */
    public static void m6037b() {
        File[] fileArrListFiles;
        File file = new File(GlobalApplication.m3260b().getFilesDir().getAbsolutePath());
        if (file.exists() && (fileArrListFiles = file.listFiles()) != null) {
            for (File file2 : fileArrListFiles) {
                if (file2.isDirectory()) {
                    m6035a(file2);
                    if (!file2.delete()) {
                        file2.delete();
                    }
                }
            }
        }
    }

    /* renamed from: a */
    public static void m6036a(String str) {
        C1786r.m6061b("deleteDirectory path: " + str, f6446a);
        File file = new File(str);
        if (file.exists()) {
            m6035a(file);
            if (!file.delete()) {
                file.delete();
            }
        }
    }

    /* renamed from: a */
    public static void m6035a(File file) {
        int length;
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles != null && (length = fileArrListFiles.length) > 0) {
            for (int i = 0; i < length; i++) {
                if (fileArrListFiles[i].isFile()) {
                    fileArrListFiles[i].delete();
                } else {
                    m6035a(fileArrListFiles[i]);
                    if (!fileArrListFiles[i].delete()) {
                        fileArrListFiles[i].delete();
                    }
                }
            }
        }
    }

    /* renamed from: b */
    public static boolean m6039b(String str) {
        return new File(str).exists();
    }

    /* renamed from: b */
    public static boolean m6038b(File file) {
        return file != null && file.exists();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:122:0x00b8 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:128:0x00c7 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:132:0x0142 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:134:0x00c2 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:136:0x00bd A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:139:0x013d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:141:0x0138 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:143:0x0133 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r2v24 */
    /* JADX WARN: Type inference failed for: r2v28 */
    /* JADX WARN: Type inference failed for: r2v3, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r2v31 */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String m6032a(java.lang.String r9, java.lang.String r10, java.lang.String r11) {
        /*
            Method dump skipped, instructions count: 486
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.util.C1783o.m6032a(java.lang.String, java.lang.String, java.lang.String):java.lang.String");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00c6 A[PHI: r1 r2
  0x00c6: PHI (r1v10 java.io.FileOutputStream) = 
  (r1v14 java.io.FileOutputStream)
  (r1v5 java.io.FileOutputStream)
  (r1v19 java.io.FileOutputStream)
  (r1v20 java.io.FileOutputStream)
 binds: [B:15:0x0068, B:35:0x00c5, B:19:0x0074, B:21:0x007e] A[DONT_GENERATE, DONT_INLINE]
  0x00c6: PHI (r2v24 ??) = (r2v30 ?? I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]), (r2v20 ??), (r2v21 ??), (r2v22 ??) binds: [B:15:0x0068, B:35:0x00c5, B:19:0x0074, B:21:0x007e] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:67:0x015d  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x017d  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x00c8 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0068 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x001e  */
    /* JADX WARN: Type inference failed for: r2v11 */
    /* JADX WARN: Type inference failed for: r2v12 */
    /* JADX WARN: Type inference failed for: r2v13, types: [java.io.FileOutputStream] */
    /* JADX WARN: Type inference failed for: r2v16, types: [java.io.FileOutputStream] */
    /* JADX WARN: Type inference failed for: r2v20, types: [java.io.FileOutputStream, java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r2v21, types: [boolean] */
    /* JADX WARN: Type inference failed for: r2v22, types: [int] */
    /* JADX WARN: Type inference failed for: r2v24 */
    /* JADX WARN: Type inference failed for: r2v30 */
    /* JADX WARN: Type inference failed for: r3v10, types: [android.graphics.Bitmap] */
    /* JADX WARN: Type inference failed for: r3v14 */
    /* JADX WARN: Type inference failed for: r3v2 */
    /* JADX WARN: Type inference failed for: r3v9 */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static android.graphics.Bitmap m6031a(android.content.Context r8, java.io.File r9, boolean r10, boolean r11) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 384
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.util.C1783o.m6031a(android.content.Context, java.io.File, boolean, boolean):android.graphics.Bitmap");
    }

    /* renamed from: a */
    public static String m6033a(String str, String str2, String str3, boolean z, String str4, long j, EnumC0695j enumC0695j, String str5) {
        String strM6009a;
        String strM3270a;
        f6447b = new MediaScannerConnection(GlobalApplication.m3260b(), f6449d);
        C0800j c0800jM3409a = new C0800j(EnumC1765bu.FILE, "/file").m3406a(EnumC0801k.GET).m3409a("uid", C1789u.m6075a().getString("uid", ""));
        String str6 = "imei=" + C1721ad.m5873a() + "&buddyid=" + str2 + "&filename=" + str3;
        String str7 = str6 + "&size=239";
        C1786r.m6061b("filedownLoadUrl:" + str6, f6446a);
        try {
            String strM6029a = GlobalApplication.m3264e().m6029a();
            if (!TextUtils.isEmpty(strM6029a)) {
                C1771c c1771c = new C1771c(C1771c.m6013b(strM6029a), C1771c.m6014c(strM6029a));
                if (z) {
                    strM6009a = C1771c.m6009a(c1771c.m6015b(str7.getBytes()));
                } else {
                    strM6009a = C1771c.m6009a(c1771c.m6015b(str6.getBytes()));
                }
                c0800jM3409a.m3409a("param", strM6009a);
                boolean zM6002a = C1767bw.m6002a();
                String absolutePath = zM6002a ? GlobalApplication.m3260b().getExternalFilesDir(null).getAbsolutePath() : GlobalApplication.m3260b().getFilesDir().getAbsolutePath();
                try {
                    String str8 = str + "?uid=" + C1789u.m6075a().getString("uid", "") + "&param=" + strM6009a;
                    C1786r.m6061b("Donwload Url : " + str8, f6446a);
                    strM3270a = C0764a.m3270a(str8, absolutePath + "//" + str4 + "//", str3, z);
                } catch (Exception e) {
                    C1786r.m6056a(e, f6446a);
                    strM3270a = C0452a.f1724c;
                }
                C0665i.m3058a(GlobalApplication.m3260b().getContentResolver(), str5, str4, Long.valueOf(j), strM3270a, enumC0695j, zM6002a, z);
                return strM3270a;
            }
            C1786r.m6054a("Fail in getting a key", f6446a);
            C0665i.m3058a(GlobalApplication.m3260b().getContentResolver(), str5, str4, Long.valueOf(j), C0452a.f1724c, enumC0695j, C1767bw.m6002a(), z);
            return C0452a.f1724c;
        } catch (Exception e2) {
            C1786r.m6056a(e2, f6446a);
            C0665i.m3058a(GlobalApplication.m3260b().getContentResolver(), str5, str4, Long.valueOf(j), C0452a.f1724c, enumC0695j, C1767bw.m6002a(), z);
            return C0452a.f1724c;
        }
    }
}
