package org.jboss.netty.handler.stream;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import org.jboss.netty.buffer.ChannelBuffers;

/* loaded from: classes.dex */
public class ChunkedNioFile implements ChunkedInput {
    private final int chunkSize;
    private final long endOffset;

    /* renamed from: in */
    private final FileChannel f7874in;
    private volatile long offset;
    private long startOffset;

    public ChunkedNioFile(File file) {
        this(new FileInputStream(file).getChannel());
    }

    public ChunkedNioFile(File file, int i) {
        this(new FileInputStream(file).getChannel(), i);
    }

    public ChunkedNioFile(FileChannel fileChannel) {
        this(fileChannel, 8192);
    }

    public ChunkedNioFile(FileChannel fileChannel, int i) {
        this(fileChannel, 0L, fileChannel.size(), i);
    }

    public ChunkedNioFile(FileChannel fileChannel, long j, long j2, int i) throws IOException {
        if (fileChannel == null) {
            throw new NullPointerException("in");
        }
        if (j < 0) {
            throw new IllegalArgumentException("offset: " + j + " (expected: 0 or greater)");
        }
        if (j2 < 0) {
            throw new IllegalArgumentException("length: " + j2 + " (expected: 0 or greater)");
        }
        if (i <= 0) {
            throw new IllegalArgumentException("chunkSize: " + i + " (expected: a positive integer)");
        }
        if (j != 0) {
            fileChannel.position(j);
        }
        this.f7874in = fileChannel;
        this.chunkSize = i;
        this.startOffset = j;
        this.offset = j;
        this.endOffset = j + j2;
    }

    public long getStartOffset() {
        return this.startOffset;
    }

    public long getEndOffset() {
        return this.endOffset;
    }

    public long getCurrentOffset() {
        return this.offset;
    }

    @Override // org.jboss.netty.handler.stream.ChunkedInput
    public boolean hasNextChunk() {
        return this.offset < this.endOffset && this.f7874in.isOpen();
    }

    @Override // org.jboss.netty.handler.stream.ChunkedInput
    public boolean isEndOfInput() {
        return !hasNextChunk();
    }

    @Override // org.jboss.netty.handler.stream.ChunkedInput
    public void close() {
        this.f7874in.close();
    }

    @Override // org.jboss.netty.handler.stream.ChunkedInput
    public Object nextChunk() throws IOException {
        long j = this.offset;
        if (j >= this.endOffset) {
            return null;
        }
        int iMin = (int) Math.min(this.chunkSize, this.endOffset - j);
        byte[] bArr = new byte[iMin];
        ByteBuffer byteBufferWrap = ByteBuffer.wrap(bArr);
        int i = 0;
        do {
            int i2 = this.f7874in.read(byteBufferWrap);
            if (i2 < 0) {
                break;
            }
            i += i2;
        } while (i != iMin);
        this.offset = i + this.offset;
        return ChannelBuffers.wrappedBuffer(bArr);
    }
}
