package com.sec.chaton.push.p051b.p052a;

import android.content.Context;
import com.sec.chaton.push.p050a.C2044a;
import com.sec.chaton.push.p050a.C2045b;
import com.sec.chaton.push.p051b.p053b.C2063c;
import com.sec.chaton.push.p051b.p053b.C2070j;
import com.sec.chaton.push.p051b.p053b.InterfaceC2061a;
import org.jboss.netty.channel.Channel;
import org.jboss.netty.channel.ChannelPipelineFactory;

/* compiled from: PushConnectionManager.java */
/* renamed from: com.sec.chaton.push.b.a.d */
/* loaded from: classes.dex */
public class C2060d extends AbstractC2057a {
    public C2060d(Context context) {
        super(context);
    }

    @Override // com.sec.chaton.push.p051b.p052a.AbstractC2057a
    /* renamed from: a */
    protected ChannelPipelineFactory mo8181a() {
        return new C2070j(this.f7910a, true);
    }

    @Override // com.sec.chaton.push.p051b.p052a.AbstractC2057a
    /* renamed from: a */
    public synchronized Channel mo8180a(String str, int i, boolean z) {
        Channel channelMo8180a;
        channelMo8180a = super.mo8180a(str, i, z);
        try {
            ((C2063c) channelMo8180a.getPipeline().get("message channel handler")).m8187a(C2045b.m8162a().m8174i());
        } catch (NullPointerException e) {
            throw new C2044a(e);
        }
        return channelMo8180a;
    }

    @Override // com.sec.chaton.push.p051b.p052a.AbstractC2057a
    /* renamed from: b */
    public synchronized void mo8184b() {
        if (this.f7913d == null) {
            throw new C2044a("Connection is already disconnected.");
        }
        InterfaceC2061a interfaceC2061aM8186a = ((C2063c) this.f7913d.getPipeline().get("message channel handler")).m8186a();
        ((C2063c) this.f7913d.getPipeline().get("message channel handler")).m8187a((InterfaceC2061a) null);
        super.mo8184b();
        if (interfaceC2061aM8186a != null) {
            interfaceC2061aM8186a.mo8176a(false, null);
        }
    }
}
