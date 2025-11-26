package com.sec.chaton.p017e;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashMap;

/* compiled from: SQLBuilder.java */
/* renamed from: com.sec.chaton.e.z */
/* loaded from: classes.dex */
public class C0711z {

    /* renamed from: a */
    private String f2665a;

    /* renamed from: b */
    private StringBuilder f2666b = new StringBuilder();

    /* renamed from: c */
    private HashMap f2667c = new HashMap();

    /* renamed from: d */
    private ArrayList f2668d = new ArrayList();

    /* renamed from: a */
    public C0711z m3183a(String str) {
        this.f2665a = str;
        return this;
    }

    /* renamed from: b */
    private void m3177b() {
        if (this.f2665a == null) {
            throw new IllegalStateException("Table not specified");
        }
    }

    /* renamed from: a */
    public String[] m3185a() {
        return (String[]) this.f2668d.toArray(new String[this.f2668d.size()]);
    }

    /* renamed from: a */
    public C0711z m3184a(String str, String... strArr) {
        if (TextUtils.isEmpty(str)) {
            if (strArr == null || strArr.length <= 0) {
            }
        } else {
            if (this.f2666b.length() > 0) {
                this.f2666b.append(" AND ");
            }
            this.f2666b.append("(").append(str).append(")");
            if (strArr != null) {
                for (String str2 : strArr) {
                    this.f2668d.add(str2);
                }
            }
        }
        return this;
    }

    /* renamed from: a */
    private void m3176a(String[] strArr) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < strArr.length) {
                String str = (String) this.f2667c.get(strArr[i2]);
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
    private String m3178c() {
        return this.f2666b.toString();
    }

    /* renamed from: a */
    public Cursor m3182a(SQLiteDatabase sQLiteDatabase, String[] strArr, String str, String str2, String str3, String str4) {
        m3177b();
        if (strArr != null) {
            m3176a(strArr);
        }
        return sQLiteDatabase.query(this.f2665a, strArr, m3178c(), m3185a(), str, str2, str3, str4);
    }

    /* renamed from: a */
    public Cursor m3181a(SQLiteDatabase sQLiteDatabase, String[] strArr, String str) {
        return m3182a(sQLiteDatabase, strArr, null, null, str, null);
    }

    /* renamed from: a */
    public int m3180a(SQLiteDatabase sQLiteDatabase, ContentValues contentValues) {
        m3177b();
        return sQLiteDatabase.update(this.f2665a, contentValues, m3178c(), m3185a());
    }

    /* renamed from: a */
    public int m3179a(SQLiteDatabase sQLiteDatabase) {
        m3177b();
        return sQLiteDatabase.delete(this.f2665a, m3178c(), m3185a());
    }
}
