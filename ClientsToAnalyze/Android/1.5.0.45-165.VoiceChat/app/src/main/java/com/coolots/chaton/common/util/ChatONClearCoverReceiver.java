package com.coolots.chaton.common.util;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.view.IWindowManager;
import com.sds.coolots.MainApplication;
import com.sds.coolots.call.model.CallStatusData;

/* loaded from: classes.dex */
public class ChatONClearCoverReceiver extends BroadcastReceiver {
    private static final String VOIP_ACTION_MOVETOTOP = "movetotop_voip";
    private static final String VOIP_ACTION_TYPE = "VOIP_ACTION";
    private String action;
    private IWindowManager mWindowManager = null;

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        this.action = intent.getAction();
        if (this.action.equals("com.samsung.cover.OPEN") && !isCoverOpen() && isCallActiveState()) {
            Intent movetotopIntent = new Intent("com.sds.coolots.broadcast.VOIPACTION");
            movetotopIntent.putExtra(VOIP_ACTION_TYPE, VOIP_ACTION_MOVETOTOP);
            context.sendBroadcast(movetotopIntent);
        }
    }

    public boolean isCoverOpen() {
        if (this.mWindowManager == null) {
            this.mWindowManager = IWindowManager.Stub.asInterface(ServiceManager.getService("window"));
        }
        try {
            boolean result = this.mWindowManager.isCoverOpen();
            return result;
        } catch (RemoteException e) {
            e.printStackTrace();
            return true;
        } catch (NoSuchMethodError e2) {
            e2.printStackTrace();
            return true;
        }
    }

    private boolean isCallActiveState() {
        CallStatusData callInfo = new CallStatusData();
        MainApplication.mPhoneManager.getPhoneStateMachine().updateCallInfo(callInfo);
        int callState = callInfo.getCallState();
        if (callInfo.isValidity()) {
            return callState == 0 || callState == 1 || callState == 2 || callState == 4 || callState == 5;
        }
        return false;
    }
}
