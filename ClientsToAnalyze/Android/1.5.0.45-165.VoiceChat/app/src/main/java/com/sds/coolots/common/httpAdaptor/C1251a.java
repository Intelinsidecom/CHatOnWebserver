package com.sds.coolots.common.httpAdaptor;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;

/* renamed from: com.sds.coolots.common.httpAdaptor.a */
/* loaded from: classes.dex */
class C1251a implements HostnameVerifier {
    C1251a() {
    }

    @Override // javax.net.ssl.HostnameVerifier
    public boolean verify(String str, SSLSession sSLSession) {
        return true;
    }
}
