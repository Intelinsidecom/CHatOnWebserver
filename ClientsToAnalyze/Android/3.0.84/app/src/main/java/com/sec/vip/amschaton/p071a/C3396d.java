package com.sec.vip.amschaton.p071a;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import com.sec.chaton.util.C3250y;

/* compiled from: AMSRecentBackgroundDatabase.java */
/* renamed from: com.sec.vip.amschaton.a.d */
/* loaded from: classes.dex */
public class C3396d extends C3393a {
    public C3396d(Context context) {
        super(context);
    }

    /* renamed from: b */
    public C3396d m12110b() {
        super.m12097a("ams_recent_background");
        return this;
    }

    @Override // com.sec.vip.amschaton.p071a.C3393a
    /* renamed from: a */
    public void mo12098a() {
        super.mo12098a();
    }

    /* renamed from: a */
    public long m12107a(String str, String str2, String str3) {
        Cursor cursorM12113c;
        if (this.f12432c == null || !this.f12432c.isOpen() || this.f12432c.isReadOnly() || (cursorM12113c = m12113c(str)) == null) {
            return -1L;
        }
        if (cursorM12113c.getCount() > 0) {
            for (boolean zMoveToFirst = cursorM12113c.moveToFirst(); zMoveToFirst; zMoveToFirst = cursorM12113c.moveToNext()) {
                m12108a(Long.valueOf(cursorM12113c.getString(cursorM12113c.getColumnIndex("_id"))).longValue());
            }
        }
        cursorM12113c.close();
        Cursor cursorM12112c = m12112c();
        if (cursorM12112c == null) {
            return -1L;
        }
        if (cursorM12112c.getCount() >= 40) {
            for (boolean zMoveToPosition = cursorM12112c.moveToPosition(39); zMoveToPosition; zMoveToPosition = cursorM12112c.moveToNext()) {
                m12108a(Long.valueOf(cursorM12112c.getString(cursorM12112c.getColumnIndex("_id"))).longValue());
            }
        }
        cursorM12112c.close();
        ContentValues contentValues = new ContentValues();
        contentValues.put("ams_path", str2);
        contentValues.put("ams_index", str);
        contentValues.put("ams_type", "");
        contentValues.put("ams_date", str3);
        return this.f12432c.insert("ams_recent_background", null, contentValues);
    }

    /* renamed from: a */
    public boolean m12108a(long j) {
        if (this.f12432c == null || !this.f12432c.isOpen() || this.f12432c.isReadOnly()) {
            return false;
        }
        C3250y.m11453c("Delete called value__" + j, getClass().getSimpleName());
        return this.f12432c.delete("ams_recent_background", "_id=?", new String[]{String.valueOf(j)}) > 0;
    }

    /* renamed from: b */
    public boolean m12111b(String str) {
        long jM12106d = m12106d(str);
        if (jM12106d < 0) {
            return false;
        }
        return m12108a(jM12106d);
    }

    /* renamed from: c */
    public Cursor m12112c() {
        if (this.f12432c != null && this.f12432c.isOpen()) {
            return this.f12432c.query("ams_recent_background", new String[]{"ams_path", "ams_index", "ams_type", "ams_date", "_id"}, null, null, null, null, "ams_date DESC");
        }
        return null;
    }

    /* renamed from: b */
    public Cursor m12109b(long j) {
        Cursor cursorQuery = null;
        if (this.f12432c != null && this.f12432c.isOpen() && (cursorQuery = this.f12432c.query("ams_recent_background", new String[]{"ams_path", "ams_index", "ams_type", "ams_date", "_id"}, "_id=?", new String[]{String.valueOf(j)}, null, null, null)) != null) {
            cursorQuery.moveToFirst();
        }
        return cursorQuery;
    }

    /* renamed from: c */
    public Cursor m12113c(String str) {
        Cursor cursorQuery = null;
        if (this.f12432c != null && this.f12432c.isOpen() && (cursorQuery = this.f12432c.query("ams_recent_background", new String[]{"ams_path", "ams_index", "ams_type", "ams_date", "_id"}, "ams_index=?", new String[]{str}, null, null, null)) != null) {
            cursorQuery.moveToFirst();
        }
        return cursorQuery;
    }

    /* renamed from: d */
    private long m12106d(String str) {
        Cursor cursorQuery;
        if (this.f12432c != null && this.f12432c.isOpen() && (cursorQuery = this.f12432c.query("ams_recent_background", null, "ams_index=?", new String[]{String.valueOf(str)}, null, null, null)) != null && cursorQuery.getCount() == 1 && cursorQuery.moveToFirst()) {
            return Long.valueOf(cursorQuery.getString(cursorQuery.getColumnIndex("_id"))).longValue();
        }
        return -1L;
    }
}
