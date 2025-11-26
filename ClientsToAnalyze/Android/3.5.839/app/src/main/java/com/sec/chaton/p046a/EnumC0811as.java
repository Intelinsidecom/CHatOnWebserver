package com.sec.chaton.p046a;

import com.google.protobuf.Internal;

/* compiled from: SSMGPB.java */
/* renamed from: com.sec.chaton.a.as */
/* loaded from: classes.dex */
public enum EnumC0811as implements Internal.EnumLite {
    ADD(0, 0),
    REMOVE(1, 1);


    /* renamed from: c */
    private static Internal.EnumLiteMap<EnumC0811as> f2277c = new Internal.EnumLiteMap<EnumC0811as>() { // from class: com.sec.chaton.a.at
        @Override // com.google.protobuf.Internal.EnumLiteMap
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public EnumC0811as findValueByNumber(int i) {
            return EnumC0811as.m3426a(i);
        }
    };

    /* renamed from: d */
    private final int f2279d;

    @Override // com.google.protobuf.Internal.EnumLite
    public final int getNumber() {
        return this.f2279d;
    }

    /* renamed from: a */
    public static EnumC0811as m3426a(int i) {
        switch (i) {
            case 0:
                return ADD;
            case 1:
                return REMOVE;
            default:
                return null;
        }
    }

    EnumC0811as(int i, int i2) {
        this.f2279d = i2;
    }
}
