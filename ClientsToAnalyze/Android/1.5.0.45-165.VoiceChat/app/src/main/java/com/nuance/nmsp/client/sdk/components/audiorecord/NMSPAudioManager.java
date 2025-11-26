package com.nuance.nmsp.client.sdk.components.audiorecord;

import com.nuance.nmsp.client.sdk.common.defines.NMSPDefines;
import com.nuance.nmsp.client.sdk.components.internal.audiorecord.RecorderImpl;
import com.nuance.nmsp.client.sdk.components.resource.common.Manager;
import java.util.Vector;

/* loaded from: classes.dex */
public class NMSPAudioManager {
    private NMSPAudioManager() {
    }

    public static Recorder createRecorder(NMSPAudioRecordListener nMSPAudioRecordListener, Manager manager, Vector vector, NMSPDefines.AudioSystem.InputDevice inputDevice) {
        if (nMSPAudioRecordListener == null) {
            throw new NullPointerException("NMSPAudioRecordListener can not be null!");
        }
        if (manager == null) {
            throw new NullPointerException("Manager can not be null!");
        }
        return new RecorderImpl(nMSPAudioRecordListener, manager, vector, inputDevice);
    }
}
