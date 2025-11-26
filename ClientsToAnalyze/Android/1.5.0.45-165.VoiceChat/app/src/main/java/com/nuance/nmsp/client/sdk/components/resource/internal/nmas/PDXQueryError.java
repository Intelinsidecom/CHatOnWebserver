package com.nuance.nmsp.client.sdk.components.resource.internal.nmas;

import com.google.android.gcm.GCMConstants;
import com.nuance.nmsp.client.sdk.common.oem.api.LogFactory;
import com.nuance.nmsp.client.sdk.components.resource.nmas.QueryError;

/* loaded from: classes.dex */
public class PDXQueryError extends PDXMessage implements QueryError {

    /* renamed from: a */
    private static final LogFactory.Log f177a = LogFactory.getLog(PDXQueryError.class);

    public PDXQueryError(byte[] bArr) {
        super((short) 29186, bArr);
    }

    @Override // com.nuance.nmsp.client.sdk.components.resource.nmas.QueryError
    public String getDescription() {
        f177a.debug("PDXQueryError.getDescription()");
        String uTF8String = getUTF8String("description");
        return uTF8String != null ? uTF8String : "";
    }

    @Override // com.nuance.nmsp.client.sdk.components.resource.nmas.QueryError
    public int getError() {
        f177a.debug("PDXQueryError.getError()");
        return getInteger(GCMConstants.EXTRA_ERROR);
    }

    @Override // com.nuance.nmsp.client.sdk.components.resource.nmas.QueryError
    public String getParameter() {
        f177a.debug("PDXQueryError.getParameter()");
        String uTF8String = getUTF8String("parameter");
        return uTF8String != null ? uTF8String : "";
    }
}
