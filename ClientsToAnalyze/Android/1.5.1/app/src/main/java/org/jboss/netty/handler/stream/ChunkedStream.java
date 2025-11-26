package org.jboss.netty.handler.stream;

import java.io.IOException;
import java.io.InputStream;
import java.io.PushbackInputStream;
import org.jboss.netty.buffer.ChannelBuffers;

/* loaded from: classes.dex */
public class ChunkedStream implements ChunkedInput {
    static final int DEFAULT_CHUNK_SIZE = 8192;
    private final int chunkSize;

    /* renamed from: in */
    private final PushbackInputStream f4586in;
    private volatile long offset;

    public ChunkedStream(InputStream inputStream) {
        this(inputStream, DEFAULT_CHUNK_SIZE);
    }

    public ChunkedStream(InputStream inputStream, int i) {
        if (inputStream == null) {
            throw new NullPointerException("in");
        }
        if (i <= 0) {
            throw new IllegalArgumentException("chunkSize: " + i + " (expected: a positive integer)");
        }
        if (inputStream instanceof PushbackInputStream) {
            this.f4586in = (PushbackInputStream) inputStream;
        } else {
            this.f4586in = new PushbackInputStream(inputStream);
        }
        this.chunkSize = i;
    }

    @Override // org.jboss.netty.handler.stream.ChunkedInput
    public void close() throws IOException {
        this.f4586in.close();
    }

    public long getTransferredBytes() {
        return this.offset;
    }

    @Override // org.jboss.netty.handler.stream.ChunkedInput
    public boolean hasNextChunk() throws IOException {
        int i = this.f4586in.read();
        if (i < 0) {
            return false;
        }
        this.f4586in.unread(i);
        return true;
    }

    @Override // org.jboss.netty.handler.stream.ChunkedInput
    public boolean isEndOfInput() {
        return !hasNextChunk();
    }

    @Override // org.jboss.netty.handler.stream.ChunkedInput
    public Object nextChunk() throws IOException {
        int i;
        if (!hasNextChunk()) {
            return null;
        }
        int iMin = this.f4586in.available() <= 0 ? this.chunkSize : Math.min(this.chunkSize, this.f4586in.available());
        byte[] bArr = new byte[iMin];
        int i2 = 0;
        while (true) {
            int i3 = this.f4586in.read(bArr, i2, iMin - i2);
            if (i3 < 0) {
                i = i2;
                break;
            }
            i2 += i3;
            this.offset += i3;
            if (i2 == iMin) {
                i = i2;
                break;
            }
        }
        return ChannelBuffers.wrappedBuffer(bArr, 0, i);
    }
}
