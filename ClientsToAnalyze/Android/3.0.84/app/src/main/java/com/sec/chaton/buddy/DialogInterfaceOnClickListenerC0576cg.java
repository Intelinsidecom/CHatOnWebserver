package com.sec.chaton.buddy;

import android.content.DialogInterface;
import com.sec.chaton.R;
import com.sec.chaton.p025d.C1330h;
import com.sec.chaton.p037j.C1594v;
import com.sec.common.CommonApplication;
import com.sec.widget.C3641ai;

/* compiled from: BuddyFragment.java */
/* renamed from: com.sec.chaton.buddy.cg */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC0576cg implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ HandlerC0575cf f2538a;

    DialogInterfaceOnClickListenerC0576cg(HandlerC0575cf handlerC0575cf) {
        this.f2538a = handlerC0575cf;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        int iM6733a = C1594v.m6733a(CommonApplication.m11493l());
        if (-3 == iM6733a || -2 == iM6733a) {
            C3641ai.m13210a(this.f2538a.f2537a.getActivity(), R.string.popup_no_network_connection, 0).show();
        } else {
            new C1330h(this.f2538a.f2537a.f1868cd).m5716a("group", false, (String) null, this.f2538a.f2537a.f1762Z.getString("ACTIVITY_PURPOSE_ARG2"), this.f2538a.f2537a.m3443h(), 325);
            this.f2538a.f2537a.m3262Y();
        }
    }
}
