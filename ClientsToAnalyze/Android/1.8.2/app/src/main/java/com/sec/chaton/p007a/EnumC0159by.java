package com.sec.chaton.p007a;

import com.google.protobuf.Internal;

/* compiled from: SSMGPB.java */
/* renamed from: com.sec.chaton.a.by */
/* loaded from: classes.dex */
public enum EnumC0159by implements Internal.EnumLite {
    TEXT(0, 0),
    MEDIA(1, 1),
    NOTI(2, 2),
    ANS(3, 3);


    /* renamed from: e */
    private static Internal.EnumLiteMap f583e = new Internal.EnumLiteMap() { // from class: com.sec.chaton.a.bz
        @Override // com.google.protobuf.Internal.EnumLiteMap
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public EnumC0159by findValueByNumber(int i) {
            return EnumC0159by.m1347a(i);
        }
    };

    /* renamed from: f */
    private final int f585f;

    @Override // com.google.protobuf.Internal.EnumLite
    public final int getNumber() {
        return this.f585f;
    }

    /* renamed from: a */
    public static EnumC0159by m1347a(int i) {
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

    EnumC0159by(int i, int i2) {
        this.f585f = i2;
    }
}
