package com.voiceengine;

import android.media.AudioRecord;
import android.media.AudioTrack;
import android.util.Log;

/* loaded from: classes.dex */
public class SamsungAudioEngine {
    private static /* synthetic */ int[] $SWITCH_TABLE$com$voiceengine$SamsungAudioEngine$WaveInOutEvent = null;
    private static Band BAND = null;
    private static final int ONE_FRAME_TIME = 20;
    private static final int PLAYOUT_TIME = 10;
    private static int SAMPLING_RATE;
    private static int WAVE_IN_MONO_FRAME_SIZE;
    private static int WAVE_IN_STEREO_FRAME_SIZE;
    private static int WAVE_OUT_MONO_FRAME_SIZE;
    private static int WAVE_OUT_STEREO_FRAME_SIZE;
    private static int audioFormat;
    private static int audioSource;
    private static int audioStream;
    static int bufferSizeInBytes;
    private static int channelInConfig;
    private static int channelOutConfig;
    private static long playbackPos;
    private static int sampleRateInHz;
    private static int WAVE_IN_MONO_FRAME_SIZE_BYTE = 0;
    private static int WAVE_IN_STEREO_FRAME_SIZE_BYTE = 0;
    private static int WAVE_OUT_MONO_FRAME_SIZE_BYTE = 0;
    private static int WAVE_OUT_STEREO_FRAME_SIZE_BYTE = 0;
    private static AudioRecord audioRecord = null;
    private static AudioTrack audioTrack = null;
    private static boolean bInStereo = true;
    private static boolean bOutStereo = false;
    private static byte[] WaveIn_buf = null;
    private static byte[] WaveOut_buf = null;
    static WaveInOutEvent[] wave_event = WaveInOutEvent.valuesCustom();

    enum Band {
        NARROW,
        WIDE,
        SILKSW,
        SUPERWIDE,
        FULL;

        /* renamed from: values, reason: to resolve conflict with enum method */
        public static Band[] valuesCustom() {
            Band[] bandArrValuesCustom = values();
            int length = bandArrValuesCustom.length;
            Band[] bandArr = new Band[length];
            System.arraycopy(bandArrValuesCustom, 0, bandArr, 0, length);
            return bandArr;
        }
    }

    enum WaveInOutEvent {
        SAE_WAVE_IN_OPEN,
        SAE_WAVE_IN_START,
        SAE_WAVE_IN_READ,
        SAE_WAVE_IN_STOP,
        SAE_WAVE_IN_CLOSE,
        SAE_WAVE_OUT_OPEN,
        SAE_WAVE_OUT_START,
        SAE_WAVE_OUT_WRITE,
        SAE_WAVE_OUT_STOP,
        SAE_WAVE_OUT_CLOSE,
        SAE_WAVE_OUT_GETPOS;

        /* renamed from: values, reason: to resolve conflict with enum method */
        public static WaveInOutEvent[] valuesCustom() {
            WaveInOutEvent[] waveInOutEventArrValuesCustom = values();
            int length = waveInOutEventArrValuesCustom.length;
            WaveInOutEvent[] waveInOutEventArr = new WaveInOutEvent[length];
            System.arraycopy(waveInOutEventArrValuesCustom, 0, waveInOutEventArr, 0, length);
            return waveInOutEventArr;
        }
    }

    public static native int SAE_CreateChannel();

    public static native int SAE_CreateStream(int i, long j);

    public static native int SAE_DeleteChannel(int i);

    public static native int SAE_DeleteStream(int i, int i2);

    public static native int SAE_EnableDtx(int i, int i2);

    public static native int SAE_EnableRTCP(int i, int i2);

    public static native int SAE_EnableSRTP(int i, int i2, int i3, String str, int i4);

    public static native int SAE_GetRecPort(int i);

    public static native int SAE_GetSendIP(int i, String str, int i2);

    public static native int SAE_GetSendPort(int i);

    public static native int SAE_GetVersion(String str, int i);

    public static native int SAE_Init();

    public static native int SAE_MutePlayOut(int i, int i2);

    public static native int SAE_MuteRecord(int i);

    public static native int SAE_PlayPCMAsMicrophone(int i, String str, int i2, int i3);

    public static native int SAE_PlaySound(int i, String str, int i2);

    public static native byte[] SAE_ReceiveWaveOutFrame();

    public static native int SAE_SendDTMF(int i, int i2);

    public static native int SAE_SendWaveInFrame(byte[] bArr, int i);

    public static native int SAE_SetAECConfig(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17, int i18, int i19, int i20, int i21, int i22, int i23, int i24, int i25, int i26, int i27, int i28, int i29, int i30, int i31, int i32, int i33);

    public static native int SAE_SetAECStatus(int i);

    public static native int SAE_SetAMRTxCMR(int i, int i2);

    public static native int SAE_SetDTMFMode(int i, int i2);

    public static native int SAE_SetDTMFPayloadType(int i, int i2);

    public static native int SAE_SetPacketizationMode(int i, String str, int i2);

    public static native int SAE_SetRXAGCStatus(int i);

    public static native int SAE_SetRXCNGStatus(int i);

    public static native int SAE_SetRXFIRStatus(int i);

    public static native int SAE_SetRXLiveVolStatus(int i);

    public static native int SAE_SetRXNSStatus(int i);

    public static native int SAE_SetRXVBStatus(int i);

    public static native int SAE_SetRecPort(int i, int i2);

    public static native int SAE_SetRxAGCConfig(int i, int i2, int i3, int i4);

    public static native int SAE_SetRxCNGConfig(int i);

    public static native int SAE_SetRxFIRConfig(int i, int i2, int i3, int i4, int i5, int i6, int i7);

    public static native int SAE_SetRxLiveVolConfig(int i);

    public static native int SAE_SetRxNsGainConfig(int i, int i2);

    public static native int SAE_SetRxVBConfig(int i, int i2, int i3, int i4);

    public static native int SAE_SetSendCodec(int i, String str);

    public static native int SAE_SetSendIP(int i, String str);

    public static native int SAE_SetSendPort(int i, int i2);

    public static native int SAE_SetSendSSRC(int i, long j);

    public static native int SAE_SetTOS(int i, int i2);

    public static native int SAE_SetTXAGCStatus(int i);

    public static native int SAE_SetTXFIRStatus(int i);

    public static native int SAE_SetTXLiveVolStatus(int i);

    public static native int SAE_SetTXMuteStatus(int i);

    public static native int SAE_SetTXNSStatus(int i);

    public static native int SAE_SetTrace(int i);

    public static native int SAE_SetTraceEx(int i);

    public static native int SAE_SetTxAGCConfig(int i, int i2, int i3, int i4);

    public static native int SAE_SetTxFIRConfig(int i, int i2, int i3, int i4, int i5, int i6, int i7);

    public static native int SAE_SetTxLiveVolConfig(int i);

    public static native int SAE_SetTxNsGainConfig(int i, int i2);

    public static native int SAE_SetVEStatus(int i, int i2);

    public static native int SAE_StartFDSR(int i);

    public static native int SAE_StartRecording(int i, int i2, String str, int i3);

    public static native int SAE_StopFDSR(int i);

    public static native int SAE_StopPlayingFileAsMicrophone(int i);

    public static native int SAE_StopRecording(int i, int i2);

    public static native int SAE_Terminate();

    public static native int SAE_UnMutePlayOut(int i, int i2);

    public static native int SAE_UnMuteRecord(int i);

    static /* synthetic */ int[] $SWITCH_TABLE$com$voiceengine$SamsungAudioEngine$WaveInOutEvent() {
        int[] iArr = $SWITCH_TABLE$com$voiceengine$SamsungAudioEngine$WaveInOutEvent;
        if (iArr == null) {
            iArr = new int[WaveInOutEvent.valuesCustom().length];
            try {
                iArr[WaveInOutEvent.SAE_WAVE_IN_CLOSE.ordinal()] = 5;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[WaveInOutEvent.SAE_WAVE_IN_OPEN.ordinal()] = 1;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[WaveInOutEvent.SAE_WAVE_IN_READ.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                iArr[WaveInOutEvent.SAE_WAVE_IN_START.ordinal()] = 2;
            } catch (NoSuchFieldError e4) {
            }
            try {
                iArr[WaveInOutEvent.SAE_WAVE_IN_STOP.ordinal()] = 4;
            } catch (NoSuchFieldError e5) {
            }
            try {
                iArr[WaveInOutEvent.SAE_WAVE_OUT_CLOSE.ordinal()] = 10;
            } catch (NoSuchFieldError e6) {
            }
            try {
                iArr[WaveInOutEvent.SAE_WAVE_OUT_GETPOS.ordinal()] = 11;
            } catch (NoSuchFieldError e7) {
            }
            try {
                iArr[WaveInOutEvent.SAE_WAVE_OUT_OPEN.ordinal()] = 6;
            } catch (NoSuchFieldError e8) {
            }
            try {
                iArr[WaveInOutEvent.SAE_WAVE_OUT_START.ordinal()] = 7;
            } catch (NoSuchFieldError e9) {
            }
            try {
                iArr[WaveInOutEvent.SAE_WAVE_OUT_STOP.ordinal()] = 9;
            } catch (NoSuchFieldError e10) {
            }
            try {
                iArr[WaveInOutEvent.SAE_WAVE_OUT_WRITE.ordinal()] = 8;
            } catch (NoSuchFieldError e11) {
            }
            $SWITCH_TABLE$com$voiceengine$SamsungAudioEngine$WaveInOutEvent = iArr;
        }
        return iArr;
    }

    public SamsungAudioEngine() {
        Log.d("SAE", "jar: SamsungAudioEngine constructor called");
    }

    public static void init() {
        Log.d("SAE", "jar: SamsungAudioEngine init() called");
        audioFormat = 2;
        bOutStereo = false;
        SAMPLING_RATE = 44100;
        WAVE_IN_MONO_FRAME_SIZE = SAMPLING_RATE / 50;
        WAVE_IN_STEREO_FRAME_SIZE = WAVE_IN_MONO_FRAME_SIZE * 2;
        WAVE_OUT_MONO_FRAME_SIZE = WAVE_IN_MONO_FRAME_SIZE / 2;
        WAVE_OUT_STEREO_FRAME_SIZE = WAVE_IN_STEREO_FRAME_SIZE / 2;
        if (audioFormat == 2) {
            WAVE_OUT_MONO_FRAME_SIZE_BYTE = WAVE_OUT_MONO_FRAME_SIZE * 2;
        } else if (audioFormat == 3) {
            WAVE_OUT_MONO_FRAME_SIZE_BYTE = WAVE_OUT_MONO_FRAME_SIZE;
        }
        WaveOut_buf = new byte[WAVE_OUT_MONO_FRAME_SIZE_BYTE];
        Log.d("SAE", "jar: WaveOut_buf allocated!!! ");
    }

    public static int nativeEventHandler(int event) throws IllegalStateException {
        int readSize;
        switch ($SWITCH_TABLE$com$voiceengine$SamsungAudioEngine$WaveInOutEvent()[wave_event[event].ordinal()]) {
            case 1:
                Log.d("SAE", "jar: SAE_WAVE_IN_OPEN");
                if (bInStereo) {
                    if (audioFormat == 2) {
                        WAVE_IN_STEREO_FRAME_SIZE_BYTE = WAVE_IN_STEREO_FRAME_SIZE * 2;
                    } else if (audioFormat == 3) {
                        WAVE_IN_STEREO_FRAME_SIZE_BYTE = WAVE_IN_STEREO_FRAME_SIZE;
                    }
                    WaveIn_buf = new byte[WAVE_IN_STEREO_FRAME_SIZE_BYTE];
                    channelInConfig = 12;
                } else {
                    if (audioFormat == 2) {
                        WAVE_IN_MONO_FRAME_SIZE_BYTE = WAVE_IN_MONO_FRAME_SIZE * 2;
                    } else if (audioFormat == 3) {
                        WAVE_IN_MONO_FRAME_SIZE_BYTE = WAVE_IN_MONO_FRAME_SIZE;
                    }
                    WaveIn_buf = new byte[WAVE_IN_MONO_FRAME_SIZE_BYTE];
                    channelInConfig = 16;
                }
                bufferSizeInBytes = AudioRecord.getMinBufferSize(sampleRateInHz, channelInConfig, audioFormat);
                Log.d("SAE", "jar: audio record param audioSource[" + audioSource + "] sampleRateInHz[" + sampleRateInHz + "] channelConfig[" + channelInConfig + "] audioFormat[" + audioFormat + "] bufferSizeInBytes[" + bufferSizeInBytes + "]");
                try {
                    audioRecord = new AudioRecord(audioSource, sampleRateInHz, channelInConfig, audioFormat, bufferSizeInBytes);
                    return 0;
                } catch (Exception e) {
                    Log.d("SAE", "jar: Error!!! Unable to init audio recording!");
                    e.printStackTrace();
                    return -1;
                }
            case 2:
                Log.d("SAE", "jar: SAE_WAVE_IN_START");
                if (audioRecord != null && audioRecord.getState() != 0) {
                    if (audioRecord.getRecordingState() != 1) {
                        audioRecord.stop();
                        Log.d("SAE", "jar: audioRecord.stop()");
                    }
                    audioRecord.startRecording();
                    Log.d("SAE", "jar: after calling audioRecord.startRecording()");
                    return 0;
                }
                Log.d("SAE", "jar: Error!!! SAE_WAVE_IN_START return -1");
                return -1;
            case 3:
                if (bInStereo) {
                    readSize = audioRecord.read(WaveIn_buf, 0, WAVE_IN_STEREO_FRAME_SIZE_BYTE);
                } else {
                    readSize = audioRecord.read(WaveIn_buf, 0, WAVE_IN_MONO_FRAME_SIZE_BYTE);
                }
                SAE_SendWaveInFrame(WaveIn_buf, readSize);
                return 0;
            case 4:
            case 5:
                audioRecord.stop();
                audioRecord.release();
                audioRecord = null;
                return 0;
            case 6:
            case 7:
                Log.d("SAE", "jar: SAE_WAVE_OUT_OPEN");
                channelOutConfig = 4;
                bufferSizeInBytes = AudioTrack.getMinBufferSize(sampleRateInHz, channelOutConfig, audioFormat);
                Log.d("SAE", "jar: audio track param audioStream[" + audioStream + "] sampleRateInHz[" + sampleRateInHz + "] channelConfig[" + channelOutConfig + "] audioFormat[" + audioFormat + "] bufferSizeInBytes[" + bufferSizeInBytes + "]");
                try {
                    audioTrack = new AudioTrack(audioStream, sampleRateInHz, channelOutConfig, audioFormat, bufferSizeInBytes * 2, 1);
                    if (audioTrack.getState() != 1) {
                        Log.d("SAE", "jar: Error!!! AudioTrack is not initialized");
                        return -1;
                    }
                    audioTrack.play();
                    return 0;
                } catch (Exception e2) {
                    Log.d("SAE", "jar: Error!!! Unable to init audio track!");
                    e2.printStackTrace();
                    return -1;
                }
            case 8:
                if (WaveOut_buf == null) {
                    Log.d("SAE", "jar: Error!!! WaveOut_buf is NULL ");
                    return -1;
                }
                if (bOutStereo) {
                    audioTrack.write(WaveOut_buf, 0, WAVE_OUT_STEREO_FRAME_SIZE_BYTE);
                    return 0;
                }
                audioTrack.write(WaveOut_buf, 0, WAVE_OUT_MONO_FRAME_SIZE_BYTE);
                return 0;
            case 9:
            case 10:
                audioTrack.stop();
                audioTrack.release();
                audioTrack = null;
                Log.d("SAE", "jar: !!! SAE_WAVE_OUT_STOP AudioTrack Stop!!! ");
                return 0;
            case 11:
                playbackPos = audioTrack.getPlaybackHeadPosition();
                return 0;
            default:
                return 0;
        }
    }
}
