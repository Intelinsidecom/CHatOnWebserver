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
    private final FileChannel f4584in;
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
        this.f4584in = fileChannel;
        this.chunkSize = i;
        this.startOffset = j;
        this.offset = j;
        this.endOffset = j + j2;
    }

    @Override // org.jboss.netty.handler.stream.ChunkedInput
    public void close() {
        this.f4584in.close();
    }

    public long getCurrentOffset() {
        return this.offset;
    }

    public long getEndOffset() {
        return this.endOffset;
    }

    public long getStartOffset() {
        return this.startOffset;
    }

    @Override // org.jboss.netty.handler.stream.ChunkedInput
    public boolean hasNextChunk() {
        return this.offset < this.endOffset && this.f4584in.isOpen();
    }

    @Override // org.jboss.netty.handler.stream.ChunkedInput
    public boolean isEndOfInput() {
        return !hasNextChunk();
    }

    @Override // org.jboss.netty.handler.stream.ChunkedInput
    public Object nextChunk() throws IOException {
        int i;
        long j = this.offset;
        if (j >= this.endOffset) {
            return null;
        }
        int iMin = (int) Math.min(this.chunkSize, this.endOffset - j);
        byte[] bArr = new byte[iMin];
        ByteBuffer byteBufferWrap = ByteBuffer.wrap(bArr);
        int i2 = 0;
        while (true) {
            int i3 = this.f4584in.read(byteBufferWrap);
            if (i3 < 0) {
                i = i2;
                break;
            }
            i2 += i3;
            if (i2 == iMin) {
                i = i2;
                break;
            }
        }
        this.offset += i;
        return ChannelBuffers.wrappedBuffer(bArr);
    }
}
