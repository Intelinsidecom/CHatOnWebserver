package com.sec.widget;

import android.widget.NumberPicker;
import java.util.Formatter;
import java.util.Locale;

/* compiled from: CustomDatePicker.java */
/* renamed from: com.sec.widget.e */
/* loaded from: classes.dex */
final class C3671e implements NumberPicker.Formatter {

    /* renamed from: a */
    final StringBuilder f13581a = new StringBuilder();

    /* renamed from: b */
    final Formatter f13582b = new Formatter(this.f13581a, Locale.US);

    /* renamed from: c */
    final Object[] f13583c = new Object[1];

    C3671e() {
    }

    @Override // android.widget.NumberPicker.Formatter
    public String format(int i) {
        this.f13583c[0] = Integer.valueOf(i);
        this.f13581a.delete(0, this.f13581a.length());
        this.f13582b.format("%02d", this.f13583c);
        return this.f13582b.toString();
    }
}
