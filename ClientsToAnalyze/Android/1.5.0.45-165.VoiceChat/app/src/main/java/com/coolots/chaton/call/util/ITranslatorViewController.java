package com.coolots.chaton.call.util;

import com.sds.coolots.common.controller.translation.data.TranslationDisplayData;

/* loaded from: classes.dex */
public interface ITranslatorViewController {
    void addtHostTranslatePopup(TranslationDisplayData translationDisplayData, boolean z);

    void endDurationTranslatePopup(TranslationDisplayData translationDisplayData);

    void goneTranslatorIcon(String str);

    void removeGuestTranslatePopup(TranslationDisplayData translationDisplayData);

    void setGuestName(String str);

    void startDurationTranslatePopup(TranslationDisplayData translationDisplayData, boolean z);

    void visibleTranslatorIcon(String str);
}
