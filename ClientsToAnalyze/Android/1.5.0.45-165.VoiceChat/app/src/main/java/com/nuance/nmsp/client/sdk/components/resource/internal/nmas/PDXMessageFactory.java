package com.nuance.nmsp.client.sdk.components.resource.internal.nmas;

import com.nuance.nmsp.client.sdk.common.oem.api.LogFactory;

/* loaded from: classes.dex */
public class PDXMessageFactory {

    /* renamed from: a */
    private static final LogFactory.Log f172a = LogFactory.getLog(PDXMessageFactory.class);

    public static PDXMessage createMessage(byte[] bArr) {
        short s = (short) (((bArr[1] & 255) << 8) + (bArr[0] & 255));
        byte[] bArr2 = new byte[bArr.length - 2];
        System.arraycopy(bArr, 2, bArr2, 0, bArr2.length);
        switch (s) {
            case 29185:
                return new PDXQueryResult(bArr2);
            case 29186:
                return new PDXQueryError(bArr2);
            case 29187:
            case 29188:
            default:
                f172a.error("PDXMessageFactory.createMessage() Unknown command: " + ((int) s) + ". ");
                return null;
            case 29189:
                return new PDXQueryRetry(bArr2);
        }
    }
}
