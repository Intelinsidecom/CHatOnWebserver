package com.sec.chaton.chat.p054a;

import android.content.DialogInterface;
import com.sec.chaton.chat.ChatActivity;
import com.sec.chaton.p055d.C2142w;
import com.sec.chaton.p057e.EnumC2214ab;
import com.sec.chaton.util.C4809aa;
import com.sec.chaton.util.C4904y;

/* compiled from: SystemBubbleDrawer.java */
/* renamed from: com.sec.chaton.chat.a.ao */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC1521ao implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ ViewOnClickListenerC1519am f5912a;

    DialogInterfaceOnClickListenerC1521ao(ViewOnClickListenerC1519am viewOnClickListenerC1519am) {
        this.f5912a = viewOnClickListenerC1519am;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        try {
            ((ChatActivity) this.f5912a.f5910c.f5856c).m7825j();
        } catch (Exception e) {
            e.printStackTrace();
        }
        C2142w c2142wM9606c = C2142w.m9606c(this.f5912a.f5910c.f5861h.f6427aR);
        if (c2142wM9606c != null) {
            c2142wM9606c.mo9226a(EnumC2214ab.TEXT, this.f5912a.f5910c.f5861h.f6424aO, new String[]{C4809aa.m18104a().m18121a("chaton_id", "")}, this.f5912a.f5909b);
        } else if (C4904y.f17875e) {
            C4904y.m18634a("control is null", "SystemBubbleDrawer");
        }
    }
}
