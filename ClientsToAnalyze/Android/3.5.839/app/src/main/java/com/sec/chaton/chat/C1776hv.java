package com.sec.chaton.chat;

import android.database.AbstractCursor;
import android.database.Cursor;
import android.database.DataSetObserver;
import java.lang.reflect.Array;
import java.util.Date;

/* compiled from: SortCursor.java */
/* renamed from: com.sec.chaton.chat.hv */
/* loaded from: classes.dex */
public class C1776hv extends AbstractCursor {

    /* renamed from: a */
    private static final String f6660a = C1776hv.class.getSimpleName();

    /* renamed from: b */
    private Cursor f6661b;

    /* renamed from: c */
    private Cursor[] f6662c;

    /* renamed from: d */
    private int[] f6663d;

    /* renamed from: h */
    private int[][] f6667h;

    /* renamed from: e */
    private final int f6664e = 64;

    /* renamed from: f */
    private int[] f6665f = new int[64];

    /* renamed from: g */
    private int[] f6666g = new int[64];

    /* renamed from: i */
    private int f6668i = -1;

    /* renamed from: j */
    private DataSetObserver f6669j = new C1777hw(this);

    public C1776hv(Cursor[] cursorArr, String[] strArr) {
        this.f6662c = cursorArr;
        int length = this.f6662c.length;
        this.f6663d = new int[length];
        for (int i = 0; i < length; i++) {
            if (this.f6662c[i] != null) {
                this.f6662c[i].registerDataSetObserver(this.f6669j);
                this.f6662c[i].moveToFirst();
                this.f6663d[i] = this.f6662c[i].getColumnIndex(strArr[i]);
            }
        }
        this.f6661b = null;
        Long lValueOf = 0L;
        for (int i2 = 0; i2 < length; i2++) {
            if (this.f6662c[i2] != null && !this.f6662c[i2].isAfterLast()) {
                lValueOf = lValueOf.longValue() == 0 ? Long.valueOf(this.f6662c[i2].getLong(this.f6663d[i2])) : lValueOf;
                Long lValueOf2 = Long.valueOf(this.f6662c[i2].getLong(this.f6663d[i2]));
                if (this.f6661b == null || m8788a(lValueOf2).compareTo(m8788a(lValueOf)) < 0) {
                    this.f6661b = this.f6662c[i2];
                    lValueOf = lValueOf2;
                }
            }
        }
        for (int length2 = this.f6665f.length - 1; length2 >= 0; length2--) {
            this.f6665f[length2] = -2;
        }
        this.f6667h = (int[][]) Array.newInstance((Class<?>) Integer.TYPE, 64, length);
    }

    /* renamed from: a */
    private Date m8788a(Long l) {
        return new Date(l.longValue());
    }

    /* renamed from: a */
    public Cursor m8790a() {
        return this.f6661b;
    }

    @Override // android.database.AbstractCursor, android.database.Cursor
    public int getCount() {
        int count = 0;
        int length = this.f6662c.length;
        for (int i = 0; i < length; i++) {
            if (this.f6662c[i] != null) {
                count += this.f6662c[i].getCount();
            }
        }
        return count;
    }

    /* JADX WARN: Removed duplicated region for block: B:64:0x011d A[PHI: r0
  0x011d: PHI (r0v30 java.lang.Long) = (r0v24 java.lang.Long), (r0v32 java.lang.Long) binds: [B:36:0x0088, B:47:0x00d1] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // android.database.AbstractCursor, android.database.CrossProcessCursor
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onMove(int r12, int r13) {
        /*
            Method dump skipped, instructions count: 291
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.chat.C1776hv.onMove(int, int):boolean");
    }

    @Override // android.database.AbstractCursor, android.database.Cursor
    public String getString(int i) {
        return this.f6661b.getString(i);
    }

    @Override // android.database.AbstractCursor, android.database.Cursor
    public short getShort(int i) {
        return this.f6661b.getShort(i);
    }

    @Override // android.database.AbstractCursor, android.database.Cursor
    public int getInt(int i) {
        return this.f6661b.getInt(i);
    }

    @Override // android.database.AbstractCursor, android.database.Cursor
    public long getLong(int i) {
        return this.f6661b.getLong(i);
    }

    @Override // android.database.AbstractCursor, android.database.Cursor
    public float getFloat(int i) {
        return this.f6661b.getFloat(i);
    }

    @Override // android.database.AbstractCursor, android.database.Cursor
    public double getDouble(int i) {
        return this.f6661b.getDouble(i);
    }

    @Override // android.database.AbstractCursor, android.database.Cursor
    public int getType(int i) {
        return this.f6661b.getType(i);
    }

    @Override // android.database.AbstractCursor, android.database.Cursor
    public boolean isNull(int i) {
        return this.f6661b.isNull(i);
    }

    @Override // android.database.AbstractCursor, android.database.Cursor
    public byte[] getBlob(int i) {
        return this.f6661b.getBlob(i);
    }

    @Override // android.database.AbstractCursor, android.database.Cursor
    public String[] getColumnNames() {
        if (this.f6661b != null) {
            return this.f6661b.getColumnNames();
        }
        int length = this.f6662c.length;
        for (int i = 0; i < length; i++) {
            if (this.f6662c[i] != null) {
                return this.f6662c[i].getColumnNames();
            }
        }
        throw new IllegalStateException("No cursor that can return names");
    }

    @Override // android.database.AbstractCursor, android.database.Cursor
    public void deactivate() {
        int length = this.f6662c.length;
        for (int i = 0; i < length; i++) {
            if (this.f6662c[i] != null) {
                this.f6662c[i].deactivate();
            }
        }
    }

    @Override // android.database.AbstractCursor, android.database.Cursor, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        int length = this.f6662c.length;
        for (int i = 0; i < length; i++) {
            if (this.f6662c[i] != null) {
                this.f6662c[i].close();
            }
        }
    }

    @Override // android.database.AbstractCursor, android.database.Cursor
    public void registerDataSetObserver(DataSetObserver dataSetObserver) {
        int length = this.f6662c.length;
        for (int i = 0; i < length; i++) {
            if (this.f6662c[i] != null) {
                this.f6662c[i].registerDataSetObserver(dataSetObserver);
            }
        }
    }

    @Override // android.database.AbstractCursor, android.database.Cursor
    public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
        int length = this.f6662c.length;
        for (int i = 0; i < length; i++) {
            if (this.f6662c[i] != null) {
                this.f6662c[i].unregisterDataSetObserver(dataSetObserver);
            }
        }
    }

    @Override // android.database.AbstractCursor, android.database.Cursor
    public boolean requery() {
        int length = this.f6662c.length;
        for (int i = 0; i < length; i++) {
            if (this.f6662c[i] != null && !this.f6662c[i].requery()) {
                return false;
            }
        }
        return true;
    }
}
