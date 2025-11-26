package com.sec.chaton.buddy.dialog;

import com.sec.chaton.buddy.p019a.EnumC0515e;

/* compiled from: SpecialBuddyDialog.java */
/* renamed from: com.sec.chaton.buddy.dialog.ac */
/* loaded from: classes.dex */
/* synthetic */ class C0609ac {

    /* renamed from: a */
    static final /* synthetic */ int[] f2824a;

    /* renamed from: b */
    static final /* synthetic */ int[] f2825b = new int[EnumC0619am.values().length];

    static {
        try {
            f2825b[EnumC0619am.Nonetwork.ordinal()] = 1;
        } catch (NoSuchFieldError e) {
        }
        try {
            f2825b[EnumC0619am.NetworkErr.ordinal()] = 2;
        } catch (NoSuchFieldError e2) {
        }
        f2824a = new int[EnumC0515e.values().length];
        try {
            f2824a[EnumC0515e.CHAT.ordinal()] = 1;
        } catch (NoSuchFieldError e3) {
        }
        try {
            f2824a[EnumC0515e.CONTENTS.ordinal()] = 2;
        } catch (NoSuchFieldError e4) {
        }
        try {
            f2824a[EnumC0515e.CHATCONTENTS.ordinal()] = 3;
        } catch (NoSuchFieldError e5) {
        }
        try {
            f2824a[EnumC0515e.NONE.ordinal()] = 4;
        } catch (NoSuchFieldError e6) {
        }
    }
}
