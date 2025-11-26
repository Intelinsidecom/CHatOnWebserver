package com.coolots.chaton.call.util;

import android.content.res.Configuration;
import android.content.res.Resources;
import android.media.AudioManager;
import android.os.Handler;
import android.os.Message;
import android.provider.Settings;
import android.speech.tts.TextToSpeech;
import com.coolots.chaton.C0000R;
import com.coolots.chaton.call.model.CallUserAddedInfo;
import com.coolots.chaton.call.view.VideoCallActivity;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonRecentMediaAdapter;
import com.sds.coolots.MainApplication;
import com.sds.coolots.call.TextToSpeechInterface;
import com.sds.coolots.call.model.CallStatusData;
import com.sds.coolots.call.model.Destination;
import com.sds.coolots.call.model.RingtoneInfo;
import com.sds.coolots.common.util.Log;
import java.util.HashMap;
import java.util.Locale;

/* loaded from: classes.dex */
public class CallTextToSpeech implements TextToSpeechInterface {
    private static final String CLASSNAME = "[CallTextToSpeech]";
    private AudioManager mAudioManager = null;
    private TextToSpeech mTts = null;
    private TtsListener mTtsListener = null;
    private final int INVALID_VOLUME_LEVEL = -1;
    private int mOriginTtsVolume = -1;
    private int mOriginRingVolume = -1;
    private final int FADE_IN = 100;
    private final int FADE_OUT = 200;
    private final int REPEAT_TTS = 300;
    private final int REPEAT_TTS_DELAY = 2000;
    private final int FADE_OUT_THRESHOLD_TIME = 1000;
    private final int FADE_IN_THRESHOLD_TIME = 4000;
    private final int TTS_REPEAT_COUNT_MAX = 2;
    private final int RINGTONE_MAX_VOLUME_FOR_TTS = 6;
    private int mFadeOutUpdateDelay = 0;
    private int mFadeInUpdateDelay = 0;
    private int mCurrentRingtoneVolume = -1;
    private int mTtsRepeatCount = 0;
    private String DEFAULT_TTS_STREAM = Integer.toString(5);
    private Handler mHandler = new Handler() { // from class: com.coolots.chaton.call.util.CallTextToSpeech.1
        @Override // android.os.Handler
        public void handleMessage(Message msg) {
            CallTextToSpeech.this.logE("handleMessage : " + msg.what);
            switch (msg.what) {
                case 100:
                    CallTextToSpeech.this.mCurrentRingtoneVolume++;
                    CallTextToSpeech.this.logE("FADE_IN: " + CallTextToSpeech.this.mCurrentRingtoneVolume);
                    if (CallTextToSpeech.this.mCurrentRingtoneVolume == 1) {
                        CallTextToSpeech.this.mAudioManager.setStreamMute(2, false);
                    } else {
                        CallTextToSpeech.this.mAudioManager.setStreamVolume(2, CallTextToSpeech.this.mCurrentRingtoneVolume, 0);
                    }
                    if (CallTextToSpeech.this.mCurrentRingtoneVolume > 6) {
                        if (CallTextToSpeech.this.mTtsRepeatCount < 2) {
                            CallTextToSpeech.this.mTtsRepeatCount++;
                            sendEmptyMessageDelayed(300, 2000L);
                            break;
                        } else {
                            CallTextToSpeech.this.stopTTS();
                            break;
                        }
                    } else {
                        sendEmptyMessageDelayed(100, CallTextToSpeech.this.mFadeInUpdateDelay);
                        break;
                    }
                case 200:
                    CallTextToSpeech callTextToSpeech = CallTextToSpeech.this;
                    callTextToSpeech.mCurrentRingtoneVolume--;
                    CallTextToSpeech.this.logE("FADE_OUT: " + CallTextToSpeech.this.mCurrentRingtoneVolume);
                    if (CallTextToSpeech.this.mCurrentRingtoneVolume == 0) {
                        CallTextToSpeech.this.mAudioManager.setStreamMute(2, true);
                    } else {
                        CallTextToSpeech.this.mAudioManager.setStreamVolume(2, CallTextToSpeech.this.mCurrentRingtoneVolume, 0);
                    }
                    if (CallTextToSpeech.this.mCurrentRingtoneVolume > 0) {
                        sendEmptyMessageDelayed(200, CallTextToSpeech.this.mFadeOutUpdateDelay);
                        break;
                    } else {
                        CallTextToSpeech.this.makeTTSText();
                        break;
                    }
                case 300:
                    if (CallTextToSpeech.this.mTts != null) {
                        CallTextToSpeech.this.setVolumeForTts();
                        break;
                    }
                    break;
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void logE(String message) {
        Log.m2958e(CLASSNAME + message);
    }

    private void logI(String message) {
        Log.m2963i(CLASSNAME + message);
    }

    private class TtsListener implements TextToSpeech.OnInitListener, TextToSpeech.OnUtteranceCompletedListener {
        private TtsListener() {
        }

        /* synthetic */ TtsListener(CallTextToSpeech callTextToSpeech, TtsListener ttsListener) {
            this();
        }

        @Override // android.speech.tts.TextToSpeech.OnInitListener
        public void onInit(int status) {
            Locale loc;
            if (status != 0) {
                CallTextToSpeech.this.logE("Could not initialize TextToSpeech.");
                return;
            }
            int result = -2;
            if (CallTextToSpeech.this.mTts != null) {
                String localeLanguage = Settings.System.getString(MainApplication.mContext.getContentResolver(), "voicetalk_language");
                if (localeLanguage != null && !localeLanguage.equals("")) {
                    loc = new Locale(localeLanguage);
                } else {
                    loc = Locale.getDefault();
                }
                result = CallTextToSpeech.this.mTts.setLanguage(loc);
            }
            if (result == -1 || result == -2) {
                CallTextToSpeech.this.logE("Language is not available. Locale = " + Locale.getDefault());
            } else {
                CallTextToSpeech.this.setVolumeForTts();
            }
        }

        @Override // android.speech.tts.TextToSpeech.OnUtteranceCompletedListener
        public void onUtteranceCompleted(String utteranceId) {
            CallTextToSpeech.this.logE("onUtteranceCompleted...TTS");
            CallTextToSpeech.this.mFadeInUpdateDelay = VideoCallActivity.CAMERA_VISIBLE_REAR;
            CallTextToSpeech.this.mHandler.sendEmptyMessageDelayed(100, CallTextToSpeech.this.mFadeInUpdateDelay);
        }
    }

    public CallTextToSpeech() {
        logE("CallTextToSpeech()");
    }

    @Override // com.sds.coolots.call.TextToSpeechInterface
    public void startTTS() {
        if (isReadyTTS()) {
            this.mAudioManager = (AudioManager) MainApplication.mContext.getSystemService(SlookAirButtonRecentMediaAdapter.AUDIO_TYPE);
            this.mTtsListener = new TtsListener(this, null);
            this.mTts = new TextToSpeech(MainApplication.mContext, this.mTtsListener);
        }
    }

    private boolean isReadyTTS() {
        return isDrivingModeOn() && isDrivingModeChatONVTtsOn();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setVolumeForTts() {
        this.mOriginTtsVolume = this.mAudioManager.getStreamVolume(5);
        this.mOriginRingVolume = this.mAudioManager.getStreamVolume(2);
        logE("mOriginTtsVolume = " + this.mOriginTtsVolume + " mOriginRingVolume = " + this.mOriginRingVolume);
        if (this.mOriginRingVolume <= 0) {
            logI("Volume is 0!!");
            return;
        }
        this.mCurrentRingtoneVolume = this.mOriginRingVolume < 6 ? this.mOriginRingVolume : 6;
        this.mAudioManager.setStreamVolume(5, this.mAudioManager.getStreamMaxVolume(5), 0);
        this.mAudioManager.setStreamVolume(2, this.mCurrentRingtoneVolume, 0);
        this.mFadeOutUpdateDelay = 1000 / this.mOriginRingVolume;
        this.mHandler.sendEmptyMessageDelayed(200, this.mFadeOutUpdateDelay);
    }

    private void resetVolumeForTts() {
        if (this.mOriginTtsVolume != -1) {
            this.mAudioManager.setStreamVolume(5, this.mOriginTtsVolume, 0);
            this.mOriginTtsVolume = -1;
        }
        if (this.mOriginRingVolume != -1) {
            this.mAudioManager.setStreamVolume(2, this.mOriginRingVolume, 0);
            this.mAudioManager.setStreamMute(2, false);
            this.mOriginRingVolume = -1;
        }
        this.mFadeOutUpdateDelay = 0;
        this.mFadeInUpdateDelay = 0;
        this.mCurrentRingtoneVolume = -1;
        this.mTtsRepeatCount = 0;
        this.mHandler.removeMessages(100);
        this.mHandler.removeMessages(200);
        this.mHandler.removeMessages(300);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void makeTTSText() {
        String ttsText;
        CallStatusData callInfo = new CallStatusData();
        MainApplication.mPhoneManager.getPhoneStateMachine().updateCallInfo(callInfo);
        Destination dest = callInfo.getDestination();
        DestinationUtil destUtil = new DestinationUtil();
        CallUserAddedInfo info = new CallUserAddedInfo(isConference(dest), dest, callInfo.getHostDisplayName());
        Locale systemLocale = MainApplication.mContext.getResources().getConfiguration().locale;
        Locale sVoiceLoc = getSVoiceLocale();
        changeLocale(sVoiceLoc);
        if (isReadyToStartCallWithVoiceControlMode()) {
            if (isConference(dest)) {
                ttsText = String.format(MainApplication.mContext.getResources().getString(C0000R.string.call_from_you_can_say_answer_or_reject), destUtil.getConferenceConnectedMember(dest, info, false).userName);
            } else {
                ttsText = String.format(MainApplication.mContext.getResources().getString(C0000R.string.call_from_you_can_say_answer_or_reject), info.getUserDisplayNameByUserID(dest.getString()));
            }
        } else if (isConference(dest)) {
            ttsText = String.format(MainApplication.mContext.getResources().getString(C0000R.string.incoming_call_from), destUtil.getConferenceConnectedMember(dest, info, false).userName);
        } else {
            ttsText = String.format(MainApplication.mContext.getResources().getString(C0000R.string.incoming_call_from), info.getUserDisplayNameByUserID(dest.getString()));
        }
        playTTS(ttsText);
        changeLocale(systemLocale);
    }

    private Locale getSVoiceLocale() {
        String sVoiceLocaleLanguage = Settings.System.getString(MainApplication.mContext.getContentResolver(), "voicetalk_language");
        logI("<CIH> sVoiceLocaleLanguage = " + sVoiceLocaleLanguage);
        return (sVoiceLocaleLanguage == null || sVoiceLocaleLanguage.equals("")) ? Locale.getDefault() : new Locale(sVoiceLocaleLanguage);
    }

    private void changeLocale(Locale locale) {
        Resources res = MainApplication.mContext.getResources();
        Configuration conf = res.getConfiguration();
        conf.locale = locale;
        res.updateConfiguration(conf, res.getDisplayMetrics());
    }

    private void playTTS(String text) {
        logI("<CIH> playTTS(), text = " + text);
        HashMap<String, String> myHashAlarm = new HashMap<>();
        myHashAlarm.put("streamType", this.DEFAULT_TTS_STREAM);
        myHashAlarm.put("utteranceId", "TTS ended : 1");
        if (this.mTts.isSpeaking()) {
            this.mTts.stop();
        }
        this.mTts.speak(text, 0, myHashAlarm);
        this.mTts.setOnUtteranceCompletedListener(this.mTtsListener);
    }

    @Override // com.sds.coolots.call.TextToSpeechInterface
    public void stopTTS() {
        logI("stopTTS()");
        if (this.mTts != null) {
            if (this.mTts.isSpeaking()) {
                this.mTts.stop();
            }
            if (this.mTts != null) {
                this.mTts.shutdown();
            }
            this.mTts = null;
            resetVolumeForTts();
        }
    }

    public boolean isDrivingModeChatONVTtsOn() {
        int chatonV_ttsMode = Settings.System.getInt(MainApplication.mContext.getContentResolver(), "driving_mode_chaton_call_notification", 0);
        logI("isDrivingModeChatONVTtsOn() = " + chatonV_ttsMode);
        return chatonV_ttsMode != 0;
    }

    public boolean isDrivingModeOn() {
        int driving_mode = Settings.System.getInt(MainApplication.mContext.getContentResolver(), "driving_mode_on", 0);
        logI("isDrivingModeOn() = " + driving_mode);
        return driving_mode != 0;
    }

    public boolean isReadyToStartCallWithVoiceControlMode() {
        if (!isVibrateOrMuteMode()) {
            logI("isReadyToStartCallWithVoiceControlMode() = false");
            return false;
        }
        if (getVoiceControlSettingValueFromDevice() && getVoiceControlChatONSettingValueFromDevice()) {
            logI("isReadyToStartCallWithVoiceControlMode() = true");
            return true;
        }
        logI("isReadyToStartCallWithVoiceControlMode() = false");
        return false;
    }

    private boolean getVoiceControlSettingValueFromDevice() {
        int voiceInputControl = Settings.System.getInt(MainApplication.mContext.getContentResolver(), "voice_input_control", 0);
        if (voiceInputControl == 0) {
            logI("getVoiceControlSettingValueFromDevice() = false");
            return false;
        }
        logI("getVoiceControlSettingValueFromDevice() = true");
        return true;
    }

    private boolean getVoiceControlChatONSettingValueFromDevice() {
        int voiceInputControl = Settings.System.getInt(MainApplication.mContext.getContentResolver(), "voice_input_control_chatonv", 0);
        if (voiceInputControl == 0) {
            logI("getVoiceControlChatONSettingValueFromDevice() = false");
            return false;
        }
        logI("getVoiceControlChatONSettingValueFromDevice() = true");
        return true;
    }

    private boolean isVibrateOrMuteMode() {
        AudioManager audioManager = (AudioManager) MainApplication.mContext.getSystemService(SlookAirButtonRecentMediaAdapter.AUDIO_TYPE);
        int ringerMode = audioManager.getRingerMode();
        boolean retValue = true;
        if (ringerMode == 1 || ringerMode == 0) {
            logI("ringerMode: RINGER_MODE_VIBRATE || RINGER_MODE_SILENT (Barge-in no action)");
            retValue = false;
        } else if (ringerMode == 2) {
            logI("ringerMode: RINGER_MODE_NORMAL");
            RingtoneInfo mRingtoneInfo = new RingtoneInfo(MainApplication.mRingtoneSettingData.getRingtoneFromSettingData());
            if (mRingtoneInfo.getIndex() == -1) {
                logI("ChatONV ringerMode: SILENT (Barge-in no action)");
                retValue = false;
            }
        }
        logI("isVibrateOrMuteMode() = " + retValue);
        return retValue;
    }

    public boolean isConference(Destination destination) {
        if (destination == null) {
            return false;
        }
        return destination.getDestinationType() == 4 || destination.getDestinationType() == 5;
    }
}
