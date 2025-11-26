package com.sec.chaton.receiver;

import com.sec.chaton.p017e.EnumC0695j;

/* compiled from: PushReceiver.java */
/* renamed from: com.sec.chaton.receiver.b */
/* loaded from: classes.dex */
/* synthetic */ class C1145b {

    /* renamed from: a */
    static final /* synthetic */ int[] f4159a = new int[EnumC0695j.values().length];

    static {
        try {
            f4159a[EnumC0695j.ONETOONE.ordinal()] = 1;
        } catch (NoSuchFieldError e) {
        }
        try {
            f4159a[EnumC0695j.BROADCAST.ordinal()] = 2;
        } catch (NoSuchFieldError e2) {
        }
        try {
            f4159a[EnumC0695j.GROUPCHAT.ordinal()] = 3;
        } catch (NoSuchFieldError e3) {
        }
        try {
            f4159a[EnumC0695j.WEB_AUTH.ordinal()] = 4;
        } catch (NoSuchFieldError e4) {
        }
    }
}
