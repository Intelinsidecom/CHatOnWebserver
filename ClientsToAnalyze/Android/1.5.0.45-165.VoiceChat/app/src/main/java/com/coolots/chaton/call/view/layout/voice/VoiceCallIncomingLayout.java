package com.coolots.chaton.call.view.layout.voice;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.provider.Settings;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.coolots.chaton.C0000R;
import com.coolots.chaton.CoolotsChatOn;
import com.coolots.chaton.buddy.BuddyManagerInterface;
import com.coolots.chaton.buddy.model.BuddyTable;
import com.coolots.chaton.call.model.CallDisplayUserInfo;
import com.coolots.chaton.call.model.ConferenceCallDisplayUserInfo;
import com.coolots.chaton.call.view.InviteViewMemberLayout;
import com.coolots.chaton.call.view.VoiceCallActivity;
import com.coolots.chaton.common.controller.VAppPhoneManager;
import com.coolots.chaton.common.util.BuddyImageView;
import com.sds.coolots.MainApplication;
import com.sds.coolots.call.model.Destination;
import com.sds.coolots.common.util.Log;
import com.sds.coolots.common.view.DisposeInterface;

/* loaded from: classes.dex */
public class VoiceCallIncomingLayout extends FrameLayout implements DisposeInterface {
    private static final String CLASSNAME = "[VoiceCallIncomingLayout]";
    private BuddyManagerInterface mBuddyManager;
    private BuddyImageView mConfUserImage;
    private Context mContext;
    private Destination mDestination;
    private RelativeLayout mIcomingStatusBar;
    private InviteViewMemberLayout mInviteViewLayout;
    private boolean mLiveShare;
    private VoiceCallActivity mParentActivity;
    public TextView mPhoneNetworkStateText;
    ViewGroup mRootGroupView;
    private FrameLayout mTotallayout;
    private BuddyImageView mUserImage;
    private TextView mUserName;
    private TextView mUserNumber;

    private void logE(String message) {
        Log.m2958e(CLASSNAME + message);
    }

    private void logI(String message) {
        Log.m2963i(CLASSNAME + message);
    }

    public VoiceCallIncomingLayout(Context context, ViewGroup r) {
        super(context);
        this.mBuddyManager = ((VAppPhoneManager) MainApplication.mPhoneManager).getChatOnContactManager();
        this.mLiveShare = false;
        logI("VoiceCallIncomingLayout() constructor");
        this.mContext = context;
        int childViewCount = r.getChildCount();
        LayoutInflater inflater = (LayoutInflater) context.getSystemService("layout_inflater");
        this.mRootGroupView = (ViewGroup) inflater.inflate(C0000R.layout.voice_call_incoming, r, true);
        this.mUserName = (TextView) this.mRootGroupView.findViewById(C0000R.id.voice_in_call_membername);
        this.mUserName.setSelected(true);
        this.mUserImage = (BuddyImageView) this.mRootGroupView.findViewById(C0000R.id.voice_in_call_memberimage);
        this.mConfUserImage = (BuddyImageView) this.mRootGroupView.findViewById(C0000R.id.voice_in_call_memberimage_conf);
        this.mUserNumber = (TextView) this.mRootGroupView.findViewById(C0000R.id.voice_in_call_membernumber);
        this.mPhoneNetworkStateText = (TextView) this.mRootGroupView.findViewById(C0000R.id.voice_in_call_state_text);
        this.mIcomingStatusBar = (RelativeLayout) this.mRootGroupView.findViewById(C0000R.id.voice_call_incoming_status_bar);
        this.mTotallayout = (FrameLayout) this.mRootGroupView.findViewById(C0000R.id.voice_in_call_all_layout);
        this.mInviteViewLayout = (InviteViewMemberLayout) this.mRootGroupView.findViewById(C0000R.id.voice_call_inviteview_member_incoming);
        if (isDrivingModeOn() && 2 == getConfiguration()) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.mTotallayout.getLayoutParams();
            layoutParams.width = -2;
            layoutParams.height = -1;
            this.mTotallayout.setLayoutParams(layoutParams);
        }
        this.mRootGroupView.getChildAt(childViewCount).setTag(String.valueOf(getClass().toString()) + getConfiguration());
    }

    public void setStatusBarVisibility(int visibility) {
        if (getConfiguration() == 2 && isDrivingModeOn()) {
            this.mIcomingStatusBar.setVisibility(visibility);
        }
    }

    public InviteViewMemberLayout getInviteViewMemberLayout() {
        return this.mInviteViewLayout;
    }

    public ViewGroup getLayoutreference() {
        if (this.mRootGroupView != null) {
            return this.mRootGroupView;
        }
        return null;
    }

    public VoiceCallIncomingLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mBuddyManager = ((VAppPhoneManager) MainApplication.mPhoneManager).getChatOnContactManager();
        this.mLiveShare = false;
        this.mContext = context;
        LayoutInflater inflater = LayoutInflater.from(context);
        inflater.inflate(C0000R.layout.voice_call_incoming, (ViewGroup) this, true);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean arg0, int arg1, int arg2, int arg3, int arg4) {
        int count = getChildCount();
        for (int i = 0; i < count; i++) {
            View child = getChildAt(i);
            if (child.getVisibility() != 8) {
                int childLeft = getPaddingLeft();
                int childTop = getPaddingTop();
                child.layout(childLeft, childTop, child.getMeasuredWidth() + childLeft, child.getMeasuredHeight() + childTop);
            }
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
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
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        logI("onFinishInflate()");
        this.mUserName = (TextView) findViewById(C0000R.id.voice_in_call_membername);
        this.mUserName.setSelected(true);
        this.mUserImage = (BuddyImageView) findViewById(C0000R.id.voice_in_call_memberimage);
        this.mConfUserImage = (BuddyImageView) findViewById(C0000R.id.voice_in_call_memberimage_conf);
        this.mUserNumber = (TextView) findViewById(C0000R.id.voice_in_call_membernumber);
        this.mPhoneNetworkStateText = (TextView) findViewById(C0000R.id.voice_in_call_state_text);
        this.mIcomingStatusBar = (RelativeLayout) findViewById(C0000R.id.voice_call_incoming_status_bar);
        this.mTotallayout = (FrameLayout) findViewById(C0000R.id.voice_in_call_all_layout);
        this.mInviteViewLayout = (InviteViewMemberLayout) findViewById(C0000R.id.voice_call_inviteview_member_incoming);
        if (isDrivingModeOn() && 2 == getConfiguration()) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -1, 51);
            this.mTotallayout.setLayoutParams(layoutParams);
        }
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration newConfig) {
        logI("onConfigurationChanged()");
        if (isDrivingModeOn() && 2 == getConfiguration()) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.mTotallayout.getLayoutParams();
            layoutParams.width = -2;
            layoutParams.height = -1;
            this.mTotallayout.setLayoutParams(layoutParams);
        }
        super.onConfigurationChanged(newConfig);
    }

    public boolean isDrivingModeOn() {
        int driving_mode = Settings.System.getInt(this.mContext.getContentResolver(), "driving_mode_on", 0);
        return driving_mode != 0;
    }

    public void setMember(Destination destination, boolean isOutGoingCall, CallDisplayUserInfo calluserInfo) {
        logI("setMember()");
        this.mDestination = destination;
        setMemberInfo(calluserInfo);
    }

    public void setMember(Destination destination, boolean isOutGoingCall, CallDisplayUserInfo calluserInfo, boolean isLiveShare) throws Throwable {
        this.mDestination = destination;
        this.mLiveShare = isLiveShare;
        setMemberInfo(calluserInfo);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent arg0) {
        return true;
    }

    public void setParent(VoiceCallActivity parent) {
        this.mParentActivity = parent;
    }

    private void setMemberInfo(CallDisplayUserInfo calluserInfo) throws Throwable {
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
                    if (MainApplication.mPhoneManager.IsLinkagewithChatON()) {
                        String groupName = this.mParentActivity.getDestination().getGroupName();
                        if (groupName != null && !groupName.isEmpty()) {
                            this.mUserName.setText(groupName);
                        } else {
                            this.mUserName.setText(userInfo.userName);
                        }
                    } else if (groupID == 0) {
                        this.mUserName.setText(userInfo.userName);
                    } else {
                        this.mUserName.setText(this.mBuddyManager.getGroupNameByGroupID(groupID));
                    }
                    StringBuffer userCnt = new StringBuffer(getResources().getString(C0000R.string.call_info_outgoing_video_group_title));
                    userCnt.append(" (" + (this.mDestination.getConferenceMemberCountWithMe() - this.mParentActivity.getConferenceWaitCount()) + ")");
                    this.mUserNumber.setText(userCnt.toString());
                    this.mUserImage.setVisibility(8);
                    this.mConfUserImage.setVisibility(0);
                    this.mConfUserImage.setImageViewMode(5);
                    if (MainApplication.mPhoneManager.IsLinkagewithChatON()) {
                        String groupName2 = this.mParentActivity.getDestination().getGroupName();
                        if (groupName2 != null && !groupName2.isEmpty()) {
                            this.mConfUserImage.loadImage(groupName2, true);
                        }
                    } else if (groupID != 0) {
                        this.mConfUserImage.loadImage(groupID);
                    }
                    this.mInviteViewLayout.setVisibility(0);
                    break;
                }
                break;
        }
    }

    public int getIncomingStatusBarHeight() {
        return this.mIcomingStatusBar.getHeight();
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
        if (this.mConfUserImage != null) {
            this.mConfUserImage.dispose();
            this.mConfUserImage = null;
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
        if (this.mBuddyManager.getKindOfBuddy(userno) == 0) {
            this.mUserImage.loadImage(userno);
        } else {
            this.mUserImage.setBuddyGroupDefaultImage();
        }
    }

    public void setCallerImage(String userno) {
        logI("setCallerImage buddyID = " + userno);
        this.mUserImage.setImageViewMode(0);
        if (this.mBuddyManager.getKindOfBuddy(userno) == 0) {
            this.mUserImage.loadImage(userno, false);
        } else {
            this.mUserImage.setBuddyGroupDefaultImage();
        }
    }

    public void removeImage() {
        this.mUserImage.setImageResource(C0000R.drawable.call_image);
    }

    private int getConfiguration() {
        return getResources().getConfiguration().orientation;
    }

    public void sendAccessibilityEvent() {
        new Handler().postDelayed(new Runnable() { // from class: com.coolots.chaton.call.view.layout.voice.VoiceCallIncomingLayout.1
            @Override // java.lang.Runnable
            public void run() {
                if (VoiceCallIncomingLayout.this.mUserName != null) {
                    VoiceCallIncomingLayout.this.mUserName.sendAccessibilityEvent(32768);
                }
            }
        }, 500L);
    }
}
