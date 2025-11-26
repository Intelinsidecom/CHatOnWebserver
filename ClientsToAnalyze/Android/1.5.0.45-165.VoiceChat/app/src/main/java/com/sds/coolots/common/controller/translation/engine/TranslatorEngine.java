package com.sds.coolots.common.controller.translation.engine;

import com.sds.coolots.MainApplication;
import com.sds.coolots.common.controller.translation.data.TranslationData;
import com.sds.coolots.common.util.Log;
import java.util.Map;

/* loaded from: classes.dex */
public abstract class TranslatorEngine {

    /* renamed from: a */
    private static final String f3015a = "[TranslatorEngine]";

    /* renamed from: b */
    private boolean f3016b;
    protected int mHandlerArg1End;
    protected int mHandlerArg1Start;
    protected int mHandlerWhat;
    protected String mID;
    protected int mInLanguage = 0;
    protected int mOutLanguage = 0;
    protected String mUserID;

    /* renamed from: a */
    private void m2917a(String str) {
        Log.m2958e(f3015a + str);
    }

    /* renamed from: b */
    private void m2918b(String str) {
        Log.m2963i(f3015a + str);
    }

    public void dispose() {
    }

    public abstract int getInLanguage();

    public abstract int getOutLanguage();

    public abstract Map getSupportedLanguage();

    public void init() {
        m2918b("init()");
    }

    public boolean isActive() {
        return this.f3016b;
    }

    public abstract boolean isSupportedLanguage(int i, int i2);

    public void notifyTanslationEnd(String str) {
        if (this.f3016b) {
            TranslationData translationData = new TranslationData(this.mID, this.mUserID, this.mInLanguage, this.mOutLanguage, 0, null, str);
            if (MainApplication.mPhoneManager.getPhoneStateMachine().getTranslationNotificationManager() != null) {
                MainApplication.mPhoneManager.getPhoneStateMachine().getTranslationNotificationManager().onTranslationEnd(translationData);
            }
        }
    }

    public void notifyTranslationStart() {
        if (this.f3016b) {
            TranslationData translationData = new TranslationData(this.mID, this.mUserID, this.mInLanguage, this.mOutLanguage, 0, null, null);
            if (MainApplication.mPhoneManager.getPhoneStateMachine().getTranslationNotificationManager() != null) {
                MainApplication.mPhoneManager.getPhoneStateMachine().getTranslationNotificationManager().onTranslationStart(translationData);
            }
        }
    }

    public void setLangauge(int i, int i2) {
        m2918b("setLangauge()");
        this.mInLanguage = i;
        this.mOutLanguage = i2;
    }

    public void start(String str, String str2, String str3) {
        m2918b("start()");
        this.mID = str;
        this.mUserID = str2;
        this.f3016b = true;
    }

    public void stop() {
        m2918b("stop()");
        this.f3016b = false;
    }
}
