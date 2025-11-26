package com.sec.chaton.p046a;

import com.google.protobuf.Internal;

/* compiled from: SSMGPB.java */
/* renamed from: com.sec.chaton.a.bp */
/* loaded from: classes.dex */
public enum EnumC0835bp implements Internal.EnumLite {
    CLOSE(0, 0),
    HOLD_ON(1, 1);


    /* renamed from: c */
    private static Internal.EnumLiteMap<EnumC0835bp> f2417c = new Internal.EnumLiteMap<EnumC0835bp>() { // from class: com.sec.chaton.a.bq
        @Override // com.google.protobuf.Internal.EnumLiteMap
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public EnumC0835bp findValueByNumber(int i) {
            return EnumC0835bp.m3725a(i);
        }
    };

    /* renamed from: d */
    private final int f2419d;

    @Override // com.google.protobuf.Internal.EnumLite
    public final int getNumber() {
        return this.f2419d;
    }

    /* renamed from: a */
    public static EnumC0835bp m3725a(int i) {
        switch (i) {
            case 0:
                return CLOSE;
            case 1:
                return HOLD_ON;
            default:
                return null;
        }
    }

    EnumC0835bp(int i, int i2) {
        this.f2419d = i2;
    }
}
