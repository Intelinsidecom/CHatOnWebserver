package com.sec.chaton.p016a;

import com.google.protobuf.Internal;

/* compiled from: SSMGPB.java */
/* renamed from: com.sec.chaton.a.az */
/* loaded from: classes.dex */
public enum EnumC0302az implements Internal.EnumLite {
    SINGLE(0, 0),
    GROUP(1, 1),
    BROADCAST(2, 2),
    BR2(3, 3);


    /* renamed from: e */
    private static Internal.EnumLiteMap<EnumC0302az> f996e = new Internal.EnumLiteMap<EnumC0302az>() { // from class: com.sec.chaton.a.ba
        @Override // com.google.protobuf.Internal.EnumLiteMap
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public EnumC0302az findValueByNumber(int i) {
            return EnumC0302az.m1704a(i);
        }
    };

    /* renamed from: f */
    private final int f998f;

    @Override // com.google.protobuf.Internal.EnumLite
    public final int getNumber() {
        return this.f998f;
    }

    /* renamed from: a */
    public static EnumC0302az m1704a(int i) {
        switch (i) {
            case 0:
                return SINGLE;
            case 1:
                return GROUP;
            case 2:
                return BROADCAST;
            case 3:
                return BR2;
            default:
                return null;
        }
    }

    EnumC0302az(int i, int i2) {
        this.f998f = i2;
    }
}
