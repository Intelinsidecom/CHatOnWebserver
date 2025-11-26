package com.samsung.spen.p005a.p009d;

import android.graphics.Matrix;
import android.graphics.RectF;
import com.samsung.spen.p005a.p011f.InterfaceC1094a;
import com.samsung.spen.settings.SettingFillingInfo;
import com.samsung.spen.settings.SettingStrokeInfo;
import com.samsung.spen.settings.SettingTextInfo;
import com.samsung.spensdk.applistener.ColorPickerColorChangeListener;
import com.samsung.spensdk.applistener.HistoryUpdateListener;
import com.samsung.spensdk.applistener.SCanvasLongPressListener;

/* renamed from: com.samsung.spen.a.d.d */
/* loaded from: classes.dex */
public interface InterfaceC1086d extends InterfaceC1087e {
    boolean onCancelAllDrawing();

    boolean onCancelDrawing();

    boolean onCancelDrawing(int i);

    boolean onCancelTextEditing();

    void onDeleteAll(boolean z);

    void onDeleteAll(boolean z, int i);

    boolean onGetCanvasDrawable();

    int onGetCanvasMode();

    boolean onGetCanvasPanEnable();

    boolean onGetCanvasSupportPenOnly();

    boolean onGetCanvasZoomEnable();

    int onGetColorPickerColor(float f, float f2);

    boolean onGetPanningMode();

    float onGetScale();

    RectF onGetSelectedSObjectRect();

    SettingFillingInfo onGetSettingFillingInfo();

    SettingStrokeInfo onGetSettingStrokeInfo();

    SettingTextInfo onGetSettingTextInfo();

    boolean onGetTextLongClickSelectOption();

    boolean onGetTouchEventDispatchMode();

    boolean onIsAnyoneDrawing();

    boolean onIsColorPickerMode();

    boolean onIsDrawing();

    boolean onIsHistoricalOperationSupport();

    boolean onIsRedoable();

    boolean onIsRedoable(int i);

    boolean onIsTextEditing();

    boolean onIsUndoable();

    boolean onIsUndoable(int i);

    boolean onPanBySCanvas(float f, float f2);

    boolean onPanToSCanvas(float f, float f2);

    boolean onRedo();

    boolean onRedo(int i);

    boolean onSetCanvasDrawable(boolean z);

    boolean onSetCanvasMode(int i);

    void onSetCanvasPanEnable(boolean z);

    boolean onSetCanvasSupportPenOnly(boolean z);

    void onSetCanvasZoomEnable(boolean z);

    void onSetColorPickerMode(boolean z);

    void onSetDrawingFront(boolean z);

    void onSetDrawingUpdatable(boolean z);

    void onSetEraserCursorVisible(boolean z);

    boolean onSetEraserPenSetting(int i);

    void onSetHistoricalOperationSupport(boolean z);

    boolean onSetMultiTouchCancel(boolean z);

    void onSetObjectManagerInterface(InterfaceC1094a interfaceC1094a);

    void onSetOnSCanvasLayoutDropperToolListener(ColorPickerColorChangeListener colorPickerColorChangeListener);

    void onSetOnSCanvasLayoutHistoryListener(HistoryUpdateListener historyUpdateListener);

    void onSetOnSCanvasLayoutLongPressListener(SCanvasLongPressListener sCanvasLongPressListener);

    boolean onSetPanningMode(boolean z);

    boolean onSetPenSetting(int i, float f, int i2);

    void onSetRemoveLongPressStroke(boolean z);

    boolean onSetSCanvasMatrix(Matrix matrix);

    boolean onSetSCanvasMaxZoom(float f);

    boolean onSetSCanvasMinZoom(float f);

    boolean onSetScale(float f);

    void onSetSelectAllTextByDoubleTap(boolean z);

    void onSetSelectAllTextByLongPress(boolean z);

    boolean onSetSettingFillingInfo(SettingFillingInfo settingFillingInfo);

    boolean onSetSettingStrokeInfo(SettingStrokeInfo settingStrokeInfo);

    boolean onSetSettingTextInfo(SettingTextInfo settingTextInfo);

    void onSetTextLongClickSelectOption(boolean z);

    boolean onSetTextSetting(int i, float f, int i2, String str);

    void onSetTouchEventDispatchMode(boolean z);

    void onSetUseCanvasLongPressListener(boolean z);

    boolean onUndo();

    boolean onUndo(int i);

    boolean onZoomSCanvas(float f);

    boolean onZoomSCanvas(float f, float f2, float f3);
}
