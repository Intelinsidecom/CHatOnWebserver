package com.sec.chaton.util;

import android.media.MediaScannerConnection;
import android.os.Environment;
import android.text.TextUtils;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p018c.C0478ac;
import com.sec.chaton.p018c.C0519z;
import com.sec.chaton.p018c.EnumC0511r;
import com.sec.chaton.p025d.EnumC0665r;
import com.sec.chaton.p025d.p026a.C0635o;
import com.sec.chaton.p029f.C0684a;
import java.io.File;

/* compiled from: ChatONFileUtil.java */
/* renamed from: com.sec.chaton.util.bt */
/* loaded from: classes.dex */
public class C1324bt {

    /* renamed from: b */
    private static MediaScannerConnection f4546b;

    /* renamed from: c */
    private static String f4547c;

    /* renamed from: a */
    private static String f4545a = "ChatONFileUtil";

    /* renamed from: d */
    private static MediaScannerConnection.MediaScannerConnectionClient f4548d = new C1334i();

    /* renamed from: a */
    public static void m4583a() {
        File file = new File(Environment.getExternalStorageDirectory().getAbsolutePath(), "ChatON");
        if (file.exists()) {
            m4584a(file);
            if (!file.delete()) {
                file.delete();
            }
        }
    }

    /* renamed from: b */
    public static void m4586b() {
        File[] fileArrListFiles;
        try {
            File file = new File(GlobalApplication.m3100a().getFilesDir().getAbsolutePath());
            if (file.exists() && (fileArrListFiles = file.listFiles()) != null) {
                for (File file2 : fileArrListFiles) {
                    if (file2.isDirectory()) {
                        m4584a(file2);
                        if (!file2.delete()) {
                            file2.delete();
                        }
                    }
                }
            }
        } catch (Exception e) {
            C1341p.m4653a(e, f4545a);
        }
    }

    /* renamed from: a */
    public static void m4585a(String str) {
        C1341p.m4658b("deleteDirectory path: " + str, f4545a);
        try {
            File file = new File(str);
            if (file.exists()) {
                m4584a(file);
                if (!file.delete()) {
                    file.delete();
                }
            }
        } catch (Exception e) {
            C1341p.m4653a(e, f4545a);
        }
    }

    /* renamed from: a */
    public static void m4584a(File file) {
        int length;
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles != null && (length = fileArrListFiles.length) > 0) {
            for (int i = 0; i < length; i++) {
                if (fileArrListFiles[i].isFile()) {
                    fileArrListFiles[i].delete();
                } else {
                    m4584a(fileArrListFiles[i]);
                    if (!fileArrListFiles[i].delete()) {
                        fileArrListFiles[i].delete();
                    }
                }
            }
        }
    }

    /* renamed from: b */
    public static boolean m4588b(String str) {
        return new File(str).exists();
    }

    /* renamed from: b */
    public static boolean m4587b(File file) {
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
    public static java.lang.String m4581a(java.lang.String r9, java.lang.String r10, java.lang.String r11) {
        /*
            Method dump skipped, instructions count: 486
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.util.C1324bt.m4581a(java.lang.String, java.lang.String, java.lang.String):java.lang.String");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:11:0x003c  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x006b A[Catch: FileNotFoundException -> 0x00d0, Exception -> 0x00ea, all -> 0x010f, TryCatch #12 {FileNotFoundException -> 0x00d0, Exception -> 0x00ea, all -> 0x010f, blocks: (B:14:0x0065, B:20:0x007b, B:16:0x006b, B:18:0x0071), top: B:93:0x0065 }] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x007b A[Catch: FileNotFoundException -> 0x00d0, Exception -> 0x00ea, all -> 0x010f, TRY_LEAVE, TryCatch #12 {FileNotFoundException -> 0x00d0, Exception -> 0x00ea, all -> 0x010f, blocks: (B:14:0x0065, B:20:0x007b, B:16:0x006b, B:18:0x0071), top: B:93:0x0065 }] */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0112 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00e4 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:85:0x00f9 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0065 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static android.graphics.Bitmap m4580a(android.content.Context r9, java.io.File r10, boolean r11) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 348
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.util.C1324bt.m4580a(android.content.Context, java.io.File, boolean):android.graphics.Bitmap");
    }

    /* renamed from: a */
    public static String m4582a(String str, String str2, String str3, boolean z, String str4, long j, EnumC0665r enumC0665r, String str5) {
        String strM4567a;
        String strM2468a;
        f4546b = new MediaScannerConnection(GlobalApplication.m3100a(), f4548d);
        C0519z c0519zM2584a = new C0519z(EnumC1333h.FILE, "/file").m2581a(EnumC0511r.GET).m2584a("uid", C1323bs.m4575a().getString("uid", ""));
        String str6 = "imei=" + C1336k.m4621a() + "&buddyid=" + str2 + "&filename=" + str3;
        String str7 = str6 + "&size=239";
        C1341p.m4658b("filedownLoadUrl:" + str6, f4545a);
        try {
            String strM4670a = GlobalApplication.m3108i().m4670a();
            if (!TextUtils.isEmpty(strM4670a)) {
                C1322br c1322br = new C1322br(C1322br.m4571b(strM4670a), C1322br.m4572c(strM4670a));
                if (z) {
                    strM4567a = C1322br.m4567a(c1322br.m4573b(str7.getBytes()));
                } else {
                    strM4567a = C1322br.m4567a(c1322br.m4573b(str6.getBytes()));
                }
                c0519zM2584a.m2584a("param", strM4567a);
                boolean zM4595a = C1327bw.m4595a();
                String absolutePath = zM4595a ? GlobalApplication.m3100a().getExternalFilesDir(null).getAbsolutePath() : GlobalApplication.m3100a().getFilesDir().getAbsolutePath();
                try {
                    String str8 = str + "?uid=" + C1323bs.m4575a().getString("uid", "") + "&param=" + strM4567a;
                    C1341p.m4658b("Donwload Url : " + str8, f4545a);
                    strM2468a = C0478ac.m2468a(str8, absolutePath + "//" + str4 + "//", str3, z);
                    if (C1341p.f4578b) {
                        C1341p.m4658b("download result: " + strM2468a, f4545a);
                    }
                } catch (Exception e) {
                    C1341p.m4653a(e, f4545a);
                    strM2468a = C0684a.f2332c;
                }
                C0635o.m2927a(GlobalApplication.m3100a().getContentResolver(), str5, str4, Long.valueOf(j), strM2468a, enumC0665r, zM4595a, z);
                return strM2468a;
            }
            C1341p.m4651a("Fail in getting a key", f4545a);
            C0635o.m2927a(GlobalApplication.m3100a().getContentResolver(), str5, str4, Long.valueOf(j), C0684a.f2332c, enumC0665r, C1327bw.m4595a(), z);
            return C0684a.f2332c;
        } catch (Exception e2) {
            C1341p.m4653a(e2, f4545a);
            C0635o.m2927a(GlobalApplication.m3100a().getContentResolver(), str5, str4, Long.valueOf(j), C0684a.f2332c, enumC0665r, C1327bw.m4595a(), z);
            return C0684a.f2332c;
        }
    }
}
