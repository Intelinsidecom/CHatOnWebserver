package com.sec.chaton.util;

import android.text.InputFilter;
import android.text.Spanned;

/* compiled from: ObservableLengthFilter.java */
/* renamed from: com.sec.chaton.util.bn */
/* loaded from: classes.dex */
public class C4849bn extends InputFilter.LengthFilter {

    /* renamed from: a */
    private int f17668a;

    /* renamed from: b */
    private InterfaceC4850bo f17669b;

    public C4849bn(int i) {
        this(i, null);
    }

    public C4849bn(int i, InterfaceC4850bo interfaceC4850bo) {
        super(i);
        this.f17668a = i;
        this.f17669b = interfaceC4850bo;
    }

    /* renamed from: a */
    public int m18336a() {
        return this.f17668a;
    }

    /* renamed from: a */
    public void m18337a(InterfaceC4850bo interfaceC4850bo) {
        this.f17669b = interfaceC4850bo;
    }

    @Override // android.text.InputFilter.LengthFilter, android.text.InputFilter
    public CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
        CharSequence charSequenceFilter = super.filter(charSequence, i, i2, spanned, i3, i4);
        if (charSequenceFilter != null && this.f17669b != null) {
            this.f17669b.mo7436a(this.f17668a);
        }
        return charSequenceFilter;
    }
}
