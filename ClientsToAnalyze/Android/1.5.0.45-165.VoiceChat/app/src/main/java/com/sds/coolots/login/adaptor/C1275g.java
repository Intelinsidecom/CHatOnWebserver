package com.sds.coolots.login.adaptor;

import android.os.Handler;
import android.os.Message;
import com.coolots.p2pmsg.MessageInfo;
import com.coolots.p2pmsg.model.EWalletInfoRep;
import com.coolots.p2pmsg.model.MsgBody;
import com.coolots.p2pmsg.model.P2PMsg;
import com.sds.coolots.MainApplication;
import com.sds.coolots.call.model.Destination;
import com.sds.coolots.common.httpAdaptor.HttpAdaptor;
import com.sds.coolots.common.util.Log;
import java.util.ArrayList;
import java.util.Iterator;

/* renamed from: com.sds.coolots.login.adaptor.g */
/* loaded from: classes.dex */
public class C1275g extends HttpAdaptor {

    /* renamed from: a */
    private Destination f3203a;

    /* renamed from: b */
    private boolean f3204b;

    /* renamed from: c */
    private int f3205c;

    /* renamed from: d */
    private final ArrayList f3206d;

    public C1275g(MsgBody msgBody, Handler handler) {
        super(MessageInfo.EWalletInfoAsk, msgBody, handler, 6000);
        this.f3203a = null;
        this.f3204b = false;
        this.f3205c = 0;
        this.mbCheckNonce = false;
        this.f3206d = null;
    }

    public C1275g(MsgBody msgBody, ArrayList arrayList) {
        super(MessageInfo.EWalletInfoAsk, msgBody, null, 6000);
        this.f3203a = null;
        this.f3204b = false;
        this.f3205c = 0;
        this.f3203a = null;
        this.f3204b = false;
        this.mbCheckNonce = false;
        this.f3206d = arrayList;
    }

    public C1275g(MsgBody msgBody, ArrayList arrayList, Destination destination, boolean z) {
        super(MessageInfo.EWalletInfoAsk, msgBody, null, 6000);
        this.f3203a = null;
        this.f3204b = false;
        this.f3205c = 0;
        this.f3203a = destination;
        this.f3204b = z;
        this.mbCheckNonce = false;
        this.f3206d = arrayList;
    }

    /* renamed from: a */
    private void m3072a(int i, int i2, int i3, Object obj, Handler handler) {
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
    protected void printAdaptorKind() {
        logE("ADAPTOR_TRACE eWalletInfoAdaptor EWalletInfoAsk");
    }

    @Override // com.sds.coolots.common.httpAdaptor.HttpAdaptor
    protected void processRecvMessage(P2PMsg p2PMsg) {
        MsgBody msgBody = p2PMsg.getMsgBody();
        if (msgBody instanceof EWalletInfoRep) {
            ((EWalletInfoRep) msgBody).getEWalletInfoList();
        }
    }

    @Override // com.sds.coolots.common.httpAdaptor.HttpAdaptor
    protected void processTimeOutError() {
        logE("ADAPTOR_TRACE eWalletInfoAdaptor's processTimeOutError");
        super.processTimeOutError();
    }

    @Override // com.sds.coolots.common.httpAdaptor.HttpAdaptor
    protected void sendEvent(int i, int i2, Object obj) {
        if (i < 0) {
            this.f3205c = i;
            Log.m2963i(Integer.toString(this.f3205c));
        }
        if (obj == null) {
            if (this.mHandler != null) {
                m3072a(this.mDispathInfo.getDispatchCode(), i, i2, this.mObject, this.mHandler);
            }
            if (this.f3206d == null || this.f3206d.size() <= 0) {
                return;
            }
            Iterator it = this.f3206d.iterator();
            while (it.hasNext()) {
                Handler handler = (Handler) it.next();
                if (handler != null) {
                    m3072a(this.mDispathInfo.getDispatchCode(), i, i2, this.mObject, handler);
                }
            }
            return;
        }
        if (this.mHandler != null) {
            m3072a(this.mDispathInfo.getDispatchCode(), i, i2, obj, this.mHandler);
        }
        if (this.f3206d == null || this.f3206d.size() <= 0) {
            return;
        }
        Iterator it2 = this.f3206d.iterator();
        while (it2.hasNext()) {
            Handler handler2 = (Handler) it2.next();
            if (handler2 != null) {
                m3072a(this.mDispathInfo.getDispatchCode(), i, i2, obj, handler2);
            }
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
