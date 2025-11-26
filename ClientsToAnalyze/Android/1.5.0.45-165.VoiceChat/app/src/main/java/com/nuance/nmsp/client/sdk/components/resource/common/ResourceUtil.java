package com.nuance.nmsp.client.sdk.components.resource.common;

import android.content.Context;
import com.nuance.nmsp.client.sdk.oem.DeviceInfoOEM;

/* loaded from: classes.dex */
public class ResourceUtil {
    public static String getDeviceModel(Context context) {
        return new DeviceInfoOEM(context).getDeviceModel();
    }

    public static String getOperatorName(Context context) {
        return new DeviceInfoOEM(context).getOperatorName();
    }

    public static String getPhoneNumber(Context context) {
        return new DeviceInfoOEM(context).getPhoneNumber();
    }

    public static String getUniqueID(Context context) {
        return new DeviceInfoOEM(context).getUniqueID();
    }
}
