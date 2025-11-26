package com.coolots.chaton.common.util;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.sds.coolots.MainApplication;
import com.sds.coolots.common.util.Log;
import com.sec.chaton.for3rd.IDataAccessService;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class ChatONAIDLAccess {
    private static final String CHATON_AIDL_ACTION_NAME = "com.sec.chaton.for3rd.DATA_ACCESS_SERVICE";
    private static final String CLASSNAME = "[ChatONAIDLAccess]";
    private IDataAccessService mService;
    private final ServiceConnection mServiceConnection = new ServiceConnection() { // from class: com.coolots.chaton.common.util.ChatONAIDLAccess.1
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName name, IBinder service) {
            if (ChatONAIDLAccess.this.mService == null) {
                ChatONAIDLAccess.this.mService = IDataAccessService.Stub.asInterface(service);
            }
            ChatONAIDLAccess.this.logI("ChatON AIDL Service connected.+++++++++++++++++++++++++++++");
            ChatONAIDLAccess.this.mIsBinding = false;
            new Thread(new Runnable() { // from class: com.coolots.chaton.common.util.ChatONAIDLAccess.1.1
                @Override // java.lang.Runnable
                public void run() {
                    ChatONAIDLAccess.this.runProcess();
                }
            }).start();
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName name) {
            ChatONAIDLAccess.this.mService = null;
            ChatONAIDLAccess.this.logI("ChatON AIDL Service disconnected.-----------------------");
            ChatONAIDLAccess.this.mIsBinding = false;
            synchronized (ChatONAIDLAccess.this.mLock) {
                ChatONAIDLAccess.this.exitProcess();
            }
        }
    };
    private final Object mLock = new Object();
    private final ArrayList<ChatONAIDLAccessInterface> mMsgList = new ArrayList<>();
    private ChatONAIDLAccessInterface mCurrentMsg = null;
    private boolean mIsBinding = false;

    private void logE(String message) {
        Log.m2958e(CLASSNAME + message);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void logI(String message) {
        Log.m2963i(CLASSNAME + message);
    }

    public ChatONAIDLAccess() {
        this.mService = null;
        this.mService = null;
    }

    public boolean insertEvent(Object object) {
        boolean ret = true;
        synchronized (this.mLock) {
            if (this.mIsBinding) {
                logI("It is binding ....");
                logI("insertEvent: insert " + (this.mMsgList.size() + 1) + "th event.");
                synchronized (this.mLock) {
                    this.mMsgList.add((ChatONAIDLAccessInterface) object);
                }
            } else if (this.mService == null) {
                logI("Try to bind");
                this.mIsBinding = true;
                ret = MainApplication.mContext.bindService(new Intent(CHATON_AIDL_ACTION_NAME), this.mServiceConnection, 1);
                if (ret) {
                    logI("insertEvent(): insert " + (this.mMsgList.size() + 1) + "th event.");
                    synchronized (this.mLock) {
                        this.mMsgList.add((ChatONAIDLAccessInterface) object);
                    }
                }
            } else {
                logI("Already is binded.");
                logI("insertEvent(): insert " + (this.mMsgList.size() + 1) + "th event.");
                synchronized (this.mLock) {
                    this.mMsgList.add((ChatONAIDLAccessInterface) object);
                }
            }
        }
        return ret;
    }

    public void runProcess() {
        logI("runProcess-----------------------");
        while (true) {
            synchronized (this.mLock) {
                if (this.mMsgList.isEmpty()) {
                    logI("Message is empty");
                    exitProcess();
                    return;
                } else {
                    this.mCurrentMsg = this.mMsgList.get(0);
                    this.mMsgList.remove(0);
                }
            }
            this.mCurrentMsg.runProcess(this.mService);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void exitProcess() {
        logI("exitProcess & message clear");
        MainApplication.mContext.unbindService(this.mServiceConnection);
        this.mService = null;
        this.mMsgList.clear();
        this.mCurrentMsg = null;
        this.mIsBinding = false;
    }
}
