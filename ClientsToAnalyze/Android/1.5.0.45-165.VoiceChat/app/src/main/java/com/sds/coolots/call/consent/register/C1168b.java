package com.sds.coolots.call.consent.register;

/* renamed from: com.sds.coolots.call.consent.register.b */
/* loaded from: classes.dex */
public class C1168b implements RegisterInterface {
    @Override // com.sds.coolots.call.consent.register.RegisterInterface
    public void registerRequest(String str, int i, String str2, RegisterCallbackInterface registerCallbackInterface) {
        registerCallbackInterface.onRegisterResult(true, str2);
    }
}
