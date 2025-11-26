package org.jboss.netty.util.internal.jzlib;

import com.sec.amsoma.AMSLibs;
import org.jboss.netty.util.internal.jzlib.JZlib;

/* loaded from: classes.dex */
final class Deflate {
    private static final int BUSY_STATE = 113;
    private static final int BlockDone = 1;
    private static final int Buf_size = 16;
    private static final int DYN_TREES = 2;
    private static final int END_BLOCK = 256;
    private static final int FAST = 1;
    private static final int FINISH_STATE = 666;
    private static final int FinishDone = 3;
    private static final int FinishStarted = 2;
    private static final int INIT_STATE = 42;
    private static final int MAX_MATCH = 258;
    private static final int MIN_LOOKAHEAD = 262;
    private static final int MIN_MATCH = 3;
    private static final int NeedMore = 0;
    private static final int REPZ_11_138 = 18;
    private static final int REPZ_3_10 = 17;
    private static final int REP_3_6 = 16;
    private static final int SLOW = 2;
    private static final int STATIC_TREES = 1;
    private static final int STORED = 0;
    private static final int STORED_BLOCK = 0;
    private static final int Z_ASCII = 1;
    private static final int Z_BINARY = 0;
    private static final int Z_UNKNOWN = 2;
    private static final Config[] config_table = new Config[10];
    private static final String[] z_errmsg;
    short bi_buf;
    int bi_valid;
    int block_start;
    int d_buf;
    byte data_type;
    int good_match;
    private int gzipUncompressedBytes;
    int hash_bits;
    int hash_mask;
    int hash_shift;
    int hash_size;
    short[] head;
    int heap_len;
    int heap_max;
    int ins_h;
    int l_buf;
    int last_eob_len;
    int last_flush;
    int last_lit;
    int level;
    int lit_bufsize;
    int lookahead;
    int match_available;
    int match_length;
    int match_start;
    int matches;
    int max_chain_length;
    int max_lazy_match;
    int nice_match;
    int opt_len;
    int pending;
    byte[] pending_buf;
    int pending_buf_size;
    int pending_out;
    short[] prev;
    int prev_length;
    int prev_match;
    int static_len;
    int status;
    int strategy;
    ZStream strm;
    int strstart;
    int w_bits;
    int w_mask;
    int w_size;
    byte[] window;
    int window_size;
    JZlib.WrapperType wrapperType;
    private boolean wroteTrailer;
    Tree l_desc = new Tree();
    Tree d_desc = new Tree();
    Tree bl_desc = new Tree();
    short[] bl_count = new short[16];
    int[] heap = new int[573];
    byte[] depth = new byte[573];
    short[] dyn_ltree = new short[1146];
    short[] dyn_dtree = new short[122];
    short[] bl_tree = new short[78];

    final class Config {
        final int func;
        final int good_length;
        final int max_chain;
        final int max_lazy;
        final int nice_length;

        Config(int i, int i2, int i3, int i4, int i5) {
            this.good_length = i;
            this.max_lazy = i2;
            this.nice_length = i3;
            this.max_chain = i4;
            this.func = i5;
        }
    }

    static {
        config_table[0] = new Config(0, 0, 0, 0, 0);
        config_table[1] = new Config(4, 4, 8, 4, 1);
        config_table[2] = new Config(4, 5, 16, 8, 1);
        config_table[3] = new Config(4, 6, 32, 32, 1);
        config_table[4] = new Config(4, 4, 16, 16, 2);
        config_table[5] = new Config(8, 16, 32, 32, 2);
        config_table[6] = new Config(8, 16, 128, 128, 2);
        config_table[7] = new Config(8, 32, 128, END_BLOCK, 2);
        config_table[8] = new Config(32, 128, MAX_MATCH, 1024, 2);
        config_table[9] = new Config(32, MAX_MATCH, MAX_MATCH, 4096, 2);
        z_errmsg = new String[]{"need dictionary", "stream end", "", "file error", "stream error", "data error", "insufficient memory", "buffer error", "incompatible version", ""};
    }

    Deflate() {
    }

    private void _tr_align() {
        send_bits(2, 3);
        send_code(END_BLOCK, StaticTree.static_ltree);
        bi_flush();
        if (((this.last_eob_len + 1) + 10) - this.bi_valid < 9) {
            send_bits(2, 3);
            send_code(END_BLOCK, StaticTree.static_ltree);
            bi_flush();
        }
        this.last_eob_len = 7;
    }

    private void _tr_flush_block(int i, int i2, boolean z) {
        int i3;
        int i4;
        int iBuild_bl_tree;
        if (this.level > 0) {
            if (this.data_type == 2) {
                set_data_type();
            }
            this.l_desc.build_tree(this);
            this.d_desc.build_tree(this);
            iBuild_bl_tree = build_bl_tree();
            int i5 = ((this.opt_len + 3) + 7) >>> 3;
            i4 = ((this.static_len + 3) + 7) >>> 3;
            if (i4 <= i5) {
                i3 = i4;
            } else {
                i4 = i5;
                i3 = i4;
            }
        } else {
            int i6 = i2 + 5;
            i3 = i6;
            i4 = i6;
            iBuild_bl_tree = 0;
        }
        if (i2 + 4 <= i4 && i != -1) {
            _tr_stored_block(i, i2, z);
        } else if (i3 == i4) {
            send_bits((z ? 1 : 0) + 2, 3);
            compress_block(StaticTree.static_ltree, StaticTree.static_dtree);
        } else {
            send_bits((z ? 1 : 0) + 4, 3);
            send_all_trees(this.l_desc.max_code + 1, this.d_desc.max_code + 1, iBuild_bl_tree + 1);
            compress_block(this.dyn_ltree, this.dyn_dtree);
        }
        init_block();
        if (z) {
            bi_windup();
        }
    }

    private void _tr_stored_block(int i, int i2, boolean z) {
        send_bits((z ? 1 : 0) + 0, 3);
        copy_block(i, i2, true);
    }

    private boolean _tr_tally(int i, int i2) {
        this.pending_buf[this.d_buf + (this.last_lit * 2)] = (byte) (i >>> 8);
        this.pending_buf[this.d_buf + (this.last_lit * 2) + 1] = (byte) i;
        this.pending_buf[this.l_buf + this.last_lit] = (byte) i2;
        this.last_lit++;
        if (i == 0) {
            short[] sArr = this.dyn_ltree;
            int i3 = i2 * 2;
            sArr[i3] = (short) (sArr[i3] + 1);
        } else {
            this.matches++;
            short[] sArr2 = this.dyn_ltree;
            int i4 = (Tree._length_code[i2] + 256 + 1) * 2;
            sArr2[i4] = (short) (sArr2[i4] + 1);
            short[] sArr3 = this.dyn_dtree;
            int iD_code = Tree.d_code(i - 1) * 2;
            sArr3[iD_code] = (short) (sArr3[iD_code] + 1);
        }
        if ((this.last_lit & 8191) == 0 && this.level > 2) {
            int i5 = this.last_lit * 8;
            int i6 = this.strstart - this.block_start;
            int i7 = i5;
            for (int i8 = 0; i8 < 30; i8++) {
                i7 = (int) (i7 + (this.dyn_dtree[i8 * 2] * (5 + Tree.extra_dbits[i8])));
            }
            int i9 = i7 >>> 3;
            if (this.matches < this.last_lit / 2 && i9 < i6 / 2) {
                return true;
            }
        }
        return this.last_lit == this.lit_bufsize - 1;
    }

    private void bi_flush() {
        if (this.bi_valid == 16) {
            put_short(this.bi_buf);
            this.bi_buf = (short) 0;
            this.bi_valid = 0;
        } else if (this.bi_valid >= 8) {
            put_byte((byte) this.bi_buf);
            this.bi_buf = (short) (this.bi_buf >>> 8);
            this.bi_valid -= 8;
        }
    }

    private void bi_windup() {
        if (this.bi_valid > 8) {
            put_short(this.bi_buf);
        } else if (this.bi_valid > 0) {
            put_byte((byte) this.bi_buf);
        }
        this.bi_buf = (short) 0;
        this.bi_valid = 0;
    }

    private int build_bl_tree() {
        scan_tree(this.dyn_ltree, this.l_desc.max_code);
        scan_tree(this.dyn_dtree, this.d_desc.max_code);
        this.bl_desc.build_tree(this);
        int i = REPZ_11_138;
        while (i >= 3 && this.bl_tree[(Tree.bl_order[i] * 2) + 1] == 0) {
            i--;
        }
        this.opt_len += ((i + 1) * 3) + 5 + 5 + 4;
        return i;
    }

    private void compress_block(short[] sArr, short[] sArr2) {
        int i = 0;
        if (this.last_lit != 0) {
            do {
                int i2 = ((this.pending_buf[this.d_buf + (i * 2)] << 8) & 65280) | (this.pending_buf[this.d_buf + (i * 2) + 1] & 255);
                int i3 = this.pending_buf[this.l_buf + i] & 255;
                i++;
                if (i2 == 0) {
                    send_code(i3, sArr);
                } else {
                    byte b = Tree._length_code[i3];
                    send_code(b + 256 + 1, sArr);
                    int i4 = Tree.extra_lbits[b];
                    if (i4 != 0) {
                        send_bits(i3 - Tree.base_length[b], i4);
                    }
                    int i5 = i2 - 1;
                    int iD_code = Tree.d_code(i5);
                    send_code(iD_code, sArr2);
                    int i6 = Tree.extra_dbits[iD_code];
                    if (i6 != 0) {
                        send_bits(i5 - Tree.base_dist[iD_code], i6);
                    }
                }
            } while (i < this.last_lit);
        }
        send_code(END_BLOCK, sArr);
        this.last_eob_len = sArr[513];
    }

    private void copy_block(int i, int i2, boolean z) {
        bi_windup();
        this.last_eob_len = 8;
        if (z) {
            put_short((short) i2);
            put_short((short) (i2 ^ (-1)));
        }
        put_byte(this.window, i, i2);
    }

    private int deflateInit2(ZStream zStream, int i, int i2, int i3, int i4, int i5, JZlib.WrapperType wrapperType) {
        zStream.msg = null;
        int i6 = i == -1 ? 6 : i;
        if (i3 < 0) {
            throw new IllegalArgumentException("windowBits: " + i3);
        }
        if (i4 < 1 || i4 > 9 || i2 != 8 || i3 < 9 || i3 > 15 || i6 < 0 || i6 > 9 || i5 < 0 || i5 > 2) {
            return -2;
        }
        zStream.dstate = this;
        this.wrapperType = wrapperType;
        this.w_bits = i3;
        this.w_size = 1 << this.w_bits;
        this.w_mask = this.w_size - 1;
        this.hash_bits = i4 + 7;
        this.hash_size = 1 << this.hash_bits;
        this.hash_mask = this.hash_size - 1;
        this.hash_shift = ((this.hash_bits + 3) - 1) / 3;
        this.window = new byte[this.w_size * 2];
        this.prev = new short[this.w_size];
        this.head = new short[this.hash_size];
        this.lit_bufsize = 1 << (i4 + 6);
        this.pending_buf = new byte[this.lit_bufsize * 4];
        this.pending_buf_size = this.lit_bufsize * 4;
        this.d_buf = this.lit_bufsize / 2;
        this.l_buf = this.lit_bufsize * 3;
        this.level = i6;
        this.strategy = i5;
        return deflateReset(zStream);
    }

    private int deflateReset(ZStream zStream) {
        zStream.total_out = 0L;
        zStream.total_in = 0L;
        zStream.msg = null;
        this.pending = 0;
        this.pending_out = 0;
        this.wroteTrailer = false;
        this.status = this.wrapperType == JZlib.WrapperType.NONE ? BUSY_STATE : INIT_STATE;
        zStream.adler = Adler32.adler32(0L, null, 0, 0);
        zStream.crc32 = 0;
        this.gzipUncompressedBytes = 0;
        this.last_flush = 0;
        tr_init();
        lm_init();
        return 0;
    }

    private int deflate_fast(int i) {
        int i2;
        boolean z;
        int i3;
        int i4;
        int i5 = 0;
        while (true) {
            if (this.lookahead < MIN_LOOKAHEAD) {
                fill_window();
                if (this.lookahead < MIN_LOOKAHEAD && i == 0) {
                    return 0;
                }
                if (this.lookahead == 0) {
                    flush_block_only(i == 4);
                    return this.strm.avail_out == 0 ? i == 4 ? 2 : 0 : i == 4 ? 3 : 1;
                }
            }
            if (this.lookahead >= 3) {
                this.ins_h = ((this.ins_h << this.hash_shift) ^ (this.window[(this.strstart + 3) - 1] & 255)) & this.hash_mask;
                i5 = this.head[this.ins_h] & 65535;
                this.prev[this.strstart & this.w_mask] = this.head[this.ins_h];
                this.head[this.ins_h] = (short) this.strstart;
            }
            if (i5 != 0 && ((this.strstart - i5) & 65535) <= this.w_size - MIN_LOOKAHEAD && this.strategy != 2) {
                this.match_length = longest_match(i5);
            }
            if (this.match_length >= 3) {
                boolean z_tr_tally = _tr_tally(this.strstart - this.match_start, this.match_length - 3);
                this.lookahead -= this.match_length;
                if (this.match_length > this.max_lazy_match || this.lookahead < 3) {
                    this.strstart += this.match_length;
                    this.match_length = 0;
                    this.ins_h = this.window[this.strstart] & 255;
                    this.ins_h = ((this.ins_h << this.hash_shift) ^ (this.window[this.strstart + 1] & 255)) & this.hash_mask;
                    i2 = i5;
                    z = z_tr_tally;
                } else {
                    this.match_length--;
                    do {
                        this.strstart++;
                        this.ins_h = ((this.ins_h << this.hash_shift) ^ (this.window[(this.strstart + 3) - 1] & 255)) & this.hash_mask;
                        i3 = this.head[this.ins_h] & 65535;
                        this.prev[this.strstart & this.w_mask] = this.head[this.ins_h];
                        this.head[this.ins_h] = (short) this.strstart;
                        i4 = this.match_length - 1;
                        this.match_length = i4;
                    } while (i4 != 0);
                    this.strstart++;
                    i2 = i3;
                    z = z_tr_tally;
                }
            } else {
                boolean z_tr_tally2 = _tr_tally(0, this.window[this.strstart] & 255);
                this.lookahead--;
                this.strstart++;
                i2 = i5;
                z = z_tr_tally2;
            }
            if (z) {
                flush_block_only(false);
                if (this.strm.avail_out == 0) {
                    return 0;
                }
            }
            i5 = i2;
        }
    }

    private int deflate_slow(int i) {
        int i2;
        int i3 = 0;
        while (true) {
            if (this.lookahead < MIN_LOOKAHEAD) {
                fill_window();
                if (this.lookahead < MIN_LOOKAHEAD && i == 0) {
                    return 0;
                }
                if (this.lookahead == 0) {
                    if (this.match_available != 0) {
                        _tr_tally(0, this.window[this.strstart - 1] & 255);
                        this.match_available = 0;
                    }
                    flush_block_only(i == 4);
                    return this.strm.avail_out == 0 ? i == 4 ? 2 : 0 : i == 4 ? 3 : 1;
                }
            }
            if (this.lookahead >= 3) {
                this.ins_h = ((this.ins_h << this.hash_shift) ^ (this.window[(this.strstart + 3) - 1] & 255)) & this.hash_mask;
                i3 = this.head[this.ins_h] & 65535;
                this.prev[this.strstart & this.w_mask] = this.head[this.ins_h];
                this.head[this.ins_h] = (short) this.strstart;
            }
            this.prev_length = this.match_length;
            this.prev_match = this.match_start;
            this.match_length = 2;
            if (i3 != 0 && this.prev_length < this.max_lazy_match && ((this.strstart - i3) & 65535) <= this.w_size - MIN_LOOKAHEAD) {
                if (this.strategy != 2) {
                    this.match_length = longest_match(i3);
                }
                if (this.match_length <= 5 && (this.strategy == 1 || (this.match_length == 3 && this.strstart - this.match_start > 4096))) {
                    this.match_length = 2;
                }
            }
            if (this.prev_length >= 3 && this.match_length <= this.prev_length) {
                int i4 = (this.strstart + this.lookahead) - 3;
                boolean z_tr_tally = _tr_tally((this.strstart - 1) - this.prev_match, this.prev_length - 3);
                this.lookahead -= this.prev_length - 1;
                this.prev_length -= 2;
                do {
                    int i5 = this.strstart + 1;
                    this.strstart = i5;
                    if (i5 <= i4) {
                        this.ins_h = ((this.ins_h << this.hash_shift) ^ (this.window[(this.strstart + 3) - 1] & 255)) & this.hash_mask;
                        i3 = this.head[this.ins_h] & 65535;
                        this.prev[this.strstart & this.w_mask] = this.head[this.ins_h];
                        this.head[this.ins_h] = (short) this.strstart;
                    }
                    i2 = this.prev_length - 1;
                    this.prev_length = i2;
                } while (i2 != 0);
                this.match_available = 0;
                this.match_length = 2;
                this.strstart++;
                if (z_tr_tally) {
                    flush_block_only(false);
                    if (this.strm.avail_out == 0) {
                        return 0;
                    }
                } else {
                    continue;
                }
            } else if (this.match_available != 0) {
                if (_tr_tally(0, this.window[this.strstart - 1] & 255)) {
                    flush_block_only(false);
                }
                this.strstart++;
                this.lookahead--;
                if (this.strm.avail_out == 0) {
                    return 0;
                }
            } else {
                this.match_available = 1;
                this.strstart++;
                this.lookahead--;
            }
        }
    }

    private int deflate_stored(int i) {
        int i2 = 65535 > this.pending_buf_size - 5 ? this.pending_buf_size - 5 : 65535;
        while (true) {
            if (this.lookahead <= 1) {
                fill_window();
                if (this.lookahead == 0 && i == 0) {
                    return 0;
                }
                if (this.lookahead == 0) {
                    flush_block_only(i == 4);
                    return this.strm.avail_out == 0 ? i == 4 ? 2 : 0 : i == 4 ? 3 : 1;
                }
            }
            this.strstart += this.lookahead;
            this.lookahead = 0;
            int i3 = this.block_start + i2;
            if (this.strstart == 0 || this.strstart >= i3) {
                this.lookahead = this.strstart - i3;
                this.strstart = i3;
                flush_block_only(false);
                if (this.strm.avail_out == 0) {
                    return 0;
                }
            }
            if (this.strstart - this.block_start >= this.w_size - MIN_LOOKAHEAD) {
                flush_block_only(false);
                if (this.strm.avail_out == 0) {
                    return 0;
                }
            }
        }
    }

    private void fill_window() {
        do {
            int i = (this.window_size - this.lookahead) - this.strstart;
            if (i == 0 && this.strstart == 0 && this.lookahead == 0) {
                i = this.w_size;
            } else if (i == -1) {
                i--;
            } else if (this.strstart >= (this.w_size + this.w_size) - MIN_LOOKAHEAD) {
                System.arraycopy(this.window, this.w_size, this.window, 0, this.w_size);
                this.match_start -= this.w_size;
                this.strstart -= this.w_size;
                this.block_start -= this.w_size;
                int i2 = this.hash_size;
                int i3 = i2;
                do {
                    i2--;
                    int i4 = this.head[i2] & 65535;
                    this.head[i2] = i4 >= this.w_size ? (short) (i4 - this.w_size) : (short) 0;
                    i3--;
                } while (i3 != 0);
                int i5 = this.w_size;
                int i6 = i5;
                do {
                    i5--;
                    int i7 = this.prev[i5] & 65535;
                    this.prev[i5] = i7 >= this.w_size ? (short) (i7 - this.w_size) : (short) 0;
                    i6--;
                } while (i6 != 0);
                i += this.w_size;
            }
            if (this.strm.avail_in == 0) {
                return;
            }
            this.lookahead = this.strm.read_buf(this.window, this.strstart + this.lookahead, i) + this.lookahead;
            if (this.lookahead >= 3) {
                this.ins_h = this.window[this.strstart] & 255;
                this.ins_h = ((this.ins_h << this.hash_shift) ^ (this.window[this.strstart + 1] & 255)) & this.hash_mask;
            }
            if (this.lookahead >= MIN_LOOKAHEAD) {
                return;
            }
        } while (this.strm.avail_in != 0);
    }

    private void flush_block_only(boolean z) {
        _tr_flush_block(this.block_start >= 0 ? this.block_start : -1, this.strstart - this.block_start, z);
        this.block_start = this.strstart;
        this.strm.flush_pending();
    }

    private void init_block() {
        for (int i = 0; i < 286; i++) {
            this.dyn_ltree[i * 2] = 0;
        }
        for (int i2 = 0; i2 < 30; i2++) {
            this.dyn_dtree[i2 * 2] = 0;
        }
        for (int i3 = 0; i3 < 19; i3++) {
            this.bl_tree[i3 * 2] = 0;
        }
        this.dyn_ltree[512] = 1;
        this.static_len = 0;
        this.opt_len = 0;
        this.matches = 0;
        this.last_lit = 0;
    }

    private void lm_init() {
        this.window_size = this.w_size * 2;
        this.max_lazy_match = config_table[this.level].max_lazy;
        this.good_match = config_table[this.level].good_length;
        this.nice_match = config_table[this.level].nice_length;
        this.max_chain_length = config_table[this.level].max_chain;
        this.strstart = 0;
        this.block_start = 0;
        this.lookahead = 0;
        this.prev_length = 2;
        this.match_length = 2;
        this.match_available = 0;
        this.ins_h = 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x00b8 A[PHI: r2 r3 r6 r9
  0x00b8: PHI (r2v5 byte) = (r2v4 byte), (r2v4 byte), (r2v4 byte), (r2v4 byte), (r2v4 byte), (r2v12 byte) binds: [B:12:0x0085, B:14:0x0092, B:16:0x00a2, B:18:0x00b6, B:53:0x01bc, B:51:0x0198] A[DONT_GENERATE, DONT_INLINE]
  0x00b8: PHI (r3v4 byte) = (r3v3 byte), (r3v3 byte), (r3v3 byte), (r3v3 byte), (r3v3 byte), (r3v10 byte) binds: [B:12:0x0085, B:14:0x0092, B:16:0x00a2, B:18:0x00b6, B:53:0x01bc, B:51:0x0198] A[DONT_GENERATE, DONT_INLINE]
  0x00b8: PHI (r6v6 int) = (r6v5 int), (r6v5 int), (r6v5 int), (r6v5 int), (r6v5 int), (r6v9 int) binds: [B:12:0x0085, B:14:0x0092, B:16:0x00a2, B:18:0x00b6, B:53:0x01bc, B:51:0x0198] A[DONT_GENERATE, DONT_INLINE]
  0x00b8: PHI (r9v5 int) = (r9v4 int), (r9v4 int), (r9v4 int), (r9v4 int), (r9v13 int), (r9v14 int) binds: [B:12:0x0085, B:14:0x0092, B:16:0x00a2, B:18:0x00b6, B:53:0x01bc, B:51:0x0198] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00c6  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00ca A[EDGE_INSN: B:55:0x00ca->B:23:0x00ca BREAK  A[LOOP:0: B:11:0x007c->B:59:?], SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private int longest_match(int r20) {
        /*
            Method dump skipped, instructions count: 466
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jboss.netty.util.internal.jzlib.Deflate.longest_match(int):int");
    }

    private final void putShortMSB(int i) {
        put_byte((byte) (i >> 8));
        put_byte((byte) i);
    }

    private final void put_byte(byte b) {
        byte[] bArr = this.pending_buf;
        int i = this.pending;
        this.pending = i + 1;
        bArr[i] = b;
    }

    private final void put_byte(byte[] bArr, int i, int i2) {
        System.arraycopy(bArr, i, this.pending_buf, this.pending, i2);
        this.pending += i2;
    }

    private final void put_short(int i) {
        put_byte((byte) i);
        put_byte((byte) (i >>> 8));
    }

    private void scan_tree(short[] sArr, int i) {
        int i2;
        int i3;
        short s = -1;
        short s2 = sArr[1];
        if (s2 == 0) {
            i3 = 138;
            i2 = 3;
        } else {
            i2 = 4;
            i3 = 7;
        }
        sArr[((i + 1) * 2) + 1] = -1;
        short s3 = s2;
        int i4 = 0;
        int i5 = i2;
        int i6 = i3;
        int i7 = 0;
        while (i4 <= i) {
            short s4 = sArr[((i4 + 1) * 2) + 1];
            i7++;
            if (i7 >= i6 || s3 != s4) {
                if (i7 < i5) {
                    short[] sArr2 = this.bl_tree;
                    int i8 = s3 * 2;
                    sArr2[i8] = (short) (i7 + sArr2[i8]);
                } else if (s3 != 0) {
                    if (s3 != s) {
                        short[] sArr3 = this.bl_tree;
                        int i9 = s3 * 2;
                        sArr3[i9] = (short) (sArr3[i9] + 1);
                    }
                    short[] sArr4 = this.bl_tree;
                    sArr4[32] = (short) (sArr4[32] + 1);
                } else if (i7 <= 10) {
                    short[] sArr5 = this.bl_tree;
                    sArr5[34] = (short) (sArr5[34] + 1);
                } else {
                    short[] sArr6 = this.bl_tree;
                    sArr6[36] = (short) (sArr6[36] + 1);
                }
                if (s4 == 0) {
                    i6 = 138;
                    i7 = 0;
                    i5 = 3;
                } else if (s3 == s4) {
                    i6 = 6;
                    i7 = 0;
                    i5 = 3;
                } else {
                    i5 = 4;
                    i6 = 7;
                    i7 = 0;
                }
            } else {
                s3 = s;
            }
            i4++;
            s = s3;
            s3 = s4;
        }
    }

    private void send_all_trees(int i, int i2, int i3) {
        send_bits(i - 257, 5);
        send_bits(i2 - 1, 5);
        send_bits(i3 - 4, 4);
        for (int i4 = 0; i4 < i3; i4++) {
            send_bits(this.bl_tree[(Tree.bl_order[i4] * 2) + 1], 3);
        }
        send_tree(this.dyn_ltree, i - 1);
        send_tree(this.dyn_dtree, i2 - 1);
    }

    private void send_bits(int i, int i2) {
        if (this.bi_valid <= 16 - i2) {
            this.bi_buf = (short) (this.bi_buf | ((i << this.bi_valid) & 65535));
            this.bi_valid += i2;
        } else {
            this.bi_buf = (short) (this.bi_buf | ((i << this.bi_valid) & 65535));
            put_short(this.bi_buf);
            this.bi_buf = (short) (i >>> (16 - this.bi_valid));
            this.bi_valid += i2 - 16;
        }
    }

    private final void send_code(int i, short[] sArr) {
        int i2 = i * 2;
        send_bits(sArr[i2] & 65535, sArr[i2 + 1] & 65535);
    }

    private void send_tree(short[] sArr, int i) {
        int i2;
        int i3;
        int i4;
        short s = sArr[1];
        if (s == 0) {
            i2 = 3;
            i3 = 138;
        } else {
            i2 = 4;
            i3 = 7;
        }
        short s2 = -1;
        int i5 = 0;
        int i6 = i2;
        int i7 = 0;
        int i8 = i3;
        short s3 = s;
        while (i5 <= i) {
            short s4 = sArr[((i5 + 1) * 2) + 1];
            i7++;
            if (i7 >= i8 || s3 != s4) {
                if (i7 < i6) {
                    int i9 = i7;
                    do {
                        send_code(s3, this.bl_tree);
                        i9--;
                    } while (i9 != 0);
                } else if (s3 != 0) {
                    if (s3 != s2) {
                        send_code(s3, this.bl_tree);
                        i4 = i7 - 1;
                    } else {
                        i4 = i7;
                    }
                    send_code(16, this.bl_tree);
                    send_bits(i4 - 3, 2);
                } else if (i7 <= 10) {
                    send_code(REPZ_3_10, this.bl_tree);
                    send_bits(i7 - 3, 3);
                } else {
                    send_code(REPZ_11_138, this.bl_tree);
                    send_bits(i7 - 11, 7);
                }
                if (s4 == 0) {
                    i6 = 3;
                    i8 = 138;
                    i7 = 0;
                } else if (s3 == s4) {
                    i8 = 6;
                    i7 = 0;
                    i6 = 3;
                } else {
                    i6 = 4;
                    i8 = 7;
                    i7 = 0;
                }
            } else {
                s3 = s2;
            }
            i5++;
            s2 = s3;
            s3 = s4;
        }
    }

    private void set_data_type() {
        int i = 0;
        int i2 = 0;
        while (i2 < 7) {
            i += this.dyn_ltree[i2 * 2];
            i2++;
        }
        int i3 = i2;
        int i4 = 0;
        while (i3 < 128) {
            i4 += this.dyn_ltree[i3 * 2];
            i3++;
        }
        while (i3 < END_BLOCK) {
            i += this.dyn_ltree[i3 * 2];
            i3++;
        }
        this.data_type = (byte) (i > (i4 >>> 2) ? 0 : 1);
    }

    private static boolean smaller(short[] sArr, int i, int i2, byte[] bArr) {
        short s = sArr[i * 2];
        short s2 = sArr[i2 * 2];
        return s < s2 || (s == s2 && bArr[i] <= bArr[i2]);
    }

    private void tr_init() {
        this.l_desc.dyn_tree = this.dyn_ltree;
        this.l_desc.stat_desc = StaticTree.static_l_desc;
        this.d_desc.dyn_tree = this.dyn_dtree;
        this.d_desc.stat_desc = StaticTree.static_d_desc;
        this.bl_desc.dyn_tree = this.bl_tree;
        this.bl_desc.stat_desc = StaticTree.static_bl_desc;
        this.bi_buf = (short) 0;
        this.bi_valid = 0;
        this.last_eob_len = 8;
        init_block();
    }

    int deflate(ZStream zStream, int i) {
        int iDeflate_slow;
        if (i > 4 || i < 0) {
            return -2;
        }
        if (zStream.next_out == null || ((zStream.next_in == null && zStream.avail_in != 0) || (this.status == FINISH_STATE && i != 4))) {
            zStream.msg = z_errmsg[4];
            return -2;
        }
        if (zStream.avail_out == 0) {
            zStream.msg = z_errmsg[7];
            return -5;
        }
        this.strm = zStream;
        int i2 = this.last_flush;
        this.last_flush = i;
        if (this.status == INIT_STATE) {
            switch (this.wrapperType) {
                case ZLIB:
                    int i3 = (((this.w_bits - 8) << 4) + 8) << 8;
                    int i4 = ((this.level - 1) & 255) >> 1;
                    if (i4 > 3) {
                        i4 = 3;
                    }
                    int i5 = i3 | (i4 << 6);
                    if (this.strstart != 0) {
                        i5 |= 32;
                    }
                    putShortMSB(i5 + (31 - (i5 % 31)));
                    if (this.strstart != 0) {
                        putShortMSB((int) (zStream.adler >>> 16));
                        putShortMSB((int) (zStream.adler & 65535));
                    }
                    zStream.adler = Adler32.adler32(0L, null, 0, 0);
                    break;
                case GZIP:
                    put_byte(AMSLibs.ENUM_VIP_AMS_ERROR_INVALID_OBJECT_DATA);
                    put_byte((byte) -117);
                    put_byte((byte) 8);
                    put_byte((byte) 0);
                    put_byte((byte) 0);
                    put_byte((byte) 0);
                    put_byte((byte) 0);
                    put_byte((byte) 0);
                    switch (config_table[this.level].func) {
                        case 1:
                            put_byte((byte) 4);
                            break;
                        case 2:
                            put_byte((byte) 2);
                            break;
                        default:
                            put_byte((byte) 0);
                            break;
                    }
                    put_byte((byte) -1);
                    zStream.crc32 = 0;
                    break;
            }
            this.status = BUSY_STATE;
        }
        if (this.pending != 0) {
            zStream.flush_pending();
            if (zStream.avail_out == 0) {
                this.last_flush = -1;
                return 0;
            }
        } else if (zStream.avail_in == 0 && i <= i2 && i != 4) {
            zStream.msg = z_errmsg[7];
            return -5;
        }
        if (this.status == FINISH_STATE && zStream.avail_in != 0) {
            zStream.msg = z_errmsg[7];
            return -5;
        }
        int i6 = zStream.next_in_index;
        try {
            if (zStream.avail_in != 0 || this.lookahead != 0 || (i != 0 && this.status != FINISH_STATE)) {
                switch (config_table[this.level].func) {
                    case 0:
                        iDeflate_slow = deflate_stored(i);
                        break;
                    case 1:
                        iDeflate_slow = deflate_fast(i);
                        break;
                    case 2:
                        iDeflate_slow = deflate_slow(i);
                        break;
                    default:
                        iDeflate_slow = -1;
                        break;
                }
                if (iDeflate_slow == 2 || iDeflate_slow == 3) {
                    this.status = FINISH_STATE;
                }
                if (iDeflate_slow == 0 || iDeflate_slow == 2) {
                    if (zStream.avail_out == 0) {
                        this.last_flush = -1;
                    }
                    return 0;
                }
                if (iDeflate_slow == 1) {
                    if (i == 1) {
                        _tr_align();
                    } else {
                        _tr_stored_block(0, 0, false);
                        if (i == 3) {
                            for (int i7 = 0; i7 < this.hash_size; i7++) {
                                this.head[i7] = 0;
                            }
                        }
                    }
                    zStream.flush_pending();
                    if (zStream.avail_out == 0) {
                        this.last_flush = -1;
                        return 0;
                    }
                }
            }
            if (i != 4) {
                return 0;
            }
            if (this.wrapperType == JZlib.WrapperType.NONE || this.wroteTrailer) {
                return 1;
            }
            switch (this.wrapperType) {
                case ZLIB:
                    putShortMSB((int) (zStream.adler >>> 16));
                    putShortMSB((int) (zStream.adler & 65535));
                    break;
                case GZIP:
                    put_byte((byte) (zStream.crc32 & 255));
                    put_byte((byte) ((zStream.crc32 >>> 8) & 255));
                    put_byte((byte) ((zStream.crc32 >>> 16) & 255));
                    put_byte((byte) ((zStream.crc32 >>> 24) & 255));
                    put_byte((byte) (this.gzipUncompressedBytes & 255));
                    put_byte((byte) ((this.gzipUncompressedBytes >>> 8) & 255));
                    put_byte((byte) ((this.gzipUncompressedBytes >>> 16) & 255));
                    put_byte((byte) ((this.gzipUncompressedBytes >>> 24) & 255));
                    break;
            }
            zStream.flush_pending();
            this.wroteTrailer = true;
            return this.pending != 0 ? 0 : 1;
        } finally {
            this.gzipUncompressedBytes = (zStream.next_in_index - i6) + this.gzipUncompressedBytes;
        }
    }

    int deflateEnd() {
        if (this.status != INIT_STATE && this.status != BUSY_STATE && this.status != FINISH_STATE) {
            return -2;
        }
        this.pending_buf = null;
        this.head = null;
        this.prev = null;
        this.window = null;
        return this.status == BUSY_STATE ? -3 : 0;
    }

    int deflateInit(ZStream zStream, int i, int i2, JZlib.WrapperType wrapperType) {
        return deflateInit2(zStream, i, 8, i2, 8, 0, wrapperType);
    }

    int deflateParams(ZStream zStream, int i, int i2) {
        int iDeflate = 0;
        int i3 = i == -1 ? 6 : i;
        if (i3 < 0 || i3 > 9 || i2 < 0 || i2 > 2) {
            return -2;
        }
        if (config_table[this.level].func != config_table[i3].func && zStream.total_in != 0) {
            iDeflate = zStream.deflate(1);
        }
        if (this.level != i3) {
            this.level = i3;
            this.max_lazy_match = config_table[this.level].max_lazy;
            this.good_match = config_table[this.level].good_length;
            this.nice_match = config_table[this.level].nice_length;
            this.max_chain_length = config_table[this.level].max_chain;
        }
        this.strategy = i2;
        return iDeflate;
    }

    int deflateSetDictionary(ZStream zStream, byte[] bArr, int i) {
        int i2;
        int i3;
        if (bArr == null || this.status != INIT_STATE) {
            return -2;
        }
        zStream.adler = Adler32.adler32(zStream.adler, bArr, 0, i);
        if (i < 3) {
            return 0;
        }
        if (i > this.w_size - MIN_LOOKAHEAD) {
            int i4 = this.w_size - MIN_LOOKAHEAD;
            i3 = i4;
            i2 = i - i4;
        } else {
            i2 = 0;
            i3 = i;
        }
        System.arraycopy(bArr, i2, this.window, 0, i3);
        this.strstart = i3;
        this.block_start = i3;
        this.ins_h = this.window[0] & 255;
        this.ins_h = ((this.ins_h << this.hash_shift) ^ (this.window[1] & 255)) & this.hash_mask;
        for (int i5 = 0; i5 <= i3 - 3; i5++) {
            this.ins_h = ((this.ins_h << this.hash_shift) ^ (this.window[(i5 + 3) - 1] & 255)) & this.hash_mask;
            this.prev[this.w_mask & i5] = this.head[this.ins_h];
            this.head[this.ins_h] = (short) i5;
        }
        return 0;
    }

    void pqdownheap(short[] sArr, int i) {
        int i2 = this.heap[i];
        int i3 = i << 1;
        int i4 = i;
        while (i3 <= this.heap_len) {
            if (i3 < this.heap_len && smaller(sArr, this.heap[i3 + 1], this.heap[i3], this.depth)) {
                i3++;
            }
            if (smaller(sArr, i2, this.heap[i3], this.depth)) {
                break;
            }
            this.heap[i4] = this.heap[i3];
            i4 = i3;
            i3 <<= 1;
        }
        this.heap[i4] = i2;
    }
}
