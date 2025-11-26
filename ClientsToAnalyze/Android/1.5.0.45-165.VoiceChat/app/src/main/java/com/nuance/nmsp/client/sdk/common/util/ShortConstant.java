package com.nuance.nmsp.client.sdk.common.util;

/* loaded from: classes.dex */
public class ShortConstant {
    protected final short value;

    public ShortConstant(short s) {
        this.value = s;
    }

    public boolean equals(ShortConstant shortConstant) {
        return this.value == shortConstant.getValue();
    }

    public short getValue() {
        return this.value;
    }
}
