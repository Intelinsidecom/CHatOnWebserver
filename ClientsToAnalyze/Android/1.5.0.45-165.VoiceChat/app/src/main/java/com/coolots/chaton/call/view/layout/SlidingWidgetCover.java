package com.coolots.chaton.call.view.layout;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Vibrator;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.coolots.chaton.C0000R;
import com.coolots.chaton.CoolotsChatOn;
import com.coolots.chaton.buddy.model.BuddyTable;
import com.coolots.chaton.call.model.CallDisplayUserInfo;
import com.coolots.chaton.call.model.ConferenceCallDisplayUserInfo;
import com.coolots.chaton.call.view.ChatOnCallActivity;
import com.sds.coolots.MainApplication;
import com.sds.coolots.call.model.Destination;
import com.sds.coolots.common.util.Log;
import com.sds.coolots.common.view.DisposeInterface;

/* loaded from: classes.dex */
public abstract class SlidingWidgetCover extends RelativeLayout implements View.OnClickListener, DisposeInterface, View.OnTouchListener {
    public static final String CLASSNAME = "[SlidingWidgetCover]";
    public final long VIBRATE_SHORT;
    private int mAcceptMoveImg;
    private int mAcceptTouchImg;
    protected FrameLayout mClearAcceptLayout;
    protected ImageView mClearCoverAccept;
    protected ImageView mClearCoverAcceptCircle;
    protected TextView mClearCoverCallKind;
    protected ImageView mClearCoverReject;
    protected ImageView mClearCoverRejectCircle;
    protected LinearLayout mClearCoverTextLayout;
    protected TextView mClearCoverUserMessage;
    protected TextView mClearCoverUserName;
    protected FrameLayout mClearRejectLayout;
    protected Destination mDestination;
    protected ImageView mGreenArrowCover;
    protected boolean mIsLeftHandle;
    protected boolean mIsRightHandle;
    protected boolean mIsThresholdReached;
    protected boolean mIsTracking;
    protected ChatOnCallActivity mParentActivity;
    protected ImageView mRedArrowCover;
    private int mRejectMoveImg;
    private int mRejectTouchImg;
    protected ViewGroup mRootGroupView;
    private Vibrator mVibrator;

    private void logI(String message) {
        Log.m2963i(CLASSNAME + message);
    }

    public SlidingWidgetCover(Context context, ChatOnCallActivity parent, Destination destination, ViewGroup r) {
        this(context);
        logI("IncomingSlidingWidgetCoverBig()");
        this.mDestination = destination;
        this.mParentActivity = parent;
        this.mIsThresholdReached = false;
    }

    public SlidingWidgetCover(Context context) {
        super(context);
        this.VIBRATE_SHORT = 30L;
        this.mIsLeftHandle = false;
        this.mIsRightHandle = false;
        this.mIsThresholdReached = false;
        this.mContext = context;
    }

    public SlidingWidgetCover(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.VIBRATE_SHORT = 30L;
        this.mIsLeftHandle = false;
        this.mIsRightHandle = false;
        this.mIsThresholdReached = false;
        this.mContext = context;
    }

    public SlidingWidgetCover(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.VIBRATE_SHORT = 30L;
        this.mIsLeftHandle = false;
        this.mIsRightHandle = false;
        this.mIsThresholdReached = false;
        this.mContext = context;
    }

    public void setMoveImage(int acceptResId, int rejectResId) {
        this.mAcceptMoveImg = acceptResId;
        this.mRejectMoveImg = rejectResId;
    }

    public void setTouchImage(int acceptResId, int rejectResId) {
        this.mAcceptTouchImg = acceptResId;
        this.mRejectTouchImg = rejectResId;
    }

    public void setClearCoverActive(CallDisplayUserInfo calluserInfo, String callKind) {
        logI("setClearCoverActive()");
        switch (this.mDestination.getDestinationType()) {
            case 2:
                this.mClearCoverUserName.setText(calluserInfo.userName);
                break;
            case 3:
                BuddyTable info = CoolotsChatOn.mPhoneManager.getChatOnContactManager().getVAppBuddyInfoTextDataByPhoneNumber(this.mDestination.getPhoneNo());
                if (info == null || info.getDisplayName() == null) {
                    this.mClearCoverUserName.setText(this.mDestination.getPhoneNo());
                    break;
                } else {
                    this.mClearCoverUserName.setText(info.getDisplayName());
                    break;
                }
                break;
            case 4:
            case 5:
                ConferenceCallDisplayUserInfo userInfo = this.mParentActivity.getConferenceMemberName();
                if (userInfo == null) {
                    this.mClearCoverUserName.setText(C0000R.string.call_info_voice_group_title);
                    break;
                } else if (MainApplication.mPhoneManager.IsLinkagewithChatON()) {
                    String groupName = this.mParentActivity.getDestination().getGroupName();
                    if (groupName != null && !groupName.isEmpty()) {
                        this.mClearCoverUserName.setText(groupName);
                        break;
                    } else {
                        this.mClearCoverUserName.setText(userInfo.userName);
                        break;
                    }
                }
                break;
        }
        this.mClearCoverCallKind.setText(callKind);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0080  */
    @Override // android.view.View.OnTouchListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onTouch(android.view.View r7, android.view.MotionEvent r8) {
        /*
            r6 = this;
            r5 = 4
            r4 = 1
            r3 = 0
            int r0 = r8.getAction()
            switch(r0) {
                case 0: goto Lb;
                case 1: goto L80;
                case 2: goto L60;
                case 3: goto L80;
                case 4: goto La;
                case 5: goto La;
                case 6: goto L80;
                default: goto La;
            }
        La:
            return r4
        Lb:
            r1 = 30
            r6.vibrate(r1)
            r6.mIsTracking = r4
            int r1 = r7.getId()
            android.widget.ImageView r2 = r6.mClearCoverAccept
            int r2 = r2.getId()
            if (r1 != r2) goto L34
            android.widget.ImageView r1 = r6.mClearCoverAcceptCircle
            int r2 = r6.mAcceptTouchImg
            r1.setBackgroundResource(r2)
            android.widget.ImageView r1 = r6.mClearCoverAcceptCircle
            r1.setVisibility(r3)
            android.widget.ImageView r1 = r6.mClearCoverRejectCircle
            r1.setVisibility(r5)
            r6.mIsLeftHandle = r4
            r6.mIsRightHandle = r3
            goto La
        L34:
            int r1 = r7.getId()
            android.widget.ImageView r2 = r6.mClearCoverReject
            int r2 = r2.getId()
            if (r1 != r2) goto L5b
            java.lang.String r1 = "onTouch clear_reject_call ACTION_DOWN"
            r6.logI(r1)
            android.widget.ImageView r1 = r6.mClearCoverRejectCircle
            int r2 = r6.mRejectTouchImg
            r1.setBackgroundResource(r2)
            android.widget.ImageView r1 = r6.mClearCoverRejectCircle
            r1.setVisibility(r3)
            android.widget.ImageView r1 = r6.mClearCoverAcceptCircle
            r1.setVisibility(r5)
            r6.mIsLeftHandle = r3
            r6.mIsRightHandle = r4
            goto La
        L5b:
            r6.mIsLeftHandle = r3
            r6.mIsRightHandle = r3
            goto La
        L60:
            boolean r1 = r6.mIsTracking
            if (r1 == 0) goto L80
            boolean r1 = r6.mIsLeftHandle
            if (r1 == 0) goto L72
            boolean r1 = r6.mIsRightHandle
            if (r1 != 0) goto L72
            android.widget.ImageView r1 = r6.mClearCoverAcceptCircle
            r6.processMoveEvent(r8, r1)
            goto La
        L72:
            boolean r1 = r6.mIsLeftHandle
            if (r1 != 0) goto La
            boolean r1 = r6.mIsRightHandle
            if (r1 == 0) goto La
            android.widget.ImageView r1 = r6.mClearCoverRejectCircle
            r6.processMoveEvent(r8, r1)
            goto La
        L80:
            boolean r1 = r6.mIsTracking
            if (r1 == 0) goto L8a
            r6.mIsTracking = r3
            r6.mIsLeftHandle = r3
            r6.mIsRightHandle = r3
        L8a:
            android.widget.ImageView r1 = r6.mClearCoverRejectCircle
            r1.setVisibility(r5)
            android.widget.ImageView r1 = r6.mClearCoverAcceptCircle
            r1.setVisibility(r5)
            goto La
        */
        throw new UnsupportedOperationException("Method not decompiled: com.coolots.chaton.call.view.layout.SlidingWidgetCover.onTouch(android.view.View, android.view.MotionEvent):boolean");
    }

    public void processMoveEvent(MotionEvent motion, View view) {
        if (this.mIsLeftHandle || this.mIsRightHandle) {
            float x = motion.getX();
            float y = motion.getY();
            if (!this.mIsThresholdReached && isThresholdReached(x, y, view)) {
                this.mIsThresholdReached = true;
                if (this.mIsLeftHandle && !this.mIsRightHandle) {
                    logI("onTouch clear_accept_call ACTION_MOVE");
                    this.mClearCoverAcceptCircle.setBackgroundResource(this.mAcceptMoveImg);
                    this.mParentActivity.receiveCall();
                } else if (!this.mIsLeftHandle && this.mIsRightHandle) {
                    logI("onTouch clear_reject_call ACTION_MOVE");
                    this.mClearCoverRejectCircle.setBackgroundResource(this.mRejectMoveImg);
                    this.mParentActivity.denyCall();
                }
            }
        }
    }

    public boolean isInCircle(float x, float y, View view) {
        float radius = view.getWidth() / 2.0f;
        int[] tmpPos = new int[2];
        int topOffset = getDispalymatrix();
        getLocationOnScreen(tmpPos);
        float pivotX = tmpPos[0] + (view.getWidth() / 2);
        float pivotY = (tmpPos[1] + (view.getHeight() / 2)) - topOffset;
        double dx = Math.abs(x - pivotX);
        double dy = Math.abs(y - pivotY);
        double posLength = Math.sqrt((dx * dx) + (dy * dy));
        double ratio = posLength / radius;
        logI("isInCircle - x : " + x + " y : " + y + " ratio : " + ratio);
        return ratio < 1.3d;
    }

    private int getDispalymatrix() {
        DisplayMetrics mDisplayMetrics = new DisplayMetrics();
        ((Activity) this.mContext).getWindowManager().getDefaultDisplay().getMetrics(mDisplayMetrics);
        int topOffset = mDisplayMetrics.heightPixels - getMeasuredHeight();
        return topOffset;
    }

    public double getTargetProximityRatio(float x, float y, View view) {
        RelativeLayout.LayoutParams lp;
        float pivotX;
        if (view.getId() == this.mClearCoverAcceptCircle.getId()) {
            lp = (RelativeLayout.LayoutParams) this.mClearAcceptLayout.getLayoutParams();
            pivotX = (view.getWidth() / 2) + lp.leftMargin;
        } else {
            lp = (RelativeLayout.LayoutParams) this.mClearRejectLayout.getLayoutParams();
            pivotX = (view.getWidth() / 2) + lp.rightMargin;
        }
        float pivotY = (view.getHeight() / 2) + lp.bottomMargin;
        double dx = Math.abs(x - pivotX);
        double dy = Math.abs(y - pivotY);
        double posLength = Math.sqrt((dx * dx) + (dy * dy));
        float radius = view.getWidth() / 2.0f;
        return posLength / radius;
    }

    public boolean isThresholdReached(float x, float y, View view) {
        double ratio = getTargetProximityRatio(x, y, view);
        logI("isThresholdReached() ratio = " + ratio);
        return ratio >= 0.95d;
    }

    public void setDestination(Destination destination) {
        this.mDestination = destination;
    }

    public synchronized void vibrate(long duration) {
        if (this.mVibrator == null) {
            this.mVibrator = (Vibrator) getContext().getSystemService("vibrator");
        }
        this.mVibrator.vibrate(duration);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View arg0) {
    }

    public int getConfiguration() {
        return getResources().getConfiguration().orientation;
    }

    public void sendAccessibilityEvent() {
        new Handler().postDelayed(new Runnable() { // from class: com.coolots.chaton.call.view.layout.SlidingWidgetCover.1
            @Override // java.lang.Runnable
            public void run() {
                if (SlidingWidgetCover.this.mClearCoverTextLayout != null) {
                    SlidingWidgetCover.this.mClearCoverTextLayout.sendAccessibilityEvent(32768);
                }
            }
        }, 500L);
    }

    public void dispose() {
        if (this.mParentActivity != null) {
            this.mParentActivity = null;
        }
        if (this.mContext != null) {
            this.mContext = null;
        }
        if (this.mClearCoverUserName != null) {
            this.mClearCoverUserName = null;
        }
        if (this.mClearCoverUserMessage != null) {
            this.mClearCoverUserMessage = null;
        }
        if (this.mClearCoverCallKind != null) {
            this.mClearCoverCallKind = null;
        }
        if (this.mClearCoverTextLayout != null) {
            this.mClearCoverTextLayout = null;
        }
        if (this.mClearCoverRejectCircle != null) {
            this.mClearCoverRejectCircle = null;
        }
        if (this.mClearCoverAcceptCircle != null) {
            this.mClearCoverAcceptCircle = null;
        }
        this.mVibrator = null;
        removeAllViewsInLayout();
    }
}
