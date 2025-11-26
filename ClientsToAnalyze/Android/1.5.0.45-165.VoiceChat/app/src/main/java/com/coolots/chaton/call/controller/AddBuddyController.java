package com.coolots.chaton.call.controller;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.Toast;
import com.coolots.chaton.C0000R;
import com.coolots.chaton.buddy.BuddyManagerInterface;
import com.coolots.chaton.call.util.ChatONAddBuddyReceiver;
import com.coolots.chaton.common.controller.VAppPhoneManager;
import com.coolots.chaton.common.util.ChatONStringConvert;
import com.coolots.p2pmsg.model.BuddyGroupInfo;
import com.coolots.p2pmsg.model.BuddyGroupMapInfo;
import com.coolots.p2pmsg.model.SimpleUserInfo;
import com.sds.coolots.MainApplication;
import com.sds.coolots.call.model.P2PUserInfo;
import com.sds.coolots.common.util.Log;
import com.sds.coolots.common.view.DisposeInterface;
import com.sec.chaton.clientapi.GraphAPI;
import com.sec.chaton.clientapi.exception.IllegalArgumentClientAPIException;
import com.sec.chaton.clientapi.exception.NotActivatedClientAPIException;
import com.sec.chaton.clientapi.exception.NotAvailableClientAPIException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

/* loaded from: classes.dex */
public class AddBuddyController implements DisposeInterface {
    private static final String CLASSNAME = "[AddBuddyController]";
    public static final int RETRY_CALL_TYPE_NONE = -1;
    public static final int RETRY_CALL_TYPE_VIDEO = 0;
    public static final int RETRY_CALL_TYPE_VOICE = 1;
    private static final int TIME_OUT_ADD_BUDDY = 1;
    private static final int TIME_OUT_GROUP_ADD = 2;
    private Activity mActivity;
    private AlertDialog mAddBuddyDialog;
    private IAddBuddyController mRetryCall;
    private TimeOutHandler mTimeOutHandler;
    public boolean mIsRetryCallDirect = false;
    public boolean mAddbuddyBeforeReTryCall = false;
    private int mRetryCallType = -1;
    private boolean mIsConference = false;
    private ArrayList<String> mUnknownFriendsUserID = null;
    private ArrayList<String> mAllMemberUserID = null;
    private String mNeedToAddBuddyName = null;
    private BuddyGroupInfo mBuddyGroupInfo = new BuddyGroupInfo();
    private List<BuddyGroupMapInfo> mBuddyGruopMemberList = new ArrayList();
    private String mNewGruopName = "";
    private BuddyManagerInterface mBuddyManager = ((VAppPhoneManager) MainApplication.mPhoneManager).getChatOnContactManager();
    private Toast mToast = null;
    private EditText mEditText = null;
    private boolean activeAddBuddyReceiver = false;
    private Timer addBuddyTimer = new Timer();
    private TimerTask addBuddyTask = new TimerTask() { // from class: com.coolots.chaton.call.controller.AddBuddyController.1
        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            if (!AddBuddyController.this.activeAddBuddyReceiver) {
                AddBuddyController.this.retryCallAfterAddBuddy(false);
            }
        }
    };
    public LayoutInflater inflater = null;
    public InputMethodManager imm = null;

    /* JADX INFO: Access modifiers changed from: private */
    public void logI(String message) {
        Log.m2963i(CLASSNAME + message);
    }

    private void logE(String message) {
        Log.m2963i(CLASSNAME + message);
    }

    public AddBuddyController(Activity activity, IAddBuddyController retryCall) {
        this.mRetryCall = null;
        logI("AddBuddyController");
        this.mActivity = activity;
        this.mRetryCall = retryCall;
        ChatONAddBuddyReceiver.registerController(this);
    }

    public void setRetryCallType(boolean isConference, int retryCallType) {
        logI("setRetryCallType() isConference: " + isConference + " retryCallType: " + retryCallType);
        this.mIsConference = isConference;
        this.mRetryCallType = retryCallType;
    }

    public boolean isIncludedNotFriend(boolean isConference, ArrayList<SimpleUserInfo> memberList, ArrayList<P2PUserInfo> p2pMemberList, HashMap<String, Long> totalUserNoList, String calleeUserID, String calleeUserName) {
        logI("isIncludedNotFriend()1");
        HashMap<String, String> _destination = new HashMap<>();
        Iterator<SimpleUserInfo> it = memberList.iterator();
        while (it.hasNext()) {
            SimpleUserInfo userInfo = it.next();
            _destination.put(userInfo.getUserID(), userInfo.getUserName());
        }
        Iterator<P2PUserInfo> it2 = p2pMemberList.iterator();
        while (it2.hasNext()) {
            P2PUserInfo userInfo2 = it2.next();
            _destination.put(userInfo2.userID, userInfo2.userName);
        }
        return isIncludedNotFriend(isConference, _destination, totalUserNoList, calleeUserID, calleeUserName);
    }

    public boolean isIncludedNotFriend(boolean isConference, HashMap<String, String> destination, HashMap<String, Long> totalUserNoList, String calleeUserID, String calleeUserName) {
        logI("isIncludedNotFriend()2");
        String myUserID = MainApplication.mConfig.getProfileUserID();
        if (this.mUnknownFriendsUserID == null) {
            this.mUnknownFriendsUserID = new ArrayList<>();
        } else {
            this.mUnknownFriendsUserID.clear();
        }
        this.mNeedToAddBuddyName = "";
        if (this.mAllMemberUserID == null) {
            this.mAllMemberUserID = new ArrayList<>();
        } else {
            this.mAllMemberUserID.clear();
        }
        if (this.mBuddyGroupInfo == null) {
            this.mBuddyGroupInfo = new BuddyGroupInfo();
        }
        if (isConference) {
            for (String userID : destination.keySet()) {
                if (!userID.equals(myUserID)) {
                    String userName = destination.get(userID);
                    switch (this.mBuddyManager.getKindOfBuddy(userID)) {
                        case 0:
                            logI("NORMAL_BUDDY >> userID: " + userID + ", userName: " + userName);
                            break;
                        case 1:
                        case 2:
                        default:
                            logI("ERROR >> userID: " + userID + ", userName: " + userName);
                            break;
                        case 3:
                        case 4:
                            logI("UNKNOWN_BUDDY/SUGGESTION_BUDDY >> userID: " + userID + ", userName: " + userName);
                            this.mUnknownFriendsUserID.add(userID);
                            this.mNeedToAddBuddyName = String.valueOf(this.mNeedToAddBuddyName) + addStringToTailWithComma(this.mNeedToAddBuddyName, getUserName(userID, userName));
                            break;
                    }
                    this.mAllMemberUserID.add(userID);
                }
            }
        } else {
            switch (this.mBuddyManager.getKindOfBuddy(calleeUserID)) {
                case 3:
                case 4:
                    this.mUnknownFriendsUserID.add(calleeUserID);
                    this.mNeedToAddBuddyName = calleeUserName;
                    break;
            }
        }
        return (this.mNeedToAddBuddyName == null || this.mNeedToAddBuddyName.isEmpty()) ? false : true;
    }

    public void retryCall() {
        if (this.mRetryCallType == 0) {
            if (this.mIsConference) {
                logI("retryCall() video conference call");
                this.mRetryCall.retryVideoConferenceCall();
                return;
            } else {
                logI("retryCall() video call");
                this.mRetryCall.retryVideoCall();
                return;
            }
        }
        if (this.mRetryCallType == 1) {
            if (this.mIsConference) {
                logI("retryCall() voice conference call");
                this.mRetryCall.retryVoiceConferenceCall();
            } else {
                logI("retryCall() voice call");
                this.mRetryCall.retryVoiceCall();
            }
        }
    }

    public void showAddBuddyAlertBuilder(String addedBuddyName, final ArrayList<String> aUnknownbuddylist) {
        logI("showAddBuddyAlertBuilder()");
        dialogDismiss();
        disposeTimeOutHandler();
        AlertDialog.Builder bld = new AlertDialog.Builder(this.mActivity);
        bld.setTitle(getDialogString(true, aUnknownbuddylist.size() == 1, null));
        bld.setMessage(getDialogString(false, aUnknownbuddylist.size() == 1, addedBuddyName));
        bld.setCancelable(false);
        bld.setPositiveButton(C0000R.string.alert_dialog_ok, new DialogInterface.OnClickListener() { // from class: com.coolots.chaton.call.controller.AddBuddyController.2
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int which) {
                AddBuddyController.this.logI("<CIH> : showAddBuddyAlertBuilder - OK");
                AddBuddyController.this.hidekeyboard();
                if (aUnknownbuddylist != null && !aUnknownbuddylist.isEmpty()) {
                    ChatONAddBuddyReceiver.setUnknownbuddylist(aUnknownbuddylist);
                    Iterator it = aUnknownbuddylist.iterator();
                    while (it.hasNext()) {
                        String unknownbuddy = (String) it.next();
                        AddBuddyController.this.mAddbuddyBeforeReTryCall = true;
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
                }
                dialog.dismiss();
                if (AddBuddyController.this.mRetryCallType == -1) {
                    AddBuddyController.this.mRetryCall.callActivityQuit();
                } else {
                    AddBuddyController.this.addBuddyTimer.schedule(AddBuddyController.this.addBuddyTask, 10000L);
                }
            }
        });
        bld.setNegativeButton(C0000R.string.cancel, new DialogInterface.OnClickListener() { // from class: com.coolots.chaton.call.controller.AddBuddyController.3
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int arg1) {
                AddBuddyController.this.logI("showAddBuddyAlertBuilder - CANCEL");
                AddBuddyController.this.hidekeyboard();
                dialog.dismiss();
                AddBuddyController.this.mRetryCall.callActivityQuit();
            }
        });
        this.mAddBuddyDialog = bld.create();
        this.mAddBuddyDialog.show();
    }

    public void retryCallAfterAddBuddy(boolean resultAddBuddy) {
        this.activeAddBuddyReceiver = true;
        this.mRetryCall.callActivityDelayedQuit();
        if (resultAddBuddy) {
            showToast(C0000R.string.added);
            retryCall();
        } else {
            showToast(C0000R.string.webpage_loading_fail);
            this.mRetryCall.callActivityQuit();
        }
    }

    public String getGroupName() {
        logI("getGroupName() : " + this.mNewGruopName);
        return this.mNewGruopName;
    }

    public boolean isShowAddGroupDialog() {
        return this.mAddBuddyDialog != null && this.mAddBuddyDialog.isShowing();
    }

    private String addStringToTailWithComma(String destStr, String addStr) {
        return destStr.isEmpty() ? addStr : ", " + addStr;
    }

    private String getUserName(String userID, String userName) {
        if (userName == null) {
            return ChatONStringConvert.getInstance().removeFooter(userID);
        }
        return userName;
    }

    private String getDialogString(boolean isTitle, boolean isOne, String name) {
        return isTitle ? isOne ? getString(C0000R.string.call_menu_add_buddy) : getString(C0000R.string.preference_buddies_btn_add_buddies) : isOne ? getString(C0000R.string.information_str_msg_12, "'" + name + "'") : getString(C0000R.string.end_call_dialog_add_buddies, "'" + name + "'");
    }

    private String getString(int resID) {
        return MainApplication.mContext.getResources().getString(resID);
    }

    private String getString(int resID, String arg0) {
        return MainApplication.mContext.getResources().getString(resID, arg0);
    }

    public class TimeOutHandler extends Handler implements DisposeInterface {
        private boolean bIsDispose = false;

        public TimeOutHandler() {
        }

        @Override // com.sds.coolots.common.view.DisposeInterface
        public void dispose() {
            this.bIsDispose = true;
        }

        @Override // android.os.Handler
        public void handleMessage(Message msg) {
            if (!this.bIsDispose) {
                if (msg.arg1 == -16) {
                    AddBuddyController.this.showToast(C0000R.string.information_str_msg_1);
                } else {
                    AddBuddyController.this.showToast(C0000R.string.error_add_buddy_ask);
                }
                AddBuddyController.this.mRetryCall.callActivityQuit();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void showToast(int rID) {
        this.mToast = Toast.makeText(MainApplication.mContext, "null", 0);
        this.mToast.setText(getString(rID));
        this.mToast.show();
    }

    public void hidekeyboard() {
        try {
            logI("hidekeyboard!!!");
            if (this.imm == null) {
                this.imm = (InputMethodManager) this.mActivity.getSystemService("input_method");
            }
            if (this.imm != null && this.mEditText != null) {
                this.imm.hideSoftInputFromWindow(this.mEditText.getWindowToken(), 0);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.sds.coolots.common.view.DisposeInterface
    public void dispose() {
        logI("dispose()");
        if (this.mActivity != null) {
            this.mActivity = null;
        }
        if (this.mRetryCall != null) {
            this.mRetryCall = null;
        }
        if (this.mUnknownFriendsUserID != null) {
            this.mUnknownFriendsUserID.clear();
            this.mUnknownFriendsUserID = null;
        }
        if (this.mAllMemberUserID != null) {
            this.mAllMemberUserID.clear();
            this.mAllMemberUserID = null;
        }
        if (this.mNeedToAddBuddyName != null) {
            this.mNeedToAddBuddyName = null;
        }
        if (this.mBuddyGroupInfo != null) {
            this.mBuddyGroupInfo = null;
        }
        if (this.mBuddyGruopMemberList != null) {
            this.mBuddyGruopMemberList.clear();
            this.mBuddyGruopMemberList = null;
        }
        dialogDismiss();
        this.inflater = null;
        this.imm = null;
        if (this.mNewGruopName != null) {
            this.mNewGruopName = null;
        }
        if (this.mBuddyManager != null) {
            this.mBuddyManager = null;
        }
        if (this.mToast != null) {
            this.mToast.cancel();
            this.mToast = null;
        }
        disposeTimeOutHandler();
        ChatONAddBuddyReceiver.unregisterConteroller();
    }

    private void disposeTimeOutHandler() {
        if (this.mTimeOutHandler != null) {
            this.mTimeOutHandler.removeMessages(1);
            this.mTimeOutHandler.removeMessages(2);
            this.mTimeOutHandler.dispose();
            this.mTimeOutHandler = null;
        }
    }

    private void dialogDismiss() {
        if (this.mAddBuddyDialog != null) {
            this.mAddBuddyDialog.dismiss();
            this.mAddBuddyDialog = null;
        }
    }
}
