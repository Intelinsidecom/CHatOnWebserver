package com.sds.coolots.call.consent.register;

import android.os.Handler;
import android.os.Message;
import com.coolots.p2pmsg.MessageInfo;
import com.sds.coolots.call.p013a.C1137c;

/* renamed from: com.sds.coolots.call.consent.register.d */
/* loaded from: classes.dex */
public class HandlerC1170d extends Handler implements RegisterInterface {

    /* renamed from: a */
    private RegisterCallbackInterface f2400a;

    /* renamed from: b */
    private String f2401b;

    /* renamed from: a */
    private void m2195a(Message message) {
        if (message.arg1 == 0) {
            this.f2400a.onRegisterResult(true, this.f2401b);
        } else {
            this.f2400a.onRegisterResult(false, this.f2401b);
        }
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        if (message.what == MessageInfo.ChangeConferenceTypeAsk.getDispatchCode()) {
            m2195a(message);
        }
        super.handleMessage(message);
    }

    @Override // com.sds.coolots.call.consent.register.RegisterInterface
    public void registerRequest(String str, int i, String str2, RegisterCallbackInterface registerCallbackInterface) {
        this.f2400a = registerCallbackInterface;
        this.f2401b = str2;
        new C1137c(str, "S", str2, 0, this).start();
    }
}
