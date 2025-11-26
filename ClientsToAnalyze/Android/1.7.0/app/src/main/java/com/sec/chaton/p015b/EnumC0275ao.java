package com.sec.chaton.p015b;

import com.google.protobuf.Internal;

/* compiled from: SSMGPB.java */
/* renamed from: com.sec.chaton.b.ao */
/* loaded from: classes.dex */
public enum EnumC0275ao implements Internal.EnumLite {
    TEXT(0, 0),
    MEDIA(1, 1),
    NOTI(2, 2),
    ANS(3, 3);


    /* renamed from: e */
    private static Internal.EnumLiteMap f719e = new Internal.EnumLiteMap() { // from class: com.sec.chaton.b.bx
        @Override // com.google.protobuf.Internal.EnumLiteMap
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public EnumC0275ao findValueByNumber(int i) {
            return EnumC0275ao.m1170a(i);
        }
    };

    /* renamed from: f */
    private final int f721f;

    @Override // com.google.protobuf.Internal.EnumLite
    public final int getNumber() {
        return this.f721f;
    }

    /* renamed from: a */
    public static EnumC0275ao m1170a(int i) {
        switch (i) {
            case 0:
                return TEXT;
            case 1:
                return MEDIA;
            case 2:
                return NOTI;
            case 3:
                return ANS;
            default:
                return null;
        }
    }

    EnumC0275ao(int i, int i2) {
        this.f721f = i2;
    }
}
