package com.nuance.nmsp.client.sdk.components.resource.internal.nmas;

import com.nuance.nmsp.client.sdk.components.resource.nmas.Parameter;

/* loaded from: classes.dex */
public class PDXTextParam extends PDXParam implements Parameter {

    /* renamed from: a */
    private String f188a;

    public PDXTextParam(String str, String str2) {
        super(str, (byte) 2);
        this.f188a = str2;
    }

    protected String getText() {
        return this.f188a;
    }
}
