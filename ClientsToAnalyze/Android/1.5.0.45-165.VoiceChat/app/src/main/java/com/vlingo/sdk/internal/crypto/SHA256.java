package com.vlingo.sdk.internal.crypto;

import com.nuance.nmsp.client.sdk.common.protocols.ProtocolDefines;

/* loaded from: classes.dex */
public class SHA256 implements HashFunction {
    private static final int BLOCK_SIZE = 64;
    private static final int HASH_SIZE = 32;
    private static final char[] HEX_CHARS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    /* renamed from: K */
    private static final int[] f3250K = {1116352408, 1899447441, -1245643825, -373957723, 961987163, 1508970993, -1841331548, -1424204075, -670586216, 310598401, 607225278, 1426881987, 1925078388, -2132889090, -1680079193, -1046744716, -459576895, -272742522, 264347078, 604807628, 770255983, 1249150122, 1555081692, 1996064986, -1740746414, -1473132947, -1341970488, -1084653625, -958395405, -710438585, 113926993, 338241895, 666307205, 773529912, 1294757372, 1396182291, 1695183700, 1986661051, -2117940946, -1838011259, -1564481375, -1474664885, -1035236496, -949202525, -778901479, -694614492, -200395387, 275423344, 430227734, 506948616, 659060556, 883997877, 958139571, 1322822218, 1537002063, 1747873779, 1955562222, 2024104815, -2067236844, -1933114872, -1866530822, -1538233109, -1090935817, -965641998};
    private int bufOff;
    private long byteCount;
    private final int[] context = new int[8];
    private final int[] buffer = new int[64];
    private final byte[] buf = new byte[64];

    public SHA256() {
        coreReset();
    }

    protected void coreDigest(byte[] buf, int off) {
        for (int i = 0; i < this.context.length; i++) {
            for (int j = 0; j < 4; j++) {
                buf[(i * 4) + (3 - j) + off] = (byte) (this.context[i] >>> (j * 8));
            }
        }
    }

    protected void coreReset() {
        this.bufOff = 0;
        this.byteCount = 0L;
        this.context[0] = 1779033703;
        this.context[1] = -1150833019;
        this.context[2] = 1013904242;
        this.context[3] = -1521486534;
        this.context[4] = 1359893119;
        this.context[5] = -1694144372;
        this.context[6] = 528734635;
        this.context[7] = 1541459225;
    }

    protected void coreUpdate(byte[] block, int offset) {
        int[] W = this.buffer;
        int offset2 = offset;
        for (int i = 0; i < 16; i++) {
            int offset3 = offset2 + 1;
            int i2 = block[offset2] << 24;
            int offset4 = offset3 + 1;
            int i3 = i2 | ((block[offset3] & 255) << 16);
            int offset5 = offset4 + 1;
            int i4 = i3 | ((block[offset4] & 255) << 8);
            offset2 = offset5 + 1;
            W[i] = i4 | (block[offset5] & 255);
        }
        for (int i5 = 16; i5 < 64; i5++) {
            W[i5] = sig1(W[i5 - 2]) + W[i5 - 7] + sig0(W[i5 - 15]) + W[i5 - 16];
        }
        int a = this.context[0];
        int b = this.context[1];
        int c = this.context[2];
        int d = this.context[3];
        int e = this.context[4];
        int f = this.context[5];
        int g = this.context[6];
        int h = this.context[7];
        for (int i6 = 0; i6 < 64; i6++) {
            int T1 = Sig1(e) + h + m3092Ch(e, f, g) + f3250K[i6] + W[i6];
            int T2 = Sig0(a) + Maj(a, b, c);
            h = g;
            g = f;
            f = e;
            e = d + T1;
            d = c;
            c = b;
            b = a;
            a = T1 + T2;
        }
        int[] iArr = this.context;
        iArr[0] = iArr[0] + a;
        int[] iArr2 = this.context;
        iArr2[1] = iArr2[1] + b;
        int[] iArr3 = this.context;
        iArr3[2] = iArr3[2] + c;
        int[] iArr4 = this.context;
        iArr4[3] = iArr4[3] + d;
        int[] iArr5 = this.context;
        iArr5[4] = iArr5[4] + e;
        int[] iArr6 = this.context;
        iArr6[5] = iArr6[5] + f;
        int[] iArr7 = this.context;
        iArr7[6] = iArr7[6] + g;
        int[] iArr8 = this.context;
        iArr8[7] = iArr8[7] + h;
    }

    /* renamed from: Ch */
    private final int m3092Ch(int x, int y, int z) {
        return (x & y) ^ ((x ^ (-1)) & z);
    }

    private final int Maj(int x, int y, int z) {
        return ((x & y) ^ (x & z)) ^ (y & z);
    }

    private final int Sig0(int x) {
        return (m3094S(2, x) ^ m3094S(13, x)) ^ m3094S(22, x);
    }

    private final int Sig1(int x) {
        return (m3094S(6, x) ^ m3094S(11, x)) ^ m3094S(25, x);
    }

    private final int sig0(int x) {
        return (m3094S(7, x) ^ m3094S(18, x)) ^ m3093R(3, x);
    }

    private final int sig1(int x) {
        return (m3094S(17, x) ^ m3094S(19, x)) ^ m3093R(10, x);
    }

    /* renamed from: R */
    private final int m3093R(int off, int x) {
        return x >>> off;
    }

    /* renamed from: S */
    private final int m3094S(int off, int x) {
        return (x >>> off) | (x << (32 - off));
    }

    private int privateDigest(byte[] buf, int offset, int len, boolean reset) {
        byte[] bArr = this.buf;
        int i = this.bufOff;
        this.bufOff = i + 1;
        bArr[i] = -128;
        int C = 64 - 8;
        if (this.bufOff > C) {
            while (this.bufOff < 64) {
                byte[] bArr2 = this.buf;
                int i2 = this.bufOff;
                this.bufOff = i2 + 1;
                bArr2[i2] = 0;
            }
            coreUpdate(this.buf, 0);
            this.bufOff = 0;
        }
        while (this.bufOff < C) {
            byte[] bArr3 = this.buf;
            int i3 = this.bufOff;
            this.bufOff = i3 + 1;
            bArr3[i3] = 0;
        }
        long bitCount = this.byteCount * 8;
        for (int i4 = 56; i4 >= 0; i4 -= 8) {
            byte[] bArr4 = this.buf;
            int i5 = this.bufOff;
            this.bufOff = i5 + 1;
            bArr4[i5] = (byte) (bitCount >>> i4);
        }
        coreUpdate(this.buf, 0);
        coreDigest(buf, offset);
        if (reset) {
            coreReset();
            return 32;
        }
        return 32;
    }

    public void extract(int[] digest, int offset) {
        for (int i = 0; i < this.context.length; i++) {
            digest[i + offset] = this.context[i];
        }
    }

    public void update(byte b) {
        this.byteCount++;
        byte[] bArr = this.buf;
        int i = this.bufOff;
        this.bufOff = i + 1;
        bArr[i] = b;
        if (this.bufOff == 64) {
            coreUpdate(this.buf, 0);
            this.bufOff = 0;
        }
    }

    public void update(byte[] input, int offset, int length) {
        this.byteCount += length;
        while (true) {
            int todo = 64 - this.bufOff;
            if (length >= todo) {
                System.arraycopy(input, offset, this.buf, this.bufOff, todo);
                coreUpdate(this.buf, 0);
                length -= todo;
                offset += todo;
                this.bufOff = 0;
            } else {
                System.arraycopy(input, offset, this.buf, this.bufOff, length);
                this.bufOff += length;
                return;
            }
        }
    }

    public void update(byte[] data) {
        update(data, 0, data.length);
    }

    public byte[] digest() {
        byte[] tmp = new byte[32];
        privateDigest(tmp, 0, 32, true);
        return tmp;
    }

    public void digest(boolean reset, byte[] buffer, int offset) {
        privateDigest(this.buf, offset, buffer.length, true);
    }

    public final int digestSize() {
        return 256;
    }

    @Override // com.vlingo.sdk.internal.crypto.HashFunction
    public String hash(String s) {
        coreReset();
        for (int i = 0; i < s.length(); i++) {
            update((byte) s.charAt(i));
        }
        byte[] d = digest();
        return toHex(d);
    }

    public static final String toHex(byte[] hash) {
        char[] buf = new char[hash.length * 2];
        int x = 0;
        for (int i = 0; i < hash.length; i++) {
            int x2 = x + 1;
            buf[x] = HEX_CHARS[(hash[i] >>> 4) & 15];
            x = x2 + 1;
            buf[x2] = HEX_CHARS[hash[i] & ProtocolDefines.XMODE_PROTOCOL_BB_HANDSHAKE];
        }
        return new String(buf);
    }
}
