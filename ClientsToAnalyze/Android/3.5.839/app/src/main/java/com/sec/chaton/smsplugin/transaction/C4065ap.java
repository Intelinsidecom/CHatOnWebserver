package com.sec.chaton.smsplugin.transaction;

import android.net.Uri;

/* compiled from: TransactionState.java */
/* renamed from: com.sec.chaton.smsplugin.transaction.ap */
/* loaded from: classes.dex */
public class C4065ap {

    /* renamed from: b */
    private int f14652b = 0;

    /* renamed from: a */
    private Uri f14651a = null;

    /* renamed from: a */
    public synchronized int m15641a() {
        return this.f14652b;
    }

    /* renamed from: a */
    synchronized void m15642a(int i) {
        if (i < 0 && i > 2) {
            throw new IllegalArgumentException("Bad state: " + i);
        }
        this.f14652b = i;
    }

    /* renamed from: b */
    public synchronized Uri m15644b() {
        return this.f14651a;
    }

    /* renamed from: a */
    synchronized void m15643a(Uri uri) {
        this.f14651a = uri;
    }
}
