package com.sec.chaton.p016a;

import com.google.protobuf.Internal;

/* compiled from: SSMGPB.java */
/* renamed from: com.sec.chaton.a.bu */
/* loaded from: classes.dex */
public enum EnumC0324bu implements Internal.EnumLite {
    TIMEOUT(0, 0),
    GROUPCHAT_END(1, 1);


    /* renamed from: c */
    private static Internal.EnumLiteMap<EnumC0324bu> f1082c = new Internal.EnumLiteMap<EnumC0324bu>() { // from class: com.sec.chaton.a.bv
        @Override // com.google.protobuf.Internal.EnumLiteMap
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public EnumC0324bu findValueByNumber(int i) {
            return EnumC0324bu.m1921a(i);
        }
    };

    /* renamed from: d */
    private final int f1084d;

    @Override // com.google.protobuf.Internal.EnumLite
    public final int getNumber() {
        return this.f1084d;
    }

    /* renamed from: a */
    public static EnumC0324bu m1921a(int i) {
        switch (i) {
            case 0:
                return TIMEOUT;
            case 1:
                return GROUPCHAT_END;
            default:
                return null;
        }
    }

    EnumC0324bu(int i, int i2) {
        this.f1084d = i2;
    }
}
