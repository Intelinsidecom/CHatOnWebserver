package com.coolots.chaton.common.coolotsinterface;

import com.android.internal.telephony.ITelephony;
import com.sds.coolots.MainApplication;
import com.sds.coolots.call.model.CallState;
import com.sds.coolots.call.model.CallStatusData;
import com.sds.coolots.common.coolotsinterface.MobilePhoneStateInterface;
import com.sds.coolots.common.util.Log;

/* loaded from: classes.dex */
public class MobilePhoneState implements MobilePhoneStateInterface {
    private int mTelephonyMode = 0;
    private int mCoolotsMode = 0;
    private int mTelephonyCallType = 0;
    private ITelephony mITelephonyInterface = null;

    @Override // com.sds.coolots.common.coolotsinterface.MobilePhoneStateInterface
    public void updateMobilePhoneState() {
        updateTelephonyState();
        updateCoolotsState();
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x0015, code lost:
    
        r3.mTelephonyMode = 0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void updateTelephonyState() {
        /*
            r3 = this;
            r2 = 0
            com.android.internal.telephony.ITelephony r1 = r3.mITelephonyInterface
            if (r1 != 0) goto L11
            java.lang.String r1 = "phone"
            android.os.IBinder r1 = android.os.ServiceManager.checkService(r1)
            com.android.internal.telephony.ITelephony r1 = com.android.internal.telephony.ITelephony.Stub.asInterface(r1)
            r3.mITelephonyInterface = r1
        L11:
            com.android.internal.telephony.ITelephony r1 = r3.mITelephonyInterface
            if (r1 != 0) goto L16
        L15:
            return
        L16:
            com.android.internal.telephony.ITelephony r1 = r3.mITelephonyInterface     // Catch: android.os.RemoteException -> L22
            boolean r1 = r1.isIdle()     // Catch: android.os.RemoteException -> L22
            if (r1 == 0) goto L2b
            r1 = 0
            r3.mTelephonyMode = r1     // Catch: android.os.RemoteException -> L22
            goto L15
        L22:
            r0 = move-exception
            r3.mTelephonyMode = r2
            r0.printStackTrace()
        L28:
            r3.mTelephonyMode = r2
            goto L15
        L2b:
            com.android.internal.telephony.ITelephony r1 = r3.mITelephonyInterface     // Catch: android.os.RemoteException -> L22
            boolean r1 = r1.isRinging()     // Catch: android.os.RemoteException -> L22
            if (r1 == 0) goto L37
            r1 = 1
            r3.mTelephonyMode = r1     // Catch: android.os.RemoteException -> L22
            goto L15
        L37:
            com.android.internal.telephony.ITelephony r1 = r3.mITelephonyInterface     // Catch: android.os.RemoteException -> L22
            boolean r1 = r1.isOffhook()     // Catch: android.os.RemoteException -> L22
            if (r1 == 0) goto L28
            r1 = 2
            r3.mTelephonyMode = r1     // Catch: android.os.RemoteException -> L22
            goto L15
        */
        throw new UnsupportedOperationException("Method not decompiled: com.coolots.chaton.common.coolotsinterface.MobilePhoneState.updateTelephonyState():void");
    }

    private void updateCoolotsState() {
        CallStatusData callInfo = new CallStatusData();
        MainApplication.mPhoneManager.getPhoneStateMachine().updateCallInfo(callInfo);
        Log.m2958e("<<YHT100>> callInfo.getCallState():" + callInfo.getCallState());
        if (!callInfo.isValidity()) {
            this.mCoolotsMode = 0;
            return;
        }
        if (CallState.isConnected(callInfo.getCallState()) || CallState.isCalling(callInfo.getCallState())) {
            if (callInfo.isUseVideo()) {
                this.mCoolotsMode = 4;
                return;
            } else {
                this.mCoolotsMode = 3;
                return;
            }
        }
        this.mCoolotsMode = 0;
    }

    @Override // com.sds.coolots.common.coolotsinterface.MobilePhoneStateInterface
    public int getTelephonyState() {
        return this.mTelephonyMode;
    }

    @Override // com.sds.coolots.common.coolotsinterface.MobilePhoneStateInterface
    public int getCoolotsState() {
        return this.mCoolotsMode;
    }

    @Override // com.sds.coolots.common.coolotsinterface.MobilePhoneStateInterface
    public int getTelephonyCallType() {
        return this.mTelephonyCallType;
    }
}
