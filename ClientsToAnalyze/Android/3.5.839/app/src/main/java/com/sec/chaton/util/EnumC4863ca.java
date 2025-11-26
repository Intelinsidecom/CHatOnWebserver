package com.sec.chaton.util;

/* compiled from: RegistrationUtil.java */
/* renamed from: com.sec.chaton.util.ca */
/* loaded from: classes.dex */
public enum EnumC4863ca {
    FAIL(0),
    SUCCESS(1),
    GOING(2),
    OTHER(-1);


    /* renamed from: e */
    private int f17695e;

    EnumC4863ca(int i) {
        this.f17695e = i;
    }

    /* renamed from: a */
    private int m18418a() {
        return this.f17695e;
    }

    /* renamed from: a */
    public static EnumC4863ca m18420a(int i) {
        EnumC4863ca enumC4863ca = OTHER;
        if (SUCCESS.m18418a() == i) {
            return SUCCESS;
        }
        if (FAIL.m18418a() == i) {
            return FAIL;
        }
        if (GOING.m18418a() == i) {
            return GOING;
        }
        return enumC4863ca;
    }

    /* renamed from: a */
    public static int m18419a(EnumC4863ca enumC4863ca) {
        return enumC4863ca.m18418a();
    }
}
