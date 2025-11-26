package com.sec.chaton.push.p035a.p037b;

import android.content.Context;
import com.sec.chaton.push.p035a.p036a.C0858f;
import com.sec.chaton.push.p035a.p036a.C0859g;
import com.sec.chaton.push.p035a.p036a.InterfaceC0855c;
import com.sec.chaton.push.p038b.C0872e;
import com.sec.chaton.push.p038b.C0879l;
import org.jboss.netty.channel.Channel;
import org.jboss.netty.channel.ChannelPipelineFactory;

/* compiled from: ProvConnectionManager.java */
/* renamed from: com.sec.chaton.push.a.b.b */
/* loaded from: classes.dex */
public class C0864b extends AbstractC0865c {
    public C0864b(Context context) {
        super(context);
    }

    @Override // com.sec.chaton.push.p035a.p037b.AbstractC0865c
    /* renamed from: a */
    protected ChannelPipelineFactory mo3456a() {
        return new C0858f(this.f2989a, true);
    }

    @Override // com.sec.chaton.push.p035a.p037b.AbstractC0865c
    /* renamed from: a */
    public synchronized Channel mo3455a(String str, int i, boolean z) {
        Channel channelMo3455a;
        channelMo3455a = super.mo3455a(str, i, z);
        ((C0859g) channelMo3455a.getPipeline().get("message channel handler")).m3452a(C0879l.m3463a().m3474h());
        return channelMo3455a;
    }

    @Override // com.sec.chaton.push.p035a.p037b.AbstractC0865c
    /* renamed from: b */
    public synchronized void mo3457b() {
        if (this.f2992d == null) {
            throw new C0872e("Connection is already disconnected.");
        }
        InterfaceC0855c interfaceC0855cM3451a = ((C0859g) this.f2992d.getPipeline().get("message channel handler")).m3451a();
        ((C0859g) this.f2992d.getPipeline().get("message channel handler")).m3452a((InterfaceC0855c) null);
        super.mo3457b();
        if (interfaceC0855cM3451a != null) {
            interfaceC0855cM3451a.mo3449a(false, null);
        }
    }
}
