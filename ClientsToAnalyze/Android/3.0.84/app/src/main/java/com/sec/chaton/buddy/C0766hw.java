package com.sec.chaton.buddy;

import com.sec.chaton.buddy.p019a.EnumC0515e;

/* compiled from: SpecialBuddyFragment.java */
/* renamed from: com.sec.chaton.buddy.hw */
/* loaded from: classes.dex */
/* synthetic */ class C0766hw {

    /* renamed from: a */
    static final /* synthetic */ int[] f3033a;

    /* renamed from: b */
    static final /* synthetic */ int[] f3034b = new int[EnumC0778ih.values().length];

    static {
        try {
            f3034b[EnumC0778ih.Nonetwork.ordinal()] = 1;
        } catch (NoSuchFieldError e) {
        }
        try {
            f3034b[EnumC0778ih.NetworkErr.ordinal()] = 2;
        } catch (NoSuchFieldError e2) {
        }
        f3033a = new int[EnumC0515e.values().length];
        try {
            f3033a[EnumC0515e.CHAT.ordinal()] = 1;
        } catch (NoSuchFieldError e3) {
        }
        try {
            f3033a[EnumC0515e.CONTENTS.ordinal()] = 2;
        } catch (NoSuchFieldError e4) {
        }
        try {
            f3033a[EnumC0515e.CHATCONTENTS.ordinal()] = 3;
        } catch (NoSuchFieldError e5) {
        }
        try {
            f3033a[EnumC0515e.NONE.ordinal()] = 4;
        } catch (NoSuchFieldError e6) {
        }
    }
}
