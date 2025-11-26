package com.sec.chaton.util;

import android.graphics.BitmapFactory;
import com.sec.chaton.global.GlobalApplication;
import java.io.File;

/* compiled from: ImageFileUtils.java */
/* renamed from: com.sec.chaton.util.ao */
/* loaded from: classes.dex */
public class C1732ao {
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:18:0x0060 -> B:11:0x0054). Please report as a decompilation issue!!! */
    /* renamed from: a */
    public static boolean m5915a(File file) {
        BitmapFactory.Options options;
        boolean z = true;
        C1786r.m6061b("[ShouldBeResized]: " + file.getName(), GlobalApplication.m3260b().getClass().getName());
        if (file.length() <= 512000) {
            try {
                options = new BitmapFactory.Options();
                options.inJustDecodeBounds = true;
                BitmapFactory.decodeFile(file.getAbsolutePath(), options);
            } catch (Exception e) {
                C1786r.m6054a("Exception", GlobalApplication.m3260b().getClass().getName());
            }
            if (options.outWidth < options.outHeight ? !(options.outHeight > 1024 || options.outWidth > 768) : !(options.outWidth > 1024 || options.outHeight > 768)) {
                z = false;
            }
        }
        return z;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:117:0x029a  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x02ab  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x02e3  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x02f4  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x0354  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x0365  */
    /* JADX WARN: Removed duplicated region for block: B:227:0x04f9  */
    /* JADX WARN: Removed duplicated region for block: B:231:0x02e8 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:235:0x00bc A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:239:0x02ed A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:242:0x0359 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:246:0x00c1 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:252:0x035e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:258:0x029f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:260:0x02a4 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:266:0x0198 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:272:0x011b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x011e A[Catch: all -> 0x04b1, Exception -> 0x04c9, FileNotFoundException -> 0x04db, OutOfMemoryError -> 0x04ed, TryCatch #26 {FileNotFoundException -> 0x04db, Exception -> 0x04c9, OutOfMemoryError -> 0x04ed, all -> 0x04b1, blocks: (B:56:0x011b, B:57:0x011e, B:59:0x0124, B:60:0x0132, B:62:0x0138, B:63:0x0157, B:65:0x015d, B:66:0x0160, B:67:0x0180, B:69:0x0184, B:70:0x0188, B:71:0x0191, B:99:0x0238, B:102:0x023f, B:97:0x0219, B:96:0x020a), top: B:272:0x011b }] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0124 A[Catch: all -> 0x04b1, Exception -> 0x04c9, FileNotFoundException -> 0x04db, OutOfMemoryError -> 0x04ed, TryCatch #26 {FileNotFoundException -> 0x04db, Exception -> 0x04c9, OutOfMemoryError -> 0x04ed, all -> 0x04b1, blocks: (B:56:0x011b, B:57:0x011e, B:59:0x0124, B:60:0x0132, B:62:0x0138, B:63:0x0157, B:65:0x015d, B:66:0x0160, B:67:0x0180, B:69:0x0184, B:70:0x0188, B:71:0x0191, B:99:0x0238, B:102:0x023f, B:97:0x0219, B:96:0x020a), top: B:272:0x011b }] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0138 A[Catch: all -> 0x04b1, Exception -> 0x04c9, FileNotFoundException -> 0x04db, OutOfMemoryError -> 0x04ed, TryCatch #26 {FileNotFoundException -> 0x04db, Exception -> 0x04c9, OutOfMemoryError -> 0x04ed, all -> 0x04b1, blocks: (B:56:0x011b, B:57:0x011e, B:59:0x0124, B:60:0x0132, B:62:0x0138, B:63:0x0157, B:65:0x015d, B:66:0x0160, B:67:0x0180, B:69:0x0184, B:70:0x0188, B:71:0x0191, B:99:0x0238, B:102:0x023f, B:97:0x0219, B:96:0x020a), top: B:272:0x011b }] */
    /* JADX WARN: Removed duplicated region for block: B:65:0x015d A[Catch: all -> 0x04b1, Exception -> 0x04c9, FileNotFoundException -> 0x04db, OutOfMemoryError -> 0x04ed, TryCatch #26 {FileNotFoundException -> 0x04db, Exception -> 0x04c9, OutOfMemoryError -> 0x04ed, all -> 0x04b1, blocks: (B:56:0x011b, B:57:0x011e, B:59:0x0124, B:60:0x0132, B:62:0x0138, B:63:0x0157, B:65:0x015d, B:66:0x0160, B:67:0x0180, B:69:0x0184, B:70:0x0188, B:71:0x0191, B:99:0x0238, B:102:0x023f, B:97:0x0219, B:96:0x020a), top: B:272:0x011b }] */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0184 A[Catch: IOException -> 0x023e, all -> 0x04b1, Exception -> 0x04c9, FileNotFoundException -> 0x04db, OutOfMemoryError -> 0x04ed, TryCatch #18 {IOException -> 0x023e, blocks: (B:67:0x0180, B:69:0x0184, B:70:0x0188, B:99:0x0238), top: B:248:0x0180 }] */
    /* JADX WARN: Removed duplicated region for block: B:96:0x020a A[Catch: all -> 0x04b1, Exception -> 0x04c9, FileNotFoundException -> 0x04db, OutOfMemoryError -> 0x04ed, TRY_ENTER, TryCatch #26 {FileNotFoundException -> 0x04db, Exception -> 0x04c9, OutOfMemoryError -> 0x04ed, all -> 0x04b1, blocks: (B:56:0x011b, B:57:0x011e, B:59:0x0124, B:60:0x0132, B:62:0x0138, B:63:0x0157, B:65:0x015d, B:66:0x0160, B:67:0x0180, B:69:0x0184, B:70:0x0188, B:71:0x0191, B:99:0x0238, B:102:0x023f, B:97:0x0219, B:96:0x020a), top: B:272:0x011b }] */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0219 A[Catch: all -> 0x04b1, Exception -> 0x04c9, FileNotFoundException -> 0x04db, OutOfMemoryError -> 0x04ed, TRY_LEAVE, TryCatch #26 {FileNotFoundException -> 0x04db, Exception -> 0x04c9, OutOfMemoryError -> 0x04ed, all -> 0x04b1, blocks: (B:56:0x011b, B:57:0x011e, B:59:0x0124, B:60:0x0132, B:62:0x0138, B:63:0x0157, B:65:0x015d, B:66:0x0160, B:67:0x0180, B:69:0x0184, B:70:0x0188, B:71:0x0191, B:99:0x0238, B:102:0x023f, B:97:0x0219, B:96:0x020a), top: B:272:0x011b }] */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0238 A[Catch: IOException -> 0x023e, all -> 0x04b1, Exception -> 0x04c9, FileNotFoundException -> 0x04db, OutOfMemoryError -> 0x04ed, TRY_ENTER, TRY_LEAVE, TryCatch #18 {IOException -> 0x023e, blocks: (B:67:0x0180, B:69:0x0184, B:70:0x0188, B:99:0x0238), top: B:248:0x0180 }] */
    /* JADX WARN: Type inference failed for: r2v0, types: [android.graphics.Bitmap] */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v10 */
    /* JADX WARN: Type inference failed for: r2v11 */
    /* JADX WARN: Type inference failed for: r2v12 */
    /* JADX WARN: Type inference failed for: r2v13 */
    /* JADX WARN: Type inference failed for: r2v2, types: [java.io.FileOutputStream] */
    /* JADX WARN: Type inference failed for: r4v0 */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v10 */
    /* JADX WARN: Type inference failed for: r4v12 */
    /* JADX WARN: Type inference failed for: r4v13 */
    /* JADX WARN: Type inference failed for: r4v14 */
    /* JADX WARN: Type inference failed for: r4v16 */
    /* JADX WARN: Type inference failed for: r4v17 */
    /* JADX WARN: Type inference failed for: r4v21, types: [android.graphics.Bitmap] */
    /* JADX WARN: Type inference failed for: r4v3 */
    /* JADX WARN: Type inference failed for: r4v4 */
    /* JADX WARN: Type inference failed for: r4v5, types: [android.graphics.Bitmap] */
    /* JADX WARN: Type inference failed for: r4v7 */
    /* JADX WARN: Type inference failed for: r4v8, types: [android.graphics.Bitmap] */
    /* JADX WARN: Type inference failed for: r4v9, types: [android.graphics.Bitmap] */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r5v10, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r5v11, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r5v13 */
    /* JADX WARN: Type inference failed for: r5v14 */
    /* JADX WARN: Type inference failed for: r5v15 */
    /* JADX WARN: Type inference failed for: r5v17 */
    /* JADX WARN: Type inference failed for: r5v18, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r5v19 */
    /* JADX WARN: Type inference failed for: r5v2 */
    /* JADX WARN: Type inference failed for: r5v22, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r5v3 */
    /* JADX WARN: Type inference failed for: r5v4, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r5v6 */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.io.File m5914a(android.content.Context r12, java.io.File r13, java.lang.String r14, android.net.Uri r15) {
        /*
            Method dump skipped, instructions count: 1279
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.util.C1732ao.m5914a(android.content.Context, java.io.File, java.lang.String, android.net.Uri):java.io.File");
    }
}
