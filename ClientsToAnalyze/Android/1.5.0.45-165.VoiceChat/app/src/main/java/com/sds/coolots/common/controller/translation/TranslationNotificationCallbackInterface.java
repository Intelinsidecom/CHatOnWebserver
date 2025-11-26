package com.sds.coolots.common.controller.translation;

import com.coolots.p2pmsg.model.RecognitionAsk;
import com.coolots.p2pmsg.model.RecognitionRep;
import com.coolots.p2pmsg.model.TTSAsk;
import com.coolots.p2pmsg.model.TTSRep;
import com.coolots.p2pmsg.model.TranslationAsk;
import com.coolots.p2pmsg.model.TranslationRep;

/* loaded from: classes.dex */
public interface TranslationNotificationCallbackInterface {
    void onReceiveRecognitionAsk(RecognitionAsk recognitionAsk);

    void onReceiveRecognitionRep(RecognitionRep recognitionRep);

    void onReceiveTTSAsk(TTSAsk tTSAsk);

    void onReceiveTTSRep(TTSRep tTSRep);

    void onReceiveTranslationAsk(TranslationAsk translationAsk);

    void onReceiveTranslationRep(TranslationRep translationRep);
}
