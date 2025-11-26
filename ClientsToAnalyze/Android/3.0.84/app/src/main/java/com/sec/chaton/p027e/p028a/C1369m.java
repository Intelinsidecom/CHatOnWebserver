package com.sec.chaton.p027e.p028a;

import android.content.ContentProviderOperation;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import com.sec.chaton.p027e.C1401as;
import com.sec.chaton.p035io.entry.inner.FontFilter;
import com.sec.chaton.util.C3170al;
import java.util.ArrayList;

/* compiled from: FontFilterDatabaseHelper.java */
/* renamed from: com.sec.chaton.e.a.m */
/* loaded from: classes.dex */
public class C1369m extends C1366j {
    /* renamed from: a */
    public static ContentProviderOperation m6100a(FontFilter fontFilter) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("filter_id", fontFilter.f5644id);
        contentValues.put("filter_title", fontFilter.title);
        return ContentProviderOperation.newInsert(C3170al.m11041a(C1401as.f5214a)).withValues(contentValues).build();
    }

    /* renamed from: a */
    public static ArrayList<FontFilter> m6101a(Context context) {
        Cursor cursorQuery;
        ArrayList<FontFilter> arrayList = null;
        if (context != null && (cursorQuery = context.getContentResolver().query(C1401as.f5214a, null, null, null, "filter_title")) != null) {
            if (cursorQuery.getCount() <= 0 || !cursorQuery.moveToFirst()) {
                cursorQuery.close();
            } else {
                arrayList = new ArrayList<>();
                for (boolean zMoveToFirst = cursorQuery.moveToFirst(); zMoveToFirst; zMoveToFirst = cursorQuery.moveToNext()) {
                    FontFilter fontFilter = new FontFilter();
                    fontFilter.f5644id = Integer.valueOf(cursorQuery.getInt(cursorQuery.getColumnIndex("filter_id")));
                    fontFilter.title = cursorQuery.getString(cursorQuery.getColumnIndex("filter_title"));
                    arrayList.add(fontFilter);
                }
                cursorQuery.close();
            }
        }
        return arrayList;
    }
}
