package com.samsung.android.sdk.pen.recognition;

import android.content.Context;
import com.samsung.android.sdk.pen.document.SpenObjectBase;
import com.samsung.android.sdk.pen.plugin.interfaces.SpenRecognitionInterface;
import java.util.List;

/* loaded from: classes.dex */
public abstract class SpenRecognitionBase {
    protected SpenRecognitionInterface mPluginObject;
    private ResultListener mResultListener = null;

    public interface ResultListener {
        void onResult(List<SpenObjectBase> list, List<SpenObjectBase> list2);
    }

    SpenRecognitionBase(Context context, SpenRecognitionInterface pluginObject) {
        this.mPluginObject = null;
        if (context == null) {
            throw new IllegalArgumentException("E_INVALID_ARG : parameter 'context' is null");
        }
        this.mPluginObject = pluginObject;
    }

    SpenRecognitionInterface getPluginObject() {
        return this.mPluginObject;
    }

    public void request(List<SpenObjectBase> input) throws Exception {
        if (this.mPluginObject == null) {
            throw new IllegalStateException("E_INVALID_STATE : SpenRecognitionBase is not loaded");
        }
        this.mPluginObject.request(input);
    }

    public void setResultListener(ResultListener listener) throws Exception {
        if (this.mPluginObject == null) {
            throw new IllegalStateException("E_INVALID_STATE : SpenRecognitionBase is not loaded");
        }
        this.mResultListener = listener;
        if (this.mResultListener != null) {
            this.mPluginObject.setResultListener(new SpenRecognitionInterface.ResultListener() { // from class: com.samsung.android.sdk.pen.recognition.SpenRecognitionBase.1
                @Override // com.samsung.android.sdk.pen.plugin.interfaces.SpenRecognitionInterface.ResultListener
                public void onResult(List<SpenObjectBase> input, List<SpenObjectBase> output) {
                    if (SpenRecognitionBase.this.mResultListener == null) {
                        return;
                    }
                    SpenRecognitionBase.this.mResultListener.onResult(input, output);
                }
            });
        } else {
            this.mPluginObject.setResultListener(null);
        }
    }
}
