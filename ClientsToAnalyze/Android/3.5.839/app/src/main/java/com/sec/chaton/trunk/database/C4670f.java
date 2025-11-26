package com.sec.chaton.trunk.database;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import java.util.ArrayList;

/* compiled from: SQLBuilder.java */
/* renamed from: com.sec.chaton.trunk.database.f */
/* loaded from: classes.dex */
public class C4670f {

    /* renamed from: a */
    private String f16907a;

    /* renamed from: b */
    private StringBuilder f16908b = new StringBuilder();

    /* renamed from: c */
    private ArrayList<String> f16909c = new ArrayList<>();

    /* renamed from: a */
    public String m17673a() {
        return this.f16908b.toString();
    }

    /* renamed from: b */
    public String[] m17675b() {
        return (String[]) this.f16909c.toArray(new String[this.f16909c.size()]);
    }

    @Deprecated
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public C4670f clone() {
        C4670f c4670f = new C4670f();
        c4670f.f16908b = new StringBuilder(this.f16908b.toString());
        c4670f.f16909c = new ArrayList<>(this.f16909c);
        return c4670f;
    }

    /* renamed from: a */
    public C4670f m17671a(String str) {
        this.f16907a = str;
        return this;
    }

    /* renamed from: a */
    public C4670f m17672a(String str, String... strArr) {
        if (!TextUtils.isEmpty(str) && strArr != null && strArr.length != 0) {
            if (this.f16908b.length() > 0) {
                this.f16908b.append(" AND ");
            }
            this.f16908b.append(str);
            for (String str2 : strArr) {
                this.f16909c.add(str2);
            }
        }
        return this;
    }

    /* renamed from: a */
    public Cursor m17670a(SQLiteDatabase sQLiteDatabase, String str, String str2, String str3) {
        return sQLiteDatabase.query(this.f16907a, null, m17673a(), m17675b(), str, str2, str3);
    }

    /* renamed from: a */
    public long m17669a(SQLiteDatabase sQLiteDatabase, ContentValues contentValues) {
        return sQLiteDatabase.insertOrThrow(this.f16907a, null, contentValues);
    }

    /* renamed from: b */
    public int m17674b(SQLiteDatabase sQLiteDatabase, ContentValues contentValues) {
        return sQLiteDatabase.update(this.f16907a, contentValues, m17673a(), m17675b());
    }

    /* renamed from: a */
    public int m17668a(SQLiteDatabase sQLiteDatabase) {
        return sQLiteDatabase.delete(this.f16907a, m17673a(), m17675b());
    }
}
