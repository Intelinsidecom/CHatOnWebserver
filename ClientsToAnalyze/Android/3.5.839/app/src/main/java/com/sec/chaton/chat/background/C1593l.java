package com.sec.chaton.chat.background;

import android.app.Service;

/* compiled from: RequestExt.java */
/* renamed from: com.sec.chaton.chat.background.l */
/* loaded from: classes.dex */
public class C1593l extends C1590i {

    /* renamed from: s */
    protected int f6096s = -1;

    /* renamed from: t */
    protected Service f6097t = null;

    /* renamed from: u */
    protected int f6098u;

    /* renamed from: d */
    public C1593l m8494d(int i) {
        this.f6096s = i;
        return this;
    }

    /* renamed from: a */
    public C1593l m8492a(Service service) {
        this.f6097t = service;
        return this;
    }

    /* renamed from: e */
    public C1593l m8495e(int i) {
        this.f6098u = i;
        return this;
    }

    @Override // com.sec.chaton.chat.background.C1590i
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C1592k mo8471a() {
        return new C1592k(this);
    }
}
