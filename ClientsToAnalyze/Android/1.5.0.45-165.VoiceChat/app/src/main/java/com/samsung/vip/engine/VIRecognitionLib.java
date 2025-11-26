package com.samsung.vip.engine;

import com.samsung.vip.engine.shape.GraphPrimitive;

/* loaded from: classes.dex */
public class VIRecognitionLib {
    public static final String LIBNAME = "VIRecognition";
    private static final String TAG = "VIRecognitionLib";
    public static final String VERSION = "0.7.3";
    public static final int VI_EQ_ENGINE_RAM_SIZE = 262144;
    public static final int VI_EQ_MAX_CANDIDATE_NUM = 10;
    public static final int VI_EQ_MAX_GROUP_NUM = 128;
    public static final int VI_EQ_MAX_POINT_DATA_NUM = 4000;
    public static final int VI_EQ_MAX_POINT_NUM = 2000;
    public static final int VI_EQ_MAX_RECT_HEIGHT = 20000;
    public static final int VI_EQ_MAX_RECT_WIDTH = 20000;
    public static final int VI_EQ_MAX_STRING_LEN = 365;
    public static final int VI_EQ_MIN_RECT_HEIGHT = 10;
    public static final int VI_EQ_MIN_RECT_WIDTH = 10;
    public static final int VI_SH_ENGINE_RAM_SIZE = 10485760;

    protected native void VIEQ_Close();

    protected native int VIEQ_Init(String str, int i, int i2, int i3);

    protected native String VIEQ_Recog(int[] iArr, int i);

    protected native void VISH_ClearScene();

    protected native void VISH_ClearSelected();

    protected native void VISH_DeObject();

    protected native short VISH_DeleteChoosenPrimitive();

    protected native GraphPrimitive[] VISH_GetGraphPrimitiveArray();

    protected native int VISH_GetLastShapeType();

    protected native int[] VISH_GetLastStrokeBreakPoints();

    protected native void VISH_InitSmartShapeEngine(int i);

    protected native void VISH_JoinSelectedObject();

    protected native int VISH_PrimitiveRotate(int[] iArr, int[] iArr2);

    protected native int VISH_PrimitiveTranslate(float[] fArr);

    protected native int VISH_PrimitiveZoom(int[] iArr, int[] iArr2);

    protected native void VISH_ReleaseSmartShapeEngine();

    protected native short VISH_SearchPrimitive(int i, int[] iArr);

    protected native void VISH_UpdateMovePrimitivesData(float[] fArr);

    protected native void VISH_UpdateScene(int[] iArr);

    public void loadLibrary(String pathName) {
        System.load(pathName);
    }
}
