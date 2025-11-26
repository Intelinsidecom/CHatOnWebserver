package com.sec.chaton.util;

import com.sec.chaton.p027e.EnumC1450r;

/* compiled from: ProfileImageLoader.java */
/* renamed from: com.sec.chaton.util.bv */
/* loaded from: classes.dex */
/* synthetic */ class C3207bv {

    /* renamed from: a */
    static final /* synthetic */ int[] f11574a;

    /* renamed from: b */
    static final /* synthetic */ int[] f11575b = new int[EnumC1450r.values().length];

    static {
        try {
            f11575b[EnumC1450r.ONETOONE.ordinal()] = 1;
        } catch (NoSuchFieldError e) {
        }
        try {
            f11575b[EnumC1450r.GROUPCHAT.ordinal()] = 2;
        } catch (NoSuchFieldError e2) {
        }
        try {
            f11575b[EnumC1450r.BROADCAST.ordinal()] = 3;
        } catch (NoSuchFieldError e3) {
        }
        try {
            f11575b[EnumC1450r.BROADCAST2.ordinal()] = 4;
        } catch (NoSuchFieldError e4) {
        }
        f11574a = new int[EnumC3208bw.values().length];
        try {
            f11574a[EnumC3208bw.BROADCAST.ordinal()] = 1;
        } catch (NoSuchFieldError e5) {
        }
        try {
            f11574a[EnumC3208bw.GROUP.ordinal()] = 2;
        } catch (NoSuchFieldError e6) {
        }
        try {
            f11574a[EnumC3208bw.BUDDY.ordinal()] = 3;
        } catch (NoSuchFieldError e7) {
        }
        try {
            f11574a[EnumC3208bw.CHAT_GROUP.ordinal()] = 4;
        } catch (NoSuchFieldError e8) {
        }
    }
}
