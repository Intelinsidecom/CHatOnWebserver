package com.samsung.android.sdk.pen.recognition;

import android.content.Context;
import java.lang.reflect.UndeclaredThrowableException;
import java.util.List;

/* loaded from: classes.dex */
public final class SpenTextRecognitionManager extends SpenRecognitionManager {
    public static final String SPEN_TEXT = "com.samsung.android.sdk.pen.recognition.preload.TextRecognitionPlugin";
    private Context mContext;

    public SpenTextRecognitionManager(Context context) {
        super(context);
        this.mContext = null;
        this.mContext = context;
    }

    public List<SpenRecognitionInfo> getInfoList(int inputType, int outputType) {
        return getInfoList("TextRecognition", inputType, outputType, "SpenLanguageRecognitionInterface");
    }

    @Override // com.samsung.android.sdk.pen.recognition.SpenRecognitionManager
    public String getPrivateKeyHint(SpenRecognitionInfo info) throws IllegalAccessException, InstantiationException, ClassNotFoundException {
        return super.getPrivateKeyHint(info);
    }

    public SpenTextRecognition createRecognition(SpenRecognitionInfo info) throws Exception {
        return createRecognition(info, (String) null);
    }

    public SpenTextRecognition createRecognition(SpenRecognitionInfo info, String key) throws Exception {
        if (info == null) {
            throw new IllegalArgumentException("E_INVALID_ARG : parameter 'info' is null");
        }
        List<SpenRecognitionInfo> list = getInfoList("TextRecognition", "SpenLanguageRecognitionInterface");
        if (list == null) {
            throw new SpenCreationFailureException("There is no available TextRecognition engine");
        }
        for (SpenRecognitionInfo recognitionInfo : list) {
            if (info.className.equals(recognitionInfo.className)) {
                try {
                    return new SpenTextRecognition(this.mContext, createPluginObject(this.mContext, recognitionInfo, key));
                } catch (UndeclaredThrowableException e) {
                    throw new SpenCreationFailureException("TextRecognizer is not loaded");
                }
            }
        }
        throw new ClassNotFoundException("The class '" + info.className + "' is not founded");
    }

    public SpenTextRecognition createRecognition(String className) throws Exception {
        try {
            return createRecognition(className, (String) null);
        } catch (UndeclaredThrowableException e) {
            throw new SpenCreationFailureException("TextRecognizer is not loaded");
        }
    }

    public SpenTextRecognition createRecognition(String className, String key) throws Exception {
        if (className == null) {
            throw new IllegalArgumentException("E_INVALID_ARG : parameter 'className' is null");
        }
        List<SpenRecognitionInfo> list = getInfoList("TextRecognition", "SpenLanguageRecognitionInterface");
        if (list == null) {
            throw new SpenCreationFailureException("There is no available TextRecognition engine");
        }
        for (SpenRecognitionInfo recognitionInfo : list) {
            if (className.equals(recognitionInfo.className)) {
                try {
                    return new SpenTextRecognition(this.mContext, createPluginObject(this.mContext, recognitionInfo, key));
                } catch (UndeclaredThrowableException e) {
                    throw new SpenCreationFailureException("TextRecognizer is not loaded");
                }
            }
        }
        throw new ClassNotFoundException("The class '" + className + "' is not founded");
    }

    public void destroyRecognition(SpenTextRecognition recognition) {
        if (recognition == null || recognition.getPluginObject() == null) {
            throw new IllegalArgumentException("E_INVALID_STATE : parameter 'recognition' is null");
        }
        destroyPluginObject(recognition.getPluginObject());
    }

    @Override // com.samsung.android.sdk.pen.recognition.SpenRecognitionManager
    public void close() {
        super.close();
        this.mContext = null;
    }

    @Override // com.samsung.android.sdk.pen.recognition.SpenRecognitionManager
    protected void finalize() throws Throwable {
        super.finalize();
        this.mContext = null;
    }
}
