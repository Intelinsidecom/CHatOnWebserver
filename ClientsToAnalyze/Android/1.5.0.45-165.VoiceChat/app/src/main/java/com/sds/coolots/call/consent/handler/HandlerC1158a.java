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

/* renamed from: com.sds.coolots.call.consent.handler.a */
/* loaded from: classes.dex */
public class HandlerC1158a extends AbstractHandlerC1163f {

    /* renamed from: k */
    private static final String f2371k = "[CallConsentHandlerForHostReceiver]<<YHT77>>";

    /* renamed from: l */
    private boolean f2372l;

    /* renamed from: m */
    private boolean f2373m;

    /* renamed from: n */
    private String f2374n;

    public HandlerC1158a(Destination destination, CallConsentHandler.CallConsentCallback callConsentCallback, C1162e c1162e, C1162e c1162e2, int i) {
        super(destination, callConsentCallback, c1162e, c1162e2, i);
        this.f2372l = false;
        this.f2373m = false;
        m2171c();
        m2147a(true);
    }

    /* renamed from: c */
    private void m2151c(String str) {
        Log.m2958e(f2371k + str);
    }

    /* renamed from: d */
    private void m2152d(String str) {
        Log.m2963i(f2371k + str);
    }

    /* renamed from: f */
    private boolean m2153f() {
        m2152d("sendRequestConsentAsk!!!");
        ArrayList arrayList = new ArrayList();
        Iterator it = this.f2363a.getConferenceMember().iterator();
        while (it.hasNext()) {
            SimpleUserInfo simpleUserInfo = (SimpleUserInfo) it.next();
            if ("1".equals(simpleUserInfo.getStatus()) && simpleUserInfo.getUserID() != null && !simpleUserInfo.getUserID().equals(this.f2374n)) {
                PushTargetInfo pushTargetInfo = new PushTargetInfo();
                pushTargetInfo.setReceiverUserID(simpleUserInfo.getUserID());
                pushTargetInfo.setReceiverUserNo(simpleUserInfo.getUserNo());
                pushTargetInfo.setReceiverDeviceID(simpleUserInfo.getDeviceID());
                arrayList.add(pushTargetInfo);
            }
        }
        if (arrayList.isEmpty()) {
            return true;
        }
        m2168a(arrayList, this.f2374n);
        return true;
    }

    /* renamed from: g */
    private boolean m2154g() {
        return this.f2372l && m2174e();
    }

    @Override // com.sds.coolots.call.consent.handler.CallConsentInterface
    public boolean acceptConsent() {
        m2152d("acceptConsent!!!");
        this.f2372l = true;
        if (m2154g()) {
            m2145a();
            this.f2386h.registerRequest(this.f2363a.getPhoneNo(), this.f2365c.f2384b, this.f2374n, this);
        }
        return true;
    }

    @Override // com.sds.coolots.call.consent.handler.CallConsentHandler
    /* renamed from: b */
    protected void mo2150b() {
        m2152d("handleConsentTimeout!!!");
        m2172c(false, "");
        m2149a(false, true, "");
        dispose();
    }

    @Override // com.sds.coolots.call.consent.handler.CallConsentInterface
    public void handleNotifyConsentAsk(NotifyConsentAsk notifyConsentAsk) {
        m2151c("handleNotifyCallTypeChangeAsk!!! invalid state!!!");
    }

    @Override // com.sds.coolots.call.consent.handler.CallConsentInterface
    public void handleProposeConsentAsk(ProposeConsentAsk proposeConsentAsk) {
        m2152d("handleProposeConsentAsk!!! msg:" + proposeConsentAsk.toString());
        if (this.f2363a.getPhoneNo().equals(proposeConsentAsk.getConferenceNo())) {
            if (!this.f2373m) {
                if (proposeConsentAsk.getRequesterID() != null) {
                    this.f2374n = proposeConsentAsk.getRequesterID();
                    m2169b(this.f2374n);
                    m2170b(true, proposeConsentAsk.getRequesterID());
                    m2146a(this.f2374n);
                    m2153f();
                    this.f2373m = true;
                    return;
                }
                return;
            }
            if (!this.f2369g.isAcceptDuplicationRequest(proposeConsentAsk.getConsentType(), proposeConsentAsk.getOption())) {
                m2170b(false, proposeConsentAsk.getRequesterID());
                return;
            }
            m2170b(true, proposeConsentAsk.getRequesterID());
            m2169b(proposeConsentAsk.getRequesterID());
            if (m2154g()) {
                m2145a();
                this.f2386h.registerRequest(this.f2363a.getPhoneNo(), this.f2365c.f2384b, this.f2374n, this);
            }
        }
    }

    @Override // com.sds.coolots.call.consent.handler.CallConsentInterface
    public void handleProposeConsentRep(ProposeConsentRep proposeConsentRep) {
        m2151c("handleProposeConsentRep!!! invalid state!!!");
    }

    @Override // com.sds.coolots.call.consent.handler.CallConsentInterface
    public void handleRequestConsentAsk(RequestConsentAsk requestConsentAsk) {
        m2151c("handleRequestConsentAsk!!! invalid state!!!");
    }

    @Override // com.sds.coolots.call.consent.handler.CallConsentInterface
    public void handleRequestConsentRep(RequestConsentRep requestConsentRep) {
        m2152d("handleRequestConsentRep!!! msg:" + requestConsentRep.toString());
        if (this.f2363a.getPhoneNo().equals(requestConsentRep.getConferenceNo()) && requestConsentRep.getRequestKey() == this.f2368f) {
            if (!requestConsentRep.getAccept()) {
                m2172c(false, requestConsentRep.getRequesterID());
                m2149a(false, false, requestConsentRep.getRequesterID());
                dispose();
            } else {
                m2169b(requestConsentRep.getRequesterID());
                if (m2154g()) {
                    m2145a();
                    this.f2386h.registerRequest(this.f2363a.getPhoneNo(), this.f2365c.f2384b, this.f2374n, this);
                }
            }
        }
    }

    @Override // com.sds.coolots.call.consent.handler.CallConsentInterface
    public void processTimeoutResult(boolean z, boolean z2, int i, int i2) {
        m2152d("processTimeoutResult!!! result : " + z + " isCallSwitching : " + z2 + " option : " + i);
        if (z) {
            m2148a(true, MainApplication.mConfig.getProfileUserID());
        } else {
            m2149a(true, true, "");
        }
        dispose();
    }

    @Override // com.sds.coolots.call.consent.handler.CallConsentInterface
    public boolean rejectConsent(int i) {
        m2152d("rejectConsent!!! rejectCode:" + i);
        m2172c(false, MainApplication.mConfig.getProfileUserID());
        if (i == 2) {
            m2149a(false, true, MainApplication.mConfig.getProfileUserID());
        } else {
            m2149a(false, false, MainApplication.mConfig.getProfileUserID());
        }
        dispose();
        return true;
    }

    @Override // com.sds.coolots.call.consent.handler.CallConsentInterface
    public boolean requestConsent() {
        m2151c("requestConsent!!! invalid state");
        return this.f2369g.isAcceptDuplicationRequest(this.f2365c.f2383a, this.f2365c.f2384b) ? acceptConsent() : rejectConsent(1);
    }

    @Override // com.sds.coolots.call.consent.handler.CallConsentHandler, com.sds.coolots.call.consent.handler.CallConsentInterface
    public void updateDestination(Destination destination) {
        super.updateDestination(destination);
        List<String> listD = m2173d();
        if (this.f2373m && !listD.isEmpty()) {
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
            m2168a(arrayList, this.f2374n);
        }
    }
}
