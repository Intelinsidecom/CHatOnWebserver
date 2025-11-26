package com.sec.chaton.push;

import com.sec.chaton.push.IPushClientService;
import com.sec.chaton.push.message.processer.MessageController;
import com.sec.chaton.push.registration.RegistrationManager;
import java.util.ArrayList;

/* renamed from: com.sec.chaton.push.e */
/* loaded from: classes.dex */
class BinderC0357e extends IPushClientService.Stub {

    /* renamed from: a */
    final /* synthetic */ PushClientService f2603a;

    BinderC0357e(PushClientService pushClientService) {
        this.f2603a = pushClientService;
    }

    @Override // com.sec.chaton.push.IPushClientService
    /* renamed from: a */
    public void mo2849a(String str) {
        if (str == null) {
            throw new IllegalArgumentException("Notification id shouldn't be null.");
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(str);
        MessageController.m2911p().m2920a(arrayList);
    }

    @Override // com.sec.chaton.push.IPushClientService
    /* renamed from: a */
    public void mo2850a(String str, IDeregistrationCallbackListener iDeregistrationCallbackListener) {
        if (str == null) {
            throw new IllegalArgumentException("Application id shouldn't be null.");
        }
        if (RegistrationManager.m3012b(this.f2603a.getApplicationContext()) == null || !RegistrationManager.m3012b(this.f2603a.getApplicationContext()).equals(str)) {
            iDeregistrationCallbackListener.mo2099a(5200, "The application hadn't been registered in push module");
        } else {
            MessageController.m2911p().m2926b(str, new C0359g(this, iDeregistrationCallbackListener));
        }
    }

    @Override // com.sec.chaton.push.IPushClientService
    /* renamed from: a */
    public void mo2851a(String str, IRegistrationCallbackListener iRegistrationCallbackListener) {
        if (str == null) {
            throw new IllegalArgumentException("Application id shouldn't be null.");
        }
        MessageController.m2911p().m2919a(str, new C0360h(this, iRegistrationCallbackListener));
    }

    @Override // com.sec.chaton.push.IPushClientService
    /* renamed from: a */
    public boolean mo2852a() {
        return MessageController.m2911p().m2931d();
    }

    @Override // com.sec.chaton.push.IPushClientService
    /* renamed from: b */
    public String mo2853b(String str) {
        if (str == null) {
            throw new IllegalArgumentException("Application id shouldn't be null.");
        }
        return RegistrationManager.m3015d(this.f2603a);
    }
}
