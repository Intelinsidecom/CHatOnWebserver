package com.google.p034a.p036b;

/* compiled from: Streams.java */
/* renamed from: com.google.a.b.aj */
/* loaded from: classes.dex */
class C0633aj implements CharSequence {

    /* renamed from: a */
    char[] f1500a;

    C0633aj() {
    }

    @Override // java.lang.CharSequence
    public int length() {
        return this.f1500a.length;
    }

    @Override // java.lang.CharSequence
    public char charAt(int i) {
        return this.f1500a[i];
    }

    @Override // java.lang.CharSequence
    public CharSequence subSequence(int i, int i2) {
        return new String(this.f1500a, i, i2 - i);
    }
}
