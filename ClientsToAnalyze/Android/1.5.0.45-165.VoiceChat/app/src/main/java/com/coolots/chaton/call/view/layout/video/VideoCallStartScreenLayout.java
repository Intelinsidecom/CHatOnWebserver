package com.coolots.chaton.call.view.layout.video;

import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.coolots.chaton.C0000R;
import com.coolots.chaton.buddy.BuddyManagerInterface;
import com.coolots.chaton.call.model.CallDisplayUserInfo;
import com.coolots.chaton.call.model.ConferenceCallDisplayUserInfo;
import com.coolots.chaton.call.view.ChatOnCallActivity;
import com.coolots.chaton.call.view.InviteViewMemberLayout;
import com.coolots.chaton.common.controller.VAppPhoneManager;
import com.coolots.chaton.common.util.ContentDescriptionStringMaker;
import com.sds.coolots.MainApplication;
import com.sds.coolots.call.model.Destination;
import com.sds.coolots.common.util.Log;
import com.sds.coolots.common.view.DisposeInterface;

/* loaded from: classes.dex */
public class VideoCallStartScreenLayout extends FrameLayout implements DisposeInterface {
    private static final String CLASSNAME = "[VideoCallStartScreenLayout]";
    private ViewGroup mCallHideMeBtn;
    private ImageView mCallHideMeImg;
    private TextView mCallHideMeText;
    private CallDisplayUserInfo mCalluserInfo;
    private Destination mDestination;
    private InviteViewMemberLayout mInviteViewLayout;
    private ChatOnCallActivity mParentActivity;
    private TextView mVideoCallMemberInfo;
    private TextView mVideoCallMemberName;
    private TextView mVideoCallStatusMsg;

    private void logE(String message) {
        Log.m2958e(CLASSNAME + message);
    }

    private void logI(String message) {
        Log.m2963i(CLASSNAME + message);
    }

    public VideoCallStartScreenLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater inflater = LayoutInflater.from(context);
        inflater.inflate(C0000R.layout.video_call_start_ui, (ViewGroup) this, true);
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        this.mVideoCallMemberName = (TextView) findViewById(C0000R.id.video_call_member_name);
        this.mVideoCallMemberName.setSelected(true);
        this.mVideoCallMemberInfo = (TextView) findViewById(C0000R.id.video_call_member_info);
        this.mVideoCallStatusMsg = (TextView) findViewById(C0000R.id.video_call_status_msg);
        this.mCallHideMeBtn = (ViewGroup) findViewById(C0000R.id.hide_me_btn);
        this.mCallHideMeText = (TextView) findViewById(C0000R.id.hide_me_txt);
        this.mCallHideMeImg = (ImageView) findViewById(C0000R.id.hide_me_img);
        this.mCallHideMeBtn.setOnClickListener(new View.OnClickListener() { // from class: com.coolots.chaton.call.view.layout.video.VideoCallStartScreenLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View arg0) {
                VideoCallStartScreenLayout.this.mParentActivity.setAlterImage();
            }
        });
        this.mInviteViewLayout = (InviteViewMemberLayout) findViewById(C0000R.id.video_call_inviteview_member_incoming);
    }

    public void initLayout(Destination destination, CallDisplayUserInfo calluserInfo, ChatOnCallActivity parent) {
        this.mParentActivity = parent;
        this.mDestination = destination;
        this.mCalluserInfo = calluserInfo;
        initView();
    }

    private void initView() {
        String groupName;
        BuddyManagerInterface buddyManager = ((VAppPhoneManager) MainApplication.mPhoneManager).getChatOnContactManager();
        if (this.mParentActivity.isConference()) {
            if (MainApplication.mPhoneManager.IsLinkagewithChatON()) {
                groupName = this.mParentActivity.getDestination().getGroupName();
            } else {
                long groupID = this.mParentActivity.getGroupIDByUserInfo();
                groupName = buddyManager.getGroupNameByGroupID(groupID);
            }
            ConferenceCallDisplayUserInfo userInfo = this.mParentActivity.getConferenceMemberName();
            if (userInfo == null) {
                this.mVideoCallMemberInfo.setText(C0000R.string.call_info_voice_group_title);
                this.mVideoCallMemberName.setText(C0000R.string.wait_for_other_members_to_join);
            } else if (groupName == null || groupName.isEmpty()) {
                this.mVideoCallMemberName.setText(userInfo.userName);
            } else {
                this.mVideoCallMemberName.setText(groupName);
            }
            StringBuffer userCnt = new StringBuffer(getResources().getString(C0000R.string.call_info_outgoing_video_group_title));
            userCnt.append(" (" + (this.mDestination.getConferenceMemberCountWithMe() - this.mParentActivity.getConferenceWaitCount()) + ")");
            this.mVideoCallMemberInfo.setText(userCnt.toString());
            this.mInviteViewLayout.setVisibility(0);
        } else {
            this.mVideoCallMemberName.setText(this.mCalluserInfo.userName);
            this.mVideoCallMemberInfo.setText(C0000R.string.calling_button_receive);
            this.mInviteViewLayout.setVisibility(8);
        }
        this.mVideoCallStatusMsg.setText(getResources().getString(C0000R.string.call_info_incoming_video_call));
        this.mVideoCallMemberName.setSelected(true);
    }

    @Override // com.sds.coolots.common.view.DisposeInterface
    public void dispose() {
        if (this.mVideoCallMemberName != null) {
            this.mVideoCallMemberName = null;
        }
        if (this.mVideoCallMemberInfo != null) {
            this.mVideoCallMemberInfo = null;
        }
        if (this.mVideoCallStatusMsg != null) {
            this.mVideoCallStatusMsg = null;
        }
        if (this.mInviteViewLayout != null) {
            this.mInviteViewLayout.removeAllViews();
            this.mInviteViewLayout = null;
        }
        if (this.mCallHideMeText != null) {
            this.mCallHideMeText = null;
        }
        if (this.mCallHideMeImg != null) {
            this.mCallHideMeImg = null;
        }
        if (this.mCallHideMeBtn != null) {
            this.mCallHideMeBtn.removeAllViews();
            this.mCallHideMeBtn = null;
        }
        removeAllViewsInLayout();
    }

    public void setHideMeBtn(boolean hideMe) {
        if (hideMe) {
            this.mCallHideMeText.setText(getResources().getString(C0000R.string.call_menu_show_me));
            this.mCallHideMeImg.setBackgroundResource(C0000R.drawable.action_bar_icon_show_me);
            this.mCallHideMeBtn.setContentDescription(ContentDescriptionStringMaker.makeString(C0000R.string.call_menu_show_me, C0000R.string.talk_back_button));
        } else {
            this.mCallHideMeText.setText(getResources().getString(C0000R.string.call_menu_hide_me));
            this.mCallHideMeImg.setBackgroundResource(C0000R.drawable.action_bar_icon_hide_me);
            this.mCallHideMeBtn.setContentDescription(ContentDescriptionStringMaker.makeString(C0000R.string.call_menu_hide_me, C0000R.string.talk_back_button));
        }
    }

    public void sendAccessibilityEvent() {
        new Handler().postDelayed(new Runnable() { // from class: com.coolots.chaton.call.view.layout.video.VideoCallStartScreenLayout.2
            @Override // java.lang.Runnable
            public void run() {
                if (VideoCallStartScreenLayout.this.mVideoCallMemberName != null) {
                    VideoCallStartScreenLayout.this.mVideoCallMemberName.sendAccessibilityEvent(32768);
                }
            }
        }, 500L);
    }
}
