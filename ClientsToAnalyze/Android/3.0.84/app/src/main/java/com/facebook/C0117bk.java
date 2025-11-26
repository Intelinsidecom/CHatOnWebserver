package com.facebook;

import android.content.Context;

/* compiled from: Session.java */
/* renamed from: com.facebook.bk */
/* loaded from: classes.dex */
public final class C0117bk {

    /* renamed from: a */
    private final Context f237a;

    /* renamed from: b */
    private String f238b;

    /* renamed from: c */
    private AbstractC0130bx f239c;

    public C0117bk(Context context) {
        this.f237a = context;
    }

    /* renamed from: a */
    public C0117bk m350a(String str) {
        this.f238b = str;
        return this;
    }

    /* renamed from: a */
    public C0107ba m349a() {
        return new C0107ba(this.f237a, this.f238b, this.f239c);
    }
}
