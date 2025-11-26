package com.sds.coolots.call.consent.handler;

import com.coolots.p2pmsg.model.NotifyConsentAsk;
import com.coolots.p2pmsg.model.ProposeConsentAsk;
import com.coolots.p2pmsg.model.ProposeConsentRep;
import com.coolots.p2pmsg.model.PushTargetInfo;
import com.coolots.p2pmsg.model.RequestConsentAsk;
import com.coolots.p2pmsg.model.RequestConsentRep;
import com.coolots.p2pmsg.model.SimpleUserInfo;
import com.sds.coolots.MainApplication;
import com.sds.coolots.call.consent.handler.CallConsentHandler;
import com.sds.coolots.call.model.Destination;
import com.sds.coolots.common.util.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.sds.coolots.call.consent.handler.b */
/* loaded from: classes.dex */
public class HandlerC1159b extends AbstractHandlerC1163f {

    /* renamed from: k */
    private static final String f2375k = "[CallConsentHandlerForHostRequester]<<YHT77>>";

    /* renamed from: l */
    private boolean f2376l;

    public HandlerC1159b(Destination destination, CallConsentHandler.CallConsentCallback callConsentCallback, C1162e c1162e, C1162e c1162e2, int i) {
        super(destination, callConsentCallback, c1162e, c1162e2, i);
        this.f2376l = false;
        m2171c();
        m2147a(true);
    }

    /* renamed from: c */
    private void m2155c(String str) {
        Log.m2958e(f2375k + str);
    }

    /* renamed from: d */
    private void m2156d(String str) {
        Log.m2963i(f2375k + str);
    }

    /* renamed from: f */
    private boolean m2157f() {
        ArrayList arrayList = new ArrayList();
        Iterator it = this.f2363a.getConferenceMember().iterator();
        while (it.hasNext()) {
            SimpleUserInfo simpleUserInfo = (SimpleUserInfo) it.next();
            if ("1".equals(simpleUserInfo.getStatus())) {
                PushTargetInfo pushTargetInfo = new PushTargetInfo();
                pushTargetInfo.setReceiverUserID(simpleUserInfo.getUserID());
                pushTargetInfo.setReceiverUserNo(simpleUserInfo.getUserNo());
                pushTargetInfo.setReceiverDeviceID(simpleUserInfo.getDeviceID());
                arrayList.add(pushTargetInfo);
            }
        }
        m2168a(arrayList, MainApplication.mConfig.getProfileUserID());
        this.f2376l = true;
        return true;
    }

    /* renamed from: g */
    private boolean m2158g() {
        return m2174e();
    }

    @Override // com.sds.coolots.call.consent.handler.CallConsentInterface
    public boolean acceptConsent() {
        m2155c("acceptConsent!!! invalid state");
        return false;
    }

    @Override // com.sds.coolots.call.consent.handler.CallConsentHandler
    /* renamed from: b */
    protected void mo2150b() {
        m2156d("handleConsentTimeout!!!");
        m2172c(false, MainApplication.mConfig.getProfileUserID());
        m2149a(true, true, MainApplication.mConfig.getProfileUserID());
        dispose();
    }

    @Override // com.sds.coolots.call.consent.handler.CallConsentInterface
    public void handleNotifyConsentAsk(NotifyConsentAsk notifyConsentAsk) {
        m2155c("handleNotifyConsentAsk!!! invalid state");
    }

    @Override // com.sds.coolots.call.consent.handler.CallConsentInterface
    public void handleProposeConsentAsk(ProposeConsentAsk proposeConsentAsk) {
        m2156d("handleProposeConsentAsk!!!");
        m2156d("handleProposeConsentAsk!!! msg:" + proposeConsentAsk.toString());
        boolean zIsAcceptDuplicationRequest = this.f2369g.isAcceptDuplicationRequest(proposeConsentAsk.getConsentType(), proposeConsentAsk.getOption());
        m2156d("handleProposeConsentAsk!!! bAutoAccept:" + zIsAcceptDuplicationRequest);
        m2170b(true, proposeConsentAsk.getRequesterID());
        if (zIsAcceptDuplicationRequest) {
            m2169b(proposeConsentAsk.getRequesterID());
            if (m2158g()) {
                m2145a();
                this.f2386h.registerRequest(this.f2363a.getPhoneNo(), this.f2365c.f2384b, MainApplication.mConfig.getProfileUserID(), this);
            }
        }
    }

    @Override // com.sds.coolots.call.consent.handler.CallConsentInterface
    public void handleProposeConsentRep(ProposeConsentRep proposeConsentRep) {
        m2155c("handleProposeConsentRep!!! invalid state");
    }

    @Override // com.sds.coolots.call.consent.handler.CallConsentInterface
    public void handleRequestConsentAsk(RequestConsentAsk requestConsentAsk) {
        m2155c("handleRequestConsentAsk!!! invalid state");
    }

    @Override // com.sds.coolots.call.consent.handler.CallConsentInterface
    public void handleRequestConsentRep(RequestConsentRep requestConsentRep) {
        m2156d("handleCallTypeChangeRep!!!");
        m2156d("handleCallTypeChangeRep!!! msg:" + requestConsentRep.toString());
        if (requestConsentRep.getRequestKey() == this.f2368f && this.f2363a.getPhoneNo().equals(requestConsentRep.getConferenceNo())) {
            if (!requestConsentRep.getAccept()) {
                m2172c(false, requestConsentRep.getRequesterID());
                m2149a(false, false, requestConsentRep.getRequesterID());
                dispose();
            } else {
                m2169b(requestConsentRep.getRequesterID());
                if (m2158g()) {
                    m2145a();
                    this.f2386h.registerRequest(this.f2363a.getPhoneNo(), this.f2365c.f2384b, MainApplication.mConfig.getProfileUserID(), this);
                }
            }
        }
    }

    @Override // com.sds.coolots.call.consent.handler.CallConsentInterface
    public void processTimeoutResult(boolean z, boolean z2, int i, int i2) {
        m2156d("processTimeoutResult!!! result : " + z + " isCallSwitching : " + z2 + " option : " + i);
        if (z) {
            m2148a(true, MainApplication.mConfig.getProfileUserID());
        } else {
            m2149a(true, true, "");
        }
        dispose();
    }

    @Override // com.sds.coolots.call.consent.handler.CallConsentInterface
    public boolean rejectConsent(int i) {
        m2155c("rejectCallSwitch!!! invalid state");
        return false;
    }

    @Override // com.sds.coolots.call.consent.handler.CallConsentInterface
    public boolean requestConsent() {
        return m2157f();
    }

    @Override // com.sds.coolots.call.consent.handler.CallConsentHandler, com.sds.coolots.call.consent.handler.CallConsentInterface
    public void updateDestination(Destination destination) {
        super.updateDestination(destination);
        List<String> listD = m2173d();
        if (this.f2376l && !listD.isEmpty()) {
            ArrayList arrayList = new ArrayList();
            for (String str : listD) {
                Iterator it = this.f2363a.getConferenceMember().iterator();
                while (it.hasNext()) {
                    SimpleUserInfo simpleUserInfo = (SimpleUserInfo) it.next();
                    if (simpleUserInfo.getUserID().equals(str)) {
                        PushTargetInfo pushTargetInfo = new PushTargetInfo();
                        pushTargetInfo.setReceiverUserID(simpleUserInfo.getUserID());
                        pushTargetInfo.setReceiverUserNo(simpleUserInfo.getUserNo());
                        pushTargetInfo.setReceiverDeviceID(simpleUserInfo.getDeviceID());
                        arrayList.add(pushTargetInfo);
                    }
                }
            }
            m2168a(arrayList, MainApplication.mConfig.getProfileUserID());
        }
    }
}
