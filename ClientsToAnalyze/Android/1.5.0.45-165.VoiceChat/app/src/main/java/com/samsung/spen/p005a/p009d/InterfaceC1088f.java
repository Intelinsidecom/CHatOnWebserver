package com.samsung.spen.p005a.p009d;

import android.graphics.Bitmap;
import com.samsung.samm.common.SObject;

/* renamed from: com.samsung.spen.a.d.f */
/* loaded from: classes.dex */
public interface InterfaceC1088f extends InterfaceC1089g {
    boolean onChangeObject(SObject sObject);

    boolean onDeleteObject(SObject sObject);

    boolean onDrawBackgroundImage(Bitmap bitmap);

    Bitmap onDrawCanvasBackground(Bitmap bitmap, Bitmap bitmap2, Bitmap bitmap3);

    boolean onDrawCanvasBackground(Bitmap bitmap);

    boolean onDrawObject(SObject sObject, boolean z);

    boolean onDrawSAMMStrokePoint(int i, float f, float f2, float f3, int i2, long j, long j2);

    Bitmap onGetCanvasBitmap(boolean z);

    byte[] onGetSCanvasBitmapData();

    SObject onSelectSObject(int i, int i2);

    boolean onSetCanvasBitmap(Bitmap bitmap, boolean z);

    void onSetDispatchObjectEvent(boolean z);

    boolean onSetSCanvasBitmapData(byte[] bArr);

    boolean onSetSCanvasSize(int i, int i2);

    void onSetUsingHistoricalEventForStroke(boolean z);

    void onUpdateSelectedObjectList();
}
