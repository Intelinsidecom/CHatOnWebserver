package com.samsung.android.sdk.pen.recognition;

import android.content.Context;
import java.lang.reflect.UndeclaredThrowableException;
import java.util.List;

/* loaded from: classes.dex */
public final class SpenEquationRecognitionManager extends SpenRecognitionManager {
    public static final String SPEN_EQUATION = "com.samsung.android.sdk.pen.recognition.preload.EquationRecognitionPlugin";
    private Context mContext;

    public SpenEquationRecognitionManager(Context context) {
        super(context);
        this.mContext = null;
        this.mContext = context;
    }

    public List<SpenRecognitionInfo> getInfoList(int inputType, int outputType) {
        return getInfoList("EquationRecognition", inputType, outputType);
    }

    @Override // com.samsung.android.sdk.pen.recognition.SpenRecognitionManager
    public String getPrivateKeyHint(SpenRecognitionInfo info) throws IllegalAccessException, InstantiationException, ClassNotFoundException {
        return super.getPrivateKeyHint(info);
    }

    public SpenEquationRecognition createRecognition(SpenRecognitionInfo info) throws Exception {
        if (info == null) {
            throw new IllegalArgumentException("E_INVALID_ARG : parameter 'info' is null");
        }
        List<SpenRecognitionInfo> list = getInfoList("EquationRecognition");
        if (list == null) {
            throw new SpenCreationFailureException("There is no available EquationRecognition engine");
        }
        for (SpenRecognitionInfo recognitionInfo : list) {
            if (info.className.equals(recognitionInfo.className)) {
                try {
                    return new SpenEquationRecognition(this.mContext, createPluginObject(this.mContext, recognitionInfo, ""));
                } catch (UndeclaredThrowableException e) {
                    throw new SpenCreationFailureException("EquationRecognizer is not loaded");
                }
            }
        }
        throw new ClassNotFoundException("The class '" + info.className + "' is not founded");
    }

    public SpenEquationRecognition createRecognition(SpenRecognitionInfo info, String key) throws Exception {
        if (info == null) {
            throw new IllegalArgumentException("E_INVALID_ARG : parameter 'info' is null");
        }
        List<SpenRecognitionInfo> list = getInfoList("EquationRecognition");
        if (list == null) {
            throw new SpenCreationFailureException("There is no available EquationRecognition engine");
        }
        for (SpenRecognitionInfo recognitionInfo : list) {
            if (info.className.equals(recognitionInfo.className)) {
                try {
                    return new SpenEquationRecognition(this.mContext, createPluginObject(this.mContext, recognitionInfo, key));
                } catch (UndeclaredThrowableException e) {
                    throw new SpenCreationFailureException("EquationRecognizer is not loaded");
                }
            }
        }
        throw new ClassNotFoundException("The class '" + info.className + "' is not founded");
    }

    public SpenEquationRecognition createRecognition(String className) throws Exception {
        if (className == null) {
            throw new IllegalArgumentException("E_INVALID_ARG : parameter 'className' is null");
        }
        List<SpenRecognitionInfo> list = getInfoList("EquationRecognition");
        if (list == null) {
            throw new SpenCreationFailureException("There is no available EquationRecognition engine");
        }
        for (SpenRecognitionInfo recognitionInfo : list) {
            if (className.equals(recognitionInfo.className)) {
                try {
                    return new SpenEquationRecognition(this.mContext, createPluginObject(this.mContext, recognitionInfo, ""));
                } catch (UndeclaredThrowableException e) {
                    throw new SpenCreationFailureException("EquationRecognizer is not loaded");
                }
            }
        }
        throw new ClassNotFoundException("The class '" + className + "' is not founded");
    }

    public SpenEquationRecognition createRecognition(String className, String key) throws Exception {
        if (className == null) {
            throw new IllegalArgumentException("E_INVALID_ARG : parameter 'className' is null");
        }
        List<SpenRecognitionInfo> list = getInfoList("EquationRecognition");
        if (list == null) {
            throw new SpenCreationFailureException("There is no available EquationRecognition engine");
        }
        for (SpenRecognitionInfo recognitionInfo : list) {
            if (className.equals(recognitionInfo.className)) {
                try {
                    return new SpenEquationRecognition(this.mContext, createPluginObject(this.mContext, recognitionInfo, key));
                } catch (UndeclaredThrowableException e) {
                    throw new SpenCreationFailureException("EquationRecognizer is not loaded");
                }
            }
        }
        throw new ClassNotFoundException("The class '" + className + "' is not founded");
    }

    public void destroyRecognition(SpenEquationRecognition recognition) {
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
