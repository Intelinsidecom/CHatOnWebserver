package com.sec.chaton.trunk.p053e;

import android.net.Uri;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.util.C1767bw;
import com.sec.chaton.util.C1786r;
import java.io.File;

/* compiled from: FileUtil.java */
/* renamed from: com.sec.chaton.trunk.e.a */
/* loaded from: classes.dex */
public class C1592a {

    /* renamed from: a */
    private static final String f5707a = C1592a.class.getSimpleName();

    /* renamed from: a */
    public static Uri m5492a(String str) {
        if (new File(str).exists()) {
            return Uri.parse(str);
        }
        return null;
    }

    /* renamed from: a */
    public static String m5494a() {
        File filesDir = null;
        if (C1767bw.m6002a() && (filesDir = GlobalApplication.m3260b().getExternalFilesDir(null)) == null) {
            C1786r.m6065d("Storage is available but can't create external files directory.", f5707a);
        }
        if (filesDir == null) {
            filesDir = GlobalApplication.m3260b().getFilesDir();
        }
        return filesDir.getAbsolutePath();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:71:0x008a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0085 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r1v9, types: [java.io.BufferedOutputStream] */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v11, types: [int] */
    /* JADX WARN: Type inference failed for: r2v12 */
    /* JADX WARN: Type inference failed for: r2v13 */
    /* JADX WARN: Type inference failed for: r2v15 */
    /* JADX WARN: Type inference failed for: r2v2, types: [java.io.BufferedOutputStream] */
    /* JADX WARN: Type inference failed for: r2v3, types: [java.io.BufferedOutputStream] */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r2v8 */
    /* JADX WARN: Type inference failed for: r2v9 */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.io.File m5493a(java.io.File r5, java.io.File r6) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 205
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.trunk.p053e.C1592a.m5493a(java.io.File, java.io.File):java.io.File");
    }
}
