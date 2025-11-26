package com.nuance.nmsp.client.sdk.components.resource.internal.nmas;

import com.nuance.nmsp.client.sdk.components.resource.nmas.Parameter;

/* loaded from: classes.dex */
public class PDXDataParam extends PDXParam implements Parameter {

    /* renamed from: a */
    private byte[] f165a;

    public PDXDataParam(String str, byte[] bArr) {
        super(str, (byte) 4);
        this.f165a = new byte[bArr.length];
        System.arraycopy(bArr, 0, this.f165a, 0, this.f165a.length);
    }

    protected byte[] getData() {
        return this.f165a;
    }
}
