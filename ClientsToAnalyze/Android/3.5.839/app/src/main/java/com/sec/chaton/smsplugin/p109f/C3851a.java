package com.sec.chaton.smsplugin.p109f;

/* compiled from: HVGALayoutParameters.java */
/* renamed from: com.sec.chaton.smsplugin.f.a */
/* loaded from: classes.dex */
public class C3851a implements InterfaceC3853c {

    /* renamed from: a */
    private int f13850a;

    public C3851a(int i) {
        this.f13850a = -1;
        if (i != 10 && i != 11) {
            throw new IllegalArgumentException("Bad layout type detected: " + i);
        }
        this.f13850a = i;
    }

    @Override // com.sec.chaton.smsplugin.p109f.InterfaceC3853c
    /* renamed from: a */
    public int mo14732a() {
        return this.f13850a == 10 ? 480 : 320;
    }

    @Override // com.sec.chaton.smsplugin.p109f.InterfaceC3853c
    /* renamed from: b */
    public int mo14733b() {
        return this.f13850a == 10 ? 320 : 480;
    }

    @Override // com.sec.chaton.smsplugin.p109f.InterfaceC3853c
    /* renamed from: c */
    public int mo14734c() {
        return this.f13850a == 10 ? 240 : 320;
    }

    @Override // com.sec.chaton.smsplugin.p109f.InterfaceC3853c
    /* renamed from: d */
    public int mo14735d() {
        return this.f13850a == 10 ? 80 : 160;
    }
}
