package com.coolots.chaton.call.view.layout;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Handler;
import android.os.Message;
import android.os.Vibrator;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.ScaleAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.coolots.chaton.C0000R;
import com.coolots.chaton.call.screenshare.util.ScreenSharePacket;
import com.coolots.chaton.common.util.ContentDescriptionStringMaker;
import com.sds.coolots.common.util.Log;
import com.sds.coolots.common.view.DisposeInterface;
import com.vlingo.sdk.recognition.spotter.VLSpotterContext;

/* loaded from: classes.dex */
public class IncomingLiveScreenShareCallWidget extends RelativeLayout implements DisposeInterface {
    private static final String CLASSNAME = "[IncomingCallWidget]";
    private final long VIBRATE_LONG;
    private final long VIBRATE_SHORT;
    private Context mContext;
    private DisplayMetrics mDisplayMetrics;
    private int mGrabbedState;
    private boolean mHandlerDispose;
    private boolean mIsTracking;
    public Handle mLeftHandle;
    private OnTriggerListener mOnTriggerListener;
    public Handle mRightHandle;
    private Vibrator mVibrator;

    public interface OnTriggerListener {
        public static final int LEFT_HANDLE = 1;
        public static final int NO_HANDLE = 0;
        public static final int RIGHT_HANDLE = 2;

        void onGrabbedStateChange(View view, int i);

        void onTrigger(View view, int i);
    }

    private void logE(String message) {
        Log.m2958e(CLASSNAME + message);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void logI(String message) {
        Log.m2963i(CLASSNAME + message);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void logD(String message) {
        Log.m2954d(CLASSNAME + message);
    }

    public IncomingLiveScreenShareCallWidget(Context context) {
        super(context);
        this.VIBRATE_SHORT = 30L;
        this.VIBRATE_LONG = 40L;
        this.mGrabbedState = 0;
        this.mContext = context;
        init();
    }

    public IncomingLiveScreenShareCallWidget(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.VIBRATE_SHORT = 30L;
        this.VIBRATE_LONG = 40L;
        this.mGrabbedState = 0;
        this.mContext = context;
        init();
    }

    public IncomingLiveScreenShareCallWidget(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.VIBRATE_SHORT = 30L;
        this.VIBRATE_LONG = 40L;
        this.mGrabbedState = 0;
        this.mContext = context;
        init();
    }

    private void init() {
        logI("init");
        this.mDisplayMetrics = new DisplayMetrics();
        ((Activity) this.mContext).getWindowManager().getDefaultDisplay().getMetrics(this.mDisplayMetrics);
        this.mLeftHandle = new Handle(this.mContext, this, 1);
        this.mRightHandle = new Handle(this.mContext, this, 2);
        this.mHandlerDispose = false;
    }

    public void setRightTabResources(int iconId, int targetId, int barId, int tabId) {
    }

    public void setLeftTabResources(int iconId, int targetId, int barId, int tabId) {
    }

    public void setLeftHintText(int resId) {
    }

    public void setRightHintText(int resId) {
    }

    public void reset() {
        if (this.mLeftHandle != null) {
            this.mLeftHandle.setState(0, false);
        }
        if (this.mRightHandle != null) {
            this.mRightHandle.setState(0, false);
        }
    }

    public void setOnTriggerListener(OnTriggerListener listener) {
        this.mOnTriggerListener = listener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dispatchTriggerEvent(int whichHandle) {
        logI("dispatchTriggerEvent : whichHandle - " + whichHandle);
        vibrate(40L);
        if (this.mOnTriggerListener != null) {
            this.mOnTriggerListener.onTrigger(this, whichHandle);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setGrabbedState(int newState) {
        if (newState != this.mGrabbedState) {
            this.mGrabbedState = newState;
            if (this.mOnTriggerListener != null) {
                this.mOnTriggerListener.onGrabbedStateChange(this, this.mGrabbedState);
            }
        }
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed, l, t, r, b);
        if (PhoneFeature.hasFeature(1)) {
            this.mLeftHandle.tabletMakeLayout();
            this.mRightHandle.tabletMakeLayout();
        } else {
            this.mLeftHandle.makeLayout();
            this.mRightHandle.makeLayout();
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent event) {
        int action = event.getAction();
        float x = event.getX();
        float y = event.getY();
        boolean leftHit = this.mLeftHandle.isHandleSelected(x, y);
        boolean rightHit = this.mRightHandle.isHandleSelected(x, y);
        if (!this.mIsTracking && !leftHit && !rightHit) {
            return false;
        }
        switch (action) {
            case 0:
                vibrate(30L);
                this.mIsTracking = true;
                if (leftHit) {
                    this.mLeftHandle.setState(1);
                    this.mRightHandle.setState(2);
                    setGrabbedState(1);
                    break;
                } else if (rightHit) {
                    this.mRightHandle.setState(1);
                    this.mLeftHandle.setState(2);
                    setGrabbedState(2);
                    break;
                }
                break;
        }
        return true;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent event) {
        if (this.mIsTracking) {
            int action = event.getAction();
            switch (action) {
                case 1:
                case 3:
                case 6:
                    this.mIsTracking = false;
                    this.mLeftHandle.setState(0);
                    this.mRightHandle.setState(0);
                    setGrabbedState(0);
                    return true;
                case 2:
                    if (this.mLeftHandle.getState() == 1) {
                        if (PhoneFeature.hasFeature(1)) {
                            this.mLeftHandle.tabletProcessMoveEvent(event);
                            return true;
                        }
                        this.mLeftHandle.processMoveEvent(event);
                        return true;
                    }
                    if (this.mRightHandle.getState() != 1) {
                        return true;
                    }
                    if (PhoneFeature.hasFeature(1)) {
                        this.mRightHandle.tabletProcessMoveEvent(event);
                        return true;
                    }
                    this.mRightHandle.processMoveEvent(event);
                    return true;
            }
        }
        return this.mIsTracking || super.onTouchEvent(event);
    }

    private synchronized void vibrate(long duration) {
        if (this.mVibrator == null) {
            this.mVibrator = (Vibrator) getContext().getSystemService("vibrator");
        }
        this.mVibrator.vibrate(duration);
    }

    public class Handle {
        public static final int STATE_ACTIVE = 1;
        public static final int STATE_INACTIVE = 2;
        public static final int STATE_NORMAL = 0;
        private LinearLayout mArrowContainer;
        private ImageView[] mArrowImageViews;
        private int mCircleColor;
        public FrameLayout mContainer;
        private Context mContext;
        private int mCurrentState;
        private int mHandleType;
        private TextView mIncomingCircleDescription;
        private ViewGroup mParent;
        private ImageView mTab;
        private TabCircle mTabCircle;
        private TargetCircle mTargetCircle;
        private int mTopOffset;
        private final int FIRST_WAVE_DELAY = 900;
        private final int SECOND_WAVE_DELAY = ScreenSharePacket.SCREEN_SHARE_CMD_SETTING_MATRIXINFO;
        private final int START_WAVE = 100;
        private final int RESET_STATE = 200;
        private final int ARROW_ANI_DURATION = 900;
        final int ARROW_COUNT = 3;
        private Handler mHandler = new Handler() { // from class: com.coolots.chaton.call.view.layout.IncomingLiveScreenShareCallWidget.Handle.1
            @Override // android.os.Handler
            public void handleMessage(Message msg) {
                if (!IncomingLiveScreenShareCallWidget.this.mHandlerDispose) {
                    IncomingLiveScreenShareCallWidget.this.logI("handleMessage");
                    switch (msg.what) {
                        case 100:
                            if (Handle.this.mArrowContainer.isShown()) {
                                ImageView arrowImage = null;
                                for (int i = 0; i < 3; i++) {
                                    int index = Handle.this.mHandleType == 1 ? i : (3 - i) - 1;
                                    arrowImage = Handle.this.mArrowImageViews[index];
                                    Animation ani = arrowImage.getAnimation();
                                    if (ani == null || !ani.hasStarted()) {
                                        if (3 != i + 1) {
                                            sendEmptyMessageDelayed(100, 150L);
                                        } else {
                                            sendEmptyMessageDelayed(100, 900L);
                                        }
                                        arrowImage.startAnimation(Handle.this.makeArrowAnimation());
                                        break;
                                    }
                                }
                                arrowImage.startAnimation(Handle.this.makeArrowAnimation());
                            }
                            break;
                        case 200:
                            IncomingLiveScreenShareCallWidget.this.mLeftHandle.setState(0);
                            IncomingLiveScreenShareCallWidget.this.mRightHandle.setState(0);
                            break;
                        default:
                            super.handleMessage(msg);
                            break;
                    }
                }
            }
        };
        private final int MAKE_TARGET_DURATION = 400;
        private final int RESET_DURATION = 200;

        public Handle(Context context, ViewGroup parent, int handleType) {
            this.mHandleType = 0;
            this.mContext = context;
            this.mHandleType = handleType;
            this.mParent = parent;
            init();
        }

        private void init() {
            RelativeLayout.LayoutParams mContainerParams;
            IncomingLiveScreenShareCallWidget.this.logI(" Handle ; init!");
            this.mCurrentState = 0;
            this.mContainer = new FrameLayout(this.mContext) { // from class: com.coolots.chaton.call.view.layout.IncomingLiveScreenShareCallWidget.Handle.2
                @Override // android.view.View
                protected void onWindowVisibilityChanged(int visibility) {
                    IncomingLiveScreenShareCallWidget.this.logI("onWindowVisibilityChanged visibility : " + visibility);
                    super.onWindowVisibilityChanged(visibility);
                    switch (visibility) {
                        case 0:
                            Handle.this.showArrow();
                            break;
                        default:
                            Handle.this.hideArrow();
                            break;
                    }
                }
            };
            DisplayMetrics metrics = this.mContext.getResources().getDisplayMetrics();
            int diameter = (Math.min(metrics.widthPixels, metrics.heightPixels) * 91) / 128;
            if (PhoneFeature.hasFeature(1)) {
                diameter = (Math.min(metrics.widthPixels, metrics.heightPixels) * 86) / 128;
            }
            RelativeLayout.LayoutParams containerParams = new RelativeLayout.LayoutParams(diameter, diameter);
            containerParams.addRule(12);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2, 17);
            this.mTab = new ImageView(this.mContext);
            this.mContainer.addView(this.mTab, layoutParams);
            if (this.mHandleType == 1) {
                containerParams.addRule(9);
                this.mTab.setBackgroundResource(C0000R.drawable.share_ic_jog_dial_answer);
                this.mCircleColor = -10378987;
            } else if (this.mHandleType == 2) {
                containerParams.addRule(11);
                this.mTab.setBackgroundResource(C0000R.drawable.share_ic_jog_dial_decline);
                this.mCircleColor = -5760497;
            }
            if (PhoneFeature.hasFeature(1)) {
                this.mTabCircle = new TabCircle(this.mContext, (diameter * 8.0f) / 50.0f);
            } else {
                this.mTabCircle = new TabCircle(this.mContext, (diameter * 20.0f) / 100.0f);
            }
            this.mTabCircle.setVisibility(0);
            this.mContainer.addView(this.mTabCircle, layoutParams);
            makeArrowViews(this.mContainer, diameter);
            this.mTargetCircle = new TargetCircle(this.mContext, diameter / 2);
            this.mTargetCircle.setVisibility(4);
            this.mContainer.addView(this.mTargetCircle, layoutParams);
            this.mContainer.setLayoutParams(containerParams);
            this.mParent.addView(this.mContainer);
            if (PhoneFeature.hasFeature(2)) {
                if (IncomingLiveScreenShareCallWidget.this.getResources().getConfiguration().orientation == 2) {
                    mContainerParams = new RelativeLayout.LayoutParams(-1, (diameter * 60) / 100);
                } else {
                    mContainerParams = new RelativeLayout.LayoutParams(-1, (diameter * 72) / 100);
                }
                mContainerParams.addRule(12);
                this.mIncomingCircleDescription = new TextView(this.mContext);
                this.mIncomingCircleDescription.setText(C0000R.string.call_answer_description);
                this.mIncomingCircleDescription.setGravity(1);
                this.mIncomingCircleDescription.setLayoutParams(mContainerParams);
                this.mParent.addView(this.mIncomingCircleDescription);
            }
            if (this.mHandleType == 1) {
                this.mTab.setContentDescription(ContentDescriptionStringMaker.makeString(C0000R.string.call_swipe_right_message, C0000R.string.slide_to_answer_hint));
                this.mTab.setClickable(true);
            } else if (this.mHandleType == 2) {
                this.mTab.setContentDescription(ContentDescriptionStringMaker.makeString(C0000R.string.call_swipe_left_message, C0000R.string.slide_to_decline_hint));
                this.mTab.setClickable(true);
            }
        }

        private void makeArrowViews(FrameLayout container, int diameter) {
            int alpha;
            int arrowResId;
            this.mArrowContainer = new LinearLayout(this.mContext);
            this.mArrowImageViews = new ImageView[3];
            int layoutGravity = 0;
            LinearLayout.LayoutParams paddingLp = new LinearLayout.LayoutParams((diameter * 3) / 80, (diameter * 3) / 80, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET);
            for (int i = 0; i < 3; i++) {
                this.mArrowImageViews[i] = new ImageView(this.mContext);
                if (this.mHandleType == 1) {
                    arrowResId = C0000R.drawable.arrow_g;
                    layoutGravity = 21;
                    alpha = (int) (255.0f * (1.0f - ((20.0f * ((3 - i) - 1)) / 100.0f)));
                    if (i != 0) {
                        this.mArrowContainer.addView(new View(this.mContext), paddingLp);
                    }
                    this.mArrowContainer.addView(this.mArrowImageViews[i]);
                } else {
                    alpha = (int) (255.0f * (1.0f - ((20.0f * i) / 100.0f)));
                    arrowResId = C0000R.drawable.arrow_r;
                    layoutGravity = 19;
                    this.mArrowContainer.addView(this.mArrowImageViews[i]);
                    if (i != 2) {
                        this.mArrowContainer.addView(new View(this.mContext), paddingLp);
                    }
                }
                this.mArrowImageViews[i].setImageResource(arrowResId);
                this.mArrowImageViews[i].setAlpha(alpha);
            }
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2, layoutGravity);
            container.addView(this.mArrowContainer, layoutParams);
            ViewGroup.MarginLayoutParams lp = (ViewGroup.MarginLayoutParams) this.mArrowContainer.getLayoutParams();
            if (PhoneFeature.hasFeature(4)) {
                if (this.mHandleType == 1) {
                    lp.rightMargin = (diameter * 13) / 120;
                } else {
                    lp.leftMargin = (diameter * 13) / 120;
                }
            } else if (this.mHandleType == 1) {
                lp.rightMargin = (diameter * 11) / 120;
            } else {
                lp.leftMargin = (diameter * 11) / 120;
            }
            this.mArrowContainer.setLayoutParams(lp);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void showArrow() {
            if (this.mContainer.isShown()) {
                this.mArrowContainer.setVisibility(0);
                if (!this.mHandler.hasMessages(100)) {
                    this.mHandler.sendEmptyMessage(100);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void hideArrow() {
            this.mHandler.removeMessages(100);
            this.mArrowContainer.setVisibility(4);
            for (ImageView imageView : this.mArrowImageViews) {
                imageView.clearAnimation();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public AlphaAnimation makeArrowAnimation() {
            AlphaAnimation alphaAni = new AlphaAnimation(1.0f, 0.6f);
            alphaAni.setDuration(900L);
            alphaAni.setInterpolator(AnimationUtils.loadInterpolator(this.mContext, R.anim.accelerate_interpolator));
            return alphaAni;
        }

        public void makeLayout() {
            ((Activity) this.mContext).getWindowManager().getDefaultDisplay().getMetrics(IncomingLiveScreenShareCallWidget.this.mDisplayMetrics);
            int marginY = 0;
            int marginX = (this.mContainer.getWidth() * 36) / 128;
            if (PhoneFeature.hasFeature(4)) {
                marginX -= (IncomingLiveScreenShareCallWidget.this.mDisplayMetrics.densityDpi * 17) / 160;
                marginY = (IncomingLiveScreenShareCallWidget.this.mDisplayMetrics.densityDpi * 10) / 160;
            }
            if (this.mHandleType == 1) {
                int leftHandleLeft = this.mContainer.getLeft() - marginX;
                int leftHandleTop = this.mContainer.getTop() + (this.mContainer.getHeight() / 10);
                this.mContainer.layout(leftHandleLeft, leftHandleTop - marginY, this.mContainer.getWidth() + leftHandleLeft, (this.mContainer.getHeight() + leftHandleTop) - marginY);
            } else if (this.mHandleType == 2) {
                int rightHandleLeft = this.mContainer.getLeft() + marginX;
                int rightHandleTop = this.mContainer.getTop() + (this.mContainer.getHeight() / 10);
                this.mContainer.layout(rightHandleLeft, rightHandleTop - marginY, this.mContainer.getWidth() + rightHandleLeft, (this.mContainer.getHeight() + rightHandleTop) - marginY);
            }
            IncomingLiveScreenShareCallWidget.this.logI("mDisplayMetrics " + IncomingLiveScreenShareCallWidget.this.mDisplayMetrics);
        }

        public void tabletMakeLayout() {
            int rightHandleTop;
            int leftHandleTop;
            ((Activity) this.mContext).getWindowManager().getDefaultDisplay().getMetrics(IncomingLiveScreenShareCallWidget.this.mDisplayMetrics);
            int marginX = (this.mContainer.getWidth() * 34) / 128;
            boolean isLandScape = false;
            Configuration config = IncomingLiveScreenShareCallWidget.this.getResources().getConfiguration();
            if (config.orientation == 2) {
                isLandScape = true;
            } else if (config.orientation == 1) {
                isLandScape = false;
            }
            if (this.mHandleType == 1) {
                int leftHandleLeft = this.mContainer.getLeft() - marginX;
                if (isLandScape) {
                    leftHandleTop = this.mContainer.getTop() + ((this.mContainer.getHeight() * 1) / 18);
                } else {
                    leftHandleTop = this.mContainer.getTop() - ((this.mContainer.getHeight() * 1) / 7);
                }
                this.mContainer.layout(leftHandleLeft, leftHandleTop, this.mContainer.getWidth() + leftHandleLeft, this.mContainer.getHeight() + leftHandleTop);
            } else if (this.mHandleType == 2) {
                int rightHandleLeft = this.mContainer.getLeft() + marginX;
                if (isLandScape) {
                    rightHandleTop = this.mContainer.getTop() + ((this.mContainer.getHeight() * 1) / 18);
                } else {
                    rightHandleTop = this.mContainer.getTop() - ((this.mContainer.getHeight() * 1) / 7);
                }
                this.mContainer.layout(rightHandleLeft, rightHandleTop, this.mContainer.getWidth() + rightHandleLeft, this.mContainer.getHeight() + rightHandleTop);
            }
            IncomingLiveScreenShareCallWidget.this.logI("mDisplayMetrics " + IncomingLiveScreenShareCallWidget.this.mDisplayMetrics);
        }

        public void setState(int newState) {
            setState(newState, true);
        }

        public void setState(int newState, boolean animation) {
            if (this.mHandler.hasMessages(200)) {
                IncomingLiveScreenShareCallWidget.this.logI("Block setState until reset. Handles will be reset");
            }
            int preState = this.mCurrentState;
            this.mCurrentState = newState;
            IncomingLiveScreenShareCallWidget.this.logI("HANDLE : " + this.mCurrentState + " setState preState " + preState + " Current : " + this.mCurrentState);
            switch (this.mCurrentState) {
                case 0:
                    if (preState == 2) {
                        setEnable();
                        break;
                    } else if (preState == 1) {
                        reset(animation);
                        break;
                    } else {
                        reset(false);
                        break;
                    }
                case 1:
                    showTarget();
                    break;
                case 2:
                    setDisable();
                    break;
            }
        }

        public int getState() {
            return this.mCurrentState;
        }

        private void showTarget() {
            AnimationSet aniSet = new AnimationSet(true);
            ScaleAnimation scaleAni = new ScaleAnimation(0.3f, 1.0f, 0.3f, 1.0f, this.mTargetCircle.getWidth() / 2.0f, this.mTargetCircle.getWidth() / 2.0f);
            aniSet.addAnimation(scaleAni);
            AlphaAnimation alphaAni = new AlphaAnimation(VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, 1.0f);
            aniSet.addAnimation(alphaAni);
            aniSet.setDuration(400L);
            aniSet.setInterpolator(AnimationUtils.loadInterpolator(this.mContext, R.anim.decelerate_interpolator));
            aniSet.setFillAfter(true);
            this.mTargetCircle.startAnimation(aniSet);
            this.mTargetCircle.setAlpha(97);
            this.mTargetCircle.setVisibility(0);
        }

        private void reset(boolean animation) {
            if (animation) {
                AnimationSet aniSet = new AnimationSet(true);
                ScaleAnimation scaleAni = new ScaleAnimation(1.0f, 0.3f, 1.0f, 0.3f, this.mTargetCircle.getWidth() / 2.0f, this.mTargetCircle.getWidth() / 2.0f);
                aniSet.addAnimation(scaleAni);
                AlphaAnimation alphaAni = new AlphaAnimation(1.0f, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET);
                aniSet.addAnimation(alphaAni);
                aniSet.setDuration(400L);
                aniSet.setInterpolator(AnimationUtils.loadInterpolator(this.mContext, R.anim.accelerate_interpolator));
                this.mTargetCircle.clearAnimation();
                this.mTargetCircle.startAnimation(aniSet);
            } else {
                this.mTargetCircle.clearAnimation();
            }
            this.mTargetCircle.setVisibility(4);
            this.mTabCircle.clearAnimation();
            this.mTabCircle.setAlpha(255);
            this.mTabCircle.invalidate();
            this.mTabCircle.setVisibility(0);
            showArrow();
        }

        private void setDisable() {
            AlphaAnimation alphaAni = new AlphaAnimation(1.0f, 0.35f);
            alphaAni.setDuration(200L);
            alphaAni.setFillAfter(true);
            this.mTab.startAnimation(alphaAni);
            this.mTabCircle.setVisibility(4);
            hideArrow();
        }

        private void setEnable() {
            AlphaAnimation tabAni = new AlphaAnimation(0.35f, 1.0f);
            tabAni.setDuration(200L);
            tabAni.setFillAfter(true);
            this.mTab.startAnimation(tabAni);
            this.mTabCircle.setVisibility(0);
            showArrow();
        }

        public void processMoveEvent(MotionEvent motion) {
            if (this.mCurrentState == 1) {
                float x = motion.getX();
                float y = motion.getY();
                if (this.mTargetCircle.isThresholdReached(x, y)) {
                    this.mHandler.sendEmptyMessageDelayed(200, 500L);
                    this.mTargetCircle.clearAnimation();
                    this.mTabCircle.clearAnimation();
                    this.mTargetCircle.setAlpha(255);
                    this.mTargetCircle.invalidate();
                    this.mTabCircle.setAlpha(0);
                    this.mTabCircle.invalidate();
                    IncomingLiveScreenShareCallWidget.this.mIsTracking = false;
                    IncomingLiveScreenShareCallWidget.this.dispatchTriggerEvent(this.mHandleType);
                    IncomingLiveScreenShareCallWidget.this.setGrabbedState(0);
                    return;
                }
                if (this.mTabCircle.isInCircle(x, y)) {
                    showArrow();
                } else {
                    hideArrow();
                }
                double ratio = this.mTargetCircle.getTargetProximityRatio(x, y);
                this.mTabCircle.setAlpha(255 - ((int) (255.0d * ratio)));
                this.mTargetCircle.setAlpha(((int) (158.0d * ratio)) + 97);
                this.mTargetCircle.invalidate();
                this.mTabCircle.invalidate();
            }
        }

        public void tabletProcessMoveEvent(MotionEvent motion) {
            if (this.mCurrentState == 1) {
                float x = motion.getX();
                float y = motion.getY();
                double currentRatio = this.mTargetCircle.getTargetProximityRatio(x, y);
                if (currentRatio < 0.95d) {
                    IncomingLiveScreenShareCallWidget.this.logI("Not reach the target circle, set Circle's alpha value");
                    if (this.mTabCircle.isInCircle(x, y)) {
                        showArrow();
                    } else {
                        hideArrow();
                    }
                    this.mTabCircle.setAlpha(255 - ((int) (255.0d * currentRatio)));
                    this.mTargetCircle.setAlpha(((int) (158.0d * currentRatio)) + 97);
                    this.mTargetCircle.invalidate();
                    this.mTabCircle.invalidate();
                    return;
                }
                if (currentRatio < 0.95d || currentRatio > 2.5d) {
                    IncomingLiveScreenShareCallWidget.this.logI(" Go over the valid region, set the State as Normal");
                    this.mHandler.postDelayed(new Runnable() { // from class: com.coolots.chaton.call.view.layout.IncomingLiveScreenShareCallWidget.Handle.4
                        @Override // java.lang.Runnable
                        public void run() {
                            IncomingLiveScreenShareCallWidget.this.mLeftHandle.setState(0);
                            IncomingLiveScreenShareCallWidget.this.mRightHandle.setState(0);
                        }
                    }, 500L);
                    return;
                }
                IncomingLiveScreenShareCallWidget.this.logI(" Reach the valid region, let's call dispatchTriggerEvent()");
                this.mTargetCircle.clearAnimation();
                this.mTabCircle.clearAnimation();
                this.mTargetCircle.setAlpha(255);
                this.mTargetCircle.invalidate();
                this.mTabCircle.setAlpha(0);
                this.mTabCircle.invalidate();
                IncomingLiveScreenShareCallWidget.this.mIsTracking = false;
                IncomingLiveScreenShareCallWidget.this.dispatchTriggerEvent(this.mHandleType);
                IncomingLiveScreenShareCallWidget.this.setGrabbedState(0);
                this.mHandler.postDelayed(new Runnable() { // from class: com.coolots.chaton.call.view.layout.IncomingLiveScreenShareCallWidget.Handle.3
                    @Override // java.lang.Runnable
                    public void run() {
                        IncomingLiveScreenShareCallWidget.this.mLeftHandle.setState(0);
                        IncomingLiveScreenShareCallWidget.this.mRightHandle.setState(0);
                    }
                }, 500L);
            }
        }

        public boolean isHandleSelected(float x, float y) {
            ((Activity) this.mContext).getWindowManager().getDefaultDisplay().getMetrics(IncomingLiveScreenShareCallWidget.this.mDisplayMetrics);
            this.mTopOffset = IncomingLiveScreenShareCallWidget.this.mDisplayMetrics.heightPixels - IncomingLiveScreenShareCallWidget.this.getMeasuredHeight();
            IncomingLiveScreenShareCallWidget.this.logI("mTopOffset : " + this.mTopOffset);
            if (this.mTopOffset < 0 || PhoneFeature.hasFeature(1)) {
                this.mTopOffset = 0;
            }
            return this.mTabCircle.isInCircle(x, y);
        }

        public class TabCircle extends View {
            private Paint mLinePaint;
            private float mRadius;

            public TabCircle(Context context, float radius) {
                super(context);
                init(radius);
            }

            public void setAlpha(int alpha) {
                if (this.mLinePaint != null) {
                    this.mLinePaint.setAlpha(alpha);
                }
            }

            private void init(float radius) {
                this.mLinePaint = new Paint();
                this.mLinePaint.setAntiAlias(true);
                this.mLinePaint.setColor(Handle.this.mCircleColor);
                this.mLinePaint.setStyle(Paint.Style.STROKE);
                if (!PhoneFeature.hasFeature(1)) {
                    if (IncomingLiveScreenShareCallWidget.this.mDisplayMetrics.densityDpi == 160) {
                        this.mLinePaint.setStrokeWidth(3.0f);
                    } else {
                        this.mLinePaint.setStrokeWidth(4.0f);
                    }
                } else {
                    this.mLinePaint.setStrokeWidth(5.0f);
                }
                this.mRadius = radius;
            }

            public boolean isInCircle(float x, float y) {
                int[] tmpPos = new int[2];
                getLocationOnScreen(tmpPos);
                float pivotX = tmpPos[0] + (getWidth() / 2);
                float pivotY = (tmpPos[1] + (getHeight() / 2)) - Handle.this.mTopOffset;
                double dx = Math.abs(x - pivotX);
                double dy = Math.abs(y - pivotY);
                double posLength = Math.sqrt((dx * dx) + (dy * dy));
                double ratio = posLength / this.mRadius;
                IncomingLiveScreenShareCallWidget.this.logI("isInCircle - x : " + x + " y : " + y + " ratio : " + ratio);
                return ratio < 1.3d;
            }

            @Override // android.view.View
            public void onDraw(Canvas canvas) {
                canvas.drawCircle(getWidth() / 2.0f, getHeight() / 2.0f, this.mRadius, this.mLinePaint);
            }

            @Override // android.view.View
            public boolean dispatchGenericMotionEvent(MotionEvent event) {
                IncomingLiveScreenShareCallWidget.this.logD("dispatchGenericMotionEvent : event = " + event);
                int action = event.getAction();
                if (action == 9 || action == 7 || action == 10) {
                    return false;
                }
                return super.dispatchGenericMotionEvent(event);
            }
        }

        public class TargetCircle extends View {
            private Paint mLinePaint;
            private float mRadius;

            public TargetCircle(Context context, float radius) {
                super(context);
                init(radius);
            }

            private void init(float radius) {
                this.mLinePaint = new Paint();
                this.mLinePaint.setAntiAlias(true);
                this.mLinePaint.setColor(Handle.this.mCircleColor);
                this.mLinePaint.setStyle(Paint.Style.STROKE);
                this.mLinePaint.setStrokeWidth(3.0f);
                this.mRadius = radius - (this.mLinePaint.getStrokeWidth() * 4.0f);
            }

            public void setAlpha(int alpha) {
                if (this.mLinePaint != null) {
                    this.mLinePaint.setAlpha(alpha);
                }
            }

            public boolean isThresholdReached(float x, float y) {
                double ratio = getTargetProximityRatio(x, y);
                return ratio >= 0.95d;
            }

            public double getTargetProximityRatio(float x, float y) {
                int[] tmpPos = new int[2];
                getLocationOnScreen(tmpPos);
                float pivotX = tmpPos[0] + (getWidth() / 2);
                float pivotY = (tmpPos[1] + (getHeight() / 2)) - Handle.this.mTopOffset;
                double dx = Math.abs(x - pivotX);
                double dy = Math.abs(y - pivotY);
                double posLength = Math.sqrt((dx * dx) + (dy * dy));
                return posLength / this.mRadius;
            }

            @Override // android.view.View
            public void onDraw(Canvas canvas) {
                canvas.drawCircle(getWidth() / 2.0f, getHeight() / 2.0f, this.mRadius, this.mLinePaint);
            }

            @Override // android.view.View
            public boolean dispatchGenericMotionEvent(MotionEvent event) {
                IncomingLiveScreenShareCallWidget.this.logD("dispatchGenericMotionEvent : event = " + event);
                int action = event.getAction();
                if (action == 9 || action == 7 || action == 10) {
                    return false;
                }
                return super.dispatchGenericMotionEvent(event);
            }
        }
    }

    @Override // com.sds.coolots.common.view.DisposeInterface
    public void dispose() {
        logI("dispose()");
        this.mContext = null;
        this.mLeftHandle = null;
        this.mRightHandle = null;
        this.mOnTriggerListener = null;
        this.mDisplayMetrics = null;
        this.mVibrator = null;
        this.mHandlerDispose = true;
    }
}
