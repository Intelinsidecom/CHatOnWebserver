package com.samsung.vip.engine;

/* loaded from: classes.dex */
public class VITextAllRecognitionLib extends VITextRecognitionLib {
    private native void VIHW_AddStroke(float[] fArr, float[] fArr2);

    private native void VIHW_Close();

    private native String VIHW_GetResult();

    private native int VIHW_Init(String str, int i, int i2, int i3, short s);

    private native int VIHW_Recog(int i);

    private native int VIHW_Recog(int i, int[] iArr, int i2);

    @Override // com.samsung.vip.engine.VITextRecognitionLib
    protected int VIText_Init(String szDataPath, int nLangMode, int nWidth, int nHeight, short sRangeMode) {
        return VIHW_Init(szDataPath, nLangMode, nWidth, nHeight, sRangeMode);
    }

    @Override // com.samsung.vip.engine.VITextRecognitionLib
    protected void VIText_Close() {
        VIHW_Close();
    }

    @Override // com.samsung.vip.engine.VITextRecognitionLib
    protected int VIText_Recog(int nRecogType, int[] pPointData, int nPointNum) {
        return VIHW_Recog(nRecogType, pPointData, nPointNum);
    }

    @Override // com.samsung.vip.engine.VITextRecognitionLib
    protected int VIText_Recog(int nRecogType) {
        return VIHW_Recog(nRecogType);
    }

    @Override // com.samsung.vip.engine.VITextRecognitionLib
    protected void VIText_AddStroke(float[] x, float[] y) {
        VIHW_AddStroke(x, y);
    }

    @Override // com.samsung.vip.engine.VITextRecognitionLib
    protected String VIText_GetResult() {
        return VIHW_GetResult();
    }
}
