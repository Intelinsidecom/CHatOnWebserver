package com.sec.chaton.network;

import com.sec.chaton.network.HttpEnvelope;
import com.sec.chaton.util.ServerAddressMgr;

/* renamed from: com.sec.chaton.network.d */
/* loaded from: classes.dex */
/* synthetic */ class C0342d {

    /* renamed from: a */
    static final /* synthetic */ int[] f2536a;

    /* renamed from: b */
    static final /* synthetic */ int[] f2537b = new int[ServerAddressMgr.ServerWhat.values().length];

    static {
        try {
            f2537b[ServerAddressMgr.ServerWhat.GLD.ordinal()] = 1;
        } catch (NoSuchFieldError e) {
        }
        try {
            f2537b[ServerAddressMgr.ServerWhat.CONTACT.ordinal()] = 2;
        } catch (NoSuchFieldError e2) {
        }
        try {
            f2537b[ServerAddressMgr.ServerWhat.FILE.ordinal()] = 3;
        } catch (NoSuchFieldError e3) {
        }
        try {
            f2537b[ServerAddressMgr.ServerWhat.SMS_GATEWAY.ordinal()] = 4;
        } catch (NoSuchFieldError e4) {
        }
        f2536a = new int[HttpEnvelope.RequestMethod.values().length];
        try {
            f2536a[HttpEnvelope.RequestMethod.GET.ordinal()] = 1;
        } catch (NoSuchFieldError e5) {
        }
        try {
            f2536a[HttpEnvelope.RequestMethod.POST.ordinal()] = 2;
        } catch (NoSuchFieldError e6) {
        }
        try {
            f2536a[HttpEnvelope.RequestMethod.PUT.ordinal()] = 3;
        } catch (NoSuchFieldError e7) {
        }
        try {
            f2536a[HttpEnvelope.RequestMethod.DELETE.ordinal()] = 4;
        } catch (NoSuchFieldError e8) {
        }
    }
}
