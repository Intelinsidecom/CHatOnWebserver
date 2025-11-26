package com.nuance.nmsp.client.sdk.oem.bluetooth;

import android.content.Context;
import android.media.AudioManager;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonRecentMediaAdapter;

/* renamed from: com.nuance.nmsp.client.sdk.oem.bluetooth.a */
/* loaded from: classes.dex */
final class C0531a extends Bluetooth {

    /* renamed from: a */
    private AudioManager f383a;

    public C0531a(Context context) {
        super(context);
        this.f383a = (AudioManager) this.mContext.getSystemService(SlookAirButtonRecentMediaAdapter.AUDIO_TYPE);
    }

    @Override // com.nuance.nmsp.client.sdk.oem.bluetooth.Bluetooth
    public final int getPlaybackStream() {
        if (isHeadsetConnected()) {
            return Audio.AUDIO_TRACK_VOICE_CALL_STREAM;
        }
        return 3;
    }

    @Override // com.nuance.nmsp.client.sdk.oem.bluetooth.Bluetooth
    public final int getRecordingSource() {
        if (isHeadsetConnected()) {
            return Audio.AUDIO_RECORD_AUDIO_SOURCE;
        }
        return 1;
    }

    @Override // com.nuance.nmsp.client.sdk.oem.bluetooth.Bluetooth
    public final void startBluetoothScoInternal() {
        this.f383a.startBluetoothSco();
    }

    @Override // com.nuance.nmsp.client.sdk.oem.bluetooth.Bluetooth
    public final void stopBluetoothSco() {
        this.f383a.stopBluetoothSco();
    }
}
