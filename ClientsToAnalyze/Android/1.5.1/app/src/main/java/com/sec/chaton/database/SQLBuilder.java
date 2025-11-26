package com.sec.chaton.database;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashMap;

/* loaded from: classes.dex */
public class SQLBuilder {

    /* renamed from: a */
    private String f1751a;

    /* renamed from: b */
    private StringBuilder f1752b = new StringBuilder();

    /* renamed from: c */
    private HashMap f1753c = new HashMap();

    /* renamed from: d */
    private ArrayList f1754d = new ArrayList();

    /* renamed from: a */
    private void m2207a(String[] strArr) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= strArr.length) {
                return;
            }
            String str = (String) this.f1753c.get(strArr[i2]);
            if (str != null) {
                strArr[i2] = str;
            }
            i = i2 + 1;
        }
    }

    /* renamed from: b */
    private void m2208b() {
        if (this.f1751a == null) {
            throw new IllegalStateException("Table not specified");
        }
    }

    /* renamed from: c */
    private String m2209c() {
        return this.f1752b.toString();
    }

    /* renamed from: a */
    public int m2210a(SQLiteDatabase sQLiteDatabase) {
        m2208b();
        return sQLiteDatabase.delete(this.f1751a, m2209c(), m2216a());
    }

    /* renamed from: a */
    public int m2211a(SQLiteDatabase sQLiteDatabase, ContentValues contentValues) {
        m2208b();
        return sQLiteDatabase.update(this.f1751a, contentValues, m2209c(), m2216a());
    }

    /* renamed from: a */
    public Cursor m2212a(SQLiteDatabase sQLiteDatabase, String[] strArr, String str) {
        return m2213a(sQLiteDatabase, strArr, null, null, str, null);
    }

    /* renamed from: a */
    public Cursor m2213a(SQLiteDatabase sQLiteDatabase, String[] strArr, String str, String str2, String str3, String str4) {
        m2208b();
        if (strArr != null) {
            m2207a(strArr);
        }
        return sQLiteDatabase.query(this.f1751a, strArr, m2209c(), m2216a(), str, str2, str3);
    }

    /* renamed from: a */
    public SQLBuilder m2214a(String str) {
        this.f1751a = str;
        return this;
    }

    /* renamed from: a */
    public SQLBuilder m2215a(String str, String... strArr) {
        if (TextUtils.isEmpty(str)) {
            if (strArr == null || strArr.length <= 0) {
            }
            return this;
        }
        if (this.f1752b.length() > 0) {
            this.f1752b.append(" AND ");
        }
        this.f1752b.append("(").append(str).append(")");
        if (strArr != null) {
            for (String str2 : strArr) {
                this.f1754d.add(str2);
            }
        }
        return this;
    }

    /* renamed from: a */
    public String[] m2216a() {
        return (String[]) this.f1754d.toArray(new String[this.f1754d.size()]);
    }
}
