package com.vlingo.sdk.internal.util;

/* loaded from: classes.dex */
public class CRC32 {
    private static int[] crc_table = make_crc_table();
    private int crc = 0;

    private static int[] make_crc_table() {
        int[] crc_table2 = new int[256];
        for (int n = 0; n < 256; n++) {
            int c = n;
            int k = 8;
            while (true) {
                k--;
                if (k < 0) {
                    break;
                }
                if ((c & 1) != 0) {
                    c = (-306674912) ^ (c >>> 1);
                } else {
                    c >>>= 1;
                }
            }
            crc_table2[n] = c;
        }
        return crc_table2;
    }

    public long getValue() {
        return this.crc & 4294967295L;
    }

    public void reset() {
        this.crc = 0;
    }

    public void update(int bval) {
        int c = this.crc ^ (-1);
        this.crc = (crc_table[(c ^ bval) & 255] ^ (c >>> 8)) ^ (-1);
    }

    public void update(byte[] buf, int off, int len) {
        int c = this.crc ^ (-1);
        while (true) {
            int off2 = off;
            len--;
            if (len >= 0) {
                off = off2 + 1;
                c = crc_table[(buf[off2] ^ c) & 255] ^ (c >>> 8);
            } else {
                this.crc = c ^ (-1);
                return;
            }
        }
    }

    public void update(byte[] buf) {
        update(buf, 0, buf.length);
    }
}
