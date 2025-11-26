package com.sec.chaton.p007a;

import com.google.protobuf.Internal;

/* compiled from: SSMGPB.java */
/* renamed from: com.sec.chaton.a.ai */
/* loaded from: classes.dex */
public enum EnumC0116ai implements Internal.EnumLite {
    SINGLE(0, 0),
    GROUP(1, 1),
    BROADCAST(2, 2);


    /* renamed from: d */
    private static Internal.EnumLiteMap f394d = new Internal.EnumLiteMap() { // from class: com.sec.chaton.a.aj
        @Override // com.google.protobuf.Internal.EnumLiteMap
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public EnumC0116ai findValueByNumber(int i) {
            return EnumC0116ai.m813a(i);
        }
    };

    /* renamed from: e */
    private final int f396e;

    @Override // com.google.protobuf.Internal.EnumLite
    public final int getNumber() {
        return this.f396e;
    }

    /* renamed from: a */
    public static EnumC0116ai m813a(int i) {
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

    EnumC0116ai(int i, int i2) {
        this.f396e = i2;
    }
}
