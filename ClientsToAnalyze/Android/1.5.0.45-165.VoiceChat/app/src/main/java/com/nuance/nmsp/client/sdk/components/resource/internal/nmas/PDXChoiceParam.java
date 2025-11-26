package com.nuance.nmsp.client.sdk.components.resource.internal.nmas;

import com.nuance.nmsp.client.sdk.components.resource.nmas.Parameter;

/* loaded from: classes.dex */
public class PDXChoiceParam extends PDXParam implements Parameter {

    /* renamed from: a */
    private String f163a;

    public PDXChoiceParam(String str, String str2) {
        super(str, (byte) 3);
        this.f163a = str2;
    }

    protected String getChoicename() {
        return this.f163a;
    }
}
