package com.google.p034a.p036b;

import java.math.BigDecimal;

/* compiled from: LazilyParsedNumber.java */
/* renamed from: com.google.a.b.v */
/* loaded from: classes.dex */
public final class C0659v extends Number {

    /* renamed from: a */
    private final String f1549a;

    public C0659v(String str) {
        this.f1549a = str;
    }

    @Override // java.lang.Number
    public int intValue() {
        try {
            return Integer.parseInt(this.f1549a);
        } catch (NumberFormatException e) {
            try {
                return (int) Long.parseLong(this.f1549a);
            } catch (NumberFormatException e2) {
                return new BigDecimal(this.f1549a).intValue();
            }
        }
    }

    @Override // java.lang.Number
    public long longValue() {
        try {
            return Long.parseLong(this.f1549a);
        } catch (NumberFormatException e) {
            return new BigDecimal(this.f1549a).longValue();
        }
    }

    @Override // java.lang.Number
    public float floatValue() {
        return Float.parseFloat(this.f1549a);
    }

    @Override // java.lang.Number
    public double doubleValue() {
        return Double.parseDouble(this.f1549a);
    }

    public String toString() {
        return this.f1549a;
    }
}
