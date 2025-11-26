package com.sec.chaton.util;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Environment;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/* compiled from: ShareUtil.java */
/* renamed from: com.sec.chaton.util.bv */
/* loaded from: classes.dex */
public class C1766bv {
    /* renamed from: a */
    public static void m5998a(Context context, String str, String str2, String str3) {
        Intent intentM6000b = m6000b(context, str, str2, str3);
        if (intentM6000b != null) {
            context.startActivity(intentM6000b);
        }
    }

    /* renamed from: a */
    public static void m5997a(Context context, String str, Bitmap bitmap, String str2, String str3) {
        Intent intentM5999b = m5999b(context, str, bitmap, str2, str3);
        if (intentM5999b != null) {
            context.startActivity(intentM5999b);
        }
    }

    /* renamed from: b */
    public static Intent m5999b(Context context, String str, Bitmap bitmap, String str2, String str3) {
        return m5993a(context, str, m5995a(context, bitmap), str2, str3);
    }

    /* renamed from: a */
    public static Intent m5994a(Context context, String str, String str2, String str3, String str4) {
        return m5993a(context, str, m5996a(context, str2), str3, str4);
    }

    /* renamed from: b */
    public static Intent m6001b(Context context, String str, String str2, String str3, String str4) {
        Uri uriM5996a = m5996a(context, str2);
        if (uriM5996a == null) {
            return null;
        }
        Intent intentPutExtra = new Intent("android.intent.action.SEND").setType("video/*").putExtra("android.intent.extra.STREAM", uriM5996a);
        if (str3 != null) {
            intentPutExtra.putExtra("android.intent.extra.TEXT", str3);
        }
        if (str4 != null) {
            intentPutExtra.putExtra("android.intent.extra.SUBJECT", str4);
        }
        intentPutExtra.putExtra("extra_from_chaton", true);
        return Intent.createChooser(intentPutExtra, str);
    }

    /* renamed from: b */
    private static Intent m6000b(Context context, String str, String str2, String str3) {
        Intent intentPutExtra = new Intent("android.intent.action.SEND").setType("text/plain").putExtra("android.intent.extra.TEXT", str2);
        if (str3 != null) {
            intentPutExtra.putExtra("android.intent.extra.SUBJECT", str3);
        }
        intentPutExtra.putExtra("extra_from_chaton", true);
        return Intent.createChooser(intentPutExtra, str);
    }

    /* renamed from: a */
    private static Intent m5993a(Context context, String str, Uri uri, String str2, String str3) {
        String str4;
        if (uri == null) {
            return null;
        }
        Intent intentPutExtra = new Intent("android.intent.action.SEND").setType("image/*").putExtra("android.intent.extra.STREAM", uri);
        if (str2 == null) {
            str4 = "www.chaton.com";
        } else {
            str4 = str2 + " www.chaton.com";
        }
        if (str4 != null) {
            intentPutExtra.putExtra("android.intent.extra.TEXT", str4);
        }
        if (str3 != null) {
            intentPutExtra.putExtra("android.intent.extra.SUBJECT", str3);
        }
        intentPutExtra.putExtra("extra_from_chaton", true);
        return Intent.createChooser(intentPutExtra, str);
    }

    /* renamed from: a */
    private static Uri m5995a(Context context, Bitmap bitmap) throws IOException {
        FileOutputStream fileOutputStreamOpenFileOutput;
        File fileStreamPath;
        File externalFilesDir;
        try {
            if (!"mounted".equals(Environment.getExternalStorageState()) || (externalFilesDir = context.getExternalFilesDir(null)) == null) {
                fileOutputStreamOpenFileOutput = null;
                fileStreamPath = null;
            } else {
                fileStreamPath = new File(externalFilesDir.getAbsolutePath() + "/temp_for_share.jpg");
                fileOutputStreamOpenFileOutput = new FileOutputStream(fileStreamPath);
            }
            if (fileStreamPath == null) {
                fileStreamPath = context.getFileStreamPath("temp_for_share.jpg");
                if (fileStreamPath == null) {
                    return null;
                }
                fileOutputStreamOpenFileOutput = context.openFileOutput("temp_for_share.jpg", 1);
            }
            bitmap.compress(Bitmap.CompressFormat.JPEG, 90, fileOutputStreamOpenFileOutput);
            try {
                fileOutputStreamOpenFileOutput.close();
                return Uri.fromFile(fileStreamPath);
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }
        } catch (FileNotFoundException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    /* renamed from: a */
    private static Uri m5996a(Context context, String str) {
        return Uri.fromFile(new File(str));
    }
}
