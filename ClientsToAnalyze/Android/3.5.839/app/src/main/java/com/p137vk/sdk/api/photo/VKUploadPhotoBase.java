package com.p137vk.sdk.api.photo;

import com.p137vk.sdk.api.VKError;
import com.p137vk.sdk.api.VKRequest;
import com.p137vk.sdk.api.VKResponse;
import com.p137vk.sdk.api.httpClient.VKAbstractOperation;
import com.p137vk.sdk.api.httpClient.VKHttpClient;
import com.p137vk.sdk.api.httpClient.VKJsonOperation;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public abstract class VKUploadPhotoBase extends VKRequest {
    private static final long serialVersionUID = -4566961568409572159L;
    protected long mAlbumId;
    protected long mGroupId;
    protected File mImage;
    protected long mUserId;

    protected abstract VKRequest getSaveRequest(JSONObject jSONObject);

    protected abstract VKRequest getServerRequest();

    public VKUploadPhotoBase() {
        super(null);
    }

    @Override // com.p137vk.sdk.api.VKRequest
    public VKAbstractOperation getOperation() {
        return new VKUploadImageOperation();
    }

    public class VKUploadImageOperation extends VKAbstractOperation {
        protected VKAbstractOperation lastOperation;

        protected VKUploadImageOperation() {
        }

        @Override // com.p137vk.sdk.api.httpClient.VKAbstractOperation
        public void start() {
            final VKRequest.VKRequestListener vKRequestListener = VKUploadPhotoBase.this.requestListener;
            VKUploadPhotoBase.this.requestListener = new VKRequest.VKRequestListener() { // from class: com.vk.sdk.api.photo.VKUploadPhotoBase.VKUploadImageOperation.1
                @Override // com.vk.sdk.api.VKRequest.VKRequestListener
                public void onComplete(VKResponse vKResponse) {
                    VKUploadImageOperation.this.setState(VKAbstractOperation.VKOperationState.Finished);
                    vKResponse.request = VKUploadPhotoBase.this;
                    if (vKRequestListener != null) {
                        vKRequestListener.onComplete(vKResponse);
                    }
                }

                @Override // com.vk.sdk.api.VKRequest.VKRequestListener
                public void onError(VKError vKError) {
                    VKUploadImageOperation.this.setState(VKAbstractOperation.VKOperationState.Finished);
                    vKError.request = VKUploadPhotoBase.this;
                    if (vKRequestListener != null) {
                        vKRequestListener.onError(vKError);
                    }
                }

                @Override // com.vk.sdk.api.VKRequest.VKRequestListener
                public void onProgress(VKRequest.VKProgressType vKProgressType, long j, long j2) {
                    if (vKRequestListener != null) {
                        vKRequestListener.onProgress(vKProgressType, j, j2);
                    }
                }
            };
            setState(VKAbstractOperation.VKOperationState.Executing);
            VKRequest serverRequest = VKUploadPhotoBase.this.getServerRequest();
            serverRequest.setRequestListener(new C52042());
            this.lastOperation = serverRequest.getOperation();
            VKHttpClient.enqueueOperation(this.lastOperation);
        }

        /* renamed from: com.vk.sdk.api.photo.VKUploadPhotoBase$VKUploadImageOperation$2 */
        class C52042 extends VKRequest.VKRequestListener {
            C52042() {
            }

            @Override // com.vk.sdk.api.VKRequest.VKRequestListener
            public void onComplete(VKResponse vKResponse) {
                try {
                    VKJsonOperation vKJsonOperation = new VKJsonOperation(VKHttpClient.fileUploadRequest(vKResponse.json.getJSONObject("response").getString("upload_url"), VKUploadPhotoBase.this.mImage));
                    vKJsonOperation.setJsonOperationListener(new VKJsonOperation.VKJSONOperationCompleteListener() { // from class: com.vk.sdk.api.photo.VKUploadPhotoBase.VKUploadImageOperation.2.1
                        /* JADX WARN: Can't rename method to resolve collision */
                        @Override // com.vk.sdk.api.httpClient.VKJsonOperation.VKJSONOperationCompleteListener, com.vk.sdk.api.httpClient.VKAbstractOperation.VKAbstractCompleteListener
                        public void onComplete(VKJsonOperation vKJsonOperation2, JSONObject jSONObject) {
                            VKRequest saveRequest = VKUploadPhotoBase.this.getSaveRequest(jSONObject);
                            saveRequest.setRequestListener(new VKRequest.VKRequestListener() { // from class: com.vk.sdk.api.photo.VKUploadPhotoBase.VKUploadImageOperation.2.1.1
                                @Override // com.vk.sdk.api.VKRequest.VKRequestListener
                                public void onComplete(VKResponse vKResponse2) {
                                    VKUploadPhotoBase.this.requestListener.onComplete(vKResponse2);
                                    VKUploadImageOperation.this.setState(VKAbstractOperation.VKOperationState.Finished);
                                }

                                @Override // com.vk.sdk.api.VKRequest.VKRequestListener
                                public void onError(VKError vKError) {
                                    VKUploadPhotoBase.this.requestListener.onError(vKError);
                                }
                            });
                            VKUploadImageOperation.this.lastOperation = saveRequest.getOperation();
                            VKHttpClient.enqueueOperation(VKUploadImageOperation.this.lastOperation);
                        }

                        /* JADX WARN: Can't rename method to resolve collision */
                        @Override // com.vk.sdk.api.httpClient.VKJsonOperation.VKJSONOperationCompleteListener, com.vk.sdk.api.httpClient.VKAbstractOperation.VKAbstractCompleteListener
                        public void onError(VKJsonOperation vKJsonOperation2, VKError vKError) {
                            VKUploadPhotoBase.this.requestListener.onError(vKError);
                        }
                    });
                    VKUploadImageOperation.this.lastOperation = vKJsonOperation;
                    VKHttpClient.enqueueOperation(VKUploadImageOperation.this.lastOperation);
                } catch (JSONException e) {
                    e.printStackTrace();
                    VKError vKError = new VKError(VKError.VK_API_JSON_FAILED);
                    vKError.httpError = e;
                    vKError.errorMessage = e.getMessage();
                    VKUploadPhotoBase.this.requestListener.onError(vKError);
                }
            }

            @Override // com.vk.sdk.api.VKRequest.VKRequestListener
            public void onError(VKError vKError) {
                if (VKUploadPhotoBase.this.requestListener != null) {
                    VKUploadPhotoBase.this.requestListener.onError(vKError);
                }
            }
        }

        @Override // com.p137vk.sdk.api.httpClient.VKAbstractOperation
        public void cancel() {
            if (this.lastOperation != null) {
                this.lastOperation.cancel();
            }
            super.cancel();
        }

        @Override // com.p137vk.sdk.api.httpClient.VKAbstractOperation
        public void finish() {
            super.finish();
            this.lastOperation = null;
        }
    }
}
