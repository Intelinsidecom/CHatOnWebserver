package com.sec.chaton;

/* compiled from: EventBusManager.java */
/* renamed from: com.sec.chaton.bc */
/* loaded from: classes.dex */
public final class C1063bc {

    /* renamed from: a */
    private EnumC1064bd f3353a;

    /* renamed from: b */
    private String f3354b;

    /* renamed from: a */
    public static C1063bc m6172a(EnumC1064bd enumC1064bd) {
        return new C1063bc(enumC1064bd);
    }

    /* renamed from: a */
    public static C1063bc m6173a(EnumC1064bd enumC1064bd, String str) {
        return new C1063bc(enumC1064bd, str);
    }

    private C1063bc(EnumC1064bd enumC1064bd) {
        this.f3353a = enumC1064bd;
        this.f3354b = "";
    }

    private C1063bc(EnumC1064bd enumC1064bd, String str) {
        this.f3353a = enumC1064bd;
        this.f3354b = str;
    }

    /* renamed from: a */
    public EnumC1064bd m6174a() {
        return this.f3353a;
    }
}
