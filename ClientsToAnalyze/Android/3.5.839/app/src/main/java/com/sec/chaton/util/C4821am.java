package com.sec.chaton.util;

import android.content.ContentProviderOperation;
import android.content.ContentProviderResult;
import android.content.Context;
import android.net.Uri;
import java.util.ArrayList;

/* compiled from: DatabaseUtils.java */
/* renamed from: com.sec.chaton.util.am */
/* loaded from: classes.dex */
public class C4821am {
    /* renamed from: a */
    public static ContentProviderResult[] m18190a(Context context, String str, ArrayList<ContentProviderOperation> arrayList) {
        return context.getContentResolver().applyBatch(str, arrayList);
    }

    /* renamed from: a */
    public static ContentProviderResult[] m18189a(Context context, String str, ContentProviderOperation contentProviderOperation) {
        ArrayList<ContentProviderOperation> arrayList = new ArrayList<>();
        arrayList.add(contentProviderOperation);
        return context.getContentResolver().applyBatch(str, arrayList);
    }

    /* renamed from: a */
    public static Uri m18188a(Uri uri) {
        return uri.buildUpon().appendQueryParameter("replace", Boolean.TRUE.toString()).build();
    }
}
