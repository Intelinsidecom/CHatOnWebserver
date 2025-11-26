package com.sec.chaton.p016a;

import com.google.protobuf.Internal;

/* compiled from: SSMGPB.java */
/* renamed from: com.sec.chaton.a.bb */
/* loaded from: classes.dex */
public enum EnumC0305bb implements Internal.EnumLite {
    CONTENT_TEXT(0, 0),
    CONTENT_IMAGE(1, 1),
    CONTENT_VIDEO(2, 2),
    CONTENT_AUDIO(3, 3);


    /* renamed from: e */
    private static Internal.EnumLiteMap<EnumC0305bb> f1003e = new Internal.EnumLiteMap<EnumC0305bb>() { // from class: com.sec.chaton.a.bc
        @Override // com.google.protobuf.Internal.EnumLiteMap
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public EnumC0305bb findValueByNumber(int i) {
            return EnumC0305bb.m1706a(i);
        }
    };

    /* renamed from: f */
    private final int f1005f;

    @Override // com.google.protobuf.Internal.EnumLite
    public final int getNumber() {
        return this.f1005f;
    }

    /* renamed from: a */
    public static EnumC0305bb m1706a(int i) {
        switch (i) {
            case 0:
                return CONTENT_TEXT;
            case 1:
                return CONTENT_IMAGE;
            case 2:
                return CONTENT_VIDEO;
            case 3:
                return CONTENT_AUDIO;
            default:
                return null;
        }
    }

    EnumC0305bb(int i, int i2) {
        this.f1005f = i2;
    }
}
