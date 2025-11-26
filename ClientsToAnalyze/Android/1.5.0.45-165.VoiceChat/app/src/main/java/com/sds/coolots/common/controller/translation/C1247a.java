package com.sds.coolots.common.controller.translation;

import com.sds.coolots.common.controller.translation.data.C1250a;
import com.sds.coolots.common.controller.translation.data.TranslationData;
import com.sds.coolots.common.controller.translation.data.TranslationDisplayData;
import com.sds.coolots.common.util.Log;
import com.sds.coolots.common.view.DisposeInterface;

/* renamed from: com.sds.coolots.common.controller.translation.a */
/* loaded from: classes.dex */
public class C1247a implements TranslationListManagerInterface, DisposeInterface {

    /* renamed from: b */
    private static final String f2984b = "[TranslationListManager]";

    /* renamed from: a */
    public C1250a f2985a;

    /* renamed from: a */
    private void m2878a() {
        if (this.f2985a == null) {
            this.f2985a = new C1250a();
        }
    }

    /* renamed from: a */
    private void m2879a(String str) {
        Log.m2958e(f2984b + str);
    }

    /* renamed from: b */
    private void m2880b(String str) {
        Log.m2963i(f2984b + str);
    }

    @Override // com.sds.coolots.common.controller.translation.TranslationListManagerInterface, com.sds.coolots.common.view.DisposeInterface
    public void dispose() {
        if (this.f2985a != null) {
            this.f2985a.m2913b();
            this.f2985a = null;
        }
    }

    @Override // com.sds.coolots.common.controller.translation.TranslationListManagerInterface
    public TranslationDisplayData get(String str) {
        m2878a();
        return this.f2985a.m2912b(str);
    }

    @Override // com.sds.coolots.common.controller.translation.TranslationListManagerInterface
    public C1250a getList() {
        m2878a();
        return this.f2985a;
    }

    @Override // com.sds.coolots.common.controller.translation.TranslationListManagerInterface
    public void removeListData(String str) {
        this.f2985a.m2909a(str);
    }

    @Override // com.sds.coolots.common.controller.translation.TranslationListManagerInterface
    public void setNowPlayTTS(TranslationDisplayData translationDisplayData) {
        m2878a();
        String id = translationDisplayData.getID();
        if (this.f2985a.m2912b(id) == null) {
            m2880b("no such item [id: " + id);
            return;
        }
        String translatedText = this.f2985a.m2912b(id).getTranslatedText();
        if (!C1248b.m2882a(translatedText)) {
            m2880b(String.valueOf(id) + ": translated text is null");
        } else {
            m2880b("TTS text: " + translatedText);
            this.f2985a.m2911a(id, true);
        }
    }

    @Override // com.sds.coolots.common.controller.translation.TranslationListManagerInterface
    public void updateRecognitionEnd(TranslationData translationData) {
        m2878a();
        if (this.f2985a.m2912b(translationData.getID()) == null) {
            m2880b("updateRecognitionEnd: no such item (" + translationData.getID() + ")");
            this.f2985a.m2908a(new TranslationDisplayData(translationData));
        }
        this.f2985a.m2912b(translationData.getID()).setInLanguage(translationData.getInLanguage());
        this.f2985a.m2912b(translationData.getID()).setOutLanguage(translationData.getOutLanguage());
        this.f2985a.m2912b(translationData.getID()).setRecognizedText(translationData.getRecognizedText());
        this.f2985a.m2912b(translationData.getID()).setNowRecognizing(false);
        m2880b("updateRecognitionEnd: " + this.f2985a.m2912b(translationData.getID()).toString());
    }

    @Override // com.sds.coolots.common.controller.translation.TranslationListManagerInterface
    public void updateRecognitionStart(TranslationData translationData) {
        m2878a();
        TranslationDisplayData translationDisplayData = new TranslationDisplayData(translationData);
        this.f2985a.m2908a(translationDisplayData);
        m2880b("updateRecognitionStart: " + this.f2985a.m2912b(translationDisplayData.getID()).toString());
    }

    @Override // com.sds.coolots.common.controller.translation.TranslationListManagerInterface
    public boolean updateTTSPlayEnd(String str) {
        m2878a();
        if (this.f2985a.m2912b(str) == null) {
            m2880b("updateTTSPlayEnd: no such item (" + str + ")");
            return false;
        }
        this.f2985a.m2912b(str).setNowTTSPlaying(false);
        m2880b("updateTTSPlayEnd: " + this.f2985a.m2912b(str).toString());
        return true;
    }

    @Override // com.sds.coolots.common.controller.translation.TranslationListManagerInterface
    public boolean updateTTSPlayStart(String str) {
        m2878a();
        if (this.f2985a.m2912b(str) == null) {
            m2880b("updateTTSPlayStart: no such item (" + str + ")");
            return false;
        }
        this.f2985a.m2912b(str).setNowTTSPlaying(true);
        m2880b("updateTTSPlayStart: " + this.f2985a.m2912b(str).toString());
        return true;
    }

    @Override // com.sds.coolots.common.controller.translation.TranslationListManagerInterface
    public void updateTranslationEnd(TranslationData translationData) {
        m2878a();
        if (this.f2985a.m2912b(translationData.getID()) == null) {
            m2880b("updateTranslationEnd: no such item (" + translationData.getID() + ")");
            this.f2985a.m2908a(new TranslationDisplayData(translationData));
        } else {
            this.f2985a.m2912b(translationData.getID()).setTranslatedText(translationData.getTranslatedText());
            this.f2985a.m2912b(translationData.getID()).setNowTranslating(false);
            m2880b("updateTranslationEnd: " + this.f2985a.m2912b(translationData.getID()).toString());
        }
    }

    @Override // com.sds.coolots.common.controller.translation.TranslationListManagerInterface
    public void updateTranslationStart(TranslationData translationData) {
        m2878a();
        if (this.f2985a.m2912b(translationData.getID()) == null) {
            m2880b("updateTranslationStart: no such item (" + translationData.getID() + ")");
            this.f2985a.m2908a(new TranslationDisplayData(translationData));
        }
        this.f2985a.m2912b(translationData.getID()).setTranslatedText(null);
        this.f2985a.m2912b(translationData.getID()).setNowTranslating(true);
        m2880b("updateTranslationStart: " + this.f2985a.m2912b(translationData.getID()).toString());
    }
}
