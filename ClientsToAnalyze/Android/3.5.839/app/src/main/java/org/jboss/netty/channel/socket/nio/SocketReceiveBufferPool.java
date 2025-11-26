package org.jboss.netty.channel.socket.nio;

import java.lang.ref.SoftReference;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
final class SocketReceiveBufferPool {
    private final SoftReference<ByteBuffer>[] pool = new SoftReference[8];

    SocketReceiveBufferPool() {
    }

    final ByteBuffer acquire(int i) {
        SoftReference<ByteBuffer>[] softReferenceArr = this.pool;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < 8) {
                SoftReference<ByteBuffer> softReference = softReferenceArr[i3];
                if (softReference != null) {
                    ByteBuffer byteBuffer = softReference.get();
                    if (byteBuffer == null) {
                        softReferenceArr[i3] = null;
                    } else if (byteBuffer.capacity() >= i) {
                        softReferenceArr[i3] = null;
                        byteBuffer.clear();
                        return byteBuffer;
                    }
                }
                i2 = i3 + 1;
            } else {
                ByteBuffer byteBufferAllocateDirect = ByteBuffer.allocateDirect(normalizeCapacity(i));
                byteBufferAllocateDirect.clear();
                return byteBufferAllocateDirect;
            }
        }
    }

    final void release(ByteBuffer byteBuffer) {
        SoftReference<ByteBuffer>[] softReferenceArr = this.pool;
        for (int i = 0; i < 8; i++) {
            SoftReference<ByteBuffer> softReference = softReferenceArr[i];
            if (softReference == null || softReference.get() == null) {
                softReferenceArr[i] = new SoftReference<>(byteBuffer);
                return;
            }
        }
        int iCapacity = byteBuffer.capacity();
        for (int i2 = 0; i2 < 8; i2++) {
            ByteBuffer byteBuffer2 = softReferenceArr[i2].get();
            if (byteBuffer2 == null) {
                softReferenceArr[i2] = null;
            } else if (byteBuffer2.capacity() < iCapacity) {
                softReferenceArr[i2] = new SoftReference<>(byteBuffer);
                return;
            }
        }
    }

    private static final int normalizeCapacity(int i) {
        int i2 = i >>> 10;
        if ((i & 1023) != 0) {
            i2++;
        }
        return i2 << 10;
    }
}
