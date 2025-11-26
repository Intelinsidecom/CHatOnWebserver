package com.nuance.nmsp.client.sdk.components.resource.internal.nmas;

import com.nuance.nmsp.client.sdk.common.oem.api.LogFactory;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/* loaded from: classes.dex */
public class PDXMessage extends PDXDictionary {
    protected static final short EnrollementSegment = 1024;
    protected static final short EnrollmentAudio = 1026;
    protected static final short QueryBegin = 514;
    protected static final short QueryEnd = 516;
    protected static final short QueryError = 29186;
    protected static final short QueryParameter = 515;
    protected static final short QueryResult = 29185;
    protected static final short QueryRetry = 29189;

    /* renamed from: a */
    private static final LogFactory.Log f170a = LogFactory.getLog(PDXMessage.class);

    /* renamed from: b */
    private short f171b;

    public PDXMessage(short s) {
        this.f171b = s;
    }

    public PDXMessage(short s, byte[] bArr) {
        super(bArr, true);
        this.f171b = s;
    }

    public short getCommandCode() {
        return this.f171b;
    }

    public byte[] getMessage() {
        return super.toByteArray();
    }

    @Override // com.nuance.nmsp.client.sdk.components.resource.internal.nmas.PDXDictionary
    public byte[] toByteArray() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byteArrayOutputStream.write(this.f171b & 255);
        byteArrayOutputStream.write((this.f171b >> 8) & 255);
        try {
            byteArrayOutputStream.write(super.toByteArray());
        } catch (IOException e) {
            f170a.error("PDXMessage.toByteArray() " + e.toString() + ". ");
        }
        return byteArrayOutputStream.toByteArray();
    }
}
