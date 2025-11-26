package com.nuance.nmsp.client.sdk.components.resource.internal.nmas;

import com.nuance.nmsp.client.sdk.common.oem.api.LogFactory;
import com.nuance.nmsp.client.sdk.components.resource.nmas.QueryResult;

/* loaded from: classes.dex */
public class PDXQueryResult extends PDXMessage implements QueryResult {

    /* renamed from: a */
    private static final LogFactory.Log f179a = LogFactory.getLog(PDXQueryResult.class);

    /* renamed from: b */
    private final byte[] f180b;

    public PDXQueryResult(byte[] bArr) {
        super((short) 29185, bArr);
        this.f180b = bArr;
    }

    @Override // com.nuance.nmsp.client.sdk.components.resource.nmas.QueryResult
    public byte[] getRawInput() {
        return this.f180b;
    }

    @Override // com.nuance.nmsp.client.sdk.components.resource.nmas.QueryResult
    public String getResultType() {
        f179a.debug("PDXQueryResult.getResultType()");
        String uTF8String = getUTF8String("result_type");
        return uTF8String != null ? uTF8String : "";
    }

    @Override // com.nuance.nmsp.client.sdk.components.resource.nmas.QueryResult
    public boolean isFinalResponse() {
        boolean z = true;
        try {
            if (containsKey("final_response")) {
                if (getInteger("final_response") == 0) {
                    z = false;
                }
            } else if (f179a.isInfoEnabled()) {
                f179a.info("final_response does not exist. ");
            }
        } catch (Exception e) {
        }
        return z;
    }
}
