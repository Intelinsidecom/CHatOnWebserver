package com.sds.coolots.call.consent.handler;

import com.coolots.p2pmsg.MessageInfo;
import com.coolots.p2pmsg.model.MsgHeader;
import com.coolots.p2pmsg.model.NotifyConsentAsk;
import com.coolots.p2pmsg.model.ProposeConsentAsk;
import com.coolots.p2pmsg.model.ProposeConsentRep;
import com.coolots.p2pmsg.model.PushTargetInfo;
import com.coolots.p2pmsg.model.RequestConsentAsk;
import com.coolots.p2pmsg.model.RequestConsentRep;
import com.coolots.p2pmsg.model.SimpleUserInfo;
import com.sds.coolots.EngineInterface;
import com.sds.coolots.MainApplication;
import com.sds.coolots.call.consent.acceptor.C1152b;
import com.sds.coolots.call.consent.acceptor.C1155e;
import com.sds.coolots.call.consent.handler.CallConsentHandler;
import com.sds.coolots.call.model.Destination;
import com.sds.coolots.call.p014b.C1149a;
import com.sds.coolots.common.util.Log;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

/* renamed from: com.sds.coolots.call.consent.handler.c */
/* loaded from: classes.dex */
public class HandlerC1160c extends AbstractHandlerC1163f {

    /* renamed from: k */
    private static final String f2377k = "[CallConsentHandlerForParticipantReceiver]<<YHT77>>";

    /* renamed from: l */
    private boolean f2378l;

    /* renamed from: m */
    private boolean f2379m;

    /* renamed from: n */
    private boolean f2380n;

    /* renamed from: o */
    private String f2381o;

    public HandlerC1160c(Destination destination, CallConsentHandler.CallConsentCallback callConsentCallback, C1162e c1162e, C1162e c1162e2, int i) {
        super(destination, callConsentCallback, c1162e, c1162e2, i);
        this.f2378l = false;
        this.f2379m = false;
        this.f2380n = false;
        m2147a(false);
    }

    /* renamed from: a */
    private void m2159a(boolean z, int i) {
        m2161d("RequestConsentRep!!! result:" + z);
        RequestConsentRep requestConsentRep = new RequestConsentRep();
        requestConsentRep.setConferenceNo(this.f2363a.getPhoneNo());
        requestConsentRep.setAccept(z);
        requestConsentRep.setCanceledByTimer(false);
        requestConsentRep.setConsentType(this.f2365c.f2383a);
        requestConsentRep.setOption(this.f2365c.f2384b);
        requestConsentRep.setRequesterID(MainApplication.mConfig.getProfileUserID());
        requestConsentRep.setRequestKey(i);
        m2161d("RequestConsentRep!!! msg:" + requestConsentRep.toString());
        MsgHeader msgHeaderM2140a = C1149a.m2140a(MessageInfo.RequestConsentRep.getServiceCode(), MessageInfo.RequestConsentRep.getMessageCode());
        ArrayList arrayList = new ArrayList();
        Iterator it = this.f2363a.getConferenceMember().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            SimpleUserInfo simpleUserInfo = (SimpleUserInfo) it.next();
            if (SimpleUserInfo.TYPE_HOST.equals(simpleUserInfo.getUserType())) {
                PushTargetInfo pushTargetInfo = new PushTargetInfo();
                pushTargetInfo.setReceiverUserID(simpleUserInfo.getUserID());
                pushTargetInfo.setReceiverUserNo(simpleUserInfo.getUserNo());
                pushTargetInfo.setReceiverDeviceID(simpleUserInfo.getDeviceID());
                arrayList.add(pushTargetInfo);
                break;
            }
        }
        C1149a.m2141a(msgHeaderM2140a, requestConsentRep, arrayList);
    }

    /* renamed from: c */
    private void m2160c(String str) {
        Log.m2958e(f2377k + str);
    }

    /* renamed from: d */
    private void m2161d(String str) {
        Log.m2963i(f2377k + str);
    }

    @Override // com.sds.coolots.call.consent.handler.CallConsentInterface
    public boolean acceptConsent() {
        m2161d("acceptConsent!!!");
        this.f2378l = true;
        this.f2379m = true;
        m2159a(true, this.f2368f);
        return true;
    }

    @Override // com.sds.coolots.call.consent.handler.CallConsentHandler
    /* renamed from: b */
    protected void mo2150b() {
        m2161d("handleConsentTimeout!!!");
        if ((this.f2369g instanceof C1152b) || (this.f2369g instanceof C1155e)) {
            this.f2366d.processCallConsentTimeOut();
        } else {
            m2149a(false, true, MainApplication.mConfig.getProfileUserID());
            dispose();
        }
    }

    @Override // com.sds.coolots.call.consent.handler.CallConsentInterface
    public void handleNotifyConsentAsk(NotifyConsentAsk notifyConsentAsk) {
        m2161d("handleNotifyConsentAsk!!!");
        if (this.f2363a.getPhoneNo().equals(notifyConsentAsk.getConferenceNo())) {
            if (notifyConsentAsk.getAccept()) {
                m2148a(false, this.f2381o);
            } else {
                m2149a(false, false, notifyConsentAsk.getRejectUserID());
            }
            dispose();
        }
    }

    @Override // com.sds.coolots.call.consent.handler.CallConsentInterface
    public void handleProposeConsentAsk(ProposeConsentAsk proposeConsentAsk) {
        m2160c("handleProposeConsentAsk!!! invalid state");
    }

    @Override // com.sds.coolots.call.consent.handler.CallConsentInterface
    public void handleProposeConsentRep(ProposeConsentRep proposeConsentRep) {
        m2160c("handleProposeConsentRep!!! invalid state");
    }

    @Override // com.sds.coolots.call.consent.handler.CallConsentInterface
    public void handleRequestConsentAsk(RequestConsentAsk requestConsentAsk) {
        m2161d("handleRequestConsentAsk!!!");
        if (this.f2363a.getPhoneNo().equals(requestConsentAsk.getConferenceNo())) {
            m2161d("<CIH> handleRequestConsentAsk() step 1");
            if (this.f2368f == requestConsentAsk.getRequestKey()) {
                this.f2381o = requestConsentAsk.getRequesterID();
                if (this.f2380n) {
                    return;
                }
                m2146a(this.f2381o);
                this.f2380n = true;
                return;
            }
            m2161d("<CIH> handleRequestConsentAsk() step 2");
            if (!this.f2369g.isAcceptDuplicationRequest(requestConsentAsk.getConsentType(), requestConsentAsk.getOption())) {
                m2161d("<CIH> handleRequestConsentAsk() step 6");
                m2159a(false, requestConsentAsk.getRequestKey());
                this.f2366d.notifyClearConsent();
                dispose();
                return;
            }
            m2161d("<CIH> handleRequestConsentAsk() step 3");
            m2147a(false);
            this.f2381o = requestConsentAsk.getRequesterID();
            this.f2368f = requestConsentAsk.getRequestKey();
            this.f2365c.f2383a = requestConsentAsk.getConsentType();
            this.f2365c.f2384b = requestConsentAsk.getOption();
            if (this.f2378l) {
                m2161d("<CIH> handleRequestConsentAsk() step 4");
                m2159a(this.f2379m, this.f2368f);
                return;
            }
            m2161d("<CIH> handleRequestConsentAsk() step 5");
            if (this.f2380n) {
                return;
            }
            m2146a(this.f2381o);
            this.f2380n = true;
        }
    }

    @Override // com.sds.coolots.call.consent.handler.CallConsentInterface
    public void handleRequestConsentRep(RequestConsentRep requestConsentRep) {
        m2160c("handleRequestConsentRep!!! invalid state");
    }

    @Override // com.sds.coolots.call.consent.handler.CallConsentInterface
    public void processTimeoutResult(boolean z, boolean z2, int i, int i2) throws IOException {
        m2161d("processTimeoutResult!!! result : " + z + " isCallSwitching : " + z2 + " option : " + i);
        if (z) {
            if (z2) {
                m2161d("<CIH> 엔진에 콜 스위칭을 알림");
                EngineInterface.getInstance().notifyCallSwitching(i2, i, 1);
            }
            m2148a(false, this.f2381o);
        } else {
            m2149a(false, true, MainApplication.mConfig.getProfileUserID());
        }
        dispose();
    }

    @Override // com.sds.coolots.call.consent.handler.CallConsentInterface
    public boolean rejectConsent(int i) {
        m2161d("rejectConsent!!! rejectCode:" + i);
        this.f2378l = true;
        this.f2379m = false;
        m2159a(false, this.f2368f);
        return true;
    }

    @Override // com.sds.coolots.call.consent.handler.CallConsentInterface
    public boolean requestConsent() {
        m2160c("requestConsent!!! invalid state");
        return this.f2369g.isAcceptDuplicationRequest(this.f2365c.f2383a, this.f2365c.f2384b) ? acceptConsent() : rejectConsent(1);
    }
}
