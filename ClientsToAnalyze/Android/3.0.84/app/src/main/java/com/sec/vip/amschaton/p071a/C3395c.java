package com.sec.vip.amschaton.p071a;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import com.sec.chaton.util.C3250y;

/* compiled from: AMSEmoticonStampListDatabase.java */
/* renamed from: com.sec.vip.amschaton.a.c */
/* loaded from: classes.dex */
public class C3395c extends C3393a {
    public C3395c(Context context) {
        super(context);
    }

    /* renamed from: b */
    public C3395c m12102b() {
        super.m12097a("ams_emoticon_stamp_list");
        return this;
    }

    @Override // com.sec.vip.amschaton.p071a.C3393a
    /* renamed from: a */
    public void mo12098a() {
        super.mo12098a();
    }

    /* renamed from: a */
    public long m12100a(String str, String str2) {
        Cursor cursorM12105c;
        if (this.f12432c == null || !this.f12432c.isOpen() || this.f12432c.isReadOnly() || (cursorM12105c = m12105c(str)) == null) {
            return -1L;
        }
        if (cursorM12105c.getCount() > 0) {
            for (boolean zMoveToFirst = cursorM12105c.moveToFirst(); zMoveToFirst; zMoveToFirst = cursorM12105c.moveToNext()) {
                m12101a(Long.valueOf(cursorM12105c.getString(cursorM12105c.getColumnIndex("_id"))).longValue());
            }
        }
        cursorM12105c.close();
        Cursor cursorM12104c = m12104c();
        if (cursorM12104c == null) {
            return -1L;
        }
        if (cursorM12104c.getCount() >= 40) {
            for (boolean zMoveToPosition = cursorM12104c.moveToPosition(39); zMoveToPosition; zMoveToPosition = cursorM12104c.moveToNext()) {
                m12101a(Long.valueOf(cursorM12104c.getString(cursorM12104c.getColumnIndex("_id"))).longValue());
            }
        }
        cursorM12104c.close();
        ContentValues contentValues = new ContentValues();
        contentValues.put("ams_path", "");
        contentValues.put("ams_index", str);
        contentValues.put("ams_type", "");
        contentValues.put("ams_date", str2);
        return this.f12432c.insert("ams_emoticon_stamp_list", null, contentValues);
    }

    /* renamed from: a */
    public boolean m12101a(long j) {
        if (this.f12432c == null || !this.f12432c.isOpen() || this.f12432c.isReadOnly()) {
            return false;
        }
        C3250y.m11453c("Delete called value__" + j, getClass().getSimpleName());
        return this.f12432c.delete("ams_emoticon_stamp_list", "_id=?", new String[]{String.valueOf(j)}) > 0;
    }

    /* renamed from: b */
    public boolean m12103b(String str) {
        long jM12099d = m12099d(str);
        if (jM12099d < 0) {
            return false;
        }
        return m12101a(jM12099d);
    }

    /* renamed from: c */
    public Cursor m12104c() {
        if (this.f12432c != null && this.f12432c.isOpen()) {
            return this.f12432c.query("ams_emoticon_stamp_list", new String[]{"ams_path", "ams_index", "ams_type", "ams_date", "_id"}, null, null, null, null, "ams_date DESC");
        }
        return null;
    }

    /* renamed from: c */
    public Cursor m12105c(String str) {
        Cursor cursorQuery = null;
        if (this.f12432c != null && this.f12432c.isOpen() && (cursorQuery = this.f12432c.query("ams_emoticon_stamp_list", new String[]{"ams_path", "ams_index", "ams_type", "ams_date", "_id"}, "ams_index=?", new String[]{str}, null, null, null)) != null) {
            cursorQuery.moveToFirst();
        }
        return cursorQuery;
    }

    /* renamed from: d */
    private long m12099d(String str) {
        Cursor cursorQuery;
        if (this.f12432c != null && this.f12432c.isOpen() && (cursorQuery = this.f12432c.query("ams_emoticon_stamp_list", null, "ams_index=?", new String[]{String.valueOf(str)}, null, null, null)) != null && cursorQuery.getCount() == 1 && cursorQuery.moveToFirst()) {
            return Long.valueOf(cursorQuery.getString(cursorQuery.getColumnIndex("_id"))).longValue();
        }
        return -1L;
    }
}
