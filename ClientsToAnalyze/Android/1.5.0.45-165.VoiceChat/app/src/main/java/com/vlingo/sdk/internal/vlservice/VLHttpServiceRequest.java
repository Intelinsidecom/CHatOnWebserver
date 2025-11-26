package com.vlingo.sdk.internal.vlservice;

import com.vlingo.sdk.internal.http.HttpCallback;
import com.vlingo.sdk.internal.http.HttpRequest;
import com.vlingo.sdk.internal.http.HttpResponse;
import com.vlingo.sdk.internal.http.HttpUtil;
import com.vlingo.sdk.internal.http.URL;
import com.vlingo.sdk.internal.util.StringUtils;
import java.util.Hashtable;

/* loaded from: classes.dex */
public class VLHttpServiceRequest extends HttpRequest {
    public static final String RESPONSE_ENCODING_JSON = "application/json";
    public static final String RESPONSE_ENCODING_XML = "text/xml";
    private String mLanguage;

    public static VLHttpServiceRequest createVLRequest(String taskName, HttpCallback callback, URL url, String request, String language) {
        return new VLHttpServiceRequest(taskName, callback, url.url, StringUtils.convertStringToBytes(request), language);
    }

    public static VLHttpServiceRequest createVLRequest(String taskName, HttpCallback callback, URL url, String request) {
        return new VLHttpServiceRequest(taskName, callback, url.url, StringUtils.convertStringToBytes(request), null);
    }

    public VLHttpServiceRequest(String taskName, HttpCallback callback, String url, byte[] data, String language) {
        super(taskName, callback, url, data);
        this.mLanguage = language;
    }

    public void setResponseEncoding(String responseEncoding) {
        if (this.extraHeaders == null) {
            this.extraHeaders = new Hashtable<>();
        }
        VLServiceUtil.setProtocolHeader(this.extraHeaders, responseEncoding);
    }

    @Override // com.vlingo.sdk.internal.http.HttpRequest
    public HttpResponse fetchResponse() {
        log.debug("** fetch response " + this + " url=" + this.url);
        if (this.extraHeaders == null) {
            this.extraHeaders = new Hashtable<>();
        }
        if (this.cookies == null) {
            this.cookies = new Hashtable<>();
        }
        VLServiceUtil.addStandardVlingoHttpHeaders(this.extraHeaders, this.client, this.software, this.mLanguage, null);
        this.cookies = VLServiceUtil.addVLServiceCookies(this.cookies, HttpUtil.getDomain(this.url), HttpUtil.getPath(this.url));
        HttpResponse response = super.fetchResponse();
        VLServiceUtil.handleResponseCookies(response.getCookies());
        return response;
    }
}
