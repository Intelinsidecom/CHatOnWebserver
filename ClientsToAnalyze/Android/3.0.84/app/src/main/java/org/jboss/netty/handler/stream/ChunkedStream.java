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
    private final PushbackInputStream f13712in;
    private volatile long offset;

    public ChunkedStream(InputStream inputStream) {
        this(inputStream, 8192);
    }

    public ChunkedStream(InputStream inputStream, int i) {
        if (inputStream == null) {
            throw new NullPointerException("in");
        }
        if (i <= 0) {
            throw new IllegalArgumentException("chunkSize: " + i + " (expected: a positive integer)");
        }
        if (inputStream instanceof PushbackInputStream) {
            this.f13712in = (PushbackInputStream) inputStream;
        } else {
            this.f13712in = new PushbackInputStream(inputStream);
        }
        this.chunkSize = i;
    }

    public long getTransferredBytes() {
        return this.offset;
    }

    @Override // org.jboss.netty.handler.stream.ChunkedInput
    public boolean hasNextChunk() throws IOException {
        int i = this.f13712in.read();
        if (i < 0) {
            return false;
        }
        this.f13712in.unread(i);
        return true;
    }

    @Override // org.jboss.netty.handler.stream.ChunkedInput
    public boolean isEndOfInput() {
        return !hasNextChunk();
    }

    @Override // org.jboss.netty.handler.stream.ChunkedInput
    public void close() throws IOException {
        this.f13712in.close();
    }

    @Override // org.jboss.netty.handler.stream.ChunkedInput
    public Object nextChunk() throws IOException {
        int iMin;
        if (!hasNextChunk()) {
            return null;
        }
        if (this.f13712in.available() <= 0) {
            iMin = this.chunkSize;
        } else {
            iMin = Math.min(this.chunkSize, this.f13712in.available());
        }
        byte[] bArr = new byte[iMin];
        int i = 0;
        do {
            int i2 = this.f13712in.read(bArr, i, iMin - i);
            if (i2 < 0) {
                break;
            }
            i += i2;
            this.offset += i2;
        } while (i != iMin);
        return ChannelBuffers.wrappedBuffer(bArr, 0, i);
    }
}
