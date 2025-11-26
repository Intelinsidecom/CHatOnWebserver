package com.nuance.nmsp.client.sdk.oem.bluetooth;

import android.content.Context;
import android.media.AudioManager;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonRecentMediaAdapter;

/* renamed from: com.nuance.nmsp.client.sdk.oem.bluetooth.c */
/* loaded from: classes.dex */
final class C0533c extends Bluetooth {

    /* renamed from: a */
    private AudioManager f384a;

    public C0533c(Context context) {
        super(context);
        this.f384a = (AudioManager) this.mContext.getSystemService(SlookAirButtonRecentMediaAdapter.AUDIO_TYPE);
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
        if (AndroidVersion.USE_MUSIC_STREAM_FOR_BLUETOOTH) {
            return;
        }
        this.f384a.startBluetoothSco();
    }

    @Override // com.nuance.nmsp.client.sdk.oem.bluetooth.Bluetooth
    public final void stopBluetoothSco() {
        if (AndroidVersion.USE_MUSIC_STREAM_FOR_BLUETOOTH) {
            return;
        }
        this.f384a.stopBluetoothSco();
    }
}
