package com.sec.common.util;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.util.Log;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/* compiled from: ZipUtils.java */
/* renamed from: com.sec.common.util.u */
/* loaded from: classes.dex */
public class C5055u {

    /* renamed from: a */
    private static final String f18399a = C5055u.class.getSimpleName();

    /* renamed from: a */
    public static final Uri m19202a(Context context, File[] fileArr, File file) throws Throwable {
        ZipOutputStream zipOutputStream;
        FileInputStream fileInputStream;
        ZipOutputStream zipOutputStream2 = null;
        try {
            zipOutputStream = new ZipOutputStream(new FileOutputStream(file));
        } catch (Throwable th) {
            th = th;
        }
        try {
            byte[] bArr = new byte[1024];
            for (File file2 : fileArr) {
                Log.d(f18399a, String.format("Zip start: %s ", file2));
                if (!file2.exists()) {
                    Log.e(f18399a, String.format("Zip not exist: %s ", file2));
                    throw new FileNotFoundException(String.format("Couldn't find source file: %s", file2.getAbsolutePath()));
                }
                zipOutputStream.putNextEntry(new ZipEntry(file2.getName()));
                try {
                    fileInputStream = new FileInputStream(file2);
                    while (true) {
                        try {
                            int i = fileInputStream.read(bArr);
                            if (i <= 0) {
                                break;
                            }
                            zipOutputStream.write(bArr, 0, i);
                        } catch (Throwable th2) {
                            th = th2;
                            if (fileInputStream != null) {
                                fileInputStream.close();
                            }
                            throw th;
                        }
                    }
                    fileInputStream.close();
                    if (fileInputStream != null) {
                        fileInputStream.close();
                    }
                    zipOutputStream.closeEntry();
                    Log.d(f18399a, String.format("Zip end: %s, size: %s", file2, Long.valueOf(file2.length())));
                } catch (Throwable th3) {
                    th = th3;
                    fileInputStream = null;
                }
            }
            if (zipOutputStream != null) {
                zipOutputStream.close();
            }
            Log.d(f18399a, String.format("Zip result: %s, size: %s", file, Long.valueOf(file.length())));
            if (file.exists()) {
                return Uri.fromFile(file);
            }
            return null;
        } catch (Throwable th4) {
            th = th4;
            zipOutputStream2 = zipOutputStream;
            if (zipOutputStream2 != null) {
                zipOutputStream2.close();
            }
            throw th;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x00a5, code lost:
    
        throw new java.lang.InterruptedException("Unzip is interrupted.");
     */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00e7  */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.io.File m19203a(android.content.Context r12, java.io.File r13, java.io.File r14) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 257
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.common.util.C5055u.m19203a(android.content.Context, java.io.File, java.io.File):java.io.File");
    }

    /* renamed from: a */
    private static void m19204a(File file) throws IOException {
        if (file == null) {
            throw new IOException(C5052r.m19199a("Can't create directory. The directory is null."));
        }
        if (!file.exists() && !file.mkdirs()) {
            throw new IOException(C5052r.m19199a("Can't create directory."));
        }
    }

    /* renamed from: b */
    private static void m19206b(File file) {
        int length;
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles != null && (length = fileArrListFiles.length) > 0) {
            for (int i = 0; i < length; i++) {
                if (fileArrListFiles[i].isFile()) {
                    fileArrListFiles[i].delete();
                } else {
                    m19206b(fileArrListFiles[i]);
                    if (!fileArrListFiles[i].delete()) {
                        fileArrListFiles[i].delete();
                    }
                }
            }
        }
    }

    @SuppressLint({"NewApi"})
    /* renamed from: a */
    private static void m19205a(String str, Throwable th) throws IOException {
        if (Build.VERSION.SDK_INT <= 9) {
            throw new IOException(str);
        }
        throw new IOException(str, th);
    }
}
