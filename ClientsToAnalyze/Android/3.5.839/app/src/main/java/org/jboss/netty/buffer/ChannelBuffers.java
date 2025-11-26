package org.jboss.netty.buffer;

import java.nio.ByteOrder;

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

    public static ChannelBuffer dynamicBuffer(ChannelBufferFactory channelBufferFactory) {
        if (channelBufferFactory == null) {
            throw new NullPointerException("factory");
        }
        return new DynamicChannelBuffer(channelBufferFactory.getDefaultOrder(), 256, channelBufferFactory);
    }

    public static ChannelBuffer dynamicBuffer(ByteOrder byteOrder, int i, ChannelBufferFactory channelBufferFactory) {
        return new DynamicChannelBuffer(byteOrder, i, channelBufferFactory);
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

    public static short swapShort(short s) {
        return (short) ((s << 8) | ((s >>> 8) & 255));
    }

    public static int swapInt(int i) {
        return (swapShort((short) i) << 16) | (swapShort((short) (i >>> 16)) & 65535);
    }

    public static long swapLong(long j) {
        return (swapInt((int) j) << 32) | (swapInt((int) (j >>> 32)) & 4294967295L);
    }
}
