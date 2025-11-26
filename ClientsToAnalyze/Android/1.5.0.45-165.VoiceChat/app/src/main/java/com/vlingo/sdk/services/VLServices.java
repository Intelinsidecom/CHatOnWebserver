package com.vlingo.sdk.services;

import com.vlingo.sdk.VLComponent;
import com.vlingo.sdk.services.userlogging.VLUserLoggerLogRecord;

/* loaded from: classes.dex */
public interface VLServices extends VLComponent {
    void sendActivityLog(String str, VLUserLoggerLogRecord vLUserLoggerLogRecord, VLServicesListener vLServicesListener);

    void sendHello(String str, VLServicesListener vLServicesListener);
}
