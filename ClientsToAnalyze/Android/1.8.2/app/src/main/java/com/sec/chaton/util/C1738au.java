package com.sec.chaton.util;

/* compiled from: MessageServerAddressMgr.java */
/* renamed from: com.sec.chaton.util.au */
/* loaded from: classes.dex */
public class C1738au {

    /* renamed from: a */
    final /* synthetic */ C1736as f6348a;

    /* renamed from: b */
    private String f6349b;

    /* renamed from: c */
    private int f6350c;

    public C1738au(C1736as c1736as, String str, int i) {
        this.f6348a = c1736as;
        this.f6349b = str;
        this.f6350c = i;
    }

    /* renamed from: a */
    public synchronized void m5925a(String str) {
        this.f6349b = str;
    }

    /* renamed from: a */
    public synchronized String m5923a() {
        return this.f6349b;
    }

    /* renamed from: a */
    public synchronized void m5924a(int i) {
        this.f6350c = i;
    }

    /* renamed from: b */
    public synchronized int m5926b() {
        return this.f6350c;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("SERVER : ").append(this.f6349b).append("\n").append("PORT : ").append(Integer.toString(this.f6350c));
        return sb.toString();
    }
}
