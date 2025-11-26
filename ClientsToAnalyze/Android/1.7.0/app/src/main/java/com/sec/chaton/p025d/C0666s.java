package com.sec.chaton.p025d;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashMap;

/* compiled from: SQLBuilder.java */
/* renamed from: com.sec.chaton.d.s */
/* loaded from: classes.dex */
public class C0666s {

    /* renamed from: a */
    private String f2306a;

    /* renamed from: b */
    private StringBuilder f2307b = new StringBuilder();

    /* renamed from: c */
    private HashMap f2308c = new HashMap();

    /* renamed from: d */
    private ArrayList f2309d = new ArrayList();

    /* renamed from: a */
    public C0666s m3020a(String str) {
        this.f2306a = str;
        return this;
    }

    /* renamed from: b */
    private void m3014b() {
        if (this.f2306a == null) {
            throw new IllegalStateException("Table not specified");
        }
    }

    /* renamed from: a */
    public String[] m3022a() {
        return (String[]) this.f2309d.toArray(new String[this.f2309d.size()]);
    }

    /* renamed from: a */
    public C0666s m3021a(String str, String... strArr) {
        if (TextUtils.isEmpty(str)) {
            if (strArr == null || strArr.length <= 0) {
            }
        } else {
            if (this.f2307b.length() > 0) {
                this.f2307b.append(" AND ");
            }
            this.f2307b.append("(").append(str).append(")");
            if (strArr != null) {
                for (String str2 : strArr) {
                    this.f2309d.add(str2);
                }
            }
        }
        return this;
    }

    /* renamed from: a */
    private void m3013a(String[] strArr) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < strArr.length) {
                String str = (String) this.f2308c.get(strArr[i2]);
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
    private String m3015c() {
        return this.f2307b.toString();
    }

    /* renamed from: a */
    public Cursor m3019a(SQLiteDatabase sQLiteDatabase, String[] strArr, String str, String str2, String str3, String str4) {
        m3014b();
        if (strArr != null) {
            m3013a(strArr);
        }
        return sQLiteDatabase.query(this.f2306a, strArr, m3015c(), m3022a(), str, str2, str3, str4);
    }

    /* renamed from: a */
    public Cursor m3018a(SQLiteDatabase sQLiteDatabase, String[] strArr, String str) {
        return m3019a(sQLiteDatabase, strArr, null, null, str, null);
    }

    /* renamed from: a */
    public int m3017a(SQLiteDatabase sQLiteDatabase, ContentValues contentValues) {
        m3014b();
        return sQLiteDatabase.update(this.f2306a, contentValues, m3015c(), m3022a());
    }

    /* renamed from: a */
    public int m3016a(SQLiteDatabase sQLiteDatabase) {
        m3014b();
        return sQLiteDatabase.delete(this.f2306a, m3015c(), m3022a());
    }
}
