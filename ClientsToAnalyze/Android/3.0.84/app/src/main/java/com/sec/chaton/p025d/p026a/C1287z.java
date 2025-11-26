package com.sec.chaton.p025d.p026a;

import android.os.Handler;
import com.sec.chaton.p016a.p017a.C0267d;
import com.sec.chaton.p035io.entry.ChatONVApplicationInfoEntry;
import com.sec.chaton.p037j.C1580h;
import com.sec.chaton.p037j.EnumC1587o;
import com.sec.chaton.util.C3159aa;
import com.sec.chaton.util.C3250y;
import com.sec.common.util.C3364o;

/* compiled from: ChatONVApplicationInfoTask.java */
/* renamed from: com.sec.chaton.d.a.z */
/* loaded from: classes.dex */
public class C1287z extends AbstractC1145a {

    /* renamed from: b */
    private static final String f4906b = C1287z.class.getSimpleName();

    public C1287z(Handler handler, C1580h c1580h, EnumC1172b enumC1172b) {
        super(handler, c1580h, enumC1172b);
    }

    @Override // com.sec.chaton.p025d.p026a.AbstractC1145a
    /* renamed from: f */
    protected String mo5496f() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.sec.chaton.p025d.p026a.AbstractC1145a, com.sec.common.p066d.p067a.AbstractCallableC3318b
    /* renamed from: b */
    public void mo5489a(C0267d c0267d) {
        mo5488a(c0267d);
    }

    @Override // com.sec.chaton.p025d.p026a.AbstractC1145a
    /* renamed from: a */
    protected void mo5488a(C0267d c0267d) {
        if (c0267d.m1351b() == EnumC1587o.SUCCESS) {
            ChatONVApplicationInfoEntry chatONVApplicationInfoEntry = (ChatONVApplicationInfoEntry) c0267d.m11667p();
            if (C3250y.f11734b) {
                C3250y.m11450b(C3364o.m11849a("install.enable: ", chatONVApplicationInfoEntry.install.enable, "\nvideoCallMax: ", chatONVApplicationInfoEntry.config.videoCallMax, "\nvoiceCallMax: ", chatONVApplicationInfoEntry.config.voiceCallMax), f4906b);
            }
            C3159aa.m10962a().m10983b("chatonv_available", chatONVApplicationInfoEntry.install.enable);
            return;
        }
        if (C3250y.f11737e) {
            C3250y.m11442a(C3364o.m11849a("ChatON V application info task has network error."), f4906b);
        }
    }
}
