package com.sec.chaton.util;

/* compiled from: MessageServerAddressMgr.java */
/* renamed from: com.sec.chaton.util.bk */
/* loaded from: classes.dex */
public class C4846bk {

    /* renamed from: a */
    final /* synthetic */ C4844bi f17663a;

    /* renamed from: b */
    private String f17664b = C4865cc.m18453d();

    /* renamed from: c */
    private int f17665c = C4865cc.m18457f().intValue();

    public C4846bk(C4844bi c4844bi) {
        this.f17663a = c4844bi;
    }

    /* renamed from: a */
    public synchronized void m18331a(String str) {
        this.f17664b = str;
    }

    /* renamed from: a */
    public synchronized String m18329a() {
        return this.f17664b;
    }

    /* renamed from: a */
    public synchronized void m18330a(int i) {
        this.f17665c = i;
    }

    /* renamed from: b */
    public synchronized int m18332b() {
        return this.f17665c;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("SERVER : ").append(this.f17664b).append("\n").append("PORT : ").append(Integer.toString(this.f17665c));
        return sb.toString();
    }
}
