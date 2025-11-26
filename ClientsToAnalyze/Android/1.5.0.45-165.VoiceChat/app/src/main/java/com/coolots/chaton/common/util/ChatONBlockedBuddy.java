package com.coolots.chaton.common.util;

import android.os.Handler;
import android.os.Message;
import android.os.RemoteException;
import com.sds.coolots.common.util.Log;
import com.sec.chaton.for3rd.IDataAccessService;

/* loaded from: classes.dex */
public class ChatONBlockedBuddy implements ChatONAIDLAccessInterface {
    private static final String CLASSNAME = "[ChatONBlockedBuddy]";
    private static final int RETURN_BUDDY_STATUS_BLOCKED_BUDDY = 2;
    private static final int RETURN_BUDDY_STATUS_MY_BUDDY = 0;
    private static final int RETURN_BUDDY_STATUS_NO_CHATON_USER = 3;
    private static final int RETURN_BUDDY_STATUS_NO_MY_BUDDY = 1;
    private static final int RETURN_BUDDY_STATUS_TIMEOUT = -1;
    private static final int TIMEOUT_DURATION_MSEC = 3000;
    private final boolean IS_LATEST_VERSION = true;
    private Integer mEventWhat;
    private Handler mHandler;
    private String mMSISDN;

    private void logE(String message) {
        Log.m2958e(CLASSNAME + message);
    }

    private void logI(String message) {
        Log.m2963i(CLASSNAME + message);
    }

    public ChatONBlockedBuddy(Integer eventNum, Handler handler, String userID) {
        this.mMSISDN = null;
        this.mHandler = null;
        this.mEventWhat = eventNum;
        this.mMSISDN = ChatONStringConvert.getInstance().removeAfterAt(userID);
        this.mHandler = handler;
    }

    @Override // com.coolots.chaton.common.util.ChatONAIDLAccessInterface
    public void runProcess(IDataAccessService service) {
        logI("runProcess() timeout 3000msec");
        boolean isBlockedBuddy = true;
        try {
            int result = service.getBuddyStatus(this.mMSISDN, 3000);
            logI("service.getBuddyStatus() return: " + result);
            switch (result) {
                case -1:
                case 2:
                    isBlockedBuddy = true;
                    break;
                case 0:
                case 1:
                default:
                    isBlockedBuddy = false;
                    break;
            }
        } catch (RemoteException e) {
            logE("RemoteException!!! getBuddyStatus()");
        } catch (NoSuchMethodError e2) {
            logE("NoSuchMethodError!!! getBuddyStatus()");
        }
        if (this.mHandler != null) {
            logI("send message " + isBlockedBuddy);
            Message msg = new Message();
            msg.what = this.mEventWhat.intValue();
            msg.obj = Boolean.valueOf(isBlockedBuddy);
            this.mHandler.sendMessage(msg);
        }
    }
}
