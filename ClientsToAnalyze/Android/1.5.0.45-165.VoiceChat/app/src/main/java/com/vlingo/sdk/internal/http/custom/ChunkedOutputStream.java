package com.vlingo.sdk.internal.http.custom;

import com.vlingo.sdk.internal.logging.Logger;
import com.vlingo.sdk.internal.util.NoCopyByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/* loaded from: classes.dex */
public class ChunkedOutputStream extends OutputStream {
    private static final int DEFAULT_MIN_CHUNK_SIZE = 1024;
    private static Logger log = Logger.getLogger(ChunkedOutputStream.class);
    private OutputStream ivOut;
    private byte[] singleByteBuffer = new byte[1];
    private boolean ivClosed = false;
    private int ivMinChunkSize = 1024;
    private NoCopyByteArrayOutputStream ivWriteBuffer = new NoCopyByteArrayOutputStream(this.ivMinChunkSize * 2);

    public ChunkedOutputStream(OutputStream out) {
        this.ivOut = new BufferedOutputStream(out, this.ivMinChunkSize * 3);
    }

    private void checkClosed() {
        if (this.ivClosed) {
            throw new RuntimeException("Stream is closed already");
        }
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.ivClosed = true;
        this.ivOut.close();
    }

    private void bufferedWrite(byte[] buff, int offset, int length) throws IOException {
        checkClosed();
        this.ivWriteBuffer.write(buff, offset, length);
        if (this.ivWriteBuffer.size() >= this.ivMinChunkSize) {
            flushBuffer();
        }
    }

    private void flushBuffer() throws IOException {
        writeChunk(this.ivWriteBuffer.getByteArray(), 0, this.ivWriteBuffer.size());
        this.ivWriteBuffer.reset();
    }

    private void writeChunk(byte[] buff, int offset, int length) throws IOException {
        log.debug("writing chunk, len=" + length + " (" + Integer.toHexString(length) + ")");
        this.ivOut.write(buff, offset, length);
        this.ivOut.flush();
    }

    public synchronized void writeLastChunk() throws IOException {
        checkClosed();
        flushBuffer();
        this.ivOut.flush();
    }

    @Override // java.io.OutputStream
    public synchronized void write(int it) throws IOException {
        this.singleByteBuffer[0] = (byte) it;
        bufferedWrite(this.singleByteBuffer, 0, 1);
    }

    @Override // java.io.OutputStream
    public synchronized void write(byte[] buff) throws IOException {
        bufferedWrite(buff, 0, buff.length);
    }

    @Override // java.io.OutputStream
    public synchronized void write(byte[] buff, int offset, int length) throws IOException {
        bufferedWrite(buff, offset, length);
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public synchronized void flush() throws IOException {
        flushBuffer();
    }
}
