package com.p137vk.sdk.api.httpClient;

import com.p137vk.sdk.api.model.VKApiModel;
import org.apache.http.client.methods.HttpUriRequest;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class VKModelOperation extends VKJsonOperation {
    protected Class<? extends VKApiModel> mModelClass;
    public VKApiModel parsedModel;

    public VKModelOperation(HttpUriRequest httpUriRequest, Class<? extends VKApiModel> cls) {
        super(httpUriRequest);
        this.mModelClass = cls;
    }

    @Override // com.p137vk.sdk.api.httpClient.VKJsonOperation, com.p137vk.sdk.api.httpClient.VKHttpOperation
    protected boolean postExecution() throws IllegalAccessException, InstantiationException {
        if (!super.postExecution()) {
            return false;
        }
        if (this.mModelClass != null) {
            try {
                JSONObject responseJson = getResponseJson();
                VKApiModel vKApiModelNewInstance = this.mModelClass.newInstance();
                vKApiModelNewInstance.parse(responseJson);
                this.parsedModel = vKApiModelNewInstance;
                return true;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }
}
