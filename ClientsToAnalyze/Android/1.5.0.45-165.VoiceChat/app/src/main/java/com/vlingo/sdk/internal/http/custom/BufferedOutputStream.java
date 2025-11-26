package com.vlingo.sdk.internal.http.custom;

import com.vlingo.sdk.internal.logging.Logger;
import com.vlingo.sdk.internal.util.NoCopyByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/* loaded from: classes.dex */
public class BufferedOutputStream extends OutputStream {
    private static Logger log = Logger.getLogger(BufferedOutputStream.class);
    private NoCopyByteArrayOutputStream buffer;
    private OutputStream out;

    public BufferedOutputStream(OutputStream out, int bufferSize) {
        this.out = out;
        this.buffer = new NoCopyByteArrayOutputStream(bufferSize);
    }

    @Override // java.io.OutputStream
    public synchronized void write(int b) throws IOException {
        this.buffer.write(b);
    }

    @Override // java.io.OutputStream
    public synchronized void write(byte[] buff) throws IOException {
        this.buffer.write(buff, 0, buff.length);
    }

    @Override // java.io.OutputStream
    public synchronized void write(byte[] buff, int offset, int length) throws IOException {
        this.buffer.write(buff, offset, length);
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public synchronized void flush() throws IOException {
        this.out.write(this.buffer.getByteArray(), 0, this.buffer.size());
        log.debug("Calling flush on " + this.out);
        this.out.flush();
        this.buffer.reset();
    }
}
