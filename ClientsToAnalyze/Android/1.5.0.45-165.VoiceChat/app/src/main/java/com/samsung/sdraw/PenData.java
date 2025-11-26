package com.samsung.sdraw;

/* loaded from: classes.dex */
public class PenData {

    /* renamed from: a */
    protected int f1097a;

    /* renamed from: b */
    protected int f1098b;

    /* renamed from: c */
    protected int f1099c;

    /* renamed from: d */
    protected int f1100d;

    public int getPenSize() {
        return this.f1098b;
    }

    public void setPenSize(int size) {
        this.f1098b = size;
    }

    public int getAlpha() {
        return this.f1100d;
    }

    public void setAlpha(int alpha) {
        this.f1100d = alpha;
    }

    public void setPenType(int pentype) {
        this.f1097a = pentype;
    }

    public int getPenType() {
        return this.f1097a;
    }

    public void setColor(int color) {
        this.f1099c = color;
    }

    public int getColor() {
        return this.f1099c;
    }

    public boolean equals(Object o) {
        PenData penData;
        return !(o instanceof PenData) || (penData = (PenData) o) == null || (penData.f1097a == this.f1097a && penData.f1098b == this.f1098b && penData.f1100d == this.f1100d && penData.f1099c == this.f1099c);
    }

    public int hashCode() {
        return super.hashCode();
    }
}
