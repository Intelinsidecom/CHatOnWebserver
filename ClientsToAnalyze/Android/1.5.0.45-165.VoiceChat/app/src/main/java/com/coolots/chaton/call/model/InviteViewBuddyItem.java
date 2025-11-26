package com.coolots.chaton.call.model;

import com.sds.coolots.common.util.Log;
import com.sds.coolots.common.view.DisposeInterface;

/* loaded from: classes.dex */
public class InviteViewBuddyItem implements DisposeInterface {
    private static final String CLASSNAME = "[InviteViewBuddyItem]";
    public static final int INVITE_STATE_CONNECTED = 3;
    public static final int INVITE_STATE_ENDED = 2;
    public static final int INVITE_STATE_WAITING = 1;
    private int mUserCallState;
    private String mUserDiscription;
    private String mUserID;
    private String mUserMessage;
    private final long mUserNo;
    private String mUserType;

    private void logI(String message) {
        Log.m2963i(CLASSNAME + message);
    }

    private void logE(String message) {
        Log.m2958e(CLASSNAME + message);
    }

    public InviteViewBuddyItem(String userID, long userNo, String userDiscription, String userMessage, int inviteState, String userType) {
        this.mUserNo = userNo;
        this.mUserID = userID;
        this.mUserDiscription = userDiscription;
        this.mUserMessage = userMessage;
        if (inviteState == 1) {
            this.mUserCallState = 1;
        } else if (inviteState == 3) {
            this.mUserCallState = 3;
        } else if (inviteState == 2) {
            this.mUserCallState = 2;
        } else {
            this.mUserCallState = 1;
        }
        this.mUserType = userType;
    }

    public String getUserDiscription() {
        return this.mUserDiscription;
    }

    public long getUserNo() {
        return this.mUserNo;
    }

    public String getUserID() {
        return this.mUserID;
    }

    public int getUserCallState() {
        return this.mUserCallState;
    }

    public String getUserMessage() {
        return this.mUserMessage;
    }

    public String getUserType() {
        return this.mUserType;
    }

    public void setCallState(int state) {
        this.mUserCallState = state;
    }

    public int getCallState() {
        return this.mUserCallState;
    }

    public void description() {
        logI("user no: " + this.mUserNo);
        logI("user id: " + this.mUserID);
        logI("user name: " + this.mUserDiscription);
        logI("user message: " + this.mUserMessage);
        logI("user call state: " + this.mUserCallState);
        logI("user type: " + this.mUserType);
    }

    @Override // com.sds.coolots.common.view.DisposeInterface
    public void dispose() {
        this.mUserID = null;
        this.mUserDiscription = null;
        this.mUserMessage = null;
    }
}
