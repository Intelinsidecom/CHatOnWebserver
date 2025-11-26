package com.sec.chaton.util;

/* compiled from: MessageServerAddressMgr.java */
/* renamed from: com.sec.chaton.util.bk */
/* loaded from: classes.dex */
public class C3196bk {

    /* renamed from: a */
    final /* synthetic */ C3194bi f11548a;

    /* renamed from: b */
    private String f11549b = C3216cd.m11286d();

    /* renamed from: c */
    private int f11550c = C3216cd.m11290f().intValue();

    public C3196bk(C3194bi c3194bi) {
        this.f11548a = c3194bi;
    }

    /* renamed from: a */
    public synchronized void m11157a(String str) {
        this.f11549b = str;
    }

    /* renamed from: a */
    public synchronized String m11155a() {
        return this.f11549b;
    }

    /* renamed from: a */
    public synchronized void m11156a(int i) {
        this.f11550c = i;
    }

    /* renamed from: b */
    public synchronized int m11158b() {
        return this.f11550c;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("SERVER : ").append(this.f11549b).append("\n").append("PORT : ").append(Integer.toString(this.f11550c));
        return sb.toString();
    }
}
