package com.samsung.voiceserviceplatform.clientsdk.internal;

/* loaded from: classes.dex */
public class SpeexJNI {
    public static final int SPEEX_GET_FRAME_SIZE = 3;
    public static final int SPEEX_SET_QUALITY = 4;
    private static boolean jniLibraryLoaded;

    public static native int startEncode(byte[] bArr);

    public native void speex_bits_destroy(SpeexBits speexBits);

    public native void speex_bits_init(SpeexBits speexBits);

    public native void speex_bits_reset(SpeexBits speexBits);

    public native int speex_bits_write(SpeexBits speexBits, byte[] bArr, int i);

    public native int speex_encode_int(long j, short[] sArr, SpeexBits speexBits);

    public native int speex_encoder_ctl(long j, int i, Long l);

    public native void speex_encoder_destroy(long j);

    public native long speex_encoder_init();

    static {
        jniLibraryLoaded = false;
        if (jniLibraryLoaded) {
            return;
        }
        try {
            System.loadLibrary("speex-jni");
            jniLibraryLoaded = true;
        } catch (Throwable th) {
        }
    }

    public final boolean isSpeexLoaded() {
        return jniLibraryLoaded;
    }
}
