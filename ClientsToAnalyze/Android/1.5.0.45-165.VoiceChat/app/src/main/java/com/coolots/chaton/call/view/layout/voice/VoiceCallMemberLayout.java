package com.coolots.chaton.call.view.layout.voice;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.coolots.chaton.C0000R;
import com.coolots.chaton.CoolotsChatOn;
import com.coolots.chaton.buddy.BuddyManagerInterface;
import com.coolots.chaton.buddy.model.BuddyTable;
import com.coolots.chaton.call.model.CallDisplayUserInfo;
import com.coolots.chaton.call.model.ConferenceCallDisplayUserInfo;
import com.coolots.chaton.call.util.ITranslatorViewController;
import com.coolots.chaton.call.view.VoiceCallActivity;
import com.coolots.chaton.call.view.layout.voice.VoiceCallMenuLayout;
import com.coolots.chaton.common.controller.VAppPhoneManager;
import com.coolots.chaton.common.util.ChatONStringConvert;
import com.coolots.chaton.common.util.ChatOnService;
import com.coolots.chaton.common.view.layout.InCallQuickPanel;
import com.sds.coolots.MainApplication;
import com.sds.coolots.call.model.CallState;
import com.sds.coolots.call.model.Destination;
import com.sds.coolots.common.controller.translation.data.TranslationDisplayData;
import com.sds.coolots.common.util.Log;
import com.sds.coolots.common.view.DisposeInterface;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

/* loaded from: classes.dex */
public class VoiceCallMemberLayout extends FrameLayout implements DisposeInterface, View.OnClickListener, VoiceCallMenuLayout.AnimationCallback, ITranslatorViewController {
    private static final int BLINK_DELAYED_CALL_END = 1;
    private static final String CLASSNAME = "[VoiceCallMemberLayout]";
    private static final int SET_MENU_BACKGROUND = 2;
    private int blinkTimes;
    private int mCallState;
    private Button mChatroomBtn;
    private FrameLayout mChatroomLayout;
    private Destination mDestination;
    private ImageView mDialingImageView;
    private LinearLayout mDialingTxtLayout;
    private boolean mDuringAnimation;
    private Chronometer mElapsedTime;
    private EndBtnHandler mEndHandler;
    private boolean mIsConference;
    private RelativeLayout mMemberInfoBackGround;
    private VoiceCallActivity mParentActivity;
    private ViewGroup mRootGroupView;
    private boolean mShowMenu;
    private TextView mUserName;
    private TextView mUserNumber;
    private RelativeLayout mUserNumberLayout;
    private RelativeLayout mWaitGroupCallLayout;
    private TextView mWaitGroupCallText;

    private void logE(String message) {
        Log.m2958e(CLASSNAME + message);
    }

    private void logI(String message) {
        Log.m2963i(CLASSNAME + message);
    }

    private class EndBtnHandler extends Handler implements DisposeInterface {
        private boolean bDisposed;

        private EndBtnHandler() {
            this.bDisposed = false;
        }

        /* synthetic */ EndBtnHandler(VoiceCallMemberLayout voiceCallMemberLayout, EndBtnHandler endBtnHandler) {
            this();
        }

        @Override // com.sds.coolots.common.view.DisposeInterface
        public void dispose() {
            this.bDisposed = true;
        }

        @Override // android.os.Handler
        public void handleMessage(Message msg) {
            if (!this.bDisposed) {
                if (msg.what == 1) {
                    VoiceCallActivity.setPublicBaseTime(0L);
                    Log.m2954d("<<KEONLEE>> handleMessage" + VoiceCallMemberLayout.this.blinkTimes);
                    try {
                        switch (VoiceCallMemberLayout.this.blinkTimes) {
                            case 0:
                                VoiceCallMemberLayout.this.mElapsedTime.setVisibility(0);
                                break;
                            case 1:
                                VoiceCallMemberLayout.this.mElapsedTime.setVisibility(4);
                                break;
                            case 2:
                                VoiceCallMemberLayout.this.mElapsedTime.setVisibility(0);
                                break;
                            case 3:
                                VoiceCallMemberLayout.this.mElapsedTime.setVisibility(4);
                                break;
                            case 4:
                                VoiceCallMemberLayout.this.mElapsedTime.setText(C0000R.string.clear_call);
                                VoiceCallMemberLayout.this.mElapsedTime.setVisibility(0);
                                break;
                        }
                        VoiceCallMemberLayout.this.blinkTimes++;
                        if (VoiceCallMemberLayout.this.blinkTimes <= 4) {
                            VoiceCallMemberLayout.this.mEndHandler.removeMessages(1);
                            VoiceCallMemberLayout.this.mEndHandler.sendEmptyMessageDelayed(1, 500L);
                        } else if (VoiceCallMemberLayout.this.blinkTimes > 4) {
                            VoiceCallMemberLayout.this.mEndHandler.removeMessages(1);
                        }
                    } catch (Exception e) {
                        VoiceCallMemberLayout.this.mEndHandler.removeMessages(1);
                    }
                } else {
                    int i = msg.what;
                }
                super.handleMessage(msg);
            }
        }
    }

    public VoiceCallMemberLayout(Context context, ViewGroup r) {
        super(context);
        this.mDuringAnimation = false;
        this.mShowMenu = false;
        this.mIsConference = false;
        int childViewCount = r.getChildCount();
        setEndHandler();
        LayoutInflater inflater = (LayoutInflater) context.getSystemService("layout_inflater");
        this.mRootGroupView = (ViewGroup) inflater.inflate(C0000R.layout.voice_call_member, r, true);
        this.mElapsedTime = (Chronometer) this.mRootGroupView.findViewById(C0000R.id.elapsedTime);
        this.mDialingTxtLayout = (LinearLayout) this.mRootGroupView.findViewById(C0000R.id.voiceCallDialing);
        this.mDialingImageView = (ImageView) this.mRootGroupView.findViewById(C0000R.id.voice_call_dialing_image);
        this.mUserName = (TextView) this.mRootGroupView.findViewById(C0000R.id.voice_call_membername);
        this.mUserNumber = (TextView) this.mRootGroupView.findViewById(C0000R.id.voice_call_membernumber);
        this.mMemberInfoBackGround = (RelativeLayout) this.mRootGroupView.findViewById(C0000R.id.voice_call_member_info_bg);
        this.mChatroomBtn = (Button) this.mRootGroupView.findViewById(C0000R.id.option_chat_btn);
        this.mChatroomLayout = (FrameLayout) this.mRootGroupView.findViewById(C0000R.id.chat_btn_layout);
        this.mUserNumberLayout = (RelativeLayout) this.mRootGroupView.findViewById(C0000R.id.voice_call_membernumber_layout);
        this.mWaitGroupCallLayout = (RelativeLayout) this.mRootGroupView.findViewById(C0000R.id.voice_call_wait_group_call_layout);
        this.mWaitGroupCallText = (TextView) this.mRootGroupView.findViewById(C0000R.id.voice_call_wait_group_call);
        this.mChatroomBtn.setOnClickListener(this);
        this.mMemberInfoBackGround.setOnClickListener(this);
        this.mRootGroupView.getChildAt(childViewCount).setTag(String.valueOf(getClass().toString()) + getConfiguration());
    }

    public ViewGroup getLayoutreference() {
        if (this.mRootGroupView != null) {
            return this.mRootGroupView;
        }
        return null;
    }

    public VoiceCallMemberLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mDuringAnimation = false;
        this.mShowMenu = false;
        this.mIsConference = false;
        setEndHandler();
        LayoutInflater inflater = LayoutInflater.from(context);
        inflater.inflate(C0000R.layout.voice_call_member, (ViewGroup) this, true);
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        this.mElapsedTime = (Chronometer) findViewById(C0000R.id.elapsedTime);
        this.mDialingTxtLayout = (LinearLayout) findViewById(C0000R.id.voiceCallDialing);
        this.mDialingImageView = (ImageView) findViewById(C0000R.id.voice_call_dialing_image);
        this.mUserName = (TextView) findViewById(C0000R.id.voice_call_membername);
        this.mUserNumber = (TextView) findViewById(C0000R.id.voice_call_membernumber);
        this.mMemberInfoBackGround = (RelativeLayout) findViewById(C0000R.id.voice_call_member_info_bg);
        this.mChatroomBtn = (Button) findViewById(C0000R.id.option_chat_btn);
        this.mChatroomLayout = (FrameLayout) findViewById(C0000R.id.chat_btn_layout);
        this.mUserNumberLayout = (RelativeLayout) findViewById(C0000R.id.voice_call_membernumber_layout);
        this.mWaitGroupCallLayout = (RelativeLayout) findViewById(C0000R.id.voice_call_wait_group_call_layout);
        this.mWaitGroupCallText = (TextView) findViewById(C0000R.id.voice_call_wait_group_call);
        this.mChatroomBtn.setOnClickListener(this);
        this.mMemberInfoBackGround.setOnClickListener(this);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean arg0, int arg1, int arg2, int arg3, int arg4) {
        logE("<<kyj>> VoiceCallMemberLayout() => onLayout");
        int count = getChildCount();
        for (int i = 0; i < count; i++) {
            View child = getChildAt(i);
            if (child.getVisibility() != 8) {
                int childLeft = getPaddingLeft();
                int childTop = getPaddingTop();
                child.layout(childLeft, childTop, child.getMeasuredWidth() + childLeft, child.getMeasuredHeight() + childTop);
            }
        }
        logE("<<kyj>> VoiceCallMemberLayout() => onLayout2");
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        logE("<<kyj>> VoiceCallMemberLayout() => onMeasure");
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
        logE("<<kyj>> VoiceCallMemberLayout() => onMeasure2");
    }

    public void clickableStatusBarFuctionBtn() {
        this.mChatroomBtn.setClickable(true);
    }

    public void unClickableStatusBarFuctionBtn() {
        this.mChatroomBtn.setClickable(false);
    }

    public final void setEndHandler() {
        if (this.mEndHandler == null) {
            this.mEndHandler = new EndBtnHandler(this, null);
        }
    }

    public void setMenuBackgroudVisibility() {
        this.mEndHandler.sendEmptyMessageDelayed(2, 600L);
    }

    public void setParent(VoiceCallActivity parent) {
        this.mParentActivity = parent;
    }

    public void setVoiceOptionMenu(int menuId) {
        showMenu();
        this.mParentActivity.setOptionMenu(menuId);
    }

    public boolean setBluetoothIsDisconnected() {
        return this.mParentActivity.getAudioPathController().isBlueToothOn();
    }

    private boolean isDeviceLandscape() {
        int rotation = this.mParentActivity.getWindowManager().getDefaultDisplay().getRotation();
        if (rotation != 1 && rotation != 3) {
            return false;
        }
        return true;
    }

    public void setUIState(boolean isOutGoingCall, int callState, int destType, int networkState) {
        if (CallState.isNotConnected(callState)) {
            this.mWaitGroupCallLayout.setVisibility(8);
            this.mUserNumberLayout.setVisibility(0);
            setEndHandler();
            this.mCallState = 1;
            this.mEndHandler.removeMessages(1);
            this.blinkTimes = 0;
            this.mElapsedTime.setVisibility(8);
            this.mDialingTxtLayout.setVisibility(0);
            this.mDialingImageView.setBackgroundResource(C0000R.anim.dialing_image_change_effect);
            AnimationDrawable frameAnimation = (AnimationDrawable) this.mDialingImageView.getBackground();
            frameAnimation.start();
            this.mElapsedTime.setText(C0000R.string.call_info_outgoing_voice_call);
            this.mUserName.setTextColor(getResources().getColor(C0000R.color.chaton_color_002_light));
            this.mUserNumber.setTextColor(getResources().getColor(C0000R.color.chaton_color_008_light));
            this.mMemberInfoBackGround.setBackgroundResource(C0000R.drawable.action_bar_bg_01);
            this.mChatroomLayout.setVisibility(8);
            return;
        }
        if (CallState.isConnected(callState)) {
            this.mDialingTxtLayout.setVisibility(8);
            this.mElapsedTime.setVisibility(0);
            if (this.mParentActivity.getCallFunctionController().getCallSwitchingProcessing() == 1) {
                logI("CALL_SWITCH Backup Call Time Setting");
                setLayoutCallBaseTime(this.mParentActivity.getLayoutCallBaseTime(), callState);
            } else {
                setLayoutCallBaseTime(this.mParentActivity.getLayoutCallBaseTime(), callState);
            }
            this.mUserName.setTextColor(getResources().getColor(C0000R.color.tw_color001));
            this.mUserNumber.setTextColor(getResources().getColor(C0000R.color.call_status_bar_status_msg));
            this.mMemberInfoBackGround.setBackgroundResource(C0000R.drawable.action_bar_bg_02);
            this.mChatroomLayout.setVisibility(0);
            initChatLayout();
            return;
        }
        if (CallState.isDisconnected(callState)) {
            this.mWaitGroupCallLayout.setVisibility(8);
            this.mUserNumberLayout.setVisibility(0);
            this.mElapsedTime.setVisibility(8);
            this.mDialingTxtLayout.setVisibility(8);
            logI("setUIState mStartTimer: " + this.mCallState);
            if (this.mCallState != 2 && this.mParentActivity.mCallStatusData.isActiveShareScreen() == 2 && MainApplication.mPhoneManager.getPhoneStateMachine().getHangupCode() != 0) {
                Date d = ((VAppPhoneManager) MainApplication.mPhoneManager).getPhoneStateMachine().getCallFirstStartTime();
                new Date();
                logI("setUIState time: " + (SystemClock.elapsedRealtime() - (this.mParentActivity.getNowDateSetting() - d.getTime())));
                this.mElapsedTime.setBase(this.mParentActivity.getLayoutCallBaseTime().longValue());
                this.mElapsedTime.stop();
                this.mCallState = 3;
                this.mEndHandler.sendEmptyMessage(1);
            }
            if (this.mCallState == 1) {
                this.mElapsedTime.setText(C0000R.string.clear_call);
                this.mEndHandler.sendEmptyMessage(1);
            } else if (this.mCallState == 2 || this.mCallState == 0) {
                this.mElapsedTime.stop();
                this.mCallState = 3;
                this.mEndHandler.sendEmptyMessage(1);
            }
            this.mUserName.setTextColor(getResources().getColor(C0000R.color.tw_color001));
            this.mUserNumber.setTextColor(getResources().getColor(C0000R.color.call_status_bar_status_msg));
            this.mMemberInfoBackGround.setBackgroundResource(C0000R.drawable.action_bar_bg_03);
            this.mChatroomLayout.setVisibility(8);
        }
    }

    private void initChatLayout() {
        if (MainApplication.mPhoneManager.IsLinkagewithChatON()) {
            ChatOnService chatonservice = ChatOnService.createService(getContext());
            if (this.mParentActivity.isConference()) {
                boolean isChatOnMember = false;
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
                if (isChatOnMember) {
                    this.mChatroomLayout.setVisibility(0);
                    return;
                } else {
                    this.mChatroomLayout.setVisibility(8);
                    return;
                }
            }
            String AccountId2 = ChatONStringConvert.getInstance().removeFooter(this.mDestination.getString());
            if (chatonservice != null && chatonservice.isChatOnBuddy(AccountId2) == 4) {
                this.mChatroomLayout.setVisibility(0);
                return;
            } else {
                this.mChatroomLayout.setVisibility(8);
                return;
            }
        }
        this.mChatroomLayout.setVisibility(8);
    }

    public void setMember(Destination destination, boolean isOutGoingCall, CallDisplayUserInfo calluserInfo) {
        this.mDestination = destination;
        setMemberInfo(calluserInfo);
        this.mUserName.setSelected(true);
    }

    private void setMemberInfo(CallDisplayUserInfo calluserInfo) {
        String groupName;
        switch (this.mDestination.getDestinationType()) {
            case 2:
                if (getChangeConferenceCall() && CallState.isConnected(this.mParentActivity.mCallStatusData.getCallState())) {
                    this.mUserNumberLayout.setVisibility(8);
                    this.mWaitGroupCallLayout.setVisibility(0);
                    this.mWaitGroupCallText.setText(C0000R.string.change_to_conference_start);
                    break;
                } else {
                    this.mWaitGroupCallLayout.setVisibility(8);
                    this.mUserNumberLayout.setVisibility(0);
                    this.mUserName.setText(calluserInfo.userName);
                    this.mUserNumber.setText(C0000R.string.calling_button_receive);
                    break;
                }
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
            case 5:
                if (this.mParentActivity.getConferenceWaitCount() > 0 && this.mParentActivity.getConferenceConnectCount() != 0 && this.mParentActivity.getConferenceConnectCount() < 2 && CallState.isConnected(this.mParentActivity.mCallStatusData.getCallState())) {
                    ConferenceCallDisplayUserInfo userInfo = this.mParentActivity.getConferenceMemberName();
                    this.mUserNumberLayout.setVisibility(8);
                    this.mWaitGroupCallLayout.setVisibility(0);
                    this.mUserName.setText(userInfo.userName);
                    this.mWaitGroupCallText.setText(C0000R.string.call_inviting_participants);
                    break;
                } else {
                    this.mWaitGroupCallLayout.setVisibility(8);
                    this.mUserNumberLayout.setVisibility(0);
                    long groupID = this.mParentActivity.getGroupIDByUserInfo();
                    ConferenceCallDisplayUserInfo userInfo2 = this.mParentActivity.getConferenceMemberName();
                    if (userInfo2 == null) {
                        this.mUserNumber.setText(C0000R.string.call_info_voice_group_title);
                        this.mUserName.setText(C0000R.string.wait_for_other_members_to_join);
                        break;
                    } else {
                        if (groupID == 0) {
                            if (MainApplication.mPhoneManager.IsLinkagewithChatON() && (groupName = this.mParentActivity.getDestination().getGroupName()) != null && !groupName.isEmpty()) {
                                this.mUserName.setText(groupName);
                            } else {
                                this.mUserName.setText(userInfo2.userName);
                            }
                        } else {
                            BuddyManagerInterface buddyManager = ((VAppPhoneManager) MainApplication.mPhoneManager).getChatOnContactManager();
                            this.mUserName.setText(buddyManager.getGroupNameByGroupID(groupID));
                        }
                        StringBuffer userCnt = new StringBuffer(getResources().getString(C0000R.string.call_info_outgoing_video_group_title));
                        userCnt.append(" (" + (this.mDestination.getConferenceMemberCountWithMe() - this.mParentActivity.getConferenceWaitCount()) + ")");
                        this.mUserNumber.setText(userCnt.toString());
                        break;
                    }
                }
                break;
        }
    }

    public void setChangeConferenceCall(boolean isChangeConference) {
        this.mIsConference = isChangeConference;
    }

    public boolean getChangeConferenceCall() {
        return this.mIsConference;
    }

    public Long getLayoutCallBaseTime() {
        return Long.valueOf(this.mElapsedTime.getBase());
    }

    public void setLayoutCallBaseTime(Long baseTime, int callState) {
        if (!CallState.isNotConnected(callState)) {
            if (CallState.isDisconnected(callState)) {
                this.mCallState = 3;
                this.mElapsedTime.setBase(baseTime.longValue());
                VoiceCallActivity.setPublicBaseTime(baseTime);
                this.blinkTimes = 0;
                this.mEndHandler.sendEmptyMessage(1);
                return;
            }
            if (this.mCallState == 0) {
                this.mElapsedTime.setBase(this.mParentActivity.getLayoutCallBaseTime().longValue());
                this.mElapsedTime.start();
            } else if (this.mCallState != 2 && this.mCallState != 5) {
                this.mElapsedTime.setBase(baseTime.longValue());
                this.mElapsedTime.start();
                this.mCallState = 2;
                VoiceCallActivity.setPublicBaseTime(baseTime);
                InCallQuickPanel.callBaseTime = baseTime.longValue();
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == this.mMemberInfoBackGround.getId()) {
            this.mParentActivity.closeOptionsMenu();
            this.mParentActivity.InviteViewCheck();
        } else if (view.getId() == this.mChatroomBtn.getId()) {
            this.mParentActivity.openChatService();
        }
    }

    public void showMenu() {
        if (!this.mDuringAnimation) {
            if (!this.mShowMenu) {
                logI("<<YHT2>> START SHOW MENU!! STEP 1");
            }
            logI("<<YHT2>> START SHOW MENU!! STEP 3");
            this.mDuringAnimation = true;
        }
    }

    public boolean isMenuOpen() {
        return this.mShowMenu;
    }

    public void changeMenuButton(boolean show) {
    }

    public void updatetMenuStatus(boolean show) {
        if (show) {
            this.mShowMenu = false;
            showMenu();
        }
    }

    public void setMenuOpen(boolean value) {
        this.mShowMenu = value;
    }

    public void setBTButtonStatus(boolean btOn) {
        setBtButtonEnable(true);
    }

    public void setBtButtonEnable(boolean btEnable) {
    }

    @Override // com.sds.coolots.common.view.DisposeInterface
    public void dispose() {
        if (this.mDestination != null) {
            this.mDestination = null;
        }
        if (this.mElapsedTime != null) {
            this.mElapsedTime = null;
        }
        if (this.mParentActivity != null) {
            this.mParentActivity = null;
        }
        if (this.mUserName != null) {
            this.mUserName = null;
        }
        if (this.mUserNumber != null) {
            this.mUserNumber = null;
        }
        if (this.mEndHandler != null) {
            this.mEndHandler.dispose();
            this.mEndHandler = null;
        }
        if (this.mMemberInfoBackGround != null) {
            this.mMemberInfoBackGround = null;
        }
        if (this.mWaitGroupCallText != null) {
            this.mWaitGroupCallText = null;
        }
        if (this.mUserNumberLayout != null) {
            this.mUserNumberLayout = null;
        }
        if (this.mWaitGroupCallLayout != null) {
            this.mWaitGroupCallLayout = null;
        }
        removeAllViewsInLayout();
    }

    @Override // com.coolots.chaton.call.view.layout.voice.VoiceCallMenuLayout.AnimationCallback
    public void onShowMenuAnimationFinish() {
    }

    @Override // com.coolots.chaton.call.view.layout.voice.VoiceCallMenuLayout.AnimationCallback
    public void onHideMenuAnimationFinish() {
    }

    public void setMenuButtonEnable(boolean enable) {
    }

    public void setTitleBarTextToWaitForOtherMembers(boolean isConnectorZero) {
        String userNames = this.mUserName.getText().toString();
        if (isConnectorZero) {
            this.mUserName.setText(C0000R.string.wait_for_other_members_to_join);
        } else {
            this.mUserName.setText(userNames);
        }
    }

    private int getConfiguration() {
        return getResources().getConfiguration().orientation;
    }

    private void setTitleforTranslating() {
        this.mUserNumber.setText(C0000R.string.translator_change_tts_translating);
    }

    private void setInfo() {
        this.mUserNumber.setText(C0000R.string.calling_button_receive);
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
}
