package com.samsung.android.sdk.pen.recognition;

import android.content.Context;
import com.samsung.android.sdk.pen.plugin.interfaces.SpenLanguageRecognitionInterface;
import com.samsung.android.sdk.pen.plugin.interfaces.SpenRecognitionInterface;
import java.util.List;

/* loaded from: classes.dex */
public final class SpenTextRecognition extends SpenRecognitionBase {
    SpenTextRecognition(Context context, SpenRecognitionInterface pluginObject) {
        super(context, pluginObject);
    }

    public List<String> getSupportedLanguage() {
        if (this.mPluginObject == null) {
            throw new IllegalStateException("E_INVALID_STATE : Recognition is not loaded");
        }
        return ((SpenLanguageRecognitionInterface) this.mPluginObject).getSupportedLanguage();
    }

    public String getLanguage() {
        if (this.mPluginObject == null) {
            throw new IllegalStateException("E_INVALID_STATE : Recognition is not loaded");
        }
        return ((SpenLanguageRecognitionInterface) this.mPluginObject).getLanguage();
    }

    public void setLanguage(String language) {
        if (this.mPluginObject == null) {
            throw new IllegalStateException("E_INVALID_STATE : Recognition is not loaded");
        }
        ((SpenLanguageRecognitionInterface) this.mPluginObject).setLanguage(language);
    }
}
