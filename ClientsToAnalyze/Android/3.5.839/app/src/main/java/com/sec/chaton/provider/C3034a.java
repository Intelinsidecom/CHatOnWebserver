package com.sec.chaton.provider;

import com.sec.chaton.p057e.EnumC2300t;
import com.sec.chaton.p057e.p058a.EnumC2209w;
import com.sec.chaton.specialbuddy.EnumC4549n;

/* compiled from: ChatONProvider.java */
/* renamed from: com.sec.chaton.provider.a */
/* loaded from: classes.dex */
/* synthetic */ class C3034a {

    /* renamed from: a */
    static final /* synthetic */ int[] f11243a;

    /* renamed from: b */
    static final /* synthetic */ int[] f11244b;

    /* renamed from: c */
    static final /* synthetic */ int[] f11245c = new int[EnumC4549n.values().length];

    static {
        try {
            f11245c[EnumC4549n.LIVECHAT.ordinal()] = 1;
        } catch (NoSuchFieldError e) {
        }
        try {
            f11245c[EnumC4549n.LIVECONTENTS.ordinal()] = 2;
        } catch (NoSuchFieldError e2) {
        }
        f11244b = new int[EnumC2300t.values().length];
        try {
            f11244b[EnumC2300t.BROADCAST.ordinal()] = 1;
        } catch (NoSuchFieldError e3) {
        }
        try {
            f11244b[EnumC2300t.ONETOONE.ordinal()] = 2;
        } catch (NoSuchFieldError e4) {
        }
        try {
            f11244b[EnumC2300t.TOPIC.ordinal()] = 3;
        } catch (NoSuchFieldError e5) {
        }
        try {
            f11244b[EnumC2300t.GROUPCHAT.ordinal()] = 4;
        } catch (NoSuchFieldError e6) {
        }
        try {
            f11244b[EnumC2300t.BROADCAST2.ordinal()] = 5;
        } catch (NoSuchFieldError e7) {
        }
        try {
            f11244b[EnumC2300t.MONOLOGUE.ordinal()] = 6;
        } catch (NoSuchFieldError e8) {
        }
        f11243a = new int[EnumC2209w.values().length];
        try {
            f11243a[EnumC2209w.NOT_DETERMINED.ordinal()] = 1;
        } catch (NoSuchFieldError e9) {
        }
        try {
            f11243a[EnumC2209w.NOT_PHONE_NUMBER.ordinal()] = 2;
        } catch (NoSuchFieldError e10) {
        }
        try {
            f11243a[EnumC2209w.PHONE_NUMBER_BELOW_DIGIT_8.ordinal()] = 3;
        } catch (NoSuchFieldError e11) {
        }
        try {
            f11243a[EnumC2209w.PHONE_NUMBER_DIGIT_8_AND_OVER.ordinal()] = 4;
        } catch (NoSuchFieldError e12) {
        }
    }
}
