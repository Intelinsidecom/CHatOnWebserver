package com.coolots.chaton.call.view.layout;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.Chronometer;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.coolots.chaton.C0000R;
import com.coolots.chaton.buddy.BuddyManagerInterface;
import com.coolots.chaton.call.model.CallDisplayUserInfo;
import com.coolots.chaton.call.model.ConferenceCallDisplayUserInfo;
import com.coolots.chaton.call.view.ChatOnCallActivity;
import com.coolots.chaton.common.controller.VAppPhoneManager;
import com.coolots.chaton.common.util.BuddyImageView;
import com.sds.coolots.MainApplication;
import com.sds.coolots.call.model.Destination;
import com.sds.coolots.common.view.DisposeInterface;
import java.io.IOException;

/* loaded from: classes.dex */
public class EndedCallCoveredLayoutBig extends EndedCallCoveredWidget implements DisposeInterface {
    private static final String CLASSNAME = "[EndCallCoveredLayout]";
    private BuddyManagerInterface mBuddyManager;
    private TextView mClearCoverCallKind;
    private RelativeLayout mClearCoverLowerLayout;
    private ImageView mIconImage;
    private BuddyImageView mUserImage;

    public EndedCallCoveredLayoutBig(Context context, ViewGroup r, Destination destination, ChatOnCallActivity parentActivity) {
        super(context, r, destination, parentActivity);
        this.mBuddyManager = ((VAppPhoneManager) MainApplication.mPhoneManager).getChatOnContactManager();
        int childViewCount = r.getChildCount();
        LayoutInflater inflater = LayoutInflater.from(this.mContext);
        this.mRootGroupView = (ViewGroup) inflater.inflate(C0000R.layout.ended_call_clear_cover_big, r, true);
        this.mUserImage = (BuddyImageView) this.mRootGroupView.findViewById(C0000R.id.voice_end_call_memberimage_covered);
        this.mClearCoverUserName = (TextView) this.mRootGroupView.findViewById(C0000R.id.clear_end_big_cover_ui_name);
        this.mClearCoverUserMessage = (TextView) this.mRootGroupView.findViewById(C0000R.id.clear_end_big_cover_ui_message);
        this.mClearCoverLowerLayout = (RelativeLayout) this.mRootGroupView.findViewById(C0000R.id.clear_big_cover_incoming_call_widget);
        this.mClearCoverEndedtime = (Chronometer) this.mRootGroupView.findViewById(C0000R.id.clear_end_big_cover_ended_time);
        this.mClearCoverEndedtime.setBase(parentActivity.getLayoutCallBaseTime().longValue());
        this.mClearCoverEndedtime.stop();
        this.mIconImage = (ImageView) this.mRootGroupView.findViewById(C0000R.id.clear_big_cover_ic_chaton_call_end);
        this.mClearCoverCallKind = (TextView) this.mRootGroupView.findViewById(C0000R.id.clear_end_big_cover_ui_call_kind);
        this.mRootGroupView.getChildAt(childViewCount).setTag(String.valueOf(getClass().toString()) + getConfiguration());
    }

    public EndedCallCoveredLayoutBig(Context context) {
        super(context);
        this.mBuddyManager = ((VAppPhoneManager) MainApplication.mPhoneManager).getChatOnContactManager();
        this.mContext = context;
    }

    public EndedCallCoveredLayoutBig(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mBuddyManager = ((VAppPhoneManager) MainApplication.mPhoneManager).getChatOnContactManager();
        this.mContext = context;
    }

    public EndedCallCoveredLayoutBig(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.mBuddyManager = ((VAppPhoneManager) MainApplication.mPhoneManager).getChatOnContactManager();
        this.mContext = context;
    }

    @Override // com.coolots.chaton.call.view.layout.EndedCallCoveredWidget
    public void setClearCoverActive(CallDisplayUserInfo calluserInfo) throws IOException {
        setCallerImage();
        setCallerName(calluserInfo);
        this.mClearCoverUserMessage.setText(calluserInfo.userStateMsg);
        this.mClearCoverCallKind.setText(getResources().getString(C0000R.string.clear_call));
        if (this.mIsVoiceCall) {
            this.mIconImage.setBackgroundResource(C0000R.drawable.ic_chaton_call);
            return;
        }
        this.mIconImage.setBackgroundResource(C0000R.drawable.ic_chaton_video);
        this.mClearCoverLowerLayout.setBackgroundColor(getResources().getColor(C0000R.color.tw_color002));
        this.mClearCoverEndedtime.setVisibility(8);
    }

    private void setCallerName(CallDisplayUserInfo calluserInfo) {
        String groupName;
        if (this.mParentActivity.isConference()) {
            if (MainApplication.mPhoneManager.IsLinkagewithChatON()) {
                groupName = this.mParentActivity.getDestination().getGroupName();
            } else {
                long groupID = this.mParentActivity.getGroupIDByUserInfo();
                BuddyManagerInterface buddyManager = ((VAppPhoneManager) MainApplication.mPhoneManager).getChatOnContactManager();
                groupName = buddyManager.getGroupNameByGroupID(groupID);
            }
            ConferenceCallDisplayUserInfo userInfo = this.mParentActivity.getConferenceMemberName();
            if (userInfo == null) {
                this.mClearCoverUserName.setText(C0000R.string.call_info_voice_group_title);
                this.mClearCoverUserName.setText(C0000R.string.wait_for_other_members_to_join);
            } else if (groupName == null || groupName.isEmpty()) {
                this.mClearCoverUserName.setText(userInfo.userName);
            } else {
                this.mClearCoverUserName.setText(groupName);
            }
        } else {
            this.mClearCoverUserName.setText(calluserInfo.userName);
        }
        this.mClearCoverUserName.setSelected(true);
    }

    private void setCallerImage() throws IOException {
        if (this.mDestination != null && this.mUserImage.getDrawable() == null) {
            String buddyID = this.mDestination.getString();
            logI("setCallerImage buddyID = " + buddyID);
            if (this.mParentActivity.isConference()) {
                this.mUserImage.setImageViewMode(4);
            } else {
                this.mUserImage.setImageViewMode(0);
            }
            if (this.mBuddyManager.getKindOfBuddy(buddyID) == 0) {
                this.mUserImage.loadImageForCover(buddyID, this.mIsVoiceCall);
            } else {
                this.mUserImage.setBuddyGroupDefaultImageForCover(this.mIsVoiceCall);
            }
        }
    }

    @Override // com.coolots.chaton.call.view.layout.EndedCallCoveredWidget
    public void initialize(Destination destination, ChatOnCallActivity parentActivity) {
        LayoutInflater inflater = LayoutInflater.from(this.mContext);
        this.mDestination = destination;
        this.mParentActivity = parentActivity;
        inflater.inflate(C0000R.layout.ended_call_clear_cover_big, (ViewGroup) this, true);
        this.mClearCoverUserName = (TextView) findViewById(C0000R.id.clear_end_big_cover_ui_name);
        this.mClearCoverUserMessage = (TextView) findViewById(C0000R.id.clear_end_big_cover_ui_message);
        this.mClearCoverCallKind = (TextView) findViewById(C0000R.id.clear_end_big_cover_ui_call_kind);
        this.mUserImage = (BuddyImageView) findViewById(C0000R.id.voice_end_call_memberimage_covered);
        this.mIconImage = (ImageView) findViewById(C0000R.id.clear_big_cover_ic_chaton_call_end);
        this.mClearCoverLowerLayout = (RelativeLayout) findViewById(C0000R.id.clear_big_cover_incoming_call_widget);
        this.mClearCoverEndedtime = (Chronometer) findViewById(C0000R.id.clear_end_big_cover_ended_time);
    }

    @Override // com.coolots.chaton.call.view.layout.EndedCallCoveredWidget, com.sds.coolots.common.view.DisposeInterface
    public void dispose() {
        if (this.mClearCoverCallKind != null) {
            this.mClearCoverCallKind = null;
        }
        removeAllViewsInLayout();
    }
}
