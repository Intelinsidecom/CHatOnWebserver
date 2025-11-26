package com.nuance.nmsp.client.sdk.components.resource.internal.nmas;

import com.nuance.nmsp.client.sdk.common.oem.api.LogFactory;
import com.nuance.nmsp.client.sdk.components.resource.nmas.QueryRetry;
import com.sec.chaton.clientapi.GraphAPI;

/* loaded from: classes.dex */
public class PDXQueryRetry extends PDXMessage implements QueryRetry {

    /* renamed from: a */
    private static final LogFactory.Log f181a = LogFactory.getLog(PDXQueryRetry.class);

    public PDXQueryRetry(byte[] bArr) {
        super((short) 29189, bArr);
    }

    @Override // com.nuance.nmsp.client.sdk.components.resource.nmas.QueryRetry
    public int getCause() {
        f181a.debug("PDXQueryRetry.getCause()");
        try {
            return getInteger("cause");
        } catch (Exception e) {
            return 0;
        }
    }

    @Override // com.nuance.nmsp.client.sdk.components.resource.nmas.QueryRetry
    public String getName() {
        f181a.debug("PDXQueryRetry.getName()");
        String uTF8String = getUTF8String(GraphAPI.ME_NAME);
        return uTF8String != null ? uTF8String : "";
    }

    @Override // com.nuance.nmsp.client.sdk.components.resource.nmas.QueryRetry
    public String getPrompt() {
        String uTF8String;
        f181a.debug("PDXQueryRetry.getPrompt()");
        try {
            uTF8String = getUTF8String("prompt");
        } catch (Exception e) {
            uTF8String = "";
        }
        return uTF8String != null ? uTF8String : "";
    }
}
