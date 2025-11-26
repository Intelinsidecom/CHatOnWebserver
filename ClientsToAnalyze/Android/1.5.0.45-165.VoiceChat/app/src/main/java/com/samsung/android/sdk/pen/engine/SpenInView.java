package com.samsung.android.sdk.pen.engine;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.util.Log;
import android.view.ContextMenu;
import android.view.GestureDetector;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import com.C2Ddrawbitmap.c2ddrawbitmapJNI;
import com.samsung.android.sdk.pen.Spen;
import com.samsung.android.sdk.pen.SpenSettingEraserInfo;
import com.samsung.android.sdk.pen.SpenSettingPenInfo;
import com.samsung.android.sdk.pen.SpenSettingRemoverInfo;
import com.samsung.android.sdk.pen.SpenSettingSelectionInfo;
import com.samsung.android.sdk.pen.SpenSettingTextInfo;
import com.samsung.android.sdk.pen.SpenSettingViewInterface;
import com.samsung.android.sdk.pen.document.SpenObjectBase;
import com.samsung.android.sdk.pen.document.SpenObjectContainer;
import com.samsung.android.sdk.pen.document.SpenObjectImage;
import com.samsung.android.sdk.pen.document.SpenObjectStroke;
import com.samsung.android.sdk.pen.document.SpenObjectTextBox;
import com.samsung.android.sdk.pen.document.SpenPageDoc;
import com.samsung.android.sdk.pen.engine.SpenCanvasViewScroll;
import com.samsung.android.sdk.pen.engine.SpenControlBase;
import com.samsung.android.sdk.pen.engine.SpenControlTextBox;
import com.samsung.android.sdk.pen.engine.SpenPageEffectHandler;
import com.samsung.android.sdk.pen.engine.SpenSmartScaleGestureDetector;
import com.samsung.android.sdk.pen.engine.SpenZoomPad;
import com.samsung.android.sdk.pen.settingui.SpenSettingPenLayout;
import com.samsung.android.sdk.pen.util.SpenError;
import com.samsung.android.sdk.pen.util.SpenFont;
import com.vlingo.sdk.internal.vlservice.config.VLConfigParser;
import com.vlingo.sdk.recognition.spotter.VLSpotterContext;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
class SpenInView implements SpenSettingViewInterface {
    private static final boolean DBG = false;
    public static final int PAGE_TRANSITION_EFFECT_LEFT = 0;
    public static final int PAGE_TRANSITION_EFFECT_RIGHT = 1;
    public static final int PAGE_TRANSITION_EFFECT_TYPE_SHADOW = 0;
    public static final int PAGE_TRANSITION_EFFECT_TYPE_SLIDE = 1;
    public static final int REPLAY_STATE_PAUSED = 2;
    public static final int REPLAY_STATE_PLAYING = 1;
    public static final int REPLAY_STATE_STOPPED = 0;
    private static final String STROKE_FRAME_KEY = "STROKE_FRAME";
    private static final int STROKE_FRAME_RETAKE = 2;
    private static final int STROKE_FRAME_TAKE = 1;
    private static final String TAG = "SpenInView";
    private Context mContext;
    private SpenControlBase mControl;
    private SpenStrokeFrame mStrokeFrame;
    private UpdateCanvasListener mUpdateCanvasListener;
    private boolean mUseC2D;
    private SpenZoomPad mZoomPad;
    private ContextMenu mContextMenu = null;
    private int mLayoutWidth = 0;
    private int mLayoutHeight = 0;
    private int mLayoutExceptSIP = 0;
    private int mBitmapWidth = 0;
    private int mBitmapHeight = 0;
    private int mScreenWidth = 0;
    private int mScreenHeight = 0;
    private int mScreenHeightExceptSIP = 0;
    private int mScreenStartX = 0;
    private int mScreenStartY = 0;
    private int mRatioBitmapWidth = 0;
    private int mRatioBitmapHeight = 0;
    private int mRtoBmpItstScrWidth = 0;
    private int mRtoBmpItstScrHeight = 0;
    private int mFramebufferWidth = 0;
    private int mFramebufferHeight = 0;
    private Rect mSrcDrawRect = new Rect();
    private Rect mDstDrawRect = new Rect();
    private Resources mSdkResources = null;
    private SpenPageDoc mPageDoc = null;
    private Bitmap mFloatingLayer = null;
    private ArrayList<Bitmap> mCanvasLayer = null;
    private Bitmap mScreenFB = null;
    private boolean mMagicPenEnabled = true;
    private SpenControlListener mControlListener = null;
    private SpenSettingViewInterface.SpenBackgroundColorChangeListener mBackgroundColorChangeListener = null;
    private SpenEraserChangeListener mEraserChangeListener = null;
    private SpenRemoverChangeListener mRemoverChangeListener = null;
    private SpenColorPickerListener mColorPickerListener = null;
    private SpenDrawListener mPreDrawListener = null;
    private SpenDrawListener mPostDrawListener = null;
    private SpenFlickListener mFlickListener = null;
    private SpenHoverListener mHoverListener = null;
    private SpenPageEffectListener mPageEffectListener = null;
    private SpenHyperTextListener mHyperTextListener = null;
    private SpenLongPressListener mLongPressListener = null;
    private SpenPenChangeListener mPenChangeListener = null;
    private SpenReplayListener mReplayListener = null;
    private SpenPenDetachmentListener mPenDetachmentListener = null;
    private SpenTextChangeListener mTextChangeListener = null;
    private SpenSelectionChangeListener mSelectionChangeListener = null;
    private SpenStrokeFrameListener mThisStrokeFrameListener = null;
    private SpenStrokeFrameListener mUpdateStrokeFrameListener = null;
    private SpenTouchListener mTouchListener = null;
    private SpenTouchListener mPreTouchListener = null;
    private SpenZoomListener mZoomListener = null;
    private SpenZoomPadListener mZoomPadListener = null;
    private SpenSettingPenInfo mPenSettingInfo = null;
    private SpenSettingEraserInfo mEraserSettingInfo = null;
    private SpenSettingRemoverInfo mRemoverSettingInfo = null;
    private SpenSettingSelectionInfo mSelectionSettingInfo = null;
    private SpenSettingTextInfo mTextSettingInfo = null;
    private ArrayList<SpenHighlightInfo> mHighlightInfoList = null;
    private DetachReceiver mDetachReceiver = null;
    private GestureDetector mGestureDetector = null;
    private SpenSmartScaleGestureDetector mSmartScaleGestureDetector = null;
    private SpenCanvasViewScroll mScroll = null;
    private SpenPageEffectManager mPageEffectManager = null;
    private SPenHoverPointerIconWrapper mHoverPointer = null;
    private Drawable mHoverDrawable = null;
    private boolean mHoverEnable = false;
    private SpenToolTip mToolTip = null;
    private boolean mIsToolTip = false;
    private boolean isSkipTouch = true;
    private long mTouchProcessingTime = 0;
    private float mDeltaX = VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET;
    private float mDeltaY = VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET;
    private float mRatio = 1.0f;
    private float mMaxDeltaX = VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET;
    private float mMaxDeltaY = VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET;
    private Paint mBlackPaint = null;
    private Paint mHighlightPaint = null;
    private Paint mDebugPaint = null;
    private Paint mSrcPaint = null;
    private Paint mAntiAliasPaint = null;
    private Paint mTextPaint = null;
    private Paint mCirclePaint = null;
    private PointF mCirclePoint = new PointF(-100.0f, -100.0f);
    private float mCircleRadius = VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET;
    private float mRemoverRadius = VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET;
    private boolean mDottedLineEnable = false;
    private Paint mDottedLinePaint = null;
    private int mDottedLineIntervalHeight = 0;
    private float mDottedLineHalfWidth = VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET;
    private boolean mZoomable = true;
    private boolean mIsSmartScale = false;
    private boolean mIsSmartHorizontal = false;
    private boolean mIsSmartVertical = false;
    private boolean mIsHyperText = false;
    private boolean mIsControlSelect = false;
    private boolean mTransactionClosingControl = false;
    private boolean mPreZoomable = false;
    private boolean mPreScrollable = false;
    private View mView = null;
    private ViewGroup mParentView = null;
    private int mStrokeFrameType = 1;
    private Toast mRemoverToastMessage = null;
    private float removerTouchX = VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET;
    private float removerTouchY = VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET;
    private boolean isEraserCursor = false;
    public View.OnHoverListener mHoverPointerlistener = new View.OnHoverListener() { // from class: com.samsung.android.sdk.pen.engine.SpenInView.1
        public int mHoverIconID = -1;

        @Override // android.view.View.OnHoverListener
        public boolean onHover(View view, MotionEvent event) {
            if (SpenInView.this.mZoomPad != null && !SpenInView.this.mZoomPad.isZoomPadEnabled()) {
                if (event.getAction() == 9) {
                    if (SpenInView.this.mHoverDrawable != null) {
                        this.mHoverIconID = SpenInView.this.setCustomHoveringIcon(SpenInView.this.mHoverDrawable);
                    }
                    if (SpenInView.this.mControl != null && SpenInView.this.mPageDoc.isObjectContained(SpenInView.this.mControl.getObjectList().get(0))) {
                        SpenInView.this.mControl.onCanvasHoverEnter();
                    }
                } else if (event.getAction() == 10) {
                    SpenInView.this.removeHoveringIcon(this.mHoverIconID);
                }
            }
            return view.onHoverEvent(event);
        }
    };
    private Handler mTouchUpHandler = new TouchUpHandler(this);
    private Handler mSetPageDocHandler = new SetPageDocHandler(this);
    private int nativeCanvas = native_init();

    public interface UpdateCanvasListener {
        void onUpdateCanvas(RectF rectF, boolean z);
    }

    private static native void native_cancelStroke(int i);

    private static native ArrayList<Object> native_command(int i, int i2, ArrayList<Object> arrayList, int i3);

    private static native boolean native_construct(int i, Context context, SpenInView spenInView, RectF rectF);

    private static native boolean native_drawObjectList(int i, Bitmap bitmap, ArrayList<SpenObjectBase> arrayList, int i2);

    private static native void native_enablePenCurve(int i, boolean z);

    private static native void native_enableZoom(int i, boolean z);

    private static native void native_finalize(int i);

    private static native String native_getAdvancedSetting(int i);

    private static native float native_getEraserSize(int i);

    private static native float native_getMaxZoomRatio(int i);

    private static native float native_getMinZoomRatio(int i);

    /* JADX INFO: Access modifiers changed from: private */
    public static native void native_getPan(int i, PointF pointF);

    private static native int native_getPenColor(int i);

    private static native float native_getPenSize(int i);

    private static native String native_getPenStyle(int i);

    private static native int native_getReplayState(int i);

    private static native void native_getTemporaryStroke(int i, ArrayList<SpenObjectStroke> arrayList);

    private static native int native_getToolTypeAction(int i, int i2);

    private static native float native_getZoomRatio(int i);

    /* JADX INFO: Access modifiers changed from: private */
    public static native void native_inVisibleUpdate(int i, int i2, boolean z, boolean z2);

    private static native int native_init();

    private static native boolean native_isPenCurve(int i);

    private static native boolean native_isZoomable(int i);

    private static native boolean native_onHover(int i, MotionEvent motionEvent, int i2);

    /* JADX INFO: Access modifiers changed from: private */
    public static native boolean native_onLongPress(int i, MotionEvent motionEvent, int i2);

    /* JADX INFO: Access modifiers changed from: private */
    public static native boolean native_onSingleTapUp(int i, MotionEvent motionEvent, int i2);

    /* JADX INFO: Access modifiers changed from: private */
    public static native boolean native_onTouch(int i, MotionEvent motionEvent, int i2);

    private static native boolean native_pauseReplay(int i);

    private static native void native_removeCanvasBitmap(int i);

    private static native boolean native_resumeReplay(int i);

    private static native void native_setAdvancedSetting(int i, String str);

    private static native void native_setBitmap(int i, Bitmap bitmap);

    private static native void native_setCanvasBitmap(int i, int i2, Bitmap bitmap);

    private static native void native_setEraserSize(int i, float f);

    private static native void native_setEraserType(int i, int i2);

    private static native void native_setHyperTextViewEnabled(int i, boolean z);

    private static native boolean native_setMaxZoomRatio(int i, float f);

    private static native boolean native_setMinZoomRatio(int i, float f);

    private static native boolean native_setPageDoc(int i, SpenPageDoc spenPageDoc, boolean z);

    /* JADX INFO: Access modifiers changed from: private */
    public static native void native_setPan(int i, float f, float f2, boolean z);

    private static native void native_setPenColor(int i, int i2);

    private static native void native_setPenSize(int i, float f);

    private static native boolean native_setPenStyle(int i, String str);

    private static native void native_setRemoverSize(int i, float f);

    private static native void native_setRemoverType(int i, int i2);

    private static native boolean native_setReplayPosition(int i, int i2);

    private static native boolean native_setReplaySpeed(int i, int i2);

    private static native void native_setScreenFrameBuffer(int i, Bitmap bitmap);

    /* JADX INFO: Access modifiers changed from: private */
    public static native void native_setScreenSize(int i, int i2, int i3, int i4);

    private static native void native_setSelectionType(int i, int i2);

    private static native void native_setToolTypeAction(int i, int i2, int i3);

    private static native void native_setZoom(int i, float f, float f2, float f3);

    private static native boolean native_startReplay(int i);

    private static native void native_startTemporaryStroke(int i);

    private static native boolean native_stopReplay(int i);

    private static native void native_stopTemporaryStroke(int i);

    private static native void native_update(int i);

    private static native void native_updateAllScreenFrameBuffer(int i);

    private static native boolean native_updateRedo(int i, SpenPageDoc.HistoryUpdateInfo[] historyUpdateInfoArr, int i2);

    private static native boolean native_updateUndo(int i, SpenPageDoc.HistoryUpdateInfo[] historyUpdateInfoArr, int i2);

    public SpenInView(Context context, UpdateCanvasListener updateCanvasListener, boolean isUseC2D) {
        this.mContext = null;
        this.mUpdateCanvasListener = null;
        this.mUseC2D = false;
        this.mContext = context;
        this.mUpdateCanvasListener = updateCanvasListener;
        construct();
        File libFilePath = new File("/system/vendor/lib/libC2D2.so");
        if (!libFilePath.exists()) {
            this.mUseC2D = false;
            return;
        }
        if (isUseC2D) {
            try {
                c2ddrawbitmapJNI.native_init_c2dJNI();
                this.mUseC2D = true;
                Log.d("c2d", "c2d blit init");
            } catch (NoClassDefFoundError e) {
                this.mUseC2D = false;
                Log.d("c2d", "c2d blit init fail, lib loading error");
            } catch (UnsatisfiedLinkError e2) {
                this.mUseC2D = false;
                Log.d("c2d", "c2d blit init fail, lib loading error");
            }
        }
    }

    private void construct() {
        OnGestureListener onGestureListener = null;
        byte b = 0;
        byte b2 = 0;
        byte b3 = 0;
        byte b4 = 0;
        byte b5 = 0;
        Log.d(TAG, "nativeCanvas = " + this.nativeCanvas);
        if (this.nativeCanvas == 0) {
            SpenError.ThrowUncheckedException(8, " : nativeCanvas must not be null");
            return;
        }
        if (this.mContext == null) {
            SpenError.ThrowUncheckedException(8, " : context must not be null");
            return;
        }
        try {
            this.mSdkResources = this.mContext.getPackageManager().getResourcesForApplication(Spen.SPEN_NATIVE_PACKAGE_NAME);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        if (!native_construct(this.nativeCanvas, this.mContext, this, new RectF())) {
            SpenError.ThrowUncheckedException(SpenError.getError());
        }
        this.mGestureDetector = new GestureDetector(this.mContext, new OnGestureListener(this, onGestureListener));
        this.mGestureDetector.setOnDoubleTapListener(new OnGestureDoubleTapListener(this, b5 == true ? 1 : 0));
        this.mSmartScaleGestureDetector = new SpenSmartScaleGestureDetector(this.mContext, this.mContext.getResources().getDisplayMetrics().densityDpi);
        this.mSmartScaleGestureDetector.setListener(new OnSmartScaleGestureDetectorListener(this, b4 == true ? 1 : 0));
        this.mScroll = new SpenCanvasViewScroll(new OnScrollListener(this, b3 == true ? 1 : 0));
        this.mHoverPointer = new SPenHoverPointerIconWrapper();
        this.mBlackPaint = new Paint();
        this.mBlackPaint.setStyle(Paint.Style.FILL);
        this.mBlackPaint.setColor(-15910321);
        this.mHighlightPaint = new Paint();
        this.mHighlightPaint.setStyle(Paint.Style.STROKE);
        this.mHighlightPaint.setAntiAlias(true);
        this.mDebugPaint = new Paint();
        this.mDebugPaint.setStyle(Paint.Style.STROKE);
        this.mDebugPaint.setAntiAlias(true);
        this.mDebugPaint.setStrokeWidth(1.5f);
        this.mDebugPaint.setColor(-15910321);
        this.mSrcPaint = new Paint();
        this.mSrcPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC));
        this.mSrcPaint.setAntiAlias(true);
        this.mAntiAliasPaint = new Paint();
        this.mAntiAliasPaint.setAntiAlias(true);
        this.mTextPaint = new Paint();
        this.mTextPaint.setAntiAlias(true);
        this.mCirclePaint = new Paint();
        this.mCirclePaint.setAntiAlias(true);
        this.mCirclePaint.setStyle(Paint.Style.STROKE);
        this.mCirclePaint.setColor(-16777216);
        this.mPageEffectManager = new SpenPageEffectManager(new OnPageEffectListener(this, b2 == true ? 1 : 0));
        this.mPageEffectManager.setPaint(this.mBlackPaint);
        this.mCanvasLayer = new ArrayList<>();
        this.mToolTip = new SpenToolTip(this.mContext);
        this.mEraserSettingInfo = new SpenSettingEraserInfo();
        native_setEraserSize(this.nativeCanvas, this.mEraserSettingInfo.size);
        this.mRemoverSettingInfo = new SpenSettingRemoverInfo();
        native_setRemoverSize(this.nativeCanvas, this.mRemoverSettingInfo.size);
        this.mZoomPad = new SpenZoomPad(this.mContext);
        this.mZoomPad.setActionListener(new OnZoomPadActionListener(this, b == true ? 1 : 0));
        this.mRemoverToastMessage = new Toast(this.mContext);
        this.mThisStrokeFrameListener = new SpenStrokeFrameListener() { // from class: com.samsung.android.sdk.pen.engine.SpenInView.2
            @Override // com.samsung.android.sdk.pen.engine.SpenStrokeFrameListener
            public void onCompleted(int frameType, SpenObjectContainer o) {
                SpenInView.this.mStrokeFrame = null;
                o.setVisibility(true);
                o.setExtraDataInt("STROKE_FRAME", 2);
                if (frameType == 0) {
                    o.getObject(0).setVisibility(true);
                    o.getObject(1).setVisibility(false);
                    SpenInView.this.mStrokeFrameType = frameType;
                } else if (frameType == 1) {
                    o.getObject(1).setVisibility(true);
                    o.getObject(0).setVisibility(false);
                    SpenInView.this.mStrokeFrameType = frameType;
                }
                SpenInView.this.mPageDoc.clearHistoryTag();
                SpenInView.this.update();
                if (SpenInView.this.mUpdateStrokeFrameListener != null) {
                    SpenInView.this.mUpdateStrokeFrameListener.onCompleted(frameType, o);
                }
            }

            @Override // com.samsung.android.sdk.pen.engine.SpenStrokeFrameListener
            public void onCanceled(int state, SpenObjectContainer o) {
                SpenInView.this.mStrokeFrame = null;
                if ((state & 1) > 0) {
                    SpenInView.this.updateUndo(SpenInView.this.mPageDoc.undoToTag());
                    SpenInView.this.mPageDoc.clearHistoryTag();
                } else {
                    o.setVisibility(true);
                    SpenInView.this.update();
                }
                if (SpenInView.this.mUpdateStrokeFrameListener != null) {
                    SpenInView.this.mUpdateStrokeFrameListener.onCanceled(state, o);
                }
            }
        };
    }

    @TargetApi(16)
    public void close() {
        if (this.mContext != null && this.mDetachReceiver != null) {
            this.mContext.unregisterReceiver(this.mDetachReceiver);
            this.mDetachReceiver = null;
        }
        closeControl();
        if (this.nativeCanvas != 0 && getReplayState() != 0) {
            stopReplay();
        }
        if (this.nativeCanvas != 0) {
            native_finalize(this.nativeCanvas);
            this.nativeCanvas = 0;
        }
        if (this.mFloatingLayer != null) {
            this.mFloatingLayer.recycle();
            this.mFloatingLayer = null;
        }
        if (!this.mCanvasLayer.isEmpty()) {
            Iterator<Bitmap> it = this.mCanvasLayer.iterator();
            while (it.hasNext()) {
                Bitmap bitmap = it.next();
                if (bitmap != null && !bitmap.isRecycled()) {
                    bitmap.recycle();
                }
            }
            this.mCanvasLayer.clear();
            this.mCanvasLayer = null;
        }
        if (this.mScreenFB != null) {
            this.mScreenFB.recycle();
            this.mScreenFB = null;
        }
        if (this.mToolTip != null) {
            this.mToolTip.close();
            this.mToolTip = null;
        }
        if (this.mScroll != null) {
            this.mScroll.close();
            this.mScroll = null;
        }
        this.mHoverPointer = null;
        this.mHoverDrawable = null;
        if (this.mPageEffectManager != null) {
            this.mPageEffectManager.close();
            this.mPageEffectManager = null;
        }
        if (this.mGestureDetector != null) {
            this.mGestureDetector.setOnDoubleTapListener(null);
            this.mGestureDetector = null;
        }
        if (this.mSmartScaleGestureDetector != null) {
            this.mSmartScaleGestureDetector.close();
            this.mSmartScaleGestureDetector = null;
        }
        if (this.mRemoverToastMessage != null) {
            this.mRemoverToastMessage.cancel();
            this.mRemoverToastMessage = null;
        }
        this.mBlackPaint = null;
        this.mHighlightPaint = null;
        this.mDebugPaint = null;
        this.mSrcPaint = null;
        this.mAntiAliasPaint = null;
        this.mTextPaint = null;
        this.mCirclePaint = null;
        this.mDottedLinePaint = null;
        this.mCirclePoint = null;
        this.mPenSettingInfo = null;
        this.mEraserSettingInfo = null;
        this.mTextSettingInfo = null;
        this.mRemoverSettingInfo = null;
        this.mSelectionSettingInfo = null;
        this.mHighlightInfoList = null;
        this.mControlListener = null;
        this.mEraserChangeListener = null;
        this.mRemoverChangeListener = null;
        this.mColorPickerListener = null;
        this.mPreDrawListener = null;
        this.mPostDrawListener = null;
        this.mFlickListener = null;
        this.mHoverListener = null;
        this.mPageEffectListener = null;
        this.mHyperTextListener = null;
        this.mLongPressListener = null;
        this.mPenChangeListener = null;
        this.mReplayListener = null;
        this.mPenDetachmentListener = null;
        this.mTextChangeListener = null;
        this.mSelectionChangeListener = null;
        this.mThisStrokeFrameListener = null;
        this.mUpdateStrokeFrameListener = null;
        this.mTouchListener = null;
        this.mPreTouchListener = null;
        this.mZoomListener = null;
        this.mZoomPadListener = null;
        this.mUpdateCanvasListener = null;
        this.mHoverPointerlistener = null;
        this.mBackgroundColorChangeListener = null;
        if (this.mTouchUpHandler != null) {
            this.mTouchUpHandler.removeCallbacks(null);
            this.mTouchUpHandler = null;
        }
        if (this.mSetPageDocHandler != null) {
            this.mSetPageDocHandler.removeCallbacks(null);
            this.mSetPageDocHandler = null;
        }
        if (this.mZoomPad != null) {
            this.mZoomPad.close();
            this.mZoomPad = null;
        }
        this.mContext = null;
        this.mSdkResources = null;
        this.mControl = null;
        this.mContextMenu = null;
        this.mSrcDrawRect = null;
        this.mDstDrawRect = null;
        this.mPageDoc = null;
        this.mParentView = null;
        this.mView = null;
        if (this.mUseC2D) {
            c2ddrawbitmapJNI.native_deinit_c2dJNI();
        }
    }

    protected void onVisibilityChanged(View changedView, int visibility) {
        if (this.mControl != null && (this.mControl instanceof SpenControlTextBox)) {
            if (visibility == 4) {
                ((SpenControlTextBox) this.mControl).hideSoftInput();
            } else if (visibility == 0) {
                ((SpenControlTextBox) this.mControl).showSoftInput();
            }
        }
        if (this.mUseC2D && visibility == 0) {
            c2ddrawbitmapJNI.native_deinit_c2dJNI();
            c2ddrawbitmapJNI.native_init_c2dJNI();
        }
    }

    @SuppressLint({"DrawAllocation"})
    protected void onLayout(boolean changed, int left, int top, int right, int bottom, Rect parentLayoutRect, Rect windowVisibleRect) {
        int w = right - left;
        int h = bottom - top;
        int hExceptSIP = windowVisibleRect == null ? h : windowVisibleRect.bottom - (parentLayoutRect.top + this.mScreenStartY);
        if (w != 0 && h != 0) {
            if (w != this.mLayoutWidth || h != this.mLayoutHeight || hExceptSIP != this.mLayoutExceptSIP) {
                this.mLayoutWidth = w;
                this.mLayoutHeight = h;
                this.mLayoutExceptSIP = hExceptSIP;
                Log.d(TAG, "onLayout(" + changed + ", " + left + ", " + top + ", " + right + ", " + bottom + ")");
                printRect("onLayout. parentLayoutRect : ", parentLayoutRect);
                if (windowVisibleRect != null) {
                    printRect("onLayout. windowVisibleRect : ", windowVisibleRect);
                    Log.d(TAG, "onLayout. hExceptSIP : " + hExceptSIP);
                }
                this.mScreenWidth = w;
                this.mScreenHeight = h;
                this.mScreenHeightExceptSIP = hExceptSIP;
                if (this.mScroll != null) {
                    this.mScroll.setScreenSize(w, h);
                }
                if (this.mPageEffectManager != null) {
                    this.mPageEffectManager.setScreenResolution(w, h);
                }
                native_setScreenSize(this.nativeCanvas, w, h, this.mScreenHeightExceptSIP);
                int newFramebufferWidth = this.mScreenWidth > this.mBitmapWidth ? this.mScreenWidth : this.mBitmapWidth;
                int newFramebufferHeight = this.mScreenHeight > this.mBitmapHeight ? this.mScreenHeight : this.mBitmapHeight;
                if (newFramebufferWidth > this.mFramebufferWidth || newFramebufferHeight > this.mFramebufferHeight) {
                    this.mFramebufferWidth = newFramebufferWidth;
                    this.mFramebufferHeight = newFramebufferHeight;
                    if (this.mScreenFB != null) {
                        this.mScreenFB.recycle();
                    }
                    try {
                        Log.d(TAG, "onLayout. ScreenFB W : " + this.mFramebufferWidth + ", H : " + this.mFramebufferHeight);
                        this.mScreenFB = Bitmap.createBitmap(this.mFramebufferWidth, this.mFramebufferHeight, Bitmap.Config.ARGB_8888);
                        native_setScreenFrameBuffer(this.nativeCanvas, this.mScreenFB);
                    } catch (Throwable th) {
                        Log.e(TAG, "Failed to create bitmap");
                        SpenError.ThrowUncheckedException(2);
                    }
                }
                updateScreenFrameBuffer();
                onUpdateCanvas(null, true);
            }
        }
    }

    private void absoluteCoordinate(RectF dstRectF, RectF srcRectF) {
        dstRectF.left = (srcRectF.left / this.mRatio) + this.mDeltaX;
        dstRectF.right = (srcRectF.right / this.mRatio) + this.mDeltaX;
        dstRectF.top = (srcRectF.top / this.mRatio) + this.mDeltaY;
        dstRectF.bottom = (srcRectF.bottom / this.mRatio) + this.mDeltaY;
    }

    private void absoluteCoordinate(Rect dstRect, float l, float t, float r, float b) {
        dstRect.left = (int) Math.floor((l / this.mRatio) + this.mDeltaX);
        dstRect.right = (int) Math.floor((r / this.mRatio) + this.mDeltaX);
        dstRect.top = (int) Math.ceil((t / this.mRatio) + this.mDeltaY);
        dstRect.bottom = (int) Math.ceil((b / this.mRatio) + this.mDeltaY);
    }

    private void relativeCoordinate(RectF dstRect, RectF srcRect) {
        dstRect.left = (srcRect.left - this.mDeltaX) * this.mRatio;
        dstRect.right = (srcRect.right - this.mDeltaX) * this.mRatio;
        dstRect.top = (srcRect.top - this.mDeltaY) * this.mRatio;
        dstRect.bottom = (srcRect.bottom - this.mDeltaY) * this.mRatio;
    }

    private boolean isIntersect(RectF lhs, RectF rhs) {
        return lhs.left < rhs.right && rhs.left < lhs.right && lhs.top < rhs.bottom && rhs.top < lhs.bottom;
    }

    private Rect MakeNewExtendRect(RectF src) {
        return new Rect((int) Math.floor(src.left), (int) Math.floor(src.top), (int) Math.ceil(src.right), (int) Math.ceil(src.bottom));
    }

    private void ExtendRectFromRectF(Rect dst, RectF src) {
        dst.left = (int) Math.floor(src.left);
        dst.top = (int) Math.floor(src.top);
        dst.right = (int) Math.ceil(src.right);
        dst.bottom = (int) Math.ceil(src.bottom);
    }

    void printRect(String name, Rect srcRect) {
        Log.d(TAG, String.valueOf(name) + " (" + srcRect.left + ", " + srcRect.top + ") (" + srcRect.right + ", " + srcRect.bottom + ") w = " + srcRect.width() + " h = " + srcRect.height());
    }

    void printRect(String name, RectF srcRect) {
        if (srcRect == null) {
            Log.d(TAG, String.valueOf(name) + " null");
        } else {
            Log.d(TAG, String.valueOf(name) + " (" + srcRect.left + ", " + srcRect.top + ") (" + srcRect.right + ", " + srcRect.bottom + ") w = " + srcRect.width() + " h = " + srcRect.height());
        }
    }

    void joinRect(RectF dst, RectF src) {
        if (dst == null || src == null || src.left >= src.right || src.top >= src.bottom) {
            return;
        }
        if (dst.left >= dst.right || dst.top >= dst.bottom) {
            dst.left = src.left;
            dst.right = src.right;
            dst.top = src.top;
            dst.bottom = src.bottom;
            return;
        }
        if (src.left < dst.left) {
            dst.left = src.left;
        }
        if (src.top < dst.top) {
            dst.top = src.top;
        }
        if (src.right > dst.right) {
            dst.right = src.right;
        }
        if (src.bottom > dst.bottom) {
            dst.bottom = src.bottom;
        }
    }

    private void createBitmap(SpenPageDoc pageDoc) {
        if (this.nativeCanvas != 0 && pageDoc != null && pageDoc.isValid()) {
            int width = this.mBitmapWidth;
            int height = this.mBitmapHeight;
            this.mBitmapWidth = pageDoc.getWidth();
            this.mBitmapHeight = pageDoc.getHeight();
            if (this.mBitmapWidth == 0) {
                SpenError.ThrowUncheckedException(6, "The width of pageDoc is 0");
                return;
            }
            if (this.mBitmapHeight == 0) {
                SpenError.ThrowUncheckedException(6, "The height of pageDoc is 0");
                return;
            }
            if (width != this.mBitmapWidth || height != this.mBitmapHeight || pageDoc.isLayerChanged()) {
                Log.d(TAG, "createBitmap Width=" + this.mBitmapWidth + " Height=" + this.mBitmapHeight + " IsLayerChanged=" + pageDoc.isLayerChanged());
                if (this.mFloatingLayer != null) {
                    this.mFloatingLayer.recycle();
                    this.mFloatingLayer = null;
                }
                try {
                    this.mFloatingLayer = Bitmap.createBitmap(this.mBitmapWidth, this.mBitmapHeight, Bitmap.Config.ARGB_8888);
                } catch (Throwable th) {
                    Log.e(TAG, "Failed to create bitmap");
                    SpenError.ThrowUncheckedException(2);
                }
                native_setBitmap(this.nativeCanvas, this.mFloatingLayer);
                Log.d(TAG, "Added Layer Count=" + pageDoc.getLayerCount() + ", Layer Size=" + this.mCanvasLayer.size());
                if (!this.mCanvasLayer.isEmpty()) {
                    native_removeCanvasBitmap(this.nativeCanvas);
                    Iterator<Bitmap> it = this.mCanvasLayer.iterator();
                    while (it.hasNext()) {
                        Bitmap bitmap = it.next();
                        if (bitmap != null && !bitmap.isRecycled()) {
                            bitmap.recycle();
                        }
                    }
                    this.mCanvasLayer.clear();
                }
                for (int pos = 0; pos < pageDoc.getLayerCount(); pos++) {
                    Bitmap bitmap2 = Bitmap.createBitmap(this.mBitmapWidth, this.mBitmapHeight, Bitmap.Config.ARGB_8888);
                    if (this.mUseC2D && pos == 0) {
                        c2ddrawbitmapJNI.native_reallocBitmapJNI(bitmap2);
                    }
                    native_setCanvasBitmap(this.nativeCanvas, pageDoc.getLayerIdByIndex(pos), bitmap2);
                    this.mCanvasLayer.add(bitmap2);
                }
                deltaZoomSizeChanged();
            }
        }
    }

    private void updateDottedLine(Canvas canvas, RectF re_rectf) {
        if (this.mDottedLineEnable && this.mDottedLinePaint != null) {
            RectF ab_rectf = new RectF(VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, this.mRtoBmpItstScrWidth, this.mRtoBmpItstScrHeight);
            absoluteCoordinate(ab_rectf, ab_rectf);
            float currentLine = this.mDottedLineIntervalHeight;
            while (currentLine - this.mDottedLineHalfWidth <= ab_rectf.bottom) {
                if (ab_rectf.top <= this.mDottedLineHalfWidth + currentLine) {
                    float re_line = (currentLine - this.mDeltaY) * this.mRatio;
                    canvas.drawLine(this.mScreenStartX, this.mScreenStartY + re_line, this.mScreenStartX + this.mRtoBmpItstScrWidth, this.mScreenStartY + re_line, this.mDottedLinePaint);
                }
                currentLine += this.mDottedLineIntervalHeight;
            }
        }
    }

    private void drawHintText(Canvas canvas, SpenObjectTextBox textObject) {
        RectF dstRectF = new RectF();
        String text = textObject.getText();
        if (text == null || text.isEmpty()) {
            String hintText = textObject.getHintText();
            if (!textObject.isHintTextEnabled() && hintText != null && !hintText.isEmpty()) {
                relativeCoordinate(dstRectF, textObject.getRect());
                dstRectF.offset(this.mScreenStartX, this.mScreenStartY);
                dstRectF.left += textObject.getLeftMargin() * this.mRatio;
                dstRectF.top += textObject.getTopMargin() * this.mRatio;
                dstRectF.right -= textObject.getRightMargin() * this.mRatio;
                dstRectF.bottom -= textObject.getBottomMargin() * this.mRatio;
                float size = textObject.getHintTextFontSize() * this.mRatio;
                this.mTextPaint.setTypeface(SpenFont.getTypeFace(textObject.getFont()));
                this.mTextPaint.setColor(textObject.getHintTextColor());
                this.mTextPaint.setTextSize(size);
                int align = textObject.getTextAlignment();
                Layout.Alignment alignment = Layout.Alignment.ALIGN_NORMAL;
                if (align == 2 || align == 3) {
                    alignment = Layout.Alignment.ALIGN_CENTER;
                } else if (align == 1) {
                    alignment = Layout.Alignment.ALIGN_OPPOSITE;
                }
                StaticLayout textLayout = new StaticLayout(hintText.subSequence(0, hintText.length()), new TextPaint(this.mTextPaint), (int) dstRectF.width(), alignment, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, size, false);
                float verticalOffset = size * 0.3f;
                int gravity = textObject.getGravity();
                if (gravity == 1) {
                    verticalOffset = (dstRectF.height() - size) / 2.0f;
                } else if (gravity == 2) {
                    verticalOffset = dstRectF.height() - size;
                }
                canvas.save();
                canvas.translate(dstRectF.left, dstRectF.top + verticalOffset);
                textLayout.draw(canvas);
                canvas.restore();
            }
        }
    }

    private void drawHintText(Canvas canvas, SpenObjectImage imageObject) {
        RectF dstRectF = new RectF();
        String hintText = imageObject.getHintText();
        if (!imageObject.isHintTextEnabled() && hintText != null && !hintText.isEmpty()) {
            relativeCoordinate(dstRectF, imageObject.getRect());
            dstRectF.offset(this.mScreenStartX, this.mScreenStartY);
            float size = imageObject.getHintTextFontSize() * this.mRatio;
            float verticalOffset = imageObject.getHintTextVerticalOffset() * this.mRatio;
            this.mTextPaint.setTypeface(Typeface.create(Typeface.SANS_SERIF, 0));
            this.mTextPaint.setColor(imageObject.getHintTextColor());
            this.mTextPaint.setTextSize(size);
            StaticLayout textLayout = new StaticLayout(hintText.subSequence(0, hintText.length()), new TextPaint(this.mTextPaint), (int) dstRectF.width(), Layout.Alignment.ALIGN_CENTER, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, size, false);
            canvas.save();
            canvas.translate(dstRectF.left, dstRectF.top + verticalOffset + ((dstRectF.height() - (textLayout.getLineCount() * size)) / 2.0f));
            textLayout.draw(canvas);
            canvas.restore();
        }
    }

    private void drawHintText(Canvas canvas, SpenObjectContainer containerObject) {
        ArrayList<SpenObjectBase> objectList = containerObject.getObjectList();
        int objectCount = objectList.size();
        for (int cnt = 0; cnt < objectCount; cnt++) {
            SpenObjectBase base = objectList.get(cnt);
            if (base != null) {
                int type = base.getType();
                if (type == 2) {
                    drawHintText(canvas, (SpenObjectTextBox) base);
                } else if (type == 3) {
                    drawHintText(canvas, (SpenObjectImage) base);
                } else if (type == 4) {
                    drawHintText(canvas, (SpenObjectContainer) base);
                }
            }
        }
    }

    private void updateHighlight(Canvas canvas, RectF re_rect) {
        if (this.mHighlightInfoList != null) {
            int count = this.mHighlightInfoList.size();
            RectF rect = new RectF();
            for (int pos = 0; pos < count; pos++) {
                SpenHighlightInfo info = this.mHighlightInfoList.get(pos);
                rect.left = (info.rect.left - this.mDeltaX) * this.mRatio;
                rect.top = (info.rect.top - this.mDeltaY) * this.mRatio;
                rect.right = (info.rect.right - this.mDeltaX) * this.mRatio;
                rect.bottom = (info.rect.bottom - this.mDeltaY) * this.mRatio;
                rect.intersect(VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, this.mRtoBmpItstScrWidth, this.mRtoBmpItstScrHeight);
                rect.offset(this.mScreenStartX, this.mScreenStartY);
                rect.intersect(VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, this.mScreenWidth, this.mScreenHeight);
                this.mHighlightPaint.setColor(info.color);
                this.mHighlightPaint.setStrokeWidth(info.size * this.mRatio);
                canvas.drawRect(rect, this.mHighlightPaint);
            }
        }
    }

    private void updateFloatingLayer(Canvas canvas) {
        if (this.mFloatingLayer != null) {
            this.mFloatingLayer.setPixel(0, 0, this.mFloatingLayer.getPixel(0, 0));
            float ratioBitmapWidth = this.mBitmapWidth * this.mRatio;
            float ratioBitmapHeight = this.mBitmapHeight * this.mRatio;
            float rtoBmpItstScrWidth = ratioBitmapWidth < ((float) this.mScreenWidth) ? ratioBitmapWidth : this.mScreenWidth;
            float rtoBmpItstScrHeight = ratioBitmapHeight < ((float) this.mScreenHeight) ? ratioBitmapHeight : this.mScreenHeight;
            float screenStartX = (this.mScreenWidth - rtoBmpItstScrWidth) / 2.0f;
            float screenStartY = (this.mScreenHeight - rtoBmpItstScrHeight) / 2.0f;
            Rect srcRect = new Rect(0, 0, this.mBitmapWidth, this.mBitmapHeight);
            RectF dstRect = new RectF(VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, this.mBitmapWidth, this.mBitmapHeight);
            RectF dstRelRect = new RectF();
            relativeCoordinate(dstRelRect, dstRect);
            dstRect.set(dstRelRect.left + screenStartX, dstRelRect.top + screenStartY, dstRelRect.right + screenStartX, dstRelRect.bottom + screenStartY);
            canvas.drawBitmap(this.mFloatingLayer, srcRect, dstRect, this.mAntiAliasPaint);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateCanvasLayer2(Canvas canvas) {
        Rect srcRect = new Rect();
        absoluteCoordinate(srcRect, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, this.mRtoBmpItstScrWidth, this.mRtoBmpItstScrHeight);
        Rect dstRect = new Rect(0, 0, this.mRtoBmpItstScrWidth, this.mRtoBmpItstScrHeight);
        int layer = 0;
        while (layer < this.mCanvasLayer.size()) {
            Bitmap bitmap = this.mCanvasLayer.get(layer);
            if (bitmap != null) {
                bitmap.setPixel(0, 0, bitmap.getPixel(0, 0));
                if (this.mPreDrawListener == null) {
                    canvas.drawBitmap(bitmap, srcRect, dstRect, layer == 0 ? this.mSrcPaint : this.mAntiAliasPaint);
                } else {
                    canvas.drawBitmap(bitmap, srcRect, dstRect, this.mAntiAliasPaint);
                }
            }
            layer++;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateCanvasLayer(Canvas canvas, RectF re_rectF, boolean isScreenFramebuffer) {
        if (this.mScreenFB != null || !this.mScreenFB.isRecycled()) {
            if (re_rectF != null && re_rectF.width() == this.mScreenWidth && re_rectF.height() == this.mScreenHeight) {
                re_rectF = null;
            }
            if (this.mZoomPad != null && this.mZoomPad.isZoomPadEnabled()) {
                this.mZoomPad.updateFrameBuffer(true);
            }
            if (re_rectF == null) {
                absoluteCoordinate(this.mSrcDrawRect, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, this.mRtoBmpItstScrWidth, this.mRtoBmpItstScrHeight);
                this.mDstDrawRect.set(0, 0, this.mRtoBmpItstScrWidth, this.mRtoBmpItstScrHeight);
                this.mDstDrawRect.offset(this.mScreenStartX, this.mScreenStartY);
                if (this.mScreenStartX > VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET) {
                    canvas.drawRect(VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, this.mScreenStartX, this.mScreenHeight, this.mBlackPaint);
                    canvas.drawRect(this.mScreenStartX + this.mRtoBmpItstScrWidth, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, this.mLayoutWidth, this.mLayoutHeight, this.mBlackPaint);
                }
                if (this.mScreenStartY > VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET) {
                    canvas.drawRect(VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, this.mScreenWidth, this.mScreenStartY, this.mBlackPaint);
                    canvas.drawRect(VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, this.mScreenStartY + this.mRtoBmpItstScrHeight, this.mLayoutWidth, this.mLayoutHeight, this.mBlackPaint);
                }
                if (this.mZoomPad != null && this.mZoomPad.isZoomPadEnabled()) {
                    canvas.drawRect(VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, this.mScreenHeight - this.mSrcDrawRect.top, this.mLayoutWidth, this.mLayoutHeight, this.mBlackPaint);
                }
            } else {
                absoluteCoordinate(this.mSrcDrawRect, re_rectF.left, re_rectF.top, re_rectF.right, re_rectF.bottom);
                ExtendRectFromRectF(this.mDstDrawRect, re_rectF);
                this.mDstDrawRect.offset(this.mScreenStartX, this.mScreenStartY);
            }
            if (isScreenFramebuffer && this.mRatio != 1.0f) {
                Rect srcRectFB = new Rect(this.mDstDrawRect);
                srcRectFB.offset(-this.mScreenStartX, -this.mScreenStartY);
                this.mScreenFB.setPixel(0, 0, this.mScreenFB.getPixel(0, 0));
                if (this.mPreDrawListener == null) {
                    canvas.drawBitmap(this.mScreenFB, srcRectFB, this.mDstDrawRect, this.mSrcPaint);
                    return;
                } else {
                    canvas.drawBitmap(this.mScreenFB, srcRectFB, this.mDstDrawRect, this.mAntiAliasPaint);
                    return;
                }
            }
            int layer = 0;
            while (layer < this.mCanvasLayer.size()) {
                Bitmap bitmap = this.mCanvasLayer.get(layer);
                if (bitmap != null) {
                    bitmap.setPixel(0, 0, bitmap.getPixel(0, 0));
                    if (this.mPreDrawListener == null) {
                        int area = (this.mSrcDrawRect.width() * this.mSrcDrawRect.height()) + (this.mDstDrawRect.width() * this.mDstDrawRect.height());
                        if (area <= 4147200 || !this.mUseC2D) {
                            canvas.drawBitmap(bitmap, this.mSrcDrawRect, this.mDstDrawRect, layer == 0 ? this.mSrcPaint : this.mAntiAliasPaint);
                        } else {
                            if (c2ddrawbitmapJNI.native_drawBitmapJNI(canvas, bitmap, this.mSrcDrawRect, this.mDstDrawRect, layer == 0 ? this.mSrcPaint : this.mAntiAliasPaint) < 0) {
                                canvas.drawBitmap(bitmap, this.mSrcDrawRect, this.mDstDrawRect, layer == 0 ? this.mSrcPaint : this.mAntiAliasPaint);
                            }
                        }
                    } else {
                        int area2 = (this.mSrcDrawRect.width() * this.mSrcDrawRect.height()) + (this.mDstDrawRect.width() * this.mDstDrawRect.height());
                        if (area2 <= 4147200 || !this.mUseC2D) {
                            canvas.drawBitmap(bitmap, this.mSrcDrawRect, this.mDstDrawRect, this.mAntiAliasPaint);
                        } else if (c2ddrawbitmapJNI.native_drawBitmapJNI(canvas, bitmap, this.mSrcDrawRect, this.mDstDrawRect, this.mAntiAliasPaint) < 0) {
                            canvas.drawBitmap(bitmap, this.mSrcDrawRect, this.mDstDrawRect, this.mAntiAliasPaint);
                        }
                    }
                }
                layer++;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onUpdateCanvas(RectF rectf, boolean isScreenFramebuffer) {
        if (this.mUpdateCanvasListener != null) {
            this.mUpdateCanvasListener.onUpdateCanvas(rectf, isScreenFramebuffer);
        }
    }

    public boolean GetPageEffectWorking() {
        if (this.mPageEffectManager == null) {
            return false;
        }
        return this.mPageEffectManager.isWorking();
    }

    public int GetScreenStartX() {
        return this.mScreenStartX;
    }

    public int GetScreenStartY() {
        return this.mScreenStartY;
    }

    public int GetScreenWidth() {
        return this.mScreenWidth;
    }

    public int GetScreenHeight() {
        return this.mScreenHeight;
    }

    public int GetRtoBmpItstScrWidth() {
        return this.mRtoBmpItstScrWidth;
    }

    public int GetRtoBmpItstScrHeight() {
        return this.mRtoBmpItstScrHeight;
    }

    @SuppressLint({"WrongCall"})
    public void UpdateCanvas(Canvas canvas, RectF rectf, boolean isScreenFramebuffer) {
        long time = SystemClock.uptimeMillis();
        long postdraw = time;
        long engine = time;
        long predraw = time;
        if (rectf == null) {
            Log.v(TAG, "Performance onUpdateCanvas start rect = null isScreenFramebuffer = " + isScreenFramebuffer);
        } else {
            Log.v(TAG, "Performance onUpdateCanvas start rect = (" + rectf.left + ", " + rectf.top + ") (" + rectf.right + ", " + rectf.bottom + ") w = " + rectf.width() + " h = " + rectf.height() + " isScreenFramebuffer = " + isScreenFramebuffer);
        }
        if (this.mPageDoc != null) {
            if (this.mPageEffectManager != null && this.mPageEffectManager.isWorking()) {
                this.mPageEffectManager.drawAnimation(canvas);
            } else {
                if (this.mPreDrawListener != null) {
                    this.mPreDrawListener.onDraw(canvas, this.mDeltaX, this.mDeltaY, this.mRatio, this.mScreenStartX, this.mScreenStartY, rectf);
                }
                predraw = SystemClock.uptimeMillis();
                updateCanvasLayer(canvas, rectf, isScreenFramebuffer);
                if (rectf == null) {
                    rectf = new RectF(VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, this.mRtoBmpItstScrWidth, this.mRtoBmpItstScrHeight);
                } else {
                    updateFloatingLayer(canvas);
                }
                updateHighlight(canvas, rectf);
                updateDottedLine(canvas, rectf);
                if (this.mCircleRadius > VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET) {
                    canvas.drawCircle(this.mCirclePoint.x, this.mCirclePoint.y, this.mCircleRadius, this.mCirclePaint);
                }
                if (this.mRemoverRadius > VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET && (this.mView == null || !(this.mView instanceof SurfaceView) || rectf.width() <= ((this.mRemoverRadius * 2.0f) + 30.0f) * this.mRatio)) {
                    canvas.drawCircle(this.mCirclePoint.x, this.mCirclePoint.y, this.mRemoverRadius, this.mCirclePaint);
                }
                engine = SystemClock.uptimeMillis();
                if (this.mPostDrawListener != null) {
                    this.mPostDrawListener.onDraw(canvas, this.mDeltaX, this.mDeltaY, this.mRatio, this.mScreenStartX, this.mScreenStartY, rectf);
                }
                postdraw = SystemClock.uptimeMillis();
                this.mScroll.drawScroll(canvas);
                if (this.mSmartScaleGestureDetector != null) {
                    this.mSmartScaleGestureDetector.draw(canvas);
                }
            }
        } else {
            canvas.drawColor(this.mBlackPaint.getColor());
        }
        Log.v(TAG, "Performance onUpdateCanvas end total = " + (SystemClock.uptimeMillis() - time) + " ms predraw = " + (predraw - time) + " ms spenview = " + (engine - predraw) + " ms postdraw = " + (postdraw - engine) + " ms");
    }

    private void getVariableForOnUpdateCanvas() {
        this.mMaxDeltaX = this.mBitmapWidth - (this.mScreenWidth / this.mRatio);
        if (this.mMaxDeltaX < VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET) {
            this.mMaxDeltaX = VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET;
        }
        int shortHeight = this.mScreenHeight < this.mScreenHeightExceptSIP ? this.mScreenHeight : this.mScreenHeightExceptSIP;
        this.mMaxDeltaY = this.mBitmapHeight - (shortHeight / this.mRatio);
        if (this.mMaxDeltaY < VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET) {
            this.mMaxDeltaY = VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET;
        }
        this.mRatioBitmapWidth = (int) (this.mBitmapWidth * this.mRatio);
        this.mRatioBitmapHeight = (int) (this.mBitmapHeight * this.mRatio);
        this.mRtoBmpItstScrWidth = this.mRatioBitmapWidth < this.mScreenWidth ? this.mRatioBitmapWidth : this.mScreenWidth;
        this.mRtoBmpItstScrHeight = this.mRatioBitmapHeight < this.mScreenHeight ? this.mRatioBitmapHeight : this.mScreenHeight;
        this.mScreenStartX = (int) ((this.mScreenWidth - this.mRtoBmpItstScrWidth) / 2.0f);
        this.mScreenStartY = (int) ((this.mScreenHeight - this.mRtoBmpItstScrHeight) / 2.0f);
    }

    private void deltaZoomSizeChanged() {
        getVariableForOnUpdateCanvas();
        if (this.mSmartScaleGestureDetector != null) {
            this.mSmartScaleGestureDetector.onZoom(this.mDeltaX, this.mDeltaY, this.mRatio);
            this.mSmartScaleGestureDetector.setLimitHeight(this.mMaxDeltaX, this.mMaxDeltaY);
            this.mSmartScaleGestureDetector.setDrawInformation(this.mRtoBmpItstScrWidth, this.mRtoBmpItstScrHeight, this.mScreenStartX, this.mScreenStartY);
        }
        if (this.mScroll != null) {
            this.mScroll.setRatioBitmapSize(this.mRatioBitmapWidth, this.mRatioBitmapHeight);
            this.mScroll.setDeltaValue(this.mDeltaX, this.mDeltaY, this.mMaxDeltaX, this.mMaxDeltaY);
        }
        Log.d(TAG, "onZoom. dx : " + this.mDeltaX + ", dy : " + this.mDeltaY + ", r : " + this.mRatio + ", MaxDx : " + this.mMaxDeltaX + ", MaxDy : " + this.mMaxDeltaY);
    }

    private void onZoom(float centerX, float centerY, float ratio) {
        this.mDeltaX = centerX;
        this.mDeltaY = centerY;
        this.mRatio = ratio;
        deltaZoomSizeChanged();
        if (this.mZoomListener != null) {
            this.mZoomListener.onZoom(centerX, centerY, ratio);
        }
        if (this.mControl != null) {
            if (this.mControl instanceof SpenControlTextBox) {
                ((SpenControlTextBox) this.mControl).fit(false);
            }
            this.mControl.fit();
            this.mControl.invalidate();
        }
    }

    private void onColorPickerChanged(int x, int y, int color) {
        int controlColor;
        Log.d(TAG, "onColorPickerChanged color" + color);
        if (this.mColorPickerListener != null) {
            if (this.mControl != null && (this.mControl instanceof SpenControlTextBox) && (controlColor = ((SpenControlTextBox) this.mControl).getPixel(x, y)) != 0) {
                float alpha = Color.alpha(controlColor) / 255.0f;
                float ialpha = 1.0f - alpha;
                color = Color.argb(255, (int) ((Color.red(controlColor) * alpha) + (Color.red(color) * ialpha)), (int) ((Color.green(controlColor) * alpha) + (Color.green(color) * ialpha)), (int) ((Color.blue(controlColor) * alpha) + (Color.blue(color) * ialpha)));
            }
            this.mColorPickerListener.onChanged(color, x, y);
        }
    }

    private void onProgressChanged(int progress, int id) {
        if (this.mReplayListener != null) {
            this.mReplayListener.onProgressChanged(progress, id);
        }
    }

    private void onCompleted() {
        Log.d(TAG, "onCompleted");
        if (this.mReplayListener != null) {
            this.mReplayListener.onCompleted();
        }
    }

    private void applyTextSetting(SpenObjectTextBox object) {
        int endPos = 0;
        if (object.getText() != null) {
            endPos = object.getText().length();
        }
        if (object.getSpan() == null) {
            if (this.mTextSettingInfo == null) {
                this.mTextSettingInfo = new SpenSettingTextInfo();
                this.mTextSettingInfo.size = (float) (r14.size * (getCanvasWidth() / 200.0d));
            }
            ArrayList<SpenObjectTextBox.TextSpanInfo> span = new ArrayList<>();
            SpenObjectTextBox.FontSizeSpanInfo fsSpan = new SpenObjectTextBox.FontSizeSpanInfo();
            fsSpan.startPos = 0;
            fsSpan.endPos = endPos;
            fsSpan.fontSize = this.mTextSettingInfo.size;
            span.add(fsSpan);
            SpenObjectTextBox.ForegroundColorSpanInfo fcSpan = new SpenObjectTextBox.ForegroundColorSpanInfo();
            fcSpan.startPos = 0;
            fcSpan.endPos = endPos;
            fcSpan.foregroundColor = this.mTextSettingInfo.color;
            span.add(fcSpan);
            SpenObjectTextBox.BoldStyleSpanInfo bsSpan = new SpenObjectTextBox.BoldStyleSpanInfo();
            bsSpan.startPos = 0;
            bsSpan.endPos = endPos;
            bsSpan.isBold = (this.mTextSettingInfo.style & 1) == 1;
            span.add(bsSpan);
            SpenObjectTextBox.ItalicStyleSpanInfo isSpan = new SpenObjectTextBox.ItalicStyleSpanInfo();
            isSpan.startPos = 0;
            isSpan.endPos = endPos;
            isSpan.isItalic = (this.mTextSettingInfo.style & 2) == 2;
            span.add(isSpan);
            SpenObjectTextBox.UnderlineStyleSpanInfo usSpan = new SpenObjectTextBox.UnderlineStyleSpanInfo();
            usSpan.startPos = 0;
            usSpan.endPos = endPos;
            usSpan.isUnderline = (this.mTextSettingInfo.style & 4) == 4;
            span.add(usSpan);
            SpenObjectTextBox.FontNameSpanInfo fnSpan = new SpenObjectTextBox.FontNameSpanInfo();
            fnSpan.startPos = 0;
            fnSpan.endPos = endPos;
            fnSpan.fontName = this.mTextSettingInfo.font;
            span.add(fnSpan);
            SpenObjectTextBox.TextDirectionSpanInfo direction = new SpenObjectTextBox.TextDirectionSpanInfo();
            direction.textDirection = (char) this.mTextSettingInfo.direction;
            direction.startPos = 0;
            direction.endPos = endPos;
            span.add(direction);
            object.setSpan(span);
        }
        if (object.getParagraph() == null) {
            if (this.mTextSettingInfo == null) {
                this.mTextSettingInfo = new SpenSettingTextInfo();
            }
            ArrayList<SpenObjectTextBox.TextParagraphInfo> paragraph = new ArrayList<>();
            SpenObjectTextBox.AlignParagraphInfo align = new SpenObjectTextBox.AlignParagraphInfo();
            align.align = (char) this.mTextSettingInfo.align;
            align.startPos = 0;
            align.endPos = endPos;
            paragraph.add(align);
            SpenObjectTextBox.LineSpacingParagraphInfo lineSpacing = new SpenObjectTextBox.LineSpacingParagraphInfo();
            lineSpacing.type = this.mTextSettingInfo.lineSpacingType;
            lineSpacing.lineSpacing = this.mTextSettingInfo.lineSpacing;
            lineSpacing.startPos = 0;
            lineSpacing.endPos = endPos;
            paragraph.add(lineSpacing);
            object.setParagraph(paragraph);
        }
    }

    private boolean onSelectObject(ArrayList<SpenObjectBase> objectList, int toolType, int pressType, float x, float y, int userdata) {
        if (this.mControl != null && pressType == 0) {
            return false;
        }
        if (this.mControl != null) {
            if (!this.mControl.isTouchEnabled()) {
                return false;
            }
            closeControl();
        }
        if (objectList == null) {
            Log.d(TAG, "onSelectObject ObjectList is nulll");
            return false;
        }
        if (objectList.size() == 0) {
            Log.d(TAG, "onSelectObject : selected list size is zero.");
            return false;
        }
        ArrayList<Rect> relativeObjectRectList = new ArrayList<>();
        ArrayList<SpenContextMenuItemInfo> menuList = new ArrayList<>();
        ArrayList<Integer> styleList = new ArrayList<>();
        PointF point = new PointF(x, y);
        RectF tempRelativeRectF = new RectF();
        Rect boundaryRect = new Rect(0, 0, 0, 0);
        for (int i = 0; i < objectList.size(); i++) {
            SpenObjectBase tempObject = objectList.get(i);
            if (tempObject == null) {
                Log.d(TAG, "onSelectObject : object is null.");
                return false;
            }
            if (!this.mPageDoc.isObjectContained(tempObject)) {
                return false;
            }
            Rect relativeRect = new Rect();
            relativeCoordinate(tempRelativeRectF, tempObject.getRect());
            tempRelativeRectF.round(relativeRect);
            relativeObjectRectList.add(relativeRect);
            boundaryRect.union(relativeRect);
        }
        styleList.add(0);
        if (objectList.size() > 1) {
            styleList.set(0, 2);
            if (this.mControlListener != null) {
                boolean continueProcess = this.mControlListener.onCreated(objectList, relativeObjectRectList, menuList, styleList, pressType, point);
                if (!continueProcess) {
                    return true;
                }
            }
            if (this.mPageDoc.getSelectedObjectCount() == 0) {
                this.mPageDoc.selectObject(objectList);
            }
            SpenControlList control = new SpenControlList(this.mContext, this.mPageDoc);
            control.setStyle(styleList.get(0).intValue());
            control.setContextMenu(menuList);
            control.setObject(objectList);
            setControl(control);
            return true;
        }
        SpenObjectBase object = objectList.get(0);
        SpenControlBase control2 = null;
        if (this.mPageDoc.getSelectedObjectCount() == 0) {
            this.mPageDoc.selectObject(object);
        }
        switch (object.getType()) {
            case 1:
                Log.d(TAG, "TYPE_STROKE");
                control2 = new SpenControlStroke(this.mContext, this.mPageDoc);
                ((SpenControlStroke) control2).setObject((SpenObjectStroke) object);
                break;
            case 2:
                Log.d(TAG, "Text Selection");
                if (userdata == 1) {
                    SpenControlTextBox ControlTextBox = new SpenControlTextBox(this.mContext, this.mPageDoc);
                    ControlTextBox.setStyle(1);
                    ControlTextBox.setTextEraserEnabled(true);
                    ControlTextBox.setObject((SpenObjectTextBox) object);
                    ControlTextBox.setEditable(true);
                    ControlTextBox.setDimEnabled(false);
                    setControl(ControlTextBox);
                    return true;
                }
                boolean isEditable = true;
                if (getToolTypeAction(1) == 6 || getToolTypeAction(2) == 6 || getToolTypeAction(3) == 6 || getToolTypeAction(4) == 6 || pressType == 2) {
                    isEditable = false;
                }
                if (isEditable) {
                    styleList.set(0, 2);
                    object.setRotatable(false);
                } else {
                    object.setRotatable(true);
                }
                applyTextSetting((SpenObjectTextBox) object);
                control2 = new SpenControlTextBox(this.mContext, this.mPageDoc);
                ((SpenControlTextBox) control2).setObject((SpenObjectTextBox) object);
                ((SpenControlTextBox) control2).setEditable(isEditable);
                ((SpenControlTextBox) control2).setDimEnabled(false);
                break;
            case 3:
                Log.d(TAG, "TYPE_IMAGE");
                control2 = new SpenControlImage(this.mContext, this.mPageDoc);
                ((SpenControlImage) control2).setObject((SpenObjectImage) object);
                break;
            case 4:
                Log.d(TAG, "TYPE_CONTAINER");
                control2 = new SpenControlContainer(this.mContext, this.mPageDoc);
                ((SpenControlContainer) control2).setObject((SpenObjectContainer) object);
                break;
        }
        if (this.mControlListener != null) {
            boolean continueProcess2 = this.mControlListener.onCreated(objectList, relativeObjectRectList, menuList, styleList, pressType, point);
            if (!continueProcess2) {
                return true;
            }
        }
        if (control2 != null) {
            control2.setStyle(styleList.get(0).intValue());
            control2.setContextMenu(menuList);
            control2.setFocusable(true);
            control2.requestFocus();
            control2.setNextFocusDownId(240784);
            control2.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.samsung.android.sdk.pen.engine.SpenInView.3
                @Override // android.view.View.OnFocusChangeListener
                public void onFocusChange(View arg0, boolean hasFocus) {
                    if (!hasFocus) {
                        return;
                    }
                    SpenInView.this.raiseOnKeyDown();
                }
            });
            setControl(control2);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void raiseOnKeyDown() {
        if (this.mControl != null) {
            this.mControl.onKeyDown(22, new KeyEvent(0, 22));
        }
    }

    private void onHyperText(String hyperText, int type, int handle) {
        if (this.mHyperTextListener != null && this.mPageDoc != null) {
            SpenObjectTextBox textBox = (SpenObjectTextBox) this.mPageDoc.getObjectByRuntimeHandle(handle);
            this.mHyperTextListener.onSelected(hyperText, type, textBox);
        }
    }

    private void fitControlToObject() {
        if (this.mControl != null) {
            if (this.mPageDoc.isObjectContained(this.mControl.getObjectList().get(0))) {
                this.mControl.fit();
                this.mControl.invalidate();
            } else {
                closeControl();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean removeHoveringIcon(int nHoverIconID) {
        if (this.mContext == null || !this.mHoverEnable) {
            return false;
        }
        this.mHoverEnable = false;
        PackageManager pm = this.mContext.getPackageManager();
        if (pm == null || !pm.hasSystemFeature("com.sec.feature.hovering_ui")) {
            return false;
        }
        try {
            if (this.mHoverPointer != null) {
                this.mHoverPointer.setHoveringSpenIcon(1);
                this.mHoverPointer.removeHoveringSpenCustomIcon(nHoverIconID);
            }
            return true;
        } catch (ClassNotFoundException e) {
            Log.e(TAG, "removeCustomHoveringIcon() ClassNotFoundException");
            e.printStackTrace();
            return false;
        } catch (IllegalAccessException e2) {
            Log.e(TAG, "removeCustomHoveringIcon() IllegalAccessException");
            e2.printStackTrace();
            return false;
        } catch (IllegalArgumentException e3) {
            Log.e(TAG, "removeCustomHoveringIcon() IllegalArgumentException");
            e3.printStackTrace();
            return false;
        } catch (NoSuchMethodException e4) {
            Log.e(TAG, "removeCustomHoveringIcon() NoSuchMethodException");
            e4.printStackTrace();
            return false;
        } catch (InvocationTargetException e5) {
            Log.e(TAG, "removeCustomHoveringIcon() IllegalAccessException");
            e5.printStackTrace();
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int setCustomHoveringIcon(Drawable d) {
        int nHoverIconID = -1;
        if (this.mContext == null) {
            return -1;
        }
        this.mHoverEnable = true;
        PackageManager pm = this.mContext.getPackageManager();
        if (pm != null && pm.hasSystemFeature("com.sec.feature.hovering_ui")) {
            if (d != null) {
                try {
                    if (this.mHoverPointer != null) {
                        nHoverIconID = this.mHoverPointer.setHoveringSpenIcon(0, d);
                    }
                } catch (Resources.NotFoundException e) {
                    Log.e(TAG, "setCustomHoveringIcon() NotFoundException");
                    e.printStackTrace();
                    return -1;
                } catch (ClassNotFoundException e2) {
                    Log.e(TAG, "setCustomHoveringIcon() ClassNotFoundException");
                    e2.printStackTrace();
                    return -1;
                } catch (IllegalAccessException e3) {
                    Log.e(TAG, "setCustomHoveringIcon() IllegalAccessException");
                    e3.printStackTrace();
                    return -1;
                } catch (IllegalArgumentException e4) {
                    Log.e(TAG, "setCustomHoveringIcon() IllegalArgumentException");
                    e4.printStackTrace();
                    return -1;
                } catch (NoSuchMethodException e5) {
                    Log.e(TAG, "setCustomHoveringIcon() NoSuchMethodException");
                    e5.printStackTrace();
                    return -1;
                } catch (InvocationTargetException e6) {
                    Log.e(TAG, "setCustomHoveringIcon() InvocationTargetException");
                    e6.printStackTrace();
                    return -1;
                }
            }
            return nHoverIconID;
        }
        return -1;
    }

    private void setHoverPointerDrawable(Drawable d) {
        if (this.nativeCanvas != 0) {
            Log.d(TAG, "setHoverPointerDrawable");
            this.mHoverDrawable = d;
        }
    }

    public void update() {
        if (this.nativeCanvas != 0) {
            createBitmap(this.mPageDoc);
            native_update(this.nativeCanvas);
            if (this.mPageDoc != null && this.mPageDoc.isValid() && this.mBackgroundColorChangeListener != null) {
                boolean enable = ((this.mPageDoc.getBackgroundColor() >> 24) & 255) == 255;
                if (enable != this.mMagicPenEnabled) {
                    this.mBackgroundColorChangeListener.onChanged(enable);
                    this.mMagicPenEnabled = enable;
                }
            }
        }
    }

    public void updateScreenFrameBuffer() {
        if (this.nativeCanvas != 0 && getReplayState() == 0) {
            native_updateAllScreenFrameBuffer(this.nativeCanvas);
        }
    }

    public void updateScreen() {
        if (this.nativeCanvas != 0 && getReplayState() == 0) {
            RectF rectf = new RectF(VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, this.mScreenWidth, this.mScreenHeight);
            onUpdateCanvas(rectf, true);
        }
    }

    public void updateUndo(SpenPageDoc.HistoryUpdateInfo[] userDataList) {
        if (this.nativeCanvas != 0) {
            if (userDataList == null || userDataList.length == 0) {
                Log.e(TAG, "The parameter 'userDataList' cannot be null.");
                return;
            }
            createBitmap(this.mPageDoc);
            if (!native_updateUndo(this.nativeCanvas, userDataList, userDataList.length)) {
                SpenError.ThrowUncheckedException(SpenError.getError());
            }
            fitControlToObject();
        }
    }

    public void updateRedo(SpenPageDoc.HistoryUpdateInfo[] userDataList) {
        if (this.nativeCanvas != 0) {
            if (userDataList == null || userDataList.length == 0) {
                Log.e(TAG, "The parameter 'userDataList' cannot be null.");
                return;
            }
            createBitmap(this.mPageDoc);
            if (!native_updateRedo(this.nativeCanvas, userDataList, userDataList.length)) {
                SpenError.ThrowUncheckedException(SpenError.getError());
            }
            fitControlToObject();
        }
    }

    public boolean onTouchEvent(MotionEvent event) {
        if (event == null || this.nativeCanvas == 0) {
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
            this.isSkipTouch = diffTime > 600 + this.mTouchProcessingTime;
            if (this.mPageEffectManager != null && this.mPageEffectManager.isWorking()) {
                this.isSkipTouch = true;
            }
            if (this.isSkipTouch) {
                long eventTime = event.getEventTime();
                long downTime = event.getDownTime();
                long systemTime = SystemClock.uptimeMillis();
                Log.v(TAG, "skiptouch action = " + action + " eventTime = " + eventTime + " downTime = " + downTime + " systemTime = " + systemTime + " diffTime = " + diffTime + " mTouchProcessingTime = " + this.mTouchProcessingTime);
            }
            this.mTouchProcessingTime = 0L;
        }
        if (action == 0) {
            this.mIsControlSelect = false;
        }
        if (this.mControl != null && this.mControl.isTouchEnabled() && this.mControl.getStyle() != 3) {
            if (this.mIsControlSelect) {
                if (action == 1) {
                    this.mIsControlSelect = false;
                }
                this.mControl.onTouchEvent(event);
                event.setAction(2);
            } else if (action == 1) {
                closeControl();
            }
            if (this.mGestureDetector != null) {
                this.mGestureDetector.onTouchEvent(event);
            }
            return true;
        }
        if (!this.isSkipTouch) {
            event.offsetLocation(-this.mScreenStartX, -this.mScreenStartY);
            if (this.mSmartScaleGestureDetector != null) {
                this.mSmartScaleGestureDetector.onTouchEvent(event);
            }
            if (this.mGestureDetector != null) {
                this.mGestureDetector.onTouchEvent(event);
            }
            if (action == 1 && getToolTypeAction(event.getToolType(0)) == 1) {
                this.mTouchUpHandler.sendEmptyMessage(0);
            }
            long time = SystemClock.uptimeMillis();
            Log.v(TAG, "Performance touch process start");
            if (this.mPreTouchListener != null && this.mPreTouchListener.onTouch(this.mView, event)) {
                Log.v(TAG, "Performance pretouch listener has consumed action = " + action);
                return true;
            }
            long pretouch = SystemClock.uptimeMillis();
            if (action == 0) {
                int toolTypeAction = native_getToolTypeAction(this.nativeCanvas, event.getToolType(0));
                if (this.mIsToolTip && toolTypeAction != 3 && toolTypeAction != 4 && toolTypeAction != 5) {
                    this.mHoverDrawable = null;
                }
                if (toolTypeAction == 3 || toolTypeAction == 4) {
                    this.isEraserCursor = true;
                    if (toolTypeAction == 3) {
                        this.mCircleRadius = (this.mEraserSettingInfo.size * this.mRatio) / 2.0f;
                    } else if (toolTypeAction == 4) {
                        if (this.mRemoverSettingInfo.type == 0) {
                            this.mRemoverRadius = (20.0f * this.mRatio) / 2.0f;
                        } else if (this.mRemoverSettingInfo.type == 1) {
                            this.mRemoverRadius = (40.0f * this.mRatio) / 2.0f;
                        }
                    }
                    this.mCirclePoint.x = event.getX() + this.mScreenStartX;
                    this.mCirclePoint.y = event.getY() + this.mScreenStartY;
                    this.mCirclePaint.setStrokeWidth(2.0f * this.mRatio);
                }
            } else if (this.isEraserCursor) {
                if (action == 2) {
                    int toolTypeAction2 = native_getToolTypeAction(this.nativeCanvas, event.getToolType(0));
                    if (toolTypeAction2 == 3) {
                        this.mCircleRadius = (this.mEraserSettingInfo.size * this.mRatio) / 2.0f;
                    } else if (toolTypeAction2 == 4) {
                        if (this.mRemoverSettingInfo.type == 0) {
                            this.mRemoverRadius = (20.0f * this.mRatio) / 2.0f;
                        } else if (this.mRemoverSettingInfo.type == 1) {
                            this.mRemoverRadius = (40.0f * this.mRatio) / 2.0f;
                        }
                    }
                    this.mCirclePoint.x = event.getX() + this.mScreenStartX;
                    this.mCirclePoint.y = event.getY() + this.mScreenStartY;
                    this.mCirclePaint.setStrokeWidth(2.0f * this.mRatio);
                } else {
                    this.isEraserCursor = false;
                    this.mCircleRadius = -100.0f;
                    this.mRemoverRadius = -100.0f;
                    this.mCirclePoint.x = -100.0f;
                    this.mCirclePoint.y = -100.0f;
                }
            }
            this.removerTouchX = event.getRawX();
            this.removerTouchY = event.getRawY();
            native_onTouch(this.nativeCanvas, event, event.getToolType(0));
            long engine = SystemClock.uptimeMillis();
            if (this.mTouchListener != null && this.mTouchListener.onTouch(this.mView, event)) {
                long posttouch = SystemClock.uptimeMillis();
                this.mTouchProcessingTime = SystemClock.uptimeMillis() - time;
                Log.v(TAG, "Performance touch process end total = " + (SystemClock.uptimeMillis() - time) + " ms pretouch = " + (pretouch - time) + " ms spenview = " + (engine - pretouch) + " ms posttouch = " + (posttouch - engine) + " ms action = " + action);
                return true;
            }
            long posttouch2 = SystemClock.uptimeMillis();
            this.mTouchProcessingTime = SystemClock.uptimeMillis() - time;
            Log.v(TAG, "Performance touch process end total = " + (SystemClock.uptimeMillis() - time) + " ms pretouch = " + (pretouch - time) + " ms spenview = " + (engine - pretouch) + " ms posttouch = " + (posttouch2 - engine) + " ms action = " + action);
        }
        return true;
    }

    public boolean onHoverEvent(MotionEvent event) {
        if (event == null || this.nativeCanvas == 0) {
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
                Log.d(TAG, "skiptouch hover action = " + action + " eventTime = " + eventTime + " downTime = " + downTime + " systemTime = " + systemTime + " diffTime = " + diffTime);
            }
        }
        if (this.isSkipTouch) {
            return true;
        }
        native_onHover(this.nativeCanvas, event, event.getToolType(0));
        if (this.mControl == null && this.mSmartScaleGestureDetector != null) {
            this.mSmartScaleGestureDetector.onHoverEvent(event);
        }
        if (this.mHoverListener == null || this.mHoverListener.onHover(this.mView, event)) {
            return true;
        }
        return true;
    }

    private void savePngFile(String filename, Bitmap bmp) throws IOException {
        File file = new File(filename);
        try {
            FileOutputStream filestream = new FileOutputStream(file);
            bmp.compress(Bitmap.CompressFormat.PNG, 0, filestream);
            filestream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }

    public Bitmap captureCurrentView(boolean includeBackground) {
        if (this.nativeCanvas == 0) {
            return null;
        }
        native_updateAllScreenFrameBuffer(this.nativeCanvas);
        Bitmap bitmap = null;
        try {
            if (!includeBackground) {
                bitmap = Bitmap.createBitmap(this.mRtoBmpItstScrWidth, this.mRtoBmpItstScrHeight, Bitmap.Config.ARGB_8888);
            } else {
                bitmap = Bitmap.createBitmap(this.mScreenWidth, this.mScreenHeight, Bitmap.Config.ARGB_8888);
            }
        } catch (Throwable th) {
            Log.e(TAG, "Failed to create bitmap");
            SpenError.ThrowUncheckedException(2, " : fail createBitmap.");
        }
        Canvas canvas = new Canvas(bitmap);
        if (!includeBackground) {
            canvas.translate(-this.mScreenStartX, -this.mScreenStartY);
        }
        updateCanvasLayer(canvas, null, true);
        return bitmap;
    }

    public Bitmap capturePage(float ratio) {
        if (this.mCanvasLayer.size() == 0 || this.mCanvasLayer.get(0) == null) {
            return null;
        }
        return Bitmap.createScaledBitmap(this.mCanvasLayer.get(0), (int) (this.mBitmapWidth * ratio), (int) (this.mBitmapHeight * ratio), true);
    }

    @Override // com.samsung.android.sdk.pen.SpenSettingViewInterface
    public void setToolTypeAction(int toolType, int action) {
        if (this.nativeCanvas != 0) {
            if (this.mControl != null && toolType != 5) {
                if (action == 5) {
                    this.mControl.setTouchEnabled(false);
                } else {
                    this.mControl.setTouchEnabled(true);
                }
            }
            if (this.mSmartScaleGestureDetector != null) {
                this.mSmartScaleGestureDetector.setToolTypeAction(toolType, action);
            }
            if (this.mZoomPad != null) {
                this.mZoomPad.setToolTypeAction(toolType, action);
            }
            if (this.mIsToolTip) {
                if (action == 2 && this.mToolTip != null) {
                    if (this.mPenSettingInfo == null) {
                        this.mPenSettingInfo = new SpenSettingPenInfo();
                    }
                    setHoverPointerDrawable(this.mToolTip.getDrawableImage(this.mPenSettingInfo.name, this.mPenSettingInfo.color, this.mPenSettingInfo.size));
                } else if (action == 3 && this.mToolTip != null) {
                    if (this.mEraserSettingInfo == null) {
                        this.mEraserSettingInfo = new SpenSettingEraserInfo();
                    }
                    setHoverPointerDrawable(this.mToolTip.getDrawableEraserImage(this.mEraserSettingInfo.size));
                } else if (action == 4 && this.mToolTip != null) {
                    if (this.mRemoverSettingInfo == null) {
                        this.mRemoverSettingInfo = new SpenSettingRemoverInfo();
                    }
                    if (this.mRemoverSettingInfo.type == 0) {
                        setHoverPointerDrawable(this.mToolTip.getDrawableRemoverImage(20));
                    } else if (this.mRemoverSettingInfo.type == 1) {
                        setHoverPointerDrawable(this.mToolTip.getDrawableRemoverImage(40));
                    }
                } else if (action == 5 && this.mToolTip != null) {
                    setHoverPointerDrawable(this.mToolTip.getDrawableHoverImage());
                } else {
                    setHoverPointerDrawable(null);
                }
            }
            native_setToolTypeAction(this.nativeCanvas, toolType, action);
        }
    }

    @Override // com.samsung.android.sdk.pen.SpenSettingViewInterface
    public int getToolTypeAction(int toolType) {
        if (this.nativeCanvas == 0) {
            return 0;
        }
        return native_getToolTypeAction(this.nativeCanvas, toolType);
    }

    public void setZoomable(boolean enable) {
        if (this.nativeCanvas != 0) {
            this.mZoomable = enable;
            native_enableZoom(this.nativeCanvas, enable);
        }
    }

    public boolean isZoomable() {
        if (this.nativeCanvas == 0) {
            return false;
        }
        return native_isZoomable(this.nativeCanvas);
    }

    public void setZoom(float centerX, float centerY, float ratio) {
        if (this.nativeCanvas != 0) {
            native_setZoom(this.nativeCanvas, centerX, centerY, ratio);
        }
    }

    public float getZoomRatio() {
        return this.nativeCanvas == 0 ? VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET : native_getZoomRatio(this.nativeCanvas);
    }

    public PointF getFrameStartPosition() {
        if (this.nativeCanvas == 0) {
            return null;
        }
        return new PointF(this.mScreenStartX, this.mScreenStartY);
    }

    public boolean setMaxZoomRatio(float ratio) {
        if (this.nativeCanvas == 0) {
            return false;
        }
        return native_setMaxZoomRatio(this.nativeCanvas, ratio);
    }

    public float getMaxZoomRatio() {
        return this.nativeCanvas == 0 ? VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET : native_getMaxZoomRatio(this.nativeCanvas);
    }

    public boolean setMinZoomRatio(float ratio) {
        if (this.nativeCanvas == 0) {
            return false;
        }
        return native_setMinZoomRatio(this.nativeCanvas, ratio);
    }

    public float getMinZoomRatio() {
        return this.nativeCanvas == 0 ? VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET : native_getMinZoomRatio(this.nativeCanvas);
    }

    public void setPan(PointF position) {
        if (this.nativeCanvas != 0) {
            native_setPan(this.nativeCanvas, position.x, position.y, true);
        }
    }

    public PointF getPan() {
        if (this.nativeCanvas == 0) {
            return null;
        }
        PointF point = new PointF();
        native_getPan(this.nativeCanvas, point);
        return point;
    }

    public void setBlankColor(int color) {
        if (this.nativeCanvas != 0) {
            this.mBlackPaint.setColor(color);
            if (this.mPageEffectManager != null) {
                this.mPageEffectManager.setPaint(this.mBlackPaint);
            }
        }
    }

    public int getBlankColor() {
        if (this.nativeCanvas == 0) {
            return 0;
        }
        return this.mBlackPaint.getColor();
    }

    @Override // com.samsung.android.sdk.pen.SpenSettingViewInterface
    public int getCanvasWidth() {
        if (this.nativeCanvas == 0 || this.mPageDoc == null) {
            return 0;
        }
        return this.mPageDoc.getWidth();
    }

    @Override // com.samsung.android.sdk.pen.SpenSettingViewInterface
    public int getCanvasHeight() {
        if (this.nativeCanvas == 0 || this.mPageDoc == null) {
            return 0;
        }
        return this.mPageDoc.getHeight();
    }

    @Override // com.samsung.android.sdk.pen.SpenSettingViewInterface
    public void setBackgroundColorChangeListener(Object object, SpenSettingViewInterface.SpenBackgroundColorChangeListener listener) {
        if (object != null && (object instanceof SpenSettingPenLayout)) {
            Log.d(TAG, "setBackgroundColorListener");
            this.mBackgroundColorChangeListener = listener;
            if (this.mPageDoc != null && this.mPageDoc.isValid() && this.mBackgroundColorChangeListener != null) {
                boolean enable = ((this.mPageDoc.getBackgroundColor() >> 24) & 255) == 255;
                if (enable != this.mMagicPenEnabled) {
                    this.mBackgroundColorChangeListener.onChanged(enable);
                    this.mMagicPenEnabled = enable;
                }
            }
        }
    }

    @Override // com.samsung.android.sdk.pen.SpenSettingViewInterface
    public void setTextSettingInfo(SpenSettingTextInfo info) {
        if (this.nativeCanvas != 0) {
            if (this.mControl != null) {
                if (this.mControl instanceof SpenControlTextBox) {
                    ((SpenControlTextBox) this.mControl).setTextSettingInfo(info);
                }
                if (this.mTextChangeListener != null) {
                    this.mTextChangeListener.onChanged(info, 2);
                    return;
                }
                return;
            }
            this.mTextSettingInfo = info;
            if (this.mIsToolTip && getToolTypeAction(1) != 5 && getToolTypeAction(2) != 5 && getToolTypeAction(4) != 5 && getToolTypeAction(3) != 5) {
                setHoverPointerDrawable(null);
            }
            if (this.mTextSettingInfo != null) {
                if (this.mTextSettingInfo.size < VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET) {
                    this.mTextSettingInfo.size = 10.0f * ((float) (getCanvasWidth() / 200.0d));
                }
                if (this.mTextSettingInfo.style < 0) {
                    this.mTextSettingInfo.style = 0;
                }
            }
            if (this.mTextChangeListener != null) {
                this.mTextChangeListener.onChanged(this.mTextSettingInfo, 1);
            }
        }
    }

    @Override // com.samsung.android.sdk.pen.SpenSettingViewInterface
    public SpenSettingTextInfo getTextSettingInfo() {
        if (this.nativeCanvas == 0) {
            return null;
        }
        if (this.mControl != null && (this.mControl instanceof SpenControlTextBox)) {
            return ((SpenControlTextBox) this.mControl).getTextSettingInfo();
        }
        SpenSettingTextInfo info = new SpenSettingTextInfo();
        info.size *= (float) (getCanvasWidth() / 200.0d);
        if (this.mTextSettingInfo != null) {
            info.style = this.mTextSettingInfo.style;
            info.color = this.mTextSettingInfo.color;
            info.size = this.mTextSettingInfo.size;
            info.font = this.mTextSettingInfo.font;
            info.align = this.mTextSettingInfo.align;
            info.lineIndent = this.mTextSettingInfo.lineIndent;
            info.lineSpacing = this.mTextSettingInfo.lineSpacing;
            return info;
        }
        return info;
    }

    @Override // com.samsung.android.sdk.pen.SpenSettingViewInterface
    public void setPenSettingInfo(SpenSettingPenInfo info) {
        if (this.nativeCanvas != 0) {
            this.mPenSettingInfo = info;
            if (this.mPenSettingInfo != null) {
                if (this.mPenSettingInfo.size < VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET) {
                    this.mPenSettingInfo.size = 10.0f;
                }
                if (this.mIsToolTip && this.mToolTip != null && getToolTypeAction(1) != 5 && getToolTypeAction(2) != 5 && getToolTypeAction(4) != 5 && getToolTypeAction(3) != 5) {
                    setHoverPointerDrawable(this.mToolTip.getDrawableImage(this.mPenSettingInfo.name, this.mPenSettingInfo.color, this.mPenSettingInfo.size));
                }
                native_setPenStyle(this.nativeCanvas, this.mPenSettingInfo.name);
                native_setPenColor(this.nativeCanvas, this.mPenSettingInfo.color);
                native_setPenSize(this.nativeCanvas, this.mPenSettingInfo.size);
                native_enablePenCurve(this.nativeCanvas, this.mPenSettingInfo.isCurvable);
                native_setAdvancedSetting(this.nativeCanvas, this.mPenSettingInfo.advancedSetting);
                if (this.mZoomPad != null) {
                    this.mZoomPad.setPenSettingInfo(this.mPenSettingInfo);
                }
            }
            if (this.mPenChangeListener != null) {
                this.mPenChangeListener.onChanged(this.mPenSettingInfo);
            }
        }
    }

    @Override // com.samsung.android.sdk.pen.SpenSettingViewInterface
    public SpenSettingPenInfo getPenSettingInfo() {
        if (this.nativeCanvas == 0) {
            return null;
        }
        SpenSettingPenInfo info = new SpenSettingPenInfo();
        if (this.mPenSettingInfo != null) {
            info.name = this.mPenSettingInfo.name;
            info.size = this.mPenSettingInfo.size;
            info.color = this.mPenSettingInfo.color;
            info.isCurvable = this.mPenSettingInfo.isCurvable;
            info.advancedSetting = this.mPenSettingInfo.advancedSetting;
            return info;
        }
        return info;
    }

    @Override // com.samsung.android.sdk.pen.SpenSettingViewInterface
    public void setEraserSettingInfo(SpenSettingEraserInfo info) {
        if (this.nativeCanvas != 0) {
            this.mEraserSettingInfo = info;
            if (this.mEraserSettingInfo != null) {
                if (this.mControl != null && (this.mControl instanceof SpenControlTextBox)) {
                    ((SpenControlTextBox) this.mControl).setTextEraserEnabled(this.mEraserSettingInfo.type == 1);
                }
                if (this.mEraserSettingInfo.size < 2.0f) {
                    this.mEraserSettingInfo.size = 2.0f;
                }
                if (this.mIsToolTip && this.mToolTip != null && getToolTypeAction(1) != 5 && getToolTypeAction(2) != 5 && getToolTypeAction(4) != 5 && getToolTypeAction(3) != 5) {
                    setHoverPointerDrawable(this.mToolTip.getDrawableEraserImage(this.mEraserSettingInfo.size));
                }
                native_setEraserType(this.nativeCanvas, this.mEraserSettingInfo.type);
                native_setEraserSize(this.nativeCanvas, this.mEraserSettingInfo.size);
            }
            if (this.mEraserChangeListener != null) {
                this.mEraserChangeListener.onChanged(this.mEraserSettingInfo);
            }
        }
    }

    @Override // com.samsung.android.sdk.pen.SpenSettingViewInterface
    public SpenSettingEraserInfo getEraserSettingInfo() {
        if (this.nativeCanvas == 0) {
            return null;
        }
        SpenSettingEraserInfo info = new SpenSettingEraserInfo();
        if (this.mEraserSettingInfo != null) {
            info.type = this.mEraserSettingInfo.type;
            info.size = this.mEraserSettingInfo.size;
            return info;
        }
        return info;
    }

    @Override // com.samsung.android.sdk.pen.SpenSettingViewInterface
    public void setRemoverSettingInfo(SpenSettingRemoverInfo info) {
        if (this.nativeCanvas != 0) {
            this.mRemoverSettingInfo = info;
            if (this.mRemoverSettingInfo != null) {
                if (this.mRemoverSettingInfo.size < VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET) {
                    this.mRemoverSettingInfo.size = 1.0f;
                }
                if (this.mIsToolTip && this.mToolTip != null && getToolTypeAction(1) != 5 && getToolTypeAction(2) != 5 && getToolTypeAction(4) != 5 && getToolTypeAction(3) != 5) {
                    if (this.mRemoverSettingInfo.type == 0) {
                        setHoverPointerDrawable(this.mToolTip.getDrawableRemoverImage(20));
                    } else if (this.mRemoverSettingInfo.type == 1) {
                        setHoverPointerDrawable(this.mToolTip.getDrawableRemoverImage(40));
                    }
                }
                native_setRemoverType(this.nativeCanvas, this.mRemoverSettingInfo.type);
                native_setRemoverSize(this.nativeCanvas, this.mRemoverSettingInfo.size);
                if (this.mZoomPad != null) {
                    this.mZoomPad.setRemoverSettingInfo(this.mRemoverSettingInfo);
                }
            }
            if (this.mRemoverChangeListener != null) {
                this.mRemoverChangeListener.onChanged(this.mRemoverSettingInfo);
            }
        }
    }

    @Override // com.samsung.android.sdk.pen.SpenSettingViewInterface
    public SpenSettingRemoverInfo getRemoverSettingInfo() {
        if (this.nativeCanvas == 0) {
            return null;
        }
        SpenSettingRemoverInfo info = new SpenSettingRemoverInfo();
        if (this.mRemoverSettingInfo != null) {
            info.type = this.mRemoverSettingInfo.type;
            info.size = this.mRemoverSettingInfo.size;
            return info;
        }
        return info;
    }

    @Override // com.samsung.android.sdk.pen.SpenSettingViewInterface
    public void setSelectionSettingInfo(SpenSettingSelectionInfo info) {
        if (this.nativeCanvas != 0) {
            this.mSelectionSettingInfo = info;
            if (this.mIsToolTip && getToolTypeAction(1) != 5 && getToolTypeAction(2) != 5 && getToolTypeAction(4) != 5 && getToolTypeAction(3) != 5) {
                setHoverPointerDrawable(null);
            }
            if (this.mSelectionSettingInfo != null) {
                native_setSelectionType(this.nativeCanvas, this.mSelectionSettingInfo.type);
            }
            if (this.mSelectionChangeListener != null) {
                this.mSelectionChangeListener.onChanged(this.mSelectionSettingInfo);
            }
        }
    }

    @Override // com.samsung.android.sdk.pen.SpenSettingViewInterface
    public SpenSettingSelectionInfo getSelectionSettingInfo() {
        if (this.nativeCanvas == 0) {
            return null;
        }
        SpenSettingSelectionInfo info = new SpenSettingSelectionInfo();
        if (this.mSelectionSettingInfo != null) {
            info.type = this.mSelectionSettingInfo.type;
            return info;
        }
        return info;
    }

    public boolean setPageDoc(SpenPageDoc pageDoc, boolean isUpdate) {
        if (this.nativeCanvas == 0) {
            return false;
        }
        if (pageDoc == this.mPageDoc) {
            Log.e(TAG, "setPageDoc is same");
            return true;
        }
        if (pageDoc != null && !pageDoc.isValid()) {
            Log.e(TAG, "setPageDoc is closed");
            return false;
        }
        if (this.mPageEffectManager != null && this.mPageEffectManager.isWorking()) {
            return false;
        }
        closeControl();
        createBitmap(pageDoc);
        this.mPageDoc = pageDoc;
        if (this.mPageDoc != null && this.mPageDoc.isValid() && this.mBackgroundColorChangeListener != null) {
            boolean enable = ((this.mPageDoc.getBackgroundColor() >> 24) & 255) == 255;
            if (enable != this.mMagicPenEnabled) {
                this.mBackgroundColorChangeListener.onChanged(enable);
                this.mMagicPenEnabled = enable;
            }
        }
        if (native_setPageDoc(this.nativeCanvas, this.mPageDoc, isUpdate)) {
            if (isUpdate) {
                this.mSetPageDocHandler.sendEmptyMessage(0);
            }
        } else {
            this.mPageDoc = null;
        }
        return true;
    }

    public boolean setPageDoc(SpenPageDoc pageDoc, int direction, int type, float centerY) {
        if (this.nativeCanvas == 0) {
            return false;
        }
        if (pageDoc == this.mPageDoc) {
            Log.e(TAG, "setPageDoc is same");
            return true;
        }
        if (pageDoc != null && !pageDoc.isValid()) {
            Log.e(TAG, "setPageDoc is closed");
            return false;
        }
        if (this.mPageEffectManager == null || this.mPageEffectManager.isWorking()) {
            return false;
        }
        Log.d(TAG, "setPageDoc, direction=" + direction);
        this.mPageEffectManager.setType(type);
        this.mPageEffectManager.setCanvasInformation(this.mScreenStartX, this.mScreenStartY, this.mRtoBmpItstScrWidth, this.mRtoBmpItstScrHeight);
        boolean isMemoryEnough = true;
        if (!this.mPageEffectManager.saveScreenshot()) {
            Log.e(TAG, "setPageDoc. No enough memory1. Change to PAGE_TRANSITION_EFFECT_NONE");
            isMemoryEnough = false;
        }
        closeControl();
        createBitmap(pageDoc);
        this.mPageDoc = pageDoc;
        native_setPan(this.nativeCanvas, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, centerY, false);
        if (this.mPageDoc != null && this.mPageDoc.isValid() && this.mBackgroundColorChangeListener != null) {
            boolean enable = ((this.mPageDoc.getBackgroundColor() >> 24) & 255) == 255;
            if (enable != this.mMagicPenEnabled) {
                this.mBackgroundColorChangeListener.onChanged(enable);
                this.mMagicPenEnabled = enable;
            }
        }
        if (isMemoryEnough) {
            native_setPageDoc(this.nativeCanvas, this.mPageDoc, false);
            if (!this.mPageEffectManager.startAnimation(direction)) {
                Log.e(TAG, "setPageDoc. No enough memory2. Change to PAGE_TRANSITION_EFFECT_NONE");
                this.mSetPageDocHandler.sendEmptyMessage(0);
            }
        } else if (native_setPageDoc(this.nativeCanvas, this.mPageDoc, true)) {
            this.mSetPageDocHandler.sendEmptyMessage(0);
        } else {
            this.mPageDoc = null;
        }
        return true;
    }

    public void cancelStrokeFrame() {
        if (this.mPageDoc == null || !this.mPageDoc.isValid()) {
            SpenError.ThrowUncheckedException(8, "The vies has not SpenPageDoc instance. please use to call setPageDoc.");
        }
        if (this.mStrokeFrame != null) {
            SpenObjectContainer o = this.mStrokeFrame.cancelStrokeFrame();
            if (o.getExtraDataInt("STROKE_FRAME") == 1) {
                updateUndo(this.mPageDoc.undoToTag());
                this.mPageDoc.clearHistoryTag();
            } else if (o.getExtraDataInt("STROKE_FRAME") == 2) {
                o.setVisibility(true);
                update();
            }
            this.mStrokeFrame = null;
        }
    }

    public void changeStrokeFrame(SpenObjectContainer container) {
        if (this.mPageDoc == null || !this.mPageDoc.isValid()) {
            SpenError.ThrowUncheckedException(8, "The vies has not SpenPageDoc instance. please use to call setPageDoc.");
        }
        if (container == null) {
            throw new IllegalArgumentException("container is null");
        }
        if (container.getObject(0).isVisible()) {
            container.getObject(0).setVisibility(false);
            container.getObject(1).setVisibility(true);
        } else {
            container.getObject(1).setVisibility(false);
            container.getObject(0).setVisibility(true);
        }
        update();
    }

    private boolean checkMDMCameraLock() throws ClassNotFoundException {
        String result = null;
        try {
            Class<?> c = Class.forName("android.os.SystemProperties", true, this.mContext.getClassLoader());
            Class[] s = {String.class};
            Object[] args = {new String("persist.sys.camera_lock")};
            result = (String) c.getMethod("get", s).invoke(null, args);
        } catch (ClassNotFoundException e) {
        } catch (IllegalAccessException e2) {
        } catch (IllegalArgumentException e3) {
        } catch (NoSuchMethodException e4) {
        } catch (InvocationTargetException e5) {
        }
        if (result != null && "camera_lock.enabled".equals(result)) {
            return false;
        }
        return true;
    }

    public void takeStrokeFrame(Activity activity, ViewGroup canvasLayout, List<SpenObjectStroke> strokeList, SpenStrokeFrameListener listener) {
        if (this.mPageDoc == null || !this.mPageDoc.isValid()) {
            SpenError.ThrowUncheckedException(8, "The vies has not SpenPageDoc instance. please use to call setPageDoc.");
        }
        if (activity == null || canvasLayout == null || strokeList == null || listener == null) {
            throw new IllegalArgumentException("Arguments is null. activity = " + activity + " viewgroup = " + canvasLayout + " stroke = " + strokeList + " listener = " + listener);
        }
        if (!checkMDMCameraLock()) {
            listener.onCanceled(33, null);
            return;
        }
        SpenObjectContainer oc = new SpenObjectContainer();
        oc.appendObject(new SpenObjectImage());
        for (SpenObjectStroke s : strokeList) {
            this.mPageDoc.removeObject(s);
            oc.appendObject(s);
        }
        update();
        SpenObjectContainer bc = new SpenObjectContainer();
        bc.appendObject(new SpenObjectImage());
        SpenObjectContainer c = new SpenObjectContainer();
        c.setOutOfViewEnabled(false);
        c.setRotatable(false);
        c.setVisibility(false);
        c.appendObject(oc);
        c.appendObject(bc);
        this.mPageDoc.setHistoryTag();
        this.mPageDoc.appendObject(c);
        c.setExtraDataInt("STROKE_FRAME", 1);
        this.mUpdateStrokeFrameListener = listener;
        this.mStrokeFrame = new SpenStrokeFrame();
        Bitmap bgBitmap = Bitmap.createBitmap(this.mBitmapWidth, this.mBitmapHeight, Bitmap.Config.ARGB_8888);
        native_setCanvasBitmap(this.nativeCanvas, -100, bgBitmap);
        this.mStrokeFrame.takeStrokeFrame(activity, captureCurrentView(true), bgBitmap, this.mPageDoc.getWidth(), this.mPageDoc.getHeight(), this.mStrokeFrameType, c, this.mThisStrokeFrameListener, getPan(), getZoomRatio(), getFrameStartPosition(), canvasLayout);
    }

    public void retakeStrokeFrame(Activity activity, ViewGroup canvasLayout, SpenObjectContainer strokeFrameContainer, SpenStrokeFrameListener listener) {
        if (this.mPageDoc == null || !this.mPageDoc.isValid()) {
            SpenError.ThrowUncheckedException(8, "The vies has not SpenPageDoc instance. please use to call setPageDoc.");
        }
        if (activity == null || canvasLayout == null || strokeFrameContainer == null || listener == null) {
            throw new IllegalArgumentException("Arguments is null. activity = " + activity + " viewgroup = " + canvasLayout + " stroke = " + strokeFrameContainer + " listener = " + listener);
        }
        if (!checkMDMCameraLock()) {
            listener.onCanceled(34, strokeFrameContainer);
            return;
        }
        strokeFrameContainer.setVisibility(false);
        update();
        this.mStrokeFrame = new SpenStrokeFrame();
        Bitmap bgBitmap = Bitmap.createBitmap(this.mBitmapWidth, this.mBitmapHeight, Bitmap.Config.ARGB_8888);
        native_setCanvasBitmap(this.nativeCanvas, -100, bgBitmap);
        this.mStrokeFrame.retakeStrokeFrame(activity, captureCurrentView(true), bgBitmap, this.mPageDoc.getWidth(), this.mPageDoc.getHeight(), this.mStrokeFrameType, strokeFrameContainer, this.mThisStrokeFrameListener, getPan(), getZoomRatio(), getFrameStartPosition(), canvasLayout);
    }

    public void setSmartScaleEnabled(boolean enable, Rect region, int effectFrame, int zoomOutResponseTime, float zoomRatio) {
        if (this.nativeCanvas != 0 && this.mSmartScaleGestureDetector != null) {
            this.mIsSmartScale = enable;
            this.mSmartScaleGestureDetector.enableSmartScale(enable, region, effectFrame, zoomOutResponseTime, zoomRatio);
        }
    }

    public boolean isSmartScaleEnabled() {
        return this.mIsSmartScale;
    }

    public void setHorizontalSmartScrollEnabled(boolean enable, Rect leftScrollRegion, Rect rightScrollRegion, int responseTime, int velocity) {
        if (this.nativeCanvas != 0 && this.mSmartScaleGestureDetector != null) {
            this.mIsSmartHorizontal = enable;
            this.mSmartScaleGestureDetector.enableHorizontalSmartScroll(enable, leftScrollRegion, rightScrollRegion, responseTime, velocity);
        }
    }

    public boolean isHorizontalSmartScrollEnabled() {
        return this.mIsSmartHorizontal;
    }

    public void setVerticalSmartScrollEnabled(boolean enable, Rect topScrollRegion, Rect bottomScrollRegion, int responseTime, int velocity) {
        if (this.nativeCanvas != 0 && this.mSmartScaleGestureDetector != null) {
            this.mIsSmartVertical = enable;
            this.mSmartScaleGestureDetector.enableVerticalSmartScroll(enable, topScrollRegion, bottomScrollRegion, responseTime, velocity);
        }
    }

    public boolean isVerticalSmartScrollEnabled() {
        return this.mIsSmartVertical;
    }

    public void setHyperTextViewEnabled(boolean enable) {
        if (this.nativeCanvas != 0) {
            this.mIsHyperText = enable;
            native_setHyperTextViewEnabled(this.nativeCanvas, this.mIsHyperText);
        }
    }

    public boolean isHyperTextViewEnabled() {
        return this.mIsHyperText;
    }

    public void setToolTipEnabled(boolean enable) {
        Log.d(TAG, "setToolTipEnabled=" + enable);
        if (!enable) {
            setHoverPointerDrawable(null);
        }
        this.mIsToolTip = enable;
    }

    public boolean isToolTipEnabled() {
        return this.mIsToolTip;
    }

    public void setView(View view) {
        this.mView = view;
    }

    public void setParent(ViewGroup view) {
        this.mParentView = view;
    }

    public void setControl(SpenControlBase spenControlBase) {
        BaseControlListener baseControlListener = null;
        byte b = 0;
        if (this.nativeCanvas != 0) {
            if (this.mControl != null) {
                this.mControl.close();
                this.mControl = null;
            }
            this.mIsControlSelect = true;
            this.mControl = spenControlBase;
            this.mControl.setListener(new BaseControlListener(this, baseControlListener));
            this.mControl.updateRectList();
            if (spenControlBase instanceof SpenControlTextBox) {
                ((SpenControlTextBox) spenControlBase).setActionListener(new OnTextActionListener(this, b == true ? 1 : 0));
            }
            if (this.mParentView != null) {
                this.mParentView.addView(this.mControl);
            }
        }
    }

    public SpenControlBase getControl() {
        if (this.nativeCanvas == 0) {
            return null;
        }
        return this.mControl;
    }

    @Override // com.samsung.android.sdk.pen.SpenSettingViewInterface
    public void closeControl() {
        if (this.nativeCanvas != 0 && !this.mTransactionClosingControl) {
            this.mTransactionClosingControl = true;
            if (this.mControl != null) {
                try {
                    this.mControl.close();
                } catch (IllegalArgumentException e) {
                    e.printStackTrace();
                }
            }
            this.mTransactionClosingControl = false;
        }
    }

    public void startReplay() {
        if (this.nativeCanvas != 0 && !native_startReplay(this.nativeCanvas)) {
            SpenError.ThrowUncheckedException(SpenError.getError());
        }
    }

    public void stopReplay() {
        if (this.nativeCanvas != 0 && !native_stopReplay(this.nativeCanvas)) {
            SpenError.ThrowUncheckedException(SpenError.getError());
        }
    }

    public void pauseReplay() {
        if (this.nativeCanvas != 0 && !native_pauseReplay(this.nativeCanvas)) {
            SpenError.ThrowUncheckedException(SpenError.getError());
        }
    }

    public void resumeReplay() {
        if (this.nativeCanvas != 0 && !native_resumeReplay(this.nativeCanvas)) {
            SpenError.ThrowUncheckedException(SpenError.getError());
        }
    }

    public int getReplayState() {
        if (this.nativeCanvas == 0) {
            return 0;
        }
        return native_getReplayState(this.nativeCanvas);
    }

    public void setReplaySpeed(int speed) {
        if (this.nativeCanvas != 0 && !native_setReplaySpeed(this.nativeCanvas, speed)) {
            SpenError.ThrowUncheckedException(SpenError.getError());
        }
    }

    public void setReplayPosition(int index) {
        if (this.nativeCanvas != 0 && !native_setReplayPosition(this.nativeCanvas, index)) {
            SpenError.ThrowUncheckedException(SpenError.getError());
        }
    }

    public void setDottedLineEnabled(boolean enable, int intervalHeight, int color, int thickness, float[] pathIntervals, float phase) {
        if (this.nativeCanvas != 0) {
            if (this.mDottedLineEnable != enable || this.mDottedLineIntervalHeight != intervalHeight || ((this.mDottedLinePaint != null && this.mDottedLinePaint.getColor() != color) || (this.mDottedLinePaint != null && this.mDottedLinePaint.getStrokeWidth() != thickness))) {
                this.mDottedLineEnable = enable;
                if (this.mDottedLineEnable) {
                    this.mDottedLineIntervalHeight = intervalHeight;
                    this.mDottedLineHalfWidth = thickness / 2.0f;
                    this.mDottedLinePaint = new Paint();
                    this.mDottedLinePaint.setStyle(Paint.Style.STROKE);
                    this.mDottedLinePaint.setStrokeWidth(thickness);
                    this.mDottedLinePaint.setPathEffect(new DashPathEffect(pathIntervals, phase));
                    this.mDottedLinePaint.setColor(color);
                } else {
                    this.mDottedLinePaint = null;
                }
                onUpdateCanvas(null, true);
            }
        }
    }

    public boolean isDottedLineEnabled() {
        if (this.nativeCanvas == 0) {
            return false;
        }
        return this.mDottedLineEnable;
    }

    public void setHighlight(ArrayList<SpenHighlightInfo> highlightInfo) {
        if (this.nativeCanvas != 0) {
            this.mHighlightInfoList = highlightInfo;
            if (this.mHighlightInfoList != null) {
                onUpdateCanvas(null, true);
            }
        }
    }

    public void clearHighlight() {
        if (this.nativeCanvas != 0 && this.mHighlightInfoList != null) {
            this.mHighlightInfoList = null;
            onUpdateCanvas(null, true);
        }
    }

    public void startTemporaryStroke() {
        if (this.nativeCanvas != 0) {
            native_startTemporaryStroke(this.nativeCanvas);
        }
    }

    public void stopTemporaryStroke() {
        if (this.nativeCanvas != 0) {
            native_stopTemporaryStroke(this.nativeCanvas);
        }
    }

    public ArrayList<SpenObjectStroke> getTemporaryStroke() {
        if (this.nativeCanvas == 0) {
            return null;
        }
        ArrayList<SpenObjectStroke> list = new ArrayList<>();
        native_getTemporaryStroke(this.nativeCanvas, list);
        return list;
    }

    public void setScrollBarEnabled(boolean enable) {
        if (this.nativeCanvas != 0 && this.mScroll != null) {
            this.mScroll.enableScroll(enable);
            updateScreen();
        }
    }

    public boolean isScrollBarEnabled() {
        if (this.nativeCanvas == 0 || this.mScroll == null) {
            return false;
        }
        boolean ret = this.mScroll.isScroll();
        return ret;
    }

    public void setZoomPadPosition(PointF point) {
        if (this.nativeCanvas != 0 && point != null && this.mZoomPad != null) {
            this.mZoomPad.setZoomViewPosition(point.x, point.y);
        }
    }

    public PointF getZoomPadPosition() {
        if (this.nativeCanvas == 0) {
            return null;
        }
        PointF point = new PointF(VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET);
        if (this.mZoomPad != null) {
            point.x = this.mZoomPad.getZoomViewRect().left;
            point.y = this.mZoomPad.getZoomViewRect().top;
            return point;
        }
        return point;
    }

    public void startZoomPad() {
        if (this.nativeCanvas != 0 && this.mZoomPad != null) {
            this.mPreZoomable = isZoomable();
            setZoomable(false);
            this.mPreScrollable = isScrollBarEnabled();
            setScrollBarEnabled(false);
            this.mZoomPad.setCanvasSize(this.mScreenWidth, this.mScreenHeight, this.mScreenStartY, this.mRtoBmpItstScrHeight);
            this.mZoomPad.setLayer(this.mCanvasLayer);
            this.mZoomPad.setPanAndZoom(this.mDeltaX, this.mDeltaY, this.mRatio);
            this.mZoomPad.startZoomPad(this.mParentView);
            if (this.mPenSettingInfo == null) {
                this.mPenSettingInfo = new SpenSettingPenInfo();
            }
            this.mZoomPad.setPenSettingInfo(this.mPenSettingInfo);
        }
    }

    public void stopZoomPad() {
        if (this.nativeCanvas != 0 && this.mZoomPad != null) {
            this.mZoomPad.stopZoomPad();
        }
    }

    public boolean isZoomPadEnabled() {
        if (this.nativeCanvas == 0 || this.mZoomPad == null) {
            return false;
        }
        return this.mZoomPad.isZoomPadEnabled();
    }

    public Bitmap drawObjectList(ArrayList<SpenObjectBase> objectList) {
        if (objectList == null || objectList.size() == 0) {
            return null;
        }
        RectF dstRect = new RectF();
        Iterator<SpenObjectBase> it = objectList.iterator();
        while (it.hasNext()) {
            SpenObjectBase object = it.next();
            RectF srcRect = object.getDrawnRect();
            joinRect(dstRect, srcRect);
        }
        try {
            Bitmap bitmap = Bitmap.createBitmap((int) dstRect.width(), (int) dstRect.height(), Bitmap.Config.ARGB_8888);
            if (native_drawObjectList(this.nativeCanvas, bitmap, objectList, objectList.size())) {
                return bitmap;
            }
        } catch (Exception e) {
            Log.e(TAG, "Failed to create bitmap");
            SpenError.ThrowUncheckedException(2);
        }
        return null;
    }

    public void cancelStroke() {
        if (this.nativeCanvas != 0) {
            native_cancelStroke(this.nativeCanvas);
        }
    }

    public void setPreTouchListener(SpenTouchListener listener) {
        if (this.nativeCanvas != 0) {
            this.mPreTouchListener = listener;
        }
    }

    public void setTouchListener(SpenTouchListener listener) {
        if (this.nativeCanvas != 0) {
            this.mTouchListener = listener;
        }
    }

    public void setHoverListener(SpenHoverListener listener) {
        if (this.nativeCanvas != 0) {
            String releaseNumber = Build.VERSION.RELEASE;
            if (releaseNumber.startsWith("4.")) {
                this.mHoverListener = listener;
            } else {
                SpenError.ThrowUncheckedException(12, "S Pen Hover Listener cannot be supported under android ICS");
            }
        }
    }

    public void setLongPressListener(SpenLongPressListener listener) {
        if (this.nativeCanvas != 0) {
            this.mLongPressListener = listener;
        }
    }

    public void setReplayListener(SpenReplayListener listener) {
        if (this.nativeCanvas != 0) {
            this.mReplayListener = listener;
        }
    }

    public void setColorPickerListener(SpenColorPickerListener listener) {
        if (this.nativeCanvas != 0) {
            this.mColorPickerListener = listener;
        }
    }

    public void setZoomListener(SpenZoomListener listener) {
        if (this.nativeCanvas != 0) {
            this.mZoomListener = listener;
        }
    }

    public void setPageEffectListener(SpenPageEffectListener listener) {
        this.mPageEffectListener = listener;
    }

    public void setPenDetachmentListener(SpenPenDetachmentListener listener) {
        if (this.nativeCanvas != 0) {
            this.mPenDetachmentListener = listener;
            if (this.mPenDetachmentListener != null && this.mContext != null && this.mDetachReceiver == null) {
                IntentFilter filter = new IntentFilter("com.samsung.pen.INSERT");
                filter.addAction("com.samsung.pen.INSERT");
                this.mDetachReceiver = new DetachReceiver(this, null);
                this.mContext.registerReceiver(this.mDetachReceiver, filter);
            }
        }
    }

    public void setPenChangeListener(SpenPenChangeListener listener) {
        if (this.nativeCanvas != 0) {
            this.mPenChangeListener = listener;
        }
    }

    public void setEraserChangeListener(SpenEraserChangeListener listener) {
        if (this.nativeCanvas != 0) {
            this.mEraserChangeListener = listener;
        }
    }

    public void setRemoverChangeListener(SpenRemoverChangeListener listener) {
        if (this.nativeCanvas != 0) {
            this.mRemoverChangeListener = listener;
        }
    }

    public void setTextChangeListener(SpenTextChangeListener listener) {
        if (this.nativeCanvas != 0) {
            this.mTextChangeListener = listener;
        }
    }

    public void setSelectionChangeListener(SpenSelectionChangeListener listener) {
        if (this.nativeCanvas != 0) {
            this.mSelectionChangeListener = listener;
        }
    }

    public void setControlListener(SpenControlListener listener) {
        if (this.nativeCanvas != 0) {
            this.mControlListener = listener;
        }
    }

    public void setFlickListener(SpenFlickListener listener) {
        if (this.nativeCanvas != 0) {
            this.mFlickListener = listener;
        }
    }

    public void setPreDrawListener(SpenDrawListener listener) {
        if (this.nativeCanvas != 0) {
            Log.d(TAG, "Register setPreDrawListener");
            this.mPreDrawListener = listener;
        }
    }

    public void setPostDrawListener(SpenDrawListener listener) {
        if (this.nativeCanvas != 0) {
            Log.d(TAG, "Register setPostDrawListener");
            this.mPostDrawListener = listener;
        }
    }

    public void setHyperTextListener(SpenHyperTextListener listener) {
        if (this.nativeCanvas != 0) {
            this.mHyperTextListener = listener;
        }
    }

    public void setZoomPadListener(SpenZoomPadListener listener) {
        if (this.nativeCanvas != 0) {
            this.mZoomPadListener = listener;
        }
    }

    private class BaseControlListener implements SpenControlBase.ActionListener {
        private BaseControlListener() {
        }

        /* synthetic */ BaseControlListener(SpenInView spenInView, BaseControlListener baseControlListener) {
            this();
        }

        @Override // com.samsung.android.sdk.pen.engine.SpenControlBase.ActionListener
        public void onClosed(ArrayList<SpenObjectBase> objectList) {
            Log.d(SpenInView.TAG, "onClosed");
            if (SpenInView.this.mControl != null && SpenInView.this.mControl.getParent() != null) {
                ((ViewGroup) SpenInView.this.mControl.getParent()).removeView(SpenInView.this.mControl);
            }
            if (SpenInView.this.mPageDoc != null) {
                SpenInView.this.mPageDoc.selectObject((SpenObjectBase) null);
            }
            SpenInView.this.mControl = null;
            if (SpenInView.this.mControlListener != null) {
                SpenInView.this.mControlListener.onClosed(objectList);
            }
            SpenInView.this.update();
        }

        @Override // com.samsung.android.sdk.pen.engine.SpenControlBase.ActionListener
        public void onObjectChanged(ArrayList<SpenObjectBase> objectList) {
            Log.d(SpenInView.TAG, "onObjectChanged");
            if (SpenInView.this.nativeCanvas != 0 && SpenInView.this.mControl != null) {
                if (SpenInView.this.mControlListener != null) {
                    SpenInView.this.mControlListener.onObjectChanged(objectList);
                }
                SpenInView.this.update();
            }
        }

        @Override // com.samsung.android.sdk.pen.engine.SpenControlBase.ActionListener
        public void onVisibleUpdated(ArrayList<SpenObjectBase> objectList, boolean visible) {
            if (objectList == null) {
                Log.d(SpenInView.TAG, "onVisibleUpdated : objectList is null.");
                return;
            }
            if (objectList.size() == 0 || objectList.get(0) == null) {
                Log.d(SpenInView.TAG, "onVisibleUpdated : the size of list is zero.");
                return;
            }
            int runtimeHandle = objectList.get(0).getRuntimeHandle();
            if (visible) {
                if (!visible) {
                    return;
                }
                SpenInView.native_inVisibleUpdate(SpenInView.this.nativeCanvas, runtimeHandle, true, true);
                return;
            }
            SpenInView.native_inVisibleUpdate(SpenInView.this.nativeCanvas, runtimeHandle, false, false);
        }

        @Override // com.samsung.android.sdk.pen.engine.SpenControlBase.ActionListener
        public void onRectChanged(RectF rect, SpenObjectBase object) {
            if (SpenInView.this.mControlListener != null) {
                SpenInView.this.mControlListener.onRectChanged(rect, object);
            }
        }

        @Override // com.samsung.android.sdk.pen.engine.SpenControlBase.ActionListener
        public void onRotationChanged(float angle, SpenObjectBase object) {
            if (SpenInView.this.mControlListener != null) {
                SpenInView.this.mControlListener.onRotationChanged(angle, object);
            }
        }

        @Override // com.samsung.android.sdk.pen.engine.SpenControlBase.ActionListener
        public void onMenuSelected(ArrayList<SpenObjectBase> objectList, int itemId) {
            if (SpenInView.this.mControlListener != null) {
                SpenInView.this.mControlListener.onMenuSelected(objectList, itemId);
            }
        }

        @Override // com.samsung.android.sdk.pen.engine.SpenControlBase.ActionListener
        public void onRequestCoordinateInfo(SpenControlBase.CoordinateInfo coordinateInfo) {
            coordinateInfo.frameRect.set(SpenInView.this.mScreenStartX, SpenInView.this.mScreenStartY, SpenInView.this.mScreenStartX + SpenInView.this.mRtoBmpItstScrWidth, SpenInView.this.mScreenStartY + SpenInView.this.mRtoBmpItstScrHeight);
            coordinateInfo.pan = SpenInView.this.getPan();
            coordinateInfo.zoomRatio = SpenInView.this.getZoomRatio();
        }

        @Override // com.samsung.android.sdk.pen.engine.SpenControlBase.ActionListener
        public void onRequestScroll(float dx, float dy) {
            if (SpenInView.this.nativeCanvas != 0) {
                PointF point = new PointF();
                SpenInView.native_getPan(SpenInView.this.nativeCanvas, point);
                point.x += dx;
                point.y += dy;
                SpenInView.native_setPan(SpenInView.this.nativeCanvas, point.x, point.y, SpenInView.this.mRatio == 1.0f);
                SpenInView.this.updateScreenFrameBuffer();
            }
        }

        @Override // com.samsung.android.sdk.pen.engine.SpenControlBase.ActionListener
        public Bitmap onRequestBackground() {
            if (SpenInView.this.mView instanceof SurfaceView) {
                return SpenInView.this.captureCurrentView(true);
            }
            return null;
        }
    }

    private class DetachReceiver extends BroadcastReceiver {
        private DetachReceiver() {
        }

        /* synthetic */ DetachReceiver(SpenInView spenInView, DetachReceiver detachReceiver) {
            this();
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            boolean penInsert = intent.getBooleanExtra("penInsert", false);
            Log.d(SpenInView.TAG, "intent=" + intent.getAction() + " penInsert=" + penInsert);
            if (SpenInView.this.mPenDetachmentListener != null) {
                SpenInView.this.mPenDetachmentListener.onDetached(penInsert);
            }
        }
    }

    private class OnGestureListener implements GestureDetector.OnGestureListener {
        private OnGestureListener() {
        }

        /* synthetic */ OnGestureListener(SpenInView spenInView, OnGestureListener onGestureListener) {
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
            if (SpenInView.this.nativeCanvas != 0) {
                SpenInView.native_onSingleTapUp(SpenInView.this.nativeCanvas, e, e.getToolType(0));
            }
            return false;
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
            return false;
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public void onLongPress(MotionEvent e) {
            if (SpenInView.this.nativeCanvas != 0 && !SpenInView.this.isSkipTouch) {
                if (SpenInView.this.mLongPressListener != null) {
                    SpenInView.this.mLongPressListener.onLongPressed(e);
                }
                if (SpenInView.this.isEraserCursor) {
                    SpenInView.this.isEraserCursor = false;
                    SpenInView.this.mCircleRadius = -100.0f;
                    SpenInView.this.mRemoverRadius = -100.0f;
                    SpenInView.this.mCirclePoint.x = -100.0f;
                    SpenInView.this.mCirclePoint.y = -100.0f;
                }
                if (SpenInView.this.mSmartScaleGestureDetector != null && (SpenInView.this.mIsSmartScale || SpenInView.this.mIsSmartHorizontal || SpenInView.this.mIsSmartVertical)) {
                    float x = (e.getX() / SpenInView.this.mRatio) + SpenInView.this.mDeltaX;
                    float y = (e.getY() / SpenInView.this.mRatio) + SpenInView.this.mDeltaY;
                    if (SpenInView.this.mPageDoc != null && SpenInView.this.mPageDoc.findTopObjectAtPosition(6, x, y) != null) {
                        SpenInView.this.setZoom(SpenInView.this.mSmartScaleGestureDetector.getCenterX(), SpenInView.this.mSmartScaleGestureDetector.getCenterY(), 1.0f);
                        float rx = (x - SpenInView.this.mDeltaX) * SpenInView.this.mRatio;
                        float ry = (y - SpenInView.this.mDeltaY) * SpenInView.this.mRatio;
                        MotionEvent event = MotionEvent.obtain(e.getDownTime(), e.getEventTime(), e.getAction(), rx, ry, e.getPressure(), e.getSize(), e.getMetaState(), e.getXPrecision(), e.getYPrecision(), e.getDeviceId(), e.getEdgeFlags());
                        SpenInView.native_onLongPress(SpenInView.this.nativeCanvas, event, e.getToolType(0));
                        event.recycle();
                        return;
                    }
                    return;
                }
                SpenInView.native_onLongPress(SpenInView.this.nativeCanvas, e, e.getToolType(0));
            }
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
            if (e1 == null || SpenInView.this.getToolTypeAction(e1.getToolType(0)) != 1 || SpenInView.this.mSmartScaleGestureDetector == null) {
                return false;
            }
            SpenInView.this.mSmartScaleGestureDetector.onFling(e1, e2, velocityX, velocityY);
            return true;
        }
    }

    private class OnGestureDoubleTapListener implements GestureDetector.OnDoubleTapListener {
        private OnGestureDoubleTapListener() {
        }

        /* synthetic */ OnGestureDoubleTapListener(SpenInView spenInView, OnGestureDoubleTapListener onGestureDoubleTapListener) {
            this();
        }

        @Override // android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent e) {
            if (SpenInView.this.getToolTypeAction(e.getToolType(0)) != 2 && SpenInView.this.getToolTypeAction(e.getToolType(0)) != 3 && SpenInView.this.getToolTypeAction(e.getToolType(0)) != 4 && SpenInView.this.getToolTypeAction(e.getToolType(0)) != 5 && SpenInView.this.mControl == null) {
                Log.d(SpenInView.TAG, "one finger double tab");
                if (SpenInView.this.mRatioBitmapWidth == SpenInView.this.mScreenWidth) {
                    SpenInView.this.setZoom(e.getX(), e.getY(), (SpenInView.this.mScreenWidth * 1.5f) / SpenInView.this.mBitmapWidth);
                } else {
                    SpenInView.this.setZoom(e.getX(), e.getY(), SpenInView.this.mScreenWidth / SpenInView.this.mBitmapWidth);
                }
                SpenInView.this.updateScreenFrameBuffer();
            }
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

    private class OnScrollListener implements SpenCanvasViewScroll.Listener {
        private OnScrollListener() {
        }

        /* synthetic */ OnScrollListener(SpenInView spenInView, OnScrollListener onScrollListener) {
            this();
        }

        @Override // com.samsung.android.sdk.pen.engine.SpenCanvasViewScroll.Listener
        public void onUpdate() {
            if (SpenInView.this.getReplayState() == 0 && SpenInView.this.mSmartScaleGestureDetector != null && SpenInView.this.mSmartScaleGestureDetector.getState() != SpenSmartScaleGestureDetector.State.FLING_STATE) {
                SpenInView.this.onUpdateCanvas(null, true);
            }
        }
    }

    private class OnPageEffectListener implements SpenPageEffectHandler.Listener {
        private OnPageEffectListener() {
        }

        /* synthetic */ OnPageEffectListener(SpenInView spenInView, OnPageEffectListener onPageEffectListener) {
            this();
        }

        @Override // com.samsung.android.sdk.pen.engine.SpenPageEffectHandler.Listener
        public void onUpdateCanvasLayer(Canvas canvas) {
            SpenInView.this.updateCanvasLayer(canvas, null, false);
        }

        @Override // com.samsung.android.sdk.pen.engine.SpenPageEffectHandler.Listener
        public void onUpdateCanvasLayer2(Canvas canvas) {
            SpenInView.this.updateCanvasLayer2(canvas);
        }

        @Override // com.samsung.android.sdk.pen.engine.SpenPageEffectHandler.Listener
        public void onUpdate() {
            SpenInView.this.onUpdateCanvas(null, true);
        }

        @Override // com.samsung.android.sdk.pen.engine.SpenPageEffectHandler.Listener
        public void onFinish() {
            SpenInView.this.onUpdateCanvas(null, false);
            if (SpenInView.this.mSetPageDocHandler != null) {
                SpenInView.this.mSetPageDocHandler.sendEmptyMessage(0);
            }
            if (SpenInView.this.mPageEffectListener != null) {
                SpenInView.this.mPageEffectListener.onFinish();
            }
        }
    }

    private class OnSmartScaleGestureDetectorListener implements SpenSmartScaleGestureDetector.Listener {
        private OnSmartScaleGestureDetectorListener() {
        }

        /* synthetic */ OnSmartScaleGestureDetectorListener(SpenInView spenInView, OnSmartScaleGestureDetectorListener onSmartScaleGestureDetectorListener) {
            this();
        }

        @Override // com.samsung.android.sdk.pen.engine.SpenSmartScaleGestureDetector.Listener
        public void onChangeScale(float centerX, float centerY, float ratio) {
            if (SpenInView.this.mControl != null && SpenInView.this.mControl.getStyle() != 3) {
                SpenInView.this.closeControl();
            }
            SpenInView.this.setZoom(centerX, centerY, ratio);
        }

        @Override // com.samsung.android.sdk.pen.engine.SpenSmartScaleGestureDetector.Listener
        public void onChangePan(float x, float y) {
            if (SpenInView.this.nativeCanvas != 0) {
                if (SpenInView.this.mControl != null && SpenInView.this.mControl.getStyle() != 3) {
                    SpenInView.this.closeControl();
                }
                SpenInView.native_setPan(SpenInView.this.nativeCanvas, x, y, true);
            }
        }

        @Override // com.samsung.android.sdk.pen.engine.SpenSmartScaleGestureDetector.Listener
        public boolean onFlick(int direction) {
            Log.d(SpenInView.TAG, "onFlick direction = " + direction);
            if (SpenInView.this.mPageEffectManager == null || !SpenInView.this.mPageEffectManager.isWorking()) {
                if (SpenInView.this.mFlickListener != null) {
                    return SpenInView.this.mFlickListener.onFlick(direction);
                }
                return false;
            }
            return true;
        }

        @Override // com.samsung.android.sdk.pen.engine.SpenSmartScaleGestureDetector.Listener
        public void onUpdate() {
            SpenInView.this.onUpdateCanvas(null, true);
        }

        @Override // com.samsung.android.sdk.pen.engine.SpenSmartScaleGestureDetector.Listener
        public void onUpdateScreenFrameBuffer() {
            SpenInView.this.updateScreenFrameBuffer();
        }
    }

    private class OnTextActionListener implements SpenControlTextBox.ActionListener {
        private OnTextActionListener() {
        }

        /* synthetic */ OnTextActionListener(SpenInView spenInView, OnTextActionListener onTextActionListener) {
            this();
        }

        @Override // com.samsung.android.sdk.pen.engine.SpenControlTextBox.ActionListener
        public void onSettingTextInfoChanged(SpenSettingTextInfo info) {
            if (SpenInView.this.mTextChangeListener != null) {
                SpenInView.this.mTextChangeListener.onChanged(info, 0);
            }
        }

        @Override // com.samsung.android.sdk.pen.engine.SpenControlTextBox.ActionListener
        public boolean onSelectionChanged(int selStart, int selEnd) {
            if (SpenInView.this.mTextChangeListener != null) {
                return SpenInView.this.mTextChangeListener.onSelectionChanged(selStart, selEnd);
            }
            return true;
        }

        @Override // com.samsung.android.sdk.pen.engine.SpenControlTextBox.ActionListener
        public void onMoreButtonDown(SpenObjectTextBox object) {
            if (SpenInView.this.mTextChangeListener != null) {
                SpenInView.this.mTextChangeListener.onMoreButtonDown(object);
            }
        }

        @Override // com.samsung.android.sdk.pen.engine.SpenControlTextBox.ActionListener
        public void onFocusChanged(boolean gainFocus) {
            if (SpenInView.this.mTextChangeListener != null) {
                SpenInView.this.mTextChangeListener.onFocusChanged(gainFocus);
            }
        }
    }

    private class OnZoomPadActionListener implements SpenZoomPad.ZoomPadActionListener {
        private OnZoomPadActionListener() {
        }

        /* synthetic */ OnZoomPadActionListener(SpenInView spenInView, OnZoomPadActionListener onZoomPadActionListener) {
            this();
        }

        @Override // com.samsung.android.sdk.pen.engine.SpenZoomPad.ZoomPadActionListener
        public void onChangePan(float x, float y) {
            if (SpenInView.this.nativeCanvas == 0) {
                return;
            }
            SpenInView.native_setPan(SpenInView.this.nativeCanvas, x, y, true);
            if (SpenInView.this.mZoomPad != null) {
                SpenInView.this.mZoomPad.setPanAndZoom(SpenInView.this.mDeltaX, SpenInView.this.mDeltaY, SpenInView.this.mRatio);
            }
        }

        @Override // com.samsung.android.sdk.pen.engine.SpenZoomPad.ZoomPadActionListener
        public void onStop() {
            if (SpenInView.this.nativeCanvas != 0) {
                SpenInView.this.mScreenWidth = SpenInView.this.mLayoutWidth;
                SpenInView.this.mScreenHeight = SpenInView.this.mLayoutHeight;
                SpenInView.this.mScreenHeightExceptSIP = SpenInView.this.mLayoutExceptSIP;
                RectF rect = SpenInView.this.mZoomPad.getZoomViewRect();
                rect.top -= SpenInView.this.mScreenStartY;
                SpenInView.native_setScreenSize(SpenInView.this.nativeCanvas, SpenInView.this.mScreenWidth, SpenInView.this.mScreenHeight, SpenInView.this.mScreenHeightExceptSIP);
                if (SpenInView.this.mZoomPad != null) {
                    SpenInView.this.mZoomPad.setZoomViewPosition(rect.left, rect.top + SpenInView.this.mScreenStartY);
                }
                SpenInView.this.updateScreenFrameBuffer();
                SpenInView.this.setZoomable(SpenInView.this.mPreZoomable);
                SpenInView.this.setScrollBarEnabled(SpenInView.this.mPreScrollable);
                if (SpenInView.this.mZoomPadListener != null) {
                    SpenInView.this.mZoomPadListener.onStop();
                }
            }
        }

        @Override // com.samsung.android.sdk.pen.engine.SpenZoomPad.ZoomPadActionListener
        public void onUpdate(SpenObjectBase object) {
            if (SpenInView.this.mPageDoc != null) {
                SpenInView.this.mPageDoc.appendObject(object);
                SpenInView.this.update();
            }
        }

        @Override // com.samsung.android.sdk.pen.engine.SpenZoomPad.ZoomPadActionListener
        public void onChangeScreenSize(boolean force, int width, int height, int heightSIP) {
            if (SpenInView.this.nativeCanvas != 0) {
                float curHeight = SpenInView.this.mPageDoc.getHeight() * SpenInView.this.mRatio;
                if (SpenInView.this.mScreenStartY != 0 || curHeight <= heightSIP) {
                    SpenInView.this.mScreenHeight = heightSIP;
                    SpenInView.this.mScreenHeightExceptSIP = heightSIP;
                }
                if (SpenInView.this.mZoomPad != null) {
                    if (force) {
                        SpenInView.this.setZoomable(true);
                        SpenInView.this.setZoom(SpenInView.this.mDeltaX, SpenInView.this.mDeltaY, SpenInView.this.mScreenWidth / SpenInView.this.mBitmapWidth);
                        SpenInView.this.setZoomable(false);
                    }
                    SpenInView.native_setScreenSize(SpenInView.this.nativeCanvas, width, heightSIP, heightSIP);
                    if (force) {
                        SpenInView.this.mZoomPad.setCanvasSize(width, height, SpenInView.this.mScreenStartY, SpenInView.this.mRtoBmpItstScrHeight);
                    }
                }
                if (SpenInView.this.mScreenStartY != 0 || curHeight <= heightSIP) {
                    SpenInView.this.mScreenHeight = heightSIP;
                    SpenInView.this.mScreenHeightExceptSIP = heightSIP;
                }
            }
        }

        @Override // com.samsung.android.sdk.pen.engine.SpenZoomPad.ZoomPadActionListener
        public void onUpdateScreenFrameBuffer() {
            SpenInView.this.updateScreenFrameBuffer();
        }

        @Override // com.samsung.android.sdk.pen.engine.SpenZoomPad.ZoomPadActionListener
        public void onViewTouchEvent(MotionEvent event, RectF view, RectF bitmap) {
            float x = event.getX();
            float y = event.getY();
            int action = event.getAction() & 255;
            long downTime = event.getDownTime();
            long eventTime = event.getEventTime();
            int metaState = event.getMetaState();
            int buttonState = event.getButtonState();
            float xPrecision = event.getXPrecision();
            float yPrecision = event.getYPrecision();
            int deviceId = event.getDeviceId();
            int edgeFlags = event.getEdgeFlags();
            int source = event.getSource();
            int flags = event.getFlags();
            MotionEvent.PointerProperties[] pp = {new MotionEvent.PointerProperties()};
            pp[0].toolType = event.getToolType(0);
            MotionEvent.PointerCoords[] pc = {new MotionEvent.PointerCoords()};
            pp[0].id = 0;
            pc[0].x = ((x - bitmap.left) * (view.width() / bitmap.width())) + view.left;
            pc[0].y = (((y - bitmap.top) * (view.height() / bitmap.height())) + view.top) - SpenInView.this.mScreenStartY;
            MotionEvent ev = MotionEvent.obtain(downTime, eventTime, action, 1, pp, pc, metaState, buttonState, xPrecision, yPrecision, deviceId, edgeFlags, source, flags);
            SpenInView.native_onTouch(SpenInView.this.nativeCanvas, ev, ev.getToolType(0));
            ev.recycle();
        }
    }

    static class SPenHoverPointerIconWrapper {
        private Class<?> mKlass;
        private Method mRemoveHoveringSpenCustomIcon;
        private Method mSetHoveringSpenIcon;
        private Method mSetHoveringSpenIcon2;

        public SPenHoverPointerIconWrapper() {
            try {
                this.mKlass = Class.forName("android.view.PointerIcon");
            } catch (ClassNotFoundException e) {
            }
        }

        public int setHoveringSpenIcon(int iconType, Drawable d) throws IllegalAccessException, NoSuchMethodException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
            if (this.mSetHoveringSpenIcon == null) {
                Class[] paramTypes = {Integer.TYPE, Drawable.class};
                this.mSetHoveringSpenIcon = this.mKlass.getMethod("setHoveringSpenIcon", paramTypes);
            }
            Object[] parameters = {Integer.valueOf(iconType), d};
            Integer rt = (Integer) this.mSetHoveringSpenIcon.invoke(null, parameters);
            return rt.intValue();
        }

        public void setHoveringSpenIcon(int iconType) throws IllegalAccessException, NoSuchMethodException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
            if (this.mSetHoveringSpenIcon2 == null) {
                Class[] paramTypes = {Integer.TYPE, Integer.TYPE};
                this.mSetHoveringSpenIcon2 = this.mKlass.getMethod("setHoveringSpenIcon", paramTypes);
            }
            Object[] parameters = {Integer.valueOf(iconType), -1};
            this.mSetHoveringSpenIcon2.invoke(null, parameters);
        }

        public void removeHoveringSpenCustomIcon(int customIconId) throws IllegalAccessException, NoSuchMethodException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
            if (this.mRemoveHoveringSpenCustomIcon == null) {
                Class[] paramTypes = {Integer.TYPE};
                this.mRemoveHoveringSpenCustomIcon = this.mKlass.getMethod("removeHoveringSpenCustomIcon", paramTypes);
            }
            Object[] parameters = {Integer.valueOf(customIconId)};
            this.mRemoveHoveringSpenCustomIcon.invoke(null, parameters);
        }
    }

    private static class TouchUpHandler extends Handler {
        private final WeakReference<SpenInView> mSpenView;

        TouchUpHandler(SpenInView view) {
            this.mSpenView = new WeakReference<>(view);
        }

        @Override // android.os.Handler
        public void handleMessage(Message msg) {
            SpenInView spenView = this.mSpenView.get();
            if (spenView != null && spenView.mSmartScaleGestureDetector != null && spenView.mSmartScaleGestureDetector.getState() != SpenSmartScaleGestureDetector.State.FLING_STATE && spenView.mPageEffectManager != null && !spenView.mPageEffectManager.isWorking()) {
                spenView.updateScreenFrameBuffer();
            }
        }
    }

    private static class SetPageDocHandler extends Handler {
        private final WeakReference<SpenInView> mSpenView;

        SetPageDocHandler(SpenInView view) {
            this.mSpenView = new WeakReference<>(view);
        }

        @Override // android.os.Handler
        public void handleMessage(Message msg) {
            SpenInView spenView = this.mSpenView.get();
            if (spenView != null) {
                spenView.updateScreenFrameBuffer();
                spenView.onUpdateCanvas(null, true);
            }
        }
    }

    private String getResourceString(String strName) throws Resources.NotFoundException {
        String string = null;
        if (this.mSdkResources != null) {
            int resId = this.mSdkResources.getIdentifier(strName, VLConfigParser.TYPE_STRING, Spen.SPEN_NATIVE_PACKAGE_NAME);
            if (resId == 0) {
                return null;
            }
            string = this.mSdkResources.getString(resId);
        }
        return string;
    }

    private void onShowRemoverMessage() {
        Log.d(TAG, "onShowRemoverMessage");
        this.mRemoverToastMessage.cancel();
        this.mRemoverToastMessage = Toast.makeText(this.mContext, getResourceString("string_unable_to_erase_heavy_lines"), 0);
        this.mRemoverToastMessage.show();
    }
}
