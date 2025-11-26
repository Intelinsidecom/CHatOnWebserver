package com.vlingo.sdk.internal.crypto;

import com.nuance.nmsp.client.sdk.common.protocols.ProtocolDefines;
import com.vlingo.sdk.internal.util.StringUtils;

/* loaded from: classes.dex */
public class MD5 implements HashFunction {
    private static final char[] HEX_CHARS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    private static final byte[] padding;
    private MD5State finals;
    private MD5State state;

    static {
        byte[] bArr = new byte[64];
        bArr[0] = -128;
        padding = bArr;
    }

    private final void decode(byte[] buffer, int shift, int[] out) {
        out[0] = (buffer[shift] & 255) | ((buffer[shift + 1] & 255) << 8) | ((buffer[shift + 2] & 255) << 16) | (buffer[shift + 3] << 24);
        out[1] = (buffer[shift + 4] & 255) | ((buffer[shift + 5] & 255) << 8) | ((buffer[shift + 6] & 255) << 16) | (buffer[shift + 7] << 24);
        out[2] = (buffer[shift + 8] & 255) | ((buffer[shift + 9] & 255) << 8) | ((buffer[shift + 10] & 255) << 16) | (buffer[shift + 11] << 24);
        out[3] = (buffer[shift + 12] & 255) | ((buffer[shift + 13] & 255) << 8) | ((buffer[shift + 14] & 255) << 16) | (buffer[shift + 15] << 24);
        out[4] = (buffer[shift + 16] & 255) | ((buffer[shift + 17] & 255) << 8) | ((buffer[shift + 18] & 255) << 16) | (buffer[shift + 19] << 24);
        out[5] = (buffer[shift + 20] & 255) | ((buffer[shift + 21] & 255) << 8) | ((buffer[shift + 22] & 255) << 16) | (buffer[shift + 23] << 24);
        out[6] = (buffer[shift + 24] & 255) | ((buffer[shift + 25] & 255) << 8) | ((buffer[shift + 26] & 255) << 16) | (buffer[shift + 27] << 24);
        out[7] = (buffer[shift + 28] & 255) | ((buffer[shift + 29] & 255) << 8) | ((buffer[shift + 30] & 255) << 16) | (buffer[shift + 31] << 24);
        out[8] = (buffer[shift + 32] & 255) | ((buffer[shift + 33] & 255) << 8) | ((buffer[shift + 34] & 255) << 16) | (buffer[shift + 35] << 24);
        out[9] = (buffer[shift + 36] & 255) | ((buffer[shift + 37] & 255) << 8) | ((buffer[shift + 38] & 255) << 16) | (buffer[shift + 39] << 24);
        out[10] = (buffer[shift + 40] & 255) | ((buffer[shift + 41] & 255) << 8) | ((buffer[shift + 42] & 255) << 16) | (buffer[shift + 43] << 24);
        out[11] = (buffer[shift + 44] & 255) | ((buffer[shift + 45] & 255) << 8) | ((buffer[shift + 46] & 255) << 16) | (buffer[shift + 47] << 24);
        out[12] = (buffer[shift + 48] & 255) | ((buffer[shift + 49] & 255) << 8) | ((buffer[shift + 50] & 255) << 16) | (buffer[shift + 51] << 24);
        out[13] = (buffer[shift + 52] & 255) | ((buffer[shift + 53] & 255) << 8) | ((buffer[shift + 54] & 255) << 16) | (buffer[shift + 55] << 24);
        out[14] = (buffer[shift + 56] & 255) | ((buffer[shift + 57] & 255) << 8) | ((buffer[shift + 58] & 255) << 16) | (buffer[shift + 59] << 24);
        out[15] = (buffer[shift + 60] & 255) | ((buffer[shift + 61] & 255) << 8) | ((buffer[shift + 62] & 255) << 16) | (buffer[shift + 63] << 24);
    }

    private final void transform(MD5State state, byte[] buffer, int shift, int[] decode_buf) {
        int a = state.state[0];
        int b = state.state[1];
        int c = state.state[2];
        int d = state.state[3];
        decode(buffer, shift, decode_buf);
        int a2 = a + ((((b & c) | ((b ^ (-1)) & d)) + decode_buf[0]) - 680876936);
        int a3 = ((a2 << 7) | (a2 >>> 25)) + b;
        int d2 = d + ((((a3 & b) | ((a3 ^ (-1)) & c)) + decode_buf[1]) - 389564586);
        int d3 = ((d2 << 12) | (d2 >>> 20)) + a3;
        int c2 = c + ((d3 & a3) | ((d3 ^ (-1)) & b)) + decode_buf[2] + 606105819;
        int c3 = ((c2 << 17) | (c2 >>> 15)) + d3;
        int b2 = b + ((((c3 & d3) | ((c3 ^ (-1)) & a3)) + decode_buf[3]) - 1044525330);
        int b3 = ((b2 << 22) | (b2 >>> 10)) + c3;
        int a4 = a3 + ((((b3 & c3) | ((b3 ^ (-1)) & d3)) + decode_buf[4]) - 176418897);
        int a5 = ((a4 << 7) | (a4 >>> 25)) + b3;
        int d4 = d3 + ((a5 & b3) | ((a5 ^ (-1)) & c3)) + decode_buf[5] + 1200080426;
        int d5 = ((d4 << 12) | (d4 >>> 20)) + a5;
        int c4 = c3 + ((((d5 & a5) | ((d5 ^ (-1)) & b3)) + decode_buf[6]) - 1473231341);
        int c5 = ((c4 << 17) | (c4 >>> 15)) + d5;
        int b4 = b3 + ((((c5 & d5) | ((c5 ^ (-1)) & a5)) + decode_buf[7]) - 45705983);
        int b5 = ((b4 << 22) | (b4 >>> 10)) + c5;
        int a6 = a5 + ((b5 & c5) | ((b5 ^ (-1)) & d5)) + decode_buf[8] + 1770035416;
        int a7 = ((a6 << 7) | (a6 >>> 25)) + b5;
        int d6 = d5 + ((((a7 & b5) | ((a7 ^ (-1)) & c5)) + decode_buf[9]) - 1958414417);
        int d7 = ((d6 << 12) | (d6 >>> 20)) + a7;
        int c6 = c5 + ((((d7 & a7) | ((d7 ^ (-1)) & b5)) + decode_buf[10]) - 42063);
        int c7 = ((c6 << 17) | (c6 >>> 15)) + d7;
        int b6 = b5 + ((((c7 & d7) | ((c7 ^ (-1)) & a7)) + decode_buf[11]) - 1990404162);
        int b7 = ((b6 << 22) | (b6 >>> 10)) + c7;
        int a8 = a7 + ((b7 & c7) | ((b7 ^ (-1)) & d7)) + decode_buf[12] + 1804603682;
        int a9 = ((a8 << 7) | (a8 >>> 25)) + b7;
        int d8 = d7 + ((((a9 & b7) | ((a9 ^ (-1)) & c7)) + decode_buf[13]) - 40341101);
        int d9 = ((d8 << 12) | (d8 >>> 20)) + a9;
        int c8 = c7 + ((((d9 & a9) | ((d9 ^ (-1)) & b7)) + decode_buf[14]) - 1502002290);
        int c9 = ((c8 << 17) | (c8 >>> 15)) + d9;
        int b8 = b7 + ((c9 & d9) | ((c9 ^ (-1)) & a9)) + decode_buf[15] + 1236535329;
        int b9 = ((b8 << 22) | (b8 >>> 10)) + c9;
        int a10 = a9 + ((((b9 & d9) | ((d9 ^ (-1)) & c9)) + decode_buf[1]) - 165796510);
        int a11 = ((a10 << 5) | (a10 >>> 27)) + b9;
        int d10 = d9 + ((((a11 & c9) | ((c9 ^ (-1)) & b9)) + decode_buf[6]) - 1069501632);
        int d11 = ((d10 << 9) | (d10 >>> 23)) + a11;
        int c10 = c9 + ((d11 & b9) | ((b9 ^ (-1)) & a11)) + decode_buf[11] + 643717713;
        int c11 = ((c10 << 14) | (c10 >>> 18)) + d11;
        int b10 = b9 + ((((c11 & a11) | ((a11 ^ (-1)) & d11)) + decode_buf[0]) - 373897302);
        int b11 = ((b10 << 20) | (b10 >>> 12)) + c11;
        int a12 = a11 + ((((b11 & d11) | ((d11 ^ (-1)) & c11)) + decode_buf[5]) - 701558691);
        int a13 = ((a12 << 5) | (a12 >>> 27)) + b11;
        int d12 = d11 + ((a13 & c11) | ((c11 ^ (-1)) & b11)) + decode_buf[10] + 38016083;
        int d13 = ((d12 << 9) | (d12 >>> 23)) + a13;
        int c12 = c11 + ((((d13 & b11) | ((b11 ^ (-1)) & a13)) + decode_buf[15]) - 660478335);
        int c13 = ((c12 << 14) | (c12 >>> 18)) + d13;
        int b12 = b11 + ((((c13 & a13) | ((a13 ^ (-1)) & d13)) + decode_buf[4]) - 405537848);
        int b13 = ((b12 << 20) | (b12 >>> 12)) + c13;
        int a14 = a13 + ((b13 & d13) | ((d13 ^ (-1)) & c13)) + decode_buf[9] + 568446438;
        int a15 = ((a14 << 5) | (a14 >>> 27)) + b13;
        int d14 = d13 + ((((a15 & c13) | ((c13 ^ (-1)) & b13)) + decode_buf[14]) - 1019803690);
        int d15 = ((d14 << 9) | (d14 >>> 23)) + a15;
        int c14 = c13 + ((((d15 & b13) | ((b13 ^ (-1)) & a15)) + decode_buf[3]) - 187363961);
        int c15 = ((c14 << 14) | (c14 >>> 18)) + d15;
        int b14 = b13 + ((c15 & a15) | ((a15 ^ (-1)) & d15)) + decode_buf[8] + 1163531501;
        int b15 = ((b14 << 20) | (b14 >>> 12)) + c15;
        int a16 = a15 + ((((b15 & d15) | ((d15 ^ (-1)) & c15)) + decode_buf[13]) - 1444681467);
        int a17 = ((a16 << 5) | (a16 >>> 27)) + b15;
        int d16 = d15 + ((((a17 & c15) | ((c15 ^ (-1)) & b15)) + decode_buf[2]) - 51403784);
        int d17 = ((d16 << 9) | (d16 >>> 23)) + a17;
        int c16 = c15 + ((d17 & b15) | ((b15 ^ (-1)) & a17)) + decode_buf[7] + 1735328473;
        int c17 = ((c16 << 14) | (c16 >>> 18)) + d17;
        int b16 = b15 + ((((c17 & a17) | ((a17 ^ (-1)) & d17)) + decode_buf[12]) - 1926607734);
        int b17 = ((b16 << 20) | (b16 >>> 12)) + c17;
        int a18 = a17 + ((((b17 ^ c17) ^ d17) + decode_buf[5]) - 378558);
        int a19 = ((a18 << 4) | (a18 >>> 28)) + b17;
        int d18 = d17 + ((((a19 ^ b17) ^ c17) + decode_buf[8]) - 2022574463);
        int d19 = ((d18 << 11) | (d18 >>> 21)) + a19;
        int c18 = c17 + ((d19 ^ a19) ^ b17) + decode_buf[11] + 1839030562;
        int c19 = ((c18 << 16) | (c18 >>> 16)) + d19;
        int b18 = b17 + ((((c19 ^ d19) ^ a19) + decode_buf[14]) - 35309556);
        int b19 = ((b18 << 23) | (b18 >>> 9)) + c19;
        int a20 = a19 + ((((b19 ^ c19) ^ d19) + decode_buf[1]) - 1530992060);
        int a21 = ((a20 << 4) | (a20 >>> 28)) + b19;
        int d20 = d19 + ((a21 ^ b19) ^ c19) + decode_buf[4] + 1272893353;
        int d21 = ((d20 << 11) | (d20 >>> 21)) + a21;
        int c20 = c19 + ((((d21 ^ a21) ^ b19) + decode_buf[7]) - 155497632);
        int c21 = ((c20 << 16) | (c20 >>> 16)) + d21;
        int b20 = b19 + ((((c21 ^ d21) ^ a21) + decode_buf[10]) - 1094730640);
        int b21 = ((b20 << 23) | (b20 >>> 9)) + c21;
        int a22 = a21 + ((b21 ^ c21) ^ d21) + decode_buf[13] + 681279174;
        int a23 = ((a22 << 4) | (a22 >>> 28)) + b21;
        int d22 = d21 + ((((a23 ^ b21) ^ c21) + decode_buf[0]) - 358537222);
        int d23 = ((d22 << 11) | (d22 >>> 21)) + a23;
        int c22 = c21 + ((((d23 ^ a23) ^ b21) + decode_buf[3]) - 722521979);
        int c23 = ((c22 << 16) | (c22 >>> 16)) + d23;
        int b22 = b21 + ((c23 ^ d23) ^ a23) + decode_buf[6] + 76029189;
        int b23 = ((b22 << 23) | (b22 >>> 9)) + c23;
        int a24 = a23 + ((((b23 ^ c23) ^ d23) + decode_buf[9]) - 640364487);
        int a25 = ((a24 << 4) | (a24 >>> 28)) + b23;
        int d24 = d23 + ((((a25 ^ b23) ^ c23) + decode_buf[12]) - 421815835);
        int d25 = ((d24 << 11) | (d24 >>> 21)) + a25;
        int c24 = c23 + ((d25 ^ a25) ^ b23) + decode_buf[15] + 530742520;
        int c25 = ((c24 << 16) | (c24 >>> 16)) + d25;
        int b24 = b23 + ((((c25 ^ d25) ^ a25) + decode_buf[2]) - 995338651);
        int b25 = ((b24 << 23) | (b24 >>> 9)) + c25;
        int a26 = a25 + (((((d25 ^ (-1)) | b25) ^ c25) + decode_buf[0]) - 198630844);
        int a27 = ((a26 << 6) | (a26 >>> 26)) + b25;
        int d26 = d25 + (((c25 ^ (-1)) | a27) ^ b25) + decode_buf[7] + 1126891415;
        int d27 = ((d26 << 10) | (d26 >>> 22)) + a27;
        int c26 = c25 + (((((b25 ^ (-1)) | d27) ^ a27) + decode_buf[14]) - 1416354905);
        int c27 = ((c26 << 15) | (c26 >>> 17)) + d27;
        int b26 = b25 + (((((a27 ^ (-1)) | c27) ^ d27) + decode_buf[5]) - 57434055);
        int b27 = ((b26 << 21) | (b26 >>> 11)) + c27;
        int a28 = a27 + (((d27 ^ (-1)) | b27) ^ c27) + decode_buf[12] + 1700485571;
        int a29 = ((a28 << 6) | (a28 >>> 26)) + b27;
        int d28 = d27 + (((((c27 ^ (-1)) | a29) ^ b27) + decode_buf[3]) - 1894986606);
        int d29 = ((d28 << 10) | (d28 >>> 22)) + a29;
        int c28 = c27 + (((((b27 ^ (-1)) | d29) ^ a29) + decode_buf[10]) - 1051523);
        int c29 = ((c28 << 15) | (c28 >>> 17)) + d29;
        int b28 = b27 + (((((a29 ^ (-1)) | c29) ^ d29) + decode_buf[1]) - 2054922799);
        int b29 = ((b28 << 21) | (b28 >>> 11)) + c29;
        int a30 = a29 + (((d29 ^ (-1)) | b29) ^ c29) + decode_buf[8] + 1873313359;
        int a31 = ((a30 << 6) | (a30 >>> 26)) + b29;
        int d30 = d29 + (((((c29 ^ (-1)) | a31) ^ b29) + decode_buf[15]) - 30611744);
        int d31 = ((d30 << 10) | (d30 >>> 22)) + a31;
        int c30 = c29 + (((((b29 ^ (-1)) | d31) ^ a31) + decode_buf[6]) - 1560198380);
        int c31 = ((c30 << 15) | (c30 >>> 17)) + d31;
        int b30 = b29 + (((a31 ^ (-1)) | c31) ^ d31) + decode_buf[13] + 1309151649;
        int b31 = ((b30 << 21) | (b30 >>> 11)) + c31;
        int a32 = a31 + (((((d31 ^ (-1)) | b31) ^ c31) + decode_buf[4]) - 145523070);
        int a33 = ((a32 << 6) | (a32 >>> 26)) + b31;
        int d32 = d31 + (((((c31 ^ (-1)) | a33) ^ b31) + decode_buf[11]) - 1120210379);
        int d33 = ((d32 << 10) | (d32 >>> 22)) + a33;
        int c32 = c31 + (((b31 ^ (-1)) | d33) ^ a33) + decode_buf[2] + 718787259;
        int c33 = ((c32 << 15) | (c32 >>> 17)) + d33;
        int b32 = b31 + (((((a33 ^ (-1)) | c33) ^ d33) + decode_buf[9]) - 343485551);
        int[] iArr = state.state;
        iArr[0] = iArr[0] + a33;
        int[] iArr2 = state.state;
        iArr2[1] = iArr2[1] + ((b32 << 21) | (b32 >>> 11)) + c33;
        int[] iArr3 = state.state;
        iArr3[2] = iArr3[2] + c33;
        int[] iArr4 = state.state;
        iArr4[3] = iArr4[3] + d33;
    }

    private final void update(MD5State stat, byte[] buffer, int offset, int length) {
        int i;
        this.finals = null;
        if (length - offset > buffer.length) {
            length = buffer.length - offset;
        }
        int index = (int) (stat.count & 63);
        stat.count += length;
        int partlen = 64 - index;
        if (length >= partlen) {
            int[] decode_buf = new int[16];
            if (partlen == 64) {
                partlen = 0;
            } else {
                for (int i2 = 0; i2 < partlen; i2++) {
                    stat.buffer[i2 + index] = buffer[i2 + offset];
                }
                transform(stat, stat.buffer, 0, decode_buf);
            }
            i = partlen;
            while (i + 63 < length) {
                transform(stat, buffer, i + offset, decode_buf);
                i += 64;
            }
            index = 0;
        } else {
            i = 0;
        }
        if (i < length) {
            int start = i;
            while (i < length) {
                stat.buffer[(index + i) - start] = buffer[i + offset];
                i++;
            }
        }
    }

    private static final byte[] encode(int[] input, int len) {
        byte[] out = new byte[len];
        int i = 0;
        for (int j = 0; j < len; j += 4) {
            out[j] = (byte) (input[i] & 255);
            out[j + 1] = (byte) ((input[i] >>> 8) & 255);
            out[j + 2] = (byte) ((input[i] >>> 16) & 255);
            out[j + 3] = (byte) ((input[i] >>> 24) & 255);
            i++;
        }
        return out;
    }

    public MD5() {
        this(new byte[0]);
    }

    public MD5(String data) {
        this(StringUtils.convertStringToBytes(data));
    }

    public MD5(byte[] data) {
        this.state = new MD5State();
        this.finals = null;
        update(data);
    }

    public final void update(byte[] buffer) {
        if (buffer != null) {
            this.state = new MD5State();
            update(this.state, buffer, 0, buffer.length);
        }
    }

    public final synchronized byte[] doFinal() {
        if (this.finals == null) {
            MD5State fin = new MD5State(this, this.state);
            int[] count_ints = {(int) (fin.count << 3), (int) (fin.count >> 29)};
            byte[] bits = encode(count_ints, 8);
            int index = (int) (fin.count & 63);
            int padlen = index < 56 ? 56 - index : 120 - index;
            update(fin, padding, 0, padlen);
            update(fin, bits, 0, 8);
            this.finals = fin;
        }
        return encode(this.finals.state, 16);
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

    public static final String toBase64(byte[] data) {
        char[] alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/=".toCharArray();
        char[] out = new char[((data.length + 2) / 3) * 4];
        int i = 0;
        int index = 0;
        while (i < data.length) {
            boolean quad = false;
            boolean trip = false;
            int val = (data[i] & 255) << 8;
            if (i + 1 < data.length) {
                val |= data[i + 1] & 255;
                trip = true;
            }
            int val2 = val << 8;
            if (i + 2 < data.length) {
                val2 |= data[i + 2] & 255;
                quad = true;
            }
            out[index + 3] = alphabet[quad ? val2 & 63 : 64];
            int val3 = val2 >> 6;
            out[index + 2] = alphabet[trip ? val3 & 63 : 64];
            int val4 = val3 >> 6;
            out[index + 1] = alphabet[val4 & 63];
            out[index + 0] = alphabet[(val4 >> 6) & 63];
            i += 3;
            index += 4;
        }
        return new String(out);
    }

    public final byte[] fingerprint(byte[] data) {
        update(data);
        return doFinal();
    }

    public static final boolean equals(byte[] hash1, byte[] hash2) {
        if (hash1 == null) {
            return hash2 == null;
        }
        if (hash2 == null) {
            return false;
        }
        int targ = 16;
        if (hash1.length < 16) {
            if (hash2.length != hash1.length) {
                return false;
            }
            targ = hash1.length;
        } else if (hash2.length < 16) {
            return false;
        }
        for (int i = 0; i < targ; i++) {
            if (hash1[i] != hash2[i]) {
                return false;
            }
        }
        return true;
    }

    @Override // com.vlingo.sdk.internal.crypto.HashFunction
    public String hash(String str) {
        MD5 md5 = new MD5(StringUtils.convertStringToBytes(str));
        byte[] hash = md5.doFinal();
        return toHex(hash);
    }

    class MD5State {
        byte[] buffer;
        long count;
        int[] state;

        public MD5State() {
            this.buffer = new byte[64];
            this.count = 0L;
            this.state = new int[4];
            this.state[0] = 1732584193;
            this.state[1] = -271733879;
            this.state[2] = -1732584194;
            this.state[3] = 271733878;
        }

        public MD5State(MD5 md5, MD5State from) {
            this();
            for (int i = 0; i < this.buffer.length; i++) {
                this.buffer[i] = from.buffer[i];
            }
            for (int i2 = 0; i2 < this.state.length; i2++) {
                this.state[i2] = from.state[i2];
            }
            this.count = from.count;
        }
    }
}
