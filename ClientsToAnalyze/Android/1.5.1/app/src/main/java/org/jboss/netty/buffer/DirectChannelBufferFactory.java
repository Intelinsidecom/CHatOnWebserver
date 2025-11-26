package org.jboss.netty.buffer;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* loaded from: classes.dex */
public class DirectChannelBufferFactory extends AbstractChannelBufferFactory {
    private static final DirectChannelBufferFactory INSTANCE_BE = new DirectChannelBufferFactory(ByteOrder.BIG_ENDIAN);
    private static final DirectChannelBufferFactory INSTANCE_LE = new DirectChannelBufferFactory(ByteOrder.LITTLE_ENDIAN);
    private final Object bigEndianLock;
    private final Object littleEndianLock;
    private ChannelBuffer preallocatedBigEndianBuffer;
    private int preallocatedBigEndianBufferPosition;
    private final int preallocatedBufferCapacity;
    private ChannelBuffer preallocatedLittleEndianBuffer;
    private int preallocatedLittleEndianBufferPosition;

    public DirectChannelBufferFactory() {
        this(ByteOrder.BIG_ENDIAN);
    }

    public DirectChannelBufferFactory(int i) {
        this(ByteOrder.BIG_ENDIAN, i);
    }

    public DirectChannelBufferFactory(ByteOrder byteOrder) {
        this(byteOrder, 1048576);
    }

    public DirectChannelBufferFactory(ByteOrder byteOrder, int i) {
        super(byteOrder);
        this.bigEndianLock = new Object();
        this.littleEndianLock = new Object();
        this.preallocatedBigEndianBuffer = null;
        this.preallocatedLittleEndianBuffer = null;
        if (i <= 0) {
            throw new IllegalArgumentException("preallocatedBufferCapacity must be greater than 0: " + i);
        }
        this.preallocatedBufferCapacity = i;
    }

    private ChannelBuffer allocateBigEndianBuffer(int i) {
        ChannelBuffer channelBufferSlice;
        synchronized (this.bigEndianLock) {
            if (this.preallocatedBigEndianBuffer != null && this.preallocatedBigEndianBuffer.capacity() - this.preallocatedBigEndianBufferPosition >= i) {
                channelBufferSlice = this.preallocatedBigEndianBuffer.slice(this.preallocatedBigEndianBufferPosition, i);
                this.preallocatedBigEndianBufferPosition += i;
            } else {
                this.preallocatedBigEndianBuffer = ChannelBuffers.directBuffer(ByteOrder.BIG_ENDIAN, this.preallocatedBufferCapacity);
                channelBufferSlice = this.preallocatedBigEndianBuffer.slice(0, i);
                this.preallocatedBigEndianBufferPosition = i;
            }
        }
        return channelBufferSlice;
    }

    private ChannelBuffer allocateLittleEndianBuffer(int i) {
        ChannelBuffer channelBufferSlice;
        synchronized (this.littleEndianLock) {
            if (this.preallocatedLittleEndianBuffer != null && this.preallocatedLittleEndianBuffer.capacity() - this.preallocatedLittleEndianBufferPosition >= i) {
                channelBufferSlice = this.preallocatedLittleEndianBuffer.slice(this.preallocatedLittleEndianBufferPosition, i);
                this.preallocatedLittleEndianBufferPosition += i;
            } else {
                this.preallocatedLittleEndianBuffer = ChannelBuffers.directBuffer(ByteOrder.LITTLE_ENDIAN, this.preallocatedBufferCapacity);
                channelBufferSlice = this.preallocatedLittleEndianBuffer.slice(0, i);
                this.preallocatedLittleEndianBufferPosition = i;
            }
        }
        return channelBufferSlice;
    }

    public static ChannelBufferFactory getInstance() {
        return INSTANCE_BE;
    }

    public static ChannelBufferFactory getInstance(ByteOrder byteOrder) {
        if (byteOrder == ByteOrder.BIG_ENDIAN) {
            return INSTANCE_BE;
        }
        if (byteOrder == ByteOrder.LITTLE_ENDIAN) {
            return INSTANCE_LE;
        }
        if (byteOrder == null) {
            throw new NullPointerException("defaultEndianness");
        }
        throw new IllegalStateException("Should not reach here");
    }

    @Override // org.jboss.netty.buffer.ChannelBufferFactory
    public ChannelBuffer getBuffer(ByteBuffer byteBuffer) {
        if (!byteBuffer.isReadOnly() && byteBuffer.isDirect()) {
            return ChannelBuffers.wrappedBuffer(byteBuffer);
        }
        ChannelBuffer buffer = getBuffer(byteBuffer.order(), byteBuffer.remaining());
        int iPosition = byteBuffer.position();
        buffer.writeBytes(byteBuffer);
        byteBuffer.position(iPosition);
        return buffer;
    }

    @Override // org.jboss.netty.buffer.ChannelBufferFactory
    public ChannelBuffer getBuffer(ByteOrder byteOrder, int i) {
        if (byteOrder == null) {
            throw new NullPointerException("order");
        }
        if (i < 0) {
            throw new IllegalArgumentException("capacity: " + i);
        }
        if (i == 0) {
            return ChannelBuffers.EMPTY_BUFFER;
        }
        if (i >= this.preallocatedBufferCapacity) {
            return ChannelBuffers.directBuffer(byteOrder, i);
        }
        ChannelBuffer channelBufferAllocateBigEndianBuffer = byteOrder == ByteOrder.BIG_ENDIAN ? allocateBigEndianBuffer(i) : allocateLittleEndianBuffer(i);
        channelBufferAllocateBigEndianBuffer.clear();
        return channelBufferAllocateBigEndianBuffer;
    }

    @Override // org.jboss.netty.buffer.ChannelBufferFactory
    public ChannelBuffer getBuffer(ByteOrder byteOrder, byte[] bArr, int i, int i2) {
        if (bArr == null) {
            throw new NullPointerException("array");
        }
        if (i < 0) {
            throw new IndexOutOfBoundsException("offset: " + i);
        }
        if (i2 == 0) {
            return ChannelBuffers.EMPTY_BUFFER;
        }
        if (i + i2 > bArr.length) {
            throw new IndexOutOfBoundsException("length: " + i2);
        }
        ChannelBuffer buffer = getBuffer(byteOrder, i2);
        buffer.writeBytes(bArr, i, i2);
        return buffer;
    }
}
