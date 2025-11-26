package com.coolots.sse.common.util;

/* loaded from: classes.dex */
public class SSELibraryInfo {
    public static final int US_DEV_SERVER = 0;
    public static final int US_STG_SERVER = 1;
    public static final String VERSION = "0.9.10";
    public static int serverType = 1;

    public static void setServerDomain(int type) {
        serverType = type;
    }

    public static String getServerDomain() {
        if (serverType == 0) {
            return "us-devcs-sse.coolots.com";
        }
        if (serverType != 1) {
            return "";
        }
        return "us-stgcs-sse.coolots.com";
    }
}
