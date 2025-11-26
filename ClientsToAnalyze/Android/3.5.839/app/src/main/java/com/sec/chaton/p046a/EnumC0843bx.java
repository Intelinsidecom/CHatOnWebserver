package com.sec.chaton.p046a;

import com.google.protobuf.Internal;

/* compiled from: SSMGPB.java */
/* renamed from: com.sec.chaton.a.bx */
/* loaded from: classes.dex */
public enum EnumC0843bx implements Internal.EnumLite {
    TIMEOUT(0, 0),
    GROUPCHAT_END(1, 1);


    /* renamed from: c */
    private static Internal.EnumLiteMap<EnumC0843bx> f2444c = new Internal.EnumLiteMap<EnumC0843bx>() { // from class: com.sec.chaton.a.by
        @Override // com.google.protobuf.Internal.EnumLiteMap
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public EnumC0843bx findValueByNumber(int i) {
            return EnumC0843bx.m3797a(i);
        }
    };

    /* renamed from: d */
    private final int f2446d;

    @Override // com.google.protobuf.Internal.EnumLite
    public final int getNumber() {
        return this.f2446d;
    }

    /* renamed from: a */
    public static EnumC0843bx m3797a(int i) {
        switch (i) {
            case 0:
                return TIMEOUT;
            case 1:
                return GROUPCHAT_END;
            default:
                return null;
        }
    }

    EnumC0843bx(int i, int i2) {
        this.f2446d = i2;
    }
}
