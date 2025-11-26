package com.sec.chaton.buddy;

import android.content.DialogInterface;
import com.sec.chaton.R;
import com.sec.chaton.p055d.C2128i;
import com.sec.chaton.p067j.C2471v;
import com.sec.common.CommonApplication;
import com.sec.widget.C5179v;

/* compiled from: BuddyFragment.java */
/* renamed from: com.sec.chaton.buddy.bz */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC1162bz implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ BuddyFragment f4381a;

    DialogInterfaceOnClickListenerC1162bz(BuddyFragment buddyFragment) {
        this.f4381a = buddyFragment;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        int iM10677a = C2471v.m10677a(CommonApplication.m18732r());
        if (-3 == iM10677a || -2 == iM10677a) {
            C5179v.m19810a(this.f4381a.getActivity(), R.string.popup_no_network_connection, 0).show();
            return;
        }
        C2128i c2128i = new C2128i(this.f4381a.f3769v);
        if (this.f4381a.m6604g().length > 1) {
            c2128i.m9506a(this.f4381a.m6604g());
        } else {
            c2128i.m9534h(this.f4381a.m6604g()[0]);
        }
        this.f4381a.m6326V();
    }
}
