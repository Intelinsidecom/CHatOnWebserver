package com.sec.chaton.p007a;

import com.google.protobuf.Internal;

/* compiled from: SSMGPB.java */
/* renamed from: com.sec.chaton.a.at */
/* loaded from: classes.dex */
public enum EnumC0127at implements Internal.EnumLite {
    CLOSE(0, 0),
    HOLD_ON(1, 1);


    /* renamed from: c */
    private static Internal.EnumLiteMap f438c = new Internal.EnumLiteMap() { // from class: com.sec.chaton.a.au
        @Override // com.google.protobuf.Internal.EnumLiteMap
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public EnumC0127at findValueByNumber(int i) {
            return EnumC0127at.m937a(i);
        }
    };

    /* renamed from: d */
    private final int f440d;

    @Override // com.google.protobuf.Internal.EnumLite
    public final int getNumber() {
        return this.f440d;
    }

    /* renamed from: a */
    public static EnumC0127at m937a(int i) {
        switch (i) {
            case 0:
                return CLOSE;
            case 1:
                return HOLD_ON;
            default:
                return null;
        }
    }

    EnumC0127at(int i, int i2) {
        this.f440d = i2;
    }
}
