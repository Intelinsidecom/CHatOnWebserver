package com.google.protobuf;

import com.google.protobuf.MessageLite;
import com.sec.amsoma.AMSLibs;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
public final class CodedInputStream {
    private static final int BUFFER_SIZE = 4096;
    private static final int DEFAULT_RECURSION_LIMIT = 64;
    private static final int DEFAULT_SIZE_LIMIT = 67108864;
    private final byte[] buffer;
    private int bufferPos;
    private int bufferSize;
    private int bufferSizeAfterLimit;
    private int currentLimit;
    private final InputStream input;
    private int lastTag;
    private int recursionDepth;
    private int recursionLimit;
    private int sizeLimit;
    private int totalBytesRetired;

    public static CodedInputStream newInstance(InputStream inputStream) {
        return new CodedInputStream(inputStream);
    }

    public static CodedInputStream newInstance(byte[] bArr) {
        return newInstance(bArr, 0, bArr.length);
    }

    public static CodedInputStream newInstance(byte[] bArr, int i, int i2) {
        CodedInputStream codedInputStream = new CodedInputStream(bArr, i, i2);
        try {
            codedInputStream.pushLimit(i2);
            return codedInputStream;
        } catch (InvalidProtocolBufferException e) {
            throw new IllegalArgumentException(e);
        }
    }

    public int readTag() throws InvalidProtocolBufferException {
        if (isAtEnd()) {
            this.lastTag = 0;
            return 0;
        }
        this.lastTag = readRawVarint32();
        if (WireFormat.getTagFieldNumber(this.lastTag) == 0) {
            throw InvalidProtocolBufferException.invalidTag();
        }
        return this.lastTag;
    }

    public void checkLastTagWas(int i) throws InvalidProtocolBufferException {
        if (this.lastTag != i) {
            throw InvalidProtocolBufferException.invalidEndTag();
        }
    }

    public boolean skipField(int i) throws InvalidProtocolBufferException {
        switch (WireFormat.getTagWireType(i)) {
            case 0:
                readInt32();
                return true;
            case 1:
                readRawLittleEndian64();
                return true;
            case 2:
                skipRawBytes(readRawVarint32());
                return true;
            case 3:
                skipMessage();
                checkLastTagWas(WireFormat.makeTag(WireFormat.getTagFieldNumber(i), 4));
                return true;
            case 4:
                return false;
            case 5:
                readRawLittleEndian32();
                return true;
            default:
                throw InvalidProtocolBufferException.invalidWireType();
        }
    }

    public void skipMessage() throws InvalidProtocolBufferException {
        int tag;
        do {
            tag = readTag();
            if (tag == 0) {
                return;
            }
        } while (skipField(tag));
    }

    public double readDouble() {
        return Double.longBitsToDouble(readRawLittleEndian64());
    }

    public float readFloat() {
        return Float.intBitsToFloat(readRawLittleEndian32());
    }

    public long readUInt64() {
        return readRawVarint64();
    }

    public long readInt64() {
        return readRawVarint64();
    }

    public int readInt32() {
        return readRawVarint32();
    }

    public long readFixed64() {
        return readRawLittleEndian64();
    }

    public int readFixed32() {
        return readRawLittleEndian32();
    }

    public boolean readBool() {
        return readRawVarint32() != 0;
    }

    public String readString() throws InvalidProtocolBufferException {
        int rawVarint32 = readRawVarint32();
        if (rawVarint32 > this.bufferSize - this.bufferPos || rawVarint32 <= 0) {
            return new String(readRawBytes(rawVarint32), "UTF-8");
        }
        String str = new String(this.buffer, this.bufferPos, rawVarint32, "UTF-8");
        this.bufferPos = rawVarint32 + this.bufferPos;
        return str;
    }

    public void readGroup(int i, MessageLite.Builder builder, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        if (this.recursionDepth >= this.recursionLimit) {
            throw InvalidProtocolBufferException.recursionLimitExceeded();
        }
        this.recursionDepth++;
        builder.mergeFrom(this, extensionRegistryLite);
        checkLastTagWas(WireFormat.makeTag(i, 4));
        this.recursionDepth--;
    }

    @Deprecated
    public void readUnknownGroup(int i, MessageLite.Builder builder) throws InvalidProtocolBufferException {
        readGroup(i, builder, null);
    }

    public void readMessage(MessageLite.Builder builder, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        int rawVarint32 = readRawVarint32();
        if (this.recursionDepth >= this.recursionLimit) {
            throw InvalidProtocolBufferException.recursionLimitExceeded();
        }
        int iPushLimit = pushLimit(rawVarint32);
        this.recursionDepth++;
        builder.mergeFrom(this, extensionRegistryLite);
        checkLastTagWas(0);
        this.recursionDepth--;
        popLimit(iPushLimit);
    }

    public ByteString readBytes() throws InvalidProtocolBufferException {
        int rawVarint32 = readRawVarint32();
        if (rawVarint32 == 0) {
            return ByteString.EMPTY;
        }
        if (rawVarint32 <= this.bufferSize - this.bufferPos && rawVarint32 > 0) {
            ByteString byteStringCopyFrom = ByteString.copyFrom(this.buffer, this.bufferPos, rawVarint32);
            this.bufferPos = rawVarint32 + this.bufferPos;
            return byteStringCopyFrom;
        }
        return ByteString.copyFrom(readRawBytes(rawVarint32));
    }

    public int readUInt32() {
        return readRawVarint32();
    }

    public int readEnum() {
        return readRawVarint32();
    }

    public int readSFixed32() {
        return readRawLittleEndian32();
    }

    public long readSFixed64() {
        return readRawLittleEndian64();
    }

    public int readSInt32() {
        return decodeZigZag32(readRawVarint32());
    }

    public long readSInt64() {
        return decodeZigZag64(readRawVarint64());
    }

    public int readRawVarint32() throws InvalidProtocolBufferException {
        byte rawByte = readRawByte();
        if (rawByte < 0) {
            int i = rawByte & 127;
            byte rawByte2 = readRawByte();
            if (rawByte2 >= 0) {
                return i | (rawByte2 << 7);
            }
            int i2 = i | ((rawByte2 & 127) << 7);
            byte rawByte3 = readRawByte();
            if (rawByte3 >= 0) {
                return i2 | (rawByte3 << AMSLibs.ENUM_VIP_AMS_ERROR_USERIMAGE_TRANSMIT_FULL);
            }
            int i3 = i2 | ((rawByte3 & 127) << 14);
            byte rawByte4 = readRawByte();
            if (rawByte4 >= 0) {
                return i3 | (rawByte4 << AMSLibs.ENUM_VIP_AMS_ERROR_DECODE_DATA);
            }
            int i4 = i3 | ((rawByte4 & 127) << 21);
            byte rawByte5 = readRawByte();
            int i5 = i4 | (rawByte5 << AMSLibs.ENUM_VIP_AMS_ERROR_OBJECT_START_SETTING);
            if (rawByte5 < 0) {
                for (int i6 = 0; i6 < 5; i6++) {
                    if (readRawByte() >= 0) {
                        return i5;
                    }
                }
                throw InvalidProtocolBufferException.malformedVarint();
            }
            return i5;
        }
        return rawByte;
    }

    static int readRawVarint32(InputStream inputStream) throws IOException {
        int i = inputStream.read();
        if (i == -1) {
            throw InvalidProtocolBufferException.truncatedMessage();
        }
        return readRawVarint32(i, inputStream);
    }

    public static int readRawVarint32(int i, InputStream inputStream) throws IOException {
        if ((i & 128) != 0) {
            i &= 127;
            int i2 = 7;
            while (true) {
                if (i2 < 32) {
                    int i3 = inputStream.read();
                    if (i3 == -1) {
                        throw InvalidProtocolBufferException.truncatedMessage();
                    }
                    i |= (i3 & 127) << i2;
                    if ((i3 & 128) == 0) {
                        break;
                    }
                    i2 += 7;
                } else {
                    while (i2 < 64) {
                        int i4 = inputStream.read();
                        if (i4 == -1) {
                            throw InvalidProtocolBufferException.truncatedMessage();
                        }
                        if ((i4 & 128) != 0) {
                            i2 += 7;
                        }
                    }
                    throw InvalidProtocolBufferException.malformedVarint();
                }
            }
        }
        return i;
    }

    public long readRawVarint64() throws InvalidProtocolBufferException {
        long j = 0;
        for (int i = 0; i < 64; i += 7) {
            j |= (r3 & 127) << i;
            if ((readRawByte() & 128) == 0) {
                return j;
            }
        }
        throw InvalidProtocolBufferException.malformedVarint();
    }

    public int readRawLittleEndian32() throws InvalidProtocolBufferException {
        return (readRawByte() & 255) | ((readRawByte() & 255) << 8) | ((readRawByte() & 255) << 16) | ((readRawByte() & 255) << 24);
    }

    public long readRawLittleEndian64() throws InvalidProtocolBufferException {
        return ((readRawByte() & 255) << 8) | (readRawByte() & 255) | ((readRawByte() & 255) << 16) | ((readRawByte() & 255) << 24) | ((readRawByte() & 255) << 32) | ((readRawByte() & 255) << 40) | ((readRawByte() & 255) << 48) | ((readRawByte() & 255) << 56);
    }

    public static int decodeZigZag32(int i) {
        return (i >>> 1) ^ (-(i & 1));
    }

    public static long decodeZigZag64(long j) {
        return (j >>> 1) ^ (-(1 & j));
    }

    private CodedInputStream(byte[] bArr, int i, int i2) {
        this.currentLimit = Integer.MAX_VALUE;
        this.recursionLimit = 64;
        this.sizeLimit = DEFAULT_SIZE_LIMIT;
        this.buffer = bArr;
        this.bufferSize = i + i2;
        this.bufferPos = i;
        this.totalBytesRetired = -i;
        this.input = null;
    }

    private CodedInputStream(InputStream inputStream) {
        this.currentLimit = Integer.MAX_VALUE;
        this.recursionLimit = 64;
        this.sizeLimit = DEFAULT_SIZE_LIMIT;
        this.buffer = new byte[4096];
        this.bufferSize = 0;
        this.bufferPos = 0;
        this.totalBytesRetired = 0;
        this.input = inputStream;
    }

    public int setRecursionLimit(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("Recursion limit cannot be negative: " + i);
        }
        int i2 = this.recursionLimit;
        this.recursionLimit = i;
        return i2;
    }

    public int setSizeLimit(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("Size limit cannot be negative: " + i);
        }
        int i2 = this.sizeLimit;
        this.sizeLimit = i;
        return i2;
    }

    public void resetSizeCounter() {
        this.totalBytesRetired = -this.bufferPos;
    }

    public int pushLimit(int i) throws InvalidProtocolBufferException {
        if (i < 0) {
            throw InvalidProtocolBufferException.negativeSize();
        }
        int i2 = this.totalBytesRetired + this.bufferPos + i;
        int i3 = this.currentLimit;
        if (i2 > i3) {
            throw InvalidProtocolBufferException.truncatedMessage();
        }
        this.currentLimit = i2;
        recomputeBufferSizeAfterLimit();
        return i3;
    }

    private void recomputeBufferSizeAfterLimit() {
        this.bufferSize += this.bufferSizeAfterLimit;
        int i = this.totalBytesRetired + this.bufferSize;
        if (i > this.currentLimit) {
            this.bufferSizeAfterLimit = i - this.currentLimit;
            this.bufferSize -= this.bufferSizeAfterLimit;
        } else {
            this.bufferSizeAfterLimit = 0;
        }
    }

    public void popLimit(int i) {
        this.currentLimit = i;
        recomputeBufferSizeAfterLimit();
    }

    public int getBytesUntilLimit() {
        if (this.currentLimit == Integer.MAX_VALUE) {
            return -1;
        }
        return this.currentLimit - (this.totalBytesRetired + this.bufferPos);
    }

    public boolean isAtEnd() {
        return this.bufferPos == this.bufferSize && !refillBuffer(false);
    }

    public int getTotalBytesRead() {
        return this.totalBytesRetired + this.bufferPos;
    }

    private boolean refillBuffer(boolean z) throws InvalidProtocolBufferException {
        if (this.bufferPos < this.bufferSize) {
            throw new IllegalStateException("refillBuffer() called when buffer wasn't empty.");
        }
        if (this.totalBytesRetired + this.bufferSize == this.currentLimit) {
            if (z) {
                throw InvalidProtocolBufferException.truncatedMessage();
            }
            return false;
        }
        this.totalBytesRetired += this.bufferSize;
        this.bufferPos = 0;
        this.bufferSize = this.input == null ? -1 : this.input.read(this.buffer);
        if (this.bufferSize == 0 || this.bufferSize < -1) {
            throw new IllegalStateException("InputStream#read(byte[]) returned invalid result: " + this.bufferSize + "\nThe InputStream implementation is buggy.");
        }
        if (this.bufferSize == -1) {
            this.bufferSize = 0;
            if (z) {
                throw InvalidProtocolBufferException.truncatedMessage();
            }
            return false;
        }
        recomputeBufferSizeAfterLimit();
        int i = this.totalBytesRetired + this.bufferSize + this.bufferSizeAfterLimit;
        if (i > this.sizeLimit || i < 0) {
            throw InvalidProtocolBufferException.sizeLimitExceeded();
        }
        return true;
    }

    public byte readRawByte() throws InvalidProtocolBufferException {
        if (this.bufferPos == this.bufferSize) {
            refillBuffer(true);
        }
        byte[] bArr = this.buffer;
        int i = this.bufferPos;
        this.bufferPos = i + 1;
        return bArr[i];
    }

    public byte[] readRawBytes(int i) throws InvalidProtocolBufferException {
        if (i < 0) {
            throw InvalidProtocolBufferException.negativeSize();
        }
        if (this.totalBytesRetired + this.bufferPos + i > this.currentLimit) {
            skipRawBytes((this.currentLimit - this.totalBytesRetired) - this.bufferPos);
            throw InvalidProtocolBufferException.truncatedMessage();
        }
        if (i <= this.bufferSize - this.bufferPos) {
            byte[] bArr = new byte[i];
            System.arraycopy(this.buffer, this.bufferPos, bArr, 0, i);
            this.bufferPos += i;
            return bArr;
        }
        if (i < 4096) {
            byte[] bArr2 = new byte[i];
            int i2 = this.bufferSize - this.bufferPos;
            System.arraycopy(this.buffer, this.bufferPos, bArr2, 0, i2);
            this.bufferPos = this.bufferSize;
            refillBuffer(true);
            while (i - i2 > this.bufferSize) {
                System.arraycopy(this.buffer, 0, bArr2, i2, this.bufferSize);
                i2 += this.bufferSize;
                this.bufferPos = this.bufferSize;
                refillBuffer(true);
            }
            System.arraycopy(this.buffer, 0, bArr2, i2, i - i2);
            this.bufferPos = i - i2;
            return bArr2;
        }
        int i3 = this.bufferPos;
        int i4 = this.bufferSize;
        this.totalBytesRetired += this.bufferSize;
        this.bufferPos = 0;
        this.bufferSize = 0;
        ArrayList arrayList = new ArrayList();
        int i5 = i - (i4 - i3);
        while (i5 > 0) {
            byte[] bArr3 = new byte[Math.min(i5, 4096)];
            int i6 = 0;
            while (i6 < bArr3.length) {
                int i7 = this.input == null ? -1 : this.input.read(bArr3, i6, bArr3.length - i6);
                if (i7 == -1) {
                    throw InvalidProtocolBufferException.truncatedMessage();
                }
                this.totalBytesRetired += i7;
                i6 += i7;
            }
            int length = i5 - bArr3.length;
            arrayList.add(bArr3);
            i5 = length;
        }
        byte[] bArr4 = new byte[i];
        int length2 = i4 - i3;
        System.arraycopy(this.buffer, i3, bArr4, 0, length2);
        Iterator it = arrayList.iterator();
        while (true) {
            int i8 = length2;
            if (!it.hasNext()) {
                return bArr4;
            }
            byte[] bArr5 = (byte[]) it.next();
            System.arraycopy(bArr5, 0, bArr4, i8, bArr5.length);
            length2 = bArr5.length + i8;
        }
    }

    public void skipRawBytes(int i) throws InvalidProtocolBufferException {
        if (i < 0) {
            throw InvalidProtocolBufferException.negativeSize();
        }
        if (this.totalBytesRetired + this.bufferPos + i > this.currentLimit) {
            skipRawBytes((this.currentLimit - this.totalBytesRetired) - this.bufferPos);
            throw InvalidProtocolBufferException.truncatedMessage();
        }
        if (i <= this.bufferSize - this.bufferPos) {
            this.bufferPos += i;
            return;
        }
        int i2 = this.bufferSize - this.bufferPos;
        this.bufferPos = this.bufferSize;
        refillBuffer(true);
        while (i - i2 > this.bufferSize) {
            i2 += this.bufferSize;
            this.bufferPos = this.bufferSize;
            refillBuffer(true);
        }
        this.bufferPos = i - i2;
    }
}
