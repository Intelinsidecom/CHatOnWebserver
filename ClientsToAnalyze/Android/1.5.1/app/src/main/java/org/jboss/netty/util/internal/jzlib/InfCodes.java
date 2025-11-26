package org.jboss.netty.util.internal.jzlib;

/* loaded from: classes.dex */
final class InfCodes {
    private static final int BADCODE = 9;
    private static final int COPY = 5;
    private static final int DIST = 3;
    private static final int DISTEXT = 4;
    private static final int END = 8;
    private static final int LEN = 1;
    private static final int LENEXT = 2;
    private static final int LIT = 6;
    private static final int START = 0;
    private static final int WASH = 7;
    private static final int[] inflate_mask = {0, 1, 3, 7, 15, 31, 63, 127, 255, 511, 1023, 2047, 4095, 8191, 16383, 32767, 65535};
    private byte dbits;
    private int dist;
    private int[] dtree;
    private int dtree_index;
    private int get;
    private byte lbits;
    private int len;
    private int lit;
    private int[] ltree;
    private int ltree_index;
    private int mode;
    private int need;
    private int[] tree;
    private int tree_index = 0;

    InfCodes() {
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0085, code lost:
    
        r3 = r27.avail_in - r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x008d, code lost:
    
        if ((r7 >> 3) >= r3) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x008f, code lost:
    
        r3 = r7 >> 3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0091, code lost:
    
        r26.bitb = r8;
        r26.bitk = r7 - (r3 << 3);
        r27.avail_in = r5 + r3;
        r27.total_in += r6 - r27.next_in_index;
        r27.next_in_index = r6 - r3;
        r26.write = r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x00c4, code lost:
    
        return 0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    int inflate_fast(int r20, int r21, int[] r22, int r23, int[] r24, int r25, org.jboss.netty.util.internal.jzlib.InfBlocks r26, org.jboss.netty.util.internal.jzlib.ZStream r27) {
        /*
            Method dump skipped, instructions count: 864
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jboss.netty.util.internal.jzlib.InfCodes.inflate_fast(int, int, int[], int, int[], int, org.jboss.netty.util.internal.jzlib.InfBlocks, org.jboss.netty.util.internal.jzlib.ZStream):int");
    }

    void init(int i, int i2, int[] iArr, int i3, int[] iArr2, int i4) {
        this.mode = 0;
        this.lbits = (byte) i;
        this.dbits = (byte) i2;
        this.ltree = iArr;
        this.ltree_index = i3;
        this.dtree = iArr2;
        this.dtree_index = i4;
        this.tree = null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:141:0x06ad, code lost:
    
        r18.bitb = r8;
        r18.bitk = r6;
        r19.avail_in = r4;
        r19.total_in += r5 - r19.next_in_index;
        r19.next_in_index = r5;
        r18.write = r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:207:?, code lost:
    
        return r18.inflate_flush(r19, 1);
     */
    /* JADX WARN: Removed duplicated region for block: B:162:0x01dd A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:165:0x01c7 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:174:0x0395 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:175:0x0378 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x014f  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x02fe  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x046d A[LOOP:5: B:70:0x046b->B:71:0x046d, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:79:0x04ab  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    int proc(org.jboss.netty.util.internal.jzlib.InfBlocks r18, org.jboss.netty.util.internal.jzlib.ZStream r19, int r20) {
        /*
            Method dump skipped, instructions count: 1876
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jboss.netty.util.internal.jzlib.InfCodes.proc(org.jboss.netty.util.internal.jzlib.InfBlocks, org.jboss.netty.util.internal.jzlib.ZStream, int):int");
    }
}
