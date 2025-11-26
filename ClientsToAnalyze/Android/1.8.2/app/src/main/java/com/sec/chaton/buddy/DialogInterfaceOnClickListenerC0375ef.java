package com.sec.chaton.buddy;

import android.content.DialogInterface;
import com.sec.chaton.R;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p022h.C0809s;
import com.sec.widget.C2153y;

/* compiled from: BuddyRecommendListActivity.java */
/* renamed from: com.sec.chaton.buddy.ef */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC0375ef implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ HandlerC0372ec f1526a;

    DialogInterfaceOnClickListenerC0375ef(HandlerC0372ec handlerC0372ec) {
        this.f1526a = handlerC0372ec;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        int iM3420a = C0809s.m3420a(GlobalApplication.m3260b());
        if (-3 != iM3420a && -2 != iM3420a) {
            this.f1526a.f1523a.m2209a(this.f1526a.f1523a.f1190h, this.f1526a.f1523a.f1191i);
        } else {
            C2153y.m7535a(this.f1526a.f1523a.getActivity(), R.string.popup_no_network_connection, 0).show();
        }
    }
}
