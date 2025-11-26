package org.jboss.netty.buffer;

import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.accessibility.AccessibilityEventCompat;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.CharBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.CoderResult;
import java.util.ArrayList;
import java.util.List;
import org.jboss.netty.util.CharsetUtil;

/* loaded from: classes.dex */
public class ChannelBuffers {
    public static final ByteOrder BIG_ENDIAN = ByteOrder.BIG_ENDIAN;
    public static final ByteOrder LITTLE_ENDIAN = ByteOrder.LITTLE_ENDIAN;
    public static final ChannelBuffer EMPTY_BUFFER = new BigEndianHeapChannelBuffer(0);
    private static final char[] HEXDUMP_TABLE = new char[AccessibilityEventCompat.TYPE_TOUCH_EXPLORATION_GESTURE_END];

    static {
        char[] charArray = "0123456789abcdef".toCharArray();
        for (int i = 0; i < 256; i++) {
            HEXDUMP_TABLE[(i << 1) + 0] = charArray[(i >>> 4) & 15];
            HEXDUMP_TABLE[(i << 1) + 1] = charArray[(i >>> 0) & 15];
        }
    }

    public static ChannelBuffer buffer(int i) {
        return buffer(BIG_ENDIAN, i);
    }

    public static ChannelBuffer buffer(ByteOrder byteOrder, int i) {
        if (byteOrder == BIG_ENDIAN) {
            if (i == 0) {
                return EMPTY_BUFFER;
            }
            return new BigEndianHeapChannelBuffer(i);
        }
        if (byteOrder == LITTLE_ENDIAN) {
            if (i == 0) {
                return EMPTY_BUFFER;
            }
            return new LittleEndianHeapChannelBuffer(i);
        }
        throw new NullPointerException("endianness");
    }

    public static ChannelBuffer directBuffer(int i) {
        return directBuffer(BIG_ENDIAN, i);
    }

    public static ChannelBuffer directBuffer(ByteOrder byteOrder, int i) {
        if (byteOrder == null) {
            throw new NullPointerException("endianness");
        }
        if (i == 0) {
            return EMPTY_BUFFER;
        }
        ByteBufferBackedChannelBuffer byteBufferBackedChannelBuffer = new ByteBufferBackedChannelBuffer(ByteBuffer.allocateDirect(i).order(byteOrder));
        byteBufferBackedChannelBuffer.clear();
        return byteBufferBackedChannelBuffer;
    }

    public static ChannelBuffer dynamicBuffer() {
        return dynamicBuffer(BIG_ENDIAN, AccessibilityEventCompat.TYPE_VIEW_HOVER_EXIT);
    }

    public static ChannelBuffer dynamicBuffer(ChannelBufferFactory channelBufferFactory) {
        if (channelBufferFactory == null) {
            throw new NullPointerException("factory");
        }
        return new DynamicChannelBuffer(channelBufferFactory.getDefaultOrder(), AccessibilityEventCompat.TYPE_VIEW_HOVER_EXIT, channelBufferFactory);
    }

    public static ChannelBuffer dynamicBuffer(int i) {
        return dynamicBuffer(BIG_ENDIAN, i);
    }

    public static ChannelBuffer dynamicBuffer(ByteOrder byteOrder, int i) {
        return new DynamicChannelBuffer(byteOrder, i);
    }

    public static ChannelBuffer dynamicBuffer(int i, ChannelBufferFactory channelBufferFactory) {
        if (channelBufferFactory == null) {
            throw new NullPointerException("factory");
        }
        return new DynamicChannelBuffer(channelBufferFactory.getDefaultOrder(), i, channelBufferFactory);
    }

    public static ChannelBuffer dynamicBuffer(ByteOrder byteOrder, int i, ChannelBufferFactory channelBufferFactory) {
        return new DynamicChannelBuffer(byteOrder, i, channelBufferFactory);
    }

    public static ChannelBuffer wrappedBuffer(byte[] bArr) {
        return wrappedBuffer(BIG_ENDIAN, bArr);
    }

    public static ChannelBuffer wrappedBuffer(ByteOrder byteOrder, byte[] bArr) {
        if (byteOrder == BIG_ENDIAN) {
            if (bArr.length == 0) {
                return EMPTY_BUFFER;
            }
            return new BigEndianHeapChannelBuffer(bArr);
        }
        if (byteOrder == LITTLE_ENDIAN) {
            if (bArr.length == 0) {
                return EMPTY_BUFFER;
            }
            return new LittleEndianHeapChannelBuffer(bArr);
        }
        throw new NullPointerException("endianness");
    }

    public static ChannelBuffer wrappedBuffer(byte[] bArr, int i, int i2) {
        return wrappedBuffer(BIG_ENDIAN, bArr, i, i2);
    }

    public static ChannelBuffer wrappedBuffer(ByteOrder byteOrder, byte[] bArr, int i, int i2) {
        if (byteOrder == null) {
            throw new NullPointerException("endianness");
        }
        if (i == 0) {
            if (i2 == bArr.length) {
                return wrappedBuffer(byteOrder, bArr);
            }
            if (i2 == 0) {
                return EMPTY_BUFFER;
            }
            return new TruncatedChannelBuffer(wrappedBuffer(byteOrder, bArr), i2);
        }
        if (i2 == 0) {
            return EMPTY_BUFFER;
        }
        return new SlicedChannelBuffer(wrappedBuffer(byteOrder, bArr), i, i2);
    }

    public static ChannelBuffer wrappedBuffer(ByteBuffer byteBuffer) {
        if (!byteBuffer.hasRemaining()) {
            return EMPTY_BUFFER;
        }
        if (byteBuffer.hasArray()) {
            return wrappedBuffer(byteBuffer.order(), byteBuffer.array(), byteBuffer.arrayOffset() + byteBuffer.position(), byteBuffer.remaining());
        }
        return new ByteBufferBackedChannelBuffer(byteBuffer);
    }

    public static ChannelBuffer wrappedBuffer(ChannelBuffer channelBuffer) {
        return channelBuffer.readable() ? channelBuffer.slice() : EMPTY_BUFFER;
    }

    public static ChannelBuffer wrappedBuffer(byte[]... bArr) {
        return wrappedBuffer(BIG_ENDIAN, bArr);
    }

    public static ChannelBuffer wrappedBuffer(ByteOrder byteOrder, byte[]... bArr) {
        switch (bArr.length) {
            case 0:
                break;
            case 1:
                if (bArr[0].length != 0) {
                    return wrappedBuffer(byteOrder, bArr[0]);
                }
                break;
            default:
                ArrayList arrayList = new ArrayList(bArr.length);
                for (byte[] bArr2 : bArr) {
                    if (bArr2 != null) {
                        if (bArr2.length > 0) {
                            arrayList.add(wrappedBuffer(byteOrder, bArr2));
                        }
                    } else {
                        return compositeBuffer(byteOrder, arrayList);
                    }
                }
                return compositeBuffer(byteOrder, arrayList);
        }
        return EMPTY_BUFFER;
    }

    private static ChannelBuffer compositeBuffer(ByteOrder byteOrder, List list) {
        switch (list.size()) {
            case 0:
                return EMPTY_BUFFER;
            case 1:
                return (ChannelBuffer) list.get(0);
            default:
                return new CompositeChannelBuffer(byteOrder, list);
        }
    }

    public static ChannelBuffer wrappedBuffer(ChannelBuffer... channelBufferArr) {
        ByteOrder byteOrderOrder;
        switch (channelBufferArr.length) {
            case 0:
                break;
            case 1:
                if (channelBufferArr[0].readable()) {
                    return wrappedBuffer(channelBufferArr[0]);
                }
                break;
            default:
                ArrayList arrayList = new ArrayList(channelBufferArr.length);
                int length = channelBufferArr.length;
                int i = 0;
                ByteOrder byteOrder = null;
                while (i < length) {
                    ChannelBuffer channelBuffer = channelBufferArr[i];
                    if (channelBuffer != null) {
                        if (channelBuffer.readable()) {
                            if (byteOrder != null) {
                                if (!byteOrder.equals(channelBuffer.order())) {
                                    throw new IllegalArgumentException("inconsistent byte order");
                                }
                                byteOrderOrder = byteOrder;
                            } else {
                                byteOrderOrder = channelBuffer.order();
                            }
                            if (channelBuffer instanceof CompositeChannelBuffer) {
                                arrayList.addAll(((CompositeChannelBuffer) channelBuffer).decompose(channelBuffer.readerIndex(), channelBuffer.readableBytes()));
                            } else {
                                arrayList.add(channelBuffer.slice());
                            }
                        } else {
                            byteOrderOrder = byteOrder;
                        }
                        i++;
                        byteOrder = byteOrderOrder;
                    } else {
                        return compositeBuffer(byteOrder, arrayList);
                    }
                }
                return compositeBuffer(byteOrder, arrayList);
        }
        return EMPTY_BUFFER;
    }

    public static ChannelBuffer wrappedBuffer(ByteBuffer... byteBufferArr) {
        switch (byteBufferArr.length) {
            case 0:
                break;
            case 1:
                if (byteBufferArr[0].hasRemaining()) {
                    return wrappedBuffer(byteBufferArr[0]);
                }
                break;
            default:
                ArrayList arrayList = new ArrayList(byteBufferArr.length);
                ByteOrder byteOrderOrder = null;
                for (ByteBuffer byteBuffer : byteBufferArr) {
                    if (byteBuffer != null) {
                        if (byteBuffer.hasRemaining()) {
                            if (byteOrderOrder != null) {
                                if (!byteOrderOrder.equals(byteBuffer.order())) {
                                    throw new IllegalArgumentException("inconsistent byte order");
                                }
                            } else {
                                byteOrderOrder = byteBuffer.order();
                            }
                            arrayList.add(wrappedBuffer(byteBuffer));
                        }
                    } else {
                        return compositeBuffer(byteOrderOrder, arrayList);
                    }
                }
                return compositeBuffer(byteOrderOrder, arrayList);
        }
        return EMPTY_BUFFER;
    }

    public static ChannelBuffer copiedBuffer(byte[] bArr) {
        return copiedBuffer(BIG_ENDIAN, bArr);
    }

    public static ChannelBuffer copiedBuffer(ByteOrder byteOrder, byte[] bArr) {
        if (byteOrder == BIG_ENDIAN) {
            if (bArr.length == 0) {
                return EMPTY_BUFFER;
            }
            return new BigEndianHeapChannelBuffer((byte[]) bArr.clone());
        }
        if (byteOrder == LITTLE_ENDIAN) {
            if (bArr.length == 0) {
                return EMPTY_BUFFER;
            }
            return new LittleEndianHeapChannelBuffer((byte[]) bArr.clone());
        }
        throw new NullPointerException("endianness");
    }

    public static ChannelBuffer copiedBuffer(byte[] bArr, int i, int i2) {
        return copiedBuffer(BIG_ENDIAN, bArr, i, i2);
    }

    public static ChannelBuffer copiedBuffer(ByteOrder byteOrder, byte[] bArr, int i, int i2) {
        if (byteOrder == null) {
            throw new NullPointerException("endianness");
        }
        if (i2 == 0) {
            return EMPTY_BUFFER;
        }
        byte[] bArr2 = new byte[i2];
        System.arraycopy(bArr, i, bArr2, 0, i2);
        return wrappedBuffer(byteOrder, bArr2);
    }

    public static ChannelBuffer copiedBuffer(ByteBuffer byteBuffer) {
        int iRemaining = byteBuffer.remaining();
        if (iRemaining == 0) {
            return EMPTY_BUFFER;
        }
        byte[] bArr = new byte[iRemaining];
        int iPosition = byteBuffer.position();
        try {
            byteBuffer.get(bArr);
            byteBuffer.position(iPosition);
            return wrappedBuffer(byteBuffer.order(), bArr);
        } catch (Throwable th) {
            byteBuffer.position(iPosition);
            throw th;
        }
    }

    public static ChannelBuffer copiedBuffer(ChannelBuffer channelBuffer) {
        return channelBuffer.readable() ? channelBuffer.copy() : EMPTY_BUFFER;
    }

    public static ChannelBuffer copiedBuffer(byte[]... bArr) {
        return copiedBuffer(BIG_ENDIAN, bArr);
    }

    public static ChannelBuffer copiedBuffer(ByteOrder byteOrder, byte[]... bArr) {
        switch (bArr.length) {
            case 0:
                return EMPTY_BUFFER;
            case 1:
                if (bArr[0].length == 0) {
                    return EMPTY_BUFFER;
                }
                return copiedBuffer(byteOrder, bArr[0]);
            default:
                int length = 0;
                for (byte[] bArr2 : bArr) {
                    if (Integer.MAX_VALUE - length < bArr2.length) {
                        throw new IllegalArgumentException("The total length of the specified arrays is too big.");
                    }
                    length += bArr2.length;
                }
                if (length == 0) {
                    return EMPTY_BUFFER;
                }
                byte[] bArr3 = new byte[length];
                int length2 = 0;
                for (byte[] bArr4 : bArr) {
                    System.arraycopy(bArr4, 0, bArr3, length2, bArr4.length);
                    length2 += bArr4.length;
                }
                return wrappedBuffer(byteOrder, bArr3);
        }
    }

    public static ChannelBuffer copiedBuffer(ChannelBuffer... channelBufferArr) {
        switch (channelBufferArr.length) {
            case 0:
                return EMPTY_BUFFER;
            case 1:
                return copiedBuffer(channelBufferArr[0]);
            default:
                ChannelBuffer[] channelBufferArr2 = new ChannelBuffer[channelBufferArr.length];
                for (int i = 0; i < channelBufferArr.length; i++) {
                    channelBufferArr2[i] = copiedBuffer(channelBufferArr[i]);
                }
                return wrappedBuffer(channelBufferArr2);
        }
    }

    public static ChannelBuffer copiedBuffer(ByteBuffer... byteBufferArr) {
        switch (byteBufferArr.length) {
            case 0:
                return EMPTY_BUFFER;
            case 1:
                return copiedBuffer(byteBufferArr[0]);
            default:
                ChannelBuffer[] channelBufferArr = new ChannelBuffer[byteBufferArr.length];
                for (int i = 0; i < byteBufferArr.length; i++) {
                    channelBufferArr[i] = copiedBuffer(byteBufferArr[i]);
                }
                return wrappedBuffer(channelBufferArr);
        }
    }

    public static ChannelBuffer copiedBuffer(CharSequence charSequence, Charset charset) {
        return copiedBuffer(BIG_ENDIAN, charSequence, charset);
    }

    public static ChannelBuffer copiedBuffer(CharSequence charSequence, int i, int i2, Charset charset) {
        return copiedBuffer(BIG_ENDIAN, charSequence, i, i2, charset);
    }

    public static ChannelBuffer copiedBuffer(ByteOrder byteOrder, CharSequence charSequence, Charset charset) {
        if (charSequence == null) {
            throw new NullPointerException("string");
        }
        return charSequence instanceof CharBuffer ? copiedBuffer(byteOrder, (CharBuffer) charSequence, charset) : copiedBuffer(byteOrder, CharBuffer.wrap(charSequence), charset);
    }

    public static ChannelBuffer copiedBuffer(ByteOrder byteOrder, CharSequence charSequence, int i, int i2, Charset charset) {
        if (charSequence == null) {
            throw new NullPointerException("string");
        }
        if (i2 == 0) {
            return EMPTY_BUFFER;
        }
        if (charSequence instanceof CharBuffer) {
            CharBuffer charBuffer = (CharBuffer) charSequence;
            if (charBuffer.hasArray()) {
                return copiedBuffer(byteOrder, charBuffer.array(), charBuffer.arrayOffset() + charBuffer.position() + i, i2, charset);
            }
            CharBuffer charBufferSlice = charBuffer.slice();
            charBufferSlice.limit(i2);
            charBufferSlice.position(i);
            return copiedBuffer(byteOrder, charBufferSlice, charset);
        }
        return copiedBuffer(byteOrder, CharBuffer.wrap(charSequence, i, i + i2), charset);
    }

    public static ChannelBuffer copiedBuffer(char[] cArr, Charset charset) {
        return copiedBuffer(BIG_ENDIAN, cArr, 0, cArr.length, charset);
    }

    public static ChannelBuffer copiedBuffer(char[] cArr, int i, int i2, Charset charset) {
        return copiedBuffer(BIG_ENDIAN, cArr, i, i2, charset);
    }

    public static ChannelBuffer copiedBuffer(ByteOrder byteOrder, char[] cArr, Charset charset) {
        return copiedBuffer(byteOrder, cArr, 0, cArr.length, charset);
    }

    public static ChannelBuffer copiedBuffer(ByteOrder byteOrder, char[] cArr, int i, int i2, Charset charset) {
        if (cArr == null) {
            throw new NullPointerException("array");
        }
        return i2 == 0 ? EMPTY_BUFFER : copiedBuffer(byteOrder, CharBuffer.wrap(cArr, i, i2), charset);
    }

    private static ChannelBuffer copiedBuffer(ByteOrder byteOrder, CharBuffer charBuffer, Charset charset) throws CharacterCodingException {
        ByteBuffer byteBufferEncodeString = encodeString(charBuffer, charset);
        ChannelBuffer channelBufferWrappedBuffer = wrappedBuffer(byteOrder, byteBufferEncodeString.array());
        channelBufferWrappedBuffer.writerIndex(byteBufferEncodeString.remaining());
        return channelBufferWrappedBuffer;
    }

    @Deprecated
    public static ChannelBuffer copiedBuffer(String str, String str2) {
        return copiedBuffer(str, Charset.forName(str2));
    }

    @Deprecated
    public static ChannelBuffer copiedBuffer(ByteOrder byteOrder, String str, String str2) {
        return copiedBuffer(byteOrder, str, Charset.forName(str2));
    }

    public static ChannelBuffer unmodifiableBuffer(ChannelBuffer channelBuffer) {
        if (channelBuffer instanceof ReadOnlyChannelBuffer) {
            channelBuffer = ((ReadOnlyChannelBuffer) channelBuffer).unwrap();
        }
        return new ReadOnlyChannelBuffer(channelBuffer);
    }

    public static String hexDump(ChannelBuffer channelBuffer) {
        return hexDump(channelBuffer, channelBuffer.readerIndex(), channelBuffer.readableBytes());
    }

    public static String hexDump(ChannelBuffer channelBuffer, int i, int i2) {
        if (i2 < 0) {
            throw new IllegalArgumentException("length: " + i2);
        }
        if (i2 == 0) {
            return "";
        }
        int i3 = i + i2;
        char[] cArr = new char[i2 << 1];
        int i4 = 0;
        while (i < i3) {
            System.arraycopy(HEXDUMP_TABLE, channelBuffer.getUnsignedByte(i) << 1, cArr, i4, 2);
            i++;
            i4 += 2;
        }
        return new String(cArr);
    }

    public static int hashCode(ChannelBuffer channelBuffer) {
        int i;
        int i2;
        int i3 = channelBuffer.readableBytes();
        int i4 = i3 >>> 2;
        int i5 = i3 & 3;
        int i6 = channelBuffer.readerIndex();
        if (channelBuffer.order() == BIG_ENDIAN) {
            int i7 = i4;
            i = i6;
            i2 = 1;
            while (i7 > 0) {
                int i8 = channelBuffer.getInt(i) + (i2 * 31);
                i7--;
                i += 4;
                i2 = i8;
            }
        } else {
            int i9 = i4;
            i = i6;
            i2 = 1;
            while (i9 > 0) {
                int iSwapInt = swapInt(channelBuffer.getInt(i)) + (i2 * 31);
                i9--;
                i += 4;
                i2 = iSwapInt;
            }
        }
        int i10 = i;
        int i11 = i2;
        int i12 = i5;
        while (i12 > 0) {
            i12--;
            i11 = channelBuffer.getByte(i10) + (i11 * 31);
            i10++;
        }
        if (i11 == 0) {
            return 1;
        }
        return i11;
    }

    public static boolean equals(ChannelBuffer channelBuffer, ChannelBuffer channelBuffer2) {
        int i;
        int i2;
        int i3 = channelBuffer.readableBytes();
        if (i3 != channelBuffer2.readableBytes()) {
            return false;
        }
        int i4 = i3 >>> 3;
        int i5 = i3 & 7;
        int i6 = channelBuffer.readerIndex();
        int i7 = channelBuffer2.readerIndex();
        if (channelBuffer.order() == channelBuffer2.order()) {
            i = i7;
            i2 = i6;
            int i8 = i4;
            while (i8 > 0) {
                if (channelBuffer.getLong(i2) != channelBuffer2.getLong(i)) {
                    return false;
                }
                i8--;
                i += 8;
                i2 += 8;
            }
        } else {
            i = i7;
            i2 = i6;
            int i9 = i4;
            while (i9 > 0) {
                if (channelBuffer.getLong(i2) != swapLong(channelBuffer2.getLong(i))) {
                    return false;
                }
                i9--;
                i += 8;
                i2 += 8;
            }
        }
        int i10 = i2;
        int i11 = i;
        for (int i12 = i5; i12 > 0; i12--) {
            if (channelBuffer.getByte(i10) != channelBuffer2.getByte(i11)) {
                return false;
            }
            i10++;
            i11++;
        }
        return true;
    }

    public static int compare(ChannelBuffer channelBuffer, ChannelBuffer channelBuffer2) {
        int i;
        int i2;
        int i3 = channelBuffer.readableBytes();
        int i4 = channelBuffer2.readableBytes();
        int iMin = Math.min(i3, i4);
        int i5 = iMin >>> 2;
        int i6 = iMin & 3;
        int i7 = channelBuffer.readerIndex();
        int i8 = channelBuffer2.readerIndex();
        if (channelBuffer.order() == channelBuffer2.order()) {
            i = i8;
            i2 = i7;
            int i9 = i5;
            while (i9 > 0) {
                long unsignedInt = channelBuffer.getUnsignedInt(i2);
                long unsignedInt2 = channelBuffer2.getUnsignedInt(i);
                if (unsignedInt > unsignedInt2) {
                    return 1;
                }
                if (unsignedInt < unsignedInt2) {
                    return -1;
                }
                i9--;
                i += 4;
                i2 += 4;
            }
        } else {
            i = i8;
            i2 = i7;
            int i10 = i5;
            while (i10 > 0) {
                long unsignedInt3 = channelBuffer.getUnsignedInt(i2);
                long jSwapInt = swapInt(channelBuffer2.getInt(i)) & 4294967295L;
                if (unsignedInt3 > jSwapInt) {
                    return 1;
                }
                if (unsignedInt3 < jSwapInt) {
                    return -1;
                }
                i10--;
                i += 4;
                i2 += 4;
            }
        }
        int i11 = i2;
        int i12 = i;
        for (int i13 = i6; i13 > 0; i13--) {
            short unsignedByte = channelBuffer.getUnsignedByte(i11);
            short unsignedByte2 = channelBuffer2.getUnsignedByte(i12);
            if (unsignedByte > unsignedByte2) {
                return 1;
            }
            if (unsignedByte < unsignedByte2) {
                return -1;
            }
            i11++;
            i12++;
        }
        return i3 - i4;
    }

    public static int indexOf(ChannelBuffer channelBuffer, int i, int i2, byte b) {
        return i <= i2 ? firstIndexOf(channelBuffer, i, i2, b) : lastIndexOf(channelBuffer, i, i2, b);
    }

    public static int indexOf(ChannelBuffer channelBuffer, int i, int i2, ChannelBufferIndexFinder channelBufferIndexFinder) {
        return i <= i2 ? firstIndexOf(channelBuffer, i, i2, channelBufferIndexFinder) : lastIndexOf(channelBuffer, i, i2, channelBufferIndexFinder);
    }

    public static short swapShort(short s) {
        return (short) ((s << 8) | ((s >>> 8) & MotionEventCompat.ACTION_MASK));
    }

    public static int swapMedium(int i) {
        return ((i << 16) & 16711680) | (65280 & i) | ((i >>> 16) & MotionEventCompat.ACTION_MASK);
    }

    public static int swapInt(int i) {
        return (swapShort((short) i) << 16) | (swapShort((short) (i >>> 16)) & 65535);
    }

    public static long swapLong(long j) {
        return (swapInt((int) j) << 32) | (swapInt((int) (j >>> 32)) & 4294967295L);
    }

    private static int firstIndexOf(ChannelBuffer channelBuffer, int i, int i2, byte b) {
        int iMax = Math.max(i, 0);
        if (iMax >= i2 || channelBuffer.capacity() == 0) {
            return -1;
        }
        while (iMax < i2) {
            if (channelBuffer.getByte(iMax) != b) {
                iMax++;
            } else {
                return iMax;
            }
        }
        return -1;
    }

    private static int lastIndexOf(ChannelBuffer channelBuffer, int i, int i2, byte b) {
        int iMin = Math.min(i, channelBuffer.capacity());
        if (iMin < 0 || channelBuffer.capacity() == 0) {
            return -1;
        }
        for (int i3 = iMin - 1; i3 >= i2; i3--) {
            if (channelBuffer.getByte(i3) == b) {
                return i3;
            }
        }
        return -1;
    }

    private static int firstIndexOf(ChannelBuffer channelBuffer, int i, int i2, ChannelBufferIndexFinder channelBufferIndexFinder) {
        int iMax = Math.max(i, 0);
        if (iMax >= i2 || channelBuffer.capacity() == 0) {
            return -1;
        }
        while (iMax < i2) {
            if (!channelBufferIndexFinder.find(channelBuffer, iMax)) {
                iMax++;
            } else {
                return iMax;
            }
        }
        return -1;
    }

    private static int lastIndexOf(ChannelBuffer channelBuffer, int i, int i2, ChannelBufferIndexFinder channelBufferIndexFinder) {
        int iMin = Math.min(i, channelBuffer.capacity());
        if (iMin < 0 || channelBuffer.capacity() == 0) {
            return -1;
        }
        for (int i3 = iMin - 1; i3 >= i2; i3--) {
            if (channelBufferIndexFinder.find(channelBuffer, i3)) {
                return i3;
            }
        }
        return -1;
    }

    static ByteBuffer encodeString(CharBuffer charBuffer, Charset charset) throws CharacterCodingException {
        CharsetEncoder encoder = CharsetUtil.getEncoder(charset);
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate((int) (charBuffer.remaining() * encoder.maxBytesPerChar()));
        try {
            CoderResult coderResultEncode = encoder.encode(charBuffer, byteBufferAllocate, true);
            if (!coderResultEncode.isUnderflow()) {
                coderResultEncode.throwException();
            }
            CoderResult coderResultFlush = encoder.flush(byteBufferAllocate);
            if (!coderResultFlush.isUnderflow()) {
                coderResultFlush.throwException();
            }
            byteBufferAllocate.flip();
            return byteBufferAllocate;
        } catch (CharacterCodingException e) {
            throw new IllegalStateException(e);
        }
    }

    static String decodeString(ByteBuffer byteBuffer, Charset charset) throws CharacterCodingException {
        CharsetDecoder decoder = CharsetUtil.getDecoder(charset);
        CharBuffer charBufferAllocate = CharBuffer.allocate((int) (byteBuffer.remaining() * decoder.maxCharsPerByte()));
        try {
            CoderResult coderResultDecode = decoder.decode(byteBuffer, charBufferAllocate, true);
            if (!coderResultDecode.isUnderflow()) {
                coderResultDecode.throwException();
            }
            CoderResult coderResultFlush = decoder.flush(charBufferAllocate);
            if (!coderResultFlush.isUnderflow()) {
                coderResultFlush.throwException();
            }
            return charBufferAllocate.flip().toString();
        } catch (CharacterCodingException e) {
            throw new IllegalStateException(e);
        }
    }

    private ChannelBuffers() {
    }
}
