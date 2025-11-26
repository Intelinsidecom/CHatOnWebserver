package com.sec.common.util;

import android.content.Context;
import android.text.TextUtils;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* compiled from: IoUtils.java */
/* renamed from: com.sec.common.util.l */
/* loaded from: classes.dex */
public class C3350l {

    /* renamed from: a */
    private static final String f12083a = C3350l.class.getSimpleName();

    /* renamed from: a */
    public static File m11800a(Context context) {
        return m11801a(context, EnumC3363n.USE_BOTH_EXTERNAL_FIRST);
    }

    /* renamed from: a */
    public static File m11801a(Context context, EnumC3363n enumC3363n) {
        File filesDir;
        switch (enumC3363n) {
            case INTERNAL_ONLY:
                filesDir = context.getFilesDir();
                break;
            case USE_BOTH_EXTERNAL_FIRST:
            default:
                filesDir = context.getExternalFilesDir(null);
                if (filesDir == null) {
                    filesDir = context.getFilesDir();
                    break;
                }
                break;
            case USE_BOTH_INTERNAL_FIRST:
                filesDir = context.getFilesDir();
                if (filesDir == null) {
                    filesDir = context.getExternalFilesDir(null);
                    break;
                }
                break;
        }
        if (!filesDir.exists()) {
            filesDir.mkdirs();
        }
        return filesDir;
    }

    /* renamed from: b */
    public static File m11807b(Context context, EnumC3363n enumC3363n) {
        File cacheDir;
        switch (enumC3363n) {
            case INTERNAL_ONLY:
                cacheDir = context.getCacheDir();
                break;
            case USE_BOTH_EXTERNAL_FIRST:
            default:
                cacheDir = context.getExternalCacheDir();
                if (cacheDir == null) {
                    cacheDir = context.getCacheDir();
                    break;
                }
                break;
            case USE_BOTH_INTERNAL_FIRST:
                cacheDir = context.getCacheDir();
                if (cacheDir == null) {
                    cacheDir = context.getExternalCacheDir();
                    break;
                }
                break;
        }
        if (!cacheDir.exists()) {
            cacheDir.mkdirs();
        }
        return cacheDir;
    }

    /* renamed from: b */
    public static File m11806b(Context context) {
        return m11807b(context, EnumC3363n.USE_BOTH_EXTERNAL_FIRST);
    }

    /* renamed from: a */
    public static void m11803a(File file) {
        int length;
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles != null && (length = fileArrListFiles.length) > 0) {
            for (int i = 0; i < length; i++) {
                if (fileArrListFiles[i].isFile()) {
                    fileArrListFiles[i].delete();
                } else {
                    m11803a(fileArrListFiles[i]);
                    if (!fileArrListFiles[i].delete()) {
                        fileArrListFiles[i].delete();
                    }
                }
            }
        }
        file.delete();
    }

    /* renamed from: a */
    public static String m11802a(String str) {
        String[] strArrSplit;
        return (TextUtils.isEmpty(str) || (strArrSplit = str.split("\\.")) == null || strArrSplit.length == 0) ? str : strArrSplit[0];
    }

    /* renamed from: a */
    public static void m11804a(InputStream inputStream) throws IOException {
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException e) {
            }
        }
    }

    /* renamed from: a */
    public static void m11805a(OutputStream outputStream) throws IOException {
        if (outputStream != null) {
            try {
                outputStream.close();
            } catch (IOException e) {
            }
        }
    }
}
