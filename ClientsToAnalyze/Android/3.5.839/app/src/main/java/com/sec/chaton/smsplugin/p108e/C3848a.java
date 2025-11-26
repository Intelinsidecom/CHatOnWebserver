package com.sec.chaton.smsplugin.p108e;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SqliteWrapper;
import android.net.Uri;
import com.sec.chaton.smsplugin.p111h.C3890m;
import java.io.IOException;
import java.io.OutputStream;

/* compiled from: DrmUtils.java */
/* renamed from: com.sec.chaton.smsplugin.e.a */
/* loaded from: classes.dex */
public class C3848a {

    /* renamed from: a */
    private static final Uri f13844a = Uri.parse("content://mms/drm");

    /* renamed from: a */
    public static void m14722a(Context context) {
        try {
            SqliteWrapper.delete(context, context.getContentResolver(), f13844a, (String) null, (String[]) null);
        } catch (RuntimeException e) {
            C3890m.m14995a("DrmUtils", e.getMessage(), e);
        }
    }

    /* renamed from: a */
    public static Uri m14721a(Context context, C3849b c3849b) throws IOException {
        ContentResolver contentResolver = context.getContentResolver();
        Uri uriInsert = SqliteWrapper.insert(context, contentResolver, f13844a, new ContentValues(0));
        OutputStream outputStreamOpenOutputStream = null;
        try {
            outputStreamOpenOutputStream = contentResolver.openOutputStream(uriInsert);
            byte[] bArrM14725a = c3849b.m14725a();
            if (bArrM14725a != null) {
                outputStreamOpenOutputStream.write(bArrM14725a);
            }
            return uriInsert;
        } finally {
            if (outputStreamOpenOutputStream != null) {
                try {
                    outputStreamOpenOutputStream.close();
                } catch (IOException e) {
                    C3890m.m14995a("DrmUtils", e.getMessage(), e);
                }
            }
        }
    }
}
