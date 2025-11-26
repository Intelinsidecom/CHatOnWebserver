package com.p137vk.sdk.api;

import android.content.Intent;
import com.p137vk.sdk.VKAccessToken;
import com.p137vk.sdk.VKOpenAuthActivity;
import com.p137vk.sdk.VKSdk;
import com.p137vk.sdk.VKSdkVersion;
import com.p137vk.sdk.VKUIHelper;
import com.p137vk.sdk.api.httpClient.VKAbstractOperation;
import com.p137vk.sdk.api.httpClient.VKHttpClient;
import com.p137vk.sdk.api.httpClient.VKJsonOperation;
import com.p137vk.sdk.api.httpClient.VKModelOperation;
import com.p137vk.sdk.api.model.VKApiModel;
import com.p137vk.sdk.util.VKStringJoiner;
import com.p137vk.sdk.util.VKUtil;
import com.sec.chaton.privateplugin.data.Spam;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Locale;
import org.apache.http.client.methods.HttpUriRequest;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class VKRequest implements Serializable {
    private static final long serialVersionUID = 3390183888801770378L;
    public int attempts;
    public HttpMethod httpMethod;
    public File inputFile;
    private int mAttemptsUsed;
    private VKAbstractOperation mLoadingOperation;
    private VKParameters mMethodParameters;
    private Class<? extends VKApiModel> mModelClass;
    private ArrayList<VKRequest> mPostRequestsQueue;
    private String mPreferredLang;
    private VKParameters mPreparedParameters;
    private String mUploadUrl;
    public String methodName;
    public boolean parseModel;
    public VKRequestListener requestListener;
    public boolean secure;
    public boolean useSystemLanguage;

    public enum HttpMethod {
        GET,
        POST
    }

    public enum VKProgressType {
        Download,
        Upload
    }

    static /* synthetic */ int access$404(VKRequest vKRequest) {
        int i = vKRequest.mAttemptsUsed + 1;
        vKRequest.mAttemptsUsed = i;
        return i;
    }

    public HttpMethod getHttpMethod() {
        return this.httpMethod;
    }

    public VKParameters getMethodParameters() {
        return this.mMethodParameters;
    }

    public VKRequest(String str) {
        this(str, null);
    }

    public VKRequest(String str, VKParameters vKParameters) {
        this(str, vKParameters, HttpMethod.GET);
    }

    public VKRequest(String str, VKParameters vKParameters, HttpMethod httpMethod) {
        this.methodName = str;
        this.mMethodParameters = new VKParameters(vKParameters == null ? new VKParameters() : vKParameters);
        this.httpMethod = httpMethod == null ? HttpMethod.GET : httpMethod;
        this.mAttemptsUsed = 0;
        this.secure = true;
        this.attempts = 1;
        this.mPreferredLang = "en";
        this.useSystemLanguage = true;
    }

    public VKRequest(String str, VKParameters vKParameters, HttpMethod httpMethod, Class<? extends VKApiModel> cls) {
        this(str, vKParameters, httpMethod);
        setModelClass(cls);
    }

    public void executeWithListener(VKRequestListener vKRequestListener) {
        this.requestListener = vKRequestListener;
        start();
    }

    public void setRequestListener(VKRequestListener vKRequestListener) {
        this.requestListener = vKRequestListener;
    }

    public void executeAfterRequest(VKRequest vKRequest, VKRequestListener vKRequestListener) {
        this.requestListener = vKRequestListener;
        vKRequest.addPostRequest(this);
    }

    private void addPostRequest(VKRequest vKRequest) {
        if (this.mPostRequestsQueue == null) {
            this.mPostRequestsQueue = new ArrayList<>();
        }
        this.mPostRequestsQueue.add(vKRequest);
    }

    public VKParameters getPreparedParameters() {
        if (this.mPreparedParameters == null && this.mUploadUrl == null) {
            this.mPreparedParameters = new VKParameters(this.mMethodParameters);
            VKAccessToken accessToken = VKSdk.getAccessToken();
            if (accessToken == null) {
                VKError vKError = new VKError(VKError.VK_API_REQUEST_NOT_PREPARED);
                vKError.errorMessage = "Access token is nil";
                provideError(vKError);
                return null;
            }
            this.mPreparedParameters.put("access_token", accessToken.accessToken);
            if ((!this.secure && accessToken.secret == null) || accessToken.httpsRequired) {
                this.secure = true;
            }
            this.mPreparedParameters.put(VKApiConst.VERSION, VKSdkVersion.API_VERSION);
            this.mPreparedParameters.put(VKApiConst.LANG, getLang());
            if (this.secure) {
                this.mPreparedParameters.put(VKApiConst.HTTPS, Spam.ACTIVITY_REPORT);
            }
            if (accessToken.secret != null) {
                this.mPreparedParameters.put(VKApiConst.SIG, generateSig(accessToken));
            }
        }
        return this.mPreparedParameters;
    }

    public HttpUriRequest getPreparedRequest() {
        HttpUriRequest httpUriRequestRequestWithVkRequest = VKHttpClient.requestWithVkRequest(this);
        if (httpUriRequestRequestWithVkRequest == null) {
            provideError(new VKError(VKError.VK_API_REQUEST_NOT_PREPARED));
            return null;
        }
        return httpUriRequestRequestWithVkRequest;
    }

    public VKAbstractOperation getOperation() {
        if (this.mModelClass != null && this.parseModel) {
            this.mLoadingOperation = new VKModelOperation(getPreparedRequest(), this.mModelClass);
        } else {
            this.mLoadingOperation = new VKJsonOperation(getPreparedRequest());
        }
        ((VKJsonOperation) this.mLoadingOperation).setJsonOperationListener(new VKJsonOperation.VKJSONOperationCompleteListener() { // from class: com.vk.sdk.api.VKRequest.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.vk.sdk.api.httpClient.VKJsonOperation.VKJSONOperationCompleteListener, com.vk.sdk.api.httpClient.VKAbstractOperation.VKAbstractCompleteListener
            public void onComplete(VKJsonOperation vKJsonOperation, JSONObject jSONObject) {
                if (!jSONObject.has("error")) {
                    VKRequest.this.provideResponse(jSONObject, VKRequest.this.mLoadingOperation instanceof VKModelOperation ? ((VKModelOperation) VKRequest.this.mLoadingOperation).parsedModel : null);
                    return;
                }
                try {
                    VKError vKError = new VKError(jSONObject.getJSONObject("error"));
                    if (!VKRequest.this.processCommonError(vKError)) {
                        VKRequest.this.provideError(vKError);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.vk.sdk.api.httpClient.VKJsonOperation.VKJSONOperationCompleteListener, com.vk.sdk.api.httpClient.VKAbstractOperation.VKAbstractCompleteListener
            public void onError(VKJsonOperation vKJsonOperation, VKError vKError) {
                if (vKError.errorCode != -101 && vKJsonOperation != null && vKJsonOperation.response != null && vKJsonOperation.response.getStatusLine().getStatusCode() == 200) {
                    VKRequest.this.provideResponse(vKJsonOperation.getResponseJson(), null);
                    return;
                }
                if (VKRequest.this.attempts != 0 && VKRequest.access$404(VKRequest.this) >= VKRequest.this.attempts) {
                    VKRequest.this.provideError(vKError);
                    return;
                }
                if (VKRequest.this.requestListener != null) {
                    VKRequest.this.requestListener.attemptFailed(VKRequest.this, VKRequest.this.mAttemptsUsed, VKRequest.this.attempts);
                }
                VKAbstractOperation.postInMainQueueDelayed(new Runnable() { // from class: com.vk.sdk.api.VKRequest.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        VKRequest.this.start();
                    }
                });
            }
        });
        return this.mLoadingOperation;
    }

    public void start() {
        VKAbstractOperation operation = getOperation();
        this.mLoadingOperation = operation;
        if (operation != null) {
            VKHttpClient.enqueueOperation(this.mLoadingOperation);
        }
    }

    public void repeat() {
        this.mAttemptsUsed = 0;
        this.mPreparedParameters = null;
        start();
    }

    public void cancel() {
        if (this.mLoadingOperation != null) {
            this.mLoadingOperation.cancel();
        } else {
            provideError(new VKError(VKError.VK_API_CANCELED));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void provideError(VKError vKError) {
        vKError.request = this;
        if (this.requestListener != null) {
            this.requestListener.onError(vKError);
        }
        if (this.mPostRequestsQueue != null && this.mPostRequestsQueue.size() > 0) {
            Iterator<VKRequest> it = this.mPostRequestsQueue.iterator();
            while (it.hasNext()) {
                VKRequest next = it.next();
                if (next.requestListener != null) {
                    next.requestListener.onError(vKError);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void provideResponse(JSONObject jSONObject, VKApiModel vKApiModel) {
        VKResponse vKResponse = new VKResponse();
        vKResponse.request = this;
        vKResponse.json = jSONObject;
        vKResponse.parsedModel = vKApiModel;
        if (this.mPostRequestsQueue != null && this.mPostRequestsQueue.size() > 0) {
            Iterator<VKRequest> it = this.mPostRequestsQueue.iterator();
            while (it.hasNext()) {
                it.next().start();
            }
        }
        if (this.requestListener != null) {
            this.requestListener.onComplete(vKResponse);
        }
    }

    public void addExtraParameter(String str, Object obj) {
        this.mMethodParameters.put(str, obj);
    }

    public void addExtraParameters(VKParameters vKParameters) {
        this.mMethodParameters.putAll(vKParameters);
    }

    private String generateSig(VKAccessToken vKAccessToken) {
        return VKUtil.md5(String.format(Locale.US, "/method/%s?%s", this.methodName, VKStringJoiner.joinParams(this.mPreparedParameters)) + vKAccessToken.secret);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean processCommonError(VKError vKError) {
        if (vKError.errorCode == -101) {
            if (vKError.apiError.errorCode == 14) {
                vKError.apiError.request = this;
                this.mLoadingOperation = null;
                VKSdk.instance().sdkListener().onCaptchaError(vKError.apiError);
                return true;
            }
            if (vKError.apiError.errorCode == 16) {
                VKSdk.getAccessToken().httpsRequired = true;
                repeat();
                return true;
            }
            if (vKError.apiError.errorCode == 17) {
                Intent intent = new Intent(VKUIHelper.getTopActivity(), (Class<?>) VKOpenAuthActivity.class);
                intent.putExtra(VKOpenAuthActivity.VK_EXTRA_VALIDATION_URL, vKError.apiError.redirectUri);
                VKUIHelper.getTopActivity().startActivityForResult(intent, VKSdk.VK_SDK_REQUEST_CODE);
                return true;
            }
        }
        return false;
    }

    private String getLang() {
        String str = this.mPreferredLang;
        if (this.useSystemLanguage) {
            String language = Locale.getDefault().getLanguage();
            if (language.equals("uk")) {
                language = "ua";
            }
            if (!Arrays.asList("ru", "en", "ua", "es", "fi", "de", "it").contains(language)) {
                return this.mPreferredLang;
            }
            return language;
        }
        return str;
    }

    public void setPreferredLang(String str) {
        this.useSystemLanguage = false;
        this.mPreferredLang = str;
    }

    public void setModelClass(Class<? extends VKApiModel> cls) {
        this.mModelClass = cls;
        if (this.mModelClass != null) {
            this.parseModel = true;
        }
    }

    public abstract class VKRequestListener {
        public void onComplete(VKResponse vKResponse) {
        }

        public void attemptFailed(VKRequest vKRequest, int i, int i2) {
        }

        public void onError(VKError vKError) {
        }

        public void onProgress(VKProgressType vKProgressType, long j, long j2) {
        }
    }
}
