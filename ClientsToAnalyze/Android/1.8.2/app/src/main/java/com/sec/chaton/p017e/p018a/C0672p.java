package com.sec.chaton.p017e.p018a;

import android.content.Context;
import android.database.Cursor;
import com.sec.chaton.p017e.C0704s;

/* compiled from: SpecialBuddyDatabaseHelper.java */
/* renamed from: com.sec.chaton.e.a.p */
/* loaded from: classes.dex */
public class C0672p {
    /* renamed from: a */
    public static String m3094a(Context context, String str) {
        Cursor cursorQuery;
        if (str == null || context == null || (cursorQuery = context.getContentResolver().query(C0704s.f2647a, new String[]{"buddy_name"}, "buddy_no=?", new String[]{str}, null)) == null) {
            return null;
        }
        if (cursorQuery.getCount() <= 0 || !cursorQuery.moveToFirst()) {
            cursorQuery.close();
            return null;
        }
        String string = cursorQuery.getString(cursorQuery.getColumnIndex("buddy_name"));
        cursorQuery.close();
        return string;
    }

    /* renamed from: b */
    public static String m3095b(Context context, String str) {
        Cursor cursorQuery;
        if (str == null || context == null || (cursorQuery = context.getContentResolver().query(C0704s.f2647a, new String[]{"weburl"}, "buddy_no=?", new String[]{str}, null)) == null) {
            return null;
        }
        if (cursorQuery.getCount() <= 0 || !cursorQuery.moveToFirst()) {
            cursorQuery.close();
            return null;
        }
        String string = cursorQuery.getString(cursorQuery.getColumnIndex("weburl"));
        cursorQuery.close();
        return string;
    }

    /* renamed from: c */
    public static boolean m3096c(Context context, String str) {
        if (str == null || context == null) {
            return false;
        }
        Cursor cursorQuery = context.getContentResolver().query(C0704s.f2647a, new String[]{"buddy_no"}, "buddy_no=?", new String[]{str}, null);
        if (cursorQuery == null) {
            return false;
        }
        if (cursorQuery.getCount() <= 0 || !cursorQuery.moveToFirst()) {
            cursorQuery.close();
            return false;
        }
        cursorQuery.close();
        return true;
    }
}
