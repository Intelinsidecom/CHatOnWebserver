package com.sec.chaton.p015b;

import com.google.protobuf.Internal;

/* compiled from: SSMGPB.java */
/* renamed from: com.sec.chaton.b.o */
/* loaded from: classes.dex */
public enum EnumC0341o implements Internal.EnumLite {
    CLOSE(0, 0),
    HOLD_ON(1, 1);


    /* renamed from: c */
    private static Internal.EnumLiteMap f984c = new Internal.EnumLiteMap() { // from class: com.sec.chaton.b.d
        @Override // com.google.protobuf.Internal.EnumLiteMap
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public EnumC0341o findValueByNumber(int i) {
            return EnumC0341o.m1946a(i);
        }
    };

    /* renamed from: d */
    private final int f986d;

    @Override // com.google.protobuf.Internal.EnumLite
    public final int getNumber() {
        return this.f986d;
    }

    /* renamed from: a */
    public static EnumC0341o m1946a(int i) {
        switch (i) {
            case 0:
                return CLOSE;
            case 1:
                return HOLD_ON;
            default:
                return null;
        }
    }

    EnumC0341o(int i, int i2) {
        this.f986d = i2;
    }
}
