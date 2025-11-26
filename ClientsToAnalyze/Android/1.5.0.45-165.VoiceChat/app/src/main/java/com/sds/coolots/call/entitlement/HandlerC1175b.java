package com.sds.coolots.call.entitlement;

import android.os.Handler;
import android.os.Message;
import com.sds.coolots.MainApplication;
import java.util.Date;

/* renamed from: com.sds.coolots.call.entitlement.b */
/* loaded from: classes.dex */
class HandlerC1175b extends Handler {

    /* renamed from: a */
    final /* synthetic */ C1174a f2414a;

    /* renamed from: b */
    private boolean f2415b = false;

    /* renamed from: c */
    private IEntitlementResultListener f2416c;

    /* renamed from: d */
    private IEntitlementHangupListener f2417d;

    public HandlerC1175b(C1174a c1174a, IEntitlementResultListener iEntitlementResultListener, IEntitlementHangupListener iEntitlementHangupListener) {
        this.f2414a = c1174a;
        this.f2416c = iEntitlementResultListener;
        this.f2417d = iEntitlementHangupListener;
    }

    /* renamed from: a */
    public void m2216a() {
        this.f2415b = true;
        this.f2416c = null;
        this.f2417d = null;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        if (this.f2415b) {
            return;
        }
        int i = message.what;
        this.f2414a.m2210a("ReceiveResultHandler: resultType: " + i);
        if (i == 1) {
            this.f2414a.m2206a(MainApplication.mContext, new Date(System.currentTimeMillis()));
            this.f2414a.m2205a(MainApplication.mContext, i);
        }
        if (this.f2417d != null) {
            this.f2417d.onHangupCall(i);
        } else if (this.f2416c != null) {
            this.f2416c.onReceiveEntitlementResult(i);
        }
        super.handleMessage(message);
    }
}
