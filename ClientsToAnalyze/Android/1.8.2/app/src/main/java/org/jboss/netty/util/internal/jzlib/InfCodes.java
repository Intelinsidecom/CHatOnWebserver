package org.jboss.netty.util.internal.jzlib;

import android.support.v4.view.MotionEventCompat;

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
    private static final int[] inflate_mask = {0, 1, 3, 7, 15, 31, 63, 127, MotionEventCompat.ACTION_MASK, 511, 1023, 2047, 4095, 8191, 16383, 32767, 65535};
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

    /* JADX WARN: Code restructure failed: missing block: B:133:0x03af, code lost:
    
        r12.bitb = r5;
        r12.bitk = r4;
        r13.avail_in = r2;
        r13.total_in += r3 - r13.next_in_index;
        r13.next_in_index = r3;
        r12.write = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:195:?, code lost:
    
        return r12.inflate_flush(r13, 1);
     */
    /* JADX WARN: Removed duplicated region for block: B:151:0x00f6 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:152:0x00e9 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:161:0x01fe A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:162:0x01ed A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x019e  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x027d A[LOOP:5: B:68:0x027b->B:69:0x027d, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:76:0x02a1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    int proc(org.jboss.netty.util.internal.jzlib.InfBlocks r12, org.jboss.netty.util.internal.jzlib.ZStream r13, int r14) {
        /*
            Method dump skipped, instructions count: 1024
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jboss.netty.util.internal.jzlib.InfCodes.proc(org.jboss.netty.util.internal.jzlib.InfBlocks, org.jboss.netty.util.internal.jzlib.ZStream, int):int");
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0075, code lost:
    
        r1 = r24.avail_in - r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x007c, code lost:
    
        if ((r4 >> 3) >= r1) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x007e, code lost:
    
        r1 = r4 >> 3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0080, code lost:
    
        r23.bitb = r6;
        r23.bitk = r4 - (r1 << 3);
        r24.avail_in = r2 + r1;
        r24.total_in += r3 - r24.next_in_index;
        r24.next_in_index = r3 - r1;
        r23.write = r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x00ab, code lost:
    
        return 0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    int inflate_fast(int r17, int r18, int[] r19, int r20, int[] r21, int r22, org.jboss.netty.util.internal.jzlib.InfBlocks r23, org.jboss.netty.util.internal.jzlib.ZStream r24) {
        /*
            Method dump skipped, instructions count: 768
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jboss.netty.util.internal.jzlib.InfCodes.inflate_fast(int, int, int[], int, int[], int, org.jboss.netty.util.internal.jzlib.InfBlocks, org.jboss.netty.util.internal.jzlib.ZStream):int");
    }
}
