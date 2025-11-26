package com.coolots.chaton.call.util;

import java.util.Set;

/* loaded from: classes.dex */
public interface ITranslatorDialog {
    int getTranslatorHostLanguageCode();

    int getTranslatorTheOherPartyLanguageCode();

    void sendIncomingMsgOnly(boolean z);

    Set<Integer> sendTranslatorHostLanguage(int i);

    void sendTranslatorHostLanguageCode(int i);

    void sendTranslatorTheOtherPartyLanguageCode(int i);
}
