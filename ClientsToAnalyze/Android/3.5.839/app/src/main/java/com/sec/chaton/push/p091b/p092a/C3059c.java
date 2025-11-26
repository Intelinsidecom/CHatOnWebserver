package com.sec.chaton.push.p091b.p092a;

import android.content.Context;
import com.sec.chaton.push.p090a.C3044a;
import com.sec.chaton.push.p090a.C3045b;
import com.sec.chaton.push.p091b.p093b.C3063c;
import com.sec.chaton.push.p091b.p093b.C3069i;
import com.sec.chaton.push.p091b.p093b.InterfaceC3061a;
import org.jboss.netty.channel.Channel;
import org.jboss.netty.channel.ChannelPipelineFactory;

/* compiled from: ProvConnectionManager.java */
/* renamed from: com.sec.chaton.push.b.a.c */
/* loaded from: classes.dex */
public class C3059c extends AbstractC3057a {
    public C3059c(Context context) {
        super(context);
    }

    @Override // com.sec.chaton.push.p091b.p092a.AbstractC3057a
    /* renamed from: a */
    protected ChannelPipelineFactory mo12524a() {
        return new C3069i(this.f11320a, true);
    }

    @Override // com.sec.chaton.push.p091b.p092a.AbstractC3057a
    /* renamed from: a */
    public synchronized Channel mo12523a(String str, int i, boolean z) {
        Channel channelMo12523a;
        channelMo12523a = super.mo12523a(str, i, z);
        try {
            ((C3063c) channelMo12523a.getPipeline().get("message channel handler")).m12530a(C3045b.m12505a().m12516h());
        } catch (NullPointerException e) {
            throw new C3044a(e);
        }
        return channelMo12523a;
    }

    @Override // com.sec.chaton.push.p091b.p092a.AbstractC3057a
    /* renamed from: b */
    public synchronized void mo12527b() {
        if (this.f11323d == null) {
            throw new C3044a("Connection is already disconnected.");
        }
        InterfaceC3061a interfaceC3061aM12529a = ((C3063c) this.f11323d.getPipeline().get("message channel handler")).m12529a();
        ((C3063c) this.f11323d.getPipeline().get("message channel handler")).m12530a((InterfaceC3061a) null);
        super.mo12527b();
        if (interfaceC3061aM12529a != null) {
            interfaceC3061aM12529a.mo12519a(false, null);
        }
    }
}
