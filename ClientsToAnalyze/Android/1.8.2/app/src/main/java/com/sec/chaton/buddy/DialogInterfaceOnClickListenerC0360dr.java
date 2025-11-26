package com.sec.chaton.buddy;

import android.content.DialogInterface;
import com.sec.chaton.R;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p022h.C0809s;
import com.sec.widget.C2153y;

/* compiled from: BuddyRecommendActivity.java */
/* renamed from: com.sec.chaton.buddy.dr */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC0360dr implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ HandlerC0357do f1504a;

    DialogInterfaceOnClickListenerC0360dr(HandlerC0357do handlerC0357do) {
        this.f1504a = handlerC0357do;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        int iM3420a = C0809s.m3420a(GlobalApplication.m3260b());
        if (-3 != iM3420a && -2 != iM3420a) {
            this.f1504a.f1501a.m2183a(this.f1504a.f1501a.f1172h, this.f1504a.f1501a.f1173i);
        } else {
            C2153y.m7535a(this.f1504a.f1501a.getActivity(), R.string.popup_no_network_connection, 0).show();
        }
    }
}
