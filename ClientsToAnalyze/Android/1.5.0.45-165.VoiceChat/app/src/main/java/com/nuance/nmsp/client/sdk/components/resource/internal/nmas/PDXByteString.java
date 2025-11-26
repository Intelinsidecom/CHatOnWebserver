package com.nuance.nmsp.client.sdk.components.resource.internal.nmas;

/* loaded from: classes.dex */
public class PDXByteString extends PDXClass {

    /* renamed from: a */
    private byte[] f162a;

    public PDXByteString(byte[] bArr) {
        super((short) 4);
        this.f162a = bArr;
    }

    public byte[] getValue() {
        return this.f162a;
    }

    public byte[] toByteArray() {
        return super.toByteArray(this.f162a);
    }
}
