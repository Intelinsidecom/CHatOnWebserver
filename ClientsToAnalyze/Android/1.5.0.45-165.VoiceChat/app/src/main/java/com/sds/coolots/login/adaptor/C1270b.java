package com.sds.coolots.login.adaptor;

import android.os.Handler;
import android.os.Message;
import com.coolots.p2pmsg.MessageInfo;
import com.coolots.p2pmsg.model.EWalletAutoChargeRep;
import com.coolots.p2pmsg.model.MsgBody;
import com.coolots.p2pmsg.model.P2PMsg;
import com.sds.coolots.MainApplication;
import com.sds.coolots.common.httpAdaptor.HttpAdaptor;
import com.sds.coolots.common.model.EventCode;
import com.sds.coolots.common.util.Log;

/* renamed from: com.sds.coolots.login.adaptor.b */
/* loaded from: classes.dex */
public class C1270b extends HttpAdaptor {

    /* renamed from: a */
    private int f3200a;

    public C1270b(MsgBody msgBody, Handler handler) {
        super(MessageInfo.EWalletAutoChargeAsk, msgBody, handler, 6000);
        this.f3200a = 0;
        this.mbCheckNonce = false;
    }

    /* renamed from: a */
    private void m3068a(int i, int i2, int i3, Object obj, Handler handler) {
        Message messageObtain = Message.obtain();
        messageObtain.what = i;
        messageObtain.arg1 = i2;
        messageObtain.arg2 = i3;
        messageObtain.obj = obj;
        if (handler != null) {
            handler.sendMessage(messageObtain);
        }
    }

    @Override // com.sds.coolots.common.httpAdaptor.HttpAdaptor
    protected void handleNormalError(P2PMsg p2PMsg) {
        sendEvent(EventCode.EVENT_COMMON_GET_AUTO_CHARGE_UNKNOWN, 0, null);
    }

    @Override // com.sds.coolots.common.httpAdaptor.HttpAdaptor
    protected void printAdaptorKind() {
        logE("ADAPTOR_TRACE EWalletAutoChargeAdaptor EWalletAutoChargeAsk");
    }

    @Override // com.sds.coolots.common.httpAdaptor.HttpAdaptor
    protected void processRecvMessage(P2PMsg p2PMsg) {
        MsgBody msgBody = p2PMsg.getMsgBody();
        if (msgBody instanceof EWalletAutoChargeRep) {
            EWalletAutoChargeRep eWalletAutoChargeRep = (EWalletAutoChargeRep) msgBody;
            if (eWalletAutoChargeRep.getAutoChargeResult() != null) {
                if (eWalletAutoChargeRep.getAutoChargeResult().equals(EWalletAutoChargeRep.RESULT_SUCCESS) || eWalletAutoChargeRep.getAutoChargeResult().equals(EWalletAutoChargeRep.RESULT_SUCCESS_TEST)) {
                    sendEvent(EventCode.EVENT_COMMON_GET_AUTO_CHARGE_SUCCESS, 0, null);
                } else {
                    sendEvent(EventCode.EVENT_COMMON_GET_AUTO_CHARGE_FAIL, 0, null);
                }
            }
        }
    }

    @Override // com.sds.coolots.common.httpAdaptor.HttpAdaptor
    protected void processTimeOutError() {
        logE("ADAPTOR_TRACE EWalletAutoChargeAdaptor's processTimeOutError");
        super.processTimeOutError();
    }

    @Override // com.sds.coolots.common.httpAdaptor.HttpAdaptor
    protected void sendEvent(int i, int i2, Object obj) {
        if (i < 0) {
            this.f3200a = i;
            Log.m2963i(Integer.toString(this.f3200a));
        }
        if (obj == null) {
            if (this.mHandler != null) {
                m3068a(this.mDispathInfo.getDispatchCode(), i, i2, this.mObject, this.mHandler);
            }
        } else if (this.mHandler != null) {
            m3068a(this.mDispathInfo.getDispatchCode(), i, i2, obj, this.mHandler);
        }
    }

    @Override // com.sds.coolots.common.httpAdaptor.HttpAdaptor
    protected void setUserInfo() {
        if (MainApplication.mConfig.getProfileUserID() != null && !MainApplication.mConfig.getProfileUserID().equals("")) {
            this.mUserID = MainApplication.mConfig.getProfileUserID();
        }
        if (MainApplication.mConfig.getProfileDeviceID() != null) {
            this.mDeviceID = MainApplication.mConfig.getProfileDeviceID();
        }
        if (MainApplication.mConfig.getProfilePasswd() == null || MainApplication.mConfig.getProfilePasswd().equals("")) {
            return;
        }
        this.mPasswd = MainApplication.mConfig.getProfilePasswd();
    }
}
