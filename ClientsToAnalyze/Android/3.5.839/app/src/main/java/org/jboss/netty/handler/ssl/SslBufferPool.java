package org.jboss.netty.handler.ssl;

import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public class SslBufferPool {
    private int index;
    private final int maxBufferCount;
    private final ByteBuffer[] pool;

    public SslBufferPool() {
        this(19162112);
    }

    public SslBufferPool(int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("maxPoolSize: " + i);
        }
        int i2 = i / 18713;
        i2 = i % 18713 != 0 ? i2 + 1 : i2;
        this.pool = new ByteBuffer[i2];
        this.maxBufferCount = i2;
    }

    synchronized ByteBuffer acquire() {
        ByteBuffer byteBufferAllocate;
        if (this.index == 0) {
            byteBufferAllocate = ByteBuffer.allocate(18713);
        } else {
            ByteBuffer[] byteBufferArr = this.pool;
            int i = this.index - 1;
            this.index = i;
            byteBufferAllocate = (ByteBuffer) byteBufferArr[i].clear();
        }
        return byteBufferAllocate;
    }

    synchronized void release(ByteBuffer byteBuffer) {
        if (this.index < this.maxBufferCount) {
            ByteBuffer[] byteBufferArr = this.pool;
            int i = this.index;
            this.index = i + 1;
            byteBufferArr[i] = byteBuffer;
        }
    }
}
