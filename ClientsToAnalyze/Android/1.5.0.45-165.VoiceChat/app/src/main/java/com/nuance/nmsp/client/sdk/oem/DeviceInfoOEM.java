package com.nuance.nmsp.client.sdk.oem;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.telephony.TelephonyManager;
import com.nuance.nmsp.client.sdk.common.oem.api.DeviceInfo;
import com.nuance.nmsp.client.sdk.common.oem.api.LogFactory;
import java.util.UUID;

/* loaded from: classes.dex */
public class DeviceInfoOEM implements DeviceInfo {

    /* renamed from: a */
    private static final LogFactory.Log f302a = LogFactory.getLog(DeviceInfoOEM.class);

    /* renamed from: b */
    private TelephonyManager f303b;

    /* renamed from: c */
    private Context f304c;

    public DeviceInfoOEM(Context context) {
        this.f304c = null;
        this.f304c = context;
        this.f303b = (TelephonyManager) context.getSystemService("phone");
    }

    @Override // com.nuance.nmsp.client.sdk.common.oem.api.DeviceInfo
    public String getDeviceModel() {
        return Build.MODEL;
    }

    @Override // com.nuance.nmsp.client.sdk.common.oem.api.DeviceInfo
    public String getOperatorName() {
        String networkOperatorName = this.f303b.getNetworkOperatorName();
        return networkOperatorName == null ? "" : networkOperatorName;
    }

    @Override // com.nuance.nmsp.client.sdk.common.oem.api.DeviceInfo
    public String getPhoneNumber() {
        String line1Number = this.f303b.getLine1Number();
        return line1Number == null ? "" : line1Number;
    }

    @Override // com.nuance.nmsp.client.sdk.common.oem.api.DeviceInfo
    public String getUniqueID() {
        SharedPreferences sharedPreferences = this.f304c.getSharedPreferences("nuance_sdk_pref", 0);
        String string = sharedPreferences.getString("NUANCE_NMSP_UID", "");
        if (string.length() == 0) {
            string = UUID.randomUUID().toString();
            if (string != null) {
                string = string.replaceAll("-", "");
            }
            SharedPreferences.Editor editorEdit = sharedPreferences.edit();
            editorEdit.putString("NUANCE_NMSP_UID", string);
            if (!editorEdit.commit()) {
                f302a.error("Storing nuance sdk uid has failed");
            }
        }
        return string == null ? "" : string;
    }
}
