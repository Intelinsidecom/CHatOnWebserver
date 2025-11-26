package com.sec.chaton.chat;

/* compiled from: TypingStateManager.java */
/* renamed from: com.sec.chaton.chat.if */
/* loaded from: classes.dex */
public enum EnumC1787if {
    ACTIVE(1),
    IDLE(0);


    /* renamed from: c */
    private int f6698c;

    EnumC1787if(int i) {
        this.f6698c = i;
    }

    /* renamed from: a */
    public static String m8817a(EnumC1787if enumC1787if) {
        switch (enumC1787if) {
            case ACTIVE:
                return "active";
            case IDLE:
                return "idle";
            default:
                return "idle";
        }
    }

    /* renamed from: a */
    public static EnumC1787if m8816a(String str) {
        EnumC1787if enumC1787if = IDLE;
        if ("active".equalsIgnoreCase(str)) {
            return ACTIVE;
        }
        return enumC1787if;
    }
}
