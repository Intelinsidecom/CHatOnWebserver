package com.sec.chaton.chat.background;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.sec.chaton.chat.C1770hp;
import com.sec.chaton.p046a.p047a.C0788l;

/* compiled from: JobContainer.java */
/* renamed from: com.sec.chaton.chat.background.g */
/* loaded from: classes.dex */
public class HandlerC1588g extends Handler {

    /* renamed from: a */
    final /* synthetic */ C1587f f6051a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HandlerC1588g(C1587f c1587f, Looper looper) {
        super(looper);
        this.f6051a = c1587f;
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
                    C1770hp c1770hp = (C1770hp) message.obj;
                    if (c1770hp.m8780b() == this.f6051a.f6044o) {
                        C0788l c0788l = (C0788l) c1770hp.m8779a();
                        if (c0788l == null) {
                            this.f6051a.mo8447a(this.f6051a.f6041l);
                            break;
                        } else {
                            boolean z = c0788l.f2172a;
                            if (z) {
                                this.f6051a.mo8449a(z, 1, c0788l.m3153h());
                                this.f6051a.mo8447a(this.f6051a.f6041l);
                                break;
                            } else {
                                this.f6051a.mo8449a(z, 0, c0788l.m3153h());
                                this.f6051a.mo8447a(this.f6051a.f6041l);
                                break;
                            }
                        }
                    }
                    break;
            }
        }
    }
}
