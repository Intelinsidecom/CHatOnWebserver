package com.samsung.android.sdk.pen.engine;

import android.R;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.SparseIntArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.samsung.android.sdk.pen.Spen;
import com.samsung.android.sdk.pen.SpenSettingPenInfo;
import com.samsung.android.sdk.pen.SpenSettingRemoverInfo;
import com.samsung.android.sdk.pen.document.SpenObjectBase;
import com.samsung.android.sdk.pen.document.SpenObjectStroke;
import com.samsung.android.sdk.pen.pen.SpenPen;
import com.samsung.android.sdk.pen.pen.SpenPenManager;
import com.samsung.android.sdk.pen.util.SpenError;
import com.samsung.android.sdk.pen.util.SpenScreenCodecDecoder;
import com.vlingo.sdk.internal.vlservice.config.VLConfigParser;
import com.vlingo.sdk.recognition.spotter.VLSpotterContext;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

/* loaded from: classes.dex */
class SpenZoomPad extends View {
    public static final int ACTION_STROKE_REMOVER = 4;
    private static final String TAG = "ZoomPad";
    private static final int ZOOMPAD_BAR_BUTTON_WIDTH = 36;
    private static final int ZOOMPAD_BAR_COLOR = -12104889;
    private static final int ZOOMPAD_BAR_SIZE = 34;
    private static final int ZOOMPAD_BG_COLOR = -8684677;
    private static final int ZOOMPAD_MOVING_RECT_COLOR = 1199164146;
    private static final int ZOOMPAD_STATE_BTN_ENTER = 7;
    private static final int ZOOMPAD_STATE_BTN_LEFT = 5;
    private static final int ZOOMPAD_STATE_BTN_RIGHT = 6;
    private static final int ZOOMPAD_STATE_DRAW = 8;
    private static final int ZOOMPAD_STATE_NONE = 0;
    private static final int ZOOMPAD_STATE_PAD_MOVE = 3;
    private static final int ZOOMPAD_STATE_PAD_MOVING_RECT = 4;
    private static final int ZOOMPAD_STATE_VIEW_MOVE = 1;
    private static final int ZOOMPAD_STATE_VIEW_RESIZE = 2;
    private static final int ZOOMPAD_VIEW_LINE_COLOR = -16020522;
    private static final int ZOOMVIEW_RESIZE = 17;
    private boolean isEraserCursor;
    private ZoomPadActionListener mActionListener;
    private Paint mAntiAliasPaint;
    private ArrayList<Bitmap> mCanvasLayer;
    private Paint mCirclePaint;
    private final PointF mCirclePoint;
    private ImageButton mCloseButton;
    private Context mContext;
    private SpenPen mCurrentPen;
    private float mDeltaX;
    private float mDeltaY;
    private ImageButton mEnterButton;
    private ImageButton mLeftButton;
    private float mOnePT;
    private ViewGroup mParentView;
    private SpenPenManager mPenManager;
    private String mPenName;
    private float mPenSize;
    private float mRatio;
    private RelativeLayout mRelative;
    private float mRemoverRadius;
    private SpenSettingRemoverInfo mRemoverSettingInfo;
    private ImageButton mRightButton;
    private int mRtoBmpItstScrHeight;
    private int mScreenHeight;
    private int mScreenHeightExceptSIP;
    private int mScreenStartY;
    private int mScreenWidth;
    private Resources mSdkResources;
    private Paint mSrcPaint;
    private SpenObjectStroke mStroke;
    private final RectF mTempRect;
    private SparseIntArray mToolAndActionMap;
    private Rect mZoomPadBarImageRect;
    private Rect mZoomPadBarMovingRect;
    private Rect mZoomPadBarRect;
    private Bitmap[] mZoomPadBitmap;
    private RectF mZoomPadBitmapRect;
    private boolean mZoomPadEnabled;
    private Rect mZoomPadHandleRect;
    private ZoomPadHandler mZoomPadHandler;
    private Paint mZoomPadLinePaint;
    private Rect mZoomPadMovingRect;
    private Paint mZoomPadPaint;
    private PointF mZoomPadPrePoint;
    private RectF mZoomPadRect;
    private int mZoomPadScrollLimit;
    private int mZoomPadState;
    private Paint mZoomViewPaint;
    private RectF mZoomViewRect;
    private RectF mZoomViewSaveRect;

    public interface ZoomPadActionListener {
        void onChangePan(float f, float f2);

        void onChangeScreenSize(boolean z, int i, int i2, int i3);

        void onStop();

        void onUpdate(SpenObjectBase spenObjectBase);

        void onUpdateScreenFrameBuffer();

        void onViewTouchEvent(MotionEvent motionEvent, RectF rectF, RectF rectF2);
    }

    public SpenZoomPad(Context context) {
        super(context);
        this.mSdkResources = null;
        this.mOnePT = VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET;
        this.mZoomPadState = 0;
        this.mZoomPadEnabled = false;
        this.mZoomPadPrePoint = null;
        this.mZoomPadHandler = null;
        this.mLeftButton = null;
        this.mRightButton = null;
        this.mEnterButton = null;
        this.mCloseButton = null;
        this.mParentView = null;
        this.mToolAndActionMap = new SparseIntArray(10);
        this.mCanvasLayer = null;
        this.mSrcPaint = null;
        this.mAntiAliasPaint = null;
        this.mScreenWidth = 0;
        this.mScreenHeight = 0;
        this.mScreenHeightExceptSIP = 0;
        this.mScreenStartY = 0;
        this.mRtoBmpItstScrHeight = 0;
        this.mDeltaX = VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET;
        this.mDeltaY = VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET;
        this.mRatio = 1.0f;
        this.mPenSize = VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET;
        this.mPenManager = null;
        this.mCurrentPen = null;
        this.mRemoverSettingInfo = null;
        this.mCirclePaint = null;
        this.mCirclePoint = new PointF(-100.0f, -100.0f);
        this.mRemoverRadius = VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET;
        this.isEraserCursor = false;
        DisplayMetrics mDisplayMetrics = context.getResources().getDisplayMetrics();
        this.mOnePT = mDisplayMetrics.density;
        this.mZoomPadBitmap = new Bitmap[5];
        this.mZoomViewPaint = new Paint();
        this.mZoomViewPaint.setStyle(Paint.Style.STROKE);
        this.mZoomViewPaint.setStrokeWidth(2.0f * this.mOnePT);
        this.mZoomViewPaint.setColor(ZOOMPAD_VIEW_LINE_COLOR);
        this.mZoomPadPaint = new Paint();
        this.mZoomPadLinePaint = new Paint();
        this.mZoomPadLinePaint.setStyle(Paint.Style.STROKE);
        this.mZoomPadLinePaint.setStrokeWidth(4.0f * this.mOnePT);
        this.mZoomPadLinePaint.setColor(ZOOMPAD_BAR_COLOR);
        this.mZoomViewRect = new RectF();
        this.mZoomViewSaveRect = new RectF();
        this.mZoomPadBitmapRect = new RectF();
        this.mZoomPadRect = new RectF();
        this.mZoomPadMovingRect = new Rect();
        this.mZoomPadBarRect = new Rect();
        this.mZoomPadBarMovingRect = new Rect();
        this.mZoomPadBarImageRect = new Rect();
        this.mZoomPadHandleRect = new Rect();
        this.mTempRect = new RectF();
        this.mZoomPadPrePoint = new PointF();
        this.mZoomPadHandler = new ZoomPadHandler(this);
        this.mSrcPaint = new Paint();
        this.mSrcPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC));
        this.mSrcPaint.setAntiAlias(true);
        this.mSrcPaint.setFilterBitmap(true);
        this.mAntiAliasPaint = new Paint();
        this.mAntiAliasPaint.setAntiAlias(true);
        this.mAntiAliasPaint.setFilterBitmap(true);
        this.mCirclePaint = new Paint();
        this.mCirclePaint.setAntiAlias(true);
        this.mCirclePaint.setStyle(Paint.Style.STROKE);
        this.mCirclePaint.setColor(-16777216);
        try {
            PackageManager manager = context.getPackageManager();
            this.mSdkResources = manager.getResourcesForApplication(Spen.SPEN_NATIVE_PACKAGE_NAME);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        this.mPenManager = new SpenPenManager(context);
        this.mContext = context;
    }

    public void close() {
        if (this.mZoomPadBitmap != null) {
            for (Bitmap bitmap : this.mZoomPadBitmap) {
                if (bitmap != null && !bitmap.isRecycled()) {
                    bitmap.recycle();
                }
            }
            this.mZoomPadBitmap = null;
        }
        if (this.mRelative != null) {
            if (Build.VERSION.SDK_INT < 16) {
                this.mLeftButton.setBackgroundDrawable(null);
            } else {
                this.mLeftButton.setBackground(null);
            }
            if (Build.VERSION.SDK_INT < 16) {
                this.mRightButton.setBackgroundDrawable(null);
            } else {
                this.mRightButton.setBackground(null);
            }
            if (Build.VERSION.SDK_INT < 16) {
                this.mEnterButton.setBackgroundDrawable(null);
            } else {
                this.mEnterButton.setBackground(null);
            }
            if (Build.VERSION.SDK_INT < 16) {
                this.mCloseButton.setBackgroundDrawable(null);
            } else {
                this.mCloseButton.setBackground(null);
            }
            this.mLeftButton = null;
            this.mRightButton = null;
            this.mEnterButton = null;
            this.mCloseButton = null;
            this.mRelative.removeAllViews();
            this.mRelative = null;
        }
        this.mZoomViewPaint = null;
        this.mZoomPadPaint = null;
        this.mZoomPadLinePaint = null;
        this.mZoomViewRect = null;
        this.mZoomViewSaveRect = null;
        this.mZoomPadBitmapRect = null;
        this.mZoomPadRect = null;
        this.mZoomPadMovingRect = null;
        this.mZoomPadBarRect = null;
        this.mZoomPadBarMovingRect = null;
        this.mZoomPadBarImageRect = null;
        this.mZoomPadHandleRect = null;
        this.mZoomPadHandler = null;
        this.mZoomPadPrePoint = null;
        this.mStroke = null;
        if (this.mPenManager != null) {
            if (this.mCurrentPen != null) {
                this.mPenManager.destroyPen(this.mCurrentPen);
                this.mCurrentPen = null;
            }
            this.mPenManager.close();
            this.mPenManager = null;
        }
        if (this.mToolAndActionMap != null) {
            this.mToolAndActionMap.clear();
            this.mToolAndActionMap = null;
        }
        this.mContext = null;
        this.mSdkResources = null;
        this.mActionListener = null;
        this.mCanvasLayer = null;
        this.mSrcPaint = null;
        this.mAntiAliasPaint = null;
    }

    public void setLayer(ArrayList<Bitmap> canvasLayer) {
        this.mCanvasLayer = canvasLayer;
    }

    public void setCanvasSize(int width, int height, int y, int rtoHeight) {
        this.mScreenWidth = width;
        this.mScreenHeight = height;
        this.mScreenStartY = y;
        this.mRtoBmpItstScrHeight = rtoHeight;
    }

    public void setPanAndZoom(float x, float y, float ratio) {
        Log.d(TAG, "[" + x + " " + y + "], ratio=" + ratio);
        this.mDeltaX = x;
        this.mDeltaY = y;
        this.mRatio = ratio;
    }

    public void setZoomViewPosition(float x, float y) {
        Log.d(TAG, "setZoomViewPosition=[" + x + ", " + y + "]");
        this.mZoomViewRect.left = x;
        this.mZoomViewRect.top = y;
    }

    public RectF getZoomViewRect() {
        return this.mZoomViewRect;
    }

    public void setPenSettingInfo(SpenSettingPenInfo info) {
        if (this.mPenManager != null) {
            try {
                this.mPenName = info.name;
                if (this.mCurrentPen != null) {
                    this.mPenManager.destroyPen(this.mCurrentPen);
                }
                this.mCurrentPen = this.mPenManager.createPen(info.name);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e2) {
                e2.printStackTrace();
            } catch (InstantiationException e3) {
                e3.printStackTrace();
            } catch (Exception e4) {
                e4.printStackTrace();
            }
            this.mCurrentPen.setBitmap(this.mZoomPadBitmap[4]);
            this.mCurrentPen.setColor(info.color);
            this.mPenSize = info.size;
            this.mCurrentPen.setSize(info.size * this.mRatio * (this.mZoomPadBitmapRect.height() / this.mZoomViewRect.height()));
            if (this.mCurrentPen.getPenAttribute(3)) {
                this.mCurrentPen.setCurveEnabled(info.isCurvable);
            }
            if (this.mCurrentPen.getPenAttribute(4)) {
                this.mCurrentPen.setAdvancedSetting(info.advancedSetting);
            }
        }
    }

    public void setRemoverSettingInfo(SpenSettingRemoverInfo info) {
        this.mRemoverSettingInfo = info;
    }

    public int getZoomPadHeight() {
        return (int) this.mZoomPadBitmapRect.top;
    }

    public void setToolTypeAction(int toolType, int action) {
        this.mToolAndActionMap.put(toolType, action);
    }

    public void startZoomPad(ViewGroup view) {
        Log.d(TAG, "startZoomPad");
        if (!this.mZoomPadEnabled) {
            this.mParentView = view;
            this.mZoomPadBitmap[0] = getResourceBitmap("zoompad_button");
            this.mZoomPadBitmap[1] = getResourceBitmap("zoompad_handle_bottom");
            this.mZoomPadBitmap[2] = getResourceBitmap("zoompad_selected_handle_normal");
            this.mZoomPadBitmap[3] = getResourceBitmap("zoompad_selected_handle_press");
            this.mZoomPadEnabled = true;
            onFit();
            setZoomPadView();
            if (this.mParentView != null) {
                this.mParentView.addView(this);
                this.mParentView.addView(this.mRelative);
            }
            updateZoomView(true);
            updateFrameBuffer(false);
        }
    }

    public void stopZoomPad() {
        Log.d(TAG, "stopZoomPad");
        if (this.mZoomPadEnabled) {
            if (this.mParentView != null) {
                this.mParentView.removeView(this.mRelative);
                this.mParentView.removeView(this);
            }
            if (this.mZoomPadBitmap != null) {
                for (Bitmap bitmap : this.mZoomPadBitmap) {
                    if (bitmap != null && !bitmap.isRecycled()) {
                        bitmap.recycle();
                    }
                }
            }
            if (this.mActionListener != null) {
                this.mActionListener.onStop();
            }
            this.mZoomPadEnabled = false;
        }
    }

    public boolean isZoomPadEnabled() {
        return this.mZoomPadEnabled;
    }

    public void setActionListener(ZoomPadActionListener listener) {
        this.mActionListener = listener;
    }

    public void updateFrameBuffer(boolean isUpdate) {
        if (!this.mZoomPadBitmap[4].isRecycled()) {
            Canvas canvas = new Canvas(this.mZoomPadBitmap[4]);
            canvas.drawColor(0, PorterDuff.Mode.CLEAR);
            RectF abRectF = new RectF();
            absoluteCoordinate(abRectF, this.mZoomViewRect);
            Rect abRect = new Rect();
            ExtendRectFromRectF(abRect, abRectF);
            RectF dstRect = new RectF();
            dstRect.set(VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, this.mZoomPadBitmapRect.width(), this.mZoomPadBitmapRect.height());
            for (int layer = 0; layer < this.mCanvasLayer.size(); layer++) {
                Bitmap bitmap = this.mCanvasLayer.get(layer);
                if (bitmap != null) {
                    bitmap.setPixel(0, 0, bitmap.getPixel(0, 0));
                    if (layer == 0) {
                        canvas.drawBitmap(bitmap, abRect, MakeNewExtendRect(dstRect), this.mSrcPaint);
                    } else {
                        canvas.drawBitmap(bitmap, abRect, MakeNewExtendRect(dstRect), this.mAntiAliasPaint);
                    }
                }
            }
            if (isUpdate) {
                invalidate();
            }
        }
    }

    private void updateZoomPad(Canvas canvas) {
        if (this.mZoomPadEnabled) {
            Rect srcRect = new Rect((int) (this.mZoomViewRect.right - (this.mOnePT * 17.0f)), (int) (this.mZoomViewRect.bottom - (this.mOnePT * 17.0f)), (int) this.mZoomViewRect.right, (int) this.mZoomViewRect.bottom);
            if (this.mZoomPadState != 2) {
                canvas.drawBitmap(this.mZoomPadBitmap[2], (Rect) null, srcRect, this.mAntiAliasPaint);
            } else {
                canvas.drawBitmap(this.mZoomPadBitmap[3], (Rect) null, srcRect, this.mAntiAliasPaint);
            }
            canvas.drawRect(this.mZoomViewRect, this.mZoomViewPaint);
            if (!this.mZoomPadBitmap[4].isRecycled()) {
                this.mZoomPadBitmap[4].setPixel(0, 0, this.mZoomPadBitmap[4].getPixel(0, 0));
                canvas.drawBitmap(this.mZoomPadBitmap[4], (Rect) null, MakeNewExtendRect(this.mZoomPadBitmapRect), this.mSrcPaint);
            }
            if (this.mRemoverRadius > VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET) {
                canvas.drawCircle(this.mCirclePoint.x, this.mCirclePoint.y, this.mRemoverRadius, this.mCirclePaint);
            }
            this.mZoomPadPaint.setColor(ZOOMPAD_BAR_COLOR);
            canvas.drawRect(this.mZoomPadBarRect, this.mZoomPadPaint);
            this.mZoomPadPaint.setColor(ZOOMPAD_MOVING_RECT_COLOR);
            canvas.drawRect(this.mZoomPadMovingRect, this.mZoomPadPaint);
            canvas.drawBitmap(this.mZoomPadBitmap[1], (Rect) null, this.mZoomPadHandleRect, this.mAntiAliasPaint);
            canvas.drawRect(this.mZoomPadBitmapRect, this.mZoomPadLinePaint);
            canvas.drawRect(this.mZoomPadRect, this.mZoomPadLinePaint);
            canvas.drawBitmap(this.mZoomPadBitmap[0], (Rect) null, this.mZoomPadBarMovingRect, this.mAntiAliasPaint);
            if (this.mZoomPadBitmapRect.bottom < this.mScreenHeight - (this.mOnePT * 2.0f)) {
                srcRect.set(0, (int) (this.mZoomPadBitmapRect.bottom + (this.mOnePT * 2.0f)), this.mScreenWidth, this.mScreenHeight);
                this.mZoomPadPaint.setColor(ZOOMPAD_BG_COLOR);
                this.mZoomPadPaint.setAlpha(77);
                canvas.drawRect(srcRect, this.mZoomPadPaint);
                this.mZoomPadPaint.setAlpha(255);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateButton() {
        if (this.mRelative != null) {
            RelativeLayout.LayoutParams totalLayoutParams = new RelativeLayout.LayoutParams(this.mZoomPadBarImageRect.width(), this.mZoomPadBarImageRect.height());
            totalLayoutParams.leftMargin = this.mZoomPadBarImageRect.left;
            totalLayoutParams.topMargin = this.mZoomPadBarImageRect.top;
            this.mRelative.setLayoutParams(totalLayoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateZoomView(boolean force) {
        float width = this.mZoomViewRect.width();
        float height = this.mZoomViewRect.height();
        if (height < this.mOnePT * 20.0f) {
            height = 20.0f * this.mOnePT;
        }
        if (this.mZoomViewRect.top < this.mScreenStartY) {
            this.mZoomViewRect.top = this.mScreenStartY + this.mOnePT;
            this.mZoomViewRect.bottom = this.mScreenStartY + height + this.mOnePT;
        }
        if (this.mScreenStartY != 0 && this.mZoomViewRect.bottom > this.mScreenStartY + this.mRtoBmpItstScrHeight) {
            this.mZoomViewRect.top = ((this.mScreenStartY + this.mRtoBmpItstScrHeight) - this.mZoomViewRect.height()) - this.mOnePT;
            this.mZoomViewRect.bottom = (this.mScreenStartY + this.mRtoBmpItstScrHeight) - this.mOnePT;
        } else if (this.mZoomViewRect.bottom > this.mZoomPadBarRect.top - (this.mOnePT * 4.0f)) {
            this.mZoomViewRect.top = (this.mZoomPadBarRect.top - height) - (this.mOnePT * 2.0f);
            this.mZoomViewRect.bottom = this.mZoomPadBarRect.top - (this.mOnePT * 2.0f);
        }
        if (force) {
            if (this.mScreenWidth <= this.mScreenHeight) {
                this.mZoomViewRect.right = this.mZoomViewRect.left + (this.mZoomPadBitmapRect.width() / 4.0f);
                this.mZoomViewRect.bottom = this.mZoomViewRect.top + (this.mZoomPadBitmapRect.height() / 4.0f);
            } else {
                this.mZoomViewRect.right = this.mZoomViewRect.left + (this.mZoomPadBitmapRect.width() / 5.0f);
                this.mZoomViewRect.bottom = this.mZoomViewRect.top + (this.mZoomPadBitmapRect.height() / 5.0f);
            }
        }
        if (this.mZoomViewRect.left < VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET) {
            this.mZoomViewRect.left = this.mOnePT;
            this.mZoomViewRect.right = this.mOnePT + width;
        }
        if (this.mZoomViewRect.right > this.mScreenWidth) {
            this.mZoomViewRect.left = (this.mScreenWidth - width) - this.mOnePT;
            this.mZoomViewRect.right = this.mScreenWidth - this.mOnePT;
        }
        this.mZoomViewSaveRect.set(this.mZoomViewRect);
    }

    private void onFit() {
        if (this.mActionListener != null) {
            this.mScreenHeightExceptSIP = setZoomPadSize(this.mScreenWidth, this.mScreenHeight);
            this.mZoomViewRect.top -= this.mScreenStartY;
            this.mZoomViewRect.bottom -= this.mScreenStartY;
            this.mActionListener.onChangeScreenSize(true, this.mScreenWidth, this.mScreenHeight, this.mScreenHeightExceptSIP);
            this.mActionListener.onUpdateScreenFrameBuffer();
            this.mZoomViewRect.top += this.mScreenStartY;
            this.mZoomViewRect.bottom += this.mScreenStartY;
            if (this.mScreenStartY != 0) {
                this.mActionListener.onChangePan(this.mDeltaX, (this.mDeltaY + this.mScreenHeight) - this.mScreenHeightExceptSIP);
            } else {
                this.mActionListener.onChangePan(this.mDeltaX, this.mDeltaY);
            }
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        updateZoomPad(canvas);
    }

    @Override // android.view.View
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        int w = right - left;
        int h = bottom - top;
        if (this.mScreenWidth != w || this.mScreenHeight != h) {
            Log.d(TAG, "onLayout [" + (right - left) + ", " + (bottom - top) + "]");
            this.mScreenWidth = w;
            this.mScreenHeight = h;
            onFit();
            Handler handler = new Handler();
            handler.postDelayed(new Runnable() { // from class: com.samsung.android.sdk.pen.engine.SpenZoomPad.1
                @Override // java.lang.Runnable
                public void run() {
                    SpenZoomPad.this.updateButton();
                    SpenZoomPad.this.updateZoomView(true);
                    SpenZoomPad.this.updateFrameBuffer(true);
                    if (SpenZoomPad.this.mCurrentPen != null) {
                        SpenZoomPad.this.mCurrentPen.setSize(SpenZoomPad.this.mPenSize * SpenZoomPad.this.mRatio * (SpenZoomPad.this.mZoomPadBitmapRect.height() / SpenZoomPad.this.mZoomViewRect.height()));
                    }
                }
            }, 0L);
        }
        super.onLayout(changed, left, top, right, bottom);
    }

    private boolean onTouchZoomPad(MotionEvent event) {
        float x = event.getX();
        float y = event.getY();
        float dx = this.mZoomPadPrePoint.x - x;
        float dy = this.mZoomPadPrePoint.y - y;
        RectF tmpRect = new RectF();
        int action = event.getAction() & 255;
        switch (action) {
            case 0:
                this.mZoomPadHandler.setMovingEnabled(false);
                this.mZoomPadHandler.removeMessages(1);
                this.mZoomPadState = 0;
                this.mZoomPadPrePoint.x = event.getX();
                this.mZoomPadPrePoint.y = event.getY();
                if (!this.mZoomPadRect.contains(x, y)) {
                    tmpRect.set(this.mZoomViewRect.right - (17.0f * this.mOnePT), this.mZoomViewRect.bottom - (17.0f * this.mOnePT), this.mZoomViewRect.right, this.mZoomViewRect.bottom);
                    if (tmpRect.contains(x, y)) {
                        Log.d(TAG, "ZoomView resize contains");
                        this.mZoomPadState = 2;
                        break;
                    } else if (this.mZoomViewRect.contains(x, y)) {
                        Log.d(TAG, "ZoomView contains");
                        this.mZoomPadState = 1;
                        break;
                    }
                } else if (this.mZoomPadBarMovingRect.contains((int) x, (int) y)) {
                    Log.d(TAG, "ZoomPadBar contains");
                    this.mZoomPadState = 3;
                    this.mTempRect.top = this.mZoomViewRect.top - this.mScreenStartY;
                    this.mTempRect.bottom = this.mZoomViewRect.bottom - this.mScreenStartY;
                    break;
                } else if (this.mZoomPadHandleRect.contains((int) x, (int) y)) {
                    Log.d(TAG, "ZoomPadMovingRect contains");
                    this.mZoomPadState = 4;
                    break;
                } else {
                    this.mZoomPadState = 8;
                    break;
                }
                break;
            case 1:
                if (this.mZoomPadState == 1) {
                    Log.d(TAG, "ZoomView moving=[" + this.mZoomViewRect.top + ", " + this.mZoomViewRect.bottom + "] [" + x + ", " + y + "]");
                    if (y > this.mZoomPadBarRect.top && this.mActionListener != null) {
                        this.mActionListener.onChangePan(this.mDeltaX, (this.mDeltaY + y) - this.mZoomPadBarRect.top);
                        updateFrameBuffer(true);
                    } else if (y < this.mScreenStartY && this.mActionListener != null) {
                        this.mActionListener.onChangePan(this.mDeltaX, this.mDeltaY + y);
                        updateFrameBuffer(true);
                    }
                }
                if (this.mZoomPadState == 3) {
                    if (this.mScreenStartY != 0 || this.mRtoBmpItstScrHeight <= this.mZoomPadBitmapRect.top) {
                        if (this.mZoomPadBitmapRect.top - (34.0f * this.mOnePT) < this.mRtoBmpItstScrHeight) {
                            int bitmapHeight = (int) this.mZoomPadBitmapRect.height();
                            int movingHeight = this.mZoomPadMovingRect.height();
                            int movingRectHeight = this.mZoomPadBarMovingRect.height();
                            int barHeight = this.mZoomPadBarRect.height();
                            int imageHeight = this.mZoomPadBarImageRect.height();
                            this.mZoomPadBitmapRect.top = ((int) (34.0f * this.mOnePT)) + this.mRtoBmpItstScrHeight;
                            this.mZoomPadBitmapRect.bottom = ((int) (34.0f * this.mOnePT)) + this.mRtoBmpItstScrHeight + bitmapHeight;
                            this.mZoomPadMovingRect.top = ((int) (34.0f * this.mOnePT)) + this.mRtoBmpItstScrHeight;
                            this.mZoomPadMovingRect.bottom = ((int) (34.0f * this.mOnePT)) + this.mRtoBmpItstScrHeight + movingHeight;
                            this.mZoomPadBarMovingRect.top = this.mRtoBmpItstScrHeight;
                            this.mZoomPadBarMovingRect.bottom = this.mRtoBmpItstScrHeight + movingRectHeight;
                            this.mZoomPadBarRect.top = this.mRtoBmpItstScrHeight;
                            this.mZoomPadBarRect.bottom = this.mRtoBmpItstScrHeight + barHeight;
                            this.mZoomPadBarImageRect.top = this.mRtoBmpItstScrHeight;
                            this.mZoomPadBarImageRect.bottom = this.mRtoBmpItstScrHeight + imageHeight;
                            this.mZoomPadRect.top = this.mZoomPadBitmapRect.top - (34.0f * this.mOnePT);
                            this.mZoomPadRect.bottom = this.mZoomPadBitmapRect.bottom;
                            this.mZoomPadHandleRect.set(this.mZoomPadMovingRect.left - ((int) (13.0f * this.mOnePT)), this.mZoomPadMovingRect.bottom - ((int) (29.0f * this.mOnePT)), this.mZoomPadMovingRect.left + ((int) (13.0f * this.mOnePT)), this.mZoomPadMovingRect.bottom);
                            updateButton();
                        }
                        if (this.mActionListener != null) {
                            this.mActionListener.onChangeScreenSize(true, this.mScreenWidth, this.mScreenHeight, (int) this.mZoomPadRect.top);
                            this.mActionListener.onUpdateScreenFrameBuffer();
                        }
                        this.mZoomViewRect.top = this.mTempRect.top + this.mScreenStartY;
                        this.mZoomViewRect.bottom = this.mTempRect.bottom + this.mScreenStartY;
                    }
                    updateZoomView(false);
                    updateFrameBuffer(true);
                    break;
                }
                break;
            case 2:
                switch (this.mZoomPadState) {
                    case 1:
                        Log.d(TAG, "ZoomView moving x=" + x + " y=" + y);
                        this.mZoomViewRect.left -= dx;
                        this.mZoomViewRect.right -= dx;
                        this.mZoomViewRect.top -= dy;
                        this.mZoomViewRect.bottom -= dy;
                        updateZoomView(false);
                        this.mZoomViewSaveRect.set(this.mZoomViewRect);
                        updateFrameBuffer(true);
                        break;
                    case 2:
                        Log.d(TAG, "Zoom view resize x=" + x + " y=" + y);
                        float ratio = this.mZoomPadBitmapRect.height() / this.mZoomPadBitmapRect.width();
                        this.mZoomViewRect.right -= dx;
                        this.mZoomViewRect.bottom -= dx * ratio;
                        Log.d(TAG, "Zoom view resize ratio=" + ratio + " right=" + this.mZoomViewRect.right + " bottom=" + this.mZoomViewRect.bottom);
                        if (this.mZoomViewRect.right < this.mZoomViewRect.left + (this.mZoomPadBitmapRect.width() / 4.0f)) {
                            this.mZoomViewRect.right = this.mZoomViewRect.left + (this.mZoomPadBitmapRect.width() / 4.0f);
                        }
                        if (this.mZoomViewRect.bottom < this.mZoomViewRect.top + (this.mZoomPadBitmapRect.height() / 4.0f)) {
                            this.mZoomViewRect.bottom = this.mZoomViewRect.top + (this.mZoomPadBitmapRect.height() / 4.0f);
                        }
                        if (this.mCurrentPen != null) {
                            this.mCurrentPen.setSize(this.mPenSize * this.mRatio * (this.mZoomPadBitmapRect.height() / this.mZoomViewRect.height()));
                            break;
                        }
                        break;
                    case 3:
                        Log.d(TAG, "ZoomPadBar moving x=" + x + " y=" + y);
                        int bitmapHeight2 = (int) this.mZoomPadBitmapRect.height();
                        this.mZoomPadBitmapRect.top -= (int) dy;
                        this.mZoomPadBitmapRect.bottom -= (int) dy;
                        int movingHeight2 = this.mZoomPadMovingRect.height();
                        this.mZoomPadMovingRect.top -= (int) dy;
                        this.mZoomPadMovingRect.bottom -= (int) dy;
                        int movingRectHeight2 = this.mZoomPadBarMovingRect.height();
                        this.mZoomPadBarMovingRect.top -= (int) dy;
                        this.mZoomPadBarMovingRect.bottom -= (int) dy;
                        int barHeight2 = this.mZoomPadBarRect.height();
                        this.mZoomPadBarRect.top -= (int) dy;
                        this.mZoomPadBarRect.bottom -= (int) dy;
                        int imageHeight2 = this.mZoomPadBarImageRect.height();
                        this.mZoomPadBarImageRect.top -= (int) dy;
                        this.mZoomPadBarImageRect.bottom -= (int) dy;
                        if (this.mZoomPadBitmapRect.top - (34.0f * this.mOnePT) < this.mZoomPadScrollLimit) {
                            this.mZoomPadBitmapRect.top = (34.0f * this.mOnePT) + this.mZoomPadScrollLimit;
                            this.mZoomPadBitmapRect.bottom = (34.0f * this.mOnePT) + this.mZoomPadScrollLimit + bitmapHeight2;
                            this.mZoomPadMovingRect.top = (int) ((34.0f * this.mOnePT) + this.mZoomPadScrollLimit);
                            this.mZoomPadMovingRect.bottom = (int) ((34.0f * this.mOnePT) + this.mZoomPadScrollLimit + movingHeight2);
                            this.mZoomPadBarMovingRect.top = this.mZoomPadScrollLimit;
                            this.mZoomPadBarMovingRect.bottom = this.mZoomPadScrollLimit + movingRectHeight2;
                            this.mZoomPadBarRect.top = this.mZoomPadScrollLimit;
                            this.mZoomPadBarRect.bottom = this.mZoomPadScrollLimit + barHeight2;
                            this.mZoomPadBarImageRect.top = this.mZoomPadScrollLimit;
                            this.mZoomPadBarImageRect.bottom = this.mZoomPadScrollLimit + imageHeight2;
                        }
                        if (this.mZoomPadBitmapRect.bottom > this.mScreenHeight - (2.0f * this.mOnePT)) {
                            this.mZoomPadBitmapRect.top = (this.mScreenHeight - (2.0f * this.mOnePT)) - bitmapHeight2;
                            this.mZoomPadBitmapRect.bottom = this.mScreenHeight - (2.0f * this.mOnePT);
                            this.mZoomPadMovingRect.top = (int) ((this.mScreenHeight - (2.0f * this.mOnePT)) - movingHeight2);
                            this.mZoomPadMovingRect.bottom = (int) (this.mScreenHeight - (2.0f * this.mOnePT));
                            this.mZoomPadBarMovingRect.top = ((int) this.mZoomPadBitmapRect.top) - movingRectHeight2;
                            this.mZoomPadBarMovingRect.bottom = (int) this.mZoomPadBitmapRect.top;
                            this.mZoomPadBarRect.top = (int) (this.mZoomPadBitmapRect.top - barHeight2);
                            this.mZoomPadBarRect.bottom = (int) this.mZoomPadBitmapRect.top;
                            this.mZoomPadBarImageRect.top = (int) (this.mZoomPadBitmapRect.top - imageHeight2);
                            this.mZoomPadBarImageRect.bottom = (int) this.mZoomPadBitmapRect.top;
                        }
                        this.mZoomPadRect.top = this.mZoomPadBitmapRect.top - (34.0f * this.mOnePT);
                        this.mZoomPadRect.bottom = this.mZoomPadBitmapRect.bottom;
                        this.mZoomPadHandleRect.set(this.mZoomPadMovingRect.left - ((int) (13.0f * this.mOnePT)), this.mZoomPadMovingRect.bottom - ((int) (29.0f * this.mOnePT)), this.mZoomPadMovingRect.left + ((int) (13.0f * this.mOnePT)), this.mZoomPadMovingRect.bottom);
                        updateButton();
                        break;
                    case 4:
                        Log.d(TAG, "ZoomBar moving rect x=" + x + " y=" + y);
                        this.mZoomPadMovingRect.left = (int) (r13.left - dx);
                        if (this.mZoomPadMovingRect.left < this.mZoomPadBitmapRect.width() / 2.0f) {
                            this.mZoomPadMovingRect.left = ((int) this.mZoomPadBitmapRect.width()) / 2;
                        }
                        if (this.mZoomPadMovingRect.left > (this.mZoomPadBitmapRect.width() * 3.0f) / 4.0f) {
                            this.mZoomPadMovingRect.left = (((int) this.mZoomPadBitmapRect.width()) * 3) / 4;
                        }
                        this.mZoomPadHandleRect.set(this.mZoomPadMovingRect.left - ((int) (13.0f * this.mOnePT)), this.mZoomPadMovingRect.bottom - ((int) (29.0f * this.mOnePT)), this.mZoomPadMovingRect.left + ((int) (13.0f * this.mOnePT)), this.mZoomPadMovingRect.bottom);
                        break;
                }
                if (this.mZoomPadState == 3 || this.mZoomPadState == 4 || this.mZoomPadState == 2) {
                    updateFrameBuffer(true);
                }
                this.mZoomPadPrePoint.x = x;
                this.mZoomPadPrePoint.y = y;
                break;
        }
        if (this.mZoomPadState != 8 && this.mZoomPadState != 0) {
            if (action == 1) {
                this.mZoomPadState = 0;
            }
            return true;
        }
        return false;
    }

    private boolean onTouchInputPen(MotionEvent event) {
        int action = event.getAction() & 255;
        if (this.mCurrentPen != null) {
            RectF tmpRect = new RectF();
            event.offsetLocation(-this.mZoomPadBitmapRect.left, -this.mZoomPadBitmapRect.top);
            switch (action) {
                case 0:
                    this.mStroke = new SpenObjectStroke();
                    this.mStroke.setPenName(this.mPenName);
                    this.mStroke.setColor(this.mCurrentPen.getColor());
                    this.mStroke.setPenSize(this.mPenSize);
                    this.mStroke.setCurveEnabled(this.mCurrentPen.isCurveEnabled());
                    this.mStroke.setAdvancedPenSetting(this.mCurrentPen.getAdvancedSetting());
                    this.mStroke.setToolType(event.getToolType(0));
                    this.mCurrentPen.draw(event, tmpRect);
                    for (int pos = 0; pos < event.getHistorySize(); pos++) {
                        float x = (event.getHistoricalX(pos) * (this.mZoomViewRect.width() / this.mZoomPadBitmapRect.width())) + this.mZoomViewRect.left;
                        float y = (event.getHistoricalY(pos) * (this.mZoomViewRect.height() / this.mZoomPadBitmapRect.height())) + this.mZoomViewRect.top;
                        this.mStroke.addPoint(new PointF((x / this.mRatio) + this.mDeltaX, ((y - this.mScreenStartY) / this.mRatio) + this.mDeltaY), event.getHistoricalPressure(pos), (int) event.getHistoricalEventTime(pos));
                    }
                    float x2 = (event.getX() * (this.mZoomViewRect.width() / this.mZoomPadBitmapRect.width())) + this.mZoomViewRect.left;
                    float y2 = (event.getY() * (this.mZoomViewRect.height() / this.mZoomPadBitmapRect.height())) + this.mZoomViewRect.top;
                    this.mStroke.addPoint(new PointF((x2 / this.mRatio) + this.mDeltaX, ((y2 - this.mScreenStartY) / this.mRatio) + this.mDeltaY), event.getPressure(), (int) event.getEventTime());
                    break;
                case 1:
                    this.mCurrentPen.draw(event, tmpRect);
                    for (int pos2 = 0; pos2 < event.getHistorySize(); pos2++) {
                        float x3 = (event.getHistoricalX(pos2) * (this.mZoomViewRect.width() / this.mZoomPadBitmapRect.width())) + this.mZoomViewRect.left;
                        float y3 = (event.getHistoricalY(pos2) * (this.mZoomViewRect.height() / this.mZoomPadBitmapRect.height())) + this.mZoomViewRect.top;
                        this.mStroke.addPoint(new PointF((x3 / this.mRatio) + this.mDeltaX, ((y3 - this.mScreenStartY) / this.mRatio) + this.mDeltaY), event.getHistoricalPressure(pos2), (int) event.getHistoricalEventTime(pos2));
                    }
                    float x4 = (event.getX() * (this.mZoomViewRect.width() / this.mZoomPadBitmapRect.width())) + this.mZoomViewRect.left;
                    float y4 = (event.getY() * (this.mZoomViewRect.height() / this.mZoomPadBitmapRect.height())) + this.mZoomViewRect.top;
                    this.mStroke.addPoint(new PointF((x4 / this.mRatio) + this.mDeltaX, ((y4 - this.mScreenStartY) / this.mRatio) + this.mDeltaY), event.getPressure(), (int) event.getEventTime());
                    if (this.mActionListener != null) {
                        this.mActionListener.onUpdate(this.mStroke);
                        updateFrameBuffer(true);
                    }
                    this.mStroke = null;
                    break;
                case 2:
                    this.mCurrentPen.draw(event, tmpRect);
                    for (int pos3 = 0; pos3 < event.getHistorySize(); pos3++) {
                        float x5 = (event.getHistoricalX(pos3) * (this.mZoomViewRect.width() / this.mZoomPadBitmapRect.width())) + this.mZoomViewRect.left;
                        float y5 = (event.getHistoricalY(pos3) * (this.mZoomViewRect.height() / this.mZoomPadBitmapRect.height())) + this.mZoomViewRect.top;
                        this.mStroke.addPoint(new PointF((x5 / this.mRatio) + this.mDeltaX, ((y5 - this.mScreenStartY) / this.mRatio) + this.mDeltaY), event.getHistoricalPressure(pos3), (int) event.getHistoricalEventTime(pos3));
                    }
                    float x6 = (event.getX() * (this.mZoomViewRect.width() / this.mZoomPadBitmapRect.width())) + this.mZoomViewRect.left;
                    float y6 = (event.getY() * (this.mZoomViewRect.height() / this.mZoomPadBitmapRect.height())) + this.mZoomViewRect.top;
                    this.mStroke.addPoint(new PointF((x6 / this.mRatio) + this.mDeltaX, ((y6 - this.mScreenStartY) / this.mRatio) + this.mDeltaY), event.getPressure(), (int) event.getEventTime());
                    invalidate();
                    break;
            }
            if (this.mZoomPadMovingRect.left < event.getX()) {
                this.mZoomPadHandler.setMovingEnabled(true);
            }
            if (action == 1 && this.mZoomPadHandler.isMovingEnabled()) {
                this.mZoomPadHandler.sendEmptyMessageDelayed(1, 600L);
            }
        }
        return true;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent event) {
        if (this.mZoomPadEnabled && !onTouchZoomPad(event) && this.mZoomPadState == 8) {
            int action = event.getAction() & 255;
            int toolTypeAction = this.mToolAndActionMap.get(event.getToolType(0));
            float x = event.getX();
            float y = event.getY();
            if (toolTypeAction == 4) {
                if (this.mZoomPadBitmapRect.contains(x, y)) {
                    if (action == 0) {
                        this.isEraserCursor = true;
                        if (this.mRemoverSettingInfo.type == 0) {
                            this.mRemoverRadius = ((this.mRatio * 20.0f) * (this.mZoomPadBitmapRect.height() / this.mZoomViewRect.height())) / 2.0f;
                        } else if (this.mRemoverSettingInfo.type == 1) {
                            this.mRemoverRadius = ((this.mRatio * 40.0f) * (this.mZoomPadBitmapRect.height() / this.mZoomViewRect.height())) / 2.0f;
                        }
                        this.mCirclePoint.x = event.getX();
                        this.mCirclePoint.y = event.getY();
                        this.mCirclePaint.setStrokeWidth(this.mRatio * 2.0f * (this.mZoomPadBitmapRect.height() / this.mZoomViewRect.height()));
                    } else if (this.isEraserCursor) {
                        if (action == 2) {
                            if (this.mRemoverSettingInfo.type == 0) {
                                this.mRemoverRadius = ((this.mRatio * 20.0f) * (this.mZoomPadBitmapRect.height() / this.mZoomViewRect.height())) / 2.0f;
                            } else if (this.mRemoverSettingInfo.type == 1) {
                                this.mRemoverRadius = ((this.mRatio * 40.0f) * (this.mZoomPadBitmapRect.height() / this.mZoomViewRect.height())) / 2.0f;
                            }
                            this.mCirclePoint.x = event.getX();
                            this.mCirclePoint.y = event.getY();
                            this.mCirclePaint.setStrokeWidth(this.mRatio * 2.0f * (this.mZoomPadBitmapRect.height() / this.mZoomViewRect.height()));
                        } else {
                            this.isEraserCursor = false;
                            this.mRemoverRadius = -100.0f;
                            this.mCirclePoint.x = -100.0f;
                            this.mCirclePoint.y = -100.0f;
                        }
                    }
                    this.mActionListener.onViewTouchEvent(event, this.mZoomViewRect, this.mZoomPadBitmapRect);
                    invalidate();
                } else {
                    this.mRemoverRadius = -100.0f;
                    this.mCirclePoint.x = -100.0f;
                    this.mCirclePoint.y = -100.0f;
                    invalidate();
                }
            } else if (onTouchInputPen(event)) {
            }
        }
        return true;
    }

    private static class ZoomPadHandler extends Handler {
        private static final int MOVING_DELAY = 600;
        private static final int MOVING_MESSAGE = 1;
        private boolean mIsMoving = false;
        private final WeakReference<SpenZoomPad> mSpenZoomPad;

        ZoomPadHandler(SpenZoomPad view) {
            this.mSpenZoomPad = new WeakReference<>(view);
        }

        public void setMovingEnabled(boolean enable) {
            this.mIsMoving = enable;
        }

        public boolean isMovingEnabled() {
            return this.mIsMoving;
        }

        @Override // android.os.Handler
        public void handleMessage(Message msg) {
            SpenZoomPad zoomPad;
            if (msg.what != 1 || (zoomPad = this.mSpenZoomPad.get()) == null) {
                return;
            }
            zoomPad.setZoomPadButton(6);
            zoomPad.updateFrameBuffer(true);
            this.mIsMoving = false;
        }
    }

    @TargetApi(16)
    private void setZoomPadView() {
        if (this.mRelative != null) {
            RelativeLayout.LayoutParams totalLayoutParams = new RelativeLayout.LayoutParams(this.mZoomPadBarImageRect.width(), this.mZoomPadBarImageRect.height());
            totalLayoutParams.leftMargin = this.mZoomPadBarImageRect.left;
            totalLayoutParams.topMargin = this.mZoomPadBarImageRect.top;
            this.mRelative.setLayoutParams(totalLayoutParams);
            invalidate();
            return;
        }
        this.mRelative = new RelativeLayout(this.mContext);
        RelativeLayout.LayoutParams totalLayoutParams2 = new RelativeLayout.LayoutParams(this.mZoomPadBarImageRect.width(), this.mZoomPadBarImageRect.height());
        totalLayoutParams2.leftMargin = this.mZoomPadBarImageRect.left;
        totalLayoutParams2.topMargin = this.mZoomPadBarImageRect.top;
        this.mRelative.setLayoutParams(totalLayoutParams2);
        LinearLayout linear = new LinearLayout(this.mContext);
        linear.setOrientation(0);
        this.mLeftButton = new ImageButton(this.mContext);
        LinearLayout.LayoutParams leftButtonParams = new LinearLayout.LayoutParams((int) (this.mOnePT * 36.0f), (int) (this.mOnePT * 34.0f));
        this.mLeftButton.setLayoutParams(leftButtonParams);
        this.mLeftButton.setFocusable(true);
        if (Build.VERSION.SDK_INT < 16) {
            this.mLeftButton.setBackgroundDrawable(setDrawableSelectImg("zoompad_menu_left", "zoompad_menu_press", "zoompad_menu_focus"));
        } else {
            this.mLeftButton.setBackground(setDrawableSelectImg("zoompad_menu_left", "zoompad_menu_press", "zoompad_menu_focus"));
        }
        this.mRightButton = new ImageButton(this.mContext);
        LinearLayout.LayoutParams rightButtonParams = new LinearLayout.LayoutParams((int) (this.mOnePT * 36.0f), (int) (this.mOnePT * 34.0f));
        this.mRightButton.setLayoutParams(rightButtonParams);
        this.mRightButton.setFocusable(true);
        if (Build.VERSION.SDK_INT < 16) {
            this.mRightButton.setBackgroundDrawable(setDrawableSelectImg("zoompad_menu_right", "zoompad_menu_press", "zoompad_menu_focus"));
        } else {
            this.mRightButton.setBackground(setDrawableSelectImg("zoompad_menu_right", "zoompad_menu_press", "zoompad_menu_focus"));
        }
        this.mEnterButton = new ImageButton(this.mContext);
        LinearLayout.LayoutParams enterButtonParams = new LinearLayout.LayoutParams((int) (this.mOnePT * 36.0f), (int) (this.mOnePT * 34.0f));
        this.mEnterButton.setLayoutParams(enterButtonParams);
        this.mEnterButton.setFocusable(true);
        if (Build.VERSION.SDK_INT < 16) {
            this.mEnterButton.setBackgroundDrawable(setDrawableSelectImg("zoompad_menu_enter", "zoompad_menu_press", "zoompad_menu_focus"));
        } else {
            this.mEnterButton.setBackground(setDrawableSelectImg("zoompad_menu_enter", "zoompad_menu_press", "zoompad_menu_focus"));
        }
        this.mCloseButton = new ImageButton(this.mContext);
        LinearLayout.LayoutParams closeButtonParams = new LinearLayout.LayoutParams((int) (this.mOnePT * 36.0f), (int) (this.mOnePT * 34.0f));
        this.mCloseButton.setLayoutParams(closeButtonParams);
        this.mCloseButton.setFocusable(true);
        this.mCloseButton.setContentDescription(getResourceString("string_close"));
        if (Build.VERSION.SDK_INT < 16) {
            this.mCloseButton.setBackgroundDrawable(setDrawableSelectImg("zoompad_menu_close", "zoompad_menu_press", "zoompad_menu_focus"));
        } else {
            this.mCloseButton.setBackground(setDrawableSelectImg("zoompad_menu_close", "zoompad_menu_press", "zoompad_menu_focus"));
        }
        linear.addView(this.mLeftButton);
        linear.addView(this.mRightButton);
        linear.addView(this.mEnterButton);
        linear.addView(this.mCloseButton);
        this.mRelative.addView(linear);
        this.mLeftButton.setOnClickListener(new View.OnClickListener() { // from class: com.samsung.android.sdk.pen.engine.SpenZoomPad.2
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                SpenZoomPad.this.setZoomPadButton(5);
            }
        });
        this.mRightButton.setOnClickListener(new View.OnClickListener() { // from class: com.samsung.android.sdk.pen.engine.SpenZoomPad.3
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                SpenZoomPad.this.setZoomPadButton(6);
            }
        });
        this.mEnterButton.setOnClickListener(new View.OnClickListener() { // from class: com.samsung.android.sdk.pen.engine.SpenZoomPad.4
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                SpenZoomPad.this.setZoomPadButton(7);
            }
        });
        this.mCloseButton.setOnClickListener(new View.OnClickListener() { // from class: com.samsung.android.sdk.pen.engine.SpenZoomPad.5
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                SpenZoomPad.this.stopZoomPad();
            }
        });
    }

    private int setZoomPadSize(int width, int height) {
        this.mZoomPadRect.left = this.mOnePT * 2.0f;
        this.mZoomPadRect.right = width - (this.mOnePT * 2.0f);
        this.mZoomPadRect.top = (float) (height * 0.72d);
        this.mZoomPadRect.bottom = height - (this.mOnePT * 2.0f);
        this.mZoomPadBitmapRect.set(this.mZoomPadRect.left, this.mZoomPadRect.top, this.mZoomPadRect.right, this.mZoomPadRect.bottom);
        this.mZoomPadScrollLimit = (int) (23.0f * this.mOnePT);
        int heightSIP = (int) (height - this.mZoomPadBitmapRect.height());
        this.mZoomPadBarRect.set((int) this.mZoomPadBitmapRect.left, (int) this.mZoomPadBitmapRect.top, (int) this.mZoomPadBitmapRect.right, (int) (((int) this.mZoomPadBitmapRect.top) + (this.mOnePT * 34.0f)));
        this.mZoomPadBarMovingRect.set((this.mZoomPadBarRect.width() / 2) - 50, this.mZoomPadBarRect.top, (this.mZoomPadBarRect.width() / 2) + 50, this.mZoomPadBarRect.bottom);
        this.mZoomPadBitmapRect.top += this.mOnePT * 34.0f;
        this.mZoomPadMovingRect.set((((int) this.mZoomPadBitmapRect.width()) * 3) / 4, this.mZoomPadBarRect.bottom, (int) this.mZoomPadBitmapRect.right, (int) this.mZoomPadBitmapRect.bottom);
        this.mZoomPadHandleRect.set(this.mZoomPadMovingRect.left - ((int) (this.mOnePT * 13.0f)), this.mZoomPadMovingRect.bottom - ((int) (29.0f * this.mOnePT)), this.mZoomPadMovingRect.left + ((int) (this.mOnePT * 13.0f)), this.mZoomPadMovingRect.bottom);
        this.mZoomPadBarImageRect.set(this.mZoomPadBarRect.right - ((int) ((36.0f * this.mOnePT) * 4.0f)), this.mZoomPadBarRect.top, this.mZoomPadBarRect.right, this.mZoomPadBarRect.bottom);
        try {
            if (this.mZoomPadBitmap[4] != null) {
                this.mZoomPadBitmap[4].recycle();
            }
            this.mZoomPadBitmap[4] = Bitmap.createBitmap((int) this.mZoomPadBitmapRect.width(), (int) this.mZoomPadBitmapRect.height(), Bitmap.Config.ARGB_8888);
            if (this.mCurrentPen != null) {
                this.mCurrentPen.setBitmap(this.mZoomPadBitmap[4]);
            }
        } catch (Exception e) {
            SpenError.ThrowUncheckedException(2, "Bitmap failed to create.");
        }
        return heightSIP;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setZoomPadButton(int direction) {
        int diff = ((int) this.mZoomViewRect.width()) / 2;
        switch (direction) {
            case 5:
                this.mZoomViewRect.left -= diff;
                this.mZoomViewRect.right -= diff;
                if (this.mZoomViewRect.left < VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET) {
                    float width = this.mZoomViewRect.width();
                    this.mZoomViewRect.left = VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET;
                    this.mZoomViewRect.right = width;
                    break;
                }
                break;
            case 6:
                if (this.mZoomViewRect.right == this.mScreenWidth) {
                    setZoomPadButton(7);
                    return;
                }
                this.mZoomViewRect.left += diff;
                this.mZoomViewRect.right += diff;
                if (this.mZoomViewRect.right > this.mScreenWidth) {
                    this.mZoomViewRect.left = this.mScreenWidth - this.mZoomViewRect.width();
                    this.mZoomViewRect.right = this.mScreenWidth;
                    break;
                }
                break;
            case 7:
                this.mZoomViewRect.left = this.mZoomViewSaveRect.left;
                this.mZoomViewRect.right = this.mZoomViewSaveRect.right;
                this.mZoomViewRect.top += this.mZoomViewSaveRect.height();
                this.mZoomViewRect.bottom += this.mZoomViewSaveRect.height();
                if (this.mScreenStartY != 0 && this.mZoomViewRect.bottom > this.mScreenStartY + this.mRtoBmpItstScrHeight) {
                    this.mZoomViewRect.top = ((this.mScreenStartY + this.mRtoBmpItstScrHeight) - this.mZoomViewRect.height()) - this.mOnePT;
                    this.mZoomViewRect.bottom = (this.mScreenStartY + this.mRtoBmpItstScrHeight) - this.mOnePT;
                    break;
                } else if (this.mZoomViewRect.bottom > this.mZoomPadBarRect.top - (4.0f * this.mOnePT)) {
                    if (this.mActionListener != null) {
                        this.mActionListener.onChangePan(this.mDeltaX, (this.mDeltaY + this.mZoomViewRect.bottom) - this.mZoomPadBarRect.top);
                    }
                    this.mZoomViewRect.top = (this.mZoomPadBarRect.top - this.mZoomViewRect.height()) - (this.mOnePT * 2.0f);
                    this.mZoomViewRect.bottom = this.mZoomPadBarRect.top - (this.mOnePT * 2.0f);
                    break;
                }
                break;
            default:
                return;
        }
        updateFrameBuffer(true);
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

    private void absoluteCoordinate(RectF dstRectF, RectF srcRectF) {
        dstRectF.left = (srcRectF.left / this.mRatio) + this.mDeltaX;
        dstRectF.right = (srcRectF.right / this.mRatio) + this.mDeltaX;
        dstRectF.top = ((srcRectF.top - this.mScreenStartY) / this.mRatio) + this.mDeltaY;
        dstRectF.bottom = ((srcRectF.bottom - this.mScreenStartY) / this.mRatio) + this.mDeltaY;
    }

    private StateListDrawable setDrawableSelectImg(String defaultImg, String pressedImg, String focusedImg) {
        StateListDrawable localStateListDrawable = new StateListDrawable();
        if (defaultImg != null) {
            localStateListDrawable.addState(new int[]{-16842919, -16842913, -16842908}, getResourceDrawable(defaultImg));
        }
        if (pressedImg != null) {
            localStateListDrawable.addState(new int[]{R.attr.state_pressed}, getResourceDrawable(pressedImg));
            localStateListDrawable.addState(new int[]{R.attr.state_selected}, getResourceDrawable(pressedImg));
        }
        if (focusedImg != null) {
            localStateListDrawable.addState(new int[]{R.attr.state_focused}, getResourceDrawable(focusedImg));
        }
        return localStateListDrawable;
    }

    private Drawable getResourceDrawable(String imgPath) throws Resources.NotFoundException, IOException {
        Drawable drawable = null;
        if (this.mSdkResources != null) {
            int resId = this.mSdkResources.getIdentifier(imgPath, "drawable", Spen.SPEN_NATIVE_PACKAGE_NAME);
            if (resId == 0) {
                return null;
            }
            drawable = SpenScreenCodecDecoder.getDrawable(this.mSdkResources, resId);
        }
        return drawable;
    }

    private Bitmap getResourceBitmap(String imgPath) throws Resources.NotFoundException, IOException {
        Drawable drawable = null;
        if (this.mSdkResources != null) {
            int resId = this.mSdkResources.getIdentifier(imgPath, "drawable", Spen.SPEN_NATIVE_PACKAGE_NAME);
            if (resId == 0) {
                return null;
            }
            drawable = SpenScreenCodecDecoder.getDrawable(this.mSdkResources, resId);
        }
        if (drawable == null) {
            return null;
        }
        if (drawable instanceof BitmapDrawable) {
            return ((BitmapDrawable) drawable).getBitmap();
        }
        Bitmap bitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        drawable.draw(canvas);
        return bitmap;
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
}
