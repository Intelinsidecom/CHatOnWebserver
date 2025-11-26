package com.samsung.android.sdk.pen.engine;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import com.samsung.android.sdk.pen.engine.SpenPageEffectHandler;
import com.vlingo.sdk.recognition.spotter.VLSpotterContext;

/* loaded from: classes.dex */
class SpenPageEffectHandler2 extends Handler implements SpenPageEffectHandler {
    private static final int PAGE_EFFECT_IN = 1;
    private static final int PAGE_EFFECT_OUT = 2;
    private static final int PAGE_EFFECT_TIMER_INTERVAL = 0;
    private static final String TAG = "PageEffectHandler";
    private float[] mDistanceTable;
    private SpenPageEffectHandler.Listener mListener;
    private int mScreenHeight;
    private int mScreenWidth;
    private Paint mSrcPaint;
    private Bitmap mScreenshot = null;
    private int mDirection = 0;
    private boolean mWorking = false;
    private Paint mBlackPaint = null;
    private int mCount = 0;
    private float mCurrentX = VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET;

    public SpenPageEffectHandler2(SpenPageEffectHandler.Listener listener) {
        this.mSrcPaint = null;
        this.mDistanceTable = null;
        this.mDistanceTable = new float[]{0.15f, 0.202164f, 0.27246857f, 0.36722222f, 0.4949274f, 0.6670434f, 0.89901435f, 1.2116556f, 1.633021f, 2.2009203f, 2.9663124f, 3.9978771f, 5.388179f, 7.261972f, 9.7873955f, 12.5f, 12.5f, 12.5f, 12.5f, 12.5f};
        this.mSrcPaint = new Paint();
        this.mSrcPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC));
        this.mListener = listener;
    }

    @Override // com.samsung.android.sdk.pen.engine.SpenPageEffectHandler
    public void close() {
        if (this.mScreenshot != null) {
            this.mScreenshot.recycle();
            this.mScreenshot = null;
        }
        this.mDistanceTable = null;
        this.mSrcPaint = null;
        this.mListener = null;
        this.mBlackPaint = null;
    }

    @Override // com.samsung.android.sdk.pen.engine.SpenPageEffectHandler
    public void setPaint(Paint paint) {
        this.mBlackPaint = paint;
    }

    @Override // com.samsung.android.sdk.pen.engine.SpenPageEffectHandler
    public void setScreenResolution(int w, int h) {
        this.mScreenWidth = w;
        this.mScreenHeight = h;
    }

    @Override // com.samsung.android.sdk.pen.engine.SpenPageEffectHandler
    public boolean saveScreenshot() {
        try {
            this.mScreenshot = Bitmap.createBitmap(this.mScreenWidth, this.mScreenHeight, Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(this.mScreenshot);
            this.mListener.onUpdateCanvasLayer(canvas);
            return true;
        } catch (Exception e) {
            return false;
        } catch (OutOfMemoryError e2) {
            return false;
        }
    }

    @Override // com.samsung.android.sdk.pen.engine.SpenPageEffectHandler
    public void setCanvasInformation(int x, int y, int w, int h) {
    }

    @Override // com.samsung.android.sdk.pen.engine.SpenPageEffectHandler
    public boolean startAnimation(int direction) {
        if (this.mScreenshot == null) {
            return false;
        }
        this.mCount = 0;
        this.mCurrentX = VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET;
        this.mDirection = direction;
        this.mWorking = true;
        sendEmptyMessageDelayed(2, 0L);
        return true;
    }

    @Override // com.samsung.android.sdk.pen.engine.SpenPageEffectHandler
    public boolean isWorking() {
        return this.mWorking;
    }

    @Override // com.samsung.android.sdk.pen.engine.SpenPageEffectHandler
    public void drawAnimation(Canvas canvas) {
        Log.e(TAG, "Start draw animation");
        canvas.drawBitmap(this.mScreenshot, this.mCurrentX, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, this.mSrcPaint);
        if (this.mCurrentX < VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET) {
            Log.d(TAG, "(" + (this.mScreenWidth + this.mCurrentX) + ", 0) (" + this.mScreenWidth + ", " + this.mScreenHeight + ")");
            canvas.drawRect(this.mCurrentX + this.mScreenWidth, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, this.mScreenWidth, this.mScreenHeight, this.mBlackPaint);
        } else {
            Log.d(TAG, "(0, 0) (" + this.mCurrentX + ", " + this.mScreenHeight + ")");
            canvas.drawRect(VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, this.mCurrentX, this.mScreenHeight, this.mBlackPaint);
        }
        Log.e(TAG, "Start draw animation");
    }

    @Override // android.os.Handler
    public void handleMessage(Message msg) {
        float distance;
        if (msg.what == 2) {
            float distance2 = this.mScreenWidth / 8.0f;
            if (this.mDirection == 0) {
                this.mCurrentX += distance2;
            } else if (this.mDirection == 1) {
                this.mCurrentX -= distance2;
            }
            this.mListener.onUpdate();
            if (Math.abs(this.mCurrentX) >= this.mScreenWidth) {
                this.mCount = 19;
                Canvas canvas = new Canvas(this.mScreenshot);
                this.mListener.onUpdateCanvasLayer(canvas);
                this.mCurrentX = -this.mCurrentX;
                sendEmptyMessageDelayed(1, 0L);
                return;
            }
            this.mCount++;
            sendEmptyMessageDelayed(2, 0L);
            return;
        }
        if (msg.what == 1) {
            if (this.mCount >= this.mDistanceTable.length) {
                distance = this.mScreenWidth * this.mDistanceTable[this.mDistanceTable.length - 1] * 0.01f;
            } else {
                distance = this.mScreenWidth * this.mDistanceTable[this.mCount] * 0.01f;
            }
            if (this.mDirection == 0) {
                this.mCurrentX += distance;
            } else if (this.mDirection == 1) {
                this.mCurrentX -= distance;
            }
            if (this.mCount == 0) {
                this.mCurrentX = VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET;
                endAnimation();
                this.mWorking = false;
                this.mScreenshot.recycle();
                this.mScreenshot = null;
                return;
            }
            this.mListener.onUpdate();
            this.mCount--;
            sendEmptyMessageDelayed(1, 0L);
        }
    }

    private void endAnimation() {
        this.mWorking = false;
        this.mListener.onFinish();
    }
}
