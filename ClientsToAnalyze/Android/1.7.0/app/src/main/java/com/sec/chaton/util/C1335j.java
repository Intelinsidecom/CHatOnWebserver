package com.sec.chaton.util;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Environment;
import android.text.TextUtils;
import android.webkit.MimeTypeMap;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/* compiled from: ShareUtil.java */
/* renamed from: com.sec.chaton.util.j */
/* loaded from: classes.dex */
public class C1335j {
    /* renamed from: a */
    public static void m4617a(Context context, String str, String str2, String str3) {
        Intent intentM4619b = m4619b(context, str, str2, str3);
        if (intentM4619b != null) {
            context.startActivity(intentM4619b);
        }
    }

    /* renamed from: a */
    public static void m4616a(Context context, String str, Bitmap bitmap, String str2, String str3) {
        Intent intentM4618b = m4618b(context, str, bitmap, str2, str3);
        if (intentM4618b != null) {
            context.startActivity(intentM4618b);
        }
    }

    /* renamed from: b */
    public static Intent m4618b(Context context, String str, Bitmap bitmap, String str2, String str3) {
        return m4612a(context, str, m4614a(context, bitmap), str2, str3);
    }

    /* renamed from: a */
    public static Intent m4613a(Context context, String str, String str2, String str3, String str4) {
        return m4612a(context, str, m4615a(context, str2), str3, str4);
    }

    /* renamed from: b */
    public static Intent m4620b(Context context, String str, String str2, String str3, String str4) {
        Uri uriM4615a = m4615a(context, str2);
        if (uriM4615a == null) {
            return null;
        }
        Intent intentPutExtra = new Intent("android.intent.action.SEND").setType("video/*").putExtra("android.intent.extra.STREAM", uriM4615a);
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
    private static Intent m4619b(Context context, String str, String str2, String str3) {
        Intent intentPutExtra = new Intent("android.intent.action.SEND").setType("text/plain").putExtra("android.intent.extra.TEXT", str2);
        if (str3 != null) {
            intentPutExtra.putExtra("android.intent.extra.SUBJECT", str3);
        }
        intentPutExtra.putExtra("extra_from_chaton", true);
        return Intent.createChooser(intentPutExtra, str);
    }

    /* renamed from: a */
    private static Intent m4612a(Context context, String str, Uri uri, String str2, String str3) {
        String str4;
        if (uri == null) {
            return null;
        }
        String mimeTypeFromExtension = MimeTypeMap.getSingleton().getMimeTypeFromExtension(MimeTypeMap.getFileExtensionFromUrl(Uri.decode(uri.toString())));
        Intent intent = new Intent("android.intent.action.SEND");
        if (TextUtils.isEmpty(mimeTypeFromExtension)) {
            intent.setType("image/*");
        } else if (mimeTypeFromExtension.startsWith("image")) {
            intent.setType(mimeTypeFromExtension);
        } else {
            intent.setType("image/" + mimeTypeFromExtension);
        }
        intent.putExtra("android.intent.extra.STREAM", uri);
        if (str2 == null) {
            str4 = "www.chaton.com";
        } else {
            str4 = str2 + " www.chaton.com";
        }
        if (str4 != null) {
            intent.putExtra("android.intent.extra.TEXT", str4);
        }
        if (str3 != null) {
            intent.putExtra("android.intent.extra.SUBJECT", str3);
        }
        intent.putExtra("extra_from_chaton", true);
        return Intent.createChooser(intent, str);
    }

    /* renamed from: a */
    private static Uri m4614a(Context context, Bitmap bitmap) throws IOException {
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
    private static Uri m4615a(Context context, String str) {
        return Uri.fromFile(new File(str));
    }
}
