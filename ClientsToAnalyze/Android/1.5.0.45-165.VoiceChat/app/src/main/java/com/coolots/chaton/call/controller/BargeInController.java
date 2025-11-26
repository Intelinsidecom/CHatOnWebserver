package com.coolots.chaton.call.controller;

import android.content.Context;
import android.media.AudioManager;
import android.provider.Settings;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonRecentMediaAdapter;
import com.sds.coolots.MainApplication;
import com.sds.coolots.common.util.Log;
import com.sds.coolots.common.view.DisposeInterface;
import com.sec.android.app.IWSpeechRecognizer.BargeInRecognizer;
import com.sec.android.app.IWSpeechRecognizer.IWSpeechRecognizerListener;

/* loaded from: classes.dex */
public class BargeInController implements DisposeInterface {
    private BargeInRecognizer mBargeInRecognizer = null;
    private IBargeInListener mBargeInListener = null;
    private boolean mIsAcceptByVoice = false;

    public static void logE(String message) {
        Log.m2958e("[BargeInController]" + message);
    }

    public static void logI(String message) {
        Log.m2954d("[BargeInController]" + message);
    }

    public BargeInController() {
        logI("BargeInController new");
    }

    public static boolean canIStart(Context context, boolean isDrivingMode) {
        if (!canIStartByNativeRingerMode(isDrivingMode)) {
            return false;
        }
        boolean canIStart = getApplicationVoiceInputControlValue(context);
        if (canIStart) {
            return getIncomingcallsviaChatOnV(context);
        }
        return canIStart;
    }

    private static boolean canIStartByNativeRingerMode(boolean isDrivingMode) {
        AudioManager audioManager = (AudioManager) MainApplication.mContext.getSystemService(SlookAirButtonRecentMediaAdapter.AUDIO_TYPE);
        int ringerMode = audioManager.getRingerMode();
        logI("canIStartByNativeRingerMode(), ringerMode: " + ringerMode + ", isDrivingMode: " + isDrivingMode);
        boolean retValue = true;
        if (!isDrivingMode && ringerMode == 1) {
            logI("ringerMode: RINGER_MODE_VIBRATE (Barge-in no action)");
            retValue = false;
        }
        if (!isDrivingMode && MainApplication.mNativeSetting.isVibrateWhenRinging()) {
            logI("Vibrate when rining mode is on, so Barge-in is off.");
            return false;
        }
        return retValue;
    }

    public static boolean getApplicationVoiceInputControlValue(Context context) {
        int voiceInputControl = Settings.System.getInt(context.getContentResolver(), "voice_input_control", 0);
        logI("getApplicationVoiceInputControlValue() = " + voiceInputControl);
        return voiceInputControl != 0;
    }

    public static boolean getIncomingcallsviaChatOnV(Context context) {
        int voiceInputControl = Settings.System.getInt(context.getContentResolver(), "voice_input_control_chatonv", 0);
        logI("getIncomingcallsviaChatOnV() = " + voiceInputControl);
        return voiceInputControl != 0;
    }

    public static void setIncomingcallsviaChatOnV(Context context, boolean value) {
        if (value) {
            Settings.System.putInt(context.getContentResolver(), "voice_input_control_chatonv", 1);
        } else {
            Settings.System.putInt(context.getContentResolver(), "voice_input_control_chatonv", 0);
        }
    }

    public void initBargeIn(IBargeInListener listener) {
        logI("initBargeIn()");
        this.mBargeInListener = listener;
        if (isExistIWSpeechRecognizerListener()) {
            if (this.mBargeInRecognizer == null) {
                try {
                    this.mBargeInRecognizer = new BargeInRecognizer();
                    this.mBargeInRecognizer.InitBargeInRecognizer(new IWSpeechRecognizerListener() { // from class: com.coolots.chaton.call.controller.BargeInController.1
                        public void onResults(String[] arg0) {
                            int result = BargeInController.this.mBargeInRecognizer.getIntBargeInResult();
                            BargeInController.logI("onResults: " + result);
                            BargeInController.this.mBargeInListener.onResultBargeIn(result);
                            BargeInController.this.mIsAcceptByVoice = true;
                        }
                    });
                } catch (Exception e) {
                    logI("BargeInRecognizer Exception Occur : " + e.toString());
                    this.mBargeInRecognizer = null;
                } catch (NoSuchMethodError e2) {
                    logI("BargeInRecognizer NoSuchMethodError : " + e2.toString());
                    this.mBargeInRecognizer = null;
                }
            }
            this.mIsAcceptByVoice = false;
        }
    }

    public void pauseBargeIn() {
        logI("pauseBargeIn()");
        if (this.mBargeInRecognizer != null) {
            this.mBargeInRecognizer.stopBargeIn();
        }
    }

    public void startBargeIn() {
        logI("startBargeIn()");
        if (this.mBargeInRecognizer != null) {
            this.mBargeInRecognizer.startBargeIn(2);
        }
        if (this.mBargeInRecognizer != null) {
            this.mBargeInRecognizer.startBargeIn(2);
        }
    }

    public boolean isAcceptByVoice() {
        return this.mIsAcceptByVoice;
    }

    private boolean isExistIWSpeechRecognizerListener() throws ClassNotFoundException {
        try {
            Class myclass = Class.forName("com.sec.android.app.IWSpeechRecognizer.IWSpeechRecognizerListener");
            return myclass != null;
        } catch (ClassNotFoundException e) {
            logE("ClassNotFoundException");
            return false;
        }
    }

    @Override // com.sds.coolots.common.view.DisposeInterface
    public void dispose() {
        logI("dispose()");
        if (this.mBargeInRecognizer != null) {
            this.mBargeInRecognizer.stopBargeIn();
            this.mBargeInRecognizer = null;
        }
        this.mBargeInListener = null;
        this.mIsAcceptByVoice = false;
    }
}
