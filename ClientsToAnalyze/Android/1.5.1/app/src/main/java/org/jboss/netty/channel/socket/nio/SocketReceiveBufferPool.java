package org.jboss.netty.channel.socket.nio;

import java.lang.ref.SoftReference;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
final class SocketReceiveBufferPool {
    private static final int POOL_SIZE = 8;
    private final SoftReference[] pool = new SoftReference[8];

    SocketReceiveBufferPool() {
    }

    private static final int normalizeCapacity(int i) {
        int i2 = i >>> 10;
        if ((i & 1023) != 0) {
            i2++;
        }
        return i2 << 10;
    }

    final ByteBuffer acquire(int i) {
        SoftReference[] softReferenceArr = this.pool;
        for (int i2 = 0; i2 < 8; i2++) {
            SoftReference softReference = softReferenceArr[i2];
            if (softReference != null) {
                ByteBuffer byteBuffer = (ByteBuffer) softReference.get();
                if (byteBuffer == null) {
                    softReferenceArr[i2] = null;
                } else if (byteBuffer.capacity() >= i) {
                    softReferenceArr[i2] = null;
                    byteBuffer.clear();
                    return byteBuffer;
                }
            }
        }
        ByteBuffer byteBufferAllocateDirect = ByteBuffer.allocateDirect(normalizeCapacity(i));
        byteBufferAllocateDirect.clear();
        return byteBufferAllocateDirect;
    }

    final void release(ByteBuffer byteBuffer) {
        SoftReference[] softReferenceArr = this.pool;
        for (int i = 0; i < 8; i++) {
            SoftReference softReference = softReferenceArr[i];
            if (softReference == null || softReference.get() == null) {
                softReferenceArr[i] = new SoftReference(byteBuffer);
                return;
            }
        }
        int iCapacity = byteBuffer.capacity();
        for (int i2 = 0; i2 < 8; i2++) {
            ByteBuffer byteBuffer2 = (ByteBuffer) softReferenceArr[i2].get();
            if (byteBuffer2 == null) {
                softReferenceArr[i2] = null;
            } else if (byteBuffer2.capacity() < iCapacity) {
                softReferenceArr[i2] = new SoftReference(byteBuffer);
                return;
            }
        }
    }
}
