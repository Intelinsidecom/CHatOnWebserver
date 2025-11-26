package com.sec.chaton.p027e;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashMap;

/* compiled from: SQLBuilder.java */
/* renamed from: com.sec.chaton.e.bj */
/* loaded from: classes.dex */
public class C1434bj {

    /* renamed from: a */
    private String f5359a;

    /* renamed from: b */
    private StringBuilder f5360b = new StringBuilder();

    /* renamed from: c */
    private HashMap<String, String> f5361c = new HashMap<>();

    /* renamed from: d */
    private ArrayList<String> f5362d = new ArrayList<>();

    /* renamed from: a */
    public C1434bj m6288a(String str) {
        this.f5359a = str;
        return this;
    }

    /* renamed from: b */
    private void m6282b() {
        if (this.f5359a == null) {
            throw new IllegalStateException("Table not specified");
        }
    }

    /* renamed from: a */
    public String[] m6290a() {
        return (String[]) this.f5362d.toArray(new String[this.f5362d.size()]);
    }

    /* renamed from: a */
    public C1434bj m6289a(String str, String... strArr) {
        if (TextUtils.isEmpty(str)) {
            if (strArr == null || strArr.length <= 0) {
            }
        } else {
            if (this.f5360b.length() > 0) {
                this.f5360b.append(" AND ");
            }
            this.f5360b.append("(").append(str).append(")");
            if (strArr != null) {
                for (String str2 : strArr) {
                    this.f5362d.add(str2);
                }
            }
        }
        return this;
    }

    /* renamed from: a */
    private void m6281a(String[] strArr) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < strArr.length) {
                String str = this.f5361c.get(strArr[i2]);
                if (str != null) {
                    strArr[i2] = str;
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    /* renamed from: c */
    private String m6283c() {
        return this.f5360b.toString();
    }

    /* renamed from: a */
    public Cursor m6287a(SQLiteDatabase sQLiteDatabase, String[] strArr, String str, String str2, String str3, String str4) {
        m6282b();
        if (strArr != null) {
            m6281a(strArr);
        }
        return sQLiteDatabase.query(this.f5359a, strArr, m6283c(), m6290a(), str, str2, str3, str4);
    }

    /* renamed from: a */
    public Cursor m6286a(SQLiteDatabase sQLiteDatabase, String[] strArr, String str) {
        return m6287a(sQLiteDatabase, strArr, null, null, str, null);
    }

    /* renamed from: a */
    public int m6285a(SQLiteDatabase sQLiteDatabase, ContentValues contentValues) {
        m6282b();
        return sQLiteDatabase.update(this.f5359a, contentValues, m6283c(), m6290a());
    }

    /* renamed from: a */
    public int m6284a(SQLiteDatabase sQLiteDatabase) {
        m6282b();
        return sQLiteDatabase.delete(this.f5359a, m6283c(), m6290a());
    }
}
