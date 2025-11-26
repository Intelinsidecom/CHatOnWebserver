package com.sec.chaton.trunk.database;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import java.util.ArrayList;

/* compiled from: SQLBuilder.java */
/* renamed from: com.sec.chaton.trunk.database.f */
/* loaded from: classes.dex */
public class C1590f {

    /* renamed from: a */
    private String f5704a;

    /* renamed from: b */
    private StringBuilder f5705b = new StringBuilder();

    /* renamed from: c */
    private ArrayList f5706c = new ArrayList();

    /* renamed from: a */
    public String m5487a() {
        return this.f5705b.toString();
    }

    /* renamed from: b */
    public String[] m5489b() {
        return (String[]) this.f5706c.toArray(new String[this.f5706c.size()]);
    }

    @Deprecated
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public C1590f clone() {
        C1590f c1590f = new C1590f();
        c1590f.f5705b = new StringBuilder(this.f5705b.toString());
        c1590f.f5706c = new ArrayList(this.f5706c);
        return c1590f;
    }

    /* renamed from: a */
    public C1590f m5485a(String str) {
        this.f5704a = str;
        return this;
    }

    /* renamed from: a */
    public C1590f m5486a(String str, String... strArr) {
        if (!TextUtils.isEmpty(str) && strArr != null && strArr.length != 0) {
            if (this.f5705b.length() > 0) {
                this.f5705b.append(" AND ");
            }
            this.f5705b.append(str);
            for (String str2 : strArr) {
                this.f5706c.add(str2);
            }
        }
        return this;
    }

    /* renamed from: a */
    public Cursor m5484a(SQLiteDatabase sQLiteDatabase, String str, String str2, String str3) {
        return sQLiteDatabase.query(this.f5704a, null, m5487a(), m5489b(), str, str2, str3);
    }

    /* renamed from: a */
    public long m5483a(SQLiteDatabase sQLiteDatabase, ContentValues contentValues) {
        return sQLiteDatabase.insertOrThrow(this.f5704a, null, contentValues);
    }

    /* renamed from: b */
    public int m5488b(SQLiteDatabase sQLiteDatabase, ContentValues contentValues) {
        return sQLiteDatabase.update(this.f5704a, contentValues, m5487a(), m5489b());
    }

    /* renamed from: a */
    public int m5482a(SQLiteDatabase sQLiteDatabase) {
        return sQLiteDatabase.delete(this.f5704a, m5487a(), m5489b());
    }
}
