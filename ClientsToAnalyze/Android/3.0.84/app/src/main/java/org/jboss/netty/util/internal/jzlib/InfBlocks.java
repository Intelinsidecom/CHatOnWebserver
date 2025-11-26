package org.jboss.netty.util.internal.jzlib;

import android.support.v4.view.MotionEventCompat;

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
    private static final int[] inflate_mask = {0, 1, 3, 7, 15, 31, 63, 127, MotionEventCompat.ACTION_MASK, 511, 1023, 2047, 4095, 8191, 16383, 32767, 65535};
    private static final int[] border = {16, 17, 18, 0, 8, 7, 9, 6, 10, 5, 11, 4, 12, 3, 13, 2, 14, 1, 15};

    /* renamed from: bb */
    private final int[] f13718bb = new int[1];

    /* renamed from: tb */
    private final int[] f13719tb = new int[1];
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

    /* JADX WARN: Code restructure failed: missing block: B:159:0x0679, code lost:
    
        r18.blens = null;
        r18.mode = 9;
        r19.msg = "invalid bit length repeat";
        r18.bitb = r12;
        r18.bitk = r11;
        r19.avail_in = r9;
        r19.total_in += r10 - r19.next_in_index;
        r19.next_in_index = r10;
        r18.write = r13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:253:?, code lost:
    
        return inflate_flush(r19, -3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:259:?, code lost:
    
        return inflate_flush(r19, -3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x034a, code lost:
    
        r18.mode = 9;
        r19.msg = "too many length or distance symbols";
        r18.bitb = r8;
        r18.bitk = r7;
        r19.avail_in = r3;
        r19.total_in += r4 - r19.next_in_index;
        r19.next_in_index = r4;
        r18.write = r13;
     */
    /* JADX WARN: Removed duplicated region for block: B:100:0x03c1  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x073c  */
    /* JADX WARN: Removed duplicated region for block: B:214:0x0732 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:232:0x0432 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    int proc(org.jboss.netty.util.internal.jzlib.ZStream r19, int r20) {
        /*
            Method dump skipped, instructions count: 2158
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jboss.netty.util.internal.jzlib.InfBlocks.proc(org.jboss.netty.util.internal.jzlib.ZStream, int):int");
    }

    void free(ZStream zStream) {
        reset(zStream, null);
        this.window = null;
        this.hufts = null;
    }

    void set_dictionary(byte[] bArr, int i, int i2) {
        System.arraycopy(bArr, i, this.window, 0, i2);
        this.write = i2;
        this.read = i2;
    }

    int sync_point() {
        return this.mode == 1 ? 1 : 0;
    }

    int inflate_flush(ZStream zStream, int i) {
        int i2;
        int i3 = zStream.next_out_index;
        int i4 = this.read;
        int i5 = (i4 <= this.write ? this.write : this.end) - i4;
        if (i5 > zStream.avail_out) {
            i5 = zStream.avail_out;
        }
        if (i5 != 0 && i == -5) {
            i = 0;
        }
        zStream.avail_out -= i5;
        zStream.total_out += i5;
        if (this.checkfn != null) {
            long jAdler32 = Adler32.adler32(this.check, this.window, i4, i5);
            this.check = jAdler32;
            zStream.adler = jAdler32;
        }
        System.arraycopy(this.window, i4, zStream.next_out, i3, i5);
        int i6 = i3 + i5;
        int i7 = i5 + i4;
        if (i7 == this.end) {
            if (this.write == this.end) {
                this.write = 0;
            }
            int i8 = this.write - 0;
            if (i8 > zStream.avail_out) {
                i8 = zStream.avail_out;
            }
            if (i8 != 0 && i == -5) {
                i = 0;
            }
            zStream.avail_out -= i8;
            zStream.total_out += i8;
            if (this.checkfn != null) {
                long jAdler322 = Adler32.adler32(this.check, this.window, 0, i8);
                this.check = jAdler322;
                zStream.adler = jAdler322;
            }
            System.arraycopy(this.window, 0, zStream.next_out, i6, i8);
            int i9 = i6 + i8;
            i7 = i8 + 0;
            i2 = i9;
        } else {
            i2 = i6;
        }
        zStream.next_out_index = i2;
        this.read = i7;
        return i;
    }
}
