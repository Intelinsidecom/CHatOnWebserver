package com.sec.chaton.p027e;

/* compiled from: ChatONContract.java */
/* renamed from: com.sec.chaton.e.ai */
/* loaded from: classes.dex */
public enum EnumC1391ai {
    UNKNOWN(-99),
    INVITE(0),
    ENTER(1),
    LEAVE(2),
    INVALID_USER(3),
    MEMBER(4),
    MARK(5),
    DEACTIVATED(6),
    TRANSLATE_ON(7),
    TRANSLATE_OFF(8);


    /* renamed from: k */
    private int f5200k;

    EnumC1391ai(int i) {
        this.f5200k = i;
    }

    /* renamed from: a */
    public int m6248a() {
        return this.f5200k;
    }

    /* renamed from: a */
    public static EnumC1391ai m6246a(int i) {
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
            case 5:
                return MARK;
            case 6:
                return DEACTIVATED;
            case 7:
                return TRANSLATE_ON;
            case 8:
                return TRANSLATE_OFF;
            default:
                return UNKNOWN;
        }
    }

    /* renamed from: a */
    public static EnumC1391ai m6247a(String str) {
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
        if ("MARK".equals(str)) {
            return MARK;
        }
        if ("DEACTIVATED".equals(str)) {
            return DEACTIVATED;
        }
        if ("TRANSLATED_ON".equals(str)) {
            return TRANSLATE_ON;
        }
        if ("TRANSLATED_OFF".equals(str)) {
            return TRANSLATE_OFF;
        }
        return UNKNOWN;
    }
}
