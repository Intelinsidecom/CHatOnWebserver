package com.sec.chaton.p025d;

import com.sec.chaton.p027e.EnumC1450r;
import com.sec.chaton.p027e.EnumC1455w;

/* compiled from: MessageControl2.java */
/* renamed from: com.sec.chaton.d.s */
/* loaded from: classes.dex */
/* synthetic */ class C1341s {

    /* renamed from: a */
    static final /* synthetic */ int[] f5065a;

    /* renamed from: b */
    static final /* synthetic */ int[] f5066b = new int[EnumC1455w.values().length];

    static {
        try {
            f5066b[EnumC1455w.CONTACT.ordinal()] = 1;
        } catch (NoSuchFieldError e) {
        }
        try {
            f5066b[EnumC1455w.CALENDAR.ordinal()] = 2;
        } catch (NoSuchFieldError e2) {
        }
        try {
            f5066b[EnumC1455w.DOCUMENT.ordinal()] = 3;
        } catch (NoSuchFieldError e3) {
        }
        try {
            f5066b[EnumC1455w.FILE.ordinal()] = 4;
        } catch (NoSuchFieldError e4) {
        }
        try {
            f5066b[EnumC1455w.AUDIO.ordinal()] = 5;
        } catch (NoSuchFieldError e5) {
        }
        f5065a = new int[EnumC1450r.values().length];
        try {
            f5065a[EnumC1450r.ONETOONE.ordinal()] = 1;
        } catch (NoSuchFieldError e6) {
        }
        try {
            f5065a[EnumC1450r.GROUPCHAT.ordinal()] = 2;
        } catch (NoSuchFieldError e7) {
        }
        try {
            f5065a[EnumC1450r.BROADCAST.ordinal()] = 3;
        } catch (NoSuchFieldError e8) {
        }
    }
}
