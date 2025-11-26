package com.samsung.android.sdk.pen.engine;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Build;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import com.samsung.android.sdk.pen.SpenSettingEraserInfo;
import com.samsung.android.sdk.pen.SpenSettingPenInfo;
import com.samsung.android.sdk.pen.SpenSettingRemoverInfo;
import com.samsung.android.sdk.pen.SpenSettingSelectionInfo;
import com.samsung.android.sdk.pen.SpenSettingTextInfo;
import com.samsung.android.sdk.pen.SpenSettingViewInterface;
import com.samsung.android.sdk.pen.document.SpenPageDoc;
import com.samsung.android.sdk.pen.engine.SpenPageEffectHandler;
import com.samsung.android.sdk.pen.engine.SpenSmartScaleGestureDetector;
import com.samsung.android.sdk.pen.settingui.SpenSettingPenLayout;
import com.samsung.android.sdk.pen.util.SpenError;
import com.vlingo.sdk.recognition.spotter.VLSpotterContext;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class SpenMultiView extends View implements SpenSettingViewInterface {
    public static final int PAGE_TRANSITION_EFFECT_LEFT = 0;
    public static final int PAGE_TRANSITION_EFFECT_RIGHT = 1;
    public static final int PAGE_TRANSITION_EFFECT_TYPE_SHADOW = 0;
    public static final int PAGE_TRANSITION_EFFECT_TYPE_SLIDE = 1;
    private static final String TAG = "SpenMultiView";
    private boolean isSkipTouch;
    private int localUserId;
    private Paint mAntiAliasPaint;
    private Paint mBlackPaint;
    private int mCanvasHeight;
    private int mCanvasWidth;
    private SpenColorPickerListener mColorPickerListener;
    private Context mContext;
    private Paint mDebugPaint;
    private float mDeltaX;
    private float mDeltaY;
    private SpenEraserChangeListener mEraserChangeListener;
    private Canvas mFBCanvas;
    private SpenFlickListener mFlickListener;
    private Bitmap mFrameBuffer;
    private int mFrameHeight;
    private int mFrameStartX;
    private int mFrameStartY;
    private int mFrameWidth;
    private GestureDetector mGestureDetector;
    private SpenHoverListener mHoverListener;
    private float mMaxDeltaX;
    private float mMaxDeltaY;
    private int mNativeMulti;
    private SpenPageDoc mPageDoc;
    private SpenPageEffectListener mPageEffectListener;
    private SpenPageEffectManager mPageEffectManager;
    private SpenPenChangeListener mPenChangeListener;
    private SpenTouchListener mPreTouchListener;
    private float mRatio;
    private int mRtoCvsItstFrmHeight;
    private int mRtoCvsItstFrmWidth;
    private SpenSmartScaleGestureDetector mSmartScaleGestureDetector;
    private long mThreadId;
    private SpenTouchListener mTouchListener;
    private long mTouchProcessingTime;
    private SpenZoomListener mZoomListener;

    private static native boolean native_addUser(int i, int i2);

    private static native ArrayList<Object> native_command(int i, int i2, ArrayList<Object> arrayList, int i3);

    private static native boolean native_construct(int i, Context context, SpenMultiView spenMultiView, RectF rectF);

    private static native void native_enablePenCurve(int i, int i2, boolean z);

    private static native void native_enableZoom(int i, boolean z);

    private static native void native_finalize(int i);

    private static native String native_getAdvancedSetting(int i, int i2);

    private static native float native_getEraserSize(int i, int i2);

    private static native int native_getLocalUserId(int i);

    private static native float native_getMaxZoomRatio(int i);

    private static native float native_getMinZoomRatio(int i);

    private static native void native_getPan(int i, PointF pointF);

    private static native int native_getPenColor(int i, int i2);

    private static native float native_getPenSize(int i, int i2);

    private static native String native_getPenStyle(int i, int i2);

    private static native int native_getToolTypeAction(int i, int i2, int i3);

    private static native float native_getZoomRatio(int i);

    private static native int native_init();

    private static native boolean native_isPenCurve(int i, int i2);

    private static native boolean native_isZoomable(int i);

    private static native boolean native_onHover(int i, int i2, MotionEvent motionEvent, int i3);

    private static native boolean native_onTouch(int i, int i2, MotionEvent motionEvent, int i3);

    private static native boolean native_removeUser(int i, int i2);

    private static native void native_setAdvancedSetting(int i, int i2, String str);

    private static native void native_setBitmap(int i, Bitmap bitmap);

    private static native boolean native_setEraserSize(int i, int i2, float f);

    private static native boolean native_setLocalUserId(int i, int i2);

    private static native boolean native_setMaxZoomRatio(int i, float f);

    private static native boolean native_setMinZoomRatio(int i, float f);

    private static native boolean native_setPageDoc(int i, SpenPageDoc spenPageDoc, boolean z);

    /* JADX INFO: Access modifiers changed from: private */
    public static native void native_setPan(int i, float f, float f2, boolean z);

    private static native void native_setPenColor(int i, int i2, int i3);

    private static native void native_setPenSize(int i, int i2, float f);

    private static native boolean native_setPenStyle(int i, int i2, String str);

    private static native void native_setScreenSize(int i, int i2, int i3);

    private static native boolean native_setToolTypeAction(int i, int i2, int i3, int i4);

    private static native void native_setZoom(int i, float f, float f2, float f3);

    private static native boolean native_update(int i);

    private static native boolean native_updateHistory(int i);

    public SpenMultiView(Context context) {
        super(context);
        this.mCanvasWidth = 0;
        this.mCanvasHeight = 0;
        this.mFrameWidth = 0;
        this.mFrameHeight = 0;
        this.mFrameBuffer = null;
        this.mFBCanvas = null;
        this.localUserId = 0;
        this.isSkipTouch = true;
        this.mTouchProcessingTime = 0L;
        this.mThreadId = 0L;
        this.mDeltaX = VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET;
        this.mDeltaY = VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET;
        this.mRatio = 1.0f;
        this.mMaxDeltaX = VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET;
        this.mMaxDeltaY = VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET;
        this.mBlackPaint = null;
        this.mDebugPaint = null;
        this.mAntiAliasPaint = null;
        this.mGestureDetector = null;
        this.mSmartScaleGestureDetector = null;
        this.mPageEffectManager = null;
        this.mFlickListener = null;
        this.mColorPickerListener = null;
        this.mEraserChangeListener = null;
        this.mHoverListener = null;
        this.mPenChangeListener = null;
        this.mTouchListener = null;
        this.mPreTouchListener = null;
        this.mZoomListener = null;
        this.mPageEffectListener = null;
        this.mContext = context;
        this.mNativeMulti = native_init();
        construct();
    }

    public SpenMultiView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mCanvasWidth = 0;
        this.mCanvasHeight = 0;
        this.mFrameWidth = 0;
        this.mFrameHeight = 0;
        this.mFrameBuffer = null;
        this.mFBCanvas = null;
        this.localUserId = 0;
        this.isSkipTouch = true;
        this.mTouchProcessingTime = 0L;
        this.mThreadId = 0L;
        this.mDeltaX = VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET;
        this.mDeltaY = VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET;
        this.mRatio = 1.0f;
        this.mMaxDeltaX = VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET;
        this.mMaxDeltaY = VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET;
        this.mBlackPaint = null;
        this.mDebugPaint = null;
        this.mAntiAliasPaint = null;
        this.mGestureDetector = null;
        this.mSmartScaleGestureDetector = null;
        this.mPageEffectManager = null;
        this.mFlickListener = null;
        this.mColorPickerListener = null;
        this.mEraserChangeListener = null;
        this.mHoverListener = null;
        this.mPenChangeListener = null;
        this.mTouchListener = null;
        this.mPreTouchListener = null;
        this.mZoomListener = null;
        this.mPageEffectListener = null;
        this.mContext = context;
        this.mNativeMulti = native_init();
        construct();
    }

    public SpenMultiView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.mCanvasWidth = 0;
        this.mCanvasHeight = 0;
        this.mFrameWidth = 0;
        this.mFrameHeight = 0;
        this.mFrameBuffer = null;
        this.mFBCanvas = null;
        this.localUserId = 0;
        this.isSkipTouch = true;
        this.mTouchProcessingTime = 0L;
        this.mThreadId = 0L;
        this.mDeltaX = VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET;
        this.mDeltaY = VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET;
        this.mRatio = 1.0f;
        this.mMaxDeltaX = VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET;
        this.mMaxDeltaY = VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET;
        this.mBlackPaint = null;
        this.mDebugPaint = null;
        this.mAntiAliasPaint = null;
        this.mGestureDetector = null;
        this.mSmartScaleGestureDetector = null;
        this.mPageEffectManager = null;
        this.mFlickListener = null;
        this.mColorPickerListener = null;
        this.mEraserChangeListener = null;
        this.mHoverListener = null;
        this.mPenChangeListener = null;
        this.mTouchListener = null;
        this.mPreTouchListener = null;
        this.mZoomListener = null;
        this.mPageEffectListener = null;
        this.mContext = context;
        this.mNativeMulti = native_init();
        construct();
    }

    private void construct() {
        OnGestureListener onGestureListener = null;
        byte b = 0;
        byte b2 = 0;
        byte b3 = 0;
        Log.e(TAG, "nativeMulti = " + this.mNativeMulti);
        if (this.mNativeMulti == 0) {
            SpenError.ThrowUncheckedException(8, " : nativeMulti must not be null");
            return;
        }
        if (this.mContext == null) {
            SpenError.ThrowUncheckedException(8, " : context must not be null");
            return;
        }
        if (!native_construct(this.mNativeMulti, this.mContext, this, new RectF())) {
            SpenError.ThrowUncheckedException(SpenError.getError());
        }
        this.mBlackPaint = new Paint();
        this.mBlackPaint.setStyle(Paint.Style.FILL);
        this.mBlackPaint.setColor(-15910321);
        this.mDebugPaint = new Paint();
        this.mDebugPaint.setStyle(Paint.Style.STROKE);
        this.mDebugPaint.setColor(-1);
        this.mAntiAliasPaint = new Paint();
        this.mAntiAliasPaint.setAntiAlias(true);
        this.mGestureDetector = new GestureDetector(this.mContext, new OnGestureListener(this, onGestureListener));
        this.mGestureDetector.setOnDoubleTapListener(new OnGestureDoubleTapListener(this, b3 == true ? 1 : 0));
        this.mSmartScaleGestureDetector = new SpenSmartScaleGestureDetector(this.mContext, this.mContext.getResources().getDisplayMetrics().densityDpi);
        this.mSmartScaleGestureDetector.setListener(new OnSmartScaleGestureDetectorListener(this, b2 == true ? 1 : 0));
        this.mPageEffectManager = new SpenPageEffectManager(new OnPageEffectListener(this, b == true ? 1 : 0));
        this.mPageEffectManager.setPaint(this.mBlackPaint);
        this.mThreadId = Thread.currentThread().getId();
    }

    public void close() {
        if (this.mNativeMulti != 0) {
            native_finalize(this.mNativeMulti);
            this.mNativeMulti = 0;
        }
        this.mContext = null;
        this.mPageDoc = null;
        if (this.mFrameBuffer != null) {
            this.mFrameBuffer.recycle();
            this.mFrameBuffer = null;
        }
        this.mFBCanvas = null;
        this.mBlackPaint = null;
        this.mDebugPaint = null;
        this.mAntiAliasPaint = null;
        this.mGestureDetector = null;
        if (this.mSmartScaleGestureDetector != null) {
            this.mSmartScaleGestureDetector.close();
            this.mSmartScaleGestureDetector = null;
        }
        if (this.mPageEffectManager != null) {
            this.mPageEffectManager.close();
            this.mPageEffectManager = null;
        }
        this.mFlickListener = null;
        this.mColorPickerListener = null;
        this.mEraserChangeListener = null;
        this.mHoverListener = null;
        this.mPenChangeListener = null;
        this.mTouchListener = null;
        this.mPreTouchListener = null;
        this.mZoomListener = null;
        this.mPageEffectListener = null;
    }

    private void createBitmap(SpenPageDoc pageDoc) {
        if (pageDoc != null && this.mNativeMulti != 0) {
            int width = this.mCanvasWidth;
            int height = this.mCanvasHeight;
            this.mCanvasWidth = pageDoc.getWidth();
            this.mCanvasHeight = pageDoc.getHeight();
            if (this.mCanvasWidth == 0) {
                SpenError.ThrowUncheckedException(6, "The width of pageDoc is 0");
                return;
            }
            if (this.mCanvasHeight == 0) {
                SpenError.ThrowUncheckedException(6, "The height of pageDoc is 0");
                return;
            }
            if (this.mCanvasWidth != width || this.mCanvasHeight != height) {
                Log.e(TAG, "createBitmap Width=" + this.mCanvasWidth + " Height=" + this.mCanvasHeight);
                try {
                    if (this.mFrameBuffer != null) {
                        this.mFrameBuffer.recycle();
                    }
                    this.mFrameBuffer = Bitmap.createBitmap(this.mCanvasWidth, this.mCanvasHeight, Bitmap.Config.ARGB_8888);
                    this.mFBCanvas = new Canvas(this.mFrameBuffer);
                    this.mFBCanvas.drawColor(-1);
                    native_setBitmap(this.mNativeMulti, this.mFrameBuffer);
                } catch (Exception e) {
                    SpenError.ThrowUncheckedException(2, "Failed to create bitmap of frame buffer");
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateCanvas2(Canvas canvas) {
        if (this.mPageDoc != null) {
            Rect srcRect = new Rect();
            absoluteCoordinate(srcRect, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, this.mRtoCvsItstFrmWidth, this.mRtoCvsItstFrmHeight);
            Rect dstRect = new Rect(0, 0, this.mRtoCvsItstFrmWidth, this.mRtoCvsItstFrmHeight);
            canvas.drawBitmap(this.mFrameBuffer, srcRect, dstRect, this.mAntiAliasPaint);
            return;
        }
        canvas.drawColor(this.mBlackPaint.getColor());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateCanvas(Canvas canvas, boolean framebufferUpdate) {
        long time = SystemClock.uptimeMillis();
        if (this.mPageDoc != null) {
            if (this.mFrameStartX > VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET) {
                canvas.drawRect(VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, this.mFrameStartX, this.mFrameHeight, this.mBlackPaint);
                canvas.drawRect(this.mFrameStartX + this.mRtoCvsItstFrmWidth, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, this.mFrameWidth, this.mFrameHeight, this.mBlackPaint);
            }
            if (this.mFrameStartY > VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET) {
                canvas.drawRect(VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, this.mFrameWidth, this.mFrameStartY, this.mBlackPaint);
                canvas.drawRect(VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, this.mFrameStartY + this.mRtoCvsItstFrmHeight, this.mFrameWidth, this.mFrameHeight, this.mBlackPaint);
            }
            if (framebufferUpdate) {
                this.mFrameBuffer.setPixel(0, 0, this.mFrameBuffer.getPixel(0, 0));
            }
            Rect srcRect = new Rect();
            absoluteCoordinate(srcRect, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, this.mRtoCvsItstFrmWidth, this.mRtoCvsItstFrmHeight);
            Rect dstRect = new Rect(0, 0, this.mRtoCvsItstFrmWidth, this.mRtoCvsItstFrmHeight);
            dstRect.offset(this.mFrameStartX, this.mFrameStartY);
            canvas.drawBitmap(this.mFrameBuffer, srcRect, dstRect, this.mAntiAliasPaint);
        } else {
            canvas.drawColor(this.mBlackPaint.getColor());
        }
        Log.i(TAG, "Performance updateCanvas end " + (SystemClock.uptimeMillis() - time) + " ms");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onUpdateCanvas(RectF abRect, boolean isScreenFramebuffer) {
        if (this.mThreadId == Thread.currentThread().getId()) {
            invalidate();
        } else {
            postInvalidate();
        }
    }

    private void getVariableForOnUpdateCanvas() {
        this.mMaxDeltaX = this.mCanvasWidth - (this.mFrameWidth / this.mRatio);
        if (this.mMaxDeltaX < VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET) {
            this.mMaxDeltaX = VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET;
        }
        this.mMaxDeltaY = this.mCanvasHeight - (this.mFrameHeight / this.mRatio);
        if (this.mMaxDeltaY < VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET) {
            this.mMaxDeltaY = VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET;
        }
        int mRatioCanvasWidth = (int) (this.mCanvasWidth * this.mRatio);
        int mRatioCanvasHeight = (int) (this.mCanvasHeight * this.mRatio);
        if (mRatioCanvasWidth >= this.mFrameWidth) {
            mRatioCanvasWidth = this.mFrameWidth;
        }
        this.mRtoCvsItstFrmWidth = mRatioCanvasWidth;
        if (mRatioCanvasHeight >= this.mFrameHeight) {
            mRatioCanvasHeight = this.mFrameHeight;
        }
        this.mRtoCvsItstFrmHeight = mRatioCanvasHeight;
        this.mFrameStartX = (int) ((this.mFrameWidth - this.mRtoCvsItstFrmWidth) / 2.0f);
        this.mFrameStartY = (int) ((this.mFrameHeight - this.mRtoCvsItstFrmHeight) / 2.0f);
    }

    private void onZoom(float centerX, float centerY, float ratio) {
        this.mDeltaX = centerX;
        this.mDeltaY = centerY;
        this.mRatio = ratio;
        getVariableForOnUpdateCanvas();
        this.mSmartScaleGestureDetector.onZoom(this.mDeltaX, this.mDeltaY, this.mRatio);
        this.mSmartScaleGestureDetector.setLimitHeight(this.mMaxDeltaX, this.mMaxDeltaY);
        this.mSmartScaleGestureDetector.setDrawInformation(this.mRtoCvsItstFrmWidth, this.mRtoCvsItstFrmHeight, this.mFrameStartX, this.mFrameStartY);
        if (this.mZoomListener != null) {
            this.mZoomListener.onZoom(centerX, centerY, ratio);
        }
    }

    private void onColorPickerChanged(int x, int y, int color) {
        Log.d(TAG, "onColorPickerChanged color" + color);
        if (this.mColorPickerListener != null) {
            this.mColorPickerListener.onChanged(color, x, y);
        }
    }

    private void printRect(String name, Rect srcRect) {
        Log.d(TAG, String.valueOf(name) + " (" + srcRect.left + ", " + srcRect.top + ") (" + srcRect.right + ", " + srcRect.bottom + ") w = " + srcRect.width() + " h = " + srcRect.height());
    }

    private void printRect(String name, RectF srcRect) {
        Log.d(TAG, String.valueOf(name) + " (" + srcRect.left + ", " + srcRect.top + ") (" + srcRect.right + ", " + srcRect.bottom + ") w = " + srcRect.width() + " h = " + srcRect.height());
    }

    private void absoluteCoordinate(RectF dstRectF, Rect srcRectF) {
        dstRectF.left = (srcRectF.left / this.mRatio) + this.mDeltaX;
        dstRectF.right = (srcRectF.right / this.mRatio) + this.mDeltaX;
        dstRectF.top = (srcRectF.top / this.mRatio) + this.mDeltaY;
        dstRectF.bottom = (srcRectF.bottom / this.mRatio) + this.mDeltaY;
    }

    private void absoluteCoordinate(Rect dstRect, float l, float t, float r, float b) {
        dstRect.left = (int) ((l / this.mRatio) + this.mDeltaX);
        dstRect.right = (int) ((r / this.mRatio) + this.mDeltaX);
        dstRect.top = (int) ((t / this.mRatio) + this.mDeltaY);
        dstRect.bottom = (int) ((b / this.mRatio) + this.mDeltaY);
    }

    private void relativeCoordinate(RectF dstRect, RectF srcRect) {
        dstRect.left = (srcRect.left - this.mDeltaX) * this.mRatio;
        dstRect.right = (srcRect.right - this.mDeltaX) * this.mRatio;
        dstRect.top = (srcRect.top - this.mDeltaY) * this.mRatio;
        dstRect.bottom = (srcRect.bottom - this.mDeltaY) * this.mRatio;
    }

    private void relativeCoordinate(RectF dstRect, Rect srcRect) {
        dstRect.left = (srcRect.left - this.mDeltaX) * this.mRatio;
        dstRect.right = (srcRect.right - this.mDeltaX) * this.mRatio;
        dstRect.top = (srcRect.top - this.mDeltaY) * this.mRatio;
        dstRect.bottom = (srcRect.bottom - this.mDeltaY) * this.mRatio;
    }

    @Override // android.view.View
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        if (this.mNativeMulti != 0) {
            this.mFrameWidth = w;
            this.mFrameHeight = h;
            this.mPageEffectManager.setScreenResolution(w, h);
            native_setScreenSize(this.mNativeMulti, w, h);
            super.onSizeChanged(w, h, oldw, oldh);
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.mNativeMulti != 0) {
            if (this.mPageEffectManager != null && this.mPageEffectManager.isWorking()) {
                this.mPageEffectManager.drawAnimation(canvas);
            } else {
                updateCanvas(canvas, true);
                if (this.mSmartScaleGestureDetector != null) {
                    this.mSmartScaleGestureDetector.draw(canvas);
                }
            }
            super.onDraw(canvas);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent event) {
        if (event == null || this.mNativeMulti == 0) {
            return true;
        }
        int count = event.getPointerCount();
        for (int a = 0; a < count; a++) {
            if (event.getSize(a) > 0.5f) {
                return true;
            }
        }
        int action = event.getAction() & 255;
        if (action == 0) {
            long diffTime = SystemClock.uptimeMillis() - event.getDownTime();
            this.isSkipTouch = diffTime > 100 + this.mTouchProcessingTime;
            if (this.isSkipTouch) {
                long eventTime = event.getEventTime();
                long downTime = event.getDownTime();
                long systemTime = SystemClock.uptimeMillis();
                Log.i(TAG, "skiptouch action = " + action + " eventTime = " + eventTime + " downTime = " + downTime + " systemTime = " + systemTime + " diffTime = " + diffTime);
            }
        }
        event.offsetLocation(-this.mFrameStartX, -this.mFrameStartY);
        this.mSmartScaleGestureDetector.onTouchEvent(event);
        this.mGestureDetector.onTouchEvent(event);
        if (!this.isSkipTouch) {
            long time = SystemClock.uptimeMillis();
            Log.i(TAG, "Performance mPreTouchListener start");
            if (this.mPreTouchListener != null && this.mPreTouchListener.onTouch(this, event)) {
                return true;
            }
            Log.i(TAG, "Performance mPreTouchListener.onTouch end " + (SystemClock.uptimeMillis() - time) + " ms");
            native_onTouch(this.mNativeMulti, this.localUserId, event, event.getToolType(0));
            Log.i(TAG, "Performance native_onTouch end " + (SystemClock.uptimeMillis() - time) + " ms");
            if (this.mTouchListener != null && this.mTouchListener.onTouch(this, event)) {
                return true;
            }
            this.mTouchProcessingTime = SystemClock.uptimeMillis() - time;
            Log.i(TAG, "Performance mTouchListener.onTouch end " + (SystemClock.uptimeMillis() - time) + " ms");
        }
        return true;
    }

    public boolean onTouchEvent(int userId, MotionEvent event) {
        if (event != null && this.mNativeMulti != 0) {
            native_onTouch(this.mNativeMulti, userId, event, event.getToolType(0));
        }
        return true;
    }

    @Override // android.view.View
    public boolean onHoverEvent(MotionEvent event) {
        if (event == null || this.mNativeMulti == 0) {
            return true;
        }
        int action = event.getAction();
        if (action == 9) {
            long diffTime = SystemClock.uptimeMillis() - event.getEventTime();
            this.isSkipTouch = diffTime > 100 + this.mTouchProcessingTime;
            if (this.isSkipTouch) {
                long eventTime = event.getEventTime();
                long downTime = event.getDownTime();
                long systemTime = SystemClock.uptimeMillis();
                Log.i(TAG, "skiptouch hover action = " + action + " eventTime = " + eventTime + " downTime = " + downTime + " systemTime = " + systemTime + " diffTime = " + diffTime);
            }
        }
        if (this.isSkipTouch) {
            Log.d(TAG, "skiptouch hover");
            return true;
        }
        if (this.mHoverListener == null || this.mHoverListener.onHover(this, event)) {
            return true;
        }
        return true;
    }

    @Override // com.samsung.android.sdk.pen.SpenSettingViewInterface
    public void setTextSettingInfo(SpenSettingTextInfo info) {
    }

    @Override // com.samsung.android.sdk.pen.SpenSettingViewInterface
    public SpenSettingTextInfo getTextSettingInfo() {
        return null;
    }

    @Override // com.samsung.android.sdk.pen.SpenSettingViewInterface
    public void setPenSettingInfo(SpenSettingPenInfo info) {
        if (this.mNativeMulti != 0 && info != null) {
            if (info.size < VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET) {
                info.size = 10.0f;
            }
            if (!native_setPenStyle(this.mNativeMulti, this.localUserId, info.name)) {
                SpenError.ThrowUncheckedException(1, "not set LocalUserId");
            }
            native_setPenColor(this.mNativeMulti, this.localUserId, info.color);
            native_setPenSize(this.mNativeMulti, this.localUserId, info.size);
            native_enablePenCurve(this.mNativeMulti, this.localUserId, info.isCurvable);
            native_setAdvancedSetting(this.mNativeMulti, this.localUserId, info.advancedSetting);
            if (this.mPenChangeListener != null) {
                this.mPenChangeListener.onChanged(info);
            }
        }
    }

    public void setPenSettingInfo(int userId, SpenSettingPenInfo info) {
        if (this.mNativeMulti != 0 && info != null) {
            if (info.size < VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET) {
                info.size = 10.0f;
            }
            native_setPenStyle(this.mNativeMulti, userId, info.name);
            native_setPenColor(this.mNativeMulti, userId, info.color);
            native_setPenSize(this.mNativeMulti, userId, info.size);
            native_enablePenCurve(this.mNativeMulti, userId, info.isCurvable);
            native_setAdvancedSetting(this.mNativeMulti, userId, info.advancedSetting);
        }
    }

    @Override // com.samsung.android.sdk.pen.SpenSettingViewInterface
    public SpenSettingPenInfo getPenSettingInfo() {
        if (this.mNativeMulti == 0) {
            return null;
        }
        SpenSettingPenInfo info = new SpenSettingPenInfo();
        if (info != null) {
            info.name = native_getPenStyle(this.mNativeMulti, this.localUserId);
            if (info.name == null) {
                SpenError.ThrowUncheckedException(1, "not set LocalUserId");
            }
            info.size = native_getPenSize(this.mNativeMulti, this.localUserId);
            info.color = native_getPenColor(this.mNativeMulti, this.localUserId);
            info.isCurvable = native_isPenCurve(this.mNativeMulti, this.localUserId);
            info.advancedSetting = native_getAdvancedSetting(this.mNativeMulti, this.localUserId);
            return info;
        }
        return info;
    }

    public SpenSettingPenInfo getPenSettingInfo(int userId) {
        if (this.mNativeMulti == 0) {
            return null;
        }
        SpenSettingPenInfo info = new SpenSettingPenInfo();
        if (info != null) {
            info.name = native_getPenStyle(this.mNativeMulti, userId);
            info.size = native_getPenSize(this.mNativeMulti, userId);
            info.color = native_getPenColor(this.mNativeMulti, userId);
            info.isCurvable = native_isPenCurve(this.mNativeMulti, userId);
            info.advancedSetting = native_getAdvancedSetting(this.mNativeMulti, userId);
            return info;
        }
        return info;
    }

    @Override // com.samsung.android.sdk.pen.SpenSettingViewInterface
    public void setEraserSettingInfo(SpenSettingEraserInfo info) {
        if (this.mNativeMulti != 0) {
            if (info != null) {
                if (info.size < 2.0f) {
                    info.size = 2.0f;
                }
                if (!native_setEraserSize(this.mNativeMulti, this.localUserId, info.size)) {
                    SpenError.ThrowUncheckedException(1, "not set LocalUserId");
                }
            }
            if (this.mEraserChangeListener != null) {
                this.mEraserChangeListener.onChanged(info);
            }
        }
    }

    public void setEraserSettingInfo(int userId, SpenSettingEraserInfo info) {
        if (this.mNativeMulti != 0 && info != null) {
            if (info.size < 2.0f) {
                info.size = 2.0f;
            }
            native_setEraserSize(this.mNativeMulti, userId, info.size);
        }
    }

    @Override // com.samsung.android.sdk.pen.SpenSettingViewInterface
    public SpenSettingEraserInfo getEraserSettingInfo() {
        if (this.mNativeMulti == 0) {
            return null;
        }
        SpenSettingEraserInfo info = new SpenSettingEraserInfo();
        if (info != null) {
            info.size = native_getEraserSize(this.mNativeMulti, this.localUserId);
            if (info.size == VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET) {
                SpenError.ThrowUncheckedException(1, "not set LocalUserId");
                return info;
            }
            return info;
        }
        return info;
    }

    public SpenSettingEraserInfo getEraserSettingInfo(int userId) {
        if (this.mNativeMulti == 0) {
            return null;
        }
        SpenSettingEraserInfo info = new SpenSettingEraserInfo();
        if (info != null) {
            info.size = native_getEraserSize(this.mNativeMulti, userId);
            return info;
        }
        return info;
    }

    @Override // com.samsung.android.sdk.pen.SpenSettingViewInterface
    public void setRemoverSettingInfo(SpenSettingRemoverInfo info) {
    }

    @Override // com.samsung.android.sdk.pen.SpenSettingViewInterface
    public SpenSettingRemoverInfo getRemoverSettingInfo() {
        return null;
    }

    @Override // com.samsung.android.sdk.pen.SpenSettingViewInterface
    public void setSelectionSettingInfo(SpenSettingSelectionInfo info) {
    }

    @Override // com.samsung.android.sdk.pen.SpenSettingViewInterface
    public SpenSettingSelectionInfo getSelectionSettingInfo() {
        return null;
    }

    @Override // com.samsung.android.sdk.pen.SpenSettingViewInterface
    public void setToolTypeAction(int toolType, int action) {
        if (this.mNativeMulti != 0) {
            this.mSmartScaleGestureDetector.setToolTypeAction(toolType, action);
            if (!native_setToolTypeAction(this.mNativeMulti, this.localUserId, toolType, action)) {
                SpenError.ThrowUncheckedException(1, "not set LocalUserId");
            }
        }
    }

    public void setToolTypeAction(int userId, int toolType, int action) {
        if (this.mNativeMulti != 0) {
            native_setToolTypeAction(this.mNativeMulti, userId, toolType, action);
        }
    }

    @Override // com.samsung.android.sdk.pen.SpenSettingViewInterface
    public int getToolTypeAction(int toolType) {
        if (this.mNativeMulti == 0) {
            return 0;
        }
        int action = native_getToolTypeAction(this.mNativeMulti, this.localUserId, toolType);
        if (action == -1) {
            SpenError.ThrowUncheckedException(1, "not set LocalUserId");
            return action;
        }
        return action;
    }

    public int getToolTypeAction(int userId, int toolType) {
        if (this.mNativeMulti == 0) {
            return 0;
        }
        return native_getToolTypeAction(this.mNativeMulti, userId, toolType);
    }

    @Override // com.samsung.android.sdk.pen.SpenSettingViewInterface
    public int getCanvasWidth() {
        if (this.mNativeMulti == 0 || this.mPageDoc == null) {
            return 0;
        }
        return this.mPageDoc.getWidth();
    }

    @Override // com.samsung.android.sdk.pen.SpenSettingViewInterface
    public int getCanvasHeight() {
        if (this.mNativeMulti == 0 || this.mPageDoc == null) {
            return 0;
        }
        return this.mPageDoc.getHeight();
    }

    @Override // com.samsung.android.sdk.pen.SpenSettingViewInterface
    public void setBackgroundColorChangeListener(Object object, SpenSettingViewInterface.SpenBackgroundColorChangeListener listener) {
        if (this.mNativeMulti != 0 && object != null && (object instanceof SpenSettingPenLayout)) {
            Log.d(TAG, "setBackgroundColorListener");
            listener.onChanged(false);
        }
    }

    public void setLocalUserId(int userId) {
        if (this.mNativeMulti != 0 && native_setLocalUserId(this.mNativeMulti, userId)) {
            this.localUserId = userId;
        }
    }

    public int getLocalUserId() {
        if (this.mNativeMulti == 0) {
            return -1;
        }
        this.localUserId = native_getLocalUserId(this.mNativeMulti);
        return this.localUserId;
    }

    public boolean addUser(int userId) {
        if (this.mNativeMulti == 0) {
            return false;
        }
        return native_addUser(this.mNativeMulti, userId);
    }

    public boolean removeUser(int userId) {
        if (this.mNativeMulti == 0) {
            return false;
        }
        return native_removeUser(this.mNativeMulti, userId);
    }

    public void setZoom(float centerX, float centerY, float ratio) {
        if (this.mNativeMulti != 0) {
            native_setZoom(this.mNativeMulti, centerX, centerY, ratio);
        }
    }

    public float getZoomRatio() {
        return this.mNativeMulti == 0 ? VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET : native_getZoomRatio(this.mNativeMulti);
    }

    public boolean setMaxZoomRatio(float ratio) {
        if (this.mNativeMulti == 0) {
            return false;
        }
        return native_setMaxZoomRatio(this.mNativeMulti, ratio);
    }

    public float getMaxZoomRatio() {
        return this.mNativeMulti == 0 ? VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET : native_getMaxZoomRatio(this.mNativeMulti);
    }

    public boolean setMinZoomRatio(float ratio) {
        if (this.mNativeMulti == 0) {
            return false;
        }
        return native_setMinZoomRatio(this.mNativeMulti, ratio);
    }

    public float getMinZoomRatio() {
        return this.mNativeMulti == 0 ? VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET : native_getMinZoomRatio(this.mNativeMulti);
    }

    public void setPan(PointF position) {
        if (this.mNativeMulti != 0) {
            native_setPan(this.mNativeMulti, position.x, position.y, true);
        }
    }

    public PointF getPan() {
        if (this.mNativeMulti == 0) {
            return null;
        }
        PointF point = new PointF();
        native_getPan(this.mNativeMulti, point);
        return point;
    }

    public void setBlankColor(int color) {
        if (this.mNativeMulti != 0 && color != this.mBlackPaint.getColor()) {
            this.mBlackPaint.setColor(color);
            this.mPageEffectManager.setPaint(this.mBlackPaint);
            onUpdateCanvas(null, false);
        }
    }

    public int getBlankColor() {
        if (this.mNativeMulti == 0) {
            return 0;
        }
        return this.mBlackPaint.getColor();
    }

    public boolean setPageDoc(SpenPageDoc pageDoc, boolean isUpdate) {
        if (this.mNativeMulti == 0) {
            return false;
        }
        if (pageDoc != null && !pageDoc.isValid()) {
            Log.d(TAG, "setPageDoc is closed");
            return false;
        }
        createBitmap(pageDoc);
        this.mPageDoc = pageDoc;
        if (!native_setPageDoc(this.mNativeMulti, pageDoc, isUpdate)) {
            this.mPageDoc = null;
        }
        return true;
    }

    public boolean setPageDoc(SpenPageDoc pageDoc, int direction, int type, float centerY) {
        if (this.mNativeMulti == 0) {
            return false;
        }
        if (pageDoc != null && !pageDoc.isValid()) {
            Log.d(TAG, "setPageDoc is closed");
            return false;
        }
        if (this.mPageEffectManager.isWorking()) {
            return false;
        }
        Log.d(TAG, "setPageDoc, direction=" + direction);
        this.mPageEffectManager.setType(type);
        this.mPageEffectManager.saveScreenshot();
        createBitmap(pageDoc);
        this.mPageDoc = pageDoc;
        native_setPan(this.mNativeMulti, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, centerY, false);
        native_setPageDoc(this.mNativeMulti, this.mPageDoc, false);
        this.mPageEffectManager.startAnimation(direction);
        return true;
    }

    public void update() {
        if (this.mNativeMulti != 0 && !native_update(this.mNativeMulti)) {
            SpenError.ThrowUncheckedException(SpenError.getError(), "We can't update this state, we can update just for append object");
        }
    }

    public void updateUndo(SpenPageDoc.HistoryUpdateInfo[] userDataList, int userId) {
        if (this.mNativeMulti != 0 && !native_updateHistory(this.mNativeMulti)) {
            SpenError.ThrowUncheckedException(SpenError.getError(), "We can't undo");
        }
    }

    public void updateRedo(SpenPageDoc.HistoryUpdateInfo[] userDataList, int userId) {
        if (this.mNativeMulti != 0 && !native_updateHistory(this.mNativeMulti)) {
            SpenError.ThrowUncheckedException(SpenError.getError(), "We can't redo");
        }
    }

    public void setPreTouchListener(SpenTouchListener listener) {
        if (this.mNativeMulti != 0) {
            this.mPreTouchListener = listener;
        }
    }

    public void setTouchListener(SpenTouchListener listener) {
        if (this.mNativeMulti != 0) {
            this.mTouchListener = listener;
        }
    }

    public void setFlickListener(SpenFlickListener listener) {
        if (this.mNativeMulti != 0) {
            this.mFlickListener = listener;
        }
    }

    public void setHoverListener(SpenHoverListener listener) {
        if (this.mNativeMulti != 0) {
            String releaseNumber = Build.VERSION.RELEASE;
            if (releaseNumber.startsWith("4.")) {
                this.mHoverListener = listener;
            } else {
                SpenError.ThrowUncheckedException(12, "S Pen Hover Listener cannot be supported under android ICS");
            }
        }
    }

    public void setColorPickerListener(SpenColorPickerListener listener) {
        if (this.mNativeMulti != 0) {
            this.mColorPickerListener = listener;
        }
    }

    public void setZoomListener(SpenZoomListener listener) {
        if (this.mNativeMulti != 0) {
            this.mZoomListener = listener;
        }
    }

    public void setPageEffectListener(SpenPageEffectListener listener) {
        if (this.mNativeMulti != 0) {
            this.mPageEffectListener = listener;
        }
    }

    public void setPenChangeListener(SpenPenChangeListener listener) {
        if (this.mNativeMulti != 0) {
            this.mPenChangeListener = listener;
        }
    }

    public void setEraserChangeListener(SpenEraserChangeListener listener) {
        if (this.mNativeMulti != 0) {
            this.mEraserChangeListener = listener;
        }
    }

    public Bitmap captureCurrentView(boolean includeBlank) {
        if (this.mNativeMulti == 0) {
            return null;
        }
        Bitmap bitmap = null;
        try {
            if (!includeBlank) {
                bitmap = Bitmap.createBitmap(this.mRtoCvsItstFrmWidth, this.mRtoCvsItstFrmHeight, Bitmap.Config.ARGB_8888);
            } else {
                bitmap = Bitmap.createBitmap(this.mFrameWidth, this.mFrameHeight, Bitmap.Config.ARGB_8888);
            }
        } catch (Throwable th) {
            Log.e(TAG, "Failed to create bitmap");
            SpenError.ThrowUncheckedException(2, " : fail createBitmap.");
        }
        Canvas canvas = new Canvas(bitmap);
        if (!includeBlank) {
            canvas.translate(-this.mFrameStartX, -this.mFrameStartY);
        }
        updateCanvas(canvas, false);
        return bitmap;
    }

    public Bitmap capturePage(float ratio) {
        if (this.mFrameBuffer == null) {
            return null;
        }
        return Bitmap.createScaledBitmap(this.mFrameBuffer, (int) (this.mCanvasWidth * ratio), (int) (this.mCanvasHeight * ratio), true);
    }

    private class OnPageEffectListener implements SpenPageEffectHandler.Listener {
        private OnPageEffectListener() {
        }

        /* synthetic */ OnPageEffectListener(SpenMultiView spenMultiView, OnPageEffectListener onPageEffectListener) {
            this();
        }

        @Override // com.samsung.android.sdk.pen.engine.SpenPageEffectHandler.Listener
        public void onUpdateCanvasLayer(Canvas canvas) {
            SpenMultiView.this.updateCanvas(canvas, false);
        }

        @Override // com.samsung.android.sdk.pen.engine.SpenPageEffectHandler.Listener
        public void onUpdateCanvasLayer2(Canvas canvas) {
            SpenMultiView.this.updateCanvas2(canvas);
        }

        @Override // com.samsung.android.sdk.pen.engine.SpenPageEffectHandler.Listener
        public void onUpdate() {
            SpenMultiView.this.invalidate();
        }

        @Override // com.samsung.android.sdk.pen.engine.SpenPageEffectHandler.Listener
        public void onFinish() {
            SpenMultiView.this.invalidate();
            if (SpenMultiView.this.mPageEffectListener != null) {
                SpenMultiView.this.mPageEffectListener.onFinish();
            }
        }
    }

    private class OnSmartScaleGestureDetectorListener implements SpenSmartScaleGestureDetector.Listener {
        private OnSmartScaleGestureDetectorListener() {
        }

        /* synthetic */ OnSmartScaleGestureDetectorListener(SpenMultiView spenMultiView, OnSmartScaleGestureDetectorListener onSmartScaleGestureDetectorListener) {
            this();
        }

        @Override // com.samsung.android.sdk.pen.engine.SpenSmartScaleGestureDetector.Listener
        public void onChangeScale(float centerX, float centerY, float ratio) {
        }

        @Override // com.samsung.android.sdk.pen.engine.SpenSmartScaleGestureDetector.Listener
        public void onChangePan(float x, float y) {
            SpenMultiView.native_setPan(SpenMultiView.this.mNativeMulti, x, y, true);
        }

        @Override // com.samsung.android.sdk.pen.engine.SpenSmartScaleGestureDetector.Listener
        public boolean onFlick(int direction) {
            Log.d(SpenMultiView.TAG, "onFlick direction = " + direction);
            if (!SpenMultiView.this.mPageEffectManager.isWorking()) {
                if (SpenMultiView.this.mFlickListener != null) {
                    return SpenMultiView.this.mFlickListener.onFlick(direction);
                }
                return false;
            }
            return true;
        }

        @Override // com.samsung.android.sdk.pen.engine.SpenSmartScaleGestureDetector.Listener
        public void onUpdate() {
            SpenMultiView.this.onUpdateCanvas(null, true);
        }

        @Override // com.samsung.android.sdk.pen.engine.SpenSmartScaleGestureDetector.Listener
        public void onUpdateScreenFrameBuffer() {
        }
    }

    private class OnGestureListener implements GestureDetector.OnGestureListener {
        private OnGestureListener() {
        }

        /* synthetic */ OnGestureListener(SpenMultiView spenMultiView, OnGestureListener onGestureListener) {
            this();
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent e) {
            return false;
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public void onShowPress(MotionEvent e) {
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public boolean onSingleTapUp(MotionEvent e) {
            return false;
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
            return false;
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public void onLongPress(MotionEvent e) {
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
            if (e1 == null || SpenMultiView.this.getToolTypeAction(e1.getToolType(0)) != 1) {
                return false;
            }
            SpenMultiView.this.mSmartScaleGestureDetector.onFling(e1, e2, velocityX, velocityY);
            return true;
        }
    }

    private class OnGestureDoubleTapListener implements GestureDetector.OnDoubleTapListener {
        private OnGestureDoubleTapListener() {
        }

        /* synthetic */ OnGestureDoubleTapListener(SpenMultiView spenMultiView, OnGestureDoubleTapListener onGestureDoubleTapListener) {
            this();
        }

        @Override // android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent e) {
            SpenMultiView.this.setZoom(SpenMultiView.this.mDeltaX, SpenMultiView.this.mDeltaY, SpenMultiView.this.mFrameWidth / SpenMultiView.this.mCanvasWidth);
            return false;
        }

        @Override // android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTapEvent(MotionEvent e) {
            return false;
        }

        @Override // android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(MotionEvent e) {
            return false;
        }
    }

    @Override // com.samsung.android.sdk.pen.SpenSettingViewInterface
    public void closeControl() {
    }
}
