package com.sec.chaton.control.task;

import com.sec.chaton.network.NetResultReceiver;
import com.sec.chaton.network.TcpClient;
import com.sec.chaton.network.TcpContext;
import com.sec.chaton.network.TcpEnvelope;

/* renamed from: com.sec.chaton.control.task.e */
/* loaded from: classes.dex */
class C0196e implements NetResultReceiver.Receiver {

    /* renamed from: a */
    final /* synthetic */ AbstractNetTask f1687a;

    /* renamed from: b */
    private TcpEnvelope f1688b;

    /* renamed from: c */
    private TcpContext f1689c;

    public C0196e(AbstractNetTask abstractNetTask, TcpEnvelope tcpEnvelope, TcpContext tcpContext) {
        this.f1687a = abstractNetTask;
        this.f1688b = tcpEnvelope;
        this.f1689c = tcpContext;
    }

    /* renamed from: a */
    public void m2159a() {
        if (this.f1688b != null) {
            TcpClient.m2758a(this.f1689c, this.f1688b);
        } else {
            mo2027a(-1, this.f1688b);
        }
    }

    @Override // com.sec.chaton.network.NetResultReceiver.Receiver
    /* renamed from: a */
    public void mo2027a(int i, Object obj) {
        this.f1687a.mo2108a(i, obj, null);
    }

    @Override // com.sec.chaton.network.NetResultReceiver.Receiver
    /* renamed from: a */
    public void mo2028a(int i, Object obj, Object obj2) {
        this.f1687a.mo2108a(i, obj, obj2);
    }
}
