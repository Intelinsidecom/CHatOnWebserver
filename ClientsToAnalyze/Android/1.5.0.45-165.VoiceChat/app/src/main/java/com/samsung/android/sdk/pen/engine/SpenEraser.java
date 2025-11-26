package com.samsung.android.sdk.pen.engine;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.view.MotionEvent;

/* loaded from: classes.dex */
class SpenEraser {
    private static final float TOUCH_TOLERANCE_ERASER = 1.0f;
    private Paint mPaint;
    private float mQuadLastX;
    private float mQuadLastY;
    private float mQuadStartX;
    private float mQuadStartY;
    private Path mUnitPath;

    /* renamed from: mX */
    private float f397mX;

    /* renamed from: mY */
    private float f398mY;
    private Canvas mCanvas = null;
    private float mSize = 20.0f;

    public SpenEraser() {
        this.mUnitPath = null;
        this.mPaint = null;
        this.mPaint = new Paint();
        this.mPaint.setAntiAlias(true);
        this.mPaint.setStyle(Paint.Style.STROKE);
        this.mPaint.setStrokeJoin(Paint.Join.ROUND);
        this.mPaint.setStrokeCap(Paint.Cap.ROUND);
        this.mPaint.setStrokeWidth(this.mSize);
        this.mPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        this.mUnitPath = new Path();
        this.mUnitPath.incReserve(3);
    }

    public void startPen(MotionEvent event, RectF rect) {
        this.f397mX = event.getX();
        this.f398mY = event.getY();
        this.mQuadStartX = this.f397mX;
        this.mQuadStartY = this.f398mY;
        this.mQuadLastX = this.f397mX;
        this.mQuadLastY = this.f398mY;
    }

    public void movePen(MotionEvent event, RectF rect) {
        float dx = Math.abs(event.getX() - this.f397mX);
        float dy = Math.abs(event.getY() - this.f398mY);
        float curStrokeWidth = getSize();
        if (dx >= TOUCH_TOLERANCE_ERASER || dy >= TOUCH_TOLERANCE_ERASER) {
            this.mUnitPath.rewind();
            this.mUnitPath.moveTo(this.mQuadStartX, this.mQuadStartY);
            int N = event.getHistorySize();
            for (int i = 0; i < N; i++) {
                float ipX = event.getHistoricalX(i);
                float ipY = event.getHistoricalY(i);
                this.mQuadLastX = (this.f397mX + ipX) / 2.0f;
                this.mQuadLastY = (this.f398mY + ipY) / 2.0f;
                this.mUnitPath.quadTo(this.f397mX, this.f398mY, this.mQuadLastX, this.mQuadLastY);
                this.f397mX = ipX;
                this.f398mY = ipY;
            }
            this.mQuadLastX = (event.getX() + this.f397mX) / 2.0f;
            this.mQuadLastY = (event.getY() + this.f398mY) / 2.0f;
            this.mUnitPath.quadTo(this.f397mX, this.f398mY, this.mQuadLastX, this.mQuadLastY);
            this.mCanvas.drawPath(this.mUnitPath, this.mPaint);
            this.mUnitPath.computeBounds(rect, false);
            float halfSize = (curStrokeWidth / 2.0f) + TOUCH_TOLERANCE_ERASER;
            rect.set(rect.left - halfSize, rect.top - halfSize, rect.right + halfSize, rect.bottom + halfSize);
            this.mQuadStartX = this.mQuadLastX;
            this.mQuadStartY = this.mQuadLastY;
            this.f397mX = event.getX();
            this.f398mY = event.getY();
        }
    }

    public void endPen(MotionEvent event, RectF rect) {
        float curStrokeWidth = getSize();
        this.mUnitPath.rewind();
        this.mUnitPath.moveTo(this.mQuadStartX, this.mQuadStartY);
        this.mUnitPath.lineTo(event.getX(), event.getY());
        this.mCanvas.drawPath(this.mUnitPath, this.mPaint);
        this.mUnitPath.computeBounds(rect, false);
        float halfSize = (curStrokeWidth / 2.0f) + TOUCH_TOLERANCE_ERASER;
        rect.set(rect.left - halfSize, rect.top - halfSize, rect.right + halfSize, rect.bottom + halfSize);
    }

    public void setBitmap(Bitmap bitmap) {
        this.mCanvas = new Canvas(bitmap);
    }

    public void setSize(float size) {
        this.mSize = size;
        if (this.mPaint != null) {
            this.mPaint.setStrokeWidth(this.mSize);
        }
    }

    public float getSize() {
        return this.mSize;
    }

    public void close() {
        this.mPaint = null;
        this.mUnitPath = null;
        this.mCanvas = null;
    }
}
