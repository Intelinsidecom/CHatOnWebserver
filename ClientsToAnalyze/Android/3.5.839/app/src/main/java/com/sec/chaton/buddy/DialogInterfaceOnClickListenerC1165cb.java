package com.sec.chaton.buddy;

import android.content.DialogInterface;
import com.sec.chaton.R;
import com.sec.chaton.buddy.p050a.C1106c;
import com.sec.chaton.p055d.C2133n;
import com.sec.chaton.p067j.C2471v;
import com.sec.common.CommonApplication;
import com.sec.widget.C5179v;

/* compiled from: BuddyFragment.java */
/* renamed from: com.sec.chaton.buddy.cb */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC1165cb implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ C1106c f4384a;

    /* renamed from: b */
    final /* synthetic */ BuddyFragment f4385b;

    DialogInterfaceOnClickListenerC1165cb(BuddyFragment buddyFragment, C1106c c1106c) {
        this.f4385b = buddyFragment;
        this.f4384a = c1106c;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        int iM10677a = C2471v.m10677a(CommonApplication.m18732r());
        if (-3 == iM10677a || -2 == iM10677a) {
            C5179v.m19810a(this.f4385b.getActivity(), R.string.popup_no_network_connection, 0).show();
        } else {
            new C2133n(this.f4385b.f3769v).m9559a(this.f4384a.m7046a());
            this.f4385b.m6326V();
        }
    }
}
