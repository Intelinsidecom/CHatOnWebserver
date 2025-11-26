package com.sds.coolots.call.consent.handler;

import android.os.Handler;
import android.os.Message;
import com.sds.coolots.MainApplication;
import com.sds.coolots.call.consent.acceptor.AutoAcceptorInterface;
import com.sds.coolots.call.consent.acceptor.C1152b;
import com.sds.coolots.call.consent.acceptor.C1154d;
import com.sds.coolots.call.consent.acceptor.C1155e;
import com.sds.coolots.call.consent.acceptor.C1156f;
import com.sds.coolots.call.consent.acceptor.C1157g;
import com.sds.coolots.call.model.CallStatusData;
import com.sds.coolots.call.model.Destination;
import com.sds.coolots.common.util.Log;
import com.sds.coolots.common.view.DisposeInterface;

/* loaded from: classes.dex */
public abstract class CallConsentHandler extends Handler implements CallConsentInterface, DisposeInterface {

    /* renamed from: h */
    private static final String f2359h = "[CallConsentHandler]";

    /* renamed from: i */
    private static final int f2360i = 10;

    /* renamed from: j */
    private static final int f2361j = 12000;

    /* renamed from: k */
    private static final int f2362k = 15000;

    /* renamed from: a */
    protected Destination f2363a;

    /* renamed from: b */
    protected int f2364b;

    /* renamed from: c */
    protected final C1162e f2365c;

    /* renamed from: d */
    protected final CallConsentCallback f2366d;

    /* renamed from: e */
    protected final C1162e f2367e;

    /* renamed from: f */
    protected int f2368f;

    /* renamed from: g */
    protected AutoAcceptorInterface f2369g;

    /* renamed from: l */
    private int f2370l = f2361j;

    public interface CallConsentCallback {
        void notifyClearConsent();

        void notifyConsentRequest(int i, int i2, String str);

        void notifyConsentResult(boolean z, int i, int i2, boolean z2, boolean z3, String str);

        void notifyProposeResult(boolean z, int i, int i2, boolean z2, boolean z3, String str);

        void notifySendPush();

        void processCallConsentTimeOut();
    }

    public CallConsentHandler(Destination destination, int i, CallConsentCallback callConsentCallback, C1162e c1162e, C1162e c1162e2, int i2) {
        this.f2363a = destination;
        this.f2364b = i;
        this.f2365c = c1162e;
        this.f2366d = callConsentCallback;
        this.f2367e = c1162e2;
        this.f2368f = i2;
        switch (c1162e.f2383a) {
            case 1:
                this.f2369g = new C1152b(c1162e.f2383a, c1162e.f2384b);
                break;
            case 2:
                this.f2369g = new C1155e(c1162e.f2383a, c1162e.f2384b);
                break;
            case 3:
                this.f2369g = new C1156f(c1162e.f2383a, c1162e.f2384b);
                break;
            case 4:
                this.f2369g = new C1154d(c1162e.f2383a, c1162e.f2384b);
                break;
            case 5:
                this.f2369g = new C1157g(c1162e.f2383a, c1162e.f2384b);
                break;
            default:
                this.f2369g = new C1152b(c1162e.f2383a, c1162e.f2384b);
                break;
        }
    }

    /* renamed from: b */
    private void m2143b(String str) {
        Log.m2963i(f2359h + str);
    }

    /* renamed from: c */
    private boolean m2144c() {
        CallStatusData callStatusData = new CallStatusData();
        MainApplication.mPhoneManager.getPhoneStateMachine().updateCallInfo(callStatusData);
        return (callStatusData.getCallState() == 4 || callStatusData.isPlayHoldTone()) ? false : true;
    }

    /* renamed from: a */
    protected void m2145a() {
        m2143b("stopSwitchTimer!");
        removeMessages(10);
    }

    /* renamed from: a */
    protected void m2146a(String str) {
        m2143b("<<YHT22>> notifyConsentRequest! userid:" + str);
        if (this.f2369g.isAcceptCompareWithCurrentOption(this.f2367e.f2384b, this.f2365c.f2384b)) {
            acceptConsent();
        } else if (this.f2365c.f2383a != 3 || m2144c()) {
            this.f2366d.notifyConsentRequest(this.f2365c.f2383a, this.f2365c.f2384b, str);
        } else {
            rejectConsent(0);
        }
    }

    /* renamed from: a */
    protected void m2147a(boolean z) {
        m2143b("<CIH> startSwitchTimer(), isHost = " + z);
        removeMessages(10);
        if (z) {
            this.f2370l = 15000;
        }
        sendEmptyMessageDelayed(10, this.f2370l);
    }

    /* renamed from: a */
    protected void m2148a(boolean z, String str) {
        m2143b("notifyConsentSuccess!");
        this.f2366d.notifyConsentResult(true, this.f2365c.f2383a, this.f2365c.f2384b, z, false, str);
    }

    /* renamed from: a */
    protected void m2149a(boolean z, boolean z2, String str) {
        m2143b("notifyConsentFailed!, <CIH> isRequester = " + z + ", isTimeCancel = " + z2 + ", rejectUserID = " + str);
        this.f2366d.notifyConsentResult(false, this.f2365c.f2383a, this.f2365c.f2384b, z, z2, str);
    }

    /* renamed from: b */
    protected abstract void mo2150b();

    @Override // com.sds.coolots.common.view.DisposeInterface
    public void dispose() {
        Log.m2958e("<<YHT10>> DISPOSED!!!!");
        removeMessages(10);
        this.f2366d.notifyClearConsent();
    }

    @Override // com.sds.coolots.call.consent.handler.CallConsentInterface
    public int getConsentType() {
        return this.f2365c.f2383a;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        if (message.what == 10) {
            mo2150b();
        }
        super.handleMessage(message);
    }

    @Override // com.sds.coolots.call.consent.handler.CallConsentInterface
    public void updateDestination(Destination destination) {
        this.f2363a = destination;
    }
}
