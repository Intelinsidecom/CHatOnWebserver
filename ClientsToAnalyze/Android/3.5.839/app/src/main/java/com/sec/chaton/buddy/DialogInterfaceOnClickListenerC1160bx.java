package com.sec.chaton.buddy;

import android.content.DialogInterface;
import com.sec.chaton.R;
import com.sec.chaton.p055d.C2133n;
import com.sec.chaton.p067j.C2471v;
import com.sec.common.CommonApplication;
import com.sec.widget.C5179v;

/* compiled from: BuddyFragment.java */
/* renamed from: com.sec.chaton.buddy.bx */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC1160bx implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ BuddyFragment f4379a;

    DialogInterfaceOnClickListenerC1160bx(BuddyFragment buddyFragment) {
        this.f4379a = buddyFragment;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        int iM10677a = C2471v.m10677a(CommonApplication.m18732r());
        if (-3 == iM10677a || -2 == iM10677a) {
            C5179v.m19810a(this.f4379a.getActivity(), R.string.popup_no_network_connection, 0).show();
            return;
        }
        C2133n c2133n = new C2133n(this.f4379a.f3769v);
        if (this.f4379a.m6604g().length > 1) {
            c2133n.m9561a(this.f4379a.m6604g());
        } else {
            c2133n.m9559a(this.f4379a.m6604g()[0]);
        }
        this.f4379a.m6326V();
    }
}
