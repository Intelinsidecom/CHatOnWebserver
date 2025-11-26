package com.nuance.nmsp.client.sdk.components.audiorecord;

import com.nuance.nmsp.client.sdk.components.general.NMSPAudioSink;
import com.nuance.nmsp.client.sdk.components.resource.common.ResourceException;
import java.util.Vector;

/* loaded from: classes.dex */
public interface Recorder {
    public static final String BUFFER_RECORDED = "BUFFER_RECORDED";
    public static final String CAPTURE_TIMEOUT = "CAPTURE_TIMEOUT";
    public static final String END_OF_SPEECH = "END_OF_SPEECH";
    public static final String RECORD_ERROR = "RECORD_ERROR";
    public static final String STARTED = "STARTED";
    public static final String START_OF_SPEECH = "START_OF_SPEECH";
    public static final String STOPPED = "STOPPED";

    Vector getParams(Vector vector) throws ResourceException;

    void startCapturing(NMSPAudioSink nMSPAudioSink, int i);

    void startRecording();

    void startRecording(NMSPAudioSink nMSPAudioSink, int i);

    void stopCapturing();

    void stopRecording();
}
