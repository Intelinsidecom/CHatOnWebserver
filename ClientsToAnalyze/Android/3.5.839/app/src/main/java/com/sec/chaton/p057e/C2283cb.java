package com.sec.chaton.p057e;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashMap;

/* compiled from: SQLBuilder.java */
/* renamed from: com.sec.chaton.e.cb */
/* loaded from: classes.dex */
public class C2283cb {

    /* renamed from: a */
    private String f8187a;

    /* renamed from: b */
    private StringBuilder f8188b = new StringBuilder();

    /* renamed from: c */
    private HashMap<String, String> f8189c = new HashMap<>();

    /* renamed from: d */
    private ArrayList<String> f8190d = new ArrayList<>();

    /* renamed from: a */
    public C2283cb m10145a(String str) {
        this.f8187a = str;
        return this;
    }

    /* renamed from: b */
    private void m10139b() {
        if (this.f8187a == null) {
            throw new IllegalStateException("Table not specified");
        }
    }

    /* renamed from: a */
    public String[] m10147a() {
        return (String[]) this.f8190d.toArray(new String[this.f8190d.size()]);
    }

    /* renamed from: a */
    public C2283cb m10146a(String str, String... strArr) {
        if (TextUtils.isEmpty(str)) {
            if (strArr == null || strArr.length <= 0) {
            }
        } else {
            if (this.f8188b.length() > 0) {
                this.f8188b.append(" AND ");
            }
            this.f8188b.append("(").append(str).append(")");
            if (strArr != null) {
                for (String str2 : strArr) {
                    this.f8190d.add(str2);
                }
            }
        }
        return this;
    }

    /* renamed from: a */
    private void m10138a(String[] strArr) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < strArr.length) {
                String str = this.f8189c.get(strArr[i2]);
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
    private String m10140c() {
        return this.f8188b.toString();
    }

    /* renamed from: a */
    public Cursor m10144a(SQLiteDatabase sQLiteDatabase, String[] strArr, String str, String str2, String str3, String str4) {
        m10139b();
        if (strArr != null) {
            m10138a(strArr);
        }
        return sQLiteDatabase.query(this.f8187a, strArr, m10140c(), m10147a(), str, str2, str3, str4);
    }

    /* renamed from: a */
    public Cursor m10143a(SQLiteDatabase sQLiteDatabase, String[] strArr, String str) {
        return m10144a(sQLiteDatabase, strArr, null, null, str, null);
    }

    /* renamed from: a */
    public int m10142a(SQLiteDatabase sQLiteDatabase, ContentValues contentValues) {
        m10139b();
        return sQLiteDatabase.update(this.f8187a, contentValues, m10140c(), m10147a());
    }

    /* renamed from: a */
    public int m10141a(SQLiteDatabase sQLiteDatabase) {
        m10139b();
        return sQLiteDatabase.delete(this.f8187a, m10140c(), m10147a());
    }
}
