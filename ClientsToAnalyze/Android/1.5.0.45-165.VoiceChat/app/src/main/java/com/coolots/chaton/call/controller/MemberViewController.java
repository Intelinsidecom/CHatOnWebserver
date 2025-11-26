package com.coolots.chaton.call.controller;

import android.os.Handler;
import android.os.Message;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.coolots.chaton.C0000R;
import com.coolots.chaton.call.model.CallUserAddedInfo;
import com.coolots.chaton.call.view.ChatOnCallActivity;
import com.coolots.chaton.call.view.layout.video.VideoCallStatusBar;
import com.coolots.chaton.call.view.layout.voice.VoiceCallMemberLayout;
import com.sds.coolots.call.model.Destination;
import com.sds.coolots.common.util.Log;
import com.sds.coolots.common.view.DisposeInterface;

/* loaded from: classes.dex */
public class MemberViewController implements DisposeInterface {
    private static final String CLASSNAME = "[MemberViewController]";
    public static final int MEMBERVIEW_REMOVE_NOTI_TO_SERVER = 10;
    private ChatOnCallActivity mActivity;
    IMemberViewController mIMemberViewController;
    protected ListView mMemberListView;
    protected MemberViewAdapter mMemberViewAdaptor;
    protected ViewGroup mMemberViewLayout;
    private VideoCallStatusBar mVideoCallStatusBar;
    private VoiceCallMemberLayout mVoiceCallStatusBar;
    protected boolean mMemberViewActive = false;
    private Handler mMemberViewHandler = null;

    /* JADX INFO: Access modifiers changed from: private */
    public void logI(String message) {
        Log.m2963i(CLASSNAME + message);
    }

    private void logE(String message) {
        Log.m2963i(CLASSNAME + message);
    }

    public MemberViewController(ChatOnCallActivity activity, IMemberViewController memberViewController, ViewGroup memberViewLayout) {
        this.mMemberViewLayout = null;
        this.mActivity = activity;
        this.mIMemberViewController = memberViewController;
        this.mMemberViewLayout = memberViewLayout;
    }

    public void startMemberView(boolean mIsOutGoingCall, Destination mDestination, CallUserAddedInfo mUserAddedInfo, VideoCallStatusBar videoCallStatusBar) {
        if (this.mActivity.isConference()) {
            if (MemberViewAdapter.getMemberListCount(mDestination) <= 0) {
                this.mActivity.showToast(this.mActivity.getResources().getString(C0000R.string.wait_for_other_members_to_join));
                return;
            }
            this.mMemberViewActive = true;
            if (this.mMemberViewHandler == null) {
                this.mMemberViewHandler = new MemberViewHandler();
            }
            this.mMemberViewAdaptor = new MemberViewAdapter(this.mActivity.getApplicationContext(), this.mMemberViewHandler, mDestination, mUserAddedInfo, C0000R.layout.video_call_member_item, C0000R.id.video_member_item_image, C0000R.id.video_member_item_name, C0000R.id.video_member_item_end_button, mIsOutGoingCall);
            this.mMemberListView = (ListView) this.mActivity.findViewById(C0000R.id.video_call_member_list);
            this.mMemberListView.setAdapter((ListAdapter) this.mMemberViewAdaptor);
            this.mMemberViewLayout.setVisibility(0);
            this.mIMemberViewController.goneOtherViewForMemberView();
            this.mVideoCallStatusBar = videoCallStatusBar;
        }
    }

    public void startMemberView(boolean mIsOutGoingCall, Destination mDestination, CallUserAddedInfo mUserAddedInfo, VoiceCallMemberLayout voiceCallStatusBar) {
        if (this.mActivity.isConference()) {
            if (MemberViewAdapter.getMemberListCount(mDestination) <= 0) {
                this.mActivity.showToast(this.mActivity.getResources().getString(C0000R.string.wait_for_other_members_to_join));
                return;
            }
            this.mMemberViewActive = true;
            if (this.mMemberViewHandler == null) {
                this.mMemberViewHandler = new MemberViewHandler();
            }
            this.mMemberViewAdaptor = new MemberViewAdapter(this.mActivity.getApplicationContext(), this.mMemberViewHandler, mDestination, mUserAddedInfo, C0000R.layout.video_call_member_item, C0000R.id.video_member_item_image, C0000R.id.video_member_item_name, C0000R.id.video_member_item_end_button, mIsOutGoingCall);
            this.mMemberListView = (ListView) this.mActivity.findViewById(C0000R.id.video_call_member_list);
            this.mMemberListView.setAdapter((ListAdapter) this.mMemberViewAdaptor);
            this.mMemberListView.setDivider(this.mActivity.getResources().getDrawable(C0000R.drawable.list_divider));
            this.mMemberViewLayout.setVisibility(0);
            this.mIMemberViewController.goneOtherViewForMemberView();
            this.mVoiceCallStatusBar = voiceCallStatusBar;
        }
    }

    public void endMemberView() {
        if (this.mMemberViewActive) {
            this.mMemberViewActive = false;
            this.mMemberViewHandler.removeMessages(10);
            if (this.mMemberListView != null) {
                this.mMemberListView.setAdapter((ListAdapter) null);
            }
            this.mMemberViewAdaptor = null;
            this.mMemberViewLayout.setVisibility(8);
            this.mIMemberViewController.showOtherViewForMemberView();
            this.mIMemberViewController.updateLayoutChangeDestination();
            if (this.mVoiceCallStatusBar != null) {
                this.mVoiceCallStatusBar.clickableStatusBarFuctionBtn();
            }
            if (this.mVideoCallStatusBar != null) {
                this.mVideoCallStatusBar.clickableStatusBarFuctionBtn();
            }
        }
    }

    protected class MemberViewHandler extends Handler {
        protected MemberViewHandler() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message msg) {
            if (MemberViewController.this.mMemberViewActive) {
                switch (msg.what) {
                    case 10:
                        MemberViewController.this.logI("MEMBERVIEW_REMOVE_NOTI_TO_SERVER >> userID = " + ((String) msg.obj));
                        MemberViewController.this.mActivity.removeConferenceMember((String) msg.obj);
                        break;
                }
            }
            super.handleMessage(msg);
        }
    }

    public void checkMemberView(Destination mDestination, CallUserAddedInfo mUserAddedInfo) {
        if (this.mMemberViewActive) {
            if (mDestination.getDestinationType() == 4 && mDestination.getConferenceMember().isEmpty()) {
                endMemberView();
                return;
            }
            if (mDestination.getDestinationType() == 5 && mDestination.getP2PConferenceMember().isEmpty()) {
                endMemberView();
                return;
            }
            this.mMemberViewAdaptor.memberCopy(mDestination, mUserAddedInfo);
            if (this.mMemberViewAdaptor.getCount() != 0) {
                this.mMemberViewAdaptor.notifyDataSetChanged();
            } else {
                endMemberView();
            }
        }
    }

    public boolean ismMemberViewActive() {
        return this.mMemberViewActive;
    }

    public ViewGroup getMemberViewLayout() {
        return this.mMemberViewLayout;
    }

    @Override // com.sds.coolots.common.view.DisposeInterface
    public void dispose() {
        if (this.mMemberViewAdaptor != null) {
            this.mMemberViewAdaptor.dispose();
            this.mMemberViewAdaptor = null;
        }
        if (this.mMemberListView != null) {
            this.mMemberListView.setAdapter((ListAdapter) null);
            this.mMemberListView.removeAllViewsInLayout();
            this.mMemberListView = null;
        }
        if (this.mMemberViewHandler != null) {
            this.mMemberViewHandler.removeMessages(10);
            this.mMemberViewHandler = null;
        }
        this.mActivity = null;
        this.mIMemberViewController = null;
        this.mMemberViewLayout = null;
    }
}
