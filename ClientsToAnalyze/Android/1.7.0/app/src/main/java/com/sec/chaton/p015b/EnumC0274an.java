package com.sec.chaton.p015b;

import com.google.protobuf.Internal;

/* compiled from: SSMGPB.java */
/* renamed from: com.sec.chaton.b.an */
/* loaded from: classes.dex */
public enum EnumC0274an implements Internal.EnumLite {
    ENTER(0, 0),
    LEAVE(1, 1);


    /* renamed from: c */
    private static Internal.EnumLiteMap f712c = new Internal.EnumLiteMap() { // from class: com.sec.chaton.b.h
        @Override // com.google.protobuf.Internal.EnumLiteMap
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public EnumC0274an findValueByNumber(int i) {
            return EnumC0274an.m1169a(i);
        }
    };

    /* renamed from: d */
    private final int f714d;

    @Override // com.google.protobuf.Internal.EnumLite
    public final int getNumber() {
        return this.f714d;
    }

    /* renamed from: a */
    public static EnumC0274an m1169a(int i) {
        switch (i) {
            case 0:
                return ENTER;
            case 1:
                return LEAVE;
            default:
                return null;
        }
    }

    EnumC0274an(int i, int i2) {
        this.f714d = i2;
    }
}
