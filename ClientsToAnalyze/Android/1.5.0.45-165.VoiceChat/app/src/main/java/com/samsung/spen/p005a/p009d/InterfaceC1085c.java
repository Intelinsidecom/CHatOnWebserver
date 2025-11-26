package com.samsung.spen.p005a.p009d;

import com.samsung.spensdk.applistener.SCanvasDeleteAllConfirmListener;
import com.samsung.spensdk.applistener.SCanvasInitializeListener;
import com.samsung.spensdk.applistener.SCanvasMatrixChangeListener;
import com.samsung.spensdk.applistener.SCanvasModeChangedListener;
import com.samsung.spensdk.applistener.SObjectSelectListener;
import com.samsung.spensdk.applistener.SObjectUpdateListener;

/* renamed from: com.samsung.spen.a.d.c */
/* loaded from: classes.dex */
public interface InterfaceC1085c extends InterfaceC1086d, InterfaceC1088f, InterfaceC1090h, InterfaceC1091i {
    void onSetSCanvasDeleteAllConfirmListener(SCanvasDeleteAllConfirmListener sCanvasDeleteAllConfirmListener);

    void onSetSCanvasInitializeListener(SCanvasInitializeListener sCanvasInitializeListener);

    void onSetSCanvasMatrixChangeListener(SCanvasMatrixChangeListener sCanvasMatrixChangeListener);

    void onSetSCanvasModeChangedListener(SCanvasModeChangedListener sCanvasModeChangedListener);

    void onSetSCanvasSObjectSelectListener(SObjectSelectListener sObjectSelectListener);

    void onSetSCanvasSObjectUpdateListener(SObjectUpdateListener sObjectUpdateListener);
}
