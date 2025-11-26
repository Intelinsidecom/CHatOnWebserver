package com.vlingo.sdk.internal.http;

/* loaded from: classes.dex */
public interface HttpCallback {
    void onCancelled(HttpRequest httpRequest);

    void onFailure(HttpRequest httpRequest);

    void onResponse(HttpRequest httpRequest, HttpResponse httpResponse);

    boolean onTimeout(HttpRequest httpRequest);

    void onWillExecuteRequest(HttpRequest httpRequest);
}
