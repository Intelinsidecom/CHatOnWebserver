package com.sec.chaton.p057e;

/* compiled from: ChatONContract.java */
/* renamed from: com.sec.chaton.e.as */
/* loaded from: classes.dex */
public enum EnumC2231as {
    UNKNOWN(-99),
    INVITE(0),
    ENTER(1),
    LEAVE(2),
    INVALID_USER(3),
    MEMBER(4),
    MARK(5),
    DEACTIVATED(6),
    TRANSLATE_ON(7),
    TRANSLATE_OFF(8),
    WEB_ONLY(9),
    OFFLINE_USER(10),
    INVITE_CONTACT(11),
    HUGEFILE(12),
    CANCELED_MESSAGE_FAILURE(13),
    SESSION_TITLE_UPDATED(14);


    /* renamed from: q */
    private final int f7976q;

    EnumC2231as(int i) {
        this.f7976q = i;
    }

    /* renamed from: a */
    public int m10100a() {
        return this.f7976q;
    }

    /* renamed from: a */
    public static EnumC2231as m10098a(int i) {
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
            case 9:
                return WEB_ONLY;
            case 10:
                return OFFLINE_USER;
            case 11:
                return INVITE_CONTACT;
            case 12:
                return HUGEFILE;
            case 13:
                return CANCELED_MESSAGE_FAILURE;
            case 14:
                return SESSION_TITLE_UPDATED;
            default:
                return UNKNOWN;
        }
    }

    /* renamed from: a */
    public static EnumC2231as m10099a(String str) {
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
        if ("WEB_ONLY".equals(str)) {
            return WEB_ONLY;
        }
        if ("OFFLINE_USER".equals(str)) {
            return OFFLINE_USER;
        }
        if ("HUGEFILE".equals(str)) {
            return HUGEFILE;
        }
        if ("INVITE_CONTACT".equals(str)) {
            return INVITE_CONTACT;
        }
        if ("CANCELED_MESSAGE_FAILURE".equals(str)) {
            return INVITE_CONTACT;
        }
        if ("SESSION_TITLE_UPDATED".equals(str)) {
            return SESSION_TITLE_UPDATED;
        }
        return UNKNOWN;
    }
}
