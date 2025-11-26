package com.sec.chaton.util;

import com.sec.chaton.util.ServerAddressMgr;

/* renamed from: com.sec.chaton.util.n */
/* loaded from: classes.dex */
/* synthetic */ class C0616n {

    /* renamed from: a */
    static final /* synthetic */ int[] f3787a = new int[ServerAddressMgr.ServerType.values().length];

    static {
        try {
            f3787a[ServerAddressMgr.ServerType.PRIMARY.ordinal()] = 1;
        } catch (NoSuchFieldError e) {
        }
        try {
            f3787a[ServerAddressMgr.ServerType.SECONDARY.ordinal()] = 2;
        } catch (NoSuchFieldError e2) {
        }
    }
}
