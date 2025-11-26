package com.vlingo.sdk.internal.http;

/* loaded from: classes.dex */
public class BaseHttpCallback implements HttpCallback {
    @Override // com.vlingo.sdk.internal.http.HttpCallback
    public void onWillExecuteRequest(HttpRequest request) {
    }

    @Override // com.vlingo.sdk.internal.http.HttpCallback
    public void onResponse(HttpRequest request, HttpResponse response) {
    }

    @Override // com.vlingo.sdk.internal.http.HttpCallback
    public boolean onTimeout(HttpRequest request) {
        return true;
    }

    @Override // com.vlingo.sdk.internal.http.HttpCallback
    public void onFailure(HttpRequest request) {
    }

    @Override // com.vlingo.sdk.internal.http.HttpCallback
    public void onCancelled(HttpRequest request) {
    }
}
