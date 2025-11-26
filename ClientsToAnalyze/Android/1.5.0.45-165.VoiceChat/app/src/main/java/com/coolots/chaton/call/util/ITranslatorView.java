package com.coolots.chaton.call.util;

import com.sds.coolots.common.controller.translation.data.TranslationDisplayData;

/* loaded from: classes.dex */
public interface ITranslatorView {
    void addDurationTranslatePopup(TranslationDisplayData translationDisplayData, boolean z);

    void addGuestTranslatePopup(TranslationDisplayData translationDisplayData);

    void addHostTranslatePopup(TranslationDisplayData translationDisplayData, boolean z);

    void goneTranslatorIcon(String str);

    void removeDurationTranslatePopup(TranslationDisplayData translationDisplayData);

    void setGuestName(String str);

    void visibleTranslatorIcon(String str);
}
