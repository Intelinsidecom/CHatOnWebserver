package com.sec.chaton.util;

import android.media.MediaPlayer;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.text.TextUtils;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p020c.C0816a;
import com.sec.chaton.p027e.EnumC1450r;
import com.sec.chaton.p027e.p028a.C1373q;
import com.sec.chaton.p037j.C1540a;
import com.sec.chaton.p037j.C1582j;
import com.sec.chaton.p037j.EnumC1583k;
import com.sec.common.CommonApplication;
import java.io.File;
import java.io.IOException;

/* compiled from: ChatONFileUtil.java */
/* renamed from: com.sec.chaton.util.r */
/* loaded from: classes.dex */
public class C3243r {

    /* renamed from: b */
    private static MediaScannerConnection f11722b;

    /* renamed from: c */
    private static String f11723c;

    /* renamed from: a */
    private static String f11721a = "ChatONFileUtil";

    /* renamed from: d */
    private static MediaScannerConnection.MediaScannerConnectionClient f11724d = new C3244s();

    /* renamed from: a */
    public static void m11417a() {
        File[] fileArrListFiles;
        try {
            File file = new File(CommonApplication.m11493l().getFilesDir().getAbsolutePath());
            if (file.exists() && (fileArrListFiles = file.listFiles()) != null) {
                for (File file2 : fileArrListFiles) {
                    if (file2.isDirectory()) {
                        m11418a(file2);
                        if (!file2.delete()) {
                            file2.delete();
                        }
                    }
                }
            }
        } catch (Exception e) {
            C3250y.m11443a(e, f11721a);
        }
    }

    /* renamed from: a */
    public static void m11419a(String str) {
        C3250y.m11450b("deleteDirectory path: " + str, f11721a);
        try {
            File file = new File(str);
            if (file.exists()) {
                m11418a(file);
                if (!file.delete()) {
                    file.delete();
                }
            }
        } catch (Exception e) {
            C3250y.m11443a(e, f11721a);
        }
    }

    /* renamed from: a */
    public static void m11418a(File file) {
        int length;
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles != null && (length = fileArrListFiles.length) > 0) {
            for (int i = 0; i < length; i++) {
                if (fileArrListFiles[i].isFile()) {
                    fileArrListFiles[i].delete();
                } else {
                    m11418a(fileArrListFiles[i]);
                    if (!fileArrListFiles[i].delete()) {
                        fileArrListFiles[i].delete();
                    }
                }
            }
        }
    }

    /* renamed from: b */
    public static boolean m11424b(File file) {
        return file != null && file.exists();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:122:0x00b7 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:130:0x00c6 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:132:0x0141 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:134:0x00c1 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:137:0x00bc A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:141:0x013c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:143:0x0137 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:145:0x0132 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r2v23 */
    /* JADX WARN: Type inference failed for: r2v27 */
    /* JADX WARN: Type inference failed for: r2v3, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r2v30 */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String m11415a(java.lang.String r9, java.lang.String r10, java.lang.String r11) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 485
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.util.C3243r.m11415a(java.lang.String, java.lang.String, java.lang.String):java.lang.String");
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x0068 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:112:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0077 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0072 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:98:0x006d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void m11420a(java.lang.String r9, java.lang.String r10) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 176
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.util.C3243r.m11420a(java.lang.String, java.lang.String):void");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:105:0x00da A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:10:0x001e  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00d8 A[PHI: r1 r2
  0x00d8: PHI (r1v10 java.io.FileOutputStream) = 
  (r1v15 java.io.FileOutputStream)
  (r1v5 java.io.FileOutputStream)
  (r1v20 java.io.FileOutputStream)
  (r1v21 java.io.FileOutputStream)
 binds: [B:16:0x0068, B:41:0x00d7, B:20:0x0074, B:22:0x007e] A[DONT_GENERATE, DONT_INLINE]
  0x00d8: PHI (r2v25 ??) = (r2v31 ?? I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]), (r2v21 ??), (r2v22 ??), (r2v23 ??) binds: [B:16:0x0068, B:41:0x00d7, B:20:0x0074, B:22:0x007e] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:73:0x016f  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x018f  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0068 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r2v12 */
    /* JADX WARN: Type inference failed for: r2v13 */
    /* JADX WARN: Type inference failed for: r2v14, types: [java.io.FileOutputStream] */
    /* JADX WARN: Type inference failed for: r2v17, types: [java.io.FileOutputStream] */
    /* JADX WARN: Type inference failed for: r2v21, types: [java.io.FileOutputStream, java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r2v22, types: [boolean] */
    /* JADX WARN: Type inference failed for: r2v23, types: [int] */
    /* JADX WARN: Type inference failed for: r2v25 */
    /* JADX WARN: Type inference failed for: r2v31 */
    /* JADX WARN: Type inference failed for: r3v11, types: [android.graphics.Bitmap] */
    /* JADX WARN: Type inference failed for: r3v15 */
    /* JADX WARN: Type inference failed for: r3v2 */
    /* JADX WARN: Type inference failed for: r3v9 */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static android.graphics.Bitmap m11414a(android.content.Context r8, java.io.File r9, boolean r10, boolean r11, boolean r12) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 402
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.util.C3243r.m11414a(android.content.Context, java.io.File, boolean, boolean, boolean):android.graphics.Bitmap");
    }

    /* renamed from: a */
    public static String m11416a(String str, String str2, String str3, boolean z, String str4, long j, EnumC1450r enumC1450r, String str5) {
        String strM10954a;
        String strM6538a;
        f11722b = new MediaScannerConnection(CommonApplication.m11493l(), f11724d);
        C1582j c1582jM6714a = new C1582j(EnumC3219cg.FILE, "/file").m6710a(EnumC1583k.GET).m6714a("uid", C3159aa.m10962a().m10979a("uid", ""));
        String str6 = "imei=" + C3171am.m11045a() + "&buddyid=" + str2 + "&filename=" + str3;
        String str7 = str6 + "&size=239";
        C3250y.m11450b("filedownLoadUrl:" + str6, f11721a);
        try {
            String strM11411a = GlobalApplication.m6453c().m11411a();
            if (!TextUtils.isEmpty(strM11411a)) {
                C3158a c3158a = new C3158a(C3158a.m10958b(strM11411a), C3158a.m10959c(strM11411a));
                if (z) {
                    strM10954a = C3158a.m10954a(c3158a.m10960b(str7.getBytes()));
                } else {
                    strM10954a = C3158a.m10954a(c3158a.m10960b(str6.getBytes()));
                }
                c1582jM6714a.m6714a("param", strM10954a);
                boolean zM11327a = C3223ck.m11327a();
                String absolutePath = zM11327a ? CommonApplication.m11493l().getExternalFilesDir(null).getAbsolutePath() : CommonApplication.m11493l().getFilesDir().getAbsolutePath();
                try {
                    String str8 = str + "?uid=" + C3159aa.m10962a().m10979a("uid", "") + "&param=" + strM10954a;
                    C3250y.m11450b("Donwload Url : " + str8, f11721a);
                    strM6538a = C1540a.m6538a(str8, absolutePath + "//" + str4 + "//", str3, z);
                    if (C3250y.f11734b) {
                        C3250y.m11450b("download result: " + strM6538a, f11721a);
                    }
                } catch (Exception e) {
                    C3250y.m11443a(e, f11721a);
                    strM6538a = C0816a.f3113b;
                }
                C1373q.m6161a(CommonApplication.m11493l().getContentResolver(), str5, str4, Long.valueOf(j), strM6538a, enumC1450r, zM11327a, z);
                return strM6538a;
            }
            C3250y.m11442a("Fail in getting a key", f11721a);
            C1373q.m6161a(CommonApplication.m11493l().getContentResolver(), str5, str4, Long.valueOf(j), C0816a.f3113b, enumC1450r, C3223ck.m11327a(), z);
            return C0816a.f3113b;
        } catch (Exception e2) {
            C3250y.m11443a(e2, f11721a);
            C1373q.m6161a(CommonApplication.m11493l().getContentResolver(), str5, str4, Long.valueOf(j), C0816a.f3113b, enumC1450r, C3223ck.m11327a(), z);
            return C0816a.f3113b;
        }
    }

    /* renamed from: b */
    public static String m11423b(String str) throws IllegalStateException, IOException, SecurityException, IllegalArgumentException {
        MediaPlayer mediaPlayer = new MediaPlayer();
        if (mediaPlayer != null) {
            try {
                mediaPlayer.reset();
                if (!TextUtils.isEmpty(str) && str.startsWith("file:")) {
                    str = Uri.parse(str).getPath();
                }
                mediaPlayer.setDataSource(str);
                mediaPlayer.prepare();
                int duration = mediaPlayer.getDuration() / 60000;
                int duration2 = (mediaPlayer.getDuration() / 1000) % 60;
                mediaPlayer.release();
                return String.format("0:00/%d:%02d", Integer.valueOf(duration), Integer.valueOf(duration2));
            } catch (IOException e) {
                C3250y.m11443a(e, f11721a);
            } catch (IllegalArgumentException e2) {
                C3250y.m11443a(e2, f11721a);
            } catch (IllegalStateException e3) {
                C3250y.m11443a(e3, f11721a);
            } catch (SecurityException e4) {
                C3250y.m11443a(e4, f11721a);
            }
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x002d A[RETURN, SYNTHETIC] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean m11421a(com.sec.chaton.p027e.EnumC1455w r3, java.lang.String r4) {
        /*
            r0 = 1
            int[] r1 = com.sec.chaton.util.C3245t.f11725a
            int r2 = r3.ordinal()
            r1 = r1[r2]
            switch(r1) {
                case 1: goto Ld;
                case 2: goto L2f;
                case 3: goto L40;
                case 4: goto L40;
                case 5: goto L49;
                default: goto Lc;
            }
        Lc:
            return r0
        Ld:
            java.lang.String r1 = "JPEG"
            boolean r1 = r1.equalsIgnoreCase(r4)
            if (r1 != 0) goto Lc
            java.lang.String r1 = "JPG"
            boolean r1 = r1.equalsIgnoreCase(r4)
            if (r1 != 0) goto Lc
            java.lang.String r1 = "PNG"
            boolean r1 = r1.equalsIgnoreCase(r4)
            if (r1 != 0) goto Lc
            java.lang.String r1 = "GIF"
            boolean r1 = r1.equalsIgnoreCase(r4)
            if (r1 != 0) goto Lc
        L2d:
            r0 = 0
            goto Lc
        L2f:
            java.lang.String r1 = "MP4"
            boolean r1 = r1.equalsIgnoreCase(r4)
            if (r1 != 0) goto Lc
            java.lang.String r1 = "3GP"
            boolean r1 = r1.equalsIgnoreCase(r4)
            if (r1 == 0) goto L2d
            goto Lc
        L40:
            com.sec.chaton.multimedia.doc.a r1 = com.sec.chaton.multimedia.doc.FileExplorerActivity.m7385b(r4)
            com.sec.chaton.multimedia.doc.a r2 = com.sec.chaton.multimedia.doc.EnumC1794a.UNKNOWN
            if (r1 == r2) goto L2d
            goto Lc
        L49:
            java.lang.String r1 = "3GP"
            boolean r1 = r1.equalsIgnoreCase(r4)
            if (r1 != 0) goto Lc
            java.lang.String r1 = "3GA"
            boolean r1 = r1.equalsIgnoreCase(r4)
            if (r1 != 0) goto Lc
            java.lang.String r1 = "M4A"
            boolean r1 = r1.equalsIgnoreCase(r4)
            if (r1 != 0) goto Lc
            java.lang.String r1 = "AMR"
            boolean r1 = r1.equalsIgnoreCase(r4)
            if (r1 == 0) goto L2d
            goto Lc
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.util.C3243r.m11421a(com.sec.chaton.e.w, java.lang.String):boolean");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:123:0x0126 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:127:0x0121 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:131:0x0151 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:133:0x0132 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:137:0x0156 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:157:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:158:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0124  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0137 A[Catch: IOException -> 0x0140, TryCatch #18 {IOException -> 0x0140, blocks: (B:70:0x0132, B:72:0x0137, B:74:0x013c), top: B:133:0x0132 }] */
    /* JADX WARN: Removed duplicated region for block: B:74:0x013c A[Catch: IOException -> 0x0140, TRY_LEAVE, TryCatch #18 {IOException -> 0x0140, blocks: (B:70:0x0132, B:72:0x0137, B:74:0x013c), top: B:133:0x0132 }] */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0154  */
    /* JADX WARN: Type inference failed for: r3v10 */
    /* JADX WARN: Type inference failed for: r3v11, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r3v3, types: [android.content.Context] */
    /* JADX WARN: Type inference failed for: r3v4 */
    /* JADX WARN: Type inference failed for: r3v5 */
    /* JADX WARN: Type inference failed for: r3v7, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r3v8, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r4v2, types: [boolean] */
    /* JADX WARN: Type inference failed for: r4v22, types: [boolean] */
    /* renamed from: c */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.sec.chaton.util.C3246u m11426c(java.lang.String r11) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 401
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.util.C3243r.m11426c(java.lang.String):com.sec.chaton.util.u");
    }
}
