package com.sec.chaton.p016a;

import com.google.protobuf.Internal;

/* compiled from: SSMGPB.java */
/* renamed from: com.sec.chaton.a.cx */
/* loaded from: classes.dex */
public enum EnumC0354cx implements Internal.EnumLite {
    TEXT(0, 0),
    MEDIA(1, 1),
    NOTI(2, 2),
    ANS(3, 3),
    MESSAGE(4, 4);


    /* renamed from: f */
    private static Internal.EnumLiteMap<EnumC0354cx> f1237f = new Internal.EnumLiteMap<EnumC0354cx>() { // from class: com.sec.chaton.a.cy
        @Override // com.google.protobuf.Internal.EnumLiteMap
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public EnumC0354cx findValueByNumber(int i) {
            return EnumC0354cx.m2352a(i);
        }
    };

    /* renamed from: g */
    private final int f1239g;

    @Override // com.google.protobuf.Internal.EnumLite
    public final int getNumber() {
        return this.f1239g;
    }

    /* renamed from: a */
    public static EnumC0354cx m2352a(int i) {
        switch (i) {
            case 0:
                return TEXT;
            case 1:
                return MEDIA;
            case 2:
                return NOTI;
            case 3:
                return ANS;
            case 4:
                return MESSAGE;
            default:
                return null;
        }
    }

    EnumC0354cx(int i, int i2) {
        this.f1239g = i2;
    }
}
