package com.p137vk.sdk.api.methods;

import com.p137vk.sdk.api.VKParameters;
import com.p137vk.sdk.api.VKRequest;
import com.p137vk.sdk.api.model.VKApiModel;
import java.util.Locale;

/* loaded from: classes.dex */
class VKApiBase {
    private String mMethodGroup;

    VKApiBase() {
        String simpleName = getClass().getSimpleName();
        if (simpleName == null) {
            throw new ClassCastException("Enclosing classes denied");
        }
        this.mMethodGroup = simpleName.substring("VKApi".length()).toLowerCase();
    }

    VKRequest prepareRequest(String str, VKParameters vKParameters) {
        return prepareRequest(str, vKParameters, VKRequest.HttpMethod.GET, null);
    }

    VKRequest prepareRequest(String str, VKParameters vKParameters, VKRequest.HttpMethod httpMethod) {
        return prepareRequest(str, vKParameters, httpMethod, null);
    }

    VKRequest prepareRequest(String str, VKParameters vKParameters, VKRequest.HttpMethod httpMethod, Class<? extends VKApiModel> cls) {
        return new VKRequest(String.format(Locale.getDefault(), "%s.%s", this.mMethodGroup, str), vKParameters, httpMethod, cls);
    }
}
