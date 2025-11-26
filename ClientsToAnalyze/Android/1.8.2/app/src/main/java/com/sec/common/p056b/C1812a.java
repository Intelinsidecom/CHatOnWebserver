package com.sec.common.p056b;

import android.database.Cursor;
import android.database.CursorWrapper;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* compiled from: AdditionalCursorWrapper.java */
/* renamed from: com.sec.common.b.a */
/* loaded from: classes.dex */
public class C1812a extends CursorWrapper {

    /* renamed from: a */
    private int f6504a;

    /* renamed from: b */
    private List f6505b;

    /* renamed from: c */
    private List f6506c;

    public C1812a(Cursor cursor, List list, List list2) {
        super(cursor);
        this.f6505b = list;
        this.f6506c = list2;
        if (list == null) {
            this.f6505b = new ArrayList();
        }
        if (list2 == null) {
            this.f6506c = new ArrayList();
        }
        if (cursor == null || cursor.getPosition() == -1) {
            this.f6504a = -1;
        }
    }

    @Override // android.database.CursorWrapper, android.database.Cursor
    public int getCount() {
        int count = super.getCount();
        if (count >= 1) {
            return count + this.f6505b.size() + this.f6506c.size();
        }
        return count;
    }

    @Override // android.database.CursorWrapper, android.database.Cursor
    public int getPosition() {
        return this.f6504a;
    }

    @Override // android.database.CursorWrapper, android.database.Cursor
    public boolean isFirst() {
        return this.f6504a == 0;
    }

    @Override // android.database.CursorWrapper, android.database.Cursor
    public boolean isLast() {
        return this.f6504a == getCount();
    }

    @Override // android.database.CursorWrapper, android.database.Cursor, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f6504a = -1;
        super.close();
    }

    @Override // android.database.CursorWrapper, android.database.Cursor
    public byte[] getBlob(int i) {
        int iM6147b = m6147b(this.f6504a);
        return (iM6147b == -1 || iM6147b == 1) ? (byte[]) m6146a(i) : super.getBlob(i);
    }

    @Override // android.database.CursorWrapper, android.database.Cursor
    public double getDouble(int i) {
        int iM6147b = m6147b(this.f6504a);
        return (iM6147b == -1 || iM6147b == 1) ? Double.valueOf(String.valueOf(m6146a(i))).doubleValue() : super.getDouble(i);
    }

    @Override // android.database.CursorWrapper, android.database.Cursor
    public float getFloat(int i) {
        int iM6147b = m6147b(this.f6504a);
        return (iM6147b == -1 || iM6147b == 1) ? Float.valueOf(String.valueOf(m6146a(i))).floatValue() : super.getFloat(i);
    }

    @Override // android.database.CursorWrapper, android.database.Cursor
    public int getInt(int i) {
        int iM6147b = m6147b(this.f6504a);
        return (iM6147b == -1 || iM6147b == 1) ? Integer.valueOf(String.valueOf(m6146a(i))).intValue() : super.getInt(i);
    }

    @Override // android.database.CursorWrapper, android.database.Cursor
    public long getLong(int i) {
        int iM6147b = m6147b(this.f6504a);
        return (iM6147b == -1 || iM6147b == 1) ? Long.valueOf(String.valueOf(m6146a(i))).longValue() : super.getLong(i);
    }

    @Override // android.database.CursorWrapper, android.database.Cursor
    public short getShort(int i) {
        int iM6147b = m6147b(this.f6504a);
        return (iM6147b == -1 || iM6147b == 1) ? Short.valueOf(String.valueOf(m6146a(i))).shortValue() : super.getShort(i);
    }

    @Override // android.database.CursorWrapper, android.database.Cursor
    public String getString(int i) {
        int iM6147b = m6147b(this.f6504a);
        return (iM6147b == -1 || iM6147b == 1) ? String.valueOf(m6146a(i)) : super.getString(i);
    }

    @Override // android.database.CursorWrapper, android.database.Cursor
    public boolean moveToPosition(int i) {
        if (i > getCount()) {
            return false;
        }
        if (i < 0) {
            this.f6504a = -1;
            super.moveToPosition(-1);
            return false;
        }
        this.f6504a = i;
        int iM6147b = m6147b(this.f6504a);
        if (iM6147b == -1 || iM6147b == 1) {
            super.moveToPosition(-1);
            return true;
        }
        return super.moveToPosition((this.f6504a - this.f6505b.size()) - this.f6506c.size());
    }

    /* renamed from: a */
    private Object m6146a(int i) {
        String columnName = getColumnName(i);
        int iM6147b = m6147b(this.f6504a);
        if (iM6147b == -1) {
            return ((Map) this.f6505b.get(this.f6504a)).get(columnName);
        }
        if (iM6147b == 1) {
            return ((Map) this.f6506c.get(this.f6504a)).get(columnName);
        }
        return null;
    }

    /* renamed from: b */
    private int m6147b(int i) {
        if (i <= this.f6505b.size() - 1) {
            return -1;
        }
        if (i - this.f6505b.size() > super.getCount() - 1) {
            super.moveToPosition(-1);
            return 1;
        }
        return 0;
    }
}
