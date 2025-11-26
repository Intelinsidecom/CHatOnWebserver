package com.sec.chaton.multimedia.skin.p037b.p038a;

import android.content.ContentProviderOperation;
import android.content.ContentProviderResult;
import android.content.ContentValues;
import android.content.Context;
import android.net.Uri;
import com.sec.chaton.multimedia.skin.entry.inner.Skin;
import com.sec.chaton.multimedia.skin.p037b.C1002c;
import java.util.ArrayList;

/* compiled from: SkinDatabaseHelper.java */
/* renamed from: com.sec.chaton.multimedia.skin.b.a.a */
/* loaded from: classes.dex */
public class C1000a {
    /* renamed from: a */
    public static ContentProviderResult[] m3934a(Context context, ArrayList arrayList) {
        return context.getContentResolver().applyBatch("com.sec.chaton.provider2", arrayList);
    }

    /* renamed from: a */
    public static ContentProviderResult[] m3933a(Context context, ContentProviderOperation contentProviderOperation) {
        ArrayList<ContentProviderOperation> arrayList = new ArrayList<>();
        arrayList.add(contentProviderOperation);
        return context.getContentResolver().applyBatch("com.sec.chaton.provider2", arrayList);
    }

    /* renamed from: a */
    public static ContentProviderOperation m3929a(Skin skin) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("skin_id", skin.f3707id);
        contentValues.put("special", Integer.valueOf(skin.special));
        contentValues.put("thumbnail_url", skin.thumbnailurl);
        contentValues.put("bg_type", skin.bgtype);
        contentValues.put("expiration_date", Long.valueOf(skin.expirationdate));
        contentValues.put("new", Boolean.valueOf(skin.newitem));
        return ContentProviderOperation.newInsert(m3932a(C1002c.f3694a)).withValues(contentValues).build();
    }

    /* renamed from: a */
    public static ContentProviderOperation m3931a(String str, long j) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("install", Long.valueOf(j));
        return ContentProviderOperation.newUpdate(C1002c.f3694a.buildUpon().appendPath(str).build()).withValues(contentValues).build();
    }

    /* renamed from: a */
    public static ContentProviderOperation m3930a(String str) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("install", (Integer) 0);
        return ContentProviderOperation.newUpdate(C1002c.f3694a.buildUpon().appendPath(str).build()).withValues(contentValues).build();
    }

    /* renamed from: a */
    private static Uri m3932a(Uri uri) {
        return uri.buildUpon().appendQueryParameter("replace", Boolean.TRUE.toString()).build();
    }
}
