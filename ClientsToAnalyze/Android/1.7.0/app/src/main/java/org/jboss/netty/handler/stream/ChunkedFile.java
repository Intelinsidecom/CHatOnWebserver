package org.jboss.netty.handler.stream;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import org.jboss.netty.buffer.ChannelBuffers;

/* loaded from: classes.dex */
public class ChunkedFile implements ChunkedInput {
    private final int chunkSize;
    private final long endOffset;
    private final RandomAccessFile file;
    private volatile long offset;
    private final long startOffset;

    public ChunkedFile(File file) {
        this(file, 8192);
    }

    public ChunkedFile(File file, int i) {
        this(new RandomAccessFile(file, "r"), i);
    }

    public ChunkedFile(RandomAccessFile randomAccessFile) {
        this(randomAccessFile, 8192);
    }

    public ChunkedFile(RandomAccessFile randomAccessFile, int i) {
        this(randomAccessFile, 0L, randomAccessFile.length(), i);
    }

    public ChunkedFile(RandomAccessFile randomAccessFile, long j, long j2, int i) throws IOException {
        if (randomAccessFile == null) {
            throw new NullPointerException("file");
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
        this.file = randomAccessFile;
        this.startOffset = j;
        this.offset = j;
        this.endOffset = j + j2;
        this.chunkSize = i;
        randomAccessFile.seek(j);
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
        return this.offset < this.endOffset && this.file.getChannel().isOpen();
    }

    @Override // org.jboss.netty.handler.stream.ChunkedInput
    public boolean isEndOfInput() {
        return !hasNextChunk();
    }

    @Override // org.jboss.netty.handler.stream.ChunkedInput
    public void close() throws IOException {
        this.file.close();
    }

    @Override // org.jboss.netty.handler.stream.ChunkedInput
    public Object nextChunk() throws IOException {
        long j = this.offset;
        if (j >= this.endOffset) {
            return null;
        }
        int iMin = (int) Math.min(this.chunkSize, this.endOffset - j);
        byte[] bArr = new byte[iMin];
        this.file.readFully(bArr);
        this.offset = j + iMin;
        return ChannelBuffers.wrappedBuffer(bArr);
    }
}
