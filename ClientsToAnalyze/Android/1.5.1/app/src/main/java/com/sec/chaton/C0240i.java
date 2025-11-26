package com.sec.chaton;

import com.sec.chaton.HandleIntent;

/* renamed from: com.sec.chaton.i */
/* loaded from: classes.dex */
/* synthetic */ class C0240i {

    /* renamed from: a */
    static final /* synthetic */ int[] f1908a = new int[HandleIntent.IntentDest.values().length];

    static {
        try {
            f1908a[HandleIntent.IntentDest.CHATROOM.ordinal()] = 1;
        } catch (NoSuchFieldError e) {
        }
        try {
            f1908a[HandleIntent.IntentDest.FORWARD.ordinal()] = 2;
        } catch (NoSuchFieldError e2) {
        }
    }
}
