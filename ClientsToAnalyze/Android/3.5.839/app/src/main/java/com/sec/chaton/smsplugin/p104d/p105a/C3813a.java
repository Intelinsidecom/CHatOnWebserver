package com.sec.chaton.smsplugin.p104d.p105a;

import org.p146b.p147a.p148a.InterfaceC5237b;
import org.p146b.p147a.p148a.InterfaceC5240e;

/* compiled from: EventImpl.java */
/* renamed from: com.sec.chaton.smsplugin.d.a.a */
/* loaded from: classes.dex */
public class C3813a implements InterfaceC5237b {

    /* renamed from: a */
    private String f13678a;

    /* renamed from: b */
    private boolean f13679b;

    /* renamed from: c */
    private boolean f13680c;

    /* renamed from: d */
    private boolean f13681d;

    /* renamed from: e */
    private InterfaceC5240e f13682e;

    /* renamed from: f */
    private short f13683f;

    /* renamed from: g */
    private boolean f13684g;

    /* renamed from: h */
    private boolean f13685h;

    /* renamed from: i */
    private InterfaceC5240e f13686i;

    /* renamed from: j */
    private int f13687j;

    /* renamed from: k */
    private final long f13688k = System.currentTimeMillis();

    /* renamed from: a */
    public boolean m14493a() {
        return this.f13679b;
    }

    @Override // org.p146b.p147a.p148a.InterfaceC5237b
    /* renamed from: b */
    public String mo14494b() {
        return this.f13678a;
    }

    @Override // org.p146b.p147a.p148a.InterfaceC5237b
    /* renamed from: a */
    public void mo14489a(String str, boolean z, boolean z2) {
        this.f13678a = str;
        this.f13679b = z;
        this.f13680c = z2;
        this.f13681d = true;
    }

    /* renamed from: a */
    public void m14490a(String str, boolean z, boolean z2, int i) {
        this.f13687j = i;
        mo14489a(str, z, z2);
    }

    /* renamed from: c */
    boolean m14496c() {
        return this.f13681d;
    }

    /* renamed from: d */
    boolean m14497d() {
        return this.f13685h;
    }

    /* renamed from: e */
    boolean m14498e() {
        return this.f13684g;
    }

    /* renamed from: a */
    void m14491a(InterfaceC5240e interfaceC5240e) {
        this.f13682e = interfaceC5240e;
    }

    /* renamed from: a */
    void m14492a(short s) {
        this.f13683f = s;
    }

    /* renamed from: b */
    void m14495b(InterfaceC5240e interfaceC5240e) {
        this.f13686i = interfaceC5240e;
    }

    /* renamed from: f */
    public int m14499f() {
        return this.f13687j;
    }
}
