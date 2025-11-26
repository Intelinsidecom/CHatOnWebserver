package com.vlingo.sdk.internal.util;

import java.io.ByteArrayOutputStream;

/* loaded from: classes.dex */
public class NoCopyByteArrayOutputStream extends ByteArrayOutputStream {
    public NoCopyByteArrayOutputStream() {
    }

    public NoCopyByteArrayOutputStream(byte[] buffer, int offset) {
        this.buf = buffer;
        this.count = offset;
    }

    public NoCopyByteArrayOutputStream(int size) {
        super(size);
    }

    public byte[] getByteArray() {
        return this.buf;
    }
}
