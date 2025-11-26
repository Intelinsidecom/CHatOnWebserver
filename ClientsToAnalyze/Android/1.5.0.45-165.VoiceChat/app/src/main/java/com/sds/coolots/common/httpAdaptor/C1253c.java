package com.sds.coolots.common.httpAdaptor;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ResponseHandler;
import org.apache.http.util.EntityUtils;

/* renamed from: com.sds.coolots.common.httpAdaptor.c */
/* loaded from: classes.dex */
class C1253c implements ResponseHandler {

    /* renamed from: a */
    final /* synthetic */ C1252b f3040a;

    C1253c(C1252b c1252b) {
        this.f3040a = c1252b;
    }

    @Override // org.apache.http.client.ResponseHandler
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public byte[] handleResponse(HttpResponse httpResponse) {
        HttpEntity entity = httpResponse.getEntity();
        if (entity == null) {
            return null;
        }
        return EntityUtils.toByteArray(entity);
    }
}
