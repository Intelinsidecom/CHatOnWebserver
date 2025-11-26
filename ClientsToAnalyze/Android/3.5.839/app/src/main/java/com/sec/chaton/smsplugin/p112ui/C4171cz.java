package com.sec.chaton.smsplugin.p112ui;

import java.util.LinkedList;

/* compiled from: MmsSlideView.java */
/* renamed from: com.sec.chaton.smsplugin.ui.cz */
/* loaded from: classes.dex */
public class C4171cz {

    /* renamed from: d */
    private static C4171cz f15486d;

    /* renamed from: a */
    protected int f15487a = 3;

    /* renamed from: b */
    private final LinkedList<Runnable> f15488b = new LinkedList<>();

    /* renamed from: c */
    private Thread f15489c;

    /* renamed from: a */
    public static C4171cz m16453a() {
        if (f15486d == null) {
            f15486d = new C4171cz();
            f15486d.m16458b();
        }
        return f15486d;
    }

    private C4171cz() {
    }

    /* renamed from: e */
    private Thread m16456e() {
        return new C4173da(this, "slide bitmap loader");
    }

    /* renamed from: a */
    public void m16457a(Runnable runnable) {
        synchronized (f15486d) {
            this.f15488b.add(runnable);
            if (this.f15487a == 1) {
                f15486d.notifyAll();
            }
        }
    }

    /* renamed from: b */
    public void m16459b(Runnable runnable) {
        synchronized (f15486d) {
            this.f15488b.remove(runnable);
        }
    }

    /* renamed from: b */
    public void m16458b() {
        if (this.f15487a != 1) {
            m16460c();
            if (this.f15489c == null) {
                this.f15489c = m16456e();
                this.f15489c.start();
            }
        }
    }

    /* renamed from: c */
    public void m16460c() {
        if (this.f15487a != 1) {
            this.f15487a = 1;
            synchronized (f15486d) {
                f15486d.notifyAll();
            }
        }
    }
}
