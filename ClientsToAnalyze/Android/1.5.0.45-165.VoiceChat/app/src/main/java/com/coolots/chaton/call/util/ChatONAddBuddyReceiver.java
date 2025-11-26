package com.coolots.chaton.call.util;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.coolots.chaton.call.controller.AddBuddyController;
import com.coolots.sso.util.ChatONInterface;
import com.sds.coolots.common.util.Log;
import com.sec.chaton.clientapi.NotificationAPI;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class ChatONAddBuddyReceiver extends BroadcastReceiver {
    public static final String ADD_BUDDY_RESULT = "com.sec.chaton.api.background.ADD_BUDDY_RESULT";
    private static AddBuddyController mAddBuddyController;
    private static ArrayList<String> mUnknownbuddylist;
    private final String CLASSNAME = "[ChatONAddBuddyReceiver]";

    private void logI(String message) {
        Log.m2963i("[ChatONAddBuddyReceiver]" + message);
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context arg0, Intent arg1) {
        logI("parkshin onReceive()");
        if (arg1 != null && arg1.getAction().equals(ADD_BUDDY_RESULT)) {
            boolean addBuddyResult = arg1.getBooleanExtra(ChatONInterface.EXTRAS_KEY_RESULT, false);
            int addBuddyResultErrCode = arg1.getIntExtra(NotificationAPI.RESULT_CODE, -1);
            long addBuddyRequestId = arg1.getLongExtra(NotificationAPI.REQUEST_ID, -1L);
            logI("onReceive() addBuddyResult = " + addBuddyResult);
            logI("onReceive() addBuddyResultErrCode = " + addBuddyResultErrCode);
            logI("onReceive() addBuddyRequestId = " + addBuddyRequestId);
            if (mAddBuddyController != null) {
                if (!addBuddyResult) {
                    mAddBuddyController.retryCallAfterAddBuddy(false);
                }
                if (mUnknownbuddylist != null && !mUnknownbuddylist.isEmpty()) {
                    mUnknownbuddylist.remove(0);
                    if (mUnknownbuddylist.isEmpty()) {
                        logI("onReceive() complete - add buddies");
                        mAddBuddyController.retryCallAfterAddBuddy(addBuddyResult);
                        return;
                    }
                    return;
                }
                logI("onReceive() complete add buddy");
                mAddBuddyController.retryCallAfterAddBuddy(addBuddyResult);
            }
        }
    }

    public static void registerController(AddBuddyController controller) {
        mAddBuddyController = controller;
    }

    public static void unregisterConteroller() {
        mAddBuddyController = null;
        if (mUnknownbuddylist != null) {
            mUnknownbuddylist.clear();
        }
    }

    public static void setUnknownbuddylist(ArrayList<String> unknownbuddylist) {
        mUnknownbuddylist = unknownbuddylist;
    }
}
