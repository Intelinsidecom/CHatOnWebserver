package com.sec.chaton.multimedia.emoticon.p032b.p033a;

import android.content.ContentProviderOperation;
import android.content.ContentProviderResult;
import android.content.ContentValues;
import android.content.Context;
import android.net.Uri;
import com.sec.chaton.multimedia.emoticon.entry.inner.Anicon;
import com.sec.chaton.multimedia.emoticon.entry.inner.Package;
import com.sec.chaton.multimedia.emoticon.p032b.C0950e;
import com.sec.chaton.multimedia.emoticon.p032b.C0952g;
import com.sec.common.p056b.p060d.C1828c;
import java.util.ArrayList;

/* compiled from: AniconDatabaseHelper.java */
/* renamed from: com.sec.chaton.multimedia.emoticon.b.a.a */
/* loaded from: classes.dex */
public class C0946a {

    /* renamed from: a */
    private static final String f3512a = C0946a.class.getSimpleName();

    /* renamed from: a */
    public static ContentProviderResult[] m3813a(Context context, ArrayList arrayList) {
        return context.getContentResolver().applyBatch("com.sec.chaton.provider2", arrayList);
    }

    /* renamed from: a */
    public static ContentProviderResult[] m3812a(Context context, ContentProviderOperation contentProviderOperation) {
        ArrayList<ContentProviderOperation> arrayList = new ArrayList<>();
        arrayList.add(contentProviderOperation);
        return context.getContentResolver().applyBatch("com.sec.chaton.provider2", arrayList);
    }

    /* renamed from: a */
    public static ContentProviderOperation m3808a(Package r4) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("package_id", r4.f3539id);
        contentValues.put("category_id", r4.categoryid);
        contentValues.put("name", r4.name);
        contentValues.put("preview_url", r4.previewurl);
        contentValues.put("thumbnail_url", r4.thumbnailurl);
        contentValues.put("anicon_count", Integer.valueOf(r4.aniconcount));
        contentValues.put("volume", Long.valueOf(r4.volume));
        contentValues.put("special", Integer.valueOf(r4.special));
        contentValues.put("new", Integer.valueOf(r4._new));
        return ContentProviderOperation.newInsert(m3811a(C0952g.f3515a)).withValues(contentValues).build();
    }

    /* renamed from: a */
    public static ContentProviderOperation m3809a(String str) {
        return ContentProviderOperation.newDelete(C0952g.f3515a.buildUpon().appendPath(str).build()).build();
    }

    /* renamed from: a */
    public static ContentProviderOperation m3810a(String str, long j) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("install", Long.valueOf(j));
        return ContentProviderOperation.newUpdate(C0952g.f3515a.buildUpon().appendPath(str).build()).withValues(contentValues).build();
    }

    /* renamed from: b */
    public static ArrayList m3815b(String str) {
        ArrayList arrayList = new ArrayList();
        ContentValues contentValues = new ContentValues();
        contentValues.put("install", (Integer) 0);
        arrayList.add(ContentProviderOperation.newUpdate(C0952g.f3515a.buildUpon().appendPath(str).build()).withValues(contentValues).build());
        arrayList.add(ContentProviderOperation.newDelete(C0950e.f3514a).withSelection(C1828c.m6207a("package_id", "=?"), new String[]{str}).build());
        return arrayList;
    }

    /* renamed from: b */
    public static ContentProviderOperation m3814b(String str, long j) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("expiration_time", Long.valueOf(j));
        return ContentProviderOperation.newUpdate(C0952g.f3515a.buildUpon().appendPath(str).build()).withValues(contentValues).build();
    }

    /* renamed from: a */
    public static ContentProviderOperation m3807a(Anicon anicon) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("anicon_id", anicon.f3537id);
        contentValues.put("package_id", anicon.packageid);
        contentValues.put("zip_url", anicon.aniconzipurl);
        contentValues.put("delegate_url", anicon.delegateimage);
        contentValues.put("cd_proxy_url", anicon.cdproxyurl);
        return ContentProviderOperation.newInsert(m3811a(C0950e.f3514a)).withValues(contentValues).build();
    }

    /* renamed from: a */
    private static Uri m3811a(Uri uri) {
        return uri.buildUpon().appendQueryParameter("replace", Boolean.TRUE.toString()).build();
    }
}
