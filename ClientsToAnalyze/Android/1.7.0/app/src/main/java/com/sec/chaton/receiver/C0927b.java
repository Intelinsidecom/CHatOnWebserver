package com.sec.chaton.receiver;

import com.sec.chaton.p025d.EnumC0665r;

/* compiled from: PushReceiver.java */
/* renamed from: com.sec.chaton.receiver.b */
/* loaded from: classes.dex */
/* synthetic */ class C0927b {

    /* renamed from: a */
    static final /* synthetic */ int[] f3138a = new int[EnumC0665r.values().length];

    static {
        try {
            f3138a[EnumC0665r.ONETOONE.ordinal()] = 1;
        } catch (NoSuchFieldError e) {
        }
        try {
            f3138a[EnumC0665r.BROADCAST.ordinal()] = 2;
        } catch (NoSuchFieldError e2) {
        }
        try {
            f3138a[EnumC0665r.GROUPCHAT.ordinal()] = 3;
        } catch (NoSuchFieldError e3) {
        }
        try {
            f3138a[EnumC0665r.WEB_AUTH.ordinal()] = 4;
        } catch (NoSuchFieldError e4) {
        }
    }
}
