package com.sec.chaton.trunk.database;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import java.util.ArrayList;

/* compiled from: SQLBuilder.java */
/* renamed from: com.sec.chaton.trunk.database.b */
/* loaded from: classes.dex */
public class C1174b {

    /* renamed from: a */
    private String f4035a;

    /* renamed from: b */
    private StringBuilder f4036b = new StringBuilder();

    /* renamed from: c */
    private ArrayList f4037c = new ArrayList();

    /* renamed from: a */
    public String m4249a() {
        return this.f4036b.toString();
    }

    /* renamed from: b */
    public String[] m4251b() {
        return (String[]) this.f4037c.toArray(new String[this.f4037c.size()]);
    }

    @Deprecated
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public C1174b clone() {
        C1174b c1174b = new C1174b();
        c1174b.f4036b = new StringBuilder(this.f4036b.toString());
        c1174b.f4037c = new ArrayList(this.f4037c);
        return c1174b;
    }

    /* renamed from: a */
    public C1174b m4247a(String str) {
        this.f4035a = str;
        return this;
    }

    /* renamed from: a */
    public C1174b m4248a(String str, String... strArr) {
        if (!TextUtils.isEmpty(str) && strArr != null && strArr.length != 0) {
            if (this.f4036b.length() > 0) {
                this.f4036b.append(" AND ");
            }
            this.f4036b.append(str);
            for (String str2 : strArr) {
                this.f4037c.add(str2);
            }
        }
        return this;
    }

    /* renamed from: a */
    public Cursor m4246a(SQLiteDatabase sQLiteDatabase, String str, String str2, String str3) {
        return sQLiteDatabase.query(this.f4035a, null, m4249a(), m4251b(), str, str2, str3);
    }

    /* renamed from: a */
    public long m4245a(SQLiteDatabase sQLiteDatabase, ContentValues contentValues) {
        return sQLiteDatabase.insertOrThrow(this.f4035a, null, contentValues);
    }

    /* renamed from: b */
    public int m4250b(SQLiteDatabase sQLiteDatabase, ContentValues contentValues) {
        return sQLiteDatabase.update(this.f4035a, contentValues, m4249a(), m4251b());
    }

    /* renamed from: a */
    public int m4244a(SQLiteDatabase sQLiteDatabase) {
        return sQLiteDatabase.delete(this.f4035a, m4249a(), m4251b());
    }
}
