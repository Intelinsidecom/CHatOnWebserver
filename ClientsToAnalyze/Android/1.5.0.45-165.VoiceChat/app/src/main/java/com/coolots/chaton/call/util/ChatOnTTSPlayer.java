package com.coolots.chaton.call.util;

import android.content.res.Configuration;
import android.content.res.Resources;
import android.media.AudioManager;
import android.provider.Settings;
import android.speech.tts.TextToSpeech;
import android.util.Log;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonRecentMediaAdapter;
import com.sds.coolots.MainApplication;
import com.sds.coolots.call.model.RingtoneInfo;
import java.util.HashMap;
import java.util.Locale;

/* loaded from: classes.dex */
public class ChatOnTTSPlayer {
    private static final String CLASSNAME = "[ChatOnTTSPlayer]";
    private String mTTSString;
    private AudioManager mAudioManager = null;
    private TextToSpeech mTts = null;
    private TtsListener mTtsListener = null;
    private final int INVALID_VOLUME_LEVEL = -1;
    private int mOriginTtsVolume = -1;
    private String DEFAULT_TTS_STREAM = Integer.toString(5);

    /* JADX INFO: Access modifiers changed from: private */
    public void logE(String message) {
        Log.e(CLASSNAME, message);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void logI(String message) {
        Log.i(CLASSNAME, message);
    }

    private class TtsListener implements TextToSpeech.OnInitListener, TextToSpeech.OnUtteranceCompletedListener {
        private TtsListener() {
        }

        /* synthetic */ TtsListener(ChatOnTTSPlayer chatOnTTSPlayer, TtsListener ttsListener) {
            this();
        }

        @Override // android.speech.tts.TextToSpeech.OnInitListener
        public void onInit(int status) {
            Locale loc;
            if (status != 0) {
                ChatOnTTSPlayer.this.logE("YKKYU onInit() Could not initialize TextToSpeech.");
                return;
            }
            int result = -2;
            if (ChatOnTTSPlayer.this.mTts != null) {
                String localeLanguage = Settings.System.getString(MainApplication.mContext.getContentResolver(), "voicetalk_language");
                if (localeLanguage != null && !localeLanguage.equals("")) {
                    loc = new Locale(localeLanguage);
                } else {
                    loc = Locale.getDefault();
                }
                result = ChatOnTTSPlayer.this.mTts.setLanguage(loc);
            }
            if (result == -1 || result == -2) {
                ChatOnTTSPlayer.this.logE("YKYU onInit() Language is not available. Locale = " + Locale.getDefault());
                return;
            }
            ChatOnTTSPlayer.this.logI("YKYU onInit() -1-");
            if (!ChatOnTTSPlayer.this.setVolumeForTts()) {
                ChatOnTTSPlayer.this.stopTTS();
            } else {
                ChatOnTTSPlayer.this.setTTSText();
            }
            ChatOnTTSPlayer.this.logI("YKYU onInit() -2-");
        }

        @Override // android.speech.tts.TextToSpeech.OnUtteranceCompletedListener
        public void onUtteranceCompleted(String utteranceId) {
            ChatOnTTSPlayer.this.logI("YKYU onUtteranceCompleted...TTS");
            ChatOnTTSPlayer.this.stopTTS();
        }
    }

    public void startTTS(String TTSString) {
        this.mAudioManager = (AudioManager) MainApplication.mContext.getSystemService(SlookAirButtonRecentMediaAdapter.AUDIO_TYPE);
        this.mTtsListener = new TtsListener(this, null);
        this.mTTSString = TTSString;
        this.mTts = new TextToSpeech(MainApplication.mContext, this.mTtsListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean setVolumeForTts() {
        if (this.mAudioManager.getStreamVolume(2) <= 0) {
            return false;
        }
        this.mOriginTtsVolume = this.mAudioManager.getStreamVolume(5);
        logI("YKYU mOriginTtsVolume = " + this.mOriginTtsVolume);
        logI("YKYU MaxVolume = " + this.mAudioManager.getStreamMaxVolume(5));
        this.mAudioManager.setStreamVolume(5, this.mAudioManager.getStreamMaxVolume(5), 0);
        logI("YKYU mCurrentTtsVolume = " + this.mAudioManager.getStreamVolume(5));
        return true;
    }

    private void resetVolumeForTts() {
        if (this.mOriginTtsVolume != -1) {
            this.mAudioManager.setStreamVolume(5, this.mOriginTtsVolume, 0);
            this.mOriginTtsVolume = -1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTTSText() {
        logI("YKYU setTTSText() -start-");
        Locale sVoiceLoc = getSVoiceLocale();
        changeLocale(sVoiceLoc);
        playTTS(this.mTTSString);
        Locale systemLocale = MainApplication.mContext.getResources().getConfiguration().locale;
        changeLocale(systemLocale);
        logI("YKYU setTTSText() -end-");
    }

    private Locale getSVoiceLocale() {
        String sVoiceLocaleLanguage = Settings.System.getString(MainApplication.mContext.getContentResolver(), "voicetalk_language");
        logI("YKYU getSVoiceLocale() sVoiceLocaleLanguage = " + sVoiceLocaleLanguage);
        return (sVoiceLocaleLanguage == null || sVoiceLocaleLanguage.equals("")) ? Locale.getDefault() : new Locale(sVoiceLocaleLanguage);
    }

    private void changeLocale(Locale locale) {
        Resources res = MainApplication.mContext.getResources();
        Configuration conf = res.getConfiguration();
        conf.locale = locale;
        res.updateConfiguration(conf, res.getDisplayMetrics());
    }

    private void playTTS(String text) {
        logI("YKYU playTTS() text = " + text);
        HashMap<String, String> myHashAlarm = new HashMap<>();
        myHashAlarm.put("streamType", this.DEFAULT_TTS_STREAM);
        myHashAlarm.put("utteranceId", "TTS ended : 1");
        if (this.mTts.isSpeaking()) {
            this.mTts.stop();
        }
        this.mTts.speak(text, 0, myHashAlarm);
        this.mTts.setOnUtteranceCompletedListener(this.mTtsListener);
    }

    public void stopTTS() {
        if (this.mTts != null) {
            if (this.mTts.isSpeaking()) {
                this.mTts.stop();
                this.mTts.shutdown();
            }
            this.mTts = null;
            resetVolumeForTts();
        }
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
}
