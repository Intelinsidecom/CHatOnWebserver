package com.sec.chaton.p017e.p018a;

import android.content.ContentProviderOperation;
import android.content.ContentResolver;
import com.sec.chaton.p017e.C0703r;

/* compiled from: RelationDatabaseHelper.java */
/* renamed from: com.sec.chaton.e.a.o */
/* loaded from: classes.dex */
public class C0671o {

    /* renamed from: a */
    private static final String[] f2558a = {"relation_buddy_id", "relation_date", "relation_send", "relation_received", "relation_point"};

    /* renamed from: a */
    public static ContentProviderOperation m3093a(ContentResolver contentResolver, String str, String str2, String str3, String str4, String str5, String str6) {
        ContentProviderOperation.Builder builderNewInsert = ContentProviderOperation.newInsert(C0703r.f2646a);
        builderNewInsert.withValue("relation_buddy_id", str);
        builderNewInsert.withValue("relation_date", str2);
        builderNewInsert.withValue("relation_point", str3);
        builderNewInsert.withValue("relation_send", str4);
        builderNewInsert.withValue("relation_received", str5);
        builderNewInsert.withValue("relation_rank", str6);
        return builderNewInsert.build();
    }
}
