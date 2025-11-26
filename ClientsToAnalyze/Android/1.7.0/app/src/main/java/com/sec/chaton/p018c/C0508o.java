package com.sec.chaton.p018c;

import com.sec.chaton.util.EnumC1333h;

/* compiled from: ChatONHttpClient2.java */
/* renamed from: com.sec.chaton.c.o */
/* loaded from: classes.dex */
/* synthetic */ class C0508o {

    /* renamed from: a */
    static final /* synthetic */ int[] f1650a;

    /* renamed from: b */
    static final /* synthetic */ int[] f1651b = new int[EnumC1333h.values().length];

    static {
        try {
            f1651b[EnumC1333h.GLD.ordinal()] = 1;
        } catch (NoSuchFieldError e) {
        }
        try {
            f1651b[EnumC1333h.CONTACT.ordinal()] = 2;
        } catch (NoSuchFieldError e2) {
        }
        try {
            f1651b[EnumC1333h.FILE.ordinal()] = 3;
        } catch (NoSuchFieldError e3) {
        }
        try {
            f1651b[EnumC1333h.SMS_GATEWAY.ordinal()] = 4;
        } catch (NoSuchFieldError e4) {
        }
        f1650a = new int[EnumC0511r.values().length];
        try {
            f1650a[EnumC0511r.GET.ordinal()] = 1;
        } catch (NoSuchFieldError e5) {
        }
        try {
            f1650a[EnumC0511r.POST.ordinal()] = 2;
        } catch (NoSuchFieldError e6) {
        }
        try {
            f1650a[EnumC0511r.PUT.ordinal()] = 3;
        } catch (NoSuchFieldError e7) {
        }
        try {
            f1650a[EnumC0511r.DELETE.ordinal()] = 4;
        } catch (NoSuchFieldError e8) {
        }
    }
}
