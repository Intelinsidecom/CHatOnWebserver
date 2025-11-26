package com.samsung.android.sdk.pen.engine;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import com.C2Ddrawbitmap.c2ddrawbitmapJNI;
import com.samsung.android.sdk.pen.SpenSettingEraserInfo;
import com.samsung.android.sdk.pen.SpenSettingPenInfo;
import com.samsung.android.sdk.pen.SpenSettingRemoverInfo;
import com.samsung.android.sdk.pen.SpenSettingSelectionInfo;
import com.samsung.android.sdk.pen.SpenSettingTextInfo;
import com.samsung.android.sdk.pen.SpenSettingViewInterface;
import com.samsung.android.sdk.pen.document.SpenObjectBase;
import com.samsung.android.sdk.pen.document.SpenObjectContainer;
import com.samsung.android.sdk.pen.document.SpenObjectStroke;
import com.samsung.android.sdk.pen.document.SpenPageDoc;
import com.samsung.android.sdk.pen.engine.SpenInView;
import com.samsung.android.sdk.pen.util.SpenError;
import com.vlingo.sdk.recognition.spotter.VLSpotterContext;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class SpenSurfaceView extends SurfaceView implements SpenSettingViewInterface {
    public static final int PAGE_TRANSITION_EFFECT_LEFT = 0;
    public static final int PAGE_TRANSITION_EFFECT_RIGHT = 1;
    public static final int PAGE_TRANSITION_EFFECT_TYPE_SHADOW = 0;
    public static final int PAGE_TRANSITION_EFFECT_TYPE_SLIDE = 1;
    public static final int REPLAY_STATE_PAUSED = 2;
    public static final int REPLAY_STATE_PLAYING = 1;
    public static final int REPLAY_STATE_STOPPED = 0;
    public static final String STROKE_FRAME_KEY = "STROKE_FRAME";
    public static final int STROKE_FRAME_RETAKE = 2;
    public static final int STROKE_FRAME_TAKE = 1;
    private static final String TAG = "SpenSurfaceView";
    private HolderCallback mHolderCallback;
    private SurfaceUpdateCanvasListener mListener;
    private Rect mMetricsRect;
    private SpenInView mSpenInView;

    public SpenSurfaceView(Context context) {
        super(context);
        this.mSpenInView = null;
        this.mListener = null;
        this.mMetricsRect = null;
        this.mHolderCallback = null;
        construct(context);
    }

    public SpenSurfaceView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mSpenInView = null;
        this.mListener = null;
        this.mMetricsRect = null;
        this.mHolderCallback = null;
        construct(context);
    }

    public SpenSurfaceView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.mSpenInView = null;
        this.mListener = null;
        this.mMetricsRect = null;
        this.mHolderCallback = null;
        construct(context);
    }

    private class HolderCallback implements SurfaceHolder.Callback {
        private HolderCallback() {
        }

        /* synthetic */ HolderCallback(SpenSurfaceView spenSurfaceView, HolderCallback holderCallback) {
            this();
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
            if (SpenSurfaceView.this.mListener != null) {
                SpenSurfaceView.this.mListener.onUpdateCanvas(null, true);
            }
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceCreated(SurfaceHolder arg0) {
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceDestroyed(SurfaceHolder holder) {
        }
    }

    private void construct(Context context) {
        this.mListener = new SurfaceUpdateCanvasListener();
        this.mSpenInView = new SpenInView(context, this.mListener, true);
        if (this.mSpenInView == null) {
            SpenError.ThrowUncheckedException(9, "failed to create SpenInView");
            return;
        }
        if (context == null) {
            SpenError.ThrowUncheckedException(8, " : context must not be null");
            return;
        }
        this.mSpenInView.setView(this);
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        int width = displayMetrics.widthPixels > displayMetrics.heightPixels ? displayMetrics.widthPixels : displayMetrics.heightPixels;
        this.mMetricsRect = new Rect(0, 0, width, width);
        SurfaceHolder holder = getHolder();
        this.mHolderCallback = new HolderCallback(this, null);
        holder.addCallback(this.mHolderCallback);
        holder.setFormat(1);
        String releaseNumber = Build.VERSION.RELEASE;
        if (releaseNumber.startsWith("4.")) {
            setOnHoverListener(this.mSpenInView.mHoverPointerlistener);
        }
    }

    public void close() {
        if (this.mSpenInView != null) {
            this.mSpenInView.close();
            this.mSpenInView = null;
            this.mMetricsRect = null;
            SurfaceHolder holder = getHolder();
            holder.removeCallback(this.mHolderCallback);
            this.mHolderCallback = null;
            this.mListener = null;
        }
    }

    @Override // android.view.View
    protected void onVisibilityChanged(View changedView, int visibility) {
        if (this.mSpenInView != null) {
            this.mSpenInView.onVisibilityChanged(changedView, visibility);
            super.onVisibilityChanged(changedView, visibility);
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        try {
            c2ddrawbitmapJNI.native_deinit_c2dJNI();
            c2ddrawbitmapJNI.native_init_c2dJNI();
        } catch (ExceptionInInitializerError e) {
        } catch (NoClassDefFoundError e2) {
        } catch (UnsatisfiedLinkError e3) {
        }
        Log.e(TAG, "onSizeChanged(" + w + ", " + h + ", " + oldw + ", " + oldh + ")");
    }

    @Override // android.view.View
    @SuppressLint({"DrawAllocation", "WrongCall"})
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        if (this.mSpenInView != null) {
            Rect parentLayoutRect = new Rect();
            ((ViewGroup) getParent()).getGlobalVisibleRect(parentLayoutRect);
            Rect windowVisibleRect = new Rect();
            getWindowVisibleDisplayFrame(windowVisibleRect);
            if ((this.mMetricsRect != null && !this.mMetricsRect.contains(windowVisibleRect)) || windowVisibleRect.bottom >= parentLayoutRect.bottom || windowVisibleRect.bottom <= parentLayoutRect.top) {
                windowVisibleRect = null;
            }
            this.mSpenInView.onLayout(changed, left, top, right, bottom, parentLayoutRect, windowVisibleRect);
        }
    }

    @Override // android.view.SurfaceView, android.view.View
    protected void onAttachedToWindow() {
        if (this.mSpenInView != null) {
            this.mSpenInView.setParent((ViewGroup) getParent());
            super.onAttachedToWindow();
        }
    }

    @Override // android.view.SurfaceView, android.view.View
    protected void onDetachedFromWindow() {
        if (this.mSpenInView != null) {
            this.mSpenInView.setParent(null);
            super.onDetachedFromWindow();
        }
    }

    public void update() {
        if (this.mSpenInView != null) {
            this.mSpenInView.update();
        }
    }

    public void updateScreenFrameBuffer() {
        if (this.mSpenInView != null) {
            this.mSpenInView.updateScreenFrameBuffer();
        }
    }

    public void updateScreen() {
        if (this.mSpenInView != null) {
            this.mSpenInView.updateScreen();
        }
    }

    public void updateUndo(SpenPageDoc.HistoryUpdateInfo[] userDataList) {
        if (this.mSpenInView != null) {
            this.mSpenInView.updateUndo(userDataList);
        }
    }

    public void updateRedo(SpenPageDoc.HistoryUpdateInfo[] userDataList) {
        if (this.mSpenInView != null) {
            this.mSpenInView.updateRedo(userDataList);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent event) {
        if (this.mSpenInView == null) {
            return false;
        }
        return this.mSpenInView.onTouchEvent(event);
    }

    @Override // android.view.View
    public boolean onHoverEvent(MotionEvent event) {
        if (this.mSpenInView == null) {
            return false;
        }
        return this.mSpenInView.onHoverEvent(event);
    }

    public Bitmap captureCurrentView(boolean includeBlank) {
        if (this.mSpenInView == null) {
            return null;
        }
        return this.mSpenInView.captureCurrentView(includeBlank);
    }

    public Bitmap capturePage(float ratio) {
        if (this.mSpenInView == null) {
            return null;
        }
        return this.mSpenInView.capturePage(ratio);
    }

    @Override // com.samsung.android.sdk.pen.SpenSettingViewInterface
    public void setToolTypeAction(int toolType, int action) {
        if (this.mSpenInView != null) {
            this.mSpenInView.setToolTypeAction(toolType, action);
        }
    }

    @Override // com.samsung.android.sdk.pen.SpenSettingViewInterface
    public int getToolTypeAction(int toolType) {
        if (this.mSpenInView == null) {
            return 0;
        }
        return this.mSpenInView.getToolTypeAction(toolType);
    }

    public void setZoomable(boolean enable) {
        if (this.mSpenInView != null) {
            this.mSpenInView.setZoomable(enable);
        }
    }

    public boolean isZoomable() {
        if (this.mSpenInView == null) {
            return false;
        }
        return this.mSpenInView.isZoomable();
    }

    public void setZoom(float centerX, float centerY, float ratio) {
        if (this.mSpenInView != null) {
            this.mSpenInView.setZoom(centerX, centerY, ratio);
        }
    }

    public float getZoomRatio() {
        return this.mSpenInView == null ? VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET : this.mSpenInView.getZoomRatio();
    }

    public PointF getFrameStartPosition() {
        if (this.mSpenInView == null) {
            return null;
        }
        return this.mSpenInView.getFrameStartPosition();
    }

    public boolean setMaxZoomRatio(float ratio) {
        if (this.mSpenInView == null) {
            return false;
        }
        return this.mSpenInView.setMaxZoomRatio(ratio);
    }

    public float getMaxZoomRatio() {
        return this.mSpenInView == null ? VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET : this.mSpenInView.getMaxZoomRatio();
    }

    public boolean setMinZoomRatio(float ratio) {
        if (this.mSpenInView == null) {
            return false;
        }
        return this.mSpenInView.setMinZoomRatio(ratio);
    }

    public float getMinZoomRatio() {
        return this.mSpenInView == null ? VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET : this.mSpenInView.getMinZoomRatio();
    }

    public void setPan(PointF position) {
        if (this.mSpenInView != null) {
            this.mSpenInView.setPan(position);
        }
    }

    public PointF getPan() {
        if (this.mSpenInView == null) {
            return null;
        }
        return this.mSpenInView.getPan();
    }

    public void setBlankColor(int color) {
        if (this.mSpenInView != null) {
            this.mSpenInView.setBlankColor(color);
        }
    }

    public int getBlankColor() {
        if (this.mSpenInView == null) {
            return 0;
        }
        return this.mSpenInView.getBlankColor();
    }

    @Override // com.samsung.android.sdk.pen.SpenSettingViewInterface
    public int getCanvasWidth() {
        if (this.mSpenInView == null) {
            return 0;
        }
        return this.mSpenInView.getCanvasWidth();
    }

    @Override // com.samsung.android.sdk.pen.SpenSettingViewInterface
    public int getCanvasHeight() {
        if (this.mSpenInView == null) {
            return 0;
        }
        return this.mSpenInView.getCanvasHeight();
    }

    @Override // com.samsung.android.sdk.pen.SpenSettingViewInterface
    public void setBackgroundColorChangeListener(Object object, SpenSettingViewInterface.SpenBackgroundColorChangeListener listener) {
        if (this.mSpenInView != null) {
            this.mSpenInView.setBackgroundColorChangeListener(object, listener);
        }
    }

    @Override // com.samsung.android.sdk.pen.SpenSettingViewInterface
    public void setTextSettingInfo(SpenSettingTextInfo info) {
        if (this.mSpenInView != null) {
            this.mSpenInView.setTextSettingInfo(info);
        }
    }

    @Override // com.samsung.android.sdk.pen.SpenSettingViewInterface
    public SpenSettingTextInfo getTextSettingInfo() {
        if (this.mSpenInView == null) {
            return null;
        }
        return this.mSpenInView.getTextSettingInfo();
    }

    @Override // com.samsung.android.sdk.pen.SpenSettingViewInterface
    public void setPenSettingInfo(SpenSettingPenInfo info) {
        if (this.mSpenInView != null) {
            this.mSpenInView.setPenSettingInfo(info);
        }
    }

    @Override // com.samsung.android.sdk.pen.SpenSettingViewInterface
    public SpenSettingPenInfo getPenSettingInfo() {
        if (this.mSpenInView == null) {
            return null;
        }
        return this.mSpenInView.getPenSettingInfo();
    }

    @Override // com.samsung.android.sdk.pen.SpenSettingViewInterface
    public void setEraserSettingInfo(SpenSettingEraserInfo info) {
        if (this.mSpenInView != null) {
            this.mSpenInView.setEraserSettingInfo(info);
        }
    }

    @Override // com.samsung.android.sdk.pen.SpenSettingViewInterface
    public SpenSettingEraserInfo getEraserSettingInfo() {
        if (this.mSpenInView == null) {
            return null;
        }
        return this.mSpenInView.getEraserSettingInfo();
    }

    @Override // com.samsung.android.sdk.pen.SpenSettingViewInterface
    public void setRemoverSettingInfo(SpenSettingRemoverInfo info) {
        if (this.mSpenInView != null) {
            this.mSpenInView.setRemoverSettingInfo(info);
        }
    }

    @Override // com.samsung.android.sdk.pen.SpenSettingViewInterface
    public SpenSettingRemoverInfo getRemoverSettingInfo() {
        if (this.mSpenInView == null) {
            return null;
        }
        return this.mSpenInView.getRemoverSettingInfo();
    }

    @Override // com.samsung.android.sdk.pen.SpenSettingViewInterface
    public void setSelectionSettingInfo(SpenSettingSelectionInfo info) {
        if (this.mSpenInView != null) {
            this.mSpenInView.setSelectionSettingInfo(info);
        }
    }

    @Override // com.samsung.android.sdk.pen.SpenSettingViewInterface
    public SpenSettingSelectionInfo getSelectionSettingInfo() {
        if (this.mSpenInView == null) {
            return null;
        }
        return this.mSpenInView.getSelectionSettingInfo();
    }

    public boolean setPageDoc(SpenPageDoc pageDoc, boolean isUpdate) {
        if (this.mSpenInView == null) {
            return false;
        }
        return this.mSpenInView.setPageDoc(pageDoc, isUpdate);
    }

    public boolean setPageDoc(SpenPageDoc pageDoc, int direction, int type, float centerY) {
        if (this.mSpenInView == null) {
            return false;
        }
        return this.mSpenInView.setPageDoc(pageDoc, direction, type, centerY);
    }

    public void setSmartScaleEnabled(boolean enable, Rect region, int effectFrame, int zoomOutResponseTime, float zoomRatio) {
        if (this.mSpenInView != null) {
            this.mSpenInView.setSmartScaleEnabled(enable, region, effectFrame, zoomOutResponseTime, zoomRatio);
        }
    }

    public boolean isSmartScaleEnabled() {
        if (this.mSpenInView == null) {
            return false;
        }
        return this.mSpenInView.isSmartScaleEnabled();
    }

    public void setHorizontalSmartScrollEnabled(boolean enable, Rect leftScrollRegion, Rect rightScrollRegion, int responseTime, int velocity) {
        if (this.mSpenInView != null) {
            this.mSpenInView.setHorizontalSmartScrollEnabled(enable, leftScrollRegion, rightScrollRegion, responseTime, velocity);
        }
    }

    public boolean isHorizontalSmartScrollEnabled() {
        if (this.mSpenInView == null) {
            return false;
        }
        return this.mSpenInView.isHorizontalSmartScrollEnabled();
    }

    public void setVerticalSmartScrollEnabled(boolean enable, Rect topScrollRegion, Rect bottomScrollRegion, int responseTime, int velocity) {
        if (this.mSpenInView != null) {
            this.mSpenInView.setVerticalSmartScrollEnabled(enable, topScrollRegion, bottomScrollRegion, responseTime, velocity);
        }
    }

    public boolean isVerticalSmartScrollEnabled() {
        if (this.mSpenInView == null) {
            return false;
        }
        return this.mSpenInView.isVerticalSmartScrollEnabled();
    }

    public void setControl(SpenControlBase control) {
        if (this.mSpenInView != null) {
            this.mSpenInView.setControl(control);
        }
    }

    public SpenControlBase getControl() {
        if (this.mSpenInView == null) {
            return null;
        }
        return this.mSpenInView.getControl();
    }

    @Override // com.samsung.android.sdk.pen.SpenSettingViewInterface
    public void closeControl() {
        if (this.mSpenInView != null) {
            this.mSpenInView.closeControl();
        }
    }

    public void startReplay() {
        if (this.mSpenInView != null) {
            this.mSpenInView.startReplay();
        }
    }

    public void stopReplay() {
        if (this.mSpenInView != null) {
            this.mSpenInView.stopReplay();
        }
    }

    public void pauseReplay() {
        if (this.mSpenInView != null) {
            this.mSpenInView.pauseReplay();
        }
    }

    public void resumeReplay() {
        if (this.mSpenInView != null) {
            this.mSpenInView.resumeReplay();
        }
    }

    public int getReplayState() {
        if (this.mSpenInView == null) {
            return 0;
        }
        return this.mSpenInView.getReplayState();
    }

    public void setReplaySpeed(int speed) {
        if (this.mSpenInView != null) {
            this.mSpenInView.setReplaySpeed(speed);
        }
    }

    public void setReplayPosition(int index) {
        if (this.mSpenInView != null) {
            this.mSpenInView.setReplayPosition(index);
        }
    }

    public void setDottedLineEnabled(boolean enable, int intervalHeight, int color, int thickness, float[] pathIntervals, float phase) {
        if (this.mSpenInView != null) {
            this.mSpenInView.setDottedLineEnabled(enable, intervalHeight, color, thickness, pathIntervals, phase);
        }
    }

    public boolean isDottedLineEnabled() {
        if (this.mSpenInView == null) {
            return false;
        }
        return this.mSpenInView.isDottedLineEnabled();
    }

    public void setHighlight(ArrayList<SpenHighlightInfo> highlightInfo) {
        if (this.mSpenInView != null) {
            this.mSpenInView.setHighlight(highlightInfo);
        }
    }

    public void clearHighlight() {
        if (this.mSpenInView != null) {
            this.mSpenInView.clearHighlight();
        }
    }

    public void startTemporaryStroke() {
        if (this.mSpenInView != null) {
            this.mSpenInView.startTemporaryStroke();
        }
    }

    public void stopTemporaryStroke() {
        if (this.mSpenInView != null) {
            this.mSpenInView.stopTemporaryStroke();
        }
    }

    public ArrayList<SpenObjectStroke> getTemporaryStroke() {
        if (this.mSpenInView == null) {
            return null;
        }
        return this.mSpenInView.getTemporaryStroke();
    }

    public void setScrollBarEnabled(boolean enable) {
        if (this.mSpenInView != null) {
            this.mSpenInView.setScrollBarEnabled(enable);
        }
    }

    public boolean isScrollBarEnabled() {
        if (this.mSpenInView == null) {
            return false;
        }
        return this.mSpenInView.isScrollBarEnabled();
    }

    public void setHyperTextViewEnabled(boolean enable) {
        if (this.mSpenInView != null) {
            this.mSpenInView.setHyperTextViewEnabled(enable);
        }
    }

    public boolean isHyperTextViewEnabled() {
        if (this.mSpenInView == null) {
            return false;
        }
        return this.mSpenInView.isHyperTextViewEnabled();
    }

    public void setToolTipEnabled(boolean enable) {
        if (this.mSpenInView != null) {
            this.mSpenInView.setToolTipEnabled(enable);
        }
    }

    public boolean isToolTipEnabled() {
        if (this.mSpenInView == null) {
            return false;
        }
        return this.mSpenInView.isToolTipEnabled();
    }

    public void setZoomPadPosition(PointF point) {
        if (this.mSpenInView != null) {
            this.mSpenInView.setZoomPadPosition(point);
        }
    }

    public PointF getZoomPadPosition() {
        if (this.mSpenInView == null) {
            return null;
        }
        return this.mSpenInView.getZoomPadPosition();
    }

    public void startZoomPad() {
        if (this.mSpenInView != null) {
            this.mSpenInView.startZoomPad();
        }
    }

    public void stopZoomPad() {
        if (this.mSpenInView != null) {
            this.mSpenInView.stopZoomPad();
        }
    }

    public boolean isZoomPadEnabled() {
        if (this.mSpenInView == null) {
            return false;
        }
        return this.mSpenInView.isZoomPadEnabled();
    }

    public Bitmap drawObjectList(ArrayList<SpenObjectBase> objectList) {
        if (this.mSpenInView == null) {
            return null;
        }
        return this.mSpenInView.drawObjectList(objectList);
    }

    public void cancelStroke() {
        if (this.mSpenInView != null) {
            this.mSpenInView.cancelStroke();
        }
    }

    @Override // android.view.View
    @Deprecated
    public void setBackground(Drawable background) {
        SpenError.ThrowUncheckedException(13, " : setBackground not supported");
    }

    @Override // android.view.View
    @Deprecated
    public void setBackgroundDrawable(Drawable background) {
        SpenError.ThrowUncheckedException(13, " : setBackgroundDrawable not supported");
    }

    @Override // android.view.View
    @Deprecated
    public void setBackgroundColor(int color) {
        SpenError.ThrowUncheckedException(13, " : setBackgroundColor not supported");
    }

    @Override // android.view.View
    @Deprecated
    public void setBackgroundResource(int resid) {
        SpenError.ThrowUncheckedException(13, " : setBackgroundResource not supported");
    }

    public void setPreTouchListener(SpenTouchListener listener) {
        if (this.mSpenInView != null) {
            this.mSpenInView.setPreTouchListener(listener);
        }
    }

    public void setTouchListener(SpenTouchListener listener) {
        if (this.mSpenInView != null) {
            this.mSpenInView.setTouchListener(listener);
        }
    }

    public void setHoverListener(SpenHoverListener listener) {
        if (this.mSpenInView != null) {
            this.mSpenInView.setHoverListener(listener);
        }
    }

    public void setLongPressListener(SpenLongPressListener listener) {
        if (this.mSpenInView != null) {
            this.mSpenInView.setLongPressListener(listener);
        }
    }

    public void setReplayListener(SpenReplayListener listener) {
        if (this.mSpenInView != null) {
            this.mSpenInView.setReplayListener(listener);
        }
    }

    public void setColorPickerListener(SpenColorPickerListener listener) {
        if (this.mSpenInView != null) {
            this.mSpenInView.setColorPickerListener(listener);
        }
    }

    public void setZoomListener(SpenZoomListener listener) {
        if (this.mSpenInView != null) {
            this.mSpenInView.setZoomListener(listener);
        }
    }

    public void setPageEffectListener(SpenPageEffectListener listener) {
        if (this.mSpenInView != null) {
            this.mSpenInView.setPageEffectListener(listener);
        }
    }

    public void setPenDetachmentListener(SpenPenDetachmentListener listener) {
        if (this.mSpenInView != null) {
            this.mSpenInView.setPenDetachmentListener(listener);
        }
    }

    public void setPenChangeListener(SpenPenChangeListener listener) {
        if (this.mSpenInView != null) {
            this.mSpenInView.setPenChangeListener(listener);
        }
    }

    public void setEraserChangeListener(SpenEraserChangeListener listener) {
        if (this.mSpenInView != null) {
            this.mSpenInView.setEraserChangeListener(listener);
        }
    }

    public void setRemoverChangeListener(SpenRemoverChangeListener listener) {
        if (this.mSpenInView != null) {
            this.mSpenInView.setRemoverChangeListener(listener);
        }
    }

    public void setTextChangeListener(SpenTextChangeListener listener) {
        if (this.mSpenInView != null) {
            this.mSpenInView.setTextChangeListener(listener);
        }
    }

    public void setSelectionChangeListener(SpenSelectionChangeListener listener) {
        if (this.mSpenInView != null) {
            this.mSpenInView.setSelectionChangeListener(listener);
        }
    }

    public void setControlListener(SpenControlListener listener) {
        if (this.mSpenInView != null) {
            this.mSpenInView.setControlListener(listener);
        }
    }

    public void setFlickListener(SpenFlickListener listener) {
        if (this.mSpenInView != null) {
            this.mSpenInView.setFlickListener(listener);
        }
    }

    public void setPreDrawListener(SpenDrawListener listener) {
        if (this.mSpenInView != null) {
            this.mSpenInView.setPreDrawListener(listener);
        }
    }

    public void setPostDrawListener(SpenDrawListener listener) {
        if (this.mSpenInView != null) {
            this.mSpenInView.setPostDrawListener(listener);
        }
    }

    public void setHyperTextListener(SpenHyperTextListener listener) {
        if (this.mSpenInView != null) {
            this.mSpenInView.setHyperTextListener(listener);
        }
    }

    public void setZoomPadListener(SpenZoomPadListener listener) {
        if (this.mSpenInView != null) {
            this.mSpenInView.setZoomPadListener(listener);
        }
    }

    public void takeStrokeFrame(Activity activity, ViewGroup canvasLayout, List<SpenObjectStroke> strokeList, SpenStrokeFrameListener listener) {
        if (this.mSpenInView != null) {
            this.mSpenInView.takeStrokeFrame(activity, canvasLayout, strokeList, listener);
        }
    }

    public void retakeStrokeFrame(Activity activity, ViewGroup canvasLayout, SpenObjectContainer strokeFrameContainer, SpenStrokeFrameListener listener) {
        if (this.mSpenInView != null) {
            this.mSpenInView.retakeStrokeFrame(activity, canvasLayout, strokeFrameContainer, listener);
        }
    }

    public void changeStrokeFrame(SpenObjectContainer objectContainer) {
        if (this.mSpenInView != null) {
            this.mSpenInView.changeStrokeFrame(objectContainer);
        }
    }

    public void cancelStrokeFrame() {
        if (this.mSpenInView != null) {
            this.mSpenInView.cancelStrokeFrame();
        }
    }

    class SurfaceUpdateCanvasListener implements SpenInView.UpdateCanvasListener {
        SurfaceUpdateCanvasListener() {
        }

        @Override // com.samsung.android.sdk.pen.engine.SpenInView.UpdateCanvasListener
        public void onUpdateCanvas(RectF rectf, boolean isScreenFramebuffer) {
            if (SpenSurfaceView.this.mSpenInView != null) {
                Rect dstRect = null;
                if (!SpenSurfaceView.this.mSpenInView.GetPageEffectWorking()) {
                    if (rectf != null && (rectf.width() != SpenSurfaceView.this.mSpenInView.GetScreenWidth() || rectf.height() != SpenSurfaceView.this.mSpenInView.GetScreenHeight())) {
                        if (rectf.intersect(VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, SpenSurfaceView.this.mSpenInView.GetRtoBmpItstScrWidth(), SpenSurfaceView.this.mSpenInView.GetRtoBmpItstScrHeight())) {
                            if (!isScreenFramebuffer && SpenSurfaceView.this.mSpenInView.getZoomRatio() != 1.0f) {
                                rectf = null;
                            }
                        } else {
                            return;
                        }
                    }
                    if (rectf != null) {
                        dstRect = new Rect((int) Math.floor(rectf.left), (int) Math.floor(rectf.top), (int) Math.ceil(rectf.right), (int) Math.ceil(rectf.bottom));
                        if (rectf.width() != SpenSurfaceView.this.mSpenInView.GetScreenWidth() || rectf.height() != SpenSurfaceView.this.mSpenInView.GetScreenHeight()) {
                            dstRect.offset(SpenSurfaceView.this.mSpenInView.GetScreenStartX(), SpenSurfaceView.this.mSpenInView.GetScreenStartY());
                        }
                    }
                }
                Rect copyDstRect = null;
                if (dstRect != null) {
                    copyDstRect = new Rect(dstRect);
                }
                long time = SystemClock.uptimeMillis();
                SurfaceHolder holder = SpenSurfaceView.this.getHolder();
                synchronized (holder) {
                    Canvas canvas = holder.lockCanvas(dstRect);
                    if (canvas == null) {
                        Log.i(SpenSurfaceView.TAG, "Performance onUpdateCanvas lockCanvas return null");
                        return;
                    }
                    long lockCanvasTime = SystemClock.uptimeMillis();
                    if (dstRect != null && (dstRect.left != copyDstRect.left || dstRect.top != copyDstRect.top || dstRect.right != copyDstRect.right || dstRect.bottom != copyDstRect.bottom)) {
                        Log.e(SpenSurfaceView.TAG, "Performance lockCanvas warning: originDirtyRect (" + copyDstRect.left + ", " + copyDstRect.top + ") (" + copyDstRect.right + ", " + copyDstRect.bottom + ") w = " + copyDstRect.width() + " h = " + copyDstRect.height());
                        Log.e(SpenSurfaceView.TAG, "Performance lockCanvas warning: outDirtyRect (" + dstRect.left + ", " + dstRect.top + ") (" + dstRect.right + ", " + dstRect.bottom + ") w = " + dstRect.width() + " h = " + dstRect.height());
                        rectf = null;
                    }
                    SpenSurfaceView.this.mSpenInView.UpdateCanvas(canvas, rectf, isScreenFramebuffer);
                    long drawTime = SystemClock.uptimeMillis();
                    if (canvas != null) {
                        holder.unlockCanvasAndPost(canvas);
                    }
                    long unlcokCanvasTime = SystemClock.uptimeMillis();
                    Log.v(SpenSurfaceView.TAG, "Performance total = " + (SystemClock.uptimeMillis() - time) + " ms lockCanvasTime = " + (lockCanvasTime - time) + " ms drawTime = " + (drawTime - lockCanvasTime) + " ms unlcokCanvasTime = " + (unlcokCanvasTime - drawTime) + " ms");
                }
            }
        }
    }
}
