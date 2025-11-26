package com.samsung.android.sdk.pen.engine;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Message;
import com.vlingo.sdk.recognition.spotter.VLSpotterContext;

/* loaded from: classes.dex */
class SpenCanvasViewScroll extends Handler {
    private static final int SCROLL_BAR_MARGIN = 10;
    private static final int SCROLL_BAR_THICK = 10;
    private float mDeltaX;
    private float mDeltaY;
    private final Listener mListener;
    private float mMaxDeltaX;
    private float mMaxDeltaY;
    private int mRatioBitmapH;
    private int mRatioBitmapW;
    private int mScreenH;
    private int mScreenW;
    private boolean mEnable = false;
    private boolean mShow = false;
    private Rect mRectLR = new Rect();
    private Rect mRectTB = new Rect();
    private Paint mPaint = new Paint();

    public interface Listener {
        void onUpdate();
    }

    public SpenCanvasViewScroll(Listener listener) {
        this.mPaint.setColor(-2141233313);
        this.mListener = listener;
    }

    public void close() {
        this.mRectLR = null;
        this.mRectTB = null;
        this.mPaint = null;
    }

    public void drawScroll(Canvas c) {
        if (this.mEnable && this.mShow) {
            if (this.mMaxDeltaX > VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET) {
                c.drawRect(this.mRectLR, this.mPaint);
            }
            if (this.mMaxDeltaY > VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET) {
                c.drawRect(this.mRectTB, this.mPaint);
            }
        }
    }

    public void setScreenSize(int w, int h) {
        this.mScreenW = w;
        this.mScreenH = h;
    }

    public void setRatioBitmapSize(int w, int h) {
        this.mRatioBitmapW = w;
        this.mRatioBitmapH = h;
    }

    public void setDeltaValue(float deltaX, float deltaY, float maxDeltaX, float maxDeltaY) {
        this.mDeltaX = deltaX;
        this.mDeltaY = deltaY;
        this.mMaxDeltaX = maxDeltaX;
        this.mMaxDeltaY = maxDeltaY;
        if (this.mMaxDeltaX > VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET) {
            int scrollbarW = (this.mScreenW * this.mScreenW) / this.mRatioBitmapW;
            int canMoveDistanceW = (this.mScreenW - scrollbarW) + 1;
            float factorW = canMoveDistanceW / this.mMaxDeltaX;
            int startLR = (int) (this.mDeltaX * factorW);
            this.mRectLR.set(startLR, (this.mScreenH - 10) - 10, startLR + scrollbarW, this.mScreenH - 10);
        }
        if (this.mMaxDeltaY > VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET) {
            int scrollbarH = (this.mScreenH * this.mScreenH) / this.mRatioBitmapH;
            int canMoveDistanceH = (this.mScreenH - scrollbarH) + 1;
            float factorH = canMoveDistanceH / this.mMaxDeltaY;
            int startTB = (int) (this.mDeltaY * factorH);
            this.mRectTB.set((this.mScreenW - 10) - 10, startTB, this.mScreenW - 10, startTB + scrollbarH);
        }
        if (this.mEnable) {
            this.mShow = true;
            removeMessages(0);
            sendEmptyMessageDelayed(0, 300L);
        }
    }

    public void enableScroll(boolean enable) {
        this.mEnable = enable;
    }

    public boolean isScroll() {
        return this.mEnable;
    }

    @Override // android.os.Handler
    public void handleMessage(Message msg) {
        this.mShow = false;
        if (this.mListener != null) {
            this.mListener.onUpdate();
        }
    }
}
