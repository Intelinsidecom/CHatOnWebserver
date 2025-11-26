package com.sec.chaton.p057e.p058a;

import android.content.ContentProviderOperation;
import android.content.ContentValues;
import com.sec.chaton.p057e.C2262bh;
import com.sec.chaton.p065io.entry.inner.MoreAppList;

/* compiled from: MoreAppsDatabaseHelper.java */
/* renamed from: com.sec.chaton.e.a.u */
/* loaded from: classes.dex */
public class C2207u {
    /* renamed from: a */
    public static ContentProviderOperation m10059a(MoreAppList moreAppList) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("id", moreAppList.f8573id);
        contentValues.put("title", moreAppList.title);
        contentValues.put("priority", moreAppList.priority);
        contentValues.put("type", moreAppList.type);
        contentValues.put("contenturl", moreAppList.contenturl);
        contentValues.put("appid", moreAppList.appid);
        contentValues.put("linkurl", moreAppList.linkurl);
        contentValues.put("samsungappsurl", moreAppList.samsungappsurl);
        contentValues.put("downloadurl", moreAppList.downloadurl);
        return ContentProviderOperation.newInsert(C2262bh.f8053a).withValues(contentValues).build();
    }

    /* renamed from: a */
    public static ContentProviderOperation m10058a() {
        return ContentProviderOperation.newDelete(C2262bh.f8053a).build();
    }
}
