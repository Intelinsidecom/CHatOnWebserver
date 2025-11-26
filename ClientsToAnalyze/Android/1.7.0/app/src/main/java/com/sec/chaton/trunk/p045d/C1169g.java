package com.sec.chaton.trunk.p045d;

import android.net.Uri;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.util.C1327bw;
import com.sec.chaton.util.C1341p;
import java.io.File;

/* compiled from: FileUtil.java */
/* renamed from: com.sec.chaton.trunk.d.g */
/* loaded from: classes.dex */
public class C1169g {

    /* renamed from: a */
    private static final String f4020a = C1169g.class.getSimpleName();

    /* renamed from: a */
    public static Uri m4214a(String str) {
        if (new File(str).exists()) {
            return Uri.parse(str);
        }
        return null;
    }

    /* renamed from: a */
    public static String m4216a() {
        File filesDir = null;
        if (C1327bw.m4595a() && (filesDir = GlobalApplication.m3100a().getExternalFilesDir(null)) == null) {
            C1341p.m4661d("Storage is available but can't create external files directory.", f4020a);
        }
        if (filesDir == null) {
            filesDir = GlobalApplication.m3100a().getFilesDir();
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
    public static java.io.File m4215a(java.io.File r5, java.io.File r6) {
        /*
            Method dump skipped, instructions count: 205
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.trunk.p045d.C1169g.m4215a(java.io.File, java.io.File):java.io.File");
    }
}
