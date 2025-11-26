package com.coolots.chaton.common.view;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.telephony.PhoneNumberUtils;
import android.widget.Toast;
import com.coolots.chaton.C0000R;
import com.coolots.chaton.buddy.model.BuddyTable;
import com.coolots.chaton.common.controller.VAppPhoneManager;
import com.coolots.chaton.common.util.ChatONStringConvert;
import com.coolots.chaton.common.util.InformationActivityGenerator;
import com.coolots.chaton.common.util.ViewRecycleUtil;
import com.sds.coolots.MainApplication;
import com.sds.coolots.call.model.Destination;
import com.sds.coolots.call.model.P2PUserInfo;
import com.sds.coolots.common.util.Log;
import com.sds.coolots.common.view.DisposeInterface;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class ChatONNativeCallActivity extends Activity implements DisposeInterface {
    private static final String CLASSNAME = "[ChatONNativeCallActivity]";
    private static final boolean IS_NATIVE_CALL_INSTEAD_OF_SIP_CALL = true;
    public static final String NATIVE_CONTACT_CALL_ACTION = "com.sds.vapp.voipcall";
    private static final String PHONE_ACTION = "android.intent.action.CALL_PRIVILEGED";
    private static final String PHONE_NO_DELEMETER = "-";
    private static final String PHONE_NO_PREFIX = "tel:";
    private static final int PHONE_NUMBER_MAX_LENGTH = 6;
    private static final String SHORTCUT_ACTION = "com.coolots.chaton.CALL_SHORTCUT";
    public static final String SHORTCUT_BUDDY_ACTION = "com.coolots.chaton.CALL_BUDDY";
    public static final String SHORTCUT_ISGROUP = "is_group";
    public static final String SHORTCUT_LIVESHARE = "live_share";
    public static final String SHORTCUT_USERACCOUNT = "user_account";
    public static final String SHORTCUT_USERNO = "user_no";
    public static final String SHORTCUT_VIDEOCALL = "video_call";
    public InformationActivityGenerator mInformationActivity;

    private void logE(String message) {
        Log.m2958e(CLASSNAME + message);
    }

    private void logI(String message) {
        Log.m2963i(CLASSNAME + message);
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        logI("onCreate");
        super.onCreate(savedInstanceState);
        getWindow().setFlags(2, 2);
        setContentView(C0000R.layout.call_error_information);
        this.mInformationActivity = new InformationActivityGenerator();
        logI("onCreate end");
    }

    @Override // android.app.Activity
    protected void onResume() {
        logI("onResume");
        super.onResume();
        Intent intent = getIntent();
        if (intent != null) {
            if (intent.getAction().equals(PHONE_ACTION)) {
                if (checkMembershipInfo()) {
                    startCalling(intent.getExtras(), true);
                } else {
                    finish();
                    return;
                }
            } else if (intent.getAction().equals("com.coolots.chaton.CALL_SHORTCUT")) {
                if (checkMembershipInfo()) {
                    startCalling(intent.getExtras(), true);
                } else {
                    finish();
                    return;
                }
            } else if (intent.getAction().equals(SHORTCUT_BUDDY_ACTION)) {
                if (checkMembershipInfo()) {
                    startCalling(intent.getExtras(), false);
                } else {
                    finish();
                    return;
                }
            } else if (intent.getAction().equals(NATIVE_CONTACT_CALL_ACTION)) {
                if (checkMembershipInfo()) {
                    startCallingFromNative();
                } else {
                    finish();
                    return;
                }
            }
            finish();
        }
        logI("onResume end");
    }

    private boolean checkMembershipInfo() {
        logI("checkMembershipInfo()");
        String userID = MainApplication.mConfig.getProfileUserID();
        if (userID != null && !userID.isEmpty()) {
            return true;
        }
        logI("checkMembershipInfo() - myAccount is null");
        ((VAppPhoneManager) MainApplication.mPhoneManager).getSSOManager().startChatONForCreateAccount();
        return false;
    }

    @Override // android.app.Activity
    protected void onPause() {
        logI("onPause");
        super.onPause();
        finish();
        logI("onPause end");
    }

    @Override // android.app.Activity
    public void onBackPressed() {
    }

    @Override // android.app.Activity
    public void onDestroy() {
        dispose();
        super.onDestroy();
    }

    @Override // com.sds.coolots.common.view.DisposeInterface
    public void dispose() {
        ViewRecycleUtil.recurisveRecycle(getWindow().getDecorView());
        System.gc();
    }

    private void startCalling(Bundle extras, boolean callByPhoneNo) {
        String e164;
        logI("<<YHT2>> Native Phone Call Start");
        if (callByPhoneNo) {
            String phoneNo = getPhoneNumber();
            if (phoneNo != null) {
                if (phoneNo.length() <= 6) {
                    if (PhoneNumberUtils.isEmergencyNumber(phoneNo)) {
                        logE(String.valueOf(phoneNo) + " is emergency call.");
                        Intent intent = new Intent("android.intent.action.CALL_EMERGENCY");
                        intent.setData(Uri.fromParts("tel", phoneNo, null));
                        intent.setFlags(268435456);
                        startActivity(intent);
                        return;
                    }
                    logE(String.valueOf(phoneNo) + " is too short.");
                    this.mInformationActivity.showInformationActivity(14);
                    return;
                }
                logE("<<YHT2>> PHONE NO:" + phoneNo);
                String e1642 = MainApplication.mConfig.getE164PhoneNumber(phoneNo);
                if (e1642 == null) {
                    e164 = convertOnlyDigit(phoneNo);
                } else {
                    e164 = e1642.replace("+", "");
                }
                logE("<<YHT2>> e164:" + e164);
                BuddyTable contact = ((VAppPhoneManager) MainApplication.mPhoneManager).getChatOnContactManager().getVAppBuddyInfoTextDataByPhoneNumber(e164);
                if (contact == null) {
                    logE("<<YHT2>> PHONE NO:" + e164 + ", is not buddy!!!");
                    logE(String.valueOf(phoneNo) + " is not your buddy");
                    this.mInformationActivity.showInformationActivityForAddBuddy(e164);
                    return;
                } else {
                    boolean isLiveShare = getIntent().getBooleanExtra(SHORTCUT_LIVESHARE, false);
                    if (isVideoCall(extras)) {
                        startP2PCall(contact.getUserID(), true, isLiveShare);
                        return;
                    } else {
                        startP2PCall(contact.getUserID(), false, isLiveShare);
                        return;
                    }
                }
            }
            finish();
            return;
        }
        long userNo = getUserNo();
        logI("<<YHT2>>  USERno:" + userNo);
        startOutgoingCall(userNo);
    }

    private void startCallingFromNative() {
        logI("BUDDY_TRACE Native Phone Call Start");
        String userAccountID = getUserAccount();
        long userNo = ((VAppPhoneManager) MainApplication.mPhoneManager).getChatOnContactManager().getUserNoByAccountIDWithNoException(userAccountID);
        logI("BUDDY_TRACE  USER Account:" + userAccountID);
        if (MainApplication.mPhoneManager.IsLinkagewithChatON()) {
            startOutgoingCallBySAccount(userAccountID);
        } else {
            startOutgoingCall(userNo);
        }
    }

    private String convertOnlyDigit(String phoneNo) {
        String numeral = "";
        if (phoneNo == null) {
            return null;
        }
        for (int i = 0; i < phoneNo.length(); i++) {
            if (Character.isDigit(phoneNo.charAt(i))) {
                numeral = String.valueOf(numeral) + phoneNo.charAt(i);
            }
        }
        return numeral;
    }

    private void startOutgoingCall(long userNo) {
        logI("startOutgoingCall: " + userNo);
        int buddyType = ((VAppPhoneManager) MainApplication.mPhoneManager).getChatOnContactManager().getKindOfBuddy(userNo);
        String userName = ((VAppPhoneManager) MainApplication.mPhoneManager).getChatOnContactManager().getUserNameByUserIDForAddbuddyList(userNo);
        if (buddyType == 4) {
            Toast.makeText(this, getString(C0000R.string.buddy_not_subscriber), 0).show();
            return;
        }
        if (buddyType == 2) {
            Toast.makeText(this, getString(C0000R.string.buddy_block, new Object[]{userName}), 0).show();
            return;
        }
        if (buddyType == 1) {
            Toast.makeText(this, getString(C0000R.string.buddy_hid, new Object[]{userName}), 0).show();
            return;
        }
        BuddyTable contact = ((VAppPhoneManager) MainApplication.mPhoneManager).getChatOnContactManager().getVAppBuddyInfoTextDataByUserNo(userNo);
        if (contact == null) {
            Toast.makeText(this, getString(C0000R.string.buddy_not_subscriber), 0).show();
            return;
        }
        boolean isLiveShare = getIntent().getBooleanExtra(SHORTCUT_LIVESHARE, false);
        if (getIntent().getBooleanExtra(SHORTCUT_VIDEOCALL, false)) {
            logE("<<YHT100>> SHORTCUT_VIDEOCALL is true!!");
            startP2PCall(contact.getUserID(), true, isLiveShare);
        } else {
            logE("<<YHT100>> SHORTCUT_VIDEOCALL is false!!");
            startP2PCall(contact.getUserID(), false, isLiveShare);
        }
    }

    private void startOutgoingCallBySAccount(String userID) {
        logI("startOutgoingCallBySAccount " + userID);
        boolean isLiveShare = getIntent().getBooleanExtra(SHORTCUT_LIVESHARE, false);
        if (getIntent().getBooleanExtra(SHORTCUT_VIDEOCALL, false)) {
            logE("video call");
            startP2PCall(userID, true, isLiveShare);
        } else {
            logE("voice call");
            startP2PCall(userID, false, isLiveShare);
        }
    }

    private void startP2PCall(String MSISDN, boolean isVideoCall, boolean isLiveShare) {
        Destination destination;
        if (MainApplication.mPhoneManager.isConfTest()) {
            List<P2PUserInfo> memberList = new ArrayList<>();
            P2PUserInfo userInfo = new P2PUserInfo();
            userInfo.userID = ChatONStringConvert.getInstance().toUserID(MSISDN);
            userInfo.userName = MainApplication.mPhoneManager.getContactManager().getUserNameByUserID(ChatONStringConvert.getInstance().toUserID(MSISDN));
            memberList.add(userInfo);
            destination = new Destination(-1, memberList, 0L);
        } else {
            destination = new Destination(2, ChatONStringConvert.getInstance().toUserID(MSISDN));
        }
        callProcessing(destination, isVideoCall, isLiveShare);
    }

    public void callProcessing(Destination destination, boolean isVideoCall, boolean isLiveShare) {
        if (isVideoCall) {
            ((VAppPhoneManager) MainApplication.mPhoneManager).getSSOManager().videoDCallWithCaller(destination.getString(), null, MainApplication.mConfig.getProfileUserName(), null, isLiveShare);
        } else {
            ((VAppPhoneManager) MainApplication.mPhoneManager).getSSOManager().voiceDCallWithCaller(destination.getString(), null, MainApplication.mConfig.getProfileUserName(), null, isLiveShare);
        }
    }

    private long getUserNo() {
        return getIntent().getLongExtra(SHORTCUT_USERNO, 0L);
    }

    private String getUserAccount() {
        return getIntent().getStringExtra(SHORTCUT_USERACCOUNT);
    }

    private String getPhoneNumber() {
        String phoneNo;
        Uri uri = getIntent().getData();
        if (uri == null) {
            return null;
        }
        String phoneNo2 = uri.toString().replace(PHONE_NO_PREFIX, "").replace(PHONE_NO_DELEMETER, "");
        try {
            phoneNo = URLDecoder.decode(phoneNo2, "UTF-8").replace(" ", "");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            phoneNo = phoneNo2.replace("%20", "");
        }
        logE("phoneNo:" + phoneNo);
        return phoneNo;
    }

    private boolean isVideoCall(Bundle extras) {
        return extras != null && extras.containsKey("videocall");
    }
}
