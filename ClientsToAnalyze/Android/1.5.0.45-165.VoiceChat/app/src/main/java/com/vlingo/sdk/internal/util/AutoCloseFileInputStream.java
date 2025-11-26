package com.vlingo.sdk.internal.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/* loaded from: classes.dex */
public class AutoCloseFileInputStream extends FileInputStream {
    private boolean isClosed;

    public AutoCloseFileInputStream(String path) throws FileNotFoundException {
        super(path);
        this.isClosed = false;
    }

    @Override // java.io.FileInputStream, java.io.InputStream
    public int read() throws IOException {
        int byteRead = super.read();
        if (byteRead == -1) {
            close();
        }
        return byteRead;
    }

    @Override // java.io.FileInputStream, java.io.InputStream
    public int read(byte[] buffer, int byteOffset, int byteCount) throws IOException {
        int bytesRead = super.read(buffer, byteOffset, byteCount);
        if (bytesRead == -1) {
            close();
        }
        return bytesRead;
    }

    @Override // java.io.FileInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (!this.isClosed) {
            super.close();
            this.isClosed = true;
        }
    }
}
