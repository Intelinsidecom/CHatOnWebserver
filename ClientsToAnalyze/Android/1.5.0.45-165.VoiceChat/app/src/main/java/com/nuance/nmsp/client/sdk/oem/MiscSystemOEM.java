package com.nuance.nmsp.client.sdk.oem;

import com.nuance.nmsp.client.sdk.common.oem.api.MiscSystem;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: classes.dex */
public class MiscSystemOEM extends MiscSystem {
    @Override // com.nuance.nmsp.client.sdk.common.oem.api.MiscSystem
    protected byte[] HMAC_SHA1_impl(byte[] bArr, byte[] bArr2) throws NoSuchAlgorithmException, InvalidKeyException {
        if (bArr == null || bArr2 == null) {
            return new byte[0];
        }
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, "HmacSHA1");
            Mac mac = Mac.getInstance("HmacSHA1");
            mac.init(secretKeySpec);
            return mac.doFinal(bArr2);
        } catch (Exception e) {
            return new byte[0];
        }
    }
}
