package com.p137vk.sdk.api;

import com.p137vk.sdk.VKObject;
import com.p137vk.sdk.api.VKRequest;
import com.p137vk.sdk.api.httpClient.VKHttpClient;

/* loaded from: classes.dex */
public class VKBatchRequest extends VKObject {
    private boolean mCanceled = false;
    private VKRequest[] mRequests;
    private VKResponse[] mResponses;
    public VKBatchRequestListener requestListener;

    public VKBatchRequest(VKRequest... vKRequestArr) {
        this.mRequests = vKRequestArr;
        this.mResponses = new VKResponse[this.mRequests.length];
    }

    public void executeWithListener(VKBatchRequestListener vKBatchRequestListener) {
        if (this.mRequests == null) {
            provideError(new VKError(VKError.VK_API_REQUEST_NOT_PREPARED));
            return;
        }
        this.requestListener = vKBatchRequestListener;
        for (VKRequest vKRequest : this.mRequests) {
            final VKRequest.VKRequestListener vKRequestListener = vKRequest.requestListener;
            vKRequest.setRequestListener(new VKRequest.VKRequestListener() { // from class: com.vk.sdk.api.VKBatchRequest.1
                @Override // com.vk.sdk.api.VKRequest.VKRequestListener
                public void onComplete(VKResponse vKResponse) {
                    if (vKRequestListener != null) {
                        vKRequestListener.onComplete(vKResponse);
                    }
                    VKBatchRequest.this.provideResponse(vKResponse);
                }

                @Override // com.vk.sdk.api.VKRequest.VKRequestListener
                public void onError(VKError vKError) {
                    if (vKRequestListener != null) {
                        vKRequestListener.onError(vKError);
                    }
                    VKBatchRequest.this.provideError(vKError);
                }

                @Override // com.vk.sdk.api.VKRequest.VKRequestListener
                public void onProgress(VKRequest.VKProgressType vKProgressType, long j, long j2) {
                    if (vKRequestListener != null) {
                        vKRequestListener.onProgress(vKProgressType, j, j2);
                    }
                }
            });
            VKHttpClient.enqueueOperation(vKRequest.getOperation());
        }
    }

    public void cancel() {
        if (!this.mCanceled) {
            this.mCanceled = true;
            for (VKRequest vKRequest : this.mRequests) {
                vKRequest.cancel();
            }
        }
    }

    protected void provideResponse(VKResponse vKResponse) {
        this.mResponses[indexOfRequest(vKResponse.request)] = vKResponse;
        for (VKResponse vKResponse2 : this.mResponses) {
            if (vKResponse2 == null) {
                return;
            }
        }
        if (this.requestListener != null) {
            this.requestListener.onComplete(this.mResponses);
        }
    }

    private int indexOfRequest(VKRequest vKRequest) {
        for (int i = 0; i < this.mRequests.length; i++) {
            if (this.mRequests[i].equals(vKRequest)) {
                return i;
            }
        }
        return -1;
    }

    protected void provideError(VKError vKError) {
        if (!this.mCanceled) {
            if (this.requestListener != null) {
                this.requestListener.onError(vKError);
            }
            cancel();
        }
    }

    public abstract class VKBatchRequestListener {
        public void onComplete(VKResponse[] vKResponseArr) {
        }

        public void onError(VKError vKError) {
        }
    }
}
