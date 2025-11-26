package com.sec.chaton.p057e.p058a;

import android.content.ContentProviderOperation;
import android.content.ContentValues;
import android.database.Cursor;
import com.sec.chaton.p055d.EnumC2125f;
import com.sec.chaton.p057e.C2257bc;
import com.sec.chaton.p057e.EnumC2258bd;
import com.sec.chaton.settings.p096a.C3433a;
import com.sec.chaton.util.C4904y;
import com.sec.common.CommonApplication;
import java.io.IOException;

/* compiled from: DownloadItemDatabaseHelper.java */
/* renamed from: com.sec.chaton.e.a.j */
/* loaded from: classes.dex */
public class C2196j {
    /* renamed from: a */
    public static ContentProviderOperation m9898a(EnumC2258bd enumC2258bd, String str, long j) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("install", Long.valueOf(j));
        contentValues.put("newly_installed", Long.valueOf(j));
        return ContentProviderOperation.newUpdate(C2257bc.m10121a(enumC2258bd).buildUpon().appendPath(str).build()).withValues(contentValues).build();
    }

    /* renamed from: a */
    public static ContentProviderOperation m9897a(EnumC2258bd enumC2258bd, String str) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("install", (Integer) 0);
        contentValues.put("newly_installed", (Integer) 0);
        return ContentProviderOperation.newUpdate(C2257bc.m10121a(enumC2258bd).buildUpon().appendPath(str).build()).withValues(contentValues).build();
    }

    /* renamed from: a */
    public static ContentProviderOperation m9896a() {
        return ContentProviderOperation.newDelete(C2257bc.f8039a.buildUpon().appendEncodedPath("delete_not_installed_item").build()).build();
    }

    /* renamed from: b */
    public static void m9899b() throws Throwable {
        Cursor cursorQuery;
        try {
            cursorQuery = CommonApplication.m18732r().getContentResolver().query(C2257bc.f8039a.buildUpon().appendEncodedPath("ams_invalid").build(), null, null, null, null);
            if (cursorQuery != null) {
                while (cursorQuery.moveToNext()) {
                    try {
                        try {
                            C3433a.m13700b(CommonApplication.m18732r(), EnumC2125f.m9473a(EnumC2258bd.m10122a(cursorQuery.getString(cursorQuery.getColumnIndex("item_type")))), cursorQuery.getString(cursorQuery.getColumnIndex("item_id")));
                        } catch (IOException e) {
                            if (C4904y.f17875e) {
                                C4904y.m18635a(e, C2196j.class.getSimpleName());
                            }
                        }
                    } catch (Throwable th) {
                        th = th;
                        if (cursorQuery != null) {
                            cursorQuery.close();
                        }
                        throw th;
                    }
                }
            }
            if (cursorQuery != null) {
                cursorQuery.close();
            }
        } catch (Throwable th2) {
            th = th2;
            cursorQuery = null;
        }
    }
}
