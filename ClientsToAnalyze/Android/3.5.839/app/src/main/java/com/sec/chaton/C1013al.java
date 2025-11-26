package com.sec.chaton;

/* compiled from: EventBusManager.java */
/* renamed from: com.sec.chaton.al */
/* loaded from: classes.dex */
public final class C1013al {

    /* renamed from: a */
    private EnumC1014am f3288a;

    /* renamed from: b */
    private String f3289b;

    /* renamed from: c */
    private String f3290c;

    /* renamed from: a */
    public static C1013al m6086a(EnumC1014am enumC1014am) {
        return new C1013al(enumC1014am);
    }

    /* renamed from: a */
    public static C1013al m6087a(EnumC1014am enumC1014am, String str, String str2) {
        return new C1013al(enumC1014am, str, str2);
    }

    private C1013al(EnumC1014am enumC1014am) {
        this.f3288a = enumC1014am;
    }

    private C1013al(EnumC1014am enumC1014am, String str, String str2) {
        this.f3288a = enumC1014am;
        this.f3289b = str;
        this.f3290c = str2;
    }

    /* renamed from: a */
    public EnumC1014am m6088a() {
        return this.f3288a;
    }

    /* renamed from: b */
    public String m6089b() {
        return this.f3289b;
    }

    /* renamed from: c */
    public String m6090c() {
        return this.f3290c;
    }
}
