package com.sec.spp.push.dlc.api;

/* loaded from: classes.dex */
public class DlcApi implements IDlcApi {
    public static final int RC_SVC_NOT_CONNECTED = -1000;

    public static String getResultStr(int i) {
        switch (i) {
            case RC_SVC_NOT_CONNECTED /* -1000 */:
                return "Service is not connected";
            case IDlcApi.RC_NOT_REGISTERED /* -6 */:
                return "This app is not registered yet";
            case IDlcApi.RC_URGENT_NOT_ALLOWED /* -5 */:
                return "Urgent logging is not allowed";
            case IDlcApi.RC_NOT_PERMITTED /* -4 */:
                return "Permission error";
            case IDlcApi.RC_APPLICATION_BLOCKED /* -3 */:
                return "Application is blocked";
            case IDlcApi.RC_SVC_UNAVAILABLE /* -2 */:
                return "Service is unavailable";
            case -1:
                return "Invalid parameter";
            case 0:
                return "Success";
            default:
                return "";
        }
    }
}
