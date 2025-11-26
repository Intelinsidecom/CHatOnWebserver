package com.nuance.nmsp.client.sdk.common.oem.api;

import com.nuance.nmsp.client.sdk.oem.MiscSystemOEM;

/* loaded from: classes.dex */
public abstract class MiscSystem {

    /* renamed from: a */
    private static MiscSystem f64a = new MiscSystemOEM();

    public static byte[] HMAC_SHA1(byte[] bArr, byte[] bArr2) {
        return f64a.HMAC_SHA1_impl(bArr, bArr2);
    }

    protected abstract byte[] HMAC_SHA1_impl(byte[] bArr, byte[] bArr2);
}
