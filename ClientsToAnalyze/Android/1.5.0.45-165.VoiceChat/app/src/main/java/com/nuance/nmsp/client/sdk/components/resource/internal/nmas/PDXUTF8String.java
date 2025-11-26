package com.nuance.nmsp.client.sdk.components.resource.internal.nmas;

import com.nuance.nmsp.client.sdk.common.oem.api.LogFactory;
import com.nuance.nmsp.client.sdk.components.resource.nmas.NMASResource;

/* loaded from: classes.dex */
public class PDXUTF8String extends PDXClass {

    /* renamed from: a */
    private static final LogFactory.Log f207a = LogFactory.getLog(PDXUTF8String.class);

    /* renamed from: b */
    private String f208b;

    public PDXUTF8String(String str) {
        super(NMASResource.PDX_DATA_TYPE_UTF8);
        this.f208b = str;
    }

    public PDXUTF8String(byte[] bArr) {
        super(NMASResource.PDX_DATA_TYPE_UTF8);
        try {
            this.f208b = new String(bArr, "UTF-8");
        } catch (Exception e) {
            f207a.error("PDXUTF8String() " + e.getMessage());
            this.f208b = new String(bArr);
        }
    }

    public String getValue() {
        return this.f208b;
    }

    public byte[] toByteArray() {
        try {
            return super.toByteArray(this.f208b.getBytes("UTF-8"));
        } catch (Exception e) {
            f207a.error("PDXUTF8String().toByteArray() " + e.getMessage());
            return super.toByteArray(this.f208b.getBytes());
        }
    }
}
