package com.sec.chaton.buddy;

import android.content.DialogInterface;
import com.sec.chaton.R;
import com.sec.chaton.p025d.C1330h;
import com.sec.chaton.p037j.C1594v;
import com.sec.common.CommonApplication;
import com.sec.widget.C3641ai;

/* compiled from: BuddyFragment.java */
/* renamed from: com.sec.chaton.buddy.bx */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC0566bx implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ HandlerC0565bw f2528a;

    DialogInterfaceOnClickListenerC0566bx(HandlerC0565bw handlerC0565bw) {
        this.f2528a = handlerC0565bw;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        int iM6733a = C1594v.m6733a(CommonApplication.m11493l());
        if (-3 == iM6733a || -2 == iM6733a) {
            C3641ai.m13210a(this.f2528a.f2527a.getActivity(), R.string.popup_no_network_connection, 0).show();
            return;
        }
        new C1330h(this.f2528a.f2527a.f1837bX).m5716a("group", false, this.f2528a.f2527a.f1786aX.m3976c(), (String) null, (String[]) this.f2528a.f2527a.f1786aX.m3999z().keySet().toArray(new String[0]), 327);
        if (this.f2528a.f2527a.f1807as != null && !this.f2528a.f2527a.f1807as.isShowing()) {
            this.f2528a.f2527a.f1807as.show();
        }
    }
}
