package org.jboss.netty.buffer;

import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.GatheringByteChannel;
import java.nio.channels.ScatteringByteChannel;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public class CompositeChannelBuffer extends AbstractChannelBuffer {
    static final /* synthetic */ boolean $assertionsDisabled;
    private ChannelBuffer[] components;
    private int[] indices;
    private int lastAccessedComponentId;
    private final ByteOrder order;

    static {
        $assertionsDisabled = !CompositeChannelBuffer.class.desiredAssertionStatus();
    }

    public CompositeChannelBuffer(ByteOrder byteOrder, List list) {
        this.order = byteOrder;
        setComponents(list);
    }

    private CompositeChannelBuffer(CompositeChannelBuffer compositeChannelBuffer) {
        this.order = compositeChannelBuffer.order;
        this.components = (ChannelBuffer[]) compositeChannelBuffer.components.clone();
        this.indices = (int[]) compositeChannelBuffer.indices.clone();
        setIndex(compositeChannelBuffer.readerIndex(), compositeChannelBuffer.writerIndex());
    }

    private int componentId(int i) {
        int i2 = this.lastAccessedComponentId;
        if (i >= this.indices[i2]) {
            if (i >= this.indices[i2 + 1]) {
                do {
                    i2++;
                    if (i2 >= this.components.length) {
                        throw new IndexOutOfBoundsException();
                    }
                } while (i >= this.indices[i2 + 1]);
                this.lastAccessedComponentId = i2;
            }
            return i2;
        }
        i2--;
        while (i2 >= 0) {
            if (i >= this.indices[i2]) {
                this.lastAccessedComponentId = i2;
                return i2;
            }
            i2--;
        }
        throw new IndexOutOfBoundsException();
    }

    private void copyTo(int i, int i2, int i3, ChannelBuffer channelBuffer) {
        int i4 = 0;
        int i5 = i2;
        int i6 = i;
        int i7 = i3;
        while (i5 > 0) {
            ChannelBuffer channelBuffer2 = this.components[i7];
            int i8 = this.indices[i7];
            int iMin = Math.min(i5, channelBuffer2.capacity() - (i6 - i8));
            channelBuffer2.getBytes(i6 - i8, channelBuffer, i4, iMin);
            i6 += iMin;
            i4 += iMin;
            i5 -= iMin;
            i7++;
        }
        channelBuffer.writerIndex(channelBuffer.capacity());
    }

    private void setComponents(List list) {
        if (!$assertionsDisabled && list.isEmpty()) {
            throw new AssertionError();
        }
        this.lastAccessedComponentId = 0;
        this.components = new ChannelBuffer[list.size()];
        for (int i = 0; i < this.components.length; i++) {
            ChannelBuffer channelBuffer = (ChannelBuffer) list.get(i);
            if (channelBuffer.order() != order()) {
                throw new IllegalArgumentException("All buffers must have the same endianness.");
            }
            if (!$assertionsDisabled && channelBuffer.readerIndex() != 0) {
                throw new AssertionError();
            }
            if (!$assertionsDisabled && channelBuffer.writerIndex() != channelBuffer.capacity()) {
                throw new AssertionError();
            }
            this.components[i] = channelBuffer;
        }
        this.indices = new int[this.components.length + 1];
        this.indices[0] = 0;
        for (int i2 = 1; i2 <= this.components.length; i2++) {
            this.indices[i2] = this.indices[i2 - 1] + this.components[i2 - 1].capacity();
        }
        setIndex(0, capacity());
    }

    @Override // org.jboss.netty.buffer.ChannelBuffer
    public byte[] array() {
        throw new UnsupportedOperationException();
    }

    @Override // org.jboss.netty.buffer.ChannelBuffer
    public int arrayOffset() {
        throw new UnsupportedOperationException();
    }

    @Override // org.jboss.netty.buffer.ChannelBuffer
    public int capacity() {
        return this.indices[this.components.length];
    }

    @Override // org.jboss.netty.buffer.ChannelBuffer
    public ChannelBuffer copy(int i, int i2) {
        int iComponentId = componentId(i);
        if (i > capacity() - i2) {
            throw new IndexOutOfBoundsException();
        }
        ChannelBuffer buffer = factory().getBuffer(order(), i2);
        copyTo(i, i2, iComponentId, buffer);
        return buffer;
    }

    public List decompose(int i, int i2) {
        if (i2 == 0) {
            return Collections.emptyList();
        }
        if (i + i2 > capacity()) {
            throw new IndexOutOfBoundsException();
        }
        int iComponentId = componentId(i);
        ArrayList arrayList = new ArrayList(this.components.length);
        ChannelBuffer channelBufferDuplicate = this.components[iComponentId].duplicate();
        channelBufferDuplicate.readerIndex(i - this.indices[iComponentId]);
        int i3 = iComponentId;
        int i4 = i2;
        while (true) {
            int i5 = channelBufferDuplicate.readableBytes();
            if (i4 <= i5) {
                channelBufferDuplicate.writerIndex(i4 + channelBufferDuplicate.readerIndex());
                arrayList.add(channelBufferDuplicate);
                break;
            }
            arrayList.add(channelBufferDuplicate);
            i4 -= i5;
            int i6 = i3 + 1;
            ChannelBuffer channelBufferDuplicate2 = this.components[i6].duplicate();
            if (i4 <= 0) {
                break;
            }
            i3 = i6;
            channelBufferDuplicate = channelBufferDuplicate2;
        }
        for (int i7 = 0; i7 < arrayList.size(); i7++) {
            arrayList.set(i7, ((ChannelBuffer) arrayList.get(i7)).slice());
        }
        return arrayList;
    }

    @Override // org.jboss.netty.buffer.AbstractChannelBuffer, org.jboss.netty.buffer.ChannelBuffer
    public void discardReadBytes() {
        int i;
        int iWriterIndex;
        int i2 = readerIndex();
        if (i2 == 0) {
            return;
        }
        int iWriterIndex2 = writerIndex();
        List listDecompose = decompose(i2, capacity() - i2);
        ChannelBuffer channelBufferBuffer = ChannelBuffers.buffer(order(), i2);
        channelBufferBuffer.writerIndex(i2);
        listDecompose.add(channelBufferBuffer);
        try {
            resetReaderIndex();
            i = readerIndex();
        } catch (IndexOutOfBoundsException e) {
            i = i2;
        }
        try {
            resetWriterIndex();
            iWriterIndex = writerIndex();
        } catch (IndexOutOfBoundsException e2) {
            iWriterIndex = iWriterIndex2;
        }
        setComponents(listDecompose);
        setIndex(Math.max(i - i2, 0), Math.max(iWriterIndex - i2, 0));
        markReaderIndex();
        markWriterIndex();
        setIndex(0, Math.max(iWriterIndex2 - i2, 0));
    }

    @Override // org.jboss.netty.buffer.ChannelBuffer
    public ChannelBuffer duplicate() {
        CompositeChannelBuffer compositeChannelBuffer = new CompositeChannelBuffer(this);
        compositeChannelBuffer.setIndex(readerIndex(), writerIndex());
        return compositeChannelBuffer;
    }

    @Override // org.jboss.netty.buffer.ChannelBuffer
    public ChannelBufferFactory factory() {
        return HeapChannelBufferFactory.getInstance(order());
    }

    @Override // org.jboss.netty.buffer.ChannelBuffer
    public byte getByte(int i) {
        int iComponentId = componentId(i);
        return this.components[iComponentId].getByte(i - this.indices[iComponentId]);
    }

    @Override // org.jboss.netty.buffer.ChannelBuffer
    public int getBytes(int i, GatheringByteChannel gatheringByteChannel, int i2) {
        return gatheringByteChannel.write(toByteBuffer(i, i2));
    }

    @Override // org.jboss.netty.buffer.ChannelBuffer
    public void getBytes(int i, OutputStream outputStream, int i2) {
        int iComponentId = componentId(i);
        if (i > capacity() - i2) {
            throw new IndexOutOfBoundsException();
        }
        int i3 = i2;
        int i4 = i;
        while (i3 > 0) {
            ChannelBuffer channelBuffer = this.components[iComponentId];
            int i5 = this.indices[iComponentId];
            int iMin = Math.min(i3, channelBuffer.capacity() - (i4 - i5));
            channelBuffer.getBytes(i4 - i5, outputStream, iMin);
            i4 += iMin;
            i3 -= iMin;
            iComponentId++;
        }
    }

    @Override // org.jboss.netty.buffer.ChannelBuffer
    public void getBytes(int i, ByteBuffer byteBuffer) {
        int iComponentId = componentId(i);
        int iLimit = byteBuffer.limit();
        int iRemaining = byteBuffer.remaining();
        if (i > capacity() - iRemaining) {
            throw new IndexOutOfBoundsException();
        }
        int i2 = i;
        while (iRemaining > 0) {
            try {
                ChannelBuffer channelBuffer = this.components[iComponentId];
                int i3 = this.indices[iComponentId];
                int iMin = Math.min(iRemaining, channelBuffer.capacity() - (i2 - i3));
                byteBuffer.limit(byteBuffer.position() + iMin);
                channelBuffer.getBytes(i2 - i3, byteBuffer);
                i2 += iMin;
                iRemaining -= iMin;
                iComponentId++;
            } finally {
                byteBuffer.limit(iLimit);
            }
        }
    }

    @Override // org.jboss.netty.buffer.ChannelBuffer
    public void getBytes(int i, ChannelBuffer channelBuffer, int i2, int i3) {
        int iComponentId = componentId(i);
        if (i > capacity() - i3 || i2 > channelBuffer.capacity() - i3) {
            throw new IndexOutOfBoundsException();
        }
        int i4 = i3;
        int i5 = i2;
        int i6 = i;
        while (i4 > 0) {
            ChannelBuffer channelBuffer2 = this.components[iComponentId];
            int i7 = this.indices[iComponentId];
            int iMin = Math.min(i4, channelBuffer2.capacity() - (i6 - i7));
            channelBuffer2.getBytes(i6 - i7, channelBuffer, i5, iMin);
            i6 += iMin;
            i5 += iMin;
            i4 -= iMin;
            iComponentId++;
        }
    }

    @Override // org.jboss.netty.buffer.ChannelBuffer
    public void getBytes(int i, byte[] bArr, int i2, int i3) {
        int iComponentId = componentId(i);
        if (i > capacity() - i3 || i2 > bArr.length - i3) {
            throw new IndexOutOfBoundsException();
        }
        int i4 = i3;
        int i5 = i2;
        int i6 = i;
        while (i4 > 0) {
            ChannelBuffer channelBuffer = this.components[iComponentId];
            int i7 = this.indices[iComponentId];
            int iMin = Math.min(i4, channelBuffer.capacity() - (i6 - i7));
            channelBuffer.getBytes(i6 - i7, bArr, i5, iMin);
            i6 += iMin;
            i5 += iMin;
            i4 -= iMin;
            iComponentId++;
        }
    }

    @Override // org.jboss.netty.buffer.ChannelBuffer
    public int getInt(int i) {
        int iComponentId = componentId(i);
        return i + 4 <= this.indices[iComponentId + 1] ? this.components[iComponentId].getInt(i - this.indices[iComponentId]) : order() == ByteOrder.BIG_ENDIAN ? ((getShort(i) & 65535) << 16) | (getShort(i + 2) & 65535) : (getShort(i) & 65535) | ((getShort(i + 2) & 65535) << 16);
    }

    @Override // org.jboss.netty.buffer.ChannelBuffer
    public long getLong(int i) {
        int iComponentId = componentId(i);
        return i + 8 <= this.indices[iComponentId + 1] ? this.components[iComponentId].getLong(i - this.indices[iComponentId]) : order() == ByteOrder.BIG_ENDIAN ? ((getInt(i) & 4294967295L) << 32) | (getInt(i + 4) & 4294967295L) : (getInt(i) & 4294967295L) | ((getInt(i + 4) & 4294967295L) << 32);
    }

    @Override // org.jboss.netty.buffer.ChannelBuffer
    public short getShort(int i) {
        int iComponentId = componentId(i);
        return i + 2 <= this.indices[iComponentId + 1] ? this.components[iComponentId].getShort(i - this.indices[iComponentId]) : order() == ByteOrder.BIG_ENDIAN ? (short) (((getByte(i) & 255) << 8) | (getByte(i + 1) & 255)) : (short) ((getByte(i) & 255) | ((getByte(i + 1) & 255) << 8));
    }

    @Override // org.jboss.netty.buffer.ChannelBuffer
    public int getUnsignedMedium(int i) {
        int iComponentId = componentId(i);
        return i + 3 <= this.indices[iComponentId + 1] ? this.components[iComponentId].getUnsignedMedium(i - this.indices[iComponentId]) : order() == ByteOrder.BIG_ENDIAN ? ((getShort(i) & 65535) << 8) | (getByte(i + 2) & 255) : (getShort(i) & 65535) | ((getByte(i + 2) & 255) << 16);
    }

    @Override // org.jboss.netty.buffer.ChannelBuffer
    public boolean hasArray() {
        return false;
    }

    @Override // org.jboss.netty.buffer.ChannelBuffer
    public boolean isDirect() {
        return false;
    }

    @Override // org.jboss.netty.buffer.ChannelBuffer
    public ByteOrder order() {
        return this.order;
    }

    @Override // org.jboss.netty.buffer.ChannelBuffer
    public void setByte(int i, int i2) {
        int iComponentId = componentId(i);
        this.components[iComponentId].setByte(i - this.indices[iComponentId], i2);
    }

    @Override // org.jboss.netty.buffer.ChannelBuffer
    public int setBytes(int i, InputStream inputStream, int i2) {
        int iComponentId = componentId(i);
        if (i > capacity() - i2) {
            throw new IndexOutOfBoundsException();
        }
        int i3 = i2;
        int i4 = i;
        int i5 = iComponentId;
        int i6 = 0;
        do {
            ChannelBuffer channelBuffer = this.components[i5];
            int i7 = this.indices[i5];
            int iMin = Math.min(i3, channelBuffer.capacity() - (i4 - i7));
            int bytes = channelBuffer.setBytes(i4 - i7, inputStream, iMin);
            if (bytes < 0) {
                if (i6 == 0) {
                    return -1;
                }
                return i6;
            }
            if (bytes == iMin) {
                i4 += iMin;
                i3 -= iMin;
                i6 += iMin;
                i5++;
            } else {
                i4 += bytes;
                i3 -= bytes;
                i6 += bytes;
            }
        } while (i3 > 0);
        return i6;
    }

    @Override // org.jboss.netty.buffer.ChannelBuffer
    public int setBytes(int i, ScatteringByteChannel scatteringByteChannel, int i2) {
        int iComponentId = componentId(i);
        if (i > capacity() - i2) {
            throw new IndexOutOfBoundsException();
        }
        int i3 = i2;
        int i4 = i;
        int i5 = iComponentId;
        int i6 = 0;
        do {
            ChannelBuffer channelBuffer = this.components[i5];
            int i7 = this.indices[i5];
            int iMin = Math.min(i3, channelBuffer.capacity() - (i4 - i7));
            int bytes = channelBuffer.setBytes(i4 - i7, scatteringByteChannel, iMin);
            if (bytes == iMin) {
                i4 += iMin;
                i3 -= iMin;
                i6 += iMin;
                i5++;
            } else {
                i4 += bytes;
                i3 -= bytes;
                i6 += bytes;
            }
        } while (i3 > 0);
        return i6;
    }

    @Override // org.jboss.netty.buffer.ChannelBuffer
    public void setBytes(int i, ByteBuffer byteBuffer) {
        int iComponentId = componentId(i);
        int iLimit = byteBuffer.limit();
        int iRemaining = byteBuffer.remaining();
        if (i > capacity() - iRemaining) {
            throw new IndexOutOfBoundsException();
        }
        int i2 = i;
        while (iRemaining > 0) {
            try {
                ChannelBuffer channelBuffer = this.components[iComponentId];
                int i3 = this.indices[iComponentId];
                int iMin = Math.min(iRemaining, channelBuffer.capacity() - (i2 - i3));
                byteBuffer.limit(byteBuffer.position() + iMin);
                channelBuffer.setBytes(i2 - i3, byteBuffer);
                i2 += iMin;
                iRemaining -= iMin;
                iComponentId++;
            } finally {
                byteBuffer.limit(iLimit);
            }
        }
    }

    @Override // org.jboss.netty.buffer.ChannelBuffer
    public void setBytes(int i, ChannelBuffer channelBuffer, int i2, int i3) {
        int iComponentId = componentId(i);
        if (i > capacity() - i3 || i2 > channelBuffer.capacity() - i3) {
            throw new IndexOutOfBoundsException();
        }
        int i4 = i3;
        int i5 = i2;
        int i6 = i;
        while (i4 > 0) {
            ChannelBuffer channelBuffer2 = this.components[iComponentId];
            int i7 = this.indices[iComponentId];
            int iMin = Math.min(i4, channelBuffer2.capacity() - (i6 - i7));
            channelBuffer2.setBytes(i6 - i7, channelBuffer, i5, iMin);
            i6 += iMin;
            i5 += iMin;
            i4 -= iMin;
            iComponentId++;
        }
    }

    @Override // org.jboss.netty.buffer.ChannelBuffer
    public void setBytes(int i, byte[] bArr, int i2, int i3) {
        int iComponentId = componentId(i);
        if (i > capacity() - i3 || i2 > bArr.length - i3) {
            throw new IndexOutOfBoundsException();
        }
        int i4 = i3;
        int i5 = i2;
        int i6 = i;
        while (i4 > 0) {
            ChannelBuffer channelBuffer = this.components[iComponentId];
            int i7 = this.indices[iComponentId];
            int iMin = Math.min(i4, channelBuffer.capacity() - (i6 - i7));
            channelBuffer.setBytes(i6 - i7, bArr, i5, iMin);
            i6 += iMin;
            i5 += iMin;
            i4 -= iMin;
            iComponentId++;
        }
    }

    @Override // org.jboss.netty.buffer.ChannelBuffer
    public void setInt(int i, int i2) {
        int iComponentId = componentId(i);
        if (i + 4 <= this.indices[iComponentId + 1]) {
            this.components[iComponentId].setInt(i - this.indices[iComponentId], i2);
        } else if (order() == ByteOrder.BIG_ENDIAN) {
            setShort(i, (short) (i2 >>> 16));
            setShort(i + 2, (short) i2);
        } else {
            setShort(i, (short) i2);
            setShort(i + 2, (short) (i2 >>> 16));
        }
    }

    @Override // org.jboss.netty.buffer.ChannelBuffer
    public void setLong(int i, long j) {
        int iComponentId = componentId(i);
        if (i + 8 <= this.indices[iComponentId + 1]) {
            this.components[iComponentId].setLong(i - this.indices[iComponentId], j);
        } else if (order() == ByteOrder.BIG_ENDIAN) {
            setInt(i, (int) (j >>> 32));
            setInt(i + 4, (int) j);
        } else {
            setInt(i, (int) j);
            setInt(i + 4, (int) (j >>> 32));
        }
    }

    @Override // org.jboss.netty.buffer.ChannelBuffer
    public void setMedium(int i, int i2) {
        int iComponentId = componentId(i);
        if (i + 3 <= this.indices[iComponentId + 1]) {
            this.components[iComponentId].setMedium(i - this.indices[iComponentId], i2);
        } else if (order() == ByteOrder.BIG_ENDIAN) {
            setShort(i, (short) (i2 >> 8));
            setByte(i + 2, (byte) i2);
        } else {
            setShort(i, (short) i2);
            setByte(i + 2, (byte) (i2 >>> 16));
        }
    }

    @Override // org.jboss.netty.buffer.ChannelBuffer
    public void setShort(int i, int i2) {
        int iComponentId = componentId(i);
        if (i + 2 <= this.indices[iComponentId + 1]) {
            this.components[iComponentId].setShort(i - this.indices[iComponentId], i2);
        } else if (order() == ByteOrder.BIG_ENDIAN) {
            setByte(i, (byte) (i2 >>> 8));
            setByte(i + 1, (byte) i2);
        } else {
            setByte(i, (byte) i2);
            setByte(i + 1, (byte) (i2 >>> 8));
        }
    }

    @Override // org.jboss.netty.buffer.ChannelBuffer
    public ChannelBuffer slice(int i, int i2) {
        if (i == 0) {
            if (i2 == 0) {
                return ChannelBuffers.EMPTY_BUFFER;
            }
        } else {
            if (i < 0 || i > capacity() - i2) {
                throw new IndexOutOfBoundsException();
            }
            if (i2 == 0) {
                return ChannelBuffers.EMPTY_BUFFER;
            }
        }
        List listDecompose = decompose(i, i2);
        switch (listDecompose.size()) {
            case 0:
                return ChannelBuffers.EMPTY_BUFFER;
            case 1:
                return (ChannelBuffer) listDecompose.get(0);
            default:
                return new CompositeChannelBuffer(order(), listDecompose);
        }
    }

    @Override // org.jboss.netty.buffer.ChannelBuffer
    public ByteBuffer toByteBuffer(int i, int i2) {
        if (this.components.length == 1) {
            return this.components[0].toByteBuffer(i, i2);
        }
        ByteBuffer[] byteBuffers = toByteBuffers(i, i2);
        ByteBuffer byteBufferOrder = ByteBuffer.allocate(i2).order(order());
        for (ByteBuffer byteBuffer : byteBuffers) {
            byteBufferOrder.put(byteBuffer);
        }
        byteBufferOrder.flip();
        return byteBufferOrder;
    }

    @Override // org.jboss.netty.buffer.AbstractChannelBuffer, org.jboss.netty.buffer.ChannelBuffer
    public ByteBuffer[] toByteBuffers(int i, int i2) {
        int iComponentId = componentId(i);
        if (i + i2 > capacity()) {
            throw new IndexOutOfBoundsException();
        }
        ArrayList arrayList = new ArrayList(this.components.length);
        int i3 = i2;
        int i4 = i;
        while (i3 > 0) {
            ChannelBuffer channelBuffer = this.components[iComponentId];
            int i5 = this.indices[iComponentId];
            int iMin = Math.min(i3, channelBuffer.capacity() - (i4 - i5));
            arrayList.add(channelBuffer.toByteBuffer(i4 - i5, iMin));
            i4 += iMin;
            i3 -= iMin;
            iComponentId++;
        }
        return (ByteBuffer[]) arrayList.toArray(new ByteBuffer[arrayList.size()]);
    }

    @Override // org.jboss.netty.buffer.AbstractChannelBuffer, org.jboss.netty.buffer.ChannelBuffer
    public String toString() {
        String string = super.toString();
        return string.substring(0, string.length() - 1) + ", components=" + this.components.length + ")";
    }
}
