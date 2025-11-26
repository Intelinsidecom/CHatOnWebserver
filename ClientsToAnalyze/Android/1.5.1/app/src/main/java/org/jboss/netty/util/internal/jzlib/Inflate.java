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
                zStream.istate.mode = 0;
                break;
            case GZIP:
                zStream.istate.mode = GZIP_ID1;
                break;
        }
        zStream.istate.blocks.reset(zStream, null);
        this.gzipUncompressedBytes = 0;
        return 0;
    }

    /* JADX WARN: Code restructure failed: missing block: B:305:?, code lost:
    
        return r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:306:?, code lost:
    
        return r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:307:?, code lost:
    
        return r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:308:?, code lost:
    
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:309:?, code lost:
    
        return 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x00c9, code lost:
    
        if (r9.avail_in != 0) goto L40;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x00ce, code lost:
    
        r9.avail_in--;
        r9.total_in++;
        r1 = r9.istate;
        r2 = r9.next_in;
        r9.next_in_index = r9.next_in_index + 1;
        r1.need = ((r2[r3] & 255) << org.jboss.netty.util.internal.jzlib.Inflate.GZIP_CRC32) & 4278190080L;
        r9.istate.mode = 3;
        r1 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x00fc, code lost:
    
        if (r9.avail_in != 0) goto L44;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x0101, code lost:
    
        r9.avail_in--;
        r9.total_in++;
        r1 = r9.istate;
        r2 = r1.need;
        r4 = r9.next_in;
        r9.next_in_index = r9.next_in_index + 1;
        r1.need = r2 + (((r4[r5] & 255) << org.jboss.netty.util.internal.jzlib.Inflate.GZIP_CM) & 16711680);
        r9.istate.mode = 4;
        r1 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x0130, code lost:
    
        if (r9.avail_in != 0) goto L48;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x0135, code lost:
    
        r9.avail_in--;
        r9.total_in++;
        r1 = r9.istate;
        r2 = r1.need;
        r4 = r9.next_in;
        r9.next_in_index = r9.next_in_index + 1;
        r1.need = r2 + (((r4[r5] & 255) << 8) & 65280);
        r9.istate.mode = 5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x0163, code lost:
    
        if (r9.avail_in == 0) goto L308;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x0165, code lost:
    
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
    /* JADX WARN: Code restructure failed: missing block: B:93:0x033f, code lost:
    
        return 1;
     */
    /* JADX WARN: Removed duplicated region for block: B:105:0x0389  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x03c6  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x0403  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x0444  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x04be  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x04f4 A[LOOP:4: B:149:0x04f4->B:195:0x0637, LOOP_START, PHI: r1
  0x04f4: PHI (r1v66 int) = (r1v64 int), (r1v74 int) binds: [B:148:0x04f2, B:195:0x0637] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:158:0x0521 A[LOOP:5: B:158:0x0521->B:194:0x0634, LOOP_START, PHI: r1
  0x0521: PHI (r1v55 int) = (r1v53 int), (r1v63 int) binds: [B:157:0x051f, B:194:0x0634] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:167:0x0551 A[LOOP:6: B:167:0x0551->B:172:0x055c, LOOP_START, PHI: r1
  0x0551: PHI (r1v43 int) = (r1v41 int), (r1v52 int) binds: [B:166:0x054f, B:172:0x055c] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:186:0x05dd  */
    /* JADX WARN: Removed duplicated region for block: B:230:0x007d A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:241:0x0243 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:242:0x0289 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:243:0x02be A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:244:0x02f3 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:250:0x0386 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:253:0x03c3 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:256:0x0400 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:258:0x04c5 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:266:0x0478 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:271:0x062c A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:272:0x061b A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0258  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x028c  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x02c1  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x02f6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    int inflate(org.jboss.netty.util.internal.jzlib.ZStream r9, int r10) {
        /*
            Method dump skipped, instructions count: 1654
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jboss.netty.util.internal.jzlib.Inflate.inflate(org.jboss.netty.util.internal.jzlib.ZStream, int):int");
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
        if (i < 8 || i > GZIP_ID2) {
            inflateEnd(zStream);
            return -2;
        }
        this.wbits = i;
        zStream.istate.blocks = new InfBlocks(zStream, zStream.istate.wrapperType == JZlib.WrapperType.NONE ? null : this, 1 << i);
        inflateReset(zStream);
        return 0;
    }

    int inflateSetDictionary(ZStream zStream, byte[] bArr, int i) {
        int i2;
        int i3;
        if (zStream == null || zStream.istate == null || zStream.istate.mode != 6) {
            return -2;
        }
        if (Adler32.adler32(1L, bArr, 0, i) != zStream.adler) {
            return -3;
        }
        zStream.adler = Adler32.adler32(0L, null, 0, 0);
        if (i >= (1 << zStream.istate.wbits)) {
            i2 = (1 << zStream.istate.wbits) - 1;
            i3 = i - i2;
        } else {
            i2 = i;
            i3 = 0;
        }
        zStream.istate.blocks.set_dictionary(bArr, i3, i2);
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
        int i3 = i;
        int i4 = zStream.istate.marker;
        while (i3 != 0 && i4 < 4) {
            i4 = zStream.next_in[i2] == mark[i4] ? i4 + 1 : zStream.next_in[i2] != 0 ? 0 : 4 - i4;
            i2++;
            i3--;
        }
        zStream.total_in += i2 - zStream.next_in_index;
        zStream.next_in_index = i2;
        zStream.avail_in = i3;
        zStream.istate.marker = i4;
        if (i4 != 4) {
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
