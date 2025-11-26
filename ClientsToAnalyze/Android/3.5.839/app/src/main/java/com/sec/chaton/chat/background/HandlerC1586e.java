package com.sec.chaton.chat.background;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.sec.chaton.chat.C1770hp;
import com.sec.chaton.p046a.p047a.C0788l;
import com.sec.chaton.util.C4904y;

/* compiled from: GetMessageJobContainer.java */
/* renamed from: com.sec.chaton.chat.background.e */
/* loaded from: classes.dex */
public class HandlerC1586e extends Handler {

    /* renamed from: a */
    final /* synthetic */ C1585d f6029a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HandlerC1586e(C1585d c1585d, Looper looper) {
        super(looper);
        this.f6029a = c1585d;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        if (message != null) {
            C0788l c0788l = (C0788l) ((C1770hp) message.obj).m8779a();
            if (c0788l == null) {
                if (C4904y.f17872b) {
                    C4904y.m18639b("resultEntry is null", "GetMessageJonContainer");
                    return;
                }
                return;
            }
            switch (message.what) {
                case 2:
                    if (!c0788l.f2172a) {
                        this.f6029a.mo8449a(c0788l.f2172a, 0, c0788l.m3153h());
                        this.f6029a.mo8447a(this.f6029a.f6041l);
                        break;
                    }
                    break;
                case 6:
                    if (!c0788l.f2172a) {
                        this.f6029a.mo8449a(c0788l.f2172a, 0, c0788l.m3153h());
                        this.f6029a.mo8447a(this.f6029a.f6041l);
                        break;
                    } else {
                        C4904y.m18641c("get message deliveryChat success", "GetMessageJonContainer");
                        this.f6029a.mo8449a(c0788l.f2172a, 1, c0788l.m3153h());
                        this.f6029a.mo8447a(this.f6029a.f6041l);
                        this.f6029a.f6037h.m9644b(this.f6029a.f6035f, this.f6029a.f6033d);
                        break;
                    }
                case 34:
                    if (!c0788l.f2172a) {
                        this.f6029a.mo8449a(c0788l.f2172a, 0, c0788l.m3153h());
                        this.f6029a.mo8447a(this.f6029a.f6041l);
                        break;
                    } else {
                        C4904y.m18641c("get message ForwardOnlineMessage success", "GetMessageJonContainer");
                        this.f6029a.mo8449a(c0788l.f2172a, 1, c0788l.m3153h());
                        this.f6029a.mo8447a(this.f6029a.f6041l);
                        break;
                    }
                case 36:
                    if (!c0788l.f2172a) {
                        this.f6029a.mo8449a(c0788l.f2172a, 0, c0788l.m3153h());
                        this.f6029a.mo8447a(this.f6029a.f6041l);
                        break;
                    } else {
                        C4904y.m18641c("get message ForwardStoredMessage success", "GetMessageJonContainer");
                        this.f6029a.mo8449a(c0788l.f2172a, 1, c0788l.m3153h());
                        this.f6029a.mo8447a(this.f6029a.f6041l);
                        break;
                    }
            }
            super.handleMessage(message);
        }
    }
}
