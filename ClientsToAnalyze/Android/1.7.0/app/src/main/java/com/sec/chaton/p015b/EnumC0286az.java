package com.sec.chaton.p015b;

import com.google.protobuf.Internal;

/* compiled from: SSMGPB.java */
/* renamed from: com.sec.chaton.b.az */
/* loaded from: classes.dex */
public enum EnumC0286az implements Internal.EnumLite {
    TIMEOUT(0, 0),
    GROUPCHAT_END(1, 1);


    /* renamed from: c */
    private static Internal.EnumLiteMap f766c = new Internal.EnumLiteMap() { // from class: com.sec.chaton.b.n
        @Override // com.google.protobuf.Internal.EnumLiteMap
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public EnumC0286az findValueByNumber(int i) {
            return EnumC0286az.m1296a(i);
        }
    };

    /* renamed from: d */
    private final int f768d;

    @Override // com.google.protobuf.Internal.EnumLite
    public final int getNumber() {
        return this.f768d;
    }

    /* renamed from: a */
    public static EnumC0286az m1296a(int i) {
        switch (i) {
            case 0:
                return TIMEOUT;
            case 1:
                return GROUPCHAT_END;
            default:
                return null;
        }
    }

    EnumC0286az(int i, int i2) {
        this.f768d = i2;
    }
}
