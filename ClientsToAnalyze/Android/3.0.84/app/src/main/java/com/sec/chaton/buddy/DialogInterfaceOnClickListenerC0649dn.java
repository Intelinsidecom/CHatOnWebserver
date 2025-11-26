package com.sec.chaton.buddy;

import android.content.DialogInterface;
import com.sec.chaton.R;
import com.sec.chaton.p025d.C1330h;
import com.sec.chaton.p037j.C1594v;
import com.sec.common.CommonApplication;
import com.sec.widget.C3641ai;

/* compiled from: BuddyGroupMemberEditFragment.java */
/* renamed from: com.sec.chaton.buddy.dn */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC0649dn implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ HandlerC0648dm f2869a;

    DialogInterfaceOnClickListenerC0649dn(HandlerC0648dm handlerC0648dm) {
        this.f2869a = handlerC0648dm;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        int iM6733a = C1594v.m6733a(CommonApplication.m11493l());
        if (-3 == iM6733a || -2 == iM6733a) {
            C3641ai.m13210a(this.f2869a.f2868a.f1904i, R.string.popup_no_network_connection, 0).show();
        } else {
            new C1330h(this.f2869a.f2868a.f1906k).m5713a("group", false, 329, this.f2869a.f2868a.f1898c.m3962b(), this.f2869a.f2868a.m3455a().m3443h(), this.f2869a.f2868a.f1903h);
            this.f2869a.f2868a.m3460b();
        }
    }
}
