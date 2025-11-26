package com.sec.chaton.smsplugin.provider;

import android.database.Cursor;
import java.util.Iterator;

/* compiled from: SmsCursorJoiner.java */
/* renamed from: com.sec.chaton.smsplugin.provider.y */
/* loaded from: classes.dex */
public final class C3967y implements Iterable<EnumC3943aa>, Iterator<EnumC3943aa> {

    /* renamed from: a */
    static final /* synthetic */ boolean f14274a;

    /* renamed from: b */
    private static final String f14275b;

    /* renamed from: c */
    private Cursor f14276c;

    /* renamed from: d */
    private Cursor f14277d;

    /* renamed from: e */
    private boolean f14278e;

    /* renamed from: f */
    private EnumC3943aa f14279f;

    /* renamed from: g */
    private int f14280g;

    /* renamed from: h */
    private int f14281h;

    static {
        f14274a = !C3967y.class.desiredAssertionStatus();
        f14275b = C3967y.class.getSimpleName();
    }

    public C3967y(Cursor cursor, String str, Cursor cursor2, String str2) {
        this.f14276c = cursor;
        this.f14277d = cursor2;
        this.f14276c.moveToFirst();
        this.f14277d.moveToFirst();
        this.f14278e = false;
        this.f14280g = m15279a(cursor, str);
        this.f14281h = m15279a(cursor2, str2);
    }

    @Override // java.lang.Iterable
    public Iterator<EnumC3943aa> iterator() {
        return this;
    }

    /* renamed from: a */
    private int m15279a(Cursor cursor, String str) {
        return cursor.getColumnIndexOrThrow(str);
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        if (!this.f14278e) {
            return (this.f14276c.isAfterLast() && this.f14277d.isAfterLast()) ? false : true;
        }
        switch (this.f14279f) {
            case BOTH:
                return (this.f14276c.isLast() && this.f14277d.isLast()) ? false : true;
            case LEFT:
                return (this.f14276c.isLast() && this.f14277d.isAfterLast()) ? false : true;
            case RIGHT:
                return (this.f14276c.isAfterLast() && this.f14277d.isLast()) ? false : true;
            default:
                throw new IllegalStateException("bad value for mCompareResult, " + this.f14279f);
        }
    }

    @Override // java.util.Iterator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public EnumC3943aa next() {
        if (!hasNext()) {
            throw new IllegalStateException("you must only call next() when hasNext() is true");
        }
        m15281b();
        if (!f14274a && !hasNext()) {
            throw new AssertionError();
        }
        boolean z = !this.f14276c.isAfterLast();
        boolean z2 = this.f14277d.isAfterLast() ? false : true;
        if (z && z2) {
            switch (m15278a(m15280a(this.f14276c, this.f14280g), m15280a(this.f14277d, this.f14281h))) {
                case -1:
                    this.f14279f = EnumC3943aa.RIGHT;
                    break;
                case 0:
                    this.f14279f = EnumC3943aa.BOTH;
                    break;
                case 1:
                    this.f14279f = EnumC3943aa.LEFT;
                    break;
            }
        } else if (z) {
            this.f14279f = EnumC3943aa.LEFT;
        } else {
            if (!f14274a && !z2) {
                throw new AssertionError();
            }
            this.f14279f = EnumC3943aa.RIGHT;
        }
        this.f14278e = true;
        return this.f14279f;
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("not implemented");
    }

    /* renamed from: a */
    private static long m15280a(Cursor cursor, int i) {
        return cursor.getLong(i);
    }

    /* renamed from: b */
    private void m15281b() {
        if (this.f14278e) {
            switch (this.f14279f) {
                case BOTH:
                    this.f14276c.moveToNext();
                    this.f14277d.moveToNext();
                    break;
                case LEFT:
                    this.f14276c.moveToNext();
                    break;
                case RIGHT:
                    this.f14277d.moveToNext();
                    break;
            }
            this.f14278e = false;
        }
    }

    /* renamed from: a */
    private static int m15278a(long j, long j2) {
        if (j < j2) {
            return -1;
        }
        if (j > j2) {
            return 1;
        }
        return 0;
    }
}
