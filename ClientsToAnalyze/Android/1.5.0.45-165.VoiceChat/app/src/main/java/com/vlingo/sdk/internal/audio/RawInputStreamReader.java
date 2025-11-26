package com.vlingo.sdk.internal.audio;

import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes.dex */
public class RawInputStreamReader {
    byte[] mInputBuffer;
    int mInputBufferOffset = 0;
    InputStream mInputStream;
    boolean mIsBEInputStream;

    public RawInputStreamReader(InputStream is, boolean isBigEndian, int maxReadLength) {
        this.mInputStream = is;
        this.mIsBEInputStream = isBigEndian;
        this.mInputBuffer = new byte[maxReadLength * 2];
    }

    public int read(short[] data, int offset, int length) throws IOException {
        int lo;
        int hi;
        int bytesToRead = length * 2;
        if (bytesToRead > this.mInputBuffer.length) {
            bytesToRead = this.mInputBuffer.length;
        }
        int bytesRead = this.mInputStream.read(this.mInputBuffer, this.mInputBufferOffset, bytesToRead - this.mInputBufferOffset);
        if (bytesRead == -1) {
            return -1;
        }
        int bytesInBuffer = bytesRead + this.mInputBufferOffset;
        int shortBytesInBuffer = bytesInBuffer - (bytesInBuffer % 2);
        boolean carryOverLastByte = shortBytesInBuffer != bytesInBuffer;
        for (int i = 0; i < shortBytesInBuffer; i += 2) {
            if (this.mIsBEInputStream) {
                hi = this.mInputBuffer[i] & 255;
                lo = this.mInputBuffer[i + 1] & 255;
            } else {
                lo = this.mInputBuffer[i] & 255;
                hi = this.mInputBuffer[i + 1] & 255;
            }
            data[offset] = (short) ((hi << 8) | lo);
            offset++;
        }
        if (carryOverLastByte) {
            this.mInputBuffer[0] = this.mInputBuffer[bytesInBuffer - 1];
            this.mInputBufferOffset = 1;
        } else {
            this.mInputBufferOffset = 0;
        }
        return shortBytesInBuffer / 2;
    }
}
