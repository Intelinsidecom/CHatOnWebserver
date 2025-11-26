package com.nuance.nmsp.client.sdk.oem;

import android.content.Context;
import com.nuance.nmsp.client.sdk.common.defines.NMSPDefines;
import com.nuance.nmsp.client.sdk.common.oem.api.BluetoothSystem;
import com.nuance.nmsp.client.sdk.common.oem.api.LogFactory;
import com.nuance.nmsp.client.sdk.components.general.Parameter;
import com.nuance.nmsp.client.sdk.oem.bluetooth.Bluetooth;
import java.util.Vector;

/* loaded from: classes.dex */
public class BluetoothSystemOEM implements BluetoothSystem {

    /* renamed from: a */
    private LogFactory.Log f299a = LogFactory.getLog(getClass());

    /* renamed from: b */
    private Context f300b;

    /* renamed from: c */
    private boolean f301c;

    public BluetoothSystemOEM(Vector vector) {
        int i = 0;
        this.f300b = null;
        this.f301c = false;
        if (vector == null) {
            return;
        }
        while (true) {
            int i2 = i;
            if (i2 >= vector.size()) {
                return;
            }
            Parameter parameter = (Parameter) vector.get(i2);
            String name = parameter.getName();
            if (parameter.getType() == Parameter.Type.SDK) {
                if (name.equals(NMSPDefines.NMSP_DEFINES_ANDROID_CONTEXT)) {
                    this.f300b = (Context) parameter.getValueRaw();
                    if (this.f299a.isDebugEnabled()) {
                        this.f299a.debug("NMSP_DEFINES_ANDROID_CONTEXT is passed in as" + this.f300b);
                    }
                } else if (name.equals(NMSPDefines.NMSP_DEFINES_DISABLE_BLUETOOTH) && new String(parameter.getValue()).equalsIgnoreCase("TRUE")) {
                    if (this.f299a.isDebugEnabled()) {
                        this.f299a.debug("Disable_Bluetooth is true.");
                    }
                    this.f301c = true;
                }
            }
            i = i2 + 1;
        }
    }

    @Override // com.nuance.nmsp.client.sdk.common.oem.api.BluetoothSystem
    public boolean isBluetoothHeadsetConnected() {
        if (this.f301c) {
            return false;
        }
        if (this.f300b == null) {
            if (!this.f299a.isErrorEnabled()) {
                return false;
            }
            this.f299a.error("ANDROID_CONTEXT parameter is not passed in!!!");
            return false;
        }
        Bluetooth bluetoothCreateInstance = Bluetooth.createInstance(this.f300b);
        boolean zIsHeadsetConnected = bluetoothCreateInstance.isHeadsetConnected();
        bluetoothCreateInstance.close();
        return zIsHeadsetConnected;
    }
}
