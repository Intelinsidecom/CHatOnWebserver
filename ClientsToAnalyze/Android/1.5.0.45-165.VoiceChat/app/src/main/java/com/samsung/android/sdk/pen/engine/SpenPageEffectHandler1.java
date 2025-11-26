package com.samsung.android.sdk.pen.engine;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Shader;
import android.os.Handler;
import android.os.Message;
import com.samsung.android.sdk.pen.engine.SpenPageEffectHandler;
import com.vlingo.sdk.recognition.spotter.VLSpotterContext;

/* compiled from: SpenPageEffectHandler.java */
/* loaded from: classes.dex */
class SpenPageEffectHandler1 extends Handler implements SpenPageEffectHandler {
    private static final int FRAME_COUNT = 12;
    private static final float MIN_RATIO = 0.98f;
    private static final int PAGE_EFFECT_TIMER_INTERVAL = 0;
    private static final float SIZE_FACTOR = 0.0016666651f;
    private Paint mBackPaint;
    private Bitmap mBmpGradient;
    private int mCanvasHeight;
    private int mCanvasWidth;
    private int mCount;
    private int mDirection;
    private SpenPageEffectHandler.Listener mListener;
    private int mScreenHeight;
    private int mScreenWidth;
    private Screenshot mShotL;
    private Screenshot mShotR;
    private int mStartX;
    private int mStartY;
    private boolean mWorking;
    private Screenshot mShot0 = new Screenshot();
    private Screenshot mShot1 = new Screenshot();
    private Rect[] mBackRect = new Rect[7];

    /* compiled from: SpenPageEffectHandler.java */
    private class Screenshot {
        public Bitmap bmp;
        public Rect src = new Rect();
        public Rect dst = new Rect();

        public Screenshot() {
        }

        public boolean saveScreenshot() {
            try {
                this.bmp = Bitmap.createBitmap(SpenPageEffectHandler1.this.mCanvasWidth, SpenPageEffectHandler1.this.mCanvasHeight, Bitmap.Config.ARGB_8888);
                Canvas canvas = new Canvas(this.bmp);
                SpenPageEffectHandler1.this.mListener.onUpdateCanvasLayer2(canvas);
                return true;
            } catch (Exception e) {
                this.bmp = null;
                return false;
            } catch (OutOfMemoryError e2) {
                this.bmp = null;
                return false;
            }
        }

        public void clean() {
            if (this.bmp != null) {
                this.bmp.recycle();
            }
            this.src.setEmpty();
            this.dst.setEmpty();
            this.bmp = null;
        }
    }

    public SpenPageEffectHandler1(SpenPageEffectHandler.Listener listener) {
        for (int i = 0; i < this.mBackRect.length; i++) {
            this.mBackRect[i] = new Rect();
        }
        this.mListener = listener;
        this.mWorking = false;
    }

    @Override // com.samsung.android.sdk.pen.engine.SpenPageEffectHandler
    public void close() {
        removeMessages(0);
        this.mWorking = false;
        if (this.mShot0 != null) {
            this.mShot0.clean();
            this.mShot0.src = null;
            this.mShot0.dst = null;
            this.mShot0 = null;
        }
        if (this.mShot1 != null) {
            this.mShot1.clean();
            this.mShot1.src = null;
            this.mShot1.dst = null;
            this.mShot1 = null;
        }
        if (this.mBmpGradient != null && !this.mBmpGradient.isRecycled()) {
            this.mBmpGradient.recycle();
            this.mBmpGradient = null;
        }
        this.mBackRect = null;
        this.mListener = null;
    }

    @Override // com.samsung.android.sdk.pen.engine.SpenPageEffectHandler
    public void setPaint(Paint paint) {
        this.mBackPaint = paint;
    }

    @Override // com.samsung.android.sdk.pen.engine.SpenPageEffectHandler
    public void setScreenResolution(int w, int h) {
        if (w != this.mScreenWidth || h != this.mScreenHeight) {
            this.mScreenWidth = w;
            this.mScreenHeight = h;
            if (this.mWorking) {
                this.mWorking = false;
            }
        }
    }

    @Override // com.samsung.android.sdk.pen.engine.SpenPageEffectHandler
    public void setCanvasInformation(int x, int y, int w, int h) {
        this.mStartX = x;
        this.mStartY = y;
        this.mCanvasWidth = w;
        this.mCanvasHeight = h;
    }

    @Override // com.samsung.android.sdk.pen.engine.SpenPageEffectHandler
    public boolean saveScreenshot() {
        if (makeShadowBitmap()) {
            return this.mShot0.saveScreenshot();
        }
        return false;
    }

    @Override // com.samsung.android.sdk.pen.engine.SpenPageEffectHandler
    public boolean startAnimation(int direction) {
        if (!this.mShot1.saveScreenshot()) {
            return false;
        }
        this.mShot0.src.set(0, 0, this.mCanvasWidth, this.mCanvasHeight);
        this.mShot0.dst.set(this.mStartX, this.mStartY, this.mStartX + this.mCanvasWidth, this.mStartY + this.mCanvasHeight);
        if (direction == 0) {
            this.mShotL = this.mShot1;
            this.mShotR = this.mShot0;
        } else {
            this.mShotL = this.mShot0;
            this.mShotR = this.mShot1;
        }
        this.mCount = 0;
        this.mDirection = direction;
        this.mWorking = true;
        sendEmptyMessageDelayed(0, 0L);
        return true;
    }

    @Override // com.samsung.android.sdk.pen.engine.SpenPageEffectHandler
    public boolean isWorking() {
        return this.mWorking;
    }

    @Override // com.samsung.android.sdk.pen.engine.SpenPageEffectHandler
    public void drawAnimation(Canvas canvas) {
        for (Rect r : this.mBackRect) {
            if (!r.isEmpty()) {
                canvas.drawRect(r, this.mBackPaint);
            }
        }
        if (!this.mShotR.src.isEmpty()) {
            canvas.drawBitmap(this.mShotR.bmp, this.mShotR.src, this.mShotR.dst, (Paint) null);
        }
        if (!this.mShot0.src.isEmpty()) {
            canvas.drawBitmap(this.mShotL.bmp, this.mShotL.src, this.mShotL.dst, (Paint) null);
            canvas.drawBitmap(this.mBmpGradient, this.mShotL.dst.right, this.mStartY, (Paint) null);
        }
    }

    @Override // android.os.Handler
    public void handleMessage(Message msg) {
        int i = this.mCount;
        this.mCount = i + 1;
        if (i == 12) {
            endAnimation();
            return;
        }
        float tomak = this.mCanvasWidth / 12.0f;
        float moveDistance = this.mDirection == 0 ? tomak * ((12 - this.mCount) + 1) : tomak * this.mCount;
        float dstStartX = (-moveDistance) + this.mStartX;
        if (dstStartX > VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET) {
            this.mShotL.src.set(0, 0, this.mCanvasWidth, this.mCanvasHeight);
            this.mShotL.dst.set((int) dstStartX, this.mStartY, (int) (this.mCanvasWidth + dstStartX), this.mStartY + this.mCanvasHeight);
        } else {
            this.mShotL.src.set((int) (-dstStartX), 0, this.mCanvasWidth, this.mCanvasHeight);
            this.mShotL.dst.set(0, this.mStartY, (int) (this.mCanvasWidth + dstStartX), this.mStartY + this.mCanvasHeight);
        }
        float ratio = this.mDirection == 0 ? 1.0f - (SIZE_FACTOR * this.mCount) : MIN_RATIO + (SIZE_FACTOR * (this.mCount - 1));
        float newW = this.mCanvasWidth * ratio;
        float newH = this.mCanvasHeight * ratio;
        float newX = this.mStartX + ((this.mCanvasWidth - newW) / 2.0f);
        float newY = this.mStartY + ((this.mCanvasHeight - newH) / 2.0f);
        float dstL = Math.max(newX, this.mShotL.dst.right);
        float dstR = newX + newW;
        float dstB = newY + newH;
        this.mShotR.src.set((int) ((dstL - newX) / ratio), 0, this.mCanvasWidth, this.mCanvasHeight);
        this.mShotR.dst.set((int) dstL, (int) newY, (int) dstR, (int) dstB);
        this.mBackRect[0].set(this.mShotL.dst.right, 0, this.mScreenWidth, this.mShotR.dst.top);
        this.mBackRect[1].set(this.mShotL.dst.right, this.mShotR.dst.bottom, this.mScreenWidth, this.mScreenHeight);
        this.mBackRect[2].set(this.mShotL.dst.right, this.mShotR.dst.top, this.mShotR.dst.left, this.mShotR.dst.bottom);
        this.mBackRect[3].set(Math.max(this.mShotL.dst.right, this.mShotR.dst.right), this.mShotR.dst.top, this.mScreenWidth, this.mShotR.dst.bottom);
        this.mBackRect[4].set(0, 0, this.mShotL.dst.right, this.mShotL.dst.top);
        this.mBackRect[5].set(0, this.mShotL.dst.top, this.mShotL.dst.left, this.mShotL.dst.bottom);
        this.mBackRect[6].set(0, this.mShotL.dst.bottom, this.mShotL.dst.right, this.mScreenHeight);
        this.mListener.onUpdate();
        sendEmptyMessageDelayed(0, 0L);
    }

    private void endAnimation() {
        removeMessages(0);
        this.mWorking = false;
        if (this.mListener != null) {
            this.mListener.onFinish();
        }
        if (this.mShot0 != null) {
            this.mShot0.clean();
        }
        if (this.mShot1 != null) {
            this.mShot1.clean();
        }
    }

    private boolean makeShadowBitmap() {
        try {
            this.mBmpGradient = Bitmap.createBitmap(this.mCanvasWidth / 10, this.mCanvasHeight, Bitmap.Config.ARGB_8888);
            LinearGradient gradient = new LinearGradient(VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, this.mCanvasWidth / 10.0f, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, Color.argb(125, 0, 0, 0), Color.argb(0, 255, 255, 255), Shader.TileMode.CLAMP);
            Paint gradientPaint = new Paint();
            gradientPaint.setShader(gradient);
            Canvas canvas = new Canvas(this.mBmpGradient);
            canvas.drawRect(new Rect(0, 0, this.mCanvasWidth / 10, this.mCanvasHeight), gradientPaint);
            return true;
        } catch (Exception e) {
            this.mBmpGradient = null;
            return false;
        } catch (OutOfMemoryError e2) {
            this.mBmpGradient = null;
            return false;
        }
    }
}
