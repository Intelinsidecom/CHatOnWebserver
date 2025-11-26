package com.sec.chaton.msgsend;

/* compiled from: MsgRequestBlockManager.java */
/* renamed from: com.sec.chaton.msgsend.v */
/* loaded from: classes.dex */
public enum EnumC2714v {
    RELEASE_NOTHING(0),
    RELEASE_ALLOWCHAT(1),
    RELEASE_INITCHAT(2),
    RELEASE_SERIALCHAT(4),
    RELEASE_I_A(3),
    RELEASE_A_S(5),
    RELEASE_I_S(6),
    RELEASE_I_A_S(7);


    /* renamed from: i */
    private final int f9732i;

    /* renamed from: a */
    static EnumC2714v m11364a(int i) {
        for (EnumC2714v enumC2714v : values()) {
            if (enumC2714v.m11366a() == i) {
                return enumC2714v;
            }
        }
        return RELEASE_NOTHING;
    }

    EnumC2714v(int i) {
        this.f9732i = i;
    }

    /* renamed from: a */
    public int m11366a() {
        return this.f9732i;
    }

    /* renamed from: a */
    static EnumC2714v m11365a(EnumC2714v enumC2714v, EnumC2714v enumC2714v2) {
        return m11364a(enumC2714v.f9732i | enumC2714v2.m11366a());
    }

    /* renamed from: a */
    boolean m11367a(EnumC2714v enumC2714v) {
        return (this.f9732i & enumC2714v.m11366a()) != 0;
    }
}
