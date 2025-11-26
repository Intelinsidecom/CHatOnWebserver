package com.nuance.nmsp.client.sdk.oem;

import com.nuance.nmsp.client.sdk.common.oem.api.LogFactory;

/* loaded from: classes.dex */
public class LogFactoryOEM extends LogFactory {
    public static LogFactory.Log getLog(Class cls) {
        return new LogOEM(cls);
    }
}
