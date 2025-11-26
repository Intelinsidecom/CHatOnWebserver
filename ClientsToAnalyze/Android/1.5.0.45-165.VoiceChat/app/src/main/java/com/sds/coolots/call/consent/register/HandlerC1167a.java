package com.sds.coolots.call.consent.register;

import android.os.Handler;
import android.os.Message;
import com.coolots.p2pmsg.MessageInfo;
import com.sds.coolots.call.p013a.C1137c;

/* renamed from: com.sds.coolots.call.consent.register.a */
/* loaded from: classes.dex */
public class HandlerC1167a extends Handler implements RegisterInterface {

    /* renamed from: a */
    private RegisterCallbackInterface f2396a;

    /* renamed from: b */
    private String f2397b;

    /* renamed from: a */
    private void m2193a(Message message) {
        if (message.arg1 == 0) {
            this.f2396a.onRegisterResult(true, this.f2397b);
        } else {
            this.f2396a.onRegisterResult(false, this.f2397b);
        }
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        if (message.what == MessageInfo.ChangeConferenceTypeAsk.getDispatchCode()) {
            m2193a(message);
        }
        super.handleMessage(message);
    }

    @Override // com.sds.coolots.call.consent.register.RegisterInterface
    public void registerRequest(String str, int i, String str2, RegisterCallbackInterface registerCallbackInterface) {
        this.f2396a = registerCallbackInterface;
        this.f2397b = str2;
        new C1137c(str, i == 1 ? "A" : "V", str2, 0, this).start();
    }
}
