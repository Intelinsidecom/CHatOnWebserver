package com.sec.chaton.buddy;

import android.content.DialogInterface;
import com.sec.chaton.R;
import com.sec.chaton.p055d.C2128i;
import com.sec.chaton.p067j.C2471v;
import com.sec.common.CommonApplication;
import com.sec.widget.C5179v;

/* compiled from: BuddyGroupMemberEditFragment.java */
/* renamed from: com.sec.chaton.buddy.eh */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC1274eh implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ HandlerC1273eg f4808a;

    DialogInterfaceOnClickListenerC1274eh(HandlerC1273eg handlerC1273eg) {
        this.f4808a = handlerC1273eg;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        int iM10677a = C2471v.m10677a(CommonApplication.m18732r());
        if (-3 == iM10677a || -2 == iM10677a) {
            C5179v.m19810a(this.f4808a.f4807a.f3782i, R.string.popup_no_network_connection, 0).show();
        } else {
            new C2128i(this.f4808a.f4807a.f3783j).m9486a("group", false, 329, this.f4808a.f4807a.f3776c.m7036b(), this.f4808a.f4807a.m6614a().m6604g(), this.f4808a.f4807a.f3781h);
            this.f4808a.f4807a.m6618b();
        }
    }
}
