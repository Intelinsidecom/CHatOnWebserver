package com.p137vk.sdk.api.methods;

import com.p137vk.sdk.api.VKParameters;
import com.p137vk.sdk.api.VKRequest;
import com.p137vk.sdk.api.model.VKUsersArray;

/* loaded from: classes.dex */
public class VKApiFriends extends VKApiBase {
    public VKRequest get() {
        return get(null);
    }

    public VKRequest get(VKParameters vKParameters) {
        return prepareRequest("get", vKParameters, VKRequest.HttpMethod.GET, VKUsersArray.class);
    }
}
