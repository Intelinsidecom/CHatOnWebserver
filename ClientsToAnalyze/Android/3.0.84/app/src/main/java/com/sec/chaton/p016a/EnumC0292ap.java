package com.sec.chaton.p016a;

import com.google.protobuf.Internal;

/* compiled from: SSMGPB.java */
/* renamed from: com.sec.chaton.a.ap */
/* loaded from: classes.dex */
public enum EnumC0292ap implements Internal.EnumLite {
    ADD(0, 0),
    REMOVE(1, 1);


    /* renamed from: c */
    private static Internal.EnumLiteMap<EnumC0292ap> f942c = new Internal.EnumLiteMap<EnumC0292ap>() { // from class: com.sec.chaton.a.aq
        @Override // com.google.protobuf.Internal.EnumLiteMap
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public EnumC0292ap findValueByNumber(int i) {
            return EnumC0292ap.m1581a(i);
        }
    };

    /* renamed from: d */
    private final int f944d;

    @Override // com.google.protobuf.Internal.EnumLite
    public final int getNumber() {
        return this.f944d;
    }

    /* renamed from: a */
    public static EnumC0292ap m1581a(int i) {
        switch (i) {
            case 0:
                return ADD;
            case 1:
                return REMOVE;
            default:
                return null;
        }
    }

    EnumC0292ap(int i, int i2) {
        this.f944d = i2;
    }
}
