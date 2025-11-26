package com.sec.common.util;

import android.content.Context;
import android.text.TextUtils;
import com.sec.common.C4996f;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* compiled from: IoUtils.java */
/* renamed from: com.sec.common.util.n */
/* loaded from: classes.dex */
public class C5048n {

    /* renamed from: a */
    private static final String f18386a = C5048n.class.getSimpleName();

    /* renamed from: a */
    public static File m19190a(Context context) {
        return m19191a(context, EnumC5050p.USE_BOTH_EXTERNAL_FIRST);
    }

    /* renamed from: a */
    public static File m19191a(Context context, EnumC5050p enumC5050p) {
        File filesDir;
        switch (enumC5050p) {
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
        if (!filesDir.exists() && !filesDir.mkdirs() && C4996f.f18229a.f18173e) {
            C4996f.f18229a.m18894h(f18386a, "Can't make directory. " + filesDir.getAbsolutePath());
        }
        return filesDir;
    }

    /* renamed from: b */
    public static File m19197b(Context context, EnumC5050p enumC5050p) {
        File cacheDir;
        switch (enumC5050p) {
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
        if (!cacheDir.exists() && !cacheDir.mkdirs() && C4996f.f18229a.f18173e) {
            C4996f.f18229a.m18894h(f18386a, "Can't make directory. " + cacheDir.getAbsolutePath());
        }
        return cacheDir;
    }

    /* renamed from: b */
    public static File m19196b(Context context) {
        return m19197b(context, EnumC5050p.USE_BOTH_EXTERNAL_FIRST);
    }

    /* renamed from: a */
    public static void m19193a(File file) {
        int length;
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles != null && (length = fileArrListFiles.length) > 0) {
            for (int i = 0; i < length; i++) {
                if (fileArrListFiles[i].isFile()) {
                    if (!fileArrListFiles[i].delete() && C4996f.f18229a.f18173e) {
                        C4996f.f18229a.m18894h(f18386a, "Can't delete directory. " + fileArrListFiles[i].getAbsolutePath());
                    }
                } else {
                    m19193a(fileArrListFiles[i]);
                    if (!fileArrListFiles[i].delete() && !fileArrListFiles[i].delete() && C4996f.f18229a.f18173e) {
                        C4996f.f18229a.m18894h(f18386a, "Can't delete directory. " + fileArrListFiles[i].getAbsolutePath());
                    }
                }
            }
        }
        file.delete();
    }

    /* renamed from: a */
    public static String m19192a(String str) {
        String[] strArrSplit;
        return (TextUtils.isEmpty(str) || (strArrSplit = str.split("\\.")) == null || strArrSplit.length == 0) ? str : strArrSplit[0];
    }

    /* renamed from: a */
    public static void m19194a(InputStream inputStream) throws IOException {
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException e) {
            }
        }
    }

    /* renamed from: a */
    public static void m19195a(OutputStream outputStream) throws IOException {
        if (outputStream != null) {
            try {
                outputStream.close();
            } catch (IOException e) {
            }
        }
    }
}
