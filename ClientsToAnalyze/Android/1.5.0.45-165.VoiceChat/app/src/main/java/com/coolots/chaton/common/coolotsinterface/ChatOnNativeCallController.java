package com.coolots.chaton.common.coolotsinterface;

import android.os.IVoIPInterface;
import android.os.RemoteException;
import android.os.ServiceManager;
import com.android.internal.telephony.ITelephony;
import com.sds.coolots.common.coolotsinterface.NativeCallInterface;
import com.sds.coolots.common.util.Log;

/* loaded from: classes.dex */
public class ChatOnNativeCallController implements NativeCallInterface {
    public static final String CLASSNAME = "[ChatOnNativeCallController]";
    public ITelephony mITelephonyInterface = null;
    public IVoIPInterface mIVoIPInterface = null;

    private void logE(String message) {
        Log.m2958e(CLASSNAME + message);
    }

    @Override // com.sds.coolots.common.coolotsinterface.NativeCallInterface
    public void hangUpCurrent3gCall() {
        if (this.mITelephonyInterface == null) {
            this.mITelephonyInterface = ITelephony.Stub.asInterface(ServiceManager.checkService("phone"));
        }
        if (this.mITelephonyInterface != null) {
            try {
                this.mITelephonyInterface.silenceRinger();
                this.mITelephonyInterface.endCall();
                logE("VOIP_INTERFACE ITelephony silenceRinger hangUpCurrent3gCall");
                logE("VOIP_INTERFACE ITelephony endCall hangUpCurrent3gCall");
            } catch (RemoteException e) {
                e.printStackTrace();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    @Override // com.sds.coolots.common.coolotsinterface.NativeCallInterface
    public boolean isCurrentCall() {
        if (this.mITelephonyInterface == null) {
            this.mITelephonyInterface = ITelephony.Stub.asInterface(ServiceManager.checkService("phone"));
        }
        if (this.mIVoIPInterface == null) {
            this.mIVoIPInterface = IVoIPInterface.Stub.asInterface(ServiceManager.checkService("voip"));
        }
        try {
            if ((this.mITelephonyInterface == null || this.mITelephonyInterface.isIdle()) && (this.mIVoIPInterface == null || this.mIVoIPInterface.getCurrentVoIPNumber() == null)) {
                return false;
            }
            logE("VOIP_INTERFACE ITelephony isIdle");
            logE("VOIP_INTERFACE IVoIPInterface getCurrentVoIPNumber");
            return true;
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }

    @Override // com.sds.coolots.common.coolotsinterface.NativeCallInterface
    public void hangUpIncomingCall() {
        if (this.mITelephonyInterface == null) {
            this.mITelephonyInterface = ITelephony.Stub.asInterface(ServiceManager.checkService("phone"));
        }
        if (this.mITelephonyInterface != null) {
            try {
                this.mITelephonyInterface.silenceRinger();
                this.mITelephonyInterface.endCall();
                logE("VOIP_INTERFACE ITelephony silenceRinger hangUpIncomingCall(3G)");
                logE("VOIP_INTERFACE ITelephony endCall hangUpIncomingCall(3G)");
            } catch (RemoteException e) {
                e.printStackTrace();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    @Override // com.sds.coolots.common.coolotsinterface.NativeCallInterface
    public void noticeVoipDisconnecting(String packageName, String phoneNo) {
        if (this.mIVoIPInterface == null) {
            this.mIVoIPInterface = IVoIPInterface.Stub.asInterface(ServiceManager.checkService("voip"));
        }
        if (this.mIVoIPInterface != null) {
            try {
                this.mIVoIPInterface.setVoIPDisconnecting(packageName, phoneNo);
                logE("VOIP_INTERFACE IVoIPInterface setVoIPDisconnecting");
            } catch (RemoteException e) {
                e.printStackTrace();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }
}
