package com.sec.chaton.buddy;

import android.content.DialogInterface;
import com.sec.chaton.R;
import com.sec.chaton.buddy.p050a.C1106c;
import com.sec.chaton.p055d.C2126g;
import com.sec.chaton.p067j.C2471v;
import com.sec.common.CommonApplication;
import com.sec.widget.C5179v;

/* compiled from: BuddyFragment.java */
/* renamed from: com.sec.chaton.buddy.cc */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC1166cc implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ C1106c f4386a;

    /* renamed from: b */
    final /* synthetic */ BuddyFragment f4387b;

    DialogInterfaceOnClickListenerC1166cc(BuddyFragment buddyFragment, C1106c c1106c) {
        this.f4387b = buddyFragment;
        this.f4386a = c1106c;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        int iM10677a = C2471v.m10677a(CommonApplication.m18732r());
        if (-3 != iM10677a && -2 != iM10677a) {
            this.f4387b.m6326V();
            C2126g.m9476a(this.f4387b.f3769v).m9479a(this.f4386a.m7046a(), 1);
        } else {
            C5179v.m19810a(this.f4387b.getActivity(), R.string.popup_no_network_connection, 0).show();
        }
    }
}
