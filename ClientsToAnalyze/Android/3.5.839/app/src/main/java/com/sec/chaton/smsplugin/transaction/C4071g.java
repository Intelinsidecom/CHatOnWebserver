package com.sec.chaton.smsplugin.transaction;

import android.content.Context;

/* compiled from: DefaultRetryScheme.java */
/* renamed from: com.sec.chaton.smsplugin.transaction.g */
/* loaded from: classes.dex */
public class C4071g extends AbstractC4049a {

    /* renamed from: b */
    private static final int[] f14672b = {0, 60000, 300000, 600000, 1800000};

    public C4071g(Context context, int i) {
        super(i);
        this.f14605a = this.f14605a < 0 ? 0 : this.f14605a;
        this.f14605a = this.f14605a >= f14672b.length ? f14672b.length - 1 : this.f14605a;
    }

    /* renamed from: a */
    public int m15674a() {
        return f14672b.length;
    }

    /* renamed from: b */
    public long m15675b() {
        return f14672b[this.f14605a];
    }
}
