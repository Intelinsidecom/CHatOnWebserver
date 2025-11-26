package com.sec.chaton.chat;

import android.content.DialogInterface;
import com.sec.chaton.msgsend.C1756p;
import com.sec.chaton.p027e.C1449q;
import com.sec.chaton.p027e.C1454v;
import com.sec.chaton.p027e.C1457y;
import com.sec.chaton.p037j.p040c.C1555a;
import com.sec.chaton.p037j.p040c.C1561g;

/* compiled from: ChatFragment.java */
/* renamed from: com.sec.chaton.chat.ao */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC0937ao implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ ChatFragment f3883a;

    DialogInterfaceOnClickListenerC0937ao(ChatFragment chatFragment) {
        this.f3883a = chatFragment;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        C1756p.m7230a(this.f3883a.f3703r);
        this.f3883a.f3551aa.startDelete(1, null, C1449q.f5381a, "inbox_no IN ('" + this.f3883a.f3703r + "')", null);
        this.f3883a.f3551aa.startDelete(2, null, C1454v.f5393a, "message_inbox_no='" + this.f3883a.f3703r + "'", null);
        this.f3883a.f3551aa.startDelete(3, null, C1457y.f5415a, "participants_inbox_no='" + this.f3883a.f3703r + "'", null);
        C1555a.m6596a().m6600a(this.f3883a.f3703r);
        C1561g.m6628a().m6635a(this.f3883a.f3703r);
        this.f3883a.m4711T();
    }
}
