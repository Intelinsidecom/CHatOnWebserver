package com.sec.chaton.chat.background;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.sec.chaton.chat.C0592i;
import com.sec.chaton.p015b.p016a.C0257e;
import com.sec.chaton.p018c.C0476aa;

/* compiled from: JobContainer.java */
/* renamed from: com.sec.chaton.chat.background.b */
/* loaded from: classes.dex */
class HandlerC0555b extends Handler {

    /* renamed from: a */
    final /* synthetic */ C0559f f1917a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HandlerC0555b(C0559f c0559f, Looper looper) {
        super(looper);
        this.f1917a = c0559f;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        if (message != null) {
            switch (message.what) {
                case 0:
                case 4:
                case 1025:
                case 1029:
                    C0592i c0592i = (C0592i) message.obj;
                    if (c0592i.m2778b() == this.f1917a.f1958o) {
                        C0257e c0257e = (C0257e) c0592i.m2777a();
                        if (c0257e == null) {
                            this.f1917a.m2755a(this.f1917a.f1955l);
                            break;
                        } else {
                            boolean z = c0257e.f604a;
                            if (z) {
                                C0476aa.m2436a().m2441c();
                                this.f1917a.m2763a(z, 1, c0257e.m918c());
                                this.f1917a.m2755a(this.f1917a.f1955l);
                                break;
                            } else {
                                C0476aa.m2436a().m2441c();
                                this.f1917a.m2763a(z, 0, c0257e.m918c());
                                this.f1917a.m2755a(this.f1917a.f1955l);
                                break;
                            }
                        }
                    }
                    break;
            }
        }
    }
}
