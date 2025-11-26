package com.sds.coolots.common.httpAdaptor;

import com.vlingo.sdk.internal.http.HttpUtil;
import org.apache.http.HttpRequest;
import org.apache.http.HttpRequestInterceptor;
import org.apache.http.protocol.HttpContext;

/* renamed from: com.sds.coolots.common.httpAdaptor.e */
/* loaded from: classes.dex */
class C1255e implements HttpRequestInterceptor {

    /* renamed from: a */
    final /* synthetic */ C1252b f3042a;

    C1255e(C1252b c1252b) {
        this.f3042a = c1252b;
    }

    @Override // org.apache.http.HttpRequestInterceptor
    public void process(HttpRequest httpRequest, HttpContext httpContext) {
        httpRequest.addHeader(HttpUtil.HEADER_USER_AGENT, "Mozilla/5.0");
    }
}
