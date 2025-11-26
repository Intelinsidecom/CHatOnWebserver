package com.samsung.android.sdk.pen;

/* loaded from: classes.dex */
public interface SpenSettingViewInterface {
    public static final int ACTION_COLOR_PICKER = 5;
    public static final int ACTION_ERASER = 3;
    public static final int ACTION_GESTURE = 1;
    public static final int ACTION_NONE = 0;
    public static final int ACTION_SELECTION = 6;
    public static final int ACTION_STROKE = 2;
    public static final int ACTION_STROKE_REMOVER = 4;
    public static final int ACTION_TEXT = 7;
    public static final int TOOL_ERASER = 4;
    public static final int TOOL_FINGER = 1;
    public static final int TOOL_MOUSE = 3;
    public static final int TOOL_MULTI_TOUCH = 5;
    public static final int TOOL_SPEN = 2;
    public static final int TOOL_UNKNOWN = 0;

    public interface SpenBackgroundColorChangeListener {
        void onChanged(boolean z);
    }

    void closeControl();

    int getCanvasHeight();

    int getCanvasWidth();

    SpenSettingEraserInfo getEraserSettingInfo();

    SpenSettingPenInfo getPenSettingInfo();

    SpenSettingRemoverInfo getRemoverSettingInfo();

    SpenSettingSelectionInfo getSelectionSettingInfo();

    SpenSettingTextInfo getTextSettingInfo();

    int getToolTypeAction(int i);

    void setBackgroundColorChangeListener(Object obj, SpenBackgroundColorChangeListener spenBackgroundColorChangeListener);

    void setEraserSettingInfo(SpenSettingEraserInfo spenSettingEraserInfo);

    void setPenSettingInfo(SpenSettingPenInfo spenSettingPenInfo);

    void setRemoverSettingInfo(SpenSettingRemoverInfo spenSettingRemoverInfo);

    void setSelectionSettingInfo(SpenSettingSelectionInfo spenSettingSelectionInfo);

    void setTextSettingInfo(SpenSettingTextInfo spenSettingTextInfo);

    void setToolTypeAction(int i, int i2);
}
