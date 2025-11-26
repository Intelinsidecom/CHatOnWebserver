package com.coolots.chaton.call.view.layout.voice;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.coolots.chaton.C0000R;
import com.coolots.chaton.CoolotsChatOn;
import com.coolots.chaton.buddy.BuddyManagerInterface;
import com.coolots.chaton.buddy.model.BuddyTable;
import com.coolots.chaton.call.model.CallDisplayUserInfo;
import com.coolots.chaton.call.model.ConferenceCallDisplayUserInfo;
import com.coolots.chaton.call.view.VoiceCallActivity;
import com.coolots.chaton.calllog.util.CallLogStringUtil;
import com.coolots.chaton.common.controller.VAppPhoneManager;
import com.coolots.chaton.common.util.BuddyImageView;
import com.sds.coolots.MainApplication;
import com.sds.coolots.call.model.Destination;
import com.sds.coolots.common.util.Log;
import com.sds.coolots.common.view.DisposeInterface;

/* loaded from: classes.dex */
public class LiveScreenShareIncomingLayout extends FrameLayout implements DisposeInterface {
    private static final String CLASSNAME = "[VoiceCallIncomingLayout]";
    private BuddyManagerInterface mBuddyManager;
    private Destination mDestination;
    private TextView mMemberCount;
    private VoiceCallActivity mParentActivity;
    public TextView mPhoneNetworkStateText;
    private BuddyImageView mUserImage;
    private TextView mUserName;
    private TextView mUserNumber;

    private void logE(String message) {
        Log.m2958e(CLASSNAME + message);
    }

    private void logI(String message) {
        Log.m2963i(CLASSNAME + message);
    }

    public LiveScreenShareIncomingLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mBuddyManager = ((VAppPhoneManager) MainApplication.mPhoneManager).getChatOnContactManager();
        LayoutInflater inflater = LayoutInflater.from(context);
        inflater.inflate(C0000R.layout.live_screen_share_incoming, (ViewGroup) this, true);
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        this.mUserName = (TextView) findViewById(C0000R.id.voice_in_call_membername);
        this.mMemberCount = (TextView) findViewById(C0000R.id.conf_member_count);
        this.mUserImage = (BuddyImageView) findViewById(C0000R.id.voice_in_call_memberimage);
        this.mUserNumber = (TextView) findViewById(C0000R.id.voice_in_call_membernumber);
        this.mPhoneNetworkStateText = (TextView) findViewById(C0000R.id.voice_in_call_state_text);
    }

    public void setMember(Destination destination, boolean isOutGoingCall, CallDisplayUserInfo calluserInfo) {
        this.mDestination = destination;
        setMemberInfo(calluserInfo);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent arg0) {
        return true;
    }

    public void setParent(VoiceCallActivity parent) {
        this.mParentActivity = parent;
    }

    private void setMemberInfo(CallDisplayUserInfo calluserInfo) {
        switch (this.mDestination.getDestinationType()) {
            case 2:
                this.mUserName.setText(calluserInfo.userName);
                this.mUserNumber.setText(CallLogStringUtil.getInstance().getSingleCallUserMessage(calluserInfo.userID, getResources().getString(C0000R.string.unsaved_buddy)));
                break;
            case 3:
                BuddyTable info = CoolotsChatOn.mPhoneManager.getChatOnContactManager().getVAppBuddyInfoTextDataByPhoneNumber(this.mDestination.getPhoneNo());
                if (info == null || info.getDisplayName() == null) {
                    this.mUserName.setText(this.mDestination.getPhoneNo());
                    break;
                } else {
                    this.mUserName.setText(info.getDisplayName());
                    break;
                }
                break;
            case 4:
                BuddyManagerInterface buddyManager = ((VAppPhoneManager) MainApplication.mPhoneManager).getChatOnContactManager();
                long groupID = this.mParentActivity.getGroupIDByUserInfo();
                ConferenceCallDisplayUserInfo userInfo = this.mParentActivity.getConferenceMemberName();
                if (userInfo == null) {
                    this.mMemberCount.setVisibility(8);
                    this.mUserNumber.setText(C0000R.string.call_info_voice_group_title);
                    this.mUserName.setText(C0000R.string.wait_for_other_members_to_join);
                    break;
                } else {
                    if (groupID == 0) {
                        this.mUserName.setText(userInfo.userName);
                    } else {
                        String groupName = buddyManager.getGroupNameByGroupID(groupID);
                        this.mUserName.setText(groupName);
                    }
                    this.mMemberCount.setVisibility(0);
                    this.mMemberCount.setText("(" + userInfo.userCount + ")");
                    this.mUserNumber.setText(C0000R.string.call_info_voice_group_title);
                    this.mUserImage.setVisibility(8);
                    break;
                }
        }
    }

    @Override // com.sds.coolots.common.view.DisposeInterface
    public void dispose() {
        if (this.mDestination != null) {
            this.mDestination = null;
        }
        if (this.mUserName != null) {
            this.mUserName = null;
        }
        if (this.mUserNumber != null) {
            this.mUserNumber = null;
        }
        if (this.mUserImage != null) {
            this.mUserImage.dispose();
            this.mUserImage = null;
        }
        if (this.mPhoneNetworkStateText != null) {
            this.mPhoneNetworkStateText = null;
        }
        if (this.mBuddyManager != null) {
            this.mBuddyManager = null;
        }
        removeAllViewsInLayout();
    }

    public void setCallerImage(long userno) throws Throwable {
        this.mUserImage.setImageViewMode(0);
        this.mUserImage.loadImage(userno);
    }

    public void removeImage() {
        this.mUserImage.setImageResource(C0000R.drawable.call_image);
    }
}
