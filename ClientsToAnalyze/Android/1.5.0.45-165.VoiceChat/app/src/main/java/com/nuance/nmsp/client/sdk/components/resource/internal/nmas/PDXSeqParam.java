package com.nuance.nmsp.client.sdk.components.resource.internal.nmas;

import com.nuance.nmsp.client.sdk.components.resource.nmas.Parameter;

/* loaded from: classes.dex */
public class PDXSeqParam extends PDXParam implements Parameter {
    public static final byte SEQ_CHUNK = 2;
    public static final byte SEQ_START = 1;
    public static final byte SEQ__END = 3;

    /* renamed from: a */
    private PDXDictionary f182a;

    public PDXSeqParam(String str, PDXDictionary pDXDictionary, byte b) {
        super(str);
        if (b == 1) {
            super.setType((byte) 6);
        } else if (b == 2) {
            super.setType((byte) 7);
        } else {
            super.setType((byte) 8);
        }
        this.f182a = pDXDictionary;
    }

    protected byte[] getContent() {
        return this.f182a.getContent();
    }
}
