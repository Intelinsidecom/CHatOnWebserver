package org.jboss.netty.channel;

import java.util.ArrayList;

/* loaded from: classes.dex */
public class AdaptiveReceiveBufferSizePredictor implements ReceiveBufferSizePredictor {
    static final int DEFAULT_INITIAL = 1024;
    static final int DEFAULT_MAXIMUM = 65536;
    static final int DEFAULT_MINIMUM = 64;
    private static final int INDEX_DECREMENT = 1;
    private static final int INDEX_INCREMENT = 4;
    private static final int[] SIZE_TABLE;
    private boolean decreaseNow;
    private int index;
    private final int maxIndex;
    private final int minIndex;
    private int nextReceiveBufferSize;

    static {
        ArrayList arrayList = new ArrayList();
        for (int i = 1; i <= 8; i++) {
            arrayList.add(Integer.valueOf(i));
        }
        for (int i2 = 4; i2 < 32; i2++) {
            long j = 1 << i2;
            long j2 = j >>> 4;
            long j3 = j - (j2 << 3);
            for (int i3 = 0; i3 < 8; i3++) {
                j3 += j2;
                if (j3 > 2147483647L) {
                    arrayList.add(Integer.MAX_VALUE);
                } else {
                    arrayList.add(Integer.valueOf((int) j3));
                }
            }
        }
        SIZE_TABLE = new int[arrayList.size()];
        for (int i4 = 0; i4 < SIZE_TABLE.length; i4++) {
            SIZE_TABLE[i4] = ((Integer) arrayList.get(i4)).intValue();
        }
    }

    public AdaptiveReceiveBufferSizePredictor() {
        this(DEFAULT_MINIMUM, DEFAULT_INITIAL, DEFAULT_MAXIMUM);
    }

    public AdaptiveReceiveBufferSizePredictor(int i, int i2, int i3) {
        if (i <= 0) {
            throw new IllegalArgumentException("minimum: " + i);
        }
        if (i2 < i) {
            throw new IllegalArgumentException("initial: " + i2);
        }
        if (i3 < i2) {
            throw new IllegalArgumentException("maximum: " + i3);
        }
        int sizeTableIndex = getSizeTableIndex(i);
        if (SIZE_TABLE[sizeTableIndex] < i) {
            this.minIndex = sizeTableIndex + 1;
        } else {
            this.minIndex = sizeTableIndex;
        }
        int sizeTableIndex2 = getSizeTableIndex(i3);
        if (SIZE_TABLE[sizeTableIndex2] > i3) {
            this.maxIndex = sizeTableIndex2 - 1;
        } else {
            this.maxIndex = sizeTableIndex2;
        }
        this.index = getSizeTableIndex(i2);
        this.nextReceiveBufferSize = SIZE_TABLE[this.index];
    }

    private static int getSizeTableIndex(int i) {
        if (i <= 16) {
            return i - 1;
        }
        int i2 = 0;
        int i3 = i;
        do {
            i3 >>>= 1;
            i2++;
        } while (i3 != 0);
        int i4 = i2 << 3;
        int i5 = i4 - 25;
        for (int i6 = i4 - 18; i6 >= i5; i6--) {
            if (i >= SIZE_TABLE[i6]) {
                return i6;
            }
        }
        throw new Error("shouldn't reach here; please file a bug report.");
    }

    @Override // org.jboss.netty.channel.ReceiveBufferSizePredictor
    public int nextReceiveBufferSize() {
        return this.nextReceiveBufferSize;
    }

    @Override // org.jboss.netty.channel.ReceiveBufferSizePredictor
    public void previousReceiveBufferSize(int i) {
        if (i > SIZE_TABLE[Math.max(0, (this.index - 1) - 1)]) {
            if (i >= this.nextReceiveBufferSize) {
                this.index = Math.min(this.index + 4, this.maxIndex);
                this.nextReceiveBufferSize = SIZE_TABLE[this.index];
                this.decreaseNow = false;
                return;
            }
            return;
        }
        if (!this.decreaseNow) {
            this.decreaseNow = true;
            return;
        }
        this.index = Math.max(this.index - 1, this.minIndex);
        this.nextReceiveBufferSize = SIZE_TABLE[this.index];
        this.decreaseNow = false;
    }
}
