package com.sec.chaton.sync;

import android.database.CursorJoiner;

/* renamed from: com.sec.chaton.sync.a */
/* loaded from: classes.dex */
/* synthetic */ class C0526a {

    /* renamed from: a */
    static final /* synthetic */ int[] f3312a = new int[CursorJoiner.Result.values().length];

    static {
        try {
            f3312a[CursorJoiner.Result.LEFT.ordinal()] = 1;
        } catch (NoSuchFieldError e) {
        }
        try {
            f3312a[CursorJoiner.Result.RIGHT.ordinal()] = 2;
        } catch (NoSuchFieldError e2) {
        }
        try {
            f3312a[CursorJoiner.Result.BOTH.ordinal()] = 3;
        } catch (NoSuchFieldError e3) {
        }
    }
}
