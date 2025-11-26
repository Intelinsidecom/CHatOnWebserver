package com.coolots.chaton.call.controller;

import android.content.Intent;
import android.media.SoundPool;
import android.os.Handler;
import android.os.Message;
import android.os.Vibrator;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ListAdapter;
import com.coolots.chaton.C0000R;
import com.coolots.chaton.buddy.BuddyManagerInterface;
import com.coolots.chaton.buddy.model.BuddyListChildItem;
import com.coolots.chaton.call.model.CallDisplayUserInfo;
import com.coolots.chaton.call.model.CallUserAddedInfo;
import com.coolots.chaton.call.model.InviteViewBuddyItem;
import com.coolots.chaton.call.model.InviteViewBuddyList;
import com.coolots.chaton.call.util.DestinationUtil;
import com.coolots.chaton.call.view.ChatOnCallActivity;
import com.coolots.chaton.common.controller.VAppPhoneManager;
import com.coolots.chaton.common.util.ChatOnConfigInterface;
import com.coolots.p2pmsg.model.SimpleUserInfo;
import com.sds.coolots.MainApplication;
import com.sds.coolots.call.PhoneStateMachine;
import com.sds.coolots.call.model.CallState;
import com.sds.coolots.call.model.ConferenceMember;
import com.sds.coolots.call.model.Destination;
import com.sds.coolots.call.model.P2PUserInfo;
import com.sds.coolots.common.util.Log;
import com.sds.coolots.common.view.DisposeInterface;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public class InviteViewController implements DisposeInterface {
    private static final String CLASSNAME = "[InviteViewController]";
    public static final int GROUP_VIDEO_CALL_TYPE = 1;
    public static final int GROUP_VOICE_CALL_TYPE = 0;
    public static final int INVITEVIEW_DELAY_TIME = 3000;
    public static final int INVITEVIEW_REMOVE_FROM_LIST = 11;
    public static final int INVITEVIEW_REMOVE_NOTI_TO_SERVER = 10;
    private static final int VIBRATOR_LENGTH_MILLIS = 500;
    private static SoundPool soundPool;
    private ChatOnCallActivity mActivity;
    private InviteViewBuddyList mBuddyList;
    private IInviteViewController mIInviteViewController;
    private GridView mInviteBuddyListView;
    private InviteViewAdapter mInviteViewAdaptor;
    private ViewGroup mInviteViewLayout;
    private int soundLoad;
    private boolean mIsActive = false;
    private boolean mIsInviteWaiting = false;
    private boolean mIsRequester = false;
    private InviteViewHandler mInviteViewHandler = null;
    private BuddyManagerInterface mBuddyManager = ((VAppPhoneManager) MainApplication.mPhoneManager).getChatOnContactManager();
    private Vibrator vibrator = null;

    private void logI(String message) {
        Log.m2963i(CLASSNAME + message);
    }

    private void logE(String message) {
        Log.m2963i(CLASSNAME + message);
    }

    public InviteViewController(ChatOnCallActivity activity, IInviteViewController interfaceController, ViewGroup inviteViewLayout, GridView inviteBuddyListView) {
        this.mBuddyList = null;
        this.mInviteViewLayout = null;
        this.mInviteBuddyListView = null;
        this.mActivity = activity;
        this.mIInviteViewController = interfaceController;
        this.mBuddyList = null;
        this.mInviteViewLayout = inviteViewLayout;
        this.mInviteBuddyListView = inviteBuddyListView;
    }

    public void startInviteView() {
        logI("startInviteView()");
        start();
        this.mActivity.setInviteProcessing(!checkAllConnected());
        initInviteBuddyListView();
        this.mInviteViewLayout.setVisibility(0);
    }

    private void start() {
        logI("start()");
        this.mIsActive = true;
        this.mIsInviteWaiting = false;
        if (this.mBuddyList == null) {
            this.mBuddyList = new InviteViewBuddyList();
        }
    }

    private void initInviteBuddyListView() {
        if (this.mIsActive) {
            logI("initInviteBuddyListView()");
            if (this.mInviteViewHandler == null) {
                this.mInviteViewHandler = new InviteViewHandler(this, null);
            }
            this.mInviteViewAdaptor = new InviteViewAdapter(this.mActivity.getApplicationContext(), this.mInviteViewHandler, getBuddyList(), this.mActivity.isOutGoingCall());
            this.mInviteBuddyListView.setAdapter((ListAdapter) this.mInviteViewAdaptor);
            getBuddyList().description();
        }
    }

    public void endInviteView() {
        logI("endInviteView()");
        if (this.mIsActive) {
            if (this.mInviteViewHandler != null) {
                this.mInviteViewHandler.removeMessages(10);
                this.mInviteViewHandler.removeMessages(11);
                this.mInviteViewHandler.dispose();
                this.mInviteViewHandler = null;
            }
            if (this.mInviteBuddyListView != null) {
                this.mInviteBuddyListView.setAdapter((ListAdapter) null);
            }
            this.mInviteViewAdaptor = null;
            stop();
            this.mActivity.setInviteProcessing(false);
            this.mInviteViewLayout.setVisibility(8);
        }
    }

    public void stop() {
        logI("stop()");
        this.mIsActive = false;
        this.mIsInviteWaiting = false;
        this.mIsRequester = false;
        if (this.mBuddyList != null) {
            this.mBuddyList.removeAllBuddies();
            this.mBuddyList = null;
        }
    }

    private class InviteViewHandler extends Handler implements DisposeInterface {
        private boolean isDispose;

        private InviteViewHandler() {
            this.isDispose = false;
        }

        /* synthetic */ InviteViewHandler(InviteViewController inviteViewController, InviteViewHandler inviteViewHandler) {
            this();
        }

        @Override // android.os.Handler
        public synchronized void handleMessage(Message msg) {
            if (!this.isDispose) {
                InviteViewController.this.handleInviteMessage(msg);
                super.handleMessage(msg);
            }
        }

        @Override // com.sds.coolots.common.view.DisposeInterface
        public void dispose() {
            this.isDispose = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleInviteMessage(Message msg) {
        if (this.mIsActive) {
            switch (msg.what) {
                case 10:
                    logI("Invite Buddies Handler >> noti to server (position: " + msg.arg1 + ")");
                    InviteViewBuddyItem buddyItem = getBuddyList().getBuddy(msg.arg1);
                    if (buddyItem != null) {
                        this.mActivity.removeConferenceMember(getBuddyList().getBuddy(msg.arg1).getUserID());
                        getBuddyList().removeBuddy(msg.arg1);
                        break;
                    }
                    break;
                case 11:
                    logI("Invite Buddies Handler >> remove member from list (position: " + msg.arg1 + ")");
                    getBuddyList().removeBuddy(msg.arg1);
                    break;
            }
            if (getBuddyList().getBuddiesCount() == 0) {
                endInviteView();
                this.mIInviteViewController.updateLayoutNoInvite();
            } else {
                this.mInviteViewAdaptor.notifyDataSetChanged();
            }
        }
    }

    public void preprocessInviteView(Intent data, DestinationUtil destinationUtil, Destination destination, CallUserAddedInfo userAddedInfo, CallDisplayUserInfo callUserInfo) {
        logI("preprocessInviteView(intent)");
        ArrayList<BuddyListChildItem> selectedList = (ArrayList) data.getExtras().getSerializable("selected_list");
        preprocessInviteView(selectedList, destinationUtil, destination, userAddedInfo, callUserInfo);
    }

    public void preprocessInviteView(ArrayList<BuddyListChildItem> selectedList, DestinationUtil destinationUtil, Destination destination, CallUserAddedInfo userAddedInfo, CallDisplayUserInfo callUserInfo) {
        logI("preprocessInviteView(arrayList)");
        if (selectedList == null || selectedList.isEmpty()) {
            this.mActivity.showToast(C0000R.string.invite_view_no_add_member);
            return;
        }
        this.mIInviteViewController.disableButtonDuringInviteView();
        ArrayList<String> inviteListBackup = new ArrayList<>();
        for (InviteViewBuddyItem item : getBuddyList().getBuddyList()) {
            if (item.getUserCallState() == 1) {
                inviteListBackup.add(item.getUserID());
            }
        }
        logI("backup invite list: " + inviteListBackup);
        endInviteView();
        getBuddyList().addBuddy(destination, userAddedInfo, callUserInfo);
        ArrayList<ConferenceMember> memberList = trans2ConferenceMemberList(selectedList);
        getBuddyList().addBuddy(memberList);
        this.mIInviteViewController.showProgressBarInviteView();
        ArrayList<ConferenceMember> addMemberList = destinationUtil.getMemberForAddConference(destination, inviteListBackup, memberList);
        ArrayList<ConferenceMember> removeMemberList = destinationUtil.getMemberForRemoveConference(destination, inviteListBackup, memberList);
        if (addMemberList != null && removeMemberList != null) {
            sendConferenceMemberToServer(addMemberList, removeMemberList);
        }
        this.mIsRequester = true;
        startInviteView();
    }

    private ArrayList<ConferenceMember> trans2ConferenceMemberList(ArrayList<BuddyListChildItem> buddyList) {
        ArrayList<ConferenceMember> conferenceList = new ArrayList<>();
        String phoneNo = null;
        Iterator<BuddyListChildItem> it = buddyList.iterator();
        while (it.hasNext()) {
            BuddyListChildItem item = it.next();
            if (!MainApplication.mPhoneManager.IsLinkagewithChatON()) {
                ArrayList<String> phoneNoList = this.mBuddyManager.getPhoneNoArrayListByUserID(item.getBuddyId());
                if (phoneNoList != null && !phoneNoList.isEmpty()) {
                    String phoneNo2 = phoneNoList.get(0);
                    phoneNo = phoneNo2;
                }
                if (phoneNo == null || phoneNo.isEmpty()) {
                    phoneNo = "";
                }
            }
            conferenceList.add(new ConferenceMember(item.getBuddyId(), item.getBuddyName(), phoneNo));
            logI("trans2ConferenceMemberList() add member: " + item.getBuddyId());
        }
        return conferenceList;
    }

    public void preprocessInviteView(DestinationUtil destinationUtil, Destination destination, CallUserAddedInfo userAddedInfo, CallDisplayUserInfo callUserInfo) {
        ArrayList<ConferenceMember> memberList = destinationUtil.getConferenceWaitMemberList(destination);
        ArrayList<String> connectedMemberList = destinationUtil.getConferenceConnectUserIDList(destination, userAddedInfo);
        if (!memberList.isEmpty() || !connectedMemberList.isEmpty()) {
            logI("preprocessInviteView()");
            this.mIInviteViewController.disableButtonDuringInviteView();
            endInviteView();
            if (!connectedMemberList.isEmpty()) {
                getBuddyList().addBuddy(destination, userAddedInfo, callUserInfo);
            }
            if (!memberList.isEmpty()) {
                getBuddyList().addBuddy(memberList);
            }
            startInviteView();
        }
    }

    public synchronized void checkInviteView(int callState, boolean isConference, boolean isOutGoingCall, DestinationUtil destinationUtil, Destination destination, CallUserAddedInfo userAddedInfo, CallDisplayUserInfo callUserInfo) {
        if (CallState.isConnected(callState) || CallState.isNotConnected(callState)) {
            if (this.mInviteViewHandler != null && this.mInviteViewHandler.hasMessages(11)) {
                logI("checkInviteView() not handled message");
                Message msg = this.mInviteViewHandler.obtainMessage(11);
                this.mInviteViewHandler.removeMessages(11);
                handleInviteMessage(msg);
            }
            logI("checkInviteView() mIsActive: " + this.mIsActive);
            if (this.mIsActive) {
                if (getBuddyList().getBuddyList() == null || getBuddyList().getBuddiesCount() == 0) {
                    endInviteView();
                    checkWaitMemberForInviteView(callState, isConference, isOutGoingCall, destinationUtil, destination, false, userAddedInfo, callUserInfo);
                } else if (destination.getDestinationType() == 5) {
                    Iterator it = destination.getP2PConferenceMember().iterator();
                    while (it.hasNext()) {
                        P2PUserInfo userInfo = (P2PUserInfo) it.next();
                        logI("userID: " + userInfo.userID + " state: " + userInfo.userState);
                        int position = getBuddyList().isContainBuddy(userInfo.userID);
                        if (position > 0) {
                            int position2 = position - 1;
                            int state = userInfo.userState;
                            if (state >= 4 || 2 == userInfo.userState || 3 == userInfo.userState) {
                                logI("checkInviteView() state: deny or disconnected, userID: " + userInfo.userID);
                                getBuddyList().getBuddy(position2).setCallState(2);
                                Message msg2 = new Message();
                                msg2.what = 11;
                                msg2.arg1 = position2;
                                this.mInviteViewHandler.sendMessageDelayed(msg2, 3000L);
                            } else if (1 == userInfo.userState) {
                                logI("checkInviteView() state: connected, userID: " + userInfo.userID);
                                if (CallState.isConnected(this.mActivity.mCallStatusData.getCallState()) && 1 == userInfo.userState && getBuddyList().getBuddy(position2).getCallState() != 3) {
                                    soundPool = new SoundPool(1, 4, 0);
                                    this.soundLoad = soundPool.load(this.mActivity, C0000R.raw.call_connect, 1);
                                    soundPool.play(this.soundLoad, 1.0f, 1.0f, 1, 0, 1.0f);
                                }
                                getBuddyList().getBuddy(position2).setCallState(3);
                            } else {
                                getBuddyList().getBuddy(position2).setCallState(1);
                            }
                        } else if (userInfo.userState == 0) {
                            getBuddyList().addBuddy(new ConferenceMember(userInfo.userID, userInfo.userName));
                        }
                    }
                } else {
                    int DENY_STATE = Integer.parseInt(SimpleUserInfo.STATE_DENY);
                    Iterator it2 = destination.getConferenceMember().iterator();
                    while (it2.hasNext()) {
                        SimpleUserInfo userInfo2 = (SimpleUserInfo) it2.next();
                        int position3 = getBuddyList().isContainBuddy(userInfo2.getUserID());
                        logI("position: " + position3 + "userID: " + userInfo2.getUserID() + " state: " + userInfo2.getStatus());
                        if (position3 > 0) {
                            int position4 = position3 - 1;
                            int state2 = Integer.parseInt(userInfo2.getStatus());
                            if (state2 >= DENY_STATE || "2".equals(userInfo2.getStatus()) || "3".equals(userInfo2.getStatus())) {
                                logI("checkInviteView() state: deny or disconnected, userID: " + userInfo2.getUserID());
                                getBuddyList().getBuddy(position4).setCallState(2);
                                Message msg3 = new Message();
                                msg3.what = 11;
                                msg3.arg1 = position4;
                                this.mInviteViewHandler.sendMessageDelayed(msg3, 3000L);
                            } else if ("1".equals(userInfo2.getStatus()) || SimpleUserInfo.STATE_MOVETO_CONFERENCE.equals(userInfo2.getStatus())) {
                                logI("checkInviteView() state: connected, userID: " + userInfo2.getUserID());
                                if (CallState.isConnected(this.mActivity.mCallStatusData.getCallState()) && "1".equals(userInfo2.getStatus()) && getBuddyList().getBuddy(position4).getCallState() != 3) {
                                    soundPool = new SoundPool(1, 4, 0);
                                    this.soundLoad = soundPool.load(this.mActivity, C0000R.raw.call_connect, 1);
                                    soundPool.play(this.soundLoad, 1.0f, 1.0f, 1, 0, 1.0f);
                                }
                                getBuddyList().getBuddy(position4).setCallState(3);
                            } else {
                                logI("checkInviteView() state: elsee, userID: " + userInfo2.getUserID());
                                if (!"1".equals(userInfo2.getStatus()) && !SimpleUserInfo.STATE_MOVETO_CONFERENCE.equals(userInfo2.getStatus())) {
                                    getBuddyList().getBuddy(position4).setCallState(1);
                                }
                            }
                        } else {
                            logI("userInfo.getStatus()userInfo.getStatus() = " + userInfo2.getStatus());
                            if ("0".equals(userInfo2.getStatus())) {
                                getBuddyList().addBuddy(new ConferenceMember(userInfo2.getUserID(), userInfo2.getUserName()));
                            }
                        }
                    }
                }
            } else {
                checkWaitMemberForInviteView(callState, isConference, isOutGoingCall, destinationUtil, destination, true, userAddedInfo, callUserInfo);
            }
            if (checkAllConnected()) {
                this.mActivity.setInviteProcessing(false);
            }
            if (this.mInviteViewAdaptor != null) {
                this.mInviteViewAdaptor.notifyDataSetChanged();
            }
        }
    }

    public boolean checkAllConnected() {
        boolean isAllConnected = true;
        List<InviteViewBuddyItem> buddylist = getBuddyList().getBuddyList();
        for (InviteViewBuddyItem buddyItem : buddylist) {
            if (buddyItem.getUserCallState() != 3) {
                isAllConnected = false;
            }
        }
        return isAllConnected;
    }

    public static boolean isEnableInviteButton(boolean isOutGoingCall, Destination destination) {
        if (MainApplication.mConfig.isHostInviteOnly()) {
            if (((ChatOnConfigInterface) MainApplication.mConfig).getConferenceCallMaxPeopleNum(false) >= 3) {
                return isOutGoingCall;
            }
            return false;
        }
        String myUserID = MainApplication.mConfig.getProfileUserID();
        Iterator it = destination.getConferenceMember().iterator();
        while (it.hasNext()) {
            SimpleUserInfo userInfo = (SimpleUserInfo) it.next();
            if (userInfo.getInviteUserID() != null && !userInfo.getInviteUserID().isEmpty()) {
                if (userInfo.getStatus().equals("0")) {
                    return myUserID.equals(userInfo.getInviteUserID());
                }
            } else {
                return isOutGoingCall;
            }
        }
        return true;
    }

    public boolean checkRequester(boolean isOutGoingCall, Destination destination) {
        if (!MainApplication.mConfig.isHostInviteOnly()) {
            String myUserID = MainApplication.mConfig.getProfileUserID();
            Iterator it = destination.getConferenceMember().iterator();
            while (it.hasNext()) {
                SimpleUserInfo userInfo = (SimpleUserInfo) it.next();
                if (userInfo.getInviteUserID() != null && !userInfo.getInviteUserID().isEmpty()) {
                    if (myUserID.equals(userInfo.getInviteUserID()) && userInfo.getStatus().equals("0")) {
                        return true;
                    }
                } else {
                    return isOutGoingCall;
                }
            }
            return false;
        }
        return isOutGoingCall;
    }

    public void checkWaitMemberForInviteView(int callState, boolean isConference, boolean isOutGoingCall, DestinationUtil destinationUtil, Destination destination, boolean isVibration, CallUserAddedInfo userAddedInfo, CallDisplayUserInfo callUserInfo) {
        logI("checkWaitMemberForInviteView");
        if (!CallState.isConnected(callState) && !CallState.isNotConnected(callState)) {
            logI("return");
            return;
        }
        logI("checkWaitMemberForInviteView() mIsActive: " + this.mIsActive + " isConference(): " + isConference);
        if (this.mIsActive) {
            endInviteView();
        }
        if (isConference) {
            this.mIsRequester = checkRequester(isOutGoingCall, destination);
            if (!this.mIsRequester && (CallState.isConnected(callState) || this.mIsActive)) {
                if (destinationUtil.getConferenceWaitCount(destination) > 0) {
                    this.mIInviteViewController.disableButtonDuringInviteView();
                    this.mActivity.setInviteProcessing(true);
                    if (isVibration) {
                        if (this.vibrator == null) {
                            this.vibrator = (Vibrator) MainApplication.mContext.getSystemService("vibrator");
                        }
                        this.vibrator.vibrate(500L);
                    }
                } else {
                    this.mActivity.setInviteProcessing(false);
                }
            }
            preprocessInviteView(destinationUtil, destination, userAddedInfo, callUserInfo);
            return;
        }
        endInviteView();
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x011b A[Catch: NotAvailableClientAPIException -> 0x00ba, TRY_LEAVE, TryCatch #0 {NotAvailableClientAPIException -> 0x00ba, blocks: (B:22:0x0093, B:24:0x0099, B:25:0x00a0, B:27:0x00a6, B:28:0x00b0, B:34:0x00ee, B:35:0x011b), top: B:37:0x0093 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void sendSelectedListIntent(int r17, int r18, boolean r19, com.coolots.chaton.call.util.DestinationUtil r20, com.sds.coolots.call.model.Destination r21, com.coolots.chaton.call.model.CallUserAddedInfo r22) {
        /*
            Method dump skipped, instructions count: 295
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.coolots.chaton.call.controller.InviteViewController.sendSelectedListIntent(int, int, boolean, com.coolots.chaton.call.util.DestinationUtil, com.sds.coolots.call.model.Destination, com.coolots.chaton.call.model.CallUserAddedInfo):void");
    }

    private boolean sendConferenceMemberToServer(ArrayList<ConferenceMember> addMemberList, ArrayList<ConferenceMember> removeMemberList) {
        logI("sendConferenceMemberToServer()");
        int ret = this.mActivity.addConferenceMember(addMemberList, removeMemberList);
        switch (ret) {
            case PhoneStateMachine.ERROR_INVITE_BUDDY_HOLD /* -1032 */:
                this.mActivity.showToast(C0000R.string.unable_invite_buddy_invalid_call_hold);
                return false;
            case PhoneStateMachine.ERROR_INVITE_BUDDY_CALL_CONSEND /* -1031 */:
                this.mActivity.showToast(C0000R.string.unable_invite_buddy_invalid_call_consend);
                return false;
            case PhoneStateMachine.ERROR_INVITE_BUDDY_CALL_SWITCHING /* -1030 */:
                this.mActivity.showToast(C0000R.string.unable_invite_buddy_invalid_call_switching);
                return false;
            case PhoneStateMachine.ERROR_INVALID_PARAMETER /* -1022 */:
                logI("<<YHT>> add and remove is possible for SIP Conference Call");
                return true;
            case PhoneStateMachine.ERROR_INVALID_CALL_TYPE /* -1017 */:
                this.mActivity.showToast(C0000R.string.unable_invite_buddy_invalid_call_type);
                return false;
            case PhoneStateMachine.ERROR_INVALID_STATE /* -1013 */:
                this.mActivity.showToast(C0000R.string.unable_invite_buddy_invalid_state);
                return false;
            default:
                return true;
        }
    }

    private InviteViewBuddyList getBuddyList() {
        if (this.mBuddyList == null) {
            this.mBuddyList = new InviteViewBuddyList();
        }
        return this.mBuddyList;
    }

    public boolean isActive() {
        return this.mIsActive;
    }

    public boolean isInviteWaiting() {
        return this.mIsInviteWaiting;
    }

    @Override // com.sds.coolots.common.view.DisposeInterface
    public void dispose() {
        stop();
        if (this.mInviteViewAdaptor != null) {
            this.mInviteViewAdaptor.dispose();
            this.mInviteViewAdaptor = null;
        }
        if (this.mInviteViewHandler != null) {
            this.mInviteViewHandler.removeMessages(10);
            this.mInviteViewHandler.removeMessages(11);
            this.mInviteViewHandler.dispose();
            this.mInviteViewHandler = null;
        }
        if (this.mBuddyList != null) {
            this.mBuddyList.dispose();
        }
        this.mActivity = null;
        this.mIInviteViewController = null;
        this.mInviteViewLayout = null;
        this.mInviteBuddyListView = null;
        this.mBuddyManager = null;
        this.vibrator = null;
    }
}
