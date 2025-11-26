package org.jboss.netty.util.internal.jzlib;

/* loaded from: classes.dex */
final class InfBlocks {
    private static final int BAD = 9;
    private static final int BTREE = 4;
    private static final int CODES = 6;
    private static final int DONE = 8;
    private static final int DRY = 7;
    private static final int DTREE = 5;
    private static final int LENS = 1;
    private static final int STORED = 2;
    private static final int TABLE = 3;
    private static final int TYPE = 0;
    int bitb;
    int bitk;
    private int[] blens;
    private long check;
    private final Object checkfn;
    final int end;
    private int index;
    private int last;
    private int left;
    int read;
    private int table;
    byte[] window;
    int write;
    private static final int[] inflate_mask = {0, 1, 3, 7, 15, 31, 63, 127, 255, 511, 1023, 2047, 4095, 8191, 16383, 32767, 65535};
    private static final int[] border = {16, 17, 18, 0, 8, 7, 9, 6, 10, 5, 11, 4, 12, 3, 13, 2, 14, 1, 15};

    /* renamed from: bb */
    private final int[] f4592bb = new int[1];

    /* renamed from: tb */
    private final int[] f4593tb = new int[1];
    private final InfCodes codes = new InfCodes();
    private final InfTree inftree = new InfTree();
    private int[] hufts = new int[4320];
    private int mode = 0;

    InfBlocks(ZStream zStream, Object obj, int i) {
        this.window = new byte[i];
        this.end = i;
        this.checkfn = obj;
        reset(zStream, null);
    }

    void free(ZStream zStream) {
        reset(zStream, null);
        this.window = null;
        this.hufts = null;
    }

    int inflate_flush(ZStream zStream, int i) {
        int i2;
        int i3;
        int i4;
        int i5 = zStream.next_out_index;
        int i6 = this.read;
        int i7 = (i6 <= this.write ? this.write : this.end) - i6;
        if (i7 > zStream.avail_out) {
            i7 = zStream.avail_out;
        }
        int i8 = (i7 == 0 || i != -5) ? i : 0;
        zStream.avail_out -= i7;
        zStream.total_out += i7;
        if (this.checkfn != null) {
            long jAdler32 = Adler32.adler32(this.check, this.window, i6, i7);
            this.check = jAdler32;
            zStream.adler = jAdler32;
        }
        System.arraycopy(this.window, i6, zStream.next_out, i5, i7);
        int i9 = i5 + i7;
        int i10 = i6 + i7;
        if (i10 == this.end) {
            if (this.write == this.end) {
                this.write = 0;
            }
            int i11 = this.write - 0;
            if (i11 > zStream.avail_out) {
                i11 = zStream.avail_out;
            }
            i2 = (i11 == 0 || i8 != -5) ? i8 : 0;
            zStream.avail_out -= i11;
            zStream.total_out += i11;
            if (this.checkfn != null) {
                long jAdler322 = Adler32.adler32(this.check, this.window, 0, i11);
                this.check = jAdler322;
                zStream.adler = jAdler322;
            }
            System.arraycopy(this.window, 0, zStream.next_out, i9, i11);
            int i12 = i9 + i11;
            int i13 = i11 + 0;
            i4 = i12;
            i3 = i13;
        } else {
            i2 = i8;
            i3 = i10;
            i4 = i9;
        }
        zStream.next_out_index = i4;
        this.read = i3;
        return i2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:159:0x07b1, code lost:
    
        r23.blens = null;
        r23.mode = 9;
        r24.msg = "invalid bit length repeat";
        r23.bitb = r8;
        r23.bitk = r4;
        r24.avail_in = r5;
        r24.total_in += r6 - r24.next_in_index;
        r24.next_in_index = r6;
        r23.write = r14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:254:?, code lost:
    
        return inflate_flush(r24, -3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:260:?, code lost:
    
        return inflate_flush(r24, -3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x03fc, code lost:
    
        r23.mode = 9;
        r24.msg = "too many length or distance symbols";
        r23.bitb = r7;
        r23.bitk = r6;
        r24.avail_in = r4;
        r24.total_in += r5 - r24.next_in_index;
        r24.next_in_index = r5;
        r23.write = r14;
     */
    /* JADX WARN: Removed duplicated region for block: B:101:0x0486  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x089f  */
    /* JADX WARN: Removed duplicated region for block: B:214:0x0894 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:232:0x050e A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    int proc(org.jboss.netty.util.internal.jzlib.ZStream r24, int r25) {
        /*
            Method dump skipped, instructions count: 2594
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jboss.netty.util.internal.jzlib.InfBlocks.proc(org.jboss.netty.util.internal.jzlib.ZStream, int):int");
    }

    void reset(ZStream zStream, long[] jArr) {
        if (jArr != null) {
            jArr[0] = this.check;
        }
        this.mode = 0;
        this.bitk = 0;
        this.bitb = 0;
        this.write = 0;
        this.read = 0;
        if (this.checkfn != null) {
            long jAdler32 = Adler32.adler32(0L, null, 0, 0);
            this.check = jAdler32;
            zStream.adler = jAdler32;
        }
    }

    void set_dictionary(byte[] bArr, int i, int i2) {
        System.arraycopy(bArr, i, this.window, 0, i2);
        this.write = i2;
        this.read = i2;
    }

    int sync_point() {
        return this.mode == 1 ? 1 : 0;
    }
}
