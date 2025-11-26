package com.sds.coolots.call.consent.handler;

import com.coolots.p2pmsg.model.NotifyConsentAsk;
import com.coolots.p2pmsg.model.RequestConsentAsk;
import com.coolots.p2pmsg.model.RequestConsentRep;
import com.sds.coolots.call.consent.handler.CallConsentHandler;
import com.sds.coolots.call.model.Destination;
import com.sds.coolots.common.util.Log;

/* renamed from: com.sds.coolots.call.consent.handler.h */
/* loaded from: classes.dex */
public class HandlerC1165h extends AbstractHandlerC1164g {

    /* renamed from: l */
    private static final String f2394l = "[P2PCallConsentHandlerForReceiver]";

    public HandlerC1165h(Destination destination, int i, CallConsentHandler.CallConsentCallback callConsentCallback, C1162e c1162e, C1162e c1162e2) {
        super(destination, i, callConsentCallback, c1162e, c1162e2);
        m2147a(false);
    }

    /* renamed from: d */
    private void m2188d(String str) {
        Log.m2958e(f2394l + str);
    }

    /* renamed from: e */
    private void m2189e(String str) {
        Log.m2963i(f2394l + str);
    }

    @Override // com.sds.coolots.call.consent.handler.CallConsentInterface
    public boolean acceptConsent() {
        m2189e("acceptConsent!!!");
        m2182b(true);
        return true;
    }

    @Override // com.sds.coolots.call.consent.handler.CallConsentHandler
    /* renamed from: b */
    protected void mo2150b() {
        m2189e("handleConsentTimeout!!!");
        m2149a(false, true, "");
        dispose();
    }

    @Override // com.sds.coolots.call.consent.handler.CallConsentInterface
    public void handleNotifyConsentAsk(NotifyConsentAsk notifyConsentAsk) {
        m2189e("handleNotifyConsentAsk!!!");
        if (this.f2364b != notifyConsentAsk.getCallSessionID()) {
            return;
        }
        if (notifyConsentAsk.getAccept()) {
            m2148a(false, this.f2390h);
        } else {
            m2149a(false, false, notifyConsentAsk.getRejectUserID());
        }
        dispose();
    }

    @Override // com.sds.coolots.call.consent.handler.CallConsentInterface
    public void handleRequestConsentAsk(RequestConsentAsk requestConsentAsk) {
        m2189e("<CIH> handleRequestConsentAsk()");
        m2189e("<CIH> mConsentInfo.mConsentType = " + this.f2365c.f2383a + ", mConsentInfo.mConsentOption = " + this.f2365c.f2384b);
        m2189e("<CIH> msg.getConsentType() = " + requestConsentAsk.getConsentType() + ", msg.getOption() = " + requestConsentAsk.getOption());
        if (this.f2364b != requestConsentAsk.getCallSessionID()) {
            return;
        }
        this.f2390h = requestConsentAsk.getRequesterID();
        this.f2366d.notifyConsentRequest(this.f2365c.f2383a, this.f2365c.f2384b, this.f2390h);
    }

    @Override // com.sds.coolots.call.consent.handler.CallConsentInterface
    public void handleRequestConsentRep(RequestConsentRep requestConsentRep) {
        m2188d("handleRequestConsentRep!!! invalid state");
    }

    @Override // com.sds.coolots.call.consent.handler.CallConsentInterface
    public void processTimeoutResult(boolean z, boolean z2, int i, int i2) {
    }

    @Override // com.sds.coolots.call.consent.handler.CallConsentInterface
    public boolean rejectConsent(int i) {
        m2189e("rejectConsent!!! rejectCode:" + i);
        m2182b(false);
        return true;
    }

    @Override // com.sds.coolots.call.consent.handler.CallConsentInterface
    public boolean requestConsent() {
        m2189e("<CIH> requestConsent step 1");
        if (this.f2369g.isAcceptDuplicationRequest(this.f2365c.f2383a, this.f2365c.f2384b)) {
            m2189e("<CIH> requestConsent step 2");
            return acceptConsent();
        }
        m2189e("<CIH> requestConsent step 3");
        return rejectConsent(1);
    }
}
