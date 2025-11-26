package com.p137vk.sdk.api.methods;

import com.p137vk.sdk.api.VKParameters;
import com.p137vk.sdk.api.VKRequest;

/* loaded from: classes.dex */
public class VKApiWall extends VKApiBase {
    public VKRequest post(VKParameters vKParameters) {
        return prepareRequest("post", vKParameters, VKRequest.HttpMethod.POST);
    }
}
