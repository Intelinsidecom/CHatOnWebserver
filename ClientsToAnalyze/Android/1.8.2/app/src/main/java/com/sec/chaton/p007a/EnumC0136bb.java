package com.sec.chaton.p007a;

import com.google.protobuf.Internal;

/* compiled from: SSMGPB.java */
/* renamed from: com.sec.chaton.a.bb */
/* loaded from: classes.dex */
public enum EnumC0136bb implements Internal.EnumLite {
    TIMEOUT(0, 0),
    GROUPCHAT_END(1, 1);


    /* renamed from: c */
    private static Internal.EnumLiteMap f465c = new Internal.EnumLiteMap() { // from class: com.sec.chaton.a.bc
        @Override // com.google.protobuf.Internal.EnumLiteMap
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public EnumC0136bb findValueByNumber(int i) {
            return EnumC0136bb.m1009a(i);
        }
    };

    /* renamed from: d */
    private final int f467d;

    @Override // com.google.protobuf.Internal.EnumLite
    public final int getNumber() {
        return this.f467d;
    }

    /* renamed from: a */
    public static EnumC0136bb m1009a(int i) {
        switch (i) {
            case 0:
                return TIMEOUT;
            case 1:
                return GROUPCHAT_END;
            default:
                return null;
        }
    }

    EnumC0136bb(int i, int i2) {
        this.f467d = i2;
    }
}
