package com.sec.chaton.p046a;

import com.google.protobuf.Internal;

/* compiled from: SSMGPB.java */
/* renamed from: com.sec.chaton.a.be */
/* loaded from: classes.dex */
public enum EnumC0824be implements Internal.EnumLite {
    CONTENT_TEXT(0, 0),
    CONTENT_IMAGE(1, 1),
    CONTENT_VIDEO(2, 2),
    CONTENT_AUDIO(3, 3);


    /* renamed from: e */
    private static Internal.EnumLiteMap<EnumC0824be> f2363e = new Internal.EnumLiteMap<EnumC0824be>() { // from class: com.sec.chaton.a.bf
        @Override // com.google.protobuf.Internal.EnumLiteMap
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public EnumC0824be findValueByNumber(int i) {
            return EnumC0824be.m3578a(i);
        }
    };

    /* renamed from: f */
    private final int f2365f;

    @Override // com.google.protobuf.Internal.EnumLite
    public final int getNumber() {
        return this.f2365f;
    }

    /* renamed from: a */
    public static EnumC0824be m3578a(int i) {
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

    EnumC0824be(int i, int i2) {
        this.f2365f = i2;
    }
}
