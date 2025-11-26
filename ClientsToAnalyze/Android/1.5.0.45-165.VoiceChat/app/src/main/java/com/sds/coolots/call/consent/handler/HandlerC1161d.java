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
import com.sds.coolots.MainApplication;
import com.sds.coolots.call.consent.acceptor.C1152b;
import com.sds.coolots.call.consent.acceptor.C1155e;
import com.sds.coolots.call.consent.handler.CallConsentHandler;
import com.sds.coolots.call.model.Destination;
import com.sds.coolots.call.p014b.C1149a;
import com.sds.coolots.common.util.Log;
import java.util.ArrayList;
import java.util.Iterator;

/* renamed from: com.sds.coolots.call.consent.handler.d */
/* loaded from: classes.dex */
public class HandlerC1161d extends AbstractHandlerC1163f {

    /* renamed from: k */
    private static final String f2382k = "[CallConsentHandlerForParticipantRequester]<<YHT77>>";

    public HandlerC1161d(Destination destination, CallConsentHandler.CallConsentCallback callConsentCallback, C1162e c1162e, C1162e c1162e2, int i) {
        super(destination, callConsentCallback, c1162e, c1162e2, i);
        m2147a(false);
    }

    /* renamed from: a */
    private void m2162a(int i, boolean z) {
        m2165d("sendRequestConsentRep!!! result:" + z);
        RequestConsentRep requestConsentRep = new RequestConsentRep();
        requestConsentRep.setConferenceNo(this.f2363a.getPhoneNo());
        requestConsentRep.setConsentType(this.f2365c.f2383a);
        requestConsentRep.setOption(this.f2365c.f2384b);
        requestConsentRep.setRequestKey(i);
        requestConsentRep.setAccept(z);
        requestConsentRep.setRequesterID(MainApplication.mConfig.getProfileUserID());
        m2165d("sendRequestConsentRep!!! msg:" + requestConsentRep.toString());
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

    /* renamed from: b */
    private void m2163b(boolean z, boolean z2, String str) {
        m2165d("notifyProposeFailed!, <CIH> isRequester = " + z + ", isTimeCancel = " + z2 + ", rejectUserID = " + str);
        this.f2366d.notifyProposeResult(false, this.f2365c.f2383a, this.f2365c.f2384b, z, z2, str);
    }

    /* renamed from: c */
    private void m2164c(String str) {
        Log.m2958e(f2382k + str);
    }

    /* renamed from: d */
    private void m2165d(String str) {
        Log.m2963i(f2382k + str);
    }

    /* renamed from: f */
    private boolean m2166f() {
        m2165d("sendProposeConsentAsk!!! ");
        ProposeConsentAsk proposeConsentAsk = new ProposeConsentAsk();
        proposeConsentAsk.setConferenceNo(this.f2363a.getPhoneNo());
        proposeConsentAsk.setConsentType(this.f2365c.f2383a);
        proposeConsentAsk.setOption(this.f2365c.f2384b);
        proposeConsentAsk.setRequesterID(MainApplication.mConfig.getProfileUserID());
        MsgHeader msgHeaderM2140a = C1149a.m2140a(MessageInfo.ProposeConsentAsk.getServiceCode(), MessageInfo.ProposeConsentAsk.getMessageCode());
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
        C1149a.m2141a(msgHeaderM2140a, proposeConsentAsk, arrayList);
        return true;
    }

    @Override // com.sds.coolots.call.consent.handler.CallConsentInterface
    public boolean acceptConsent() {
        m2164c("acceptConsent!!! invalid state");
        return false;
    }

    @Override // com.sds.coolots.call.consent.handler.CallConsentHandler
    /* renamed from: b */
    protected void mo2150b() {
        m2165d("handleConsentTimeout!!! ");
        if ((this.f2369g instanceof C1152b) || (this.f2369g instanceof C1155e)) {
            this.f2366d.processCallConsentTimeOut();
        } else {
            m2149a(true, true, "");
            dispose();
        }
    }

    @Override // com.sds.coolots.call.consent.handler.CallConsentInterface
    public void handleNotifyConsentAsk(NotifyConsentAsk notifyConsentAsk) {
        m2165d("handleNotifyCallTypeChangeAsk!!! ");
        if (this.f2363a.getPhoneNo().equals(notifyConsentAsk.getConferenceNo())) {
            if (notifyConsentAsk.getAccept()) {
                m2148a(true, MainApplication.mConfig.getProfileUserID());
            } else {
                m2149a(true, false, notifyConsentAsk.getRejectUserID());
            }
            dispose();
        }
    }

    @Override // com.sds.coolots.call.consent.handler.CallConsentInterface
    public void handleProposeConsentAsk(ProposeConsentAsk proposeConsentAsk) {
        m2164c("handleProposeConsentAsk!!! invalid state");
    }

    @Override // com.sds.coolots.call.consent.handler.CallConsentInterface
    public void handleProposeConsentRep(ProposeConsentRep proposeConsentRep) {
        m2165d("handleProposeConsentRep!!! msg:" + proposeConsentRep.toString());
        if (this.f2363a.getPhoneNo().equals(proposeConsentRep.getConferenceNo()) && !proposeConsentRep.getRequestResult()) {
            m2163b(true, false, "");
            dispose();
        }
    }

    @Override // com.sds.coolots.call.consent.handler.CallConsentInterface
    public void handleRequestConsentAsk(RequestConsentAsk requestConsentAsk) {
        m2164c("handleRequestConsentAsk!!! invalid state");
        String conferenceNo = requestConsentAsk.getConferenceNo();
        if (conferenceNo == null || conferenceNo.isEmpty() || !conferenceNo.equals(this.f2363a.getPhoneNo())) {
            return;
        }
        m2162a(requestConsentAsk.getRequestKey(), this.f2369g.isAcceptDuplicationRequest(requestConsentAsk.getConsentType(), requestConsentAsk.getOption()));
    }

    @Override // com.sds.coolots.call.consent.handler.CallConsentInterface
    public void handleRequestConsentRep(RequestConsentRep requestConsentRep) {
        m2164c("handleRequestConsentRep!!! invalid state");
    }

    @Override // com.sds.coolots.call.consent.handler.CallConsentInterface
    public void processTimeoutResult(boolean z, boolean z2, int i, int i2) {
        m2165d("processTimeoutResult!!!");
        if (z) {
            m2148a(true, MainApplication.mConfig.getProfileUserID());
        } else {
            m2149a(true, true, "");
        }
        dispose();
    }

    @Override // com.sds.coolots.call.consent.handler.CallConsentInterface
    public boolean rejectConsent(int i) {
        m2164c("rejectConsent!!! invalid state");
        return false;
    }

    @Override // com.sds.coolots.call.consent.handler.CallConsentInterface
    public boolean requestConsent() {
        m2165d("requestConsent!!!");
        return m2166f();
    }
}
