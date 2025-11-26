package com.sec.chaton.chat.background;

import android.app.Service;

/* compiled from: RequestExt.java */
/* renamed from: com.sec.chaton.chat.background.l */
/* loaded from: classes.dex */
public class C0978l extends C0975i {

    /* renamed from: r */
    protected int f4040r = -1;

    /* renamed from: s */
    protected Service f4041s = null;

    /* renamed from: t */
    protected int f4042t;

    /* renamed from: c */
    public C0978l m5241c(int i) {
        this.f4040r = i;
        return this;
    }

    /* renamed from: a */
    public C0978l m5239a(Service service) {
        this.f4041s = service;
        return this;
    }

    /* renamed from: d */
    public C0978l m5242d(int i) {
        this.f4042t = i;
        return this;
    }

    @Override // com.sec.chaton.chat.background.C0975i
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0977k mo5219a() {
        return new C0977k(this);
    }
}
