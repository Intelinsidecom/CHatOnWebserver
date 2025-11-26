package com.sec.chaton.p016a;

import com.google.protobuf.Internal;

/* compiled from: SSMGPB.java */
/* renamed from: com.sec.chaton.a.bm */
/* loaded from: classes.dex */
public enum EnumC0316bm implements Internal.EnumLite {
    CLOSE(0, 0),
    HOLD_ON(1, 1);


    /* renamed from: c */
    private static Internal.EnumLiteMap<EnumC0316bm> f1055c = new Internal.EnumLiteMap<EnumC0316bm>() { // from class: com.sec.chaton.a.bn
        @Override // com.google.protobuf.Internal.EnumLiteMap
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public EnumC0316bm findValueByNumber(int i) {
            return EnumC0316bm.m1849a(i);
        }
    };

    /* renamed from: d */
    private final int f1057d;

    @Override // com.google.protobuf.Internal.EnumLite
    public final int getNumber() {
        return this.f1057d;
    }

    /* renamed from: a */
    public static EnumC0316bm m1849a(int i) {
        switch (i) {
            case 0:
                return CLOSE;
            case 1:
                return HOLD_ON;
            default:
                return null;
        }
    }

    EnumC0316bm(int i, int i2) {
        this.f1057d = i2;
    }
}
