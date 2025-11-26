package com.coolots.chaton.call.view.layout.voice;

import android.app.Activity;
import android.content.Context;
import android.os.Message;
import android.os.Vibrator;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Chronometer;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.coolots.chaton.C0000R;
import com.coolots.chaton.CoolotsChatOn;
import com.coolots.chaton.buddy.BuddyManagerInterface;
import com.coolots.chaton.buddy.model.BuddyTable;
import com.coolots.chaton.call.model.CallDisplayUserInfo;
import com.coolots.chaton.call.model.ConferenceCallDisplayUserInfo;
import com.coolots.chaton.call.view.ChatOnCallActivity;
import com.coolots.chaton.common.controller.VAppPhoneManager;
import com.coolots.chaton.common.view.layout.InCallQuickPanel;
import com.sds.coolots.MainApplication;
import com.sds.coolots.call.model.CallState;
import com.sds.coolots.call.model.Destination;
import com.sds.coolots.common.util.Log;
import com.sds.coolots.common.view.DisposeInterface;

/* loaded from: classes.dex */
public class AcceptCallCoveredWidget extends RelativeLayout implements View.OnClickListener, DisposeInterface, View.OnTouchListener {
    public static final String CLASSNAME = "[AcceptCallCoveredWidget]";
    protected final long VIBRATE_LONG;
    protected final long VIBRATE_SHORT;
    private int mAcceptMoveImg;
    private int mAcceptTouchImg;
    protected RelativeLayout mClearCoverAccept_user_info;
    protected ImageView mClearCoverEndCall;
    protected ImageView mClearCoverEndCallCircle;
    protected TextView mClearCoverUserMessage;
    protected TextView mClearCoverUserName;
    protected FrameLayout mClearEndCallLayout;
    protected Destination mDestination;
    protected Chronometer mElapsedTime;
    protected boolean mIsConference;
    protected boolean mIsLeftHandle;
    protected boolean mIsRightHandle;
    protected boolean mIsTracking;
    protected ChatOnCallActivity mParentActivity;
    protected int mParentCallState;
    protected ImageView mRedArrowCover;
    private int mRejectMoveImg;
    private int mRejectTouchImg;
    protected ViewGroup mRootGroupView;
    protected int mStartState;
    private int mTouchId;
    protected Vibrator mVibrator;

    protected void logI(String message) {
        Log.m2963i(CLASSNAME + message);
    }

    public AcceptCallCoveredWidget(Context context) {
        super(context);
        this.VIBRATE_SHORT = 30L;
        this.VIBRATE_LONG = 40L;
        this.mIsLeftHandle = false;
        this.mIsRightHandle = false;
        this.mIsConference = false;
        this.mContext = context;
    }

    public AcceptCallCoveredWidget(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.VIBRATE_SHORT = 30L;
        this.VIBRATE_LONG = 40L;
        this.mIsLeftHandle = false;
        this.mIsRightHandle = false;
        this.mIsConference = false;
        this.mContext = context;
    }

    public AcceptCallCoveredWidget(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.VIBRATE_SHORT = 30L;
        this.VIBRATE_LONG = 40L;
        this.mIsLeftHandle = false;
        this.mIsRightHandle = false;
        this.mIsConference = false;
        this.mContext = context;
    }

    public AcceptCallCoveredWidget(Context context, ChatOnCallActivity parent, Destination destination, ViewGroup r) {
        this(context);
        this.mDestination = destination;
        this.mParentActivity = parent;
    }

    public void setChangeConferenceCall(boolean isChangeConference) {
        this.mIsConference = isChangeConference;
    }

    public boolean getChangeConferenceCall() {
        return this.mIsConference;
    }

    public void setUpdateDuringCallCoverBtn() {
    }

    public void setUpdateSpeakerBtnCover(boolean useSpeaker) {
    }

    public void setMember(Destination destination, CallDisplayUserInfo calluserInfo, int callstate) {
        this.mDestination = destination;
        setClearCoverActive(calluserInfo, callstate);
    }

    protected void setClearCoverActive(CallDisplayUserInfo calluserInfo, int callstate) {
        String groupName;
        switch (this.mDestination.getDestinationType()) {
            case 2:
                if (getChangeConferenceCall() && CallState.isConnected(this.mParentActivity.mCallStatusData.getCallState())) {
                    this.mClearCoverUserMessage.setText(C0000R.string.change_to_conference_start);
                    break;
                } else {
                    this.mClearCoverUserName.setText(calluserInfo.userName);
                    this.mClearCoverUserMessage.setText(C0000R.string.calling_button_receive);
                    break;
                }
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
                long groupID = this.mParentActivity.getGroupIDByUserInfo();
                ConferenceCallDisplayUserInfo userInfo = this.mParentActivity.getConferenceMemberName();
                if (this.mParentActivity.getConferenceWaitCount() > 0 && this.mParentActivity.getConferenceConnectCount() != 0 && this.mParentActivity.getConferenceConnectCount() < 2 && CallState.isConnected(this.mParentActivity.mCallStatusData.getCallState())) {
                    this.mClearCoverUserName.setText(userInfo.userName);
                    this.mClearCoverUserMessage.setText(C0000R.string.call_inviting_participants);
                    break;
                } else if (userInfo == null) {
                    this.mClearCoverUserMessage.setText(C0000R.string.call_info_voice_group_title);
                    this.mClearCoverUserName.setText(C0000R.string.wait_for_other_members_to_join);
                    break;
                } else {
                    if (groupID == 0) {
                        if (MainApplication.mPhoneManager.IsLinkagewithChatON() && (groupName = this.mParentActivity.getDestination().getGroupName()) != null && !groupName.isEmpty()) {
                            this.mClearCoverUserName.setText(groupName);
                        } else {
                            this.mClearCoverUserName.setText(userInfo.userName);
                        }
                    } else {
                        BuddyManagerInterface buddyManager = ((VAppPhoneManager) MainApplication.mPhoneManager).getChatOnContactManager();
                        this.mClearCoverUserName.setText(buddyManager.getGroupNameByGroupID(groupID));
                    }
                    StringBuffer userCnt = new StringBuffer(getResources().getString(C0000R.string.call_info_outgoing_video_group_title));
                    userCnt.append(" (" + (this.mDestination.getConferenceMemberCountWithMe() - this.mParentActivity.getConferenceWaitCount()) + ")");
                    this.mClearCoverUserMessage.setText(userCnt.toString());
                    break;
                }
                break;
        }
    }

    public void setMoveImage(int acceptResId, int rejectResId) {
        this.mAcceptMoveImg = acceptResId;
        this.mRejectMoveImg = rejectResId;
    }

    public void setTouchImage(int acceptResId, int rejectResId) {
        this.mAcceptTouchImg = acceptResId;
        this.mRejectTouchImg = rejectResId;
    }

    public void setTouchId(int touchId) {
        this.mTouchId = touchId;
    }

    public void setUpdateDuringCallCoverSpeakerBtn() {
    }

    public void setUpdateDuringCallCoverMuteBtn() {
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0041  */
    @Override // android.view.View.OnTouchListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onTouch(android.view.View r6, android.view.MotionEvent r7) {
        /*
            r5 = this;
            r4 = 1
            r3 = 0
            int r0 = r7.getAction()
            switch(r0) {
                case 0: goto La;
                case 1: goto L41;
                case 2: goto L2f;
                case 3: goto L41;
                case 4: goto L9;
                case 5: goto L9;
                case 6: goto L41;
                default: goto L9;
            }
        L9:
            return r4
        La:
            r1 = 30
            r5.vibrate(r1)
            r5.mIsTracking = r4
            int r1 = r6.getId()
            int r2 = r5.mTouchId
            if (r1 != r2) goto L2a
            android.widget.ImageView r1 = r5.mClearCoverEndCallCircle
            int r2 = r5.mRejectTouchImg
            r1.setBackgroundResource(r2)
            android.widget.ImageView r1 = r5.mClearCoverEndCallCircle
            r1.setVisibility(r3)
            r5.mIsLeftHandle = r3
            r5.mIsRightHandle = r4
            goto L9
        L2a:
            r5.mIsLeftHandle = r3
            r5.mIsRightHandle = r3
            goto L9
        L2f:
            boolean r1 = r5.mIsTracking
            if (r1 == 0) goto L41
            boolean r1 = r5.mIsLeftHandle
            if (r1 != 0) goto L9
            boolean r1 = r5.mIsRightHandle
            if (r1 == 0) goto L9
            android.widget.ImageView r1 = r5.mClearCoverEndCallCircle
            r5.processMoveEvent(r7, r1)
            goto L9
        L41:
            boolean r1 = r5.mIsTracking
            if (r1 == 0) goto L4b
            r5.mIsTracking = r3
            r5.mIsLeftHandle = r3
            r5.mIsRightHandle = r3
        L4b:
            android.widget.ImageView r1 = r5.mClearCoverEndCallCircle
            r2 = 4
            r1.setVisibility(r2)
            goto L9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.coolots.chaton.call.view.layout.voice.AcceptCallCoveredWidget.onTouch(android.view.View, android.view.MotionEvent):boolean");
    }

    public void processMoveEvent(MotionEvent motion, View view) {
        if (this.mIsLeftHandle || this.mIsRightHandle) {
            float x = motion.getX();
            float y = motion.getY();
            if (isThresholdReached(x, y, view) && !this.mIsLeftHandle && this.mIsRightHandle) {
                this.mClearCoverEndCallCircle.setBackgroundResource(this.mRejectMoveImg);
                endCall();
            }
        }
    }

    public void endCall() {
        Message msg = new Message();
        msg.what = 11;
        this.mParentActivity.sendHandlerMessage(msg, 0L);
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

    protected int getDispalymatrix() {
        DisplayMetrics mDisplayMetrics = new DisplayMetrics();
        ((Activity) this.mContext).getWindowManager().getDefaultDisplay().getMetrics(mDisplayMetrics);
        int topOffset = mDisplayMetrics.heightPixels - getMeasuredHeight();
        return topOffset;
    }

    public double getTargetProximityRatio(float x, float y, View view) {
        RelativeLayout.LayoutParams lp = (RelativeLayout.LayoutParams) this.mClearEndCallLayout.getLayoutParams();
        float pivotX = (view.getWidth() / 2) + lp.rightMargin;
        float pivotY = (view.getHeight() / 2) + lp.bottomMargin;
        double dx = Math.abs(x - pivotX);
        double dy = Math.abs(y - pivotY);
        double posLength = Math.sqrt((dx * dx) + (dy * dy));
        float radius = view.getWidth() / 2.0f;
        return posLength / radius;
    }

    public boolean isThresholdReached(float x, float y, View view) {
        double ratio = getTargetProximityRatio(x, y, view);
        return ratio >= 0.95d;
    }

    public void setDestination(Destination destination) {
        this.mDestination = destination;
    }

    protected synchronized void vibrate(long duration) {
        if (this.mVibrator == null) {
            this.mVibrator = (Vibrator) getContext().getSystemService("vibrator");
        }
        this.mVibrator.vibrate(duration);
    }

    public void setUIState(boolean isOutGoingCall, int callState, int destType) {
        if (CallState.isNotConnected(callState)) {
            this.mStartState = 1;
            this.mElapsedTime.setText(C0000R.string.call_info_outgoing_voice_call);
            return;
        }
        if (CallState.isConnected(callState)) {
            this.mElapsedTime.setVisibility(0);
            if (this.mParentActivity.getCallFunctionController().getCallSwitchingProcessing() == 1) {
                logI("CALL_SWITCH Backup Call Time Setting");
                setLayoutCallBaseTime(this.mParentActivity.getLayoutCallBaseTime(), callState);
                return;
            } else {
                if (this.mStartState == 1 || callState == 0 || callState == 2 || callState == 4 || callState == 5) {
                    setLayoutCallBaseTime(this.mParentActivity.getLayoutCallBaseTime(), callState);
                    return;
                }
                return;
            }
        }
        if (CallState.isDisconnected(callState)) {
            this.mElapsedTime.setVisibility(8);
            if (this.mStartState == 1) {
                this.mElapsedTime.setText(C0000R.string.clear_call);
            } else if (this.mStartState == 2) {
                this.mElapsedTime.stop();
                this.mStartState = 3;
            }
        }
    }

    public Long getLayoutCallBaseTime() {
        return Long.valueOf(this.mElapsedTime.getBase());
    }

    public void setLayoutCallBaseTime(Long baseTime, int callState) {
        if (!CallState.isNotConnected(callState)) {
            if (CallState.isDisconnected(callState)) {
                this.mStartState = 3;
                this.mElapsedTime.setBase(baseTime.longValue());
                ChatOnCallActivity.setPublicBaseTime(baseTime);
            } else if (callState == 0) {
                this.mElapsedTime.setBase(this.mParentActivity.getLayoutCallBaseTime().longValue());
                this.mElapsedTime.start();
            } else if (this.mStartState != 2 && this.mStartState != 4 && this.mStartState != 5) {
                this.mElapsedTime.setBase(baseTime.longValue());
                ChatOnCallActivity.setPublicBaseTime(baseTime);
                this.mElapsedTime.start();
                this.mStartState = 2;
            }
        }
        InCallQuickPanel.callBaseTime = baseTime.longValue();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View arg0) {
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
        if (this.mElapsedTime != null) {
            this.mElapsedTime = null;
        }
        if (this.mClearCoverEndCallCircle != null) {
            this.mClearCoverEndCallCircle = null;
        }
        this.mVibrator = null;
        removeAllViewsInLayout();
    }

    protected int getConfiguration() {
        return getResources().getConfiguration().orientation;
    }
}
