package com.sec.chaton.p046a;

import com.google.protobuf.Internal;

/* compiled from: SSMGPB.java */
/* renamed from: com.sec.chaton.a.au */
/* loaded from: classes.dex */
public enum EnumC0813au implements Internal.EnumLite {
    ENTER(0, 0),
    LEAVE(1, 1),
    DEREGISTERED(2, 2),
    REGISTERED(3, 3),
    OWNER(4, 4),
    SECURE_INVITED(5, 5),
    ACCEPTED(6, 6),
    EXPELLED(7, 7),
    LOST_SECURE_KEY(8, 8),
    SESSION_DESTROY_SCHEDULED(9, 9),
    SESSION_TITLE_UPDATED(10, 10);


    /* renamed from: l */
    private static Internal.EnumLiteMap<EnumC0813au> f2291l = new Internal.EnumLiteMap<EnumC0813au>() { // from class: com.sec.chaton.a.av
        @Override // com.google.protobuf.Internal.EnumLiteMap
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public EnumC0813au findValueByNumber(int i) {
            return EnumC0813au.m3428a(i);
        }
    };

    /* renamed from: m */
    private final int f2293m;

    @Override // com.google.protobuf.Internal.EnumLite
    public final int getNumber() {
        return this.f2293m;
    }

    /* renamed from: a */
    public static EnumC0813au m3428a(int i) {
        switch (i) {
            case 0:
                return ENTER;
            case 1:
                return LEAVE;
            case 2:
                return DEREGISTERED;
            case 3:
                return REGISTERED;
            case 4:
                return OWNER;
            case 5:
                return SECURE_INVITED;
            case 6:
                return ACCEPTED;
            case 7:
                return EXPELLED;
            case 8:
                return LOST_SECURE_KEY;
            case 9:
                return SESSION_DESTROY_SCHEDULED;
            case 10:
                return SESSION_TITLE_UPDATED;
            default:
                return null;
        }
    }

    EnumC0813au(int i, int i2) {
        this.f2293m = i2;
    }
}
