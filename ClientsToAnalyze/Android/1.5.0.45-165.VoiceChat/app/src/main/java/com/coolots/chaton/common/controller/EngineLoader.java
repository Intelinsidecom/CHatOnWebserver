package com.coolots.chaton.common.controller;

import android.os.Build;
import android.os.Process;
import com.sds.coolots.MainApplication;
import com.sds.coolots.common.controller.EngineLoadInterface;
import com.sds.coolots.common.util.Log;

/* loaded from: classes.dex */
public class EngineLoader implements EngineLoadInterface {
    private final int PF_ICS = 0;
    private final int PF_JB = 1;
    private final int PF_JBP = 2;
    private final int PF_JBP_MR2 = 3;
    private final int PF_KKP = 4;

    @Override // com.sds.coolots.common.controller.EngineLoadInterface
    public void loadEngine() {
        boolean bEnhancedFeature = false;
        if (MainApplication.mPhoneManager.getSupportFeature() != 0) {
            bEnhancedFeature = true;
        }
        int PlatformVersion = 2;
        if (Build.VERSION.SDK_INT == 16) {
            PlatformVersion = 1;
        } else if (Build.VERSION.SDK_INT == 17) {
            PlatformVersion = 2;
        } else if (Build.VERSION.SDK_INT == 18) {
            PlatformVersion = 3;
        } else if (Build.VERSION.SDK_INT == 19) {
            PlatformVersion = 4;
        }
        Log.m2963i("<CIH> version = " + Build.VERSION.SDK_INT);
        try {
            System.loadLibrary("sisosrtp");
            if (PlatformVersion == 2) {
                System.loadLibrary("SamsungAudioEngine_JBP");
            } else if (PlatformVersion == 3) {
                System.loadLibrary("SamsungAudioEngine_JBP_4_3");
            } else {
                System.loadLibrary("SamsungAudioEngine_SDK");
            }
            if (bEnhancedFeature) {
                System.loadLibrary("stylize");
                System.loadLibrary("dmcFaceEngineWithGaze");
            }
            System.loadLibrary("PSI");
            System.loadLibrary("rtp");
            System.loadLibrary("rtppayload");
            System.loadLibrary("rtpreorder");
            System.loadLibrary("FaceEmotionlib");
            if (MainApplication.mPhoneManager.isConfTest()) {
                System.loadLibrary("ImgProcessing");
                System.loadLibrary("openmp");
                System.loadLibrary("FaceTrackerlib");
                System.loadLibrary("FxAvatarApi");
            }
            if (PlatformVersion == 0) {
                System.loadLibrary("samsung_videoengine_ICS");
                System.loadLibrary("SamsungMediaEngineRecorder_ICS");
            } else if (PlatformVersion == 1) {
                System.loadLibrary("samsung_videoengine_JB");
                System.loadLibrary("SamsungMediaEngineRecorder_JB");
            } else if (PlatformVersion == 2) {
                System.loadLibrary("samsung_videoengine_JBP");
                System.loadLibrary("SamsungMediaEngineRecorder_JBP");
            } else if (PlatformVersion == 3) {
                System.loadLibrary("samsung_videoengine_JBP_43");
                System.loadLibrary("SamsungMediaEngineRecorder_JBP_43");
            } else {
                System.loadLibrary("samsung_videoengine_JBP_44");
                System.loadLibrary("SamsungMediaEngineRecorder_JBP_44");
            }
            MainApplication.mPhoneManager.isTranslateTest();
            if (PlatformVersion == 0) {
                System.loadLibrary("pjsip_jni_ICS");
                return;
            }
            if (PlatformVersion == 1) {
                System.loadLibrary("pjsip_jni_JB");
                return;
            }
            if (PlatformVersion == 2) {
                System.loadLibrary("pjsip_jni_JBP");
            } else if (PlatformVersion == 3) {
                System.loadLibrary("pjsip_jni_JBP_4_3");
            } else {
                System.loadLibrary("pjsip_jni_KK");
            }
        } catch (UnsatisfiedLinkError error) {
            error.printStackTrace();
            Process.killProcess(Process.myPid());
        }
    }
}
