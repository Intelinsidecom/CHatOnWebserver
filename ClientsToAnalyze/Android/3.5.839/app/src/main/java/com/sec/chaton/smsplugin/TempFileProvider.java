package com.sec.chaton.smsplugin;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.Cursor;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import com.sec.chaton.smsplugin.p111h.C3890m;
import java.io.File;
import java.io.FileNotFoundException;

/* loaded from: classes.dex */
public class TempFileProvider extends ContentProvider {

    /* renamed from: b */
    private static String f13545b = "TempFileProvider";

    /* renamed from: a */
    public static final Uri f13544a = Uri.parse("content://smsplugin_temp_file/scrapSpace");

    /* renamed from: c */
    private static final UriMatcher f13546c = new UriMatcher(-1);

    static {
        f13546c.addURI("smsplugin_temp_file", "scrapSpace", 1);
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        return true;
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        return null;
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri uri, ContentValues contentValues) {
        return null;
    }

    @Override // android.content.ContentProvider
    public int delete(Uri uri, String str, String[] strArr) {
        return 0;
    }

    @Override // android.content.ContentProvider
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return 0;
    }

    /* renamed from: a */
    private ParcelFileDescriptor m14188a() throws FileNotFoundException {
        ParcelFileDescriptor parcelFileDescriptorOpen = null;
        String strM14189a = m14189a(getContext());
        try {
            File file = new File(strM14189a);
            File parentFile = file.getParentFile();
            if (parentFile != null && !parentFile.exists() && !parentFile.mkdirs()) {
                C3890m.m14999e(f13545b, "[TempFileProvider] tempStoreFd: " + parentFile.getPath() + "does not exist!");
            } else {
                parcelFileDescriptorOpen = ParcelFileDescriptor.open(file, 939524096);
            }
        } catch (Exception e) {
            C3890m.m14995a(f13545b, "getTempStoreFd: error creating pfd for " + strM14189a, e);
        }
        return parcelFileDescriptorOpen;
    }

    @Override // android.content.ContentProvider
    public String getType(Uri uri) {
        return "*/*";
    }

    @Override // android.content.ContentProvider
    public ParcelFileDescriptor openFile(Uri uri, String str) {
        int iMatch = f13546c.match(uri);
        if (C3890m.m15000f(f13545b, C3890m.f13993b)) {
            C3890m.m14996b(f13545b, "openFile: uri=" + uri + ", mode=" + str);
        }
        switch (iMatch) {
            case 1:
                return m14188a();
            default:
                return null;
        }
    }

    /* renamed from: a */
    public static String m14190a(Context context, String str) {
        return context.getExternalCacheDir().getAbsolutePath() + "/" + str;
    }

    /* renamed from: a */
    public static String m14189a(Context context) {
        return m14190a(context, ".temp.jpg");
    }

    /* renamed from: a */
    public static Uri m14187a(String str, String str2, Context context) {
        String strM14189a = m14189a(context);
        if (str2 == null) {
            str2 = "";
        }
        File file = new File(m14190a(context, ".temp" + str2 + str));
        File file2 = new File(strM14189a);
        if (!file.delete()) {
            C3890m.m14996b(f13545b, "delete fail, renameScrapFile()");
        }
        if (file2.renameTo(file)) {
            return Uri.fromFile(file);
        }
        return null;
    }
}
