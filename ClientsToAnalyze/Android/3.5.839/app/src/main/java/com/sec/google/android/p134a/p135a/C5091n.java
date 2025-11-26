package com.sec.google.android.p134a.p135a;

/* compiled from: PduComposer.java */
/* renamed from: com.sec.google.android.a.a.n */
/* loaded from: classes.dex */
class C5091n {

    /* renamed from: a */
    final /* synthetic */ C5087j f18547a;

    /* renamed from: b */
    private int f18548b;

    /* renamed from: c */
    private int f18549c;

    private C5091n(C5087j c5087j) {
        this.f18547a = c5087j;
    }

    /* renamed from: a */
    int m19367a() {
        if (this.f18549c != this.f18547a.f18537e.f18540a) {
            throw new RuntimeException("BUG: Invalid call to getLength()");
        }
        return this.f18547a.f18535b - this.f18548b;
    }
}
