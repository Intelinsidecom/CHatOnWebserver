package com.vlingo.sdk.internal.audio;

import android.bluetooth.BluetoothDevice;
import android.content.Context;
import android.media.AudioManager;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonRecentMediaAdapter;
import com.vlingo.sdk.internal.core.ApplicationAdapter;
import com.vlingo.sdk.internal.util.StringUtils;

/* loaded from: classes.dex */
public class AudioDevice {
    public static final int BT_AMR_PADDING_MILLIS = 1200;
    private static final String DEFAULT_AUDIO_DEVICE_NAME = "Android";
    private static final String DEFAULT_BLUETOOTH_DEVICE_NAME = "Unknown";
    private static AudioDevice s_AudioDevice = null;
    private volatile String currentBluetoothHeadsetName = DEFAULT_BLUETOOTH_DEVICE_NAME;

    public static synchronized AudioDevice getInstance() {
        if (s_AudioDevice == null) {
            s_AudioDevice = new AudioDevice();
        }
        return s_AudioDevice;
    }

    public static void destroy() {
        s_AudioDevice = null;
    }

    public String getAudioDeviceName() {
        return isAudioBluetooth() ? "Android/BT/" + this.currentBluetoothHeadsetName : DEFAULT_AUDIO_DEVICE_NAME;
    }

    public boolean isAudioBluetooth() {
        Context context = ApplicationAdapter.getInstance().getApplicationContext();
        AudioManager am = (AudioManager) context.getSystemService(SlookAirButtonRecentMediaAdapter.AUDIO_TYPE);
        return am.isBluetoothScoOn();
    }

    public boolean isAudioHeadset() {
        return false;
    }

    public void setCurrentBluetoothDeviceName(BluetoothDevice bd) {
        if (bd == null || StringUtils.isNullOrWhiteSpace(bd.getName())) {
            resetCurrentBluetoothDeviceName();
        } else {
            String name = bd.getName();
            this.currentBluetoothHeadsetName = name;
        }
    }

    public void resetCurrentBluetoothDeviceName() {
        this.currentBluetoothHeadsetName = DEFAULT_BLUETOOTH_DEVICE_NAME;
    }
}
