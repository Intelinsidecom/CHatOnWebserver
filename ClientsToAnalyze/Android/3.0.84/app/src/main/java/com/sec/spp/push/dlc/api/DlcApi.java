package com.sec.spp.push.dlc.api;

/* loaded from: classes.dex */
public class DlcApi implements IDlcApi {
    public static final int RC_SVC_NOT_CONNECTED = -1000;

    public static String getResultStr(int i) {
        switch (i) {
            case RC_SVC_NOT_CONNECTED /* -1000 */:
                return "Service is not connected";
            case -5:
                return "Urgent logging is not allowed";
            case -4:
                return "Permission error";
            case -3:
                return "Application is blocked";
            case -2:
                return "Service is not available";
            case -1:
                return "Invalid parameter";
            case 0:
                return "Success";
            default:
                return "";
        }
    }
}
