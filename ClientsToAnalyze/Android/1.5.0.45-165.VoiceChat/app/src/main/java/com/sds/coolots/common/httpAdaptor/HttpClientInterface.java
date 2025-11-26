package com.sds.coolots.common.httpAdaptor;

import java.io.Serializable;

/* loaded from: classes.dex */
public interface HttpClientInterface {
    void cancelTransaction();

    Serializable getTransactionResult();

    int httpTransaction(String str, String str2, int i);

    int httpsTransaction(String str, String str2, String str3, int i);
}
