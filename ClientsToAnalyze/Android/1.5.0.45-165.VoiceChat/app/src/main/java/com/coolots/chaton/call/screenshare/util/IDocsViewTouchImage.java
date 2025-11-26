package com.coolots.chaton.call.screenshare.util;

import android.graphics.Matrix;
import android.view.MotionEvent;
import com.samsung.android.sdk.pen.engine.SpenMultiView;

/* loaded from: classes.dex */
public interface IDocsViewTouchImage {
    boolean TouchEvent(MotionEvent motionEvent);

    void finishDocsView();

    int getCurrentPageNumber();

    Matrix getMatrix();

    int getMaxPageNumber();

    String getPageInfo();

    ViewTouchImage getViewTouchImage();

    boolean isDocsViewInfoZoom();

    void setPageSwap(int i);

    void setSCanvas(SpenMultiView spenMultiView);
}
