package com.sds.coolots.common.controller.translation;

import android.os.Handler;
import com.sds.coolots.common.controller.translation.data.TranslationData;

/* loaded from: classes.dex */
public interface TranslationNotificationManagerInterface {
    void dispose();

    void init(Handler handler, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8);

    void onRecognitionEnd(TranslationData translationData);

    void onRecognitionStart(TranslationData translationData);

    void onTTSPlayEnd(String str);

    void onTTSPlayStart(String str);

    void onTranslationEnd(TranslationData translationData);

    void onTranslationStart(TranslationData translationData);

    void receiveRecognitionEnd(TranslationData translationData);

    void receiveRecognitionStart(TranslationData translationData);

    void receiveRecognitionStop();

    void receiveTTSPlayEnd(String str);

    void receiveTTSPlayStart(String str);

    void receiveTranslationEnd(TranslationData translationData);

    void receiveTranslationStart(TranslationData translationData);

    void sendToOtherpartyRecognitionStop();
}
