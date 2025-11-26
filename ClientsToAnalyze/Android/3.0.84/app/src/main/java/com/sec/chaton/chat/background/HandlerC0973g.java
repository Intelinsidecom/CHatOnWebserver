package com.sec.chaton.chat.background;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.sec.chaton.chat.C1092fg;
import com.sec.chaton.p016a.p017a.C0272i;

/* compiled from: JobContainer.java */
/* renamed from: com.sec.chaton.chat.background.g */
/* loaded from: classes.dex */
public class HandlerC0973g extends Handler {

    /* renamed from: a */
    final /* synthetic */ C0972f f3997a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HandlerC0973g(C0972f c0972f, Looper looper) {
        super(looper);
        this.f3997a = c0972f;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        if (message != null) {
            switch (message.what) {
                case 0:
                case 4:
                case 101:
                case 102:
                case 106:
                    C1092fg c1092fg = (C1092fg) message.obj;
                    if (c1092fg.m5377b() == this.f3997a.f3990o) {
                        C0272i c0272i = (C0272i) c1092fg.m5376a();
                        if (c0272i == null) {
                            this.f3997a.mo5196a(this.f3997a.f3987l);
                            break;
                        } else {
                            boolean z = c0272i.f858a;
                            if (z) {
                                this.f3997a.mo5198a(z, 1, c0272i.m1366g());
                                this.f3997a.mo5196a(this.f3997a.f3987l);
                                break;
                            } else {
                                this.f3997a.mo5198a(z, 0, c0272i.m1366g());
                                this.f3997a.mo5196a(this.f3997a.f3987l);
                                break;
                            }
                        }
                    }
                    break;
            }
        }
    }
}
