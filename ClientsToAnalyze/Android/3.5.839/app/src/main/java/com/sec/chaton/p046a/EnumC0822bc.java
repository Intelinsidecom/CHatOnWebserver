package com.sec.chaton.p046a;

import com.google.protobuf.Internal;

/* compiled from: SSMGPB.java */
/* renamed from: com.sec.chaton.a.bc */
/* loaded from: classes.dex */
public enum EnumC0822bc implements Internal.EnumLite {
    SINGLE(0, 0),
    GROUP(1, 1),
    BROADCAST(2, 2),
    BR2(3, 3),
    MONOLOGUE(4, 4),
    TOPIC(5, 5),
    SQUARE(6, 6),
    SECURE(7, 7);


    /* renamed from: i */
    private static Internal.EnumLiteMap<EnumC0822bc> f2356i = new Internal.EnumLiteMap<EnumC0822bc>() { // from class: com.sec.chaton.a.bd
        @Override // com.google.protobuf.Internal.EnumLiteMap
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public EnumC0822bc findValueByNumber(int i) {
            return EnumC0822bc.m3576a(i);
        }
    };

    /* renamed from: j */
    private final int f2358j;

    @Override // com.google.protobuf.Internal.EnumLite
    public final int getNumber() {
        return this.f2358j;
    }

    /* renamed from: a */
    public static EnumC0822bc m3576a(int i) {
        switch (i) {
            case 0:
                return SINGLE;
            case 1:
                return GROUP;
            case 2:
                return BROADCAST;
            case 3:
                return BR2;
            case 4:
                return MONOLOGUE;
            case 5:
                return TOPIC;
            case 6:
                return SQUARE;
            case 7:
                return SECURE;
            default:
                return null;
        }
    }

    EnumC0822bc(int i, int i2) {
        this.f2358j = i2;
    }
}
