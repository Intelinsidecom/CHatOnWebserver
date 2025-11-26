package com.nuance.nmsp.client.sdk.components.resource.internal.nmas;

import com.nuance.nmsp.client.sdk.components.resource.nmas.NMASResource;

/* loaded from: classes.dex */
public class PDXInteger extends PDXClass {

    /* renamed from: a */
    private int f169a;

    public PDXInteger(int i) {
        super(NMASResource.PDX_DATA_TYPE_INT);
        this.f169a = i;
    }

    public PDXInteger(byte[] bArr) {
        super(NMASResource.PDX_DATA_TYPE_INT);
        if (bArr.length == 1) {
            this.f169a = bArr[0] & 255;
            return;
        }
        if (bArr.length == 2) {
            this.f169a = ((bArr[1] & 255) << 8) + (bArr[0] & 255);
        } else if (bArr.length == 3) {
            this.f169a = ((bArr[2] & 255) << 16) + ((bArr[1] & 255) << 8) + (bArr[0] & 255);
        } else {
            this.f169a = ((bArr[3] & 255) << 24) + ((bArr[2] & 255) << 16) + ((bArr[1] & 255) << 8) + (bArr[0] & 255);
        }
    }

    public int getValue() {
        return this.f169a;
    }

    public byte[] toByteArray() {
        return super.toByteArray(Math.abs(this.f169a) < 128 ? new byte[]{(byte) this.f169a} : Math.abs(this.f169a) < 32768 ? new byte[]{(byte) this.f169a, (byte) (this.f169a >> 8)} : new byte[]{(byte) this.f169a, (byte) (this.f169a >> 8), (byte) (this.f169a >> 16), (byte) (this.f169a >>> 24)});
    }
}
