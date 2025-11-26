package com.vlingo.sdk.services;

import com.vlingo.sdk.recognition.VLAction;
import java.util.List;

/* loaded from: classes.dex */
public interface VLServicesListener {
    void onError(VLServicesErrors vLServicesErrors, String str);

    void onSuccess(List<VLAction> list);
}
