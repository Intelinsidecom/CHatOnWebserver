package com.sec.chaton.p027e.p028a;

import android.content.ContentProviderOperation;
import android.content.ContentValues;
import com.sec.chaton.p027e.C1403au;
import com.sec.chaton.p035io.entry.inner.MoreAppList;
import com.sec.chaton.settings2.PrefFragmentChats;

/* compiled from: MoreAppsDatabaseHelper.java */
/* renamed from: com.sec.chaton.e.a.t */
/* loaded from: classes.dex */
public class C1376t {
    /* renamed from: a */
    public static ContentProviderOperation m6199a(MoreAppList moreAppList) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("id", moreAppList.f5651id);
        contentValues.put("title", moreAppList.title);
        contentValues.put("priority", moreAppList.priority);
        contentValues.put(PrefFragmentChats.TYPE, moreAppList.type);
        contentValues.put("contenturl", moreAppList.contenturl);
        contentValues.put("appid", moreAppList.appid);
        contentValues.put("linkurl", moreAppList.linkurl);
        contentValues.put("samsungappsurl", moreAppList.samsungappsurl);
        contentValues.put("downloadurl", moreAppList.downloadurl);
        return ContentProviderOperation.newInsert(C1403au.f5215a).withValues(contentValues).build();
    }

    /* renamed from: a */
    public static ContentProviderOperation m6198a() {
        return ContentProviderOperation.newDelete(C1403au.f5215a).build();
    }
}
