package org.jboss.netty.channel.socket.nio;

import java.lang.ref.SoftReference;
import java.nio.ByteBuffer;
import java.nio.channels.WritableByteChannel;
import org.jboss.netty.buffer.ChannelBuffer;
import org.jboss.netty.channel.DefaultFileRegion;
import org.jboss.netty.channel.FileRegion;

/* loaded from: classes.dex */
final class SocketSendBufferPool {
    private static final SendBuffer EMPTY_BUFFER = new EmptySendBuffer();
    PreallocationRef poolHead = null;
    Preallocation current = new Preallocation(65536);

    interface SendBuffer {
        boolean finished();

        void release();

        long totalBytes();

        long transferTo(WritableByteChannel writableByteChannel);

        long writtenBytes();
    }

    SocketSendBufferPool() {
    }

    final SendBuffer acquire(Object obj) {
        if (obj instanceof ChannelBuffer) {
            return acquire((ChannelBuffer) obj);
        }
        if (obj instanceof FileRegion) {
            return acquire((FileRegion) obj);
        }
        throw new IllegalArgumentException("unsupported message type: " + obj.getClass());
    }

    private final SendBuffer acquire(FileRegion fileRegion) {
        return fileRegion.getCount() == 0 ? EMPTY_BUFFER : new FileSendBuffer(fileRegion);
    }

    private final SendBuffer acquire(ChannelBuffer channelBuffer) {
        PooledSendBuffer pooledSendBuffer;
        int i = channelBuffer.readableBytes();
        if (i == 0) {
            return EMPTY_BUFFER;
        }
        if (channelBuffer.isDirect()) {
            return new UnpooledSendBuffer(channelBuffer.toByteBuffer());
        }
        if (channelBuffer.readableBytes() > 65536) {
            return new UnpooledSendBuffer(channelBuffer.toByteBuffer());
        }
        Preallocation preallocation = this.current;
        ByteBuffer byteBuffer = preallocation.buffer;
        int iRemaining = byteBuffer.remaining();
        if (i < iRemaining) {
            int iPosition = i + byteBuffer.position();
            ByteBuffer byteBufferDuplicate = byteBuffer.duplicate();
            byteBuffer.position(align(iPosition));
            byteBufferDuplicate.limit(iPosition);
            preallocation.refCnt++;
            pooledSendBuffer = new PooledSendBuffer(preallocation, byteBufferDuplicate);
        } else if (i > iRemaining) {
            Preallocation preallocation2 = getPreallocation();
            this.current = preallocation2;
            ByteBuffer byteBuffer2 = preallocation2.buffer;
            ByteBuffer byteBufferDuplicate2 = byteBuffer2.duplicate();
            byteBuffer2.position(align(i));
            byteBufferDuplicate2.limit(i);
            preallocation2.refCnt++;
            pooledSendBuffer = new PooledSendBuffer(preallocation2, byteBufferDuplicate2);
        } else {
            preallocation.refCnt++;
            this.current = getPreallocation0();
            pooledSendBuffer = new PooledSendBuffer(preallocation, preallocation.buffer);
        }
        ByteBuffer byteBuffer3 = pooledSendBuffer.buffer;
        byteBuffer3.mark();
        channelBuffer.getBytes(channelBuffer.readerIndex(), byteBuffer3);
        byteBuffer3.reset();
        return pooledSendBuffer;
    }

    private final Preallocation getPreallocation() {
        Preallocation preallocation = this.current;
        if (preallocation.refCnt != 0) {
            return getPreallocation0();
        }
        preallocation.buffer.clear();
        return preallocation;
    }

    private final Preallocation getPreallocation0() {
        PreallocationRef preallocationRef = this.poolHead;
        if (preallocationRef != null) {
            PreallocationRef preallocationRef2 = preallocationRef;
            do {
                Preallocation preallocation = preallocationRef2.get();
                preallocationRef2 = preallocationRef2.next;
                if (preallocation != null) {
                    this.poolHead = preallocationRef2;
                    return preallocation;
                }
            } while (preallocationRef2 != null);
            this.poolHead = preallocationRef2;
        }
        return new Preallocation(65536);
    }

    private static final int align(int i) {
        int i2 = i >>> 4;
        if ((i & 15) != 0) {
            i2++;
        }
        return i2 << 4;
    }

    final class Preallocation {
        final ByteBuffer buffer;
        int refCnt;

        Preallocation(int i) {
            this.buffer = ByteBuffer.allocateDirect(i);
        }
    }

    final class PreallocationRef extends SoftReference<Preallocation> {
        final PreallocationRef next;

        PreallocationRef(Preallocation preallocation, PreallocationRef preallocationRef) {
            super(preallocation);
            this.next = preallocationRef;
        }
    }

    class UnpooledSendBuffer implements SendBuffer {
        final ByteBuffer buffer;
        final int initialPos;

        UnpooledSendBuffer(ByteBuffer byteBuffer) {
            this.buffer = byteBuffer;
            this.initialPos = byteBuffer.position();
        }

        @Override // org.jboss.netty.channel.socket.nio.SocketSendBufferPool.SendBuffer
        public final boolean finished() {
            return !this.buffer.hasRemaining();
        }

        @Override // org.jboss.netty.channel.socket.nio.SocketSendBufferPool.SendBuffer
        public final long writtenBytes() {
            return this.buffer.position() - this.initialPos;
        }

        @Override // org.jboss.netty.channel.socket.nio.SocketSendBufferPool.SendBuffer
        public final long totalBytes() {
            return this.buffer.limit() - this.initialPos;
        }

        @Override // org.jboss.netty.channel.socket.nio.SocketSendBufferPool.SendBuffer
        public final long transferTo(WritableByteChannel writableByteChannel) {
            return writableByteChannel.write(this.buffer);
        }

        @Override // org.jboss.netty.channel.socket.nio.SocketSendBufferPool.SendBuffer
        public void release() {
        }
    }

    final class PooledSendBuffer implements SendBuffer {
        final ByteBuffer buffer;
        final int initialPos;
        private final Preallocation parent;

        PooledSendBuffer(Preallocation preallocation, ByteBuffer byteBuffer) {
            this.parent = preallocation;
            this.buffer = byteBuffer;
            this.initialPos = byteBuffer.position();
        }

        @Override // org.jboss.netty.channel.socket.nio.SocketSendBufferPool.SendBuffer
        public boolean finished() {
            return !this.buffer.hasRemaining();
        }

        @Override // org.jboss.netty.channel.socket.nio.SocketSendBufferPool.SendBuffer
        public long writtenBytes() {
            return this.buffer.position() - this.initialPos;
        }

        @Override // org.jboss.netty.channel.socket.nio.SocketSendBufferPool.SendBuffer
        public long totalBytes() {
            return this.buffer.limit() - this.initialPos;
        }

        @Override // org.jboss.netty.channel.socket.nio.SocketSendBufferPool.SendBuffer
        public long transferTo(WritableByteChannel writableByteChannel) {
            return writableByteChannel.write(this.buffer);
        }

        @Override // org.jboss.netty.channel.socket.nio.SocketSendBufferPool.SendBuffer
        public void release() {
            Preallocation preallocation = this.parent;
            int i = preallocation.refCnt - 1;
            preallocation.refCnt = i;
            if (i == 0) {
                preallocation.buffer.clear();
                if (preallocation != SocketSendBufferPool.this.current) {
                    SocketSendBufferPool.this.poolHead = SocketSendBufferPool.this.new PreallocationRef(preallocation, SocketSendBufferPool.this.poolHead);
                }
            }
        }
    }

    final class FileSendBuffer implements SendBuffer {
        private final FileRegion file;
        private long writtenBytes;

        FileSendBuffer(FileRegion fileRegion) {
            this.file = fileRegion;
        }

        @Override // org.jboss.netty.channel.socket.nio.SocketSendBufferPool.SendBuffer
        public boolean finished() {
            return this.writtenBytes >= this.file.getCount();
        }

        @Override // org.jboss.netty.channel.socket.nio.SocketSendBufferPool.SendBuffer
        public long writtenBytes() {
            return this.writtenBytes;
        }

        @Override // org.jboss.netty.channel.socket.nio.SocketSendBufferPool.SendBuffer
        public long totalBytes() {
            return this.file.getCount();
        }

        @Override // org.jboss.netty.channel.socket.nio.SocketSendBufferPool.SendBuffer
        public long transferTo(WritableByteChannel writableByteChannel) {
            long jTransferTo = this.file.transferTo(writableByteChannel, this.writtenBytes);
            this.writtenBytes += jTransferTo;
            return jTransferTo;
        }

        @Override // org.jboss.netty.channel.socket.nio.SocketSendBufferPool.SendBuffer
        public void release() {
            if ((this.file instanceof DefaultFileRegion) && ((DefaultFileRegion) this.file).releaseAfterTransfer()) {
                this.file.releaseExternalResources();
            }
        }
    }

    final class EmptySendBuffer implements SendBuffer {
        EmptySendBuffer() {
        }

        @Override // org.jboss.netty.channel.socket.nio.SocketSendBufferPool.SendBuffer
        public final boolean finished() {
            return true;
        }

        @Override // org.jboss.netty.channel.socket.nio.SocketSendBufferPool.SendBuffer
        public final long writtenBytes() {
            return 0L;
        }

        @Override // org.jboss.netty.channel.socket.nio.SocketSendBufferPool.SendBuffer
        public final long totalBytes() {
            return 0L;
        }

        @Override // org.jboss.netty.channel.socket.nio.SocketSendBufferPool.SendBuffer
        public final long transferTo(WritableByteChannel writableByteChannel) {
            return 0L;
        }

        @Override // org.jboss.netty.channel.socket.nio.SocketSendBufferPool.SendBuffer
        public void release() {
        }
    }
}
