package com.samsung.android.sdk.pen.engine;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.util.SparseIntArray;
import android.view.MotionEvent;
import android.widget.EdgeEffect;
import com.vlingo.sdk.recognition.spotter.VLSpotterContext;

/* loaded from: classes.dex */
class SpenSmartScaleGestureDetector extends Handler {

    /* renamed from: $SWITCH_TABLE$com$samsung$android$sdk$pen$engine$SpenSmartScaleGestureDetector$State */
    private static /* synthetic */ int[] f399x3895ca7;
    private static final boolean DBG = false;
    private static final int HANDLER_TIME = 0;
    private final float m1CMPixel;
    private float mCenterX;
    private float mCenterY;
    private final float mDPI;
    private float mDiffX;
    private float mDiffY;
    private float mDistanceX;
    private float mDistanceY;
    private EdgeEffectLR mEdgeLR;
    private EdgeEffectTB mEdgeTB;
    private int mEffectFrame;
    private int mFrameStartX;
    private int mFrameStartY;
    private int mRtoCvsItstFrmHeight;
    private int mRtoCvsItstFrmWidth;
    private float mScrollX;
    private float mScrollY;
    private int mZoomOutResponseTime;
    private State mState = State.IDLE_STATE;
    private float mDeltaX = VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET;
    private float mDeltaY = VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET;
    private float mRatio = 1.0f;
    private float mMaxDeltaX = VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET;
    private float mMaxDeltaY = VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET;
    private float mOrigRatio = 1.0f;
    private boolean mUseSmartScale = false;
    private boolean mUseHorizontalScroll = false;
    private boolean mUseVerticalScroll = false;
    private Rect mSmartScaleRegion = null;
    private Rect mLeftScrollRegion = null;
    private Rect mRightScrollRegion = null;
    private Rect mTopScrollRegion = null;
    private Rect mBottomScrollRegion = null;
    private float mFactor = 0.125f;
    private float mZoomRatio = 1.5f;
    private int mHorizontalResponseTime = 0;
    private long mHorizontalEnterTime = 0;
    private int mHorizontalVelocity = 20;
    private int mVerticalResponseTime = 0;
    private long mVerticalEnterTime = 0;
    private int mVerticalVelocity = 20;
    private long mDownTime = 0;
    private float mDownX = VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET;
    private float mDownY = VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET;
    private Listener mListener = null;
    private Direction mFlickDirection = Direction.NONE;
    private SparseIntArray mToolAndActionMap = new SparseIntArray(10);
    private Paint mEdgePaint = new Paint();

    private enum Direction {
        NONE,
        LEFT,
        TOP,
        RIGHT,
        BOTTOM;

        /* renamed from: values, reason: to resolve conflict with enum method */
        public static Direction[] valuesCustom() {
            Direction[] directionArrValuesCustom = values();
            int length = directionArrValuesCustom.length;
            Direction[] directionArr = new Direction[length];
            System.arraycopy(directionArrValuesCustom, 0, directionArr, 0, length);
            return directionArr;
        }
    }

    private enum DirectionLR {
        NONE,
        LEFT,
        RIGHT;

        /* renamed from: values, reason: to resolve conflict with enum method */
        public static DirectionLR[] valuesCustom() {
            DirectionLR[] directionLRArrValuesCustom = values();
            int length = directionLRArrValuesCustom.length;
            DirectionLR[] directionLRArr = new DirectionLR[length];
            System.arraycopy(directionLRArrValuesCustom, 0, directionLRArr, 0, length);
            return directionLRArr;
        }
    }

    private enum DirectionTB {
        NONE,
        TOP,
        BOTTOM;

        /* renamed from: values, reason: to resolve conflict with enum method */
        public static DirectionTB[] valuesCustom() {
            DirectionTB[] directionTBArrValuesCustom = values();
            int length = directionTBArrValuesCustom.length;
            DirectionTB[] directionTBArr = new DirectionTB[length];
            System.arraycopy(directionTBArrValuesCustom, 0, directionTBArr, 0, length);
            return directionTBArr;
        }
    }

    public interface Listener {
        void onChangePan(float f, float f2);

        void onChangeScale(float f, float f2, float f3);

        boolean onFlick(int i);

        void onUpdate();

        void onUpdateScreenFrameBuffer();
    }

    public enum State {
        IDLE_STATE,
        ZOOMIN_STATE,
        ZOOMOUT_STATE,
        ZOOMED_STATE,
        READY_FOR_ZOOMOUT_STATE,
        SCROLL_STATE,
        FLING_STATE,
        EDGE_STATE;

        /* renamed from: values, reason: to resolve conflict with enum method */
        public static State[] valuesCustom() {
            State[] stateArrValuesCustom = values();
            int length = stateArrValuesCustom.length;
            State[] stateArr = new State[length];
            System.arraycopy(stateArrValuesCustom, 0, stateArr, 0, length);
            return stateArr;
        }
    }

    /* renamed from: $SWITCH_TABLE$com$samsung$android$sdk$pen$engine$SpenSmartScaleGestureDetector$State */
    static /* synthetic */ int[] m144x3895ca7() {
        int[] iArr = f399x3895ca7;
        if (iArr == null) {
            iArr = new int[State.valuesCustom().length];
            try {
                iArr[State.EDGE_STATE.ordinal()] = 8;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[State.FLING_STATE.ordinal()] = 7;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[State.IDLE_STATE.ordinal()] = 1;
            } catch (NoSuchFieldError e3) {
            }
            try {
                iArr[State.READY_FOR_ZOOMOUT_STATE.ordinal()] = 5;
            } catch (NoSuchFieldError e4) {
            }
            try {
                iArr[State.SCROLL_STATE.ordinal()] = 6;
            } catch (NoSuchFieldError e5) {
            }
            try {
                iArr[State.ZOOMED_STATE.ordinal()] = 4;
            } catch (NoSuchFieldError e6) {
            }
            try {
                iArr[State.ZOOMIN_STATE.ordinal()] = 2;
            } catch (NoSuchFieldError e7) {
            }
            try {
                iArr[State.ZOOMOUT_STATE.ordinal()] = 3;
            } catch (NoSuchFieldError e8) {
            }
            f399x3895ca7 = iArr;
        }
        return iArr;
    }

    private class EdgeEffect2 {
        public EdgeEffect effect;
        public boolean enable = false;

        public EdgeEffect2(Context context) {
            this.effect = new EdgeEffect(context);
        }

        public void close() {
            this.effect = null;
        }
    }

    private class EdgeEffectLR extends EdgeEffect2 {
        public DirectionLR direction;
        public float startX;

        public EdgeEffectLR(Context context) {
            super(context);
            this.direction = DirectionLR.NONE;
            this.startX = VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET;
        }

        @Override // com.samsung.android.sdk.pen.engine.SpenSmartScaleGestureDetector.EdgeEffect2
        public void close() {
            super.close();
        }
    }

    private class EdgeEffectTB extends EdgeEffect2 {
        public DirectionTB direction;
        public float startY;

        public EdgeEffectTB(Context context) {
            super(context);
            this.direction = DirectionTB.NONE;
            this.startY = VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET;
        }

        @Override // com.samsung.android.sdk.pen.engine.SpenSmartScaleGestureDetector.EdgeEffect2
        public void close() {
            super.close();
        }
    }

    public SpenSmartScaleGestureDetector(Context context, float dpi) {
        this.mDPI = dpi;
        this.m1CMPixel = 0.393701f * dpi;
        this.mEdgeLR = new EdgeEffectLR(context);
        this.mEdgeTB = new EdgeEffectTB(context);
        this.mEdgePaint.setAntiAlias(true);
        this.mEdgePaint.setFilterBitmap(true);
    }

    public void close() {
        if (this.mToolAndActionMap != null) {
            this.mToolAndActionMap.clear();
            this.mToolAndActionMap = null;
        }
        if (this.mEdgeLR != null) {
            this.mEdgeLR.close();
            this.mEdgeLR = null;
        }
        if (this.mEdgeTB != null) {
            this.mEdgeTB.close();
            this.mEdgeTB = null;
        }
        this.mEdgePaint = null;
    }

    public void setListener(Listener listener) {
        this.mListener = listener;
    }

    public void setToolTypeAction(int toolType, int action) {
        this.mToolAndActionMap.put(toolType, action);
    }

    public void enableSmartScale(boolean use, Rect region, int effectFrame, int zoomOutResponseTime, float zoomRatio) {
        if (use || this.mUseSmartScale) {
            Log.d("SPen_Library", "[SMART SCALE] enableSmartScale use : " + use);
            this.mUseSmartScale = use;
            this.mSmartScaleRegion = region;
            this.mEffectFrame = effectFrame;
            this.mZoomOutResponseTime = zoomOutResponseTime;
            this.mZoomRatio = zoomRatio;
            if (!use) {
                if (this.mState == State.ZOOMIN_STATE || this.mState == State.ZOOMED_STATE || this.mState == State.ZOOMOUT_STATE) {
                    this.mListener.onChangeScale((int) this.mCenterX, (int) this.mCenterY, this.mOrigRatio);
                    this.mListener.onUpdateScreenFrameBuffer();
                }
            }
        }
    }

    public void enableHorizontalSmartScroll(boolean use, Rect leftScrollRegion, Rect rightScrollRegion, int responseTime, int velocity) {
        this.mUseHorizontalScroll = use;
        this.mLeftScrollRegion = leftScrollRegion;
        this.mRightScrollRegion = rightScrollRegion;
        this.mHorizontalResponseTime = responseTime;
        this.mHorizontalVelocity = velocity;
    }

    public void enableVerticalSmartScroll(boolean use, Rect topScrollRegion, Rect bottomScrollRegion, int responseTime, int velocity) {
        this.mUseVerticalScroll = use;
        this.mTopScrollRegion = topScrollRegion;
        this.mBottomScrollRegion = bottomScrollRegion;
        this.mVerticalResponseTime = responseTime;
        this.mVerticalVelocity = velocity;
    }

    public void draw(Canvas canvas) {
        if (this.mEdgeLR.direction == DirectionLR.LEFT) {
            int restoreCount = canvas.save();
            canvas.translate(this.mFrameStartX, this.mFrameStartY + this.mRtoCvsItstFrmHeight);
            canvas.rotate(270.0f);
            if (!this.mEdgeLR.effect.isFinished()) {
                this.mEdgeLR.effect.draw(canvas);
            }
            canvas.restoreToCount(restoreCount);
        } else if (this.mEdgeLR.direction == DirectionLR.RIGHT) {
            int restoreCount2 = canvas.save();
            canvas.translate(this.mFrameStartX + this.mRtoCvsItstFrmWidth, this.mFrameStartY);
            canvas.rotate(90.0f);
            if (!this.mEdgeLR.effect.isFinished()) {
                this.mEdgeLR.effect.draw(canvas);
            }
            canvas.restoreToCount(restoreCount2);
        }
        if (this.mEdgeTB.direction == DirectionTB.TOP) {
            int restoreCount3 = canvas.save();
            canvas.translate(this.mFrameStartX, this.mFrameStartY);
            canvas.rotate(VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET);
            if (!this.mEdgeTB.effect.isFinished()) {
                this.mEdgeTB.effect.draw(canvas);
            }
            canvas.restoreToCount(restoreCount3);
            return;
        }
        if (this.mEdgeTB.direction == DirectionTB.BOTTOM) {
            int restoreCount4 = canvas.save();
            canvas.translate(this.mFrameStartX + this.mRtoCvsItstFrmWidth, this.mFrameStartY + this.mRtoCvsItstFrmHeight);
            canvas.rotate(180.0f);
            if (!this.mEdgeTB.effect.isFinished()) {
                this.mEdgeTB.effect.draw(canvas);
            }
            canvas.restoreToCount(restoreCount4);
        }
    }

    @Override // android.os.Handler
    public void handleMessage(Message msg) {
        switch (m144x3895ca7()[this.mState.ordinal()]) {
            case 2:
                ZoomIn();
                break;
            case 3:
                ZoomOut();
                break;
            case 5:
                ReadyForZoomout();
                break;
            case 6:
                Scroll();
                break;
            case 7:
                Fling();
                break;
        }
    }

    public void onHoverEvent(MotionEvent event) {
        if (event != null) {
            int action = event.getAction();
            if (event.getToolType(0) == 2) {
                if (action == 9 && this.mUseSmartScale) {
                    Log.d("SPen_Library", "[SMART SCALE] ON HOVER ENTER. STATE : " + this.mState);
                    if (this.mState == State.READY_FOR_ZOOMOUT_STATE) {
                        removeMessages(this.mZoomOutResponseTime);
                    }
                    if (this.mState == State.IDLE_STATE || this.mState == State.ZOOMOUT_STATE || this.mState == State.FLING_STATE || this.mState == State.EDGE_STATE) {
                        if (event.getButtonState() == 2) {
                            Log.d("SPen_Library", "[SMART SCALE] ON HOVER ENTER. BUTTON_SECONDARY");
                            return;
                        }
                        this.mCenterX = event.getX();
                        this.mCenterY = event.getY();
                        if (this.mState == State.IDLE_STATE || this.mState == State.FLING_STATE || this.mState == State.EDGE_STATE) {
                            this.mOrigRatio = this.mRatio;
                        }
                        if (this.mSmartScaleRegion.contains((int) event.getX(), (int) event.getY())) {
                            Log.d("SPen_Library", "[SMART SCALE] ON HOVER ENTER. SMART REGION CONTAINS");
                            if (this.mZoomRatio > this.mRatio) {
                                this.mFactor = (this.mZoomRatio - this.mRatio) / this.mEffectFrame;
                            } else {
                                this.mFactor = VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET;
                            }
                            ZoomIn();
                            return;
                        }
                        Log.d("SPen_Library", "[SMART SCALE] ON HOVER ENTER. SMART REGION NOT CONTAINS!!!");
                        return;
                    }
                    return;
                }
                if (action != 10 && (this.mState == State.SCROLL_STATE || this.mState == State.ZOOMED_STATE || this.mState == State.IDLE_STATE)) {
                    this.mScrollX = event.getX();
                    this.mScrollY = event.getY();
                    if (!this.mUseVerticalScroll || ((this.mTopScrollRegion == null || this.mDeltaY == VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET || !this.mTopScrollRegion.contains((int) this.mScrollX, (int) this.mScrollY)) && (this.mBottomScrollRegion == null || !this.mBottomScrollRegion.contains((int) this.mScrollX, (int) this.mScrollY)))) {
                        this.mVerticalEnterTime = event.getEventTime();
                    }
                    if ((!this.mUseHorizontalScroll || this.mLeftScrollRegion == null || this.mDeltaX == VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET || !this.mLeftScrollRegion.contains((int) this.mScrollX, (int) this.mScrollY)) && (this.mRightScrollRegion == null || this.mDeltaX >= this.mMaxDeltaX || !this.mRightScrollRegion.contains((int) this.mScrollX, (int) this.mScrollY))) {
                        this.mHorizontalEnterTime = event.getEventTime();
                    }
                    if (this.mState == State.ZOOMED_STATE || this.mState == State.IDLE_STATE) {
                        if ((this.mUseVerticalScroll && event.getEventTime() - this.mVerticalEnterTime > this.mVerticalResponseTime && this.mTopScrollRegion != null && this.mDeltaY != VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET && this.mTopScrollRegion.contains((int) this.mScrollX, (int) this.mScrollY)) || ((this.mUseVerticalScroll && event.getEventTime() - this.mVerticalEnterTime > this.mVerticalResponseTime && this.mBottomScrollRegion != null && this.mBottomScrollRegion.contains((int) this.mScrollX, (int) this.mScrollY)) || ((this.mUseHorizontalScroll && event.getEventTime() - this.mHorizontalEnterTime > this.mHorizontalResponseTime && this.mLeftScrollRegion != null && this.mDeltaX != VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET && this.mLeftScrollRegion.contains((int) this.mScrollX, (int) this.mScrollY)) || (this.mUseHorizontalScroll && event.getEventTime() - this.mHorizontalEnterTime > this.mHorizontalResponseTime && this.mRightScrollRegion != null && this.mDeltaX < this.mMaxDeltaX && this.mRightScrollRegion.contains((int) this.mScrollX, (int) this.mScrollY))))) {
                            this.mState = State.SCROLL_STATE;
                            Scroll();
                            return;
                        }
                        return;
                    }
                    return;
                }
                if (action == 10 && event.getButtonState() != 2) {
                    if (this.mUseSmartScale && this.mState != State.IDLE_STATE) {
                        this.mState = State.READY_FOR_ZOOMOUT_STATE;
                        sendEmptyMessageDelayed(this.mZoomOutResponseTime, this.mZoomOutResponseTime);
                    } else if (this.mUseVerticalScroll || this.mUseHorizontalScroll) {
                        this.mState = State.IDLE_STATE;
                        this.mListener.onChangePan((int) this.mDeltaX, (int) this.mDeltaY);
                        this.mListener.onUpdateScreenFrameBuffer();
                    }
                    Log.d("SPen_Library", "[SMART SCALE] ON HOVER EXIT. STATE : " + this.mState);
                }
            }
        }
    }

    public void onTouchEvent(MotionEvent event) {
        int action = event.getAction();
        int toolType = event.getToolType(0);
        float eventX = event.getX();
        float eventY = event.getY();
        if (action == 0) {
            if (this.mState == State.FLING_STATE || this.mState == State.READY_FOR_ZOOMOUT_STATE) {
                this.mListener.onChangePan((int) this.mDeltaX, (int) this.mDeltaY);
                this.mListener.onUpdateScreenFrameBuffer();
            }
            if (toolType == 2) {
                this.mState = State.ZOOMED_STATE;
            } else {
                this.mState = State.IDLE_STATE;
            }
        }
        if (action == 0) {
            this.mDownTime = event.getEventTime();
            this.mDownX = eventX;
            this.mDownY = eventY;
            this.mFlickDirection = Direction.NONE;
        } else if (action == 1) {
            long diffTime = event.getEventTime() - this.mDownTime;
            this.mDiffX = eventX - this.mDownX;
            this.mDiffY = eventY - this.mDownY;
            float velocityX = (200.0f * this.mDiffX) / (diffTime * this.mDPI);
            float velocityY = (200.0f * this.mDiffY) / (diffTime * this.mDPI);
            if (Math.abs(this.mDiffX) < this.m1CMPixel / 2.0f && Math.abs(this.mDiffY) < this.m1CMPixel / 2.0f) {
                this.mFlickDirection = Direction.NONE;
            } else if (Math.abs(velocityX) < 1.0f && Math.abs(velocityY) < 1.0f) {
                this.mFlickDirection = Direction.NONE;
            } else if (Math.abs(velocityX) > Math.abs(velocityY)) {
                if (velocityX > VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET && this.mDeltaX <= 0.0d) {
                    this.mFlickDirection = Direction.LEFT;
                } else if (velocityX < VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET && this.mDeltaX >= this.mMaxDeltaX) {
                    this.mFlickDirection = Direction.RIGHT;
                }
            } else if (velocityY > VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET && this.mDeltaY <= VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET) {
                this.mFlickDirection = Direction.TOP;
            } else if (velocityY < VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET && this.mDeltaY >= this.mMaxDeltaY) {
                this.mFlickDirection = Direction.BOTTOM;
            }
        }
        if (this.mToolAndActionMap.get(toolType) == 1 && action != 0) {
            if (action == 2) {
                if (this.mEdgeLR.enable) {
                    if (this.mEdgeLR.direction == DirectionLR.NONE) {
                        if (this.mDeltaX <= VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET) {
                            this.mEdgeLR.direction = DirectionLR.LEFT;
                            this.mEdgeLR.startX = eventX;
                        } else if (this.mDeltaX >= this.mMaxDeltaX) {
                            this.mEdgeLR.direction = DirectionLR.RIGHT;
                            this.mEdgeLR.startX = eventX;
                        }
                    } else if (this.mEdgeLR.direction == DirectionLR.LEFT) {
                        if (this.mDeltaX > 1.0f) {
                            this.mEdgeLR.direction = DirectionLR.NONE;
                            this.mEdgeLR.effect.onRelease();
                        } else {
                            float pull = (eventX - this.mEdgeLR.startX) / this.mRtoCvsItstFrmWidth;
                            if (pull < VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET) {
                                pull = VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET;
                            }
                            this.mEdgeLR.effect.onPull(pull);
                        }
                    } else if (this.mDeltaX < this.mMaxDeltaX - 1.0f) {
                        this.mEdgeLR.direction = DirectionLR.NONE;
                        this.mEdgeLR.effect.onRelease();
                    } else {
                        float pull2 = (this.mEdgeLR.startX - eventX) / this.mRtoCvsItstFrmWidth;
                        if (pull2 < VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET) {
                            pull2 = VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET;
                        }
                        this.mEdgeLR.effect.onPull(pull2);
                    }
                } else {
                    this.mEdgeLR.direction = DirectionLR.NONE;
                }
                if (this.mEdgeTB.enable) {
                    if (this.mEdgeTB.direction == DirectionTB.NONE) {
                        if (this.mDeltaY <= VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET) {
                            this.mEdgeTB.direction = DirectionTB.TOP;
                            this.mEdgeTB.startY = eventY;
                            return;
                        } else {
                            if (this.mDeltaY >= this.mMaxDeltaY) {
                                this.mEdgeTB.direction = DirectionTB.BOTTOM;
                                this.mEdgeTB.startY = eventY;
                                return;
                            }
                            return;
                        }
                    }
                    if (this.mEdgeTB.direction == DirectionTB.TOP) {
                        if (this.mDeltaY > 1.0f) {
                            this.mEdgeTB.direction = DirectionTB.NONE;
                            this.mEdgeTB.effect.onRelease();
                            return;
                        } else {
                            float pull3 = (eventY - this.mEdgeTB.startY) / this.mRtoCvsItstFrmHeight;
                            if (pull3 < VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET) {
                                pull3 = VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET;
                            }
                            this.mEdgeTB.effect.onPull(pull3);
                            return;
                        }
                    }
                    if (this.mDeltaY < this.mMaxDeltaY - 1.0f) {
                        this.mEdgeTB.direction = DirectionTB.NONE;
                        this.mEdgeTB.effect.onRelease();
                        return;
                    } else {
                        float pull4 = (this.mEdgeTB.startY - eventY) / this.mRtoCvsItstFrmHeight;
                        if (pull4 < VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET) {
                            pull4 = VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET;
                        }
                        this.mEdgeTB.effect.onPull(pull4);
                        return;
                    }
                }
                this.mEdgeTB.direction = DirectionTB.NONE;
                return;
            }
            this.mEdgeLR.direction = DirectionLR.NONE;
            this.mEdgeTB.direction = DirectionTB.NONE;
            this.mEdgeLR.effect.onRelease();
            this.mEdgeTB.effect.onRelease();
        }
    }

    public void onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        if (this.mFlickDirection == Direction.NONE) {
            this.mDistanceX = velocityX / (this.mRatio * 4.0f);
            this.mDistanceY = velocityY / (this.mRatio * 4.0f);
            if (this.mDeltaX - this.mDistanceX < VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET) {
                this.mDistanceX = this.mDeltaX;
            } else if (this.mDeltaX - this.mDistanceX > this.mMaxDeltaX) {
                this.mDistanceX = this.mDeltaX - this.mMaxDeltaX;
            }
            if (this.mDeltaY - this.mDistanceY < VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET) {
                this.mDistanceY = this.mDeltaY;
            } else if (this.mDeltaY - this.mDistanceY > this.mMaxDeltaY) {
                this.mDistanceY = this.mDeltaY - this.mMaxDeltaY;
            }
            if (this.mDistanceX != 0.0d || this.mDistanceY != 0.0d) {
                this.mState = State.FLING_STATE;
                Fling();
                return;
            }
            return;
        }
        if (this.mListener != null) {
            if (this.mFlickDirection == Direction.LEFT) {
                this.mListener.onFlick(0);
            } else if (this.mFlickDirection == Direction.RIGHT) {
                this.mListener.onFlick(1);
            }
        }
    }

    public void onZoom(float deltaX, float deltaY, float ratio) {
        this.mDeltaX = deltaX;
        this.mDeltaY = deltaY;
        this.mRatio = ratio;
    }

    public void setLimitHeight(float maxDeltaX, float maxDeltaY) {
        this.mMaxDeltaX = maxDeltaX;
        this.mMaxDeltaY = maxDeltaY;
        if (this.mMaxDeltaX > VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET) {
            this.mEdgeLR.enable = true;
        } else {
            this.mEdgeLR.enable = false;
        }
        if (this.mMaxDeltaY > VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET) {
            this.mEdgeTB.enable = true;
        } else {
            this.mEdgeTB.enable = false;
        }
    }

    public void setDrawInformation(int width, int height, int startX, int startY) {
        if (this.mRtoCvsItstFrmWidth != width || this.mRtoCvsItstFrmHeight != height) {
            this.mRtoCvsItstFrmWidth = width;
            this.mRtoCvsItstFrmHeight = height;
            this.mFrameStartX = startX;
            this.mFrameStartY = startY;
            this.mEdgeLR.effect.setSize(this.mRtoCvsItstFrmHeight, this.mRtoCvsItstFrmWidth);
            this.mEdgeTB.effect.setSize(this.mRtoCvsItstFrmWidth, this.mRtoCvsItstFrmHeight);
        }
    }

    public State getState() {
        return this.mState;
    }

    public float getCenterX() {
        return this.mCenterX;
    }

    public float getCenterY() {
        return this.mCenterY;
    }

    private void Scroll() {
        boolean sendMessage = true;
        boolean setPan = false;
        int dx = 0;
        int dy = 0;
        if (this.mUseVerticalScroll && this.mTopScrollRegion != null && this.mDeltaY != VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET && this.mTopScrollRegion.contains((int) this.mScrollX, (int) this.mScrollY)) {
            dy = 0 - this.mVerticalVelocity;
        }
        if (this.mUseVerticalScroll && this.mBottomScrollRegion != null && this.mBottomScrollRegion.contains((int) this.mScrollX, (int) this.mScrollY)) {
            dy += this.mVerticalVelocity;
        }
        if (this.mUseHorizontalScroll && this.mLeftScrollRegion != null && this.mDeltaX != VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET && this.mLeftScrollRegion.contains((int) this.mScrollX, (int) this.mScrollY)) {
            dx = 0 - this.mHorizontalVelocity;
        }
        if (this.mUseHorizontalScroll && this.mRightScrollRegion != null && this.mDeltaX < this.mMaxDeltaX && this.mRightScrollRegion.contains((int) this.mScrollX, (int) this.mScrollY)) {
            dx += this.mHorizontalVelocity;
        }
        if (dx != 0) {
            this.mDeltaX += dx;
            sendMessage = true;
            if (this.mDeltaX < VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET) {
                this.mDeltaX = VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET;
                sendMessage = false;
            } else if (this.mDeltaX > this.mMaxDeltaX) {
                this.mDeltaX = this.mMaxDeltaX;
                sendMessage = false;
            }
            setPan = true;
        }
        if (dy != 0) {
            this.mDeltaY += dy;
            sendMessage = true;
            if (this.mDeltaY < VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET) {
                this.mDeltaY = VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET;
                sendMessage = false;
            } else if (this.mDeltaY > this.mMaxDeltaY) {
                this.mDeltaY = this.mMaxDeltaY;
                sendMessage = false;
            }
            setPan = true;
        }
        if (setPan && this.mListener != null) {
            this.mListener.onChangePan(this.mDeltaX, this.mDeltaY);
        }
        if (sendMessage) {
            sendEmptyMessageDelayed(0, 0L);
        } else {
            this.mState = State.ZOOMED_STATE;
        }
    }

    private void ReadyForZoomout() {
        Log.d("SPen_Library", "[SMART SCALE] READY FOR ZOOM OUT()");
        this.mState = State.ZOOMOUT_STATE;
        ZoomOut();
    }

    private void ZoomIn() {
        if (this.mRatio >= this.mZoomRatio) {
            this.mState = State.ZOOMED_STATE;
            if (this.mListener != null) {
                this.mListener.onChangeScale((int) this.mCenterX, (int) this.mCenterY, this.mZoomRatio);
                this.mListener.onUpdateScreenFrameBuffer();
                Log.d("SPen_Library", "[SMART SCALE] ZOOM IN(), RATIO : " + this.mZoomRatio + ", STATE : " + this.mState);
                return;
            }
            return;
        }
        this.mState = State.ZOOMIN_STATE;
        this.mRatio += this.mFactor;
        if (this.mListener != null) {
            this.mListener.onChangeScale(this.mCenterX, this.mCenterY, this.mRatio);
        }
        sendEmptyMessageDelayed(0, 0L);
        Log.d("SPen_Library", "[SMART SCALE] ZOOM IN(), RATIO : " + this.mRatio + ", STATE : " + this.mState);
    }

    private void ZoomOut() {
        this.mRatio -= this.mFactor;
        if (this.mRatio <= this.mOrigRatio) {
            this.mRatio = this.mOrigRatio;
            this.mState = State.IDLE_STATE;
        }
        if (this.mState != State.IDLE_STATE) {
            this.mListener.onChangeScale(this.mCenterX, this.mCenterY, this.mRatio);
            sendEmptyMessageDelayed(0, 0L);
        } else {
            this.mListener.onChangeScale((int) this.mCenterX, (int) this.mCenterY, this.mRatio);
            this.mListener.onUpdateScreenFrameBuffer();
        }
        Log.d("SPen_Library", "[SMART SCALE] ZOOM OUT(), RATIO : " + this.mRatio + ", STATE : " + this.mState);
    }

    private void Fling() {
        float currentDistanceX = this.mDistanceX * 0.15f;
        float currentDistanceY = this.mDistanceY * 0.15f;
        if (currentDistanceX < -100.0f) {
            currentDistanceX = -100.0f;
        } else if (currentDistanceX > 100.0f) {
            currentDistanceX = 100.0f;
        }
        if (currentDistanceY < -100.0f) {
            currentDistanceY = -100.0f;
        } else if (currentDistanceY > 100.0f) {
            currentDistanceY = 100.0f;
        }
        this.mDistanceX -= currentDistanceX;
        this.mDistanceY -= currentDistanceY;
        float deltaX = this.mDeltaX - currentDistanceX;
        float deltaY = this.mDeltaY - currentDistanceY;
        if (Math.abs(currentDistanceX) < 1.0f && Math.abs(currentDistanceY) < 1.0f) {
            this.mState = State.IDLE_STATE;
            this.mListener.onChangePan((int) deltaX, (int) deltaY);
            this.mListener.onUpdateScreenFrameBuffer();
        } else {
            this.mListener.onChangePan(deltaX, deltaY);
            sendEmptyMessageDelayed(0, 0L);
        }
    }
}
