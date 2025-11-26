package com.sec.common.p056b;

import com.sec.common.p056b.p060d.C1828c;
import java.io.File;
import java.io.IOException;

/* compiled from: ZipUtil.java */
/* renamed from: com.sec.common.b.f */
/* loaded from: classes.dex */
public class C1838f {

    /* renamed from: a */
    private static final String f6575a = C1838f.class.getSimpleName();

    /* JADX WARN: Removed duplicated region for block: B:22:0x006a  */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.io.File m6232a(android.content.Context r8, java.io.File r9, java.io.File r10) throws java.lang.Throwable {
        /*
            r7 = 1024(0x400, float:1.435E-42)
            r2 = 0
            java.util.zip.ZipInputStream r1 = new java.util.zip.ZipInputStream     // Catch: java.lang.Throwable -> Lb0 java.lang.Throwable -> Lb3
            java.io.FileInputStream r0 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> Lb0 java.lang.Throwable -> Lb3
            r0.<init>(r9)     // Catch: java.lang.Throwable -> Lb0 java.lang.Throwable -> Lb3
            r1.<init>(r0)     // Catch: java.lang.Throwable -> Lb0 java.lang.Throwable -> Lb3
        Ld:
            java.util.zip.ZipEntry r0 = r1.getNextEntry()     // Catch: java.lang.Throwable -> L5b java.lang.Throwable -> L67
            if (r0 == 0) goto Laa
            com.sec.common.b.d.a r2 = com.sec.common.p056b.C1825d.f6539a     // Catch: java.lang.Throwable -> L9c
            boolean r2 = r2.f6541b     // Catch: java.lang.Throwable -> L9c
            if (r2 == 0) goto L43
            com.sec.common.b.d.a r2 = com.sec.common.p056b.C1825d.f6539a     // Catch: java.lang.Throwable -> L9c
            java.lang.String r3 = com.sec.common.p056b.C1838f.f6575a     // Catch: java.lang.Throwable -> L9c
            r4 = 4
            java.lang.Object[] r4 = new java.lang.Object[r4]     // Catch: java.lang.Throwable -> L9c
            r5 = 0
            java.lang.String r6 = "Unzip: "
            r4[r5] = r6     // Catch: java.lang.Throwable -> L9c
            r5 = 1
            java.lang.String r6 = r0.getName()     // Catch: java.lang.Throwable -> L9c
            r4[r5] = r6     // Catch: java.lang.Throwable -> L9c
            r5 = 2
            java.lang.String r6 = ", isDirectory: "
            r4[r5] = r6     // Catch: java.lang.Throwable -> L9c
            r5 = 3
            boolean r6 = r0.isDirectory()     // Catch: java.lang.Throwable -> L9c
            java.lang.Boolean r6 = java.lang.Boolean.valueOf(r6)     // Catch: java.lang.Throwable -> L9c
            r4[r5] = r6     // Catch: java.lang.Throwable -> L9c
            java.lang.String r4 = com.sec.common.p056b.p060d.C1828c.m6207a(r4)     // Catch: java.lang.Throwable -> L9c
            r2.m6200a(r3, r4)     // Catch: java.lang.Throwable -> L9c
        L43:
            boolean r2 = r0.isDirectory()     // Catch: java.lang.Throwable -> L9c
            if (r2 == 0) goto L6e
            java.io.File r2 = new java.io.File     // Catch: java.lang.Throwable -> L9c
            java.lang.String r0 = r0.getName()     // Catch: java.lang.Throwable -> L9c
            r2.<init>(r10, r0)     // Catch: java.lang.Throwable -> L9c
            m6233a(r2)     // Catch: java.lang.Throwable -> L9c
        L55:
            if (r1 == 0) goto Ld
            r1.closeEntry()     // Catch: java.lang.Throwable -> L5b java.lang.Throwable -> L67
            goto Ld
        L5b:
            r0 = move-exception
        L5c:
            if (r10 == 0) goto L61
            m6234b(r10)     // Catch: java.lang.Throwable -> L67
        L61:
            java.io.IOException r2 = new java.io.IOException     // Catch: java.lang.Throwable -> L67
            r2.<init>(r0)     // Catch: java.lang.Throwable -> L67
            throw r2     // Catch: java.lang.Throwable -> L67
        L67:
            r0 = move-exception
        L68:
            if (r1 == 0) goto L6d
            r1.close()
        L6d:
            throw r0
        L6e:
            java.io.File r2 = new java.io.File     // Catch: java.lang.Throwable -> L9c
            java.lang.String r0 = r0.getName()     // Catch: java.lang.Throwable -> L9c
            r2.<init>(r10, r0)     // Catch: java.lang.Throwable -> L9c
            java.io.File r0 = r2.getParentFile()     // Catch: java.lang.Throwable -> L9c
            m6233a(r0)     // Catch: java.lang.Throwable -> L9c
            java.io.FileOutputStream r0 = new java.io.FileOutputStream     // Catch: java.lang.Throwable -> L9c
            r0.<init>(r2)     // Catch: java.lang.Throwable -> L9c
            java.io.BufferedInputStream r2 = new java.io.BufferedInputStream     // Catch: java.lang.Throwable -> L9c
            r2.<init>(r1)     // Catch: java.lang.Throwable -> L9c
            java.io.BufferedOutputStream r3 = new java.io.BufferedOutputStream     // Catch: java.lang.Throwable -> L9c
            r3.<init>(r0)     // Catch: java.lang.Throwable -> L9c
            r0 = 1024(0x400, float:1.435E-42)
            byte[] r0 = new byte[r0]     // Catch: java.lang.Throwable -> L9c
        L91:
            int r4 = r2.read(r0)     // Catch: java.lang.Throwable -> L9c
            r5 = -1
            if (r4 != r5) goto La3
        L98:
            r3.close()     // Catch: java.lang.Throwable -> L9c
            goto L55
        L9c:
            r0 = move-exception
            if (r1 == 0) goto La2
            r1.closeEntry()     // Catch: java.lang.Throwable -> L5b java.lang.Throwable -> L67
        La2:
            throw r0     // Catch: java.lang.Throwable -> L5b java.lang.Throwable -> L67
        La3:
            r5 = 0
            r3.write(r0, r5, r4)     // Catch: java.lang.Throwable -> L9c
            if (r4 == r7) goto L91
            goto L98
        Laa:
            if (r1 == 0) goto Laf
            r1.close()
        Laf:
            return r10
        Lb0:
            r0 = move-exception
            r1 = r2
            goto L68
        Lb3:
            r0 = move-exception
            r1 = r2
            goto L5c
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.common.p056b.C1838f.m6232a(android.content.Context, java.io.File, java.io.File):java.io.File");
    }

    /* renamed from: a */
    private static void m6233a(File file) throws IOException {
        if (!file.exists() && !file.mkdirs()) {
            throw new IOException(C1828c.m6207a("Can't create directory."));
        }
    }

    /* renamed from: b */
    private static void m6234b(File file) {
        int length;
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles != null && (length = fileArrListFiles.length) > 0) {
            for (int i = 0; i < length; i++) {
                if (fileArrListFiles[i].isFile()) {
                    fileArrListFiles[i].delete();
                } else {
                    m6234b(fileArrListFiles[i]);
                    if (!fileArrListFiles[i].delete()) {
                        fileArrListFiles[i].delete();
                    }
                }
            }
        }
    }
}
