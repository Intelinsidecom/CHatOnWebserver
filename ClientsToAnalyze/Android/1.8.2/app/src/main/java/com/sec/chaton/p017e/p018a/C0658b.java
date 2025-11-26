package com.sec.chaton.p017e.p018a;

import android.content.ContentProviderOperation;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import com.sec.chaton.p017e.C0691f;
import com.sec.chaton.p017e.C0692g;
import com.sec.chaton.util.C1786r;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: BuddyGroupDatabaseHelper.java */
/* renamed from: com.sec.chaton.e.a.b */
/* loaded from: classes.dex */
public class C0658b {
    /* renamed from: a */
    public static void m2991a(ContentResolver contentResolver, String str) {
        try {
            contentResolver.delete(C0691f.f2613a, "group_relation_group = ? ", new String[]{str});
        } catch (Exception e) {
        }
    }

    /* renamed from: b */
    public static void m2994b(ContentResolver contentResolver, String str) {
        try {
            contentResolver.delete(C0692g.f2614a, "_id = ? ", new String[]{str});
        } catch (Exception e) {
        }
    }

    /* renamed from: c */
    public static Uri m2995c(ContentResolver contentResolver, String str) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("group_name", str);
        try {
            return contentResolver.insert(C0692g.f2614a, contentValues);
        } catch (Exception e) {
            return null;
        }
    }

    /* renamed from: d */
    public static int m2996d(ContentResolver contentResolver, String str) {
        try {
            Cursor cursorQuery = contentResolver.query(C0692g.f2614a, null, "group_name = ? ", new String[]{str}, null);
            if (cursorQuery.getCount() == 1) {
                cursorQuery.moveToFirst();
                return cursorQuery.getInt(cursorQuery.getColumnIndex("_id"));
            }
        } catch (Exception e) {
            C1786r.m6055a((Throwable) e);
        }
        return -1;
    }

    /* renamed from: a */
    public static void m2990a(ContentResolver contentResolver, int i, ArrayList arrayList) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("group_relation_group", Integer.valueOf(i));
        try {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                contentValues.put("group_relation_buddy", (String) it.next());
                contentResolver.insert(C0691f.f2613a, contentValues);
            }
        } catch (Exception e) {
        }
    }

    /* renamed from: a */
    public static ContentProviderOperation m2988a(ContentResolver contentResolver, int i, String str) {
        ContentProviderOperation.Builder builderNewInsert = ContentProviderOperation.newInsert(C0691f.f2613a);
        builderNewInsert.withValue("group_relation_group", Integer.valueOf(i));
        builderNewInsert.withValue("group_relation_buddy", str);
        return builderNewInsert.build();
    }

    /* renamed from: b */
    public static void m2993b(ContentResolver contentResolver, int i, ArrayList arrayList) {
        try {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                contentResolver.delete(C0691f.f2613a, "group_relation_group = ? AND group_relation_buddy = ? ", new String[]{String.valueOf(i), (String) it.next()});
            }
        } catch (Exception e) {
        }
    }

    /* renamed from: e */
    public static int m2997e(ContentResolver contentResolver, String str) {
        try {
            return contentResolver.query(C0692g.f2614a, new String[]{"group_name"}, "group_name = ? AND group_type != 1", new String[]{str}, null).getCount();
        } catch (Exception e) {
            return -1;
        }
    }

    /* renamed from: b */
    public static int m2992b(ContentResolver contentResolver, int i, String str) {
        try {
            return contentResolver.query(C0692g.f2614a, new String[]{"group_name"}, "group_name = ? AND _id != ? AND group_type != 1", new String[]{str, String.valueOf(i)}, null).getCount();
        } catch (Exception e) {
            return -1;
        }
    }

    /* renamed from: a */
    public static ContentProviderOperation m2989a(String str) {
        ContentProviderOperation.Builder builderNewDelete = ContentProviderOperation.newDelete(C0691f.f2613a);
        builderNewDelete.withSelection("group_relation_buddy = ?", new String[]{str});
        return builderNewDelete.build();
    }

    /* renamed from: a */
    public static int m2987a(ContentResolver contentResolver, String str, String str2) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("group_name", str2);
        try {
            return contentResolver.update(C0692g.f2614a, contentValues, "_id = ? ", new String[]{str});
        } catch (Exception e) {
            return 0;
        }
    }
}
