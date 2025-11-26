package com.nuance.nmsp.client.sdk.components.resource.internal.nmas;

import com.nuance.nmsp.client.sdk.common.oem.api.LogFactory;

/* loaded from: classes.dex */
public class PDXQueryEnd extends PDXMessage {

    /* renamed from: a */
    private static final LogFactory.Log f176a = LogFactory.getLog(PDXQueryEnd.class);

    public PDXQueryEnd() {
        super((short) 516);
        if (f176a.isDebugEnabled()) {
            f176a.debug("PDXQueryEnd()");
        }
    }
}
