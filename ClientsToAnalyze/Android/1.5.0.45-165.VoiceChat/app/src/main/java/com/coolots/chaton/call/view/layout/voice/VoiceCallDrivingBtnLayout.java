package com.coolots.chaton.call.view.layout.voice;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Message;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.coolots.chaton.C0000R;
import com.coolots.chaton.CoolotsChatOn;
import com.coolots.chaton.buddy.BuddyManagerInterface;
import com.coolots.chaton.buddy.model.BuddyTable;
import com.coolots.chaton.call.model.CallDisplayUserInfo;
import com.coolots.chaton.call.model.ConferenceCallDisplayUserInfo;
import com.coolots.chaton.call.view.ChatOnCallActivity;
import com.coolots.chaton.call.view.InviteViewMemberLayout;
import com.coolots.chaton.call.view.listener.SmallerHitTargetTouchListener;
import com.coolots.chaton.common.controller.VAppPhoneManager;
import com.coolots.chaton.common.util.ModelCreator;
import com.sds.coolots.MainApplication;
import com.sds.coolots.call.model.CallStatusData;
import com.sds.coolots.call.model.Destination;
import com.sds.coolots.common.util.Log;
import com.sds.coolots.common.view.DisposeInterface;
import java.util.Locale;

/* loaded from: classes.dex */
public class VoiceCallDrivingBtnLayout extends RelativeLayout implements View.OnClickListener, DisposeInterface {
    private static final String CLASSNAME = "[VoiceCallBtnLayout]";
    private static final int RESULT_INVITE_BUDDY_DONE = 2;
    private LinearLayout mAnswerBtn;
    private TextView mAnswerText;
    private BuddyManagerInterface mBuddyManager;
    private LinearLayout mCancelBtn;
    private Destination mDestinaion;
    private Destination mDestination;
    private int mDeviceType;
    private int mDisplayHeight;
    private int mDisplayWidth;
    private RelativeLayout mIcomingStatusBar;
    private InviteViewMemberLayout mInviteViewLayout;
    private boolean mIsActiveShareScreen;
    private boolean mIsOutgoingCall;
    private boolean mLiveShare;
    private ChatOnCallActivity mParentActivity;
    public TextView mPhoneNetworkStateText;
    private LinearLayout mRejectBtn;
    private TextView mRejectText;
    private ViewGroup mRootGroupView;
    private FrameLayout mTotallayout;
    private final SmallerHitTargetTouchListener mTouchListener;
    private TextView mUserName;
    private TextView mUserNumber;

    private void logI(String message) {
        Log.m2963i(CLASSNAME + message);
    }

    private void logE(String message) {
        Log.m2958e(CLASSNAME + message);
    }

    public VoiceCallDrivingBtnLayout(Context context, ViewGroup r) {
        super(context);
        this.mDeviceType = -1;
        this.mIsOutgoingCall = true;
        this.mTouchListener = new SmallerHitTargetTouchListener();
        this.mIsActiveShareScreen = false;
        this.mBuddyManager = ((VAppPhoneManager) MainApplication.mPhoneManager).getChatOnContactManager();
        this.mLiveShare = false;
        int childViewCount = r.getChildCount();
        LayoutInflater inflater = (LayoutInflater) context.getSystemService("layout_inflater");
        this.mRootGroupView = (ViewGroup) inflater.inflate(C0000R.layout.voice_call_driving_btn, r, true);
        this.mAnswerBtn = (LinearLayout) this.mRootGroupView.findViewById(C0000R.id.carkit_answer_frame_layout);
        this.mRejectBtn = (LinearLayout) this.mRootGroupView.findViewById(C0000R.id.carkit_reject_frame_layout);
        this.mCancelBtn = (LinearLayout) this.mRootGroupView.findViewById(C0000R.id.carkit_cancel_frame_layout);
        this.mAnswerBtn.setOnClickListener(this);
        this.mRejectBtn.setOnClickListener(this);
        this.mCancelBtn.setOnClickListener(this);
        CallStatusData callInfo = new CallStatusData();
        MainApplication.mPhoneManager.getPhoneStateMachine().updateCallInfo(callInfo);
        this.mUserName = (TextView) this.mRootGroupView.findViewById(C0000R.id.voice_in_call_membername);
        this.mUserNumber = (TextView) this.mRootGroupView.findViewById(C0000R.id.voice_in_call_membernumber);
        this.mPhoneNetworkStateText = (TextView) this.mRootGroupView.findViewById(C0000R.id.voice_in_call_state_text);
        this.mIcomingStatusBar = (RelativeLayout) this.mRootGroupView.findViewById(C0000R.id.voice_call_incoming_status_bar);
        this.mTotallayout = (FrameLayout) this.mRootGroupView.findViewById(C0000R.id.voice_in_call_all_layout);
        this.mInviteViewLayout = (InviteViewMemberLayout) this.mRootGroupView.findViewById(C0000R.id.voice_call_inviteview_member_incoming);
        this.mAnswerText = (TextView) this.mRootGroupView.findViewById(C0000R.id.carkit_answer_text);
        this.mRejectText = (TextView) this.mRootGroupView.findViewById(C0000R.id.carkit_reject_text);
        this.mRootGroupView.getChildAt(childViewCount).setTag(String.valueOf(getClass().toString()) + getConfiguration());
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean arg0, int arg1, int arg2, int arg3, int arg4) {
        logE("YKYU VoiceCallDrivingBtnLayout() => onLayout");
        int count = getChildCount();
        for (int i = 0; i < count; i++) {
            View child = getChildAt(i);
            if (child.getVisibility() != 8) {
                int childLeft = getPaddingLeft();
                int childTop = getPaddingTop();
                child.layout(childLeft, childTop, child.getMeasuredWidth() + childLeft, child.getMeasuredHeight() + childTop);
            }
        }
        logE("YKYU VoiceCallDrivingBtnLayout() => onLayout2");
    }

    public ViewGroup getLayoutreference() {
        if (this.mRootGroupView != null) {
            return this.mRootGroupView;
        }
        return null;
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        logE("YKYU VoiceCallDrivingBtnLayout() => onMeasure");
        int count = getChildCount();
        for (int i = 0; i < count; i++) {
            View child = getChildAt(i);
            if (child.getVisibility() != 8) {
                measureChild(child, widthMeasureSpec, heightMeasureSpec);
            }
        }
        int maxWidth = 0 + getPaddingLeft() + getPaddingRight();
        int maxHeight = 0 + getPaddingTop() + getPaddingBottom();
        Drawable drawable = getBackground();
        if (drawable != null) {
            maxHeight = Math.max(maxHeight, drawable.getMinimumHeight());
            maxWidth = Math.max(maxWidth, drawable.getMinimumWidth());
        }
        setMeasuredDimension(resolveSize(maxWidth, widthMeasureSpec), resolveSize(maxHeight, heightMeasureSpec));
        logE("YKYU VoiceCallDrivingBtnLayout() => onMeasure2");
    }

    public VoiceCallDrivingBtnLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mDeviceType = -1;
        this.mIsOutgoingCall = true;
        this.mTouchListener = new SmallerHitTargetTouchListener();
        this.mIsActiveShareScreen = false;
        this.mBuddyManager = ((VAppPhoneManager) MainApplication.mPhoneManager).getChatOnContactManager();
        this.mLiveShare = false;
        LayoutInflater inflater = LayoutInflater.from(context);
        inflater.inflate(C0000R.layout.voice_call_driving_btn, (ViewGroup) this, true);
    }

    public void setMember(Destination destination, boolean isOutGoingCall, CallDisplayUserInfo calluserInfo) {
        this.mDestination = destination;
        setMemberInfo(calluserInfo);
    }

    private void setMemberInfo(CallDisplayUserInfo calluserInfo) {
        String groupName;
        switch (this.mDestination.getDestinationType()) {
            case 2:
                this.mUserName.setText(calluserInfo.userName);
                this.mUserNumber.setText(C0000R.string.calling_button_receive);
                break;
            case 3:
                BuddyTable info = CoolotsChatOn.mPhoneManager.getChatOnContactManager().getVAppBuddyInfoTextDataByPhoneNumber(this.mDestination.getPhoneNo());
                if (info == null || info.getDisplayName() == null) {
                    this.mUserName.setText(this.mDestination.getPhoneNo());
                } else {
                    this.mUserName.setText(info.getDisplayName());
                }
                this.mInviteViewLayout.setVisibility(8);
                break;
            case 4:
            case 5:
                long groupID = this.mParentActivity.getGroupIDByUserInfo();
                ConferenceCallDisplayUserInfo userInfo = this.mParentActivity.getConferenceMemberName();
                if (userInfo == null) {
                    this.mUserNumber.setText(C0000R.string.call_info_voice_group_title);
                    this.mUserName.setText(C0000R.string.wait_for_other_members_to_join);
                    break;
                } else {
                    if (groupID == 0) {
                        if (MainApplication.mPhoneManager.IsLinkagewithChatON() && (groupName = this.mParentActivity.getDestination().getGroupName()) != null && !groupName.isEmpty()) {
                            this.mUserName.setText(groupName);
                        } else {
                            this.mUserName.setText(userInfo.userName);
                        }
                    } else {
                        this.mUserName.setText(this.mBuddyManager.getGroupNameByGroupID(groupID));
                    }
                    this.mUserNumber.setText("(" + (this.mDestination.getConferenceMemberCountWithMe() - this.mParentActivity.getConferenceWaitCount()) + ")");
                    this.mInviteViewLayout.setVisibility(0);
                    break;
                }
                break;
        }
    }

    public VoiceCallDrivingBtnLayout(Context context, AttributeSet attrs, boolean callFromChild) {
        super(context, attrs);
        this.mDeviceType = -1;
        this.mIsOutgoingCall = true;
        this.mTouchListener = new SmallerHitTargetTouchListener();
        this.mIsActiveShareScreen = false;
        this.mBuddyManager = ((VAppPhoneManager) MainApplication.mPhoneManager).getChatOnContactManager();
        this.mLiveShare = false;
    }

    protected void onFinishInflate(boolean callFromChild) {
        super.onFinishInflate();
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        this.mAnswerBtn = (LinearLayout) findViewById(C0000R.id.carkit_answer_frame_layout);
        this.mRejectBtn = (LinearLayout) findViewById(C0000R.id.carkit_reject_frame_layout);
        this.mCancelBtn = (LinearLayout) findViewById(C0000R.id.carkit_cancel_frame_layout);
        this.mAnswerBtn.setOnClickListener(this);
        this.mRejectBtn.setOnClickListener(this);
        this.mCancelBtn.setOnClickListener(this);
        CallStatusData callInfo = new CallStatusData();
        MainApplication.mPhoneManager.getPhoneStateMachine().updateCallInfo(callInfo);
        this.mUserName = (TextView) findViewById(C0000R.id.voice_in_call_membername);
        this.mUserNumber = (TextView) findViewById(C0000R.id.voice_in_call_membernumber);
        this.mPhoneNetworkStateText = (TextView) findViewById(C0000R.id.voice_in_call_state_text);
        this.mIcomingStatusBar = (RelativeLayout) findViewById(C0000R.id.voice_call_incoming_status_bar);
        this.mTotallayout = (FrameLayout) findViewById(C0000R.id.voice_in_call_all_layout);
        this.mInviteViewLayout = (InviteViewMemberLayout) findViewById(C0000R.id.voice_call_inviteview_member_incoming);
        this.mAnswerText = (TextView) findViewById(C0000R.id.carkit_answer_text);
        this.mRejectText = (TextView) findViewById(C0000R.id.carkit_reject_text);
    }

    private void setBtnTextAccordingToSVoice() throws Resources.NotFoundException {
        Locale systemLocale = MainApplication.mContext.getResources().getConfiguration().locale;
        Locale sVoiceLoc = this.mParentActivity.getSVoiceLocale();
        this.mParentActivity.changeLocale(sVoiceLoc);
        String strAnswer = getResources().getString(C0000R.string.button_to_answer);
        this.mAnswerText.setText(strAnswer);
        String strReject = getResources().getString(C0000R.string.call_swipe_left_message);
        this.mRejectText.setText(strReject);
        this.mParentActivity.changeLocale(systemLocale);
    }

    private void allBtnGone() {
        if (this.mAnswerBtn != null) {
            this.mAnswerBtn.setVisibility(8);
        }
        if (this.mRejectBtn != null) {
            this.mRejectBtn.setVisibility(8);
        }
        if (this.mCancelBtn != null) {
            this.mCancelBtn.setVisibility(8);
        }
    }

    public void setCallMode(boolean isOutgoingCall) {
        if (isOutgoingCall) {
            if (this.mAnswerBtn != null) {
                this.mAnswerBtn.setVisibility(8);
            }
            if (this.mRejectBtn != null) {
                this.mRejectBtn.setVisibility(8);
            }
            if (this.mCancelBtn != null) {
                this.mCancelBtn.setVisibility(0);
                return;
            }
            return;
        }
        if (this.mAnswerBtn != null) {
            this.mAnswerBtn.setVisibility(0);
        }
        if (this.mRejectBtn != null) {
            this.mRejectBtn.setVisibility(0);
        }
        if (this.mCancelBtn != null) {
            this.mCancelBtn.setVisibility(8);
        }
    }

    public void setParent(ChatOnCallActivity parent) {
        this.mParentActivity = parent;
        getScreenSize();
        this.mDeviceType = ModelCreator.checkDeviceModel(this.mDisplayWidth, this.mDisplayHeight);
        setBtnTextAccordingToSVoice();
    }

    private void getScreenSize() {
        this.mDisplayWidth = this.mParentActivity.getWindowManager().getDefaultDisplay().getWidth();
        this.mDisplayHeight = this.mParentActivity.getWindowManager().getDefaultDisplay().getHeight();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        logI("onClick()");
        if (this.mParentActivity != null) {
            if (this.mParentActivity.isChangeToConference()) {
                Toast.makeText(this.mParentActivity, getResources().getString(C0000R.string.change_to_conference_wait), 0).show();
                logE("WAIT: change to conference");
                return;
            }
            if (view.getId() == this.mAnswerBtn.getId()) {
                if (this.mParentActivity != null) {
                    Log.m2958e("YKYU AnswerBtn receiveCall()");
                    this.mParentActivity.receiveCall();
                    setVisibility(8);
                }
            } else if (view.getId() == this.mRejectBtn.getId()) {
                if (this.mParentActivity != null) {
                    Log.m2958e("YKYU mRejectBtn denyCall()");
                    this.mParentActivity.denyCall();
                    setVisibility(8);
                }
            } else if (view.getId() == this.mCancelBtn.getId()) {
                Log.m2958e("YKYU mCancelBtn CancelCall()");
                endCall();
                setVisibility(8);
            }
            allBtnGone();
            dispose();
        }
    }

    public void endCall() {
        Message msg = new Message();
        msg.what = 11;
        this.mParentActivity.sendHandlerMessage(msg, 0L);
    }

    @Override // com.sds.coolots.common.view.DisposeInterface
    public void dispose() {
        if (this.mParentActivity != null) {
            this.mParentActivity = null;
        }
        if (this.mAnswerBtn != null) {
            this.mAnswerBtn = null;
        }
        if (this.mRejectBtn != null) {
            this.mRejectBtn = null;
        }
        if (this.mCancelBtn != null) {
            this.mCancelBtn = null;
        }
        if (this.mDestination != null) {
            this.mDestination = null;
        }
        if (this.mUserName != null) {
            this.mUserName = null;
        }
        if (this.mUserNumber != null) {
            this.mUserNumber = null;
        }
        if (this.mPhoneNetworkStateText != null) {
            this.mPhoneNetworkStateText = null;
        }
        if (this.mBuddyManager != null) {
            this.mBuddyManager = null;
        }
        removeAllViewsInLayout();
    }

    private int getConfiguration() {
        return getResources().getConfiguration().orientation;
    }
}
