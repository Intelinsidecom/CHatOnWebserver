package com.sec.chaton.buddy;

import android.content.DialogInterface;
import com.sec.chaton.R;
import com.sec.chaton.p055d.C2128i;
import com.sec.chaton.p067j.C2471v;
import com.sec.common.CommonApplication;
import com.sec.widget.C5179v;

/* compiled from: BuddyFragment.java */
/* renamed from: com.sec.chaton.buddy.cj */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC1173cj implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ HandlerC1172ci f4400a;

    DialogInterfaceOnClickListenerC1173cj(HandlerC1172ci handlerC1172ci) {
        this.f4400a = handlerC1172ci;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        int iM10677a = C2471v.m10677a(CommonApplication.m18732r());
        if (-3 == iM10677a || -2 == iM10677a) {
            C5179v.m19810a(this.f4400a.f4399a.getActivity(), R.string.popup_no_network_connection, 0).show();
            return;
        }
        new C2128i(this.f4400a.f4399a.f3749cm).m9489a("group", false, this.f4400a.f4399a.f3706bk.m7051b(), (String) null, (String[]) this.f4400a.f4399a.f3706bk.m7076y().keySet().toArray(new String[0]), 327);
        if (this.f4400a.f4399a.f3624aE != null && !this.f4400a.f4399a.f3624aE.isShowing()) {
            this.f4400a.f4399a.f3624aE.show();
        }
    }
}
