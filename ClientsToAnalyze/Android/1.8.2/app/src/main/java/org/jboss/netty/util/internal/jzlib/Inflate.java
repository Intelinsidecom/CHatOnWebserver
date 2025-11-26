package org.jboss.netty.util.internal.jzlib;

import org.jboss.netty.util.internal.jzlib.JZlib;

/* loaded from: classes.dex */
final class Inflate {
    private static final int BAD = 13;
    private static final int BLOCKS = 7;
    private static final int CHECK1 = 11;
    private static final int CHECK2 = 10;
    private static final int CHECK3 = 9;
    private static final int CHECK4 = 8;
    private static final int DICT0 = 6;
    private static final int DICT1 = 5;
    private static final int DICT2 = 4;
    private static final int DICT3 = 3;
    private static final int DICT4 = 2;
    private static final int DONE = 12;
    private static final int FLAG = 1;
    private static final int GZIP_CM = 16;
    private static final int GZIP_CRC32 = 24;
    private static final int GZIP_FCOMMENT = 22;
    private static final int GZIP_FEXTRA = 20;
    private static final int GZIP_FHCRC = 23;
    private static final int GZIP_FLG = 17;
    private static final int GZIP_FNAME = 21;
    private static final int GZIP_ID1 = 14;
    private static final int GZIP_ID2 = 15;
    private static final int GZIP_ISIZE = 25;
    private static final int GZIP_MTIME_XFL_OS = 18;
    private static final int GZIP_XLEN = 19;
    private static final int METHOD = 0;
    private static final byte[] mark = {0, 0, -1, -1};
    private InfBlocks blocks;
    private int gzipBytesToRead;
    private int gzipCRC32;
    private int gzipFlag;
    private int gzipISize;
    private int gzipUncompressedBytes;
    private int gzipXLen;
    private int marker;
    private int method;
    private int mode;
    private long need;
    private final long[] was = new long[1];
    private int wbits;
    private JZlib.WrapperType wrapperType;

    Inflate() {
    }

    private int inflateReset(ZStream zStream) {
        if (zStream == null || zStream.istate == null) {
            return -2;
        }
        zStream.total_out = 0L;
        zStream.total_in = 0L;
        zStream.msg = null;
        switch (this.wrapperType) {
            case NONE:
                zStream.istate.mode = 7;
                break;
            case ZLIB:
            case ZLIB_OR_NONE:
                zStream.istate.mode = 0;
                break;
            case GZIP:
                zStream.istate.mode = 14;
                break;
        }
        zStream.istate.blocks.reset(zStream, null);
        this.gzipUncompressedBytes = 0;
        return 0;
    }

    int inflateEnd(ZStream zStream) {
        if (this.blocks != null) {
            this.blocks.free(zStream);
        }
        this.blocks = null;
        return 0;
    }

    int inflateInit(ZStream zStream, int i, JZlib.WrapperType wrapperType) {
        zStream.msg = null;
        this.blocks = null;
        this.wrapperType = wrapperType;
        if (i < 0) {
            throw new IllegalArgumentException("w: " + i);
        }
        if (i < 8 || i > 15) {
            inflateEnd(zStream);
            return -2;
        }
        this.wbits = i;
        zStream.istate.blocks = new InfBlocks(zStream, zStream.istate.wrapperType != JZlib.WrapperType.NONE ? this : null, 1 << i);
        inflateReset(zStream);
        return 0;
    }

    /* JADX WARN: Code restructure failed: missing block: B:303:?, code lost:
    
        return r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:304:?, code lost:
    
        return r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:305:?, code lost:
    
        return r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:306:?, code lost:
    
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:307:?, code lost:
    
        return 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00fc, code lost:
    
        if (r9.avail_in == 0) goto L303;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x00fe, code lost:
    
        r9.avail_in--;
        r9.total_in++;
        r1 = r9.istate;
        r2 = r9.next_in;
        r9.next_in_index = r9.next_in_index + 1;
        r1.need = ((r2[r3] & 255) << 24) & 4278190080L;
        r9.istate.mode = 3;
        r1 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x012c, code lost:
    
        if (r9.avail_in == 0) goto L304;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x012e, code lost:
    
        r9.avail_in--;
        r9.total_in++;
        r1 = r9.istate;
        r2 = r1.need;
        r4 = r9.next_in;
        r9.next_in_index = r9.next_in_index + 1;
        r1.need = r2 + (((r4[r5] & 255) << 16) & 16711680);
        r9.istate.mode = 4;
        r1 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x015d, code lost:
    
        if (r9.avail_in == 0) goto L305;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x015f, code lost:
    
        r9.avail_in--;
        r9.total_in++;
        r1 = r9.istate;
        r2 = r1.need;
        r4 = r9.next_in;
        r9.next_in_index = r9.next_in_index + 1;
        r1.need = r2 + (((r4[r5] & 255) << 8) & 65280);
        r9.istate.mode = 5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x018d, code lost:
    
        if (r9.avail_in != 0) goto L55;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x0192, code lost:
    
        r9.avail_in--;
        r9.total_in++;
        r0 = r9.istate;
        r1 = r0.need;
        r3 = r9.next_in;
        r9.next_in_index = r9.next_in_index + 1;
        r0.need = r1 + (r3[r4] & 255);
        r9.adler = r9.istate.need;
        r9.istate.mode = 6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:96:0x0379, code lost:
    
        return 1;
     */
    /* JADX WARN: Removed duplicated region for block: B:106:0x03bd  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x03f7  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x0431  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x0472  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x04e6  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x0519 A[LOOP:4: B:145:0x0519->B:187:0x064f, LOOP_START, PHI: r1
  0x0519: PHI (r1v68 int) = (r1v66 int), (r1v76 int) binds: [B:144:0x0517, B:187:0x064f] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:153:0x0543 A[LOOP:5: B:153:0x0543->B:186:0x064c, LOOP_START, PHI: r1
  0x0543: PHI (r1v57 int) = (r1v55 int), (r1v65 int) binds: [B:152:0x0541, B:186:0x064c] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:161:0x0570 A[LOOP:6: B:161:0x0570->B:165:0x0578, LOOP_START, PHI: r1
  0x0570: PHI (r1v45 int) = (r1v43 int), (r1v54 int) binds: [B:160:0x056e, B:165:0x0578] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:179:0x05f8  */
    /* JADX WARN: Removed duplicated region for block: B:226:0x000b A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:237:0x000b A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:238:0x000b A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:239:0x000b A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:240:0x000b A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:248:0x000b A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:251:0x000b A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:254:0x000b A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:256:0x0505 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:264:0x04a3 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:269:0x0644 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:270:0x0633 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00b2  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x026f  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x02a0  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x02d2  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0304  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    int inflate(org.jboss.netty.util.internal.jzlib.ZStream r9, int r10) {
        /*
            Method dump skipped, instructions count: 1678
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jboss.netty.util.internal.jzlib.Inflate.inflate(org.jboss.netty.util.internal.jzlib.ZStream, int):int");
    }

    int inflateSetDictionary(ZStream zStream, byte[] bArr, int i) {
        int i2;
        if (zStream == null || zStream.istate == null || zStream.istate.mode != 6) {
            return -2;
        }
        if (Adler32.adler32(1L, bArr, 0, i) != zStream.adler) {
            return -3;
        }
        zStream.adler = Adler32.adler32(0L, null, 0, 0);
        if (i >= (1 << zStream.istate.wbits)) {
            int i3 = (1 << zStream.istate.wbits) - 1;
            int i4 = i - i3;
            i = i3;
            i2 = i4;
        } else {
            i2 = 0;
        }
        zStream.istate.blocks.set_dictionary(bArr, i2, i);
        zStream.istate.mode = 7;
        return 0;
    }

    int inflateSync(ZStream zStream) {
        if (zStream == null || zStream.istate == null) {
            return -2;
        }
        if (zStream.istate.mode != 13) {
            zStream.istate.mode = 13;
            zStream.istate.marker = 0;
        }
        int i = zStream.avail_in;
        if (i == 0) {
            return -5;
        }
        int i2 = zStream.next_in_index;
        int i3 = zStream.istate.marker;
        while (i != 0 && i3 < 4) {
            if (zStream.next_in[i2] == mark[i3]) {
                i3++;
            } else {
                i3 = zStream.next_in[i2] != 0 ? 0 : 4 - i3;
            }
            i2++;
            i--;
        }
        zStream.total_in += i2 - zStream.next_in_index;
        zStream.next_in_index = i2;
        zStream.avail_in = i;
        zStream.istate.marker = i3;
        if (i3 != 4) {
            return -3;
        }
        long j = zStream.total_in;
        long j2 = zStream.total_out;
        inflateReset(zStream);
        zStream.total_in = j;
        zStream.total_out = j2;
        zStream.istate.mode = 7;
        return 0;
    }
}
