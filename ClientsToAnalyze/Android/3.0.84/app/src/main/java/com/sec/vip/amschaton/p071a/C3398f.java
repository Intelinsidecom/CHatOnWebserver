package com.sec.vip.amschaton.p071a;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import com.sec.chaton.util.C3250y;
import java.io.File;

/* compiled from: AMSRecentTemplateDatabase.java */
/* renamed from: com.sec.vip.amschaton.a.f */
/* loaded from: classes.dex */
public class C3398f extends C3393a {
    public C3398f(Context context) {
        super(context);
    }

    /* renamed from: b */
    public C3398f m12126b() {
        super.m12097a("ams_recent_template");
        return this;
    }

    @Override // com.sec.vip.amschaton.p071a.C3393a
    /* renamed from: a */
    public void mo12098a() {
        super.mo12098a();
    }

    /* renamed from: a */
    public long m12123a(String str, String str2, String str3) {
        Cursor cursorM12129c;
        if (this.f12432c == null || !this.f12432c.isOpen() || this.f12432c.isReadOnly() || !new File(str).exists() || (cursorM12129c = m12129c(str)) == null) {
            return -1L;
        }
        if (cursorM12129c.getCount() > 0) {
            for (boolean zMoveToFirst = cursorM12129c.moveToFirst(); zMoveToFirst; zMoveToFirst = cursorM12129c.moveToNext()) {
                m12124a(Long.valueOf(cursorM12129c.getString(cursorM12129c.getColumnIndex("_id"))).longValue());
            }
        }
        cursorM12129c.close();
        Cursor cursorM12128c = m12128c();
        if (cursorM12128c == null) {
            return -1L;
        }
        if (cursorM12128c.getCount() >= 40) {
            for (boolean zMoveToPosition = cursorM12128c.moveToPosition(39); zMoveToPosition; zMoveToPosition = cursorM12128c.moveToNext()) {
                m12124a(Long.valueOf(cursorM12128c.getString(cursorM12128c.getColumnIndex("_id"))).longValue());
            }
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("ams_path", str);
        contentValues.put("ams_index", "");
        contentValues.put("ams_type", str2);
        contentValues.put("ams_date", str3);
        return this.f12432c.insert("ams_recent_template", null, contentValues);
    }

    /* renamed from: a */
    public boolean m12124a(long j) {
        if (this.f12432c == null || !this.f12432c.isOpen() || this.f12432c.isReadOnly()) {
            return false;
        }
        C3250y.m11453c("Delete called value__" + j, getClass().getSimpleName());
        return this.f12432c.delete("ams_recent_template", "_id=?", new String[]{String.valueOf(j)}) > 0;
    }

    /* renamed from: b */
    public boolean m12127b(String str) {
        long jM12122d = m12122d(str);
        if (jM12122d < 0) {
            return false;
        }
        return m12124a(jM12122d);
    }

    /* renamed from: c */
    public Cursor m12128c() {
        if (this.f12432c != null && this.f12432c.isOpen()) {
            return this.f12432c.query("ams_recent_template", new String[]{"ams_path", "ams_type", "ams_date", "_id"}, null, null, null, null, "ams_date DESC");
        }
        return null;
    }

    /* renamed from: b */
    public Cursor m12125b(long j) {
        Cursor cursorQuery = null;
        if (this.f12432c != null && this.f12432c.isOpen() && (cursorQuery = this.f12432c.query("ams_recent_template", new String[]{"ams_path", "ams_type", "ams_date", "_id"}, "_id=?", new String[]{String.valueOf(j)}, null, null, null)) != null) {
            cursorQuery.moveToFirst();
        }
        return cursorQuery;
    }

    /* renamed from: c */
    public Cursor m12129c(String str) {
        Cursor cursorQuery = null;
        if (this.f12432c != null && this.f12432c.isOpen() && (cursorQuery = this.f12432c.query("ams_recent_template", new String[]{"ams_path", "ams_type", "ams_date", "_id"}, "ams_path=?", new String[]{str}, null, null, null)) != null) {
            cursorQuery.moveToFirst();
        }
        return cursorQuery;
    }

    /* renamed from: d */
    private long m12122d(String str) {
        Cursor cursorQuery;
        if (this.f12432c != null && this.f12432c.isOpen() && (cursorQuery = this.f12432c.query("ams_recent_template", null, "ams_path=?", new String[]{str}, null, null, null)) != null && cursorQuery.getCount() == 1 && cursorQuery.moveToFirst()) {
            return Long.valueOf(cursorQuery.getString(cursorQuery.getColumnIndex("_id"))).longValue();
        }
        return -1L;
    }
}
