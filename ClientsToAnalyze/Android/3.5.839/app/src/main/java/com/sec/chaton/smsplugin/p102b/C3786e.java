package com.sec.chaton.smsplugin.p102b;

import java.util.ArrayList;

/* compiled from: Contact.java */
/* renamed from: com.sec.chaton.smsplugin.b.e */
/* loaded from: classes.dex */
class C3786e {

    /* renamed from: b */
    private final ArrayList<Runnable> f13585b = new ArrayList<>();

    /* renamed from: a */
    Thread f13584a = new Thread(new RunnableC3787f(this));

    public C3786e() {
        this.f13584a.start();
    }

    /* renamed from: a */
    public void m14299a(Runnable runnable) {
        synchronized (this.f13585b) {
            this.f13585b.add(runnable);
            this.f13585b.notify();
        }
    }
}
