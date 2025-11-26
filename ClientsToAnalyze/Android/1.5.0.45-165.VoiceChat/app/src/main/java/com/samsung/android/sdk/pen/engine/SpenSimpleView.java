package com.samsung.android.sdk.pen.engine;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Build;
import android.util.Log;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import com.samsung.android.sdk.pen.SpenSettingEraserInfo;
import com.samsung.android.sdk.pen.SpenSettingPenInfo;
import com.samsung.android.sdk.pen.SpenSettingRemoverInfo;
import com.samsung.android.sdk.pen.SpenSettingSelectionInfo;
import com.samsung.android.sdk.pen.SpenSettingTextInfo;
import com.samsung.android.sdk.pen.SpenSettingViewInterface;
import com.samsung.android.sdk.pen.pen.SpenPen;
import com.samsung.android.sdk.pen.pen.SpenPenInfo;
import com.samsung.android.sdk.pen.pen.SpenPenManager;
import com.samsung.android.sdk.pen.settingui.SpenSettingPenLayout;
import com.samsung.android.sdk.pen.util.SpenError;
import com.vlingo.sdk.recognition.spotter.VLSpotterContext;
import java.util.ArrayList;
import java.util.Iterator;

@SuppressLint({"ViewConstructor"})
/* loaded from: classes.dex */
public class SpenSimpleView extends View implements SpenSettingViewInterface {
    private static final String TAG = "SpenSimpleView";
    private boolean cancelTouch;
    private int[] canvasAction;
    private SpenPen currentPen;
    private SpenPen defaultPen;
    private RectF dstRect;
    private SpenEraser eraser;
    private Bitmap mBitmap;
    private PointF mFocus;
    private final int mHeight;
    private SpenHoverListener mHoverListener;
    private Matrix mMatrix;
    private ArrayList<PluginData> mPenList;
    private SpenPenManager mPenManager;
    private float mRatio;
    private ScaleGestureDetector mScaleGestureDetector;
    private SpenSettingEraserInfo mSettingEraserInfo;
    private SpenSettingPenInfo mSettingPenInfo;
    private SpenTouchListener mTouchListener;
    private final int mWidth;
    private Rect updateRect;

    private static class PluginData {
        SpenPen handle;
        SpenPenInfo penInfo;

        private PluginData() {
        }

        /* synthetic */ PluginData(PluginData pluginData) {
            this();
        }
    }

    private void JoinRect(Rect dst, RectF src) {
        if (dst != null && src != null && src.left < src.right && src.top < src.bottom) {
            if (dst.left >= dst.right || dst.top >= dst.bottom) {
                dst.left = (int) src.left;
                dst.right = (int) src.right;
                dst.top = (int) src.top;
                dst.bottom = (int) src.bottom;
                return;
            }
            if (src.left < dst.left) {
                dst.left = (int) src.left;
            }
            if (src.top < dst.top) {
                dst.top = (int) src.top;
            }
            if (src.right > dst.right) {
                dst.right = (int) src.right;
            }
            if (src.bottom > dst.bottom) {
                dst.bottom = (int) src.bottom;
            }
        }
    }

    private void construct(Context context) {
        ArrayList arrayList;
        PluginData pluginData = null;
        byte b = 0;
        this.mPenList = new ArrayList<>();
        this.mPenManager = new SpenPenManager(context);
        if (this.mPenManager != null && (arrayList = (ArrayList) this.mPenManager.getPenInfoList()) != null) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                SpenPenInfo spenPenInfo = (SpenPenInfo) it.next();
                PluginData pluginData2 = new PluginData(pluginData);
                pluginData2.penInfo = spenPenInfo;
                this.mPenList.add(pluginData2);
            }
            try {
                this.defaultPen = this.mPenManager.createPen(SpenPenManager.SPEN_INK_PEN);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e2) {
                e2.printStackTrace();
            } catch (InstantiationException e3) {
                e3.printStackTrace();
            } catch (Exception e4) {
                e4.printStackTrace();
            }
            this.canvasAction = new int[5];
            this.canvasAction[0] = 0;
            this.canvasAction[1] = 2;
            this.canvasAction[2] = 2;
            this.canvasAction[3] = 2;
            this.canvasAction[4] = 3;
            this.eraser = new SpenEraser();
            this.updateRect = new Rect();
            this.mFocus = new PointF();
            this.mMatrix = new Matrix();
            this.dstRect = new RectF();
            this.mScaleGestureDetector = new ScaleGestureDetector(context, new onScaleGestureListener(this, b == true ? 1 : 0));
        }
    }

    private void createBitmap(int w, int h) {
        if (this.mBitmap != null) {
            this.mBitmap.recycle();
            this.mBitmap = null;
        }
        try {
            this.mBitmap = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888);
            this.defaultPen.setBitmap(this.mBitmap);
            this.eraser.setBitmap(this.mBitmap);
            Iterator<PluginData> it = this.mPenList.iterator();
            while (it.hasNext()) {
                PluginData data = it.next();
                if (data.handle != null) {
                    data.handle.setBitmap(this.mBitmap);
                    this.currentPen = data.handle;
                }
            }
            if (this.currentPen == null) {
                this.currentPen = this.defaultPen;
            }
        } catch (Exception e) {
            SpenError.ThrowUncheckedException(2, "Bitmap failed to create.");
        }
    }

    private void onTouchInputPen(MotionEvent event) {
        int action = event.getAction() & 255;
        if (action == 0) {
            this.cancelTouch = false;
        }
        if (!this.cancelTouch) {
            if (this.currentPen != null) {
                RectF tmpRect = new RectF();
                switch (action) {
                    case 0:
                        this.cancelTouch = false;
                        this.currentPen.draw(event, tmpRect);
                        this.updateRect.setEmpty();
                        break;
                    case 1:
                        this.currentPen.draw(event, tmpRect);
                        JoinRect(this.updateRect, tmpRect);
                        break;
                    case 2:
                        this.currentPen.draw(event, tmpRect);
                        JoinRect(this.updateRect, tmpRect);
                        break;
                    case 5:
                        this.cancelTouch = true;
                        break;
                }
            }
            invalidate(this.updateRect);
        }
    }

    private void onTouchInputEraser(MotionEvent event) {
        int action = event.getAction() & 255;
        if (action == 0) {
            this.cancelTouch = false;
        }
        if (!this.cancelTouch) {
            if (this.eraser != null) {
                RectF tmpRect = new RectF();
                if (this.mBitmap != null) {
                    this.mBitmap.setPixel(0, 0, 0);
                }
                switch (action) {
                    case 0:
                        this.cancelTouch = false;
                        this.eraser.startPen(event, tmpRect);
                        this.updateRect.setEmpty();
                        break;
                    case 1:
                        this.eraser.endPen(event, tmpRect);
                        JoinRect(this.updateRect, tmpRect);
                        break;
                    case 2:
                        this.eraser.movePen(event, tmpRect);
                        JoinRect(this.updateRect, tmpRect);
                        break;
                    case 5:
                        this.cancelTouch = true;
                        break;
                }
            }
            invalidate(this.updateRect);
        }
    }

    private void onTouchGesture(MotionEvent event) {
        if (this.mScaleGestureDetector != null) {
            this.mScaleGestureDetector.onTouchEvent(event);
        }
    }

    public SpenSimpleView(Context context, int width, int height) {
        super(context);
        this.mPenManager = null;
        this.mPenList = null;
        this.mBitmap = null;
        this.currentPen = null;
        this.cancelTouch = false;
        this.updateRect = null;
        this.canvasAction = null;
        this.mHoverListener = null;
        this.mTouchListener = null;
        this.mRatio = 1.0f;
        this.mScaleGestureDetector = null;
        construct(context);
        this.mWidth = width;
        this.mHeight = height;
        createBitmap(width, height);
    }

    public void close() {
        if (this.mPenList != null) {
            Iterator<PluginData> it = this.mPenList.iterator();
            while (it.hasNext()) {
                PluginData data = it.next();
                if (this.mPenManager != null && data.handle != null) {
                    data.handle.setBitmap(null);
                    this.mPenManager.destroyPen(data.handle);
                    data.handle = null;
                }
                data.penInfo = null;
            }
            this.mPenList.clear();
            this.mPenList = null;
        }
        if (this.mPenManager != null && this.defaultPen != null) {
            this.defaultPen.setBitmap(null);
            this.mPenManager.destroyPen(this.defaultPen);
            this.defaultPen = null;
            this.mPenManager.close();
            this.mPenManager = null;
        }
        if (this.mBitmap != null) {
            this.mBitmap.recycle();
            this.mBitmap = null;
        }
        if (this.eraser != null) {
            this.eraser.close();
            this.eraser = null;
        }
        this.mSettingPenInfo = null;
        this.mSettingEraserInfo = null;
        this.updateRect = null;
        this.canvasAction = null;
        this.mHoverListener = null;
        this.mTouchListener = null;
        this.mFocus = null;
        this.mMatrix = null;
        this.dstRect = null;
        this.mScaleGestureDetector = null;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent event) {
        int toolType = event.getToolType(0);
        if (this.canvasAction != null) {
            switch (this.canvasAction[toolType]) {
                case 1:
                    onTouchGesture(event);
                    break;
                case 2:
                    onTouchInputPen(event);
                    break;
                case 3:
                    onTouchInputEraser(event);
                    break;
            }
        }
        if (this.mTouchListener == null || this.mTouchListener.onTouch(this, event)) {
        }
        return true;
    }

    @Override // android.view.View
    public boolean onHoverEvent(MotionEvent event) {
        if (this.mHoverListener == null || this.mHoverListener.onHover(this, event)) {
        }
        return true;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.mBitmap != null && !this.mBitmap.isRecycled()) {
            this.dstRect.set(VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, this.mBitmap.getWidth(), this.mBitmap.getHeight());
            canvas.save();
            canvas.drawBitmap(this.mBitmap, (Rect) null, this.dstRect, (Paint) null);
            canvas.restore();
            super.onDraw(canvas);
        }
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
        if (this.mPenList != null && info != null) {
            Iterator<PluginData> it = this.mPenList.iterator();
            while (it.hasNext()) {
                PluginData data = it.next();
                if (info.name.compareTo(data.penInfo.className) == 0) {
                    if (info.size < VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET) {
                        info.size = 10.0f;
                    }
                    if (data.handle == null) {
                        try {
                            data.handle = this.mPenManager.createPen(data.penInfo);
                            if (this.mBitmap != null && !this.mBitmap.isRecycled()) {
                                data.handle.setBitmap(this.mBitmap);
                            }
                        } catch (ClassNotFoundException e) {
                            e.printStackTrace();
                        } catch (IllegalAccessException e2) {
                            e2.printStackTrace();
                        } catch (InstantiationException e3) {
                            e3.printStackTrace();
                        } catch (Exception e4) {
                            e4.printStackTrace();
                        }
                    }
                    if (data.handle != null) {
                        data.handle.setColor(info.color);
                        data.handle.setSize(info.size);
                        if (data.handle.getPenAttribute(3)) {
                            data.handle.setCurveEnabled(info.isCurvable);
                        }
                        if (data.handle.getPenAttribute(4)) {
                            data.handle.setAdvancedSetting(info.advancedSetting);
                        }
                        this.currentPen = data.handle;
                    }
                }
            }
        }
        this.mSettingPenInfo = info;
    }

    @Override // com.samsung.android.sdk.pen.SpenSettingViewInterface
    public SpenSettingPenInfo getPenSettingInfo() {
        if (this.mSettingPenInfo == null) {
            this.mSettingPenInfo = new SpenSettingPenInfo();
        }
        return this.mSettingPenInfo;
    }

    @Override // com.samsung.android.sdk.pen.SpenSettingViewInterface
    public void setEraserSettingInfo(SpenSettingEraserInfo info) {
        if (info != null) {
            if (info.size < VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET) {
                info.size = 1.0f;
            }
            this.eraser.setSize(info.size);
        }
        this.mSettingEraserInfo = info;
    }

    @Override // com.samsung.android.sdk.pen.SpenSettingViewInterface
    public SpenSettingEraserInfo getEraserSettingInfo() {
        if (this.mSettingEraserInfo == null) {
            this.mSettingEraserInfo = new SpenSettingEraserInfo();
        }
        return this.mSettingEraserInfo;
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
        if (action > 7 || action < 0) {
            action = 0;
        }
        if (toolType > 4 || toolType < 0) {
            toolType = 0;
        }
        if (this.canvasAction != null) {
            this.canvasAction[toolType] = action;
        }
    }

    @Override // com.samsung.android.sdk.pen.SpenSettingViewInterface
    public int getToolTypeAction(int toolType) {
        if (toolType > 4 || toolType < 0) {
            toolType = 0;
        }
        if (this.canvasAction != null) {
            return this.canvasAction[toolType];
        }
        return 0;
    }

    @Override // com.samsung.android.sdk.pen.SpenSettingViewInterface
    public int getCanvasWidth() {
        return this.mWidth;
    }

    @Override // com.samsung.android.sdk.pen.SpenSettingViewInterface
    public int getCanvasHeight() {
        return this.mHeight;
    }

    public Bitmap captureCurrentView() {
        if (this.mWidth == 0 || this.mHeight == 0) {
            return null;
        }
        Bitmap bitmap = null;
        try {
            bitmap = Bitmap.createBitmap(this.mWidth, this.mHeight, Bitmap.Config.ARGB_8888);
        } catch (Throwable th) {
            Log.e(TAG, "Failed to create bitmap");
            SpenError.ThrowUncheckedException(2, " : fail createBitmap.");
        }
        Canvas canvas = new Canvas(bitmap);
        canvas.drawBitmap(this.mBitmap, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, (Paint) null);
        return bitmap;
    }

    public void clearScreen() {
        if (this.mBitmap != null) {
            Canvas canvas = new Canvas(this.mBitmap);
            canvas.drawColor(0, PorterDuff.Mode.CLEAR);
            invalidate();
        }
    }

    public void setTouchListener(SpenTouchListener listener) {
        this.mTouchListener = listener;
    }

    public void setHoverListener(SpenHoverListener listener) {
        String releaseNumber = Build.VERSION.RELEASE;
        if (releaseNumber.startsWith("4.")) {
            this.mHoverListener = listener;
        } else {
            SpenError.ThrowUncheckedException(12, "S Pen Hover Listener cannot be supported under android ICS");
        }
    }

    private class onScaleGestureListener implements ScaleGestureDetector.OnScaleGestureListener {
        private onScaleGestureListener() {
        }

        /* synthetic */ onScaleGestureListener(SpenSimpleView spenSimpleView, onScaleGestureListener onscalegesturelistener) {
            this();
        }

        @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
        public boolean onScale(ScaleGestureDetector detector) {
            SpenSimpleView.this.mFocus.x = detector.getFocusX();
            SpenSimpleView.this.mFocus.y = detector.getFocusY();
            SpenSimpleView.this.mRatio -= 1.0f - detector.getScaleFactor();
            if (SpenSimpleView.this.mRatio < 1.0f) {
                SpenSimpleView.this.mRatio = 1.0f;
            }
            if (SpenSimpleView.this.mRatio > 5.0f) {
                SpenSimpleView.this.mRatio = 5.0f;
            }
            Log.d(SpenSimpleView.TAG, "onScale=[" + SpenSimpleView.this.mFocus.x + " " + SpenSimpleView.this.mFocus.y + " " + SpenSimpleView.this.mRatio + "]");
            SpenSimpleView.this.mMatrix.setScale(SpenSimpleView.this.mRatio, SpenSimpleView.this.mRatio, SpenSimpleView.this.mFocus.x, SpenSimpleView.this.mFocus.y);
            SpenSimpleView.this.invalidate();
            return true;
        }

        @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
        public boolean onScaleBegin(ScaleGestureDetector detector) {
            return true;
        }

        @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
        public void onScaleEnd(ScaleGestureDetector detector) {
        }
    }

    @Override // com.samsung.android.sdk.pen.SpenSettingViewInterface
    public void closeControl() {
    }

    @Override // com.samsung.android.sdk.pen.SpenSettingViewInterface
    public void setBackgroundColorChangeListener(Object object, SpenSettingViewInterface.SpenBackgroundColorChangeListener listener) {
        if (object != null && (object instanceof SpenSettingPenLayout)) {
            Log.d(TAG, "setBackgroundColorListener");
            listener.onChanged(false);
        }
    }
}
