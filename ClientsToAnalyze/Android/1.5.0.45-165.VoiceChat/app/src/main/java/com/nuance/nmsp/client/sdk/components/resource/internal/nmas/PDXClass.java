package com.nuance.nmsp.client.sdk.components.resource.internal.nmas;

import com.samsung.spen.lib.image.SPenImageFilterConstants;
import java.io.ByteArrayOutputStream;

/* loaded from: classes.dex */
public class PDXClass {
    protected static final short ASCII = 22;
    protected static final short BYTES = 4;
    protected static final short DICT = 224;
    protected static final short INT = 192;
    protected static final short NULL = 5;
    protected static final short SEQ = 16;
    protected static final short UTF8 = 193;

    /* renamed from: a */
    private short f164a;

    public PDXClass(short s) {
        this.f164a = s;
    }

    public int getLength(byte[] bArr, int i) {
        int i2 = bArr[i] & 255;
        return i2 == 129 ? bArr[i + 1] & 255 : i2 == 130 ? ((bArr[i + 1] & 255) << 8) + (bArr[i + 2] & 255) : i2 == 132 ? ((bArr[i + 1] & 255) << 24) + ((bArr[i + 2] & 255) << 16) + ((bArr[i + 3] & 255) << 8) + (bArr[i + 4] & 255) : i2;
    }

    public int getLengthSize(int i) {
        if (i <= 127) {
            return 1;
        }
        if (i <= 255) {
            return 2;
        }
        return i <= 65535 ? 3 : 5;
    }

    public short getType() {
        return this.f164a;
    }

    public byte[] toByteArray(byte[] bArr) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byteArrayOutputStream.write(this.f164a & 255);
        if (bArr.length > 65535) {
            byteArrayOutputStream.write(SPenImageFilterConstants.FILTER_MAGICPEN);
            byteArrayOutputStream.write(bArr.length >>> 24);
            byteArrayOutputStream.write((bArr.length >> 16) & 255);
            byteArrayOutputStream.write((bArr.length >> 8) & 255);
            byteArrayOutputStream.write(bArr.length & 255);
        } else if (bArr.length > 255) {
            byteArrayOutputStream.write(SPenImageFilterConstants.FILTER_MOSAIC);
            byteArrayOutputStream.write((bArr.length >> 8) & 255);
            byteArrayOutputStream.write(bArr.length & 255);
        } else if (bArr.length > 127) {
            byteArrayOutputStream.write(129);
            byteArrayOutputStream.write(bArr.length);
        } else if (bArr.length >= 0) {
            byteArrayOutputStream.write(bArr.length);
        }
        byteArrayOutputStream.write(bArr, 0, bArr.length);
        return byteArrayOutputStream.toByteArray();
    }
}
