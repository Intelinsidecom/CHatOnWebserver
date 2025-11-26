package com.sec.chaton.p046a;

import com.google.protobuf.Internal;

/* compiled from: SSMGPB.java */
/* renamed from: com.sec.chaton.a.eh */
/* loaded from: classes.dex */
public enum EnumC0908eh implements Internal.EnumLite {
    TEXT(0, 0),
    MEDIA(1, 1),
    NOTI(2, 2),
    ANS(3, 3),
    MESSAGE(4, 4),
    MACK(5, 5),
    UNDO(6, 6),
    UNDOCONFIRM(7, 7);


    /* renamed from: i */
    private static Internal.EnumLiteMap<EnumC0908eh> f2842i = new Internal.EnumLiteMap<EnumC0908eh>() { // from class: com.sec.chaton.a.ei
        @Override // com.google.protobuf.Internal.EnumLiteMap
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public EnumC0908eh findValueByNumber(int i) {
            return EnumC0908eh.m4887a(i);
        }
    };

    /* renamed from: j */
    private final int f2844j;

    @Override // com.google.protobuf.Internal.EnumLite
    public final int getNumber() {
        return this.f2844j;
    }

    /* renamed from: a */
    public static EnumC0908eh m4887a(int i) {
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
            case 5:
                return MACK;
            case 6:
                return UNDO;
            case 7:
                return UNDOCONFIRM;
            default:
                return null;
        }
    }

    EnumC0908eh(int i, int i2) {
        this.f2844j = i2;
    }
}
