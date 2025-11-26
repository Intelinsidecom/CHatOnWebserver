package com.samsung.android.sdk.pen.plugin.interfaces;

import java.util.List;

/* loaded from: classes.dex */
public interface SpenLanguageRecognitionInterface extends SpenRecognitionInterface {
    String getLanguage();

    List<String> getSupportedLanguage();

    void setLanguage(String str);
}
