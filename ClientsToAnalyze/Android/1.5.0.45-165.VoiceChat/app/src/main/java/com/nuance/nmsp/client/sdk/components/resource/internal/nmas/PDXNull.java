package com.nuance.nmsp.client.sdk.components.resource.internal.nmas;

/* loaded from: classes.dex */
public class PDXNull extends PDXClass {
    public PDXNull() {
        super((short) 5);
    }

    public Object getValue() {
        return null;
    }

    public byte[] toByteArray() {
        return super.toByteArray(new byte[0]);
    }
}
