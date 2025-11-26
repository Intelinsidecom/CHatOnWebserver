package org.jboss.netty.buffer;

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
    private static final char[] HEXDUMP_TABLE = new char[1024];

    static {
        char[] charArray = "0123456789abcdef".toCharArray();
        for (int i = 0; i < 256; i++) {
            HEXDUMP_TABLE[(i << 1) + 0] = charArray[(i >>> 4) & 15];
            HEXDUMP_TABLE[(i << 1) + 1] = charArray[(i >>> 0) & 15];
        }
    }

    private ChannelBuffers() {
    }

    public static ChannelBuffer buffer(int i) {
        return buffer(BIG_ENDIAN, i);
    }

    public static ChannelBuffer buffer(ByteOrder byteOrder, int i) {
        if (byteOrder == BIG_ENDIAN) {
            return i == 0 ? EMPTY_BUFFER : new BigEndianHeapChannelBuffer(i);
        }
        if (byteOrder == LITTLE_ENDIAN) {
            return i == 0 ? EMPTY_BUFFER : new LittleEndianHeapChannelBuffer(i);
        }
        throw new NullPointerException("endianness");
    }

    public static int compare(ChannelBuffer channelBuffer, ChannelBuffer channelBuffer2) {
        int i;
        int i2;
        int i3 = channelBuffer.readableBytes();
        int i4 = channelBuffer2.readableBytes();
        int iMin = Math.min(i3, i4);
        int i5 = iMin >>> 2;
        int i6 = channelBuffer.readerIndex();
        int i7 = channelBuffer2.readerIndex();
        if (channelBuffer.order() == channelBuffer2.order()) {
            int i8 = i6;
            int i9 = i7;
            while (i5 > 0) {
                long unsignedInt = channelBuffer.getUnsignedInt(i8);
                long unsignedInt2 = channelBuffer2.getUnsignedInt(i9);
                if (unsignedInt > unsignedInt2) {
                    return 1;
                }
                if (unsignedInt < unsignedInt2) {
                    return -1;
                }
                i8 += 4;
                i9 += 4;
                i5--;
            }
            i = i9;
            i2 = i8;
        } else {
            int i10 = i6;
            int i11 = i7;
            while (i5 > 0) {
                long unsignedInt3 = channelBuffer.getUnsignedInt(i10);
                long jSwapInt = swapInt(channelBuffer2.getInt(i11)) & 4294967295L;
                if (unsignedInt3 > jSwapInt) {
                    return 1;
                }
                if (unsignedInt3 < jSwapInt) {
                    return -1;
                }
                i10 += 4;
                i11 += 4;
                i5--;
            }
            i = i11;
            i2 = i10;
        }
        for (int i12 = iMin & 3; i12 > 0; i12--) {
            byte b = channelBuffer.getByte(i2);
            byte b2 = channelBuffer2.getByte(i);
            if (b > b2) {
                return 1;
            }
            if (b < b2) {
                return -1;
            }
            i2++;
            i++;
        }
        return i3 - i4;
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

    public static ChannelBuffer copiedBuffer(CharSequence charSequence, int i, int i2, Charset charset) {
        return copiedBuffer(BIG_ENDIAN, charSequence, i, i2, charset);
    }

    public static ChannelBuffer copiedBuffer(CharSequence charSequence, Charset charset) {
        return copiedBuffer(BIG_ENDIAN, charSequence, charset);
    }

    @Deprecated
    public static ChannelBuffer copiedBuffer(String str, String str2) {
        return copiedBuffer(str, Charset.forName(str2));
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

    public static ChannelBuffer copiedBuffer(ByteOrder byteOrder, CharSequence charSequence, int i, int i2, Charset charset) {
        if (charSequence == null) {
            throw new NullPointerException("string");
        }
        if (i2 == 0) {
            return EMPTY_BUFFER;
        }
        if (!(charSequence instanceof CharBuffer)) {
            return copiedBuffer(byteOrder, CharBuffer.wrap(charSequence, i, i + i2), charset);
        }
        CharBuffer charBuffer = (CharBuffer) charSequence;
        if (charBuffer.hasArray()) {
            return copiedBuffer(byteOrder, charBuffer.array(), charBuffer.arrayOffset() + charBuffer.position() + i, i2, charset);
        }
        CharBuffer charBufferSlice = charBuffer.slice();
        charBufferSlice.limit(i2);
        charBufferSlice.position(i);
        return copiedBuffer(byteOrder, charBufferSlice, charset);
    }

    public static ChannelBuffer copiedBuffer(ByteOrder byteOrder, CharSequence charSequence, Charset charset) {
        if (charSequence == null) {
            throw new NullPointerException("string");
        }
        return charSequence instanceof CharBuffer ? copiedBuffer(byteOrder, (CharBuffer) charSequence, charset) : copiedBuffer(byteOrder, CharBuffer.wrap(charSequence), charset);
    }

    @Deprecated
    public static ChannelBuffer copiedBuffer(ByteOrder byteOrder, String str, String str2) {
        return copiedBuffer(byteOrder, str, Charset.forName(str2));
    }

    private static ChannelBuffer copiedBuffer(ByteOrder byteOrder, CharBuffer charBuffer, Charset charset) throws CharacterCodingException {
        ByteBuffer byteBufferEncodeString = encodeString(charBuffer, charset);
        ChannelBuffer channelBufferWrappedBuffer = wrappedBuffer(byteOrder, byteBufferEncodeString.array());
        channelBufferWrappedBuffer.writerIndex(byteBufferEncodeString.remaining());
        return channelBufferWrappedBuffer;
    }

    public static ChannelBuffer copiedBuffer(ByteOrder byteOrder, byte[] bArr) {
        if (byteOrder == BIG_ENDIAN) {
            return bArr.length == 0 ? EMPTY_BUFFER : new BigEndianHeapChannelBuffer((byte[]) bArr.clone());
        }
        if (byteOrder == LITTLE_ENDIAN) {
            return bArr.length == 0 ? EMPTY_BUFFER : new LittleEndianHeapChannelBuffer((byte[]) bArr.clone());
        }
        throw new NullPointerException("endianness");
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

    public static ChannelBuffer copiedBuffer(ByteOrder byteOrder, char[] cArr, int i, int i2, Charset charset) {
        if (cArr == null) {
            throw new NullPointerException("array");
        }
        return i2 == 0 ? EMPTY_BUFFER : copiedBuffer(byteOrder, CharBuffer.wrap(cArr, i, i2), charset);
    }

    public static ChannelBuffer copiedBuffer(ByteOrder byteOrder, char[] cArr, Charset charset) {
        return copiedBuffer(byteOrder, cArr, 0, cArr.length, charset);
    }

    public static ChannelBuffer copiedBuffer(ByteOrder byteOrder, byte[]... bArr) {
        switch (bArr.length) {
            case 0:
                return EMPTY_BUFFER;
            case 1:
                return bArr[0].length == 0 ? EMPTY_BUFFER : copiedBuffer(byteOrder, bArr[0]);
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

    public static ChannelBuffer copiedBuffer(ChannelBuffer channelBuffer) {
        return channelBuffer.readable() ? channelBuffer.copy() : EMPTY_BUFFER;
    }

    public static ChannelBuffer copiedBuffer(byte[] bArr) {
        return copiedBuffer(BIG_ENDIAN, bArr);
    }

    public static ChannelBuffer copiedBuffer(byte[] bArr, int i, int i2) {
        return copiedBuffer(BIG_ENDIAN, bArr, i, i2);
    }

    public static ChannelBuffer copiedBuffer(char[] cArr, int i, int i2, Charset charset) {
        return copiedBuffer(BIG_ENDIAN, cArr, i, i2, charset);
    }

    public static ChannelBuffer copiedBuffer(char[] cArr, Charset charset) {
        return copiedBuffer(BIG_ENDIAN, cArr, 0, cArr.length, charset);
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

    public static ChannelBuffer copiedBuffer(byte[]... bArr) {
        return copiedBuffer(BIG_ENDIAN, bArr);
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
        return dynamicBuffer(BIG_ENDIAN, 256);
    }

    public static ChannelBuffer dynamicBuffer(int i) {
        return dynamicBuffer(BIG_ENDIAN, i);
    }

    public static ChannelBuffer dynamicBuffer(int i, ChannelBufferFactory channelBufferFactory) {
        if (channelBufferFactory == null) {
            throw new NullPointerException("factory");
        }
        return new DynamicChannelBuffer(channelBufferFactory.getDefaultOrder(), i, channelBufferFactory);
    }

    public static ChannelBuffer dynamicBuffer(ByteOrder byteOrder, int i) {
        return new DynamicChannelBuffer(byteOrder, i);
    }

    public static ChannelBuffer dynamicBuffer(ByteOrder byteOrder, int i, ChannelBufferFactory channelBufferFactory) {
        return new DynamicChannelBuffer(byteOrder, i, channelBufferFactory);
    }

    public static ChannelBuffer dynamicBuffer(ChannelBufferFactory channelBufferFactory) {
        if (channelBufferFactory == null) {
            throw new NullPointerException("factory");
        }
        return new DynamicChannelBuffer(channelBufferFactory.getDefaultOrder(), 256, channelBufferFactory);
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

    public static boolean equals(ChannelBuffer channelBuffer, ChannelBuffer channelBuffer2) {
        int i;
        int i2;
        int i3 = channelBuffer.readableBytes();
        if (i3 != channelBuffer2.readableBytes()) {
            return false;
        }
        int i4 = i3 >>> 3;
        int i5 = channelBuffer.readerIndex();
        int i6 = channelBuffer2.readerIndex();
        if (channelBuffer.order() == channelBuffer2.order()) {
            int i7 = i5;
            int i8 = i6;
            while (i4 > 0) {
                if (channelBuffer.getLong(i7) != channelBuffer2.getLong(i8)) {
                    return false;
                }
                i7 += 8;
                i8 += 8;
                i4--;
            }
            i = i8;
            i2 = i7;
        } else {
            int i9 = i5;
            int i10 = i6;
            while (i4 > 0) {
                if (channelBuffer.getLong(i9) != swapLong(channelBuffer2.getLong(i10))) {
                    return false;
                }
                i9 += 8;
                i10 += 8;
                i4--;
            }
            i = i10;
            i2 = i9;
        }
        for (int i11 = i3 & 7; i11 > 0; i11--) {
            if (channelBuffer.getByte(i2) != channelBuffer2.getByte(i)) {
                return false;
            }
            i2++;
            i++;
        }
        return true;
    }

    private static int firstIndexOf(ChannelBuffer channelBuffer, int i, int i2, byte b) {
        int iMax = Math.max(i, 0);
        if (iMax >= i2 || channelBuffer.capacity() == 0) {
            return -1;
        }
        while (iMax < i2) {
            if (channelBuffer.getByte(iMax) == b) {
                return iMax;
            }
            iMax++;
        }
        return -1;
    }

    private static int firstIndexOf(ChannelBuffer channelBuffer, int i, int i2, ChannelBufferIndexFinder channelBufferIndexFinder) {
        int iMax = Math.max(i, 0);
        if (iMax >= i2 || channelBuffer.capacity() == 0) {
            return -1;
        }
        while (iMax < i2) {
            if (channelBufferIndexFinder.find(channelBuffer, iMax)) {
                return iMax;
            }
            iMax++;
        }
        return -1;
    }

    public static int hashCode(ChannelBuffer channelBuffer) {
        int i;
        int i2;
        int i3 = channelBuffer.readableBytes();
        int i4 = i3 >>> 2;
        int i5 = i3 & 3;
        int i6 = channelBuffer.readerIndex();
        if (channelBuffer.order() == BIG_ENDIAN) {
            int i7 = 1;
            while (i4 > 0) {
                i7 = (i7 * 31) + channelBuffer.getInt(i6);
                i6 += 4;
                i4--;
            }
            i = i6;
            i2 = i7;
        } else {
            int iSwapInt = 1;
            while (i4 > 0) {
                iSwapInt = (iSwapInt * 31) + swapInt(channelBuffer.getInt(i6));
                i6 += 4;
                i4--;
            }
            i = i6;
            i2 = iSwapInt;
        }
        while (i5 > 0) {
            i5--;
            i2 = channelBuffer.getByte(i) + (i2 * 31);
            i++;
        }
        if (i2 == 0) {
            return 1;
        }
        return i2;
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
        int i5 = i;
        while (i5 < i3) {
            System.arraycopy(HEXDUMP_TABLE, channelBuffer.getUnsignedByte(i5) << 1, cArr, i4, 2);
            i5++;
            i4 += 2;
        }
        return new String(cArr);
    }

    public static int indexOf(ChannelBuffer channelBuffer, int i, int i2, byte b) {
        return i <= i2 ? firstIndexOf(channelBuffer, i, i2, b) : lastIndexOf(channelBuffer, i, i2, b);
    }

    public static int indexOf(ChannelBuffer channelBuffer, int i, int i2, ChannelBufferIndexFinder channelBufferIndexFinder) {
        return i <= i2 ? firstIndexOf(channelBuffer, i, i2, channelBufferIndexFinder) : lastIndexOf(channelBuffer, i, i2, channelBufferIndexFinder);
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

    public static int swapInt(int i) {
        return (swapShort((short) i) << 16) | (swapShort((short) (i >>> 16)) & 65535);
    }

    public static long swapLong(long j) {
        return (swapInt((int) j) << 32) | (swapInt((int) (j >>> 32)) & 4294967295L);
    }

    public static int swapMedium(int i) {
        return ((i << 16) & 16711680) | (65280 & i) | ((i >>> 16) & 255);
    }

    public static short swapShort(short s) {
        return (short) ((s << 8) | ((s >>> 8) & 255));
    }

    public static ChannelBuffer unmodifiableBuffer(ChannelBuffer channelBuffer) {
        return new ReadOnlyChannelBuffer(channelBuffer instanceof ReadOnlyChannelBuffer ? ((ReadOnlyChannelBuffer) channelBuffer).unwrap() : channelBuffer);
    }

    public static ChannelBuffer wrappedBuffer(ByteBuffer byteBuffer) {
        return !byteBuffer.hasRemaining() ? EMPTY_BUFFER : byteBuffer.hasArray() ? wrappedBuffer(byteBuffer.order(), byteBuffer.array(), byteBuffer.arrayOffset() + byteBuffer.position(), byteBuffer.remaining()) : new ByteBufferBackedChannelBuffer(byteBuffer);
    }

    public static ChannelBuffer wrappedBuffer(ByteOrder byteOrder, byte[] bArr) {
        if (byteOrder == BIG_ENDIAN) {
            return bArr.length == 0 ? EMPTY_BUFFER : new BigEndianHeapChannelBuffer(bArr);
        }
        if (byteOrder == LITTLE_ENDIAN) {
            return bArr.length == 0 ? EMPTY_BUFFER : new LittleEndianHeapChannelBuffer(bArr);
        }
        throw new NullPointerException("endianness");
    }

    public static ChannelBuffer wrappedBuffer(ByteOrder byteOrder, byte[] bArr, int i, int i2) {
        if (byteOrder == null) {
            throw new NullPointerException("endianness");
        }
        return i == 0 ? i2 == bArr.length ? wrappedBuffer(byteOrder, bArr) : i2 == 0 ? EMPTY_BUFFER : new TruncatedChannelBuffer(wrappedBuffer(byteOrder, bArr), i2) : i2 == 0 ? EMPTY_BUFFER : new SlicedChannelBuffer(wrappedBuffer(byteOrder, bArr), i, i2);
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
                    if (bArr2 == null) {
                        return compositeBuffer(byteOrder, arrayList);
                    }
                    if (bArr2.length > 0) {
                        arrayList.add(wrappedBuffer(byteOrder, bArr2));
                    }
                }
                return compositeBuffer(byteOrder, arrayList);
        }
        return EMPTY_BUFFER;
    }

    public static ChannelBuffer wrappedBuffer(ChannelBuffer channelBuffer) {
        return channelBuffer.readable() ? channelBuffer.slice() : EMPTY_BUFFER;
    }

    public static ChannelBuffer wrappedBuffer(byte[] bArr) {
        return wrappedBuffer(BIG_ENDIAN, bArr);
    }

    public static ChannelBuffer wrappedBuffer(byte[] bArr, int i, int i2) {
        return wrappedBuffer(BIG_ENDIAN, bArr, i, i2);
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
                    if (byteBuffer == null) {
                        return compositeBuffer(byteOrderOrder, arrayList);
                    }
                    if (byteBuffer.hasRemaining()) {
                        if (byteOrderOrder == null) {
                            byteOrderOrder = byteBuffer.order();
                        } else if (!byteOrderOrder.equals(byteBuffer.order())) {
                            throw new IllegalArgumentException("inconsistent byte order");
                        }
                        arrayList.add(wrappedBuffer(byteBuffer));
                    }
                }
                return compositeBuffer(byteOrderOrder, arrayList);
        }
        return EMPTY_BUFFER;
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
                ByteOrder byteOrder = null;
                ArrayList arrayList = new ArrayList(channelBufferArr.length);
                for (ChannelBuffer channelBuffer : channelBufferArr) {
                    if (channelBuffer == null) {
                        return compositeBuffer(byteOrder, arrayList);
                    }
                    if (channelBuffer.readable()) {
                        if (byteOrder == null) {
                            byteOrderOrder = channelBuffer.order();
                        } else {
                            if (!byteOrder.equals(channelBuffer.order())) {
                                throw new IllegalArgumentException("inconsistent byte order");
                            }
                            byteOrderOrder = byteOrder;
                        }
                        if (channelBuffer instanceof CompositeChannelBuffer) {
                            arrayList.addAll(((CompositeChannelBuffer) channelBuffer).decompose(channelBuffer.readerIndex(), channelBuffer.readableBytes()));
                            byteOrder = byteOrderOrder;
                        } else {
                            arrayList.add(channelBuffer.slice());
                            byteOrder = byteOrderOrder;
                        }
                    }
                }
                return compositeBuffer(byteOrder, arrayList);
        }
        return EMPTY_BUFFER;
    }

    public static ChannelBuffer wrappedBuffer(byte[]... bArr) {
        return wrappedBuffer(BIG_ENDIAN, bArr);
    }
}
