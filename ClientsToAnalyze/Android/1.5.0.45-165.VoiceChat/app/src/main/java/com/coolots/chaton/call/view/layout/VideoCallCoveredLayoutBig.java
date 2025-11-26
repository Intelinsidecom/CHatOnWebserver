package com.coolots.chaton.call.view.layout;

import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.Chronometer;
import android.widget.TextView;
import com.coolots.chaton.C0000R;
import com.coolots.chaton.CoolotsChatOn;
import com.coolots.chaton.buddy.BuddyManagerInterface;
import com.coolots.chaton.buddy.model.BuddyTable;
import com.coolots.chaton.call.model.CallDisplayUserInfo;
import com.coolots.chaton.call.model.ConferenceCallDisplayUserInfo;
import com.coolots.chaton.call.view.ChatOnCallActivity;
import com.coolots.chaton.common.controller.VAppPhoneManager;
import com.coolots.chaton.common.util.BuddyImageView;
import com.coolots.chaton.common.view.layout.InCallQuickPanel;
import com.sds.coolots.MainApplication;
import com.sds.coolots.call.model.CallState;
import com.sds.coolots.call.model.Destination;
import com.sds.coolots.common.util.Log;
import com.sds.coolots.common.view.DisposeInterface;
import java.io.IOException;

/* loaded from: classes.dex */
public class VideoCallCoveredLayoutBig extends AcceptCallCoveredLayout implements DisposeInterface {
    private static final String CLASSNAME = "[AcceptCallCovered]";
    private BuddyManagerInterface mBuddyManager;
    private BuddyImageView mCallerImage;
    private TextView mClearCoverUserMessage;
    private TextView mClearCoverUserName;
    private TextView mClearCoverVideoOpen;
    private ViewGroup mCoverdCallInfoLayout;
    private Destination mDestination;
    private Chronometer mElapsedTime;
    private boolean mIsConference;
    private ChatOnCallActivity mParentActivity;
    private int mStartState;

    private void logE(String message) {
        Log.m2958e(CLASSNAME + message);
    }

    private void logI(String message) {
        Log.m2963i(CLASSNAME + message);
    }

    public VideoCallCoveredLayoutBig(Context context) {
        super(context);
        this.mIsConference = false;
        this.mBuddyManager = ((VAppPhoneManager) MainApplication.mPhoneManager).getChatOnContactManager();
        this.mContext = context;
    }

    public VideoCallCoveredLayoutBig(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mIsConference = false;
        this.mBuddyManager = ((VAppPhoneManager) MainApplication.mPhoneManager).getChatOnContactManager();
        this.mContext = context;
    }

    public VideoCallCoveredLayoutBig(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.mIsConference = false;
        this.mBuddyManager = ((VAppPhoneManager) MainApplication.mPhoneManager).getChatOnContactManager();
        this.mContext = context;
    }

    @Override // com.coolots.chaton.call.view.layout.AcceptCallCoveredLayout
    public void initialize() {
        LayoutInflater inflater = LayoutInflater.from(this.mContext);
        inflater.inflate(C0000R.layout.video_call_corverd_layout_big, (ViewGroup) this, true);
        this.mClearCoverUserName = (TextView) findViewById(C0000R.id.caller_name);
        this.mClearCoverUserMessage = (TextView) findViewById(C0000R.id.caller_state_msg);
        this.mClearCoverVideoOpen = (TextView) findViewById(C0000R.id.open_cover_text);
        this.mElapsedTime = (Chronometer) findViewById(C0000R.id.durring_call_covered_elipse_time);
        this.mElapsedTime.bringToFront();
        this.mCoverdCallInfoLayout = (ViewGroup) findViewById(C0000R.id.coverd_call_info_layout);
        this.mCallerImage = (BuddyImageView) findViewById(C0000R.id.caller_img);
    }

    @Override // com.coolots.chaton.call.view.layout.AcceptCallCoveredLayout
    public void setClearCoverActive(CallDisplayUserInfo calluserInfo, String callKind, boolean isVoiceCall) {
        this.mClearCoverUserName.setText(calluserInfo.userName);
        this.mClearCoverUserMessage.setText(calluserInfo.userStateMsg);
    }

    private void setCallerImg() throws IOException {
        if (this.mDestination != null && this.mCallerImage.getDrawable() == null) {
            String buddyID = this.mDestination.getString();
            logI("setCallerImage buddyID = " + buddyID);
            if (this.mParentActivity.isConference()) {
                this.mCallerImage.setImageViewMode(4);
            } else {
                this.mCallerImage.setImageViewMode(0);
            }
            if (this.mBuddyManager.getKindOfBuddy(buddyID) == 0) {
                this.mCallerImage.loadImageForCover(buddyID, false);
            } else {
                this.mCallerImage.setBuddyGroupDefaultImageForCover(false);
            }
        }
    }

    @Override // com.coolots.chaton.call.view.layout.AcceptCallCoveredLayout
    public void setUIState(boolean isOutGoingCall, int callState, int destType, ChatOnCallActivity parent) throws IOException {
        this.mParentActivity = parent;
        setCallerImg();
        if (CallState.isNotConnected(callState)) {
            this.mStartState = 1;
            if (isOutGoingCall) {
                this.mClearCoverVideoOpen.setText(getResources().getString(C0000R.string.open_the_cover));
            } else {
                this.mClearCoverVideoOpen.setText(getResources().getString(C0000R.string.clear_cover_open));
            }
            this.mCoverdCallInfoLayout.setBackgroundColor(getResources().getColor(C0000R.color.chaton_covered_status_bar_calling_color));
            return;
        }
        if (CallState.isConnected(callState)) {
            this.mClearCoverVideoOpen.setText(getResources().getString(C0000R.string.open_the_cover));
            this.mCoverdCallInfoLayout.setBackgroundColor(getResources().getColor(C0000R.color.chaton_covered_status_bar_during_call_color));
            if (this.mParentActivity.getCallFunctionController().getCallSwitchingProcessing() == 2) {
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
        this.mElapsedTime.setVisibility(8);
    }

    @Override // com.coolots.chaton.call.view.layout.AcceptCallCoveredLayout
    public Long getLayoutCallBaseTime() {
        return Long.valueOf(this.mElapsedTime.getBase());
    }

    @Override // com.coolots.chaton.call.view.layout.AcceptCallCoveredLayout
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

    @Override // com.coolots.chaton.call.view.layout.AcceptCallCoveredLayout
    public void setMember(Destination destination, CallDisplayUserInfo calluserInfo) {
        this.mDestination = destination;
        setClearCoverActive(calluserInfo);
    }

    private void setClearCoverActive(CallDisplayUserInfo calluserInfo) {
        String groupName;
        switch (this.mDestination.getDestinationType()) {
            case 2:
                if (getChangeConferenceCall() && CallState.isConnected(this.mParentActivity.mCallStatusData.getCallState())) {
                    this.mClearCoverUserMessage.setText(C0000R.string.change_to_conference_start);
                    break;
                } else {
                    this.mClearCoverUserName.setText(calluserInfo.userName);
                    this.mClearCoverUserMessage.setText(calluserInfo.userStateMsg);
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

    @Override // com.coolots.chaton.call.view.layout.AcceptCallCoveredLayout
    public void setChangeConferenceCall(boolean isChangeConference) {
        this.mIsConference = isChangeConference;
    }

    @Override // com.coolots.chaton.call.view.layout.AcceptCallCoveredLayout
    public boolean getChangeConferenceCall() {
        return this.mIsConference;
    }

    @Override // com.coolots.chaton.call.view.layout.AcceptCallCoveredLayout
    public void sendAccessibilityEvent() {
        new Handler().postDelayed(new Runnable() { // from class: com.coolots.chaton.call.view.layout.VideoCallCoveredLayoutBig.1
            @Override // java.lang.Runnable
            public void run() {
                if (VideoCallCoveredLayoutBig.this.mClearCoverVideoOpen != null) {
                    VideoCallCoveredLayoutBig.this.mClearCoverVideoOpen.sendAccessibilityEvent(32768);
                }
            }
        }, 500L);
    }

    @Override // com.coolots.chaton.call.view.layout.AcceptCallCoveredLayout, com.sds.coolots.common.view.DisposeInterface
    public void dispose() {
        if (this.mParentActivity != null) {
            this.mParentActivity = null;
        }
        if (this.mContext != null) {
            this.mContext = null;
        }
        if (this.mDestination != null) {
            this.mDestination = null;
        }
        if (this.mClearCoverUserName != null) {
            this.mClearCoverUserName = null;
        }
        if (this.mClearCoverUserMessage != null) {
            this.mClearCoverUserMessage = null;
        }
        if (this.mClearCoverVideoOpen != null) {
            this.mClearCoverVideoOpen = null;
        }
        if (this.mElapsedTime != null) {
            this.mElapsedTime = null;
        }
        if (this.mCoverdCallInfoLayout != null) {
            removeAllViewsInLayout();
            this.mCoverdCallInfoLayout = null;
        }
        if (this.mCallerImage != null) {
            this.mCallerImage = null;
        }
        removeAllViewsInLayout();
    }
}
