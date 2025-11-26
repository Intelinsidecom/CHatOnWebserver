package com.sec.chaton.p015b;

import com.google.protobuf.Internal;

/* compiled from: SSMGPB.java */
/* renamed from: com.sec.chaton.b.ci */
/* loaded from: classes.dex */
public enum EnumC0323ci implements Internal.EnumLite {
    SINGLE(0, 0),
    GROUP(1, 1),
    BROADCAST(2, 2);


    /* renamed from: d */
    private static Internal.EnumLiteMap f915d = new Internal.EnumLiteMap() { // from class: com.sec.chaton.b.cb
        @Override // com.google.protobuf.Internal.EnumLiteMap
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public EnumC0323ci findValueByNumber(int i) {
            return EnumC0323ci.m1750a(i);
        }
    };

    /* renamed from: e */
    private final int f917e;

    @Override // com.google.protobuf.Internal.EnumLite
    public final int getNumber() {
        return this.f917e;
    }

    /* renamed from: a */
    public static EnumC0323ci m1750a(int i) {
        switch (i) {
            case 0:
                return SINGLE;
            case 1:
                return GROUP;
            case 2:
                return BROADCAST;
            default:
                return null;
        }
    }

    EnumC0323ci(int i, int i2) {
        this.f917e = i2;
    }
}
