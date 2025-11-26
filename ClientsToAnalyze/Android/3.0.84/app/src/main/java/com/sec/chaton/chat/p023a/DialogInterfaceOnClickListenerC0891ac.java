package com.sec.chaton.chat.p023a;

import android.content.DialogInterface;
import com.sec.chaton.chat.ChatActivity;
import com.sec.chaton.p025d.C1337o;
import com.sec.chaton.p027e.EnumC1455w;
import com.sec.chaton.util.C3159aa;

/* compiled from: SystemBubbleDrawer.java */
/* renamed from: com.sec.chaton.chat.a.ac */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC0891ac implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ ViewOnClickListenerC0889aa f3817a;

    DialogInterfaceOnClickListenerC0891ac(ViewOnClickListenerC0889aa viewOnClickListenerC0889aa) {
        this.f3817a = viewOnClickListenerC0889aa;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        try {
            ((ChatActivity) this.f3817a.f3815c.f3789c).m4672e();
        } catch (Exception e) {
            e.printStackTrace();
        }
        C1337o.m5813d(this.f3817a.f3815c.f3794h.f4243aE).m5856a(EnumC1455w.TEXT, this.f3817a.f3815c.f3794h.f4240aB, new String[]{C3159aa.m10962a().m10979a("chaton_id", "")}, this.f3817a.f3814b);
    }
}
