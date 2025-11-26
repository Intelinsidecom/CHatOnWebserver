package com.sec.vip.amschaton.p071a;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import com.sec.chaton.util.C3250y;

/* compiled from: AMSRecentStampDatabase.java */
/* renamed from: com.sec.vip.amschaton.a.e */
/* loaded from: classes.dex */
public class C3397e extends C3393a {
    public C3397e(Context context) {
        super(context);
    }

    /* renamed from: b */
    public C3397e m12118b() {
        super.m12097a("ams_recent_stamp");
        return this;
    }

    @Override // com.sec.vip.amschaton.p071a.C3393a
    /* renamed from: a */
    public void mo12098a() {
        super.mo12098a();
    }

    /* renamed from: a */
    public long m12115a(String str, String str2, String str3) {
        Cursor cursorM12121c;
        if (this.f12432c == null || !this.f12432c.isOpen() || this.f12432c.isReadOnly() || (cursorM12121c = m12121c(str)) == null) {
            return -1L;
        }
        if (cursorM12121c.getCount() > 0) {
            for (boolean zMoveToFirst = cursorM12121c.moveToFirst(); zMoveToFirst; zMoveToFirst = cursorM12121c.moveToNext()) {
                m12116a(Long.valueOf(cursorM12121c.getString(cursorM12121c.getColumnIndex("_id"))).longValue());
            }
        }
        cursorM12121c.close();
        Cursor cursorM12120c = m12120c();
        if (cursorM12120c == null) {
            return -1L;
        }
        if (cursorM12120c.getCount() >= 40) {
            for (boolean zMoveToPosition = cursorM12120c.moveToPosition(39); zMoveToPosition; zMoveToPosition = cursorM12120c.moveToNext()) {
                m12116a(Long.valueOf(cursorM12120c.getString(cursorM12120c.getColumnIndex("_id"))).longValue());
            }
        }
        cursorM12120c.close();
        ContentValues contentValues = new ContentValues();
        contentValues.put("ams_path", str2);
        contentValues.put("ams_index", str);
        contentValues.put("ams_type", "");
        contentValues.put("ams_date", str3);
        return this.f12432c.insert("ams_recent_stamp", null, contentValues);
    }

    /* renamed from: a */
    public boolean m12116a(long j) {
        if (this.f12432c == null || !this.f12432c.isOpen() || this.f12432c.isReadOnly()) {
            return false;
        }
        C3250y.m11453c("Delete called value__" + j, getClass().getSimpleName());
        return this.f12432c.delete("ams_recent_stamp", "_id=?", new String[]{String.valueOf(j)}) > 0;
    }

    /* renamed from: b */
    public boolean m12119b(String str) {
        long jM12114d = m12114d(str);
        if (jM12114d < 0) {
            return false;
        }
        return m12116a(jM12114d);
    }

    /* renamed from: c */
    public Cursor m12120c() {
        if (this.f12432c != null && this.f12432c.isOpen()) {
            return this.f12432c.query("ams_recent_stamp", new String[]{"ams_path", "ams_index", "ams_type", "ams_date", "_id"}, null, null, null, null, "ams_date DESC");
        }
        return null;
    }

    /* renamed from: b */
    public Cursor m12117b(long j) {
        Cursor cursorQuery = null;
        if (this.f12432c != null && this.f12432c.isOpen() && (cursorQuery = this.f12432c.query("ams_recent_stamp", new String[]{"ams_path", "ams_index", "ams_type", "ams_date", "_id"}, "_id=?", new String[]{String.valueOf(j)}, null, null, null)) != null) {
            cursorQuery.moveToFirst();
        }
        return cursorQuery;
    }

    /* renamed from: c */
    public Cursor m12121c(String str) {
        Cursor cursorQuery = null;
        if (this.f12432c != null && this.f12432c.isOpen() && (cursorQuery = this.f12432c.query("ams_recent_stamp", new String[]{"ams_path", "ams_index", "ams_type", "ams_date", "_id"}, "ams_index=?", new String[]{str}, null, null, null)) != null) {
            cursorQuery.moveToFirst();
        }
        return cursorQuery;
    }

    /* renamed from: d */
    private long m12114d(String str) {
        Cursor cursorQuery;
        if (this.f12432c != null && this.f12432c.isOpen() && (cursorQuery = this.f12432c.query("ams_recent_stamp", null, "ams_index=?", new String[]{String.valueOf(str)}, null, null, null)) != null && cursorQuery.getCount() == 1 && cursorQuery.moveToFirst()) {
            return Long.valueOf(cursorQuery.getString(cursorQuery.getColumnIndex("_id"))).longValue();
        }
        return -1L;
    }
}
