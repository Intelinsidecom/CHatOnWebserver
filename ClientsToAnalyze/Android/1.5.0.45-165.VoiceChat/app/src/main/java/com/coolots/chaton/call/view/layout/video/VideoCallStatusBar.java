package com.coolots.chaton.call.view.layout.video;

import android.R;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.coolots.chaton.C0000R;
import com.coolots.chaton.buddy.BuddyManagerInterface;
import com.coolots.chaton.call.model.CallDisplayUserInfo;
import com.coolots.chaton.call.model.ConferenceCallDisplayUserInfo;
import com.coolots.chaton.call.util.ITranslatorViewController;
import com.coolots.chaton.call.util.StaticsManager;
import com.coolots.chaton.call.view.ChatOnCallActivity;
import com.coolots.chaton.call.view.VideoCallActivity;
import com.coolots.chaton.common.controller.VAppPhoneManager;
import com.coolots.chaton.common.util.ChatONDialogFun;
import com.coolots.chaton.common.util.ChatONStringConvert;
import com.coolots.chaton.common.util.ChatOnService;
import com.sds.coolots.MainApplication;
import com.sds.coolots.call.model.CallState;
import com.sds.coolots.call.model.Destination;
import com.sds.coolots.common.controller.translation.data.TranslationDisplayData;
import com.sds.coolots.common.util.Log;
import com.sds.coolots.common.view.DisposeInterface;
import com.vlingo.sdk.recognition.spotter.VLSpotterContext;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
public class VideoCallStatusBar extends RelativeLayout implements DisposeInterface, ITranslatorViewController, View.OnClickListener {
    private static final int ANIMATION_CYCLE_TIME = 500;
    private static final String CLASSNAME = "[VideoCallStatusBar]";
    private Button mBtnFun;
    private Button mBtnShare;
    private RelativeLayout mCallStatusbar;
    private CallDisplayUserInfo mCalluserInfo;
    private Destination mDestination;
    private Chronometer mElapsedTime;
    private Dialog mFunDialog;
    private boolean mIsShowing;
    private boolean mIsUsingAnimation;
    private ChatOnCallActivity mParentActivity;
    private FrameLayout mShareLayout;
    private boolean mStartTimer;
    private Animation.AnimationListener mStatusBarLinstener;
    private TranslateAnimation mStatusBarTrans;
    private TextView mVideoCallMemberInfo;
    private TextView mVideoCallMemberName;
    private VideoCallActivity mVideocallActivity;

    private void logI(String message) {
        Log.m2963i(CLASSNAME + message);
    }

    private void logE(String message) {
        Log.m2958e(CLASSNAME + message);
    }

    public VideoCallStatusBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mStartTimer = false;
        this.mFunDialog = null;
        this.mStatusBarLinstener = new Animation.AnimationListener() { // from class: com.coolots.chaton.call.view.layout.video.VideoCallStatusBar.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation arg0) {
                VideoCallStatusBar.this.mIsUsingAnimation = true;
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation arg0) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation arg0) {
                VideoCallStatusBar.this.mIsUsingAnimation = false;
                if (!VideoCallStatusBar.this.mIsShowing) {
                    VideoCallStatusBar.this.hideStatusBar();
                }
            }
        };
        LayoutInflater inflater = LayoutInflater.from(context);
        inflater.inflate(C0000R.layout.video_call_status_bar, (ViewGroup) this, true);
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        this.mCallStatusbar = (RelativeLayout) findViewById(C0000R.id.video_call_status_bar_layout_id);
        this.mCallStatusbar.setOnClickListener(this);
        this.mVideoCallMemberName = (TextView) findViewById(C0000R.id.video_status_name);
        this.mVideoCallMemberInfo = (TextView) findViewById(C0000R.id.video_status_phone);
        this.mElapsedTime = (Chronometer) findViewById(C0000R.id.video_status_time);
        ImageView funImg = (ImageView) findViewById(C0000R.id.fun_btn_img);
        if (MainApplication.mPhoneManager.IsLinkagewithChatON()) {
            funImg.setBackgroundResource(C0000R.drawable.v_title_smail_icon);
        }
        this.mBtnFun = (Button) findViewById(C0000R.id.option_fun_btn);
        this.mBtnFun.setOnClickListener(this);
        this.mShareLayout = (FrameLayout) findViewById(C0000R.id.option_share_btn_layout);
        ImageView shareImg = (ImageView) findViewById(C0000R.id.share_btn_img);
        if (MainApplication.mPhoneManager.IsLinkagewithChatON()) {
            shareImg.setBackgroundResource(C0000R.drawable.v_title_chat_icon);
        }
        this.mBtnShare = (Button) findViewById(C0000R.id.option_share_btn);
        this.mBtnShare.setOnClickListener(this);
    }

    public void initLayout(Destination destination, CallDisplayUserInfo calluserInfo, ChatOnCallActivity parent, VideoCallActivity videoCallActivity) {
        this.mParentActivity = parent;
        this.mDestination = destination;
        this.mCalluserInfo = calluserInfo;
        this.mVideocallActivity = videoCallActivity;
        initView();
        if (this.mParentActivity != null) {
            boolean isChatOnMember = false;
            ChatOnService chatonservice = ChatOnService.createService(getContext());
            if (this.mParentActivity.isConference()) {
                ArrayList<String> callmemberAccountIDlist = this.mParentActivity.getConferenceConnectUserIDList();
                if (chatonservice != null) {
                    Iterator<String> it = callmemberAccountIDlist.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        String AccountId = it.next();
                        if (chatonservice.isChatOnBuddy(AccountId) == 4) {
                            isChatOnMember = true;
                            break;
                        }
                    }
                }
            } else {
                String AccountId2 = ChatONStringConvert.getInstance().removeFooter(destination.getString());
                if (chatonservice != null && chatonservice.isChatOnBuddy(AccountId2) == 4) {
                    isChatOnMember = true;
                }
            }
            if (isChatOnMember) {
                this.mShareLayout.setVisibility(0);
            } else {
                this.mShareLayout.setVisibility(8);
            }
        }
    }

    public void initLayoutParams() {
        if (getResources().getConfiguration().orientation == 2) {
            RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) getLayoutParams();
            if (this.mVideocallActivity.getShareViewFullScreen()) {
                params.rightMargin = 0;
            } else {
                params.rightMargin = ((int) (97.0f * getResources().getDisplayMetrics().density)) * 2;
            }
            setLayoutParams(params);
            return;
        }
        this.mIsShowing = true;
    }

    public void initView() {
        String groupName;
        initLayoutParams();
        BuddyManagerInterface buddyManager = ((VAppPhoneManager) MainApplication.mPhoneManager).getChatOnContactManager();
        if (this.mParentActivity != null) {
            if (this.mParentActivity.isConference()) {
                if (this.mParentActivity.getConferenceWaitCount() > 0 && this.mParentActivity.getConferenceConnectCount() != 0 && this.mParentActivity.getConferenceConnectCount() < 2 && CallState.isConnected(this.mParentActivity.mCallStatusData.getCallState())) {
                    this.mVideoCallMemberName.setText(this.mParentActivity.getConferenceMemberName().userName);
                    this.mVideoCallMemberInfo.setText(C0000R.string.call_inviting_participants);
                } else {
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
                }
            } else {
                this.mVideoCallMemberName.setText(this.mCalluserInfo.userName);
                this.mVideoCallMemberInfo.setText(C0000R.string.calling_button_receive);
            }
            this.mVideoCallMemberName.setSelected(true);
        }
    }

    private void setTitleforTranslating() {
        this.mVideoCallMemberInfo.setText(C0000R.string.translator_change_tts_translating);
    }

    private void setInfo() {
        this.mVideoCallMemberInfo.setText(C0000R.string.calling_button_receive);
    }

    @Override // com.sds.coolots.common.view.DisposeInterface
    public void dispose() {
        if (this.mElapsedTime != null) {
            this.mElapsedTime = null;
        }
        if (this.mVideoCallMemberName != null) {
            this.mVideoCallMemberName = null;
        }
        if (this.mVideoCallMemberInfo != null) {
            this.mVideoCallMemberInfo = null;
        }
        if (this.mFunDialog != null) {
            this.mFunDialog.dismiss();
            this.mFunDialog = null;
        }
        if (this.mBtnFun != null) {
            this.mBtnFun = null;
        }
        if (this.mBtnShare != null) {
            this.mBtnShare = null;
        }
        if (this.mShareLayout != null) {
            this.mShareLayout = null;
        }
        removeAllViewsInLayout();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        if (isShowing()) {
            switch (v.getId()) {
                case C0000R.id.video_call_status_bar_layout_id /* 2131493492 */:
                    this.mVideocallActivity.inviteViewCheck();
                    break;
                case C0000R.id.option_fun_btn /* 2131493499 */:
                    showFunDialog();
                    break;
                case C0000R.id.option_share_btn /* 2131493502 */:
                    if (MainApplication.mPhoneManager.IsLinkagewithChatON()) {
                        this.mParentActivity.setOptionMenuDialog(44);
                        break;
                    } else {
                        this.mParentActivity.setOptionMenuDialog(40);
                        break;
                    }
            }
        }
    }

    private void showFunDialog() {
        this.mVideocallActivity.removeStatusbarAnimation();
        ChatONDialogFun.Builder dialog = new ChatONDialogFun.Builder(this.mParentActivity);
        dialog.setTitle(C0000R.string.call_btn_option_fun);
        dialog.setCartoonViewState(this.mParentActivity.isCartoonView());
        dialog.setDualCameraSate(this.mParentActivity.useDualCamera());
        dialog.setEmotiAnidButton(new DialogInterface.OnClickListener() { // from class: com.coolots.chaton.call.view.layout.video.VideoCallStatusBar.2
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog2, int which) {
                if (VideoCallStatusBar.this.mParentActivity.useDualCamera()) {
                    Toast.makeText(VideoCallStatusBar.this.getContext(), C0000R.string.video_call_fun_enable_reason_dual_camera, 0).show();
                } else {
                    StaticsManager.getInstance().setFunEffectsAnimatedEmotionFlag();
                    VideoCallStatusBar.this.mParentActivity.setOptionMenuDialog(7);
                }
            }
        });
        dialog.setThemeShotButton(new DialogInterface.OnClickListener() { // from class: com.coolots.chaton.call.view.layout.video.VideoCallStatusBar.3
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog2, int which) {
                if (VideoCallStatusBar.this.mParentActivity.useDualCamera()) {
                    Toast.makeText(VideoCallStatusBar.this.getContext(), C0000R.string.video_call_fun_enable_reason_dual_camera, 0).show();
                } else {
                    StaticsManager.getInstance().setFunEffectsThemeViewFlag();
                    VideoCallStatusBar.this.mParentActivity.setOptionMenuDialog(8);
                }
            }
        });
        dialog.setCarttonViewButton(new DialogInterface.OnClickListener() { // from class: com.coolots.chaton.call.view.layout.video.VideoCallStatusBar.4
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog2, int which) {
                StaticsManager.getInstance().setFunEffectsCartoonViewFlag();
                VideoCallStatusBar.this.mParentActivity.setOptionMenuDialog(9);
            }
        });
        dialog.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.coolots.chaton.call.view.layout.video.VideoCallStatusBar.5
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface arg0) {
                VideoCallStatusBar.this.mVideocallActivity.startStatusbarAnimation();
            }
        });
        this.mFunDialog = dialog.create();
        this.mFunDialog.show();
    }

    public void dismissFunDialog() {
        if (this.mFunDialog != null && this.mFunDialog.isShowing()) {
            this.mFunDialog.dismiss();
        }
    }

    public void clickableStatusBarFuctionBtn() {
        this.mBtnFun.setClickable(true);
        this.mBtnShare.setClickable(true);
    }

    public void unClickableStatusBarFuctionBtn() {
        this.mBtnFun.setClickable(false);
        this.mBtnShare.setClickable(false);
    }

    public void resetUserCount() {
        if (this.mParentActivity.isConference()) {
            this.mVideoCallMemberInfo.setText(getResources().getString(C0000R.string.call_info_outgoing_video_group_title));
        } else {
            this.mVideoCallMemberInfo.setText(C0000R.string.calling_button_receive);
        }
    }

    public void setUIState(int callState) {
        if (CallState.isConnected(callState)) {
            if (this.mParentActivity.getCallFunctionController().getCallSwitchingProcessing() == 2) {
                logI("CALL_SWITCH Backup된 Call Time Setting");
                setCallBaseTime(this.mParentActivity.getLayoutCallBaseTime());
                return;
            } else {
                if (this.mStartTimer) {
                    if (callState != 2 && callState != 5) {
                        setCallBaseTime(this.mParentActivity.getLayoutCallBaseTime());
                        return;
                    }
                    return;
                }
                setCallBaseTime(this.mParentActivity.getLayoutCallBaseTime());
                ChatOnCallActivity.setPublicBaseTime(Long.valueOf(SystemClock.elapsedRealtime() - this.mParentActivity.getNowDateSetting()));
                return;
            }
        }
        if (CallState.isDisconnected(callState)) {
            this.mElapsedTime.stop();
            this.mStartTimer = false;
        }
    }

    public long getElapsedTime() {
        return this.mElapsedTime.getBase() == 0 ? SystemClock.elapsedRealtime() : this.mElapsedTime.getBase();
    }

    public long getElapsedTimeInMilisec() {
        long returnValue;
        if (this.mElapsedTime.getBase() == 0) {
            returnValue = 0;
        } else {
            returnValue = SystemClock.elapsedRealtime() - this.mElapsedTime.getBase();
        }
        return returnValue / 1000;
    }

    public Long getCallBaseTime() {
        return Long.valueOf(this.mElapsedTime.getBase());
    }

    public void setCallBaseTime(Long baseTime) {
        this.mElapsedTime.setBase(baseTime.longValue());
        this.mElapsedTime.start();
        this.mStartTimer = true;
    }

    public void startStatusBarAnimation(boolean showFlag) {
        this.mIsShowing = showFlag;
        if (this.mIsShowing) {
            this.mStatusBarTrans = new TranslateAnimation(1, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, 1, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, 1, -1.0f, 1, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET);
        } else {
            this.mStatusBarTrans = new TranslateAnimation(1, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, 1, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, 1, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, 1, -1.0f);
        }
        this.mStatusBarTrans.setInterpolator(AnimationUtils.loadInterpolator(MainApplication.mContext, R.anim.decelerate_interpolator));
        this.mStatusBarTrans.setDuration(500L);
        this.mStatusBarTrans.setAnimationListener(this.mStatusBarLinstener);
        this.mCallStatusbar.startAnimation(this.mStatusBarTrans);
    }

    public boolean isUsingAnimation() {
        return this.mIsUsingAnimation;
    }

    public boolean isShowing() {
        return this.mIsShowing;
    }

    public void showStatusBar() {
        if (getVisibility() != 0) {
            setVisibility(0);
        }
        this.mIsShowing = true;
    }

    public void hideStatusBar() {
        if (getVisibility() != 8) {
            setVisibility(8);
        }
        this.mIsShowing = false;
    }

    @Override // com.coolots.chaton.call.util.ITranslatorViewController
    public void addtHostTranslatePopup(TranslationDisplayData data, boolean OnlyIncomingMessage) {
    }

    @Override // com.coolots.chaton.call.util.ITranslatorViewController
    public void removeGuestTranslatePopup(TranslationDisplayData data) {
    }

    @Override // com.coolots.chaton.call.util.ITranslatorViewController
    public void visibleTranslatorIcon(String Id) {
    }

    @Override // com.coolots.chaton.call.util.ITranslatorViewController
    public void goneTranslatorIcon(String Id) {
    }

    @Override // com.coolots.chaton.call.util.ITranslatorViewController
    public void startDurationTranslatePopup(TranslationDisplayData data, boolean isGuest) {
        setTitleforTranslating();
    }

    @Override // com.coolots.chaton.call.util.ITranslatorViewController
    public void endDurationTranslatePopup(TranslationDisplayData data) {
        setInfo();
    }

    @Override // com.coolots.chaton.call.util.ITranslatorViewController
    public void setGuestName(String guestName) {
    }

    public void cancelAnimation() {
        this.mCallStatusbar.clearAnimation();
    }
}
