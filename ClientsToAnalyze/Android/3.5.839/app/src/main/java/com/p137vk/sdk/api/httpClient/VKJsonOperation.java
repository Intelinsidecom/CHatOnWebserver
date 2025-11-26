package com.p137vk.sdk.api.httpClient;

import com.p137vk.sdk.api.VKError;
import com.p137vk.sdk.api.httpClient.VKAbstractOperation;
import com.p137vk.sdk.api.httpClient.VKHttpOperation;
import org.apache.http.client.methods.HttpUriRequest;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class VKJsonOperation extends VKHttpOperation {
    private JSONObject mResponseJson;

    public VKJsonOperation(HttpUriRequest httpUriRequest) {
        super(httpUriRequest);
    }

    public JSONObject getResponseJson() {
        if (this.mResponseJson == null) {
            String responseString = getResponseString();
            if (responseString == null) {
                return null;
            }
            try {
                this.mResponseJson = new JSONObject(responseString);
            } catch (Exception e) {
                this.mLastException = e;
            }
        }
        return this.mResponseJson;
    }

    @Override // com.p137vk.sdk.api.httpClient.VKHttpOperation
    protected boolean postExecution() {
        if (!super.postExecution()) {
            return false;
        }
        this.mResponseJson = getResponseJson();
        return true;
    }

    @Override // com.p137vk.sdk.api.httpClient.VKHttpOperation
    public void setHttpOperationListener(VKHttpOperation.VKHTTPOperationCompleteListener vKHTTPOperationCompleteListener) {
        throw new UnsupportedOperationException("This operation is now available for this class");
    }

    public void setJsonOperationListener(final VKJSONOperationCompleteListener vKJSONOperationCompleteListener) {
        if (vKJSONOperationCompleteListener == null) {
            super.setCompleteListener(null);
        } else {
            setCompleteListener(new VKAbstractOperation.VKOperationCompleteListener() { // from class: com.vk.sdk.api.httpClient.VKJsonOperation.1
                @Override // com.vk.sdk.api.httpClient.VKAbstractOperation.VKOperationCompleteListener
                public void onComplete() {
                    if (VKJsonOperation.this.mLastException == null) {
                        vKJSONOperationCompleteListener.onComplete(VKJsonOperation.this, VKJsonOperation.this.mResponseJson);
                    } else {
                        vKJSONOperationCompleteListener.onError(VKJsonOperation.this, VKJsonOperation.this.generateError(VKJsonOperation.this.mLastException));
                    }
                }
            });
        }
    }

    public abstract class VKJSONOperationCompleteListener extends VKAbstractOperation.VKAbstractCompleteListener<VKJsonOperation, JSONObject> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.vk.sdk.api.httpClient.VKAbstractOperation.VKAbstractCompleteListener
        public void onComplete(VKJsonOperation vKJsonOperation, JSONObject jSONObject) {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.vk.sdk.api.httpClient.VKAbstractOperation.VKAbstractCompleteListener
        public void onError(VKJsonOperation vKJsonOperation, VKError vKError) {
        }
    }
}
