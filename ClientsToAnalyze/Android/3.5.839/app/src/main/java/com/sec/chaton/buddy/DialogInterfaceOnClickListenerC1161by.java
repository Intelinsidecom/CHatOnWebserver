package com.sec.chaton.buddy;

import android.content.DialogInterface;
import com.sec.chaton.R;
import com.sec.chaton.p055d.C2126g;
import com.sec.chaton.p067j.C2471v;
import com.sec.common.CommonApplication;
import com.sec.widget.C5179v;

/* compiled from: BuddyFragment.java */
/* renamed from: com.sec.chaton.buddy.by */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC1161by implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ BuddyFragment f4380a;

    DialogInterfaceOnClickListenerC1161by(BuddyFragment buddyFragment) {
        this.f4380a = buddyFragment;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        int iM10677a = C2471v.m10677a(CommonApplication.m18732r());
        if (-3 == iM10677a || -2 == iM10677a) {
            C5179v.m19810a(this.f4380a.getActivity(), R.string.popup_no_network_connection, 0).show();
            return;
        }
        C2126g c2126gM9476a = C2126g.m9476a(this.f4380a.f3769v);
        if (this.f4380a.m6604g().length > 1) {
            c2126gM9476a.m9481a(this.f4380a.m6604g());
        } else {
            c2126gM9476a.m9479a(this.f4380a.m6604g()[0], 1);
        }
        this.f4380a.m6326V();
    }
}
