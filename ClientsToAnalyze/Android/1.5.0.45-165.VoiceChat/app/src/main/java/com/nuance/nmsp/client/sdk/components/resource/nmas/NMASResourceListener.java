package com.nuance.nmsp.client.sdk.components.resource.nmas;

import com.nuance.nmsp.client.sdk.components.resource.common.ResourceListener;

/* loaded from: classes.dex */
public interface NMASResourceListener extends ResourceListener {
    void PDXCommandCreated(String str);

    void PDXCreateCommandFailed();
}
