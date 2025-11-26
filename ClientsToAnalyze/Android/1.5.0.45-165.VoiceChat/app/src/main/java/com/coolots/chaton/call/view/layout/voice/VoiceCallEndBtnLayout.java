package com.coolots.chaton.call.view.layout.voice;

import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.coolots.chaton.C0000R;
import com.coolots.chaton.call.controller.AddBuddyController;
import com.coolots.chaton.call.controller.IAddBuddyController;
import com.coolots.chaton.call.view.ChatOnCallActivity;
import com.coolots.chaton.call.view.listener.SmallerHitTargetTouchListener;
import com.coolots.chaton.common.controller.VAppPhoneManager;
import com.coolots.chaton.common.util.BatteryInfo;
import com.coolots.chaton.common.util.ChatONMessage;
import com.coolots.chaton.common.util.ChatONStringConvert;
import com.coolots.chaton.common.util.ChatOnConfigInterface;
import com.coolots.chaton.common.util.ChatOnService;
import com.coolots.chaton.common.util.InformationActivityGenerator;
import com.coolots.chaton.setting.data.ChatONSettingData;
import com.coolots.p2pmsg.model.SimpleUserInfo;
import com.coolots.sso.EntitlementUIController;
import com.coolots.sso.IEntitlementUIController;
import com.sds.coolots.MainApplication;
import com.sds.coolots.call.model.Destination;
import com.sds.coolots.call.model.P2PUserInfo;
import com.sds.coolots.common.controller.PhoneManager;
import com.sds.coolots.common.util.Log;
import com.sds.coolots.common.view.DisposeInterface;
import com.sec.chaton.clientapi.GraphAPI;
import com.sec.chaton.clientapi.exception.IllegalArgumentClientAPIException;
import com.sec.chaton.clientapi.exception.NotActivatedClientAPIException;
import com.sec.chaton.clientapi.exception.NotAvailableClientAPIException;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
public class VoiceCallEndBtnLayout extends RelativeLayout implements IEntitlementUIController, View.OnClickListener, DisposeInterface, IAddBuddyController {
    private static final String CLASSNAME = "[VoiceCallEndBtnLayout]";
    private static final int MSG_NOT_CONNTECT_FLY = 1001;
    private static final int MSG_NOT_CONNTECT_NETWORK = 1000;
    private AddBuddyController mAddBuddyCtrl;
    public InformationActivityGenerator mAlert;
    private LinearLayout mBtnAddBuddy;
    private ImageView mBtnAddBuddyImage;
    private TextView mBtnAddBuddyText;
    private LinearLayout mBtnVideoCall;
    private TextView mBtnVideoCallText;
    private LinearLayout mBtnVoiceCall;
    private TextView mBtnVoiceCallText;
    private Destination mDestination;
    private EntitlementUIController mEntitlementUIController;
    private ChatOnCallActivity mParentActivity;
    private ViewGroup mRootGroupView;
    private final SmallerHitTargetTouchListener mTouchListener;

    private void logE(String message) {
        Log.m2958e(CLASSNAME + message);
    }

    private void logI(String message) {
        Log.m2963i(CLASSNAME + message);
    }

    public VoiceCallEndBtnLayout(Context context, ViewGroup r) {
        super(context);
        this.mTouchListener = new SmallerHitTargetTouchListener();
        int childViewCount = r.getChildCount();
        LayoutInflater inflater = (LayoutInflater) context.getSystemService("layout_inflater");
        this.mRootGroupView = (ViewGroup) inflater.inflate(C0000R.layout.voice_call_end_btn, r, true);
        this.mBtnVoiceCall = (LinearLayout) this.mRootGroupView.findViewById(C0000R.id.voice_call_btn);
        this.mBtnVoiceCallText = (TextView) this.mRootGroupView.findViewById(C0000R.id.voice_call_btn_text);
        this.mBtnVideoCall = (LinearLayout) this.mRootGroupView.findViewById(C0000R.id.video_call_btn);
        this.mBtnVideoCallText = (TextView) this.mRootGroupView.findViewById(C0000R.id.video_call_btn_text);
        this.mBtnAddBuddy = (LinearLayout) this.mRootGroupView.findViewById(C0000R.id.btn_add_buddy);
        this.mBtnAddBuddyImage = (ImageView) this.mRootGroupView.findViewById(C0000R.id.btn_add_buddy_img);
        this.mBtnAddBuddyText = (TextView) this.mRootGroupView.findViewById(C0000R.id.btn_add_buddy_text);
        this.mBtnVoiceCall.setOnClickListener(this);
        this.mBtnVideoCall.setOnClickListener(this);
        this.mBtnAddBuddy.setOnClickListener(this);
        this.mBtnVoiceCall.setOnTouchListener(this.mTouchListener);
        this.mBtnVideoCall.setOnTouchListener(this.mTouchListener);
        this.mRootGroupView.getChildAt(childViewCount).setTag(String.valueOf(getClass().toString()) + getConfiguration());
    }

    public ViewGroup getLayoutreference() {
        if (this.mRootGroupView != null) {
            return this.mRootGroupView;
        }
        return null;
    }

    public VoiceCallEndBtnLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mTouchListener = new SmallerHitTargetTouchListener();
        LayoutInflater inflater = LayoutInflater.from(context);
        inflater.inflate(C0000R.layout.voice_call_end_btn, (ViewGroup) this, true);
    }

    public VoiceCallEndBtnLayout(Context context, AttributeSet attrs, boolean callFromChild) {
        super(context, attrs);
        this.mTouchListener = new SmallerHitTargetTouchListener();
    }

    protected void onFinishInflate(boolean callFromChild) {
        super.onFinishInflate();
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        this.mBtnVoiceCall = (LinearLayout) findViewById(C0000R.id.voice_call_btn);
        this.mBtnVoiceCallText = (TextView) findViewById(C0000R.id.voice_call_btn_text);
        this.mBtnVideoCall = (LinearLayout) findViewById(C0000R.id.video_call_btn);
        this.mBtnVideoCallText = (TextView) findViewById(C0000R.id.video_call_btn_text);
        this.mBtnAddBuddy = (LinearLayout) findViewById(C0000R.id.btn_add_buddy);
        this.mBtnAddBuddyImage = (ImageView) findViewById(C0000R.id.btn_add_buddy_img);
        this.mBtnAddBuddyText = (TextView) findViewById(C0000R.id.btn_add_buddy_text);
        this.mBtnVoiceCall.setOnClickListener(this);
        this.mBtnVideoCall.setOnClickListener(this);
        this.mBtnAddBuddy.setOnClickListener(this);
        this.mBtnVoiceCall.setOnTouchListener(this.mTouchListener);
        this.mBtnVideoCall.setOnTouchListener(this.mTouchListener);
    }

    public void setData(Destination destination, ChatOnCallActivity parent, long userNo) {
        logI("setData()");
        this.mParentActivity = parent;
        this.mDestination = destination;
        setUI(this.mDestination);
    }

    private void setUI(Destination mDestination) {
        logI("setUI()");
        if (this.mAddBuddyCtrl == null) {
            this.mAddBuddyCtrl = new AddBuddyController(this.mParentActivity, this);
        }
        if (this.mParentActivity.isConference()) {
            this.mBtnAddBuddy.setVisibility(8);
            return;
        }
        if (MainApplication.mPhoneManager.IsLinkagewithChatON()) {
            if (hasUnKnownBuddy()) {
                this.mBtnAddBuddy.setVisibility(0);
                this.mBtnAddBuddyText.setText(getResources().getString(C0000R.string.call_menu_add_buddy));
                this.mBtnAddBuddyImage.setVisibility(0);
                return;
            } else {
                this.mBtnAddBuddy.setVisibility(0);
                this.mBtnAddBuddyText.setText(getResources().getString(C0000R.string.calllog_view_buddy_profile));
                this.mBtnAddBuddyImage.setVisibility(8);
                return;
            }
        }
        if (this.mAddBuddyCtrl.isIncludedNotFriend(this.mParentActivity.isConference(), mDestination.getConferenceMember(), mDestination.getP2PConferenceMember(), null, mDestination.getString(), this.mParentActivity.getCallOtherPartyUserInfo().userName)) {
            this.mBtnAddBuddy.setVisibility(0);
            this.mBtnAddBuddyText.setText(getResources().getString(C0000R.string.call_menu_add_buddy));
            this.mBtnAddBuddyImage.setVisibility(0);
        } else {
            this.mBtnAddBuddy.setVisibility(0);
            this.mBtnAddBuddyText.setText(getResources().getString(C0000R.string.calllog_view_buddy_profile));
            this.mBtnAddBuddyImage.setVisibility(8);
        }
    }

    private boolean hasUnKnownBuddy() {
        logI("hasUnKnownBuddy = 1 ");
        if (this.mParentActivity.isConference()) {
            ArrayList<SimpleUserInfo> simpleuserinfoList = this.mDestination.getConferenceMember();
            Iterator<SimpleUserInfo> it = simpleuserinfoList.iterator();
            while (it.hasNext()) {
                SimpleUserInfo simpleuserinfo = it.next();
                if (!isChatOnMember(simpleuserinfo.getUserID())) {
                    logI("hasUnKnownBuddy = " + simpleuserinfo.getUserID());
                    return true;
                }
            }
            return false;
        }
        logI("hasUnKnownBuddy = 2 " + this.mDestination.getString());
        if (isChatOnMember(this.mDestination.getString())) {
            return false;
        }
        logI("hasUnKnownBuddy = " + this.mDestination.getString());
        return true;
    }

    private ArrayList<String> getUnKnownBuddyList() {
        ArrayList<String> UnKnownBuddyList = new ArrayList<>();
        if (this.mParentActivity.isConference()) {
            ArrayList<SimpleUserInfo> simpleuserinfoList = this.mDestination.getConferenceMember();
            Iterator<SimpleUserInfo> it = simpleuserinfoList.iterator();
            while (it.hasNext()) {
                SimpleUserInfo simpleuserinfo = it.next();
                if (!isChatOnMember(simpleuserinfo.getUserID())) {
                    logI("getUnKnownBuddyList Account = " + simpleuserinfo.getUserID());
                    UnKnownBuddyList.add(simpleuserinfo.getUserID());
                }
            }
        } else if (!isChatOnMember(this.mDestination.getString())) {
            logI("getUnKnownBuddyList Account  = " + this.mDestination.getString());
            UnKnownBuddyList.add(this.mDestination.getString());
        }
        return UnKnownBuddyList;
    }

    private ArrayList<String> getUnKnownBuddyNameList() {
        ArrayList<String> UnKnownBuddyNameList = new ArrayList<>();
        if (this.mParentActivity.isConference()) {
            ArrayList<SimpleUserInfo> simpleuserinfoList = this.mDestination.getConferenceMember();
            Iterator<SimpleUserInfo> it = simpleuserinfoList.iterator();
            while (it.hasNext()) {
                SimpleUserInfo simpleuserinfo = it.next();
                if (!isChatOnMember(simpleuserinfo.getUserID())) {
                    logI("getUnKnownBuddyList Account = " + simpleuserinfo.getUserName());
                    UnKnownBuddyNameList.add(simpleuserinfo.getUserName());
                }
            }
        } else if (!isChatOnMember(this.mDestination.getString())) {
            logI("getUnKnownBuddyList Account  = " + this.mDestination.getString());
            logI("getUnKnownBuddyList Account  = " + this.mParentActivity.getCallOtherPartyUserInfo().userName);
            UnKnownBuddyNameList.add(this.mParentActivity.getCallOtherPartyUserInfo().userName);
        }
        return UnKnownBuddyNameList;
    }

    private boolean isChatOnMember(String AccountID) {
        ChatOnService chatonservice = ChatOnService.createService(MainApplication.mContext);
        String AccountId = ChatONStringConvert.getInstance().removeFooter(AccountID);
        return chatonservice != null && chatonservice.isChatOnBuddy(AccountId) == 4;
    }

    public void videoCallRetryButtonToggle(boolean toggle) {
        this.mBtnVideoCall.setEnabled(toggle);
    }

    private String addStringToTailWithComma(String destStr, String addStr) {
        return destStr.isEmpty() ? addStr : ", " + addStr;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        logI("onClick()");
        if (this.mAddBuddyCtrl == null) {
            this.mAddBuddyCtrl = new AddBuddyController(this.mParentActivity, this);
        }
        if (view.getId() == this.mBtnAddBuddy.getId()) {
            if (this.mBtnAddBuddyText.getText().toString().equals(getResources().getString(C0000R.string.calllog_view_buddy_profile))) {
                ChatOnService chatonservice = ChatOnService.createService(getContext());
                chatonservice.viewBuddyProfile(this.mDestination.getString());
                return;
            }
            ArrayList<String> UnKnownBuddyList = getUnKnownBuddyList();
            if (UnKnownBuddyList != null && !UnKnownBuddyList.isEmpty()) {
                Iterator<String> it = UnKnownBuddyList.iterator();
                while (it.hasNext()) {
                    String unknownbuddy = it.next();
                    logI("onClick() unknownbuddy = " + unknownbuddy);
                    try {
                        GraphAPI.addBuddyBackgroundById(MainApplication.mContext, 0L, ChatONStringConvert.getInstance().removeFooter(unknownbuddy));
                    } catch (IllegalArgumentClientAPIException e) {
                        e.printStackTrace();
                    } catch (NotActivatedClientAPIException e2) {
                        e2.printStackTrace();
                    } catch (NotAvailableClientAPIException e3) {
                        e3.printStackTrace();
                    }
                }
                Toast.makeText(this.mParentActivity, getResources().getString(C0000R.string.added), 0).show();
                return;
            }
            return;
        }
        if (this.mBtnVideoCall.isEnabled() || this.mBtnVoiceCall.isEnabled()) {
            this.mBtnVoiceCall.setEnabled(false);
            this.mBtnVideoCall.setEnabled(false);
            this.mBtnAddBuddy.setEnabled(false);
            int retryCallType = view.getId() == this.mBtnVideoCall.getId() ? 0 : -1;
            if (view.getId() == this.mBtnVoiceCall.getId()) {
                retryCallType = 1;
            }
            this.mAddBuddyCtrl.setRetryCallType(this.mParentActivity.isConference(), retryCallType);
            ArrayList<String> unKnownBuddyName = getUnKnownBuddyNameList();
            if (unKnownBuddyName.size() > 0) {
                this.mParentActivity.cancelDelayedQuit();
                String needToAddBuddyName = new String();
                Iterator<String> it2 = unKnownBuddyName.iterator();
                while (it2.hasNext()) {
                    String buddyname = it2.next();
                    needToAddBuddyName = String.valueOf(needToAddBuddyName) + addStringToTailWithComma(needToAddBuddyName, buddyname);
                }
                this.mAddBuddyCtrl.showAddBuddyAlertBuilder(needToAddBuddyName, getUnKnownBuddyList());
                return;
            }
            logI("my id: " + MainApplication.mConfig.getProfileUserID());
            int maxCnt = 0;
            if (retryCallType == 1) {
                maxCnt = ((ChatOnConfigInterface) MainApplication.mConfig).getConferenceCallMaxPeopleNum(false) - 1;
            } else if (retryCallType == 0) {
                maxCnt = ((ChatOnConfigInterface) MainApplication.mConfig).getConferenceCallMaxPeopleNum(true) - 1;
            }
            if (MainApplication.mPhoneManager.isConfTest()) {
                if (retryCallType == 1) {
                    maxCnt = ((ChatOnConfigInterface) MainApplication.mConfig).getConferenceCallMaxPeopleNum(false) - 1;
                } else if (retryCallType == 0) {
                    maxCnt = ((ChatOnConfigInterface) MainApplication.mConfig).getConferenceCallMaxPeopleNum(true) - 1;
                }
            }
            if (this.mDestination.getDestinationType() == 5) {
                Iterator it3 = this.mDestination.getP2PConferenceMember().iterator();
                while (it3.hasNext()) {
                    P2PUserInfo user = (P2PUserInfo) it3.next();
                    logI("user id " + user.userID);
                    if (user.userID.equals(MainApplication.mConfig.getProfileUserID())) {
                        logI("my account is added.");
                        maxCnt++;
                    }
                }
                logI("destination size: " + this.mDestination.getP2PConferenceMember().size() + " maxCnt: " + maxCnt);
                if (this.mDestination.getP2PConferenceMember().size() <= maxCnt) {
                    logI("retrycall");
                    this.mAddBuddyCtrl.retryCall();
                    return;
                } else {
                    logI("toast");
                    Toast.makeText(this.mParentActivity, getResources().getString(C0000R.string.unable_make_call_exceed_member), 0).show();
                    return;
                }
            }
            Iterator it4 = this.mDestination.getConferenceMember().iterator();
            while (it4.hasNext()) {
                SimpleUserInfo user2 = (SimpleUserInfo) it4.next();
                logI("user id " + user2.getUserID());
                if (user2.getUserID().equals(MainApplication.mConfig.getProfileUserID())) {
                    logI("my account is added.");
                    maxCnt++;
                }
            }
            logI("destination size: " + this.mDestination.getConferenceMember().size() + " maxCnt: " + maxCnt);
            if (this.mDestination.getConferenceMember().size() <= maxCnt) {
                logI("retrycall");
                this.mAddBuddyCtrl.retryCall();
            } else {
                logI("toast");
                Toast.makeText(this.mParentActivity, getResources().getString(C0000R.string.unable_make_call_exceed_member), 0).show();
            }
        }
    }

    @Override // com.coolots.chaton.call.controller.IAddBuddyController
    public void callActivityDelayedQuit() {
        logI("callActivityDelayedQuit()");
        this.mParentActivity.delayedQuit();
    }

    @Override // com.coolots.chaton.call.controller.IAddBuddyController
    public void callActivityQuit() {
        logI("callActivityQuit()");
        this.mParentActivity.handleImmediatelyQuit();
    }

    private void startEntitlementCheck(boolean isVideo) {
        logI("startEntitlementCheck " + isVideo);
        Bundle extras = new Bundle();
        extras.putBoolean("is_video", isVideo);
        if (this.mEntitlementUIController != null) {
            this.mEntitlementUIController.dispose();
            this.mEntitlementUIController = null;
        }
        this.mEntitlementUIController = new EntitlementUIController();
        this.mEntitlementUIController.setBundle(extras);
        this.mEntitlementUIController.start(this, true, isVideo, true);
    }

    @Override // com.coolots.chaton.call.controller.IAddBuddyController
    public void retryVideoCall() {
        if (this.mParentActivity != null) {
            logI("retryVideoCall()");
            if (canIRetryCall(true)) {
                startEntitlementCheck(true);
            }
        }
    }

    @Override // com.coolots.chaton.call.controller.IAddBuddyController
    public void retryVoiceCall() {
        if (this.mParentActivity != null) {
            logI("retryVoiceCall()");
            if (canIRetryCall(false)) {
                startEntitlementCheck(false);
            }
        }
    }

    @Override // com.coolots.chaton.call.controller.IAddBuddyController
    public void retryVideoConferenceCall() {
        if (this.mParentActivity != null) {
            logI("retryVideoConferenceCall()");
            if (canIRetryCall(true)) {
                startEntitlementCheck(true);
            }
        }
    }

    @Override // com.coolots.chaton.call.controller.IAddBuddyController
    public void retryVoiceConferenceCall() {
        if (this.mParentActivity != null) {
            logI("retryVoiceConferenceCall()");
            if (canIRetryCall(false)) {
                startEntitlementCheck(false);
            }
        }
    }

    @Deprecated
    public void retryChat() {
        if (this.mDestination != null) {
            ChatONMessage msg = new ChatONMessage();
            msg.sendMessageEndCall(this.mParentActivity, this.mDestination);
            this.mParentActivity.finish();
        }
    }

    private boolean canIRetryCall(boolean isUseVideo) {
        logI("canIRetryCall()");
        BatteryInfo batteryInfo = new BatteryInfo();
        if (isUseVideo && !batteryInfo.isCharging() && batteryInfo.isLowBattery()) {
            logI("Video Call Fail: Battery Low");
            Toast.makeText(this.mParentActivity, getResources().getText(C0000R.string.information_str_msg_10), 1000).show();
            this.mParentActivity.finish();
            return false;
        }
        if (VAppPhoneManager.checkAirPlainMode(MainApplication.mContext) && !PhoneManager.isWifiNetworkConnected(MainApplication.mContext)) {
            logI("Call Fail: Airplain Mode");
            this.mParentActivity.cancelDelayedQuit();
            this.mParentActivity.showConnectDialog(1001);
            return false;
        }
        if (!PhoneManager.isNetworkConnected(MainApplication.mContext)) {
            logI("Call Fail: Network Disconnected");
            this.mParentActivity.cancelDelayedQuit();
            this.mParentActivity.showConnectDialog(1000);
            return false;
        }
        if (ChatONSettingData.getInstance().isUseWifiOnly() && !PhoneManager.isWifiNetworkConnected(MainApplication.mContext)) {
            logI("Call Fail: Network Disconnected");
            this.mParentActivity.cancelDelayedQuit();
            this.mParentActivity.showConnectDialog(1000);
            return false;
        }
        return true;
    }

    public void updateBalance(String value, String unit) {
    }

    public boolean isAddGroupDialog() {
        if (this.mAddBuddyCtrl != null) {
            return this.mAddBuddyCtrl.isShowAddGroupDialog();
        }
        return false;
    }

    public String getNewAddGroup() {
        if (this.mAddBuddyCtrl == null) {
            return null;
        }
        logI("<<moon>> getNewAddGroup groupname : " + this.mAddBuddyCtrl.getGroupName());
        return this.mAddBuddyCtrl.getGroupName();
    }

    public void showDialogAddGroupName(String name) {
        logI("<<moon>> showDialogAddGroupName name : " + name);
        if (this.mAddBuddyCtrl == null) {
            this.mAddBuddyCtrl = new AddBuddyController(this.mParentActivity, this);
        }
        this.mAddBuddyCtrl.setRetryCallType(this.mParentActivity.isConference(), -1);
        ArrayList<String> unKnownBuddyName = getUnKnownBuddyNameList();
        if (unKnownBuddyName.size() > 0) {
            this.mParentActivity.cancelDelayedQuit();
            String needToAddBuddyName = new String();
            Iterator<String> it = unKnownBuddyName.iterator();
            while (it.hasNext()) {
                String buddyname = it.next();
                needToAddBuddyName = String.valueOf(needToAddBuddyName) + addStringToTailWithComma(needToAddBuddyName, buddyname);
            }
            this.mAddBuddyCtrl.showAddBuddyAlertBuilder(needToAddBuddyName, getUnKnownBuddyList());
        }
    }

    @Override // com.sds.coolots.common.view.DisposeInterface
    public void dispose() {
        logI("dispose()");
        if (this.mBtnVoiceCall != null) {
            this.mBtnVoiceCall = null;
        }
        if (this.mBtnVideoCall != null) {
            this.mBtnVideoCall = null;
        }
        if (this.mBtnVoiceCallText != null) {
            this.mBtnVoiceCallText = null;
        }
        if (this.mBtnVideoCallText != null) {
            this.mBtnVideoCallText = null;
        }
        if (this.mBtnAddBuddyImage != null) {
            this.mBtnAddBuddyImage = null;
        }
        if (this.mBtnAddBuddyText != null) {
            this.mBtnAddBuddyText = null;
        }
        if (this.mDestination != null) {
            this.mDestination = null;
        }
        if (this.mParentActivity != null) {
            this.mParentActivity = null;
        }
        if (this.mBtnAddBuddy != null) {
            this.mBtnAddBuddy = null;
        }
        if (this.mAddBuddyCtrl != null) {
            this.mAddBuddyCtrl.dispose();
            this.mAddBuddyCtrl = null;
        }
        removeAllViewsInLayout();
    }

    @Override // com.coolots.sso.IEntitlementUIController
    public void onStartCall() {
        logI("Call Success!!!!!");
        Bundle extras = this.mEntitlementUIController.getExtras();
        boolean isVideo = extras.getBoolean("is_video");
        this.mParentActivity.setRetryCall(isVideo);
        this.mParentActivity.showBgActivity(isVideo);
    }

    @Override // com.coolots.sso.IEntitlementUIController
    public void onEndProcess() {
        logI("onEndEntitlementProcess()");
        if (this.mEntitlementUIController != null) {
            this.mEntitlementUIController.dispose();
            this.mEntitlementUIController = null;
        }
    }

    private int getConfiguration() {
        return getResources().getConfiguration().orientation;
    }

    @Override // com.coolots.sso.IEntitlementUIController
    public void onFailToStartCall() {
        logI("Call Fail!!!!!");
    }
}
