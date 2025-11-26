package com.p137vk.sdk.api.httpClient;

import com.p137vk.sdk.api.VKError;
import com.p137vk.sdk.api.httpClient.VKAbstractOperation;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.zip.GZIPInputStream;
import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpUriRequest;

/* loaded from: classes.dex */
public class VKHttpOperation extends VKAbstractOperation {
    protected Exception mLastException;
    private byte[] mResponseBytes;
    private String mResponseString;
    private HttpUriRequest mUriRequest;
    public OutputStream outputStream;
    public HttpResponse response;

    public VKHttpOperation(HttpUriRequest httpUriRequest) {
        this.mUriRequest = httpUriRequest;
    }

    @Override // com.p137vk.sdk.api.httpClient.VKAbstractOperation
    public void start() throws IllegalStateException, IOException {
        setState(VKAbstractOperation.VKOperationState.Executing);
        try {
            this.response = VKHttpClient.getClient().execute(this.mUriRequest);
            InputStream content = this.response.getEntity().getContent();
            Header firstHeader = this.response.getFirstHeader("Content-Encoding");
            InputStream gZIPInputStream = (firstHeader == null || !firstHeader.getValue().equalsIgnoreCase("gzip")) ? content : new GZIPInputStream(content);
            if (this.outputStream == null) {
                this.outputStream = new ByteArrayOutputStream();
            }
            byte[] bArr = new byte[1024];
            while (true) {
                int i = gZIPInputStream.read(bArr);
                if (i == -1) {
                    break;
                } else {
                    this.outputStream.write(bArr, 0, i);
                }
            }
            gZIPInputStream.close();
            this.outputStream.flush();
            if (this.outputStream instanceof ByteArrayOutputStream) {
                this.mResponseBytes = ((ByteArrayOutputStream) this.outputStream).toByteArray();
            }
            this.outputStream.close();
        } catch (Exception e) {
            this.mLastException = e;
        }
        finish();
    }

    @Override // com.p137vk.sdk.api.httpClient.VKAbstractOperation
    public void finish() {
        postExecution();
        super.finish();
    }

    protected boolean postExecution() {
        return true;
    }

    @Override // com.p137vk.sdk.api.httpClient.VKAbstractOperation
    public void cancel() throws UnsupportedOperationException {
        this.mUriRequest.abort();
        super.cancel();
    }

    public byte[] getResponseData() {
        return this.mResponseBytes;
    }

    public String getResponseString() {
        if (this.mResponseBytes == null) {
            return null;
        }
        if (this.mResponseString == null) {
            try {
                this.mResponseString = new String(this.mResponseBytes, "UTF-8");
            } catch (UnsupportedEncodingException e) {
                this.mLastException = e;
            }
        }
        return this.mResponseString;
    }

    protected VKError generateError(Exception exc) {
        VKError vKError = new VKError(VKError.VK_API_REQUEST_HTTP_FAILED);
        vKError.errorMessage = exc.getMessage();
        if (vKError.errorMessage == null) {
            vKError.errorMessage = exc.toString();
        }
        vKError.httpError = exc;
        return vKError;
    }

    public void setHttpOperationListener(final VKHTTPOperationCompleteListener vKHTTPOperationCompleteListener) {
        setCompleteListener(new VKAbstractOperation.VKOperationCompleteListener() { // from class: com.vk.sdk.api.httpClient.VKHttpOperation.1
            @Override // com.vk.sdk.api.httpClient.VKAbstractOperation.VKOperationCompleteListener
            public void onComplete() {
                if (VKHttpOperation.this.mLastException == null) {
                    vKHTTPOperationCompleteListener.onComplete(VKHttpOperation.this, VKHttpOperation.this.mResponseBytes);
                } else {
                    vKHTTPOperationCompleteListener.onError(VKHttpOperation.this, VKHttpOperation.this.generateError(VKHttpOperation.this.mLastException));
                }
            }
        });
    }

    public abstract class VKHTTPOperationCompleteListener extends VKAbstractOperation.VKAbstractCompleteListener<VKHttpOperation, byte[]> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.vk.sdk.api.httpClient.VKAbstractOperation.VKAbstractCompleteListener
        public void onComplete(VKHttpOperation vKHttpOperation, byte[] bArr) {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.vk.sdk.api.httpClient.VKAbstractOperation.VKAbstractCompleteListener
        public void onError(VKHttpOperation vKHttpOperation, VKError vKError) {
        }
    }
}
