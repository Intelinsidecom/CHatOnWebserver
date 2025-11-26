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

/* loaded from: classes.dex */
public class ShareUtil {
    /* renamed from: a */
    private static Uri m3652a(Context context, Bitmap bitmap) throws IOException {
        FileOutputStream fileOutputStreamOpenFileOutput;
        File file;
        File externalFilesDir;
        try {
            if (!"mounted".equals(Environment.getExternalStorageState()) || (externalFilesDir = context.getExternalFilesDir(null)) == null) {
                fileOutputStreamOpenFileOutput = null;
                file = null;
            } else {
                file = new File(externalFilesDir.getAbsolutePath() + "/temp_for_share.jpg");
                fileOutputStreamOpenFileOutput = new FileOutputStream(file);
            }
            if (file == null) {
                File fileStreamPath = context.getFileStreamPath("temp_for_share.jpg");
                if (fileStreamPath == null) {
                    return null;
                }
                file = fileStreamPath;
                fileOutputStreamOpenFileOutput = context.openFileOutput("temp_for_share.jpg", 1);
            }
            bitmap.compress(Bitmap.CompressFormat.JPEG, 90, fileOutputStreamOpenFileOutput);
            try {
                fileOutputStreamOpenFileOutput.close();
                return Uri.fromFile(file);
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }
        } catch (FileNotFoundException e2) {
            e2.printStackTrace();
        }
    }

    /* renamed from: a */
    private static Uri m3653a(Context context, String str) {
        return Uri.fromFile(new File(str));
    }

    /* renamed from: a */
    public static void m3654a(Context context, String str, Bitmap bitmap, String str2, String str3) {
        m3655a(context, str, m3652a(context, bitmap), str2, str3);
    }

    /* renamed from: a */
    private static void m3655a(Context context, String str, Uri uri, String str2, String str3) {
        if (uri == null) {
            return;
        }
        Intent intentPutExtra = new Intent("android.intent.action.SEND").setType("image/*").putExtra("android.intent.extra.STREAM", uri);
        if (str2 != null) {
            intentPutExtra.putExtra("android.intent.extra.TEXT", str2);
        }
        if (str3 != null) {
            intentPutExtra.putExtra("android.intent.extra.SUBJECT", str3);
        }
        intentPutExtra.putExtra("extra_from_chaton", true);
        context.startActivity(Intent.createChooser(intentPutExtra, str));
    }

    /* renamed from: a */
    public static void m3656a(Context context, String str, String str2, String str3) {
        Intent intentPutExtra = new Intent("android.intent.action.SEND").setType("text/plain").putExtra("android.intent.extra.TEXT", str2);
        if (str3 != null) {
            intentPutExtra.putExtra("android.intent.extra.SUBJECT", str3);
        }
        intentPutExtra.putExtra("extra_from_chaton", true);
        context.startActivity(Intent.createChooser(intentPutExtra, str));
    }

    /* renamed from: a */
    public static void m3657a(Context context, String str, String str2, String str3, String str4) {
        m3655a(context, str, m3653a(context, str2), str3, str4);
    }

    /* renamed from: b */
    private static void m3658b(Context context, String str, Uri uri, String str2, String str3) {
        if (uri == null) {
            return;
        }
        Intent intentPutExtra = new Intent("android.intent.action.SEND").setType("video/*").putExtra("android.intent.extra.STREAM", uri);
        if (str2 != null) {
            intentPutExtra.putExtra("android.intent.extra.TEXT", str2);
        }
        if (str3 != null) {
            intentPutExtra.putExtra("android.intent.extra.SUBJECT", str3);
        }
        intentPutExtra.putExtra("extra_from_chaton", true);
        context.startActivity(Intent.createChooser(intentPutExtra, str));
    }

    /* renamed from: b */
    public static void m3659b(Context context, String str, String str2, String str3, String str4) {
        m3658b(context, str, m3653a(context, str2), str3, str4);
    }
}
