package com.samsung.android.sdk.pen.recognition;

import android.content.Context;
import java.lang.reflect.UndeclaredThrowableException;
import java.util.List;

/* loaded from: classes.dex */
public final class SpenShapeRecognitionManager extends SpenRecognitionManager {
    public static final String SPEN_SHAPE = "com.samsung.android.sdk.pen.recognition.preload.ShapeRecognitionPlugin";
    private Context mContext;

    public SpenShapeRecognitionManager(Context context) {
        super(context);
        this.mContext = null;
        this.mContext = context;
    }

    public List<SpenRecognitionInfo> getInfoList(int inputType, int outputType) {
        return getInfoList("ShapeRecognition", inputType, outputType);
    }

    @Override // com.samsung.android.sdk.pen.recognition.SpenRecognitionManager
    public String getPrivateKeyHint(SpenRecognitionInfo info) throws IllegalAccessException, InstantiationException, ClassNotFoundException {
        return super.getPrivateKeyHint(info);
    }

    public SpenShapeRecognition createRecognition(SpenRecognitionInfo info) throws Exception {
        return createRecognition(info, (String) null);
    }

    public SpenShapeRecognition createRecognition(SpenRecognitionInfo info, String key) throws Exception {
        if (info == null) {
            throw new IllegalArgumentException("E_INVALID_ARG : parameter 'info' is null");
        }
        List<SpenRecognitionInfo> list = getInfoList("ShapeRecognition");
        if (list == null) {
            throw new SpenCreationFailureException("There is no available ShapeRecognition engine");
        }
        for (SpenRecognitionInfo recognitionInfo : list) {
            if (info.className.equals(recognitionInfo.className)) {
                try {
                    return new SpenShapeRecognition(this.mContext, createPluginObject(this.mContext, recognitionInfo, key));
                } catch (UndeclaredThrowableException e) {
                    throw new SpenCreationFailureException("ShapeRecognizer is not loaded");
                }
            }
        }
        throw new ClassNotFoundException("The class '" + info.className + "' is not founded");
    }

    public SpenShapeRecognition createRecognition(String className) throws Exception {
        if (className == null) {
            throw new IllegalArgumentException("E_INVALID_ARG : parameter 'className' is null");
        }
        List<SpenRecognitionInfo> list = getInfoList("ShapeRecognition");
        if (list == null) {
            throw new SpenCreationFailureException("There is no available ShapeRecognition engine");
        }
        for (SpenRecognitionInfo recognitionInfo : list) {
            if (className.equals(recognitionInfo.className)) {
                try {
                    return new SpenShapeRecognition(this.mContext, createPluginObject(this.mContext, recognitionInfo, null));
                } catch (UndeclaredThrowableException e) {
                    throw new SpenCreationFailureException("ShapeRecognizer is not loaded");
                }
            }
        }
        throw new ClassNotFoundException("The class '" + className + "' is not founded");
    }

    public SpenShapeRecognition createRecognition(String className, String key) throws Exception {
        if (className == null) {
            throw new IllegalArgumentException("E_INVALID_ARG : parameter 'className' is null");
        }
        List<SpenRecognitionInfo> list = getInfoList("ShapeRecognition");
        if (list == null) {
            throw new SpenCreationFailureException("There is no available ShapeRecognition engine");
        }
        for (SpenRecognitionInfo recognitionInfo : list) {
            if (className.equals(recognitionInfo.className)) {
                try {
                    return new SpenShapeRecognition(this.mContext, createPluginObject(this.mContext, recognitionInfo, key));
                } catch (UndeclaredThrowableException e) {
                    throw new SpenCreationFailureException("ShapeRecognizer is not loaded");
                }
            }
        }
        throw new ClassNotFoundException("The class '" + className + "' is not founded");
    }

    public void destroyRecognition(SpenShapeRecognition recognition) {
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
