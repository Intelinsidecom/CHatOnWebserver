package com.sec.chaton.util;

/* compiled from: MessageServerAddressMgr.java */
/* renamed from: com.sec.chaton.util.ar */
/* loaded from: classes.dex */
public class C1295ar {

    /* renamed from: a */
    final /* synthetic */ C1277a f4481a;

    /* renamed from: b */
    private String f4482b;

    /* renamed from: c */
    private int f4483c;

    public C1295ar(C1277a c1277a, String str, int i) {
        this.f4481a = c1277a;
        this.f4482b = str;
        this.f4483c = i;
    }

    /* renamed from: a */
    public synchronized void m4515a(String str) {
        this.f4482b = str;
    }

    /* renamed from: a */
    public synchronized String m4513a() {
        return this.f4482b;
    }

    /* renamed from: a */
    public synchronized void m4514a(int i) {
        this.f4483c = i;
    }

    /* renamed from: b */
    public synchronized int m4516b() {
        return this.f4483c;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("SERVER : ").append(this.f4482b).append("\n").append("PORT : ").append(Integer.toString(this.f4483c));
        return sb.toString();
    }
}
