package com.nuance.nmsp.client.sdk.common.defines;

import com.nuance.nmsp.client.sdk.common.protocols.ProtocolDefines;
import com.nuance.nmsp.client.sdk.common.util.Enum;
import com.nuance.nmsp.client.sdk.common.util.ShortConstant;
import com.nuance.nmsp.client.sdk.components.resource.common.ResourceListener;

/* loaded from: classes.dex */
public class NMSPDefines {
    public static final String ConnectionTimeout = "ConnectionTimeout";
    public static final String DEVICE_CMD_LOG_TO_SERVER_ENABLED = "DEVICE_CMD_LOG_TO_SERVER_ENABLED";
    public static final String IdleSessionTimeout = "IdleSessionTimeout";
    public static final String NMSP_DEFINES_ANDROID_CONTEXT = "Android_Context";
    public static final String NMSP_DEFINES_AUDIO_INPUTSOURCE = "Audio_Source";
    public static final String NMSP_DEFINES_CAPTURING_CONTINUES_ON_ENDPOINTER = "NMSP_DEFINES_CAPTURING_CONTINUES_ON_ENDPOINTER";
    public static final String NMSP_DEFINES_DISABLE_BLUETOOTH = "Disable_Bluetooth";
    public static final String NMSP_DEFINES_ENDPOINTER = "ep.enable";
    public static final String NMSP_DEFINES_ENDPOINTER_AMR_BOS_BACKOFF = "ep.amr.BOS_BACKOFF";
    public static final String NMSP_DEFINES_ENDPOINTER_AMR_EOS_BACKOFF = "ep.amr.EOS_BACKOFF";
    public static final String NMSP_DEFINES_ENDPOINTER_AMR_MEDIAN_ORDER = "ep.amr.MEDIAN_ORDER";
    public static final String NMSP_DEFINES_ENDPOINTER_AMR_POST_VOWEL_TIMEOUT = "ep.amr.POST_VOWEL_TIMEOUT";
    public static final String NMSP_DEFINES_ENDPOINTER_AMR_PRE_VOWEL_TIMEOUT = "ep.amr.PRE_VOWEL_TIMEOUT";
    public static final String NMSP_DEFINES_ENDPOINTER_AMR_VOWEL_THRESHOLD = "ep.amr.VOWEL_THRESHOLD";
    public static final String NMSP_DEFINES_ENDPOINTER_SPEEX_VAD_BEGIN_DELAY = "ep.VadBeginDelay";
    public static final String NMSP_DEFINES_ENDPOINTER_SPEEX_VAD_LONG_UTTERANCE = "ep.VadLongUtterance";
    public static final String NMSP_DEFINES_RECORDER_CONTINUES_ON_ENDPOINTER_AND_TIMER_STOPPING = "NMSP_DEFINES_RECORDER_CONTINUES_ON_ENDPOINTER_AND_TIMER_STOPPING";
    public static final String NMSP_DEFINES_SSL_CERT_DATA = "SSL_Cert_Data";
    public static final String NMSP_DEFINES_SSL_CERT_SUMMARY = "SSL_Cert_Summary";
    public static final String NMSP_DEFINES_SSL_SELFSIGNED_CERT = "SSL_SelfSigned_Cert";
    public static final String NMSP_DEFINES_SSL_SOCKET = "SSL_Socket_Enable";
    public static final String NMSP_DEFINES_USE_ENERGY_LEVEL = "USE_ENERGY_LEVEL";
    public static final String SocketConnectionSetting = "SocketConnectionSetting";
    public static final String VERSION = "NMSP 3.9 client SDK - build 12";

    public static class AudioSystem {

        public static class InputDevice extends Enum {
            public static InputDevice MICROPHONE = new InputDevice(0);
            public static InputDevice NETWORK = new InputDevice(1);
            public static InputDevice BLUETOOTH_HEADSET = new InputDevice(2);
            public static InputDevice WIRED_HEADSET = new InputDevice(3);

            private InputDevice(int i) {
                super(i);
            }
        }

        public static class OutputDevice extends Enum {
            public static OutputDevice SPEAKER = new OutputDevice(0);
            public static OutputDevice NETWORK = new OutputDevice(1);
            public static OutputDevice BLUETOOTH_HEADSET = new OutputDevice(2);
            public static OutputDevice BLUETOOTH_A2DP = new OutputDevice(3);
            public static OutputDevice WIRED_HEADSET = new OutputDevice(4);

            private OutputDevice(int i) {
                super(i);
            }
        }
    }

    public static class Codec extends ShortConstant {
        public static final Codec AMR_00 = new Codec(80, false);
        public static final Codec AMR_01 = new Codec(81, false);
        public static final Codec AMR_02 = new Codec(82, false);
        public static final Codec AMR_03 = new Codec(83, false);
        public static final Codec AMR_04 = new Codec(84, false);
        public static final Codec AMR_05 = new Codec(85, false);
        public static final Codec AMR_06 = new Codec(86, false);
        public static final Codec AMR_07 = new Codec(87, false);
        public static final Codec ULAW = new Codec(8, false);
        public static final Codec MP3 = new Codec(ResourceListener.COMPLETION_CAUSE_3RD_PARTY_APP_ERROR, true);
        public static final Codec MS_GSM_FR = new Codec(656, true);
        public static final Codec AMR_NBO_R0 = new Codec(128, false);
        public static final Codec AMR_NBO_R1 = new Codec(129, false);
        public static final Codec AMR_NBO_R2 = new Codec(130, false);
        public static final Codec AMR_NBO_R3 = new Codec(131, false);
        public static final Codec AMR_NBO_R4 = new Codec(132, false);
        public static final Codec AMR_NBO_R5 = new Codec(133, false);
        public static final Codec AMR_NBO_R6 = new Codec(134, false);
        public static final Codec AMR_NBO_R7 = new Codec(135, false);
        public static final Codec QCELP13 = new Codec(98, false);
        public static final Codec QCELPVar = new Codec(99, false);
        public static final Codec EVRC = new Codec(112, false);
        public static final Codec ILBC_R0 = new Codec(144, false);
        public static final Codec ILBC_R1 = new Codec(145, false);
        public static final Codec SPEEX_8K = new Codec(ProtocolDefines.XMODE_COP_COMMAND_CONFIRM, true);
        public static final Codec SPEEX_16K = new Codec(278, true);
        public static final Codec SPEEX_11K = new Codec(360, true);
        public static final Codec PCM_16_8K = new Codec(2, true);
        public static final Codec PCM_16_11K = new Codec(4, true);
        public static final Codec PCM_16_16K = new Codec(5, true);
        public static final Codec PCM_16_32K = new Codec(6, true);
        public static final Codec PCM_16_22K = new Codec(7, true);

        private Codec(short s, boolean z) {
            super(z ? s : (short) 0);
        }

        public final boolean isSupported() {
            return this.value != 0;
        }
    }
}
