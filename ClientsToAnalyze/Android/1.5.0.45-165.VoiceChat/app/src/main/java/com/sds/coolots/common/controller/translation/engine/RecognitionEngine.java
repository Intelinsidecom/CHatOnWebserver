package com.sds.coolots.common.controller.translation.engine;

import com.sds.coolots.MainApplication;
import com.sds.coolots.common.controller.translation.C1248b;
import com.sds.coolots.common.controller.translation.data.TranslationData;
import com.sds.coolots.common.util.Log;
import java.util.Set;

/* loaded from: classes.dex */
public abstract class RecognitionEngine {

    /* renamed from: a */
    private static final String f3012a = "[RecognitionEngine]";

    /* renamed from: b */
    private boolean f3013b;
    protected String mID;
    protected String mUserID;
    protected int mVoiceLanguage = 0;
    protected int mTranslationLanguage = 0;

    /* renamed from: a */
    private void m2915a(String str) {
        Log.m2958e(f3012a + str);
    }

    /* renamed from: b */
    private void m2916b(String str) {
        Log.m2963i(f3012a + str);
    }

    public void dispose() {
        m2916b("dispose()");
    }

    public abstract Set getSupportedLanguage();

    public abstract int getVoiceLanguage();

    public void init() {
        m2916b("init()");
    }

    public boolean isActive() {
        return this.f3013b;
    }

    public abstract boolean isSupportedLanguage(int i);

    protected void notifyRecognitionEnd(String str) {
        if (this.f3013b) {
            m2916b("notifyRecognitionEnd() ID: " + this.mID + " recognizedText: " + str);
            TranslationData translationData = new TranslationData(this.mID, this.mUserID, this.mVoiceLanguage, this.mTranslationLanguage, 0, str, null);
            if (MainApplication.mPhoneManager.getPhoneStateMachine().getTranslationNotificationManager() != null) {
                MainApplication.mPhoneManager.getPhoneStateMachine().getTranslationNotificationManager().onRecognitionEnd(translationData);
            }
            this.mID = null;
            this.mUserID = null;
        }
    }

    protected void notifyRecognitionStart() {
        if (this.f3013b) {
            this.mID = C1248b.m2881a();
            this.mUserID = MainApplication.mConfig.getProfileUserID();
            m2916b("notifyRecognitionStart() id: " + this.mID);
            TranslationData translationData = new TranslationData(this.mID, this.mUserID, this.mVoiceLanguage, this.mTranslationLanguage, 0, null, null);
            if (MainApplication.mPhoneManager.getPhoneStateMachine().getTranslationNotificationManager() != null) {
                MainApplication.mPhoneManager.getPhoneStateMachine().getTranslationNotificationManager().onRecognitionStart(translationData);
            }
        }
    }

    public void setLangauge(int i, int i2) {
        m2916b("setLangauge()");
        this.mVoiceLanguage = i;
        this.mTranslationLanguage = i2;
    }

    public void start() {
        m2916b("start()");
        this.f3013b = true;
    }

    public void stop() {
        m2916b("stop()");
        this.f3013b = false;
    }

    protected String toValidRecognizedString(String str) {
        String strTrim = str != null ? str.trim() : str;
        if (strTrim == null || !strTrim.isEmpty()) {
            return strTrim;
        }
        return null;
    }
}
