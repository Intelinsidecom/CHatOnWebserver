package com.vlingo.sdk.internal.http.custom;

import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes.dex */
public class LimitInputStream extends InputStream {
    private int ivMax;
    private InputStream ivOrg;
    private int ivRead;

    public LimitInputStream(InputStream org, int max) {
        this.ivMax = max;
        this.ivOrg = org;
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        if (this.ivMax == this.ivRead) {
            return -1;
        }
        this.ivRead++;
        return this.ivOrg.read();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.ivOrg.close();
    }
}
