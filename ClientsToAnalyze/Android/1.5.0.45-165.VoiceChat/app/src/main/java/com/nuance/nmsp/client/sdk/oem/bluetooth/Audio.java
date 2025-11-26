package com.nuance.nmsp.client.sdk.oem.bluetooth;

import android.media.MediaRecorder;

/* loaded from: classes.dex */
public class Audio {
    public static final int AUDIO_RECORD_AUDIO_SOURCE;
    public static final int AUDIO_TRACK_VOICE_CALL_STREAM;

    static {
        Integer num = (Integer) new Reflection().getFieldValue(MediaRecorder.AudioSource.class, "VOICE_RECOGNITION");
        if (num == null) {
            num = 0;
        }
        AUDIO_RECORD_AUDIO_SOURCE = num.intValue();
        AUDIO_TRACK_VOICE_CALL_STREAM = 0;
    }
}
