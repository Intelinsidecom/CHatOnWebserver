package com.nuance.nmsp.client.sdk.oem;

import com.nuance.nmsp.client.sdk.common.defines.NMSPDefines;
import com.nuance.nmsp.client.sdk.common.oem.api.LogFactory;
import com.nuance.nmsp.client.sdk.components.general.Parameter;
import com.nuance.nmsp.client.sdk.oem.AudioSystemOEM;
import java.util.Vector;

/* loaded from: classes.dex */
public class EndPointerOEM {

    /* renamed from: a */
    private LogFactory.Log f305a = LogFactory.getLog(getClass());

    /* renamed from: b */
    private boolean f306b = false;

    /* renamed from: c */
    private AudioSystemOEM.C05181 f307c = new AudioSystemOEM.C05181(this, (byte) 0);

    public static class EpType {
        public static final EpType DETECT_NOTHING = new EpType(1);
        public static final EpType SPEECH_END = new EpType(2);
        public static final EpType SPEECH_START = new EpType(3);

        /* renamed from: a */
        private int f308a;

        private EpType(int i) {
            this.f308a = 1;
            this.f308a = i;
        }

        public static EpType getEpType(int i) {
            return SPEECH_END.f308a == i ? SPEECH_END : SPEECH_START.f308a == i ? SPEECH_START : DETECT_NOTHING;
        }
    }

    private static native int getCurrentEndPointerState();

    private static native void initializeEndPointer(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9);

    private static native int resetVad();

    public EpType detectEndPointing() {
        return this.f306b ? EpType.getEpType(getCurrentEndPointerState()) : EpType.DETECT_NOTHING;
    }

    public void initialize(Vector vector) {
        this.f307c.f254a = 0;
        this.f307c.f255b = 0;
        this.f307c.f256c = 50;
        this.f307c.f257d = 15;
        this.f307c.f258e = 7;
        this.f307c.f260g = 50;
        this.f307c.f261h = 5;
        this.f307c.f262i = 35;
        this.f307c.f259f = 0;
        if (vector != null) {
            for (int i = 0; i < vector.size(); i++) {
                Parameter parameter = (Parameter) vector.get(i);
                String name = parameter.getName();
                if (name.equals(NMSPDefines.NMSP_DEFINES_ENDPOINTER)) {
                    if (new String(parameter.getValue()).equalsIgnoreCase("TRUE")) {
                        if (this.f305a.isDebugEnabled()) {
                            this.f305a.debug("Stop on end of speech is activated.");
                        }
                        this.f307c.f254a = 1;
                    }
                } else if (name.equals(NMSPDefines.NMSP_DEFINES_ENDPOINTER_SPEEX_VAD_LONG_UTTERANCE)) {
                    if (new String(parameter.getValue()).equalsIgnoreCase("TRUE")) {
                        this.f307c.f255b = 1;
                    }
                } else if (name.equals("ep.VadHistoryLength")) {
                    this.f307c.f256c = Integer.parseInt(new String(parameter.getValue()));
                } else if (name.equals("ep.VadBeginLength")) {
                    this.f307c.f257d = Integer.parseInt(new String(parameter.getValue()));
                } else if (name.equals("ep.VadBeginThreshold")) {
                    this.f307c.f258e = Integer.parseInt(new String(parameter.getValue()));
                } else if (name.equals("ep.VadEndLength")) {
                    this.f307c.f260g = Integer.parseInt(new String(parameter.getValue()));
                } else if (name.equals("ep.VadEndThreshold")) {
                    this.f307c.f261h = Integer.parseInt(new String(parameter.getValue()));
                } else if (name.equals("ep.VadInterSpeechLength")) {
                    this.f307c.f262i = Integer.parseInt(new String(parameter.getValue()));
                } else if (name.equals(NMSPDefines.NMSP_DEFINES_ENDPOINTER_SPEEX_VAD_BEGIN_DELAY)) {
                    this.f307c.f259f = Integer.parseInt(new String(parameter.getValue()));
                }
            }
        }
        this.f306b = this.f307c.f254a == 1;
        if (this.f306b) {
            initializeEndPointer(this.f307c.f254a, this.f307c.f255b, this.f307c.f256c, this.f307c.f257d, this.f307c.f258e, this.f307c.f259f, this.f307c.f260g, this.f307c.f261h, this.f307c.f262i);
            resetEndpointingDetection();
        }
    }

    public boolean isEndPointingActive() {
        return this.f306b;
    }

    public void resetEndpointingDetection() {
        if (this.f306b) {
            resetVad();
        }
    }
}
