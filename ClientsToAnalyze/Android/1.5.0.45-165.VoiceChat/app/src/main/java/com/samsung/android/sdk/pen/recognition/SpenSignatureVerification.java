package com.samsung.android.sdk.pen.recognition;

import android.content.Context;
import android.os.Bundle;
import com.samsung.android.sdk.pen.document.SpenObjectStroke;
import com.samsung.android.sdk.pen.plugin.interfaces.SpenSignatureVerificationInterface;
import java.util.List;

/* loaded from: classes.dex */
public final class SpenSignatureVerification {
    public static final int VERIFICATION_LEVEL_HIGH = 2;
    private static final String VERIFICATION_LEVEL_KEY = "VerificationLevel";
    public static final int VERIFICATION_LEVEL_LOW = 0;
    public static final int VERIFICATION_LEVEL_MEDIUM = 1;
    private SpenSignatureVerificationInterface mPluginObject;
    private ResultListener mResultListener = null;

    public interface ResultListener {
        void onResult(List<SpenObjectStroke> list, boolean z);
    }

    SpenSignatureVerification(Context context, SpenSignatureVerificationInterface pluginObject) {
        this.mPluginObject = null;
        if (context == null) {
            throw new IllegalArgumentException("E_INVALID_ARG : parameter 'context' is null");
        }
        if (pluginObject == null) {
            throw new IllegalArgumentException("E_INVALID_ARG : parameter 'pluginObject' is null");
        }
        this.mPluginObject = pluginObject;
    }

    SpenSignatureVerificationInterface getPluginObject() {
        return this.mPluginObject;
    }

    public int getMinimumRequiredCount() {
        if (this.mPluginObject == null) {
            throw new IllegalStateException("E_INVALID_STATE : SpenSignatureVerification is not loaded");
        }
        return this.mPluginObject.getMinimumRequiredCount();
    }

    public void register(List<SpenObjectStroke> stroke) throws Exception {
        if (this.mPluginObject == null) {
            throw new IllegalStateException("E_INVALID_STATE : SpenSignatureVerification is not loaded");
        }
        if (stroke == null) {
            throw new IllegalArgumentException("E_INVALID_ARG : stroke is null");
        }
        this.mPluginObject.register(stroke);
    }

    public void unregisterAll() {
        if (this.mPluginObject == null) {
            throw new IllegalStateException("E_INVALID_STATE : SpenSignatureVerification is not loaded");
        }
        this.mPluginObject.unregisterAll();
    }

    public int getRegisteredCount() {
        if (this.mPluginObject == null) {
            throw new IllegalStateException("E_INVALID_STATE : SpenSignatureVerification is not loaded");
        }
        return this.mPluginObject.getRegisteredCount();
    }

    public void setVerificationLevel(int level) {
        if (this.mPluginObject == null) {
            throw new IllegalStateException("E_INVALID_STATE : SpenSignatureVerification is not loaded");
        }
        Bundle propertyMap = new Bundle();
        propertyMap.putInt("VerificationLevel", level);
        this.mPluginObject.setProperty(propertyMap);
    }

    public int getVerificationLevel() {
        if (this.mPluginObject == null) {
            throw new IllegalStateException("E_INVALID_STATE : SpenSignatureVerification is not loaded");
        }
        Bundle propertyMap = new Bundle();
        this.mPluginObject.getProperty(propertyMap);
        if (propertyMap.containsKey("VerificationLevel")) {
            return propertyMap.getInt("VerificationLevel");
        }
        return -1;
    }

    public void request(List<SpenObjectStroke> stroke) throws Exception {
        if (this.mPluginObject == null) {
            throw new IllegalStateException("E_INVALID_STATE : SpenSignatureVerification is not loaded");
        }
        this.mPluginObject.request(stroke);
    }

    public void setResultListener(ResultListener listener) throws Exception {
        if (this.mPluginObject == null) {
            throw new IllegalStateException("E_INVALID_STATE : SpenSignatureVerification is not loaded");
        }
        this.mResultListener = listener;
        if (this.mResultListener != null) {
            this.mPluginObject.setResultListener(new SpenSignatureVerificationInterface.ResultListener() { // from class: com.samsung.android.sdk.pen.recognition.SpenSignatureVerification.1
                @Override // com.samsung.android.sdk.pen.plugin.interfaces.SpenSignatureVerificationInterface.ResultListener
                public void onResult(List<SpenObjectStroke> input, boolean result) {
                    if (SpenSignatureVerification.this.mResultListener == null) {
                        return;
                    }
                    SpenSignatureVerification.this.mResultListener.onResult(input, result);
                }
            });
        }
    }
}
