package com.sec.chaton.buddy;

import android.content.DialogInterface;
import com.sec.chaton.R;
import com.sec.chaton.buddy.p050a.C1106c;
import com.sec.chaton.p055d.C2128i;
import com.sec.chaton.p067j.C2471v;
import com.sec.common.CommonApplication;
import com.sec.widget.C5179v;

/* compiled from: BuddyFragment.java */
/* renamed from: com.sec.chaton.buddy.cf */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC1169cf implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ C1106c f4391a;

    /* renamed from: b */
    final /* synthetic */ BuddyFragment f4392b;

    DialogInterfaceOnClickListenerC1169cf(BuddyFragment buddyFragment, C1106c c1106c) {
        this.f4392b = buddyFragment;
        this.f4391a = c1106c;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        int iM10677a = C2471v.m10677a(CommonApplication.m18732r());
        if (-3 == iM10677a || -2 == iM10677a) {
            C5179v.m19810a(this.f4392b.getActivity(), R.string.popup_no_network_connection, 0).show();
        } else {
            new C2128i(this.f4392b.f3769v).m9534h(this.f4391a.m7046a());
            this.f4392b.m6326V();
        }
    }
}
