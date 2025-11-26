package com.coolots.chaton.common.util;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.telephony.TelephonyManager;
import com.coolots.chaton.buddy.model.BuddyTable;
import com.coolots.chaton.common.controller.VAppPhoneManager;
import com.coolots.p2pmsg.model.SimpleUserInfo;
import com.sds.coolots.MainApplication;
import com.sds.coolots.call.model.Destination;
import com.sds.coolots.call.model.P2PUserInfo;
import com.sds.coolots.common.coolotsinterface.InformationActivityGeneratorInterface;
import com.sds.coolots.common.util.Log;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
public class ChatONMessage {
    private static final String CLASSNAME = "[ChatONMessage]";
    public static final int FAIL_ADD_BUDDY = 6;
    public static final int FAIL_SEND_MSG_NO_RECEIVER = 3;
    public static final int FAIL_SEND_MSG_SMS_NO_PHONENUMBER = 4;
    public static final int FAIL_SEND_MSG_SMS_NO_USERID = 7;
    public static final int FAIL_SEND_MSG_SMS_NO_USIM = 5;
    public static final int SUCCESS_SEND_MSG_SMS = 2;
    public static final int SUCCESS_SEND_MSG_TO_CHATON = 1;
    public TelephonyManager telephony = null;
    private UserInfo mUserInfo = null;

    private static void logI(String message) {
        Log.m2963i(CLASSNAME + message);
    }

    private class UserInfo {
        private String mUserID = null;
        private StringBuilder mUserIDs = null;
        private String mUserPhoneNumber = null;
        private StringBuilder mUserPhoneNumbers = null;

        public UserInfo() {
        }
    }

    public boolean canISendSMS() {
        if (this.telephony == null) {
            this.telephony = (TelephonyManager) MainApplication.mContext.getSystemService("phone");
        }
        String phoneNumber = this.telephony.getLine1Number();
        return (phoneNumber == null || phoneNumber.isEmpty()) ? false : true;
    }

    public int sendRejectMessage(Context context, Destination destination, String rejectMsg) {
        logI("sendRejectMessage: " + rejectMsg);
        VAppPhoneManager phoneMng = (VAppPhoneManager) MainApplication.mPhoneManager;
        this.mUserInfo = getUserInfoFromDestination(destination);
        if (this.mUserInfo != null) {
            if (this.mUserInfo.mUserID != null && !this.mUserInfo.mUserID.isEmpty() && phoneMng.getChatOnContactManager().isFriend(this.mUserInfo.mUserID)) {
                return 1;
            }
            if (canISendSMS()) {
                if (this.mUserInfo.mUserPhoneNumber == null || this.mUserInfo.mUserPhoneNumber.isEmpty()) {
                    logI("PhoneNumber is nothing.");
                    return 4;
                }
                if (rejectMsg == null || rejectMsg.isEmpty()) {
                    gotoSMSEditPage(context, this.mUserInfo.mUserPhoneNumber);
                } else {
                    sendSMSDirect(context, this.mUserInfo.mUserPhoneNumber, rejectMsg);
                }
                return 2;
            }
            return 5;
        }
        logI("Receiver is nothing.");
        return 3;
    }

    public int sendMessageEndCall(Context context, Destination destination) {
        logI("gotoMessagesComposer()");
        VAppPhoneManager phoneMng = (VAppPhoneManager) MainApplication.mPhoneManager;
        this.mUserInfo = getUserInfoFromDestination(destination);
        if (this.mUserInfo != null) {
            if (this.mUserInfo.mUserID == null || this.mUserInfo.mUserID.isEmpty() || !phoneMng.getChatOnContactManager().isFriend(this.mUserInfo.mUserID)) {
                if (this.mUserInfo.mUserID != null && !this.mUserInfo.mUserID.isEmpty() && MainApplication.mInformationActivityGenerator != null) {
                    InformationActivityGeneratorInterface mAlert = MainApplication.mInformationActivityGenerator;
                    mAlert.showInformationActivityForAddBuddy(ChatONStringConvert.getInstance().removeAfterAt(this.mUserInfo.mUserID));
                    return 6;
                }
                return 7;
            }
            return 1;
        }
        logI("Receiver is nothing.");
        return 3;
    }

    private UserInfo getUserInfoFromDestination(Destination destination) {
        this.mUserInfo = new UserInfo();
        if (destination.getDestinationType() == 3) {
            logI("Destination.DEST_TYPE_SIP");
            this.mUserInfo.mUserID = null;
            this.mUserInfo.mUserPhoneNumber = destination.getPhoneNo();
            return this.mUserInfo;
        }
        if (destination.getDestinationType() == 4) {
            logI("Destination.DEST_TYPE_CONFERENCE");
            if (destination == null || destination.getConferenceMember() == null || destination.getConferenceMember().isEmpty()) {
                return null;
            }
            Iterator<SimpleUserInfo> iter = destination.getConferenceMember().iterator();
            while (true) {
                if (!iter.hasNext()) {
                    break;
                }
                SimpleUserInfo simpleUserInfo = iter.next();
                if (SimpleUserInfo.TYPE_HOST.equals(simpleUserInfo.getUserType())) {
                    getPhoneNumberFromContact(this.mUserInfo, simpleUserInfo.getUserID());
                    break;
                }
            }
        } else if (destination.getDestinationType() == 2) {
            logI("Destination.DEST_TYPE_COOLOTS");
            getPhoneNumberFromContact(this.mUserInfo, destination.getPhoneNo());
        } else if (destination.getDestinationType() == 5) {
            logI("Destination.DEST_TYPE_P2P_CONFERENCE");
            if (destination != null && destination.getP2PConferenceMember() != null && !destination.getP2PConferenceMember().isEmpty()) {
                Iterator<P2PUserInfo> iter2 = destination.getP2PConferenceMember().iterator();
                while (true) {
                    if (!iter2.hasNext()) {
                        break;
                    }
                    P2PUserInfo userInfo = iter2.next();
                    if (userInfo.userType == 0) {
                        getPhoneNumberFromContact(this.mUserInfo, userInfo.userID);
                        break;
                    }
                }
            } else {
                return null;
            }
        } else {
            logI("Destination.DEST_TYPE_ERROR");
            return null;
        }
        return this.mUserInfo;
    }

    private void getPhoneNumberFromContact(UserInfo userInfo, String userID) {
        userInfo.mUserID = userID;
        BuddyTable contact = ((VAppPhoneManager) MainApplication.mPhoneManager).getChatOnContactManager().getVAppBuddyInfoTextData(userInfo.mUserID);
        if (contact == null) {
            userInfo.mUserPhoneNumber = ChatONStringConvert.getInstance().removeAfterAt(userInfo.mUserID);
            return;
        }
        ArrayList<String> phoneNoArrayListByUserNo = ((VAppPhoneManager) MainApplication.mPhoneManager).getChatOnContactManager().getPhoneNoArrayListByUserNo(contact.getUserNo());
        if (phoneNoArrayListByUserNo != null) {
            userInfo.mUserPhoneNumber = phoneNoArrayListByUserNo.get(0);
        }
    }

    private void getPhoneNumberFromContact(UserInfo userInfo, String userID, String postfix) {
        userInfo.mUserIDs.append(userID);
        BuddyTable contact = ((VAppPhoneManager) MainApplication.mPhoneManager).getChatOnContactManager().getVAppBuddyInfoTextData(userID);
        if (contact == null) {
            userInfo.mUserPhoneNumbers.append(ChatONStringConvert.getInstance().removeAfterAt(userID));
            userInfo.mUserPhoneNumbers.append(postfix);
        } else {
            userInfo.mUserPhoneNumbers.append(((VAppPhoneManager) MainApplication.mPhoneManager).getChatOnContactManager().getPhoneNoArrayListByUserNo(contact.getUserNo()).get(0));
            userInfo.mUserPhoneNumbers.append(postfix);
        }
    }

    private void gotoSMSEditPage(Context context, String phoneNumber) {
        Uri uri = Uri.parse("smsto:" + phoneNumber);
        Intent intent = new Intent("android.intent.action.SENDTO", uri);
        intent.putExtra("sms_body", "");
        intent.setFlags(268435456);
        context.startActivity(intent);
    }

    private void gotoSMSEditPage(Context context, ArrayList<String> phoneNumber) {
        Intent intent = new Intent();
        intent.setAction("android.intent.action.SENDTO");
        Uri phoneUri = Uri.fromParts("smsto", "", null);
        intent.setData(phoneUri);
        intent.putExtra("sendto", phoneNumber);
        context.startActivity(intent);
    }

    private void sendSMSDirect(Context context, String phoneNumber, String msg) {
        String[] recipients = {phoneNumber};
        Intent intent = new Intent("com.android.mms.transaction.Send.SMS");
        intent.putExtra("recipient", recipients);
        intent.putExtra("text", msg);
        context.sendBroadcast(intent);
    }

    public String getUserID() {
        if (this.mUserInfo == null) {
            return null;
        }
        return this.mUserInfo.mUserID;
    }

    public String getUserPhoneNum() {
        if (this.mUserInfo == null) {
            return null;
        }
        return this.mUserInfo.mUserPhoneNumber;
    }
}
