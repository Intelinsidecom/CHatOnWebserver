package com.samsung.android.sdk.pen.engine;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Matrix;
import android.graphics.NinePatch;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.NinePatchDrawable;
import android.os.Build;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import com.coolots.chaton.call.screenshare.util.ScreenSharePacket;
import com.samsung.android.sdk.pen.Spen;
import com.samsung.android.sdk.pen.document.SpenObjectBase;
import com.samsung.android.sdk.pen.document.SpenObjectStroke;
import com.samsung.android.sdk.pen.document.SpenPageDoc;
import com.samsung.android.sdk.pen.engine.SpenContextMenu;
import com.samsung.android.sdk.pen.pen.SpenPenManager;
import com.samsung.android.sdk.pen.util.SpenError;
import com.vlingo.sdk.recognition.spotter.VLSpotterContext;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes.dex */
public abstract class SpenControlBase extends View {

    /* renamed from: $SWITCH_TABLE$com$samsung$android$sdk$pen$engine$SpenControlBase$QUADRANT */
    private static /* synthetic */ int[] f394xbfaee826 = null;
    protected static final int ALL = -1;
    private static final boolean DEBUG = false;
    protected static final String DEFAULT_BORDER_POINT = "handler_icon";
    protected static final String DEFAULT_DEGREE_STRING = "°";
    private static final int DEFAULT_DENSITY_DPI = 160;
    protected static final int DEFAULT_HANDLE_RESIZE_ICON_SIZE = 22;
    protected static final int DEFAULT_HANDLE_RESIZE_ICON_SIZE_N1 = 38;
    protected static final int DEFAULT_HANDLE_ROTATE_ICON_SIZE = 30;
    protected static final int DEFAULT_HANDLE_ROTATE_ICON_SIZE_N1 = 46;
    protected static final int DEFAULT_RESIZE_ZONE_SIZE = 20;
    protected static final int DEFAULT_RESIZE_ZONE_SIZE_N1 = 34;
    protected static final String DEFAULT_ROTATE_POINT_BORDER = "handler_icon_rotate";
    protected static final int DEFAULT_ROTATION_ZONE_SIZE = 25;
    protected static final int DEFAULT_ROTATION_ZONE_SIZE_N1 = 38;
    protected static final int DIMMING_BG_COLOR = 1073741824;
    protected static final int FLIP_DIRECTION_HORIZONTAL = 2;
    protected static final int FLIP_DIRECTION_NONE = 0;
    protected static final int FLIP_DIRECTION_VERTICAL = 1;
    protected static final int MIN_RESIZE_ZONE_SIZE = 5;
    protected static final int NO_OBJECT = -1;
    private static final float SIGMA = 1.0E-4f;
    public static final int STYLE_BORDER_NONE = 1;
    public static final int STYLE_BORDER_NONE_ACTION_NONE = 3;
    public static final int STYLE_BORDER_OBJECT = 0;
    public static final int STYLE_BORDER_STATIC = 2;
    protected static final int TOUCH_ZONE_BOTTOM = 7;
    protected static final int TOUCH_ZONE_BOTTOM_LEFT = 6;
    protected static final int TOUCH_ZONE_BOTTOM_RIGHT = 8;
    protected static final int TOUCH_ZONE_CENTER = 9;
    protected static final int TOUCH_ZONE_LEFT = 4;
    protected static final int TOUCH_ZONE_MAX = 10;
    protected static final int TOUCH_ZONE_NONE = -1;
    protected static final int TOUCH_ZONE_RIGHT = 5;
    protected static final int TOUCH_ZONE_ROTATE = 0;
    protected static final int TOUCH_ZONE_TOP = 2;
    protected static final int TOUCH_ZONE_TOP_LEFT = 1;
    protected static final int TOUCH_ZONE_TOP_RIGHT = 3;
    private static final int TRIVIAL_MOVING_CRITERIA = 20;
    private static final int mDeltaEdge = 1;
    private static boolean mObjectOutlineEnable = true;
    protected ContextMenuMgr mContextMenu;
    private int mDensityDpi;
    protected boolean mIsClosed;
    private boolean mIsDim;
    private boolean mIsFirstTouch;
    private boolean mIsFlipDirectionHorizontal;
    private boolean mIsFlipDirectionVertical;
    protected ActionListener mListener;
    protected RectF mMaximumResizeRect;
    protected RectF mMinimumResizeRect;
    private ArrayList<SpenObjectBase> mObjectBaseList;
    protected SpenPageDoc mPageDoc;
    private HashMap<String, Point> mPanBackup;
    private PointF mPointDown;
    private CPositionBackup mPrev;
    private ArrayList<RectF> mRectList;
    private Map<String, Drawable> mResourceMap;
    protected float mRotateAngle;
    private final SpenContextMenu.ContextMenuListener mSelectContextMenuListener;
    private int mStyle;
    private CoordinateInfo mTempCoordinateInfo;
    protected CPaint mTempPaint;
    private Rect mTempRect;
    private RectF mTempRectF;
    private Matrix mTmpMatrix;
    private boolean mTouchEnable;
    protected CTouchState mTouchState;
    private CTouchZone mTouchZone;
    protected CTransactionTouchEvent mTransactionTouchEvent;
    private boolean mTrivialMovingEn;

    protected interface ActionListener {
        void onClosed(ArrayList<SpenObjectBase> arrayList);

        void onMenuSelected(ArrayList<SpenObjectBase> arrayList, int i);

        void onObjectChanged(ArrayList<SpenObjectBase> arrayList);

        void onRectChanged(RectF rectF, SpenObjectBase spenObjectBase);

        Bitmap onRequestBackground();

        void onRequestCoordinateInfo(CoordinateInfo coordinateInfo);

        void onRequestScroll(float f, float f2);

        void onRotationChanged(float f, SpenObjectBase spenObjectBase);

        void onVisibleUpdated(ArrayList<SpenObjectBase> arrayList, boolean z);
    }

    enum QUADRANT {
        QUADRANT_1,
        QUADRANT_2,
        QUADRANT_3,
        QUADRANT_4,
        QUADRANT_MAX;

        /* renamed from: values, reason: to resolve conflict with enum method */
        public static QUADRANT[] valuesCustom() {
            QUADRANT[] quadrantArrValuesCustom = values();
            int length = quadrantArrValuesCustom.length;
            QUADRANT[] quadrantArr = new QUADRANT[length];
            System.arraycopy(quadrantArrValuesCustom, 0, quadrantArr, 0, length);
            return quadrantArr;
        }
    }

    /* renamed from: $SWITCH_TABLE$com$samsung$android$sdk$pen$engine$SpenControlBase$QUADRANT */
    static /* synthetic */ int[] m133xbfaee826() {
        int[] iArr = f394xbfaee826;
        if (iArr == null) {
            iArr = new int[QUADRANT.valuesCustom().length];
            try {
                iArr[QUADRANT.QUADRANT_1.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[QUADRANT.QUADRANT_2.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[QUADRANT.QUADRANT_3.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                iArr[QUADRANT.QUADRANT_4.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                iArr[QUADRANT.QUADRANT_MAX.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            f394xbfaee826 = iArr;
        }
        return iArr;
    }

    protected static class CoordinateInfo {
        public float zoomRatio;
        public PointF pan = new PointF();
        public RectF frameRect = new RectF();

        public CoordinateInfo() {
            reset();
        }

        public void reset() {
            this.pan.set(VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET);
            this.zoomRatio = 1.0f;
            this.frameRect.set(VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET);
        }
    }

    protected static class CTransactionTouchEvent {
        protected boolean mIsTouchDownPressed = false;

        public void check(MotionEvent event) {
            int action = event.getAction() & 255;
            if ((action == 2 || action == 1) && !this.mIsTouchDownPressed) {
                action = 0;
                event.setAction(0);
            }
            switch (action) {
                case 0:
                    this.mIsTouchDownPressed = true;
                    break;
                case 1:
                    this.mIsTouchDownPressed = false;
                    break;
            }
        }
    }

    protected static class CPaint {
        public static final int BORDER_DASHED = 2;
        public static final int BORDER_LINE = 1;
        public static final int BORDER_STATIC_LINE_WIDTH = 4;
        public static final int BORDER_TEXTBOX_LINE = 7;
        private static final int DEFAULT_BORDER_DASHED = -16478977;
        private static final int DEFAULT_BORDER_LINE_COLOR = -16478977;
        protected static final int DEFAULT_BORDER_WIDTH = 4;
        public static final int DEGREE_RECT = 4;
        public static final int DEGREE_TEXT = 5;
        public static final int DIMMING_WINDOW = 3;
        public static final int HIGHLIGHT_STROKE = 6;
        public static final int MOVING_OBJECT_PAINT = 0;
        private static final int MOVING_OBJECT_PAINT_VIENNA = 8;
        private final Paint mPaint = new Paint();
        private final DashPathEffect mDashPathEffect = new DashPathEffect(new float[]{5.0f, 5.0f}, 1.0f);

        public Paint getPaint(int option) {
            this.mPaint.reset();
            switch (option) {
                case 0:
                    this.mPaint.setStrokeWidth(2.5f);
                    this.mPaint.setColor(-16776961);
                    this.mPaint.setAlpha(100);
                    this.mPaint.setStyle(Paint.Style.STROKE);
                    break;
                case 1:
                    this.mPaint.setColor(-16478977);
                    this.mPaint.setStyle(Paint.Style.STROKE);
                    this.mPaint.setStrokeWidth(4.0f);
                    break;
                case 2:
                    this.mPaint.setStrokeWidth(4.0f);
                    this.mPaint.setColor(-16478977);
                    this.mPaint.setAlpha(100);
                    this.mPaint.setStyle(Paint.Style.STROKE);
                    this.mPaint.setPathEffect(this.mDashPathEffect);
                    break;
                case 3:
                    this.mPaint.setColor(0);
                    this.mPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC));
                    break;
                case 4:
                    this.mPaint.setColor(-16777216);
                    this.mPaint.setStyle(Paint.Style.FILL);
                    this.mPaint.setAlpha(ScreenSharePacket.SCREEN_SHARE_CMD_SETTING_MATRIXINFO);
                    this.mPaint.setAntiAlias(true);
                    this.mPaint.setShadowLayer(180.0f, 5.0f, 5.0f, -1);
                    break;
                case 5:
                    this.mPaint.setTextSize(35.0f);
                    this.mPaint.setTextAlign(Paint.Align.CENTER);
                    this.mPaint.setStyle(Paint.Style.FILL);
                    this.mPaint.setAntiAlias(true);
                    this.mPaint.setColor(-1);
                    break;
                case 6:
                    this.mPaint.setStyle(Paint.Style.STROKE);
                    this.mPaint.setStrokeJoin(Paint.Join.ROUND);
                    this.mPaint.setStrokeCap(Paint.Cap.ROUND);
                    this.mPaint.setAntiAlias(true);
                    this.mPaint.setColor(-16478977);
                    break;
                case 7:
                    this.mPaint.setColor(-16478977);
                    this.mPaint.setStyle(Paint.Style.STROKE);
                    this.mPaint.setStrokeWidth(6.0f);
                    break;
                case 8:
                    this.mPaint.setStrokeWidth(3.5f);
                    this.mPaint.setColor(-16776961);
                    this.mPaint.setAlpha(100);
                    this.mPaint.setStyle(Paint.Style.STROKE);
                    break;
            }
            return this.mPaint;
        }
    }

    protected static class CPositionBackup {
        float rotated_x;
        float rotated_y;

        /* renamed from: x */
        float f395x;

        /* renamed from: y */
        float f396y;

        protected CPositionBackup() {
        }
    }

    protected class ContextMenuMgr {
        public ArrayList<SpenContextMenuItemInfo> mItemList = null;
        public boolean mDirtyFlag = true;
        public SpenContextMenu mInstance = null;
        public boolean mFirstDraw = true;
        public boolean mVisible = true;

        protected ContextMenuMgr() {
        }

        public void setDirty() {
            this.mDirtyFlag = true;
        }

        public void resetDirty() {
            this.mDirtyFlag = false;
        }

        public View setFocusMenuItem(int i) {
            if (this.mInstance != null) {
                return this.mInstance.setFocusMenuItem(i);
            }
            return null;
        }

        public void handleSelectMenuItem(int index) {
            if (this.mInstance != null) {
                this.mInstance.handleSelectMenuItem(index);
            }
        }

        public int getCountMenuItem() {
            if (this.mInstance != null) {
                return this.mInstance.getCountMenuItem();
            }
            return -1;
        }

        public void scrollToMenuItem(int index) {
            if (this.mInstance != null) {
                this.mInstance.scrollToMenuItem(index);
            }
        }

        public void show() {
            if (this.mDirtyFlag) {
                SpenControlBase.this.updateContextMenu();
                resetDirty();
            }
            if (this.mInstance != null && this.mVisible) {
                this.mInstance.show();
            }
        }

        public void hide() {
            if (this.mInstance != null) {
                this.mInstance.hide();
            }
        }
    }

    protected static class CTouchState {
        public int mState;
        public int mTouchedObjectIndex;

        CTouchState() {
            reset();
        }

        void reset() {
            this.mState = -1;
            this.mTouchedObjectIndex = -1;
        }

        boolean isResizeZonePressed() {
            return this.mState >= 1 && this.mState <= 8;
        }

        boolean isCornerZonePressed() {
            return this.mState == 1 || this.mState == 3 || this.mState == 6 || this.mState == 8;
        }

        boolean isHorizontalResizeZonePressed() {
            return this.mState == 4 || this.mState == 5;
        }

        boolean isVerticalResizeZonePressed() {
            return this.mState == 2 || this.mState == 7;
        }

        boolean isMoveZonePressed() {
            return this.mState == 9;
        }

        boolean isRotateZonePressed() {
            return this.mState == 0;
        }

        boolean isPressed() {
            return this.mState != -1;
        }
    }

    protected class CTouchZone {
        private final RectF mTempTouchZone = new RectF();

        CTouchZone() {
        }

        RectF getRect(int touchZone, RectF rect) {
            int rect_w = (int) Math.abs(rect.width());
            int rect_h = (int) Math.abs(rect.height());
            boolean disableTopBottom = false;
            boolean disableLeftRight = false;
            int zon_size = 20;
            if (SpenContextMenu.getType() == 1) {
                zon_size = 34;
                if (rect_w < 68) {
                    disableTopBottom = true;
                }
                if (rect_h < 68) {
                    disableLeftRight = true;
                }
            } else {
                if (rect_w < 80) {
                    disableTopBottom = true;
                }
                if (rect_h < 80) {
                    disableLeftRight = true;
                }
            }
            if (zon_size < 5) {
                zon_size = 5;
            }
            int outsideGap = zon_size * 2;
            switch (touchZone) {
                case 0:
                    this.mTempTouchZone.set((rect.left + ((rect.right - rect.left) / 2.0f)) - (zon_size * 1.5f), ((rect.top - ((zon_size * 4) * 1.5f)) - 30.0f) + zon_size, rect.left + ((rect.right - rect.left) / 2.0f) + (zon_size * 1.5f), ((rect.top - (zon_size * 1.5f)) - 30.0f) + zon_size);
                    break;
                case 1:
                    this.mTempTouchZone.set((rect.left - zon_size) - outsideGap, (rect.top - zon_size) - outsideGap, rect.left + zon_size, rect.top + zon_size);
                    break;
                case 2:
                    this.mTempTouchZone.set(rect.centerX() - zon_size, rect.top - outsideGap, rect.centerX() + zon_size, rect.top + zon_size);
                    if (disableTopBottom) {
                        this.mTempTouchZone.set(VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET);
                        break;
                    }
                    break;
                case 3:
                    this.mTempTouchZone.set(rect.right - zon_size, (rect.top - zon_size) - outsideGap, rect.right + zon_size + outsideGap, rect.top + zon_size);
                    break;
                case 4:
                    this.mTempTouchZone.set((rect.left - zon_size) - outsideGap, rect.centerY() - zon_size, rect.left + zon_size, rect.centerY() + zon_size);
                    if (disableLeftRight) {
                        this.mTempTouchZone.set(VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET);
                        break;
                    }
                    break;
                case 5:
                    this.mTempTouchZone.set(rect.right - zon_size, rect.centerY() - zon_size, rect.right + zon_size + outsideGap, rect.centerY() + zon_size);
                    if (disableLeftRight) {
                        this.mTempTouchZone.set(VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET);
                        break;
                    }
                    break;
                case 6:
                    this.mTempTouchZone.set((rect.left - zon_size) - outsideGap, rect.bottom - zon_size, rect.left + zon_size, rect.bottom + zon_size + outsideGap);
                    break;
                case 7:
                    this.mTempTouchZone.set(rect.centerX() - zon_size, rect.bottom - zon_size, rect.centerX() + zon_size, rect.bottom + zon_size + outsideGap);
                    if (disableTopBottom) {
                        this.mTempTouchZone.set(VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET);
                        break;
                    }
                    break;
                case 8:
                    this.mTempTouchZone.set(rect.right - zon_size, rect.bottom - zon_size, rect.right + zon_size + outsideGap, rect.bottom + zon_size + outsideGap);
                    break;
                case 9:
                    this.mTempTouchZone.set(rect.left, rect.top, rect.right, rect.bottom);
                    break;
            }
            return this.mTempTouchZone;
        }

        protected void checkTouchPosition(RectF rect, int x, int y, SpenObjectBase objectBase, CTouchState retState) {
            retState.reset();
            if (rect.width() >= SpenControlBase.SIGMA && rect.height() >= SpenControlBase.SIGMA) {
                for (int i = 0; i < 10; i++) {
                    if (getRect(i, rect).contains(x, y)) {
                        SpenSLog.m135d(false, "zone pressed : " + i);
                        retState.mState = i;
                        if ((SpenControlBase.this.mStyle == 2 || SpenControlBase.this.mStyle == 1) && retState.mState != 9) {
                            retState.mState = -1;
                            return;
                        }
                        return;
                    }
                }
            }
        }
    }

    private void fit(int index, CoordinateInfo coordinateInfo) {
        if (isObjectAvailable()) {
            SpenObjectBase objectBase = this.mObjectBaseList.get(index);
            RectF objectRect = objectBase.getRect();
            RectF rect = this.mRectList.get(index);
            relativeCoordinate(rect, objectRect, this.mTempCoordinateInfo);
        }
    }

    private boolean isObjectAvailable() {
        return this.mObjectBaseList != null && this.mObjectBaseList.size() > 0;
    }

    protected void absoluteCoordinate(RectF dstRect, RectF srcRect, CoordinateInfo coordinateInfo) {
        if (dstRect != null && srcRect != null && coordinateInfo != null) {
            dstRect.left = ((srcRect.left - coordinateInfo.frameRect.left) / coordinateInfo.zoomRatio) + coordinateInfo.pan.x;
            dstRect.right = ((srcRect.right - coordinateInfo.frameRect.left) / coordinateInfo.zoomRatio) + coordinateInfo.pan.x;
            dstRect.top = ((srcRect.top - coordinateInfo.frameRect.top) / coordinateInfo.zoomRatio) + coordinateInfo.pan.y;
            dstRect.bottom = ((srcRect.bottom - coordinateInfo.frameRect.top) / coordinateInfo.zoomRatio) + coordinateInfo.pan.y;
        }
    }

    protected void relativeCoordinate(RectF dstRect, RectF srcRect, CoordinateInfo coordinateInfo) {
        if (dstRect != null && srcRect != null && coordinateInfo != null) {
            dstRect.left = ((srcRect.left - coordinateInfo.pan.x) * coordinateInfo.zoomRatio) + coordinateInfo.frameRect.left;
            dstRect.right = ((srcRect.right - coordinateInfo.pan.x) * coordinateInfo.zoomRatio) + coordinateInfo.frameRect.left;
            dstRect.top = ((srcRect.top - coordinateInfo.pan.y) * coordinateInfo.zoomRatio) + coordinateInfo.frameRect.top;
            dstRect.bottom = ((srcRect.bottom - coordinateInfo.pan.y) * coordinateInfo.zoomRatio) + coordinateInfo.frameRect.top;
        }
    }

    private RectF getBorderRect(int index) {
        if (!isObjectAvailable()) {
            return null;
        }
        this.mTempCoordinateInfo.reset();
        if (this.mListener != null) {
            this.mListener.onRequestCoordinateInfo(this.mTempCoordinateInfo);
        }
        relativeCoordinate(this.mTempRectF, this.mObjectBaseList.get(index).getRect(), this.mTempCoordinateInfo);
        return this.mTempRectF;
    }

    private float getBorderAngle(int index) {
        return (!isObjectAvailable() || index >= this.mObjectBaseList.size()) ? VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET : this.mObjectBaseList.get(index).getRotation();
    }

    private boolean getRotateable(int index) {
        if (index < this.mObjectBaseList.size() && index != -1) {
            return this.mObjectBaseList.get(index).isRotatable();
        }
        SpenSLog.m137e(false, " index out of range. [ index = " + index + " ]");
        return false;
    }

    private void drawDimmingWindow(Canvas canvas, RectF rect) {
        if (this.mIsDim) {
            canvas.drawRect(rect, this.mTempPaint.getPaint(3));
        }
    }

    private void initialize(SpenPageDoc pageDoc) {
        this.mPageDoc = pageDoc;
        this.mRotateAngle = VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET;
        this.mRectList = new ArrayList<>();
        this.mObjectBaseList = null;
        this.mPrev = new CPositionBackup();
        this.mTouchZone = new CTouchZone();
        this.mTouchState = new CTouchState();
        this.mTempRectF = new RectF();
        this.mTempRect = new Rect();
        this.mResourceMap = new Hashtable();
        this.mTempCoordinateInfo = new CoordinateInfo();
        this.mTransactionTouchEvent = new CTransactionTouchEvent();
        this.mTrivialMovingEn = false;
        this.mTouchEnable = true;
        this.mPanBackup = new HashMap<>();
        DisplayMetrics localDisplayMetrics = getContext().getResources().getDisplayMetrics();
        float minResizeEdge = TypedValue.applyDimension(1, 10.0f, localDisplayMetrics);
        float maxResizeWidth = TypedValue.applyDimension(1, localDisplayMetrics.widthPixels, localDisplayMetrics) * 2.0f;
        float maxResizeHeight = TypedValue.applyDimension(1, localDisplayMetrics.heightPixels, localDisplayMetrics) * 2.0f;
        this.mMinimumResizeRect = new RectF(VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, minResizeEdge, minResizeEdge);
        this.mMaximumResizeRect = new RectF(VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, maxResizeWidth, maxResizeHeight);
        if (localDisplayMetrics.densityDpi == DEFAULT_DENSITY_DPI) {
            this.mDensityDpi = DEFAULT_DENSITY_DPI;
        } else {
            this.mDensityDpi = VLSpotterContext.DEFAULT_PHRASESPOT_PARAMB;
        }
        setLayerType(1, null);
        this.mTempPaint = new CPaint();
    }

    private boolean isRotatable() {
        if (this.mStyle == 0) {
            Iterator<SpenObjectBase> it = this.mObjectBaseList.iterator();
            while (it.hasNext()) {
                SpenObjectBase objectBase = it.next();
                if (objectBase.isRotatable()) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean isOutOfViewEnabled() {
        Iterator<SpenObjectBase> it = this.mObjectBaseList.iterator();
        while (it.hasNext()) {
            SpenObjectBase objectBase = it.next();
            if (!objectBase.isOutOfViewEnabled()) {
                return false;
            }
        }
        return true;
    }

    private boolean isMovable() {
        Iterator<SpenObjectBase> it = this.mObjectBaseList.iterator();
        while (it.hasNext()) {
            SpenObjectBase objectBase = it.next();
            if (!objectBase.isMovable()) {
                return false;
            }
        }
        return true;
    }

    protected void updateContextMenu() {
        if (this.mContextMenu.mItemList != null && this.mContextMenu.mItemList.size() > 0) {
            if (this.mContextMenu.mDirtyFlag) {
                if (this.mContextMenu.mInstance != null) {
                    this.mContextMenu.mInstance.close();
                    this.mContextMenu.mInstance = null;
                }
                if (getParent() != null) {
                    this.mContextMenu.mInstance = new SpenContextMenu(getContext(), this, this.mContextMenu.mItemList, this.mSelectContextMenuListener);
                }
            }
            RectF rectF = getBoundBox(-1);
            if (rectF != null) {
                Rect rect = new Rect();
                int top_diff = 25;
                if (SpenContextMenu.getType() == 1) {
                    top_diff = 38;
                }
                if (isRotatable()) {
                    top_diff *= 3;
                }
                rect.set((int) rectF.left, (int) (rectF.top - top_diff), (int) rectF.right, ((int) rectF.bottom) + 20);
                if (this.mContextMenu.mInstance != null) {
                    Rect contextMenuPositionRect = calculateContextMenuPosition(rect);
                    if (contextMenuPositionRect != null) {
                        rect.set(contextMenuPositionRect);
                    }
                    Rect offsetRect = new Rect();
                    getGlobalVisibleRect(offsetRect);
                    rect.offset(offsetRect.left, offsetRect.top);
                    this.mContextMenu.mInstance.setRect(rect);
                }
            }
        }
    }

    private float normalizeDegree(float degrees) {
        float result = degrees;
        if (-360.0f >= degrees) {
            result = degrees + 360.0f;
        }
        if (360.0f <= degrees) {
            result = degrees - 360.0f;
        }
        if (-360.0f >= result || 360.0f <= result) {
            return normalizeDegree(result);
        }
        return result;
    }

    private void resizeL2R(int index, PointF diff_rotated) {
        RectF rectF = this.mRectList.get(index);
        rectF.left += diff_rotated.x;
    }

    private void resizeR2L(int index, PointF diff_rotated) {
        RectF rectF = this.mRectList.get(index);
        rectF.right += diff_rotated.x;
    }

    private void resizeT2B(int index, PointF diff_rotated) {
        RectF rectF = this.mRectList.get(index);
        rectF.top += diff_rotated.y;
    }

    private void resizeB2T(int index, PointF diff_rotated) {
        RectF rectF = this.mRectList.get(index);
        rectF.bottom += diff_rotated.y;
    }

    private PointF findResizeRate(PointF diff_rotated, RectF rectStart) {
        PointF resizeRate = new PointF();
        float width = rectStart.width();
        if (Math.abs(width) < SIGMA) {
            width = 1.0f;
        }
        float height = rectStart.height();
        if (Math.abs(height) < SIGMA) {
            height = 1.0f;
        }
        resizeRate.x = diff_rotated.x / width;
        resizeRate.y = diff_rotated.y / height;
        SpenSLog.m137e(false, " resizeRate.x.y = " + resizeRate.x + " , " + resizeRate.y);
        return resizeRate;
    }

    private void resize(int index, PointF diff_rotated) {
        RectF tmp = this.mRectList.get(index);
        RectF preRectF = new RectF();
        preRectF.set(tmp.left, tmp.top, tmp.right, tmp.bottom);
        switch (this.mTouchState.mState) {
            case 1:
                resizeL2R(index, diff_rotated);
                resizeT2B(index, diff_rotated);
                break;
            case 2:
                RectF rectf = this.mRectList.get(index);
                float center = rectf.centerX();
                float height = rectf.height();
                float width = rectf.width();
                resizeT2B(index, diff_rotated);
                if (this.mObjectBaseList.get(index).getResizeOption() == 1 && height != VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET) {
                    rectf.left = center - ((rectf.height() * width) / (2.0f * height));
                    rectf.right = ((rectf.height() * width) / (2.0f * height)) + center;
                    break;
                }
                break;
            case 3:
                resizeR2L(index, diff_rotated);
                resizeT2B(index, diff_rotated);
                break;
            case 4:
                RectF rectf3 = this.mRectList.get(index);
                float center3 = rectf3.centerY();
                float height3 = rectf3.height();
                float width3 = rectf3.width();
                resizeL2R(index, diff_rotated);
                if (this.mObjectBaseList.get(index).getResizeOption() == 1 && width3 != VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET) {
                    rectf3.top = center3 - ((rectf3.width() * height3) / (2.0f * width3));
                    rectf3.bottom = ((rectf3.width() * height3) / (2.0f * width3)) + center3;
                    break;
                }
                break;
            case 5:
                RectF rectf2 = this.mRectList.get(index);
                float center2 = rectf2.centerY();
                float height2 = rectf2.height();
                float width2 = rectf2.width();
                resizeR2L(index, diff_rotated);
                if (this.mObjectBaseList.get(index).getResizeOption() == 1 && width2 != VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET) {
                    rectf2.top = center2 - ((rectf2.width() * height2) / (2.0f * width2));
                    rectf2.bottom = ((rectf2.width() * height2) / (2.0f * width2)) + center2;
                    break;
                }
                break;
            case 6:
                resizeL2R(index, diff_rotated);
                resizeB2T(index, diff_rotated);
                break;
            case 7:
                RectF rectf1 = this.mRectList.get(index);
                float center1 = rectf1.centerX();
                float height1 = rectf1.height();
                float width1 = rectf1.width();
                resizeB2T(index, diff_rotated);
                if (this.mObjectBaseList.get(index).getResizeOption() == 1 && height1 != VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET) {
                    rectf1.left = center1 - ((rectf1.height() * width1) / (2.0f * height1));
                    rectf1.right = ((rectf1.height() * width1) / (2.0f * height1)) + center1;
                    break;
                }
                break;
            case 8:
                resizeR2L(index, diff_rotated);
                resizeB2T(index, diff_rotated);
                break;
        }
        if (this.mObjectBaseList.get(index).isOutOfViewEnabled() && checkAllRectOutOfCanvas(tmp, index, this.mObjectBaseList.get(index).getRotation())) {
            tmp.set(preRectF.left, preRectF.top, preRectF.right, preRectF.bottom);
        }
    }

    private Rect calculateContextMenuPosition(Rect rect) {
        Rect menuRect;
        Rect retRect = new Rect();
        RectF rectBorder = getBorderRect(0);
        if (rectBorder == null) {
            return null;
        }
        int knopHeight = (int) (Math.cos(Math.toRadians(this.mRotateAngle)) * ((rectBorder.height() / 2.0f) + this.mTouchZone.getRect(0, rectBorder).height() + (this.mTouchZone.getRect(2, rectBorder).height() / 2.0f)));
        int knopY = (int) (rectBorder.centerY() - knopHeight);
        ViewGroup parentLayout = (ViewGroup) getParent();
        if (parentLayout == null || this.mContextMenu.mInstance == null || (menuRect = this.mContextMenu.mInstance.getRect()) == null) {
            return null;
        }
        if (SpenContextMenu.getType() == 0) {
            int delta_padding = (int) TypedValue.applyDimension(1, 5, getResources().getDisplayMetrics());
            menuRect.left -= delta_padding;
            menuRect.top -= delta_padding;
            menuRect.right += delta_padding;
            menuRect.bottom += delta_padding;
            int gap = (int) TypedValue.applyDimension(1, 7.0f, getResources().getDisplayMetrics());
            int delta = (int) TypedValue.applyDimension(1, 5.0f, getResources().getDisplayMetrics());
            int centerTopX = (int) ((rect.left + rect.right) * 0.5d);
            int centerTopY = rect.top < knopY ? rect.top : knopY;
            int centerBottomY = rect.bottom > knopY ? rect.bottom : knopY;
            int x = centerTopX - ((int) (menuRect.width() * 0.5d));
            if (x < 0) {
                x = 0;
            } else if (menuRect.width() + x > parentLayout.getWidth()) {
                x = parentLayout.getWidth() - menuRect.width();
            }
            int y1 = (centerTopY - gap) - menuRect.height();
            int y2 = ((centerBottomY + gap) + menuRect.height()) - delta;
            int y = y1;
            if (y1 >= 0 || y2 < parentLayout.getHeight()) {
                if (y1 < 0) {
                    y = y2 - menuRect.height();
                } else if (y2 >= parentLayout.getHeight()) {
                    y = y1 - delta;
                }
            } else if (rectBorder.centerY() > parentLayout.getHeight() / 2.0f) {
                y = 0;
            } else {
                y = (parentLayout.getHeight() - menuRect.height()) - delta;
            }
            retRect.set(x, y, menuRect.width() + x, menuRect.height() + y);
            return retRect;
        }
        int gap2 = (int) TypedValue.applyDimension(1, 7.0f, getResources().getDisplayMetrics());
        int delta2 = (int) TypedValue.applyDimension(1, 5.0f, getResources().getDisplayMetrics());
        int centerTopX2 = (int) ((rect.left + rect.right) * 0.5d);
        int centerTopY2 = rect.top < knopY ? rect.top : knopY;
        int centerBottomY2 = rect.bottom > knopY ? rect.bottom : knopY;
        int x2 = centerTopX2 - ((int) (menuRect.width() * 0.5d));
        if (x2 < 0) {
            x2 = 0;
        } else if (menuRect.width() + x2 > parentLayout.getWidth()) {
            x2 = parentLayout.getWidth() - menuRect.width();
        }
        int y12 = (centerTopY2 - menuRect.height()) + (gap2 * 2);
        int y22 = ((centerBottomY2 + gap2) + menuRect.height()) - delta2;
        int y3 = y12;
        if (y12 >= 0 || y22 <= parentLayout.getHeight()) {
            if (y12 < 0) {
                if (centerBottomY2 == knopY) {
                    y3 = (y22 - menuRect.height()) - (gap2 * 3);
                } else {
                    y3 = y22 - menuRect.height();
                }
            } else if (y22 > parentLayout.getHeight()) {
                y3 = y12;
            }
        } else if (rectBorder.centerY() > parentLayout.getHeight() / 2.0f) {
            y3 = 0;
        } else {
            y3 = (parentLayout.getHeight() - menuRect.height()) - (gap2 * 2);
        }
        retRect.set(x2, y3, menuRect.width() + x2, menuRect.height() + y3);
        return retRect;
    }

    protected RectF getBoundBox(int index) {
        if (!isObjectAvailable()) {
            return null;
        }
        if (index == -1) {
            RectF sumRect = new RectF(getBoundBox(0));
            for (int i = 1; i < this.mObjectBaseList.size(); i++) {
                RectF tempRect = getBoundBox(i);
                sumRect.union(tempRect);
            }
            return sumRect;
        }
        float centerX = getControlPivotX(index);
        float centerY = getControlPivotY(index);
        PointF[] rotatePoint = new PointF[4];
        RectF rectF = this.mRectList.get(index);
        float degree = getBorderAngle(index);
        if (index == this.mTouchState.mTouchedObjectIndex) {
            degree = this.mRotateAngle;
        }
        rotatePoint[0] = getRotatePoint((int) rectF.left, (int) rectF.top, centerX, centerY, degree);
        rotatePoint[1] = getRotatePoint((int) rectF.right, (int) rectF.top, centerX, centerY, degree);
        rotatePoint[2] = getRotatePoint((int) rectF.left, (int) rectF.bottom, centerX, centerY, degree);
        rotatePoint[3] = getRotatePoint((int) rectF.right, (int) rectF.bottom, centerX, centerY, degree);
        float pointX_min = rotatePoint[0].x;
        float pointY_min = rotatePoint[0].y;
        float pointX_max = rotatePoint[0].x;
        float pointY_max = rotatePoint[0].y;
        for (int i2 = 0; i2 < rotatePoint.length; i2++) {
            if (pointX_min >= rotatePoint[i2].x) {
                pointX_min = rotatePoint[i2].x;
            }
            if (pointX_max <= rotatePoint[i2].x) {
                pointX_max = rotatePoint[i2].x;
            }
            if (pointY_min >= rotatePoint[i2].y) {
                pointY_min = rotatePoint[i2].y;
            }
            if (pointY_max <= rotatePoint[i2].y) {
                pointY_max = rotatePoint[i2].y;
            }
        }
        return new RectF(pointX_min, pointY_min, pointX_max, pointY_max);
    }

    protected PointF getRotatePoint(int x, int y, float pivotX, float pivotY, double degrees) {
        double dSetDegree = Math.toRadians(degrees);
        double cosq = Math.cos(dSetDegree);
        double sinq = Math.sin(dSetDegree);
        double sx = x - pivotX;
        double sy = y - pivotY;
        double rx = ((sx * cosq) - (sy * sinq)) + pivotX;
        double ry = (sx * sinq) + (sy * cosq) + pivotY;
        return new PointF((float) rx, (float) ry);
    }

    private boolean checkAllRectOutOfCanvas(RectF rectF, int index, float angle) {
        this.mTempCoordinateInfo.reset();
        if (this.mListener != null) {
            this.mListener.onRequestCoordinateInfo(this.mTempCoordinateInfo);
        }
        float pivotX = getControlPivotX(index);
        float pivotY = getControlPivotY(index);
        PointF topleft = new PointF(rectF.left, rectF.top);
        PointF topleft2 = rotatePoint(pivotX, pivotY, angle, topleft);
        PointF topright = new PointF(rectF.right, rectF.top);
        PointF topright2 = rotatePoint(pivotX, pivotY, angle, topright);
        PointF bottomleft = new PointF(rectF.left, rectF.bottom);
        PointF bottomleft2 = rotatePoint(pivotX, pivotY, angle, bottomleft);
        PointF bottomright = new PointF(rectF.right, rectF.bottom);
        float[] points = findPoints(topleft2, topright2, bottomleft2, rotatePoint(pivotX, pivotY, angle, bottomright));
        float left = points[0];
        float top = points[1];
        float right = points[2];
        float bottom = points[3];
        RectF tmpBoundBoxRect = new RectF(left, top, right, bottom);
        RectF tmpFrameRect = new RectF(this.mTempCoordinateInfo.frameRect.left + 1.0f, this.mTempCoordinateInfo.frameRect.top + 1.0f, this.mTempCoordinateInfo.frameRect.right - 1.0f, this.mTempCoordinateInfo.frameRect.bottom - 1.0f);
        return (tmpFrameRect.intersect(tmpBoundBoxRect) || tmpBoundBoxRect.contains(tmpFrameRect)) ? false : true;
    }

    protected boolean handleResizeControl(PointF pos, PointF pos_rotated) {
        if (!isObjectAvailable()) {
            return false;
        }
        PointF diff_rotated = new PointF(VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET);
        diff_rotated.x = pos_rotated.x - this.mPrev.rotated_x;
        diff_rotated.y = pos_rotated.y - this.mPrev.rotated_y;
        int index = this.mTouchState.mTouchedObjectIndex;
        if (this.mObjectBaseList.get(index).getResizeOption() == 2) {
            return false;
        }
        PointF resizeRate = findResizeRate(diff_rotated, getBorderRect(index));
        if (this.mTouchState.mState == 6 || this.mTouchState.mState == 3) {
            if (Math.abs(resizeRate.x) > Math.abs(resizeRate.y)) {
                resizeRate.y = resizeRate.x * (-1);
            } else {
                resizeRate.x = resizeRate.y * (-1);
            }
        } else if (this.mTouchState.mState == 8 || this.mTouchState.mState == 1) {
            if (Math.abs(resizeRate.x) > Math.abs(resizeRate.y)) {
                resizeRate.y = resizeRate.x * 1;
            } else {
                resizeRate.x = resizeRate.y * 1;
            }
        }
        RectF prevRect = new RectF();
        RectF postRect = new RectF();
        PointF diff_rotated_rated = new PointF(VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET);
        for (int i = 0; i < this.mObjectBaseList.size(); i++) {
            prevRect.set(this.mRectList.get(i));
            RectF rect = getBorderRect(i);
            diff_rotated_rated.x = rect.width() * resizeRate.x;
            diff_rotated_rated.y = rect.height() * resizeRate.y;
            resize(i, diff_rotated_rated);
            if (!this.mObjectBaseList.get(index).isOutOfViewEnabled()) {
                if (isClippedObject(index, false, false, true, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, this.mObjectBaseList.get(index).getRotation(), this.mObjectBaseList.get(index).getResizeOption() == 1, getBorderRect(i).width() / getBorderRect(i).height())) {
                    this.mRectList.get(index).set(prevRect);
                }
            }
            onRectChanged(this.mRectList.get(i), this.mObjectBaseList.get(i));
            if (!isObjectAvailable()) {
                return true;
            }
            postRect.set(this.mRectList.get(i));
            if (Math.signum(prevRect.right - prevRect.left) != Math.signum(postRect.right - postRect.left)) {
                onFlip(2, this.mObjectBaseList.get(i));
            }
            if (Math.signum(prevRect.bottom - prevRect.top) != Math.signum(postRect.bottom - postRect.top)) {
                onFlip(1, this.mObjectBaseList.get(i));
            }
        }
        invalidate();
        this.mPrev.f395x = pos.x;
        this.mPrev.f396y = pos.y;
        this.mPrev.rotated_x = pos_rotated.x;
        this.mPrev.rotated_y = pos_rotated.y;
        return true;
    }

    protected void handleMoveControl(Point pos, Point pos_rotated) {
        if (isObjectAvailable() && isMovable()) {
            float changeX = (int) (pos.x - this.mPrev.f395x);
            float changeY = (int) (pos.y - this.mPrev.f396y);
            if (Math.abs(changeX) < 20.0f && Math.abs(changeY) < 20.0f && !this.mTrivialMovingEn) {
                SpenSLog.m135d(false, "trivalMoving blocked: chg_X, chg_Y=" + changeX + "," + changeY);
                return;
            }
            this.mTrivialMovingEn = true;
            RectF preRectF = new RectF();
            for (int i = 0; i < this.mObjectBaseList.size(); i++) {
                RectF rectF = this.mRectList.get(i);
                preRectF.set(rectF.left, rectF.top, rectF.right, rectF.bottom);
                rectF.set(rectF.left + changeX, rectF.top + changeY, rectF.right + changeX, rectF.bottom + changeY);
                if (this.mObjectBaseList.get(i).isOutOfViewEnabled() && checkAllRectOutOfCanvas(rectF, i, this.mObjectBaseList.get(i).getRotation())) {
                    rectF.set(preRectF.left, preRectF.top, preRectF.right, preRectF.bottom);
                }
                onRectChanged(rectF, this.mObjectBaseList.get(i));
                if (!isObjectAvailable()) {
                    return;
                }
            }
            invalidate();
            this.mPrev.f395x = pos.x;
            this.mPrev.f396y = pos.y;
            this.mPrev.rotated_x = pos_rotated.x;
            this.mPrev.rotated_y = pos_rotated.y;
        }
    }

    protected void handleRotationControl(Point pos) {
        if (isObjectAvailable()) {
            float preDegree = this.mRotateAngle;
            int index = this.mTouchState.mTouchedObjectIndex;
            float dx = getControlPivotY(index) - pos.y;
            float dy = pos.x - getControlPivotX(index);
            double radian = Math.atan2(dy, dx);
            float degree = normalizeDegree((float) ((180.0d * radian) / 3.141592653589793d));
            boolean isClippable = true;
            int i = 0;
            while (true) {
                if (i >= this.mObjectBaseList.size()) {
                    break;
                }
                if (this.mObjectBaseList.get(i).isOutOfViewEnabled()) {
                    i++;
                } else {
                    isClippable = false;
                    break;
                }
            }
            if (!isClippable) {
                for (int i2 = 0; i2 < this.mObjectBaseList.size(); i2++) {
                    if (isClippedObject(i2, true, false, false, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, (int) degree, false, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET)) {
                        return;
                    }
                }
            }
            RectF rotateRect = this.mTouchZone.getRect(0, getBorderRect(index));
            float startX = rotateRect.centerX();
            float startY = rotateRect.centerY();
            float centerPointX = getControlPivotX(index);
            float centerPointY = getControlPivotY(index);
            double rotationRad = Math.sqrt(((centerPointX - startX) * (centerPointX - startX)) + ((centerPointY - startY) * (centerPointY - startY)));
            double pos2Center = Math.sqrt(((centerPointX - pos.x) * (centerPointX - pos.x)) + ((centerPointY - pos.y) * (centerPointY - pos.y)));
            this.mRotateAngle = (int) (0.5f + degree);
            if (pos2Center < 70.0d + rotationRad) {
                if (degree > 178.0f && degree < 184.0f) {
                    degree = 180.0f;
                }
                if (degree > -184.0f && degree < -178.0f) {
                    degree = -180.0f;
                }
                this.mRotateAngle = (((int) degree) / 5) * 5;
            }
            if (isClippable) {
                RectF preRectF = new RectF();
                for (int i3 = 0; i3 < this.mObjectBaseList.size(); i3++) {
                    RectF rectF = this.mRectList.get(i3);
                    preRectF.set(rectF.left, rectF.top, rectF.right, rectF.bottom);
                    if (checkAllRectOutOfCanvas(rectF, i3, this.mRotateAngle)) {
                        this.mRotateAngle = preDegree;
                        return;
                    }
                }
            }
            invalidate();
            for (int i4 = 0; i4 < this.mObjectBaseList.size(); i4++) {
                if (getRotateable(i4)) {
                    float objAng = this.mRotateAngle;
                    if (i4 != index && index != -1) {
                        float rotateDiff = this.mRotateAngle - getBorderAngle(index);
                        objAng = normalizeDegree(getBorderAngle(i4) + rotateDiff);
                    }
                    onRotationChanged(objAng, this.mObjectBaseList.get(i4));
                }
            }
        }
    }

    private void resize2Threshold(int objID) {
        RectF rectf = this.mRectList.get(objID);
        RectF srcRect = getBorderRect(objID);
        if (Math.abs(srcRect.width()) < SIGMA || Math.abs(srcRect.height()) < SIGMA) {
            rectf.left = srcRect.left;
            rectf.right = srcRect.right;
            rectf.bottom = srcRect.bottom;
            rectf.top = srcRect.top;
            return;
        }
        float ratio = srcRect.width() / srcRect.height();
        float maxWidth = Math.abs(this.mMaximumResizeRect.width()) * this.mTempCoordinateInfo.zoomRatio;
        float maxHeight = Math.abs(this.mMaximumResizeRect.height()) * this.mTempCoordinateInfo.zoomRatio;
        float minWidth = Math.abs(this.mMinimumResizeRect.width()) * this.mTempCoordinateInfo.zoomRatio;
        float minHeight = Math.abs(this.mMinimumResizeRect.height()) * this.mTempCoordinateInfo.zoomRatio;
        if (Math.abs(rectf.width()) >= maxWidth || Math.abs(rectf.width()) <= minWidth || Math.abs(rectf.height()) <= minHeight || Math.abs(rectf.height()) >= maxHeight) {
            if (this.mObjectBaseList.get(objID).getResizeOption() == 1 || this.mTouchState.isCornerZonePressed()) {
                float tmpMaxWidth = maxWidth > ratio * maxHeight ? ratio * maxHeight : maxWidth;
                if (tmpMaxWidth < maxWidth) {
                    maxWidth = tmpMaxWidth;
                } else {
                    maxHeight = maxWidth / ratio;
                }
                float tmpMinWidth = minWidth < ratio * minHeight ? ratio * minHeight : minWidth;
                if (tmpMinWidth > minWidth) {
                    minWidth = tmpMinWidth;
                } else {
                    minHeight = minWidth / ratio;
                }
            }
            int sign = 1;
            boolean isEdgeThreshold = false;
            float thresholdW = Math.abs(rectf.width()) > maxWidth ? maxWidth : minWidth;
            float thresholdH = Math.abs(rectf.height()) > maxHeight ? maxHeight : minHeight;
            if (Math.abs(rectf.width()) > maxWidth || Math.abs(rectf.width()) < minWidth) {
                switch (this.mTouchState.mState) {
                    case -1:
                        if (rectf.width() < VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET) {
                            sign = -1;
                        }
                        rectf.right = rectf.centerY() + (thresholdW / 2.0f);
                        rectf.left = rectf.right - (sign * thresholdW);
                        break;
                    case 1:
                    case 4:
                    case 6:
                        if (rectf.width() < VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET) {
                            sign = -1;
                        }
                        rectf.left = srcRect.right - (sign * thresholdW);
                        rectf.right = srcRect.right;
                        break;
                    case 3:
                    case 5:
                    case 8:
                        if (rectf.width() < VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET) {
                            sign = -1;
                        }
                        rectf.right = srcRect.left + (sign * thresholdW);
                        rectf.left = srcRect.left;
                        break;
                }
                isEdgeThreshold = true;
            }
            int sign2 = 1;
            if (Math.abs(rectf.height()) > maxHeight || Math.abs(rectf.height()) < minHeight) {
                switch (this.mTouchState.mState) {
                    case -1:
                        if (rectf.height() < VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET) {
                            sign2 = -1;
                        }
                        rectf.bottom = rectf.centerX() + (thresholdH / 2.0f);
                        rectf.top = rectf.bottom - (sign2 * thresholdH);
                        break;
                    case 1:
                    case 2:
                    case 3:
                        if (rectf.height() < VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET) {
                            sign2 = -1;
                        }
                        rectf.bottom = srcRect.bottom;
                        rectf.top = rectf.bottom - (sign2 * thresholdH);
                        break;
                    case 6:
                    case 7:
                    case 8:
                        if (rectf.height() < VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET) {
                            sign2 = -1;
                        }
                        rectf.bottom = srcRect.top + (sign2 * thresholdH);
                        rectf.top = srcRect.top;
                        break;
                }
                isEdgeThreshold = true;
            }
            if (isEdgeThreshold && this.mObjectBaseList.get(objID).getResizeOption() == 1) {
                switch (this.mTouchState.mState) {
                    case 2:
                        rectf.right = srcRect.left + ((srcRect.right - srcRect.left) / 2.0f) + (thresholdW / 2.0f);
                        rectf.left = rectf.right - thresholdW;
                        break;
                    case 4:
                        rectf.bottom = srcRect.top + ((srcRect.bottom - srcRect.top) / 2.0f) + (thresholdH / 2.0f);
                        rectf.top = rectf.bottom - thresholdH;
                        break;
                    case 5:
                        rectf.bottom = srcRect.top + ((srcRect.bottom - srcRect.top) / 2.0f) + (thresholdH / 2.0f);
                        rectf.top = rectf.bottom - thresholdH;
                        break;
                    case 7:
                        rectf.right = srcRect.left + ((srcRect.right - srcRect.left) / 2.0f) + (thresholdW / 2.0f);
                        rectf.left = rectf.right - thresholdW;
                        break;
                }
            }
            PointF offset = getOffsetWhenRotation(this.mTouchState.mState, srcRect, rectf, this.mObjectBaseList.get(objID).getRotation());
            rectf.offset(offset.x, offset.y);
        }
    }

    private PointF getOffsetWhenRotation(int touchZone, RectF srcRect, RectF dscRect, float degree) {
        PointF offset = new PointF();
        PointF srcTouchPoint = getFixedPoint(touchZone, srcRect);
        PointF newTouchPoint = getRotatePoint((int) srcTouchPoint.x, (int) srcTouchPoint.y, srcRect.centerX(), srcRect.centerY(), degree);
        PointF resizeTouchPoint = getFixedPoint(touchZone, dscRect);
        PointF newResizeTouchPoint = getRotatePoint((int) resizeTouchPoint.x, (int) resizeTouchPoint.y, dscRect.centerX(), dscRect.centerY(), degree);
        offset.x = newTouchPoint.x - newResizeTouchPoint.x;
        offset.y = newTouchPoint.y - newResizeTouchPoint.y;
        return offset;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private PointF getFixedPoint(int touchZone, RectF rect) {
        PointF result = new PointF();
        switch (touchZone) {
            case -1:
                result.x = rect.centerX();
                result.y = rect.centerY();
                return result;
            case 0:
            default:
                return result;
            case 1:
                result.x = rect.right;
                result.y = rect.bottom;
                return result;
            case 2:
                result.x = rect.centerX();
                result.y = rect.bottom;
                return result;
            case 3:
                result.x = rect.left;
                result.y = rect.bottom;
                return result;
            case 4:
                result.x = rect.right;
                result.y = rect.centerY();
                return result;
            case 5:
                result.x = rect.left;
                result.y = rect.centerY();
                return result;
            case 6:
                result.x = rect.right;
                result.y = rect.top;
                return result;
            case 7:
                result.x = rect.centerX();
                result.y = rect.top;
                return result;
            case 8:
                result.x = rect.left;
                result.y = rect.top;
                return result;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    protected boolean handleTouchEvent(MotionEvent event) {
        if (!isObjectAvailable()) {
            return false;
        }
        Point pos = new Point((int) event.getX(), (int) event.getY());
        Point pos_rotated = new Point();
        switch (event.getAction() & 255) {
            case 0:
                this.mIsFlipDirectionHorizontal = false;
                this.mIsFlipDirectionVertical = false;
                this.mPrev.f395x = pos.x;
                this.mPrev.f396y = pos.y;
                this.mTouchState.reset();
                int i = 0;
                while (true) {
                    if (i < this.mObjectBaseList.size()) {
                        SpenObjectBase objectBase = this.mObjectBaseList.get(i);
                        PointF tempPoint = getRotatePoint(pos.x, pos.y, getControlPivotX(i), getControlPivotY(i), -getBorderAngle(i));
                        pos_rotated = new Point((int) tempPoint.x, (int) tempPoint.y);
                        onCheckTouchPosition(getBorderRect(i), pos_rotated.x, pos_rotated.y, objectBase, this.mTouchState);
                        if (!this.mTouchState.isPressed()) {
                            i++;
                        } else {
                            this.mTouchState.mTouchedObjectIndex = i;
                            this.mRotateAngle = objectBase.getRotation();
                        }
                    }
                }
                this.mPrev.rotated_x = pos_rotated.x;
                this.mPrev.rotated_y = pos_rotated.y;
                SpenSLog.m135d(false, "Obj [" + this.mTouchState.mTouchedObjectIndex + "] mRotateAngle = " + this.mRotateAngle + "] pos_rotated =" + pos_rotated);
                if (!this.mTouchState.isPressed()) {
                    return false;
                }
                return true;
            case 1:
                if (this.mTouchState.isResizeZonePressed() || this.mTouchState.isRotateZonePressed() || this.mTouchState.isMoveZonePressed()) {
                    for (int i2 = 0; i2 < this.mObjectBaseList.size(); i2++) {
                        RectF rectf = this.mRectList.get(i2);
                        RectF boundBox = getBoundBox(i2);
                        if (boundBox != null && rectf != null) {
                            int deltaX = (int) (boundBox.centerX() - rectf.centerX());
                            int deltaY = (int) (boundBox.centerY() - rectf.centerY());
                            rectf.offset(deltaX, deltaY);
                        }
                    }
                }
                if (this.mTouchState.isResizeZonePressed()) {
                    for (int i3 = 0; i3 < this.mObjectBaseList.size(); i3++) {
                        RectF modifiedRect = this.mRectList.get(i3);
                        if (this.mIsFlipDirectionHorizontal) {
                            float tmpEdge = modifiedRect.right;
                            modifiedRect.right = modifiedRect.left;
                            modifiedRect.left = tmpEdge;
                        }
                        if (this.mIsFlipDirectionVertical) {
                            float tmpEdge2 = modifiedRect.top;
                            modifiedRect.top = modifiedRect.bottom;
                            modifiedRect.bottom = tmpEdge2;
                        }
                    }
                }
                onObjectChanged();
                this.mTouchState.reset();
                return true;
            case 2:
                int index = 0;
                if (this.mTouchState.mTouchedObjectIndex >= 0) {
                    index = this.mTouchState.mTouchedObjectIndex;
                }
                PointF tempPoint2 = getRotatePoint(pos.x, pos.y, getControlPivotX(index), getControlPivotY(index), -getBorderAngle(index));
                Point pos_rotated2 = new Point((int) tempPoint2.x, (int) tempPoint2.y);
                if (this.mTouchState.isRotateZonePressed() && this.mObjectBaseList.get(0).isRotatable()) {
                    handleRotationControl(pos);
                    return false;
                }
                if (this.mTouchState.isResizeZonePressed()) {
                    return handleResizeControl(new PointF(event.getX(), event.getY()), new PointF(tempPoint2.x, tempPoint2.y));
                }
                if (this.mTouchState.isMoveZonePressed()) {
                    handleMoveControl(pos, pos_rotated2);
                    return true;
                }
                return true;
            case 3:
            case 4:
            default:
                return false;
            case 5:
                close();
                return false;
        }
    }

    protected Drawable getDrawableImage(String drawableName) throws Resources.NotFoundException, PackageManager.NameNotFoundException, IOException {
        Resources mApk1Resources;
        int mDrawableResID;
        Drawable drawable = this.mResourceMap.get(drawableName);
        if (drawable != null) {
            return drawable;
        }
        try {
            PackageManager manager = getContext().getPackageManager();
            mApk1Resources = manager.getResourcesForApplication(Spen.SPEN_NATIVE_PACKAGE_NAME);
            mDrawableResID = mApk1Resources.getIdentifier(drawableName, "drawable", Spen.SPEN_NATIVE_PACKAGE_NAME);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        if (mDrawableResID != 0) {
            drawable = mApk1Resources.getDrawable(mDrawableResID);
            this.mResourceMap.put(drawableName, drawable);
            return drawable;
        }
        InputStream localInputStream = null;
        Drawable bitmapDrawable = null;
        Rect localRect = new Rect();
        URL localURL = getClass().getResource(drawableName);
        if (localURL != null) {
            try {
                localInputStream = localURL.openStream();
            } catch (IOException e2) {
                return null;
            }
        }
        BitmapFactory.Options localOptions = new BitmapFactory.Options();
        if (localInputStream != null) {
            localOptions.inDensity = this.mDensityDpi;
            Bitmap localBitmap = BitmapFactory.decodeStream(localInputStream, localRect, localOptions);
            try {
                localInputStream.close();
                if (localBitmap != null) {
                    byte[] arrayOfByte = localBitmap.getNinePatchChunk();
                    boolean bool = NinePatch.isNinePatchChunk(arrayOfByte);
                    if (bool) {
                        bitmapDrawable = new NinePatchDrawable(getContext().getResources(), localBitmap, arrayOfByte, localRect, null);
                    } else {
                        bitmapDrawable = new BitmapDrawable(getContext().getResources(), localBitmap);
                    }
                }
                this.mResourceMap.put(drawableName, bitmapDrawable);
                return bitmapDrawable;
            } catch (IOException e3) {
                return null;
            }
        }
        return null;
    }

    protected void setObjectList(ArrayList<SpenObjectBase> objectList) {
        this.mObjectBaseList = objectList;
        int defaultMaxHeight = getResources().getDisplayMetrics().heightPixels;
        int defaultMaxWidth = getResources().getDisplayMetrics().widthPixels;
        if (this.mObjectBaseList != null) {
            RectF unionRectF = new RectF(VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET);
            RectF unionMaxRectF = new RectF(VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET);
            Iterator<SpenObjectBase> it = this.mObjectBaseList.iterator();
            while (it.hasNext()) {
                SpenObjectBase objectBase = it.next();
                unionRectF.union(new RectF(VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, objectBase.getMinWidth(), objectBase.getMinHeight()));
                float maxWidth = objectBase.getMaxWidth();
                float maxHeight = objectBase.getMaxHeight();
                if (Math.abs(maxWidth) < SIGMA || Math.abs(maxWidth) > defaultMaxWidth * 2.0f) {
                    maxWidth = defaultMaxWidth * 2.0f;
                }
                if (Math.abs(maxHeight) < SIGMA || Math.abs(maxHeight) > defaultMaxHeight * 2.0f) {
                    maxHeight = defaultMaxHeight * 2.0f;
                }
                unionMaxRectF.union(new RectF(VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, maxWidth, maxHeight));
                this.mRectList.add(new RectF(objectBase.getRect()));
            }
            this.mMinimumResizeRect.union(unionRectF);
            this.mMaximumResizeRect.set(unionMaxRectF);
        }
    }

    protected void updateRectList() {
        if (this.mRectList != null) {
            this.mRectList.clear();
            if (this.mObjectBaseList != null) {
                Iterator<SpenObjectBase> it = this.mObjectBaseList.iterator();
                while (it.hasNext()) {
                    SpenObjectBase objectBase = it.next();
                    RectF dstRect = new RectF();
                    RectF srcRect = objectBase.getRect();
                    this.mTempCoordinateInfo.reset();
                    if (this.mListener != null) {
                        this.mListener.onRequestCoordinateInfo(this.mTempCoordinateInfo);
                    }
                    relativeCoordinate(dstRect, srcRect, this.mTempCoordinateInfo);
                    this.mRectList.add(dstRect);
                }
            }
        }
    }

    protected ArrayList<RectF> getRectList() {
        return this.mRectList;
    }

    protected float getControlPivotX(int index) {
        return this.mTouchState.isResizeZonePressed() ? getBorderRect(index).centerX() : this.mRectList.get(index).centerX();
    }

    protected float getControlPivotY(int index) {
        return this.mTouchState.isResizeZonePressed() ? getBorderRect(index).centerY() : this.mRectList.get(index).centerY();
    }

    private PointF rotatePoint(float px, float py, float angle, PointF input) {
        if (this.mTmpMatrix == null) {
            this.mTmpMatrix = new Matrix();
        }
        this.mTmpMatrix.setRotate(angle, px, py);
        float[] pts = {input.x, input.y};
        this.mTmpMatrix.mapPoints(pts);
        return new PointF(pts[0], pts[1]);
    }

    private float[] findPoints(PointF topleft, PointF topright, PointF bottomleft, PointF bottomright) {
        float left = topleft.x <= topright.x ? topleft.x : topright.x;
        if (bottomleft.x <= left) {
            left = bottomleft.x;
        }
        if (bottomright.x <= left) {
            left = bottomright.x;
        }
        float right = topleft.x >= topright.x ? topleft.x : topright.x;
        if (bottomleft.x >= right) {
            right = bottomleft.x;
        }
        if (bottomright.x >= right) {
            right = bottomright.x;
        }
        float top = topleft.y <= topright.y ? topleft.y : topright.y;
        if (bottomleft.y <= top) {
            top = bottomleft.y;
        }
        if (bottomright.y <= top) {
            top = bottomright.y;
        }
        float bottom = topleft.y >= topright.y ? topleft.y : topright.y;
        if (bottomleft.y >= bottom) {
            bottom = bottomleft.y;
        }
        if (bottomright.y >= bottom) {
            bottom = bottomright.y;
        }
        float[] ret = {left, top, right, bottom};
        return ret;
    }

    private float[] findPoints(PointF p1, PointF oppo_p1) {
        float left = p1.x <= oppo_p1.x ? p1.x : oppo_p1.x;
        float right = p1.x > oppo_p1.x ? p1.x : oppo_p1.x;
        float top = p1.y <= oppo_p1.y ? p1.y : oppo_p1.y;
        float bottom = p1.y > oppo_p1.y ? p1.y : oppo_p1.y;
        float[] ret = {left, top, right, bottom};
        return ret;
    }

    protected boolean isClippedObject(int index, boolean isRotating, boolean isMoving, boolean isResizing, float changeX, float changeY, float angle, boolean isKeepRatio, float ratio) {
        RectF rect = null;
        this.mTempCoordinateInfo.reset();
        if (this.mListener != null) {
            this.mListener.onRequestCoordinateInfo(this.mTempCoordinateInfo);
        }
        if (isMoving || isResizing) {
            RectF rect2 = this.mRectList.get(index);
            rect = rect2;
        } else if (isRotating) {
            rect = getBorderRect(index);
        }
        if (rect == null) {
            return false;
        }
        float px = getControlPivotX(index);
        float py = getControlPivotY(index);
        if (isMoving) {
            float deltaY = VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET;
            float deltaX = VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET;
            PointF topleft = new PointF(rect.left, rect.top);
            PointF topleft2 = rotatePoint(px, py, angle, topleft);
            PointF topright = new PointF(rect.right, rect.top);
            PointF topright2 = rotatePoint(px, py, angle, topright);
            PointF bottomleft = new PointF(rect.left, rect.bottom);
            PointF bottomleft2 = rotatePoint(px, py, angle, bottomleft);
            PointF bottomright = new PointF(rect.right, rect.bottom);
            PointF bottomright2 = rotatePoint(px, py, angle, bottomright);
            float[] points = findPoints(topleft2, topright2, bottomleft2, bottomright2);
            float left = points[0];
            float top = points[1];
            float right = points[2];
            float bottom = points[3];
            if (left < this.mTempCoordinateInfo.frameRect.left) {
                deltaX = this.mTempCoordinateInfo.frameRect.left - left;
            }
            if (right > this.mTempCoordinateInfo.frameRect.right) {
                deltaX = this.mTempCoordinateInfo.frameRect.right - right;
            }
            if (top < this.mTempCoordinateInfo.frameRect.top) {
                deltaY = this.mTempCoordinateInfo.frameRect.top - top;
            }
            if (bottom > this.mTempCoordinateInfo.frameRect.bottom) {
                deltaY = this.mTempCoordinateInfo.frameRect.bottom - bottom;
            }
            if (deltaX != VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET || deltaY != VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET) {
                topleft2.x += deltaX;
                topright2.x += deltaX;
                bottomleft2.x += deltaX;
                bottomright2.x += deltaX;
                topleft2.y += deltaY;
                topright2.y += deltaY;
                bottomleft2.y += deltaY;
                bottomright2.y += deltaY;
                float[] points2 = findPoints(topleft2, topright2, bottomleft2, bottomright2);
                float left2 = points2[0];
                float top2 = points2[1];
                float px2 = (float) (0.5d * (left2 + points2[2]));
                float py2 = (float) (0.5d * (top2 + points2[3]));
                float[] points3 = findPoints(rotatePoint(px2, py2, -angle, topleft2), rotatePoint(px2, py2, -angle, topright2), rotatePoint(px2, py2, -angle, bottomleft2), rotatePoint(px2, py2, -angle, bottomright2));
                rect.set(points3[0], points3[1], points3[2], points3[3]);
            }
            return true;
        }
        if (isResizing) {
            RectF originalRect = getBorderRect(index);
            PointF topleft3 = new PointF(rect.left, rect.top);
            PointF topleft4 = rotatePoint(px, py, angle, topleft3);
            PointF topright3 = new PointF(rect.right, rect.top);
            PointF topright4 = rotatePoint(px, py, angle, topright3);
            PointF bottomleft3 = new PointF(rect.left, rect.bottom);
            PointF bottomleft4 = rotatePoint(px, py, angle, bottomleft3);
            PointF bottomright3 = new PointF(rect.right, rect.bottom);
            PointF bottomright4 = rotatePoint(px, py, angle, bottomright3);
            float[] points4 = findPoints(topleft4, topright4, bottomleft4, bottomright4);
            float left3 = points4[0];
            if (left3 < this.mTempCoordinateInfo.frameRect.left) {
                if (Math.signum(originalRect.right - originalRect.left) != Math.signum(rect.right - rect.left)) {
                    this.mIsFlipDirectionHorizontal = true;
                }
                if (Math.signum(originalRect.bottom - originalRect.top) != Math.signum(rect.bottom - rect.top)) {
                    this.mIsFlipDirectionVertical = true;
                }
                float deltaX2 = this.mTempCoordinateInfo.frameRect.left - left3;
                if (Math.abs(left3 - topleft4.x) < SIGMA) {
                    topleft4.x += deltaX2;
                    topleft4 = rotatePoint(px, py, -angle, topleft4);
                    bottomright4 = rotatePoint(px, py, -angle, bottomright4);
                    points4 = findPoints(topleft4, bottomright4);
                } else if (Math.abs(left3 - topright4.x) < SIGMA) {
                    topright4.x += deltaX2;
                    topright4 = rotatePoint(px, py, -angle, topright4);
                    bottomleft4 = rotatePoint(px, py, -angle, bottomleft4);
                    points4 = findPoints(topright4, bottomleft4);
                } else if (Math.abs(left3 - bottomleft4.x) < SIGMA) {
                    bottomleft4.x += deltaX2;
                    topright4 = rotatePoint(px, py, -angle, topright4);
                    bottomleft4 = rotatePoint(px, py, -angle, bottomleft4);
                    points4 = findPoints(topright4, bottomleft4);
                } else if (Math.abs(left3 - bottomright4.x) < SIGMA) {
                    bottomright4.x += deltaX2;
                    topleft4 = rotatePoint(px, py, -angle, topleft4);
                    bottomright4 = rotatePoint(px, py, -angle, bottomright4);
                    points4 = findPoints(topleft4, bottomright4);
                }
                rect.set(points4[0], points4[1], points4[2], points4[3]);
                topleft4.set(rect.left, rect.top);
                topleft4 = rotatePoint(px, py, angle, topleft4);
                topright4.set(rect.right, rect.top);
                topright4 = rotatePoint(px, py, angle, topright4);
                bottomleft4.set(rect.left, rect.bottom);
                bottomleft4 = rotatePoint(px, py, angle, bottomleft4);
                bottomright4.set(rect.right, rect.bottom);
                bottomright4 = rotatePoint(px, py, angle, bottomright4);
                if (this.mTouchState.isCornerZonePressed()) {
                    if (Math.abs(topleft4.x - topright4.x) < SIGMA || Math.abs(topleft4.x - bottomleft4.x) < SIGMA) {
                        if (this.mTouchState.mState == 1) {
                            if (topleft4.y < bottomleft4.y) {
                                rect.bottom = rect.top + ((rect.right - rect.left) / ratio);
                            } else {
                                rect.right = rect.left + ((rect.bottom - rect.top) * ratio);
                            }
                        } else if (this.mTouchState.mState == 6) {
                            if (bottomleft4.y < bottomright4.y) {
                                rect.right = rect.left + ((rect.bottom - rect.top) * ratio);
                            } else {
                                rect.top = rect.bottom - ((rect.right - rect.left) / ratio);
                            }
                        } else if (this.mTouchState.mState == 8) {
                            if (bottomright4.y < topright4.y) {
                                rect.top = rect.bottom - ((rect.right - rect.left) / ratio);
                            } else {
                                rect.left = rect.right - ((rect.bottom - rect.top) * ratio);
                            }
                        } else if (this.mTouchState.mState == 3) {
                            if (topright4.y < topleft4.y) {
                                rect.left = rect.right - ((rect.bottom - rect.top) * ratio);
                            } else {
                                rect.bottom = rect.top + ((rect.right - rect.left) / ratio);
                            }
                        }
                    } else if (this.mTouchState.mState == 1) {
                        if (topleft4.y < bottomleft4.y) {
                            rect.right = rect.left + ((rect.bottom - rect.top) * ratio);
                        } else {
                            rect.bottom = rect.top + ((rect.right - rect.left) / ratio);
                        }
                    } else if (this.mTouchState.mState == 6) {
                        if (bottomleft4.y < bottomright4.y) {
                            rect.top = rect.bottom - ((rect.right - rect.left) / ratio);
                        } else {
                            rect.right = rect.left + ((rect.bottom - rect.top) * ratio);
                        }
                    } else if (this.mTouchState.mState == 8) {
                        if (bottomright4.y < topright4.y) {
                            rect.left = rect.right - ((rect.bottom - rect.top) * ratio);
                        } else {
                            rect.top = rect.bottom - ((rect.right - rect.left) / ratio);
                        }
                    } else if (this.mTouchState.mState == 3) {
                        if (topright4.y < topleft4.y) {
                            rect.bottom = rect.top + ((rect.right - rect.left) / ratio);
                        } else {
                            rect.left = rect.right - ((rect.bottom - rect.top) * ratio);
                        }
                    }
                    topleft4.set(rect.left, rect.top);
                    topleft4 = rotatePoint(px, py, angle, topleft4);
                    topright4.set(rect.right, rect.top);
                    topright4 = rotatePoint(px, py, angle, topright4);
                    bottomleft4.set(rect.left, rect.bottom);
                    bottomleft4 = rotatePoint(px, py, angle, bottomleft4);
                    bottomright4.set(rect.right, rect.bottom);
                    bottomright4 = rotatePoint(px, py, angle, bottomright4);
                } else if (isKeepRatio && !this.mTouchState.isCornerZonePressed()) {
                    if (Math.abs(topleft4.x - topright4.x) < SIGMA || Math.abs(topleft4.x - bottomleft4.x) < SIGMA) {
                        if (this.mTouchState.mState == 2) {
                            rect.bottom = rect.top + ((rect.right - rect.left) / ratio);
                        } else if (this.mTouchState.mState == 7) {
                            rect.top = rect.bottom - ((rect.right - rect.left) / ratio);
                        } else if (this.mTouchState.mState == 4) {
                            rect.right = rect.left + ((rect.bottom - rect.top) * ratio);
                        } else if (this.mTouchState.mState == 5) {
                            rect.left = rect.right - ((rect.bottom - rect.top) * ratio);
                        }
                    } else {
                        float tmp_angle = angle;
                        if (tmp_angle < VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET) {
                            tmp_angle += 360.0f;
                        }
                        if (this.mTouchState.mState == 2) {
                            if (tmp_angle > VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET && tmp_angle < 90.0f) {
                                rect.right = rect.left + ((rect.bottom - rect.top) * ratio);
                            } else if (tmp_angle > 90.0f && tmp_angle < 180.0f) {
                                rect.left = rect.right - ((rect.bottom - rect.top) * ratio);
                            } else if (tmp_angle > 180.0f && tmp_angle < 270.0f) {
                                rect.bottom = rect.top + ((rect.right - rect.left) / ratio);
                            } else if (tmp_angle > 270.0f && tmp_angle < 360.0f) {
                                rect.bottom = rect.top + ((rect.right - rect.left) / ratio);
                            }
                        } else if (this.mTouchState.mState == 5) {
                            if (tmp_angle > VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET && tmp_angle < 90.0f) {
                                rect.top = rect.bottom - ((rect.right - rect.left) / ratio);
                            } else if (tmp_angle > 90.0f && tmp_angle < 180.0f) {
                                rect.left = rect.right - ((rect.bottom - rect.top) * ratio);
                            } else if (tmp_angle > 180.0f && tmp_angle < 270.0f) {
                                rect.left = rect.right - ((rect.bottom - rect.top) * ratio);
                            } else if (tmp_angle > 270.0f && tmp_angle < 360.0f) {
                                rect.bottom = rect.top + ((rect.right - rect.left) / ratio);
                            }
                        } else if (this.mTouchState.mState == 7) {
                            if (tmp_angle > VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET && tmp_angle < 90.0f) {
                                rect.top = rect.bottom - ((rect.right - rect.left) / ratio);
                            } else if (tmp_angle > 90.0f && tmp_angle < 180.0f) {
                                rect.top = rect.bottom - ((rect.right - rect.left) / ratio);
                            } else if (tmp_angle > 180.0f && tmp_angle < 270.0f) {
                                rect.left = rect.right - ((rect.bottom - rect.top) * ratio);
                            } else if (tmp_angle > 270.0f && tmp_angle < 360.0f) {
                                rect.right = rect.left + ((rect.bottom - rect.top) * ratio);
                            }
                        } else if (this.mTouchState.mState == 4) {
                            if (tmp_angle > VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET && tmp_angle < 90.0f) {
                                rect.right = rect.left + ((rect.bottom - rect.top) * ratio);
                            } else if (tmp_angle > 90.0f && tmp_angle < 180.0f) {
                                rect.top = rect.bottom - ((rect.right - rect.left) / ratio);
                            } else if (tmp_angle > 180.0f && tmp_angle < 270.0f) {
                                rect.bottom = rect.top + ((rect.right - rect.left) / ratio);
                            } else if (tmp_angle > 270.0f && tmp_angle < 360.0f) {
                                rect.right = rect.left + ((rect.bottom - rect.top) * ratio);
                            }
                        }
                    }
                    topleft4.set(rect.left, rect.top);
                    topleft4 = rotatePoint(px, py, angle, topleft4);
                    topright4.set(rect.right, rect.top);
                    topright4 = rotatePoint(px, py, angle, topright4);
                    bottomleft4.set(rect.left, rect.bottom);
                    bottomleft4 = rotatePoint(px, py, angle, bottomleft4);
                    bottomright4.set(rect.right, rect.bottom);
                    bottomright4 = rotatePoint(px, py, angle, bottomright4);
                }
            }
            float[] points5 = findPoints(topleft4, topright4, bottomleft4, bottomright4);
            float top3 = points5[1];
            if (top3 < this.mTempCoordinateInfo.frameRect.top) {
                if (Math.signum(originalRect.right - originalRect.left) != Math.signum(rect.right - rect.left)) {
                    this.mIsFlipDirectionHorizontal = true;
                }
                if (Math.signum(originalRect.bottom - originalRect.top) != Math.signum(rect.bottom - rect.top)) {
                    this.mIsFlipDirectionVertical = true;
                }
                float deltaY2 = this.mTempCoordinateInfo.frameRect.top - top3;
                if (Math.abs(top3 - topleft4.y) < SIGMA) {
                    topleft4.y += deltaY2;
                    topleft4 = rotatePoint(px, py, -angle, topleft4);
                    bottomright4 = rotatePoint(px, py, -angle, bottomright4);
                    points5 = findPoints(topleft4, bottomright4);
                } else if (Math.abs(top3 - topright4.y) < SIGMA) {
                    topright4.y += deltaY2;
                    topright4 = rotatePoint(px, py, -angle, topright4);
                    bottomleft4 = rotatePoint(px, py, -angle, bottomleft4);
                    points5 = findPoints(topright4, bottomleft4);
                } else if (Math.abs(top3 - bottomleft4.y) < SIGMA) {
                    bottomleft4.y += deltaY2;
                    topright4 = rotatePoint(px, py, -angle, topright4);
                    bottomleft4 = rotatePoint(px, py, -angle, bottomleft4);
                    points5 = findPoints(topright4, bottomleft4);
                } else if (Math.abs(top3 - bottomright4.y) < SIGMA) {
                    bottomright4.y += deltaY2;
                    topleft4 = rotatePoint(px, py, -angle, topleft4);
                    bottomright4 = rotatePoint(px, py, -angle, bottomright4);
                    points5 = findPoints(topleft4, bottomright4);
                }
                rect.set(points5[0], points5[1], points5[2], points5[3]);
                topleft4.set(rect.left, rect.top);
                topleft4 = rotatePoint(px, py, angle, topleft4);
                topright4.set(rect.right, rect.top);
                topright4 = rotatePoint(px, py, angle, topright4);
                bottomleft4.set(rect.left, rect.bottom);
                bottomleft4 = rotatePoint(px, py, angle, bottomleft4);
                bottomright4.set(rect.right, rect.bottom);
                bottomright4 = rotatePoint(px, py, angle, bottomright4);
                if (this.mTouchState.isCornerZonePressed()) {
                    if (Math.abs(topleft4.x - topright4.x) < SIGMA || Math.abs(topleft4.x - bottomleft4.x) < SIGMA) {
                        if (this.mTouchState.mState == 1) {
                            if (topleft4.x > bottomleft4.x) {
                                rect.bottom = rect.top + ((rect.right - rect.left) / ratio);
                            } else {
                                rect.right = rect.left + ((rect.bottom - rect.top) * ratio);
                            }
                        } else if (this.mTouchState.mState == 6) {
                            if (bottomleft4.x > bottomright4.x) {
                                rect.right = rect.left + ((rect.bottom - rect.top) * ratio);
                            } else {
                                rect.top = rect.bottom - ((rect.right - rect.left) / ratio);
                            }
                        } else if (this.mTouchState.mState == 8) {
                            if (bottomright4.x > topright4.x) {
                                rect.top = rect.bottom - ((rect.right - rect.left) / ratio);
                            } else {
                                rect.left = rect.right - ((rect.bottom - rect.top) * ratio);
                            }
                        } else if (this.mTouchState.mState == 3) {
                            if (topright4.x > topleft4.x) {
                                rect.left = rect.right - ((rect.bottom - rect.top) * ratio);
                            } else {
                                rect.bottom = rect.top + ((rect.right - rect.left) / ratio);
                            }
                        }
                    } else if (this.mTouchState.mState == 1) {
                        if (topleft4.x > bottomleft4.x) {
                            rect.right = rect.left + ((rect.bottom - rect.top) * ratio);
                        } else {
                            rect.bottom = rect.top + ((rect.right - rect.left) / ratio);
                        }
                    } else if (this.mTouchState.mState == 6) {
                        if (bottomleft4.x > bottomright4.x) {
                            rect.top = rect.bottom - ((rect.right - rect.left) / ratio);
                        } else {
                            rect.right = rect.left + ((rect.bottom - rect.top) * ratio);
                        }
                    } else if (this.mTouchState.mState == 8) {
                        if (bottomright4.x > topright4.x) {
                            rect.left = rect.right - ((rect.bottom - rect.top) * ratio);
                        } else {
                            rect.top = rect.bottom - ((rect.right - rect.left) / ratio);
                        }
                    } else if (this.mTouchState.mState == 3) {
                        if (topright4.x > topleft4.x) {
                            rect.bottom = rect.top + ((rect.right - rect.left) / ratio);
                        } else {
                            rect.left = rect.right - ((rect.bottom - rect.top) * ratio);
                        }
                    }
                    topleft4.set(rect.left, rect.top);
                    topleft4 = rotatePoint(px, py, angle, topleft4);
                    topright4.set(rect.right, rect.top);
                    topright4 = rotatePoint(px, py, angle, topright4);
                    bottomleft4.set(rect.left, rect.bottom);
                    bottomleft4 = rotatePoint(px, py, angle, bottomleft4);
                    bottomright4.set(rect.right, rect.bottom);
                    bottomright4 = rotatePoint(px, py, angle, bottomright4);
                } else if (isKeepRatio && !this.mTouchState.isCornerZonePressed()) {
                    if (Math.abs(topleft4.x - topright4.x) < SIGMA || Math.abs(topleft4.x - bottomleft4.x) < SIGMA) {
                        if (this.mTouchState.mState == 2) {
                            rect.bottom = rect.top + ((rect.right - rect.left) / ratio);
                        } else if (this.mTouchState.mState == 7) {
                            rect.top = rect.bottom - ((rect.right - rect.left) / ratio);
                        } else if (this.mTouchState.mState == 4) {
                            rect.right = rect.left + ((rect.bottom - rect.top) * ratio);
                        } else if (this.mTouchState.mState == 5) {
                            rect.left = rect.right - ((rect.bottom - rect.top) * ratio);
                        }
                    } else {
                        float tmp_angle2 = angle;
                        if (tmp_angle2 < VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET) {
                            tmp_angle2 += 360.0f;
                        }
                        if (this.mTouchState.mState == 2) {
                            if (tmp_angle2 > VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET && tmp_angle2 < 90.0f) {
                                rect.bottom = rect.top + ((rect.right - rect.left) / ratio);
                            } else if (tmp_angle2 > 90.0f && tmp_angle2 < 180.0f) {
                                rect.right = rect.left + ((rect.bottom - rect.top) * ratio);
                            } else if (tmp_angle2 > 180.0f && tmp_angle2 < 270.0f) {
                                rect.left = rect.right - ((rect.bottom - rect.top) * ratio);
                            } else if (tmp_angle2 > 270.0f && tmp_angle2 < 360.0f) {
                                rect.bottom = rect.top + ((rect.right - rect.left) / ratio);
                            }
                        } else if (this.mTouchState.mState == 5) {
                            if (tmp_angle2 > VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET && tmp_angle2 < 90.0f) {
                                rect.bottom = rect.top + ((rect.right - rect.left) / ratio);
                            } else if (tmp_angle2 > 90.0f && tmp_angle2 < 180.0f) {
                                rect.top = rect.bottom - ((rect.right - rect.left) / ratio);
                            } else if (tmp_angle2 > 180.0f && tmp_angle2 < 270.0f) {
                                rect.left = rect.right - ((rect.bottom - rect.top) * ratio);
                            } else if (tmp_angle2 > 270.0f && tmp_angle2 < 360.0f) {
                                rect.left = rect.right - ((rect.bottom - rect.top) * ratio);
                            }
                        } else if (this.mTouchState.mState == 7) {
                            if (tmp_angle2 > VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET && tmp_angle2 < 90.0f) {
                                rect.right = rect.left + ((rect.bottom - rect.top) * ratio);
                            } else if (tmp_angle2 > 90.0f && tmp_angle2 < 180.0f) {
                                rect.top = rect.bottom - ((rect.right - rect.left) / ratio);
                            } else if (tmp_angle2 > 180.0f && tmp_angle2 < 270.0f) {
                                rect.top = rect.bottom - ((rect.right - rect.left) / ratio);
                            } else if (tmp_angle2 > 270.0f && tmp_angle2 < 360.0f) {
                                rect.left = rect.right - ((rect.bottom - rect.top) * ratio);
                            }
                        } else if (this.mTouchState.mState == 4) {
                            if (tmp_angle2 > VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET && tmp_angle2 < 90.0f) {
                                rect.right = rect.left + ((rect.bottom - rect.top) * ratio);
                            } else if (tmp_angle2 > 90.0f && tmp_angle2 < 180.0f) {
                                rect.right = rect.left + ((rect.bottom - rect.top) * ratio);
                            } else if (tmp_angle2 > 180.0f && tmp_angle2 < 270.0f) {
                                rect.top = rect.bottom - ((rect.right - rect.left) / ratio);
                            } else if (tmp_angle2 > 270.0f && tmp_angle2 < 360.0f) {
                                rect.bottom = rect.top + ((rect.right - rect.left) / ratio);
                            }
                        }
                    }
                    topleft4.set(rect.left, rect.top);
                    topleft4 = rotatePoint(px, py, angle, topleft4);
                    topright4.set(rect.right, rect.top);
                    topright4 = rotatePoint(px, py, angle, topright4);
                    bottomleft4.set(rect.left, rect.bottom);
                    bottomleft4 = rotatePoint(px, py, angle, bottomleft4);
                    bottomright4.set(rect.right, rect.bottom);
                    bottomright4 = rotatePoint(px, py, angle, bottomright4);
                }
            }
            float[] points6 = findPoints(topleft4, topright4, bottomleft4, bottomright4);
            float right2 = points6[2];
            if (right2 > this.mTempCoordinateInfo.frameRect.right) {
                if (Math.signum(originalRect.right - originalRect.left) != Math.signum(rect.right - rect.left)) {
                    this.mIsFlipDirectionHorizontal = true;
                }
                if (Math.signum(originalRect.bottom - originalRect.top) != Math.signum(rect.bottom - rect.top)) {
                    this.mIsFlipDirectionVertical = true;
                }
                float deltaX3 = this.mTempCoordinateInfo.frameRect.right - right2;
                if (Math.abs(right2 - topleft4.x) < SIGMA) {
                    topleft4.x += deltaX3;
                    topleft4 = rotatePoint(px, py, -angle, topleft4);
                    bottomright4 = rotatePoint(px, py, -angle, bottomright4);
                    points6 = findPoints(topleft4, bottomright4);
                } else if (Math.abs(right2 - topright4.x) < SIGMA) {
                    topright4.x += deltaX3;
                    topright4 = rotatePoint(px, py, -angle, topright4);
                    bottomleft4 = rotatePoint(px, py, -angle, bottomleft4);
                    points6 = findPoints(topright4, bottomleft4);
                } else if (Math.abs(right2 - bottomleft4.x) < SIGMA) {
                    bottomleft4.x += deltaX3;
                    topright4 = rotatePoint(px, py, -angle, topright4);
                    bottomleft4 = rotatePoint(px, py, -angle, bottomleft4);
                    points6 = findPoints(topright4, bottomleft4);
                } else if (Math.abs(right2 - bottomright4.x) < SIGMA) {
                    bottomright4.x += deltaX3;
                    topleft4 = rotatePoint(px, py, -angle, topleft4);
                    bottomright4 = rotatePoint(px, py, -angle, bottomright4);
                    points6 = findPoints(topleft4, bottomright4);
                }
                rect.set(points6[0], points6[1], points6[2], points6[3]);
                topleft4.set(rect.left, rect.top);
                topleft4 = rotatePoint(px, py, angle, topleft4);
                topright4.set(rect.right, rect.top);
                topright4 = rotatePoint(px, py, angle, topright4);
                bottomleft4.set(rect.left, rect.bottom);
                bottomleft4 = rotatePoint(px, py, angle, bottomleft4);
                bottomright4.set(rect.right, rect.bottom);
                bottomright4 = rotatePoint(px, py, angle, bottomright4);
                if (this.mTouchState.isCornerZonePressed()) {
                    if (Math.abs(topleft4.x - topright4.x) < SIGMA || Math.abs(topleft4.x - bottomleft4.x) < SIGMA) {
                        if (this.mTouchState.mState == 1) {
                            if (topleft4.y > bottomleft4.y) {
                                rect.bottom = rect.top + ((rect.right - rect.left) / ratio);
                            } else {
                                rect.right = rect.left + ((rect.bottom - rect.top) * ratio);
                            }
                        } else if (this.mTouchState.mState == 6) {
                            if (bottomleft4.y > bottomright4.y) {
                                rect.right = rect.left + ((rect.bottom - rect.top) * ratio);
                            } else {
                                rect.top = rect.bottom - ((rect.right - rect.left) / ratio);
                            }
                        } else if (this.mTouchState.mState == 8) {
                            if (bottomright4.y > topright4.y) {
                                rect.top = rect.bottom - ((rect.right - rect.left) / ratio);
                            } else {
                                rect.left = rect.right - ((rect.bottom - rect.top) * ratio);
                            }
                        } else if (this.mTouchState.mState == 3) {
                            if (topright4.y > topleft4.y) {
                                rect.left = rect.right - ((rect.bottom - rect.top) * ratio);
                            } else {
                                rect.bottom = rect.top + ((rect.right - rect.left) / ratio);
                            }
                        }
                    } else if (this.mTouchState.mState == 1) {
                        if (topleft4.y > bottomleft4.y) {
                            rect.right = rect.left + ((rect.bottom - rect.top) * ratio);
                        } else {
                            rect.bottom = rect.top + ((rect.right - rect.left) / ratio);
                        }
                    } else if (this.mTouchState.mState == 6) {
                        if (bottomleft4.y > bottomright4.y) {
                            rect.top = rect.bottom - ((rect.right - rect.left) / ratio);
                        } else {
                            rect.right = rect.left + ((rect.bottom - rect.top) * ratio);
                        }
                    } else if (this.mTouchState.mState == 8) {
                        if (bottomright4.y > topright4.y) {
                            rect.left = rect.right - ((rect.bottom - rect.top) * ratio);
                        } else {
                            rect.top = rect.bottom - ((rect.right - rect.left) / ratio);
                        }
                    } else if (this.mTouchState.mState == 3) {
                        if (topright4.y > topleft4.y) {
                            rect.bottom = rect.top + ((rect.right - rect.left) / ratio);
                        } else {
                            rect.left = rect.right - ((rect.bottom - rect.top) * ratio);
                        }
                    }
                    topleft4.set(rect.left, rect.top);
                    topleft4 = rotatePoint(px, py, angle, topleft4);
                    topright4.set(rect.right, rect.top);
                    topright4 = rotatePoint(px, py, angle, topright4);
                    bottomleft4.set(rect.left, rect.bottom);
                    bottomleft4 = rotatePoint(px, py, angle, bottomleft4);
                    bottomright4.set(rect.right, rect.bottom);
                    bottomright4 = rotatePoint(px, py, angle, bottomright4);
                } else if (isKeepRatio && !this.mTouchState.isCornerZonePressed()) {
                    if (Math.abs(topleft4.x - topright4.x) < SIGMA || Math.abs(topleft4.x - bottomleft4.x) < SIGMA) {
                        if (this.mTouchState.mState == 2) {
                            rect.bottom = rect.top + ((rect.right - rect.left) / ratio);
                        } else if (this.mTouchState.mState == 7) {
                            rect.top = rect.bottom - ((rect.right - rect.left) / ratio);
                        } else if (this.mTouchState.mState == 4) {
                            rect.right = rect.left + ((rect.bottom - rect.top) * ratio);
                        } else if (this.mTouchState.mState == 5) {
                            rect.left = rect.right - ((rect.bottom - rect.top) * ratio);
                        }
                    } else {
                        float tmp_angle3 = angle;
                        if (tmp_angle3 < VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET) {
                            tmp_angle3 += 360.0f;
                        }
                        if (this.mTouchState.mState == 2) {
                            if (tmp_angle3 > VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET && tmp_angle3 < 90.0f) {
                                rect.bottom = rect.top + ((rect.right - rect.left) / ratio);
                            } else if (tmp_angle3 > 90.0f && tmp_angle3 < 180.0f) {
                                rect.bottom = rect.top + ((rect.right - rect.left) / ratio);
                            } else if (tmp_angle3 > 180.0f && tmp_angle3 < 270.0f) {
                                rect.right = rect.left + ((rect.bottom - rect.top) * ratio);
                            } else if (tmp_angle3 > 270.0f && tmp_angle3 < 360.0f) {
                                rect.left = rect.right - ((rect.bottom - rect.top) * ratio);
                            }
                        } else if (this.mTouchState.mState == 5) {
                            if (tmp_angle3 > VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET && tmp_angle3 < 90.0f) {
                                rect.left = rect.right - ((rect.bottom - rect.top) * ratio);
                            } else if (tmp_angle3 > 90.0f && tmp_angle3 < 180.0f) {
                                rect.bottom = rect.top + ((rect.right - rect.left) / ratio);
                            } else if (tmp_angle3 > 180.0f && tmp_angle3 < 270.0f) {
                                rect.top = rect.bottom - ((rect.right - rect.left) / ratio);
                            } else if (tmp_angle3 > 270.0f && tmp_angle3 < 360.0f) {
                                rect.left = rect.right - ((rect.bottom - rect.top) * ratio);
                            }
                        } else if (this.mTouchState.mState == 7) {
                            if (tmp_angle3 > VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET && tmp_angle3 < 90.0f) {
                                rect.left = rect.right - ((rect.bottom - rect.top) * ratio);
                            } else if (tmp_angle3 > 90.0f && tmp_angle3 < 180.0f) {
                                rect.right = rect.left + ((rect.bottom - rect.top) * ratio);
                            } else if (tmp_angle3 > 180.0f && tmp_angle3 < 270.0f) {
                                rect.top = rect.bottom - ((rect.right - rect.left) / ratio);
                            } else if (tmp_angle3 > 270.0f && tmp_angle3 < 360.0f) {
                                rect.top = rect.bottom - ((rect.right - rect.left) / ratio);
                            }
                        } else if (this.mTouchState.mState == 4) {
                            if (tmp_angle3 > VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET && tmp_angle3 < 90.0f) {
                                rect.bottom = rect.top + ((rect.right - rect.left) / ratio);
                            } else if (tmp_angle3 > 90.0f && tmp_angle3 < 180.0f) {
                                rect.right = rect.left + ((rect.bottom - rect.top) * ratio);
                            } else if (tmp_angle3 > 180.0f && tmp_angle3 < 270.0f) {
                                rect.right = rect.left + ((rect.bottom - rect.top) * ratio);
                            } else if (tmp_angle3 > 270.0f && tmp_angle3 < 360.0f) {
                                rect.top = rect.bottom - ((rect.right - rect.left) / ratio);
                            }
                        }
                    }
                    topleft4.set(rect.left, rect.top);
                    topleft4 = rotatePoint(px, py, angle, topleft4);
                    topright4.set(rect.right, rect.top);
                    topright4 = rotatePoint(px, py, angle, topright4);
                    bottomleft4.set(rect.left, rect.bottom);
                    bottomleft4 = rotatePoint(px, py, angle, bottomleft4);
                    bottomright4.set(rect.right, rect.bottom);
                    bottomright4 = rotatePoint(px, py, angle, bottomright4);
                }
            }
            float[] points7 = findPoints(topleft4, topright4, bottomleft4, bottomright4);
            float bottom2 = points7[3];
            if (bottom2 > this.mTempCoordinateInfo.frameRect.bottom) {
                if (Math.signum(originalRect.right - originalRect.left) != Math.signum(rect.right - rect.left)) {
                    this.mIsFlipDirectionHorizontal = true;
                }
                if (Math.signum(originalRect.bottom - originalRect.top) != Math.signum(rect.bottom - rect.top)) {
                    this.mIsFlipDirectionVertical = true;
                }
                float deltaY3 = this.mTempCoordinateInfo.frameRect.bottom - bottom2;
                if (Math.abs(bottom2 - topleft4.y) < SIGMA) {
                    topleft4.y += deltaY3;
                    topleft4 = rotatePoint(px, py, -angle, topleft4);
                    bottomright4 = rotatePoint(px, py, -angle, bottomright4);
                    points7 = findPoints(topleft4, bottomright4);
                } else if (Math.abs(bottom2 - topright4.y) < SIGMA) {
                    topright4.y += deltaY3;
                    topright4 = rotatePoint(px, py, -angle, topright4);
                    bottomleft4 = rotatePoint(px, py, -angle, bottomleft4);
                    points7 = findPoints(topright4, bottomleft4);
                } else if (Math.abs(bottom2 - bottomleft4.y) < SIGMA) {
                    bottomleft4.y += deltaY3;
                    topright4 = rotatePoint(px, py, -angle, topright4);
                    bottomleft4 = rotatePoint(px, py, -angle, bottomleft4);
                    points7 = findPoints(topright4, bottomleft4);
                } else if (Math.abs(bottom2 - bottomright4.y) < SIGMA) {
                    bottomright4.y += deltaY3;
                    topleft4 = rotatePoint(px, py, -angle, topleft4);
                    bottomright4 = rotatePoint(px, py, -angle, bottomright4);
                    points7 = findPoints(topleft4, bottomright4);
                }
                rect.set(points7[0], points7[1], points7[2], points7[3]);
                topleft4.set(rect.left, rect.top);
                PointF topleft5 = rotatePoint(px, py, angle, topleft4);
                topright4.set(rect.right, rect.top);
                PointF topright5 = rotatePoint(px, py, angle, topright4);
                bottomleft4.set(rect.left, rect.bottom);
                PointF bottomleft5 = rotatePoint(px, py, angle, bottomleft4);
                bottomright4.set(rect.right, rect.bottom);
                PointF bottomright5 = rotatePoint(px, py, angle, bottomright4);
                if (this.mTouchState.isCornerZonePressed()) {
                    if (Math.abs(topleft5.x - topright5.x) < SIGMA || Math.abs(topleft5.x - bottomleft5.x) < SIGMA) {
                        if (this.mTouchState.mState == 1) {
                            if (topleft5.x < bottomleft5.x) {
                                rect.bottom = rect.top + ((rect.right - rect.left) / ratio);
                            } else {
                                rect.right = rect.left + ((rect.bottom - rect.top) * ratio);
                            }
                        } else if (this.mTouchState.mState == 6) {
                            if (bottomleft5.x < bottomright5.x) {
                                rect.right = rect.left + ((rect.bottom - rect.top) * ratio);
                            } else {
                                rect.top = rect.bottom - ((rect.right - rect.left) / ratio);
                            }
                        } else if (this.mTouchState.mState == 8) {
                            if (bottomright5.x < topright5.x) {
                                rect.top = rect.bottom - ((rect.right - rect.left) / ratio);
                            } else {
                                rect.left = rect.right - ((rect.bottom - rect.top) * ratio);
                            }
                        } else if (this.mTouchState.mState == 3) {
                            if (topright5.x < topleft5.x) {
                                rect.left = rect.right - ((rect.bottom - rect.top) * ratio);
                            } else {
                                rect.bottom = rect.top + ((rect.right - rect.left) / ratio);
                            }
                        }
                    } else if (this.mTouchState.mState == 1) {
                        if (topleft5.x < bottomleft5.x) {
                            rect.right = rect.left + ((rect.bottom - rect.top) * ratio);
                        } else {
                            rect.bottom = rect.top + ((rect.right - rect.left) / ratio);
                        }
                    } else if (this.mTouchState.mState == 6) {
                        if (bottomleft5.x < bottomright5.x) {
                            rect.top = rect.bottom - ((rect.right - rect.left) / ratio);
                        } else {
                            rect.right = rect.left + ((rect.bottom - rect.top) * ratio);
                        }
                    } else if (this.mTouchState.mState == 8) {
                        if (bottomright5.x < topright5.x) {
                            rect.left = rect.right - ((rect.bottom - rect.top) * ratio);
                        } else {
                            rect.top = rect.bottom - ((rect.right - rect.left) / ratio);
                        }
                    } else if (this.mTouchState.mState == 3) {
                        if (topright5.x < topleft5.x) {
                            rect.bottom = rect.top + ((rect.right - rect.left) / ratio);
                        } else {
                            rect.left = rect.right - ((rect.bottom - rect.top) * ratio);
                        }
                    }
                } else if (isKeepRatio && !this.mTouchState.isCornerZonePressed()) {
                    if (Math.abs(topleft5.x - topright5.x) < SIGMA || Math.abs(topleft5.x - bottomleft5.x) < SIGMA) {
                        if (this.mTouchState.mState == 2) {
                            rect.bottom = rect.top + ((rect.right - rect.left) / ratio);
                        } else if (this.mTouchState.mState == 7) {
                            rect.top = rect.bottom - ((rect.right - rect.left) / ratio);
                        } else if (this.mTouchState.mState == 4) {
                            rect.right = rect.left + ((rect.bottom - rect.top) * ratio);
                        } else if (this.mTouchState.mState == 5) {
                            rect.left = rect.right - ((rect.bottom - rect.top) * ratio);
                        }
                    } else {
                        float tmp_angle4 = angle;
                        if (tmp_angle4 < VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET) {
                            tmp_angle4 += 360.0f;
                        }
                        if (this.mTouchState.mState == 2) {
                            if (tmp_angle4 > VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET && tmp_angle4 < 90.0f) {
                                rect.left = rect.right - ((rect.bottom - rect.top) * ratio);
                            } else if (tmp_angle4 > 90.0f && tmp_angle4 < 180.0f) {
                                rect.bottom = rect.top + ((rect.right - rect.left) / ratio);
                            } else if (tmp_angle4 > 180.0f && tmp_angle4 < 270.0f) {
                                rect.bottom = rect.top + ((rect.right - rect.left) / ratio);
                            } else if (tmp_angle4 > 270.0f && tmp_angle4 < 360.0f) {
                                rect.right = rect.left + ((rect.bottom - rect.top) * ratio);
                            }
                        } else if (this.mTouchState.mState == 5) {
                            if (tmp_angle4 > VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET && tmp_angle4 < 90.0f) {
                                rect.left = rect.right - ((rect.bottom - rect.top) * ratio);
                            } else if (tmp_angle4 > 90.0f && tmp_angle4 < 180.0f) {
                                rect.left = rect.right - ((rect.bottom - rect.top) * ratio);
                            } else if (tmp_angle4 > 180.0f && tmp_angle4 < 270.0f) {
                                rect.bottom = rect.top + ((rect.right - rect.left) / ratio);
                            } else if (tmp_angle4 > 270.0f && tmp_angle4 < 360.0f) {
                                rect.top = rect.bottom - ((rect.right - rect.left) / ratio);
                            }
                        } else if (this.mTouchState.mState == 7) {
                            if (tmp_angle4 > VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET && tmp_angle4 < 90.0f) {
                                rect.top = rect.bottom - ((rect.right - rect.left) / ratio);
                            } else if (tmp_angle4 > 90.0f && tmp_angle4 < 180.0f) {
                                rect.left = rect.right - ((rect.bottom - rect.top) * ratio);
                            } else if (tmp_angle4 > 180.0f && tmp_angle4 < 270.0f) {
                                rect.right = rect.left + ((rect.bottom - rect.top) * ratio);
                            } else if (tmp_angle4 > 270.0f && tmp_angle4 < 360.0f) {
                                rect.top = rect.bottom - ((rect.right - rect.left) / ratio);
                            }
                        } else if (this.mTouchState.mState == 4) {
                            if (tmp_angle4 > VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET && tmp_angle4 < 90.0f) {
                                rect.top = rect.bottom - ((rect.right - rect.left) / ratio);
                            } else if (tmp_angle4 > 90.0f && tmp_angle4 < 180.0f) {
                                rect.bottom = rect.top + ((rect.right - rect.left) / ratio);
                            } else if (tmp_angle4 > 180.0f && tmp_angle4 < 270.0f) {
                                rect.right = rect.left + ((rect.bottom - rect.top) * ratio);
                            } else if (tmp_angle4 > 270.0f && tmp_angle4 < 360.0f) {
                                rect.right = rect.left + ((rect.bottom - rect.top) * ratio);
                            }
                        }
                    }
                }
            }
        } else if (isRotating) {
            PointF topleft6 = new PointF(rect.left, rect.top);
            PointF topleft7 = rotatePoint(px, py, angle, topleft6);
            PointF topright6 = new PointF(rect.right, rect.top);
            PointF topright7 = rotatePoint(px, py, angle, topright6);
            PointF bottomleft6 = new PointF(rect.left, rect.bottom);
            PointF bottomleft7 = rotatePoint(px, py, angle, bottomleft6);
            PointF bottomright6 = new PointF(rect.right, rect.bottom);
            float[] points8 = findPoints(topleft7, topright7, bottomleft7, rotatePoint(px, py, angle, bottomright6));
            float left4 = points8[0];
            float top4 = points8[1];
            float right3 = points8[2];
            float bottom3 = points8[3];
            if (isResizing && left4 + changeX < this.mTempCoordinateInfo.frameRect.left) {
                SpenSLog.m135d(false, " Clipped X Left : " + left4 + changeX);
                return true;
            }
            if (isRotating && left4 < this.mTempCoordinateInfo.frameRect.left) {
                return true;
            }
            if (isResizing && right3 + changeX > this.mTempCoordinateInfo.frameRect.right) {
                SpenSLog.m135d(false, " Clipped X Right " + right3 + changeX);
                return true;
            }
            if (isRotating && right3 > this.mTempCoordinateInfo.frameRect.right) {
                return true;
            }
            if (isResizing && top4 + changeY < this.mTempCoordinateInfo.frameRect.top) {
                SpenSLog.m135d(false, " Clipped Top " + top4 + changeY);
                return true;
            }
            if (isRotating && top4 < this.mTempCoordinateInfo.frameRect.top) {
                return true;
            }
            if (isResizing && bottom3 + changeY > this.mTempCoordinateInfo.frameRect.bottom) {
                SpenSLog.m135d(false, " Clipped Bottom " + bottom3 + changeY);
                return true;
            }
            if (isRotating && bottom3 > this.mTempCoordinateInfo.frameRect.bottom) {
                return true;
            }
        }
        return false;
    }

    protected void onCheckTouchPosition(RectF rect, int x, int y, SpenObjectBase objectBase, CTouchState touchState) {
        this.mTouchZone.checkTouchPosition(rect, x, y, objectBase, touchState);
    }

    protected void draw8Points(Drawable drawable, Canvas canvas, RectF rect, boolean isKeepRatio) {
        int w = drawable.getIntrinsicWidth();
        int h = drawable.getIntrinsicHeight();
        int halfX = Math.round(w / 2.0f);
        int halfY = Math.round(h / 2.0f);
        int CenterX = Math.round(rect.centerX());
        int CenterY = Math.round(rect.centerY());
        Rect tmpRect = new Rect();
        rect.round(tmpRect);
        Rect bounds = new Rect();
        bounds.set(tmpRect.left - halfX, tmpRect.top - halfY, tmpRect.left + halfX, tmpRect.top + halfY);
        drawable.setBounds(bounds);
        drawable.draw(canvas);
        bounds.set(tmpRect.right - halfX, tmpRect.top - halfY, tmpRect.right + halfX, tmpRect.top + halfY);
        drawable.setBounds(bounds);
        drawable.draw(canvas);
        bounds.set(tmpRect.left - halfX, tmpRect.bottom - halfY, tmpRect.left + halfX, tmpRect.bottom + halfY);
        drawable.setBounds(bounds);
        drawable.draw(canvas);
        bounds.set(tmpRect.right - halfX, tmpRect.bottom - halfY, tmpRect.right + halfX, tmpRect.bottom + halfY);
        drawable.setBounds(bounds);
        drawable.draw(canvas);
        if (Math.abs(rect.width()) > 80.0f) {
            bounds.set(CenterX - halfX, tmpRect.top - halfY, CenterX + halfX, tmpRect.top + halfY);
            drawable.setBounds(bounds);
            drawable.draw(canvas);
            bounds.set(CenterX - halfX, tmpRect.bottom - halfY, CenterX + halfX, tmpRect.bottom + halfY);
            drawable.setBounds(bounds);
            drawable.draw(canvas);
        }
        if (Math.abs(rect.height()) > 80.0f) {
            bounds.set(tmpRect.left - halfX, CenterY - halfY, tmpRect.left + halfX, CenterY + halfY);
            drawable.setBounds(bounds);
            drawable.draw(canvas);
            bounds.set(tmpRect.right - halfX, CenterY - halfY, tmpRect.right + halfX, CenterY + halfY);
            drawable.setBounds(bounds);
            drawable.draw(canvas);
        }
    }

    protected void onDrawBorder(Canvas canvas, RectF rect, SpenObjectBase objectBase) throws Resources.NotFoundException, PackageManager.NameNotFoundException, IOException {
        Drawable drawable;
        if (this.mStyle != 1) {
            boolean isEightPoint = objectBase.isRotatable() || objectBase.getResizeOption() != 2;
            boolean isRotatable = objectBase.isRotatable();
            boolean isKeepRatio = objectBase.getResizeOption() == 1;
            if (this.mStyle == 2) {
                isEightPoint = false;
                isRotatable = false;
            }
            if (isRotatable) {
                RectF rotateRect = this.mTouchZone.getRect(0, rect);
                float startX = rotateRect.centerX();
                float startY = rotateRect.centerY();
                float stopX = rect.centerX();
                float stopY = rect.top;
                canvas.drawLine(startX, startY, stopX, stopY, this.mTempPaint.getPaint(1));
                Drawable drawable2 = getDrawableImage(DEFAULT_ROTATE_POINT_BORDER);
                if (drawable2 != null) {
                    float hx = drawable2.getIntrinsicWidth() / 2.0f;
                    float hy = drawable2.getIntrinsicWidth() / 2.0f;
                    if (SpenContextMenu.getType() == 1) {
                        hx = (46.0f * hx) / 30.0f;
                        hy = (46.0f * hy) / 30.0f;
                    }
                    float CenterX = rotateRect.centerX();
                    float CenterY = rotateRect.centerY();
                    drawable2.setBounds((int) (CenterX - hx), (int) (CenterY - hy), (int) (CenterX + hx), (int) (CenterY + hy));
                    drawable2.draw(canvas);
                }
            }
            if (isEightPoint) {
                if (SpenContextMenu.getType() == 1) {
                    drawable = resizeImage(DEFAULT_BORDER_POINT, 38, 38);
                } else {
                    drawable = resizeImage(DEFAULT_BORDER_POINT, 22, 22);
                }
                if (drawable != null) {
                    canvas.drawRect(rect, this.mTempPaint.getPaint(1));
                    draw8Points(drawable, canvas, rect, isKeepRatio);
                    return;
                }
                return;
            }
            Paint paint = this.mTempPaint.getPaint(1);
            paint.setStrokeWidth(4.0f);
            rect.set((rect.left - 4.0f) + 1.0f, (rect.top - 4.0f) + 1.0f, (rect.right + 4.0f) - 1.0f, (rect.bottom + 4.0f) - 1.0f);
            canvas.drawRect(rect, paint);
        }
    }

    private Drawable resizeImage(String drawableName, int iconWidth, int iconHeight) throws PackageManager.NameNotFoundException {
        Bitmap BitmapOrg;
        PackageManager manager = getContext().getPackageManager();
        try {
            Resources mApk1Resources = manager.getResourcesForApplication(Spen.SPEN_NATIVE_PACKAGE_NAME);
            int mDrawableResID = mApk1Resources.getIdentifier(drawableName, "drawable", Spen.SPEN_NATIVE_PACKAGE_NAME);
            if (mDrawableResID == 0 || (BitmapOrg = BitmapFactory.decodeResource(mApk1Resources, mDrawableResID)) == null) {
                return null;
            }
            int width = BitmapOrg.getWidth();
            int height = BitmapOrg.getHeight();
            DisplayMetrics dm = getContext().getResources().getDisplayMetrics();
            int newWidth = (int) TypedValue.applyDimension(1, iconWidth, dm);
            int newHeight = (int) TypedValue.applyDimension(1, iconHeight, dm);
            float scaleWidth = newWidth / width;
            float scaleHeight = newHeight / height;
            Matrix matrix = new Matrix();
            matrix.postScale(scaleWidth, scaleHeight);
            Bitmap resizedBitmap = Bitmap.createBitmap(BitmapOrg, 0, 0, width, height, matrix, true);
            return new BitmapDrawable(mApk1Resources, resizedBitmap);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    protected void onRequestScroll(float dx, float dy) {
        if (this.mListener != null) {
            this.mListener.onRequestScroll(dx, dy);
        }
    }

    protected void onObjectChanged() {
        SpenSLog.m135d(false, "onObjectChanged is called..");
        if (isObjectAvailable()) {
            if (this.mContextMenu.mInstance == null || !this.mContextMenu.mFirstDraw) {
                boolean isTransaction = true;
                for (int i = 0; i < this.mObjectBaseList.size(); i++) {
                    if (!this.mObjectBaseList.get(i).isOutOfViewEnabled()) {
                        RectF rectF = this.mRectList.get(i);
                        if (this.mTouchState.isRotateZonePressed()) {
                            if (isClippedObject(i, true, false, false, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, this.mRotateAngle, false, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET)) {
                                isTransaction = false;
                                rectF.set(getBorderRect(i));
                            }
                        } else if (!this.mTouchState.isResizeZonePressed()) {
                            isClippedObject(i, false, true, false, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, this.mObjectBaseList.get(i).getRotation(), false, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET);
                        }
                    }
                }
                if (!isTransaction) {
                    invalidate();
                    if (this.mContextMenu.mInstance != null) {
                        updateContextMenu();
                        this.mContextMenu.show();
                        return;
                    }
                    return;
                }
                if (this.mListener != null) {
                    this.mTempCoordinateInfo.reset();
                    this.mListener.onRequestCoordinateInfo(this.mTempCoordinateInfo);
                    RectF objectRect = new RectF();
                    float rotateDiff = VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET;
                    int index = this.mTouchState.mTouchedObjectIndex;
                    if (this.mTouchState.mTouchedObjectIndex != -1) {
                        rotateDiff = this.mRotateAngle - getBorderAngle(this.mTouchState.mTouchedObjectIndex);
                    }
                    for (int i2 = 0; i2 < this.mObjectBaseList.size(); i2++) {
                        if (this.mTouchState.isResizeZonePressed() || this.mTouchState.mState == -1) {
                            resize2Threshold(i2);
                        }
                        absoluteCoordinate(objectRect, this.mRectList.get(i2), this.mTempCoordinateInfo);
                        SpenObjectBase object = this.mObjectBaseList.get(i2);
                        if (!object.isFlipEnabled()) {
                            if (objectRect.left > objectRect.right) {
                                float temp = objectRect.right;
                                objectRect.right = objectRect.left;
                                objectRect.left = temp;
                            }
                            if (objectRect.top > objectRect.bottom) {
                                float temp2 = objectRect.top;
                                objectRect.top = objectRect.bottom;
                                objectRect.bottom = temp2;
                            }
                        }
                        object.setRect(objectRect, false);
                        float objAng = this.mRotateAngle;
                        if (i2 != index) {
                            objAng = normalizeDegree(object.getRotation() + rotateDiff);
                        }
                        if (getRotateable(i2)) {
                            object.setRotation((int) objAng);
                        }
                    }
                    this.mListener.onObjectChanged(this.mObjectBaseList);
                }
                fit();
                invalidate();
            }
        }
    }

    protected void applyChange() {
        if (this.mListener != null) {
            this.mTempCoordinateInfo.reset();
            this.mListener.onRequestCoordinateInfo(this.mTempCoordinateInfo);
            RectF objectRect = new RectF();
            SpenSLog.m135d(false, "onObjectChanged applyChange " + this.mTempCoordinateInfo);
            float rotateDiff = VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET;
            int index = this.mTouchState.mTouchedObjectIndex;
            if (this.mTouchState.mTouchedObjectIndex != -1) {
                rotateDiff = this.mRotateAngle - getBorderAngle(this.mTouchState.mTouchedObjectIndex);
            }
            for (int i = 0; i < this.mObjectBaseList.size(); i++) {
                absoluteCoordinate(objectRect, this.mRectList.get(i), this.mTempCoordinateInfo);
                SpenSLog.m135d(false, "onObjectChanged applyChange " + this.mRectList.get(i));
                SpenObjectBase object = this.mObjectBaseList.get(i);
                object.setRect(objectRect, false);
                float objAng = this.mRotateAngle;
                if (i != index) {
                    objAng = normalizeDegree(object.getRotation() + rotateDiff);
                }
                if (getRotateable(i)) {
                    object.setRotation((int) objAng);
                }
            }
        }
    }

    protected void onMenuSelected(int itemId) {
        SpenSLog.m139i(false, " onMenuSelected is called : " + itemId);
        if (this.mListener != null) {
            this.mListener.onMenuSelected(getObjectList(), itemId);
        }
    }

    protected void onRectChanged(RectF rect, SpenObjectBase objectBase) {
        SpenSLog.m139i(false, "onRectChanged Rect: " + rect);
        if (this.mListener != null) {
            this.mListener.onRectChanged(rect, objectBase);
        }
    }

    protected void onRotationChanged(float angle, SpenObjectBase objectBase) {
        SpenSLog.m139i(false, " onRotationChanged is called");
        if (this.mListener != null) {
            this.mListener.onRotationChanged(angle, objectBase);
        }
    }

    protected void onDrawObject(Canvas canvas, Rect rect, SpenObjectBase objectBase) {
        Rect tmpRect = new Rect(rect);
        if (tmpRect.left > tmpRect.right) {
            tmpRect.left = rect.right;
            tmpRect.right = rect.left;
        }
        if (tmpRect.top > tmpRect.bottom) {
            tmpRect.top = rect.bottom;
            tmpRect.bottom = rect.top;
        }
        if (Build.MODEL.contains("SM-P90")) {
            canvas.drawRect(tmpRect, this.mTempPaint.getPaint(8));
        } else {
            canvas.drawRect(tmpRect, this.mTempPaint.getPaint(0));
        }
    }

    protected void onFlip(int flipDirection, SpenObjectBase objectBase) {
        SpenSLog.m139i(false, " Flip is occured, direction : " + flipDirection);
    }

    private String getPanKey(int w, int h) {
        return new String(new StringBuilder().append(w).append(h).toString());
    }

    protected void fitRotateAngle2BorderAngle() {
        if (this.mObjectBaseList != null && this.mObjectBaseList.size() > 0) {
            for (int i = 0; i < this.mObjectBaseList.size(); i++) {
                this.mRotateAngle = getBorderAngle(i);
            }
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        if (this.mListener != null && isObjectAvailable()) {
            this.mTempCoordinateInfo.reset();
            this.mListener.onRequestCoordinateInfo(this.mTempCoordinateInfo);
            boolean scrollDirty = false;
            this.mContextMenu.setDirty();
            fit();
            float curPanX = this.mTempCoordinateInfo.pan.x;
            float curPanY = this.mTempCoordinateInfo.pan.y;
            String key = getPanKey(w, h);
            Point pan = this.mPanBackup.get(key);
            if (pan != null) {
                SpenSLog.m134d("onSizeChanged get : " + w + " , " + h + ", pan : " + pan.y);
                onRequestScroll(pan.x - curPanX, pan.y - curPanY);
                this.mPanBackup.remove(key);
                scrollDirty = true;
            }
            RectF absoluteScreenRect = new RectF();
            absoluteCoordinate(absoluteScreenRect, this.mTempCoordinateInfo.frameRect, this.mTempCoordinateInfo);
            RectF objectBoundBox = getBoundBox(-1);
            if (objectBoundBox != null) {
                RectF absoluteObjectBoundBox = new RectF();
                absoluteCoordinate(absoluteObjectBoundBox, objectBoundBox, this.mTempCoordinateInfo);
                SpenSLog.m134d("onSizeChanged absoluteObjectBoundBox : " + absoluteObjectBoundBox);
                SpenSLog.m134d("onSizeChanged absoluteScreenRect : " + absoluteScreenRect);
                this.mPanBackup.put(getPanKey(oldw, oldh), new Point((int) this.mTempCoordinateInfo.pan.x, (int) this.mTempCoordinateInfo.pan.y));
                SpenSLog.m134d("onSizeChanged put : " + oldw + " , " + oldh + ", pan : " + this.mTempCoordinateInfo.pan.y);
                boolean containFlag = absoluteScreenRect.contains(absoluteObjectBoundBox);
                boolean intersectFlag = absoluteObjectBoundBox.intersect(absoluteScreenRect);
                SpenSLog.m134d("onSizeChanged intersect : " + intersectFlag + " , contain : " + containFlag);
                if (!intersectFlag || (!isOutOfViewEnabled() && !containFlag)) {
                    float panX = VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET;
                    float panY = VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET;
                    if (objectBoundBox.bottom > this.mTempCoordinateInfo.frameRect.bottom) {
                        panY = (objectBoundBox.bottom - this.mTempCoordinateInfo.frameRect.bottom) / this.mTempCoordinateInfo.zoomRatio;
                    } else if (objectBoundBox.top < this.mTempCoordinateInfo.frameRect.top) {
                        panY = (objectBoundBox.top - this.mTempCoordinateInfo.frameRect.top) / this.mTempCoordinateInfo.zoomRatio;
                    }
                    if (objectBoundBox.left < this.mTempCoordinateInfo.frameRect.left) {
                        panX = (objectBoundBox.left - this.mTempCoordinateInfo.frameRect.left) / this.mTempCoordinateInfo.zoomRatio;
                    } else if (objectBoundBox.right > this.mTempCoordinateInfo.frameRect.right) {
                        panX = (objectBoundBox.right - this.mTempCoordinateInfo.frameRect.right) / this.mTempCoordinateInfo.zoomRatio;
                    }
                    onRequestScroll(panX, panY);
                    scrollDirty = true;
                }
                if (scrollDirty) {
                    fit();
                }
            }
        }
    }

    public SpenControlBase(Context context, SpenPageDoc pageDoc) {
        super(context);
        this.mPageDoc = null;
        this.mContextMenu = new ContextMenuMgr();
        this.mObjectBaseList = null;
        this.mRectList = null;
        this.mPanBackup = null;
        this.mTempPaint = null;
        this.mTempRect = null;
        this.mIsDim = false;
        this.mIsClosed = false;
        this.mTmpMatrix = null;
        this.mIsFirstTouch = true;
        this.mIsFlipDirectionHorizontal = false;
        this.mIsFlipDirectionVertical = false;
        this.mSelectContextMenuListener = new SpenContextMenu.ContextMenuListener() { // from class: com.samsung.android.sdk.pen.engine.SpenControlBase.1
            @Override // com.samsung.android.sdk.pen.engine.SpenContextMenu.ContextMenuListener
            public void onSelected(int action) {
                SpenControlBase.this.onMenuSelected(action);
            }
        };
        initialize(pageDoc);
    }

    @Override // android.view.View
    public boolean onHoverEvent(MotionEvent event) {
        return false;
    }

    public void fit() {
        if (isObjectAvailable()) {
            this.mTempCoordinateInfo.reset();
            if (this.mListener != null) {
                this.mListener.onRequestCoordinateInfo(this.mTempCoordinateInfo);
            }
            for (int i = 0; i < this.mObjectBaseList.size(); i++) {
                fit(i, this.mTempCoordinateInfo);
            }
            if (this.mContextMenu.mInstance != null) {
                updateContextMenu();
                this.mContextMenu.show();
            }
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent event) {
        if (event == null || this.mStyle == 3 || !this.mTouchEnable) {
            return false;
        }
        if (event.getPointerCount() > 1) {
            close();
            return true;
        }
        this.mTransactionTouchEvent.check(event);
        switch (event.getAction() & 255) {
            case 0:
                if (this.mPointDown == null) {
                    this.mPointDown = new PointF();
                }
                this.mPointDown.set(event.getX(), event.getY());
                break;
            case 1:
                this.mIsFirstTouch = false;
                break;
            case 2:
                if (!this.mIsFirstTouch || Math.sqrt(((this.mPointDown.x - event.getX()) * (this.mPointDown.x - event.getX())) + ((this.mPointDown.y - event.getY()) * (this.mPointDown.y - event.getY()))) >= 20.0d) {
                    this.mContextMenu.hide();
                    break;
                }
                break;
            case 3:
                if (!this.mIsClosed) {
                    onCanvasHoverEnter();
                    break;
                }
                break;
        }
        if (handleTouchEvent(event)) {
            return true;
        }
        return super.onTouchEvent(event);
    }

    public void close() {
        this.mTouchState.reset();
        if (this.mContextMenu.mInstance != null) {
            this.mContextMenu.mInstance.close();
        }
        if (this.mListener != null) {
            this.mListener.onClosed(getObjectList());
        }
        this.mIsClosed = true;
        this.mObjectBaseList = null;
    }

    public boolean isClosed() {
        return this.mIsClosed;
    }

    public RectF getRect() {
        if (this.mRectList.size() == 1) {
            return this.mRectList.get(0);
        }
        RectF rect = new RectF(VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET);
        for (int i = 0; i < this.mRectList.size(); i++) {
            rect.union(this.mRectList.get(i));
        }
        return rect;
    }

    public void setStyle(int style) {
        if (style >= 0 && style <= 3) {
            this.mStyle = style;
        } else {
            SpenError.ThrowUncheckedException(7);
        }
    }

    public int getStyle() {
        return this.mStyle;
    }

    public void setContextMenu(ArrayList<SpenContextMenuItemInfo> menuItem) {
        this.mContextMenu.mItemList = menuItem;
        this.mContextMenu.setDirty();
    }

    public void setContextMenuItemEnabled(int id, boolean enable) {
        if (this.mContextMenu.mInstance != null) {
            this.mContextMenu.mInstance.setItemEnabled(id, enable);
        }
    }

    public boolean isContextMenuItemEnabled(int id) {
        if (this.mContextMenu.mInstance == null) {
            return false;
        }
        return this.mContextMenu.mInstance.getItemEnabled(id);
    }

    public ArrayList<SpenContextMenuItemInfo> getContextMenu() {
        return this.mContextMenu.mItemList;
    }

    public void setContextMenuVisible(boolean visible) {
        if (this.mContextMenu.mVisible != visible) {
            this.mContextMenu.mVisible = visible;
            if (visible) {
                this.mContextMenu.show();
            } else {
                this.mContextMenu.hide();
            }
        }
    }

    public boolean isContextMenuVisible() {
        return this.mContextMenu.mVisible;
    }

    public void setTouchEnabled(boolean enable) {
        this.mTouchEnable = enable;
    }

    public boolean isTouchEnabled() {
        return this.mTouchEnable;
    }

    public void setMinResizeRect(RectF rect) {
        if (this.mMinimumResizeRect != null) {
            this.mMinimumResizeRect.set(rect);
        }
    }

    public RectF getMinResizeRect() {
        if (this.mMinimumResizeRect != null) {
            return this.mMinimumResizeRect;
        }
        return null;
    }

    public void setDimEnabled(boolean enable) {
        this.mIsDim = enable;
    }

    public boolean isDimEnabled() {
        return this.mIsDim;
    }

    protected void onPrepareDraw(Canvas canvas) {
        if (this.mContextMenu.mVisible) {
            this.mContextMenu.show();
        }
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean hasWindowFocus) {
        if (hasWindowFocus) {
            fitRotateAngle2BorderAngle();
            fit();
            this.mTouchState.reset();
            invalidate();
        }
        super.onWindowFocusChanged(hasWindowFocus);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) throws Resources.NotFoundException, PackageManager.NameNotFoundException, IOException {
        if (canvas != null && this.mStyle != 3) {
            if (this.mContextMenu.mFirstDraw) {
                SpenSLog.m135d(false, "ControlBase.onDraw is called, for the first time.");
                this.mContextMenu.mFirstDraw = false;
                onPrepareDraw(canvas);
            }
            this.mRotateAngle = normalizeDegree(this.mRotateAngle);
            if (isObjectAvailable()) {
                if (this.mIsDim) {
                    canvas.drawColor(DIMMING_BG_COLOR);
                }
                for (int i = 0; i < this.mObjectBaseList.size(); i++) {
                    if (this.mObjectBaseList.get(i) instanceof SpenObjectStroke) {
                        drawHighlightStroke(canvas, (SpenObjectStroke) this.mObjectBaseList.get(i));
                    }
                    canvas.save();
                    canvas.rotate(getBorderAngle(i), getBorderRect(i).centerX(), getBorderRect(i).centerY());
                    drawDimmingWindow(canvas, getBorderRect(i));
                    onDrawBorder(canvas, getBorderRect(i), this.mObjectBaseList.get(i));
                    canvas.restore();
                }
                for (int i2 = 0; i2 < this.mObjectBaseList.size(); i2++) {
                    canvas.save();
                    int centerX = (int) getControlPivotX(i2);
                    int centerY = (int) getControlPivotY(i2);
                    float objAng = this.mRotateAngle;
                    int displayAngle = (int) objAng;
                    if (displayAngle < 0) {
                        displayAngle += 360;
                    }
                    if (this.mTouchState.isRotateZonePressed()) {
                        this.mTempRectF.set(centerX - 47, centerY - 40, centerX + 47, centerY + 10);
                        canvas.drawRoundRect(this.mTempRectF, 5.0f, 5.0f, this.mTempPaint.getPaint(4));
                        canvas.drawText(String.valueOf(Integer.toString(displayAngle)) + DEFAULT_DEGREE_STRING, centerX, centerY, this.mTempPaint.getPaint(5));
                    }
                    int index = this.mTouchState.mTouchedObjectIndex;
                    if (i2 != index && index != -1) {
                        if (getRotateable(i2)) {
                            float rotateDiff = this.mRotateAngle - getBorderAngle(index);
                            objAng = normalizeDegree(getBorderAngle(i2) + rotateDiff);
                        } else {
                            objAng = VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET;
                        }
                    }
                    SpenSLog.m135d(false, "center[" + i2 + "]:" + centerX + "," + centerY + ", angle:" + objAng);
                    canvas.rotate(objAng, centerX, centerY);
                    if (this.mTouchState.isResizeZonePressed() || this.mTouchState.isMoveZonePressed() || this.mTouchState.isRotateZonePressed()) {
                        this.mRectList.get(i2).round(this.mTempRect);
                        onDrawObject(canvas, this.mTempRect, this.mObjectBaseList.get(i2));
                    }
                    canvas.restore();
                }
            }
        }
    }

    protected void drawHighlightObject(Canvas canvas, SpenObjectBase objectBase) {
        if (isObjectOutlineEnabled()) {
            if (objectBase instanceof SpenObjectStroke) {
                drawHighlightStroke(canvas, (SpenObjectStroke) objectBase);
            } else {
                drawHighlightRect(canvas, objectBase);
            }
        }
    }

    private void drawHighlightRect(Canvas canvas, SpenObjectBase objectBase) {
        SpenSLog.m135d(false, "Base::drawHighlightObject");
        if (isObjectOutlineEnabled()) {
            Paint paint = this.mTempPaint.getPaint(1);
            RectF dstRect = new RectF();
            RectF srcRect = new RectF(objectBase.getRect());
            this.mTempCoordinateInfo.reset();
            if (this.mListener != null) {
                this.mListener.onRequestCoordinateInfo(this.mTempCoordinateInfo);
            }
            relativeCoordinate(dstRect, srcRect, this.mTempCoordinateInfo);
            canvas.save();
            canvas.rotate(objectBase.getRotation(), dstRect.centerX(), dstRect.centerY());
            canvas.drawRect(dstRect, paint);
            canvas.restore();
        }
    }

    void getStartEndBitmapCalcPoint(PointF curPoint, PointF prevPoint, PointF calcPoint, float distance) {
        QUADRANT quadrant;
        float originalDx = curPoint.x - prevPoint.x;
        float originalDy = curPoint.y - prevPoint.y;
        QUADRANT quadrant2 = QUADRANT.QUADRANT_MAX;
        if (originalDx >= VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET && originalDy >= VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET) {
            quadrant = QUADRANT.QUADRANT_1;
        } else if (originalDx < VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET && originalDy >= VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET) {
            quadrant = QUADRANT.QUADRANT_2;
        } else if (originalDx >= VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET && originalDy < VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET) {
            quadrant = QUADRANT.QUADRANT_3;
        } else {
            quadrant = QUADRANT.QUADRANT_4;
        }
        float dx = Math.abs(originalDx);
        float dy = Math.abs(originalDy);
        float degree = (float) ((Math.atan(dy / dx) * 180.0d) / 3.1415927410125732d);
        switch (m133xbfaee826()[quadrant.ordinal()]) {
            case 1:
                float radian = (90.0f - degree) * 0.017453292f;
                calcPoint.x = (float) (prevPoint.x + (distance * Math.sin(radian)));
                calcPoint.y = (float) (prevPoint.y + (distance * Math.cos(radian)));
                break;
            case 2:
                float radian2 = degree * 0.017453292f;
                calcPoint.x = (float) (prevPoint.x - (distance * Math.cos(radian2)));
                calcPoint.y = (float) (prevPoint.y + (distance * Math.sin(radian2)));
                break;
            case 3:
                float radian3 = degree * 0.017453292f;
                calcPoint.x = (float) (prevPoint.x + (distance * Math.cos(radian3)));
                calcPoint.y = (float) (prevPoint.y - (distance * Math.sin(radian3)));
                break;
            case 4:
                float radian4 = (90.0f - degree) * 0.017453292f;
                calcPoint.x = (float) (prevPoint.x - (distance * Math.sin(radian4)));
                calcPoint.y = (float) (prevPoint.y - (distance * Math.cos(radian4)));
                break;
        }
    }

    private void drawHighlightStroke(Canvas canvas, SpenObjectStroke objectStroke) {
        if (!isObjectOutlineEnabled() || objectStroke.getType() == 4 || objectStroke.getPenName() == null || objectStroke.getPenName().equalsIgnoreCase("com.samsung.android.sdk.pen.pen.preload.Beautify")) {
            return;
        }
        this.mTempCoordinateInfo.reset();
        if (this.mListener != null) {
            this.mListener.onRequestCoordinateInfo(this.mTempCoordinateInfo);
        }
        PointF[] myPointList = objectStroke.getPoints();
        if (myPointList != null) {
            int len = myPointList.length;
            Paint paint = this.mTempPaint.getPaint(6);
            paint.setStrokeWidth((int) (objectStroke.getPenSize() * this.mTempCoordinateInfo.zoomRatio));
            Path myPath = new Path();
            if (len > 100 || !objectStroke.isCurveEnabled()) {
                myPath.setLastPoint(((myPointList[0].x - this.mTempCoordinateInfo.pan.x) * this.mTempCoordinateInfo.zoomRatio) + this.mTempCoordinateInfo.frameRect.left, ((myPointList[0].y - this.mTempCoordinateInfo.pan.y) * this.mTempCoordinateInfo.zoomRatio) + this.mTempCoordinateInfo.frameRect.top);
                for (int i = 0; i < len; i++) {
                    myPath.lineTo(((myPointList[i].x - this.mTempCoordinateInfo.pan.x) * this.mTempCoordinateInfo.zoomRatio) + this.mTempCoordinateInfo.frameRect.left, ((myPointList[i].y - this.mTempCoordinateInfo.pan.y) * this.mTempCoordinateInfo.zoomRatio) + this.mTempCoordinateInfo.frameRect.top);
                }
                canvas.drawPath(myPath, paint);
                paint.setStrokeWidth((objectStroke.getPenSize() * this.mTempCoordinateInfo.zoomRatio) / 4.0f);
                paint.setColor(-1);
                paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
                canvas.drawPath(myPath, paint);
                return;
            }
            ArrayList<PointF> orgList = new ArrayList<>();
            for (int i2 = 0; i2 < len; i2++) {
                if (!isContained(orgList, myPointList[i2])) {
                    orgList.add(myPointList[i2]);
                }
            }
            int orgSize = orgList.size();
            ArrayList<PointF> newList = new ArrayList<>();
            if (objectStroke.getPenName().equalsIgnoreCase(SpenPenManager.SPEN_PENCIL)) {
                for (int i3 = 0; i3 < orgSize - 1; i3++) {
                    if (i3 + 1 < orgSize) {
                        newList.add(new PointF((orgList.get(i3 + 1).x + orgList.get(i3).x) / 2.0f, (orgList.get(i3 + 1).y + orgList.get(i3).y) / 2.0f));
                    }
                }
            } else {
                newList.add(orgList.get(0));
                for (int i4 = 1; i4 < orgSize - 2; i4 += 2) {
                    if (i4 + 2 < orgSize) {
                        newList.add(new PointF((orgList.get(i4 + 2).x + orgList.get(i4).x) / 2.0f, (orgList.get(i4 + 2).y + orgList.get(i4).y) / 2.0f));
                    }
                }
                if (orgSize > 1) {
                    newList.add(orgList.get(orgSize - 1));
                }
            }
            int newSize = newList.size();
            myPath.moveTo(((myPointList[0].x - this.mTempCoordinateInfo.pan.x) * this.mTempCoordinateInfo.zoomRatio) + this.mTempCoordinateInfo.frameRect.left, ((myPointList[0].y - this.mTempCoordinateInfo.pan.y) * this.mTempCoordinateInfo.zoomRatio) + this.mTempCoordinateInfo.frameRect.top);
            if (orgSize < 3) {
                if (orgSize != 2) {
                    if (orgSize == 1) {
                        paint.setStrokeWidth((objectStroke.getPenSize() * this.mTempCoordinateInfo.zoomRatio) / 4.0f);
                        canvas.drawCircle(((myPointList[0].x - this.mTempCoordinateInfo.pan.x) * this.mTempCoordinateInfo.zoomRatio) + this.mTempCoordinateInfo.frameRect.left, ((myPointList[0].y - this.mTempCoordinateInfo.pan.y) * this.mTempCoordinateInfo.zoomRatio) + this.mTempCoordinateInfo.frameRect.top, (int) ((objectStroke.getPenSize() * this.mTempCoordinateInfo.zoomRatio) / 2.0f), paint);
                        return;
                    }
                    return;
                }
                myPath.lineTo(this.mTempCoordinateInfo.frameRect.left + ((orgList.get(1).x - this.mTempCoordinateInfo.pan.x) * this.mTempCoordinateInfo.zoomRatio), ((orgList.get(1).y - this.mTempCoordinateInfo.pan.y) * this.mTempCoordinateInfo.zoomRatio) + this.mTempCoordinateInfo.frameRect.top);
                canvas.drawPath(myPath, paint);
                paint.setStrokeWidth((objectStroke.getPenSize() * this.mTempCoordinateInfo.zoomRatio) / 4.0f);
                paint.setColor(-1);
                paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
                canvas.drawPath(myPath, paint);
                return;
            }
            if (objectStroke.getPenName().equalsIgnoreCase(SpenPenManager.SPEN_MARKER) || objectStroke.getPenName().equalsIgnoreCase(SpenPenManager.SPEN_BRUSH)) {
                PointF calcPoint = new PointF();
                getStartEndBitmapCalcPoint(orgList.get(1), orgList.get(0), calcPoint, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET);
                PointF prevMiddlePoint = new PointF();
                prevMiddlePoint.x = (orgList.get(1).x + calcPoint.x) / 2.0f;
                prevMiddlePoint.y = (orgList.get(1).y + calcPoint.y) / 2.0f;
                myPath.moveTo(((calcPoint.x - this.mTempCoordinateInfo.pan.x) * this.mTempCoordinateInfo.zoomRatio) + this.mTempCoordinateInfo.frameRect.left, ((calcPoint.y - this.mTempCoordinateInfo.pan.y) * this.mTempCoordinateInfo.zoomRatio) + this.mTempCoordinateInfo.frameRect.top);
                myPath.quadTo(((calcPoint.x - this.mTempCoordinateInfo.pan.x) * this.mTempCoordinateInfo.zoomRatio) + this.mTempCoordinateInfo.frameRect.left, ((calcPoint.y - this.mTempCoordinateInfo.pan.y) * this.mTempCoordinateInfo.zoomRatio) + this.mTempCoordinateInfo.frameRect.top, ((prevMiddlePoint.x - this.mTempCoordinateInfo.pan.x) * this.mTempCoordinateInfo.zoomRatio) + this.mTempCoordinateInfo.frameRect.left, ((prevMiddlePoint.y - this.mTempCoordinateInfo.pan.y) * this.mTempCoordinateInfo.zoomRatio) + this.mTempCoordinateInfo.frameRect.top);
                PointF prevPoint = null;
                for (int i5 = 1; i5 < orgSize - 1; i5++) {
                    PointF prevPoint2 = orgList.get(i5);
                    PointF prevPoint3 = prevPoint2;
                    PointF middlePoint = new PointF();
                    middlePoint.x = (float) ((orgList.get(i5 + 1).x + prevPoint3.x) * 0.5d);
                    middlePoint.y = (float) ((orgList.get(i5 + 1).y + prevPoint3.y) * 0.5d);
                    myPath.quadTo(((prevPoint3.x - this.mTempCoordinateInfo.pan.x) * this.mTempCoordinateInfo.zoomRatio) + this.mTempCoordinateInfo.frameRect.left, ((prevPoint3.y - this.mTempCoordinateInfo.pan.y) * this.mTempCoordinateInfo.zoomRatio) + this.mTempCoordinateInfo.frameRect.top, ((middlePoint.x - this.mTempCoordinateInfo.pan.x) * this.mTempCoordinateInfo.zoomRatio) + this.mTempCoordinateInfo.frameRect.left, ((middlePoint.y - this.mTempCoordinateInfo.pan.y) * this.mTempCoordinateInfo.zoomRatio) + this.mTempCoordinateInfo.frameRect.top);
                    prevPoint = middlePoint;
                }
                myPath.quadTo(this.mTempCoordinateInfo.frameRect.left + ((prevPoint.x - this.mTempCoordinateInfo.pan.x) * this.mTempCoordinateInfo.zoomRatio), this.mTempCoordinateInfo.frameRect.top + ((prevPoint.y - this.mTempCoordinateInfo.pan.y) * this.mTempCoordinateInfo.zoomRatio), this.mTempCoordinateInfo.frameRect.left + ((orgList.get(orgSize - 1).x - this.mTempCoordinateInfo.pan.x) * this.mTempCoordinateInfo.zoomRatio), ((orgList.get(orgSize - 1).y - this.mTempCoordinateInfo.pan.y) * this.mTempCoordinateInfo.zoomRatio) + this.mTempCoordinateInfo.frameRect.top);
            } else if (objectStroke.getPenName().equalsIgnoreCase(SpenPenManager.SPEN_PENCIL)) {
                for (int i6 = 0; i6 < newSize; i6++) {
                    myPath.quadTo(this.mTempCoordinateInfo.frameRect.left + ((orgList.get(i6).x - this.mTempCoordinateInfo.pan.x) * this.mTempCoordinateInfo.zoomRatio), this.mTempCoordinateInfo.frameRect.top + ((orgList.get(i6).y - this.mTempCoordinateInfo.pan.y) * this.mTempCoordinateInfo.zoomRatio), this.mTempCoordinateInfo.frameRect.left + ((newList.get(i6).x - this.mTempCoordinateInfo.pan.x) * this.mTempCoordinateInfo.zoomRatio), ((newList.get(i6).y - this.mTempCoordinateInfo.pan.y) * this.mTempCoordinateInfo.zoomRatio) + this.mTempCoordinateInfo.frameRect.top);
                }
                myPath.lineTo(this.mTempCoordinateInfo.frameRect.left + ((orgList.get(orgSize - 1).x - this.mTempCoordinateInfo.pan.x) * this.mTempCoordinateInfo.zoomRatio), ((orgList.get(orgSize - 1).y - this.mTempCoordinateInfo.pan.y) * this.mTempCoordinateInfo.zoomRatio) + this.mTempCoordinateInfo.frameRect.top);
            } else if (!objectStroke.getPenName().equalsIgnoreCase(SpenPenManager.SPEN_CHINESE_BRUSH)) {
                for (int i7 = 0; i7 < newSize - 1; i7++) {
                    if ((i7 * 2) + 1 < orgSize) {
                        myPath.quadTo(this.mTempCoordinateInfo.frameRect.left + ((orgList.get((i7 * 2) + 1).x - this.mTempCoordinateInfo.pan.x) * this.mTempCoordinateInfo.zoomRatio), this.mTempCoordinateInfo.frameRect.top + ((orgList.get((i7 * 2) + 1).y - this.mTempCoordinateInfo.pan.y) * this.mTempCoordinateInfo.zoomRatio), this.mTempCoordinateInfo.frameRect.left + ((newList.get(i7 + 1).x - this.mTempCoordinateInfo.pan.x) * this.mTempCoordinateInfo.zoomRatio), ((newList.get(i7 + 1).y - this.mTempCoordinateInfo.pan.y) * this.mTempCoordinateInfo.zoomRatio) + this.mTempCoordinateInfo.frameRect.top);
                    }
                }
            } else if (orgSize % 2 == 1) {
                for (int i8 = 0; i8 < newSize - 1; i8++) {
                    if ((i8 * 2) + 1 < orgSize) {
                        myPath.quadTo(this.mTempCoordinateInfo.frameRect.left + ((orgList.get((i8 * 2) + 1).x - this.mTempCoordinateInfo.pan.x) * this.mTempCoordinateInfo.zoomRatio), this.mTempCoordinateInfo.frameRect.top + ((orgList.get((i8 * 2) + 1).y - this.mTempCoordinateInfo.pan.y) * this.mTempCoordinateInfo.zoomRatio), this.mTempCoordinateInfo.frameRect.left + ((newList.get(i8 + 1).x - this.mTempCoordinateInfo.pan.x) * this.mTempCoordinateInfo.zoomRatio), ((newList.get(i8 + 1).y - this.mTempCoordinateInfo.pan.y) * this.mTempCoordinateInfo.zoomRatio) + this.mTempCoordinateInfo.frameRect.top);
                    }
                }
            } else {
                for (int i9 = 0; i9 < newSize - 2; i9++) {
                    if ((i9 * 2) + 1 < orgSize) {
                        myPath.quadTo(this.mTempCoordinateInfo.frameRect.left + ((orgList.get((i9 * 2) + 1).x - this.mTempCoordinateInfo.pan.x) * this.mTempCoordinateInfo.zoomRatio), this.mTempCoordinateInfo.frameRect.top + ((orgList.get((i9 * 2) + 1).y - this.mTempCoordinateInfo.pan.y) * this.mTempCoordinateInfo.zoomRatio), this.mTempCoordinateInfo.frameRect.left + ((newList.get(i9 + 1).x - this.mTempCoordinateInfo.pan.x) * this.mTempCoordinateInfo.zoomRatio), ((newList.get(i9 + 1).y - this.mTempCoordinateInfo.pan.y) * this.mTempCoordinateInfo.zoomRatio) + this.mTempCoordinateInfo.frameRect.top);
                    }
                }
                new PointF();
                PointF point2 = newList.get(newSize - 2);
                PointF point3 = orgList.get(orgSize - 3);
                myPath.cubicTo(((point2.x - this.mTempCoordinateInfo.pan.x) * this.mTempCoordinateInfo.zoomRatio) + this.mTempCoordinateInfo.frameRect.left, ((point2.y - this.mTempCoordinateInfo.pan.y) * this.mTempCoordinateInfo.zoomRatio) + this.mTempCoordinateInfo.frameRect.top, ((point3.x - this.mTempCoordinateInfo.pan.x) * this.mTempCoordinateInfo.zoomRatio) + this.mTempCoordinateInfo.frameRect.left, ((point3.y - this.mTempCoordinateInfo.pan.y) * this.mTempCoordinateInfo.zoomRatio) + this.mTempCoordinateInfo.frameRect.top, ((newList.get(newSize - 1).x - this.mTempCoordinateInfo.pan.x) * this.mTempCoordinateInfo.zoomRatio) + this.mTempCoordinateInfo.frameRect.left, ((newList.get(newSize - 1).y - this.mTempCoordinateInfo.pan.y) * this.mTempCoordinateInfo.zoomRatio) + this.mTempCoordinateInfo.frameRect.top);
            }
            canvas.drawPath(myPath, paint);
            paint.setStrokeWidth((objectStroke.getPenSize() * this.mTempCoordinateInfo.zoomRatio) / 4.0f);
            paint.setColor(-1);
            paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
            canvas.drawPath(myPath, paint);
        }
    }

    private boolean isContained(ArrayList<PointF> arr, PointF point) {
        Iterator<PointF> it = arr.iterator();
        while (it.hasNext()) {
            PointF pointF = it.next();
            if (Math.abs(pointF.x - point.x) < SIGMA && Math.abs(pointF.y - point.y) < SIGMA) {
                return true;
            }
        }
        return false;
    }

    protected void setListener(ActionListener listener) {
        this.mListener = listener;
    }

    public ArrayList<SpenObjectBase> getObjectList() {
        return this.mObjectBaseList;
    }

    public int getPixel(int x, int y) {
        return 0;
    }

    public void setObjectOutlineEnabled(boolean enable) {
        mObjectOutlineEnable = enable;
    }

    public boolean isObjectOutlineEnabled() {
        return mObjectOutlineEnable;
    }

    protected void onCanvasHoverEnter() {
        if (this.mTouchState.isMoveZonePressed() || this.mTouchState.isResizeZonePressed() || this.mTouchState.isRotateZonePressed()) {
            onObjectChanged();
        }
    }
}
