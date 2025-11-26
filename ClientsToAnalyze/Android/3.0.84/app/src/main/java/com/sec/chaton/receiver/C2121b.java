package com.sec.chaton.receiver;

import com.sec.chaton.p027e.EnumC1450r;

/* compiled from: PushReceiver.java */
/* renamed from: com.sec.chaton.receiver.b */
/* loaded from: classes.dex */
/* synthetic */ class C2121b {

    /* renamed from: a */
    static final /* synthetic */ int[] f8075a = new int[EnumC1450r.values().length];

    static {
        try {
            f8075a[EnumC1450r.ONETOONE.ordinal()] = 1;
        } catch (NoSuchFieldError e) {
        }
        try {
            f8075a[EnumC1450r.BROADCAST.ordinal()] = 2;
        } catch (NoSuchFieldError e2) {
        }
        try {
            f8075a[EnumC1450r.GROUPCHAT.ordinal()] = 3;
        } catch (NoSuchFieldError e3) {
        }
        try {
            f8075a[EnumC1450r.WEB_AUTH.ordinal()] = 4;
        } catch (NoSuchFieldError e4) {
        }
    }
}
