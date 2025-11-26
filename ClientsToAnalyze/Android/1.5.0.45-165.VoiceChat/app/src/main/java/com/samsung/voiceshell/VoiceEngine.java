package com.samsung.voiceshell;

/* loaded from: classes.dex */
public class VoiceEngine {
    public static final int AL_ENROLL = 0;
    public static final int AL_VERIFY = 1;
    public static final int VR_RECOGNITON = 2;
    public static int isEarMic = 0;
    public static final String typeDefine = "/data/data/com.vlingo.midas/typeDefine.bin";
    public String m_UBMpath_default = "/system/wakeupdata/samsung/models_16k_NoE.bin";
    public final String ROOT = "/data/data/com.vlingo.midas/";

    public native int checkFileExistence(String str, int i, int[] iArr);

    public native int computeEnergyFrame(short[] sArr, int i, int i2);

    public native int consistencyCheckEnroll(String str, short s);

    public native int functionAssignment(String str, int[] iArr, int i);

    public native int getModelStatus(String str, short s);

    public native int initializeDRC();

    public native int initializeEnroll(String str);

    public native int initializeNS();

    public native int initializeVerify(String str, String str2, int i);

    public native int performContinuousAdaptation(String str, String str2);

    public native int processDRC(short[] sArr, int i);

    public native int processEnroll(String str, short s, short[] sArr);

    public native int processNSFrame(short[] sArr, int i);

    public native int processVerify(int i);

    public native int processVerifyFrame(int i, short[] sArr, int i2, String str, short[] sArr2, short[] sArr3);

    public native int setModelStatus(String str, int i, short s);

    public native int startVerify();

    public native int store1chPCM(short[] sArr, int i);

    public native int terminateEnroll();

    public native int terminateVerify();

    public int processBuffer(short[] recordBuffer, int readLength, String ROOT, short[] frameLeft, short[] CommandType) {
        throw new RuntimeException("Stub");
    }

    public void setMode(int mode) {
        throw new RuntimeException("Stub");
    }

    public int getMode() {
        throw new RuntimeException("Stub");
    }

    public void setIsRunningVoiceEngine(boolean mode) {
        throw new RuntimeException("Stub");
    }

    public boolean getIsRunningVoiceEngine() {
        throw new RuntimeException("Stub");
    }

    public void setIsRunningAdaptation(boolean mode) {
        throw new RuntimeException("Stub");
    }

    public void setAdaptationModelPath(String UBMpath) {
        throw new RuntimeException("Stub");
    }

    public boolean getIsRunningAdaptation() {
        throw new RuntimeException("Stub");
    }

    public static void init() {
        throw new RuntimeException("Stub");
    }
}
