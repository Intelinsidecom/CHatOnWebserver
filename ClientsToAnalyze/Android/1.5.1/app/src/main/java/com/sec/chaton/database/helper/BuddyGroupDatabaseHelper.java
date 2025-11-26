package com.sec.chaton.database.helper;

import android.content.ContentProviderOperation;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import com.sec.chaton.database.ChatONContract;
import com.sec.chaton.util.ChatONLogWriter;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
public class BuddyGroupDatabaseHelper {
    /* renamed from: a */
    public static ContentProviderOperation m2225a(String str) {
        ContentProviderOperation.Builder builderNewDelete = ContentProviderOperation.newDelete(ChatONContract.GroupRelationTable.f1715a);
        builderNewDelete.withSelection("group_relation_buddy = ?", new String[]{str});
        return builderNewDelete.build();
    }

    /* renamed from: a */
    public static void m2226a(ContentResolver contentResolver, int i, ArrayList arrayList) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("group_relation_group", Integer.valueOf(i));
        try {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                contentValues.put("group_relation_buddy", (String) it.next());
                contentResolver.insert(ChatONContract.GroupRelationTable.f1715a, contentValues);
            }
        } catch (Exception e) {
        }
    }

    /* renamed from: a */
    public static void m2227a(ContentResolver contentResolver, String str) {
        try {
            contentResolver.delete(ChatONContract.GroupRelationTable.f1715a, "group_relation_group = ? ", new String[]{str});
        } catch (Exception e) {
        }
    }

    /* renamed from: b */
    public static void m2228b(ContentResolver contentResolver, int i, ArrayList arrayList) {
        try {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                contentResolver.delete(ChatONContract.GroupRelationTable.f1715a, "group_relation_group = ? AND group_relation_buddy = ? ", new String[]{String.valueOf(i), (String) it.next()});
            }
        } catch (Exception e) {
        }
    }

    /* renamed from: b */
    public static void m2229b(ContentResolver contentResolver, String str) {
        try {
            contentResolver.delete(ChatONContract.GroupTable.f1716a, "_id = ? ", new String[]{str});
        } catch (Exception e) {
        }
    }

    /* renamed from: c */
    public static Uri m2230c(ContentResolver contentResolver, String str) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("group_name", str);
        try {
            return contentResolver.insert(ChatONContract.GroupTable.f1716a, contentValues);
        } catch (Exception e) {
            return null;
        }
    }

    /* renamed from: d */
    public static int m2231d(ContentResolver contentResolver, String str) {
        try {
            Cursor cursorQuery = contentResolver.query(ChatONContract.GroupTable.f1716a, null, "group_name = ? ", new String[]{str}, null);
            if (cursorQuery.getCount() == 1) {
                cursorQuery.moveToFirst();
                return cursorQuery.getInt(cursorQuery.getColumnIndex("_id"));
            }
        } catch (Exception e) {
            ChatONLogWriter.m3500a((Throwable) e);
        }
        return -1;
    }

    /* renamed from: e */
    public static int m2232e(ContentResolver contentResolver, String str) {
        try {
            return contentResolver.query(ChatONContract.GroupTable.f1716a, new String[]{"group_name"}, "group_name = ? ", new String[]{str}, null).getCount();
        } catch (Exception e) {
            return -1;
        }
    }
}
