package com.sds.coolots.common.controller.translation;

import com.sds.coolots.common.controller.translation.data.C1250a;
import com.sds.coolots.common.controller.translation.data.TranslationData;
import com.sds.coolots.common.controller.translation.data.TranslationDisplayData;

/* loaded from: classes.dex */
public interface TranslationListManagerInterface {
    void dispose();

    TranslationDisplayData get(String str);

    C1250a getList();

    void removeListData(String str);

    void setNowPlayTTS(TranslationDisplayData translationDisplayData);

    void updateRecognitionEnd(TranslationData translationData);

    void updateRecognitionStart(TranslationData translationData);

    boolean updateTTSPlayEnd(String str);

    boolean updateTTSPlayStart(String str);

    void updateTranslationEnd(TranslationData translationData);

    void updateTranslationStart(TranslationData translationData);
}
