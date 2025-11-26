package com.vlingo.sdk.internal.http.custom;

import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes.dex */
public class ChunkedInputStream extends InputStream {
    private static final int READ_BYTE = 0;
    private static final int READ_CR = 1;
    private static final int READ_EOF = -1;
    private static final int READ_LF = 2;
    private int currChunkRead;
    private int currChunkSize = -1;
    private InputStream ivIn;

    public ChunkedInputStream(InputStream in) {
        this.ivIn = in;
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        if (!ensureChunkAvailable()) {
            return -1;
        }
        int i = this.ivIn.read();
        this.currChunkRead++;
        return i;
    }

    private boolean ensureChunkAvailable() throws IOException {
        if (this.currChunkSize != -1 && this.currChunkRead < this.currChunkSize) {
            return true;
        }
        String sizeStr = readLine();
        if (sizeStr.length() == 0) {
            throw new IOException("Missing chunk header");
        }
        this.currChunkSize = Integer.valueOf(sizeStr, 16).intValue();
        this.currChunkRead = 0;
        if (this.currChunkSize == 0) {
            readLine();
        }
        return this.currChunkSize > 0;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0029  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.lang.String readLine() throws java.io.IOException {
        /*
            r4 = this;
            java.lang.StringBuffer r1 = new java.lang.StringBuffer
            r1.<init>()
            r2 = 0
        L6:
            java.io.InputStream r3 = r4.ivIn
            int r0 = r3.read()
            switch(r0) {
                case -1: goto L25;
                case 10: goto L21;
                case 13: goto L1e;
                default: goto Lf;
            }
        Lf:
            r2 = 0
            r1.append(r0)
        L13:
            r3 = -1
            if (r2 == r3) goto L19
            r3 = 2
            if (r2 != r3) goto L6
        L19:
            java.lang.String r3 = r1.toString()
            return r3
        L1e:
            if (r2 != 0) goto L27
            r2 = 1
        L21:
            r3 = 1
            if (r2 != r3) goto L29
            r2 = 2
        L25:
            r2 = -1
            goto L13
        L27:
            r2 = 0
            goto L21
        L29:
            r2 = 0
            goto L25
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vlingo.sdk.internal.http.custom.ChunkedInputStream.readLine():java.lang.String");
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.ivIn.close();
    }
}
