package org.jboss.netty.handler.stream;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.ReadableByteChannel;
import org.jboss.netty.buffer.ChannelBuffer;
import org.jboss.netty.buffer.ChannelBuffers;

/* loaded from: classes.dex */
public class ChunkedNioStream implements ChunkedInput {
    private final ByteBuffer byteBuffer;
    private final int chunkSize;

    /* renamed from: in */
    private final ReadableByteChannel f4585in;
    private volatile long offset;

    public ChunkedNioStream(ReadableByteChannel readableByteChannel) {
        this(readableByteChannel, 8192);
    }

    public ChunkedNioStream(ReadableByteChannel readableByteChannel, int i) {
        if (readableByteChannel == null) {
            throw new NullPointerException("in");
        }
        if (i <= 0) {
            throw new IllegalArgumentException("chunkSize: " + i + " (expected: a positive integer)");
        }
        this.f4585in = readableByteChannel;
        this.offset = 0L;
        this.chunkSize = i;
        this.byteBuffer = ByteBuffer.allocate(i);
    }

    @Override // org.jboss.netty.handler.stream.ChunkedInput
    public void close() {
        this.f4585in.close();
    }

    public long getTransferredBytes() {
        return this.offset;
    }

    @Override // org.jboss.netty.handler.stream.ChunkedInput
    public boolean hasNextChunk() {
        int i;
        if (this.byteBuffer.position() > 0) {
            return true;
        }
        if (this.f4585in.isOpen() && (i = this.f4585in.read(this.byteBuffer)) >= 0) {
            this.offset += i;
            return true;
        }
        return false;
    }

    @Override // org.jboss.netty.handler.stream.ChunkedInput
    public boolean isEndOfInput() {
        return !hasNextChunk();
    }

    @Override // org.jboss.netty.handler.stream.ChunkedInput
    public Object nextChunk() throws IOException {
        if (!hasNextChunk()) {
            return null;
        }
        int iPosition = this.byteBuffer.position();
        do {
            int i = this.f4585in.read(this.byteBuffer);
            if (i < 0) {
                break;
            }
            iPosition += i;
            this.offset += i;
        } while (iPosition != this.chunkSize);
        this.byteBuffer.flip();
        ChannelBuffer channelBufferCopiedBuffer = ChannelBuffers.copiedBuffer(this.byteBuffer);
        this.byteBuffer.clear();
        return channelBufferCopiedBuffer;
    }
}
