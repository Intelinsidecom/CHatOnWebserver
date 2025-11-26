package com.sec.chaton.chat.background;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.sec.chaton.chat.C1092fg;
import com.sec.chaton.p016a.p017a.C0272i;
import com.sec.chaton.util.C3250y;

/* compiled from: GetMessageJobContainer.java */
/* renamed from: com.sec.chaton.chat.background.e */
/* loaded from: classes.dex */
public class HandlerC0971e extends Handler {

    /* renamed from: a */
    final /* synthetic */ C0970d f3975a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HandlerC0971e(C0970d c0970d, Looper looper) {
        super(looper);
        this.f3975a = c0970d;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) throws Throwable {
        if (message != null) {
            C0272i c0272i = (C0272i) ((C1092fg) message.obj).m5376a();
            if (c0272i == null) {
                if (C3250y.f11734b) {
                    C3250y.m11450b("resultEntry is null", "GetMessageJonContainer");
                    return;
                }
                return;
            }
            switch (message.what) {
                case 2:
                    if (!c0272i.f858a) {
                        this.f3975a.mo5198a(c0272i.f858a, 0, c0272i.m1366g());
                        this.f3975a.mo5196a(this.f3975a.f3987l);
                        break;
                    }
                    break;
                case 6:
                    if (!c0272i.f858a) {
                        this.f3975a.mo5198a(c0272i.f858a, 0, c0272i.m1366g());
                        this.f3975a.mo5196a(this.f3975a.f3987l);
                        break;
                    } else {
                        C3250y.m11453c("get message deliveryChat success", "GetMessageJonContainer");
                        this.f3975a.mo5198a(c0272i.f858a, 1, c0272i.m1366g());
                        this.f3975a.mo5196a(this.f3975a.f3987l);
                        this.f3975a.f3983h.m5871a(this.f3975a.f3981f, this.f3975a.f3979d);
                        break;
                    }
            }
            super.handleMessage(message);
        }
    }
}
