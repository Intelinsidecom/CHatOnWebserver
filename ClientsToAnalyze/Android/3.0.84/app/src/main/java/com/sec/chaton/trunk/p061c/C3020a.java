package com.sec.chaton.trunk.p061c;

import android.net.Uri;
import com.sec.chaton.util.C3223ck;
import com.sec.chaton.util.C3250y;
import com.sec.common.CommonApplication;
import java.io.File;

/* compiled from: FileUtil.java */
/* renamed from: com.sec.chaton.trunk.c.a */
/* loaded from: classes.dex */
public class C3020a {

    /* renamed from: a */
    private static final String f10897a = C3020a.class.getSimpleName();

    /* renamed from: a */
    public static Uri m10524a(String str) {
        if (new File(str).exists()) {
            return Uri.parse(str);
        }
        return null;
    }

    /* renamed from: a */
    public static String m10526a() {
        File filesDir = null;
        if (C3223ck.m11327a() && (filesDir = CommonApplication.m11493l().getExternalFilesDir(null)) == null) {
            C3250y.m11455d("Storage is available but can't create external files directory.", f10897a);
        }
        if (filesDir == null) {
            filesDir = CommonApplication.m11493l().getFilesDir();
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
    public static java.io.File m10525a(java.io.File r5, java.io.File r6) {
        /*
            Method dump skipped, instructions count: 205
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.trunk.p061c.C3020a.m10525a(java.io.File, java.io.File):java.io.File");
    }
}
