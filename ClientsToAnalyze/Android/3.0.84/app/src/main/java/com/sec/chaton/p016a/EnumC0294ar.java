package com.sec.chaton.p016a;

import com.google.protobuf.Internal;

/* compiled from: SSMGPB.java */
/* renamed from: com.sec.chaton.a.ar */
/* loaded from: classes.dex */
public enum EnumC0294ar implements Internal.EnumLite {
    ENTER(0, 0),
    LEAVE(1, 1);


    /* renamed from: c */
    private static Internal.EnumLiteMap<EnumC0294ar> f947c = new Internal.EnumLiteMap<EnumC0294ar>() { // from class: com.sec.chaton.a.as
        @Override // com.google.protobuf.Internal.EnumLiteMap
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public EnumC0294ar findValueByNumber(int i) {
            return EnumC0294ar.m1583a(i);
        }
    };

    /* renamed from: d */
    private final int f949d;

    @Override // com.google.protobuf.Internal.EnumLite
    public final int getNumber() {
        return this.f949d;
    }

    /* renamed from: a */
    public static EnumC0294ar m1583a(int i) {
        switch (i) {
            case 0:
                return ENTER;
            case 1:
                return LEAVE;
            default:
                return null;
        }
    }

    EnumC0294ar(int i, int i2) {
        this.f949d = i2;
    }
}
