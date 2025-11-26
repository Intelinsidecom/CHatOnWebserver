package com.samsung.sdraw;

import android.graphics.Bitmap;
import android.graphics.Color;

/* renamed from: com.samsung.sdraw.ar */
/* loaded from: classes.dex */
class C1005ar {

    /* renamed from: a */
    private int f1530a;

    /* renamed from: d */
    private boolean f1533d = false;

    /* renamed from: b */
    private Bitmap f1531b = Bitmap.createBitmap(95, 85, Bitmap.Config.ARGB_8888);

    /* renamed from: c */
    private PenData f1532c = new PenData();

    public String toString() {
        return String.format("Number:%d\nType:%d\nWidth:%d\nRGB(%2x,%2x,%2x)\nAlpha:%2x\n", Integer.valueOf(this.f1530a), Integer.valueOf(this.f1532c.getPenType()), Integer.valueOf(this.f1532c.getPenSize()), Integer.valueOf(Color.red(this.f1532c.getColor())), Integer.valueOf(Color.green(this.f1532c.getColor())), Integer.valueOf(Color.blue(this.f1532c.getColor())), Integer.valueOf(this.f1532c.getAlpha()));
    }

    /* renamed from: a */
    public void m1379a() {
        if (this.f1531b != null && !this.f1531b.isRecycled()) {
            this.f1531b.recycle();
        }
        this.f1531b = null;
    }

    /* renamed from: b */
    public Bitmap m1382b() {
        return this.f1531b;
    }

    /* renamed from: c */
    public int m1384c() {
        return this.f1530a;
    }

    /* renamed from: a */
    public void m1380a(int i) {
        this.f1530a = i;
    }

    /* renamed from: d */
    public int m1386d() {
        return this.f1532c.getPenSize();
    }

    /* renamed from: b */
    public void m1383b(int i) {
        this.f1532c.setPenSize(i);
    }

    /* renamed from: e */
    public int m1388e() {
        return this.f1532c.getAlpha();
    }

    /* renamed from: c */
    public void m1385c(int i) {
        this.f1532c.setAlpha(i);
    }

    /* renamed from: d */
    public void m1387d(int i) {
        this.f1532c.setPenType(i);
    }

    /* renamed from: f */
    public int m1390f() {
        return this.f1532c.getPenType();
    }

    /* renamed from: e */
    public void m1389e(int i) {
        this.f1532c.setColor(i);
    }

    /* renamed from: g */
    public int m1391g() {
        return this.f1532c.getColor();
    }

    /* renamed from: a */
    public void m1381a(boolean z) {
        this.f1533d = z;
    }

    /* renamed from: h */
    public boolean m1392h() {
        return this.f1533d;
    }

    /* renamed from: i */
    public PenData m1393i() {
        return this.f1532c;
    }

    public boolean equals(Object o) {
        if (this.f1532c == null || !(o instanceof C1005ar)) {
            return false;
        }
        return this.f1532c.equals(((C1005ar) o).m1393i());
    }

    public int hashCode() {
        return super.hashCode();
    }
}
