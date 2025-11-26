package com.sec.chaton.p055d.p056a;

import com.sec.chaton.p046a.p047a.C0784h;
import com.sec.chaton.p065io.entry.ChatONVApplicationInfoEntry;
import com.sec.chaton.util.C4809aa;
import com.sec.chaton.util.C4904y;
import com.sec.common.p126d.p127a.p129b.C4985b;
import com.sec.common.util.C5052r;

/* compiled from: ChatONVApplicationInfoTask.java */
/* renamed from: com.sec.chaton.d.a.v */
/* loaded from: classes.dex */
public class C2063v extends AbstractC1924ax<C4985b, C0784h> {

    /* renamed from: a */
    private static final String f7538a = C2063v.class.getSimpleName();

    public C2063v(C4985b c4985b) {
        super(c4985b);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.sec.common.p126d.p127a.AbstractCallableC4983b
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0784h mo6146a(C4985b c4985b) {
        return new C0784h(c4985b);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.sec.common.p126d.p127a.AbstractCallableC4983b
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public String mo6150b() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.sec.common.p126d.p127a.AbstractCallableC4983b
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void mo6149a(C0784h c0784h) {
        if (c0784h.m18953m() == 200) {
            ChatONVApplicationInfoEntry chatONVApplicationInfoEntry = (ChatONVApplicationInfoEntry) c0784h.m18928p();
            if (C4904y.f17872b) {
                C4904y.m18639b(C5052r.m19199a("install.enable: ", chatONVApplicationInfoEntry.install.enable, "\nvideoCallMax: ", chatONVApplicationInfoEntry.config.videoCallMax, "\nvoiceCallMax: ", chatONVApplicationInfoEntry.config.voiceCallMax), f7538a);
            }
            C4809aa.m18104a().m18125b("chatonv_available", chatONVApplicationInfoEntry.install.enable);
            if (chatONVApplicationInfoEntry.install.enable.booleanValue()) {
                if (C4904y.f17872b) {
                    C4904y.m18639b("install.urlList[0]: " + chatONVApplicationInfoEntry.install.urlList.get(0) + "\ninstall.urlList[1]: " + chatONVApplicationInfoEntry.install.urlList.get(1), f7538a);
                }
                C4809aa.m18104a().m18128b("chatonv_apps_down_url", chatONVApplicationInfoEntry.install.urlList.get(0));
                C4809aa.m18104a().m18128b("chatonv_google_down_url", chatONVApplicationInfoEntry.install.urlList.get(1));
                return;
            }
            return;
        }
        if (C4904y.f17875e) {
            C4904y.m18634a(C5052r.m19199a("ChatON V application info task has network error."), f7538a);
        }
    }
}
