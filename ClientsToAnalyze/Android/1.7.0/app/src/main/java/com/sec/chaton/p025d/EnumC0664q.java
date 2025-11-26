package com.sec.chaton.p025d;

/* compiled from: ChatONContract.java */
/* renamed from: com.sec.chaton.d.q */
/* loaded from: classes.dex */
public enum EnumC0664q {
    UNKNOWN(-99),
    INVITE(0),
    ENTER(1),
    LEAVE(2),
    INVALID_USER(3),
    MEMBER(4);


    /* renamed from: g */
    private int f2298g;

    EnumC0664q(int i) {
        this.f2298g = i;
    }

    /* renamed from: a */
    public int m3010a() {
        return this.f2298g;
    }

    /* renamed from: a */
    public static EnumC0664q m3008a(int i) {
        switch (i) {
            case 0:
                return INVITE;
            case 1:
                return ENTER;
            case 2:
                return LEAVE;
            case 3:
                return INVALID_USER;
            case 4:
                return MEMBER;
            default:
                return UNKNOWN;
        }
    }

    /* renamed from: a */
    public static EnumC0664q m3009a(String str) {
        if ("LEAVE".equals(str)) {
            return LEAVE;
        }
        if ("ENTER".equals(str)) {
            return ENTER;
        }
        if ("INVITE".equals(str)) {
            return INVITE;
        }
        if ("INVALID_USER".equals(str)) {
            return INVALID_USER;
        }
        if ("MEMBER".equals(str)) {
            return MEMBER;
        }
        return UNKNOWN;
    }
}
