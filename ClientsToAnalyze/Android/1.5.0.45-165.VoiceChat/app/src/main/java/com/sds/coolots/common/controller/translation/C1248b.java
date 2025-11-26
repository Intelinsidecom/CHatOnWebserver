package com.sds.coolots.common.controller.translation;

import com.sds.coolots.MainApplication;
import com.sds.coolots.common.controller.translation.data.TranslationDisplayData;
import com.sds.coolots.common.controller.translation.engine.ITTSController;
import com.sds.coolots.common.controller.translation.engine.RecognitionEngine;
import com.sds.coolots.common.controller.translation.engine.TranslatorEngine;
import com.sds.coolots.common.util.Log;
import com.sds.coolots.common.view.DisposeInterface;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;

/* renamed from: com.sds.coolots.common.controller.translation.b */
/* loaded from: classes.dex */
public class C1248b implements TranslationManagerInterface, DisposeInterface {

    /* renamed from: d */
    private static final String f2986d = "[TranslationController]";

    /* renamed from: a */
    public RecognitionEngine f2987a;

    /* renamed from: b */
    protected TranslatorEngine f2988b;

    /* renamed from: c */
    public ITTSController f2989c;

    /* renamed from: a */
    public static String m2881a() {
        return String.valueOf(new SimpleDateFormat("yyyyMMddHHmmss").format(new Date())) + "_" + MainApplication.mConfig.getProfileUserID();
    }

    /* renamed from: a */
    public static boolean m2882a(String str) {
        String strTrim;
        return (str == null || str.isEmpty() || (strTrim = str.trim()) == null || strTrim.isEmpty()) ? false : true;
    }

    /* renamed from: b */
    private void m2883b(String str) {
        Log.m2958e(f2986d + str);
    }

    /* renamed from: c */
    private void m2884c(String str) {
        Log.m2963i(f2986d + str);
    }

    @Override // com.sds.coolots.common.controller.translation.TranslationManagerInterface, com.sds.coolots.common.view.DisposeInterface
    public void dispose() {
        if (this.f2987a != null) {
            this.f2987a.dispose();
            this.f2987a = null;
        }
        if (this.f2988b != null) {
            this.f2988b.dispose();
            this.f2988b = null;
        }
        if (this.f2989c != null) {
            this.f2989c.dispose();
            this.f2989c = null;
        }
    }

    @Override // com.sds.coolots.common.controller.translation.TranslationManagerInterface
    public Set getSupportedTranslationLanguage(int i) {
        return (Set) this.f2988b.getSupportedLanguage().get(Integer.valueOf(i));
    }

    @Override // com.sds.coolots.common.controller.translation.TranslationManagerInterface
    public Set getSupportedVoiceLanguage() {
        return this.f2987a.getSupportedLanguage();
    }

    @Override // com.sds.coolots.common.controller.translation.TranslationManagerInterface
    public int getTranslationInLanguage() {
        return this.f2988b.getInLanguage();
    }

    @Override // com.sds.coolots.common.controller.translation.TranslationManagerInterface
    public int getTranslationOutLanguage() {
        return this.f2988b.getOutLanguage();
    }

    @Override // com.sds.coolots.common.controller.translation.TranslationManagerInterface
    public int getVoiceLanguage() {
        return this.f2987a.getVoiceLanguage();
    }

    @Override // com.sds.coolots.common.controller.translation.TranslationManagerInterface
    public int init(RecognitionEngine recognitionEngine, TranslatorEngine translatorEngine, ITTSController iTTSController) {
        this.f2987a = recognitionEngine;
        this.f2987a.init();
        this.f2988b = translatorEngine;
        this.f2988b.init();
        this.f2989c = iTTSController;
        this.f2989c.init();
        return 0;
    }

    @Override // com.sds.coolots.common.controller.translation.TranslationManagerInterface
    public boolean isActiveRecognition() {
        return this.f2987a.isActive();
    }

    @Override // com.sds.coolots.common.controller.translation.TranslationManagerInterface
    public void playTTS(TranslationDisplayData translationDisplayData) {
        m2884c("playTTS(): " + translationDisplayData.getTranslatedText());
        String id = translationDisplayData.getID();
        TranslationListManagerInterface translationListManager = MainApplication.mPhoneManager.getPhoneStateMachine().getTranslationListManager();
        translationListManager.setNowPlayTTS(translationDisplayData);
        this.f2989c.play(translationListManager.get(id));
    }

    @Override // com.sds.coolots.common.controller.translation.TranslationManagerInterface
    public int setLanguage(int i, int i2) {
        m2884c("setLanguage(" + i + ", " + i2 + ")");
        if (!this.f2987a.isSupportedLanguage(i)) {
            m2883b("setLanguage() 1 FAIL!");
            return 1;
        }
        if (!this.f2988b.isSupportedLanguage(i, i2)) {
            m2883b("setLanguage() 2 FAIL!");
            return 1;
        }
        this.f2987a.setLangauge(i, i2);
        this.f2988b.setLangauge(i, i2);
        m2884c(">> " + i + " + " + i2);
        return 0;
    }

    @Override // com.sds.coolots.common.controller.translation.TranslationManagerInterface
    public int setTranslatedLanguage(int i) {
        m2884c("setTranslatedLanguage(" + i + ")");
        if (!this.f2988b.isSupportedLanguage(this.f2988b.getInLanguage(), i)) {
            m2883b("setTranslatedLanguage() 2 FAIL!");
            return 1;
        }
        m2884c(">> " + this.f2988b.getInLanguage() + " + " + i);
        this.f2988b.setLangauge(this.f2988b.getInLanguage(), i);
        return 0;
    }

    @Override // com.sds.coolots.common.controller.translation.TranslationManagerInterface
    public int setVoiceLanguage(int i) {
        m2884c("setVoiceLanguage(" + i + ")");
        if (!this.f2987a.isSupportedLanguage(i)) {
            m2883b("setVoiceLanguage() 1 FAIL!");
            return 1;
        }
        if (!this.f2988b.isSupportedLanguage(i, this.f2988b.getOutLanguage())) {
            m2883b("setVoiceLanguage() 2 FAIL!");
            return 1;
        }
        this.f2987a.setLangauge(i, this.f2988b.getOutLanguage());
        this.f2988b.setLangauge(i, this.f2988b.getOutLanguage());
        m2884c(">> " + i + " + " + this.f2988b.getOutLanguage());
        return 0;
    }

    @Override // com.sds.coolots.common.controller.translation.TranslationManagerInterface
    public int startRecognition() {
        if (this.f2987a.getVoiceLanguage() == 0) {
            m2883b("startRecognition() language is not initialized");
            return 1;
        }
        m2884c("startRecognition()");
        this.f2987a.start();
        return 0;
    }

    @Override // com.sds.coolots.common.controller.translation.TranslationManagerInterface
    public int startTranslation(TranslationDisplayData translationDisplayData) {
        if (this.f2988b.getInLanguage() == 0 || this.f2988b.getOutLanguage() == 0) {
            m2883b("startTranslation() language is not initialized");
            return 1;
        }
        m2884c("startTranslation()");
        if (!m2882a(translationDisplayData.getRecognizedText())) {
            m2883b("not valid string");
            return 3;
        }
        if (!this.f2988b.isSupportedLanguage(translationDisplayData.getInLanguage(), translationDisplayData.getOutLanguage())) {
            m2883b("not supported language");
            return 1;
        }
        this.f2988b.setLangauge(translationDisplayData.getInLanguage(), translationDisplayData.getOutLanguage());
        this.f2988b.start(translationDisplayData.getID(), translationDisplayData.getUserID(), translationDisplayData.getRecognizedText());
        return 0;
    }

    @Override // com.sds.coolots.common.controller.translation.TranslationManagerInterface
    public void stopRecognition() {
        m2884c("stopRecognition()");
        this.f2987a.stop();
    }

    @Override // com.sds.coolots.common.controller.translation.TranslationManagerInterface
    public void stopTranslation() {
        this.f2988b.stop();
    }
}
