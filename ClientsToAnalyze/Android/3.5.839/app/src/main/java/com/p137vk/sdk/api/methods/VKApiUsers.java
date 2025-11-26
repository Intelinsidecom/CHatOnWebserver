package com.p137vk.sdk.api.methods;

import com.p137vk.sdk.api.VKParameters;
import com.p137vk.sdk.api.VKRequest;
import com.p137vk.sdk.api.model.VKUsersArray;

/* loaded from: classes.dex */
public class VKApiUsers extends VKApiBase {
    public VKRequest get() {
        return get(null);
    }

    public VKRequest get(VKParameters vKParameters) {
        return prepareRequest("get", vKParameters, VKRequest.HttpMethod.GET, VKUsersArray.class);
    }

    public VKRequest search(VKParameters vKParameters) {
        return prepareRequest("search", vKParameters, VKRequest.HttpMethod.GET, VKUsersArray.class);
    }

    public VKRequest isAppUser() {
        return prepareRequest("isAppUser", null);
    }

    public VKRequest isAppUser(final int i) {
        return prepareRequest("isAppUser", new VKParameters() { // from class: com.vk.sdk.api.methods.VKApiUsers.1
            private static final long serialVersionUID = 7458591447441581671L;

            {
                put("user_id", String.valueOf(i));
            }
        });
    }

    public VKRequest getSubscriptions() {
        return getSubscriptions(null);
    }

    public VKRequest getSubscriptions(VKParameters vKParameters) {
        return prepareRequest("getSubscriptions", vKParameters);
    }

    public VKRequest getFollowers() {
        return getFollowers(null);
    }

    public VKRequest getFollowers(VKParameters vKParameters) {
        return prepareRequest("getFollowers", vKParameters);
    }
}
