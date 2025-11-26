package com.sec.chaton.util;

/* compiled from: RegistrationUtil.java */
/* renamed from: com.sec.chaton.util.cc */
/* loaded from: classes.dex */
public enum EnumC3215cc {
    FAIL(0),
    SUCCESS(1),
    GOING(2),
    OTHER(-1);


    /* renamed from: e */
    private int f11604e;

    EnumC3215cc(int i) {
        this.f11604e = i;
    }

    /* renamed from: a */
    private int m11271a() {
        return this.f11604e;
    }

    /* renamed from: a */
    public static EnumC3215cc m11273a(int i) {
        EnumC3215cc enumC3215cc = OTHER;
        if (SUCCESS.m11271a() == i) {
            return SUCCESS;
        }
        if (FAIL.m11271a() == i) {
            return FAIL;
        }
        if (GOING.m11271a() == i) {
            return GOING;
        }
        return enumC3215cc;
    }

    /* renamed from: a */
    public static int m11272a(EnumC3215cc enumC3215cc) {
        return enumC3215cc.m11271a();
    }
}
