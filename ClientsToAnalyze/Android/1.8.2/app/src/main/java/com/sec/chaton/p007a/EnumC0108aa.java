package com.sec.chaton.p007a;

import com.google.protobuf.Internal;

/* compiled from: SSMGPB.java */
/* renamed from: com.sec.chaton.a.aa */
/* loaded from: classes.dex */
public enum EnumC0108aa implements Internal.EnumLite {
    ENTER(0, 0),
    LEAVE(1, 1);


    /* renamed from: c */
    private static Internal.EnumLiteMap f348c = new Internal.EnumLiteMap() { // from class: com.sec.chaton.a.ab
        @Override // com.google.protobuf.Internal.EnumLiteMap
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public EnumC0108aa findValueByNumber(int i) {
            return EnumC0108aa.m690a(i);
        }
    };

    /* renamed from: d */
    private final int f350d;

    @Override // com.google.protobuf.Internal.EnumLite
    public final int getNumber() {
        return this.f350d;
    }

    /* renamed from: a */
    public static EnumC0108aa m690a(int i) {
        switch (i) {
            case 0:
                return ENTER;
            case 1:
                return LEAVE;
            default:
                return null;
        }
    }

    EnumC0108aa(int i, int i2) {
        this.f350d = i2;
    }
}
