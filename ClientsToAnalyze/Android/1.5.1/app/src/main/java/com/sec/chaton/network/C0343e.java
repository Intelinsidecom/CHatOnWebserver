package com.sec.chaton.network;

import com.sec.chaton.network.HttpEnvelope;

/* renamed from: com.sec.chaton.network.e */
/* loaded from: classes.dex */
/* synthetic */ class C0343e {

    /* renamed from: a */
    static final /* synthetic */ int[] f2538a = new int[HttpEnvelope.RequestMethod.values().length];

    static {
        try {
            f2538a[HttpEnvelope.RequestMethod.POST.ordinal()] = 1;
        } catch (NoSuchFieldError e) {
        }
        try {
            f2538a[HttpEnvelope.RequestMethod.GET.ordinal()] = 2;
        } catch (NoSuchFieldError e2) {
        }
    }
}
