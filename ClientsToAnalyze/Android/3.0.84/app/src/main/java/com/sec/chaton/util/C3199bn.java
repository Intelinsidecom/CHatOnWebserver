package com.sec.chaton.util;

import android.text.InputFilter;
import android.text.Spanned;

/* compiled from: ObservableLengthFilter.java */
/* renamed from: com.sec.chaton.util.bn */
/* loaded from: classes.dex */
public class C3199bn extends InputFilter.LengthFilter {

    /* renamed from: a */
    private int f11553a;

    /* renamed from: b */
    private InterfaceC3200bo f11554b;

    public C3199bn(int i) {
        this(i, null);
    }

    public C3199bn(int i, InterfaceC3200bo interfaceC3200bo) {
        super(i);
        this.f11553a = i;
        this.f11554b = interfaceC3200bo;
    }

    /* renamed from: a */
    public int m11161a() {
        return this.f11553a;
    }

    /* renamed from: a */
    public void m11162a(InterfaceC3200bo interfaceC3200bo) {
        this.f11554b = interfaceC3200bo;
    }

    @Override // android.text.InputFilter.LengthFilter, android.text.InputFilter
    public CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
        CharSequence charSequenceFilter = super.filter(charSequence, i, i2, spanned, i3, i4);
        if (charSequenceFilter != null && this.f11554b != null) {
            this.f11554b.mo4085a(this.f11553a);
        }
        return charSequenceFilter;
    }
}
