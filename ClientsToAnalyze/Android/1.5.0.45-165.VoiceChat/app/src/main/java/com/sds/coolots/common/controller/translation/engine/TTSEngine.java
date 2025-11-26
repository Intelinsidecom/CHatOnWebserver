package com.sds.coolots.common.controller.translation.engine;

import com.sds.coolots.MainApplication;
import com.sds.coolots.common.controller.translation.data.TranslationDisplayData;
import java.util.Set;

/* loaded from: classes.dex */
public abstract class TTSEngine {

    /* renamed from: a */
    private TranslationDisplayData f3014a;

    public void dispose() {
    }

    public abstract Set getSupportedLanguage();

    public void init() {
    }

    public void notifyEnd() {
        if (MainApplication.mPhoneManager.getPhoneStateMachine().getTranslationNotificationManager() != null) {
            MainApplication.mPhoneManager.getPhoneStateMachine().getTranslationNotificationManager().onTTSPlayEnd(this.f3014a.getID());
        }
    }

    public void notifyStart() {
        if (MainApplication.mPhoneManager.getPhoneStateMachine().getTranslationNotificationManager() != null) {
            MainApplication.mPhoneManager.getPhoneStateMachine().getTranslationNotificationManager().onTTSPlayStart(this.f3014a.getID());
        }
    }

    public boolean play(TranslationDisplayData translationDisplayData) {
        this.f3014a = translationDisplayData;
        return true;
    }
}
