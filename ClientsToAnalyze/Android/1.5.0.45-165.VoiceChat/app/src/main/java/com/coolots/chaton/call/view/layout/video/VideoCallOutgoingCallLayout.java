package com.coolots.chaton.call.view.layout.video;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.AnimationDrawable;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
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
import com.coolots.chaton.call.view.VideoCallActivity;
import com.coolots.chaton.common.controller.VAppPhoneManager;
import com.coolots.chaton.common.util.ContentDescriptionStringMaker;
import com.sds.coolots.MainApplication;
import com.sds.coolots.call.model.CallState;
import com.sds.coolots.call.model.Destination;
import com.sds.coolots.common.util.Log;
import com.sds.coolots.common.view.DisposeInterface;
import com.vlingo.sdk.recognition.spotter.VLSpotterContext;

/* loaded from: classes.dex */
public class VideoCallOutgoingCallLayout extends RelativeLayout implements DisposeInterface, View.OnClickListener {
    private static final String CLASSNAME = "[VideoCallOutgoingCallLayout]";
    private static final int LANDSCAPE_MARGIN = 97;
    private CallDisplayUserInfo mCalluserInfo;
    private Destination mDestination;
    private InnerHandler mHandler;
    private boolean mIsRotate;
    private boolean mIsVisibleDurationTime;
    private ChatOnCallActivity mParentActivity;
    private RelativeLayout mStatusBarBG;
    private int mTimeBlinkCnt;
    private VideoCallActivity mVideoCallActivity;
    private ViewGroup mVideoCallHideMeBtn;
    private ImageView mVideoCallHideMeImg;
    private ViewGroup mVideoCallHideMeLayout;
    private TextView mVideoCallHideMeText;
    private TextView mVideoCallMemberInfo;
    private TextView mVideoCallMemberName;
    private ImageView mVideoCallStatusDialingImage;
    private TextView mVideoCallStatusMsg;
    private Chronometer mVideoCallTime;

    private void logE(String message) {
        Log.m2958e(CLASSNAME + message);
    }

    private void logI(String message) {
        Log.m2963i(CLASSNAME + message);
    }

    public VideoCallOutgoingCallLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mTimeBlinkCnt = 0;
        this.mIsVisibleDurationTime = false;
        LayoutInflater inflater = LayoutInflater.from(context);
        inflater.inflate(C0000R.layout.video_call_outgoing, (ViewGroup) this, true);
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        this.mStatusBarBG = (RelativeLayout) findViewById(C0000R.id.statusbar_bg);
        this.mStatusBarBG.setOnClickListener(this);
        this.mVideoCallMemberName = (TextView) findViewById(C0000R.id.video_call_member_name);
        this.mVideoCallMemberName.setSelected(true);
        this.mVideoCallMemberInfo = (TextView) findViewById(C0000R.id.video_call_member_info);
        this.mVideoCallStatusMsg = (TextView) findViewById(C0000R.id.video_call_status_msg);
        this.mVideoCallTime = (Chronometer) findViewById(C0000R.id.video_call_time);
        this.mVideoCallStatusDialingImage = (ImageView) findViewById(C0000R.id.video_call_dialing_image);
        this.mVideoCallHideMeLayout = (ViewGroup) findViewById(C0000R.id.hide_me_layout);
        this.mVideoCallHideMeText = (TextView) findViewById(C0000R.id.hide_me_txt);
        setHideMeBtnWidth();
        this.mVideoCallHideMeImg = (ImageView) findViewById(C0000R.id.hide_me_img);
        this.mVideoCallHideMeBtn = (ViewGroup) findViewById(C0000R.id.hide_me_btn);
        this.mVideoCallHideMeBtn.setOnClickListener(new View.OnClickListener() { // from class: com.coolots.chaton.call.view.layout.video.VideoCallOutgoingCallLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View arg0) {
                VideoCallOutgoingCallLayout.this.mParentActivity.setAlterImage();
            }
        });
    }

    public void initLayout(Destination destination, boolean isRotate, CallDisplayUserInfo calluserInfo, ChatOnCallActivity parent, VideoCallActivity activity) {
        this.mParentActivity = parent;
        this.mDestination = destination;
        this.mCalluserInfo = calluserInfo;
        this.mVideoCallActivity = activity;
        initView();
        this.mIsRotate = isRotate;
        if (this.mHandler == null) {
            this.mHandler = new InnerHandler();
        }
    }

    private void initView() {
        String groupName;
        initLayoutParams();
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
        } else {
            this.mVideoCallMemberName.setText(this.mCalluserInfo.userName);
            this.mVideoCallMemberInfo.setText(C0000R.string.calling_button_receive);
        }
        this.mVideoCallMemberName.setSelected(true);
        if (CallState.isNotConnected(this.mParentActivity.getCallState())) {
            if (this.mParentActivity.isOutGoingCall()) {
                this.mVideoCallHideMeLayout.setVisibility(8);
                this.mVideoCallTime.setVisibility(8);
                startDialingAnimation();
                this.mVideoCallStatusMsg.setText(getResources().getString(C0000R.string.call_info_outgoing_video_call));
                return;
            }
            this.mVideoCallTime.setVisibility(8);
            this.mVideoCallStatusDialingImage.setVisibility(8);
            this.mVideoCallStatusMsg.setText(getResources().getString(C0000R.string.call_info_incoming_video_call));
            return;
        }
        if (CallState.isDisconnected(this.mParentActivity.getCallState())) {
            this.mStatusBarBG.setBackground(getResources().getDrawable(C0000R.drawable.action_bar_bg_03));
            this.mVideoCallTime.setVisibility(8);
            this.mVideoCallHideMeLayout.setVisibility(8);
            this.mVideoCallStatusDialingImage.setVisibility(8);
            this.mVideoCallStatusMsg.setText(getResources().getString(C0000R.string.clear_call));
            this.mVideoCallStatusMsg.setTextColor(getResources().getColor(C0000R.color.call_status_bar_status_msg));
            this.mVideoCallMemberInfo.setTextColor(getResources().getColor(C0000R.color.call_status_bar_status_msg));
            this.mVideoCallMemberName.setTextColor(getResources().getColor(C0000R.color.tw_color001));
        }
    }

    public void initLayoutParams() {
        if (getResources().getConfiguration().orientation == 2) {
            RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) getLayoutParams();
            if (CallState.isNotConnected(this.mParentActivity.getCallState())) {
                if (this.mParentActivity.isOutGoingCall() || this.mParentActivity.isDrivingModeOn()) {
                    params.rightMargin = ((int) (getResources().getDisplayMetrics().density * 97.0f)) * 2;
                } else {
                    params.leftMargin = (int) (getResources().getDisplayMetrics().density * 97.0f);
                    params.rightMargin = (int) (getResources().getDisplayMetrics().density * 97.0f);
                }
            } else if (CallState.isDisconnected(this.mParentActivity.getCallState())) {
                params.leftMargin = (int) (335.0f * getResources().getDisplayMetrics().density);
                params.rightMargin = 0;
            }
            setLayoutParams(params);
        }
    }

    public void setHideMeBtn(boolean hideMe) {
        if (hideMe) {
            this.mVideoCallHideMeText.setText(getResources().getString(C0000R.string.call_menu_show_me));
            this.mVideoCallHideMeImg.setBackgroundResource(C0000R.drawable.action_bar_icon_show_me);
            this.mVideoCallHideMeBtn.setContentDescription(ContentDescriptionStringMaker.makeString(C0000R.string.call_menu_show_me, C0000R.string.talk_back_button));
        } else {
            this.mVideoCallHideMeText.setText(getResources().getString(C0000R.string.call_menu_hide_me));
            this.mVideoCallHideMeImg.setBackgroundResource(C0000R.drawable.action_bar_icon_hide_me);
            this.mVideoCallHideMeBtn.setContentDescription(ContentDescriptionStringMaker.makeString(C0000R.string.call_menu_hide_me, C0000R.string.talk_back_button));
        }
    }

    private void setHideMeBtnWidth() {
        Paint TextPaint = this.mVideoCallHideMeText.getPaint();
        Rect TextBounds = new Rect();
        this.mVideoCallHideMeText.setText(getResources().getString(C0000R.string.call_menu_show_me));
        String getShowText = this.mVideoCallHideMeText.getText().toString();
        TextPaint.getTextBounds(getShowText, 0, getShowText.length(), TextBounds);
        int showTextWidth = TextBounds.width();
        this.mVideoCallHideMeText.setText(getResources().getString(C0000R.string.call_menu_hide_me));
        String gethideText = this.mVideoCallHideMeText.getText().toString();
        TextPaint.getTextBounds(gethideText, 0, gethideText.length(), TextBounds);
        int hideTextWidth = TextBounds.width();
        RelativeLayout.LayoutParams lp = (RelativeLayout.LayoutParams) this.mVideoCallHideMeText.getLayoutParams();
        if (showTextWidth >= hideTextWidth) {
            lp.width = showTextWidth + 10;
        } else {
            lp.width = hideTextWidth + 10;
        }
        this.mVideoCallHideMeText.setLayoutParams(lp);
        this.mVideoCallHideMeText.invalidate();
    }

    private void startDialingAnimation() {
        AnimationDrawable frameAnimation = (AnimationDrawable) this.mVideoCallStatusDialingImage.getBackground();
        frameAnimation.start();
    }

    public void sendAccessibilityEvent() {
        new Handler().postDelayed(new Runnable() { // from class: com.coolots.chaton.call.view.layout.video.VideoCallOutgoingCallLayout.2
            @Override // java.lang.Runnable
            public void run() {
                if (VideoCallOutgoingCallLayout.this.mVideoCallMemberName != null) {
                    VideoCallOutgoingCallLayout.this.mVideoCallMemberName.sendAccessibilityEvent(32768);
                }
            }
        }, 500L);
    }

    @Override // android.view.ViewGroup
    protected boolean drawChild(Canvas canvas, View child, long drawingTime) {
        if (this.mIsRotate) {
            canvas.rotate(270.0f, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, 100.0f);
        }
        return super.drawChild(canvas, child, drawingTime);
    }

    public void setTimeData(long durationTime, int isConnected) {
        if (isConnected == 0) {
            this.mIsVisibleDurationTime = false;
            this.mVideoCallTime.setVisibility(8);
            this.mVideoCallStatusMsg.setVisibility(0);
        } else {
            this.mIsVisibleDurationTime = true;
            this.mVideoCallStatusMsg.setVisibility(8);
            this.mVideoCallTime.setVisibility(0);
            this.mVideoCallTime.setBase(durationTime);
        }
        if (this.mHandler != null && this.mTimeBlinkCnt == 0) {
            this.mHandler.sendEmptyMessage(0);
        }
    }

    public long getTimeData() {
        return this.mVideoCallTime.getBase();
    }

    public int getTimeBlinkCount() {
        return this.mTimeBlinkCnt;
    }

    public void setTimeBlinkCount(int blinkCount) {
        this.mTimeBlinkCnt = blinkCount;
    }

    class InnerHandler extends Handler implements DisposeInterface {
        private boolean bDisposed = false;

        InnerHandler() {
        }

        @Override // com.sds.coolots.common.view.DisposeInterface
        public void dispose() {
            this.bDisposed = true;
        }

        @Override // android.os.Handler
        public void handleMessage(Message msg) {
            if (!this.bDisposed) {
                VideoCallOutgoingCallLayout.this.mTimeBlinkCnt++;
                ChatOnCallActivity.setPublicBaseTime(0L);
                if (VideoCallOutgoingCallLayout.this.mTimeBlinkCnt == 5) {
                    VideoCallOutgoingCallLayout.this.mTimeBlinkCnt = 0;
                    VideoCallOutgoingCallLayout.this.mHandler.removeMessages(0);
                    VideoCallOutgoingCallLayout.this.mHandler = null;
                    VideoCallOutgoingCallLayout.this.mVideoCallTime.setVisibility(8);
                    VideoCallOutgoingCallLayout.this.mVideoCallStatusMsg.setVisibility(0);
                    return;
                }
                if (VideoCallOutgoingCallLayout.this.mTimeBlinkCnt != 1 && VideoCallOutgoingCallLayout.this.mTimeBlinkCnt != 3) {
                    VideoCallOutgoingCallLayout.this.mVideoCallTime.setVisibility(4);
                    VideoCallOutgoingCallLayout.this.mVideoCallStatusMsg.setVisibility(4);
                    VideoCallOutgoingCallLayout.this.mHandler.removeMessages(0);
                    VideoCallOutgoingCallLayout.this.mHandler.sendEmptyMessageDelayed(0, 500L);
                    return;
                }
                if (!VideoCallOutgoingCallLayout.this.mIsVisibleDurationTime) {
                    VideoCallOutgoingCallLayout.this.mVideoCallStatusMsg.setVisibility(0);
                    VideoCallOutgoingCallLayout.this.mVideoCallTime.setVisibility(8);
                } else {
                    VideoCallOutgoingCallLayout.this.mVideoCallTime.setVisibility(0);
                    VideoCallOutgoingCallLayout.this.mVideoCallStatusMsg.setVisibility(8);
                }
                VideoCallOutgoingCallLayout.this.mHandler.removeMessages(0);
                VideoCallOutgoingCallLayout.this.mHandler.sendEmptyMessageDelayed(0, 500L);
            }
        }
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
        if (this.mVideoCallHideMeText != null) {
            this.mVideoCallHideMeText = null;
        }
        if (this.mVideoCallHideMeImg != null) {
            this.mVideoCallHideMeImg = null;
        }
        if (this.mVideoCallHideMeBtn != null) {
            this.mVideoCallHideMeBtn.removeAllViews();
            this.mVideoCallHideMeBtn = null;
        }
        if (this.mVideoCallHideMeLayout != null) {
            this.mVideoCallHideMeLayout.removeAllViews();
            this.mVideoCallHideMeLayout = null;
        }
        if (this.mVideoCallStatusDialingImage != null) {
            this.mVideoCallStatusDialingImage = null;
        }
        if (this.mVideoCallTime != null) {
            this.mVideoCallTime = null;
        }
        if (this.mHandler != null) {
            this.mHandler.removeMessages(0);
            this.mHandler.dispose();
            this.mHandler = null;
        }
        removeAllViewsInLayout();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        switch (v.getId()) {
            case C0000R.id.statusbar_bg /* 2131493466 */:
                this.mVideoCallActivity.inviteViewCheck();
                break;
        }
    }
}
