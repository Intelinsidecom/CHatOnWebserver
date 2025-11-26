package kr.p019co.hcilab.powertts;

/* loaded from: classes.dex */
public class PowerTTS_Java {
    public native int PTTS_Initialize();

    public native int PTTS_LoadEngine(int i, String str, int i2);

    public native int PTTS_PauseTTS();

    public native int PTTS_PlayTTS(String str, String str2, int i, int i2);

    public native int PTTS_ResumeTTS();

    public native int PTTS_SetOemKey(String str);

    public native int PTTS_SetPinyinMode(int i);

    public native int PTTS_SetPitch(int i);

    public native int PTTS_SetReadingBracket(int i);

    public native int PTTS_SetSpeed(int i);

    public native int PTTS_SetVolume(int i);

    public native int PTTS_StopTTS();

    public native int PTTS_TextToBuffer(String str, String str2, int i, int i2, int i3);

    public native int PTTS_TextToFile(int i, int i2, int i3, int i4, int i5, String str, String str2, String str3, String str4);

    public native void PTTS_UnInitialize();

    public native void PTTS_UnLoadEngine(int i);

    public static void JavaTTSCallBack(int nShortArray, short[] pData, short status) {
    }

    static {
        System.loadLibrary("powertts-samsungmobile");
    }
}
