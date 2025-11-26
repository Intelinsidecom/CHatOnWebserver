package com.nuance.nmsp.client.sdk.components.resource.internal.nmas;

import com.nuance.nmsp.client.sdk.components.resource.nmas.Parameter;

/* loaded from: classes.dex */
public class PDXDictParam extends PDXParam implements Parameter {

    /* renamed from: a */
    private PDXDictionary f166a;

    public PDXDictParam(String str, PDXDictionary pDXDictionary) {
        super(str, (byte) 5);
        this.f166a = pDXDictionary;
    }

    protected byte[] getContent() {
        return this.f166a.getContent();
    }
}
