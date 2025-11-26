package com.sec.chaton.push.p041b.p042a;

import android.content.Context;
import com.sec.chaton.push.p040a.C1071a;
import com.sec.chaton.push.p040a.C1072b;
import com.sec.chaton.push.p041b.p043b.C1090c;
import com.sec.chaton.push.p041b.p043b.C1097j;
import com.sec.chaton.push.p041b.p043b.InterfaceC1088a;
import org.jboss.netty.channel.Channel;
import org.jboss.netty.channel.ChannelPipelineFactory;

/* compiled from: PushConnectionManager.java */
/* renamed from: com.sec.chaton.push.b.a.d */
/* loaded from: classes.dex */
public class C1087d extends AbstractC1084a {
    public C1087d(Context context) {
        super(context);
    }

    @Override // com.sec.chaton.push.p041b.p042a.AbstractC1084a
    /* renamed from: a */
    protected ChannelPipelineFactory mo4138a() {
        return new C1097j(this.f4007a, true);
    }

    @Override // com.sec.chaton.push.p041b.p042a.AbstractC1084a
    /* renamed from: a */
    public synchronized Channel mo4137a(String str, int i, boolean z) {
        Channel channelMo4137a;
        channelMo4137a = super.mo4137a(str, i, z);
        ((C1090c) channelMo4137a.getPipeline().get("message channel handler")).m4144a(C1072b.m4118a().m4130i());
        return channelMo4137a;
    }

    @Override // com.sec.chaton.push.p041b.p042a.AbstractC1084a
    /* renamed from: b */
    public synchronized void mo4140b() {
        if (this.f4010d == null) {
            throw new C1071a("Connection is already disconnected.");
        }
        InterfaceC1088a interfaceC1088aM4143a = ((C1090c) this.f4010d.getPipeline().get("message channel handler")).m4143a();
        ((C1090c) this.f4010d.getPipeline().get("message channel handler")).m4144a((InterfaceC1088a) null);
        super.mo4140b();
        if (interfaceC1088aM4143a != null) {
            interfaceC1088aM4143a.mo4132a(false, null);
        }
    }
}
