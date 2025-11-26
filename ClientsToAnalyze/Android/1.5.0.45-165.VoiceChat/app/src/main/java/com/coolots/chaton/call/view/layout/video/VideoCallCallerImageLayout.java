package com.coolots.chaton.call.view.layout.video;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.coolots.chaton.C0000R;
import com.coolots.chaton.buddy.BuddyManagerInterface;
import com.coolots.chaton.call.model.CallDisplayUserInfo;
import com.coolots.chaton.call.model.ConferenceCallDisplayUserInfo;
import com.coolots.chaton.call.view.ChatOnCallActivity;
import com.coolots.chaton.common.controller.VAppPhoneManager;
import com.coolots.chaton.common.util.BuddyImageView;
import com.sds.coolots.MainApplication;
import com.sds.coolots.call.model.Destination;
import com.sds.coolots.common.util.Log;
import com.sds.coolots.common.view.DisposeInterface;

/* loaded from: classes.dex */
public class VideoCallCallerImageLayout extends RelativeLayout implements DisposeInterface {
    private static final String CLASSNAME = "[VideoCallCallerImageLayout]";
    private CallDisplayUserInfo mCalluserInfo;
    private ChatOnCallActivity mParentActivity;
    private BuddyImageView mSingleMemberPhoto;

    private void logE(String message) {
        Log.m2958e(CLASSNAME + message);
    }

    private void logI(String message) {
        Log.m2963i(CLASSNAME + message);
    }

    protected void onFinishInflate(boolean callFromChild) {
        super.onFinishInflate();
    }

    public VideoCallCallerImageLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater inflater = LayoutInflater.from(context);
        inflater.inflate(C0000R.layout.video_call_caller_image, (ViewGroup) this, true);
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        logI("onFinishInflate()");
        super.onFinishInflate();
        this.mSingleMemberPhoto = (BuddyImageView) findViewById(C0000R.id.video_call_end_ui_img);
    }

    public void initLayout(Destination destination, CallDisplayUserInfo calluserInfo, ChatOnCallActivity parent) throws Throwable {
        logI("initLayout()");
        this.mParentActivity = parent;
        this.mCalluserInfo = calluserInfo;
        initView();
    }

    private void initView() throws Throwable {
        String groupName;
        BuddyManagerInterface buddyManager = ((VAppPhoneManager) MainApplication.mPhoneManager).getChatOnContactManager();
        if (this.mParentActivity.isConference()) {
            long groupID = 0;
            if (MainApplication.mPhoneManager.IsLinkagewithChatON()) {
                groupName = this.mParentActivity.getDestination().getGroupName();
            } else {
                groupID = this.mParentActivity.getGroupIDByUserInfo();
                groupName = buddyManager.getGroupNameByGroupID(groupID);
            }
            ConferenceCallDisplayUserInfo userInfo = this.mParentActivity.getConferenceMemberName();
            if (userInfo != null) {
                if (groupName == null || groupName.isEmpty()) {
                    this.mSingleMemberPhoto.setImageResource(C0000R.drawable.call_img_conference);
                } else {
                    this.mSingleMemberPhoto.setImageViewMode(4);
                    if (MainApplication.mPhoneManager.IsLinkagewithChatON()) {
                        this.mSingleMemberPhoto.loadImage(groupName, true);
                    } else {
                        this.mSingleMemberPhoto.loadImage(groupID);
                    }
                }
            }
        } else {
            this.mSingleMemberPhoto.setImageViewMode(0);
            if (buddyManager.getKindOfBuddy(this.mCalluserInfo.userID) == 0) {
                this.mSingleMemberPhoto.loadImage(this.mCalluserInfo.userID, true);
            } else {
                this.mSingleMemberPhoto.setBuddyGroupDefaultImage();
            }
        }
        if (getResources().getConfiguration().orientation == 1) {
            RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) getLayoutParams();
            params.topMargin = this.mParentActivity.getModelInfo().getCallStatusBarHeight();
            setLayoutParams(params);
        }
    }

    @Override // com.sds.coolots.common.view.DisposeInterface
    public void dispose() {
        logI("dispose()");
        if (this.mSingleMemberPhoto != null) {
            this.mSingleMemberPhoto.dispose();
            this.mSingleMemberPhoto = null;
        }
        removeAllViewsInLayout();
    }
}
