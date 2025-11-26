package com.sds.coolots.call.consent.handler;

import com.coolots.p2pmsg.model.NotifyConsentAsk;
import com.coolots.p2pmsg.model.RequestConsentAsk;
import com.coolots.p2pmsg.model.RequestConsentRep;
import com.sds.coolots.MainApplication;
import com.sds.coolots.call.consent.handler.CallConsentHandler;
import com.sds.coolots.call.model.Destination;
import com.sds.coolots.common.util.Log;

/* renamed from: com.sds.coolots.call.consent.handler.i */
/* loaded from: classes.dex */
public class HandlerC1166i extends AbstractHandlerC1164g {

    /* renamed from: l */
    private static final String f2395l = "[P2PCallConsentHandlerForRequester]";

    public HandlerC1166i(Destination destination, int i, CallConsentHandler.CallConsentCallback callConsentCallback, C1162e c1162e, C1162e c1162e2) {
        super(destination, i, callConsentCallback, c1162e, c1162e2);
        m2184c();
        m2147a(true);
    }

    /* renamed from: d */
    private void m2190d(String str) {
        Log.m2958e(f2395l + str);
    }

    /* renamed from: e */
    private void m2191e(String str) {
        Log.m2963i(f2395l + str);
    }

    /* renamed from: f */
    private boolean m2192f() {
        m2185c(MainApplication.mConfig.getProfileUserID());
        return true;
    }

    @Override // com.sds.coolots.call.consent.handler.CallConsentInterface
    public boolean acceptConsent() {
        m2190d("acceptConsent!!! invalid state");
        return false;
    }

    @Override // com.sds.coolots.call.consent.handler.CallConsentHandler
    /* renamed from: b */
    protected void mo2150b() {
        m2191e("handleConsentTimeout!!!");
        m2183b(false, "");
        m2149a(true, true, "");
        dispose();
    }

    @Override // com.sds.coolots.call.consent.handler.CallConsentInterface
    public void handleNotifyConsentAsk(NotifyConsentAsk notifyConsentAsk) {
        if (this.f2369g.isAcceptDuplicationRequest(notifyConsentAsk.getConsentType(), notifyConsentAsk.getOption())) {
            m2191e("handleNotifyConsentAsk!!!");
            if (notifyConsentAsk.getAccept()) {
                m2148a(false, this.f2390h);
            }
            dispose();
        }
    }

    @Override // com.sds.coolots.call.consent.handler.CallConsentInterface
    public void handleRequestConsentAsk(RequestConsentAsk requestConsentAsk) {
        m2191e("<CIH> handleRequestConsentAsk()");
        m2191e("<CIH> mConsentInfo.mConsentType = " + this.f2365c.f2383a + ", mConsentInfo.mConsentOption = " + this.f2365c.f2384b);
        m2191e("<CIH> msg.getConsentType() = " + requestConsentAsk.getConsentType() + ", msg.getOption() = " + requestConsentAsk.getOption());
        if (this.f2364b != requestConsentAsk.getCallSessionID()) {
            return;
        }
        if (this.f2365c.f2383a != requestConsentAsk.getConsentType() || this.f2365c.f2384b != requestConsentAsk.getOption()) {
            m2180a(false, requestConsentAsk.getRequesterID(), requestConsentAsk.getRequestKey(), requestConsentAsk.getConsentType(), requestConsentAsk.getOption());
            return;
        }
        if (!this.f2369g.isAcceptDuplicationRequest(requestConsentAsk.getConsentType(), requestConsentAsk.getOption())) {
            m2180a(false, requestConsentAsk.getRequesterID(), requestConsentAsk.getRequestKey(), this.f2365c.f2383a, this.f2365c.f2384b);
            return;
        }
        m2147a(false);
        this.f2390h = requestConsentAsk.getRequesterID();
        this.f2368f = requestConsentAsk.getRequestKey();
        this.f2365c.f2383a = requestConsentAsk.getConsentType();
        this.f2365c.f2384b = requestConsentAsk.getOption();
        m2179a(true, this.f2365c.f2383a, this.f2365c.f2384b);
    }

    @Override // com.sds.coolots.call.consent.handler.CallConsentInterface
    public void handleRequestConsentRep(RequestConsentRep requestConsentRep) {
        m2191e("handleRequestConsentRep!!!");
        m2191e("handleRequestConsentRep!!! msg:" + requestConsentRep.toString());
        if (requestConsentRep.getRequestKey() == this.f2368f && this.f2364b == requestConsentRep.getCallSessionID()) {
            if (!requestConsentRep.getAccept()) {
                m2183b(false, requestConsentRep.getRequesterID());
                m2149a(false, false, requestConsentRep.getRequesterID());
                dispose();
            } else {
                m2181b(requestConsentRep.getRequesterID());
                if (m2187e()) {
                    m2183b(true, "");
                    m2148a(true, MainApplication.mConfig.getProfileUserID());
                    dispose();
                }
            }
        }
    }

    @Override // com.sds.coolots.call.consent.handler.CallConsentInterface
    public void processTimeoutResult(boolean z, boolean z2, int i, int i2) {
    }

    @Override // com.sds.coolots.call.consent.handler.CallConsentInterface
    public boolean rejectConsent(int i) {
        m2190d("rejectConsent!!! invalid state");
        return false;
    }

    @Override // com.sds.coolots.call.consent.handler.CallConsentInterface
    public boolean requestConsent() {
        return m2192f();
    }
}
