package com.sec.chaton.trunk.database;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import java.util.ArrayList;

/* compiled from: SQLBuilder.java */
/* renamed from: com.sec.chaton.trunk.database.f */
/* loaded from: classes.dex */
public class C3050f {

    /* renamed from: a */
    private String f10958a;

    /* renamed from: b */
    private StringBuilder f10959b = new StringBuilder();

    /* renamed from: c */
    private ArrayList<String> f10960c = new ArrayList<>();

    /* renamed from: a */
    public String m10579a() {
        return this.f10959b.toString();
    }

    /* renamed from: b */
    public String[] m10581b() {
        return (String[]) this.f10960c.toArray(new String[this.f10960c.size()]);
    }

    @Deprecated
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public C3050f clone() {
        C3050f c3050f = new C3050f();
        c3050f.f10959b = new StringBuilder(this.f10959b.toString());
        c3050f.f10960c = new ArrayList<>(this.f10960c);
        return c3050f;
    }

    /* renamed from: a */
    public C3050f m10577a(String str) {
        this.f10958a = str;
        return this;
    }

    /* renamed from: a */
    public C3050f m10578a(String str, String... strArr) {
        if (!TextUtils.isEmpty(str) && strArr != null && strArr.length != 0) {
            if (this.f10959b.length() > 0) {
                this.f10959b.append(" AND ");
            }
            this.f10959b.append(str);
            for (String str2 : strArr) {
                this.f10960c.add(str2);
            }
        }
        return this;
    }

    /* renamed from: a */
    public Cursor m10576a(SQLiteDatabase sQLiteDatabase, String str, String str2, String str3) {
        return sQLiteDatabase.query(this.f10958a, null, m10579a(), m10581b(), str, str2, str3);
    }

    /* renamed from: a */
    public long m10575a(SQLiteDatabase sQLiteDatabase, ContentValues contentValues) {
        return sQLiteDatabase.insertOrThrow(this.f10958a, null, contentValues);
    }

    /* renamed from: b */
    public int m10580b(SQLiteDatabase sQLiteDatabase, ContentValues contentValues) {
        return sQLiteDatabase.update(this.f10958a, contentValues, m10579a(), m10581b());
    }

    /* renamed from: a */
    public int m10574a(SQLiteDatabase sQLiteDatabase) {
        return sQLiteDatabase.delete(this.f10958a, m10579a(), m10581b());
    }
}
