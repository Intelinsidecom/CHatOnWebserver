package com.vlingo.sdk.internal.http.custom;

/* loaded from: classes.dex */
public class HttpInteraction {
    private VHttpConnection ivCon;
    private HttpRequest ivRequest;
    private HttpResponse ivResponse;

    public HttpInteraction(VHttpConnection con) {
        if (con == null) {
            throw new IllegalArgumentException("Connection is required");
        }
        this.ivCon = con;
        this.ivRequest = new HttpRequest(this);
        this.ivResponse = new HttpResponse(this);
    }

    public VHttpConnection getHTTPConnection() {
        return this.ivCon;
    }

    public HttpRequest getRequest() {
        return this.ivRequest;
    }

    public HttpResponse getResponse() {
        return this.ivResponse;
    }
}
