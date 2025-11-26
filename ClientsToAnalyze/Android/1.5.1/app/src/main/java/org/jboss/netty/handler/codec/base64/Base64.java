package org.jboss.netty.handler.codec.base64;

import com.sec.amsoma.AMSLibs;
import org.jboss.netty.buffer.ChannelBuffer;
import org.jboss.netty.buffer.ChannelBufferFactory;
import org.jboss.netty.buffer.HeapChannelBufferFactory;

/* loaded from: classes.dex */
public class Base64 {
    private static final byte EQUALS_SIGN = 61;
    private static final byte EQUALS_SIGN_ENC = -1;
    private static final int MAX_LINE_LENGTH = 76;
    private static final byte NEW_LINE = 10;
    private static final byte WHITE_SPACE_ENC = -5;

    private Base64() {
    }

    private static final byte[] alphabet(Base64Dialect base64Dialect) {
        if (base64Dialect == null) {
            throw new NullPointerException("dialect");
        }
        return base64Dialect.alphabet;
    }

    private static final boolean breakLines(Base64Dialect base64Dialect) {
        if (base64Dialect == null) {
            throw new NullPointerException("dialect");
        }
        return base64Dialect.breakLinesByDefault;
    }

    private static final byte[] decodabet(Base64Dialect base64Dialect) {
        if (base64Dialect == null) {
            throw new NullPointerException("dialect");
        }
        return base64Dialect.decodabet;
    }

    public static ChannelBuffer decode(ChannelBuffer channelBuffer) {
        return decode(channelBuffer, Base64Dialect.STANDARD);
    }

    public static ChannelBuffer decode(ChannelBuffer channelBuffer, int i, int i2) {
        return decode(channelBuffer, i, i2, Base64Dialect.STANDARD);
    }

    public static ChannelBuffer decode(ChannelBuffer channelBuffer, int i, int i2, ChannelBufferFactory channelBufferFactory) {
        return decode(channelBuffer, i, i2, Base64Dialect.STANDARD, channelBufferFactory);
    }

    public static ChannelBuffer decode(ChannelBuffer channelBuffer, int i, int i2, Base64Dialect base64Dialect) {
        return decode(channelBuffer, i, i2, base64Dialect, HeapChannelBufferFactory.getInstance());
    }

    public static ChannelBuffer decode(ChannelBuffer channelBuffer, int i, int i2, Base64Dialect base64Dialect, ChannelBufferFactory channelBufferFactory) {
        int i3;
        if (channelBuffer == null) {
            throw new NullPointerException("src");
        }
        if (base64Dialect == null) {
            throw new NullPointerException("dialect");
        }
        if (channelBufferFactory == null) {
            throw new NullPointerException("bufferFactory");
        }
        byte[] bArrDecodabet = decodabet(base64Dialect);
        ChannelBuffer buffer = channelBufferFactory.getBuffer(channelBuffer.order(), (i2 * 3) / 4);
        byte[] bArr = new byte[4];
        int i4 = i;
        int i5 = 0;
        int i6 = 0;
        while (true) {
            if (i4 >= i + i2) {
                i3 = i6;
                break;
            }
            byte b = (byte) (channelBuffer.getByte(i4) & 127);
            byte b2 = bArrDecodabet[b];
            if (b2 < -5) {
                throw new IllegalArgumentException("bad Base64 input character at " + i4 + ": " + ((int) channelBuffer.getUnsignedByte(i4)) + " (decimal)");
            }
            if (b2 >= -1) {
                int i7 = i5 + 1;
                bArr[i5] = b;
                if (i7 > 3) {
                    int iDecode4to3 = decode4to3(bArr, 0, buffer, i6, base64Dialect) + i6;
                    if (b == 61) {
                        i3 = iDecode4to3;
                        break;
                    }
                    i6 = iDecode4to3;
                    i5 = 0;
                } else {
                    i5 = i7;
                }
            }
            i4++;
        }
        return buffer.slice(0, i3);
    }

    public static ChannelBuffer decode(ChannelBuffer channelBuffer, ChannelBufferFactory channelBufferFactory) {
        return decode(channelBuffer, Base64Dialect.STANDARD, channelBufferFactory);
    }

    public static ChannelBuffer decode(ChannelBuffer channelBuffer, Base64Dialect base64Dialect) {
        return decode(channelBuffer, base64Dialect, HeapChannelBufferFactory.getInstance());
    }

    public static ChannelBuffer decode(ChannelBuffer channelBuffer, Base64Dialect base64Dialect, ChannelBufferFactory channelBufferFactory) {
        if (channelBuffer == null) {
            throw new NullPointerException("src");
        }
        ChannelBuffer channelBufferDecode = decode(channelBuffer, channelBuffer.readerIndex(), channelBuffer.readableBytes(), base64Dialect, channelBufferFactory);
        channelBuffer.readerIndex(channelBuffer.writerIndex());
        return channelBufferDecode;
    }

    private static int decode4to3(byte[] bArr, int i, ChannelBuffer channelBuffer, int i2, Base64Dialect base64Dialect) {
        byte[] bArrDecodabet = decodabet(base64Dialect);
        if (bArr[i + 2] == 61) {
            channelBuffer.setByte(i2, (byte) ((((bArrDecodabet[bArr[i + 1]] & EQUALS_SIGN_ENC) << 12) | ((bArrDecodabet[bArr[i]] & EQUALS_SIGN_ENC) << 18)) >>> 16));
            return 1;
        }
        if (bArr[i + 3] == 61) {
            int i3 = ((bArrDecodabet[bArr[i + 2]] & EQUALS_SIGN_ENC) << 6) | ((bArrDecodabet[bArr[i]] & EQUALS_SIGN_ENC) << 18) | ((bArrDecodabet[bArr[i + 1]] & EQUALS_SIGN_ENC) << 12);
            channelBuffer.setByte(i2, (byte) (i3 >>> 16));
            channelBuffer.setByte(i2 + 1, (byte) (i3 >>> 8));
            return 2;
        }
        try {
            int i4 = (bArrDecodabet[bArr[i + 3]] & EQUALS_SIGN_ENC) | ((bArrDecodabet[bArr[i]] & EQUALS_SIGN_ENC) << 18) | ((bArrDecodabet[bArr[i + 1]] & EQUALS_SIGN_ENC) << 12) | ((bArrDecodabet[bArr[i + 2]] & EQUALS_SIGN_ENC) << 6);
            channelBuffer.setByte(i2, (byte) (i4 >> 16));
            channelBuffer.setByte(i2 + 1, (byte) (i4 >> 8));
            channelBuffer.setByte(i2 + 2, (byte) i4);
            return 3;
        } catch (IndexOutOfBoundsException e) {
            throw new IllegalArgumentException("not encoded in Base64");
        }
    }

    public static ChannelBuffer encode(ChannelBuffer channelBuffer) {
        return encode(channelBuffer, Base64Dialect.STANDARD);
    }

    public static ChannelBuffer encode(ChannelBuffer channelBuffer, int i, int i2) {
        return encode(channelBuffer, i, i2, Base64Dialect.STANDARD);
    }

    public static ChannelBuffer encode(ChannelBuffer channelBuffer, int i, int i2, ChannelBufferFactory channelBufferFactory) {
        return encode(channelBuffer, i, i2, Base64Dialect.STANDARD, channelBufferFactory);
    }

    public static ChannelBuffer encode(ChannelBuffer channelBuffer, int i, int i2, Base64Dialect base64Dialect) {
        return encode(channelBuffer, i, i2, breakLines(base64Dialect), base64Dialect);
    }

    public static ChannelBuffer encode(ChannelBuffer channelBuffer, int i, int i2, Base64Dialect base64Dialect, ChannelBufferFactory channelBufferFactory) {
        return encode(channelBuffer, i, i2, breakLines(base64Dialect), base64Dialect, channelBufferFactory);
    }

    public static ChannelBuffer encode(ChannelBuffer channelBuffer, int i, int i2, boolean z) {
        return encode(channelBuffer, i, i2, z, Base64Dialect.STANDARD);
    }

    public static ChannelBuffer encode(ChannelBuffer channelBuffer, int i, int i2, boolean z, ChannelBufferFactory channelBufferFactory) {
        return encode(channelBuffer, i, i2, z, Base64Dialect.STANDARD, channelBufferFactory);
    }

    public static ChannelBuffer encode(ChannelBuffer channelBuffer, int i, int i2, boolean z, Base64Dialect base64Dialect) {
        return encode(channelBuffer, i, i2, z, base64Dialect, HeapChannelBufferFactory.getInstance());
    }

    public static ChannelBuffer encode(ChannelBuffer channelBuffer, int i, int i2, boolean z, Base64Dialect base64Dialect, ChannelBufferFactory channelBufferFactory) {
        int i3;
        int i4;
        if (channelBuffer == null) {
            throw new NullPointerException("src");
        }
        if (base64Dialect == null) {
            throw new NullPointerException("dialect");
        }
        if (channelBufferFactory == null) {
            throw new NullPointerException("bufferFactory");
        }
        int i5 = (i2 * 4) / 3;
        ChannelBuffer buffer = channelBufferFactory.getBuffer(channelBuffer.order(), (z ? i5 / MAX_LINE_LENGTH : 0) + (i2 % 3 > 0 ? 4 : 0) + i5);
        int i6 = i2 - 2;
        int i7 = 0;
        int i8 = 0;
        int i9 = 0;
        while (i9 < i6) {
            encode3to4(channelBuffer, i9 + i, 3, buffer, i8, base64Dialect);
            int i10 = i7 + 4;
            if (z && i10 == MAX_LINE_LENGTH) {
                buffer.setByte(i8 + 4, 10);
                i4 = i8 + 1;
                i10 = 0;
            } else {
                i4 = i8;
            }
            i7 = i10;
            i8 = i4 + 4;
            i9 += 3;
        }
        if (i9 < i2) {
            encode3to4(channelBuffer, i9 + i, i2 - i9, buffer, i8, base64Dialect);
            i3 = i8 + 4;
        } else {
            i3 = i8;
        }
        return buffer.slice(0, i3);
    }

    public static ChannelBuffer encode(ChannelBuffer channelBuffer, ChannelBufferFactory channelBufferFactory) {
        return encode(channelBuffer, Base64Dialect.STANDARD, channelBufferFactory);
    }

    public static ChannelBuffer encode(ChannelBuffer channelBuffer, Base64Dialect base64Dialect) {
        return encode(channelBuffer, breakLines(base64Dialect), base64Dialect);
    }

    public static ChannelBuffer encode(ChannelBuffer channelBuffer, Base64Dialect base64Dialect, ChannelBufferFactory channelBufferFactory) {
        return encode(channelBuffer, breakLines(base64Dialect), base64Dialect, channelBufferFactory);
    }

    public static ChannelBuffer encode(ChannelBuffer channelBuffer, boolean z) {
        return encode(channelBuffer, z, Base64Dialect.STANDARD);
    }

    public static ChannelBuffer encode(ChannelBuffer channelBuffer, boolean z, ChannelBufferFactory channelBufferFactory) {
        return encode(channelBuffer, z, Base64Dialect.STANDARD, channelBufferFactory);
    }

    public static ChannelBuffer encode(ChannelBuffer channelBuffer, boolean z, Base64Dialect base64Dialect) {
        return encode(channelBuffer, z, base64Dialect, HeapChannelBufferFactory.getInstance());
    }

    public static ChannelBuffer encode(ChannelBuffer channelBuffer, boolean z, Base64Dialect base64Dialect, ChannelBufferFactory channelBufferFactory) {
        if (channelBuffer == null) {
            throw new NullPointerException("src");
        }
        ChannelBuffer channelBufferEncode = encode(channelBuffer, channelBuffer.readerIndex(), channelBuffer.readableBytes(), z, base64Dialect, channelBufferFactory);
        channelBuffer.readerIndex(channelBuffer.writerIndex());
        return channelBufferEncode;
    }

    private static void encode3to4(ChannelBuffer channelBuffer, int i, int i2, ChannelBuffer channelBuffer2, int i3, Base64Dialect base64Dialect) {
        byte[] bArrAlphabet = alphabet(base64Dialect);
        int i4 = (i2 > 0 ? (channelBuffer.getByte(i) << AMSLibs.ENUM_VIP_AMS_ERROR_SAVE_FLASH) >>> 8 : 0) | (i2 > 1 ? (channelBuffer.getByte(i + 1) << AMSLibs.ENUM_VIP_AMS_ERROR_SAVE_FLASH) >>> 16 : 0) | (i2 > 2 ? (channelBuffer.getByte(i + 2) << AMSLibs.ENUM_VIP_AMS_ERROR_SAVE_FLASH) >>> 24 : 0);
        switch (i2) {
            case 1:
                channelBuffer2.setByte(i3, bArrAlphabet[i4 >>> 18]);
                channelBuffer2.setByte(i3 + 1, bArrAlphabet[(i4 >>> 12) & 63]);
                channelBuffer2.setByte(i3 + 2, 61);
                channelBuffer2.setByte(i3 + 3, 61);
                break;
            case 2:
                channelBuffer2.setByte(i3, bArrAlphabet[i4 >>> 18]);
                channelBuffer2.setByte(i3 + 1, bArrAlphabet[(i4 >>> 12) & 63]);
                channelBuffer2.setByte(i3 + 2, bArrAlphabet[(i4 >>> 6) & 63]);
                channelBuffer2.setByte(i3 + 3, 61);
                break;
            case 3:
                channelBuffer2.setByte(i3, bArrAlphabet[i4 >>> 18]);
                channelBuffer2.setByte(i3 + 1, bArrAlphabet[(i4 >>> 12) & 63]);
                channelBuffer2.setByte(i3 + 2, bArrAlphabet[(i4 >>> 6) & 63]);
                channelBuffer2.setByte(i3 + 3, bArrAlphabet[i4 & 63]);
                break;
        }
    }
}
