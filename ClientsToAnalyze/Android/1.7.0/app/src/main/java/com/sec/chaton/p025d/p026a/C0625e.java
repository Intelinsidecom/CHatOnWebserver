package com.sec.chaton.p025d.p026a;

import android.content.ContentProviderOperation;
import android.content.ContentResolver;
import android.content.ContentValues;
import com.sec.chaton.p025d.C0658k;
import com.sec.chaton.p025d.C0667t;

/* compiled from: RelationDatabaseHelper.java */
/* renamed from: com.sec.chaton.d.a.e */
/* loaded from: classes.dex */
public class C0625e {

    /* renamed from: a */
    private static final String[] f2190a = {"relation_buddy_id", "relation_date", "relation_send", "relation_received", "relation_point"};

    /* renamed from: a */
    public static ContentProviderOperation m2854a(ContentResolver contentResolver, String str, String str2, String str3, String str4, String str5, String str6) {
        ContentProviderOperation.Builder builderNewInsert = ContentProviderOperation.newInsert(C0658k.f2285a);
        builderNewInsert.withValue("relation_buddy_id", str);
        builderNewInsert.withValue("relation_date", str2);
        builderNewInsert.withValue("relation_point", str3);
        builderNewInsert.withValue("relation_send", str4);
        builderNewInsert.withValue("relation_received", str5);
        builderNewInsert.withValue("relation_rank", str6);
        return builderNewInsert.build();
    }

    /* renamed from: a */
    public static ContentProviderOperation m2855a(ContentResolver contentResolver, String str, boolean z) {
        ContentValues contentValues = new ContentValues();
        if (z) {
            contentValues.put("buddy_relation_hide", "Y");
        } else {
            contentValues.put("buddy_relation_hide", "N");
        }
        ContentProviderOperation.Builder builderNewUpdate = ContentProviderOperation.newUpdate(C0667t.f2310a);
        builderNewUpdate.withValues(contentValues);
        builderNewUpdate.withSelection("buddy_no = ? ", new String[]{str});
        return builderNewUpdate.build();
    }

    /* renamed from: a */
    public static ContentProviderOperation m2856a(ContentResolver contentResolver, boolean z) {
        ContentValues contentValues = new ContentValues();
        if (z) {
            contentValues.put("buddy_relation_hide", "Y");
        } else {
            contentValues.put("buddy_relation_hide", "N");
        }
        ContentProviderOperation.Builder builderNewUpdate = ContentProviderOperation.newUpdate(C0667t.f2310a);
        builderNewUpdate.withValues(contentValues);
        return builderNewUpdate.build();
    }
}
