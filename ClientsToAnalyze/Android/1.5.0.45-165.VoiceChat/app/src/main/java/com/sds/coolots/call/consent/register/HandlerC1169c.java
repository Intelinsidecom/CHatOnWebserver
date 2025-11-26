package com.sds.coolots.call.consent.register;

import android.os.Handler;
import android.os.Message;
import com.coolots.p2pmsg.MessageInfo;
import com.sds.coolots.call.p013a.C1137c;

/* renamed from: com.sds.coolots.call.consent.register.c */
/* loaded from: classes.dex */
public class HandlerC1169c extends Handler implements RegisterInterface {

    /* renamed from: a */
    private RegisterCallbackInterface f2398a;

    /* renamed from: b */
    private String f2399b;

    /* renamed from: a */
    private void m2194a(Message message) {
        if (message.arg1 == 0) {
            this.f2398a.onRegisterResult(true, this.f2399b);
        } else {
            this.f2398a.onRegisterResult(false, this.f2399b);
        }
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        if (message.what == MessageInfo.ChangeConferenceTypeAsk.getDispatchCode()) {
            m2194a(message);
        }
        super.handleMessage(message);
    }

    @Override // com.sds.coolots.call.consent.register.RegisterInterface
    public void registerRequest(String str, int i, String str2, RegisterCallbackInterface registerCallbackInterface) {
        this.f2398a = registerCallbackInterface;
        this.f2399b = str2;
        new C1137c(str, "S", str2, 0, this).start();
    }
}
