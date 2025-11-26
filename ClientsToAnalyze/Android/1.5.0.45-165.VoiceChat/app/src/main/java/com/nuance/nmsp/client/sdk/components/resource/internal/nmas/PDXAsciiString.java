package com.nuance.nmsp.client.sdk.components.resource.internal.nmas;

/* loaded from: classes.dex */
public class PDXAsciiString extends PDXClass {

    /* renamed from: a */
    private String f156a;

    public PDXAsciiString(String str) {
        super((short) 22);
        this.f156a = str;
    }

    public PDXAsciiString(byte[] bArr) {
        super((short) 22);
        this.f156a = new String(bArr);
    }

    public String getValue() {
        return this.f156a;
    }

    public byte[] toByteArray() {
        return super.toByteArray(this.f156a.getBytes());
    }
}
