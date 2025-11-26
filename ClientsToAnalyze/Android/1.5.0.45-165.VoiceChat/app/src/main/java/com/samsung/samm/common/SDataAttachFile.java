package com.samsung.samm.common;

import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.Log;
import android.webkit.MimeTypeMap;
import android.widget.Toast;
import com.samsung.samm.lib.p003a.C0903q;
import java.util.List;

/* loaded from: classes.dex */
public class SDataAttachFile {

    /* renamed from: a */
    private String f404a = null;

    /* renamed from: b */
    private String f405b = null;

    /* renamed from: c */
    private Bitmap f406c = null;

    /* renamed from: d */
    private int f407d = 0;

    public void setFileData(String str, String str2) {
        setFilePath(str);
        setFileDescription(str2);
    }

    public String getFilePath() {
        return this.f404a;
    }

    public void setFilePath(String str) {
        this.f404a = str;
    }

    public String getFileDescription() {
        return this.f405b;
    }

    public void setFileDescription(String str) {
        this.f405b = str;
    }

    public Bitmap getFileIconBitmap() {
        return this.f406c;
    }

    public boolean setFileIcon(Bitmap bitmap) {
        this.f406c = bitmap;
        return this.f406c != null;
    }

    /* renamed from: a */
    boolean m146a(Drawable drawable) {
        this.f406c = m148b(drawable);
        return this.f406c != null;
    }

    public boolean setFileIcon(Context context, String str) {
        if (context == null) {
            Log.w("SAMMLibrary", "Context is null");
            return false;
        }
        if (str == null) {
            Log.w("SAMMLibrary", "Package Name is null");
            return false;
        }
        PackageManager packageManager = context.getPackageManager();
        if (packageManager == null) {
            Log.w("SAMMLibrary", "PackageManager is null");
            return false;
        }
        Intent launchIntentForPackage = packageManager.getLaunchIntentForPackage(str);
        if (launchIntentForPackage == null) {
            return false;
        }
        List<ResolveInfo> listQueryIntentActivities = packageManager.queryIntentActivities(launchIntentForPackage, 0);
        if (!(listQueryIntentActivities != null && listQueryIntentActivities.size() > 0)) {
            Log.w("SAMMLibrary", "There is no Launch activity for package " + str);
            return false;
        }
        ComponentName component = launchIntentForPackage.getComponent();
        if (component == null) {
            return false;
        }
        ComponentName componentName = new ComponentName(str, component.getClassName());
        Intent intent = new Intent();
        intent.setComponent(componentName);
        intent.setFlags((intent.getFlags() & (-2097153)) | 268435456);
        intent.addCategory("android.intent.category.DEFAULT");
        ResolveInfo resolveInfoResolveActivity = packageManager.resolveActivity(intent, 65536);
        if (resolveInfoResolveActivity != null) {
            return m146a(resolveInfoResolveActivity.activityInfo.loadIcon(packageManager));
        }
        Log.w("SAMMLibrary", "Error to resolveActivity for package " + str);
        return false;
    }

    public boolean isInternalFile() {
        return m147a(this.f404a);
    }

    /* renamed from: a */
    boolean m147a(String str) {
        if (str == null) {
            Log.e("SAMMLibrary", "File Path is NULL");
            return false;
        }
        int length = "/data/data/".length();
        return str.length() >= length && str.substring(0, length).equals("/data/data/");
    }

    public String copyAttachedFile(String str) {
        if (str == null) {
            Log.e("SAMMLibrary", "Save path is null");
            return null;
        }
        if (this.f404a == null) {
            Log.e("SAMMLibrary", "There is no file path");
            return null;
        }
        String strM594b = C0903q.m594b(this.f404a);
        if (strM594b == null) {
            Log.e("SAMMLibrary", "There is no file name");
            return null;
        }
        String str2 = String.valueOf(str) + "/attached_" + strM594b;
        if (C0903q.m590a(this.f404a, str2, true)) {
            return str2;
        }
        Log.e("SAMMLibrary", "Copy file to the temp path is fail");
        return null;
    }

    @Deprecated
    public boolean viewAttachFile(Context context, String str) {
        return viewAttachedFile(context, str);
    }

    public boolean viewAttachedFile(Context context, String str) {
        String strCopyAttachedFile;
        if (this.f404a == null) {
            Log.e("SAMMLibrary", "File Path is NULL");
            return false;
        }
        if (isInternalFile()) {
            if (m147a(str)) {
                return false;
            }
            strCopyAttachedFile = copyAttachedFile(str);
            if (strCopyAttachedFile == null) {
                return false;
            }
        } else {
            Log.w("SAMMLibrary", "Only attached file of internal storage(decoded file) needs the external savePath");
            strCopyAttachedFile = this.f404a;
        }
        return m145a(context, strCopyAttachedFile);
    }

    /* renamed from: a */
    boolean m145a(Context context, String str) {
        if (str == null) {
            return false;
        }
        Uri uri = Uri.parse("file://" + str);
        if (uri == null) {
            Log.w("SAMMLibrary", "fileUri is null");
            return false;
        }
        String lowerCase = str.substring(str.lastIndexOf(".") + 1).toLowerCase();
        MimeTypeMap singleton = MimeTypeMap.getSingleton();
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setDataAndType(uri, singleton.getMimeTypeFromExtension(lowerCase));
        intent.setFlags(268435456);
        try {
            context.startActivity(intent);
            return true;
        } catch (ActivityNotFoundException e) {
            Toast.makeText(context, "No handler for this type of file.", 1).show();
            return false;
        }
    }

    /* renamed from: b */
    Bitmap m148b(Drawable drawable) {
        if (drawable == null) {
            return null;
        }
        int minimumWidth = drawable.getMinimumWidth();
        int minimumHeight = drawable.getMinimumHeight();
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(minimumWidth, minimumHeight, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        drawable.setBounds(0, 0, minimumWidth, minimumHeight);
        drawable.draw(canvas);
        return bitmapCreateBitmap;
    }
}
